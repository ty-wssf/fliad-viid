package com.fliad.core;

import io.nop.api.core.util.SourceLocation;
import io.nop.core.lang.eval.IEvalAction;
import io.nop.core.lang.eval.IEvalScope;
import io.nop.core.module.ModuleManager;
import io.nop.core.resource.IResource;
import io.nop.core.resource.VirtualFileSystem;
import io.nop.core.resource.component.ResourceComponentManager;
import io.nop.dao.api.IDaoEntity;
import io.nop.dao.api.IDaoProvider;
import io.nop.dao.api.IEntityDao;
import io.nop.data_.init.model.DataInitModel;
import io.nop.data_.init.model.FieldNode;
import io.nop.data_.init.model.RecordData;
import io.nop.data_.init.model.TableInitModel;
import io.nop.orm.IOrmEntity;
import io.nop.orm.IOrmTemplate;
import io.nop.orm.dao.IOrmEntityDao;
import io.nop.orm.model.IColumnModel;
import io.nop.orm.model.IEntityModel;
import io.nop.xlang.api.XLang;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataInitializerLoader {
    private static final Logger LOG = LoggerFactory.getLogger(DataInitializerLoader.class);

    private final IDaoProvider daoProvider;

    public DataInitializerLoader(IDaoProvider daoProvider) {
        this.daoProvider = daoProvider;
    }

    public void loadAndExecute(IOrmTemplate ormTemplate) {
        // Create merged model
        DataInitModel model = new DataInitModel();
        model.setLocation(SourceLocation.fromPath("/nop/data_/init/merged-app.data-init.xml"));

        // Discover and merge all module data-init files
        ModuleManager.instance()
                .getAllModuleResourcesInModules(
                        ModuleManager.instance().getEnabledModules(false),
                        "orm/app.data-init.xml"
                )
                .forEach(resource -> {
                    DataInitModel moduleModel = (DataInitModel) ResourceComponentManager
                            .instance()
                            .loadComponentModel(resource.getPath());
                    if (moduleModel != null) {
                        mergeDataInitModel(model, moduleModel);
                    }
                });

        // Load and merge main model (with override capability)
        IResource mainResource = VirtualFileSystem.instance()
                .getResource("/main/orm/app.data-init.xml");
        if (mainResource.exists()) {
            DataInitModel mainModel = (DataInitModel) ResourceComponentManager
                    .instance()
                    .loadComponentModel(mainResource.getPath());
            if (mainModel != null) {
                mergeDataInitModel(model, mainModel);
            }
        }

        // 遍历所有表的初始化配置 l
        for (TableInitModel table : model.getTables()) {
            insertData(ormTemplate, table);
        }
    }

    private void mergeDataInitModel(DataInitModel base, DataInitModel ext) {
        // Implement merge logic based on your DataInitModel structure
        // Similar to OrmModelLoader.merge() - merge tables, handle conflicts, etc.
        for (TableInitModel table : ext.getTables()) {
            base.addTable(table); // Adjust based on your model's API
        }
    }

    private void insertData(IOrmTemplate ormTemplate, TableInitModel table) {
        String tableName = table.getTableName();
        List<RecordData> records = table.getData();

        if (records == null || records.isEmpty()) {
            LOG.info("nop.data-init.skip-empty-table:tableName={}", tableName);
            return;
        }

        LOG.info("nop.data-init.insert-table:tableName={},recordCount={}",
                tableName, records.size());

        // 获取对应表的 DAO
        IEntityDao dao = daoProvider.daoForTable(tableName);
        if (dao == null) {
            LOG.error("nop.data-init.no-dao-for-table:tableName={}", tableName);
            return;
        }

        if (!(dao instanceof IOrmEntityDao)) {
            LOG.error("nop.data-init.dao-not-orm:tableName={}", tableName);
            return;
        }

        IOrmEntityDao ormDao = (IOrmEntityDao) dao;

        ormTemplate.runInSession(session -> {
            for (RecordData record : records) {
                // 将 RecordData 转换为 Map
                Map<String, Object> dataMap = convertRecordToMap(record);

                // 处理特殊字段类型(如 XPL 脚本字段)
                processSpecialFields(dataMap);

                // 创建实体对象并设置属性
                IOrmEntity entity = newEntityFromRow(dataMap, ormDao);
                entity.orm_disableAutoStamp(true);  // 禁用自动时间戳
                IDaoEntity oldEntity = ormDao.getEntityById(entity.get_id());
                if (oldEntity != null) {
                    oldEntity.orm_restoreValues(entity.orm_initedValues());
                    session.saveOrUpdate((IOrmEntity) oldEntity);
                } else {
                    session.save(entity);
                }
            }
            session.flush();
            session.clear();
            return null;
        });
    }

    private Map<String, Object> convertRecordToMap(RecordData record) {
        Map<String, Object> dataMap = new HashMap<>();

        // 添加 sid 属性
        // dataMap.put("sid", record.getSid());

        // 获取所有未知属性(通过 xdef:bean-unknown-attrs-prop 存储的属性)
        if (record.getAttributes() != null) {
            dataMap.putAll(record.getAttributes());
        }

        record.prop_names().forEach(name -> {
            Object value = record.getExtProp(name);
            if (value instanceof FieldNode) {
                value = ((FieldNode) value).getValue();
                dataMap.put(name, value);
            } else {
                dataMap.put(name, value);
            }
        });

        // 处理子节点(如 scriptContent 等复杂字段)
        /*if (record.getChildren() != null) {
            for (Map.Entry<String, Object> entry : record.getChildren().entrySet()) {
                dataMap.put(entry.getKey(), entry.getValue());
            }
        }*/

        return dataMap;
    }

    private IOrmEntity newEntityFromRow(Map<String, Object> row, IOrmEntityDao dao) {
        IEntityModel entityModel = dao.getEntityModel();
        IOrmEntity entity = (IOrmEntity) dao.newEntity();

        for (Map.Entry<String, Object> entry : row.entrySet()) {
            String colName = entry.getKey();
            IColumnModel col = entityModel.getColumnByCode(colName, false);
            if (col != null) {
                entity.orm_propValue(col.getPropId(), entry.getValue());
            }
        }

        return entity;
    }

    private void processSpecialFields(Map<String, Object> record) {
        // 处理可能的脚本字段或其他特殊类型
        for (Map.Entry<String, Object> entry : record.entrySet()) {
            Object value = entry.getValue();

            // 如果字段值是 IEvalAction(XPL 脚本),执行它获取实际值
            if (value instanceof IEvalAction) {
                IEvalAction action = (IEvalAction) value;
                IEvalScope scope = XLang.newEvalScope();
                Object result = action.invoke(scope);
                entry.setValue(result);
            }
        }
    }
}

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
import org.noear.solon.Solon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
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

        // 遍历所有表的初始化配置
        for (TableInitModel table : model.getTables()) {
            insertData(ormTemplate, table);
        }
    }

    /**
     * 合并两个DataInitModel对象
     * 当多个app.data-init.xml文件定义了相同表的数据时，需要合并这些数据而不是简单替换
     * @param base 基础模型，将合并结果存储在此模型中
     * @param ext 扩展模型，提供需要合并的数据
     */
    private void mergeDataInitModel(DataInitModel base, DataInitModel ext) {
        // 遍历扩展模型中的所有表
        for (TableInitModel table : ext.getTables()) {
            // 检查基础模型中是否已存在同名表
            TableInitModel existingTable = base.getTable(table.getTableName());
            if (existingTable != null) {
                // 如果存在同名表，则合并两个表中的记录数据
                TableInitModel mergedTable = mergeTableData(existingTable, table);
                // 移除旧表并添加合并后的新表
                // 由于模型可能被冻结，我们需要使用特殊方法来替换表
                removeAndAddTable(base, existingTable.getTableName(), mergedTable);
            } else {
                // 如果不存在同名表，则直接添加新表的克隆版本
                // 避免直接引用可能被冻结的原始对象
                base.addTable(cloneTable(table));
            }
        }
    }

    /**
     * 克隆表对象及其所有记录，避免直接修改冻结对象
     * @param table 原始表对象
     * @return 克隆后的表对象
     */
    private TableInitModel cloneTable(TableInitModel table) {
        TableInitModel clonedTable = table.cloneInstance();
        List<RecordData> clonedRecords = new ArrayList<>();
        for (RecordData record : table.getData()) {
            clonedRecords.add(record.cloneInstance());
        }
        clonedTable.setData(clonedRecords);
        return clonedTable;
    }

    /**
     * 合并两个表的记录数据
     * 将源表中的所有记录合并到目标表中
     * 创建新表对象以避免修改已冻结的对象
     * @param targetTable 目标表，将记录合并到此表中
     * @param sourceTable 源表，从中获取需要合并的记录
     * @return 合并后的新表对象
     */
    private TableInitModel mergeTableData(TableInitModel targetTable, TableInitModel sourceTable) {
        // 创建新的表对象以避免修改已冻结的对象
        TableInitModel mergedTable = targetTable.cloneInstance();
        
        // 克隆并合并记录数据
        List<RecordData> mergedRecords = new ArrayList<>();
        // 添加目标表的所有记录
        for (RecordData record : targetTable.getData()) {
            mergedRecords.add(record.cloneInstance());
        }
        // 添加源表的所有记录（会自动覆盖相同SID的记录）
        for (RecordData record : sourceTable.getData()) {
            mergedRecords.add(record.cloneInstance());
        }
        
        mergedTable.setData(mergedRecords);
        return mergedTable;
    }

    /**
     * 从基础模型中移除指定表并添加新表
     * 由于模型对象可能已被冻结，不能直接修改，需要创建新的列表
     * @param base 基础模型
     * @param tableName 要移除的表名
     * @param newTable 要添加的新表
     */
    private void removeAndAddTable(DataInitModel base, String tableName, TableInitModel newTable) {
        // 创建新的表列表
        List<TableInitModel> newTableList = new ArrayList<>();
        for (TableInitModel table : base.getTables()) {
            if (!table.getTableName().equals(tableName)) {
                newTableList.add(cloneTable(table));
            }
        }
        // 添加合并后的新表
        newTableList.add(newTable);
        
        // 重新设置表列表
        base.setTables(newTableList);
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
        // 获取是否更新已存在数据的配置
        boolean updateExistingData = Solon.cfg().getBool("orm.update-existing-data", false);

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
                    // 如果配置为不更新已存在数据，则跳过
                    if (!updateExistingData) {
                        LOG.debug("Skipping existing record for table {} with id {}, update-existing-data is disabled", 
                                tableName, entity.get_id());
                        continue;
                    }
                    // 更新已存在的实体
                    entity.orm_initedValues().forEach(oldEntity::orm_propValueByName);
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

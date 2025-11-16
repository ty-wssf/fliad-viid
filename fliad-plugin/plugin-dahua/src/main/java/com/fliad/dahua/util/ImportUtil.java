package com.fliad.dahua.util;

import cn.hutool.core.util.ObjectUtil;
import io.nop.api.core.beans.FilterBeans;
import io.nop.api.core.beans.query.QueryBean;
import io.nop.core.reflect.bean.BeanTool;
import io.nop.dao.api.DaoProvider;
import io.nop.dao.api.IEntityDao;
import io.nop.orm.IOrmTemplate;
import io.nop.orm.support.OrmEntity;
import io.nop.xlang.xmeta.IObjMeta;
import io.nop.xlang.xmeta.SchemaLoader;
import com.fliad.dahua.service.impl.EntityCopyHelper;
import com.fliad.dahua.service.impl.UniqueValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 通用导入工具类
 *
 * @author wyl
 * @since 2025/09/27
 */
public class ImportUtil {

    private static IOrmTemplate ormTemplate;
    private static UniqueValidator uniqueValidator = new UniqueValidator();

    public static void setOrmTemplate(IOrmTemplate ormTemplate) {
        ImportUtil.ormTemplate = ormTemplate;
    }

    /**
     * 通用批量导入方法
     *
     * @param entityClass 实体类class
     * @param xmetaPath   xmeta路径
     * @param dataList    数据列表
     * @param <T>         实体类型
     */
    public static <T extends OrmEntity> void importEntities(Class<T> entityClass, String xmetaPath, List<Map<String, Object>> dataList) {
        if (ormTemplate == null) {
            throw new IllegalStateException("OrmTemplate未初始化，请先调用setOrmTemplate方法");
        }
        
        ormTemplate.runInSession(() -> {
            IEntityDao<T> dao = DaoProvider.instance().daoFor(entityClass);
            IObjMeta objMeta = SchemaLoader.loadXMeta(xmetaPath);

            List<T> saveList = new ArrayList<>();
            List<T> updateList = new ArrayList<>();

            // 提取所有包含主键的数据，用于批量查询
            List<String> existIds = dataList.stream()
                    .filter(map -> map.containsKey("id_") && map.get("id_") != null)
                    .map(map -> map.get("id_").toString())
                    .collect(Collectors.toList());

            // 批量查询已存在的实体
            Map<String, T> existEntities = new HashMap<>();
            if (!existIds.isEmpty()) {
                List<T> entities = dao.findAllByQuery(new QueryBean().addFilter(FilterBeans.in("id_", existIds)));
                existEntities = entities.stream().collect(Collectors.toMap(
                        e -> e.get_id().toString(),
                        entity -> entity
                ));
            }

            // 分类处理数据
            for (Map<String, Object> dataMap : dataList) {
                if (dataMap.containsKey("id_") && dataMap.get("id_") != null) {
                    // 更新已存在的实体
                    String id = dataMap.get("id_").toString();
                    T oldEntity = existEntities.get(id);
                    if (oldEntity != null) {
                        T newEntity = dao.newEntity();
                        BeanTool.instance().setProperties(newEntity, dataMap);
                        EntityCopyHelper.copyProperties(newEntity, oldEntity);
                        // 更新前校验唯一性
                        uniqueValidator.checkUniqueForUpdate(oldEntity, objMeta, entityClass.getSimpleName());
                        updateList.add(oldEntity);
                    } else {
                        // ID存在但在数据库中找不到，作为新实体保存
                        T entity = dao.newEntity();
                        BeanTool.instance().setProperties(entity, dataMap);
                        // 保存前校验唯一性
                        uniqueValidator.checkUniqueForSave(entity, objMeta, entityClass.getSimpleName());
                        saveList.add(entity);
                    }
                } else {
                    // 新建实体
                    T entity = dao.newEntity();
                    entity.orm_restoreValues(dataMap);
                    // 保存前校验唯一性
                    uniqueValidator.checkUniqueForSave(entity, objMeta, entityClass.getSimpleName());
                    saveList.add(entity);
                }
            }

            // 保存和更新实体
            if (!saveList.isEmpty()) {
                dao.batchSaveEntities(saveList);
            }
            if (!updateList.isEmpty()) {
                dao.batchUpdateEntities(updateList);
            }
        });
    }
}

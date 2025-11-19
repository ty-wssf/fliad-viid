package io.nop.orm.utils;

import io.nop.api.core.exceptions.NopException;
import io.nop.dao.api.IDaoProvider;
import io.nop.dao.api.IEntityDao;
import io.nop.orm.IOrmEntity;
import io.nop.xlang.xmeta.IObjMeta;
import io.nop.xlang.xmeta.impl.ObjKeyModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static io.nop.orm.utils.BizErrors.*;


/**
 * 通用唯一性校验工具类
 * 不依赖 CrudBizModel，可独立使用
 */
public class UniqueValidator {

    private static IDaoProvider daoProvider;

    public static void setDaoProvider(IDaoProvider daoProvider) {
        UniqueValidator.daoProvider = daoProvider;
    }

    /**
     * 保存前的唯一性校验
     *
     * @param entity     待保存的实体
     * @param objMeta    实体的元数据模型
     * @param bizObjName 业务对象名称（用于错误提示）
     */
    public static <T extends IOrmEntity> void checkUniqueForSave(T entity, IObjMeta objMeta, String bizObjName) {
        if (objMeta.getKeys() == null || objMeta.getKeys().isEmpty()) {
            return;
        }

        if (daoProvider == null) {
            throw new IllegalStateException("DaoProvider未初始化，请先调用setDaoProvider方法");
        }

        IEntityDao<T> dao = (IEntityDao<T>) daoProvider.daoFor(entity.getClass());

        for (ObjKeyModel keyModel : objMeta.getKeys()) {
            Set<String> props = keyModel.getProps();

            // 构建查询示例对象
            T example = dao.newEntity();
            List<Object> keyValues = new ArrayList<>();
            List<Object> displayNames = new ArrayList<>();

            for (String propName : props) {
                Object value = entity.orm_propValueByName(propName);
                if (value == null) {
                    // 如果唯一键字段为空，跳过此唯一键检查
                    continue;
                }
                example.orm_propValueByName(propName, value);
                keyValues.add(value);
                displayNames.add(objMeta.getProp(propName).getDisplayName());
            }

            // 如果所有唯一键字段都有值，才进行查询
            if (keyValues.size() == props.size()) {
                T existing = dao.findFirstByExample(example);
                if (existing != null && existing != entity) {
                    throw new NopException(ERR_BIZ_ENTITY_WITH_SAME_KEY_ALREADY_EXISTS)
                            .param(ARG_KEY, String.join(",", keyValues.stream().map(String::valueOf).toArray(String[]::new)))
                            .param(ARG_DISPLAY_NAME, String.join(",", displayNames.stream().map(String::valueOf).toArray(String[]::new)))
                            .param(ARG_BIZ_OBJ_NAME, bizObjName);
                }
            }
        }
    }

    /**
     * 更新前的唯一性校验
     * 只有当唯一键字段发生变化时才进行校验
     *
     * @param entity     待更新的实体
     * @param objMeta    实体的元数据模型
     * @param bizObjName 业务对象名称（用于错误提示）
     */
    public static <T extends IOrmEntity> void checkUniqueForUpdate(T entity, IObjMeta objMeta, String bizObjName) {
        if (objMeta.getKeys() == null || objMeta.getKeys().isEmpty()) {
            return;
        }

        if (daoProvider == null) {
            throw new IllegalStateException("DaoProvider未初始化，请先调用setDaoProvider方法");
        }

        IEntityDao<T> dao = (IEntityDao<T>) daoProvider.daoFor(entity.getClass());

        for (ObjKeyModel keyModel : objMeta.getKeys()) {
            Set<String> props = keyModel.getProps();

            // 检查唯一键字段是否有变化
            if (!isAnyPropDirty(entity, props)) {
                continue;
            }

            // 构建查询示例对象
            T example = dao.newEntity();
            List<Object> keyValues = new ArrayList<>();
            List<Object> displayNames = new ArrayList<>();

            for (String propName : props) {
                Object value = entity.orm_propValueByName(propName);
                example.orm_propValueByName(propName, value);
                keyValues.add(value);
                displayNames.add(objMeta.getProp(propName).getDisplayName());
            }

            T existing = dao.findFirstByExample(example);
            if (existing != null && existing != entity) {
                throw new NopException(ERR_BIZ_ENTITY_WITH_SAME_KEY_ALREADY_EXISTS)
                        .param(ARG_KEY, String.join(",", keyValues.stream().map(String::valueOf).toArray(String[]::new)))
                        .param(ARG_DISPLAY_NAME, String.join(",", displayNames.stream().map(String::valueOf).toArray(String[]::new)))
                        .param(ARG_BIZ_OBJ_NAME, bizObjName);
            }
        }
    }

    /**
     * 检查实体的指定属性是否有任何一个被修改过
     */
    private static <T extends IOrmEntity> boolean isAnyPropDirty(T entity, Set<String> propNames) {
        for (String propName : propNames) {
            int propId = entity.orm_propId(propName);
            if (propId < 0) {
                continue;
            }
            if (entity.orm_propDirty(propId)) {
                return true;
            }
        }
        return false;
    }
}

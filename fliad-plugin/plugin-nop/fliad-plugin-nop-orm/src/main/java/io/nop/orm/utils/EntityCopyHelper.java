package io.nop.orm.utils;

import io.nop.core.reflect.ReflectionManager;
import io.nop.core.reflect.bean.IBeanModel;
import io.nop.orm.IOrmEntity;
import java.util.Objects;

/**
 * 实体属性复制工具类
 * 用于将源对象的属性复制到目标实体对象
 */
public class EntityCopyHelper {

    /**
     * 复制所有可读写属性（排除 id）
     *
     * @param source 源对象
     * @param target 目标实体对象
     */
    public static <T extends IOrmEntity> void copyProperties(Object source, T target) {
        copyProperties(source, target, true);
    }

    /**
     * 复制属性，只复制源对象有值，并且值和目标对象不一样的属性
     *
     * @param source    源对象
     * @param target    目标实体对象
     * @param excludeId 是否排除 id 字段
     */
    public static <T extends IOrmEntity> void copyProperties(Object source, T target, boolean excludeId) {
        if (source == null || target == null) {
            return;
        }

        IBeanModel sourceBeanModel = ReflectionManager.instance().getBeanModelForClass(source.getClass());
        IBeanModel targetBeanModel = ReflectionManager.instance().getBeanModelForClass(target.getClass());

        sourceBeanModel.forEachReadWriteProp(propModel -> {
            String propName = propModel.getName();

            // 排除 id 字段
            if (excludeId && "id".equals(propName)) {
                return;
            }

            // 获取源对象的属性值
            Object sourceValue = sourceBeanModel.getProperty(source, propName);
            
            // 只处理非空值
            if (sourceValue != null) {
                try {
                    // 获取目标对象的属性值
                    Object targetValue = targetBeanModel.getProperty(target, propName);
                    
                    // 只有当值不同时才设置
                    if (!Objects.equals(sourceValue, targetValue)) {
                        target.orm_propValueByName(propName, sourceValue);
                    }
                } catch (Exception e) {
                    // 忽略不存在的属性
                }
            }
        });
    }

    /**
     * 复制指定的属性列表，只复制源对象有值，并且值和目标对象不一样的属性
     *
     * @param source    源对象
     * @param target    目标实体对象
     * @param propNames 要复制的属性名称数组
     */
    public static <T extends IOrmEntity> void copyProperties(Object source, T target, String... propNames) {
        if (source == null || target == null || propNames == null) {
            return;
        }

        IBeanModel sourceBeanModel = ReflectionManager.instance().getBeanModelForClass(source.getClass());
        IBeanModel targetBeanModel = ReflectionManager.instance().getBeanModelForClass(target.getClass());

        for (String propName : propNames) {
            try {
                Object sourceValue = sourceBeanModel.getProperty(source, propName);
                
                // 只处理非空值
                if (sourceValue != null) {
                    // 获取目标对象的属性值
                    Object targetValue = targetBeanModel.getProperty(target, propName);
                    
                    // 只有当值不同时才设置
                    if (!Objects.equals(sourceValue, targetValue)) {
                        target.orm_propValueByName(propName, sourceValue);
                    }
                }
            } catch (Exception e) {
                // 忽略不存在的属性
            }
        }
    }
}

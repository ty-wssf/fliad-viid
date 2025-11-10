/*
 * Copyright [2022] [https://www.xiaonuo.vip]
 *
 * Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：
 *
 * 1.请不要删除和修改根目录下的LICENSE文件。
 * 2.请不要删除和修改Snowy源码头部的版权声明。
 * 3.本项目代码可免费商业使用，商业使用请保留源码和相关描述文件的项目出处，作者声明等。
 * 4.分发源码时候，请注明软件出处 https://www.xiaonuo.vip
 * 5.不可二次分发开源参与同类竞品，如有想法可联系团队xiaonuobase@qq.com商议合作。
 * 6.若您的项目无法满足以上几点，需要更多功能代码，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package com.fliad.core.config;

import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.ObjectUtil;
import com.mybatisflex.annotation.InsertListener;
import com.mybatisflex.annotation.UpdateListener;
import org.noear.solon.Solon;
import com.fliad.common.enums.CommonDeleteFlagEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.function.Supplier;

/**
 * 用于监听 Entity 实体类数据被新增到数据库
 *
 * @author ChengChuanYao
 * @date 2024/6/22 14:17
 */
public class CustomMetaObjectListener implements UpdateListener, InsertListener {

    private static final Logger log = LoggerFactory.getLogger(CustomMetaObjectListener.class);

    /**
     * 自定义新增注入
     */
    @Override
    public void onInsert(Object entity) {
        try {
            if (ObjectUtil.isNotNull(entity)) {
                setDateField(entity, "createTime", false);
                setDateField(entity, "updateTime", false);
                setUserIdField(entity, "createUser");
                setDeleteFlagField(entity);
            }
        } catch (Exception e) {
            printException("新增注入", e);
        }
    }

    /**
     * 自定义修改注入
     */
    @Override
    public void onUpdate(Object entity) {
        try {
            if (ObjectUtil.isNotNull(entity)) {
                setDateField(entity, "updateTime", false);
                setUserIdField(entity, "updateUser");
            }
        } catch (Exception e) {
            printException("修改注入", e);
        }
    }

    /**
     * 设置日期字段
     *
     * @param entity    实体对象
     * @param fieldName 字段名
     * @param isForce   是否强制设置（不管是否已有值）
     */
    private void setDateField(Object entity, String fieldName, boolean isForce) {
        try {
            Field field = entity.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            if (isForce || ObjectUtil.isNull(field.get(entity))) {
                field.set(entity, new Date());
            }
        } catch (Exception e) {
            // 忽略异常，字段可能不存在
        }
    }

    /**
     * 设置用户ID字段
     *
     * @param entity    实体对象
     * @param fieldName 字段名
     */
    private void setUserIdField(Object entity, String fieldName) {
        try {
            Field field = entity.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            if (ObjectUtil.isNull(field.get(entity))) {
                field.set(entity, this.getUserId());
            }
        } catch (Exception e) {
            // 忽略异常，字段可能不存在
        }
    }

    /**
     * 设置删除标志字段
     *
     * @param entity 实体对象
     */
    private void setDeleteFlagField(Object entity) {
        try {
            Field field = entity.getClass().getDeclaredField("deleteFlag");
            field.setAccessible(true);
            if (ObjectUtil.isNull(field.get(entity))) {
                field.set(entity, EnumUtil.toString(CommonDeleteFlagEnum.NOT_DELETE));
            }
        } catch (Exception e) {
            // 忽略异常，字段可能不存在
        }
    }

    /**
     * 打印异常信息
     */
    private void printException(String msg, Exception e) {
        log.error("{} => 自动注入异常 => {}", msg, e.getMessage());
    }

    /**
     * 获取用户id
     */
    private String getUserId() {
        Supplier<String> getter = Solon.context().getBean("user_id_bean");
        try {
            if (ObjectUtil.isNotEmpty(getter.get())) {
                return getter.get();
            } else {
                return "-1";
            }
        } catch (Exception e) {
            return "-1";
        }
    }
}

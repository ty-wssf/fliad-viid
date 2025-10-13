package com.fliad.viid.modular.datasource.enums;

import com.fliad.common.exception.CommonException;
import lombok.Getter;

@Getter
public enum ViidDatasourceStatus {

    /**
     * 正常
     */
    ENABLE("ENABLE"),

    /**
     * 停用
     */
    DISABLED("DISABLED");

    private final String value;

    ViidDatasourceStatus(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = ENABLE.getValue().equals(value) || DISABLED.getValue().equals(value);
        if (!flag) {
            throw new CommonException("不支持的数据源状态：{}", value);
        }
    }

}
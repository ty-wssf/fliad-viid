package com.fliad.resource.modular.workflow.enums;

import com.fliad.common.exception.CommonException;
public enum ResourceWorkflowStatus {

    /**
     * 正常
     */
    ENABLE("ENABLE"),

    /**
     * 停用
     */
    DISABLED("DISABLED");

    private final String value;

    ResourceWorkflowStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static void validate(String value) {
        boolean flag = ENABLE.getValue().equals(value) || DISABLED.getValue().equals(value);
        if (!flag) {
            throw new CommonException("不支持的工作流状态：{}", value);
        }
    }

}

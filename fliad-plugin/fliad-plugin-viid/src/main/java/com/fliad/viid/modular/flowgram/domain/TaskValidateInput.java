package com.fliad.viid.modular.flowgram.domain;

import lombok.Data;

import java.util.Map;

@Data
public class TaskValidateInput {

    /**
     * 工作流 schema 的 JSON 字符串，定义了工作流的节点和边
     */
    private String schema;

    /**
     * 工作流的初始输入参数，用于验证输入是否符合 schema 要求
     */
    private Map<String, Object> inputs;

}

package com.fliad.viid.modular.flowgram.domain;

import java.util.Map;

public class TaskRunInput {

    // 模型json描述
    private String schema;
    // 输入参数
    private Map<String, Object> inputs;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Map<String, Object> getInputs() {
        return inputs;
    }

    public void setInputs(Map<String, Object> inputs) {
        this.inputs = inputs;
    }
}

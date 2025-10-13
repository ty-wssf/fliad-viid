package com.fliad.viid.modular.flowgram.domain;

import lombok.Data;

import java.util.Map;

@Data
public class TaskRunInput {

    // 模型json描述
    private String schema;
    // 输入参数
    private Map<String, Object> inputs;

}

package com.fliad.viid.modular.flowgram.domain;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 节点快照
 */
@Data
public class Snapshot {

    private String id;
    private String nodeID;
    private Map<String, Object> inputs;
    private Map<String, Object> outputs;
    private Map<String, Object> data;
    // 异常时传递异常信息
    private String error;

    public Snapshot(String nodeID) {
        this.nodeID = nodeID;
        this.id = IdUtil.getSnowflakeNextIdStr();
        this.inputs = new HashMap<>();
        this.outputs = new HashMap<>();
        this.data = new HashMap<>();
    }

}

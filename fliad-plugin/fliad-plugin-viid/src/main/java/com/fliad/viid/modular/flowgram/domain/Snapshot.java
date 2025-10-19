package com.fliad.viid.modular.flowgram.domain;

import cn.hutool.core.util.IdUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 节点快照
 */
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNodeID() {
        return nodeID;
    }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public Map<String, Object> getInputs() {
        return inputs;
    }

    public void setInputs(Map<String, Object> inputs) {
        this.inputs = inputs;
    }

    public Map<String, Object> getOutputs() {
        return outputs;
    }

    public void setOutputs(Map<String, Object> outputs) {
        this.outputs = outputs;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

package com.fliad.resource.modular.flowgram.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 任务的执行报告
 */
public class TaskReportOutput {

    private String id;
    // 任务输入
    private Map<String, Object> inputs;
    // 任务输出
    private Map<String, Object> outputs;
    /**
     * 工作流整体状态
     */
    private WorkflowStatus workflowStatus;
    /**
     * 各节点的执行状态
     */
    private Map<String, NodeStatus> reports = new ConcurrentHashMap<>();

    public TaskReportOutput(String id, Map<String, Object> inputs) {
        this.id = id;
        this.workflowStatus = new WorkflowStatus();
        this.inputs = inputs;
        outputs = new ConcurrentHashMap<>();
    }

    public NodeStatus getNodeStatus(String id) {
        // 如果节点已经存在，则更新
        if (!reports.containsKey(id)) {
            reports.put(id, new NodeStatus(id));
        }
        return reports.get(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public WorkflowStatus getWorkflowStatus() {
        return workflowStatus;
    }

    public void setWorkflowStatus(WorkflowStatus workflowStatus) {
        this.workflowStatus = workflowStatus;
    }

    public Map<String, NodeStatus> getReports() {
        return reports;
    }

    public void setReports(Map<String, NodeStatus> reports) {
        this.reports = reports;
    }
}

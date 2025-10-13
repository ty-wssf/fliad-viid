package com.fliad.viid.modular.flowgram.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 任务的执行报告
 */
@Data
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

}

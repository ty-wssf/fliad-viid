package com.fliad.resource.modular.flowgram.domain;

public class TaskRunOutput {

    /**
     * 任务的唯一标识符，用于后续查询任务状态和结果
     */
    private String taskID;

    public TaskRunOutput(String taskID) {
        this.taskID = taskID;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }
}

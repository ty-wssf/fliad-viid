package com.fliad.viid.modular.flowgram.domain;

public class TaskReportInput {

    private String taskID;

    public TaskReportInput(String taskID) {
        this.taskID = taskID;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }
}

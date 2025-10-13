package com.fliad.viid.modular.flowgram.domain;

import lombok.Data;

@Data
public class TaskReportInput {

    private String taskID;

    public TaskReportInput(String taskID) {
        this.taskID = taskID;
    }

}

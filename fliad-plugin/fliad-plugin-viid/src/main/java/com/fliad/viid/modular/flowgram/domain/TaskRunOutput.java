package com.fliad.viid.modular.flowgram.domain;

import lombok.Data;

@Data
public class TaskRunOutput {

    /**
     * 任务的唯一标识符，用于后续查询任务状态和结果
     */
    private String taskID;

    public TaskRunOutput(String taskID) {
        this.taskID = taskID;
    }

}

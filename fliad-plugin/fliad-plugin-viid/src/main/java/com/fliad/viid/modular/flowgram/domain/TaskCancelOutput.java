package com.fliad.viid.modular.flowgram.domain;

import lombok.Data;

@Data
public class TaskCancelOutput {

    /**
     * 任务是否成功取消
     */
    private boolean success;

    public TaskCancelOutput(boolean success) {
        this.success = success;
    }

}

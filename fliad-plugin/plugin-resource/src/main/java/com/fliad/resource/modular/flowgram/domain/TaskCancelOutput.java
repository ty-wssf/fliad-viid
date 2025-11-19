package com.fliad.resource.modular.flowgram.domain;

public class TaskCancelOutput {

    /**
     * 任务是否成功取消
     */
    private boolean success;

    public TaskCancelOutput(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

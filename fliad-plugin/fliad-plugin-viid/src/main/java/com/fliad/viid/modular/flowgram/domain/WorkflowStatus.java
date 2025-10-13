package com.fliad.viid.modular.flowgram.domain;

import lombok.Data;

/**
 * 工作流整体状态
 */
@Data
public class WorkflowStatus {

    private StatusEnum status;
    private boolean terminated;
    private long startTime;
    private long endTime;
    private long timeCost;

    public WorkflowStatus() {
        this.status = StatusEnum.processing;
        this.terminated = false;
        this.startTime = System.currentTimeMillis();
        this.endTime = 0;
        this.timeCost = 0;
    }

    public void success() {
        this.status = StatusEnum.succeeded;
        this.terminated = true;
        this.endTime = System.currentTimeMillis();
        this.timeCost = this.endTime - this.startTime;
    }

    public void fail() {
        this.status = StatusEnum.failed;
        this.terminated = true;
        this.endTime = System.currentTimeMillis();
        this.timeCost = this.endTime - this.startTime;
    }

}

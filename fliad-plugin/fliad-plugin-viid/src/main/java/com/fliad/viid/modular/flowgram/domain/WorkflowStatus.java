package com.fliad.viid.modular.flowgram.domain;

/**
 * 工作流整体状态
 */
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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(long timeCost) {
        this.timeCost = timeCost;
    }
}

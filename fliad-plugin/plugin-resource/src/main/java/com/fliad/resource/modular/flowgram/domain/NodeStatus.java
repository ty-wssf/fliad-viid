package com.fliad.resource.modular.flowgram.domain;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

public class NodeStatus {

    private String id;
    private StatusEnum status;
    private long startTime;
    private long endTime;
    private List<Snapshot> snapshots;
    private boolean terminated;
    private long timeCost;

    public NodeStatus(String id) {
        this.id = id;
        this.status = StatusEnum.processing;
        this.startTime = System.currentTimeMillis();
        snapshots = new ArrayList<>();
        this.terminated = false;
        this.timeCost = 0;
    }

    public void success() {
        this.status = StatusEnum.succeeded;
        this.endTime = System.currentTimeMillis();
        this.timeCost = this.endTime - this.startTime;
        this.terminated = true;
    }

    public void fail() {
        this.status = StatusEnum.failed;
        this.endTime = System.currentTimeMillis();
        this.timeCost = this.endTime - this.startTime;
        this.terminated = true;
    }

    public Snapshot addSnapshot(Snapshot snapshot) {
        snapshots.add(snapshot);
        return snapshot;
    }

    @Transient
    // 获取最后一个节点快照
    public Snapshot getLastSnapshot() {
        return snapshots.get(snapshots.size() - 1);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
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

    public List<Snapshot> getSnapshots() {
        return snapshots;
    }

    public void setSnapshots(List<Snapshot> snapshots) {
        this.snapshots = snapshots;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    public long getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(long timeCost) {
        this.timeCost = timeCost;
    }
}

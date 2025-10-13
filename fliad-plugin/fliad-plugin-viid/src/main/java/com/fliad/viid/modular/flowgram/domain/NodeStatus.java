package com.fliad.viid.modular.flowgram.domain;

import lombok.Data;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Data
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

}

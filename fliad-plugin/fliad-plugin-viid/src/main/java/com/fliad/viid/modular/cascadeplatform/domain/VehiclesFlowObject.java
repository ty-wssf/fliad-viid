package com.fliad.viid.modular.cascadeplatform.domain;

import java.io.Serializable;

/**
 * 车流量对象
 *
 * @author yll
 * @date 2023/6/5 14:06
 */
public class VehiclesFlowObject implements Serializable {

    private String AvgSpeed;
    private int Congestion;
    private String DeviceID;
    private int FlowRateFeature;
    private int HeadInterval;
    private int LaneCount;
    private int LaneIndex;
    private int LargeCarCount;
    private int LeftCarCount;
    private int MedCarCount;
    private int QueueLength;
    private int RightCarCount;
    private int SmallCarCount;
    private String SnapTime;
    private String SnapZone;
    private int SpaceInterval;
    private int SpaceUsed;
    private int StatCycle;
    private int StraightCarCount;
    private int TimeUsed;
    private int VehicleCount;
    private int VehicleDensity;
    private String VehiclesFlowID;

    public String getAvgSpeed() {
        return AvgSpeed;
    }

    public void setAvgSpeed(String avgSpeed) {
        AvgSpeed = avgSpeed;
    }

    public int getCongestion() {
        return Congestion;
    }

    public void setCongestion(int congestion) {
        Congestion = congestion;
    }

    public String getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(String deviceID) {
        DeviceID = deviceID;
    }

    public int getFlowRateFeature() {
        return FlowRateFeature;
    }

    public void setFlowRateFeature(int flowRateFeature) {
        FlowRateFeature = flowRateFeature;
    }

    public int getHeadInterval() {
        return HeadInterval;
    }

    public void setHeadInterval(int headInterval) {
        HeadInterval = headInterval;
    }

    public int getLaneCount() {
        return LaneCount;
    }

    public void setLaneCount(int laneCount) {
        LaneCount = laneCount;
    }

    public int getLaneIndex() {
        return LaneIndex;
    }

    public void setLaneIndex(int laneIndex) {
        LaneIndex = laneIndex;
    }

    public int getLargeCarCount() {
        return LargeCarCount;
    }

    public void setLargeCarCount(int largeCarCount) {
        LargeCarCount = largeCarCount;
    }

    public int getLeftCarCount() {
        return LeftCarCount;
    }

    public void setLeftCarCount(int leftCarCount) {
        LeftCarCount = leftCarCount;
    }

    public int getMedCarCount() {
        return MedCarCount;
    }

    public void setMedCarCount(int medCarCount) {
        MedCarCount = medCarCount;
    }

    public int getQueueLength() {
        return QueueLength;
    }

    public void setQueueLength(int queueLength) {
        QueueLength = queueLength;
    }

    public int getRightCarCount() {
        return RightCarCount;
    }

    public void setRightCarCount(int rightCarCount) {
        RightCarCount = rightCarCount;
    }

    public int getSmallCarCount() {
        return SmallCarCount;
    }

    public void setSmallCarCount(int smallCarCount) {
        SmallCarCount = smallCarCount;
    }

    public String getSnapTime() {
        return SnapTime;
    }

    public void setSnapTime(String snapTime) {
        SnapTime = snapTime;
    }

    public String getSnapZone() {
        return SnapZone;
    }

    public void setSnapZone(String snapZone) {
        SnapZone = snapZone;
    }

    public int getSpaceInterval() {
        return SpaceInterval;
    }

    public void setSpaceInterval(int spaceInterval) {
        SpaceInterval = spaceInterval;
    }

    public int getSpaceUsed() {
        return SpaceUsed;
    }

    public void setSpaceUsed(int spaceUsed) {
        SpaceUsed = spaceUsed;
    }

    public int getStatCycle() {
        return StatCycle;
    }

    public void setStatCycle(int statCycle) {
        StatCycle = statCycle;
    }

    public int getStraightCarCount() {
        return StraightCarCount;
    }

    public void setStraightCarCount(int straightCarCount) {
        StraightCarCount = straightCarCount;
    }

    public int getTimeUsed() {
        return TimeUsed;
    }

    public void setTimeUsed(int timeUsed) {
        TimeUsed = timeUsed;
    }

    public int getVehicleCount() {
        return VehicleCount;
    }

    public void setVehicleCount(int vehicleCount) {
        VehicleCount = vehicleCount;
    }

    public int getVehicleDensity() {
        return VehicleDensity;
    }

    public void setVehicleDensity(int vehicleDensity) {
        VehicleDensity = vehicleDensity;
    }

    public String getVehiclesFlowID() {
        return VehiclesFlowID;
    }

    public void setVehiclesFlowID(String vehiclesFlowID) {
        VehiclesFlowID = vehiclesFlowID;
    }
}
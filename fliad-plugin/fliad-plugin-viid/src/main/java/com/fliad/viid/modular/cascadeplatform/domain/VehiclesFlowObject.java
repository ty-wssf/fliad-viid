package com.fliad.viid.modular.cascadeplatform.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 车流量对象
 *
 * @author yll
 * @date 2023/6/5 14:06
 */
@Data
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

}
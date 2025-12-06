package com.fliad.gps.model;

/**
 * 车辆统计数据模型类
 */
public class VehicleStatData {
    // 时间(小时粒度 YYYYMMDDHH)
    private String dataTime;
    // 路网编码(路口或路段编号)
    private String roadNetCode;
    // 路网类型 1:路口 2:路段
    private int roadNetType;
    // 车辆类型 1:两客一危 2:货车
    private String vehicleType;
    // 车牌颜色 1:蓝色 2:黄色 3:黑色 4:白色 5:绿色 9:其他 91:农黄色 92:农绿色 93:黄绿色 94:渐变绿
    private int vehicleColor;
    // 车流量数
    private int vehicleCount;

    public VehicleStatData() {}

    public VehicleStatData(String dataTime, String roadNetCode, int roadNetType, 
                          String vehicleType, int vehicleColor, int vehicleCount) {
        this.dataTime = dataTime;
        this.roadNetCode = roadNetCode;
        this.roadNetType = roadNetType;
        this.vehicleType = vehicleType;
        this.vehicleColor = vehicleColor;
        this.vehicleCount = vehicleCount;
    }

    // Getter和Setter方法
    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getRoadNetCode() {
        return roadNetCode;
    }

    public void setRoadNetCode(String roadNetCode) {
        this.roadNetCode = roadNetCode;
    }

    public int getRoadNetType() {
        return roadNetType;
    }

    public void setRoadNetType(int roadNetType) {
        this.roadNetType = roadNetType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(int vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public void setVehicleCount(int vehicleCount) {
        this.vehicleCount = vehicleCount;
    }

    @Override
    public String toString() {
        return "VehicleStatData{" +
                "dataTime='" + dataTime + '\'' +
                ", roadNetCode='" + roadNetCode + '\'' +
                ", roadNetType=" + roadNetType +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleColor=" + vehicleColor +
                ", vehicleCount=" + vehicleCount +
                '}';
    }
}
package com.fliad.gps.model;

/**
 * GPS数据模型类
 */
public class GpsData {
    // 流水编号
    private String id;
    // 号牌号码
    private String vehicleNo;
    // 号牌颜色
    private String vehicleColor;
    // GPS时间
    private String gpsTime;
    // 经度
    private double lon;
    // 纬度
    private double lat;
    // 速度
    private double speed;
    // 方向
    private double direction;
    // 匹配的路口ID
    private String matchedCrossId;
    // 匹配的路段ID
    private String matchedRoadSegId;
    // 车辆类型 1:两客一危 2:货车
    private int vehicleType;

    public GpsData() {}

    public GpsData(String id, String vehicleNo, String vehicleColor, String gpsTime,
                   double lon, double lat, double speed, double direction) {
        this.id = id;
        this.vehicleNo = vehicleNo;
        this.vehicleColor = vehicleColor;
        this.gpsTime = gpsTime;
        this.lon = lon;
        this.lat = lat;
        this.speed = speed;
        this.direction = direction;
    }

    // Getter和Setter方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(String gpsTime) {
        this.gpsTime = gpsTime;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public String getMatchedCrossId() {
        return matchedCrossId;
    }

    public void setMatchedCrossId(String matchedCrossId) {
        this.matchedCrossId = matchedCrossId;
    }

    public String getMatchedRoadSegId() {
        return matchedRoadSegId;
    }

    public void setMatchedRoadSegId(String matchedRoadSegId) {
        this.matchedRoadSegId = matchedRoadSegId;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "GpsData{" +
                "id='" + id + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", vehicleColor='" + vehicleColor + '\'' +
                ", gpsTime='" + gpsTime + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                ", speed=" + speed +
                ", direction=" + direction +
                ", matchedCrossId='" + matchedCrossId + '\'' +
                ", matchedRoadSegId='" + matchedRoadSegId + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
package com.fliad.viid.modular.cascadeplatform.domain;

import java.util.Date;

/**
 * 视频卡口对象（参照《部、省级公安视频图像信息数据库对接技术要求(试行)》附录A.3）
 * 说明：字段首字母大写，忽略set/get方法，包含视频卡口基础属性，必选（R）/可选（O）参照文档定义
 */
public class Tollgate {
    // 1. 卡口ID（用于区分不同卡口对象，必选）
    private String TollgateID;
    // 2. 卡口名称（卡口的名称，必选）
    private String Name;
    // 3. 经度（卡口位置经度，必选）
    private Double Longitude;
    // 4. 纬度（卡口位置纬度，必选）
    private Double Latitude;
    // 5. 安装地点行政区划代码（卡口所在地区行政区划代码，必选）
    private String PlaceCode;
    // 6. 位置名（具体到位置或街道门牌号，由(乡镇街道)+(街路巷)+(门牌号)+(门楼详细地址)构成，可选）
    private String Place;
    // 7. 卡口状态（1-正常，2-停用，9-其他，必选）
    private Integer Status;
    // 8. 卡口类型（卡口的分类，必选）
    private String TollgateCat;
    // 9. 卡口用途（80-治安卡口，81-交通卡口，82-其他，必选）
    private Integer TollgateUsage;
    // 10. 卡口车道数（卡口的车道数量，可选）
    private Integer LaneNum;
    // 11. 管辖单位代码（负责该卡口的单位代码，可选）
    private String OrgCode;
    // 12. 卡口启用时间（启用时间之后的数据有效，可选）
    private Date ActiveTime;

    public String getTollgateID() {
        return TollgateID;
    }

    public void setTollgateID(String tollgateID) {
        TollgateID = tollgateID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public String getPlaceCode() {
        return PlaceCode;
    }

    public void setPlaceCode(String placeCode) {
        PlaceCode = placeCode;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getTollgateCat() {
        return TollgateCat;
    }

    public void setTollgateCat(String tollgateCat) {
        TollgateCat = tollgateCat;
    }

    public Integer getTollgateUsage() {
        return TollgateUsage;
    }

    public void setTollgateUsage(Integer tollgateUsage) {
        TollgateUsage = tollgateUsage;
    }

    public Integer getLaneNum() {
        return LaneNum;
    }

    public void setLaneNum(Integer laneNum) {
        LaneNum = laneNum;
    }

    public String getOrgCode() {
        return OrgCode;
    }

    public void setOrgCode(String orgCode) {
        OrgCode = orgCode;
    }

    public Date getActiveTime() {
        return ActiveTime;
    }

    public void setActiveTime(Date activeTime) {
        ActiveTime = activeTime;
    }
}
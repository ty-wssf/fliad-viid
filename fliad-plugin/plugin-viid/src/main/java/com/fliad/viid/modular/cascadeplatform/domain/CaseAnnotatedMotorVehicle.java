package com.fliad.viid.modular.cascadeplatform.domain;

import java.util.List;

/**
 * 案事件标注车辆对象（参照《视图库对接技术要求》附录A.11.3）
 * 说明：在非标注车辆基础上扩展，新增时间属性及更多标注字段，字段首字母大写
 */
public class CaseAnnotatedMotorVehicle {

    // 1. 车辆全局唯一标识（必选）
    private String MotorVehicleID;
    // 2. 信息分类（人工采集/自动采集，必选）
    private String InfoKind;
    // 3. 来源图像标识（可选）
    private String SourceID;
    // 4. 关联卡口编号（卡口编码，可选）
    private String TollgateID;
    // 5. 设备编码（自动采集必选，可选）
    private String DeviceID;
    // 6. 近景照片（自动采集必选，URI路径，必选）
    private String StorageUrl1;
    // 7. 车牌照片（可选）
    private String StorageUrl2;
    // 8. 远景照片（全景相机照片，可选）
    private String StorageUrl3;
    // 9. 合成图（可选）
    private String StorageUrl4;
    // 10. 缩略图（可选）
    private String StorageUrl5;
    // 11. 车轮廓左上角X坐标（自动采集必选，可选）
    private Integer LeftTopX;
    // 12. 车轮廓左上角Y坐标（自动采集必选，可选）
    private Integer LeftTopY;
    // 13. 车轮廓右下角X坐标（自动采集必选，可选）
    private Integer RightBtmX;
    // 14. 车轮廓右下角Y坐标（自动采集必选，可选）
    private Integer RightBtmY;
    // 15. 位置标记时间（可选）
    private String MarkTime;
    // 16. 车辆出现时间（人工采集有效，可选）
    private String AppearTime;
    // 17. 车辆消失时间（可选）
    private String DisappearTime;
    // 18. 车道号（从左到右编号，可选）
    private Integer LaneNo;
    // 19. 有无车牌（可选）
    private Boolean HasPlate;
    // 20. 号牌种类（可选）
    private String PlateClass;
    // 21. 车牌颜色（底色：黑/白/黄/蓝/绿，可选）
    private String PlateColor;
    // 22. 车牌号（无法识别标"无车牌"，部分未识别用"&#45;"，可选）
    private String PlateNo;
    // 23. 挂车牌号（可选）
    private String PlateNoAttach;
    // 24. 车牌描述（广告信息，可选）
    private String PlateDescribe;
    // 25. 是否套牌（可选）
    private Boolean IsDecked;
    // 26. 是否涂改（可选）
    private Boolean IsAltered;
    // 27. 是否遮挡（可选）
    private Boolean IsCovered;
    // 28. 行驶速度（km/h，可选）
    private String Speed;
    // 29. 行驶方向（可选）
    private String Direction;
    // 30. 行驶状态代码（可选）
    private String DrivingStatusCode;
    // 31. 车辆使用性质代码（可选）
    private String UsingPropertiesCode;
    // 32. 车辆类型（可选）
    private String VehicleClass;
    // 33. 车辆品牌（可选）
    private String VehicleBrand;
    // 34. 车辆型号（可选）
    private String VehicleModel;
    // 35. 车辆年款（可选）
    private String VehicleStyles;
    // 36. 车辆长度（可选）
    private String VehicleLength;
    // 37. 车辆宽度（可选）
    private String VehicleWidth;
    // 38. 车辆高度（可选）
    private String VehicleHeight;
    // 39. 车身颜色（必选）
    private String VehicleColor;
    // 40. 颜色深浅（可选）
    private String VehicleColorDepth;
    // 41. 车前盖描述（可选）
    private String VehicleHood;
    // 42. 车后盖描述（可选）
    private String VehicleTrunk;
    // 43. 车轮描述（可选）
    private String VehicleWheel;
    // 44. 车轮印花纹（可选）
    private String WheelPrintedPattern;
    // 45. 车窗描述（可选）
    private String VehicleWindow;
    // 46. 车顶描述（可选）
    private String VehicleRoof;
    // 47. 车门描述（可选）
    private String VehicleDoor;
    // 48. 车侧描述（不含车门，可选）
    private String SideOfVehicle;
    // 49. 车厢描述（可选）
    private String CarOfVehicle;
    // 50. 后视镜描述（可选）
    private String RearviewMirror;
    // 51. 底盘描述（可选）
    private String VehicleChassis;
    // 52. 遮挡物描述（可选）
    private String VehicleShielding;
    // 53. 贴膜颜色（可选）
    private String FilmColor;
    // 54. 改装标志（可选）
    private Boolean IsModified;
    // 55. 撞痕信息（可选）
    private String HitMarkInfo;
    // 56. 车身描述（文字/载物，可选）
    private String VehicleBodyDesc;
    // 57. 车前部物品（多个用逗号分隔，可选）
    private String VehicleFrontItem;
    // 58. 车前部物品描述（可选）
    private String DescOfFrontItem;
    // 59. 车后部物品（多个用逗号分隔，可选）
    private String VehicleRearItem;
    // 60. 车后部物品描述（可选）
    private String DescOfRearItem;
    // 61. 车内人数（可选）
    private Integer NumOfPassenger;
    // 62. 经过时刻（卡口过车时间，可选）
    private String PassTime;
    // 63. 经过道路名称（可选）
    private String NameOfPassedRoad;
    // 64. 是否可疑车（可选）
    private Boolean IsSuspicious;
    // 65. 遮阳板状态（0：收起；1：放下，可选）
    private Integer Sunvisor;
    // 66. 安全带状态（0：未系；1：系，可选）
    private Integer SafetyBelt;
    // 67. 打电话状态（0：未打；1：正在打，可选）
    private Integer Calling;
    // 68. 号牌识别可信度（0-100，可选）
    private String PlateReliability;
    // 69. 每位号牌可信度（字符-可信度，可选）
    private String PlateCharReliability;
    // 70. 品牌标志可信度（0-100，可选）
    private String BrandReliability;
    // 71. 图像列表（0或多个子图像，可选）
    private List<SubImageInfo> SubImageList;
    // 72. 特征值列表（可选）
    private List<FeatureInfo> FeatureList;
    // 73. 国籍代码（可选）
    private String NationalityCode;
    // 74. 归属分类标签（可选）
    private String TabID;

    public String getMotorVehicleID() {
        return MotorVehicleID;
    }

    public void setMotorVehicleID(String motorVehicleID) {
        MotorVehicleID = motorVehicleID;
    }

    public String getInfoKind() {
        return InfoKind;
    }

    public void setInfoKind(String infoKind) {
        InfoKind = infoKind;
    }

    public String getSourceID() {
        return SourceID;
    }

    public void setSourceID(String sourceID) {
        SourceID = sourceID;
    }

    public String getTollgateID() {
        return TollgateID;
    }

    public void setTollgateID(String tollgateID) {
        TollgateID = tollgateID;
    }

    public String getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(String deviceID) {
        DeviceID = deviceID;
    }

    public String getStorageUrl1() {
        return StorageUrl1;
    }

    public void setStorageUrl1(String storageUrl1) {
        StorageUrl1 = storageUrl1;
    }

    public String getStorageUrl2() {
        return StorageUrl2;
    }

    public void setStorageUrl2(String storageUrl2) {
        StorageUrl2 = storageUrl2;
    }

    public String getStorageUrl3() {
        return StorageUrl3;
    }

    public void setStorageUrl3(String storageUrl3) {
        StorageUrl3 = storageUrl3;
    }

    public String getStorageUrl4() {
        return StorageUrl4;
    }

    public void setStorageUrl4(String storageUrl4) {
        StorageUrl4 = storageUrl4;
    }

    public String getStorageUrl5() {
        return StorageUrl5;
    }

    public void setStorageUrl5(String storageUrl5) {
        StorageUrl5 = storageUrl5;
    }

    public Integer getLeftTopX() {
        return LeftTopX;
    }

    public void setLeftTopX(Integer leftTopX) {
        LeftTopX = leftTopX;
    }

    public Integer getLeftTopY() {
        return LeftTopY;
    }

    public void setLeftTopY(Integer leftTopY) {
        LeftTopY = leftTopY;
    }

    public Integer getRightBtmX() {
        return RightBtmX;
    }

    public void setRightBtmX(Integer rightBtmX) {
        RightBtmX = rightBtmX;
    }

    public Integer getRightBtmY() {
        return RightBtmY;
    }

    public void setRightBtmY(Integer rightBtmY) {
        RightBtmY = rightBtmY;
    }

    public String getMarkTime() {
        return MarkTime;
    }

    public void setMarkTime(String markTime) {
        MarkTime = markTime;
    }

    public String getAppearTime() {
        return AppearTime;
    }

    public void setAppearTime(String appearTime) {
        AppearTime = appearTime;
    }

    public String getDisappearTime() {
        return DisappearTime;
    }

    public void setDisappearTime(String disappearTime) {
        DisappearTime = disappearTime;
    }

    public Integer getLaneNo() {
        return LaneNo;
    }

    public void setLaneNo(Integer laneNo) {
        LaneNo = laneNo;
    }

    public Boolean getHasPlate() {
        return HasPlate;
    }

    public void setHasPlate(Boolean hasPlate) {
        HasPlate = hasPlate;
    }

    public String getPlateClass() {
        return PlateClass;
    }

    public void setPlateClass(String plateClass) {
        PlateClass = plateClass;
    }

    public String getPlateColor() {
        return PlateColor;
    }

    public void setPlateColor(String plateColor) {
        PlateColor = plateColor;
    }

    public String getPlateNo() {
        return PlateNo;
    }

    public void setPlateNo(String plateNo) {
        PlateNo = plateNo;
    }

    public String getPlateNoAttach() {
        return PlateNoAttach;
    }

    public void setPlateNoAttach(String plateNoAttach) {
        PlateNoAttach = plateNoAttach;
    }

    public String getPlateDescribe() {
        return PlateDescribe;
    }

    public void setPlateDescribe(String plateDescribe) {
        PlateDescribe = plateDescribe;
    }

    public Boolean getDecked() {
        return IsDecked;
    }

    public void setDecked(Boolean decked) {
        IsDecked = decked;
    }

    public Boolean getAltered() {
        return IsAltered;
    }

    public void setAltered(Boolean altered) {
        IsAltered = altered;
    }

    public Boolean getCovered() {
        return IsCovered;
    }

    public void setCovered(Boolean covered) {
        IsCovered = covered;
    }

    public String getSpeed() {
        return Speed;
    }

    public void setSpeed(String speed) {
        Speed = speed;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }

    public String getDrivingStatusCode() {
        return DrivingStatusCode;
    }

    public void setDrivingStatusCode(String drivingStatusCode) {
        DrivingStatusCode = drivingStatusCode;
    }

    public String getUsingPropertiesCode() {
        return UsingPropertiesCode;
    }

    public void setUsingPropertiesCode(String usingPropertiesCode) {
        UsingPropertiesCode = usingPropertiesCode;
    }

    public String getVehicleClass() {
        return VehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        VehicleClass = vehicleClass;
    }

    public String getVehicleBrand() {
        return VehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        VehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return VehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        VehicleModel = vehicleModel;
    }

    public String getVehicleStyles() {
        return VehicleStyles;
    }

    public void setVehicleStyles(String vehicleStyles) {
        VehicleStyles = vehicleStyles;
    }

    public String getVehicleLength() {
        return VehicleLength;
    }

    public void setVehicleLength(String vehicleLength) {
        VehicleLength = vehicleLength;
    }

    public String getVehicleWidth() {
        return VehicleWidth;
    }

    public void setVehicleWidth(String vehicleWidth) {
        VehicleWidth = vehicleWidth;
    }

    public String getVehicleHeight() {
        return VehicleHeight;
    }

    public void setVehicleHeight(String vehicleHeight) {
        VehicleHeight = vehicleHeight;
    }

    public String getVehicleColor() {
        return VehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        VehicleColor = vehicleColor;
    }

    public String getVehicleColorDepth() {
        return VehicleColorDepth;
    }

    public void setVehicleColorDepth(String vehicleColorDepth) {
        VehicleColorDepth = vehicleColorDepth;
    }

    public String getVehicleHood() {
        return VehicleHood;
    }

    public void setVehicleHood(String vehicleHood) {
        VehicleHood = vehicleHood;
    }

    public String getVehicleTrunk() {
        return VehicleTrunk;
    }

    public void setVehicleTrunk(String vehicleTrunk) {
        VehicleTrunk = vehicleTrunk;
    }

    public String getVehicleWheel() {
        return VehicleWheel;
    }

    public void setVehicleWheel(String vehicleWheel) {
        VehicleWheel = vehicleWheel;
    }

    public String getWheelPrintedPattern() {
        return WheelPrintedPattern;
    }

    public void setWheelPrintedPattern(String wheelPrintedPattern) {
        WheelPrintedPattern = wheelPrintedPattern;
    }

    public String getVehicleWindow() {
        return VehicleWindow;
    }

    public void setVehicleWindow(String vehicleWindow) {
        VehicleWindow = vehicleWindow;
    }

    public String getVehicleRoof() {
        return VehicleRoof;
    }

    public void setVehicleRoof(String vehicleRoof) {
        VehicleRoof = vehicleRoof;
    }

    public String getVehicleDoor() {
        return VehicleDoor;
    }

    public void setVehicleDoor(String vehicleDoor) {
        VehicleDoor = vehicleDoor;
    }

    public String getSideOfVehicle() {
        return SideOfVehicle;
    }

    public void setSideOfVehicle(String sideOfVehicle) {
        SideOfVehicle = sideOfVehicle;
    }

    public String getCarOfVehicle() {
        return CarOfVehicle;
    }

    public void setCarOfVehicle(String carOfVehicle) {
        CarOfVehicle = carOfVehicle;
    }

    public String getRearviewMirror() {
        return RearviewMirror;
    }

    public void setRearviewMirror(String rearviewMirror) {
        RearviewMirror = rearviewMirror;
    }

    public String getVehicleChassis() {
        return VehicleChassis;
    }

    public void setVehicleChassis(String vehicleChassis) {
        VehicleChassis = vehicleChassis;
    }

    public String getVehicleShielding() {
        return VehicleShielding;
    }

    public void setVehicleShielding(String vehicleShielding) {
        VehicleShielding = vehicleShielding;
    }

    public String getFilmColor() {
        return FilmColor;
    }

    public void setFilmColor(String filmColor) {
        FilmColor = filmColor;
    }

    public Boolean getModified() {
        return IsModified;
    }

    public void setModified(Boolean modified) {
        IsModified = modified;
    }

    public String getHitMarkInfo() {
        return HitMarkInfo;
    }

    public void setHitMarkInfo(String hitMarkInfo) {
        HitMarkInfo = hitMarkInfo;
    }

    public String getVehicleBodyDesc() {
        return VehicleBodyDesc;
    }

    public void setVehicleBodyDesc(String vehicleBodyDesc) {
        VehicleBodyDesc = vehicleBodyDesc;
    }

    public String getVehicleFrontItem() {
        return VehicleFrontItem;
    }

    public void setVehicleFrontItem(String vehicleFrontItem) {
        VehicleFrontItem = vehicleFrontItem;
    }

    public String getDescOfFrontItem() {
        return DescOfFrontItem;
    }

    public void setDescOfFrontItem(String descOfFrontItem) {
        DescOfFrontItem = descOfFrontItem;
    }

    public String getVehicleRearItem() {
        return VehicleRearItem;
    }

    public void setVehicleRearItem(String vehicleRearItem) {
        VehicleRearItem = vehicleRearItem;
    }

    public String getDescOfRearItem() {
        return DescOfRearItem;
    }

    public void setDescOfRearItem(String descOfRearItem) {
        DescOfRearItem = descOfRearItem;
    }

    public Integer getNumOfPassenger() {
        return NumOfPassenger;
    }

    public void setNumOfPassenger(Integer numOfPassenger) {
        NumOfPassenger = numOfPassenger;
    }

    public String getPassTime() {
        return PassTime;
    }

    public void setPassTime(String passTime) {
        PassTime = passTime;
    }

    public String getNameOfPassedRoad() {
        return NameOfPassedRoad;
    }

    public void setNameOfPassedRoad(String nameOfPassedRoad) {
        NameOfPassedRoad = nameOfPassedRoad;
    }

    public Boolean getSuspicious() {
        return IsSuspicious;
    }

    public void setSuspicious(Boolean suspicious) {
        IsSuspicious = suspicious;
    }

    public Integer getSunvisor() {
        return Sunvisor;
    }

    public void setSunvisor(Integer sunvisor) {
        Sunvisor = sunvisor;
    }

    public Integer getSafetyBelt() {
        return SafetyBelt;
    }

    public void setSafetyBelt(Integer safetyBelt) {
        SafetyBelt = safetyBelt;
    }

    public Integer getCalling() {
        return Calling;
    }

    public void setCalling(Integer calling) {
        Calling = calling;
    }

    public String getPlateReliability() {
        return PlateReliability;
    }

    public void setPlateReliability(String plateReliability) {
        PlateReliability = plateReliability;
    }

    public String getPlateCharReliability() {
        return PlateCharReliability;
    }

    public void setPlateCharReliability(String plateCharReliability) {
        PlateCharReliability = plateCharReliability;
    }

    public String getBrandReliability() {
        return BrandReliability;
    }

    public void setBrandReliability(String brandReliability) {
        BrandReliability = brandReliability;
    }

    public List<SubImageInfo> getSubImageList() {
        return SubImageList;
    }

    public void setSubImageList(List<SubImageInfo> subImageList) {
        SubImageList = subImageList;
    }

    public List<FeatureInfo> getFeatureList() {
        return FeatureList;
    }

    public void setFeatureList(List<FeatureInfo> featureList) {
        FeatureList = featureList;
    }

    public String getNationalityCode() {
        return NationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        NationalityCode = nationalityCode;
    }

    public String getTabID() {
        return TabID;
    }

    public void setTabID(String tabID) {
        TabID = tabID;
    }
}
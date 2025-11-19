package com.fliad.viid.modular.cascadeplatform.domain;

public class SubscribeNotificationObject {

    // 通知标识
    private String NotificationID;
    // 订阅标识
    private String SubscribeID;
    // 订阅标题
    private String Title;
    // 触发时间
    private String TriggerTime;
    // 信息标识
    private String InfoIDs;

    // 设备状态
    private DeviceStatusListObject DeviceStatusList;
    // 车流信息
    private VehiclesFlowListObject VehiclesFlowListObject;
    // 人脸信息
    private FaceListObject FaceObjectList;
    // 机动车信息
    private MotorVehicleObjectList MotorVehicleObjectList;
    // 非机动车信息
    private NonMotorVehicleObjectList NonMotorVehicleObjectList;

    public String getNotificationID() {
        return NotificationID;
    }

    public void setNotificationID(String notificationID) {
        NotificationID = notificationID;
    }

    public String getSubscribeID() {
        return SubscribeID;
    }

    public void setSubscribeID(String subscribeID) {
        SubscribeID = subscribeID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTriggerTime() {
        return TriggerTime;
    }

    public void setTriggerTime(String triggerTime) {
        TriggerTime = triggerTime;
    }

    public String getInfoIDs() {
        return InfoIDs;
    }

    public void setInfoIDs(String infoIDs) {
        InfoIDs = infoIDs;
    }

    public com.fliad.viid.modular.cascadeplatform.domain.DeviceStatusListObject getDeviceStatusList() {
        return DeviceStatusList;
    }

    public void setDeviceStatusList(com.fliad.viid.modular.cascadeplatform.domain.DeviceStatusListObject deviceStatusList) {
        DeviceStatusList = deviceStatusList;
    }

    public com.fliad.viid.modular.cascadeplatform.domain.VehiclesFlowListObject getVehiclesFlowListObject() {
        return VehiclesFlowListObject;
    }

    public void setVehiclesFlowListObject(com.fliad.viid.modular.cascadeplatform.domain.VehiclesFlowListObject vehiclesFlowListObject) {
        VehiclesFlowListObject = vehiclesFlowListObject;
    }

    public com.fliad.viid.modular.cascadeplatform.domain.FaceListObject getFaceObjectList() {
        return FaceObjectList;
    }

    public void setFaceObjectList(com.fliad.viid.modular.cascadeplatform.domain.FaceListObject faceObjectList) {
        FaceObjectList = faceObjectList;
    }

    public com.fliad.viid.modular.cascadeplatform.domain.MotorVehicleObjectList getMotorVehicleObjectList() {
        return MotorVehicleObjectList;
    }

    public void setMotorVehicleObjectList(com.fliad.viid.modular.cascadeplatform.domain.MotorVehicleObjectList motorVehicleObjectList) {
        MotorVehicleObjectList = motorVehicleObjectList;
    }

    public com.fliad.viid.modular.cascadeplatform.domain.NonMotorVehicleObjectList getNonMotorVehicleObjectList() {
        return NonMotorVehicleObjectList;
    }

    public void setNonMotorVehicleObjectList(com.fliad.viid.modular.cascadeplatform.domain.NonMotorVehicleObjectList nonMotorVehicleObjectList) {
        NonMotorVehicleObjectList = nonMotorVehicleObjectList;
    }
}
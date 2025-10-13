package com.fliad.viid.modular.cascadeplatform.domain;

import lombok.Data;

@Data

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

}

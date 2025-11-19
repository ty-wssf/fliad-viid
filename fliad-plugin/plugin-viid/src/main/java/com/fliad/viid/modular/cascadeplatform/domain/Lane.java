package com.fliad.viid.modular.cascadeplatform.domain;

/**
 * 车道对象（参照《视图库对接技术要求(试行)_20180521.pdf》附录A.4）
 * 说明：字段首字母大写，忽略set/get方法，包含车道基础属性，必选（R）/可选（O）参照文档定义
 */
public class Lane {
    // 1. 卡口编号（关联的卡口设备编号，必选）
    private String TollgateID;

    // 2. 车道ID（用于区分不同车道的唯一标识，必选）
    private Integer LaneId;

    // 3. 车道编号（车辆行驶方向最左车道为1，由左向右顺序编号，与方向有关，必选）
    private Integer LaneNo;

    // 4. 名称（车道的名称，必选）
    private String Name;

    // 5. 车道方向（车道的行驶方向，必选）
    private String Direction;

    // 6. 车道描述（车道的补充说明信息，可选）
    private String Desc;

    // 7. 限速（车道的限制速度，单位km/h（公里/小时），可选）
    private Integer MaxSpeed;

    // 8. 车道出入城（1-进城、2-出城、3-非进出城、4-进出城混合，可选）
    private Integer CityPass;

    // 9. 设备ID（车道上对应的采集处理设备ID，可选）
    private String ApeID;
}

package com.fliad.viid.modular.cascadeplatform.domain;

import java.util.Date;

/**
 * 采集设备对象（参照《视图库对接技术要求(试行)_20180521.pdf》附录A.2）
 * 说明：字段首字母大写，忽略set/get方法，包含采集设备基础属性，必选（R）/可选（O）参照文档定义
 */
public class APE {
    // 1. 设备ID（用于区分不同采集设备，必选）
    private String ApeID;
    // 2. 名称（采集设备的名称，必选）
    private String Name;
    // 3. 型号（采集设备的型号，必选）
    private String Model;
    // 4. IP地址（采集设备的IP地址，必选）
    private String IPAddr;
    // 5. IPv6地址（采集设备的IPv6地址，可选）
    private String IPV6Addr;
    // 6. 端口号（采集设备的端口号，必选）
    private Integer Port;
    // 7. 经度（采集设备位置经度，必选）
    private Double Longitude;
    // 8. 纬度（采集设备位置纬度，必选）
    private Double Latitude;
    // 9. 安装地点行政区划代码（采集设备所在地区行政区划代码，必选）
    private String PlaceCode;
    // 10. 位置名（具体到摄像机位置或街道门牌号，由(乡镇街道)+(街路巷)+(门牌号)+(门楼详细地址)构成，可选）
    private String Place;
    // 11. 管辖单位代码（负责该采集设备的单位代码，可选）
    private String OrgCode;
    // 12. 车辆抓拍方向（0-拍车头；1-拍车尾，兼容无视频卡口信息设备，可选）
    private Integer CapDirection;
    // 13. 监视方向（采集设备的监视方向，可选）
    private String MonitorDirection;
    // 14. 监视区域说明（对采集设备监视区域的描述，可选）
    private String MonitorAreaDesc;
    // 15. 是否在线（采集设备在线状态，必选）
    private Integer IsOnline;
    // 16. 所属采集系统（采集设备所接的采集系统设备，可选）
    private String OwnerApsID;
    // 17. 用户帐号（用于支持修改设备登陆帐号，可选）
    private String UserId;
    // 18. 口令（用于支持修改设备登陆口令，可选）
    private String Password;
    // 19. 功能类型（1-车辆卡口；2-人员卡口；3-微卡口；4-特征摄像机；5-普通监控；6-高空瞭望摄像机；99-其他，多选各参数以"/"分隔，必选）
    private String FunctionType;
    // 20. 摄像机位置类型（1-省际检查站、2-党政机关、3-车站码头、4-中心广场、5-体育场馆、6-商业中心、7-宗教场所、8-校园周边、9-治安复杂区域、10-交通干线、11-医院周边、12-金融机构周边、13-危险物品场所周边、14-博物馆展览馆、15-重点水域/航道、96-市际公安检查站、97-涉外场所、98-边境沿线、99-旅游景区，多选各参数以"/"分隔，可选）
    private String PositionType;
}
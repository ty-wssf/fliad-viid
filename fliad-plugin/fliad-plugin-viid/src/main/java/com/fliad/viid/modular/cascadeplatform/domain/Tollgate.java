package com.fliad.viid.modular.cascadeplatform.domain;

import lombok.Data;

import java.util.Date;

/**
 * 视频卡口对象（参照《部、省级公安视频图像信息数据库对接技术要求(试行)》附录A.3）
 * 说明：字段首字母大写，忽略set/get方法，包含视频卡口基础属性，必选（R）/可选（O）参照文档定义
 */
@Data
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
}
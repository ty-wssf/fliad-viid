package com.fliad.viid.modular.cascadeplatform.domain;

import lombok.Data;

import java.util.List;

/**
 * 非机动车信息对象（参照《视图库对接技术要求(试行)_20180521.pdf》附录A.11.4及相关数据交互规范）
 * 说明：字段首字母大写，忽略set/get方法，包含案事件标注场景下非机动车核心属性，必选（R）/可选（O）参照文档定义
 */
@Data
public class NonMotorVehicle {
    // 1. 非机动车全局唯一标识（用于区分不同非机动车对象，必选）
    private String NonMotorVehicleID;
    // 2. 信息分类（标识数据采集方式：0-人工采集、1-自动采集，必选）
    private Integer InfoKind;
    // 3. 来源标识（关联采集该非机动车信息的原始图像/视频标识，可选）
    private String SourceID;
    // 4. 设备编码（采集该非机动车信息的设备唯一编号，自动采集场景必选，可选）
    private String DeviceID;
    // 5. 采集时间（非机动车被采集到的具体时间，格式参照dateTime类型，必选）
    private String CollectTime;
    // 6. 采集地点行政区划代码（参照GB/T2260规定的行政区划代码，必选）
    private String PlaceCode;
    // 7. 采集地点详细地址（具体到街道门牌号，格式：乡镇街道+街路巷+门楼牌号+门楼详细地址，可选）
    private String PlaceFullAddress;
    // 8. 非机动车类型（如：01-自行车、02-电动自行车、03-人力三轮车、04-电动三轮车等，必选）
    private String VehicleType;
    // 9. 车身颜色（参照ColorType定义：01-黑色、02-白色、03-红色、04-蓝色、05-绿色等，必选）
    private String VehicleColor;
    // 10. 颜色深浅（标识颜色明暗程度：0-浅色、1-深色，可选）
    private Integer VehicleColorDepth;
    // 11. 品牌（非机动车生产厂商品牌，如“爱玛”“雅迪”等，可选）
    private String VehicleBrand;
    // 12. 型号（非机动车具体型号，如“TDR2000Z”，可选）
    private String VehicleModel;
    // 13. 车牌号（如有登记号牌，填写完整号牌；无号牌则填“无”，可选）
    private String PlateNo;
    // 14. 车牌颜色（号牌底色，参照ColorType定义，无号牌时不填，可选）
    private String PlateColor;
    // 15. 驾驶人是否存在（0-无驾驶人、1-有驾驶人，可选）
    private Integer HasDriver;
    // 16. 驾驶人特征（关联驾驶人的体貌特征简述，如“男性、戴蓝色头盔”，可选）
    private String DriverFeature;
    // 17. 载物情况（是否载物及载物描述：0-无载物、1-有载物（需补充载物类型/数量），可选）
    private String CargoSituation;
    // 18. 车辆状态（如：0-正常行驶、1-停放、2-故障、3-违规行驶，可选）
    private Integer VehicleStatus;
    // 19. 行驶方向（参照HDirectionType定义：01-东、02-南、03-西、04-北、05-东北等，可选）
    private String DrivingDirection;
    // 20. 行驶速度（单位：km/h，自动采集场景可填，可选）
    private Integer DrivingSpeed;
    // 21. 关联卡口编号（如在卡口场景采集，填写卡口唯一标识，可选）
    private String TollgateID;
    // 22. 车道号（采集时非机动车所在车道编号，从左到右顺序编号，可选）
    private Integer LaneNo;
    // 23. 车辆轮廓坐标（图像中非机动车轮廓外接矩形坐标：左上角X/Y、右下角X/Y，自动采集必选，可选）
    private String ContourCoordinate;
    // 24. 图像列表（包含0或多个子图像对象，存储非机动车不同角度照片，可选）
    private List<SubImageInfo> SubImageList;
    // 25. 特征值列表（不同厂商算法提取的非机动车特征值集合，可选）
    private List<FeatureInfo> FeatureList;
    // 26. 归属分类标签标识（关联该非机动车所属的数据分类标签ID，可选）
    private String TabID;
    // 27. 备注（补充说明信息，如“车辆尾部有破损”，可选）
    private String Remarks;
}
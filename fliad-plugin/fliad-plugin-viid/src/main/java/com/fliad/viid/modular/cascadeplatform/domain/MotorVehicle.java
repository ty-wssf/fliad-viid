package com.fliad.viid.modular.cascadeplatform.domain;

import lombok.Data;

import java.util.List;

/**
 * 非标注车辆对象（MotorVehicle）
 * 对应文档：视图库对接技术要求 - 附录A.10 非标注车辆对象MotorVehicle特征属性
 * 适用场景：非案事件标注情况下产生的车辆对象数据交互
 */
@Data
public class MotorVehicle {

    // 1. 车辆全局唯一标识（必选）
    private String MotorVehicleID;
    // 2. 信息分类（人工采集/自动采集，必选）
    private String InfoKind;
    // 3. 来源图像标识（可选）
    private String SourceID;
    // 4. 关联卡口编号（卡口编码，可选）
    private String TollgateID;
    // 5. 过车时间（必选）
    private String PassTime;
    // 6. 设备编码（自动采集必选，可选）
    private String DeviceID;
    // 7. 近景照片（自动采集必选，图像访问URI，必选）
    private String StorageUrl1;
    // 8. 车牌照片（可选）
    private String StorageUrl2;
    // 9. 远景照片（全景相机照片，可选）
    private String StorageUrl3;
    // 10. 合成图（可选）
    private String StorageUrl4;
    // 11. 缩略图（可选）
    private String StorageUrl5;
    // 12. 车轮廓外接矩形左上角X坐标（自动采集必选，可选）
    private Integer LeftTopX;
    // 13. 车轮廓外接矩形左上角Y坐标（自动采集必选，可选）
    private Integer LeftTopY;
    // 14. 车轮廓外接矩形右下角X坐标（自动采集必选，可选）
    private Integer RightBtmX;
    // 15. 车轮廓外接矩形右下角Y坐标（自动采集必选，可选）
    private Integer RightBtmY;
    // 16. 车道号（车辆行驶方向从左到右编号，可选）
    private Integer LaneNo;
    // 17. 有无车牌（可选）
    private Boolean HasPlate;
    // 18. 号牌种类（可选）
    private String PlateClass;
    // 19. 车牌颜色（号牌底色：黑/白/黄/蓝/绿，可选）
    private String PlateColor;
    // 20. 车牌号（无法识别标“无车牌”，部分未识别用“-”代替，可选）
    private String PlateNo;
    // 21. 挂车牌号（挂车号牌编号，可选）
    private String PlateNoAttach;
    // 22. 车牌描述（车牌框广告信息，可选）
    private String PlateDescribe;
    // 23. 是否套牌（可选）
    private Boolean IsDecked;
    // 24. 是否涂改（可选）
    private Boolean IsAltered;
    // 25. 是否遮挡（可选）
    private Boolean IsCovered;
    // 26. 行驶速度（单位：km/h，可选）
    private String Speed;
    // 27. 行驶方向（可选）
    private String Direction;
    // 28. 行驶状态代码（可选）
    private String DrivingStatusCode;
    // 29. 车辆使用性质代码（可选）
    private String UsingPropertiesCode;
    // 30. 车辆类型（可选）
    private String VehicleClass;
    // 31. 车辆品牌（被标注车辆品牌，可选）
    private String VehicleBrand;
    // 32. 车辆型号（可选）
    private String VehicleModel;
    // 33. 车辆年款（可选）
    private String VehicleStyles;
    // 34. 车辆长度（可选）
    private String VehicleLength;
    // 35. 车辆宽度（可选）
    private String VehicleWidth;
    // 36. 车辆高度（可选）
    private String VehicleHeight;
    // 37. 车身颜色（必选）
    private String VehicleColor;
    // 38. 颜色深浅（可选）
    private String VehicleColorDepth;
    // 39. 车前盖描述（可选）
    private String VehicleHood;
    // 40. 车后盖描述（可选）
    private String VehicleTrunk;
    // 41. 车轮描述（可选）
    private String VehicleWheel;
    // 42. 车轮印花纹（可选）
    private String WheelPrintedPattern;
    // 43. 车窗描述（可选）
    private String VehicleWindow;
    // 44. 车顶描述（可选）
    private String VehicleRoof;
    // 45. 车门描述（可选）
    private String VehicleDoor;
    // 46. 车侧描述（不含车门，可选）
    private String SideOfVehicle;
    // 47. 车厢描述（可选）
    private String CarOfVehicle;
    // 48. 后视镜描述（可选）
    private String RearviewMirror;
    // 49. 底盘描述（可选）
    private String VehicleChassis;
    // 50. 车遮挡物描述（可选）
    private String VehicleShielding;
    // 51. 贴膜颜色（可选）
    private String FilmColor;
    // 52. 改装标志（是否改装，可选）
    private Boolean IsModified;
    // 53. 撞痕信息（可选）
    private String HitMarkInfo;
    // 54. 车身描述（车身上文字或载物信息，可选）
    private String VehicleBodyDesc;
    // 55. 车前部物品（多个用英文半角逗号分隔，可选）
    private String VehicleFrontItem;
    // 56. 车前部物品描述（数量/颜色/种类，可选）
    private String DescOfFrontItem;
    // 57. 车后部物品（多个用英文半角逗号分隔，可选）
    private String VehicleRearItem;
    // 58. 车后部物品描述（数量/颜色/种类，可选）
    private String DescOfRearItem;
    // 59. 车内人数（可选）
    private Integer NumOfPassenger;
    // 60. 经过道路名称（车辆被标注时经过的道路，可选）
    private String NameOfPassedRoad;
    // 61. 遮阳板状态（0：收起；1：放下，可选）
    private Integer Sunvisor;
    // 62. 安全带状态（0：未系；1：系，可选）
    private Integer SafetyBelt;
    // 63. 打电话状态（0：未打；1：正在打，可选）
    private Integer Calling;
    // 64. 号牌识别可信度（0-100百分比，可选）
    private String PlateReliability;
    // 65. 每位号牌号码可信度（格式：字符-可信度，多个用逗号分隔，可选）
    private String PlateCharReliability;
    // 66. 品牌标志识别可信度（0-100百分比，可选）
    private String BrandReliability;
    // 67. 图像列表（包含0或多个子图像对象，可选）
    private List<SubImageInfo> SubImageList;
    // 68. 特征值列表（可选）
    private List<FeatureInfo> FeatureList;
    // 69. 国籍代码（世界各国和地区名称代码，可选）
    private String NationalityCode;
    // 70. 归属分类标签标识（可选）
    private String TabID;

}
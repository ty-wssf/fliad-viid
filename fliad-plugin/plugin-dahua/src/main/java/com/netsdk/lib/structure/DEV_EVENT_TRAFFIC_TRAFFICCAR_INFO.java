package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;
import com.sun.jna.Pointer;

// TrafficCar 交通车辆信息
public class DEV_EVENT_TRAFFIC_TRAFFICCAR_INFO extends NetSDKLib.SdkStructure {
    public byte[] szPlateNumber = new byte[32];         //车牌号码
    public byte[] szPlateType = new byte[32];           //号牌类型参见VideoAnalyseRule中车牌类型定义
    public byte[] szPlateColor = new byte[32];          //车牌颜色"Blue","Yellow",
    public byte[] szVehicleColor = new byte[32];        //车身颜色"White",
    public int nSpeed;                               //速度单位Km/H
    public byte[] szEvent = new byte[64];               //触发的相关事件参见事件列表Event
    public byte[] szViolationCode = new byte[32];       //违章代码详见TrafficGlobal.ViolationCode
    public byte[] szViolationDesc = new byte[64];       //违章描述
    public int nLowerSpeedLimit;                     //速度下限
    public int nUpperSpeedLimit;                     //速度上限
    public int nOverSpeedMargin;                     //限高速宽限值单位：km/h
    public int nUnderSpeedMargin;                    //限低速宽限值单位：km/h
    public int nLane;                                //车道参见事件列表EventList中卡口和路口事件。
    public int nVehicleSize;                         //车辆大小,-1表示未知,否则按位
    // 第0位:"Light-duty", 小型车
    // 第1位:"Medium", 中型车
    // 第2位:"Oversize", 大型车
    // 第3位:"Minisize", 微型车
    // 第4位:"Largesize", 长车
    public float fVehicleLength;                       // 车辆长度单位米
    public int nSnapshotMode;                        // 抓拍方式0-未分类,1-全景,2-近景,4-同向抓拍,8-反向抓拍,16-号牌图像
    public byte[] szChannelName = new byte[32];         // 本地或远程的通道名称,可以是地点信息来源于通道标题配置ChannelTitle.Name
    public byte[] szMachineName = new byte[256];        // 本地或远程设备名称来源于普通配置General.MachineName
    public byte[] szMachineGroup = new byte[256];       // 机器分组或叫设备所属单位默认为空,用户可以将不同的设备编为一组,便于管理,可重复。
    public byte[] szRoadwayNo = new byte[64];           // 道路编号
    public byte[] szDrivingDirection = new byte[3 * NetSDKLib.NET_MAX_DRIVINGDIRECTION]; //
    // 行驶方向 , "DrivingDirection" : ["Approach", "", ""],
    // "Approach"-上行,即车辆离设备部署点越来越近；"Leave"-下行,
    // 即车辆离设备部署点越来越远,第二和第三个参数分别代表上行和
    // 下行的两个地点
    public Pointer szDeviceAddress;                      // 设备地址,OSD叠加到图片上的,来源于配 置TrafficSnapshot.DeviceAddress,'\0'结束
    public byte[] szVehicleSign = new byte[32];         // 车辆标识,例如
    public NET_SIG_CARWAY_INFO_EX stuSigInfo;                     // 由车检器产生抓拍信号冗余信息
    public Pointer szMachineAddr;                        // 设备部署地点
    public float fActualShutter;                       // 当前图片曝光时间,单位为毫秒
    public byte byActualGain;                         // 当前图片增益,范围为0~100
    public byte byDirection;                          // 车道方向,0-南向北1-西南向东北2-西向东
    public byte[] byReserved = new byte[2];
    public Pointer szDetailedAddress;                    // 详细地址,作为szDeviceAddress的补充
    public byte[] szDefendCode = new byte[NetSDKLib.NET_COMMON_STRING_64]; //图片防伪码
    public int nTrafficBlackListID;                  // 关联禁止名单数据库记录默认主键ID,0,无效；>0,禁止名单数据记录
    public NET_COLOR_RGBA stuRGBA;                              // 车身颜色RGBA
    public NET_TIME stSnapTime;                           // 抓拍时间
    public int nRecNo;                               // 记录编号
    public byte[] szCustomParkNo = new byte[NetSDKLib.NET_COMMON_STRING_32 + 1]; // 自定义车位号（停车场用）
    public byte[] byReserved1 = new byte[3];
    public int nDeckNo;                              // 车板位号
    public int nFreeDeckCount;                       // 空闲车板数量
    public int nFullDeckCount;                       // 占用车板数量
    public int nTotalDeckCount;                      // 总共车板数量
    public byte[] szViolationName = new byte[64];       // 违章名称
    public int nWeight;                              // 车重(单位Kg), 类型为unsigned int
    public byte[] szCustomRoadwayDirection = new byte[32]; // 自定义车道方向,byDirection为9时有效
    public byte byPhysicalLane;                       // 物理车道号,取值0到5
    public byte[] byReserved2 = new byte[3];
    public int emMovingDirection;                    // 车辆行驶方向 EM_TRAFFICCAR_MOVE_DIRECTION
    public NET_TIME stuEleTagInfoUTC;                     // 对应电子车牌标签信息中的过车时间(ThroughTime)
    public NET_RECT stuCarWindowBoundingBox;              // 车窗包围盒，0~8191
    public NET_TRAFFICCAR_WHITE_LIST stuWhiteList;                // 允许名单信息
    public int emCarType;                            // 车辆类型, 详见 EM_TRAFFICCAR_CAR_TYPE
    public int emLaneType;                           // 车道类型, 详见EM_TRAFFICCAR_LANE_TYPE
    public byte[] szVehicleBrandYearText = new byte[64]; // 车系年款翻译后文本内容
    public byte[] szCategory = new byte[32];            // 车辆子类型
    public NET_TRAFFICCAR_BLACK_LIST stuBlackList;                // 禁止名单信息
    public int emFlowDirection;                      // 车流量方向   EM_VEHICLE_DIRECTION
    /**
     * 收费公路车辆通行费车型分类 {@link com.netsdk.lib.enumeration.EM_TOLLS_VEHICLE_TYPE}
     */
    public int emTollsVehicleType;
    /**
     * 轴型代码,参考轴型国标 0代表其他
     */
    public int nAxleType;
    /**
     * 车轴数量
     */
    public int nAxleCount;
    /**
     * 车轮数量
     */
    public int nWheelNum;
    /**
     * 车身抠图
     */
    public NET_TRAFFICCAR_ORIGINAL_VEHICLE stuOriginalVehicle = new NET_TRAFFICCAR_ORIGINAL_VEHICLE();
    /**
     * 按功能划分的车辆类型 {@link NetSDKLib.EM_VEHICLE_TYPE_BY_FUNC}
     */
    public int emVehicleTypeByFunc;
    /**
     * 车辆子品牌
     */
    public short nSunBrand;
    /**
     * 车辆年款
     */
    public short nBrandYear;
    /**
     * 交通灯类型,仅在EVENT_IVS_TRAFFIC_RUNREDLIGHT中有效, 0;未知, 1:箭头灯, 2:圆形灯
     */
    public int nTrafficLightType;
    /**
     * 车牌属性 {@link com.netsdk.lib.enumeration.EM_PLATE_ATTRIBUTE}
     */
    public int emPlateAttribute;
    /**
     * 交通车辆信息扩展, refer to {@link com.netsdk.lib.structure.NET_TRAFFICCAR_INFO_EXTERN}
     */
    public Pointer pTrafficInfoExtern;
    public byte[] szCarNoGroupType = new byte[64];      //分组类别,出租车、网约车、私家车等等
    public int nOverShoot;                           //车辆是否冲出检测区域(0-未知 1-冲出 2-未冲出)
    /**
     * 保留字节,留待扩展
     */
    public byte[] bReserved = new byte[64 - NetSDKLib.POINTERSIZE];
}

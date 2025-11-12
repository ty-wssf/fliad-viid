package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;
import com.sun.jna.Pointer;

// 事件类型 EVENT_IVS_TRAFFICJUNCTION 交通路口老规则事件/视频电警上的交通卡口老规则事件对应的数据块描述信息
// 由于历史原因,如果要处理卡口事件,DEV_EVENT_TRAFFICJUNCTION_INFO 和 EVENT_IVS_TRAFFICGATE要一起处理
// 以防止有视频电警和线圈电警同时接入平台的情况发生, 另外EVENT_IVS_TRAFFIC_TOLLGATE只支持新卡口事件的配置
public class DEV_EVENT_TRAFFICJUNCTION_INFO extends NetSDKLib.SdkStructure {
    public int nChannelID;                           // 通道号
    public byte[] szName = new byte[128];               // 事件名称
    public byte byMainSeatBelt;                       // 主驾驶座,系安全带状态,1-系安全带,2-未系安全带
    public byte bySlaveSeatBelt;                      // 副驾驶座,系安全带状态,1-系安全带,2-未系安全带
    public byte byVehicleDirection;                   // 当前被抓拍到的车辆是车头还是车尾,具体请见 EM_VEHICLE_DIRECTION
    public byte byOpenStrobeState;                    // 开闸状态,具体请见 EM_OPEN_STROBE_STATE
    public double PTS;                                  // 时间戳(单位是毫秒)
    public NET_TIME_EX UTC;                                  // 事件发生的时间
    public int nEventID;                             // 事件ID
    public NET_MSG_OBJECT stuObject;                            // 检测到的物体
    public int nLane;                                // 对应车道号
    public int dwBreakingRule;                       // 违反规则掩码,第一位:闯红灯;
    // 第二位:不按规定车道行驶;
    // 第三位:逆行; 第四位：违章掉头;
    // 第五位:交通堵塞; 第六位:交通异常空闲
    // 第七位:压线行驶; 否则默认为:交通路口事件
    public NET_TIME_EX RedLightUTC;                          // 红灯开始UTC时间
    public NET_EVENT_FILE_INFO stuFileInfo;                       // 事件对应文件信息
    public int nSequence;                            // 表示抓拍序号,如3,2,1,1表示抓拍结束,0表示异常结束
    public int nSpeed;                               // 车辆实际速度Km/h
    public byte bEventAction;                         // 事件动作,0表示脉冲事件,1表示持续性事件开始,2表示持续性事件结束;
    public byte byDirection;                          // 路口方向,1-表示正向,2-表示反向
    public byte byLightState;                         // LightState表示红绿灯状态:0 未知,1 绿灯,2 红灯,3 黄灯
    public byte byReserved;                           // 保留字节
    public byte byImageIndex;                         // 图片的序号, 同一时间内(精确到秒)可能有多张图片, 从0开始
    public NET_MSG_OBJECT stuVehicle;                           // 车身信息
    public int dwSnapFlagMask;                       // 抓图标志(按位),具体见 NET_RESERVED_COMMON, 0位:"*",1位:"Timing",2位:"Manual",3位:"Marked",4位:"Event",5位:"Mosaic",6位:"Cutout"
    public NET_RESOLUTION_INFO stuResolution;                     // 对应图片的分辨率
    public byte[] szRecordFile = new byte[NetSDKLib.NET_COMMON_STRING_128]; // 报警对应的原始录像文件信息
    public EVENT_JUNCTION_CUSTOM_INFO stuCustomInfo;              // 自定义信息
    public byte byPlateTextSource;                    // 车牌识别来源, 0:本地算法识别,1:后端服务器算法识别
    public byte[] bReserved1 = new byte[3];             // 保留字节,留待扩展.
    public NET_GPS_INFO stuGPSInfo;                           // GPS信息
    public byte byNoneMotorInfo;                      // 0-无非机动车人员信息信息,1-有非机动车人员信息信息  此字段为1时下面11个字段生效
    public byte byBag;                                // 是否背包, 0-未知 1-不背包   2-背包
    public byte byUmbrella;                           // 是否打伞, 0-未知 1-不打伞   2-打伞
    public byte byCarrierBag;                         // 手提包状态,0-未知 1-没有 2-有
    public byte byHat;                                // 是否戴帽子, 0-未知 1-不戴帽子 2-戴帽子
    public byte byHelmet;                             // 头盔状态,0-未知 1-没有 2-有
    public byte bySex;                                // 性别,0-未知 1-男性 2-女性
    public byte byAge;                                // 年龄
    public NET_COLOR_RGBA stuUpperBodyColor;                    // 上身颜色
    public NET_COLOR_RGBA stuLowerBodyColor;                    // 下身颜色
    public byte byUpClothes;                          // 上身衣服类型 0:未知 1:长袖 2:短袖 3:长裤 4:短裤 5:裙子 6:背心 7:超短裤 8:超短裙
    public byte byDownClothes;                        // 下身衣服类型 0:未知 1:长袖 2:短袖 3:长裤 4:短裤 5:裙子 6:背心 7:超短裤 8:超短裙
    public NET_EXTENSION_INFO stuExtensionInfo;                   // 扩展信息
    public byte[] bReserved = new byte[22];             // 保留字节,留待扩展.
    public int nTriggerType;                         // TriggerType:触发类型,0车检器,1雷达,2视频
    public DEV_EVENT_TRAFFIC_TRAFFICCAR_INFO stTrafficCar;        // 交通车辆信息
    public int dwRetCardNumber;                      // 卡片个数
    public EVENT_CARD_INFO[] stuCardInfo = (EVENT_CARD_INFO[]) new EVENT_CARD_INFO().toArray(NetSDKLib.NET_EVENT_MAX_CARD_NUM); // 卡片信息
    public EVENT_COMM_INFO stCommInfo;                           // 公共信息
    public int bNonMotorInfoEx;                      // 是否有非机动车信息, 1-true; 0-false
    public VA_OBJECT_NONMOTOR stuNonMotor;                        // 非机动车信息
    public EVENT_INTELLI_COMM_INFO stuIntelliCommInfo;            // 智能事件公共信息
    public EVENT_PLATE_INFO stuPlateInfo = new EVENT_PLATE_INFO(); // 车辆信息，记录了车头、车尾车牌号和车牌颜色
    public int bSceneImage;                          // 全景图是否有效
    public SCENE_IMAGE_INFO_EX stuSceneImage = new SCENE_IMAGE_INFO_EX(); // 全景图
    public Pointer pstObjects;                           // 检测到的多个车牌信息
    public int nObjectNum;                           // 检测到的多个车牌个数
    public int emVehiclePosture;                     // 车辆姿势
    public int nVehicleSignConfidence;               // 车标置信度（范围：0~100）
    public int nVehicleCategoryConfidence;           // 车型置信度（范围：0~100）
    public int emCarDrivingDirection;                // 规则区内车辆行驶方向
    public NET_IMAGE_INFO_EX2 stuImageInfo[] = new NET_IMAGE_INFO_EX2[32]; // 图片信息数组
    public int nImageInfoNum;                        // 图片信息个数
    public byte[] szSerialNo = new byte[128];           // 和客户端请求的抓图序列号对应
    public int nAlarmCompliance;                     // 报警合规, 0:未知, 1:不合规, 2:合规
    public NET_EVENT_INFO_EXTEND stuEventInfoEx = new NET_EVENT_INFO_EXTEND(); // 事件公共扩展字段结构体
    public NET_MSG_OBJECT_SUPPLEMENT stObjectInfoEx;              // 视频分析物体信息补充字段，与 DH_MSG_OBJECT 的合集表示视频分析物体信息
    public Pointer pstuObjectEx2;                        // 检测到的物体扩展,指针对应结构体NET_MSG_OBJECT_EX2
    public Pointer pstuVehicleEx2;                       // 车身信息扩展，指针对应结构体NET_MSG_OBJECT_EX2
    public Pointer pstuObjectsEx2;                       // 检测到的多个车牌信息扩展，数量为nObjectNum,指针对应结构体NET_MSG_OBJECT_EX2
    public int nPresetID;                            // 事件触发的预置点号，从1开始, 0表示未知
    public int nTransfer;                            //文件传输状态, -1: 未知, 0-实时数据下载，1-离线数据下载, 2-离线数据传输完成, 3-离线数据传输中断
    public byte[] szFeatureVersion = new byte[32];      //特征值的版本号
    public int nDetectMode;                          //检测物体具体包含的信息类型: 0: 只包含属性 1: 只包含特征值 2: 属性、特征值都包含 3:属性和特征值都不包含
    public byte[] szSourceID = new byte[32];            //事件关联ID,格式：类型+时间+序列号，其中类型2位，时间14位，序列号5位。类型：02-图像,时间：YYYYMMDDhhmmss,序列号：00001,如"022019030714003000001"
    public int emVehicleAction;                      //车辆行为类型,0：未知,1：伐木盗林,2：偷盗沙石,参见枚举定义 {@link com.netsdk.lib.enumeration.EM_TRAFFIC_VEHICLE_ACTION}
    public int nImageInfoEx3Num;                     //图片信息个数
    public Pointer pstuImageInfo;                        //图片信息数组,参见结构体定义 {@link com.netsdk.lib.structure.NET_IMAGE_INFO_EX3}
    public int nDirectionStatsResult;                //结构化统计方向检测结果 0：未知，1：从左到右，2：从右到左
    public byte[] szReserved1 = new byte[4];            //字节对齐
    public byte[] szEventUUID = new byte[40];           //事件ID，由UUID生成，标识唯一事件
    public long nEventUUID;                           //唯一标识一个事
    public byte[] byReserved2 = new byte[448 - 4 * NetSDKLib.POINTERSIZE]; // 保留字节

    public DEV_EVENT_TRAFFICJUNCTION_INFO() {
        for (int i = 0; i < 32; i++) {
            stuImageInfo[i] = new NET_IMAGE_INFO_EX2();
        }
    }
}


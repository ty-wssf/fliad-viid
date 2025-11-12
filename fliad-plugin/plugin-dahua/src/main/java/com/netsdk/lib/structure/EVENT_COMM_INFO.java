package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;
import com.sun.jna.Pointer;

import static com.netsdk.lib.NetSDKLib.*;

public class EVENT_COMM_INFO extends NetSDKLib.SdkStructure {
    public int emNTPStatus;                          // NTP校时状态, 取值为EM_NTP_STATUS中的值
    public int nDriversNum;                          // 驾驶员信息数
    public Pointer pstDriversInfo;                       // 驾驶员信息数据，类型为 NET_MSG_OBJECT_EX*
    public Pointer pszFilePath;                          // 本地硬盘或者sd卡成功写入路径,为NULL时,路径不存在， 类型为char *
    public Pointer pszFTPPath;                           // 设备成功写到ftp服务器的路径， 类型为char *
    public Pointer pszVideoPath;                         // 当前接入需要获取当前违章的关联视频的FTP上传路径， 类型为char *
    public EVENT_COMM_SEAT[] stCommSeat = new EVENT_COMM_SEAT[NetSDKLib.COMMON_SEAT_MAX_NUMBER]; // 驾驶位信息
    public int nAttachmentNum;                       // 车辆物件个数
    public EVENT_COMM_ATTACHMENT[] stuAttachment = new EVENT_COMM_ATTACHMENT[NET_MAX_ATTACHMENT_NUM]; //车辆物件信息
    public int nAnnualInspectionNum;                 // 年检标志个数
    public NET_RECT[] stuAnnualInspection = new NET_RECT[NET_MAX_ANNUUALINSPECTION_NUM]; //年检标志
    public float fHCRatio;                             // HC所占比例，单位：%
    public float fNORatio;                             // NO所占比例，单位：%
    public float fCOPercent;                           // CO所占百分比，单位：% 取值0~100
    public float fCO2Percent;                          // CO2所占百分比，单位：% 取值0~100
    public float fLightObscuration;                    // 不透光度，单位：% 取值0~100
    public int nPictureNum;                          // 原始图片张数
    public EVENT_PIC_INFO[] stuPicInfos = new EVENT_PIC_INFO[NET_MAX_EVENT_PIC_NUM]; // 原始图片信息
    public float fTemperature;                         // 温度值,单位摄氏度
    public int nHumidity;                            // 相对湿度百分比值
    public float fPressure;                            // 气压值,单位Kpa
    public float fWindForce;                           // 风力值,单位m/s
    public int nWindDirection;                       // 风向,单位度,范围:[0,360]
    public float fRoadGradient;                        // 道路坡度值,单位度
    public float fAcceleration;                        // 加速度值,单位:m/s2
    public NET_RFIDELETAG_INFO stuRFIDEleTagInfo = new NET_RFIDELETAG_INFO(); // RFID 电子车牌标签信息
    public EVENT_PIC_INFO stuBinarizedPlateInfo = new EVENT_PIC_INFO(); // 二值化车牌抠图
    public EVENT_PIC_INFO stuVehicleBodyInfo = new EVENT_PIC_INFO(); // 车身特写抠图
    public int emVehicleTypeInTollStation;           // 收费站车型分类,详见EM_VEHICLE_TYPE
    public int emSnapCategory;                       // 抓拍的类型，默认为机动车,详见EM_SNAPCATEGORY
    public int nRegionCode;                          // 车牌所属地区代码,默认-1表示未识别
    public int emVehicleTypeByFunc;                  // 按功能划分的车辆类型，详见EM_VEHICLE_TYPE_BY_FUNC
    public int emStandardVehicleType;                // 标准车辆类型，详见EM_STANDARD_VEHICLE_TYPE
    public int nExtraPlateCount;                     // 额外车牌数量
    public byte[] szExtraPlateNumer = new byte[3 * 32];   // 额外车牌信息
    /**
     * 海外车辆类型中的子类别 {@link com.netsdk.lib.enumeration.EM_OVERSEA_VEHICLE_CATEGORY_TYPE}
     */
    public int emOverseaVehicleCategory;
    /**
     * 车牌所属国家的省、州等地区名
     */
    public byte[] szProvince = new byte[64];
    /**
     * 物体在雷达坐标系中的信息,单位：米，设备视角：右手方向为X轴正向，正前方为Y轴正向
     */
    public NET_EVENT_RADAR_INFO stuRadarInfo = new NET_EVENT_RADAR_INFO();
    /**
     * 触发事件时物体的GPS信息
     */
    public NET_EVENT_GPS_INFO stuGPSInfo = new NET_EVENT_GPS_INFO();
    /**
     * 辅车牌信息，某些国家或地区一车多牌，比如港澳三地车，一车会有3个车牌，其中一个主车牌，一般是内地发给香港或澳门的能以此在内地行驶的"港澳牌"；另外两个分别是香港牌或澳门牌，是得以在香港或澳门行驶的牌照，而这两个则称为辅牌，有辅牌的车的车牌相关信息则填在此字段，目前最多2个辅车牌
     */
    public NET_EXTRA_PLATES[] stuExtraPlates = new NET_EXTRA_PLATES[2];
    /**
     * 辅车牌有效个数
     */
    public int nExtraPlatesCount;
    /**
     * 车牌识别置信度
     */
    public int nPlateRecogniseConf;
    /**
     * 车辆姿态置信度
     */
    public int nVecPostureConf;
    /**
     * 车身颜色置信度
     */
    public int nVecColorConf;
    /**
     * 特殊车辆识别结果置信度
     */
    public int nSpecialVehConf;
    /**
     * 机动车是否为大角度
     */
    public int nIsLargeAngle;
    /**
     * 当前机动车车身是否曾经关联车牌
     */
    public int nIsRelatedPlate;
    /**
     * 机动车检测置信度
     */
    public int nDetectConf;
    /**
     * 机动车清晰度分值
     */
    public int nClarity;
    /**
     * 机动车完整度评分
     */
    public int nCompleteScore;
    /**
     * 机动车优选分数
     */
    public int nQeScore;
    public float fSpeedFloat;                          //浮点型速度值，单位km/h
    public double dbHeadingAngle;                       //航向角, 以正北方向为基准输出车辆运动方向同正北方向的角度; 范围 0~360，顺时针正,单位为度；
    public int nDriverNum;                           //车辆前排驾驶室人员数量
    public byte[] szSEMotorVehicleType_i = new byte[64]; //I级机动车交调(SE)车型
    public byte[] szReserved1 = new byte[4];            //字节对齐
    public Pointer pstuYunTongInfo;                      //云瞳平台的部分图片信息,参见结构体定义 {@link com.netsdk.lib.structure.NET_YUNTONG_INFO}
    /**
     * 预留字节
     */
    public byte[] bReserved = new byte[44 - POINTERSIZE];
    public byte[] szCountry = new byte[20];             // 国家

    public EVENT_COMM_INFO() {
        for (int i = 0; i < stCommSeat.length; i++) {
            stCommSeat[i] = new EVENT_COMM_SEAT();
        }
        for (int i = 0; i < stuAttachment.length; i++) {
            stuAttachment[i] = new EVENT_COMM_ATTACHMENT();
        }
        for (int i = 0; i < stuAnnualInspection.length; i++) {
            stuAnnualInspection[i] = new NET_RECT();
        }
        for (int i = 0; i < stuPicInfos.length; i++) {
            stuPicInfos[i] = new EVENT_PIC_INFO();
        }
        for (int i = 0; i < stuExtraPlates.length; i++) {
            stuExtraPlates[i] = new NET_EXTRA_PLATES();
        }
    }
}

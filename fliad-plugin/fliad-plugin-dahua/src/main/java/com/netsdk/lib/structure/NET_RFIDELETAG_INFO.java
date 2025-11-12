package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// RFID 电子车牌标签信息
public class NET_RFIDELETAG_INFO extends NetSDKLib.SdkStructure {
    public byte[] szCardID = new byte[NetSDKLib.MAX_RFIDELETAG_CARDID_LEN]; // 卡号
    public int nCardType;                            // 卡号类型, 0:交通管理机关发行卡, 1:新车出厂预装卡
    public int emCardPrivince;                       // 卡号省份, 对应   EM_CARD_PROVINCE
    public byte[] szPlateNumber = new byte[NetSDKLib.NET_MAX_PLATE_NUMBER_LEN]; // 车牌号码
    public byte[] szProductionDate = new byte[NetSDKLib.MAX_RFIDELETAG_DATE_LEN]; // 出厂日期
    public int emCarType;                            // 车辆类型, 对应  EM_CAR_TYPE
    public int nPower;                               // 功率,单位：千瓦时，功率值范围0~254；255表示该车功率大于可存储的最大功率值
    public int nDisplacement;                        // 排量,单位：百毫升，排量值范围0~254；255表示该车排量大于可存储的最大排量值
    public int nAntennaID;                           // 天线ID，取值范围:1~4
    public int emPlateType;                          // 号牌种类, 对应  EM_PLATE_TYPE
    public byte[] szInspectionValidity = new byte[NetSDKLib.MAX_RFIDELETAG_DATE_LEN]; // 检验有效期，年-月
    public int nInspectionFlag;                      // 逾期未年检标志, 0:已年检, 1:逾期未年检
    public int nMandatoryRetirement;                 // 强制报废期，从检验有效期开始，距离强制报废期的年数
    public int emCarColor;                           // 车身颜色, 对应  EM_CAR_COLOR_TYPE
    public int nApprovedCapacity;                    // 核定载客量，该值<0时：无效；此值表示核定载客，单位为人
    public int nApprovedTotalQuality;                // 此值表示总质量，单位为百千克；该值<0时：无效；该值的有效范围为0~0x3FF，0x3FF（1023）表示数据值超过了可存储的最大值
    public NET_TIME_EX stuThroughTime;                       // 过车时间
    public int emUseProperty;                        // 使用性质, 对应  EM_USE_PROPERTY_TYPE
    public byte[] szPlateCode = new byte[NetSDKLib.MAX_COMMON_STRING_8]; // 发牌代号，UTF-8编码
    public byte[] szPlateSN = new byte[NetSDKLib.MAX_COMMON_STRING_16]; // 号牌号码序号，UTF-8编码
    public byte[] szTID = new byte[NetSDKLib.MAX_COMMON_STRING_64]; // 标签(唯一标识), UTF-8编码
    public byte[] bReserved = new byte[40];             // 保留字节,留待扩展.
}

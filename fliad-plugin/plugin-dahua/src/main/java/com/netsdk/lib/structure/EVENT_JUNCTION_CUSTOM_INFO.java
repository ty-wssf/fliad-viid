package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

//卡口事件专用上报内容，需求增加到Custom下
public class EVENT_JUNCTION_CUSTOM_INFO extends NetSDKLib.SdkStructure {
    public EVENT_CUSTOM_WEIGHT_INFO stuWeightInfo;                // 原始图片信息
    public int nCbirFeatureOffset;                   // 数据偏移，单位字节 （由于结构体保留字节有限的限制,添加在此处， 下同）
    public int nCbirFeatureLength;                   // 数据大小，单位字节
    public int dwVehicleHeadDirection;               // 车头朝向 0:未知 1:左 2:中 3:右
    public int nAvailableSpaceNum;                   // 停车场车位余位数量
    public NET_RADAR_FREE_STREAM stuRadarFreeStream;              // 雷达自由流信息
    public NET_CUSTOM_MEASURE_TEMPER stuMeasureTemper;            // 测温信息
    public int bCbirFeatureEnc;                      //标识车身特征值是否加密
    public int nRadarTriggerLineNo;                  //雷达触发线序号上报 1 ：触发线1, 2 ：触发线2, 0 : 未知
    public byte[] bReserved = new byte[4];              // 预留字节
}

package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 非机动车配牌信息
public class NET_NONMOTOR_PLATE_INFO extends NetSDKLib.SdkStructure {
    public byte[] szPlateNumber = new byte[128];        // 非机动车车牌号
    public NET_RECT stuBoundingBox;                       // 包围盒， 非机动车矩形框，0~8191相对坐标
    public NET_RECT stuOriginalBoundingBox;               // 包围盒， 非机动车矩形框，绝对坐标
    public NET_NONMOTOR_PLATE_IMAGE stuPlateImage;                // 非机动车车牌抠图
    public int emPlateColor;                         // 车牌颜色
    public byte[] byReserved = new byte[132];           // 保留
}

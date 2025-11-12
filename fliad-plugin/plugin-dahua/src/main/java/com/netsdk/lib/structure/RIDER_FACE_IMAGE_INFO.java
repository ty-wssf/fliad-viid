package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 骑车人脸图片信息
public class RIDER_FACE_IMAGE_INFO extends NetSDKLib.SdkStructure {
    public int uOffset;                              // 在二进制数据块中的偏移
    public int uLength;                              // 图片大小,单位：字节
    public int uWidth;                               // 图片宽度
    public int uHeight;                              // 图片高度
    public int nIndexInData;                         //图片的序号
    public byte[] byReserved = new byte[44];            // 保留
}
package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 非机动车车牌图片信息
public class NET_NONMOTOR_PLATE_IMAGE extends NetSDKLib.SdkStructure {
    public int nOffset;                              // 在二进制数据块中的偏移
    public int nLength;                              // 图片大小
    public int nWidth;                               // 图片宽度
    public int nHeight;                              // 图片高度
    public int nIndexInData;                         //在上传图片数据中的图片序号
    public byte[] byReserved = new byte[508];           // 保留字节
}

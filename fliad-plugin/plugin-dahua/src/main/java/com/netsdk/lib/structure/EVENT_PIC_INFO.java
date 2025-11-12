package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 交通抓图图片信息
public class EVENT_PIC_INFO extends NetSDKLib.SdkStructure {
    public int nOffset;                              // 原始图片偏移，单位字节
    public int nLength;                              // 原始图片长度，单位字节
    public int nIndexInData;                         // 在上传图片数据中的图片序号
}

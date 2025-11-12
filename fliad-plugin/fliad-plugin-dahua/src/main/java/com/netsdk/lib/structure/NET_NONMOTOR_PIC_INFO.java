package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 非机动车抠图信息
public class NET_NONMOTOR_PIC_INFO extends NetSDKLib.SdkStructure {
    public int uOffset;                              // 在二进制数据块中的偏移
    public int uLength;                              // 图片大小,单位：字节
    public int uWidth;                               // 图片宽度
    public int uHeight;                              // 图片高度
    public byte[] szFilePath = new byte[NetSDKLib.MAX_PATH_LEN];  // 文件路径
    public int nIndexInData;                         //在上传图片数据中的图片序号
    public byte[] byReserved = new byte[508];           // 保留
}

package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 全景广角图
public class SCENE_IMAGE_INFO_EX extends NetSDKLib.SdkStructure {
    public int nOffSet;                              // 在二进制数据块中的偏移
    public int nLength;                              // 图片大小,单位字节
    public int nWidth;                               // 图片宽度(像素)
    public int nHeight;                              // 图片高度(像素)
    public byte[] szFilePath = new byte[260];           // 全景图片路径
    public int nIndexInData;                         //在上传图片数据中的图片序号
    public byte[] szImageID = new byte[42];             //图片ID
    public byte[] szReserved = new byte[6];             //预留字节
    public NET_TIME_EX SnapTime = new NET_TIME_EX();         //抓拍时间，标准UTC时间（不带时区夏令时偏差），单位秒,参见结构体定义 {@link com.netsdk.lib.NetSDKLib.NET_TIME_EX}
    public byte[] byReserved = new byte[424];           // 预留字节
}

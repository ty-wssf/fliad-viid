package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 人脸全景图
public class FACE_SCENE_IMAGE extends NetSDKLib.SdkStructure {
    public int nOffSet;                              // 在二进制数据块中的偏移
    public int nLength;                              // 图片大小,单位字节
    public int nWidth;                               // 图片宽度(像素)
    public int nHeight;                              // 图片高度(像素)
    public int nIndexInData;                         //在上传图片数据中的图片序号
    public byte[] byReserved = new byte[52];            // 预留字节
}

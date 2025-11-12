package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;
import com.sun.jna.Pointer;

//物体对应图片文件信息,对应DH_PIC_INFO
public class NET_PIC_INFO extends NetSDKLib.SdkStructure {
    public int dwOffSet;                             // 文件在二进制数据块中的偏移位置,单位:字节
    public int dwFileLenth;                          // 文件大小,单位:字节
    public short wWidth;                               // 图片宽度,单位:像素
    public short wHeight;                              // 图片高度,单位:像素
    public Pointer pszFilePath;                          // 鉴于历史原因,该成员只在事件上报时有效， char *
    // 文件路径
    // 用户使用该字段时需要自行申请空间进行拷贝保存
    public byte bIsDetected;                          // 图片是否算法检测出来的检测过的提交识别服务器时,
    // 则不需要再时检测定位抠图,1:检测过的,0:没有检测过
    public byte[] bReserved = new byte[2];              // 预留字节数
    public byte byQulityScore;                        // 人脸抓拍质量分数, 0-100
    public int nFilePathLen;                         // 文件路径长度 既pszFilePath 用户申请的大小
    public NET_POINT stuPoint;                             // 小图左上角在大图的位置，使用绝对坐标系
    public int nIndexInData;                         // 在上传图片数据中的图片序号

    public NET_PIC_INFO() {
    }
}

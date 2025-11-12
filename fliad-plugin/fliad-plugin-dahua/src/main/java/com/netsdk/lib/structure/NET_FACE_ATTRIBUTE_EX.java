package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 人脸属性
public class NET_FACE_ATTRIBUTE_EX extends NetSDKLib.SdkStructure {
    public int emSex;                                // 性别,参考EM_SEX_TYPE
    public int nAge;                                 // 年龄,-1表示该字段数据无效
    public byte[] szReserved = new byte[4];             //
    public int emEye;                                // 眼睛状态，参考EM_EYE_STATE_TYPE
    public int emMouth;                              // 嘴巴状态，参考EM_MOUTH_STATE_TYPE
    public int emMask;                               // 口罩状态， 参考EM_MASK_STATE_TYPE
    public int emBeard;                              // 胡子状态， EM_BEARD_STATE_TYPE
    public int nAttractive;                          // 魅力值, 0未识别，识别时范围1-100,得分高魅力高
    public int emGlass;                              // 眼镜，参考EM_HAS_GLASS
    public int emEmotion;                            // 表情，参考EM_EMOTION_TYPE
    public DH_RECT stuBoundingBox;                       // 包围盒(8192坐标系)
    public byte[] byReserved1 = new byte[4];            // 保留
    public int emStrabismus;                         // 斜视状态，EM_STRABISMUS_TYPE
    public int[] nAngle = new int[3];                  //目标, 三个角度依次分别是, Pitch（仰俯角）, 指抬头低头的角度, 范围是-70~60; , yaw（偏航角）, 指左右转头的角度, 范围是-90~90; , Roll（翻滚角）, 指左右倾斜的角度, 范围是-90~90;, [180,180,180]表示未识别到角度
    public NET_POINT stuObjCenter = new NET_POINT();       //物体型心(不是包围盒中心), 0-8191相对坐标, 相对于大图,参见结构体定义 {@link com.netsdk.lib.NetSDKLib.NET_POINT}
    public int nComplexion;                          //0: 未识别 1: 黄色 2: 黑色 3: 白色
    public byte[] byReserved = new byte[44];            // 保留
}

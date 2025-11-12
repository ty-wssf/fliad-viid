package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 车辆物件
public class EVENT_COMM_ATTACHMENT extends NetSDKLib.SdkStructure {
    public int emAttachmentType;                     //物件类型, 取值为EM_COMM_ATTACHMENT_TYPE中的值
    public NET_RECT stuRect;                              //坐标
    public int nConf;                                //置信度
    public byte[] bReserved = new byte[16];             //预留字节
}

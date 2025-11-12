package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 违规状态
public class EVENT_COMM_STATUS extends NetSDKLib.SdkStructure {
    public byte bySmoking;                            //是否抽烟
    public byte byCalling;                            //是否打电话
    public byte[] szReserved = new byte[14];            //预留字段
}

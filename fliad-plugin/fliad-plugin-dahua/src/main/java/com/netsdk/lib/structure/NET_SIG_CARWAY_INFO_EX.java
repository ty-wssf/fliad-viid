package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 车检器冗余信息
public class NET_SIG_CARWAY_INFO_EX extends NetSDKLib.SdkStructure {
    public byte[] byRedundance = new byte[8];           //由车检器产生抓拍信号冗余信息
    public byte[] bReserved = new byte[120];            //保留字段
}

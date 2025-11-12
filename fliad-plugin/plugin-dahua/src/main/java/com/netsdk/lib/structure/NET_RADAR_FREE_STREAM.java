package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 雷达自由流信息
public class NET_RADAR_FREE_STREAM extends NetSDKLib.SdkStructure {
    public long nABSTime;                             // 1年1月1日0时起至今的毫秒数
    public int nVehicleID;                           // 车辆ID
    public int unOBUMAC;                             // OBU的MAC地址
}

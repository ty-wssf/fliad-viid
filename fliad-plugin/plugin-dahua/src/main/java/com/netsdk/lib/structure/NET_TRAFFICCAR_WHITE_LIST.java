package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 允许名单信息
public class NET_TRAFFICCAR_WHITE_LIST extends NetSDKLib.SdkStructure {
    public int bTrustCar;                            // 车牌是否属于允许名单
    public NET_TIME stuBeginTime;                         // 允许名单起始时间
    public NET_TIME stuCancelTime;                        // 允许名单过期时间
    public NET_WHITE_LIST_AUTHORITY_LIST stuAuthorityList;        // 允许名单权限列表
    public byte[] bReserved = new byte[32];             // 保留字节
}

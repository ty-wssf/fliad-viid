package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 允许名单权限列表
public class NET_WHITE_LIST_AUTHORITY_LIST extends NetSDKLib.SdkStructure {
    public int bOpenGate;                            // 是否有开闸权限
    public byte[] bReserved = new byte[16];             // 保留字节
}

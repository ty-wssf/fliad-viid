package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 事件扩展信息
public class NET_EXTENSION_INFO extends NetSDKLib.SdkStructure {
    public byte[] szEventID = new byte[NetSDKLib.MAX_EVENT_ID_LEN]; // 国标事件ID
    public byte[] byReserved = new byte[80];            // 保留字节
}

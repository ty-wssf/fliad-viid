package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 事件上报携带卡片信息
public class EVENT_CARD_INFO extends NetSDKLib.SdkStructure {
    public byte[] szCardNumber = new byte[NetSDKLib.NET_EVENT_CARD_LEN]; // 卡片序号字符串
    public byte[] bReserved = new byte[32];             // 保留字节,留待扩展.
}

package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 智能报警事件公共信息
public class EVENT_INTELLI_COMM_INFO extends NetSDKLib.SdkStructure {
    public int emClassType;                          // 智能事件所属大类， 取值为  EM_CLASS_TYPE 中的值
    public int nPresetID;                            // 该事件触发的预置点，对应该设置规则的预置点
    public byte[] bReserved = new byte[124];            // 保留字节,留待扩展.
}

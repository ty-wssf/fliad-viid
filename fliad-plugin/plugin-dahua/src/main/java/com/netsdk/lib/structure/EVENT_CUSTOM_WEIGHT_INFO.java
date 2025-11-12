package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

//称重信息
public class EVENT_CUSTOM_WEIGHT_INFO extends NetSDKLib.SdkStructure {
    public int dwRoughWeight;                        // 毛重,车辆满载货物重量。单位KG
    public int dwTareWeight;                         // 皮重,空车重量。单位KG
    public int dwNetWeight;                          // 净重,载货重量。单位KG
    public byte[] bReserved = new byte[28];             // 预留字节
}
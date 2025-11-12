package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

public class NET_NONMOTOR_FEATURE_VECTOR_INFO extends NetSDKLib.SdkStructure {
    public int nOffset;                              // 非机动车特征值在二进制数据中的偏移, 单位:字节
    public int nLength;                              // 非机动车特征值数据长度, 单位:字节
    public int bFeatureEnc;                          //用于标识特征值是否加密
    public byte[] byReserved = new byte[28];            // 保留
}

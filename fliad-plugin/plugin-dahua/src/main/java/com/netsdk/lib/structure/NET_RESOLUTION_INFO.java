package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 图片分辨率
public class NET_RESOLUTION_INFO extends NetSDKLib.SdkStructure {
    public short snWidth;                              //宽
    public short snHight;                              //高

    @Override
    public String toString() {
        return "NET_RESOLUTION_INFO{" +
                "宽=" + snWidth +
                ",高=" + snHight +
                '}';
    }
}

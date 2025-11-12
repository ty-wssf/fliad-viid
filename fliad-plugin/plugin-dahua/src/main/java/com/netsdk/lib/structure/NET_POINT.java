package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

//二维空间点
public class NET_POINT extends NetSDKLib.SdkStructure {
    public short nx;
    public short ny;

    @Override
    public String toString() {
        return "NET_POINT{" +
                "nx=" + nx +
                ", ny=" + ny +
                '}';
    }

    public NET_POINT() {
    }
}

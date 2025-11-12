package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 颜色RGBA
public class NET_COLOR_RGBA extends NetSDKLib.SdkStructure {
    public int nRed;                                 //红
    public int nGreen;                               //绿
    public int nBlue;                                //蓝
    public int nAlpha;                               //透明

    public String toString() {
        return "[" + nRed + " " + nGreen + " " + nBlue + " " + nAlpha + "]";
    }
}

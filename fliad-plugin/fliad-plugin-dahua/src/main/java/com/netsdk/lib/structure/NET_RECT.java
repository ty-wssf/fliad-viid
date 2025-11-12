package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

//区域；各边距按整长8192的比例
public class NET_RECT extends NetSDKLib.SdkStructure {
    public int left;
    public int top;
    public int right;
    public int bottom;

    public String toString() {
        return "[" + left + " " + top + " " + right + " " + bottom + "]";
    }
}

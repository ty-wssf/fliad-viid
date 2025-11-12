package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;
import com.sun.jna.NativeLong;

public class DH_RECT extends NetSDKLib.SdkStructure {
    public NativeLong left;
    public NativeLong top;
    public NativeLong right;
    public NativeLong bottom;
}

package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 禁止名单信息
public class NET_TRAFFICCAR_BLACK_LIST extends NetSDKLib.SdkStructure {
    /**
     * 是否已启用禁止名单
     */
    public int bEnable;
    /**
     * 车牌是否属于禁止名单
     */
    public int bIsBlackCar;
    /**
     * 禁止名单起始时间
     */
    public NET_TIME stuBeginTime = new NET_TIME();
    /**
     * 禁止名单过期时间
     */
    public NET_TIME stuCancelTime = new NET_TIME();
    /**
     * 布控类型 {@link com.netsdk.lib.enumeration.EM_NET_TRAFFIC_CAR_CONTROL_TYPE}
     */
    public int emControlType;
    /**
     * 布控路线ID
     */
    public int nControlledRouteID;
    /**
     * 保留字节
     */
    public byte[] bReserved = new byte[24];

    public NET_TRAFFICCAR_BLACK_LIST() {
    }
}

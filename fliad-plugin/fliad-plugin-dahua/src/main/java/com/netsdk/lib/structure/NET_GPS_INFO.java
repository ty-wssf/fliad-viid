package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// GPS信息
public class NET_GPS_INFO extends NetSDKLib.SdkStructure {
    public int nLongitude;                           // 经度(单位是百万分之一度)
    // 西经：0 - 180000000				实际值应为: 180*1000000 – dwLongitude
    // 东经：180000000 - 360000000		实际值应为: dwLongitude – 180*1000000
    // 如: 300168866应为（300168866 - 180*1000000）/1000000 即东经120.168866度
    public int nLatidude;                            // 纬度(单位是百万分之一度)
    // 南纬：0 - 90000000				实际值应为: 90*1000000 – dwLatidude
    // 北纬：90000000 – 180000000		实际值应为: dwLatidude – 90*1000000
    // 如: 120186268应为 (120186268 - 90*1000000)/1000000 即北纬30. 186268度
    public double dbAltitude;                           // 高度,单位为米
    public double dbSpeed;                              // 速度,单位km/H
    public double dbBearing;                            // 方向角,单位°
    public byte[] bReserved = new byte[8];              // 保留字段

    protected int getNativeAlignment(Class<?> type, Object value, boolean isFirstElement) {
        int alignment = super.getNativeAlignment(type, value, isFirstElement);
        return Math.min(4, alignment);
    }

    @Override
    public String toString() {
        return "NET_GPS_INFO{" +
                "nLongitude=" + nLongitude +
                ", nLatidude=" + nLatidude +
                ", dbAltitude=" + dbAltitude +
                ", dbSpeed=" + dbSpeed +
                ", dbBearing=" + dbBearing +
                '}';
    }
}
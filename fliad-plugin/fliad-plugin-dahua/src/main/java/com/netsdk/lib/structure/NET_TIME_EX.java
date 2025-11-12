package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

public class NET_TIME_EX extends NetSDKLib.SdkStructure {
    public int dwYear;                               // 年
    public int dwMonth;                              // 月
    public int dwDay;                                // 日
    public int dwHour;                               // 时
    public int dwMinute;                             // 分
    public int dwSecond;                             // 秒
    public int dwMillisecond;                        // 毫秒
    public int dwUTC;                                // utc时间(获取时0表示无效，非0有效   下发无效)
    public int[] dwReserved = new int[1];              // 保留字段

    public void setTime(int year, int month, int day, int hour, int minute, int second) {
        this.dwYear = year;
        this.dwMonth = month;
        this.dwDay = day;
        this.dwHour = hour;
        this.dwMinute = minute;
        this.dwSecond = second;
        this.dwMillisecond = 0;
    }

    public String toString() {
        return dwYear + "/" + dwMonth + "/" + dwDay + " " + dwHour + ":" + dwMinute + ":" + dwSecond;
    }

    public String toStringTime() {
        return String.format("%02d/%02d/%02d %02d:%02d:%02d", dwYear, dwMonth, dwDay, dwHour, dwMinute, dwSecond);
    }

    public String toStringTitle() {
        return String.format("Time_%02d%02d%02d_%02d%02d%02d", dwYear, dwMonth, dwDay, dwHour, dwMinute, dwSecond);
    }
}

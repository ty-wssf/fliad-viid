package com.fliad.hikvision.acl.alarm.handler;

import com.fliad.hikvision.acl.NetSDK.HCNetSDK;
import com.sun.jna.Pointer;

/**
 * 海康威视报警处理器接口
 */
public interface AlarmHandler {
    /**
     * 处理报警数据
     *
     * @param lCommand   报警类型
     * @param pAlarmer   报警设备信息
     * @param pAlarmInfo 报警信息
     * @param dwBufLen   报警信息缓存大小
     * @param pUser      用户数据
     */
    void handle(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser);
}
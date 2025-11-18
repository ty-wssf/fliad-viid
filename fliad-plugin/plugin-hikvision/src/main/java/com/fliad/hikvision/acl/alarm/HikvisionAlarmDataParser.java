package com.fliad.hikvision.acl.alarm;

import com.fliad.hikvision.acl.NetSDK.HCNetSDK;
import com.fliad.hikvision.acl.domain.DsWeather;
import com.fliad.hikvision.acl.alarm.handler.AlarmHandlerManager;
import com.sun.jna.Pointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 海康威视报警数据解析类
 */
public class HikvisionAlarmDataParser {

    static DsWeather dsWeather = new DsWeather();
    private static final Logger log = LoggerFactory.getLogger(HikvisionAlarmDataParser.class);

    /**
     * 解析报警数据
     *
     * @param lCommand   报警类型
     * @param pAlarmer   报警设备信息
     * @param pAlarmInfo 报警信息
     * @param dwBufLen   报警信息缓存大小
     * @param pUser      用户数据
     */
    public static void parseAlarmData(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser, HikvisionAlarmManager alarmManager) {
        AlarmHandlerManager handlerManager = new AlarmHandlerManager(alarmManager);
        handlerManager.handleAlarm(lCommand, pAlarmer, pAlarmInfo, dwBufLen, pUser);
    }

}
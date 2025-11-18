
package com.fliad.hikvision.acl.alarm;

import com.fliad.hikvision.acl.NetSDK.HCNetSDK;
import com.sun.jna.Pointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FMSGCallBack_V31 implements HCNetSDK.FMSGCallBack_V31 {

    private static final Logger log = LoggerFactory.getLogger(HikvisionAlarmCallback.class);

    private final HikvisionAlarmManager alarmManager;

    public FMSGCallBack_V31(HikvisionAlarmManager alarmManager) {
        this.alarmManager = alarmManager;
    }

    // 报警信息回调函数
    public boolean invoke(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser) {
        // 解析报警数据
        HikvisionAlarmDataParser.parseAlarmData(lCommand, pAlarmer, pAlarmInfo, dwBufLen, pUser, alarmManager);
        return true;
    }
}








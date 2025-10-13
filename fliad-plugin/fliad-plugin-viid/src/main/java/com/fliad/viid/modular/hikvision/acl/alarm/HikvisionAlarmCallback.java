package com.fliad.viid.modular.hikvision.acl.alarm;

import com.fliad.viid.modular.hikvision.acl.NetSDK.HCNetSDK;
import com.sun.jna.Pointer;
import lombok.extern.slf4j.Slf4j;

/**
 * 海康威视报警回调处理类
 */
@Slf4j
public class HikvisionAlarmCallback implements HCNetSDK.FMSGCallBack {
    
    private final HikvisionAlarmManager alarmManager;
    
    public HikvisionAlarmCallback(HikvisionAlarmManager alarmManager) {
        this.alarmManager = alarmManager;
    }
    
    /**
     * 报警信息回调函数
     * @param lCommand 报警类型
     * @param pAlarmer 报警设备信息
     * @param pAlarmInfo 报警信息
     * @param dwBufLen 报警信息缓存大小
     * @param pUser 用户数据
     */
    @Override
    public void invoke(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser) {
        try {
            // 解析报警数据
            HikvisionAlarmDataParser.parseAlarmData(lCommand, pAlarmer, pAlarmInfo, dwBufLen, pUser);
        } catch (Exception e) {
            log.error("处理报警信息异常", e);
        }
    }
}
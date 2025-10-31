package com.fliad.hikvision.modular.defense.acl.alarm.handler;

import com.fliad.hikvision.modular.defense.acl.NetSDK.HCNetSDK;
import com.sun.jna.Pointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 烟火检测报警处理器
 */
public class FireDetectionAlarmHandler implements AlarmHandler {
    private static final Logger log = LoggerFactory.getLogger(FireDetectionAlarmHandler.class);

    @Override
    public void handle(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser) {
        String sbip = "";
        try {
            sbip = new String(pAlarmer.sDeviceIP, "GBK").trim();
        } catch (Exception e) {
            log.error("获取设备IP失败", e);
        }
        log.info("设备IP: {}，报警类型: 烟火检测", sbip);
    }
}
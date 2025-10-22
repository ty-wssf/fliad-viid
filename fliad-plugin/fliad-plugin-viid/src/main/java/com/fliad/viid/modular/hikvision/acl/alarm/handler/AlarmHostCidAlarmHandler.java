package com.fliad.viid.modular.hikvision.acl.alarm.handler;

import com.fliad.viid.modular.hikvision.acl.NetSDK.HCNetSDK;
import com.sun.jna.Pointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报警主机CID报告报警处理器
 */
public class AlarmHostCidAlarmHandler implements AlarmHandler {
    private static final Logger log = LoggerFactory.getLogger(AlarmHostCidAlarmHandler.class);

    @Override
    public void handle(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser) {
        String sbip = "";
        try {
            sbip = new String(pAlarmer.sDeviceIP, "GBK").trim();
        } catch (Exception e) {
            log.error("获取设备IP失败", e);
        }
        log.info("设备IP: {}，报警类型: 报警主机CID报告", sbip);
    }
}
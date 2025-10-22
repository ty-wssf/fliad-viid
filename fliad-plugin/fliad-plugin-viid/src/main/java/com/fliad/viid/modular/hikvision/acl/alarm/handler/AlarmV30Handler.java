package com.fliad.viid.modular.hikvision.acl.alarm.handler;

import com.fliad.viid.modular.hikvision.acl.NetSDK.HCNetSDK;
import com.sun.jna.Pointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 移动侦测、视频丢失、遮挡、IO信号量等报警信息处理器
 */
public class AlarmV30Handler implements AlarmHandler {
    private static final Logger log = LoggerFactory.getLogger(AlarmV30Handler.class);

    @Override
    public void handle(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser) {
        String sbip = "";
        try {
            sbip = new String(pAlarmer.sDeviceIP, "GBK").trim();
        } catch (Exception e) {
            log.error("获取设备IP失败", e);
        }
        log.info("设备IP: {}，报警类型: 移动侦测/视频丢失/遮挡/IO信号量报警", sbip);
    }
}
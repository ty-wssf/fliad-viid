package com.fliad.viid.modular.hikvision.acl.alarm.handler;

import com.fliad.viid.modular.hikvision.acl.NetSDK.HCNetSDK;
import com.fliad.viid.modular.hikvision.acl.alarm.HikvisionAlarmManager;
import com.sun.jna.Pointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 海康威视报警处理器管理器
 */
public class AlarmHandlerManager {
    private static final Logger log = LoggerFactory.getLogger(AlarmHandlerManager.class);

    private final Map<Integer, AlarmHandler> handlers = new HashMap<>();
    private final HikvisionAlarmManager alarmManager;

    public AlarmHandlerManager(HikvisionAlarmManager alarmManager) {
        this.alarmManager = alarmManager;
        initHandlers();
    }

    private void initHandlers() {
        handlers.put(HCNetSDK.COMM_ITS_PLATE_RESULT, new ItsPlateResultHandler());
        handlers.put(HCNetSDK.COMM_ALARM_AID_V41, new AidAlarmV41Handler());
        handlers.put(HCNetSDK.COMM_ALARM_TPS_V41, new TpsAlarmV41Handler());
        handlers.put(HCNetSDK.COMM_ISAPI_ALARM, new IsapiAlarmHandler());
        handlers.put(HCNetSDK.COMM_VCA_ALARM, new VcaAlarmHandler());
        handlers.put(HCNetSDK.COMM_ALARMHOST_CID_ALARM, new AlarmHostCidAlarmHandler());
        handlers.put(HCNetSDK.COMM_IPC_AUXALARM_RESULT, new IpcAuxAlarmResultHandler());
        handlers.put(HCNetSDK.COMM_ALARM_V30, new AlarmV30Handler());
        handlers.put(HCNetSDK.COMM_ALARM_V40, new AlarmV40Handler());
        handlers.put(HCNetSDK.COMM_THERMOMETRY_ALARM, new ThermometryAlarmHandler());
        handlers.put(HCNetSDK.COMM_THERMOMETRY_DIFF_ALARM, new ThermometryDiffAlarmHandler());
        handlers.put(HCNetSDK.COMM_UPLOAD_AIOP_PICTURE, new AiopPictureUploadHandler());
        handlers.put(HCNetSDK.COMM_FIREDETECTION_ALARM, new FireDetectionAlarmHandler());
        handlers.put(HCNetSDK.COMM_ALARMHOST_DATA_UPLOAD, new AlarmHostDataUploadHandler(alarmManager));
        handlers.put(HCNetSDK.COMM_ALARM_TPS_STATISTICS, new TpsStatisticsAlarmHandler());
        handlers.put(HCNetSDK.COMM_ALARM_TPS_REAL_TIME, new TpsRealTimeAlarmHandler());
    }

    public void handleAlarm(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser) {
        String sbip = "";
        try {
            sbip = new String(pAlarmer.sDeviceIP, "GBK").trim();
        } catch (Exception e) {
            log.error("获取设备IP失败", e);
        }
        alarmManager.getDeviceStateManager().handleOnlineEvent("hikvision", alarmManager.getDeviceByIp(sbip).getDeviceId());
        AlarmHandler handler = handlers.get(lCommand);
        if (handler != null) {
            handler.handle(lCommand, pAlarmer, pAlarmInfo, dwBufLen, pUser);
        } else {
            log.warn("设备IP: {}，未知的报警类型: 0x{}", sbip, Integer.toHexString(lCommand));
        }
    }
}
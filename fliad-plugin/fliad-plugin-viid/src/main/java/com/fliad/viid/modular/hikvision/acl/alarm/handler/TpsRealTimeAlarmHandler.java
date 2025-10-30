package com.fliad.viid.modular.hikvision.acl.alarm.handler;

import com.fliad.viid.modular.hikvision.acl.NetSDK.HCNetSDK;
import com.sun.jna.Pointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TPS实时过车数据处理器
 * 处理COMM_ALARM_TPS_REAL_TIME类型的报警数据
 */
public class TpsRealTimeAlarmHandler implements AlarmHandler {
    private static final Logger log = LoggerFactory.getLogger(TpsRealTimeAlarmHandler.class);

    @Override
    public void handle(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser) {
        String sbip = "";
        try {
            sbip = new String(pAlarmer.sDeviceIP, "GBK").trim();
        } catch (Exception e) {
            log.error("获取设备IP失败", e);
        }

        // 解析TPS实时过车数据
        HCNetSDK.NET_DVR_TPS_REAL_TIME_INFO netDvrTpsRealTimeInfo = new HCNetSDK.NET_DVR_TPS_REAL_TIME_INFO();
        netDvrTpsRealTimeInfo.write();
        Pointer pTpsRealTime = netDvrTpsRealTimeInfo.getPointer();
        pTpsRealTime.write(0, pAlarmInfo.getByteArray(0, netDvrTpsRealTimeInfo.size()), 0, netDvrTpsRealTimeInfo.size());
        netDvrTpsRealTimeInfo.read();

        int channel = netDvrTpsRealTimeInfo.dwChan; // 触发报警通道号

        // 检测时间
        String detectTime = "" + String.format("%04d", netDvrTpsRealTimeInfo.struTime.wYear) +
                String.format("%02d", netDvrTpsRealTimeInfo.struTime.byMonth) +
                String.format("%02d", netDvrTpsRealTimeInfo.struTime.byDay) +
                String.format("%02d", netDvrTpsRealTimeInfo.struTime.byHour) +
                String.format("%02d", netDvrTpsRealTimeInfo.struTime.byMinute) +
                String.format("%02d", netDvrTpsRealTimeInfo.struTime.bySecond);

        // 获取交通参数信息
        HCNetSDK.NET_DVR_TPS_PARAM tpsParam = netDvrTpsRealTimeInfo.struTPSRealTimeInfo;

        byte lane = tpsParam.byLane; // 对应车道号
        byte speed = tpsParam.bySpeed; // 对应车速（KM/H）
        byte laneState = tpsParam.byLaneState; // 车道状态；0-无状态，1-畅通，2-拥挤，3-堵塞
        int downwardFlow = tpsParam.dwDownwardFlow; // 当前车道 从上到下车流量
        int upwardFlow = tpsParam.dwUpwardFlow; // 当前车道 从下到上车流量
        short spaceHeadway = tpsParam.wSpaceHeadway; // 车头间距，以米来计算
        short timeHeadway = tpsParam.wTimeHeadway; // 车头时距，以秒计算

        String laneStateStr = "";
        switch (laneState) {
            case 0:
                laneStateStr = "无状态";
                break;
            case 1:
                laneStateStr = "畅通";
                break;
            case 2:
                laneStateStr = "拥挤";
                break;
            case 3:
                laneStateStr = "堵塞";
                break;
            default:
                laneStateStr = "未知状态";
                break;
        }

        log.info("设备IP: {}，报警类型: TPS实时过车数据，通道号: {}，检测时间: {}，车道号: {}，车速: {}KM/H，车道状态: {}，" +
                        "从上到下车流量: {}，从下到上车流量: {}，车头间距: {}米，车头时距: {}秒",
                sbip, channel, detectTime, lane, speed, laneStateStr, downwardFlow, upwardFlow, spaceHeadway, timeHeadway);

        // TODO: 这里应该将数据保存到数据库或发送到其他系统
        // 例如：tpsRealTimeInfoService.save(tpsRealTimeInfo);
    }
}
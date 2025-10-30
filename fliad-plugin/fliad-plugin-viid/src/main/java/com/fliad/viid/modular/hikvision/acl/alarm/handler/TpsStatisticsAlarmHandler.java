package com.fliad.viid.modular.hikvision.acl.alarm.handler;

import com.fliad.viid.modular.hikvision.acl.NetSDK.HCNetSDK;
import com.fliad.viid.modular.hikvision.acl.domain.TrafficFlowInfo;
import com.sun.jna.Pointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 交通参数统计信息处理器
 * 处理COMM_ALARM_TPS_STATISTICS类型的报警数据
 */
public class TpsStatisticsAlarmHandler implements AlarmHandler {
    private static final Logger log = LoggerFactory.getLogger(TpsStatisticsAlarmHandler.class);

    @Override
    public void handle(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser) {
        String sbip = "";
        try {
            sbip = new String(pAlarmer.sDeviceIP, "GBK").trim();
        } catch (Exception e) {
            log.error("获取设备IP失败", e);
        }
        
        // 解析交通参数统计信息
        HCNetSDK.NET_DVR_TPS_STATISTICS_INFO netDvrTpsStatisticsInfo = new HCNetSDK.NET_DVR_TPS_STATISTICS_INFO();
        netDvrTpsStatisticsInfo.write();
        Pointer pTpsVehicle = netDvrTpsStatisticsInfo.getPointer();
        pTpsVehicle.write(0, pAlarmInfo.getByteArray(0, netDvrTpsStatisticsInfo.size()), 0, netDvrTpsStatisticsInfo.size());
        netDvrTpsStatisticsInfo.read();
        
        int channel = netDvrTpsStatisticsInfo.dwChan; // 触发报警通道号
        
        // 统计开始时间
        String startTime = "" + String.format("%04d", netDvrTpsStatisticsInfo.struTPSStatisticsInfo.struStartTime.wYear) +
                String.format("%02d", netDvrTpsStatisticsInfo.struTPSStatisticsInfo.struStartTime.byMonth) +
                String.format("%02d", netDvrTpsStatisticsInfo.struTPSStatisticsInfo.struStartTime.byDay) +
                String.format("%02d", netDvrTpsStatisticsInfo.struTPSStatisticsInfo.struStartTime.byHour) +
                String.format("%02d", netDvrTpsStatisticsInfo.struTPSStatisticsInfo.struStartTime.byMinute) +
                String.format("%02d", netDvrTpsStatisticsInfo.struTPSStatisticsInfo.struStartTime.bySecond);
        
        // 统计时间（单位秒）
        int samplePeriod = netDvrTpsStatisticsInfo.struTPSStatisticsInfo.dwSamplePeriod;
        
        // 有效车道总数
        int totalLaneNum = netDvrTpsStatisticsInfo.struTPSStatisticsInfo.byTotalLaneNum;
        
        log.info("设备IP: {}，报警类型: 交通参数统计信息，通道号: {}，统计开始时间: {}，统计周期: {}秒，有效车道数: {}", 
                sbip, channel, startTime, samplePeriod, totalLaneNum);
        
        // 记录每个车道的统计信息
        for (int i = 0; i < totalLaneNum && i < netDvrTpsStatisticsInfo.struTPSStatisticsInfo.struLaneParam.length; i++) {
            HCNetSDK.NET_DVR_TPS_LANE_PARAM laneParam = netDvrTpsStatisticsInfo.struTPSStatisticsInfo.struLaneParam[i];
            
            // 创建交通流量信息对象
            TrafficFlowInfo trafficFlowInfo = new TrafficFlowInfo();
            trafficFlowInfo.setLsh(UUID.randomUUID().toString().replace("-", ""));
            trafficFlowInfo.setSbbh(sbip);
            trafficFlowInfo.setCdh(laneParam.byLane); // 车道号
            
            // 设置统计时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            try {
                Date tjsd = sdf.parse(startTime);
                trafficFlowInfo.setTjsd(tjsd);
            } catch (ParseException e) {
                log.error("解析统计开始时间失败: {}", startTime, e);
                trafficFlowInfo.setTjsd(new Date()); // 使用当前时间作为备选
            }
            
            // 设置统计周期数
            trafficFlowInfo.setTjzqs(String.valueOf(samplePeriod));
            
            // 设置车辆数
            int lightVehicle = laneParam.dwLightVehicle; // 小型车数量
            int midVehicle = laneParam.dwMidVehicle; // 中型车数量
            int heavyVehicle = laneParam.dwHeavyVehicle; // 重型车数量
            int totalVehicle = lightVehicle + midVehicle + heavyVehicle; // 通行车辆总数
            
            trafficFlowInfo.setTxcls(totalVehicle); // 通行车辆数
            trafficFlowInfo.setDcs(heavyVehicle); // 大车数
            trafficFlowInfo.setXcs(lightVehicle); // 小车数
            trafficFlowInfo.setZxcs(midVehicle); // 中型车数
            trafficFlowInfo.setMtcsl(0); // 摩托车数量，默认为0
            trafficFlowInfo.setCccsl(0); // 超长车数量，默认为0
            
            // 设置平均速度
            trafficFlowInfo.setPjsd((double) laneParam.bySpeed);
            
            // 设置平均车长
            trafficFlowInfo.setPjcc(0.0D);
            
            // 设置时间占有率和空间占有率
            trafficFlowInfo.setSjzyl(laneParam.fTimeOccupyRation / 1000.0f);
            trafficFlowInfo.setKjzyl(laneParam.fSpaceOccupyRation / 1000.0f);
            
            // 设置平均车头时距和平均车头间距
            trafficFlowInfo.setPjctsj(laneParam.dwTimeHeadway);
            trafficFlowInfo.setPjctjj(laneParam.dwSpaceHeadway);
            
            // 设置车辆密度
            trafficFlowInfo.setClmd(totalVehicle);
            
            // 设置超速车辆和低速车辆
            trafficFlowInfo.setCscl(0);
            trafficFlowInfo.setDscl(0);
            
            // 设置平均排队长度
            // trafficFlowInfo.setPjpdcd((double) laneParam.byQueueLen);
            
            // 设置时间
            trafficFlowInfo.setJrsj(new Date());
            trafficFlowInfo.setFssj(new Date());
            trafficFlowInfo.setRksj(new Date());
            
            log.info("车道{}统计信息 - 平均速度:{}km/h, 小型车:{}, 中型车:{}, 重型车:{}, 车头时距:{}s, 车头间距:{}m, 空间占有率:{}%, 时间占有率:{}%", 
                    laneParam.byLane, laneParam.bySpeed, lightVehicle, midVehicle, heavyVehicle, 
                    laneParam.dwTimeHeadway, laneParam.dwSpaceHeadway, 
                    laneParam.fSpaceOccupyRation / 1000.0f, laneParam.fTimeOccupyRation / 1000.0f);
            
            // TODO: 这里应该将 trafficFlowInfo 对象保存到数据库或发送到其他系统
            // 例如：trafficFlowInfoService.save(trafficFlowInfo);
        }
    }
}
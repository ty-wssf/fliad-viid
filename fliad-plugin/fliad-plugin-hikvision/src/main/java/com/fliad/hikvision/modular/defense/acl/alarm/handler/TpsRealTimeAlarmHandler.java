package com.fliad.hikvision.modular.defense.acl.alarm.handler;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import com.fliad.hikvision.modular.defense.acl.NetSDK.HCNetSDK;
import com.fliad.hikvision.modular.defense.acl.alarm.HikvisionAlarmManager;
import com.fliad.resource.modular.flowgram.domain.TaskRunInput;
import com.fliad.resource.modular.workflow.entity.ResourceWorkflow;
import com.sun.jna.Pointer;
import org.noear.snack.ONode;
import org.noear.snack.core.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * TPS实时过车数据处理器
 * 处理COMM_ALARM_TPS_REAL_TIME类型的报警数据
 */
public class TpsRealTimeAlarmHandler implements AlarmHandler {
    private static final Logger log = LoggerFactory.getLogger(TpsRealTimeAlarmHandler.class);

    private final HikvisionAlarmManager alarmManager;

    public TpsRealTimeAlarmHandler(HikvisionAlarmManager alarmManager) {
        this.alarmManager = alarmManager;
    }

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

        // 构建排除byRes1字段的NET_DVR_TPS_PARAM结构体JSON
        // 使用snack框架序列化数据
        Options options = Options.def();
        options.addEncoder(Date.class, (data, node) -> {
            node.val().setString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data));
        });

        // TPS参数详细信息
        java.util.Map<String, Object> tpsParamDetail = new java.util.HashMap<>();
        tpsParamDetail.put("byStart", tpsParam.byStart);
        tpsParamDetail.put("byCMD", tpsParam.byCMD);
        tpsParamDetail.put("wSpaceHeadway", tpsParam.wSpaceHeadway);
        tpsParamDetail.put("wDeviceID", tpsParam.wDeviceID);
        tpsParamDetail.put("wDataLen", tpsParam.wDataLen);
        tpsParamDetail.put("byLane", tpsParam.byLane);
        tpsParamDetail.put("bySpeed", tpsParam.bySpeed);
        tpsParamDetail.put("byLaneState", tpsParam.byLaneState);
        tpsParamDetail.put("byQueueLen", tpsParam.byQueueLen);
        tpsParamDetail.put("wLoopState", tpsParam.wLoopState);
        tpsParamDetail.put("wStateMask", tpsParam.wStateMask);
        tpsParamDetail.put("dwDownwardFlow", tpsParam.dwDownwardFlow);
        tpsParamDetail.put("dwUpwardFlow", tpsParam.dwUpwardFlow);
        tpsParamDetail.put("byJamLevel", tpsParam.byJamLevel);
        tpsParamDetail.put("byVehicleDirection", tpsParam.byVehicleDirection);
        tpsParamDetail.put("byJamFlow", tpsParam.byJamFlow);
        tpsParamDetail.put("byChannelizationLane", tpsParam.byChannelizationLane);
        tpsParamDetail.put("byVehicleType", tpsParam.byVehicleType);
        tpsParamDetail.put("wTimeHeadway", tpsParam.wTimeHeadway);
        tpsParamDetail.put("sbxh", alarmManager.getDeviceByIp(sbip).getDeviceNumber());
        tpsParamDetail.put("detectTime", "detectTime");

        log.info("TPS实时过车数据：{}",  ONode.stringify(tpsParamDetail, options));
        // 将数据交给流程处理
        try {
            List<ResourceWorkflow> workflowList = alarmManager.getViidWorkflowService().findBySubscribeDetail("105");
            for (ResourceWorkflow workflow : workflowList) {
                TaskRunInput taskRunInput = new TaskRunInput();
                taskRunInput.setSchema(workflow.getContent());
                taskRunInput.setInputs(MapUtil.of("inputs", ONode.stringify(tpsParamDetail, options)));
                alarmManager.getFlowgramService().taskRun(false, taskRunInput, IdUtil.getSnowflakeNextIdStr());
            }
        } catch (Exception e) {
            log.error("处理TPS实时过车数据流程时发生异常", e);
        }
        // TODO: 这里应该将数据保存到数据库或发送到其他系统
        // 例如：tpsRealTimeInfoService.save(tpsRealTimeInfo);
    }
}
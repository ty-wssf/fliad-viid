package com.netsdk.alarm;

import com.netsdk.lib.NetSDKLib;
import com.netsdk.lib.structure.DEV_EVENT_TRAFFICJUNCTION_INFO;
import com.sun.jna.Pointer;
import org.noear.snack.ONode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * 大华设备智能分析数据回调处理类
 */
public class DahuaAnalyzerDataCallBack implements NetSDKLib.fAnalyzerDataCallBack {
    private static final Logger log = LoggerFactory.getLogger(DahuaAnalyzerDataCallBack.class);

    private final DahuaAlarmManager dahuaAlarmManager;

    public DahuaAnalyzerDataCallBack(DahuaAlarmManager dahuaAlarmManager) {
        this.dahuaAlarmManager = dahuaAlarmManager;
    }

    @Override
    public int invoke(NetSDKLib.LLong lAnalyzerHandle, int dwAlarmType, Pointer pAlarmInfo, Pointer pBuffer, int dwBufSize, Pointer dwUser, int nSequence, Pointer reserved) throws UnsupportedEncodingException {
        try {
            log.info("收到智能分析事件，报警类型: 0x{}", Integer.toHexString(dwAlarmType));

            // 根据不同的报警类型进行处理
            switch (dwAlarmType) {
                case NetSDKLib.EVENT_IVS_ALL:
                    log.info("所有事件");
                    break;
                case NetSDKLib.EVENT_IVS_TRAFFICJUNCTION:
                    log.info("交通路口事件");
                    DEV_EVENT_TRAFFICJUNCTION_INFO msg = new DEV_EVENT_TRAFFICJUNCTION_INFO();
                    ToolKits.GetPointerData(pAlarmInfo, msg);

                    ONode trafficInfo = new ONode().asObject();
                    try {
                        trafficInfo.set("m_PlateNumber", new String(msg.stuObject.szText, "GBK").trim());
                    } catch (UnsupportedEncodingException e) {
                        log.error("解析交通路口事件号牌号码异常", e);
                    }
                    trafficInfo.set("m_PlateType", new String(msg.stTrafficCar.szPlateType).trim());
                    trafficInfo.set("m_FileCount", String.valueOf(msg.stuFileInfo.bCount));
                    trafficInfo.set("m_FileIndex", String.valueOf(msg.stuFileInfo.bIndex));
                    trafficInfo.set("m_GroupID", String.valueOf(msg.stuFileInfo.nGroupId));
                    trafficInfo.set("m_IllegalPlace", ToolKits.GetPointerDataToByteArr(msg.stTrafficCar.szDeviceAddress));
                    trafficInfo.set("m_LaneNumber", String.valueOf(msg.nLane));
                    trafficInfo.set("m_PlateColor", new String(msg.stTrafficCar.szPlateColor).trim());
                    trafficInfo.set("m_VehicleColor", new String(msg.stTrafficCar.szVehicleColor).trim());
                    trafficInfo.set("m_VehicleType", new String(msg.stuVehicle.szObjectSubType).trim());
                    trafficInfo.set("m_Utc", msg.UTC.toStringTime());
                    trafficInfo.set("m_bPicEnble", msg.stuObject.bPicEnble);
                    trafficInfo.set("m_OffSet", msg.stuObject.stPicInfo.dwOffSet);
                    trafficInfo.set("m_FileLength", msg.stuObject.stPicInfo.dwFileLenth);
                    // trafficInfo.set("m_BoundingBox", msg.stuObject.BoundingBox);
                    trafficInfo.set("nNumOfCycling", msg.stuNonMotor.nNumOfCycling);
                    log.info("交通路口事件解析结果: {}", trafficInfo);
                    break;
                default:
                    log.info("其他智能分析事件类型: 0x{}", Integer.toHexString(dwAlarmType));
                    break;
            }

            // 这里可以添加具体的智能分析事件处理逻辑
            // 例如解析pAlarmInfo中的事件详细信息

        } catch (Exception e) {
            log.error("处理智能分析事件数据异常", e);
        }
        return 0;
    }
}
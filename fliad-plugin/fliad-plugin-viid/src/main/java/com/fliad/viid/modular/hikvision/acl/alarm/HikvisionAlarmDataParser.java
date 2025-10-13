package com.fliad.viid.modular.hikvision.acl.alarm;

import com.fliad.viid.modular.hikvision.acl.NetSDK.HCNetSDK;
import com.fliad.viid.modular.hikvision.acl.CommonMethod.CommonUtil;
import com.sun.jna.Pointer;
import lombok.extern.slf4j.Slf4j;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 海康威视报警数据解析类
 */
@Slf4j
public class HikvisionAlarmDataParser {
    
    /**
     * 解析报警数据
     * @param lCommand 报警类型
     * @param pAlarmer 报警设备信息
     * @param pAlarmInfo 报警信息
     * @param dwBufLen 报警信息缓存大小
     * @param pUser 用户数据
     */
    public static void parseAlarmData(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser) {
        String sbip = "";
        try {
            sbip = new String(pAlarmer.sDeviceIP, "GBK").trim();
        } catch (Exception e) {
            log.error("获取设备IP失败", e);
        }
        
        log.info("收到报警事件，设备IP: {}，类型: 0x{}", sbip, Integer.toHexString(lCommand));
        
        // 根据报警类型解析数据
        switch (lCommand) {
            case HCNetSDK.COMM_ITS_PLATE_RESULT: // 交通抓拍结果(新报警信息)
                log.info("设备IP: {}，报警类型: 交通抓拍结果", sbip);
                break;
                
            case HCNetSDK.COMM_ALARM_AID_V41: // 道路事件检测
                log.info("设备IP: {}，报警类型: 道路事件检测", sbip);
                break;
                
            case HCNetSDK.COMM_ALARM_TPS_V41: // 交通数据统计的报警
                log.info("设备IP: {}，报警类型: 交通数据统计", sbip);
                break;
                
            case HCNetSDK.COMM_ISAPI_ALARM: // ISAPI协议报警信息
                log.info("设备IP: {}，报警类型: ISAPI协议报警信息", sbip);
                break;
                
            case HCNetSDK.COMM_VCA_ALARM: // 智能检测通用报警(Json或者XML数据结构)
                log.info("设备IP: {}，报警类型: 智能检测通用报警", sbip);
                break;
                
            case HCNetSDK.COMM_ALARMHOST_CID_ALARM: // 报警主机CID报告报警上传
                log.info("设备IP: {}，报警类型: 报警主机CID报告", sbip);
                break;
                
            case HCNetSDK.COMM_IPC_AUXALARM_RESULT: // PIR报警、无线报警、呼救报警信息
                log.info("设备IP: {}，报警类型: PIR/无线/呼救报警", sbip);
                break;
                
            case HCNetSDK.COMM_ALARM_V30: // 移动侦测、视频丢失、遮挡、IO信号量等报警信息
                log.info("设备IP: {}，报警类型: 移动侦测/视频丢失/遮挡/IO信号量报警", sbip);
                break;
                
            case HCNetSDK.COMM_ALARM_V40: // 移动侦测、视频丢失、遮挡、IO信号量等报警信息，报警数据为可变长
                log.info("设备IP: {}，报警类型: 移动侦测/视频丢失/遮挡/IO信号量报警(V40)", sbip);
                break;
                
            case HCNetSDK.COMM_THERMOMETRY_ALARM: // 温度报警信息
                log.info("设备IP: {}，报警类型: 温度报警", sbip);
                break;
                
            case HCNetSDK.COMM_THERMOMETRY_DIFF_ALARM: // 温差检测报警
                log.info("设备IP: {}，报警类型: 温差检测报警", sbip);
                break;
                
            case HCNetSDK.COMM_UPLOAD_AIOP_PICTURE: // AI开放平台接入图片检测报警信息
                log.info("设备IP: {}，报警类型: AI开放平台图片检测报警", sbip);
                break;
                
            case HCNetSDK.COMM_FIREDETECTION_ALARM: // 烟火检测
                log.info("设备IP: {}，报警类型: 烟火检测", sbip);
                break;
                
            default:
                log.warn("设备IP: {}，未知的报警类型: 0x{}", sbip, Integer.toHexString(lCommand));
                break;
        }
    }
}
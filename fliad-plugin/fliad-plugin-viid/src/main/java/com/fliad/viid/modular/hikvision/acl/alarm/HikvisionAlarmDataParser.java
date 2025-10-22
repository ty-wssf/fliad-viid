package com.fliad.viid.modular.hikvision.acl.alarm;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import com.fliad.viid.modular.flowgram.domain.TaskRunInput;
import com.fliad.viid.modular.flowgram.service.FlowgramService;
import com.fliad.viid.modular.hikvision.acl.NetSDK.HCNetSDK;
import com.fliad.viid.modular.hikvision.acl.CommonMethod.CommonUtil;
import com.fliad.viid.modular.hikvision.acl.domain.DsWeather;
import com.fliad.viid.modular.hikvision.acl.alarm.handler.AlarmHandlerManager;
import com.fliad.viid.modular.workflow.entity.ViidWorkflow;
import com.sun.jna.Pointer;
import org.noear.snack.ONode;
import org.noear.snack.core.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 海康威视报警数据解析类
 */
public class HikvisionAlarmDataParser {

    static DsWeather dsWeather = new DsWeather();
    private static final Logger log = LoggerFactory.getLogger(HikvisionAlarmDataParser.class);

    /**
     * 解析报警数据
     *
     * @param lCommand   报警类型
     * @param pAlarmer   报警设备信息
     * @param pAlarmInfo 报警信息
     * @param dwBufLen   报警信息缓存大小
     * @param pUser      用户数据
     */
    public static void parseAlarmData(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser, HikvisionAlarmManager alarmManager) {
        AlarmHandlerManager handlerManager = new AlarmHandlerManager(alarmManager);
        handlerManager.handleAlarm(lCommand, pAlarmer, pAlarmInfo, dwBufLen, pUser);
    }

}
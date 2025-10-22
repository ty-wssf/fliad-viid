package com.fliad.viid.modular.hikvision.acl.alarm.handler;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import com.fliad.viid.modular.flowgram.domain.TaskRunInput;
import com.fliad.viid.modular.flowgram.service.FlowgramService;
import com.fliad.viid.modular.hikvision.acl.NetSDK.HCNetSDK;
import com.fliad.viid.modular.hikvision.acl.alarm.HikvisionAlarmManager;
import com.fliad.viid.modular.hikvision.acl.alarm.HikvisionDevice;
import com.fliad.viid.modular.hikvision.acl.domain.DsWeather;
import com.fliad.viid.modular.workflow.entity.ViidWorkflow;
import com.sun.jna.Pointer;
import org.noear.snack.ONode;
import org.noear.snack.core.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 报警主机数据上传处理器
 */
public class AlarmHostDataUploadHandler implements AlarmHandler {
    private static final Logger log = LoggerFactory.getLogger(AlarmHostDataUploadHandler.class);
    
    private final HikvisionAlarmManager alarmManager;
    
    public AlarmHostDataUploadHandler(HikvisionAlarmManager alarmManager) {
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
        
        log.info("设备IP: {}，报警类型: 报警", sbip);
        
        HCNetSDK.NET_DVR_ALARMHOST_DATA_UPLOAD struDVRala = new HCNetSDK.NET_DVR_ALARMHOST_DATA_UPLOAD();
        struDVRala.write();
        Pointer alaPointer = struDVRala.getPointer();
        alaPointer.write(0, pAlarmInfo.getByteArray(0, struDVRala.size()), 0, struDVRala.size());
        struDVRala.read();
        struDVRala.struAlarmData.setType(HCNetSDK.NET_DVR_ALARMHOST_POINT_VALUE.class);
        struDVRala.read();

        int dwChanNo = struDVRala.struAlarmData.struPointValue.dwChanNo;
        int dwVariableNo = struDVRala.struAlarmData.struPointValue.dwVariableNo;
        long dwVariableValue = combineHighLowBits(struDVRala.struAlarmData.struPointValue.iValueEx, struDVRala.struAlarmData.struPointValue.iValue);
        // 存在负数，单独处理
        if (struDVRala.struAlarmData.struPointValue.iValueEx == 0 && struDVRala.struAlarmData.struPointValue.iValue < 0) {
            dwVariableValue = struDVRala.struAlarmData.struPointValue.iValue;
        }

        log.info("========接入类型=======" + struDVRala.struAlarmData.struPointValue.byChanType);
        log.info("========点类型=======" + struDVRala.struAlarmData.struPointValue.byPointType);
        log.info("========485通道号=======" + struDVRala.struAlarmData.struPointValue.dwChanNo);
        log.info("========槽位号=======" + struDVRala.struAlarmData.struPointValue.dwSubChanNo);
        log.info("========变量编号=======" + struDVRala.struAlarmData.struPointValue.dwVariableNo);
        log.info("========点号=======" + struDVRala.struAlarmData.struPointValue.dwPointNo);
        log.info("========监测点的值，表示低32位=======" + struDVRala.struAlarmData.struPointValue.iValue);
        log.info("========监测点的值，表示高32位=======" + struDVRala.struAlarmData.struPointValue.iValueEx);

        HikvisionDevice device = alarmManager.getDeviceByIp(sbip);

        DsWeather dsWeather = new DsWeather();
        dsWeather.setSbxh(device.getDeviceNumber());
        dsWeather.setSbbh(device.getDeviceNumber());

        // 使用BigDecimal处理数值，保留3位小数
        BigDecimal value = new BigDecimal(dwVariableValue);
        BigDecimal divisor1000 = new BigDecimal(1000);
        String valueStr = value.divide(divisor1000, 3, RoundingMode.HALF_UP).toString();

        if (dwChanNo == 1) {
            if (dwVariableNo == 1) {
                // valueStr
                dsWeather.setNjd(valueStr);
                dsWeather.setNjdpjz(valueStr);
                dsWeather.setNjdssz(valueStr);
            }
        } else if (dwChanNo == 2) {
            if (dwVariableNo == 1) {
                // 路面温度
                dsWeather.setLmwd(valueStr);
            } else if (dwVariableNo == 2) {
                // 水膜厚度
                dsWeather.setSmhd(valueStr);
            } else if (dwVariableNo == 3) {
                // 冰厚度
                dsWeather.setBhd(valueStr);
            } else if (dwVariableNo == 4) {
                // 雪厚度
                dsWeather.setXshd(valueStr);
            } else if (dwVariableNo == 5) {
                // 湿滑系数
                dsWeather.setShxs(valueStr);
            } else if (dwVariableNo == 6) {
                // 路面状态
                dsWeather.setLmzk(valueStr);
            }
        } else if (dwChanNo == 3) {
            if (dwVariableNo == 1) {
                // 空气温度
                dsWeather.setWdu(valueStr);
                dsWeather.setHjwd(valueStr);
            } else if (dwVariableNo == 2) {
                // 空气湿度
                dsWeather.setHjsd(valueStr);
            } else if (dwVariableNo == 3) {
                // 风速
                dsWeather.setFs(valueStr);
                dsWeather.setFspjz(valueStr);
                dsWeather.setFsssz(valueStr);
            } else if (dwVariableNo == 4) {
                // 风向
                dsWeather.setSjfx(valueStr);
                dsWeather.setXdfx(valueStr);
            } else if (dwVariableNo == 8) {
                // 大气压力
                dsWeather.setQy(valueStr);
            } else if (dwVariableNo == 11) {
                // 降雨量
                dsWeather.setJyl(valueStr);
            }
        }
        dsWeather.setLsh(IdUtil.simpleUUID());
        dsWeather.setAcceptTime(new Date());

        List<ViidWorkflow> workflowList = alarmManager.getViidWorkflowService().findBySubscribeDetail("103");

        // 配置ONode日期格式
        Options options = Options.def();
        options.addEncoder(Date.class, (data, node) -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            node.val().setString(sdf.format(data));
        });
        log.info("气象数据：{}", ONode.stringify(dsWeather, options));
        for (ViidWorkflow workflow : workflowList) {
            TaskRunInput taskRunInput = new TaskRunInput();
            taskRunInput.setSchema(workflow.getContent());
            taskRunInput.setInputs(MapUtil.of("inputs", ONode.stringify(dsWeather, options)));
            alarmManager.getFlowgramService().taskRun(false, taskRunInput, IdUtil.getSnowflakeNextIdStr());
        }
    }
    
    public static long combineHighLowBits(int high32bits, int low32bits) {
        // 将高32位左移32位，然后与低32位进行或操作
        return ((long) high32bits << 32) | (low32bits & 0xFFFFFFFFL);
    }
}
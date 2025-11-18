package com.fliad.hikvision.acl.alarm.handler;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import com.fliad.resource.modular.flowgram.domain.TaskRunInput;
import com.fliad.resource.modular.workflow.entity.ResourceWorkflow;
import com.fliad.hikvision.acl.NetSDK.HCNetSDK;
import com.fliad.hikvision.acl.alarm.HikvisionAlarmManager;
import com.fliad.hikvision.acl.alarm.HikvisionDevice;
import com.fliad.hikvision.acl.domain.DsWeather;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * 报警主机数据上传处理器
 */
public class AlarmHostDataUploadHandler implements AlarmHandler {
    private static final Logger log = LoggerFactory.getLogger(AlarmHostDataUploadHandler.class);

    private final HikvisionAlarmManager alarmManager;

    // 用于存储每个设备的气象数据缓存，key为设备IP，value为该设备的气象数据
    private static final Map<String, DsWeather> deviceWeatherCache = new ConcurrentHashMap<>();

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
        long dwVariableValue;
        // 存在负数，单独处理
        if (struDVRala.struAlarmData.struPointValue.iValueEx == 0 && struDVRala.struAlarmData.struPointValue.iValue < 0) {
            dwVariableValue = struDVRala.struAlarmData.struPointValue.iValue;
        } else {
            dwVariableValue = combineHighLowBits(struDVRala.struAlarmData.struPointValue.iValueEx, struDVRala.struAlarmData.struPointValue.iValue);
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

        // 从缓存中获取设备的气象数据对象，如果不存在则创建新的
        DsWeather dsWeather = deviceWeatherCache.computeIfAbsent(sbip, ip -> {
            DsWeather weather = new DsWeather();
            weather.setSbxh(device.getDeviceNumber());
            weather.setSbbh(device.getDeviceNumber());
            return weather;
        });

        // 更新设备编号信息（确保是最新的）
        dsWeather.setSbxh(device.getDeviceNumber());
        dsWeather.setSbbh(device.getDeviceNumber());

        // 使用BigDecimal处理数值，保留3位小数
        BigDecimal value = new BigDecimal(dwVariableValue);
        BigDecimal divisor1000 = new BigDecimal(1000);
        String valueStr = value.divide(divisor1000, 3, RoundingMode.HALF_UP).toString();

        if (dwVariableNo == 101) {
            dsWeather.setNjd(valueStr);
            dsWeather.setNjdpjz(valueStr);
            dsWeather.setNjdssz(valueStr);
        } else if (dwVariableNo == 203) {
            // 路面温度
            dsWeather.setLmwd(valueStr);
        } else if (dwVariableNo == 204) {
            // 水膜厚度
            dsWeather.setSmhd(valueStr);
        } else if (dwVariableNo == 205) {
            // 冰厚度
            dsWeather.setBhd(valueStr);
        } else if (dwVariableNo == 206) {
            // 雪厚度
            dsWeather.setXshd(valueStr);
        } else if (dwVariableNo == 207) {
            // 湿滑系数
            dsWeather.setShxs(valueStr);
        } else if (dwVariableNo == 208) {
            // 路面状态
            dsWeather.setLmzk(valueStr);
        } else if (dwVariableNo == 1) {
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
        /*if (dwChanNo == 1) {
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
        }*/
        dsWeather.setLsh(IdUtil.simpleUUID());
        dsWeather.setAcceptTime(new Date());

        List<ResourceWorkflow> workflowList = alarmManager.getViidWorkflowService().findBySubscribeDetail("103");

        // 配置ONode日期格式
        Options options = Options.def();
        options.addEncoder(Date.class, (data, node) -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            node.val().setString(sdf.format(data));
        });
        log.info("气象数据：{}", ONode.stringify(dsWeather, options));
        for (ResourceWorkflow workflow : workflowList) {
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

    /**
     * 获取指定设备的气象数据缓存
     *
     * @param deviceIp 设备IP地址
     * @return 该设备的气象数据，如果不存在则返回null
     */
    public static DsWeather getDeviceWeatherCache(String deviceIp) {
        return deviceWeatherCache.get(deviceIp);
    }

    /**
     * 清除指定设备的气象数据缓存
     *
     * @param deviceIp 设备IP地址
     */
    public static void clearDeviceWeatherCache(String deviceIp) {
        deviceWeatherCache.remove(deviceIp);
    }

    /**
     * 获取所有设备的气象数据缓存
     *
     * @return 所有设备的气象数据映射
     */
    public static Map<String, DsWeather> getAllDeviceWeatherCache() {
        return new ConcurrentHashMap<>(deviceWeatherCache);
    }

}

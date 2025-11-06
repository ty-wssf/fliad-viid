package com.fliad.hikvision.modular.defense.acl.alarm.handler;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import com.fliad.dev.api.DevConfigApi;
import com.fliad.hikvision.modular.defense.acl.NetSDK.HCNetSDK;
import com.fliad.hikvision.modular.defense.acl.alarm.HikvisionAlarmManager;
import com.fliad.hikvision.modular.defense.entity.VehicleTrafficRecord;
import com.fliad.hikvision.modular.defense.mapper.VehicleTrafficRecordMapper;
import com.fliad.resource.modular.flowgram.domain.TaskRunInput;
import com.fliad.resource.modular.workflow.entity.ResourceWorkflow;
import com.sun.jna.Pointer;
import org.noear.snack.ONode;
import org.noear.snack.core.Options;
import org.noear.solon.Solon;
import org.noear.solon.web.staticfiles.StaticMappings;
import org.noear.solon.web.staticfiles.repository.FileStaticRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 交通抓拍结果(新报警信息)处理器
 */
public class ItsPlateResultHandler implements AlarmHandler {
    private static final Logger log = LoggerFactory.getLogger(ItsPlateResultHandler.class);

    // 最大存储天数
    private static final int MAX_STORAGE_DAYS = 30;
    // 图片存储根目录
    private static final String IMAGE_STORAGE_ROOT = "./pic/";
    // 图片路径
    private static final String imagePathPrefix = "image/";

    // 确保静态映射只添加一次
    private static volatile boolean staticMappingAdded = false;

    // 定时清理任务执行器
    private static final ScheduledExecutorService cleanupExecutor = Executors.newScheduledThreadPool(1);

    // 静态初始化块，用于启动定时清理任务
    /*static {
        // 启动时立即执行一次清理
        cleanupExecutor.schedule(() -> performScheduledCleanup(), 0, TimeUnit.SECONDS);
        // 然后每天执行一次清理
        cleanupExecutor.scheduleAtFixedRate(() -> performScheduledCleanup(), 1, 1, TimeUnit.DAYS);
    }*/

    private final HikvisionAlarmManager alarmManager;
    private VehicleTrafficRecordMapper vehicleTrafficRecordMapper;

    public ItsPlateResultHandler(HikvisionAlarmManager alarmManager) {
        this.alarmManager = alarmManager;
        this.vehicleTrafficRecordMapper = Solon.context().getBean(VehicleTrafficRecordMapper.class);

        String hikvision_defense_image_path = Solon.context().getBean(DevConfigApi.class).getValueByKey("hikvision_defense_image_path");
        if (hikvision_defense_image_path == null) {
            hikvision_defense_image_path = IMAGE_STORAGE_ROOT;
        }

        // 确保静态映射只添加一次
        if (!staticMappingAdded) {
            synchronized (ItsPlateResultHandler.class) {
                if (!staticMappingAdded) {
                    StaticMappings.add(imagePathPrefix, new FileStaticRepository(hikvision_defense_image_path));
                    staticMappingAdded = true;
                }
            }
        }
    }

    @Override
    public void handle(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser) {
        // 用于承载数据
        ONode json = ONode.newObject();

        String sbip = "";
        try {
            sbip = new String(pAlarmer.sDeviceIP, "GBK").trim();
        } catch (Exception e) {
            log.error("获取设备IP失败", e);
        }
        log.info("设备IP: {}，报警类型: 交通抓拍结果", sbip);
        String MonitoringSiteID = "";
        String sLicense = "";
        byte VehicleType = 0;
        HCNetSDK.NET_ITS_PLATE_RESULT strItsPlateResult = new HCNetSDK.NET_ITS_PLATE_RESULT();
        strItsPlateResult.write();
        Pointer pItsPlateInfo = strItsPlateResult.getPointer();
        pItsPlateInfo.write(0, pAlarmInfo.getByteArray(0, strItsPlateResult.size()), 0, strItsPlateResult.size());
        strItsPlateResult.read();
        try {
            sLicense = new String(strItsPlateResult.struPlateInfo.sLicense, "GBK").trim();
            sLicense = "无车牌".equals(sLicense) ? "-" : sLicense;
            VehicleType = strItsPlateResult.byVehicleType;  //0-其他车辆，1-小型车，2-大型车，3- 行人触发，4- 二轮车触发，5- 三轮车触发，6- 机动车触发
            MonitoringSiteID = new String(strItsPlateResult.byMonitoringSiteID).trim();
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            log.error("", e1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            log.error("", e);
        }

        // 车辆信息解析
        short wSpeed = strItsPlateResult.struVehicleInfo.wSpeed; // 车速

        log.info("车牌号：" + sLicense + ":车辆类型：" + VehicleType + ":布防点编号：" + MonitoringSiteID + ":车速：" + wSpeed);

        json.set("gcsj", strItsPlateResult.struSnapFirstPicTime.getTime());
        json.set("sxjbh", alarmManager.getDeviceByIp(sbip).getDeviceNumber());
        json.set("hphm", sLicense);
        json.set("hpzl", strItsPlateResult.struPlateInfo.byPlateType);
        json.set("hpys", strItsPlateResult.struPlateInfo.byColor);
        json.set("cllx", strItsPlateResult.struVehicleInfo.byVehicleType);
        json.set("csys", strItsPlateResult.struVehicleInfo.byColor);
        json.set("clsd", wSpeed);
        json.set("cdh", strItsPlateResult.byDriveChan);
        json.set("fxlx", strItsPlateResult.byCarDirectionType);

        String hikvision_defense_image_path = Solon.context().getBean(DevConfigApi.class).getValueByKey("hikvision_defense_image_path");
        String hikvision_defense_image_gateway = Solon.context().getBean(DevConfigApi.class).getValueByKey("hikvision_defense_image_gateway");
        if (hikvision_defense_image_path == null) {
            hikvision_defense_image_path = IMAGE_STORAGE_ROOT;
        }
        if (hikvision_defense_image_gateway == null) {
            hikvision_defense_image_gateway = "http://127.0.0.1:" + Solon.cfg().serverPort() + "/";
        }

        /**
         * 报警图片保存，车牌，车辆图片
         */
        // 取出当前图片的类型 0-车牌图，1- 场景图，2- 合成图，3- 特写图，4- 二值图，5- 码流，6- 人脸子图(主驾驶)，7- 人脸子图(副驾驶)，8- 非机动车，9- 行人
        // 这里我们只取0 1 2 3 6 7这六种类型图片
        for (int i = 0; i < strItsPlateResult.dwPicNum; i++) {
            if (strItsPlateResult.struPicInfo[i].dwDataLen > 0) {
                byte byType = strItsPlateResult.struPicInfo[i].byType;
                if (byType == 0 || byType == 1 || byType == 2 || byType == 3 || byType == 6) {
                    // 按日期小时组织目录结构
                    String hourPath = getCurrentHourPath();
                    String fullDirPath = hikvision_defense_image_path + "/" + hourPath;

                    // 确保目录存在
                    createDirectoryIfNotExists(fullDirPath);

                    FileOutputStream fout;
                    try {
                        // 生成唯一文件名，避免覆盖
                        String filename = generateUniqueFilename();
                        fout = new FileOutputStream(fullDirPath + "/" + filename);
                        //将字节写入文/件
                        long offset = 0;
                        ByteBuffer buffers = strItsPlateResult.struPicInfo[i].pBuffer.getByteBuffer(offset, strItsPlateResult.struPicInfo[i].dwDataLen);
                        byte[] bytes = new byte[strItsPlateResult.struPicInfo[i].dwDataLen];
                        buffers.rewind();
                        buffers.get(bytes);
                        fout.write(bytes);
                        fout.close();
                        String hikvision_defense_image_url = hikvision_defense_image_gateway + imagePathPrefix + hourPath + "/" + filename;

                        // 通行图片
                        if (byType == 1 || byType == 2 || byType == 3) {
                            if (!json.contains("tp1")) {
                                json.set("tp1", hikvision_defense_image_url);
                            } else if (!json.contains("tp2")) {
                                json.set("tp2", hikvision_defense_image_url);
                            } else if (!json.contains("tp3")) {
                                json.set("tp3", hikvision_defense_image_url);
                            }
                        } else if (byType == 0) { // 车牌图片
                            json.set("tztp", hikvision_defense_image_url);
                        } else {
                            json.set("jsrtp", hikvision_defense_image_url);
                        }
                        log.info("图片访问地址：{}", hikvision_defense_image_url);

                        /*List<ResourceWorkflow> workflowList = alarmManager.getViidWorkflowService().findBySubscribeDetail("106");

                        // 配置ONode日期格式
                        Options options = Options.def();
                        options.addEncoder(Date.class, (data, node) -> {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            node.val().setString(sdf.format(data));
                        });
                        log.info("车辆通行数据：{}", json);
                        for (ResourceWorkflow workflow : workflowList) {
                            TaskRunInput taskRunInput = new TaskRunInput();
                            taskRunInput.setSchema(workflow.getContent());
                            taskRunInput.setInputs(MapUtil.of("inputs", json.toString()));
                            alarmManager.getFlowgramService().taskRun(false, taskRunInput, IdUtil.getSnowflakeNextIdStr());
                        }*/
                    } catch (IOException e) {
                        log.error("保存图片失败", e);
                    }
                }
            }
        }

        // 保存车辆通行记录到数据库
        saveVehicleTrafficRecord(json, strItsPlateResult, sbip, MonitoringSiteID, sLicense, wSpeed);
    }

    /**
     * 保存车辆通行记录到数据库
     *
     * @param json              通行记录JSON数据
     * @param strItsPlateResult 海康SDK抓拍结果
     * @param deviceIp          设备IP
     * @param monitoringSiteID  布防点编号
     * @param license           车牌号
     * @param speed             车速
     */
    private void saveVehicleTrafficRecord(ONode json, HCNetSDK.NET_ITS_PLATE_RESULT strItsPlateResult,
                                          String deviceIp, String monitoringSiteID, String license, short speed) {
        try {
            VehicleTrafficRecord record = new VehicleTrafficRecord();
            record.setId(IdUtil.getSnowflakeNextIdStr());
            record.setKkbh(monitoringSiteID); // 卡口编号
            record.setHphm(license); // 号牌号码
            record.setHpzl(String.valueOf(strItsPlateResult.struPlateInfo.byPlateType)); // 号牌种类
            record.setHpys((int) strItsPlateResult.struPlateInfo.byColor); // 号牌颜色
            record.setCllx(String.valueOf(strItsPlateResult.struVehicleInfo.byVehicleType)); // 车辆类型
            record.setCsys(String.valueOf(strItsPlateResult.struVehicleInfo.byColor)); // 车身颜色
            record.setClsd((int) speed); // 车辆速度
            record.setSxjbh(alarmManager.getDeviceByIp(deviceIp).getDeviceNumber()); // 摄像机设备编号
            record.setGcsj(DateUtil.parse(json.get("gcsj").getString(), "yyyyMMddHHmmssSSS")); // 过车时间
            record.setCdh(json.get("cdh").getString());
            record.setFxlx(json.get("fxlx").getString());

            // 图片URL
            if (json.contains("tp1")) {
                record.setTp1(json.get("tp1").getString());
            }
            if (json.contains("tp2")) {
                record.setTp2(json.get("tp2").getString());
            }
            if (json.contains("tp3")) {
                record.setTp3(json.get("tp3").getString());
            }
            if (json.contains("tztp")) {
                record.setTztp(json.get("tztp").getString());
            }
            if (json.contains("jsrtp")) {
                record.setJsrtp(json.get("jsrtp").getString());
            }

            // 保存到数据库
            vehicleTrafficRecordMapper.insert(record);
            log.info("车辆通行记录保存成功，车牌号：{}", license);
        } catch (Exception e) {
            log.error("保存车辆通行记录到数据库失败，车牌号：{}", license, e);
        }
    }

    /**
     * 生成唯一的文件名
     *
     * @return 唯一的文件名
     */
    private String generateUniqueFilename() {
        return IdUtil.getSnowflakeNextIdStr() + ".jpg";
    }

    /**
     * 获取当前日期路径 (格式: yyyy/MM/dd/HH)
     *
     * @return 日期路径字符串
     */
    private String getCurrentHourPath() {
        return DateUtil.format(new Date(), "yyyy/MM/dd/HH");
    }

    /**
     * 创建目录（如果不存在）
     *
     * @param path 目录路径
     */
    private void createDirectoryIfNotExists(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    /**
     * 执行定时清理任务
     */
    private static void performScheduledCleanup() {
        try {
            log.info("开始执行图片文件定时清理任务");

            File rootDir = new File(IMAGE_STORAGE_ROOT);
            if (!rootDir.exists() || !rootDir.isDirectory()) {
                return;
            }

            // 删除超过MAX_STORAGE_DAYS天的目录
            deleteOldDirectories(rootDir, MAX_STORAGE_DAYS);

            log.info("图片文件定时清理任务执行完成");
        } catch (Exception e) {
            log.error("执行定时清理任务时发生错误", e);
        }
    }

    /**
     * 删除过期的目录
     *
     * @param rootDir 根目录
     * @param maxDays 最大存储天数
     */
    private static void deleteOldDirectories(File rootDir, int maxDays) {
        LocalDate cutoffDate = LocalDate.now().minusDays(maxDays);

        // 遍历年份目录
        File[] yearDirs = rootDir.listFiles(File::isDirectory);
        if (yearDirs == null) return;

        for (File yearDir : yearDirs) {
            String yearStr = yearDir.getName();
            if (!isNumeric(yearStr)) continue;

            // 遍历月份目录
            File[] monthDirs = yearDir.listFiles(File::isDirectory);
            if (monthDirs == null) continue;

            for (File monthDir : monthDirs) {
                String monthStr = monthDir.getName();
                if (!isNumeric(monthStr)) continue;

                // 遍历日期目录
                File[] dayDirs = monthDir.listFiles(File::isDirectory);
                if (dayDirs == null) continue;

                for (File dayDir : dayDirs) {
                    String dayStr = dayDir.getName();
                    if (!isNumeric(dayStr)) continue;

                    // 构造日期
                    try {
                        String dateStr = yearStr + "-" + String.format("%02d", Integer.parseInt(monthStr)) + "-" + String.format("%02d", Integer.parseInt(dayStr));
                        LocalDate dirDate = LocalDate.parse(dateStr);

                        // 如果日期早于截止日期，则删除整个目录
                        if (dirDate.isBefore(cutoffDate)) {
                            deleteDirectoryRecursively(dayDir);
                            log.info("删除过期目录: {}", dayDir.getAbsolutePath());
                        }
                    } catch (Exception e) {
                        log.warn("解析日期目录时出错: {}", dayDir.getAbsolutePath(), e);
                    }
                }
            }
        }
    }

    /**
     * 递归删除目录
     *
     * @param dir 目录
     */
    private static void deleteDirectoryRecursively(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteDirectoryRecursively(file);
                }
            }
        }
        try {
            Files.deleteIfExists(dir.toPath());
        } catch (IOException e) {
            log.warn("删除文件或目录失败: {}", dir.getAbsolutePath(), e);
        }
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str 字符串
     * @return 是否为数字
     */
    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 关闭清理执行器（用于应用关闭时）
     */
    public static void shutdownCleanupExecutor() {
        cleanupExecutor.shutdown();
        try {
            if (!cleanupExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                cleanupExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            cleanupExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
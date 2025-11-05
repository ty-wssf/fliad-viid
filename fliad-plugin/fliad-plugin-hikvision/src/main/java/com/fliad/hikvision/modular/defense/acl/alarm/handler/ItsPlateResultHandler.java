package com.fliad.hikvision.modular.defense.acl.alarm.handler;

import cn.hutool.core.util.IdUtil;
import com.fliad.hikvision.modular.defense.acl.NetSDK.HCNetSDK;
import com.fliad.hikvision.modular.defense.acl.alarm.HikvisionAlarmManager;
import com.sun.jna.Pointer;
import org.noear.snack.ONode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    // 定时清理任务执行器
    private static final ScheduledExecutorService cleanupExecutor = Executors.newScheduledThreadPool(1);

    // 静态初始化块，用于启动定时清理任务
    static {
        // 启动时立即执行一次清理
        cleanupExecutor.schedule(() -> performScheduledCleanup(), 0, TimeUnit.SECONDS);
        // 然后每天执行一次清理
        cleanupExecutor.scheduleAtFixedRate(() -> performScheduledCleanup(), 1, 1, TimeUnit.DAYS);
    }

    private final HikvisionAlarmManager alarmManager;

    public ItsPlateResultHandler(HikvisionAlarmManager alarmManager) {
        this.alarmManager = alarmManager;
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

        json.set("sxjbh", alarmManager.getDeviceByIp(sbip).getDeviceNumber());
        json.set("hphm", sLicense);
        json.set("hpzl", strItsPlateResult.struPlateInfo.byPlateType);
        json.set("hpys", strItsPlateResult.struPlateInfo.byColor);
        json.set("cllx", strItsPlateResult.struVehicleInfo.byVehicleType);
        json.set("csys", strItsPlateResult.struVehicleInfo.byColor);
        json.set("clsd", wSpeed);

        /**
         * 报警图片保存，车牌，车辆图片
         */
        // 取出当前图片的类型 0-车牌图，1- 场景图，2- 合成图，3- 特写图，4- 二值图，5- 码流，6- 人脸子图(主驾驶)，7- 人脸子图(副驾驶)，8- 非机动车，9- 行人
        // 这里我们只取0 1 2 3 6 7这六种类型图片
        for (int i = 0; i < strItsPlateResult.dwPicNum; i++) {
            if (strItsPlateResult.struPicInfo[i].dwDataLen > 0) {
                byte byType = strItsPlateResult.struPicInfo[i].byType;
                if (byType == 0 || byType == 1 || byType == 2 || byType == 3 || byType == 6 || byType == 7) {
                    // 按日期组织目录结构
                    String datePath = getCurrentDatePath();
                    String fullDirPath = IMAGE_STORAGE_ROOT + datePath;

                    // 确保目录存在
                    createDirectoryIfNotExists(fullDirPath);

                    FileOutputStream fout;
                    try {
                        // 生成唯一文件名，避免覆盖
                        String filename = generateUniqueFilename(fullDirPath, strItsPlateResult.struPicInfo[i].byType);
                        fout = new FileOutputStream(filename);
                        //将字节写入文件
                        long offset = 0;
                        ByteBuffer buffers = strItsPlateResult.struPicInfo[i].pBuffer.getByteBuffer(offset, strItsPlateResult.struPicInfo[i].dwDataLen);
                        byte[] bytes = new byte[strItsPlateResult.struPicInfo[i].dwDataLen];
                        buffers.rewind();
                        buffers.get(bytes);
                        fout.write(bytes);
                        fout.close();
                    } catch (IOException e) {
                        log.error("保存图片失败", e);
                    }
                }
            }
        }
    }

    /**
     * 生成唯一的文件名
     *
     * @param dirPath  目录路径
     * @param fileType 文件类型
     * @return 唯一的文件名
     */
    private String generateUniqueFilename(String dirPath, byte fileType) {
        String baseName = dirPath + "/" + IdUtil.getSnowflakeNextIdStr() + ".jpg";
        return baseName;
    }

    /**
     * 获取当前日期路径 (格式: yyyy/MM/dd)
     *
     * @return 日期路径字符串
     */
    private String getCurrentDatePath() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return now.format(formatter);
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
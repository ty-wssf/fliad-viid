package com.netsdk.service.impl;

import com.netsdk.alarm.DahuaAlarmManager;
import com.netsdk.dao.entity.DahuaCamera;
import com.netsdk.service.DahuaCameraService;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 大华摄像头初始化运行器
 */
@Component
public class DahuaCameraInitRunner implements LifecycleBean {
    private static final Logger log = LoggerFactory.getLogger(DahuaCameraInitRunner.class);

    private static final String DEVICE_TYPE = "dahua";

    @Inject
    private DahuaCameraService dahuaCameraService;

    @Inject
    private DahuaAlarmManager dahuaAlarmManager;

    // 存储已初始化的设备ID列表
    private final List<String> initializedDevices = new CopyOnWriteArrayList<>();

    // 存储布防失败的设备列表
    private final List<DahuaCamera> failedDevices = new CopyOnWriteArrayList<>();

    /**
     * 系统启动完成后执行初始化
     */
    @Override
    public void start() throws Throwable {
        log.info("开始初始化大华设备...");

        // 获取所有大华摄像头设备
        List<DahuaCamera> cameras = dahuaCameraService.list();
        if (cameras.isEmpty()) {
            log.info("未配置大华摄像头设备，跳过初始化");
            return;
        }

        log.info("共找到 {} 个大华摄像头设备", cameras.size());

        // 初始化设备管理器
        dahuaAlarmManager.init();

        // 初始化所有设备
        for (DahuaCamera camera : cameras) {
            try {
                String deviceId = camera.getId();
                String deviceNumber = camera.getDeviceId(); // 设备编号
                String ip = camera.getIpAddr();

                log.info("初始化设备: {} (设备编号: {}, IP: {})", deviceId, deviceNumber, ip);

                // 添加设备到管理器
                dahuaAlarmManager.addDevice(
                        camera.getId(),
                        camera.getDeviceId(),
                        camera.getIpAddr(),
                        camera.getPort(),
                        camera.getUsername(),
                        camera.getPassword()
                );

                // 登录设备
                boolean loggedIn = dahuaAlarmManager.loginDevice(deviceId);
                if (!loggedIn) {
                    failedDevices.add(camera);
                    continue;
                }

                // 布防
                boolean alarmHandle = dahuaAlarmManager.setupAlarmChan(deviceId);
                if (!alarmHandle) {
                    failedDevices.add(camera);
                    continue;
                }

                // 记录成功初始化的设备
                initializedDevices.add(deviceId);
                log.info("设备 {} 初始化成功", deviceId);
            } catch (Exception e) {
                log.error("初始化设备 {} 时发生异常", camera.getId(), e);
                failedDevices.add(camera);
            }
        }

        log.info("大华设备初始化完成，成功: {} 个，失败: {} 个", initializedDevices.size(), failedDevices.size());
    }

    /**
     * 系统停止时执行资源清理
     */
    @Override
    public void stop() throws Throwable {
        log.info("开始清理大华设备资源...");

        try {
            // 创建已初始化设备列表的副本以避免并发修改
            List<String> devicesToClean = new CopyOnWriteArrayList<>(initializedDevices);

            // 逆序遍历已初始化的设备，进行撤防和注销
            for (String deviceId : devicesToClean) {
                try {
                    log.info("清理设备: {}", deviceId);

                    // 撤防
                    dahuaAlarmManager.closeAlarmChan(deviceId);
                    log.info("设备 {} 撤防完成", deviceId);

                    // 注销设备
                    dahuaAlarmManager.logoutDevice(deviceId);
                    log.info("设备 {} 注销完成", deviceId);

                    // 从已初始化列表中移除
                    initializedDevices.remove(deviceId);
                } catch (Exception e) {
                    log.error("清理设备 {} 时发生异常", deviceId, e);
                }
            }

            log.info("大华设备资源清理完成");
        } catch (Exception e) {
            log.error("清理大华设备资源时发生异常", e);
        }
    }
}
package com.fliad.hikvision.modular.defense.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import com.fliad.common.cache.CommonCacheOperator;
import com.fliad.common.state.DeviceStateManager;
import com.fliad.common.state.MultiDeviceStatusChangeListener;
import com.fliad.dev.api.DevConfigApi;
import com.fliad.hikvision.modular.defense.acl.alarm.HikvisionAlarmManager;
import com.fliad.hikvision.modular.defense.entity.HikvisionCamera;
import com.fliad.hikvision.modular.defense.service.HikvisionCameraService;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 海康威视设备初始化运行器
 * 服务启动时读取所有启用设备，登录和布防
 *
 * @author yourname
 * @date 2025/09/28
 */
@Component(index = 10)
public class HikvisionCameraInitRunner implements LifecycleBean, MultiDeviceStatusChangeListener {

    private static final Logger log = LoggerFactory.getLogger(HikvisionCameraInitRunner.class);

    private static final String DEVICE_TYPE = "hikvision";

    @Inject
    private HikvisionCameraService viidHikvisionCameraService;

    @Inject
    private HikvisionAlarmManager hikvisionAlarmManager;

    @Inject
    private DevConfigApi devConfigApi;

    private DeviceStateManager deviceStateManager;

    // 存储已初始化的设备ID列表
    private final List<String> initializedDevices = new CopyOnWriteArrayList<>();

    // 存储布防失败的设备列表
    private final List<HikvisionCamera> failedDevices = new CopyOnWriteArrayList<>();

    // 海康布防功能是否启用
    private boolean hikvisionDefenseEnabled = false;

    /**
     * 检查海康布防功能是否启用
     */
    private void checkHikvisionDefenseEnabled() {
        try {
            if (devConfigApi != null) {
                String configValue = devConfigApi.getValueByKey("hikvision_defense_enabled");
                hikvisionDefenseEnabled = "true".equalsIgnoreCase(configValue);
                log.info("海康布防功能启用状态: {}", hikvisionDefenseEnabled);
            } else {
                log.warn("DevConfigApi未注入，使用默认配置");
                hikvisionDefenseEnabled = false;
            }
        } catch (Exception e) {
            log.error("检查海康布防功能启用状态异常", e);
            hikvisionDefenseEnabled = false;
        }
    }

    /**
     * 系统启动完成后执行初始化
     */
    @Override
    public void start() throws Throwable {
        // 检查海康布防功能是否启用
        checkHikvisionDefenseEnabled();

        if (!hikvisionDefenseEnabled) {
            log.info("海康布防功能未启用，跳过设备初始化");
            return;
        }

        Solon.context().subBeansOfType(CommonCacheOperator.class, cacheOperator -> {
            this.deviceStateManager = new DeviceStateManager(cacheOperator);
            // 注册海康威视设备类型
            deviceStateManager.registerDeviceType(DEVICE_TYPE, "device:online:hikvision:");
            deviceStateManager.setDeviceTimeoutMillis(DEVICE_TYPE, 90 * 1000L); // 90秒超时
            deviceStateManager.addListener(this);
            deviceStateManager.enableScheduledCheck(DEVICE_TYPE);
            try {
                deviceStateManager.start();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });

        // 初始化海康威视报警管理器
        hikvisionAlarmManager.init(deviceStateManager);

        log.info("开始初始化海康威视设备...");

        try {
            // 查询所有启用的设备
            List<HikvisionCamera> enabledCameras = viidHikvisionCameraService.list(
                    viidHikvisionCameraService.query().eq("enable_status", 1)
            );

            log.info("找到 {} 个启用的海康威视设备", enabledCameras.size());

            // 遍历所有启用的设备，进行登录和布防
            for (HikvisionCamera camera : enabledCameras) {
                try {
                    ThreadUtil.safeSleep(500);
                    String deviceId = camera.getId();
                    String deviceNumber = camera.getDeviceId(); // 设备编号
                    String ip = camera.getIpAddr();
                    int port = camera.getPort();
                    String username = camera.getUsername();
                    String password = camera.getPassword();

                    log.info("开始初始化设备: {} (设备编号: {}, IP: {})", deviceId, deviceNumber, ip);

                    // 添加设备到报警管理器
                    boolean added = hikvisionAlarmManager.addDevice(deviceId, deviceNumber, ip, port, username, password);
                    if (!added) {
                        log.warn("设备 {} 添加失败", deviceId);
                        failedDevices.add(camera);
                        // 标记设备为离线状态
                        deviceStateManager.handleOfflineEvent(DEVICE_TYPE, deviceId);
                        continue;
                    }

                    // 登录设备
                    boolean loggedIn = hikvisionAlarmManager.loginDevice(deviceId);
                    if (!loggedIn) {
                        log.warn("设备 {} 登录失败", deviceId);
                        failedDevices.add(camera);
                        // 标记设备为离线状态
                        deviceStateManager.handleOfflineEvent(DEVICE_TYPE, deviceId);
                        continue;
                    }

                    // 布防
                    int alarmHandle = hikvisionAlarmManager.setupAlarmChan(deviceId);
                    if (alarmHandle == -1) {
                        log.warn("设备 {} 布防失败", deviceId);
                        failedDevices.add(camera);
                        // 标记设备为离线状态
                        deviceStateManager.handleOfflineEvent(DEVICE_TYPE, deviceId);
                        continue;
                    }

                    // 记录成功初始化的设备
                    initializedDevices.add(deviceId);
                    // 标记设备为在线状态
                    deviceStateManager.handleOnlineEvent(DEVICE_TYPE, deviceId);

                    log.info("设备 {} 初始化成功", deviceId);
                } catch (Exception e) {
                    log.error("初始化设备 {} 时发生异常", camera.getId(), e);
                    failedDevices.add(camera);
                    // 标记设备为离线状态
                    deviceStateManager.handleOfflineEvent(DEVICE_TYPE, camera.getId());
                }
            }

            log.info("海康威视设备初始化完成，成功: {} 个，失败: {} 个", initializedDevices.size(), failedDevices.size());

            // 处理布防失败的设备，进行无限重试
            if (!failedDevices.isEmpty()) {
                log.info("开始处理布防失败的设备，将进行无限重试直到成功");
                new Thread(this::processFailedDevices).start();
            }
        } catch (Exception e) {
            log.error("初始化海康威视设备时发生异常", e);
        }
    }

    /**
     * 处理布防失败的设备，进行无限重试直到成功
     */
    private void processFailedDevices() {
        int retryCount = 0;
        while (!failedDevices.isEmpty()) {
            retryCount++;
            log.info("第 {} 轮重试布防失败的设备，当前失败设备数量: {}", retryCount, failedDevices.size());

            // 解决设备信息调整后可以实时更新的问题
            List<HikvisionCamera> currentFailedDevices = new CopyOnWriteArrayList<>();
            for (HikvisionCamera failedDevice : failedDevices) {
                HikvisionCamera camera = viidHikvisionCameraService.getById(failedDevice.getId());
                hikvisionAlarmManager.removeDevice(failedDevice.getId());
                hikvisionAlarmManager.addDevice(camera.getId(), camera.getDeviceId(), camera.getIpAddr(), camera.getPort(), camera.getUsername(), camera.getPassword());
                currentFailedDevices.add(camera);
            }
            // 清空失败列表，准备重新添加本轮仍然失败的设备
            List<HikvisionCamera> stillFailedDevices = new CopyOnWriteArrayList<>();
            failedDevices.clear();

            // 遍历本轮需要处理的设备
            for (HikvisionCamera camera : currentFailedDevices) {
                try {
                    ThreadUtil.safeSleep(500);
                    String deviceId = camera.getId();
                    String deviceNumber = camera.getDeviceId(); // 设备编号
                    String ip = camera.getIpAddr();

                    log.info("重试初始化设备: {} (设备编号: {}, IP: {})", deviceId, deviceNumber, ip);

                    // 撤防
                    hikvisionAlarmManager.closeAlarmChan(deviceId);
                    log.info("设备 {} 撤防完成", deviceId);

                    // 注销设备
                    hikvisionAlarmManager.logoutDevice(deviceId);
                    log.info("设备 {} 注销完成", deviceId);

                    // 登录设备
                    boolean loggedIn = hikvisionAlarmManager.loginDevice(deviceId);
                    if (!loggedIn) {
                        log.warn("设备 {} 重试登录失败", deviceId);
                        stillFailedDevices.add(camera);
                        // 标记设备为离线状态
                        deviceStateManager.handleOfflineEvent(DEVICE_TYPE, deviceId);
                        continue;
                    }

                    // 布防
                    int alarmHandle = hikvisionAlarmManager.setupAlarmChan(deviceId);
                    if (alarmHandle == -1) {
                        log.warn("设备 {} 重试布防失败", deviceId);
                        stillFailedDevices.add(camera);
                        // 标记设备为离线状态
                        deviceStateManager.handleOfflineEvent(DEVICE_TYPE, deviceId);
                        continue;
                    }

                    // 记录成功初始化的设备
                    initializedDevices.add(deviceId);
                    // 标记设备为在线状态
                    deviceStateManager.handleOnlineEvent(DEVICE_TYPE, deviceId);
                    log.info("设备 {} 重试初始化成功", deviceId);
                } catch (Exception e) {
                    log.error("重试初始化设备 {} 时发生异常", camera.getId(), e);
                    stillFailedDevices.add(camera);
                    // 标记设备为离线状态
                    deviceStateManager.handleOfflineEvent(DEVICE_TYPE, camera.getId());
                }
            }

            // 更新失败设备列表
            failedDevices.addAll(stillFailedDevices);

            // 如果还有失败的设备，等待一段时间再进行下一轮重试
            if (!failedDevices.isEmpty()) {
                log.info("本轮重试后仍有 {} 个设备失败，等待30秒后进行下一轮重试", failedDevices.size());
                try {
                    Thread.sleep(5000 * 6); // 等待30秒
                } catch (InterruptedException e) {
                    log.warn("等待重试时被中断", e);
                    Thread.currentThread().interrupt();
                }
            }
        }

        log.info("所有设备布防完成，共重试 {} 轮", retryCount);
    }

    /**
     * 系统停止时执行资源清理
     */
    @Override
    public void stop() throws Throwable {
        if (!hikvisionDefenseEnabled) {
            log.info("海康布防功能未启用，跳过资源清理");
            return;
        }

        log.info("开始清理海康威视设备资源...");

        try {
            if (deviceStateManager != null) {
                deviceStateManager.stop();
            }

            // 创建已初始化设备列表的副本以避免并发修改
            List<String> devicesToClean = new ArrayList<>(initializedDevices);

            // 逆序遍历已初始化的设备，进行撤防和注销
            for (String deviceId : devicesToClean) {
                try {
                    log.info("开始清理设备: {}", deviceId);

                    // 撤防
                    hikvisionAlarmManager.closeAlarmChan(deviceId);
                    log.info("设备 {} 撤防完成", deviceId);

                    // 注销设备
                    hikvisionAlarmManager.logoutDevice(deviceId);
                    log.info("设备 {} 注销完成", deviceId);

                    // 标记设备为离线状态
                    deviceStateManager.handleOfflineEvent(DEVICE_TYPE, deviceId);
                } catch (Exception e) {
                    log.error("清理设备 {} 时发生异常", deviceId, e);
                }
            }

            // 清空已初始化设备列表
            initializedDevices.clear();

            log.info("海康威视设备资源清理完成");
        } catch (Exception e) {
            log.error("清理海康威视设备资源时发生异常", e);
        }
    }

    @Override
    public void onDeviceOnline(String deviceType, String deviceId) {
        if (deviceType.equals(DEVICE_TYPE)) {
            // 更新ViidHikvisionCamera实体在数据库的状态
            HikvisionCamera viidHikvisionCamera = viidHikvisionCameraService.getById(deviceId);
            if (viidHikvisionCamera != null) {
                viidHikvisionCamera.setOnlineStatus(1);
                viidHikvisionCameraService.updateById(viidHikvisionCamera);
            }
        }
    }

    @Override
    public void onDeviceOffline(String deviceType, String deviceId) {
        if (deviceType.equals(DEVICE_TYPE)) {
            // 删除ViidHikvisionCamera实体在数据库的状态
            HikvisionCamera viidHikvisionCamera = viidHikvisionCameraService.getById(deviceId);
            if (viidHikvisionCamera != null) {
                viidHikvisionCamera.setOnlineStatus(0);
                viidHikvisionCameraService.updateById(viidHikvisionCamera);
            }
        }
    }
}
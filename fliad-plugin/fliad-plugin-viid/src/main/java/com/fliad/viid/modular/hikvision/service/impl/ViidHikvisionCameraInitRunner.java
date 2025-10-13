package com.fliad.viid.modular.hikvision.service.impl;

import com.fliad.dev.api.DevConfigApi;
import com.fliad.viid.modular.hikvision.acl.alarm.HikvisionAlarmManager;
import com.fliad.viid.modular.hikvision.entity.ViidHikvisionCamera;
import com.fliad.viid.modular.hikvision.service.ViidHikvisionCameraService;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 海康威视设备初始化运行器
 * 服务启动时读取所有启用设备，登录和布防
 *
 * @author yourname
 * @date 2025/09/28
 */
@Slf4j
@Component(index = 10)
public class ViidHikvisionCameraInitRunner implements LifecycleBean {

    @Inject
    private ViidHikvisionCameraService viidHikvisionCameraService;

    @Inject
    private HikvisionAlarmManager hikvisionAlarmManager;
    
    @Inject
    private DevConfigApi devConfigApi;

    // 存储已初始化的设备ID列表
    private final List<String> initializedDevices = new CopyOnWriteArrayList<>();
    
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
        
        // 初始化海康威视报警管理器
        hikvisionAlarmManager.init();
        
        log.info("开始初始化海康威视设备...");

        try {
            // 查询所有启用的设备
            List<ViidHikvisionCamera> enabledCameras = viidHikvisionCameraService.list(
                    viidHikvisionCameraService.query().eq("enable_status", 1)
            );

            log.info("找到 {} 个启用的海康威视设备", enabledCameras.size());

            // 遍历所有启用的设备，进行登录和布防
            for (ViidHikvisionCamera camera : enabledCameras) {
                try {
                    String deviceId = camera.getId();
                    String ip = camera.getIpAddr();
                    int port = camera.getPort();
                    String username = camera.getUsername();
                    String password = camera.getPassword();

                    log.info("开始初始化设备: {} (IP: {})", deviceId, ip);

                    // 添加设备到报警管理器
                    boolean added = hikvisionAlarmManager.addDevice(deviceId, ip, port, username, password);
                    if (!added) {
                        log.warn("设备 {} 添加失败", deviceId);
                        continue;
                    }

                    // 登录设备
                    boolean loggedIn = hikvisionAlarmManager.loginDevice(deviceId);
                    if (!loggedIn) {
                        log.warn("设备 {} 登录失败", deviceId);
                        continue;
                    }

                    // 布防
                    int alarmHandle = hikvisionAlarmManager.setupAlarmChan(deviceId);
                    if (alarmHandle == -1) {
                        log.warn("设备 {} 布防失败", deviceId);
                        continue;
                    }

                    // 记录成功初始化的设备
                    initializedDevices.add(deviceId);

                    log.info("设备 {} 初始化成功", deviceId);
                } catch (Exception e) {
                    log.error("初始化设备 {} 时发生异常", camera.getId(), e);
                }
            }

            log.info("海康威视设备初始化完成");
        } catch (Exception e) {
            log.error("初始化海康威视设备时发生异常", e);
        }
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
            // 逆序遍历已初始化的设备，进行撤防和注销
            for (String deviceId : initializedDevices) {
                try {
                    log.info("开始清理设备: {}", deviceId);

                    // 撤防
                    hikvisionAlarmManager.closeAlarmChan(deviceId);
                    log.info("设备 {} 撤防完成", deviceId);

                    // 注销设备
                    hikvisionAlarmManager.logoutDevice(deviceId);
                    log.info("设备 {} 注销完成", deviceId);

                    // 从已初始化列表中移除
                    initializedDevices.remove(deviceId);
                } catch (Exception e) {
                    log.error("清理设备 {} 时发生异常", deviceId, e);
                }
            }

            log.info("海康威视设备资源清理完成");
        } catch (Exception e) {
            log.error("清理海康威视设备资源时发生异常", e);
        }
    }
}

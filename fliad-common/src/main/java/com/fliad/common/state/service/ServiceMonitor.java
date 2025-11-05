package com.fliad.common.state.service;

import cn.hutool.core.util.StrUtil;
import com.fliad.common.state.DeviceStateManager;
import org.noear.solon.core.bean.LifecycleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 服务监控器
 * 负责监控服务是否运行，如果不在运行状态则启动该服务
 *
 * @author lingma
 * @date 2025/11/05
 */
public class ServiceMonitor implements LifecycleBean {

    private static final Logger log = LoggerFactory.getLogger(ServiceMonitor.class);

    private static final String SERVICE_DEVICE_TYPE = "service";
    private static final String SERVICE_ONLINE_PREFIX = "service:online:";

    // 定时任务执行器
    private ScheduledExecutorService scheduledExecutorService;

    // 定时检测间隔（毫秒），默认30秒
    private long checkIntervalMillis = 30 * 1000L;

    private final DeviceStateManager deviceStateManager;

    /**
     * 服务状态监听器映射
     * key: 服务名称
     * value: 服务状态监听器
     */
    private final Map<String, ServiceStateListener> serviceListeners = new ConcurrentHashMap<>();

    /**
     * 服务启动器映射
     * key: 服务名称
     * value: 服务启动器
     */
    private final Map<String, ServiceStarter> serviceStarters = new ConcurrentHashMap<>();

    @Override
    public void start() throws Throwable {
        // 初始化定时任务执行器
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(r -> {
                Thread t = new Thread(r, "service-monitor-scheduler");
                t.setDaemon(true);
                return t;
            });

            // 启动定时检测任务
            scheduledExecutorService.scheduleWithFixedDelay(this::performServiceCheck,
                    checkIntervalMillis, checkIntervalMillis, TimeUnit.MILLISECONDS);

            log.info("服务监控器定时检测任务已启动，检测间隔: {}ms", checkIntervalMillis);
            
            // 注册服务设备类型到设备状态管理器
            deviceStateManager.registerDeviceType(SERVICE_DEVICE_TYPE, SERVICE_ONLINE_PREFIX);
            // 启用服务类型设备的定时检测功能
            deviceStateManager.enableScheduledCheck(SERVICE_DEVICE_TYPE);
        }
    }

    @Override
    public void stop() throws Throwable {
        // 关闭定时任务执行器
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            scheduledExecutorService.shutdown();
            try {
                if (!scheduledExecutorService.awaitTermination(5, TimeUnit.SECONDS)) {
                    scheduledExecutorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                scheduledExecutorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
            log.info("服务监控器定时检测任务已停止");
        }
    }

    /**
     * 构造一个新的服务监控器
     *
     * @param deviceStateManager 设备状态管理器
     */
    public ServiceMonitor(DeviceStateManager deviceStateManager) {
        this.deviceStateManager = deviceStateManager;
    }

    /**
     * 注册服务监听器
     *
     * @param serviceName 服务名称
     * @param listener    服务状态监听器
     */
    public void registerServiceListener(String serviceName, ServiceStateListener listener) {
        if (StrUtil.isBlank(serviceName) || listener == null) {
            log.warn("服务名称或监听器为空，无法注册服务监听器");
            return;
        }

        serviceListeners.put(serviceName, listener);
        log.info("已注册服务{}的监听器", serviceName);
    }

    /**
     * 注销服务监听器
     *
     * @param serviceName 服务名称
     */
    public void unregisterServiceListener(String serviceName) {
        if (StrUtil.isBlank(serviceName)) {
            log.warn("服务名称为空，无法注销服务监听器");
            return;
        }

        ServiceStateListener removed = serviceListeners.remove(serviceName);
        if (removed != null) {
            log.info("已注销服务{}的监听器", serviceName);
        }
    }

    /**
     * 注册服务启动器
     *
     * @param serviceName 服务名称
     * @param starter     服务启动器
     */
    public void registerServiceStarter(String serviceName, ServiceStarter starter) {
        if (StrUtil.isBlank(serviceName) || starter == null) {
            log.warn("服务名称或启动器为空，无法注册服务启动器");
            return;
        }

        serviceStarters.put(serviceName, starter);
        log.info("已注册服务{}的启动器", serviceName);
    }

    /**
     * 注销服务启动器
     *
     * @param serviceName 服务名称
     */
    public void unregisterServiceStarter(String serviceName) {
        if (StrUtil.isBlank(serviceName)) {
            log.warn("服务名称为空，无法注销服务启动器");
            return;
        }

        ServiceStarter removed = serviceStarters.remove(serviceName);
        if (removed != null) {
            log.info("已注销服务{}的启动器", serviceName);
        }
    }

    /**
     * 报告服务正在运行
     *
     * @param serviceName 服务名称
     * @return true-状态已变更，false-状态未变更
     */
    public boolean reportServiceRunning(String serviceName) {
        if (StrUtil.isBlank(serviceName)) {
            log.warn("服务名称为空，无法报告服务运行状态");
            return false;
        }

        return deviceStateManager.handleOnlineEvent(SERVICE_DEVICE_TYPE, serviceName);
    }

    /**
     * 报告服务已停止
     *
     * @param serviceName 服务名称
     * @return true-状态已变更，false-状态未变更
     */
    public boolean reportServiceStopped(String serviceName) {
        if (StrUtil.isBlank(serviceName)) {
            log.warn("服务名称为空，无法报告服务停止状态");
            return false;
        }

        return deviceStateManager.handleOfflineEvent(SERVICE_DEVICE_TYPE, serviceName);
    }

    /**
     * 检查服务是否正在运行
     *
     * @param serviceName 服务名称
     * @return true-正在运行，false-已停止
     */
    public boolean isServiceRunning(String serviceName) {
        if (StrUtil.isBlank(serviceName)) {
            return false;
        }

        return deviceStateManager.isOnline(SERVICE_DEVICE_TYPE, serviceName);
    }

    /**
     * 设置定时检测间隔
     *
     * @param checkIntervalMillis 检测间隔（毫秒）
     */
    public void setCheckIntervalMillis(long checkIntervalMillis) {
        this.checkIntervalMillis = checkIntervalMillis;
    }

    /**
     * 执行服务检测
     */
    private void performServiceCheck() {
        for (Map.Entry<String, ServiceStateListener> entry : serviceListeners.entrySet()) {
            String serviceName = entry.getKey();
            ServiceStateListener listener = entry.getValue();

            try {
                boolean isRunning = listener.isServiceRunning(serviceName);
                
                if (isRunning) {
                    // 服务正在运行，更新状态
                    reportServiceRunning(serviceName);
                } else {
                    // 服务已停止，尝试启动
                    log.warn("检测到服务{}已停止，准备启动服务", serviceName);
                    
                    // 先更新状态为离线
                    reportServiceStopped(serviceName);
                    
                    // 尝试启动服务
                    ServiceStarter starter = serviceStarters.get(serviceName);
                    if (starter != null) {
                        try {
                            starter.startService(serviceName);
                            log.info("已启动服务{}", serviceName);
                        } catch (Exception e) {
                            log.error("启动服务{}失败", serviceName, e);
                        }
                    } else {
                        log.warn("服务{}没有注册启动器，无法自动启动", serviceName);
                    }
                }
            } catch (Exception e) {
                log.error("检测服务{}状态时发生异常", serviceName, e);
            }
        }
    }
}
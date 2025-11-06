package com.fliad.service.monitor.core;

import org.noear.snack.ONode;
import org.noear.solon.Solon;
import org.noear.solon.config.yaml.PropertiesYaml;
import org.noear.solon.core.Props;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * 轻量级服务监控器
 * 负责监控服务是否运行，如果不在运行状态则启动该服务
 *
 * @author wyl
 * @date 2025年11月05日 21:15
 */
public class SimpleServiceMonitor {

    private static final Logger log = LoggerFactory.getLogger(SimpleServiceMonitor.class);

    // 定时任务执行器
    private ScheduledExecutorService scheduledExecutorService;

    // 定时检测间隔（毫秒），默认30秒
    private long checkIntervalMillis = 30 * 1000L;

    /**
     * 服务配置信息
     */
    private List<ServiceConfig> serviceConfigs;

    /**
     * 服务运行状态映射
     * key: 服务名称
     * value: 服务是否正在运行
     */
    private final Map<String, Boolean> serviceRunningStatus = new ConcurrentHashMap<>();

    /**
     * 启动服务监控器
     */
    public void start() {
        // 加载配置
        Collection<Props> services = Solon.cfg().getListedProp("services");
        serviceConfigs = new ArrayList<>();
        for (Props service : services) {
            serviceConfigs.add(service.bindTo(ServiceConfig.class));
        }

        // 注册服务监听器和启动器
        registerServices();

        // 初始化定时任务执行器
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(r -> {
                Thread t = new Thread(r, "service-monitor-scheduler");
                t.setDaemon(true);
                return t;
            });

            // 启动定时检测任务
            scheduledExecutorService.scheduleWithFixedDelay(this::performServiceCheck, checkIntervalMillis, checkIntervalMillis, TimeUnit.MILLISECONDS);

            log.info("服务监控器定时检测任务已启动，检测间隔: {}ms", checkIntervalMillis);
        }
    }

    /**
     * 停止服务监控器
     */
    public void stop() {
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
     * 设置定时检测间隔
     *
     * @param checkIntervalMillis 检测间隔（毫秒）
     */
    public void setCheckIntervalMillis(long checkIntervalMillis) {
        this.checkIntervalMillis = checkIntervalMillis;
    }


    /**
     * 注册服务监听器和启动器
     */
    private void registerServices() {
        if (serviceConfigs == null || serviceConfigs.isEmpty()) {
            log.warn("没有配置任何服务");
            return;
        }

        for (ServiceConfig config : serviceConfigs) {
            // 注册服务状态监听器
            registerServiceListener(config.getName(), new ServiceStateListener() {
                @Override
                public boolean isServiceRunning(String serviceName) {
                    return isPortOpen(config.getPort());
                }
            });

            // 注册服务启动器
            registerServiceStarter(config.getName(), new ServiceStarter() {
                @Override
                public void startService(String serviceName) throws Exception {
                    log.info("正在启动服务 {}，命令: {}", serviceName, config.getCommand());
                    Runtime.getRuntime().exec(config.getCommand());
                }
            });

            log.info("已注册服务: {}，端口: {}，启动命令: {}", config.getName(), config.getPort(), config.getCommand());
        }
    }

    /**
     * 检查端口是否开放
     *
     * @param port 端口号
     * @return true-端口开放，false-端口关闭
     */
    private boolean isPortOpen(int port) {
        try (Socket socket = new Socket("localhost", port)) {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

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

    /**
     * 注册服务监听器
     *
     * @param serviceName 服务名称
     * @param listener    服务状态监听器
     */
    public void registerServiceListener(String serviceName, ServiceStateListener listener) {
        if (serviceName == null || serviceName.isEmpty() || listener == null) {
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
        if (serviceName == null || serviceName.isEmpty()) {
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
        if (serviceName == null || serviceName.isEmpty() || starter == null) {
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
        if (serviceName == null || serviceName.isEmpty()) {
            log.warn("服务名称为空，无法注销服务启动器");
            return;
        }

        ServiceStarter removed = serviceStarters.remove(serviceName);
        if (removed != null) {
            log.info("已注销服务{}的启动器", serviceName);
        }
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

                // 更新服务运行状态
                Boolean previousStatus = serviceRunningStatus.put(serviceName, isRunning);

                if (isRunning) {
                    // 服务正在运行
                    log.info("服务{}正在运行", serviceName);
                } else {
                    // 服务已停止，尝试启动
                    log.warn("检测到服务{}已停止，准备启动服务", serviceName);

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

                // 如果服务状态发生变化，记录日志
                if (previousStatus != null && previousStatus != isRunning) {
                    log.info("服务{}状态发生变化: {} -> {}", serviceName, previousStatus ? "运行中" : "已停止", isRunning ? "运行中" : "已停止");
                }
            } catch (Exception e) {
                log.error("检测服务{}状态时发生异常", serviceName, e);
            }
        }
    }

    /**
     * 服务配置类
     */
    public static class ServiceConfig {
        private String name;
        private String command;
        private int port;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCommand() {
            return command;
        }

        public void setCommand(String command) {
            this.command = command;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }
    }
}

package com.fliad.service.monitor.core;

import org.noear.solon.annotation.Component;
import org.noear.solon.core.bean.LifecycleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 服务监控生命周期管理器
 * 负责管理服务监控器的启动和停止
 *
 * @author wyl
 * @date 2025年11月05日 21:15
 */
@Component
public class ServiceMonitorLifecycle implements LifecycleBean {

    private static final Logger log = LoggerFactory.getLogger(ServiceMonitorLifecycle.class);

    private SimpleServiceMonitor serviceMonitor;

    /**
     * 应用启动完成后调用
     */
    @Override
    public void start() throws Throwable {
        log.info("开始启动服务监控应用");

        // 创建服务监控器
        serviceMonitor = new SimpleServiceMonitor();

        // 设置检测间隔为10秒
        serviceMonitor.setCheckIntervalMillis(10 * 1000L);

        // 启动服务监控器
        serviceMonitor.start();

        log.info("服务监控应用启动完成");
    }

    /**
     * 应用停止前调用
     */
    @Override
    public void stop() throws Throwable {
        log.info("开始停止服务监控应用");

        if (serviceMonitor != null) {
            serviceMonitor.stop();
        }

        log.info("服务监控应用停止完成");
    }
}
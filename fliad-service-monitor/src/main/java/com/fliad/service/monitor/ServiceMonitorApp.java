package com.fliad.service.monitor;

import org.noear.solon.Solon;
import org.noear.solon.SolonApp;
import org.noear.solon.annotation.SolonMain;
import org.noear.solon.core.runtime.NativeDetector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 服务监控应用
 * 监控服务是否在运行状态，如果服务不在运行状态，则启动服务
 *
 * @author wyl
 * @date 2025年11月05日 21:15
 */
@SolonMain
public class ServiceMonitorApp {

    private static final Logger log = LoggerFactory.getLogger(ServiceMonitorApp.class);

    public static void main(String[] args) throws InterruptedException {
        SolonApp app =Solon.start(ServiceMonitorApp.class, args);
        if (NativeDetector.isNotAotRuntime()) {
            app.block();
        }
    }
}

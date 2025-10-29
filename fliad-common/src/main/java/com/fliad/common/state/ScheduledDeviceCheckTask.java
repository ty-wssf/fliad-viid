/*
 * Copyright [2022] [https://www.xiaonuo.vip]
 *
 * Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：
 *
 * 1.请不要删除和修改根目录下的LICENSE文件。
 * 2.请不要删除和修改Snowy源码头部的版权声明。
 * 3.本项目代码可免费商业使用，商业使用请保留源码和相关描述文件的项目出处，作者声明等。
 * 4.分发源码时候，请注明软件出处 https://www.xiaonuo.vip
 * 5.不可二次分发开源参与同类竞品，如有想法可联系团队xiaonuobase@qq.com商议合作。
 * 6.若您的项目无法满足以上几点，需要更多功能代码，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package com.fliad.common.state;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时设备检测任务
 * 定期检查在线设备状态，将超时未活动的设备标记为离线
 *
 * @author lingma
 * @date 2025/10/29
 */
@Component
public class ScheduledDeviceCheckTask implements LifecycleBean {

    private static final Logger log = LoggerFactory.getLogger(ScheduledDeviceCheckTask.class);

    @Inject
    private DeviceStateManager deviceStateManager;

    private ScheduledExecutorService scheduler;

    /**
     * 初始化定时任务
     */
    @Override
    public void start() throws Throwable {
        // 创建单线程的定时任务执行器
        scheduler = Executors.newSingleThreadScheduledExecutor();
        // 每30秒执行一次检测
        scheduler.scheduleAtFixedRate(this::checkDeviceStatus, 30, 30, TimeUnit.SECONDS);
    }

    /**
     * 销毁定时任务
     */
    @Override
    public void stop() throws Throwable {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
            try {
                if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                    scheduler.shutdownNow();
                }
            } catch (InterruptedException e) {
                scheduler.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * 定时检测设备状态
     * 每30秒执行一次检测
     */
    public void checkDeviceStatus() {
        // 检查定时检测功能是否启用
        if (!deviceStateManager.isScheduledCheckEnabled()) {
            return;
        }

        try {
            int offlineCount = deviceStateManager.performScheduledCheck();
            if (offlineCount > 0) {
                log.info("定时检测完成，共将{}个超时设备标记为离线", offlineCount);
            }
        } catch (Exception e) {
            log.error("执行定时设备检测时发生异常", e);
        }
    }

}

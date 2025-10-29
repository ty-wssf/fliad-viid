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
package com.fliad.common.state.example;

import com.fliad.common.state.DeviceStatusChangeListener;
import com.fliad.common.state.DeviceStatusService;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 设备状态管理使用示例
 *
 * @author lingma
 * @date 2025/10/29
 */
@Component
public class DeviceStatusExample implements DeviceStatusChangeListener {
    
    private static final Logger log = LoggerFactory.getLogger(DeviceStatusExample.class);
    
    @Inject
    private DeviceStatusService deviceStatusService;
    
    /**
     * 初始化示例
     */
    public void init() {
        // 注册监听器
        deviceStatusService.addListener(this);
        
        // 启用定时检测功能
        deviceStatusService.enableScheduledCheck();
        
        // 设置设备超时时间为5分钟
        deviceStatusService.setDeviceTimeoutMillis(5 * 60 * 1000);
        
        // 模拟设备上线事件
        deviceStatusService.handleOnlineEvent("device_001");
        deviceStatusService.handleOnlineEvent("device_002");
        
        // 再次发送上线事件，不会重复处理
        deviceStatusService.handleOnlineEvent("device_001");
        
        // 模拟设备下线事件
        deviceStatusService.handleOfflineEvent("device_001");
        
        // 再次发送下线事件，不会重复处理
        deviceStatusService.handleOfflineEvent("device_001");
        
        log.info("当前在线设备数量: {}", deviceStatusService.getOnlineDeviceCount());
    }
    
    @Override
    public void onDeviceOnline(String deviceId) {
        // 设备上线时需要执行的业务逻辑
        log.info("监听到设备上线: {}", deviceId);
        // 可以在这里添加更新数据库状态等操作
    }
    
    @Override
    public void onDeviceOffline(String deviceId) {
        // 设备下线时需要执行的业务逻辑
        log.info("监听到设备下线: {}", deviceId);
        // 可以在这里添加更新数据库状态等操作
    }
}
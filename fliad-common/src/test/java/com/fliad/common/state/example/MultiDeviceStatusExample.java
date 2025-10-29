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

import com.fliad.common.state.MultiDeviceStateManager;
import com.fliad.common.state.MultiDeviceStatusChangeListener;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 多设备状态管理使用示例
 *
 * @author lingma
 * @date 2025/10/29
 */
@Component
public class MultiDeviceStatusExample implements MultiDeviceStatusChangeListener {
    
    private static final Logger log = LoggerFactory.getLogger(MultiDeviceStatusExample.class);
    
    @Inject
    private MultiDeviceStateManager multiDeviceStateManager;
    
    @Inject
    private CameraDeviceStateManager cameraDeviceStateManager;
    
    @Inject
    private NvrDeviceStateManager nvrDeviceStateManager;
    
    /**
     * 初始化示例
     */
    public void init() {
        // 注册监听器
        multiDeviceStateManager.addListener(this);
        
        // 注册不同类型设备的状态管理器
        multiDeviceStateManager.registerStateManager("camera", cameraDeviceStateManager);
        multiDeviceStateManager.registerStateManager("nvr", nvrDeviceStateManager);
        
        // 启用定时检测功能
        multiDeviceStateManager.enableAllScheduledCheck();
        
        // 设置不同类型设备的超时时间
        multiDeviceStateManager.setDeviceTimeoutMillis("camera", 5 * 60 * 1000); // 5分钟
        multiDeviceStateManager.setDeviceTimeoutMillis("nvr", 10 * 60 * 1000);   // 10分钟
        
        // 创建设备实例
        CameraDevice camera1 = new CameraDevice("camera_001", "Camera1", "192.168.1.100", 80);
        CameraDevice camera2 = new CameraDevice("camera_002", "Camera2", "192.168.1.101", 80);
        NvrDevice nvr1 = new NvrDevice("nvr_001", "NVR1", "192.168.1.102", 80, 16);
        
        // 模拟设备上线事件
        multiDeviceStateManager.handleOnlineEvent("camera", camera1);
        multiDeviceStateManager.handleOnlineEvent("camera", camera2);
        multiDeviceStateManager.handleOnlineEvent("nvr", nvr1);
        
        // 再次发送上线事件，不会重复处理
        multiDeviceStateManager.handleOnlineEvent("camera", camera1);
        
        // 获取在线设备数量
        log.info("摄像头在线数量: {}", multiDeviceStateManager.getOnlineDeviceCount("camera"));
        log.info("NVR在线数量: {}", multiDeviceStateManager.getOnlineDeviceCount("nvr"));
        log.info("设备在线总数量: {}", multiDeviceStateManager.getTotalOnlineDeviceCount());
        
        // 模拟设备下线事件
        multiDeviceStateManager.handleOfflineEvent("camera", camera1);
        
        // 再次发送下线事件，不会重复处理
        multiDeviceStateManager.handleOfflineEvent("camera", camera1);
        
        log.info("操作完成后，摄像头在线数量: {}", multiDeviceStateManager.getOnlineDeviceCount("camera"));
    }
    
    @Override
    public void onDeviceOnline(String deviceType, String deviceId) {
        // 设备上线时需要执行的业务逻辑
        log.info("监听到{}设备上线: {}", deviceType, deviceId);
        // 可以在这里添加更新数据库状态等操作
    }
    
    @Override
    public void onDeviceOffline(String deviceType, String deviceId) {
        // 设备下线时需要执行的业务逻辑
        log.info("监听到{}设备下线: {}", deviceType, deviceId);
        // 可以在这里添加更新数据库状态等操作
    }
}
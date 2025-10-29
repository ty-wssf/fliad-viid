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

import cn.hutool.core.util.StrUtil;
import com.fliad.common.cache.CommonCacheOperator;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 设备状态服务类
 * 提供设备状态管理的完整实现，支持监听器模式
 *
 * @author lingma
 * @date 2025/10/29
 */
@Component
public class DeviceStatusService {
    
    private static final Logger log = LoggerFactory.getLogger(DeviceStatusService.class);
    
    @Inject
    private DeviceStateManager deviceStateManager;
    
    @Inject
    private CommonCacheOperator cacheOperator;
    
    /**
     * 设备状态监听器列表
     */
    private final List<DeviceStatusChangeListener> listeners = new CopyOnWriteArrayList<>();
    
    public DeviceStatusService() {
        // 设置状态管理器的回调函数
        deviceStateManager.setStatusChangeCallback(this::handleStatusChange);
    }
    
    /**
     * 添加设备状态监听器
     *
     * @param listener 监听器
     */
    public void addListener(DeviceStatusChangeListener listener) {
        if (listener != null) {
            listeners.add(listener);
        }
    }
    
    /**
     * 移除设备状态监听器
     *
     * @param listener 监听器
     */
    public void removeListener(DeviceStatusChangeListener listener) {
        if (listener != null) {
            listeners.remove(listener);
        }
    }
    
    /**
     * 处理设备状态变更内部回调
     *
     * @param deviceId 设备ID
     * @param status   状态 (online/offline)
     */
    private void handleStatusChange(String deviceId, String status) {
        if ("online".equals(status)) {
            listeners.forEach(listener -> {
                try {
                    listener.onDeviceOnline(deviceId);
                } catch (Exception e) {
                    log.error("调用设备上线监听器异常，设备ID: {}", deviceId, e);
                }
            });
        } else if ("offline".equals(status)) {
            listeners.forEach(listener -> {
                try {
                    listener.onDeviceOffline(deviceId);
                } catch (Exception e) {
                    log.error("调用设备下线监听器异常，设备ID: {}", deviceId, e);
                }
            });
        }
    }
    
    /**
     * 处理设备在线事件
     *
     * @param deviceId 设备ID
     * @return true-状态已变更，false-状态未变更
     */
    public boolean handleOnlineEvent(String deviceId) {
        if (StrUtil.isBlank(deviceId)) {
            log.warn("设备ID为空，无法处理在线事件");
            return false;
        }
        
        return deviceStateManager.handleOnlineEvent(deviceId);
    }
    
    /**
     * 处理设备离线事件
     *
     * @param deviceId 设备ID
     * @return true-状态已变更，false-状态未变更
     */
    public boolean handleOfflineEvent(String deviceId) {
        if (StrUtil.isBlank(deviceId)) {
            log.warn("设备ID为空，无法处理离线事件");
            return false;
        }
        
        return deviceStateManager.handleOfflineEvent(deviceId);
    }
    
    /**
     * 检查设备是否在线
     *
     * @param deviceId 设备ID
     * @return true-在线，false-离线
     */
    public boolean isOnline(String deviceId) {
        if (StrUtil.isBlank(deviceId)) {
            return false;
        }
        
        return deviceStateManager.isOnline(deviceId);
    }
    
    /**
     * 获取当前在线设备数量
     *
     * @return 在线设备数量
     */
    public int getOnlineDeviceCount() {
        return deviceStateManager.getOnlineEntityCount();
    }
    
    /**
     * 设置设备超时时间
     *
     * @param timeoutMillis 超时时间（毫秒）
     */
    public void setDeviceTimeoutMillis(long timeoutMillis) {
        deviceStateManager.setEntityTimeoutMillis(timeoutMillis);
    }
    
    /**
     * 启用定时检测功能
     */
    public void enableScheduledCheck() {
        deviceStateManager.enableScheduledCheck();
    }
    
    /**
     * 禁用定时检测功能
     */
    public void disableScheduledCheck() {
        deviceStateManager.disableScheduledCheck();
    }
    
    /**
     * 检查定时检测功能是否启用
     *
     * @return true-启用，false-禁用
     */
    public boolean isScheduledCheckEnabled() {
        return deviceStateManager.isScheduledCheckEnabled();
    }
    
    /**
     * 执行定时检测，将超时的设备标记为离线
     *
     * @return 被标记为离线的设备数量
     */
    public int performScheduledCheck() {
        return deviceStateManager.performScheduledCheck();
    }
}
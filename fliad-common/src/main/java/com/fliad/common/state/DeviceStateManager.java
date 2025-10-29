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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 通用设备状态管理器
 * 用于管理设备在线/离线状态，避免重复处理状态事件
 *
 * @author lingma
 * @date 2025/10/29
 */
@Component
public class DeviceStateManager extends AbstractStateManager<String> {
    
    private static final String ONLINE_DEVICE_PREFIX = "device:online:";
    
    /**
     * 设备最后活跃时间记录
     */
    private final Map<String, Long> deviceLastActiveTime = new ConcurrentHashMap<>();
    
    /**
     * 定时检测功能开关
     */
    private final AtomicBoolean enableScheduledCheck = new AtomicBoolean(false);
    
    /**
     * 设备超时时间（毫秒），默认300秒
     */
    private volatile long deviceTimeoutMillis = 300 * 1000L;

    public DeviceStateManager(CommonCacheOperator cacheOperator) {
        super(cacheOperator);
    }

    @Override
    protected String getOnlineEntityCachePrefix() {
        return ONLINE_DEVICE_PREFIX;
    }

    @Override
    protected String getEntityId(String entity) {
        return entity;
    }
    
    /**
     * 处理设备在线事件
     *
     * @param deviceId 设备ID
     * @return true-状态已变更，false-状态未变更
     */
    @Override
    public boolean handleOnlineEvent(String deviceId) {
        // 更新设备最后活跃时间
        if (enableScheduledCheck.get() && StrUtil.isNotBlank(deviceId)) {
            deviceLastActiveTime.put(deviceId, System.currentTimeMillis());
        }
        
        return super.handleOnlineEvent(deviceId);
    }
    
    /**
     * 处理设备离线事件
     *
     * @param deviceId 设备ID
     * @return true-状态已变更，false-状态未变更
     */
    @Override
    public boolean handleOfflineEvent(String deviceId) {
        // 移除设备最后活跃时间记录
        if (enableScheduledCheck.get() && StrUtil.isNotBlank(deviceId)) {
            deviceLastActiveTime.remove(deviceId);
        }
        
        return super.handleOfflineEvent(deviceId);
    }
    
    /**
     * 检查设备是否在线
     *
     * @param deviceId 设备ID
     * @return true-在线，false-离线
     */
    public boolean isOnline(String deviceId) {
        return super.isOnlineById(deviceId);
    }
    
    /**
     * 设置设备超时时间
     *
     * @param timeoutMillis 超时时间（毫秒）
     */
    public void setDeviceTimeoutMillis(long timeoutMillis) {
        this.deviceTimeoutMillis = timeoutMillis;
    }
    
    /**
     * 启用定时检测功能
     */
    public void enableScheduledCheck() {
        this.enableScheduledCheck.set(true);
    }
    
    /**
     * 禁用定时检测功能
     */
    public void disableScheduledCheck() {
        this.enableScheduledCheck.set(false);
    }
    
    /**
     * 检查定时检测功能是否启用
     *
     * @return true-启用，false-禁用
     */
    public boolean isScheduledCheckEnabled() {
        return this.enableScheduledCheck.get();
    }
    
    /**
     * 执行定时检测，将超时的设备标记为离线
     *
     * @return 被标记为离线的设备数量
     */
    public int performScheduledCheck() {
        if (!enableScheduledCheck.get()) {
            return 0;
        }
        
        long currentTime = System.currentTimeMillis();
        int offlineCount = 0;
        
        // 检查所有在线设备
        for (String deviceId : getOnlineEntities()) {
            Long lastActiveTime = deviceLastActiveTime.get(deviceId);
            if (lastActiveTime != null && (currentTime - lastActiveTime) > deviceTimeoutMillis) {
                // 设备超时，标记为离线
                if (handleOfflineEvent(deviceId)) {
                    offlineCount++;
                }
            }
        }
        
        return offlineCount;
    }
}
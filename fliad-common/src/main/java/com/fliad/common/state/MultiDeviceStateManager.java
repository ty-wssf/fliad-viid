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

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.fliad.common.cache.CommonCacheOperator;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;

/**
 * 多设备类型状态管理器
 * 支持管理多种不同类型的设备状态
 *
 * @author lingma
 * @date 2025/10/29
 */
@Component
public class MultiDeviceStateManager {
    
    private static final Logger log = LoggerFactory.getLogger(MultiDeviceStateManager.class);
    
    @Inject
    private CommonCacheOperator cacheOperator;
    
    /**
     * 不同类型设备的状态管理器映射
     * key: 设备类型标识
     * value: 对应的状态管理器
     */
    private final Map<String, AbstractStateManager<Object>> stateManagers = new ConcurrentHashMap<>();
    
    /**
     * 设备状态监听器列表
     */
    private final List<MultiDeviceStatusChangeListener> listeners = new CopyOnWriteArrayList<>();
    
    /**
     * 注册设备状态管理器
     *
     * @param deviceType 设备类型标识
     * @param stateManager 状态管理器
     */
    public void registerStateManager(String deviceType, AbstractStateManager<?> stateManager) {
        if (StrUtil.isBlank(deviceType) || stateManager == null) {
            log.warn("设备类型或状态管理器为空，无法注册");
            return;
        }
        
        // 设置状态管理器的回调函数
        stateManager.setStatusChangeCallback((deviceId, status) -> {
            // 通知所有监听器
            listeners.forEach(listener -> {
                try {
                    if ("online".equals(status)) {
                        listener.onDeviceOnline(deviceType, deviceId);
                    } else if ("offline".equals(status)) {
                        listener.onDeviceOffline(deviceType, deviceId);
                    }
                } catch (Exception e) {
                    log.error("调用设备状态变更监听器异常，设备类型: {}, 设备ID: {}", deviceType, deviceId, e);
                }
            });
        });
        
        stateManagers.put(deviceType, (AbstractStateManager<Object>) stateManager);
        log.info("已注册设备类型{}的状态管理器", deviceType);
    }
    
    /**
     * 移除设备状态管理器
     *
     * @param deviceType 设备类型标识
     */
    public void unregisterStateManager(String deviceType) {
        if (StrUtil.isBlank(deviceType)) {
            log.warn("设备类型为空，无法移除状态管理器");
            return;
        }
        
        AbstractStateManager<Object> removed = stateManagers.remove(deviceType);
        if (removed != null) {
            log.info("已移除设备类型{}的状态管理器", deviceType);
        }
    }
    
    /**
     * 获取设备状态管理器
     *
     * @param deviceType 设备类型标识
     * @return 状态管理器
     */
    @SuppressWarnings("unchecked")
    public <T> AbstractStateManager<T> getStateManager(String deviceType) {
        if (StrUtil.isBlank(deviceType)) {
            return null;
        }
        
        return (AbstractStateManager<T>) stateManagers.get(deviceType);
    }
    
    /**
     * 添加设备状态监听器
     *
     * @param listener 监听器
     */
    public void addListener(MultiDeviceStatusChangeListener listener) {
        if (listener != null) {
            listeners.add(listener);
        }
    }
    
    /**
     * 移除设备状态监听器
     *
     * @param listener 监听器
     */
    public void removeListener(MultiDeviceStatusChangeListener listener) {
        if (listener != null) {
            listeners.remove(listener);
        }
    }
    
    /**
     * 处理设备在线事件
     *
     * @param deviceType 设备类型标识
     * @param device 设备对象
     * @return true-状态已变更，false-状态未变更
     */
    public <T> boolean handleOnlineEvent(String deviceType, T device) {
        if (StrUtil.isBlank(deviceType) || device == null) {
            log.warn("设备类型或设备对象为空，无法处理在线事件");
            return false;
        }
        
        AbstractStateManager<T> stateManager = getStateManager(deviceType);
        if (stateManager == null) {
            log.warn("未找到设备类型{}的状态管理器", deviceType);
            return false;
        }
        
        return stateManager.handleOnlineEvent(device);
    }
    
    /**
     * 处理设备离线事件
     *
     * @param deviceType 设备类型标识
     * @param device 设备对象
     * @return true-状态已变更，false-状态未变更
     */
    public <T> boolean handleOfflineEvent(String deviceType, T device) {
        if (StrUtil.isBlank(deviceType) || device == null) {
            log.warn("设备类型或设备对象为空，无法处理离线事件");
            return false;
        }
        
        AbstractStateManager<T> stateManager = getStateManager(deviceType);
        if (stateManager == null) {
            log.warn("未找到设备类型{}的状态管理器", deviceType);
            return false;
        }
        
        return stateManager.handleOfflineEvent(device);
    }
    
    /**
     * 检查设备是否在线
     *
     * @param deviceType 设备类型标识
     * @param device 设备对象
     * @return true-在线，false-离线
     */
    public <T> boolean isOnline(String deviceType, T device) {
        if (StrUtil.isBlank(deviceType) || device == null) {
            return false;
        }
        
        AbstractStateManager<T> stateManager = getStateManager(deviceType);
        if (stateManager == null) {
            return false;
        }
        
        return stateManager.isOnline(device);
    }
    
    /**
     * 获取指定类型设备的在线数量
     *
     * @param deviceType 设备类型标识
     * @return 在线设备数量
     */
    public int getOnlineDeviceCount(String deviceType) {
        if (StrUtil.isBlank(deviceType)) {
            return 0;
        }
        
        AbstractStateManager<Object> stateManager = stateManagers.get(deviceType);
        if (stateManager == null) {
            return 0;
        }
        
        return stateManager.getOnlineEntityCount();
    }
    
    /**
     * 获取所有在线设备数量
     *
     * @return 在线设备总数量
     */
    public int getTotalOnlineDeviceCount() {
        return stateManagers.values().stream()
                .mapToInt(AbstractStateManager::getOnlineEntityCount)
                .sum();
    }
    
    /**
     * 获取指定类型的所有在线设备ID
     *
     * @param deviceType 设备类型标识
     * @return 在线设备ID集合
     */
    public Set<String> getOnlineDevices(String deviceType) {
        if (StrUtil.isBlank(deviceType)) {
            return CollectionUtil.newHashSet();
        }
        
        AbstractStateManager<Object> stateManager = stateManagers.get(deviceType);
        if (stateManager == null) {
            return CollectionUtil.newHashSet();
        }
        
        return stateManager.getOnlineEntities();
    }
    
    /**
     * 获取所有在线设备ID
     *
     * @return 所有在线设备ID集合，key为设备类型，value为设备ID集合
     */
    public Map<String, Set<String>> getAllOnlineDevices() {
        Map<String, Set<String>> result = new ConcurrentHashMap<>();
        stateManagers.forEach((deviceType, stateManager) -> {
            result.put(deviceType, stateManager.getOnlineEntities());
        });
        return result;
    }
    
    /**
     * 设置设备超时时间
     *
     * @param deviceType 设备类型标识
     * @param timeoutMillis 超时时间（毫秒）
     */
    public void setDeviceTimeoutMillis(String deviceType, long timeoutMillis) {
        if (StrUtil.isBlank(deviceType)) {
            log.warn("设备类型为空，无法设置超时时间");
            return;
        }
        
        AbstractStateManager<Object> stateManager = stateManagers.get(deviceType);
        if (stateManager == null) {
            log.warn("未找到设备类型{}的状态管理器", deviceType);
            return;
        }
        
        stateManager.setEntityTimeoutMillis(timeoutMillis);
    }
    
    /**
     * 启用指定类型设备的定时检测功能
     *
     * @param deviceType 设备类型标识
     */
    public void enableScheduledCheck(String deviceType) {
        if (StrUtil.isBlank(deviceType)) {
            log.warn("设备类型为空，无法启用定时检测功能");
            return;
        }
        
        AbstractStateManager<Object> stateManager = stateManagers.get(deviceType);
        if (stateManager == null) {
            log.warn("未找到设备类型{}的状态管理器", deviceType);
            return;
        }
        
        stateManager.enableScheduledCheck();
    }
    
    /**
     * 禁用指定类型设备的定时检测功能
     *
     * @param deviceType 设备类型标识
     */
    public void disableScheduledCheck(String deviceType) {
        if (StrUtil.isBlank(deviceType)) {
            log.warn("设备类型为空，无法禁用定时检测功能");
            return;
        }
        
        AbstractStateManager<Object> stateManager = stateManagers.get(deviceType);
        if (stateManager == null) {
            log.warn("未找到设备类型{}的状态管理器", deviceType);
            return;
        }
        
        stateManager.disableScheduledCheck();
    }
    
    /**
     * 启用所有设备类型的定时检测功能
     */
    public void enableAllScheduledCheck() {
        stateManagers.values().forEach(AbstractStateManager::enableScheduledCheck);
    }
    
    /**
     * 禁用所有设备类型的定时检测功能
     */
    public void disableAllScheduledCheck() {
        stateManagers.values().forEach(AbstractStateManager::disableScheduledCheck);
    }
    
    /**
     * 执行指定类型设备的定时检测
     *
     * @param deviceType 设备类型标识
     * @return 被标记为离线的设备数量
     */
    public int performScheduledCheck(String deviceType) {
        if (StrUtil.isBlank(deviceType)) {
            return 0;
        }
        
        AbstractStateManager<Object> stateManager = stateManagers.get(deviceType);
        if (stateManager == null) {
            return 0;
        }
        
        return stateManager.performScheduledCheck();
    }
    
    /**
     * 执行所有设备类型的定时检测
     *
     * @return 被标记为离线的设备总数量
     */
    public int performAllScheduledCheck() {
        return stateManagers.values().stream()
                .mapToInt(AbstractStateManager::performScheduledCheck)
                .sum();
    }
}
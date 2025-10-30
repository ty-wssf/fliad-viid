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
import org.noear.solon.core.bean.LifecycleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 设备状态管理器
 * 支持管理单设备或多设备类型的在线/离线状态
 *
 * @author lingma
 * @date 2025/10/30
 */
public class DeviceStateManager implements LifecycleBean {

    private static final Logger log = LoggerFactory.getLogger(DeviceStateManager.class);

    private static final String DEFAULT_DEVICE_TYPE = "default";
    private static final String ONLINE_DEVICE_PREFIX = "device:online:";

    // 定时任务执行器
    private ScheduledExecutorService scheduledExecutorService;

    // 定时检测间隔（毫秒），默认60秒
    private long checkIntervalMillis = 60 * 1000L;

    private final CommonCacheOperator cacheOperator;

    /**
     * 不同类型设备的状态管理器映射
     * key: 设备类型标识
     * value: 对应的状态管理器
     */
    private final Map<String, DeviceTypeStateManager> stateManagers = new ConcurrentHashMap<>();

    /**
     * 设备状态监听器列表
     */
    private final List<DeviceStatusChangeListener> listeners = new CopyOnWriteArrayList<>();

    /**
     * 多设备状态监听器列表
     */
    private final List<MultiDeviceStatusChangeListener> multiListeners = new CopyOnWriteArrayList<>();


    @Override
    public void start() throws Throwable {
        // 初始化定时任务执行器
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(r -> {
                Thread t = new Thread(r, "device-state-manager-scheduler");
                t.setDaemon(true);
                return t;
            });

            // 启动定时检测任务
            scheduledExecutorService.scheduleWithFixedDelay(this::performAllScheduledCheck,
                    checkIntervalMillis, checkIntervalMillis, TimeUnit.MILLISECONDS);

            log.info("设备状态管理器定时检测任务已启动，检测间隔: {}ms", checkIntervalMillis);
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
            log.info("设备状态管理器定时检测任务已停止");
        }
    }

    /**
     * 构造一个新的设备状态管理器
     *
     * @param cacheOperator 缓存操作器
     */
    public DeviceStateManager(CommonCacheOperator cacheOperator) {
        this.cacheOperator = cacheOperator;
        // 默认创建一个设备类型管理器
        DeviceTypeStateManager defaultManager = new DeviceTypeStateManager(cacheOperator, ONLINE_DEVICE_PREFIX, DEFAULT_DEVICE_TYPE);
        defaultManager.setStatusChangeCallback(this::handleStatusChange);
        stateManagers.put(DEFAULT_DEVICE_TYPE, defaultManager);
    }

    /**
     * 处理状态变更事件
     *
     * @param deviceId 设备ID
     * @param status   状态 (online/offline)
     */
    private void handleStatusChange(String deviceId, String status) {
        // 通知单设备监听器
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

        // 通知多设备监听器
        // 查找设备所属的类型
        String deviceType = findDeviceType(deviceId);
        if (deviceType != null) {
            multiListeners.forEach(listener -> {
                try {
                    if ("online".equals(status)) {
                        listener.onDeviceOnline(deviceType, deviceId);
                    } else if ("offline".equals(status)) {
                        listener.onDeviceOffline(deviceType, deviceId);
                    }
                } catch (Exception e) {
                    log.error("调用多设备状态变更监听器异常，设备类型: {}, 设备ID: {}", deviceType, deviceId, e);
                }
            });
        }
    }

    /**
     * 查找设备所属的类型
     *
     * @param deviceId 设备ID
     * @return 设备类型
     */
    private String findDeviceType(String deviceId) {
        for (Map.Entry<String, DeviceTypeStateManager> entry : stateManagers.entrySet()) {
            if (entry.getValue().isOnlineById(deviceId)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * 注册设备类型状态管理器
     *
     * @param deviceType  设备类型标识
     * @param cachePrefix 缓存前缀
     */
    public void registerDeviceType(String deviceType, String cachePrefix) {
        if (StrUtil.isBlank(deviceType)) {
            log.warn("设备类型为空，无法注册");
            return;
        }

        if (stateManagers.containsKey(deviceType)) {
            log.warn("设备类型{}已存在，无需重复注册", deviceType);
            return;
        }

        DeviceTypeStateManager stateManager = new DeviceTypeStateManager(cacheOperator, cachePrefix, deviceType);
        stateManager.setStatusChangeCallback((deviceId, status) -> {
            // 传递设备类型信息给回调
            this.handleStatusChangeWithDeviceType(deviceId, status, deviceType);
        });
        stateManagers.put(deviceType, stateManager);
        log.info("已注册设备类型{}的状态管理器", deviceType);
    }

    /**
     * 处理带设备类型的状态变更事件
     *
     * @param deviceId   设备ID
     * @param status     状态 (online/offline)
     * @param deviceType 设备类型
     */
    private void handleStatusChangeWithDeviceType(String deviceId, String status, String deviceType) {
        // 通知单设备监听器
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

        // 通知多设备监听器（使用传递的设备类型）
        multiListeners.forEach(listener -> {
            try {
                if ("online".equals(status)) {
                    listener.onDeviceOnline(deviceType, deviceId);
                } else if ("offline".equals(status)) {
                    listener.onDeviceOffline(deviceType, deviceId);
                }
            } catch (Exception e) {
                log.error("调用多设备状态变更监听器异常，设备类型: {}, 设备ID: {}", deviceType, deviceId, e);
            }
        });
    }

    /**
     * 移除设备类型状态管理器
     *
     * @param deviceType 设备类型标识
     */
    public void unregisterDeviceType(String deviceType) {
        if (StrUtil.isBlank(deviceType)) {
            log.warn("设备类型为空，无法移除状态管理器");
            return;
        }

        // 不允许移除默认设备类型
        if (DEFAULT_DEVICE_TYPE.equals(deviceType)) {
            log.warn("不允许移除默认设备类型");
            return;
        }

        DeviceTypeStateManager removed = stateManagers.remove(deviceType);
        if (removed != null) {
            log.info("已移除设备类型{}的状态管理器", deviceType);
        }
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
     * 添加多设备状态监听器
     *
     * @param listener 监听器
     */
    public void addListener(MultiDeviceStatusChangeListener listener) {
        if (listener != null) {
            multiListeners.add(listener);
        }
    }

    /**
     * 移除多设备状态监听器
     *
     * @param listener 监听器
     */
    public void removeListener(MultiDeviceStatusChangeListener listener) {
        if (listener != null) {
            multiListeners.remove(listener);
        }
    }

    /**
     * 处理设备在线事件（默认设备类型）
     *
     * @param deviceId 设备ID
     * @return true-状态已变更，false-状态未变更
     */
    public boolean handleOnlineEvent(String deviceId) {
        return handleOnlineEvent(DEFAULT_DEVICE_TYPE, deviceId);
    }

    /**
     * 处理设备在线事件
     *
     * @param deviceType 设备类型标识
     * @param deviceId   设备ID
     * @return true-状态已变更，false-状态未变更
     */
    public boolean handleOnlineEvent(String deviceType, String deviceId) {
        if (StrUtil.isBlank(deviceType) || StrUtil.isBlank(deviceId)) {
            log.warn("设备类型或设备ID为空，无法处理在线事件");
            return false;
        }

        DeviceTypeStateManager stateManager = stateManagers.get(deviceType);
        if (stateManager == null) {
            log.warn("未找到设备类型{}的状态管理器", deviceType);
            return false;
        }

        return stateManager.handleOnlineEvent(deviceId);
    }

    /**
     * 处理设备离线事件（默认设备类型）
     *
     * @param deviceId 设备ID
     * @return true-状态已变更，false-状态未变更
     */
    public boolean handleOfflineEvent(String deviceId) {
        return handleOfflineEvent(DEFAULT_DEVICE_TYPE, deviceId);
    }

    /**
     * 处理设备离线事件
     *
     * @param deviceType 设备类型标识
     * @param deviceId   设备ID
     * @return true-状态已变更，false-状态未变更
     */
    public boolean handleOfflineEvent(String deviceType, String deviceId) {
        if (StrUtil.isBlank(deviceType) || StrUtil.isBlank(deviceId)) {
            log.warn("设备类型或设备ID为空，无法处理离线事件");
            return false;
        }

        DeviceTypeStateManager stateManager = stateManagers.get(deviceType);
        if (stateManager == null) {
            log.warn("未找到设备类型{}的状态管理器", deviceType);
            return false;
        }

        return stateManager.handleOfflineEvent(deviceId);
    }

    /**
     * 检查设备是否在线（默认设备类型）
     *
     * @param deviceId 设备ID
     * @return true-在线，false-离线
     */
    public boolean isOnline(String deviceId) {
        return isOnline(DEFAULT_DEVICE_TYPE, deviceId);
    }

    /**
     * 检查设备是否在线
     *
     * @param deviceType 设备类型标识
     * @param deviceId   设备ID
     * @return true-在线，false-离线
     */
    public boolean isOnline(String deviceType, String deviceId) {
        if (StrUtil.isBlank(deviceType) || StrUtil.isBlank(deviceId)) {
            return false;
        }

        DeviceTypeStateManager stateManager = stateManagers.get(deviceType);
        if (stateManager == null) {
            return false;
        }

        return stateManager.isOnlineById(deviceId);
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

        DeviceTypeStateManager stateManager = stateManagers.get(deviceType);
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
                .mapToInt(DeviceTypeStateManager::getOnlineEntityCount)
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

        DeviceTypeStateManager stateManager = stateManagers.get(deviceType);
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
     * 设置设备超时时间（默认设备类型）
     *
     * @param timeoutMillis 超时时间（毫秒）
     */
    public void setDeviceTimeoutMillis(long timeoutMillis) {
        setDeviceTimeoutMillis(DEFAULT_DEVICE_TYPE, timeoutMillis);
    }

    /**
     * 设置设备超时时间
     *
     * @param deviceType    设备类型标识
     * @param timeoutMillis 超时时间（毫秒）
     */
    public void setDeviceTimeoutMillis(String deviceType, long timeoutMillis) {
        if (StrUtil.isBlank(deviceType)) {
            log.warn("设备类型为空，无法设置超时时间");
            return;
        }

        DeviceTypeStateManager stateManager = stateManagers.get(deviceType);
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

        DeviceTypeStateManager stateManager = stateManagers.get(deviceType);
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

        DeviceTypeStateManager stateManager = stateManagers.get(deviceType);
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
        stateManagers.values().forEach(DeviceTypeStateManager::enableScheduledCheck);
    }

    /**
     * 禁用所有设备类型的定时检测功能
     */
    public void disableAllScheduledCheck() {
        stateManagers.values().forEach(DeviceTypeStateManager::disableScheduledCheck);
    }

    /**
     * 检查定时检测功能是否启用（默认设备类型）
     *
     * @return true-启用，false-禁用
     */
    public boolean isScheduledCheckEnabled() {
        return isScheduledCheckEnabled(DEFAULT_DEVICE_TYPE);
    }

    /**
     * 检查指定设备类型的定时检测功能是否启用
     *
     * @param deviceType 设备类型标识
     * @return true-启用，false-禁用
     */
    public boolean isScheduledCheckEnabled(String deviceType) {
        if (StrUtil.isBlank(deviceType)) {
            return false;
        }

        DeviceTypeStateManager stateManager = stateManagers.get(deviceType);
        if (stateManager == null) {
            return false;
        }

        return stateManager.isScheduledCheckEnabled();
    }

    /**
     * 执行定时检测，将超时的设备标记为离线（默认设备类型）
     *
     * @return 被标记为离线的设备数量
     */
    public int performScheduledCheck() {
        return performScheduledCheck(DEFAULT_DEVICE_TYPE);
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

        DeviceTypeStateManager stateManager = stateManagers.get(deviceType);
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
                .mapToInt(DeviceTypeStateManager::performScheduledCheck)
                .sum();
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
     * 获取所有设备类型
     *
     * @return 设备类型列表
     */
    public Set<String> getDeviceTypes() {
        return stateManagers.keySet();
    }
}
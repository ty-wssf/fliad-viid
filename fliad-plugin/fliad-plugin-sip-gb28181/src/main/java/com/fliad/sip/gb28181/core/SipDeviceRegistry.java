package com.fliad.sip.gb28181.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * 设备注册管理器
 *
 * @author your-name
 * @since 0.1.0
 */
public class SipDeviceRegistry {
    private static final Logger log = LoggerFactory.getLogger(SipDeviceRegistry.class);

    /**
     * 设备注册表，key为设备ID，value为设备信息
     */
    private final Map<String, Object> deviceRegistry = new ConcurrentHashMap<>();
    
    /**
     * 设备最后活动时间，key为设备ID，value为时间戳
     */
    private final Map<String, Long> deviceLastActive = new ConcurrentHashMap<>();

    /**
     * 单例实例
     */
    private static SipDeviceRegistry instance;

    private SipDeviceRegistry() {
        // 私有构造函数
    }

    /**
     * 获取单例实例
     *
     * @return SipDeviceRegistry实例
     */
    public static SipDeviceRegistry getInstance() {
        if (instance == null) {
            synchronized (SipDeviceRegistry.class) {
                if (instance == null) {
                    instance = new SipDeviceRegistry();
                }
            }
        }
        return instance;
    }

    /**
     * 注册设备
     *
     * @param deviceId 设备ID
     * @param deviceInfo 设备信息
     */
    public void registerDevice(String deviceId, Object deviceInfo) {
        deviceRegistry.put(deviceId, deviceInfo);
        deviceLastActive.put(deviceId, System.currentTimeMillis());
        log.info("Device registered: {}", deviceId);
    }

    /**
     * 注销设备
     *
     * @param deviceId 设备ID
     */
    public void unregisterDevice(String deviceId) {
        deviceRegistry.remove(deviceId);
        deviceLastActive.remove(deviceId);
        log.info("Device unregistered: {}", deviceId);
    }

    /**
     * 获取设备信息
     *
     * @param deviceId 设备ID
     * @return 设备信息
     */
    public Object getDevice(String deviceId) {
        updateDeviceActivity(deviceId);
        return deviceRegistry.get(deviceId);
    }

    /**
     * 检查设备是否存在
     *
     * @param deviceId 设备ID
     * @return 是否存在
     */
    public boolean isDeviceRegistered(String deviceId) {
        updateDeviceActivity(deviceId);
        return deviceRegistry.containsKey(deviceId);
    }

    /**
     * 获取注册的设备数量
     *
     * @return 设备数量
     */
    public int getRegisteredDeviceCount() {
        return deviceRegistry.size();
    }
    
    /**
     * 获取所有注册的设备ID
     *
     * @return 设备ID集合
     */
    public Set<String> getAllDeviceIds() {
        return deviceRegistry.keySet();
    }
    
    /**
     * 获取所有注册的设备信息
     *
     * @return 设备信息列表
     */
    public List<Object> getAllDevices() {
        return new ArrayList<>(deviceRegistry.values());
    }
    
    /**
     * 更新设备活动时间
     *
     * @param deviceId 设备ID
     */
    private void updateDeviceActivity(String deviceId) {
        if (deviceRegistry.containsKey(deviceId)) {
            deviceLastActive.put(deviceId, System.currentTimeMillis());
        }
    }
    
    /**
     * 获取设备最后活动时间
     *
     * @param deviceId 设备ID
     * @return 最后活动时间戳
     */
    public Long getDeviceLastActiveTime(String deviceId) {
        return deviceLastActive.get(deviceId);
    }
    
    /**
     * 检查设备是否超时（默认300秒）
     *
     * @param deviceId 设备ID
     * @return 是否超时
     */
    public boolean isDeviceTimeout(String deviceId) {
        return isDeviceTimeout(deviceId, 300000); // 5分钟
    }
    
    /**
     * 检查设备是否超时
     *
     * @param deviceId 设备ID
     * @param timeout 超时时间（毫秒）
     * @return 是否超时
     */
    public boolean isDeviceTimeout(String deviceId, long timeout) {
        Long lastActive = deviceLastActive.get(deviceId);
        if (lastActive == null) {
            return true; // 如果没有活动记录，则认为超时
        }
        return (System.currentTimeMillis() - lastActive) > timeout;
    }
    
    /**
     * 清理超时设备
     *
     * @param timeout 超时时间（毫秒）
     * @return 清理的设备数量
     */
    public int cleanupTimeoutDevices(long timeout) {
        int count = 0;
        for (String deviceId : new ArrayList<>(deviceRegistry.keySet())) {
            if (isDeviceTimeout(deviceId, timeout)) {
                unregisterDevice(deviceId);
                count++;
            }
        }
        return count;
    }
    
    /**
     * 清理所有设备（用于系统关闭时）
     */
    public void clearAllDevices() {
        deviceRegistry.clear();
        deviceLastActive.clear();
    }
}
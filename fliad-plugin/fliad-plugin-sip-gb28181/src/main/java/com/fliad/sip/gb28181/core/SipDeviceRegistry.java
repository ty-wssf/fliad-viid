package com.fliad.sip.gb28181.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

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
        log.info("Device registered: {}", deviceId);
    }

    /**
     * 注销设备
     *
     * @param deviceId 设备ID
     */
    public void unregisterDevice(String deviceId) {
        deviceRegistry.remove(deviceId);
        log.info("Device unregistered: {}", deviceId);
    }

    /**
     * 获取设备信息
     *
     * @param deviceId 设备ID
     * @return 设备信息
     */
    public Object getDevice(String deviceId) {
        return deviceRegistry.get(deviceId);
    }

    /**
     * 检查设备是否存在
     *
     * @param deviceId 设备ID
     * @return 是否存在
     */
    public boolean isDeviceRegistered(String deviceId) {
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
}
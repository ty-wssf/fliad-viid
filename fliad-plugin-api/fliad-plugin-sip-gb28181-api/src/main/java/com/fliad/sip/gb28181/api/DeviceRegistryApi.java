package com.fliad.sip.gb28181.api;

/**
 * 设备注册管理API接口
 *
 * @author your-name
 * @since 0.1.0
 */
public interface DeviceRegistryApi {
    
    /**
     * 注册设备
     *
     * @param deviceId 设备ID
     * @param deviceInfo 设备信息
     */
    void registerDevice(String deviceId, Object deviceInfo);
    
    /**
     * 注销设备
     *
     * @param deviceId 设备ID
     */
    void unregisterDevice(String deviceId);
    
    /**
     * 获取设备信息
     *
     * @param deviceId 设备ID
     * @return 设备信息
     */
    Object getDevice(String deviceId);
    
    /**
     * 检查设备是否存在
     *
     * @param deviceId 设备ID
     * @return 是否存在
     */
    boolean isDeviceRegistered(String deviceId);
    
    /**
     * 获取注册的设备数量
     *
     * @return 设备数量
     */
    int getRegisteredDeviceCount();
}
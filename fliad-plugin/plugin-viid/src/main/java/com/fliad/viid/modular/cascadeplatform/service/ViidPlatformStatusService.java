package com.fliad.viid.modular.cascadeplatform.service;

import java.util.Date;

/**
 * 视图库平台状态Service接口
 *
 * @author your-name
 * @since 2025-08-21
 **/
public interface ViidPlatformStatusService {

    /**
     * 判断设备是否已注册
     *
     * @param deviceId 设备ID
     * @return 是否已注册
     */
    boolean isDeviceRegistered(String deviceId);

    /**
     * 获取设备最后活跃时间
     *
     * @param deviceId 设备ID
     * @return 最后活跃时间
     */
    Date getDeviceLastActiveTime(String deviceId);

    /**
     * 更新设备最后活跃时间
     *
     * @param deviceId 设备ID
     */
    void updateDeviceLastActiveTime(String deviceId);

    /**
     * 移除设备相关信息（用于注销）
     *
     * @param deviceId 设备ID
     */
    void removeDevice(String deviceId);

    /**
     * 添加已注册设备
     *
     * @param deviceId 设备ID
     */
    void addRegisteredDevice(String deviceId);
}
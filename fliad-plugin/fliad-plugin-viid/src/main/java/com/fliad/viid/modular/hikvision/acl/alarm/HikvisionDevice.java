package com.fliad.viid.modular.hikvision.acl.alarm;

import lombok.Data;

/**
 * 海康威视设备信息类
 */
@Data
public class HikvisionDevice {
    
    /**
     * 设备唯一标识
     */
    private String deviceId;
    
    /**
     * 设备IP地址
     */
    private String ip;
    
    /**
     * 设备端口
     */
    private int port;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 密码
     */
    private String password;
    
    /**
     * 用户ID（登录后获得）
     */
    private int userId = -1;
    
    /**
     * 构造函数
     * @param deviceId 设备唯一标识
     * @param ip 设备IP地址
     * @param port 设备端口
     * @param username 用户名
     * @param password 密码
     */
    public HikvisionDevice(String deviceId, String ip, int port, String username, String password) {
        this.deviceId = deviceId;
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
    }
}
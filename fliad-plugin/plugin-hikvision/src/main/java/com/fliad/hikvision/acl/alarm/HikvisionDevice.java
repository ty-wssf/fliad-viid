package com.fliad.hikvision.acl.alarm;

/**
 * 海康威视设备信息类
 */
public class HikvisionDevice {
    
    /**
     * 设备唯一标识
     */
    private String deviceId;
    
    /**
     * 设备编号
     */
    private String deviceNumber;
    
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
    
    /**
     * 构造函数
     * @param deviceId 设备唯一标识
     * @param deviceNumber 设备编号
     * @param ip 设备IP地址
     * @param port 设备端口
     * @param username 用户名
     * @param password 密码
     */
    public HikvisionDevice(String deviceId, String deviceNumber, String ip, int port, String username, String password) {
        this.deviceId = deviceId;
        this.deviceNumber = deviceNumber;
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    
    public String getDeviceNumber() {
        return deviceNumber;
    }
    
    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
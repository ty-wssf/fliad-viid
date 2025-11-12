package com.netsdk.alarm;

import com.netsdk.lib.NetSDKLib;

/**
 * 大华设备信息类
 */
public class DahuaDevice {
    // 设备唯一标识
    private String deviceId;
    
    // 设备编号
    private String deviceNumber;
    
    // IP地址
    private String ip;
    
    // 端口
    private int port;
    
    // 用户名
    private String username;
    
    // 密码
    private String password;
    
    // 登录句柄
    private NetSDKLib.LLong loginHandle;
    
    public DahuaDevice(String deviceId, String deviceNumber, String ip, int port, String username, String password) {
        this.deviceId = deviceId;
        this.deviceNumber = deviceNumber;
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
        this.loginHandle = new NetSDKLib.LLong(0);
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

    public NetSDKLib.LLong getLoginHandle() {
        return loginHandle;
    }

    public void setLoginHandle(NetSDKLib.LLong loginHandle) {
        this.loginHandle = loginHandle;
    }
}
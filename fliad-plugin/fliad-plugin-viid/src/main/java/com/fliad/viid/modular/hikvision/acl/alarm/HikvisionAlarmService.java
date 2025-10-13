package com.fliad.viid.modular.hikvision.acl.alarm;

import com.fliad.viid.modular.hikvision.acl.NetSDK.HCNetSDK;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;

/**
 * 海康威视报警服务类
 * 提供对外的报警管理接口
 */
@Slf4j
@Component
public class HikvisionAlarmService {
    
    @Inject
    private HikvisionAlarmManager alarmManager;
    
    /**
     * 添加并登录设备
     * @param deviceId 设备唯一标识
     * @param ip 设备IP地址
     * @param port 设备端口
     * @param username 用户名
     * @param password 密码
     * @return 是否成功
     */
    public boolean addAndLoginDevice(String deviceId, String ip, int port, String username, String password) {
        boolean added = alarmManager.addDevice(deviceId, ip, port, username, password);
        if (!added) {
            return false;
        }
        
        return alarmManager.loginDevice(deviceId);
    }
    
    /**
     * 删除设备（自动注销和撤防）
     * @param deviceId 设备唯一标识
     * @return 是否成功
     */
    public boolean removeDevice(String deviceId) {
        return alarmManager.removeDevice(deviceId);
    }
    
    /**
     * 对设备进行布防
     * @param deviceId 设备唯一标识
     * @return 布防句柄，-1表示失败
     */
    public int setupAlarmChan(String deviceId) {
        return alarmManager.setupAlarmChan(deviceId);
    }
    
    /**
     * 对设备进行撤防
     * @param deviceId 设备唯一标识
     */
    public void closeAlarmChan(String deviceId) {
        alarmManager.closeAlarmChan(deviceId);
    }
    
    /**
     * 获取设备信息
     * @param deviceId 设备唯一标识
     * @return 设备对象
     */
    public HikvisionDevice getDevice(String deviceId) {
        return alarmManager.getDevice(deviceId);
    }
    
    /**
     * 开启监听
     * @param ip 监听IP
     * @param port 监听端口
     * @return 监听句柄，-1表示失败
     */
    public int startListen(String ip, short port) {
        return alarmManager.startListen(ip, port);
    }
    
    /**
     * 停止监听
     */
    public void stopListen() {
        alarmManager.stopListen();
    }
    
    /**
     * 获取SDK实例
     * @return SDK实例
     */
    public HCNetSDK getSDK() {
        return HikvisionAlarmManager.getSDK();
    }
}
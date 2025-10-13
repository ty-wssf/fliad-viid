package com.fliad.viid.modular.hikvision.acl.alarm;

import com.fliad.dev.api.DevConfigApi;
import com.fliad.viid.modular.hikvision.acl.NetSDK.HCNetSDK;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * 海康威视设备报警管理器
 * 支持多设备管理的正式代码实现
 */
@Slf4j
@Component
public class HikvisionAlarmManager {

    private static HCNetSDK hCNetSDK = null;
    
    // 存储设备连接信息的线程安全Map
    private final Map<String, HikvisionDevice> devices = new ConcurrentHashMap<>();
    
    // 存储设备布防句柄的线程安全Map
    private final Map<String, Integer> alarmHandles = new ConcurrentHashMap<>();
    
    // 存储监听句柄
    private int listenHandle = -1;
    
    // 回调函数实例
    private HikvisionAlarmCallback alarmCallback;
    
    /**
     * 初始化SDK
     */
    public void init() {
        try {
            createSDKInstance();
            if (hCNetSDK == null) {
                log.error("海康威视SDK加载失败");
                return;
            }
            
            // 初始化SDK
            boolean initSuccess = hCNetSDK.NET_DVR_Init();
            if (!initSuccess) {
                log.error("海康威视SDK初始化失败，错误码: {}", hCNetSDK.NET_DVR_GetLastError());
                return;
            }
            
            // 设置日志
            hCNetSDK.NET_DVR_SetLogToFile(3, "./sdklog", false);
            
            // 设置报警回调函数
            alarmCallback = new HikvisionAlarmCallback(this);
            if (!hCNetSDK.NET_DVR_SetDVRMessageCallBack_V30(alarmCallback, null)) {
                log.error("设置回调函数失败，错误码: {}", hCNetSDK.NET_DVR_GetLastError());
            } else {
                log.info("设置回调函数成功");
            }
            
            // 设置JSON透传报警数据和图片分离
            HCNetSDK.NET_DVR_LOCAL_GENERAL_CFG struLocalCfg = new HCNetSDK.NET_DVR_LOCAL_GENERAL_CFG();
            struLocalCfg.byAlarmJsonPictureSeparate = 1;
            struLocalCfg.write();
            Pointer pLocalCfg = struLocalCfg.getPointer();
            hCNetSDK.NET_DVR_SetSDKLocalCfg(17, pLocalCfg);
            
            log.info("海康威视报警管理器初始化完成");
        } catch (Exception e) {
            log.error("海康威视报警管理器初始化异常", e);
        }
    }
    
    /**
     * 动态库加载
     */
    private synchronized void createSDKInstance() {
        if (hCNetSDK != null) {
            return;
        }
        
        try {
            String osName = System.getProperty("os.name");
            if (osName.toLowerCase().contains("windows")) {
                // Windows系统加载库路径
                String dllPath = System.getProperty("user.dir") + "\\lib\\HCNetSDK.dll";
                log.info("Loading Windows SDK from path: {}", dllPath);
                hCNetSDK = (HCNetSDK) Native.load(dllPath, HCNetSDK.class);
            } else {
                // Linux系统加载库路径
                String soPath = System.getProperty("user.dir") + "/lib/libhcnetsdk.so";
                log.info("Loading Linux SDK from path: {}", soPath);
                hCNetSDK = (HCNetSDK) Native.load(soPath, HCNetSDK.class);
            }
            
            log.info("海康威视SDK加载成功");
        } catch (Exception e) {
            log.error("海康威视SDK加载失败", e);
            hCNetSDK = null;
        }
    }
    
    /**
     * 添加设备
     * @param deviceId 设备唯一标识
     * @param ip 设备IP地址
     * @param port 设备端口
     * @param username 用户名
     * @param password 密码
     * @return 是否添加成功
     */
    public boolean addDevice(String deviceId, String ip, int port, String username, String password) {
        if (devices.containsKey(deviceId)) {
            log.warn("设备 {} 已存在", deviceId);
            return false;
        }
        
        try {
            HikvisionDevice device = new HikvisionDevice(deviceId, ip, port, username, password);
            devices.put(deviceId, device);
            log.info("成功添加设备: {}", deviceId);
            return true;
        } catch (Exception e) {
            log.error("添加设备 {} 失败", deviceId, e);
            return false;
        }
    }
    
    /**
     * 删除设备
     * @param deviceId 设备唯一标识
     * @return 是否删除成功
     */
    public boolean removeDevice(String deviceId) {
        HikvisionDevice device = devices.remove(deviceId);
        if (device != null) {
            // 如果设备已布防，先撤防
            if (alarmHandles.containsKey(deviceId)) {
                closeAlarmChan(deviceId);
            }
            
            // 如果设备已登录，先注销
            if (device.getUserId() > -1) {
                logoutDevice(deviceId);
            }
            
            log.info("成功删除设备: {}", deviceId);
            return true;
        }
        
        log.warn("设备 {} 不存在", deviceId);
        return false;
    }
    
    /**
     * 登录设备
     * @param deviceId 设备唯一标识
     * @return 是否登录成功
     */
    public boolean loginDevice(String deviceId) {
        HikvisionDevice device = devices.get(deviceId);
        if (device == null) {
            log.error("设备 {} 不存在", deviceId);
            return false;
        }
        
        if (device.getUserId() > -1) {
            log.warn("设备 {} 已登录", deviceId);
            return true;
        }
        
        try {
            HCNetSDK.NET_DVR_USER_LOGIN_INFO loginInfo = new HCNetSDK.NET_DVR_USER_LOGIN_INFO();
            HCNetSDK.NET_DVR_DEVICEINFO_V40 deviceInfo = new HCNetSDK.NET_DVR_DEVICEINFO_V40();
            
            // 设置设备IP地址
            System.arraycopy(device.getIp().getBytes(), 0, loginInfo.sDeviceAddress, 0, device.getIp().getBytes().length);
            loginInfo.wPort = (short) device.getPort();
            
            // 设置登录用户名和密码
            System.arraycopy(device.getUsername().getBytes(), 0, loginInfo.sUserName, 0, device.getUsername().getBytes().length);
            System.arraycopy(device.getPassword().getBytes(), 0, loginInfo.sPassword, 0, device.getPassword().getBytes().length);
            
            loginInfo.write();
            
            int userId = hCNetSDK.NET_DVR_Login_V40(loginInfo, deviceInfo);
            if (userId == -1) {
                int errorCode = hCNetSDK.NET_DVR_GetLastError();
                log.error("设备 {} 登录失败，错误码: {}", deviceId, errorCode);
                return false;
            }
            
            device.setUserId(userId);
            log.info("设备 {} 登录成功", deviceId);
            return true;
        } catch (Exception e) {
            log.error("设备 {} 登录异常", deviceId, e);
            return false;
        }
    }
    
    /**
     * 注销设备
     * @param deviceId 设备唯一标识
     */
    public void logoutDevice(String deviceId) {
        HikvisionDevice device = devices.get(deviceId);
        if (device == null) {
            log.error("设备 {} 不存在", deviceId);
            return;
        }
        
        if (device.getUserId() <= -1) {
            log.warn("设备 {} 未登录", deviceId);
            return;
        }
        
        try {
            boolean success = hCNetSDK.NET_DVR_Logout(device.getUserId());
            if (success) {
                device.setUserId(-1);
                log.info("设备 {} 注销成功", deviceId);
            } else {
                int errorCode = hCNetSDK.NET_DVR_GetLastError();
                log.error("设备 {} 注销失败，错误码: {}", deviceId, errorCode);
            }
        } catch (Exception e) {
            log.error("设备 {} 注销异常", deviceId, e);
        }
    }
    
    /**
     * 设备布防
     * @param deviceId 设备唯一标识
     * @return 布防句柄，-1表示失败
     */
    public int setupAlarmChan(String deviceId) {
        HikvisionDevice device = devices.get(deviceId);
        if (device == null) {
            log.error("设备 {} 不存在", deviceId);
            return -1;
        }
        
        if (device.getUserId() <= -1) {
            log.error("设备 {} 未登录", deviceId);
            return -1;
        }
        
        Integer handle = alarmHandles.get(deviceId);
        if (handle != null && handle > -1) {
            log.warn("设备 {} 已经布防，请先撤防", deviceId);
            return handle;
        }
        
        try {
            HCNetSDK.NET_DVR_SETUPALARM_PARAM_V50 alarmInfo = new HCNetSDK.NET_DVR_SETUPALARM_PARAM_V50();
            alarmInfo.dwSize = alarmInfo.size();
            alarmInfo.byLevel = 0;  //布防等级
            alarmInfo.byAlarmInfoType = 1;   // 智能交通报警信息上传类型：0- 老报警信息（NET_DVR_PLATE_RESULT），1- 新报警信息(NET_ITS_PLATE_RESULT)
            alarmInfo.byRetAlarmTypeV40 = 1; //0- 移动侦测、视频丢失、遮挡、IO信号量等报警信息以普通方式上传（报警类型：COMM_ALARM_V30，报警信息结构体：NET_DVR_ALARMINFO_V30），
            // 1- 报警信息以数据可变长方式上传（报警类型：COMM_ALARM_V40，报警信息结构体：NET_DVR_ALARMINFO_V40，设备若不支持则仍以普通方式上传）
            alarmInfo.byDeployType = 0;   //布防类型：0-客户端布防，1-实时布防
            alarmInfo.write();
            
            int alarmHandle = hCNetSDK.NET_DVR_SetupAlarmChan_V50(device.getUserId(), alarmInfo, null, 0);
            if (alarmHandle == -1) {
                int errorCode = hCNetSDK.NET_DVR_GetLastError();
                log.error("设备 {} 布防失败，错误码: {}", deviceId, errorCode);
                return -1;
            }
            
            alarmHandles.put(deviceId, alarmHandle);
            log.info("设备 {} 布防成功", deviceId);
            return alarmHandle;
        } catch (Exception e) {
            log.error("设备 {} 布防异常", deviceId, e);
            return -1;
        }
    }
    
    /**
     * 设备撤防
     * @param deviceId 设备唯一标识
     */
    public void closeAlarmChan(String deviceId) {
        Integer alarmHandle = alarmHandles.get(deviceId);
        if (alarmHandle == null || alarmHandle <= -1) {
            log.warn("设备 {} 未布防", deviceId);
            return;
        }
        
        try {
            boolean success = hCNetSDK.NET_DVR_CloseAlarmChan_V30(alarmHandle);
            if (success) {
                alarmHandles.remove(deviceId);
                log.info("设备 {} 撤防成功", deviceId);
            } else {
                int errorCode = hCNetSDK.NET_DVR_GetLastError();
                log.error("设备 {} 撤防失败，错误码: {}", deviceId, errorCode);
            }
        } catch (Exception e) {
            log.error("设备 {} 撤防异常", deviceId, e);
        }
    }
    
    /**
     * 开启监听 (使用V30版本接口)
     * @param ip 监听IP
     * @param port 监听端口
     * @return 监听句柄，-1表示失败
     */
    public int startListen(String ip, short port) {
        if (listenHandle > 0) {
            log.warn("已开启监听，请先停止监听");
            return listenHandle;
        }
        
        try {
            // 使用V30版本的监听接口，它接受FMSGCallBack类型的回调函数
            listenHandle = hCNetSDK.NET_DVR_StartListen_V30(ip, port, alarmCallback, null);
            if (listenHandle == -1) {
                int errorCode = hCNetSDK.NET_DVR_GetLastError();
                log.error("开启监听失败，错误码: {}", errorCode);
                return -1;
            }
            
            log.info("开启监听成功，IP: {}，端口: {}", ip, port);
            return listenHandle;
        } catch (Exception e) {
            log.error("开启监听异常", e);
            return -1;
        }
    }
    
    /**
     * 停止监听
     */
    public void stopListen() {
        if (listenHandle <= 0) {
            log.warn("未开启监听");
            return;
        }
        
        try {
            boolean success = hCNetSDK.NET_DVR_StopListen_V30(listenHandle);
            if (success) {
                listenHandle = -1;
                log.info("停止监听成功");
            } else {
                int errorCode = hCNetSDK.NET_DVR_GetLastError();
                log.error("停止监听失败，错误码: {}", errorCode);
            }
        } catch (Exception e) {
            log.error("停止监听异常", e);
        }
    }
    
    /**
     * 获取设备信息
     * @param deviceId 设备唯一标识
     * @return 设备对象
     */
    public HikvisionDevice getDevice(String deviceId) {
        return devices.get(deviceId);
    }
    
    /**
     * 获取SDK实例
     * @return SDK实例
     */
    public static HCNetSDK getSDK() {
        return hCNetSDK;
    }
    
    /**
     * 销毁资源
     */
    public void destroy() {
        try {
            // 关闭所有监听
            if (listenHandle > 0) {
                stopListen();
            }
            
            // 关闭所有布防
            for (String deviceId : alarmHandles.keySet()) {
                closeAlarmChan(deviceId);
            }
            
            // 注销所有设备
            for (String deviceId : devices.keySet()) {
                logoutDevice(deviceId);
            }
            
            // 清理SDK
            if (hCNetSDK != null) {
                hCNetSDK.NET_DVR_Cleanup();
                log.info("海康威视SDK资源清理完成");
            }
        } catch (Exception e) {
            log.error("海康威视SDK资源清理异常", e);
        }
    }

}
package com.netsdk.alarm;

import com.netsdk.common.ErrorCode;
import com.netsdk.lib.NetSDKLib;
import com.netsdk.lib.ToolKits;
import com.sun.jna.Native;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * 大华设备报警管理器
 */
public class DahuaAlarmManager {
    private static final Logger log = LoggerFactory.getLogger(DahuaAlarmManager.class);

    // SDK实例
    public static NetSDKLib netsdk = null;

    // 存储每个设备的登录信息
    private static final Map<String, DeviceLoginInfo> deviceLoginMap = new ConcurrentHashMap<>();

    private static boolean bInit = false;
    private static boolean bLogopen = false;

    // 设备管理
    private final Map<String, DahuaDevice> devices = new ConcurrentHashMap<>();

    // 智能分析事件订阅句柄管理
    private final Map<String, NetSDKLib.LLong> attachHandles = new ConcurrentHashMap<>();

    // 智能分析回调函数实例
    private NetSDKLib.fAnalyzerDataCallBack analyzerDataCallback;

    // 设备登录信息类
    public static class DeviceLoginInfo {
        public NetSDKLib.NET_DEVICEINFO_Ex deviceInfo;
        public NetSDKLib.LLong loginHandle;

        public DeviceLoginInfo() {
            this.deviceInfo = new NetSDKLib.NET_DEVICEINFO_Ex();
            this.loginHandle = new NetSDKLib.LLong(0);
        }
    }

    /**
     * 动态库加载
     */
    private static synchronized void createSDKInstance() {
        if (netsdk != null) {
            return;
        }

        try {
            String osName = System.getProperty("os.name");
            if (osName.toLowerCase().contains("windows")) {
                // Windows系统加载库路径
                String dllPath = System.getProperty("user.dir") + "\\dll_lib\\dahua\\dhnetsdk.dll";
                log.info("Loading Windows SDK from path: {}", dllPath);
                netsdk = Native.load(dllPath, NetSDKLib.class);
            } else {
                // Linux系统加载库路径
                String soPath = System.getProperty("user.dir") + "/lib/libhcnetsdk.so";
                log.info("Loading Linux SDK from path: {}", soPath);
                netsdk = Native.load(soPath, NetSDKLib.class);
            }

            log.info("大华SDK加载成功");
        } catch (Exception e) {
            log.error("大华SDK加载失败", e);
            netsdk = null;
        }
    }

    /**
     * 登录设备设备错误状态, 用于界面显示
     */
    public static String getErrorCodeShow() {
        return String.valueOf(netsdk.CLIENT_GetLastError());
    }

    public void setAnalyzerDataCallback(NetSDKLib.fAnalyzerDataCallBack analyzerDataCallback) {
        this.analyzerDataCallback = analyzerDataCallback;
    }

    /**
     * 初始化SDK
     */
    public static boolean initSDK(NetSDKLib.fDisConnect disConnect, NetSDKLib.fHaveReConnect haveReConnect) {
        createSDKInstance();
        bInit = netsdk.CLIENT_Init(disConnect, null);
        if (!bInit) {
            log.error("Initialize SDK failed");
            return false;
        }

        // 打开日志，可选
        NetSDKLib.LOG_SET_PRINT_INFO setLog = new NetSDKLib.LOG_SET_PRINT_INFO();
        File path = new File("./sdklog/");
        if (!path.exists()) {
            path.mkdir();
        }
        String logPath = path.getAbsoluteFile().getParent() + "\\sdklog\\" + ToolKits.getDate() + ".log";
        setLog.nPrintStrategy = 0;
        setLog.bSetFilePath = 1;
        System.arraycopy(logPath.getBytes(), 0, setLog.szLogFilePath, 0, logPath.getBytes().length);
        System.out.println(logPath);
        setLog.bSetPrintStrategy = 1;
        bLogopen = netsdk.CLIENT_LogOpen(setLog);
        if (!bLogopen) {
            log.error("Failed to open NetSDK log");
        }

        // 设置断线重连回调接口，设置过断线重连成功回调函数后，当设备出现断线情况，SDK内部会自动进行重连操作
        // 此操作为可选操作，但建议用户进行设置
        netsdk.CLIENT_SetAutoReconnect(haveReConnect, null);

        // 设置登录超时时间和尝试次数，可选
        int waitTime = 1000; // 登录请求响应超时时间设置为5S
        int tryTimes = 3;    // 登录时尝试建立链接1次
        netsdk.CLIENT_SetConnectTime(waitTime, tryTimes);

        // 设置更多网络参数，NET_PARAM的nWaittime，nConnectTryNum成员与CLIENT_SetConnectTime
        // 接口设置的登录设备超时时间和尝试次数意义相同,可选
        NetSDKLib.NET_PARAM netParam = new NetSDKLib.NET_PARAM();
        /*netParam.nConnectTime = 10000;      // 登录时尝试建立链接的超时时间
        netParam.nGetConnInfoTime = 3000;   // 设置子连接的超时时间
        netParam.nGetDevInfoTime = 3000; */   // 获取设备信息超时时间，为0默认1000ms
        netsdk.CLIENT_SetNetworkParam(netParam);

        return true;
    }

    /**
     * 清除环境
     */
    public static void cleanup() {
        if (bLogopen) {
            netsdk.CLIENT_LogClose();
        }

        if (bInit) {
            netsdk.CLIENT_Cleanup();
        }
    }

    /**
     * 登录设备
     */
    public static NetSDKLib.LLong login(String deviceId, String ip, int port, String username, String password) {
        // 先检查设备是否已经登录
        DeviceLoginInfo loginInfo = deviceLoginMap.get(deviceId);

        if (loginInfo == null) {
            loginInfo = new DeviceLoginInfo();
            deviceLoginMap.put(deviceId, loginInfo);
        }

        // 入参
        NetSDKLib.NET_IN_LOGIN_WITH_HIGHLEVEL_SECURITY pstInParam = new NetSDKLib.NET_IN_LOGIN_WITH_HIGHLEVEL_SECURITY();
        pstInParam.nPort = port;
        pstInParam.szIP = ip.getBytes();
        pstInParam.szPassword = password.getBytes();
        pstInParam.szUserName = username.getBytes();

        // 出参
        NetSDKLib.NET_OUT_LOGIN_WITH_HIGHLEVEL_SECURITY pstOutParam = new NetSDKLib.NET_OUT_LOGIN_WITH_HIGHLEVEL_SECURITY();
        pstOutParam.stuDeviceInfo = loginInfo.deviceInfo;

        loginInfo.loginHandle = netsdk.CLIENT_LoginWithHighLevelSecurity(pstInParam, pstOutParam);
        if (loginInfo.loginHandle.longValue() == 0) {
            log.error("Login Device[{}] Port[{}]Failed. {}", ip, port, getErrorCodeShow());
            deviceLoginMap.remove(deviceId); // 登录失败则移除记录
        } else {
            log.info("Login Success [ " + ip + " ]");
        }

        return loginInfo.loginHandle;
    }

    /**
     * 登出设备
     */
    public static boolean logout(String deviceId) {
        DeviceLoginInfo loginInfo = deviceLoginMap.get(deviceId);
        if (loginInfo == null || loginInfo.loginHandle.longValue() == 0) {
            return false;
        }

        boolean bRet = netsdk.CLIENT_Logout(loginInfo.loginHandle);
        if (bRet) {
            loginInfo.loginHandle.setValue(0);
            deviceLoginMap.remove(deviceId);
        }

        return bRet;
    }

    /**
     * 添加设备
     *
     * @param deviceId     设备唯一标识
     * @param deviceNumber 设备编号
     * @param ip           设备IP地址
     * @param port         设备端口
     * @param username     用户名
     * @param password     密码
     */
    public void addDevice(String deviceId, String deviceNumber, String ip, int port, String username, String password) {
        DahuaDevice device = new DahuaDevice(deviceId, deviceNumber, ip, port, username, password);
        devices.put(deviceId, device);
        log.info("添加设备: {} (设备编号: {}, IP: {})", deviceId, deviceNumber, ip);
    }

    /**
     * 登录设备
     *
     * @param deviceId 设备唯一标识
     * @return 是否登录成功
     */
    public boolean loginDevice(String deviceId) {
        DahuaDevice device = devices.get(deviceId);
        if (device == null) {
            log.error("设备 {} 不存在", deviceId);
            return false;
        }

        if (device.getLoginHandle() != null && device.getLoginHandle().longValue() != 0) {
            log.warn("设备 {} 已登录", deviceId);
            return true;
        }

        try {
            // 使用新的多设备登录模块
            NetSDKLib.LLong loginHandle = login(
                    deviceId,
                    device.getIp(),
                    device.getPort(),
                    device.getUsername(),
                    device.getPassword());

            if (loginHandle.longValue() != 0) {
                device.setLoginHandle(loginHandle); // 更新设备的登录句柄
                log.info("设备 {} 登录成功", deviceId);
                return true;
            } else {
                log.error("设备 {} 登录失败，错误码: {}", deviceId, getErrorCodeShow());
                return false;
            }
        } catch (Exception e) {
            log.error("设备 {} 登录异常", deviceId, e);
            return false;
        }
    }

    /**
     * 注销设备
     *
     * @param deviceId 设备唯一标识
     */
    public void logoutDevice(String deviceId) {
        DahuaDevice device = devices.get(deviceId);
        if (device == null) {
            log.error("设备 {} 不存在", deviceId);
            return;
        }

        if (device.getLoginHandle() == null || device.getLoginHandle().longValue() == 0) {
            log.warn("设备 {} 未登录", deviceId);
            return;
        }

        try {
            // 使用新的多设备登录模块
            boolean success = logout(deviceId);
            if (success) {
                device.setLoginHandle(new NetSDKLib.LLong(0));
                log.info("设备 {} 注销成功", deviceId);
            } else {
                log.error("设备 {} 注销失败，错误码: {}", deviceId, getErrorCodeShow());
            }
        } catch (Exception e) {
            log.error("设备 {} 注销异常", deviceId, e);
        }
    }

    /**
     * 设备布防
     *
     * @param deviceId 设备唯一标识
     * @return 布防是否成功
     */
    public boolean setupAlarmChan(String deviceId) {
        DeviceLoginInfo loginInfo = deviceLoginMap.get(deviceId);
        if (loginInfo == null || loginInfo.loginHandle.longValue() == 0) {
            log.error("设备 {} 未登录", deviceId);
            return false;
        }
        int channelNum = loginInfo.deviceInfo.byChanNum;
        for (int i = 0; i < channelNum; i++) {
            if (!setupAlarmChan(deviceId, i)) {
                log.error("设备 {} 布防失败", deviceId);
                return false;
            }
        }
        log.info("设备 {} 布防成功", deviceId);
        return true;
    }

    /**
     * 设备布防
     *
     * @param deviceId  设备唯一标识
     * @param channelId 通道ID，默认为0
     * @return 布防是否成功
     */
    public boolean setupAlarmChan(String deviceId, int channelId) {
        // 直接使用attachIVSEvent方法实现布防功能
        return attachIVSEvent(deviceId, channelId);
    }

    /**
     * 订阅实时上传智能分析数据
     *
     * @param deviceId  设备唯一标识
     * @param channelId 通道ID
     * @return 是否订阅成功
     */
    public boolean attachIVSEvent(String deviceId, int channelId) {
        DahuaDevice device = devices.get(deviceId);
        if (device == null) {
            log.error("设备 {} 不存在", deviceId);
            return false;
        }

        if (device.getLoginHandle() == null || device.getLoginHandle().longValue() == 0) {
            log.error("设备 {} 未登录", deviceId);
            return false;
        }

        try {
            // 构造key用于存储句柄
            String handleKey = deviceId + "_" + channelId;

            // 是否需要图片
            int bNeedPicture = 1;

            // 订阅智能分析事件
            NetSDKLib.LLong attachHandle = netsdk.CLIENT_RealLoadPictureEx(
                    device.getLoginHandle(),
                    channelId,
                    NetSDKLib.EVENT_IVS_ALL,
                    bNeedPicture,
                    analyzerDataCallback,
                    null,
                    null);

            if (attachHandle.longValue() != 0) {
                attachHandles.put(handleKey, attachHandle);
                log.info("设备 {} 通道 {} 订阅智能分析事件成功", deviceId, channelId);
                return true;
            } else {
                log.error("设备 {} 通道 {} 订阅智能分析事件失败，错误码: {}", deviceId, channelId, getErrorCodeShow());
                return false;
            }
        } catch (Exception e) {
            log.error("设备 {} 通道 {} 订阅智能分析事件异常", deviceId, channelId, e);
            return false;
        }
    }

    /**
     * 停止上传智能分析数据
     *
     * @param deviceId  设备唯一标识
     * @param channelId 通道ID
     */
    public void detachIVSEvent(String deviceId, int channelId) {
        String handleKey = deviceId + "_" + channelId;
        NetSDKLib.LLong attachHandle = attachHandles.get(handleKey);

        if (attachHandle == null || attachHandle.longValue() == 0) {
            log.warn("设备 {} 通道 {} 未订阅智能分析事件", deviceId, channelId);
            return;
        }

        try {
            boolean success = netsdk.CLIENT_StopLoadPic(attachHandle);
            if (success) {
                attachHandles.remove(handleKey);
                log.info("设备 {} 通道 {} 停止智能分析事件订阅成功", deviceId, channelId);
            } else {
                log.error("设备 {} 通道 {} 停止智能分析事件订阅失败，错误码: {}", deviceId, channelId, getErrorCodeShow());
            }
        } catch (Exception e) {
            log.error("设备 {} 通道 {} 停止智能分析事件订阅异常", deviceId, channelId, e);
        }
    }

    /**
     * 获取设备信息
     *
     * @param deviceId 设备唯一标识
     * @return 设备对象
     */
    public DahuaDevice getDevice(String deviceId) {
        return devices.get(deviceId);
    }

    /**
     * 根据设备IP获取设备信息
     *
     * @param ip 设备IP地址
     * @return 设备对象，未找到返回null
     */
    public DahuaDevice getDeviceByIp(String ip) {
        for (DahuaDevice device : devices.values()) {
            if (ip.equals(device.getIp())) {
                return device;
            }
        }
        return null;
    }

}
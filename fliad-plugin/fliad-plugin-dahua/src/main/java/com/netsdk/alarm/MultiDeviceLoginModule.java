package com.netsdk.alarm;

import com.netsdk.lib.NetSDKLib;
import com.netsdk.lib.ToolKits;
import com.sun.jna.ptr.IntByReference;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class MultiDeviceLoginModule {

    public static NetSDKLib netsdk = NetSDKLib.NETSDK_INSTANCE;
    public static NetSDKLib configsdk = NetSDKLib.CONFIG_INSTANCE;

    // 存储每个设备的登录信息
    private static final Map<String, DeviceLoginInfo> deviceLoginMap = new ConcurrentHashMap<>();

    private static boolean bInit = false;
    private static boolean bLogopen = false;

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
     * 初始化SDK
     */
    public static boolean init(NetSDKLib.fDisConnect disConnect, NetSDKLib.fHaveReConnect haveReConnect) {
        bInit = netsdk.CLIENT_Init(disConnect, null);
        if (!bInit) {
            System.out.println("Initialize SDK failed");
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
            System.err.println("Failed to open NetSDK log");
        }

        // 设置断线重连回调接口，设置过断线重连成功回调函数后，当设备出现断线情况，SDK内部会自动进行重连操作
        // 此操作为可选操作，但建议用户进行设置
        netsdk.CLIENT_SetAutoReconnect(haveReConnect, null);

        // 设置登录超时时间和尝试次数，可选
        int waitTime = 5000; // 登录请求响应超时时间设置为5S
        int tryTimes = 1;    // 登录时尝试建立链接1次
        netsdk.CLIENT_SetConnectTime(waitTime, tryTimes);

        // 设置更多网络参数，NET_PARAM的nWaittime，nConnectTryNum成员与CLIENT_SetConnectTime
        // 接口设置的登录设备超时时间和尝试次数意义相同,可选
        NetSDKLib.NET_PARAM netParam = new NetSDKLib.NET_PARAM();
        netParam.nConnectTime = 10000;      // 登录时尝试建立链接的超时时间
        netParam.nGetConnInfoTime = 3000;   // 设置子连接的超时时间
        netParam.nGetDevInfoTime = 3000;    // 获取设备信息超时时间，为0默认1000ms
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
            System.err.printf("Login Device[%s] Port[%d]Failed. %s\n", ip, port, ToolKits.getErrorCodePrint());
            deviceLoginMap.remove(deviceId); // 登录失败则移除记录
        } else {
            System.out.println("Login Success [ " + ip + " ]");
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
     * 获取设备登录句柄
     */
    public static NetSDKLib.LLong getLoginHandle(String deviceId) {
        DeviceLoginInfo loginInfo = deviceLoginMap.get(deviceId);
        if (loginInfo != null) {
            return loginInfo.loginHandle;
        }
        return new NetSDKLib.LLong(0);
    }

    /**
     * 更新设备登录信息
     */
    public static void updateLoginHandle(String deviceId, NetSDKLib.LLong loginHandle) {
        DeviceLoginInfo loginInfo = deviceLoginMap.get(deviceId);
        if (loginInfo == null) {
            loginInfo = new DeviceLoginInfo();
            deviceLoginMap.put(deviceId, loginInfo);
        }
        loginInfo.loginHandle = loginHandle;
    }
}
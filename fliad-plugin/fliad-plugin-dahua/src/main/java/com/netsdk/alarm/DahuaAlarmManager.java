package com.netsdk.alarm;

import com.netsdk.lib.NetSDKLib;
import com.netsdk.lib.ToolKits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

import static com.netsdk.alarm.MultiDeviceLoginModule.netsdk;

/**
 * 大华设备报警管理器
 */
public class DahuaAlarmManager {
    private static final Logger log = LoggerFactory.getLogger(DahuaAlarmManager.class);

    // 设备管理
    private final Map<String, DahuaDevice> devices = new ConcurrentHashMap<>();

    // 智能分析事件订阅句柄管理
    private final Map<String, NetSDKLib.LLong> attachHandles = new ConcurrentHashMap<>();

    // 智能分析回调函数实例
    private NetSDKLib.fAnalyzerDataCallBack analyzerDataCallback;

    /**
     * 初始化SDK
     */
    public void init() {
        try {
            // 初始化SDK
            boolean initSuccess = MultiDeviceLoginModule.init(null, null);
            if (!initSuccess) {
                log.error("大华SDK初始化失败，错误码: {}", ToolKits.getErrorCodeShow());
                return;
            }

            // 设置日志
            log.info("大华SDK初始化成功");

        } catch (Exception e) {
            log.error("初始化大华SDK异常", e);
        }
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
     * 删除设备
     *
     * @param deviceId 设备唯一标识
     * @return 是否删除成功
     */
    public boolean removeDevice(String deviceId) {
        DahuaDevice device = devices.remove(deviceId);
        if (device != null) {
            // 如果设备已订阅智能分析事件，先取消订阅
            for (String key : attachHandles.keySet()) {
                if (key.startsWith(deviceId + "_")) {
                    String[] parts = key.split("_");
                    if (parts.length >= 2) {
                        int channelId = Integer.parseInt(parts[1]);
                        detachIVSEvent(deviceId, channelId);
                    }
                }
            }

            // 如果设备已登录，先注销
            if (device.getLoginHandle() != null && device.getLoginHandle().longValue() != 0) {
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
            NetSDKLib.LLong loginHandle = MultiDeviceLoginModule.login(
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
                log.error("设备 {} 登录失败，错误码: {}", deviceId, ToolKits.getErrorCodeShow());
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
            boolean success = MultiDeviceLoginModule.logout(deviceId);
            if (success) {
                device.setLoginHandle(new NetSDKLib.LLong(0));
                log.info("设备 {} 注销成功", deviceId);
            } else {
                log.error("设备 {} 注销失败，错误码: {}", deviceId, ToolKits.getErrorCodeShow());
            }
        } catch (Exception e) {
            log.error("设备 {} 注销异常", deviceId, e);
        }
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
     * 设备布防（使用设备的第一个有效通道）
     *
     * @param deviceId 设备唯一标识
     * @return 布防是否成功
     */
    public boolean setupAlarmChan(String deviceId) {
        // 获取设备实际的通道数，使用第一个通道(通道0)进行布防
        // 在大华设备中，通常至少有一个视频通道(通道0)
        return setupAlarmChan(deviceId, 0);
    }

    /**
     * 设备撤防
     *
     * @param deviceId  设备唯一标识
     * @param channelId 通道ID
     */
    public void closeAlarmChan(String deviceId, int channelId) {
        detachIVSEvent(deviceId, channelId);
    }

    /**
     * 设备撤防（默认通道0）
     *
     * @param deviceId 设备唯一标识
     */
    public void closeAlarmChan(String deviceId) {
        closeAlarmChan(deviceId, 0);
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
            // 创建智能分析回调函数实例
            if (analyzerDataCallback == null) {
                analyzerDataCallback = new DahuaAnalyzerDataCallBack(this);
            }

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
                log.error("设备 {} 通道 {} 订阅智能分析事件失败，错误码: {}", deviceId, channelId, ToolKits.getErrorCodeShow());
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
                log.error("设备 {} 通道 {} 停止智能分析事件订阅失败，错误码: {}", deviceId, channelId, ToolKits.getErrorCodeShow());
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
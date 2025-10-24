package com.fliad.sip.gb28181.api;

/**
 * SIP服务API接口
 *
 * @author your-name
 * @since 0.1.0
 */
public interface SipServiceApi {
    
    /**
     * 初始化SIP服务
     */
    void initialize();
    
    /**
     * 配置SIP服务参数
     * 
     * @param host 主机地址
     * @param port 端口号
     * @param transport 传输协议(UDP/TCP)
     */
    void configure(String host, int port, String transport);
    
    /**
     * 启动SIP服务
     */
    void start();
    
    /**
     * 停止SIP服务
     */
    void stop();
    
    /**
     * 处理设备注册
     *
     * @param deviceId 设备ID
     * @param from 来源
     * @param contact 联系方式
     */
    void handleDeviceRegistration(String deviceId, String from, String contact);
    
    /**
     * 创建实时视频流
     *
     * @param deviceId 设备ID
     * @param channelId 通道ID
     * @return 会话ID
     */
    String createRealTimeVideoStream(String deviceId, String channelId);
    
    /**
     * 创建回放视频流
     *
     * @param deviceId 设备ID
     * @param channelId 通道ID
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 会话ID
     */
    String createPlaybackVideoStream(String deviceId, String channelId, String startTime, String endTime);
    
    /**
     * 停止视频流
     *
     * @param sessionId 会话ID
     */
    void stopVideoStream(String sessionId);
    
    /**
     * 获取注册设备数量
     *
     * @return 设备数量
     */
    int getRegisteredDeviceCount();
}
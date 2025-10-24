package com.fliad.sip.gb28181.api;

/**
 * 媒体流管理API接口
 *
 * @author your-name
 * @since 0.1.0
 */
public interface MediaStreamApi {
    
    /**
     * 创建点播流
     *
     * @param deviceId 设备ID
     * @param channelId 通道ID
     * @return 会话ID
     */
    String createRealTimeStream(String deviceId, String channelId);
    
    /**
     * 创建回放流
     *
     * @param deviceId 设备ID
     * @param channelId 通道ID
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 会话ID
     */
    String createPlaybackStream(String deviceId, String channelId, String startTime, String endTime);
    
    /**
     * 停止媒体流
     *
     * @param sessionId 会话ID
     */
    void stopStream(String sessionId);
    
    /**
     * 获取会话信息
     *
     * @param sessionId 会话ID
     * @return 会话信息
     */
    Object getStreamSession(String sessionId);
}
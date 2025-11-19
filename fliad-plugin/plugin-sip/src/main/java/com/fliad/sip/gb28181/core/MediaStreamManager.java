package com.fliad.sip.gb28181.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * 媒体流管理器
 *
 * @author your-name
 * @since 0.1.0
 */
public class MediaStreamManager {
    private static final Logger log = LoggerFactory.getLogger(MediaStreamManager.class);

    /**
     * 媒体流会话表，key为会话ID，value为会话信息
     */
    private final Map<String, StreamSession> streamSessions = new ConcurrentHashMap<>();
    
    /**
     * 设备流映射，key为设备ID，value为会话ID列表
     */
    private final Map<String, List<String>> deviceStreams = new ConcurrentHashMap<>();

    /**
     * 单例实例
     */
    private static MediaStreamManager instance;

    private MediaStreamManager() {
        // 私有构造函数
    }

    /**
     * 获取单例实例
     *
     * @return MediaStreamManager实例
     */
    public static MediaStreamManager getInstance() {
        if (instance == null) {
            synchronized (MediaStreamManager.class) {
                if (instance == null) {
                    instance = new MediaStreamManager();
                }
            }
        }
        return instance;
    }

    /**
     * 创建点播流
     *
     * @param deviceId 设备ID
     * @param channelId 通道ID
     * @return 会话ID
     */
    public String createRealTimeStream(String deviceId, String channelId) {
        String sessionId = generateSessionId();
        StreamSession session = new StreamSession(sessionId, deviceId, channelId, StreamType.REAL_TIME);
        streamSessions.put(sessionId, session);
        
        // 添加到设备流映射
        deviceStreams.computeIfAbsent(deviceId, k -> new ArrayList<>()).add(sessionId);
        
        // TODO: 实现点播流创建逻辑
        log.info("Creating real-time stream for device: {}, channel: {}, session: {}", deviceId, channelId, sessionId);
        return sessionId;
    }

    /**
     * 创建回放流
     *
     * @param deviceId 设备ID
     * @param channelId 通道ID
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 会话ID
     */
    public String createPlaybackStream(String deviceId, String channelId, String startTime, String endTime) {
        String sessionId = generateSessionId();
        StreamSession session = new StreamSession(sessionId, deviceId, channelId, StreamType.PLAYBACK);
        session.setStartTime(startTime);
        session.setEndTime(endTime);
        streamSessions.put(sessionId, session);
        
        // 添加到设备流映射
        deviceStreams.computeIfAbsent(deviceId, k -> new ArrayList<>()).add(sessionId);
        
        // TODO: 实现回放流创建逻辑
        log.info("Creating playback stream for device: {}, channel: {}, session: {}", deviceId, channelId, sessionId);
        return sessionId;
    }

    /**
     * 停止媒体流
     *
     * @param sessionId 会话ID
     */
    public void stopStream(String sessionId) {
        StreamSession session = streamSessions.remove(sessionId);
        if (session != null) {
            // 从设备流映射中移除
            List<String> sessions = deviceStreams.get(session.getDeviceId());
            if (sessions != null) {
                sessions.remove(sessionId);
                if (sessions.isEmpty()) {
                    deviceStreams.remove(session.getDeviceId());
                }
            }
            
            // TODO: 实现停止媒体流逻辑
            log.info("Stopping stream session: {}", sessionId);
        } else {
            log.warn("Stream session not found: {}", sessionId);
        }
    }
    
    /**
     * 停止设备的所有流
     *
     * @param deviceId 设备ID
     */
    public void stopAllStreamsForDevice(String deviceId) {
        List<String> sessionIds = deviceStreams.get(deviceId);
        if (sessionIds != null) {
            // 创建副本以避免并发修改异常
            List<String> sessionsToStop = new ArrayList<>(sessionIds);
            for (String sessionId : sessionsToStop) {
                stopStream(sessionId);
            }
        }
    }

    /**
     * 生成会话ID
     *
     * @return 会话ID
     */
    private String generateSessionId() {
        return "session_" + System.currentTimeMillis() + "_" + (int)(Math.random() * 1000);
    }

    /**
     * 获取会话信息
     *
     * @param sessionId 会话ID
     * @return 会话信息
     */
    public StreamSession getStreamSession(String sessionId) {
        return streamSessions.get(sessionId);
    }
    
    /**
     * 获取设备的所有会话
     *
     * @param deviceId 设备ID
     * @return 会话列表
     */
    public List<StreamSession> getStreamsForDevice(String deviceId) {
        List<StreamSession> sessions = new ArrayList<>();
        List<String> sessionIds = deviceStreams.get(deviceId);
        if (sessionIds != null) {
            for (String sessionId : sessionIds) {
                StreamSession session = streamSessions.get(sessionId);
                if (session != null) {
                    sessions.add(session);
                }
            }
        }
        return sessions;
    }
    
    /**
     * 获取所有活动会话
     *
     * @return 所有活动会话列表
     */
    public List<StreamSession> getAllActiveSessions() {
        return new ArrayList<>(streamSessions.values());
    }
    
    /**
     * 清理所有会话（用于系统关闭时）
     */
    public void clearAllSessions() {
        streamSessions.clear();
        deviceStreams.clear();
    }
    
    /**
     * 流类型枚举
     */
    public enum StreamType {
        REAL_TIME,    // 实时流
        PLAYBACK      // 回放流
    }
    
    /**
     * 流会话信息类
     */
    public static class StreamSession {
        private final String sessionId;
        private final String deviceId;
        private final String channelId;
        private final StreamType streamType;
        private String startTime;
        private String endTime;
        private String sdp;
        private String streamUrl;
        private long createTime;
        
        public StreamSession(String sessionId, String deviceId, String channelId, StreamType streamType) {
            this.sessionId = sessionId;
            this.deviceId = deviceId;
            this.channelId = channelId;
            this.streamType = streamType;
            this.createTime = System.currentTimeMillis();
        }
        
        // Getters and setters
        public String getSessionId() {
            return sessionId;
        }
        
        public String getDeviceId() {
            return deviceId;
        }
        
        public String getChannelId() {
            return channelId;
        }
        
        public StreamType getStreamType() {
            return streamType;
        }
        
        public String getStartTime() {
            return startTime;
        }
        
        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }
        
        public String getEndTime() {
            return endTime;
        }
        
        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }
        
        public String getSdp() {
            return sdp;
        }
        
        public void setSdp(String sdp) {
            this.sdp = sdp;
        }
        
        public String getStreamUrl() {
            return streamUrl;
        }
        
        public void setStreamUrl(String streamUrl) {
            this.streamUrl = streamUrl;
        }
        
        public long getCreateTime() {
            return createTime;
        }
    }
}
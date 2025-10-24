package com.fliad.sip.gb28181.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * 媒体服务器集成接口
 *
 * @author your-name
 * @since 0.1.0
 */
public class MediaServerIntegration {
    private static final Logger log = LoggerFactory.getLogger(MediaServerIntegration.class);

    /**
     * 媒体服务器地址
     */
    private String mediaServerUrl;

    /**
     * 媒体服务器API密钥
     */
    private String apiKey;

    /**
     * 单例实例
     */
    private static MediaServerIntegration instance;

    private MediaServerIntegration() {
        // 私有构造函数
    }

    /**
     * 获取单例实例
     *
     * @return MediaServerIntegration实例
     */
    public static MediaServerIntegration getInstance() {
        if (instance == null) {
            synchronized (MediaServerIntegration.class) {
                if (instance == null) {
                    instance = new MediaServerIntegration();
                }
            }
        }
        return instance;
    }

    /**
     * 配置媒体服务器连接参数
     *
     * @param mediaServerUrl 媒体服务器地址
     * @param apiKey API密钥
     */
    public void configure(String mediaServerUrl, String apiKey) {
        this.mediaServerUrl = mediaServerUrl;
        this.apiKey = apiKey;
        log.info("Media server configured with URL: {}", mediaServerUrl);
    }

    /**
     * 创建媒体流
     *
     * @param streamId 流ID
     * @param sdp SDP信息
     * @return 流地址
     */
    public String createStream(String streamId, String sdp) {
        try {
            if (mediaServerUrl == null || mediaServerUrl.isEmpty()) {
                log.warn("Media server URL not configured");
                return null;
            }
            
            String apiUrl = mediaServerUrl + "/streams/" + streamId;
            String response = sendPostRequest(apiUrl, sdp, "application/sdp");
            
            log.info("Created stream {} with SDP, response: {}", streamId, response);
            return mediaServerUrl + "/streams/" + streamId + "/play";
        } catch (Exception e) {
            log.error("Error creating stream: " + streamId, e);
            return null;
        }
    }

    /**
     * 删除媒体流
     *
     * @param streamId 流ID
     */
    public void deleteStream(String streamId) {
        try {
            if (mediaServerUrl == null || mediaServerUrl.isEmpty()) {
                log.warn("Media server URL not configured");
                return;
            }
            
            String apiUrl = mediaServerUrl + "/streams/" + streamId;
            sendDeleteRequest(apiUrl);
            
            log.info("Deleted stream: {}", streamId);
        } catch (Exception e) {
            log.error("Error deleting stream: " + streamId, e);
        }
    }

    /**
     * 获取流状态
     *
     * @param streamId 流ID
     * @return 流状态
     */
    public String getStreamStatus(String streamId) {
        try {
            if (mediaServerUrl == null || mediaServerUrl.isEmpty()) {
                log.warn("Media server URL not configured");
                return "unknown";
            }
            
            String apiUrl = mediaServerUrl + "/streams/" + streamId + "/status";
            String response = sendGetRequest(apiUrl);
            
            log.info("Got status for stream: {}, response: {}", streamId, response);
            return response != null ? response : "unknown";
        } catch (Exception e) {
            log.error("Error getting stream status: " + streamId, e);
            return "error";
        }
    }
    
    /**
     * 发送POST请求
     * 
     * @param url 请求地址
     * @param data 发送数据
     * @param contentType 内容类型
     * @return 响应结果
     * @throws Exception 请求异常
     */
    private String sendPostRequest(String url, String data, String contentType) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        try {
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", contentType);
            connection.setRequestProperty("Accept", "application/json");
            if (apiKey != null && !apiKey.isEmpty()) {
                connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            }
            connection.setDoOutput(true);
            
            if (data != null && !data.isEmpty()) {
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = data.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }
            }
            
            return readResponse(connection);
        } finally {
            connection.disconnect();
        }
    }
    
    /**
     * 发送GET请求
     * 
     * @param url 请求地址
     * @return 响应结果
     * @throws Exception 请求异常
     */
    private String sendGetRequest(String url) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        try {
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            if (apiKey != null && !apiKey.isEmpty()) {
                connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            }
            
            return readResponse(connection);
        } finally {
            connection.disconnect();
        }
    }
    
    /**
     * 发送DELETE请求
     * 
     * @param url 请求地址
     * @throws Exception 请求异常
     */
    private void sendDeleteRequest(String url) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        try {
            connection.setRequestMethod("DELETE");
            if (apiKey != null && !apiKey.isEmpty()) {
                connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            }
            
            readResponse(connection); // 读取响应但不返回
        } finally {
            connection.disconnect();
        }
    }
    
    /**
     * 读取HTTP响应
     * 
     * @param connection HTTP连接
     * @return 响应内容
     * @throws Exception 读取异常
     */
    private String readResponse(HttpURLConnection connection) throws Exception {
        int responseCode = connection.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                return response.toString();
            }
        } else {
            log.warn("HTTP request failed with code: {}", responseCode);
            return null;
        }
    }
}
package com.fliad.sip.gb28181.core.config;

import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Inject;

/**
 * GB28181 SIP配置类
 *
 * @author your-name
 * @since 0.1.0
 */
@Configuration
public class SipGb28181Configure {
    
    @Inject
    private SipConfig sipConfig;
    
    @Bean
    public SipConfig sipConfig() {
        return new SipConfig();
    }
    
    /**
     * SIP配置属性类
     */
    public static class SipConfig {
        private String host = "0.0.0.0";
        private int port = 5060;
        private String transport = "UDP,TCP"; // 支持多个传输协议，用逗号分隔
        private String deviceId = "34020000002000000001";
        private String deviceName = "GB28181 Server";
        private String password = "admin123";
        private int keepaliveTime = 60;
        private String mediaServerUrl = "http://127.0.0.1:8080";
        private String mediaServerApiKey = "";
        
        // Getters and Setters
        public String getHost() {
            return host;
        }
        
        public void setHost(String host) {
            this.host = host;
        }
        
        public int getPort() {
            return port;
        }
        
        public void setPort(int port) {
            this.port = port;
        }
        
        public String getTransport() {
            return transport;
        }
        
        public void setTransport(String transport) {
            this.transport = transport;
        }
        
        public String getDeviceId() {
            return deviceId;
        }
        
        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }
        
        public String getDeviceName() {
            return deviceName;
        }
        
        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }
        
        public String getPassword() {
            return password;
        }
        
        public void setPassword(String password) {
            this.password = password;
        }
        
        public int getKeepaliveTime() {
            return keepaliveTime;
        }
        
        public void setKeepaliveTime(int keepaliveTime) {
            this.keepaliveTime = keepaliveTime;
        }
        
        public String getMediaServerUrl() {
            return mediaServerUrl;
        }
        
        public void setMediaServerUrl(String mediaServerUrl) {
            this.mediaServerUrl = mediaServerUrl;
        }
        
        public String getMediaServerApiKey() {
            return mediaServerApiKey;
        }
        
        public void setMediaServerApiKey(String mediaServerApiKey) {
            this.mediaServerApiKey = mediaServerApiKey;
        }
    }
}
package com.fliad.sip.gb28181.core;

import com.fliad.sip.gb28181.core.config.SipConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sip.header.AuthorizationHeader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 认证管理器
 * 负责处理GB28181设备认证相关功能
 *
 * @author your-name
 * @since 0.1.0
 */
public class AuthenticationManager {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationManager.class);

    /**
     * 单例实例
     */
    /**
     * 服务端配置
     */
    private SipConfig sipConfig;

    /**
     * 存储nonce和对应的时间戳，用于验证nonce是否过期
     */
    private final Map<String, Long> nonceStore = new ConcurrentHashMap<>();

    /**
     * nonce过期时间（毫秒），默认5分钟
     */
    private static final long NONCE_EXPIRATION_TIME = 5 * 60 * 1000;

    private AuthenticationManager() {
        // 私有构造函数
    }

    /**
     * 获取单例实例
     *
     * @return AuthenticationManager实例
     */
    public static AuthenticationManager getInstance() {
        return InstanceHolder.INSTANCE;
    }
    
    private static class InstanceHolder {
        private static final AuthenticationManager INSTANCE = new AuthenticationManager();
    }

    /**
     * 设置SIP配置
     *
     * @param sipConfig SIP配置
     */
    public void setSipConfig(SipConfig sipConfig) {
        this.sipConfig = sipConfig;
    }

    /**
     * 生成WWW-Authenticate头中的realm值
     *
     * @return realm值
     */
    public String generateRealm() {
        if (sipConfig != null && sipConfig.getDeviceId() != null) {
            return sipConfig.getDeviceId();
        }
        return "GB28181_SIP_Server";
    }

    /**
     * 生成新的nonce值
     *
     * @return nonce值
     */
    public String generateNonce() {
        String nonce = UUID.randomUUID().toString().replace("-", "");
        nonceStore.put(nonce, System.currentTimeMillis());
        // 清理过期的nonce
        cleanupExpiredNonces();
        return nonce;
    }

    /**
     * 验证Authorization头中的认证信息
     *
     * @param authHeader Authorization头
     * @param deviceId 设备ID
     * @return 认证是否成功
     */
    public boolean validateAuthorization(AuthorizationHeader authHeader, String deviceId) {
        try {
            if (authHeader == null || sipConfig == null) {
                return false;
            }

            String username = authHeader.getUsername();
            String realm = authHeader.getRealm();
            String nonce = authHeader.getNonce();
            String uri = authHeader.getURI().toString();
            String response = authHeader.getResponse();

            // 检查用户名是否匹配
            if (!deviceId.equals(username)) {
                log.warn("Username mismatch: expected {}, got {}", deviceId, username);
                return false;
            }

            // 检查realm是否匹配
            if (!generateRealm().equals(realm)) {
                log.warn("Realm mismatch: expected {}, got {}", generateRealm(), realm);
                return false;
            }

            // 检查nonce是否有效且未过期
            if (!isValidNonce(nonce)) {
                log.warn("Invalid or expired nonce: {}", nonce);
                return false;
            }

            // 获取设备密码
            String password = sipConfig.getPassword();
            
            // 计算预期的response值
            String expectedResponse = calculateResponse(username, realm, password, nonce, uri);
            
            // 比较response值
            boolean isValid = expectedResponse.equals(response);
            
            if (!isValid) {
                log.warn("Authentication failed for device: {}", deviceId);
            } else {
                log.info("Authentication successful for device: {}", deviceId);
            }
            
            return isValid;
        } catch (Exception e) {
            log.error("Error validating authorization for device: " + deviceId, e);
            return false;
        }
    }

    /**
     * 计算response值
     *
     * @param username 用户名
     * @param realm 领域
     * @param password 密码
     * @param nonce 随机数
     * @param uri URI
     * @return 计算出的response值
     * @throws NoSuchAlgorithmException 算法异常
     */
    private String calculateResponse(String username, String realm, String password, String nonce, String uri) 
            throws NoSuchAlgorithmException {
        // HA1 = MD5(username:realm:password)
        String ha1 = md5(username + ":" + realm + ":" + password);
        
        // HA2 = MD5(REGISTER:uri)
        String ha2 = md5("REGISTER:" + uri);
        
        // Response = MD5(HA1:nonce:HA2)
        return md5(ha1 + ":" + nonce + ":" + ha2);
    }

    /**
     * MD5哈希计算
     *
     * @param input 输入字符串
     * @return MD5哈希值
     * @throws NoSuchAlgorithmException 算法异常
     */
    private String md5(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    /**
     * 检查nonce是否有效且未过期
     *
     * @param nonce nonce值
     * @return 是否有效
     */
    private boolean isValidNonce(String nonce) {
        Long timestamp = nonceStore.get(nonce);
        if (timestamp == null) {
            return false;
        }
        
        long currentTime = System.currentTimeMillis();
        return (currentTime - timestamp) < NONCE_EXPIRATION_TIME;
    }

    /**
     * 清理过期的nonce
     */
    private void cleanupExpiredNonces() {
        long currentTime = System.currentTimeMillis();
        nonceStore.entrySet().removeIf(entry -> 
            (currentTime - entry.getValue()) >= NONCE_EXPIRATION_TIME);
    }
    
    /**
     * 清理所有nonce
     */
    public void clearAllNonces() {
        nonceStore.clear();
        log.info("Cleared all nonces from authentication manager");
    }
}
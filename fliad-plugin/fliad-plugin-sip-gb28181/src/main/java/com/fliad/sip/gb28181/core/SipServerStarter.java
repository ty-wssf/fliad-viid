package com.fliad.sip.gb28181.core;

import com.fliad.sip.gb28181.core.config.SipGb28181Configure;
import com.fliad.sip.gb28181.modular.SipService;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * SIP服务器启动器
 * 负责在系统启动时自动初始化和启动SIP服务
 *
 * @author your-name
 * @since 0.1.0
 */
@Component
public class SipServerStarter implements LifecycleBean {
    private static final Logger log = LoggerFactory.getLogger(SipServerStarter.class);

    @Inject
    private SipGb28181Configure.SipConfig sipConfig;
    
    private SipService sipService;

    /**
     * 系统启动后自动初始化和启动SIP服务
     */
    @Override
    public void start() throws Throwable {
        try {
            log.info("Starting SIP GB28181 Server...");
            
            sipService = new SipService();
            
            // 解析传输协议配置，支持多个协议
            List<String> transports = new ArrayList<>();
            String transportConfig = sipConfig.getTransport();
            if (transportConfig != null && !transportConfig.isEmpty()) {
                String[] transportArray = transportConfig.split(",");
                for (String transport : transportArray) {
                    transports.add(transport.trim().toUpperCase());
                }
            } else {
                // 默认使用UDP
                transports.add("UDP");
            }
            
            // 配置SIP服务
            sipService.configure(
                sipConfig.getHost(),
                sipConfig.getPort(),
                transports
            );
            
            // 初始化服务
            sipService.initialize();
            
            // 启动服务
            sipService.start();
            
            log.info("SIP GB28181 Server started successfully with transports: {}", transports);
        } catch (Exception e) {
            log.error("Failed to start SIP GB28181 Server", e);
        }
    }

    /**
     * 系统关闭前停止SIP服务
     */
    @Override
    public void stop() throws Throwable {
        try {
            log.info("Stopping SIP GB28181 Server...");
            
            if (sipService != null) {
                sipService.stop();
            }
            
            log.info("SIP GB28181 Server stopped successfully");
        } catch (Exception e) {
            log.error("Failed to stop SIP GB28181 Server", e);
        }
    }
    
    /**
     * 获取SIP服务实例
     * 
     * @return SIP服务实例
     */
    public SipService getSipService() {
        return sipService;
    }
}
package com.fliad.sip.gb28181.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sip.*;
import javax.sip.address.AddressFactory;
import javax.sip.header.HeaderFactory;
import javax.sip.message.MessageFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * GB28181 SIP服务器核心类
 *
 * @author your-name
 * @since 0.1.0
 */
public class SipServer {
    private static final Logger log = LoggerFactory.getLogger(SipServer.class);

    /**
     * SIP服务器实例
     */
    private static SipServer instance;

    private SipStack sipStack;
    private List<SipProvider> sipProviders = new ArrayList<>();
    private AddressFactory addressFactory;
    private HeaderFactory headerFactory;
    private MessageFactory messageFactory;
    
    private String host;
    private int port;
    private List<String> transports = new ArrayList<>();

    private SipServer() {
        // 私有构造函数
    }

    /**
     * 获取单例实例
     *
     * @return SipServer实例
     */
    public static SipServer getInstance() {
        if (instance == null) {
            synchronized (SipServer.class) {
                if (instance == null) {
                    instance = new SipServer();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化SIP服务器
     */
    public void initialize() {
        log.info("Initializing GB28181 SIP Server...");
        // TODO: 实现SIP服务器初始化逻辑
    }
    
    /**
     * 配置SIP服务器参数
     * 
     * @param host 主机地址
     * @param port 端口号
     * @param transports 传输协议列表(UDP/TCP)
     */
    public void configure(String host, int port, List<String> transports) {
        this.host = host;
        this.port = port;
        this.transports = transports;
        log.info("SIP Server configured with host: {}, port: {}, transports: {}", host, port, transports);
    }

    /**
     * 启动SIP服务器
     */
    public void start() {
        log.info("Starting GB28181 SIP Server...");
        try {
            // 创建SIP堆栈
            Properties properties = new Properties();
            properties.setProperty("javax.sip.STACK_NAME", "GB28181_SIP_Server");
            properties.setProperty("gov.nist.javax.sip.DEBUG_LOG", "sipserver_debug.log");
            properties.setProperty("gov.nist.javax.sip.SERVER_LOG", "sipserver_messages.log");
            
            SipFactory sipFactory = SipFactory.getInstance();
            sipFactory.setPathName("gov.nist");
            sipStack = sipFactory.createSipStack(properties);
            
            headerFactory = sipFactory.createHeaderFactory();
            addressFactory = sipFactory.createAddressFactory();
            messageFactory = sipFactory.createMessageFactory();
            
            // 为每个传输协议创建监听器
            for (String transport : transports) {
                ListeningPoint listeningPoint = sipStack.createListeningPoint(host, port, transport);
                SipProvider sipProvider = sipStack.createSipProvider(listeningPoint);
                sipProviders.add(sipProvider);
                log.info("Created SIP provider for transport: {}", transport);
            }
            
            log.info("GB28181 SIP Server started successfully on {}:{} with transports: {}", host, port, transports);
        } catch (Exception e) {
            log.error("Failed to start GB28181 SIP Server", e);
        }
    }

    /**
     * 停止SIP服务器
     */
    public void stop() {
        log.info("Stopping GB28181 SIP Server...");
        try {
            if (sipStack != null) {
                sipStack.stop();
            }
            sipProviders.clear();
            log.info("GB28181 SIP Server stopped successfully");
        } catch (Exception e) {
            log.error("Failed to stop GB28181 SIP Server", e);
        }
    }
    
    public List<SipProvider> getSipProviders() {
        return sipProviders;
    }
    
    public AddressFactory getAddressFactory() {
        return addressFactory;
    }
    
    public HeaderFactory getHeaderFactory() {
        return headerFactory;
    }
    
    public MessageFactory getMessageFactory() {
        return messageFactory;
    }
}
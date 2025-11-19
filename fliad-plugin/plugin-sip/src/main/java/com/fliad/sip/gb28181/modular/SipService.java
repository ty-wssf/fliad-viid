package com.fliad.sip.gb28181.modular;

import com.fliad.sip.gb28181.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sip.*;
import javax.sip.message.Request;
import javax.sip.message.Response;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * SIP服务主类
 *
 * @author your-name
 * @since 0.1.0
 */
public class SipService implements SipListener {
    private static final Logger log = LoggerFactory.getLogger(SipService.class);

    private final SipServer sipServer = SipServer.getInstance();
    private final SipMessageHandler messageHandler = new SipMessageHandler();

    /**
     * 初始化SIP服务
     */
    public void initialize() {
        log.info("Initializing SIP Service...");
        sipServer.initialize();
    }

    /**
     * 配置SIP服务参数
     *
     * @param host       主机地址
     * @param port       端口号
     * @param transports 传输协议列表(UDP/TCP)
     */
    public void configure(String host, int port, List<String> transports) {
        Objects.requireNonNull(host, "Host must not be null");
        Objects.requireNonNull(transports, "Transports must not be null");
        
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Port must be between 1 and 65535");
        }
        
        if (transports.isEmpty()) {
            throw new IllegalArgumentException("Transports must not be empty");
        }
        
        sipServer.configure(host, port, transports);
        log.info("SIP Service configured");
    }
    
    /**
     * 设置SIP服务器配置回调函数
     * 
     * @param configCallback 配置回调函数
     */
    public void setSipConfigCallback(Consumer<SipServer.SipConfig> configCallback) {
        sipServer.setConfigCallback(configCallback);
    }

    /**
     * 启动SIP服务
     */
    public void start() {
        log.info("Starting SIP Service...");
        try {
            sipServer.start();
            // 注册SIP事件监听器
            for (SipProvider sipProvider : sipServer.getSipProviders()) {
                if (sipProvider != null) {
                    sipProvider.addSipListener(this);
                }
            }
            log.info("SIP Service started successfully");
        } catch (Exception e) {
            log.error("Failed to start SIP Service", e);
            throw new RuntimeException("Failed to start SIP service", e);
        }
    }

    /**
     * 停止SIP服务
     */
    public void stop() {
        log.info("Stopping SIP Service...");
        try {
            for (SipProvider sipProvider : sipServer.getSipProviders()) {
                if (sipProvider != null) {
                    sipProvider.removeSipListener(this);
                }
            }
            sipServer.stop();
            log.info("SIP Service stopped successfully");
        } catch (Exception e) {
            log.error("Failed to stop SIP Service", e);
        }
    }

    // SipListener 接口实现

    @Override
    public void processRequest(RequestEvent requestEvent) {
        Request request = requestEvent.getRequest();
        log.debug("Processing SIP request: {}", request.getMethod());
        try {
            messageHandler.handleRequest(requestEvent);
        } catch (Exception e) {
            log.error("Error processing SIP request: {}", request.getMethod(), e);
        }
    }

    @Override
    public void processResponse(ResponseEvent responseEvent) {
        Response response = responseEvent.getResponse();
        log.debug("Processing SIP response: {}", response.getStatusCode());
        try {
            messageHandler.handleResponse(responseEvent);
        } catch (Exception e) {
            log.error("Error processing SIP response: {}", response.getStatusCode(), e);
        }
    }

    @Override
    public void processTimeout(TimeoutEvent timeoutEvent) {
        log.warn("SIP timeout event occurred");
        // TODO: 实现超时处理逻辑
    }

    @Override
    public void processIOException(IOExceptionEvent exceptionEvent) {
        log.error("SIP IO exception occurred: {}", exceptionEvent.getHost());
        // TODO: 实现IO异常处理逻辑
    }

    @Override
    public void processTransactionTerminated(TransactionTerminatedEvent transactionTerminatedEvent) {
        log.debug("SIP transaction terminated");
        // TODO: 实现事务终止处理逻辑
    }

    @Override
    public void processDialogTerminated(DialogTerminatedEvent dialogTerminatedEvent) {
        log.debug("SIP dialog terminated: {}", dialogTerminatedEvent.getDialog().getDialogId());
        // TODO: 实现对话终止处理逻辑
    }
}
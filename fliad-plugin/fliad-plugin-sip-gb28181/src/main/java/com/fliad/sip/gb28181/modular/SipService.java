package com.fliad.sip.gb28181.modular;

import com.fliad.sip.gb28181.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sip.*;
import javax.sip.message.Request;
import javax.sip.message.Response;
import java.util.List;

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
        log.info("Initializing SIP GB28181 Service...");
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
        sipServer.configure(host, port, transports);
        log.info("SIP Service configured with host: {}, port: {}, transports: {}", host, port, transports);
    }

    /**
     * 启动SIP服务
     */
    public void start() {
        log.info("Starting SIP GB28181 Service...");
        try {
            sipServer.start();
            // 注册SIP事件监听器
            for (SipProvider sipProvider : sipServer.getSipProviders()) {
                if (sipProvider != null) {
                    sipProvider.addSipListener(this);
                }
            }
            log.info("SIP GB28181 Service started successfully");
        } catch (Exception e) {
            log.error("Failed to start SIP GB28181 Service", e);
        }
    }

    /**
     * 停止SIP服务
     */
    public void stop() {
        log.info("Stopping SIP GB28181 Service...");
        try {
            for (SipProvider sipProvider : sipServer.getSipProviders()) {
                if (sipProvider != null) {
                    sipProvider.removeSipListener(this);
                }
            }
            sipServer.stop();
            log.info("SIP GB28181 Service stopped successfully");
        } catch (Exception e) {
            log.error("Failed to stop SIP GB28181 Service", e);
        }
    }

    // SipListener 接口实现

    @Override
    public void processRequest(RequestEvent requestEvent) {
        Request request = requestEvent.getRequest();
        log.debug("Processing SIP request: {}", request.getMethod());
        messageHandler.handleRequest(requestEvent);
    }

    @Override
    public void processResponse(ResponseEvent responseEvent) {
        Response response = responseEvent.getResponse();
        log.debug("Processing SIP response: {}", response.getStatusCode());
        messageHandler.handleResponse(responseEvent);
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
        log.debug("SIP dialog terminated");
        // TODO: 实现对话终止处理逻辑
    }
}
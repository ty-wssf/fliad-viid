package com.fliad.sip.gb28181.modular;

import com.fliad.sip.gb28181.core.SipDeviceRegistry;
import com.fliad.sip.gb28181.modular.handler.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sip.RequestEvent;
import javax.sip.ResponseEvent;
import javax.sip.ServerTransaction;
import javax.sip.header.ContactHeader;
import javax.sip.header.FromHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * SIP消息处理器
 *
 * @author your-name
 * @since 0.1.0
 */
public class SipMessageHandler {
    private static final Logger log = LoggerFactory.getLogger(SipMessageHandler.class);

    /**
     * 设备注册管理器
     */
    private final SipDeviceRegistry deviceRegistry = SipDeviceRegistry.getInstance();
    
    /**
     * 请求处理器映射
     */
    private final Map<String, SipRequestHandler> requestHandlers = new HashMap<>();

    public SipMessageHandler() {
        initRequestHandlers();
    }

    /**
     * 初始化请求处理器
     */
    private void initRequestHandlers() {
        requestHandlers.put(Request.REGISTER, new RegisterRequestHandler());
        requestHandlers.put(Request.MESSAGE, new MessageRequestHandler());
        requestHandlers.put(Request.INVITE, new InviteRequestHandler());
        requestHandlers.put(Request.ACK, new AckRequestHandler());
        requestHandlers.put(Request.BYE, new ByeRequestHandler());
    }
    
    /**
     * 处理SIP请求消息
     * 
     * @param requestEvent 请求事件
     */
    public void handleRequest(RequestEvent requestEvent) {
        Request request = requestEvent.getRequest();
        ServerTransaction serverTransaction = requestEvent.getServerTransaction();
        
        String method = request.getMethod();
        log.debug("Received SIP request: {}", method);
        
        SipRequestHandler handler = requestHandlers.get(method);
        if (handler != null) {
            handler.handleRequest(requestEvent);
        } else {
            log.warn("Unsupported SIP method: {}", method);
        }
    }
    
    /**
     * 处理SIP响应消息
     * 
     * @param responseEvent 响应事件
     */
    public void handleResponse(ResponseEvent responseEvent) {
        Response response = responseEvent.getResponse();
        log.debug("Received SIP response: {}", response.getStatusCode());
        // TODO: 实现响应处理逻辑
    }

    /**
     * 处理MESSAGE消息
     *
     * @param from 消息来源
     * @param content 消息内容
     */
    public void handleMessage(String from, String content) {
        log.info("Handling MESSAGE from: {}, content: {}", from, content);
        
        // TODO: 实现消息处理逻辑
    }

    /**
     * 处理INVITE消息（媒体请求）
     *
     * @param from 请求来源
     * @param sdp SDP内容
     */
    public void handleInvite(String from, String sdp) {
        log.info("Handling INVITE from: {}", from);
        
        // TODO: 实现邀请处理逻辑
    }

    /**
     * 内部类：设备信息
     */
    public static class DeviceInfo {
        private final String from;
        private final String contact;
        private final long registerTime;

        public DeviceInfo(String from, String contact) {
            this.from = from;
            this.contact = contact;
            this.registerTime = System.currentTimeMillis();
        }

        public String getFrom() {
            return from;
        }

        public String getContact() {
            return contact;
        }

        public long getRegisterTime() {
            return registerTime;
        }
    }
}
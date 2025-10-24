package com.fliad.sip.gb28181.modular;

import com.fliad.sip.gb28181.core.SipDeviceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sip.RequestEvent;
import javax.sip.ResponseEvent;
import javax.sip.ServerTransaction;
import javax.sip.header.ContactHeader;
import javax.sip.header.FromHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;

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
     * 处理SIP请求消息
     * 
     * @param requestEvent 请求事件
     */
    public void handleRequest(RequestEvent requestEvent) {
        Request request = requestEvent.getRequest();
        ServerTransaction serverTransaction = requestEvent.getServerTransaction();
        
        String method = request.getMethod();
        log.debug("Received SIP request: {}", method);
        
        switch (method) {
            case Request.REGISTER:
                handleRegisterRequest(request, serverTransaction);
                break;
            case Request.MESSAGE:
                handleMessageRequest(request, serverTransaction);
                break;
            case Request.INVITE:
                handleInviteRequest(request, serverTransaction);
                break;
            case Request.ACK:
                handleAckRequest(request, serverTransaction);
                break;
            case Request.BYE:
                handleByeRequest(request, serverTransaction);
                break;
            default:
                log.warn("Unsupported SIP method: {}", method);
                break;
        }
    }
    
    /**
     * 处理注册请求
     */
    private void handleRegisterRequest(Request request, ServerTransaction serverTransaction) {
        try {
            FromHeader fromHeader = (FromHeader) request.getHeader(FromHeader.NAME);
            ContactHeader contactHeader = (ContactHeader) request.getHeader(ContactHeader.NAME);
            
            String from = fromHeader.getAddress().toString();
            String deviceId = fromHeader.getAddress().getURI().toString(); // 需要解析出设备ID
            String contact = contactHeader != null ? contactHeader.getAddress().toString() : "";
            
            log.info("Handling REGISTER from device: {}, contact: {}", deviceId, contact);
            
            // 注册设备
            deviceRegistry.registerDevice(deviceId, new DeviceInfo(from, contact));
            
            // 发送成功响应
            // TODO: 实际项目中需要构建正确的SIP响应
        } catch (Exception e) {
            log.error("Error handling REGISTER request", e);
        }
    }
    
    /**
     * 处理消息请求
     */
    private void handleMessageRequest(Request request, ServerTransaction serverTransaction) {
        try {
            String from = request.getHeader(FromHeader.NAME).toString();
            String content = new String(request.getRawContent());
            
            log.info("Handling MESSAGE from: {}, content: {}", from, content);
            
            // 解析GB28181消息体
            parseGb28181Message(content);
            
            // TODO: 实现完整的消息处理逻辑
        } catch (Exception e) {
            log.error("Error handling MESSAGE request", e);
        }
    }
    
    /**
     * 处理解析GB28181消息体
     */
    private void parseGb28181Message(String content) {
        // TODO: 实现GB28181 XML消息解析
        log.debug("Parsing GB28181 message content: {}", content);
    }
    
    /**
     * 处理邀请请求
     */
    private void handleInviteRequest(Request request, ServerTransaction serverTransaction) {
        try {
            String from = request.getHeader(FromHeader.NAME).toString();
            String sdp = new String(request.getRawContent());
            
            log.info("Handling INVITE from: {}", from);
            
            // TODO: 实现完整的邀请处理逻辑
        } catch (Exception e) {
            log.error("Error handling INVITE request", e);
        }
    }
    
    /**
     * 处理确认请求
     */
    private void handleAckRequest(Request request, ServerTransaction serverTransaction) {
        log.debug("Handling ACK request");
        // TODO: 实现ACK处理逻辑
    }
    
    /**
     * 处理BYE请求
     */
    private void handleByeRequest(Request request, ServerTransaction serverTransaction) {
        log.debug("Handling BYE request");
        // TODO: 实现BYE处理逻辑
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
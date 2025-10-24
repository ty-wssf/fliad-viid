package com.fliad.sip.gb28181.modular.handler;

import com.fliad.sip.gb28181.core.SipServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sip.*;
import javax.sip.header.*;
import javax.sip.message.Request;
import javax.sip.message.Response;

/**
 * INVITE请求处理器
 *
 * @author your-name
 * @since 0.1.0
 */
public class InviteRequestHandler implements SipRequestHandler {
    private static final Logger log = LoggerFactory.getLogger(InviteRequestHandler.class);
    
    private final SipServer sipServer = SipServer.getInstance();

    @Override
    public void handleRequest(RequestEvent requestEvent) {
        Request request = requestEvent.getRequest();
        ServerTransaction serverTransaction = requestEvent.getServerTransaction();

        handleInviteRequest(request, serverTransaction, requestEvent);
    }

    /**
     * 处理邀请请求
     */
    private void handleInviteRequest(Request request, ServerTransaction serverTransaction, RequestEvent requestEvent) {
        try {
            FromHeader fromHeader = (FromHeader) request.getHeader(FromHeader.NAME);
            ContactHeader contactHeader = (ContactHeader) request.getHeader(ContactHeader.NAME);
            CallIdHeader callIdHeader = (CallIdHeader) request.getHeader(CallIdHeader.NAME);
            ToHeader toHeader = (ToHeader) request.getHeader(ToHeader.NAME);
            
            String from = fromHeader != null ? fromHeader.getAddress().toString() : "unknown";
            String contact = contactHeader != null ? contactHeader.getAddress().toString() : "unknown";
            String callId = callIdHeader != null ? callIdHeader.getCallId() : "unknown";
            
            String sdp = "";
            if (request.getRawContent() != null) {
                sdp = new String(request.getRawContent());
            }

            log.info("Handling INVITE from: {}, contact: {}, callId: {}", from, contact, callId);

            // 发送100 Trying响应
            sendTryingResponse(request, serverTransaction, requestEvent);
            
            // TODO: 实现完整的邀请处理逻辑
            // 例如：解析SDP，创建媒体会话，与媒体服务器交互等
            
            // 目前我们只记录日志，实际应用中需要实现完整的媒体协商逻辑
            
        } catch (Exception e) {
            log.error("Error handling INVITE request", e);
            
            // 发送错误响应
            try {
                if (serverTransaction != null) {
                    Response errorResponse = sipServer.getMessageFactory()
                        .createResponse(Response.SERVER_INTERNAL_ERROR, request);
                    serverTransaction.sendResponse(errorResponse);
                    log.info("Sent error response for INVITE request");
                }
            } catch (Exception ex) {
                log.error("Failed to send error response for INVITE", ex);
            }
        }
    }
    
    /**
     * 发送100 Trying响应
     */
    private void sendTryingResponse(Request request, ServerTransaction serverTransaction, RequestEvent requestEvent) {
        try {
            Response response = sipServer.getMessageFactory().createResponse(Response.TRYING, request);
            
            if (serverTransaction == null) {
                // 创建新的服务器事务
                SipProvider sipProvider = (SipProvider) requestEvent.getSource();
                serverTransaction = sipProvider.getNewServerTransaction(request);
            }
            
            serverTransaction.sendResponse(response);
            log.debug("Sent 100 Trying response for INVITE");
        } catch (Exception e) {
            log.error("Error sending 100 Trying response", e);
        }
    }
}
package com.fliad.sip.gb28181.modular.handler;

import com.fliad.sip.gb28181.core.SipServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sip.*;
import javax.sip.header.CallIdHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;

/**
 * ACK请求处理器
 *
 * @author your-name
 * @since 0.1.0
 */
public class AckRequestHandler implements SipRequestHandler {
    private static final Logger log = LoggerFactory.getLogger(AckRequestHandler.class);
    
    private final SipServer sipServer = SipServer.getInstance();

    @Override
    public void handleRequest(RequestEvent requestEvent) {
        Request request = requestEvent.getRequest();
        ServerTransaction serverTransaction = requestEvent.getServerTransaction();

        handleAckRequest(request, serverTransaction, requestEvent);
    }

    /**
     * 处理确认请求
     */
    private void handleAckRequest(Request request, ServerTransaction serverTransaction, RequestEvent requestEvent) {
        try {
            log.debug("Handling ACK request");
            
            // 获取Call-ID
            CallIdHeader callIdHeader = (CallIdHeader) request.getHeader(CallIdHeader.NAME);
            String callId = callIdHeader != null ? callIdHeader.getCallId() : "unknown";
            
            log.info("Processing ACK for call ID: {}", callId);
            
            // ACK通常是对INVITE的确认，不需要特别响应
            // 但我们可以通过日志记录相关信息
            
            // TODO: 实际应用中可能需要更新会话状态或触发其他操作
            
        } catch (Exception e) {
            log.error("Error handling ACK request", e);
            
            // 尽管ACK通常不需要响应，但如果出现异常，我们可能需要记录
            try {
                if (serverTransaction != null) {
                    Response errorResponse = sipServer.getMessageFactory()
                        .createResponse(Response.SERVER_INTERNAL_ERROR, request);
                    serverTransaction.sendResponse(errorResponse);
                    log.info("Sent error response for ACK request");
                }
            } catch (Exception ex) {
                log.error("Failed to send error response for ACK", ex);
            }
        }
    }
}
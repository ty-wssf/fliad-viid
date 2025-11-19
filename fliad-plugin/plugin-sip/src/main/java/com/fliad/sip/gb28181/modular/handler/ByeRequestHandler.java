package com.fliad.sip.gb28181.modular.handler;

import com.fliad.sip.gb28181.core.SipServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sip.*;
import javax.sip.header.CallIdHeader;
import javax.sip.header.FromHeader;
import javax.sip.header.ToHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;

/**
 * BYE请求处理器
 *
 * @author your-name
 * @since 0.1.0
 */
public class ByeRequestHandler implements SipRequestHandler {
    private static final Logger log = LoggerFactory.getLogger(ByeRequestHandler.class);
    
    private final SipServer sipServer = SipServer.getInstance();

    @Override
    public void handleRequest(RequestEvent requestEvent) {
        Request request = requestEvent.getRequest();
        ServerTransaction serverTransaction = requestEvent.getServerTransaction();

        handleByeRequest(request, serverTransaction, requestEvent);
    }

    /**
     * 处理BYE请求
     */
    private void handleByeRequest(Request request, ServerTransaction serverTransaction, RequestEvent requestEvent) {
        try {
            log.debug("Handling BYE request");
            
            // 获取关键头部信息
            CallIdHeader callIdHeader = (CallIdHeader) request.getHeader(CallIdHeader.NAME);
            FromHeader fromHeader = (FromHeader) request.getHeader(FromHeader.NAME);
            ToHeader toHeader = (ToHeader) request.getHeader(ToHeader.NAME);
            
            String callId = callIdHeader != null ? callIdHeader.getCallId() : "unknown";
            String from = fromHeader != null ? fromHeader.getAddress().toString() : "unknown";
            
            log.info("Processing BYE request from {} for call ID: {}", from, callId);
            
            // 发送200 OK响应
            Response response = sipServer.getMessageFactory().createResponse(Response.OK, request);
            
            if (serverTransaction == null) {
                // 创建新的服务器事务
                SipProvider sipProvider = (SipProvider) requestEvent.getSource();
                serverTransaction = sipProvider.getNewServerTransaction(request);
            }
            
            serverTransaction.sendResponse(response);
            log.info("Sent 200 OK response for BYE request");
            
            // TODO: 实际应用中可能需要清理会话资源、通知媒体服务器等
            
        } catch (Exception e) {
            log.error("Error handling BYE request", e);
            
            // 发送错误响应
            try {
                if (serverTransaction != null) {
                    Response errorResponse = sipServer.getMessageFactory()
                        .createResponse(Response.SERVER_INTERNAL_ERROR, request);
                    serverTransaction.sendResponse(errorResponse);
                    log.info("Sent error response for BYE request");
                }
            } catch (Exception ex) {
                log.error("Failed to send error response for BYE", ex);
            }
        }
    }
}
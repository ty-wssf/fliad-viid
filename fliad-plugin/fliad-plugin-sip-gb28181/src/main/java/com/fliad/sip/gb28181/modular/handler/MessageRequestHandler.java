package com.fliad.sip.gb28181.modular.handler;

import com.fliad.sip.gb28181.core.Gb28181MessageProcessor;
import com.fliad.sip.gb28181.core.SipServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sip.*;
import javax.sip.header.FromHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;

/**
 * MESSAGE请求处理器
 *
 * @author your-name
 * @since 0.1.0
 */
public class MessageRequestHandler implements SipRequestHandler {
    private static final Logger log = LoggerFactory.getLogger(MessageRequestHandler.class);
    
    private final SipServer sipServer = SipServer.getInstance();
    private final Gb28181MessageProcessor messageProcessor = Gb28181MessageProcessor.getInstance();

    @Override
    public void handleRequest(RequestEvent requestEvent) {
        Request request = requestEvent.getRequest();
        ServerTransaction serverTransaction = requestEvent.getServerTransaction();

        handleMessageRequest(request, serverTransaction, requestEvent);
    }

    /**
     * 处理消息请求
     */
    private void handleMessageRequest(Request request, ServerTransaction serverTransaction, RequestEvent requestEvent) {
        try {
            FromHeader fromHeader = (FromHeader) request.getHeader(FromHeader.NAME);
            String from = fromHeader != null ? fromHeader.getAddress().toString() : "unknown";
            
            String content = "";
            if (request.getRawContent() != null) {
                content = new String(request.getRawContent());
            }

            log.info("Handling MESSAGE from: {}, content length: {}", from, content.length());

            // 解析GB28181消息体
            parseGb28181Message(content);

            // 发送200 OK响应
            sendOkResponse(request, serverTransaction, requestEvent);
            
            // TODO: 实现完整的消息处理逻辑
        } catch (Exception e) {
            log.error("Error handling MESSAGE request", e);
            
            // 发送错误响应
            try {
                if (serverTransaction != null) {
                    Response errorResponse = sipServer.getMessageFactory()
                        .createResponse(Response.SERVER_INTERNAL_ERROR, request);
                    serverTransaction.sendResponse(errorResponse);
                    log.info("Sent error response for MESSAGE request");
                }
            } catch (Exception ex) {
                log.error("Failed to send error response for MESSAGE", ex);
            }
        }
    }

    /**
     * 处理解析GB28181消息体
     */
    private void parseGb28181Message(String content) {
        // TODO: 实现GB28181 XML消息解析
        log.debug("Parsing GB28181 message content: {}", content);
        
        if (content.contains("<CmdType>Keepalive</CmdType>")) {
            log.info("Received keepalive message");
            // TODO: 更新设备活跃状态
        } else if (content.contains("<CmdType>Alarm</CmdType>")) {
            log.info("Received alarm message");
            // TODO: 处理报警消息
        } else if (content.contains("<CmdType>MediaStatus</CmdType>")) {
            log.info("Received media status message");
            // TODO: 处理媒体状态消息
        }
    }
    
    /**
     * 发送200 OK响应
     */
    private void sendOkResponse(Request request, ServerTransaction serverTransaction, RequestEvent requestEvent) {
        try {
            Response response = sipServer.getMessageFactory().createResponse(Response.OK, request);
            
            if (serverTransaction == null) {
                // 创建新的服务器事务
                SipProvider sipProvider = (SipProvider) requestEvent.getSource();
                serverTransaction = sipProvider.getNewServerTransaction(request);
            }
            
            serverTransaction.sendResponse(response);
            log.debug("Sent 200 OK response for MESSAGE");
        } catch (Exception e) {
            log.error("Error sending 200 OK response", e);
        }
    }
}
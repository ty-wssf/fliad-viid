package com.fliad.sip.gb28181.modular.handler;

import com.fliad.sip.gb28181.core.AuthenticationManager;
import com.fliad.sip.gb28181.core.SipDeviceRegistry;
import com.fliad.sip.gb28181.core.SipServer;
import com.fliad.sip.gb28181.modular.SipMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sip.*;
import javax.sip.address.URI;
import javax.sip.header.*;
import javax.sip.message.Request;
import javax.sip.message.Response;
import java.text.ParseException;
import java.util.Calendar;

/**
 * REGISTER请求处理器
 *
 * @author your-name
 * @since 0.1.0
 */
public class RegisterRequestHandler implements SipRequestHandler {
    private static final Logger log = LoggerFactory.getLogger(RegisterRequestHandler.class);

    /**
     * 设备注册管理器
     */
    private final SipDeviceRegistry deviceRegistry = SipDeviceRegistry.getInstance();

    /**
     * SIP服务器实例
     */
    private final SipServer sipServer = SipServer.getInstance();

    /**
     * 认证管理器
     */
    private final AuthenticationManager authManager = AuthenticationManager.getInstance();

    @Override
    public void handleRequest(RequestEvent requestEvent) {
        Request request = requestEvent.getRequest();
        ServerTransaction serverTransaction = requestEvent.getServerTransaction();

        handleRegisterRequest(request, serverTransaction, requestEvent);
    }

    /**
     * 处理注册请求
     */
    private void handleRegisterRequest(Request request, ServerTransaction serverTransaction, RequestEvent requestEvent) {
        FromHeader fromHeader = (FromHeader) request.getHeader(FromHeader.NAME);
        ContactHeader contactHeader = (ContactHeader) request.getHeader(ContactHeader.NAME);
        ToHeader toHeader = (ToHeader) request.getHeader(ToHeader.NAME);
        CallIdHeader callIdHeader = (CallIdHeader) request.getHeader(CallIdHeader.NAME);
        CSeqHeader cSeqHeader = (CSeqHeader) request.getHeader(CSeqHeader.NAME);

        // 检查是否有Authorization头
        AuthorizationHeader authHeader = (AuthorizationHeader) request.getHeader(AuthorizationHeader.NAME);

        // 提取设备ID
        String deviceId = extractDeviceId(fromHeader);
        String from = fromHeader.getAddress().toString();
        String contact = contactHeader != null ? contactHeader.getAddress().toString() : "";

        log.info("Handling REGISTER from device: {}, contact: {}", deviceId, contact);

        // 如果没有Authorization头，发送401响应要求认证
        if (authHeader == null) {
            log.debug("No Authorization header found, sending 401 response");
            sendUnauthorizedResponse(request, serverTransaction, requestEvent);
            return;
        }

        // 如果有Authorization头，验证认证信息
        if (authManager.validateAuthorization(authHeader, deviceId)) {
            // 认证成功，注册设备
            SipMessageHandler.DeviceInfo deviceInfo = new SipMessageHandler.DeviceInfo(from, contact);
            deviceRegistry.registerDevice(deviceId, deviceInfo);

            // 发送成功响应
            sendRegisterSuccessResponse(request, serverTransaction, fromHeader, toHeader, callIdHeader, cSeqHeader, requestEvent);
        } else {
            // 认证失败，发送403 Forbidden响应
            sendForbiddenResponse(request, serverTransaction, requestEvent);
        }
    }

    /**
     * 从FromHeader提取设备ID
     *
     * @param fromHeader From头
     * @return 设备ID
     */
    private String extractDeviceId(FromHeader fromHeader) {
        URI uri = fromHeader.getAddress().getURI();
        if (uri instanceof javax.sip.address.SipURI) {
            return ((javax.sip.address.SipURI) uri).getUser();
        }
        return fromHeader.getAddress().getURI().toString();
    }

    /**
     * 发送401 Unauthorized响应
     */
    private void sendUnauthorizedResponse(Request request, ServerTransaction serverTransaction, RequestEvent requestEvent) {
        try {
            // 构建401响应
            Response response = sipServer.getMessageFactory().createResponse(Response.UNAUTHORIZED, request);

            // 添加WWW-Authenticate头
            String realm = authManager.generateRealm();
            String nonce = authManager.generateNonce();
            String authHeaderStr = "Digest realm=\"" + realm + "\", nonce=\"" + nonce + "\"";
            WWWAuthenticateHeader wwwAuthHeader = sipServer.getHeaderFactory().createWWWAuthenticateHeader(authHeaderStr);
            response.setHeader(wwwAuthHeader);

            // 发送响应
            if (serverTransaction == null) {
                // 创建新的服务器事务
                SipProvider sipProvider = (SipProvider) requestEvent.getSource();
                serverTransaction = sipProvider.getNewServerTransaction(request);
            }

            serverTransaction.sendResponse(response);
            log.info("Sent REGISTER 401 Unauthorized response with realm: {}, nonce: {}", realm, nonce);
        } catch (Exception e) {
            log.error("Error sending 401 response", e);
        }
    }

    /**
     * 发送注册成功响应(200 OK)
     */
    private void sendRegisterSuccessResponse(Request request, ServerTransaction serverTransaction,
                                             FromHeader fromHeader, ToHeader toHeader,
                                             CallIdHeader callIdHeader, CSeqHeader cSeqHeader,
                                             RequestEvent requestEvent) {
        try {
            // 构建响应
            Response response = sipServer.getMessageFactory().createResponse(Response.OK, request);

            // 设置必要的头部
            response.setHeader(fromHeader);
            response.setHeader(toHeader);
            response.setHeader(callIdHeader);
            response.setHeader(cSeqHeader);

            // 添加Expires头（默认3600秒）
            ExpiresHeader expiresHeader = sipServer.getHeaderFactory().createExpiresHeader(3600);
            response.setHeader(expiresHeader);

            // 添加Date头
            Calendar calendar = Calendar.getInstance();
            DateHeader dateHeader = sipServer.getHeaderFactory().createDateHeader(calendar);
            response.setHeader(dateHeader);

            // 添加Contact头
            ContactHeader contactHeader = (ContactHeader) request.getHeader(ContactHeader.NAME);
            if (contactHeader != null) {
                response.setHeader(contactHeader);
            }

            // 发送响应
            if (serverTransaction == null) {
                // 创建新的服务器事务
                SipProvider sipProvider = (SipProvider) requestEvent.getSource();
                serverTransaction = sipProvider.getNewServerTransaction(request);
            }

            serverTransaction.sendResponse(response);
            log.info("Sent REGISTER 200 OK response");
        } catch (Exception e) {
            log.error("Error sending REGISTER success response", e);
        }
    }

    /**
     * 发送403 Forbidden响应
     */
    private void sendForbiddenResponse(Request request, ServerTransaction serverTransaction, RequestEvent requestEvent) {
        try {
            Response response = sipServer.getMessageFactory().createResponse(Response.FORBIDDEN, request);

            if (serverTransaction == null) {
                // 创建新的服务器事务
                SipProvider sipProvider = (SipProvider) requestEvent.getSource();
                serverTransaction = sipProvider.getNewServerTransaction(request);
            }

            serverTransaction.sendResponse(response);
            log.info("Sent REGISTER 403 Forbidden response");
        } catch (Exception e) {
            log.error("Error sending 403 response", e);
        }
    }

    /**
     * 发送400 Bad Request响应
     */
    private void sendBadRequestResponse(Request request, ServerTransaction serverTransaction, RequestEvent requestEvent) {
        try {
            Response response = sipServer.getMessageFactory().createResponse(Response.BAD_REQUEST, request);

            if (serverTransaction == null) {
                // 创建新的服务器事务
                SipProvider sipProvider = (SipProvider) requestEvent.getSource();
                serverTransaction = sipProvider.getNewServerTransaction(request);
            }

            serverTransaction.sendResponse(response);
            log.info("Sent REGISTER 400 Bad Request response");
        } catch (Exception e) {
            log.error("Error sending 400 response", e);
        }
    }

    /**
     * 发送错误响应
     */
    private void sendErrorResponse(Request request, ServerTransaction serverTransaction, RequestEvent requestEvent) {
        try {
            Response response = sipServer.getMessageFactory().createResponse(Response.SERVER_INTERNAL_ERROR, request);

            if (serverTransaction == null) {
                // 创建新的服务器事务
                SipProvider sipProvider = (SipProvider) requestEvent.getSource();
                serverTransaction = sipProvider.getNewServerTransaction(request);
            }

            serverTransaction.sendResponse(response);
            log.info("Sent REGISTER error response");
        } catch (Exception ex) {
            log.error("Error sending error response", ex);
        }
    }
}
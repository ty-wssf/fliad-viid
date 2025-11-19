package com.fliad.sip.gb28181.modular.handler;

import javax.sip.RequestEvent;
import javax.sip.ServerTransaction;

/**
 * SIP请求处理器接口
 *
 * @author your-name
 * @since 0.1.0
 */
public interface SipRequestHandler {
    /**
     * 处理SIP请求
     *
     * @param requestEvent 请求事件
     */
    void handleRequest(RequestEvent requestEvent);
}
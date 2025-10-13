package com.fliad.auth.modular.auth;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import com.fliad.auth.api.AuthApi;
import com.fliad.auth.core.util.StpClientUtil;
import com.fliad.auth.modular.third.service.AuthThirdService;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 认证鉴权API实现类
 *
 * @author yubaoshan
 * @date 2024/7/18 17:35
 */
@Component
public class AuthApiProvider implements AuthApi {

    @Inject
    private AuthThirdService authThirdService;

    
    @Override
    public JSONObject getUserSessionCount() {
        JSONObject resultObj = new JSONObject();
        List<JSONObject> sessionListB = StpUtil.searchSessionId("", -1, -1, true).stream().map(sessionId -> {
            JSONObject jsonObject = JSONUtil.createObj();
            String userId = StrUtil.split(sessionId, StrUtil.COLON).get(3);
            SaSession saSession = StpUtil.getSessionByLoginId(userId, false);
            int tokenCount = saSession.getTerminalList().size();
            long createTime = saSession.getCreateTime();
            jsonObject.set("userId", userId);
            jsonObject.set("tokenCount", tokenCount);
            jsonObject.set("createTime", DateTime.of(createTime));
            return jsonObject;
        }).collect(Collectors.toList());

        List<JSONObject> sessionListC = StpClientUtil.searchSessionId("", -1, -1).stream().map(sessionId -> {
            JSONObject jsonObject = JSONUtil.createObj();
            String userId = StrUtil.split(sessionId, StrUtil.COLON).get(3);
            SaSession saSession = StpClientUtil.getSessionByLoginId(userId, false);
            int tokenCount = saSession.getTerminalList().size();
            long createTime = saSession.getCreateTime();
            jsonObject.set("userId", userId);
            jsonObject.set("tokenCount", tokenCount);
            jsonObject.set("createTime", DateTime.of(createTime));
            return jsonObject;
        }).collect(Collectors.toList());
        resultObj.set("backUserSessionCount" ,sessionListB.size());
        resultObj.set("clientUserSessionCount" ,sessionListC.size());
        return resultObj;
    }

    @Override
    public Long getThirdUserCount() {
        return authThirdService.count();
    }
}

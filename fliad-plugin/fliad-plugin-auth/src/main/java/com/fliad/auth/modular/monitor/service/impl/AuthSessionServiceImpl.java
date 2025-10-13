/*
 * Copyright [2022] [https://www.xiaonuo.vip]
 *
 * Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：
 *
 * 1.请不要删除和修改根目录下的LICENSE文件。
 * 2.请不要删除和修改Snowy源码头部的版权声明。
 * 3.本项目代码可免费商业使用，商业使用请保留源码和相关描述文件的项目出处，作者声明等。
 * 4.分发源码时候，请注明软件出处 https://www.xiaonuo.vip
 * 5.不可二次分发开源参与同类竞品，如有想法可联系团队xiaonuobase@qq.com商议合作。
 * 6.若您的项目无法满足以上几点，需要更多功能代码，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package com.fliad.auth.modular.monitor.service.impl;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mybatisflex.core.paginate.Page;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import com.fliad.auth.api.SaBaseLoginUserApi;
import com.fliad.auth.core.util.StpClientUtil;
import com.fliad.auth.modular.monitor.param.AuthExitSessionParam;
import com.fliad.auth.modular.monitor.param.AuthExitTokenParam;
import com.fliad.auth.modular.monitor.param.AuthSessionPageParam;
import com.fliad.auth.modular.monitor.result.AuthSessionAnalysisResult;
import com.fliad.auth.modular.monitor.result.AuthSessionPageResult;
import com.fliad.auth.modular.monitor.service.AuthSessionService;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.common.util.CommonTimeFormatUtil;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 会话治理Service接口实现类
 *
 * @author xuyuxiang
 * @date 2022/6/24 22:25
 */
@Component
public class AuthSessionServiceImpl implements AuthSessionService {

    @Inject("loginUserApi")
    private SaBaseLoginUserApi loginUserApi;

    @Inject("clientLoginUserApi")
    private SaBaseLoginUserApi clientLoginUserApi;

    @Override
    public AuthSessionAnalysisResult analysis() {
        AuthSessionAnalysisResult authSessionAnalysisResult = new AuthSessionAnalysisResult();
        List<JSONObject> sessionListB = StpUtil.searchSessionId("", -1, -1, false).stream().map(sessionId -> {
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

        List<Integer> tokenCountList = CollectionUtil.newArrayList();
        tokenCountList.addAll(sessionListB.stream().map(jsonObject -> jsonObject.getInt("tokenCount")).collect(Collectors.toList()));
        tokenCountList.addAll(sessionListC.stream().map(jsonObject -> jsonObject.getInt("tokenCount")).collect(Collectors.toList()));
        CollectionUtil.sort(tokenCountList, Comparator.comparingInt(Integer::intValue));
        int currentSessionTotalCount = sessionListB.size() + sessionListC.size();
        authSessionAnalysisResult.setCurrentSessionTotalCount(Convert.toStr(currentSessionTotalCount));
        authSessionAnalysisResult.setMaxTokenCount(Convert.toStr(tokenCountList.get(tokenCountList.size() - 1)));
        List<Date> sessionCreateTimeList = CollectionUtil.newArrayList();
        sessionCreateTimeList.addAll(sessionListB.stream().map(jsonObject -> jsonObject.getDate("createTime")).collect(Collectors.toList()));
        sessionCreateTimeList.addAll(sessionListC.stream().map(jsonObject -> jsonObject.getDate("createTime")).collect(Collectors.toList()));
        DateTime oneHourAgo = DateUtil.offset(DateTime.now(), DateField.HOUR, -1);
        authSessionAnalysisResult.setOneHourNewlyAdded(Convert.toStr(sessionCreateTimeList.stream().filter(date -> DateUtil.compare(oneHourAgo, date) <= 0).count()));
        authSessionAnalysisResult.setProportionOfBAndC(sessionListB.size() + StrUtil.SLASH + sessionListC.size());
        return authSessionAnalysisResult;
    }

    @Override
    public Page<AuthSessionPageResult> pageForB(AuthSessionPageParam authSessionPageParam) {
        Page<AuthSessionPageResult> defaultPage = CommonPageRequest.defaultPage();
        long current = defaultPage.getPageNumber();
        int total = StpUtil.searchSessionId("", -1, Convert.toInt(defaultPage.getPageSize()), false).size();
        if (ObjectUtil.isNotEmpty(total)) {
            defaultPage = new Page<>(current, defaultPage.getPageSize(), total);
            String keyword = "";
            if (ObjectUtil.isNotEmpty(authSessionPageParam.getUserId())) {
                keyword = authSessionPageParam.getUserId();
            }
            List<String> userIdList = StpUtil.searchSessionId(keyword,
                    Convert.toInt((current - 1) * defaultPage.getPageSize()),
                    Convert.toInt(defaultPage.getPageSize()), false).stream().map(sessionId ->
                    StrUtil.split(sessionId, StrUtil.COLON).get(3)).collect(Collectors.toList());
            if (ObjectUtil.isNotEmpty(userIdList)) {
                List<AuthSessionPageResult> authSessionPageResultList = loginUserApi.listUserByUserIdList(userIdList).stream().map(userJsonObject -> {
                    SaSession saSession = StpUtil.getSessionByLoginId(userJsonObject.getStr("id"), false);
                    AuthSessionPageResult authSessionPageResult = JSONUtil.toBean(userJsonObject, AuthSessionPageResult.class);
                    authSessionPageResult.setSessionId(saSession.getId());
                    authSessionPageResult.setSessionCreateTime(DateTime.of(saSession.getCreateTime()));
                    long sessionTimeOut = saSession.timeout();
                    if (sessionTimeOut == -1) {
                        authSessionPageResult.setSessionTimeout("永久");
                    } else {
                        authSessionPageResult.setSessionTimeout(CommonTimeFormatUtil.formatSeconds(saSession.timeout()));
                    }
                    List<AuthSessionPageResult.TokenSignInfo> tokenInfoList = saSession.getTerminalList().stream()
                            .filter(tokenSign -> {
                                long tokenTimeout = SaManager.getSaTokenDao().getTimeout(StpUtil.stpLogic.splicingKeyTokenValue(tokenSign.getTokenValue()));
                                return tokenTimeout != -2;  // 过滤掉tokenTimeout为-2的元素
                            })
                            .map(tokenSign -> {
                                AuthSessionPageResult.TokenSignInfo tokenSignInfo = new AuthSessionPageResult.TokenSignInfo();
                                tokenSignInfo.setTokenValue(tokenSign.getTokenValue());
                                tokenSignInfo.setTokenDevice(tokenSign.getDeviceId());
                                long tokenTimeout = SaManager.getSaTokenDao().getTimeout(StpUtil.stpLogic.splicingKeyTokenValue(tokenSign.getTokenValue()));
                                long tokenTimeoutConfig = getTokenTimeoutConfig();
                                if (tokenTimeout == -1) {
                                    tokenSignInfo.setTokenTimeout("永久");
                                    tokenSignInfo.setTokenTimeoutPercent(100d);
                                } else {
                                    tokenSignInfo.setTokenTimeout(CommonTimeFormatUtil.formatSeconds(SaManager.getSaTokenDao()
                                            .getTimeout(StpUtil.stpLogic.splicingKeyTokenValue(tokenSign.getTokenValue()))));
                                    if (tokenTimeoutConfig == -1) {
                                        tokenSignInfo.setTokenTimeoutPercent(0d);
                                    } else {
                                        tokenSignInfo.setTokenTimeoutPercent(NumberUtil.div(tokenTimeout, tokenTimeoutConfig));
                                    }
                                }
                                return tokenSignInfo;
                            })
                            .collect(Collectors.toList());
                    authSessionPageResult.setTokenCount(tokenInfoList.size());
                    authSessionPageResult.setTokenSignList(tokenInfoList);
                    return authSessionPageResult;
                }).collect(Collectors.toList());
                defaultPage.setRecords(authSessionPageResultList);
            }
        }
        return defaultPage;
    }

    @Override
    public Page<AuthSessionPageResult> pageForC(AuthSessionPageParam authSessionPageParam) {
        Page<AuthSessionPageResult> defaultPage = CommonPageRequest.defaultPage();
        long current = defaultPage.getPageNumber();
        int total = StpClientUtil.searchSessionId("", -1, Convert.toInt(defaultPage.getPageSize())).size();
        if (ObjectUtil.isNotEmpty(total)) {
            defaultPage = new Page<>(current, defaultPage.getPageSize(), total);
            String keyword = "";
            if (ObjectUtil.isNotEmpty(authSessionPageParam.getUserId())) {
                keyword = authSessionPageParam.getUserId();
            }
            List<String> userIdList = StpClientUtil.searchSessionId(keyword,
                    Convert.toInt((current - 1) * defaultPage.getPageSize()),
                    Convert.toInt(defaultPage.getPageSize())).stream().map(sessionId ->
                    StrUtil.split(sessionId, StrUtil.COLON).get(3)).collect(Collectors.toList());
            if (ObjectUtil.isNotEmpty(userIdList)) {
                List<AuthSessionPageResult> authSessionPageResultList = loginUserApi.listUserByUserIdList(userIdList).stream().map(userJsonObject -> {
                    SaSession saSession = StpClientUtil.getSessionByLoginId(userJsonObject.getStr("id"), false);
                    AuthSessionPageResult authSessionPageResult = JSONUtil.toBean(userJsonObject, AuthSessionPageResult.class);
                    authSessionPageResult.setSessionId(saSession.getId());
                    authSessionPageResult.setSessionCreateTime(DateTime.of(saSession.getCreateTime()));
                    long sessionTimeOut = saSession.timeout();
                    if (sessionTimeOut == -1) {
                        authSessionPageResult.setSessionTimeout("永久");
                    } else {
                        authSessionPageResult.setSessionTimeout(CommonTimeFormatUtil.formatSeconds(saSession.timeout()));
                    }
                    List<AuthSessionPageResult.TokenSignInfo> tokenInfoList = saSession.getTerminalList().stream().filter(tokenSign -> {
                        long tokenTimeout = SaManager.getSaTokenDao().getTimeout(StpClientUtil.stpLogic.splicingKeyTokenValue(tokenSign.getTokenValue()));
                        return tokenTimeout != -2;  // 过滤掉tokenTimeout为-2的元素
                    }).map(tokenSign -> {
                        AuthSessionPageResult.TokenSignInfo tokenSignInfo = new AuthSessionPageResult.TokenSignInfo();
                        tokenSignInfo.setTokenValue(tokenSign.getTokenValue());
                        tokenSignInfo.setTokenDevice(tokenSign.getDeviceId());
                        long tokenTimeout = SaManager.getSaTokenDao().getTimeout(StpClientUtil.stpLogic.splicingKeyTokenValue(tokenSign.getTokenValue()));
                        long tokenTimeoutConfig = getTokenTimeoutConfig();
                        if (tokenTimeout == -1) {
                            tokenSignInfo.setTokenTimeout("永久");
                            tokenSignInfo.setTokenTimeoutPercent(100d);
                        } else {
                            tokenSignInfo.setTokenTimeout(CommonTimeFormatUtil.formatSeconds(SaManager.getSaTokenDao()
                                    .getTimeout(StpClientUtil.stpLogic.splicingKeyTokenValue(tokenSign.getTokenValue()))));
                            if (tokenTimeoutConfig == -1) {
                                tokenSignInfo.setTokenTimeoutPercent(0d);
                            } else {
                                tokenSignInfo.setTokenTimeoutPercent(NumberUtil.div(tokenTimeout, tokenTimeoutConfig));
                            }
                        }
                        return tokenSignInfo;
                    }).collect(Collectors.toList());
                    authSessionPageResult.setTokenCount(tokenInfoList.size());
                    authSessionPageResult.setTokenSignList(tokenInfoList);
                    return authSessionPageResult;
                }).collect(Collectors.toList());
                defaultPage.setRecords(authSessionPageResultList);
            }
        }
        return defaultPage;
    }

    /**
     * 获取saToken 配置文件超时时间
     */
    private long getTokenTimeoutConfig() {
        if(Objects.isNull(StpUtil.stpLogic.getConfig())){
            return StpUtil.stpLogic.getConfigOrGlobal().getTimeout();
        }else{
            return StpUtil.stpLogic.getConfig().getTimeout();
        }
    }

    @Override
    public void exitSessionForB(List<AuthExitSessionParam> authExitSessionParamList) {
        authExitSessionParamList.forEach(authExitSessionParam -> StpUtil.logout(authExitSessionParam.getUserId()));
    }

    @Override
    public void exitSessionForC(List<AuthExitSessionParam> authExitSessionParamList) {
        authExitSessionParamList.forEach(authExitSessionParam -> StpClientUtil.logout(authExitSessionParam.getUserId()));
    }

    @Override
    public void exitTokenForB(List<AuthExitTokenParam> authExitTokenParamList) {
        authExitTokenParamList.forEach(authExitTokenParam -> StpUtil.logoutByTokenValue(authExitTokenParam.getTokenValue()));
    }

    @Override
    public void exitTokenForC(List<AuthExitTokenParam> authExitTokenParamList) {
        authExitTokenParamList.forEach(authExitTokenParam -> StpClientUtil.logoutByTokenValue(authExitTokenParam.getTokenValue()));
    }
}

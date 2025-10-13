package com.fliad.viid.modular.cascadeplatform.service.impl;

import cn.hutool.core.util.StrUtil;
import com.fliad.viid.modular.cascadeplatform.domain.*;
import com.fliad.viid.modular.cascadeplatform.entity.ViidCascadePlatform;
import com.fliad.viid.modular.cascadeplatform.service.ViidCascadePlatformService;
import com.fliad.viid.modular.cascadeplatform.service.ViidSystemService;
import com.fliad.viid.modular.cascadeplatform.utils.RegisterAuthUtil;
import com.fliad.viid.modular.cascadeplatform.enums.RegisterStatusEnum;
import com.fliad.viid.modular.cascadeplatform.enums.OnlineStatusEnum;
import com.fliad.viid.modular.cascadeplatform.enums.PlatformTypeEnum;
import com.fliad.viid.modular.ape.entity.ViidApe;
import com.fliad.viid.modular.ape.service.ViidApeService;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.bean.LifecycleBean;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.handle.Context;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class ViidSystemServiceImpl implements ViidSystemService, LifecycleBean {

    @Inject
    ViidCascadePlatformService cascadePlatformService;

    @Inject
    ViidApeService viidApeService;

    @Inject
    ViidPlatformStatusServiceImpl platformStatusService;
    
    // 根据设备ID获取采集设备信息
    private ViidApe getApeByDeviceId(String deviceId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("ApeID", deviceId);
        return viidApeService.getOne(queryWrapper);
    }

    @Override
    public ResponseStatusObject register(RegisterRequest registerRequest) {
        log.info("收到注册请求：{}", registerRequest);
        String deviceID = registerRequest.getRegisterObject().getDeviceID();

        // 先检查是否为采集设备
        ViidApe viidApe = getApeByDeviceId(deviceID);
        
        // 再检查是否为视图库级联平台
        ViidCascadePlatform cascadePlatform = null;
        if (viidApe == null) {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq(ViidCascadePlatform::getSystemId, deviceID);
            queryWrapper.eq(ViidCascadePlatform::getType, PlatformTypeEnum.SUBORDINATE.getCode());
            cascadePlatform = cascadePlatformService.getOne(queryWrapper);
        }

        // 如果既不是视图库级联平台也不是采集设备，则返回错误
        if (cascadePlatform == null && viidApe == null) {
            return buildErrorResponse(deviceID, "/VIID/System/Register",
                    0, String.format("注册失败，无此设备ID：%s", deviceID), 404);
        }

        String authorization = Context.current().header("Authorization");
        // 请求头无此字段，表示第一次注册，返回401
        if (authorization == null || "".equals(authorization)) {
            log.info("我是第一次发送注册请求");
            Context.current().headerSet("WWW-Authenticate", RegisterAuthUtil.getAuthHeader());
            Context.current().status(401);
            return null;
        }
        // 获取请求头认证信息
        // 存放解析后的字典映射
        Map<String, String> stringStringHashMap = parseDigestParams(authorization);
        //=======================开始认证加密======================
        log.info("注册信息为====》{}", stringStringHashMap);

        // 统一处理认证逻辑
        // 1. 如果是视图库级联平台且密码为空，则跳过认证校验
        // 2. 如果是采集设备且密码为空，则跳过认证校验
        if ((cascadePlatform != null && StrUtil.isEmpty(cascadePlatform.getPassword())) ||
                (viidApe != null && StrUtil.isEmpty(viidApe.getPassword()))) {
            log.info("设备密码为空，跳过认证校验");
            // 设备注册
            platformStatusService.addRegisteredDevice(deviceID);
            return buildSuccessResponse(deviceID, "/VIID/System/Register");
        }

        // 如果设备设置了密码，则进行认证
        if (RegisterAuthUtil.hasAuth(
                cascadePlatform != null ? cascadePlatform.getPassword() : viidApe.getPassword(),
                stringStringHashMap)) {
            log.info("设备验证通过");
            // 设备注册
            platformStatusService.addRegisteredDevice(deviceID);
            return buildSuccessResponse(deviceID, "/VIID/System/Register");
        } else {
            log.info("设备验证未通过");
            Context.current().status(400);
            return null;
        }

    }

    @Override
    public ResponseStatusObject keepalive(KeepaliveRequest keepaliveRequest) {
        log.debug("收到心跳请求：{}", keepaliveRequest.getKeepaliveObject().getDeviceID());
        String deviceID = keepaliveRequest.getKeepaliveObject().getDeviceID();

        if (platformStatusService.isDeviceRegistered(deviceID)) {
            // 更新设备最后活跃时间
            platformStatusService.updateDeviceLastActiveTime(deviceID);
            return buildSuccessResponse(deviceID, "/VIID/System/Keepalive");
        } else {
            Context.current().headerSet("WWW-Authenticate", RegisterAuthUtil.getAuthHeader());
            Context.current().status(401);
            return null;
        }
    }

    @Override
    public ResponseStatusObject unregister(UnRegisterRequest unRegisterRequest) {
        log.info("收到注销请求：{}", unRegisterRequest);
        String deviceID = unRegisterRequest.getUnRegisterObject().getDeviceID();

        // 检查设备是否已注册
        if (!platformStatusService.isDeviceRegistered(deviceID)) {
            return buildErrorResponse(deviceID, "/VIID/System/UnRegister",
                    0, String.format("注销失败，设备未注册：%s", deviceID), 404);
        }

        // 从已注册设备列表中移除
        platformStatusService.removeDevice(deviceID);

        // 返回成功响应
        return buildSuccessResponse(deviceID, "/VIID/System/UnRegister");
    }

    /**
     * 构建成功响应
     */
    private ResponseStatusObject buildSuccessResponse(String deviceId, String requestUrl) {
        Context.current().status(200);
        return new ResponseStatusObject(deviceId, requestUrl, 0, "OK");
    }

    /**
     * 构建错误响应
     */
    private ResponseStatusObject buildErrorResponse(String deviceId, String requestUrl,
                                                    int statusCode, String statusString, int httpStatus) {
        Context.current().status(httpStatus);
        ResponseStatusObject response = new ResponseStatusObject(deviceId, requestUrl, statusCode, statusString);
        log.warn(statusString);
        return response;
    }

    public static Map<String, String> parseDigestParams(String authHeader) {
        Map<String, String> params = new HashMap<>();
        Pattern pattern = Pattern.compile("([a-zA-Z0-9]+)=(\"[^\"]+\"|[^,]+)");
        Matcher matcher = pattern.matcher(authHeader);
        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);
            if (value.startsWith("\"") && value.endsWith("\"")) {
                value = value.substring(1, value.length() - 1);
            }
            params.put(key, value);
        }
        return params;
    }

}
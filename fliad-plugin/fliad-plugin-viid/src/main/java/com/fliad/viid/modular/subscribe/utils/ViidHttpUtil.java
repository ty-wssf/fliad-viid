package com.fliad.viid.modular.subscribe.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.fliad.dev.api.DevConfigApi;
import com.fliad.viid.modular.cascadeplatform.domain.SubscribeNotificationRequest;
import com.fliad.viid.modular.cascadeplatform.entity.ViidCascadePlatform;
import com.fliad.viid.modular.cascadeplatform.utils.RegisterAuthUtil;
import com.fliad.viid.modular.subscribe.entity.ViidSubscribe;
import lombok.extern.slf4j.Slf4j;
import org.noear.snack.ONode;
import org.noear.solon.Solon;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class ViidHttpUtil {

    // 用于存储每个平台的nc计数器
    private static final Map<String, AtomicInteger> ncCountMap = new ConcurrentHashMap<>();

    // 用于存储每个平台的心跳任务ID
    private static final Map<String, String> heartbeatTaskMap = new ConcurrentHashMap<>();

    /**
     * 向下级发送订阅请求
     */
    public static String subscribeSend(ViidSubscribe subscribe, ViidCascadePlatform viidCascadePlatform) {
        subscribe.setOperateType("0");
        ONode subscribeObj = ONode.load(subscribe);
        subscribeObj.remove("SubscribeType");
        subscribeObj.remove("ApprovalStatus");
        subscribeObj.remove("ApprovalUser");
        subscribeObj.remove("ApprovalTime");
        subscribeObj.remove("SubscribeStatus");
        subscribeObj.remove("SubscriberRecoverOrgid");
        AtomicReference<String> subscribeDetailStr = new AtomicReference<>();
        ONode.load(subscribe.getSubscribeDetail()).forEach((node) -> {
            if (StrUtil.isEmptyIfStr(subscribeDetailStr.get())) {
                subscribeDetailStr.set(node.getString());
            } else {
                subscribeDetailStr.set(subscribeDetailStr + "," + node.getString());
            }
        });
        subscribeObj.set("SubscribeDetail", subscribeDetailStr.get());
        subscribeObj.set("BeginTime", DateUtil.format(DateUtil.parse(subscribe.getBeginTime()), "yyyyMMddHHmmss"));
        subscribeObj.set("EndTime", DateUtil.format(DateUtil.parse(subscribe.getEndTime()), "yyyyMMddHHmmss"));

        ONode SubscribeListObject = ONode.newObject().set("SubscribeListObject", ONode.newObject().set("SubscribeObject", ONode.newArray().add(subscribeObj)));

        log.info("向下级 {} 发送订阅请求：{}", viidCascadePlatform.getName(), SubscribeListObject);
        String res = HttpRequest.post("http://" + viidCascadePlatform.getIpAddr() + ":" + viidCascadePlatform.getPort() + "/VIID/Subscribes")
                .header("User-Identify", Solon.context().getBean(DevConfigApi.class).getValueByKey("viid_local_id"))
                .body(SubscribeListObject.toJson())
                .contentType("application/VIID+JSON")
                .timeout(3000)
                .execute().body();
        // String res = "";
        log.info("订阅请求结果：{}", res);
        return res;
    }

    /**
     * 向上级发送注册请求
     *
     * @param viidCascadePlatform 上级平台信息
     * @return 注册是否成功
     */
    public static boolean registerSend(ViidCascadePlatform viidCascadePlatform) {
        try {
            // 构造注册请求体
            Map<String, Object> registerRequest = new HashMap<>();
            registerRequest.put("DeviceID", viidCascadePlatform.getUserId());

            String registerUrl = "http://" + viidCascadePlatform.getIpAddr() + ":" + viidCascadePlatform.getPort() + "/VIID/System/Register";

            // 第一次发送注册请求，获取 WWW-Authenticate 信息
            HttpResponse firstResponse = HttpRequest.post(registerUrl)
                    .body(ONode.load(registerRequest).toJson())
                    .contentType("application/VIID+JSON")
                    .timeout(3000)
                    .execute();

            if (firstResponse != null && firstResponse.getStatus() == 401) { // 401 Unauthorized
                String wwwAuthenticateHeader = firstResponse.header("WWW-Authenticate");
                if (wwwAuthenticateHeader != null) {
                    // 初始化或获取 nc 计数器
                    AtomicInteger ncCounter = ncCountMap.computeIfAbsent(viidCascadePlatform.getUserId(), k -> new AtomicInteger(1));
                    int nc = ncCounter.get();

                    // 根据 WWW-Authenticate 信息生成 Authorization header
                    String authorization = RegisterAuthUtil.getAuthorization(
                            wwwAuthenticateHeader,
                            "/VIID/System/Register",
                            viidCascadePlatform.getUserId(),
                            viidCascadePlatform.getPassword(),
                            "POST",
                            nc
                    );

                    // 第二次发送注册请求，带上 Authorization header
                    HttpResponse secondResponse = HttpRequest.post(registerUrl)
                            .header("Authorization", authorization)
                            .body(ONode.load(registerRequest).toJson())
                            .contentType("application/VIID+JSON")
                            .timeout(3000)
                            .execute();

                    if (secondResponse != null && secondResponse.isOk()) {
                        log.info("[平台注册] 向上级平台 {} 注册成功", viidCascadePlatform.getUserId());
                        // 注册成功，重置 nc 计数器
                        ncCounter.set(1);
                        // 启动心跳任务
                        startHeartbeatTask(viidCascadePlatform);
                        return true;
                    } else {
                        log.error("[平台注册] 向上级平台 {} 注册失败, 响应状态码: {}, 响应体: {}",
                                viidCascadePlatform.getUserId(),
                                secondResponse != null ? secondResponse.getStatus() : "N/A",
                                secondResponse != null ? secondResponse.body() : "N/A");
                    }
                    // 增加 nc 计数器
                    ncCounter.incrementAndGet();
                } else {
                    log.error("[平台注册] 向上级平台 {} 注册失败, 未获取到 WWW-Authenticate header", viidCascadePlatform.getUserId());
                }
            } else {
                log.error("[平台注册] 向上级平台 {} 注册失败, 初始响应状态码: {}, 响应体: {}",
                        viidCascadePlatform.getUserId(),
                        firstResponse != null ? firstResponse.getStatus() : "N/A",
                        firstResponse != null ? firstResponse.body() : "N/A");
            }
        } catch (Exception e) {
            log.error("[平台注册] 向上级平台 {} 注册时发生异常", viidCascadePlatform.getUserId(), e);
        }
        return false;
    }

    /**
     * 启动心跳任务
     *
     * @param viidCascadePlatform 上级平台信息
     */
    private static void startHeartbeatTask(ViidCascadePlatform viidCascadePlatform) {
        // 先停止已存在的心跳任务
        stopHeartbeatTask(viidCascadePlatform.getUserId());

        // 启动新的心跳任务，每30秒执行一次
        String taskId = CronUtil.schedule("*/30 * * * * ?", (Task) () -> {
            if (!keepaliveSend(viidCascadePlatform)) {
                log.warn("[平台心跳] 向上级平台 {} 发送心跳失败", viidCascadePlatform.getUserId());
                // 如果心跳失败，可以考虑重新注册
                // registerSend(viidCascadePlatform);
            } else {
                log.debug("[平台心跳] 向上级平台 {} 发送心跳成功", viidCascadePlatform.getUserId());
            }
        });

        // 保存任务ID，方便后续停止任务
        heartbeatTaskMap.put(viidCascadePlatform.getUserId(), taskId);
        log.info("[平台心跳] 已启动向上级平台 {} 的心跳任务，任务ID: {}", viidCascadePlatform.getUserId(), taskId);
    }

    /**
     * 停止心跳任务
     *
     * @param platformId 平台ID
     */
    private static void stopHeartbeatTask(String platformId) {
        String taskId = heartbeatTaskMap.get(platformId);
        if (taskId != null) {
            CronUtil.remove(taskId);
            heartbeatTaskMap.remove(platformId);
            log.info("[平台心跳] 已停止平台 {} 的心跳任务", platformId);
        }
    }

    /**
     * 向上级平台发送保活请求
     *
     * @param viidCascadePlatform 上级平台信息
     * @return 保活是否成功
     */
    public static boolean keepaliveSend(ViidCascadePlatform viidCascadePlatform) {
        try {
            Map<String, Object> keepaliveRequest = new HashMap<>();
            keepaliveRequest.put("DeviceID", viidCascadePlatform.getUserId());

            String keepaliveUrl = "http://" + viidCascadePlatform.getIpAddr() + ":" + viidCascadePlatform.getPort() + "/VIID/System/Keepalive";

            HttpResponse response = HttpRequest.post(keepaliveUrl)
                    .header("User-Identify", viidCascadePlatform.getUserId())
                    .body(ONode.load(keepaliveRequest).toJson())
                    .contentType("application/VIID+JSON")
                    .timeout(3000)
                    .execute();

            boolean isOk = response != null && response.isOk();
            if (!isOk) {
                log.warn("[平台保活] 向上级平台 {} 发送保活失败, 响应状态码: {}, 响应体: {}",
                        viidCascadePlatform.getUserId(),
                        response != null ? response.getStatus() : "N/A",
                        response != null ? response.body() : "N/A");
            } else {
                log.debug("[平台保活] 向上级平台 {} 发送保活成功", viidCascadePlatform.getUserId());
            }
            return isOk;
        } catch (Exception e) {
            log.error("[平台保活] 向上级平台 {} 发送保活时发生异常", viidCascadePlatform.getUserId(), e);
            return false;
        }
    }

    /**
     * 向上级平台发送注销请求
     *
     * @param viidCascadePlatform 上级平台信息
     * @return 注销是否成功
     */
    public static boolean unregisterSend(ViidCascadePlatform viidCascadePlatform) {
        try {
            // 构造注销请求体
            Map<String, Object> unregisterRequest = new HashMap<>();
            Map<String, Object> unregisterObject = new HashMap<>();
            unregisterObject.put("DeviceID", viidCascadePlatform.getUserId());
            unregisterRequest.put("UnRegisterObject", unregisterObject);

            String unregisterUrl = "http://" + viidCascadePlatform.getIpAddr() + ":" + viidCascadePlatform.getPort() + "/VIID/System/UnRegister";

            HttpResponse response = HttpRequest.post(unregisterUrl)
                    .header("User-Identify", viidCascadePlatform.getUserId())
                    .body(ONode.load(unregisterRequest).toJson())
                    .contentType("application/VIID+JSON")
                    .timeout(3000)
                    .execute();

            boolean isOk = response != null && response.isOk();
            if (!isOk) {
                log.warn("[平台注销] 向上级平台 {} 发送注销失败, 响应状态码: {}, 响应体: {}",
                        viidCascadePlatform.getUserId(),
                        response != null ? response.getStatus() : "N/A",
                        response != null ? response.body() : "N/A");

                // 如果有正在进行的心跳任务，则停止它
                stopHeartbeatTask(viidCascadePlatform.getUserId());
            } else {
                log.info("[平台注销] 向上级平台 {} 发送注销成功", viidCascadePlatform.getUserId());

                // 停止心跳任务
                stopHeartbeatTask(viidCascadePlatform.getUserId());
            }
            return isOk;
        } catch (Exception e) {
            log.error("[平台注销] 向上级平台 {} 发送注销时发生异常", viidCascadePlatform.getUserId(), e);

            // 出现异常也尝试停止心跳任务
            stopHeartbeatTask(viidCascadePlatform.getUserId());
            return false;
        }
    }

    /**
     * 向上级发送通知
     */
    public String subscribeNotificationsSend(ViidSubscribe subscribe, SubscribeNotificationRequest subscribeNotificationRequest) throws Exception {
        JSONConfig jsonConfig = new JSONConfig();
        jsonConfig.setIgnoreCase(false);
        return HttpRequest.post(subscribe.getReceiveAddr())
                .header("User-Identify", subscribe.getSubscriberRecoverOrgid())
                .body(JSONUtil.toJsonStr(subscribeNotificationRequest, jsonConfig))
                .contentType("application/VIID+JSON")
                .timeout(3000)
                .execute()
                .body();
    }

}
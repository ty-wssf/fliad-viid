package com.fliad.viid.modular.cascadeplatform.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import com.fliad.viid.modular.cascadeplatform.domain.*;
import com.fliad.viid.modular.cascadeplatform.service.ViidPlatformStatusService;
import com.fliad.viid.modular.flowgram.domain.TaskRunInput;
import com.fliad.viid.modular.flowgram.service.FlowgramService;
import com.fliad.viid.modular.notification.param.ViidSubscribeNotificationsAddParam;
import com.fliad.viid.modular.notification.service.ViidSubscribeNotificationsService;
import com.fliad.viid.modular.workflow.entity.ViidWorkflow;
import com.fliad.viid.modular.workflow.service.ViidWorkflowService;
import com.fliad.dev.api.DevDictApi;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.noear.snack.ONode;
import org.noear.solon.annotation.*;
import org.noear.solon.core.handle.Context;
import org.noear.solon.validation.annotation.Valid;

import java.util.List;

/**
 * 视图库数据相关接口控制器
 * 处理VIID协议相关的数据交互，包括车流量数据和订阅通知等
 */
@Slf4j
@Api(tags = "视图库数据相关接口")
@Controller
@Valid
@Mapping("/VIID")
public class ViidDataController {

    @Inject
    private ViidPlatformStatusService viidPlatformStatusService;

    @Inject
    private ViidWorkflowService viidWorkflowService;

    @Inject
    private FlowgramService flowgramService;

    @Inject
    private ViidSubscribeNotificationsService viidSubscribeNotificationsService;

    @Inject
    private DevDictApi devDictApi;

    /**
     * 华为流量定制
     * 处理车流量数据接口
     * 接收并处理车流量相关数据，返回处理结果状态
     *
     * @param userIdentify  用户标识
     * @param vehiclesFlows 车流量数据JSON字符串
     * @return 响应状态列表对象
     */
    @Mapping("/VehiclesFlows")
    public ResponseStatusListObject vehiclesFlows(
            @Header("User-Identify") String userIdentify,
            @Body String vehiclesFlows) {

        ResponseStatusListObject responseStatusListObject = new ResponseStatusListObject();

        // 验证设备是否已注册
        if (!viidPlatformStatusService.isDeviceRegistered(userIdentify)) {
            Context.current().status(401);
            return responseStatusListObject;
        }

        try {
            // 解析请求数据
            ONode vehiclesFlowsRequest =
                    ONode.deserialize(vehiclesFlows, ONode.class);
            List<ONode> dataList =
                    vehiclesFlowsRequest.get("VehiclesFlowListObject").get("VehiclesFlowObject").ary();

            // 处理每条数据
            for (ONode data : dataList) {
                try {
                    // 处理数据
                    processVehicleFlowData(data);
                    // 添加成功状态
                    responseStatusListObject.addResponseStatus(new ResponseStatus(
                            data.get("VehiclesFlowID").getString(),
                            "/VIID/VehiclesFlows",
                            0,
                            "OK"
                    ));
                } catch (Exception e) {
                    log.error("处理单车流量数据时发生错误", e);
                    // 添加错误状态
                    String errorMessage = e.getMessage();
                    if (e.getCause() != null) {
                        errorMessage += "; Cause: " + e.getCause().getMessage();
                    }
                    responseStatusListObject.addResponseStatus(new ResponseStatus(
                            data.get("VehiclesFlowID").getString(),
                            "/VIID/VehiclesFlows",
                            -1,
                            "处理失败: " + errorMessage
                    ));
                }
            }
        } catch (Exception e) {
            log.error("处理车流量数据时发生错误", e);
            // 添加全局错误状态
            String errorMessage = e.getMessage();
            if (e.getCause() != null) {
                errorMessage += "; Cause: " + e.getCause().getMessage();
            }
            responseStatusListObject.addResponseStatus(new ResponseStatus(
                    "",
                    "/VIID/VehiclesFlows",
                    -1,
                    "处理失败: " + errorMessage
            ));
        }

        return responseStatusListObject;
    }

    /**
     * 处理订阅通知接口
     * 接收并处理订阅通知相关数据，返回处理结果状态
     *
     * @param userIdentify  用户标识
     * @param notifications 通知数据JSON字符串
     * @return 响应状态列表对象
     */
    @Mapping("/SubscribeNotifications")
    public ResponseStatusListObject subscribeNotifications(
            @Header("User-Identify") String userIdentify,
            @Body String notifications) {

        ResponseStatusListObject responseStatusListObject = new ResponseStatusListObject();
        long startTime = System.currentTimeMillis();

        // 验证设备是否已注册
        if (!viidPlatformStatusService.isDeviceRegistered(userIdentify)) {
            Context.current().status(401);
            return responseStatusListObject;
        }

        try {
            // 解析请求数据
            SubscribeNotificationRequest notificationRequest =
                    ONode.deserialize(notifications, SubscribeNotificationRequest.class);
            List<ONode> dataList =
                    notificationRequest.getSubscribeNotificationListObject().getSubscribeNotificationObject();

            // 处理每条数据
            for (ONode data : dataList) {
                try {
                    log.info("接收到订阅通知请求：{} -> {} > {}",
                            userIdentify,
                            data.get("InfoIDs").getString(),
                            data.get("NotificationID").getString());

                    // 处理数据并保存通知日志和响应信息到同一条记录中
                    processSubscribeNotificationData(data, responseStatusListObject);
                } catch (Exception e) {
                    log.error("处理单条订阅通知数据时发生错误", e);
                    // 添加错误状态
                    String errorMessage = e.getMessage();
                    if (e.getCause() != null) {
                        errorMessage += "; Cause: " + e.getCause().getMessage();
                    }
                    responseStatusListObject.addResponseStatus(new ResponseStatus(
                            data.get("NotificationID").getString(),
                            "/VIID/SubscribeNotifications",
                            -1,
                            "处理失败: " + errorMessage
                    ));
                } finally {
                    long cost = System.currentTimeMillis() - startTime;
                    saveNotificationWithResponse(data, responseStatusListObject, cost);
                }
            }
        } catch (Exception e) {
            log.error("处理订阅通知数据时发生错误", e);
            // 添加全局错误状态
            String errorMessage = e.getMessage();
            if (e.getCause() != null) {
                errorMessage += "; Cause: " + e.getCause().getMessage();
            }
            responseStatusListObject.addResponseStatus(new ResponseStatus(
                    "",
                    "/VIID/SubscribeNotifications",
                    -1,
                    "处理失败: " + errorMessage
            ));
        }

        return responseStatusListObject;
    }

    /**
     * 处理车华为定制流量数据
     * 对接收的车流量数据进行后续处理，执行相关工作流
     *
     * @param vehiclesFlowNode 车流量数据对象
     */
    private void processVehicleFlowData(ONode vehiclesFlowNode) {
        List<ViidWorkflow> workflowList = viidWorkflowService.findBySubscribeDetail("101");

        for (ViidWorkflow workflow : workflowList) {
            TaskRunInput taskRunInput = new TaskRunInput();
            taskRunInput.setSchema(workflow.getContent());
            taskRunInput.setInputs(MapUtil.of("inputs", ONode.stringify(vehiclesFlowNode)));
            flowgramService.taskRun(false, taskRunInput, IdUtil.getSnowflakeNextIdStr());
        }
    }

    /**
     * 处理订阅通知数据
     * 对接收的订阅通知数据进行后续处理，包括：
     * 1. 保存通知日志到数据库
     * 2. 触发对应的工作流任务
     * 注意：此方法不应在设备未通过身份验证时被调用
     *
     * @param subscribeNotificationNode 订阅通知数据对象
     * @param responseStatusListObject  响应状态列表对象
     */
    private void processSubscribeNotificationData(ONode subscribeNotificationNode, ResponseStatusListObject responseStatusListObject) {
        // 从字典中获取字段映射关系
        // 字段映射格式: "字段名.子字段名" -> "订阅详情类型"
        // 例如: "DeviceStatusList.APEStatusObject" -> "4"

        // 查询所有业务字典
        List<ONode> dictList = devDictApi.getDictListByCategory("BIZ");

        // 在业务字典中查找"VIID_Subscribe_Notification_Field_Mapping"字典项
        ONode mappingDict = null;
        for (ONode dict : dictList) {
            if ("VIID_Subscribe_Notification_Field_Mapping".equals(dict.get("dictValue").getString())) {
                mappingDict = dict;
                break;
            }
        }

        if (mappingDict != null) {
            // 获取所有子字典项
            List<ONode> subDictList = devDictApi.getDictListByParentId(mappingDict.get("id").getString());

            // 遍历映射关系查找匹配的字段
            for (ONode subDict : subDictList) {
                String[] fieldParts = subDict.get("dictLabel").getString().split("\\.");
                if (fieldParts.length == 2) {
                    String parentField = fieldParts[0];
                    String childField = fieldParts[1];

                    // 检查节点是否存在且不为null
                    if (subscribeNotificationNode.get(parentField) != null &&
                            !subscribeNotificationNode.get(parentField).isNull()) {

                        ONode childNode = subscribeNotificationNode.get(parentField).get(childField);
                        if (childNode != null && !childNode.isNull()) {
                            processNotificationData(
                                    childNode.ary(),
                                    subDict.get("dictValue").getString() // 使用字典值作为订阅详情类型
                            );
                            // 处理完匹配的字段后跳出循环
                            break;
                        }
                    }
                }
            }
        }

        // 添加成功状态
        responseStatusListObject.addResponseStatus(new ResponseStatus(
                subscribeNotificationNode.get("NotificationID").getString(),
                "/VIID/SubscribeNotifications",
                0,
                "OK"
        ));
    }

    /**
     * 通用处理通知数据方法
     *
     * @param dataList        数据列表
     * @param subscribeDetail 订阅详情类型
     * @param <T>             数据类型
     */
    private <T> void processNotificationData(List<T> dataList, String subscribeDetail) {
        List<ViidWorkflow> workflowList = viidWorkflowService.findBySubscribeDetail(subscribeDetail);

        for (T data : dataList) {
            for (ViidWorkflow workflow : workflowList) {
                TaskRunInput taskRunInput = new TaskRunInput();
                taskRunInput.setSchema(workflow.getContent());
                taskRunInput.setInputs(MapUtil.of("inputs", ONode.stringify(data)));
                flowgramService.taskRun(false, taskRunInput, IdUtil.getSnowflakeNextIdStr());
            }
        }
    }

    /**
     * 保存通知和响应信息到同一条记录中
     *
     * @param requestData              请求数据
     * @param responseStatusListObject 响应状态列表
     * @param cost                     请求耗时
     */
    private void saveNotificationWithResponse(ONode requestData, ResponseStatusListObject responseStatusListObject, long cost) {
        try {
            // 创建一个新的通知记录用于保存响应信息
            ViidSubscribeNotificationsAddParam notificationParam = new ViidSubscribeNotificationsAddParam();
            notificationParam.setNotificationID(requestData.get("NotificationID").getString() == null ? IdUtil.getSnowflakeNextIdStr() : requestData.get("NotificationID").getString());
            notificationParam.setSubscribeID(requestData.get("SubscribeID").getString() == null ? IdUtil.getSnowflakeNextIdStr() : requestData.get("SubscribeID").getString());
            notificationParam.setTitle(requestData.get("Title").getString());
            notificationParam.setTriggerTime(requestData.get("TriggerTime").getString() != null ? DateUtil.parse(requestData.get("TriggerTime").getString(), "yyyyMMddHHmmss") : null);
            notificationParam.setInfoIDs(requestData.get("InfoIDs").getString());

            // 从字典中获取字段映射关系
            // 字段映射格式: "字段名" -> "InfoIDs值"
            List<ONode> dictList = devDictApi.getDictListByCategory("BIZ");

            // 在业务字典中查找"VIID_Subscribe_Notification_Save_Mapping"字典项
            ONode mappingDict = null;
            for (ONode dict : dictList) {
                if ("VIID_Subscribe_Notification_Field_Mapping".equals(dict.get("dictValue").getString())) {
                    mappingDict = dict;
                    break;
                }
            }

            String requestJson = null;

            if (mappingDict != null) {
                // 获取所有子字典项
                List<ONode> subDictList = devDictApi.getDictListByParentId(mappingDict.get("id").getString());

                // 遍历映射关系查找匹配的字段
                for (ONode subDict : subDictList) {
                    String[] fieldParts = subDict.get("dictLabel").getString().split("\\.");
                    if (fieldParts.length == 2) {
                        String parentField = fieldParts[0];
                        String childField = fieldParts[1];

                        // 检查节点是否存在且不为null
                        if (requestData.get(parentField) != null &&
                                !requestData.get(parentField).isNull()) {

                            ONode childNode = requestData.get(parentField).get(childField);
                            if (childNode != null && !childNode.isNull()) {
                                requestJson = ONode.stringify(childNode);
                            }
                        }
                    }
                }
            }

            notificationParam.setRequestData(requestJson);
            notificationParam.setResponseData(ONode.stringify(responseStatusListObject));
            notificationParam.setRequestCost((int) cost);
            viidSubscribeNotificationsService.add(notificationParam);
        } catch (Exception e) {
            log.error("保存通知响应信息时发生错误", e);
        }
    }
}
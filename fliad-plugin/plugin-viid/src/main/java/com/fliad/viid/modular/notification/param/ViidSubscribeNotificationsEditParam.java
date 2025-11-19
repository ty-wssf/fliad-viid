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
package com.fliad.viid.modular.notification.param;

import io.swagger.annotations.ApiModelProperty;

import org.noear.solon.validation.annotation.NotBlank;
import org.noear.solon.validation.annotation.NotNull;

import java.util.Date;

/**
 * 订阅通知编辑参数
 *
 * @author wyl
 * @date 2025/09/22
 **/
public class ViidSubscribeNotificationsEditParam {

    /** 主键 */
    @ApiModelProperty(value = "主键", position = 1)
    private String ID;

    /** 通知标识 */
    @ApiModelProperty(value = "通知标识", required = true, position = 2)
    @NotBlank(message = "notificationID不能为空")
    private String NotificationID;

    /** 订阅标识 */
    @ApiModelProperty(value = "订阅标识", required = true, position = 3)
    @NotBlank(message = "subscribeID不能为空")
    private String SubscribeID;

    /** 订阅标题 */
    @ApiModelProperty(value = "订阅标题", position = 4)
    private String Title;

    /** 触发时间 */
    @ApiModelProperty(value = "触发时间", position = 5)
    private Date TriggerTime;

    /** 信息标识 */
    @ApiModelProperty(value = "信息标识", position = 6)
    private String InfoIDs;

    /** 请求字段数据（根据InfoIDs存储DeviceStatusList或者VehiclesFlowListObject等真实字段的数据） */
    @ApiModelProperty(value = "请求字段数据（根据InfoIDs存储DeviceStatusList或者VehiclesFlowListObject等真实字段的数据）", position = 7)
    private String RequestData;

    /** 响应字段数据（存储处理当前数据接口处理结果） */
    @ApiModelProperty(value = "响应字段数据（存储处理当前数据接口处理结果）", position = 8)
    private String ResponseData;

    /** 请求耗时（毫秒） */
    @ApiModelProperty(value = "请求耗时（毫秒）", position = 9)
    private Integer RequestCost;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNotificationID() {
        return NotificationID;
    }

    public void setNotificationID(String NotificationID) {
        this.NotificationID = NotificationID;
    }

    public String getSubscribeID() {
        return SubscribeID;
    }

    public void setSubscribeID(String SubscribeID) {
        this.SubscribeID = SubscribeID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public Date getTriggerTime() {
        return TriggerTime;
    }

    public void setTriggerTime(Date TriggerTime) {
        this.TriggerTime = TriggerTime;
    }

    public String getInfoIDs() {
        return InfoIDs;
    }

    public void setInfoIDs(String InfoIDs) {
        this.InfoIDs = InfoIDs;
    }

    public String getRequestData() {
        return RequestData;
    }

    public void setRequestData(String RequestData) {
        this.RequestData = RequestData;
    }

    public String getResponseData() {
        return ResponseData;
    }

    public void setResponseData(String ResponseData) {
        this.ResponseData = ResponseData;
    }

    public Integer getRequestCost() {
        return RequestCost;
    }

    public void setRequestCost(Integer RequestCost) {
        this.RequestCost = RequestCost;
    }
}
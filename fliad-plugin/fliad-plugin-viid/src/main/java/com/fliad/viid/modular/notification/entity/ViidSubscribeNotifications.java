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
package com.fliad.viid.modular.notification.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.annotation.Column;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 订阅通知实体
 *
 * @author wyl
 * @date 2025/09/22
 **/
@Getter
@Setter
@Table(value = "viid_subscribe_notifications")
public class ViidSubscribeNotifications {

    /** 主键 */
    @JsonProperty("ID")
    @Id
    @ApiModelProperty(value = "主键", position = 1)
    @Column("ID")
    private String ID;

    /** 通知标识 */
    @JsonProperty("NotificationID")
    @ApiModelProperty(value = "通知标识", position = 2)
    @Column("NotificationID")
    private String NotificationID;

    /** 订阅标识 */
    @JsonProperty("SubscribeID")
    @ApiModelProperty(value = "订阅标识", position = 3)
    @Column("SubscribeID")
    private String SubscribeID;

    /** 订阅标题 */
    @JsonProperty("Title")
    @ApiModelProperty(value = "订阅标题", position = 4)
    @Column("Title")
    private String Title;

    /** 触发时间 */
    @JsonProperty("TriggerTime")
    @ApiModelProperty(value = "触发时间", position = 5)
    @Column("TriggerTime")
    private Date TriggerTime;

    /** 信息标识 */
    @JsonProperty("InfoIDs")
    @ApiModelProperty(value = "信息标识", position = 6)
    @Column("InfoIDs")
    private String InfoIDs;

    /** 请求字段数据（根据InfoIDs存储DeviceStatusList或者VehiclesFlowListObject等真实字段的数据） */
    @JsonProperty("RequestData")
    @ApiModelProperty(value = "请求字段数据（根据InfoIDs存储DeviceStatusList或者VehiclesFlowListObject等真实字段的数据）", position = 7)
    @Column("RequestData")
    private String RequestData;

    /** 响应字段数据（存储处理当前数据接口处理结果） */
    @JsonProperty("ResponseData")
    @ApiModelProperty(value = "响应字段数据（存储处理当前数据接口处理结果）", position = 8)
    @Column("ResponseData")
    private String ResponseData;

    /** 请求耗时（毫秒） */
    @JsonProperty("RequestCost")
    @ApiModelProperty(value = "请求耗时（毫秒）", position = 9)
    @Column("RequestCost")
    private Integer RequestCost;

    /** 创建时间 */
    @JsonProperty("CreateTime")
    @ApiModelProperty(value = "创建时间", position = 10)
    @Column("CreateTime")
    private Date CreateTime;

    /** 更新时间 */
    @JsonProperty("UpdateTime")
    @ApiModelProperty(value = "更新时间", position = 11)
    @Column("UpdateTime")
    private Date UpdateTime;
}
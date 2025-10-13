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
package com.fliad.viid.modular.subscribe.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fliad.common.annotation.CommonWrapperField;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订阅下发实体
 *
 * @author wyl
 * @date  2025/08/22 15:00
 **/
@Getter
@Setter
@Table(value = "viid_subscribe")
public class ViidSubscribe {

    /** 订阅标识符 */
    @JsonProperty("SubscribeID")
    @Id
    @ApiModelProperty(value = "订阅标识符", position = 1)
    @Column("SubscribeID")
    private String SubscribeID;

    /** 订阅标题 */
    @JsonProperty("Title")
    @ApiModelProperty(value = "订阅标题", position = 2)
    @Column("Title")
    private String Title;

    /** 订阅类别 */
    @JsonProperty("SubscribeDetail")
    @ApiModelProperty(value = "订阅类别", position = 3)
    @Column("SubscribeDetail")
    private String SubscribeDetail;

    /** 订阅资源路径 */
    @JsonProperty("ResourceURI")
    @ApiModelProperty(value = "订阅资源路径", position = 4)
    @Column("ResourceURI")
    private String ResourceURI;

    /** 申请人 */
    @JsonProperty("ApplicantName")
    @ApiModelProperty(value = "申请人", position = 5)
    @Column("ApplicantName")
    private String ApplicantName;

    /** 申请单位 */
    @JsonProperty("ApplicantOrg")
    @ApiModelProperty(value = "申请单位", position = 6)
    @Column("ApplicantOrg")
    private String ApplicantOrg;

    /** 开始时间 */
    @JsonProperty("BeginTime")
    @ApiModelProperty(value = "开始时间", position = 7)
    @Column("BeginTime")
    private String BeginTime;

    /** 结束时间 */
    @JsonProperty("EndTime")
    @ApiModelProperty(value = "结束时间", position = 8)
    @Column("EndTime")
    private String EndTime;

    /** 信息接收地址 */
    @JsonProperty("ReceiveAddr")
    @ApiModelProperty(value = "信息接收地址", position = 9)
    @Column("ReceiveAddr")
    private String ReceiveAddr;

    /** 信息上报间隔时间 */
    @JsonProperty("ReportInterval")
    @ApiModelProperty(value = "信息上报间隔时间", position = 10)
    @Column("ReportInterval")
    private Integer ReportInterval;

    /** 理由 */
    @JsonProperty("Reason")
    @ApiModelProperty(value = "理由", position = 11)
    @Column("Reason")
    private String Reason;

    /** 操作类型 */
    @JsonProperty("OperateType")
    @ApiModelProperty(value = "操作类型 0：订阅；1：取消订阅", position = 12)
    @Column("OperateType")
    private String OperateType;

    /** 订阅执行状态 */
    @JsonProperty("SubscribeStatus")
    @ApiModelProperty(value = "订阅执行状态", position = 13)
    @Column("SubscribeStatus")
    private String SubscribeStatus;

    /** 订阅取消单位 */
    @JsonProperty("SubscribeCancelOrg")
    @ApiModelProperty(value = "订阅取消单位", position = 14)
    @Column("SubscribeCancelOrg")
    private String SubscribeCancelOrg;

    /** 订阅取消人 */
    @JsonProperty("SubscribeCancelPerson")
    @ApiModelProperty(value = "订阅取消人", position = 15)
    @Column("SubscribeCancelPerson")
    private String SubscribeCancelPerson;

    /** 取消时间 */
    @JsonProperty("CancelTime")
    @ApiModelProperty(value = "取消时间", position = 16)
    @Column("CancelTime")
    private Date CancelTime;

    /** 取消原因 */
    @JsonProperty("CancelReason")
    @ApiModelProperty(value = "取消原因", position = 17)
    @Column("CancelReason")
    private String CancelReason;

    /** 0 订阅上级 1被订阅 */
    @JsonProperty("SubscribeType")
    @ApiModelProperty(value = "0 订阅上级 1被订阅", position = 18)
    @Column("SubscribeType")
    private String SubscribeType;

    /** 订阅发起方ID */
    @JsonProperty("SubscriberSendOrgid")
    @ApiModelProperty(value = "订阅发起方ID", position = 19)
    @Column("SubscriberSendOrgid")
    private String SubscriberSendOrgid;

    /** 被订阅方ID */
    @JsonProperty("SubscriberRecoverOrgid")
    @ApiModelProperty(value = "被订阅方ID", position = 20)
    @CommonWrapperField(ref = "SubscriberRecoverOrgname")
    @Column("SubscriberRecoverOrgid")
    private String SubscriberRecoverOrgid;

    @JsonProperty("SubscriberRecoverOrgname")
    @ApiModelProperty(value = "订阅目标节点", position = 51)
    @Column(ignore = true)
    private String SubscriberRecoverOrgname;

}

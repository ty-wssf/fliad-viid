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
package com.fliad.viid.modular.subscribe.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import org.noear.solon.validation.annotation.NotBlank;
import org.noear.solon.validation.annotation.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订阅下发添加参数
 *
 * @author wyl
 * @date  2025/08/22 15:00
 **/
@Getter
@Setter
public class ViidSubscribeAddParam {

    /** 订阅标题 */
    @ApiModelProperty(value = "订阅标题", required = true, position = 2)
    @NotBlank(message = "title不能为空")
    private String Title;

    /** 订阅类别 */
    @ApiModelProperty(value = "订阅类别", required = true, position = 3)
    @NotBlank(message = "subscribedetail不能为空")
    private String SubscribeDetail;

    /** 订阅资源路径 */
    @ApiModelProperty(value = "订阅资源路径", required = true, position = 4)
    @NotBlank(message = "resourceuri不能为空")
    private String ResourceURI;

    /** 申请人 */
    @ApiModelProperty(value = "申请人", required = true, position = 5)
    @NotBlank(message = "applicantname不能为空")
    private String ApplicantName;

    /** 申请单位 */
    @ApiModelProperty(value = "申请单位", required = true, position = 6)
    @NotBlank(message = "applicantorg不能为空")
    private String ApplicantOrg;

    /** 开始时间 */
    @ApiModelProperty(value = "开始时间", required = true, position = 7)
    @NotBlank(message = "begintime不能为空")
    private String BeginTime;

    /** 结束时间 */
    @ApiModelProperty(value = "结束时间", required = true, position = 8)
    @NotBlank(message = "endtime不能为空")
    private String EndTime;

    /** 信息接收地址 */
    @ApiModelProperty(value = "信息接收地址", required = true, position = 9)
    @NotBlank(message = "receiveaddr不能为空")
    private String ReceiveAddr;

    /** 信息上报间隔时间 */
    @ApiModelProperty(value = "信息上报间隔时间", required = true, position = 10)
    @NotNull(message = "reportinterval不能为空")
    private Integer ReportInterval;

    /** 理由 */
    @ApiModelProperty(value = "理由", position = 11)
    private String Reason;

    /** 被订阅方ID */
    @ApiModelProperty(value = "被订阅方ID", required = true, position = 20)
    @NotBlank(message = "subscriberrecoverorgid不能为空")
    private String SubscriberRecoverOrgid;

}

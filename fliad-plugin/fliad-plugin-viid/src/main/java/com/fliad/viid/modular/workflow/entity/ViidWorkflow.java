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
package com.fliad.viid.modular.workflow.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.noear.solon.validation.annotation.NotBlank;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 工作流实体
 *
 * @author wyl
 * @date  2025/08/27 14:03
 **/
@Getter
@Setter
@Table(value = "viid_workflow")
public class ViidWorkflow {

    /** ID */
    @Id
    @ApiModelProperty(value = "ID", position = 1)
    private String id;

    /** 标题 */
    @ApiModelProperty(value = "标题", position = 2)
    private String title;

    /** 状态 */
    @ApiModelProperty(value = "状态", position = 3)
    private String status;

    /** 订阅类别 */
    @ApiModelProperty(value = "订阅类别", required = true, position = 3)
    @NotBlank(message = "subscribedetail不能为空")
    private String subscribeDetail;

    /** 备注 */
    @ApiModelProperty(value = "备注", position = 4)
    private String remark;

    /** 工作流设计的 JSON 内容 */
    @ApiModelProperty(value = "工作流设计的 JSON 内容", position = 5)
    private String content;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间", position = 6)
    private Date createTime;

    /** 创建用户 */
    @ApiModelProperty(value = "创建用户", position = 7)
    private String createUser;

    /** 修改时间 */
    @ApiModelProperty(value = "修改时间", position = 8)
    private Date updateTime;

    /** 修改用户 */
    @ApiModelProperty(value = "修改用户", position = 9)
    private String updateUser;
}

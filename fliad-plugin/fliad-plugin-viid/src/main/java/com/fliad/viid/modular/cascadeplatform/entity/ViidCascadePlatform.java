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
package com.fliad.viid.modular.cascadeplatform.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 视图库实体
 *
 * @author wyl
 * @date  2025/08/14 16:24
 **/
@Getter
@Setter
@Table(value = "viid_cascade_platform")
public class ViidCascadePlatform {

    /** 主键 */
    @Id
    @ApiModelProperty(value = "主键", position = 1)
    private String id;

    /** 视图库ID */
    @ApiModelProperty(value = "视图库ID", position = 2)
    private String systemId;

    /** 视图库名称 */
    @ApiModelProperty(value = "视图库名称", position = 3)
    private String name;

    /** IP地址 */
    @ApiModelProperty(value = "IP地址", position = 4)
    private String ipAddr;

    /** 端口 */
    @ApiModelProperty(value = "端口", position = 5)
    private Integer port;

    /** 注册状态 */
    @ApiModelProperty(value = "是否注册", position = 6)
    private String isRegister;

    /** 是否在线 */
    @ApiModelProperty(value = "是否在线", position = 6)
    private String isOnline;

    /** 最后在线时间 */
    @ApiModelProperty(value = "最后在线时间", position = 7)
    private Date lastOnlineTime;

    /** 视图库类型 */
    @ApiModelProperty(value = "视图库类型 0：上级 1：下级", position = 8)
    private String type;

    /** 授权用户 */
    @ApiModelProperty(value = "授权用户", position = 9)
    private String userId;

    /** 授权密码 */
    @ApiModelProperty(value = "授权密码", position = 10)
    private String password;

    /** 心跳间隔 */
    @ApiModelProperty(value = "心跳间隔", position = 11)
    private Long heartbeatInterval;

    /** 保活超时次数 */
    @ApiModelProperty(value = "保活超时次数", position = 12)
    private Integer keepaliveTimeoutCount;

}

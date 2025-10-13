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
package com.fliad.viid.modular.hikvision.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.noear.solon.validation.annotation.NotBlank;

import java.util.Date;

/**
 * 海康设备实体
 *
 * @author yubaoshan
 * @date 2025/09/27
 **/
@Getter
@Setter
@Table(value = "viid_hikvision_camera")
public class ViidHikvisionCamera {

    /** ID */
    @Id
    @ApiModelProperty(value = "ID", position = 1)
    private String id;

    /** 设备名称 */
    @ApiModelProperty(value = "设备名称", required = true, position = 2)
    @NotBlank(message = "设备名称不能为空")
    private String name;

    /** 设备IP地址 */
    @ApiModelProperty(value = "设备IP地址", required = true, position = 3)
    @NotBlank(message = "设备IP地址不能为空")
    private String ipAddr;

    /** 端口号 */
    @ApiModelProperty(value = "端口号", required = true, position = 4)
    private Integer port;

    /** 用户名 */
    @ApiModelProperty(value = "用户名", required = true, position = 5)
    @NotBlank(message = "用户名不能为空")
    private String username;

    /** 密码 */
    @ApiModelProperty(value = "密码", required = true, position = 6)
    @NotBlank(message = "密码不能为空")
    private String password;

    /** 启用状态：1=启用，0=禁用 */
    @ApiModelProperty(value = "启用状态：1=启用，0=禁用", position = 7)
    private Integer enableStatus;

    /** 在线状态：1=在线，0=离线 */
    @ApiModelProperty(value = "在线状态：1=在线，0=离线", position = 8)
    private Integer onlineStatus;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间", position = 9)
    private Date createTime;

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间", position = 10)
    private Date updateTime;
}
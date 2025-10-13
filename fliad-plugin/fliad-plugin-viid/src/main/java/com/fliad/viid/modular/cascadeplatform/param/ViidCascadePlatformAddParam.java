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
package com.fliad.viid.modular.cascadeplatform.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import org.noear.solon.validation.annotation.NotBlank;
import org.noear.solon.validation.annotation.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 视图库添加参数
 *
 * @author wyl
 * @date  2025/08/14 16:24
 **/
@Getter
@Setter
public class ViidCascadePlatformAddParam {

    /** 视图库ID */
    @ApiModelProperty(value = "视图库ID", required = true, position = 2)
    @NotBlank(message = "systemId不能为空")
    private String systemId;

    /** 视图库名称 */
    @ApiModelProperty(value = "视图库名称", required = true, position = 3)
    @NotBlank(message = "name不能为空")
    private String name;

    /** IP地址 */
    @ApiModelProperty(value = "IP地址", required = true, position = 4)
    @NotBlank(message = "ipAddr不能为空")
    private String ipAddr;

    /** 端口 */
    @ApiModelProperty(value = "端口", required = true, position = 5)
    @NotNull(message = "port不能为空")
    private Integer port;

    /** 视图库类型 */
    @ApiModelProperty(value = "视图库类型", required = true, position = 8)
    @NotBlank(message = "type不能为空")
    private String type;

    /** 授权用户 */
    @ApiModelProperty(value = "授权用户", position = 9)
    private String userId;

    /** 授权密码 */
    @ApiModelProperty(value = "授权密码", position = 10)
    private String password;

}

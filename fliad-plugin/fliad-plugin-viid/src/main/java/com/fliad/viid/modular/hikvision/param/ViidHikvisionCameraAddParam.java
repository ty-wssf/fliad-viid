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
package com.fliad.viid.modular.hikvision.param;

import io.swagger.annotations.ApiModelProperty;
import org.noear.solon.validation.annotation.NotBlank;

/**
 * 海康设备添加参数
 *
 * @author yubaoshan
 * @date 2025/09/27
 */
public class ViidHikvisionCameraAddParam {

    /** 设备编号 */
    @ApiModelProperty(value = "设备编号", position = 1)
    private String deviceId;

    /** 设备名称 */
    @ApiModelProperty(value = "设备名称", required = true, position = 2)
    @NotBlank(message = "设备名称不能为空")
    private String name;

    /** 设备IP地址 */
    @ApiModelProperty(value = "设备IP地址", required = true, position = 2)
    @NotBlank(message = "设备IP地址不能为空")
    private String ipAddr;

    /** 端口号 */
    @ApiModelProperty(value = "端口号", required = true, position = 3)
    private Integer port;

    /** 用户名 */
    @ApiModelProperty(value = "用户名", required = true, position = 4)
    @NotBlank(message = "用户名不能为空")
    private String username;

    /** 密码 */
    @ApiModelProperty(value = "密码", required = true, position = 5)
    @NotBlank(message = "密码不能为空")
    private String password;

    /** 启用状态：1=启用，0=禁用 */
    @ApiModelProperty(value = "启用状态：1=启用，0=禁用", position = 6)
    private Integer enableStatus = 1;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }
}

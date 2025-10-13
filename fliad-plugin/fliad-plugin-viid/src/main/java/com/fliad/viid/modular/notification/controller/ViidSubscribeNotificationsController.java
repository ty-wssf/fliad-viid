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
package com.fliad.viid.modular.notification.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.mybatisflex.core.paginate.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.NotEmpty;
import org.noear.solon.validation.annotation.Valid;
import com.fliad.common.annotation.CommonLog;
import com.fliad.common.pojo.CommonResult;
import com.fliad.common.pojo.CommonValidList;
import com.fliad.viid.modular.notification.entity.ViidSubscribeNotifications;
import com.fliad.viid.modular.notification.param.ViidSubscribeNotificationsAddParam;
import com.fliad.viid.modular.notification.param.ViidSubscribeNotificationsEditParam;
import com.fliad.viid.modular.notification.param.ViidSubscribeNotificationsIdParam;
import com.fliad.viid.modular.notification.param.ViidSubscribeNotificationsPageParam;
import com.fliad.viid.modular.notification.service.ViidSubscribeNotificationsService;

import java.util.List;

/**
 * 订阅通知控制器
 *
 * @author wyl
 * @date 2025/09/22
 */
@Api(tags = "订阅通知控制器")
@Controller
@Valid
public class ViidSubscribeNotificationsController {

    @Inject
    private ViidSubscribeNotificationsService viidSubscribeNotificationsService;

    /**
     * 获取订阅通知分页
     *
     * @author wyl
     * @date 2025/09/22
     */
    @ApiOperation("获取订阅通知分页")
    @SaCheckPermission("/viid/notification/page")
    @Get
    @Mapping("/viid/notification/page")
    public CommonResult<Page<ViidSubscribeNotifications>> page(ViidSubscribeNotificationsPageParam viidSubscribeNotificationsPageParam) {
        return CommonResult.data(viidSubscribeNotificationsService.page(viidSubscribeNotificationsPageParam));
    }

    /**
     * 添加订阅通知
     *
     * @author wyl
     * @date 2025/09/22
     */
    @ApiOperation("添加订阅通知")
    @CommonLog("添加订阅通知")
    @SaCheckPermission("/viid/notification/add")
    @Post
    @Mapping("/viid/notification/add")
    public CommonResult<String> add(ViidSubscribeNotificationsAddParam viidSubscribeNotificationsAddParam) {
        viidSubscribeNotificationsService.add(viidSubscribeNotificationsAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑订阅通知
     *
     * @author wyl
     * @date 2025/09/22
     */
    @ApiOperation("编辑订阅通知")
    @CommonLog("编辑订阅通知")
    @SaCheckPermission("/viid/notification/edit")
    @Post
    @Mapping("/viid/notification/edit")
    public CommonResult<String> edit(ViidSubscribeNotificationsEditParam viidSubscribeNotificationsEditParam) {
        viidSubscribeNotificationsService.edit(viidSubscribeNotificationsEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除订阅通知
     *
     * @author wyl
     * @date 2025/09/22
     */
    @ApiOperation("删除订阅通知")
    @CommonLog("删除订阅通知")
    @SaCheckPermission("/viid/notification/delete")
    @Post
    @Mapping("/viid/notification/delete")
    public CommonResult<String> delete(@NotEmpty(message = "集合不能为空")
                                       CommonValidList<ViidSubscribeNotificationsIdParam> viidSubscribeNotificationsIdParamList) {
        viidSubscribeNotificationsService.delete(viidSubscribeNotificationsIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取订阅通知详情
     *
     * @author wyl
     * @date 2025/09/22
     */
    @ApiOperation("获取订阅通知详情")
    @SaCheckPermission("/viid/notification/detail")
    @Get
    @Mapping("/viid/notification/detail")
    public CommonResult<ViidSubscribeNotifications> detail(ViidSubscribeNotificationsIdParam viidSubscribeNotificationsIdParam) {
        return CommonResult.data(viidSubscribeNotificationsService.detail(viidSubscribeNotificationsIdParam));
    }
}
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
package com.fliad.viid.modular.subscribe.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.fliad.common.annotation.CommonWrapper;
import com.fliad.viid.modular.subscribe.param.*;
import com.fliad.viid.modular.subscribe.wrapper.ViidSubscribeWrapper;
import com.mybatisflex.core.paginate.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.NotEmpty;
import org.noear.solon.validation.annotation.Valid;
import com.fliad.common.annotation.CommonLog;
import com.fliad.common.pojo.CommonResult;
import com.fliad.common.pojo.CommonValidList;
import com.fliad.viid.modular.subscribe.entity.ViidSubscribe;
import com.fliad.viid.modular.subscribe.service.ViidSubscribeService;

/**
 * 订阅上报控制器
 *
 * @author wyl
 * @date 2025/08/22 15:00
 */
@Api(tags = "订阅上报控制器")
@Controller
@Valid
public class ViidSubscribeUpController {

    @Inject
    private ViidSubscribeService viidSubscribeService;

    /**
     * 获取订阅上报分页
     *
     * @author wyl
     * @date 2025/08/22 15:00
     */
    @ApiOperation("获取订阅上报分页")
    @SaCheckPermission("/viid/subscribe/up/page")
    @Get
    @Mapping("/viid/subscribe/up/page")
    @CommonWrapper(value = ViidSubscribeWrapper.class)
    public CommonResult<Page<ViidSubscribe>> page(ViidSubscribePageParam viidSubscribePageParam) {
        return CommonResult.data(viidSubscribeService.page(viidSubscribePageParam));
    }

    /**
     * 添加订阅上报
     *
     * @author wyl
     * @date 2025/08/22 15:00
     */
    @ApiOperation("添加订阅上报")
    @CommonLog("添加订阅上报")
    @SaCheckPermission("/viid/subscribe/up/add")
    @Post
    @Mapping("/viid/subscribe/up/add")
    public CommonResult<String> add(ViidSubscribeAddParam viidSubscribeAddParam) {
        viidSubscribeService.add(viidSubscribeAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑订阅上报
     *
     * @author wyl
     * @date 2025/08/22 15:00
     */
    @ApiOperation("编辑订阅上报")
    @CommonLog("编辑订阅上报")
    @SaCheckPermission("/viid/subscribe/up/edit")
    @Post
    @Mapping("/viid/subscribe/up/edit")
    public CommonResult<String> edit(ViidSubscribeEditParam viidSubscribeEditParam) {
        viidSubscribeService.edit(viidSubscribeEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除订阅上报
     *
     * @author wyl
     * @date 2025/08/22 15:00
     */
    @ApiOperation("删除订阅上报")
    @CommonLog("删除订阅上报")
    @SaCheckPermission("/viid/subscribe/up/delete")
    @Post
    @Mapping("/viid/subscribe/up/delete")
    public CommonResult<String> delete(@NotEmpty(message = "集合不能为空")
                                       CommonValidList<ViidSubscribeIdParam> viidSubscribeIdParamList) {
        viidSubscribeService.delete(viidSubscribeIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取订阅上报详情
     *
     * @author wyl
     * @date 2025/08/22 15:00
     */
    @ApiOperation("获取订阅上报详情")
    @SaCheckPermission("/viid/subscribe/up/detail")
    @Get
    @Mapping("/viid/subscribe/up/detail")
    public CommonResult<ViidSubscribe> detail(ViidSubscribeIdParam viidSubscribeIdParam) {
        return CommonResult.data(viidSubscribeService.detail(viidSubscribeIdParam));
    }

    @ApiOperation("向上级发送订阅请求")
    @Post
    @Mapping("/viid/subscribe/up/send")
    public CommonResult<Void> subscribeSend(ViidSubscribeIdParam viidSubscribeIdParam) {
        viidSubscribeService.subscribeSend(viidSubscribeIdParam);
        return CommonResult.ok();
    }

    @ApiOperation("向上级发送取消订阅请求")
    @Post
    @Mapping("/viid/subscribe/up/cancel")
    public CommonResult<String> subscribeCancel(ViidSubscribeCancelParam viidSubscribeCancelParam) {
        viidSubscribeService.subscribeCancel(viidSubscribeCancelParam);
        return CommonResult.ok();
    }

}
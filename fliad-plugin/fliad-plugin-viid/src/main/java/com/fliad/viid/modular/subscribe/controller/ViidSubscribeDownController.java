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
import org.noear.snack.ONode;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.NotEmpty;
import org.noear.solon.validation.annotation.Valid;
import com.fliad.common.annotation.CommonLog;
import com.fliad.common.pojo.CommonResult;
import com.fliad.common.pojo.CommonValidList;
import com.fliad.viid.modular.subscribe.entity.ViidSubscribe;
import com.fliad.viid.modular.subscribe.service.ViidSubscribeService;

/**
 * 订阅下发控制器
 *
 * @author wyl
 * @date 2025/08/22 15:00
 */
@Api(tags = "订阅下发控制器")
@Controller
@Valid
public class ViidSubscribeDownController {

    @Inject
    private ViidSubscribeService viidSubscribeService;

    /**
     * 获取订阅下发分页
     *
     * @author wyl
     * @date 2025/08/22 15:00
     */
    @ApiOperation("获取订阅下发分页")
    @SaCheckPermission("/viid/subscribe/page")
    @Get
    @Mapping("/viid/subscribe/page")
    @CommonWrapper(value = ViidSubscribeWrapper.class)
    public CommonResult<Page<ViidSubscribe>> page(ViidSubscribePageParam viidSubscribePageParam) {
        return CommonResult.data(viidSubscribeService.page(viidSubscribePageParam));
    }

    /**
     * 添加订阅下发
     *
     * @author wyl
     * @date 2025/08/22 15:00
     */
    @ApiOperation("添加订阅下发")
    @CommonLog("添加订阅下发")
    @SaCheckPermission("/viid/subscribe/add")
    @Post
    @Mapping("/viid/subscribe/add")
    public CommonResult<String> add(ViidSubscribeAddParam viidSubscribeAddParam) {
        viidSubscribeService.add(viidSubscribeAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑订阅下发
     *
     * @author wyl
     * @date 2025/08/22 15:00
     */
    @ApiOperation("编辑订阅下发")
    @CommonLog("编辑订阅下发")
    @SaCheckPermission("/viid/subscribe/edit")
    @Post
    @Mapping("/viid/subscribe/edit")
    public CommonResult<String> edit(ViidSubscribeEditParam viidSubscribeEditParam) {
        viidSubscribeService.edit(viidSubscribeEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除订阅下发
     *
     * @author wyl
     * @date 2025/08/22 15:00
     */
    @ApiOperation("删除订阅下发")
    @CommonLog("删除订阅下发")
    @SaCheckPermission("/viid/subscribe/delete")
    @Post
    @Mapping("/viid/subscribe/delete")
    public CommonResult<String> delete(@NotEmpty(message = "集合不能为空")
                                       CommonValidList<ViidSubscribeIdParam> viidSubscribeIdParamList) {
        viidSubscribeService.delete(viidSubscribeIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取订阅下发详情
     *
     * @author wyl
     * @date 2025/08/22 15:00
     */
    @ApiOperation("获取订阅下发详情")
    @SaCheckPermission("/viid/subscribe/detail")
    @Get
    @Mapping("/viid/subscribe/detail")
    public CommonResult<ViidSubscribe> detail(ViidSubscribeIdParam viidSubscribeIdParam) {
        return CommonResult.data(viidSubscribeService.detail(viidSubscribeIdParam));
    }

    @ApiOperation("向下级发送订阅请求")
    @Post
    @Mapping("/viid/subscribe/send")
    public CommonResult<Void> subscribeSend(ViidSubscribeIdParam viidSubscribeIdParam) {
        viidSubscribeService.subscribeSend(viidSubscribeIdParam);
        return CommonResult.ok();
    }

    @ApiOperation("向下级发送取消订阅请求")
    @Post
    @Mapping("/viid/subscribe/cancel")
    public CommonResult<String> subscribeCancel(ViidSubscribeCancelParam viidSubscribeCancelParam) {
        viidSubscribeService.subscribeCancel(viidSubscribeCancelParam);
        return CommonResult.ok();
    }

}

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
package com.fliad.auth.modular.third.controller;

import com.mybatisflex.core.paginate.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.zhyd.oauth.model.AuthCallback;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.validation.annotation.Valid;
import org.noear.solon.validation.annotation.Validated;
import com.fliad.auth.modular.third.entity.AuthThirdUser;
import com.fliad.auth.modular.third.param.AuthThirdCallbackParam;
import com.fliad.auth.modular.third.param.AuthThirdRenderParam;
import com.fliad.auth.modular.third.param.AuthThirdUserPageParam;
import com.fliad.auth.modular.third.result.AuthThirdRenderResult;
import com.fliad.auth.modular.third.service.AuthThirdService;
import com.fliad.common.pojo.CommonResult;

/**
 * 第三方登录控制器
 *
 * @author xuyuxiang
 * @date 2022/7/8 16:18
 **/
@Api(tags = "三方登录控制器")
@Controller
@Valid
public class AuthThirdController {

    @Inject
    private AuthThirdService authThirdService;

    /**
     * 第三方登录页面渲染
     *
     * @author xuyuxiang
     * @date 2022/7/8 16:19
     **/
    @ApiOperation("第三方登录页面渲染")
    @Get
    @Mapping("/auth/third/render")
    public CommonResult<AuthThirdRenderResult> render(@Validated AuthThirdRenderParam authThirdRenderParam) {
        return CommonResult.data(authThirdService.render(authThirdRenderParam));
    }

    /**
     * 第三方登录授权回调
     *
     * @author xuyuxiang
     * @date 2022/7/8 16:42
     **/
    @ApiOperation("第三方登录授权回调")
    @Get
    @Mapping("/auth/third/callback")
    public CommonResult<String> callback(@Validated AuthThirdCallbackParam authThirdCallbackParam, AuthCallback authCallback) {
        return CommonResult.data(authThirdService.callback(authThirdCallbackParam, authCallback));
    }

    /**
     * 获取三方用户分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取三方用户分页")
    @Get
    @Mapping("/auth/third/page")
    public CommonResult<Page<AuthThirdUser>> page(AuthThirdUserPageParam authThirdUserPageParam) {
        return CommonResult.data(authThirdService.page(authThirdUserPageParam));
    }
}

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
package com.fliad.sys.modular.resource.controller;

import com.mybatisflex.core.paginate.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.NotEmpty;
import org.noear.solon.validation.annotation.Valid;
import org.noear.solon.validation.annotation.Validated;
import com.fliad.common.annotation.CommonLog;
import com.fliad.common.pojo.CommonResult;
import com.fliad.sys.modular.resource.entity.SysButton;
import com.fliad.sys.modular.resource.param.button.SysButtonAddParam;
import com.fliad.sys.modular.resource.param.button.SysButtonEditParam;
import com.fliad.sys.modular.resource.param.button.SysButtonIdParam;
import com.fliad.sys.modular.resource.param.button.SysButtonPageParam;
import com.fliad.sys.modular.resource.service.SysButtonService;

import java.util.List;

/**
 * 按钮控制器
 *
 * @author xuyuxiang
 * @date 2022/6/27 13:56
 **/
@Api(tags = "按钮控制器")
@Controller
@Valid
public class SysButtonController {

    @Inject
    private SysButtonService sysButtonService;

    /**
     * 获取按钮分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取按钮分页")
    @Get
    @Mapping("/sys/button/page")
    public CommonResult<Page<SysButton>> page(SysButtonPageParam sysButtonPageParam) {
        return CommonResult.data(sysButtonService.page(sysButtonPageParam));
    }

    /**
     * 添加按钮
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("添加按钮")
    @CommonLog("添加按钮")
    @Post
    @Mapping("/sys/button/add")
    public CommonResult<String> add(@Validated SysButtonAddParam sysButtonAddParam) {
        sysButtonService.add(sysButtonAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑按钮
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("编辑按钮")
    @CommonLog("编辑按钮")
    @Post
    @Mapping("/sys/button/edit")
    public CommonResult<String> edit(@Validated SysButtonEditParam sysButtonEditParam) {
        sysButtonService.edit(sysButtonEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除按钮
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("删除按钮")
    @CommonLog("删除按钮")
    @Post
    @Mapping("/sys/button/delete")
    public CommonResult<String> delete(@Validated @NotEmpty(message = "集合不能为空") List<SysButtonIdParam> sysButtonIdParamList) {
        sysButtonService.delete(sysButtonIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取按钮详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取按钮详情")
    @Get
    @Mapping("/sys/button/detail")
    public CommonResult<SysButton> detail(@Validated SysButtonIdParam sysButtonIdParam) {
        return CommonResult.data(sysButtonService.detail(sysButtonIdParam));
    }
}

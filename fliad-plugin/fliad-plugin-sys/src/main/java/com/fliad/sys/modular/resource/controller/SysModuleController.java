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
import org.noear.solon.validation.annotation.Valid;
import org.noear.solon.validation.annotation.Validated;
import com.fliad.common.annotation.CommonLog;
import com.fliad.common.pojo.CommonResult;
import com.fliad.common.pojo.CommonValidList;
import com.fliad.sys.modular.resource.entity.SysModule;
import com.fliad.sys.modular.resource.param.module.SysModuleAddParam;
import com.fliad.sys.modular.resource.param.module.SysModuleEditParam;
import com.fliad.sys.modular.resource.param.module.SysModuleIdParam;
import com.fliad.sys.modular.resource.param.module.SysModulePageParam;
import com.fliad.sys.modular.resource.service.SysModuleService;

import org.noear.solon.validation.annotation.NotEmpty;

/**
 * 模块控制器
 *
 * @author xuyuxiang
 * @date 2022/6/27 14:12
 **/
@Api(tags = "模块控制器")
@Controller
@Valid
public class SysModuleController {

    @Inject
    private SysModuleService sysModuleService;

    /**
     * 获取模块分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取模块分页")
    @Get
    @Mapping("/sys/module/page")
    public CommonResult<Page<SysModule>> page(SysModulePageParam sysModulePageParam) {
        return CommonResult.data(sysModuleService.page(sysModulePageParam));
    }

    /**
     * 添加模块
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("添加模块")
    @CommonLog("添加模块")
    @Post
    @Mapping("/sys/module/add")
    public CommonResult<String> add(@Validated SysModuleAddParam sysModuleAddParam) {
        sysModuleService.add(sysModuleAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑模块
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("编辑模块")
    @CommonLog("编辑模块")
    @Post
    @Mapping("/sys/module/edit")
    public CommonResult<String> edit(@Validated SysModuleEditParam sysModuleEditParam) {
        sysModuleService.edit(sysModuleEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除模块
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("删除模块")
    @CommonLog("删除模块")
    @Post
    @Mapping("/sys/module/delete")
    public CommonResult<String> delete(@Validated @NotEmpty(message = "集合不能为空")
                                                   CommonValidList<SysModuleIdParam> sysModuleIdParamList) {
        sysModuleService.delete(sysModuleIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取模块详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取模块详情")
    @Get
    @Mapping("/sys/module/detail")
    public CommonResult<SysModule> detail(@Validated SysModuleIdParam sysModuleIdParam) {
        return CommonResult.data(sysModuleService.detail(sysModuleIdParam));
    }
}

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
package com.fliad.viid.modular.ape.controller;

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
import com.fliad.viid.modular.ape.entity.ViidApe;
import com.fliad.viid.modular.ape.param.ViidApeAddParam;
import com.fliad.viid.modular.ape.param.ViidApeEditParam;
import com.fliad.viid.modular.ape.param.ViidApeIdParam;
import com.fliad.viid.modular.ape.param.ViidApePageParam;
import com.fliad.viid.modular.ape.service.ViidApeService;

import java.util.List;

/**
 * 采集设备控制器
 *
 * @author wyl
 * @date  2025/09/19
 */
@Api(tags = "采集设备控制器")
@Controller
@Valid
public class ViidApeController {

    @Inject
    private ViidApeService viidApeService;

    /**
     * 获取采集设备分页
     *
     * @author wyl
     * @date  2025/09/19
     */
    @ApiOperation("获取采集设备分页")
    @SaCheckPermission("/viid/ape/page")
    @Get
    @Mapping("/viid/ape/page")
    public CommonResult<Page<ViidApe>> page(ViidApePageParam viidApePageParam) {
        return CommonResult.data(viidApeService.page(viidApePageParam));
    }

    /**
     * 添加采集设备
     *
     * @author wyl
     * @date  2025/09/19
     */
    @ApiOperation("添加采集设备")
    @CommonLog("添加采集设备")
    @SaCheckPermission("/viid/ape/add")
    @Post
    @Mapping("/viid/ape/add")
    public CommonResult<String> add(ViidApeAddParam viidApeAddParam) {
        viidApeService.add(viidApeAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑采集设备
     *
     * @author wyl
     * @date  2025/09/19
     */
    @ApiOperation("编辑采集设备")
    @CommonLog("编辑采集设备")
    @SaCheckPermission("/viid/ape/edit")
    @Post
    @Mapping("/viid/ape/edit")
    public CommonResult<String> edit(ViidApeEditParam viidApeEditParam) {
        viidApeService.edit(viidApeEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除采集设备
     *
     * @author wyl
     * @date  2025/09/19
     */
    @ApiOperation("删除采集设备")
    @CommonLog("删除采集设备")
    @SaCheckPermission("/viid/ape/delete")
    @Post
    @Mapping("/viid/ape/delete")
    public CommonResult<String> delete(@NotEmpty(message = "集合不能为空")
                                       CommonValidList<ViidApeIdParam> viidApeIdParamList) {
        viidApeService.delete(viidApeIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取采集设备详情
     *
     * @author wyl
     * @date  2025/09/19
     */
    @ApiOperation("获取采集设备详情")
    @SaCheckPermission("/viid/ape/detail")
    @Get
    @Mapping("/viid/ape/detail")
    public CommonResult<ViidApe> detail(ViidApeIdParam viidApeIdParam) {
        return CommonResult.data(viidApeService.detail(viidApeIdParam));
    }
}
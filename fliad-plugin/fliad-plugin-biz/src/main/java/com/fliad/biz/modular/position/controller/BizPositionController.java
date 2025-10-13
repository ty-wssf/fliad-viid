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
package com.fliad.biz.modular.position.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.lang.tree.Tree;
import com.fliad.biz.modular.position.param.*;
import com.mybatisflex.core.paginate.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.NotEmpty;
import org.noear.solon.validation.annotation.Valid;
import org.noear.solon.validation.annotation.Validated;
import com.fliad.biz.modular.position.entity.BizPosition;
import com.fliad.biz.modular.position.param.*;
import com.fliad.biz.modular.position.service.BizPositionService;
import com.fliad.common.annotation.CommonLog;
import com.fliad.common.pojo.CommonResult;
import com.fliad.common.pojo.CommonValidList;

import java.util.List;

/**
 * 岗位控制器
 *
 * @author xuyuxiang
 * @date 2022/4/25 20:40
 */
@Api(tags = "岗位控制器")
@Controller
@Valid
public class BizPositionController {

    @Inject
    private BizPositionService bizPositionService;

    /**
     * 获取岗位分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取岗位分页")
    @SaCheckPermission("/biz/position/page")
    @Get
    @Mapping("/biz/position/page")
    public CommonResult<Page<BizPosition>> page(BizPositionPageParam bizPositionPageParam) {
        return CommonResult.data(bizPositionService.page(bizPositionPageParam));
    }

    /**
     * 添加岗位
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("添加岗位")
    @CommonLog("添加岗位")
    @SaCheckPermission("/biz/position/add")
    @Post
    @Mapping("/biz/position/add")
    public CommonResult<String> add(@Validated BizPositionAddParam bizPositionAddParam) {
        bizPositionService.add(bizPositionAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑岗位
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("编辑岗位")
    @CommonLog("编辑岗位")
    @SaCheckPermission("/biz/position/edit")
    @Post
    @Mapping("/biz/position/edit")
    public CommonResult<String> edit(@Validated BizPositionEditParam bizPositionEditParam) {
        bizPositionService.edit(bizPositionEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除岗位
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("删除岗位")
    @CommonLog("删除岗位")
    @SaCheckPermission("/biz/position/delete")
    @Post
    @Mapping("/biz/position/delete")
    public CommonResult<String> delete(@Validated @NotEmpty(message = "集合不能为空")
                                                   CommonValidList<BizPositionIdParam> bizPositionIdParamList) {
        bizPositionService.delete(bizPositionIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取岗位详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取岗位详情")
    @SaCheckPermission("/biz/position/detail")
    @Get
    @Mapping("/biz/position/detail")
    public CommonResult<BizPosition> detail(@Validated BizPositionIdParam bizPositionIdParam) {
        return CommonResult.data(bizPositionService.detail(bizPositionIdParam));
    }

    /* ====岗位部分所需要用到的选择器==== */

    /**
     * 获取组织树选择器
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取组织树选择器")
    @SaCheckPermission("/biz/position/orgTreeSelector")
    @Get
    @Mapping("/biz/position/orgTreeSelector")
    public CommonResult<List<Tree<String>>> orgTreeSelector() {
        return CommonResult.data(bizPositionService.orgTreeSelector());
    }

    /**
     * 获取岗位选择器
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取岗位选择器")
    @SaCheckPermission("/biz/position/positionSelector")
    @Get
    @Mapping("/biz/position/positionSelector")
    public CommonResult<Page<BizPosition>> positionSelector(BizPositionSelectorPositionParam bizPositionSelectorPositionParam) {
        return CommonResult.data(bizPositionService.positionSelector(bizPositionSelectorPositionParam));
    }
}

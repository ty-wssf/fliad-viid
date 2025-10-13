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
package com.fliad.biz.modular.org.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.lang.tree.Tree;
import com.fliad.biz.modular.org.param.*;
import com.mybatisflex.core.paginate.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.NotEmpty;
import org.noear.solon.validation.annotation.Valid;
import org.noear.solon.validation.annotation.Validated;
import com.fliad.biz.modular.org.entity.BizOrg;
import com.fliad.biz.modular.org.param.*;
import com.fliad.biz.modular.org.service.BizOrgService;
import com.fliad.biz.modular.user.entity.BizUser;
import com.fliad.common.annotation.CommonLog;
import com.fliad.common.pojo.CommonResult;
import com.fliad.common.pojo.CommonValidList;

import java.util.List;

/**
 * 机构控制器
 *
 * @author xuyuxiang
 * @date 2022/4/24 19:55
 */
@Api(tags = "机构控制器")
@Controller
@Valid
public class BizOrgController {

    @Inject
    private BizOrgService bizOrgService;

    /**
     * 获取机构分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取机构分页")
    @SaCheckPermission("/biz/org/page")
    @Get
    @Mapping("/biz/org/page")
    public CommonResult<Page<BizOrg>> page(BizOrgPageParam bizOrgPageParam) {
        return CommonResult.data(bizOrgService.page(bizOrgPageParam));
    }

    /**
     * 获取机构树
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取机构树")
    @SaCheckPermission("/biz/org/tree")
    @Get
    @Mapping("/biz/org/tree")
    public CommonResult<List<Tree<String>>> tree() {
        return CommonResult.data(bizOrgService.tree());
    }

    /**
     * 添加机构
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("添加机构")
    @CommonLog("添加机构")
    @SaCheckPermission("/biz/org/add")
    @Post
    @Mapping("/biz/org/add")
    public CommonResult<String> add(@Validated BizOrgAddParam bizOrgAddParam) {
        bizOrgService.add(bizOrgAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑机构
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("编辑机构")
    @CommonLog("编辑机构")
    @SaCheckPermission("/biz/org/edit")
    @Post
    @Mapping("/biz/org/edit")
    public CommonResult<String> edit(@Validated BizOrgEditParam bizOrgEditParam) {
        bizOrgService.edit(bizOrgEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除机构
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("删除机构")
    @CommonLog("删除机构")
    @SaCheckPermission("/biz/org/delete")
    @Post
    @Mapping("/biz/org/delete")
    public CommonResult<String> delete(@Validated @NotEmpty(message = "集合不能为空")
                                                   CommonValidList<BizOrgIdParam> bizOrgIdParamList) {
        bizOrgService.delete(bizOrgIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取机构详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取机构详情")
    @SaCheckPermission("/biz/org/detail")
    @Get
    @Mapping("/biz/org/detail")
    public CommonResult<BizOrg> detail(@Validated BizOrgIdParam bizOrgIdParam) {
        return CommonResult.data(bizOrgService.detail(bizOrgIdParam));
    }

    /* ====机构部分所需要用到的选择器==== */

    /**
     * 获取机构树选择器
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取机构树选择器")
    @SaCheckPermission("/biz/org/orgTreeSelector")
    @Get
    @Mapping("/biz/org/orgTreeSelector")
    public CommonResult<List<Tree<String>>> orgTreeSelector() {
        return CommonResult.data(bizOrgService.orgTreeSelector());
    }

    /**
     * 获取人员选择器
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取人员选择器")
    @SaCheckPermission("/biz/org/userSelector")
    @Get
    @Mapping("/biz/org/userSelector")
    public CommonResult<Page<BizUser>> userSelector(BizOrgSelectorUserParam bizOrgSelectorUserParam) {
        return CommonResult.data(bizOrgService.userSelector(bizOrgSelectorUserParam));
    }
}

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
package com.fliad.sys.modular.position.controller;

import cn.hutool.core.lang.tree.Tree;
import com.fliad.sys.modular.position.param.*;
import com.mybatisflex.core.paginate.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.Valid;
import org.noear.solon.validation.annotation.Validated;
import com.fliad.common.annotation.CommonLog;
import com.fliad.common.pojo.CommonResult;
import com.fliad.common.pojo.CommonValidList;
import com.fliad.sys.modular.position.entity.SysPosition;
import com.fliad.sys.modular.position.service.SysPositionService;

import org.noear.solon.validation.annotation.NotEmpty;
import java.util.List;

/**
 * 职位控制器
 *
 * @author xuyuxiang
 * @date 2022/4/25 20:40
 */
@Api(tags = "职位控制器")
@Controller
@Valid
public class SysPositionController {

    @Inject
    private SysPositionService sysPositionService;

    /**
     * 获取职位分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取职位分页")
    @Get
    @Mapping("/sys/position/page")
    public CommonResult<Page<SysPosition>> page(SysPositionPageParam sysPositionPageParam) {
        return CommonResult.data(sysPositionService.page(sysPositionPageParam));
    }

    /**
     * 添加职位
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("添加职位")
    @CommonLog("添加职位")
    @Post
    @Mapping("/sys/position/add")
    public CommonResult<String> add(@Validated SysPositionAddParam sysPositionAddParam) {
        sysPositionService.add(sysPositionAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑职位
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("编辑职位")
    @CommonLog("编辑职位")
    @Post
    @Mapping("/sys/position/edit")
    public CommonResult<String> edit(@Validated SysPositionEditParam sysPositionEditParam) {
        sysPositionService.edit(sysPositionEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除职位
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("删除职位")
    @CommonLog("删除职位")
    @Post
    @Mapping("/sys/position/delete")
    public CommonResult<String> delete(@Validated @NotEmpty(message = "集合不能为空")
                                                   CommonValidList<SysPositionIdParam> sysPositionIdParamList) {
        sysPositionService.delete(sysPositionIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取职位详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取职位详情")
    @Get
    @Mapping("/sys/position/detail")
    public CommonResult<SysPosition> detail(@Validated SysPositionIdParam sysPositionIdParam) {
        return CommonResult.data(sysPositionService.detail(sysPositionIdParam));
    }

    /* ====职位部分所需要用到的选择器==== */

    /**
     * 获取组织树选择器
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取组织树选择器")
    @Get
    @Mapping("/sys/position/orgTreeSelector")
    public CommonResult<List<Tree<String>>> orgTreeSelector() {
        return CommonResult.data(sysPositionService.orgTreeSelector());
    }

    /**
     * 获取职位选择器
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取职位选择器")
    @Get
    @Mapping("/sys/position/positionSelector")
    public CommonResult<Page<SysPosition>> positionSelector(SysPositionSelectorPositionParam sysPositionSelectorPositionParam) {
        return CommonResult.data(sysPositionService.positionSelector(sysPositionSelectorPositionParam));
    }
}

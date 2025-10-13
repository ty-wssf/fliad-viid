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
package com.fliad.viid.modular.workflow.controller;

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
import com.fliad.viid.modular.workflow.entity.ViidWorkflow;
import com.fliad.viid.modular.workflow.param.ViidWorkflowAddParam;
import com.fliad.viid.modular.workflow.param.ViidWorkflowEditParam;
import com.fliad.viid.modular.workflow.param.ViidWorkflowIdParam;
import com.fliad.viid.modular.workflow.param.ViidWorkflowPageParam;
import com.fliad.viid.modular.workflow.service.ViidWorkflowService;

/**
 * 工作流控制器
 *
 * @author wyl
 * @date  2025/08/27 14:03
 */
@Api(tags = "工作流控制器")
@Controller
@Valid
public class ViidWorkflowController {

    @Inject
    private ViidWorkflowService viidWorkflowService;

    /**
     * 获取工作流分页
     *
     * @author wyl
     * @date  2025/08/27 14:03
     */
    @ApiOperation("获取工作流分页")
    @SaCheckPermission("/viid/workflow/page")
    @Get
    @Mapping("/viid/workflow/page")
    public CommonResult<Page<ViidWorkflow>> page(ViidWorkflowPageParam viidWorkflowPageParam) {
        return CommonResult.data(viidWorkflowService.page(viidWorkflowPageParam));
    }

    /**
     * 添加工作流
     *
     * @author wyl
     * @date  2025/08/27 14:03
     */
    @ApiOperation("添加工作流")
    @CommonLog("添加工作流")
    @SaCheckPermission("/viid/workflow/add")
    @Post
    @Mapping("/viid/workflow/add")
    public CommonResult<String> add(ViidWorkflowAddParam viidWorkflowAddParam) {
        viidWorkflowService.add(viidWorkflowAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑工作流
     *
     * @author wyl
     * @date  2025/08/27 14:03
     */
    @ApiOperation("编辑工作流")
    // @CommonLog("编辑工作流")
    // @SaCheckPermission("/viid/workflow/edit")
    @Post
    @Mapping("/viid/workflow/edit")
    public CommonResult<String> edit(ViidWorkflowEditParam viidWorkflowEditParam) {
        viidWorkflowService.edit(viidWorkflowEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除工作流
     *
     * @author wyl
     * @date  2025/08/27 14:03
     */
    @ApiOperation("删除工作流")
    @CommonLog("删除工作流")
    @SaCheckPermission("/viid/workflow/delete")
    @Post
    @Mapping("/viid/workflow/delete")
    public CommonResult<String> delete(@NotEmpty(message = "集合不能为空")
                                                   CommonValidList<ViidWorkflowIdParam> viidWorkflowIdParamList) {
        viidWorkflowService.delete(viidWorkflowIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取工作流详情
     *
     * @author wyl
     * @date  2025/08/27 14:03
     */
    @ApiOperation("获取工作流详情")
    // @SaCheckPermission("/viid/workflow/detail")
    @Get
    @Mapping("/viid/workflow/detail")
    public CommonResult<ViidWorkflow> detail(ViidWorkflowIdParam viidWorkflowIdParam) {
        return CommonResult.data(viidWorkflowService.detail(viidWorkflowIdParam));
    }

    /**
     * 复制工作流
     *
     * @author 
     * @date  
     */
    @ApiOperation("复制工作流")
    @CommonLog("复制工作流")
    @SaCheckPermission("/viid/workflow/add")
    @Post
    @Mapping("/viid/workflow/copy")
    public CommonResult<String> copy(ViidWorkflowIdParam viidWorkflowIdParam) {
        viidWorkflowService.copy(viidWorkflowIdParam);
        return CommonResult.ok();
    }

    @ApiOperation("禁用工作流")
    @Post
    @Mapping("/viid/workflow/disableWorkflow")
    public CommonResult<String> disableWorkflow(ViidWorkflowIdParam viidWorkflowIdParam) {
        viidWorkflowService.disableWorkflow(viidWorkflowIdParam);
        return CommonResult.ok();
    }

    @ApiOperation("启用工作流")
    @Post
    @Mapping("/viid/workflow/enableWorkflow")
    public CommonResult<String> enableWorkflow(ViidWorkflowIdParam viidWorkflowIdParam) {
        viidWorkflowService.enableWorkflow(viidWorkflowIdParam);
        return CommonResult.ok();
    }

}

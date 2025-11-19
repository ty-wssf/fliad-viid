package com.fliad.resource.modular.workflow.controller;

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
import com.fliad.resource.modular.workflow.entity.ResourceWorkflow;
import com.fliad.resource.modular.workflow.param.ResourceWorkflowAddParam;
import com.fliad.resource.modular.workflow.param.ResourceWorkflowEditParam;
import com.fliad.resource.modular.workflow.param.ResourceWorkflowIdParam;
import com.fliad.resource.modular.workflow.param.ResourceWorkflowPageParam;
import com.fliad.resource.modular.workflow.service.ResourceWorkflowService;

import java.util.List;

/**
 * 工作流控制器
 *
 * @author wyl
 * @date  2025/08/27 14:03
 */
@Api(tags = "工作流控制器")
@Controller
@Valid
public class ResourceWorkflowController {

    @Inject
    private ResourceWorkflowService workflowService;

    /**
     * 获取工作流分页
     *
     * @author wyl
     * @date  2025/08/27 14:03
     */
    @ApiOperation("获取工作流分页")
    @SaCheckPermission("/resource/workflow/page")
    @Get
    @Mapping("/resource/workflow/page")
    public CommonResult<Page<ResourceWorkflow>> page(ResourceWorkflowPageParam workflowPageParam) {
        return CommonResult.data(workflowService.page(workflowPageParam));
    }

    /**
     * 添加工作流
     *
     * @author wyl
     * @date  2025/08/27 14:03
     */
    @ApiOperation("添加工作流")
    @CommonLog("添加工作流")
    @SaCheckPermission("/resource/workflow/add")
    @Post
    @Mapping("/resource/workflow/add")
    public CommonResult<String> add(ResourceWorkflowAddParam workflowAddParam) {
        workflowService.add(workflowAddParam);
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
    @Mapping("/resource/workflow/edit")
    public CommonResult<String> edit(ResourceWorkflowEditParam workflowEditParam) {
        workflowService.edit(workflowEditParam);
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
    @SaCheckPermission("/resource/workflow/delete")
    @Post
    @Mapping("/resource/workflow/delete")
    public CommonResult<String> delete(@NotEmpty(message = "集合不能为空")
                                                   CommonValidList<ResourceWorkflowIdParam> workflowIdParamList) {
        workflowService.delete(workflowIdParamList);
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
    @Mapping("/resource/workflow/detail")
    public CommonResult<ResourceWorkflow> detail(ResourceWorkflowIdParam workflowIdParam) {
        return CommonResult.data(workflowService.detail(workflowIdParam));
    }

    /**
     * 复制工作流
     *
     * @author 
     * @date  
     */
    @ApiOperation("复制工作流")
    @CommonLog("复制工作流")
    @SaCheckPermission("/resource/workflow/add")
    @Post
    @Mapping("/resource/workflow/copy")
    public CommonResult<String> copy(ResourceWorkflowIdParam workflowIdParam) {
        workflowService.copy(workflowIdParam);
        return CommonResult.ok();
    }

    @ApiOperation("禁用工作流")
    @Post
    @Mapping("/resource/workflow/disableWorkflow")
    public CommonResult<String> disableWorkflow(ResourceWorkflowIdParam workflowIdParam) {
        workflowService.disableWorkflow(workflowIdParam);
        return CommonResult.ok();
    }

    @ApiOperation("启用工作流")
    @Post
    @Mapping("/resource/workflow/enableWorkflow")
    public CommonResult<String> enableWorkflow(ResourceWorkflowIdParam workflowIdParam) {
        workflowService.enableWorkflow(workflowIdParam);
        return CommonResult.ok();
    }

    /**
     * 安装模板
     *
     * @author wyl
     * @date 2025/09/26
     */
    @ApiOperation("安装模板")
    @CommonLog("安装模板")
    @SaCheckPermission("/resource/workflow/add")
    @Post
    @Mapping("/resource/workflow/installTemplate")
    public CommonResult<String> installTemplate(ResourceWorkflowIdParam workflowIdParam) {
        workflowService.installTemplate(workflowIdParam);
        return CommonResult.ok();
    }

    /**
     * 获取模板列表
     *
     * @author wyl
     * @date 2025/09/26
     */
    @ApiOperation("获取模板列表")
    @SaCheckPermission("/resource/workflow/page")
    @Get
    @Mapping("/resource/workflow/templateList")
    public CommonResult<List<ResourceWorkflow>> templateList() {
        return CommonResult.data(workflowService.listTemplates());
    }

    /**
     * 将工作流转换为模板
     *
     * @author wyl
     * @date 2025/09/26
     */
    @ApiOperation("将工作流转换为模板")
    @CommonLog("将工作流转换为模板")
    @SaCheckPermission("/resource/workflow/edit")
    @Post
    @Mapping("/resource/workflow/convertToTemplate")
    public CommonResult<String> convertToTemplate(ResourceWorkflowIdParam workflowIdParam) {
        workflowService.convertToTemplate(workflowIdParam);
        return CommonResult.ok();
    }
}

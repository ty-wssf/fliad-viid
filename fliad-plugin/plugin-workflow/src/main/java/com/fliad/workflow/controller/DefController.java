package com.fliad.workflow.controller;

import com.fliad.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.dromara.warm.flow.core.entity.Definition;
import org.dromara.warm.flow.core.service.DefService;
import org.dromara.warm.flow.core.utils.page.Page;
import org.dromara.warm.flow.orm.entity.FlowDefinition;
import org.noear.solon.annotation.*;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.UploadedFile;
import org.noear.solon.validation.annotation.Valid;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 流程定义Controller
 *
 * @author hh
 * @date 2023-04-11
 */
@Api(tags = "流程定义")
@Controller
@Valid
public class DefController {

    @Inject
    private DefService defService;

    /**
     * 分页查询流程定义列表
     */
    @ApiOperation("获取移动端按钮分页")
    @Get
    @Mapping("/flow/definition/list")
    public CommonResult<com.mybatisflex.core.paginate.Page<FlowDefinition>> list(FlowDefinition flowDefinition) {
        // flow组件自带分页功能
        int pageNum = Context.current().paramAsInt("pageNum");
        int pageSize = Context.current().paramAsInt("pageSize");
        Page<Definition> page = Page.pageOf(pageNum, pageSize);
        page = defService.orderByCreateTime().desc().page(flowDefinition, page);
        com.mybatisflex.core.paginate.Page page_ = new com.mybatisflex.core.paginate.Page<>();
        page_.setPageNumber(page.getPageNum());
        page_.setPageSize(page.getPageSize());
        page_.setTotalRow(page.getTotal());
        List<Definition> list = page.getList();
        page_.setRecords(list);
        return CommonResult.data(page_);
    }

    /**
     * 获取流程定义详细信息
     */
    @Get
    @Mapping("/flow/definition/{id}")
    public CommonResult<Definition> getInfo(@Path("id") Long id) {
        return CommonResult.data(defService.getById(id));
    }

    /**
     * 新增流程定义
     */
    @ApiOperation("新增流程定义")
    @Post
    @Mapping("/flow/definition")
    public CommonResult<Boolean> add(@Body FlowDefinition flowDefinition) {
        return CommonResult.data(defService.checkAndSave(flowDefinition));
    }

    /**
     * 发布流程定义
     */
    @ApiOperation("发布流程定义")
    @Get
    @Mapping("/flow/definition/publish/{id}")
    public CommonResult<Boolean> publish(@Path("id") Long id) {
        return CommonResult.data(defService.publish(id));
    }

    /**
     * 取消发布流程定义
     */
    @ApiOperation("取消发布流程定义")
    @Get
    @Mapping("/flow/definition/unPublish/{id}")
    public CommonResult<Void> unPublish(@Path("id") Long id) {
        defService.unPublish(id);
        return CommonResult.ok();
    }

    /**
     * 修改流程定义
     */
    @ApiOperation("修改流程定义")
    @Put
    @Mapping("/flow/definition")
    public CommonResult<Boolean> edit(@Body FlowDefinition flowDefinition) {
        return CommonResult.data(defService.updateById(flowDefinition));
    }

    /**
     * 删除流程定义
     */
    @ApiOperation("删除流程定义")
    @Delete
    @Mapping("/flow/definition/{ids}")
    public CommonResult<Boolean> remove(@Path("ids") List<Long> ids) {
        return CommonResult.data(defService.removeDef(ids));
    }

    /**
     * 复制流程定义
     */
    @ApiOperation("复制流程定义")
    @Get
    @Mapping("/flow/definition/copyDef/{id}")
    public CommonResult<Boolean> copyDef(@Path("id") Long id) {
        return CommonResult.data(defService.copyDef(id));
    }

    /**
     * 导入流程定义
     */
    @ApiOperation("导入流程定义")
    @Post
    @Mapping("/flow/definition/importDefinition")
    public CommonResult<Void> importDefinition(UploadedFile file) throws Exception {
        defService.importIs(file.getContent());
        return CommonResult.ok();
    }

    /**
     * 导出流程定义
     */
    @ApiOperation("导出流程定义")
    @Post
    @Mapping("/flow/definition/exportDefinition/{id}")
    public void exportDefinition(@Path("id") Long id, Context ctx) throws Exception {
        // 要导出的字符串
        String content = defService.exportJson(id);

        // 设置响应头
        ctx.headerSet("Content-Disposition", "attachment; filename=exported_string.txt");
        ctx.headerSet("Content-Type", "text/plain");

        // 返回响应
        ctx.output(content.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 激活流程
     *
     * @param definitionId
     * @return
     */
    @ApiOperation("激活流程")
    @Get
    @Mapping("/flow/definition/active/{definitionId}")
    public CommonResult<Boolean> active(@Path("definitionId") Long definitionId) {
        return CommonResult.data(defService.active(definitionId));
    }

    /**
     * 挂起流程
     *
     * @param definitionId
     * @return
     */
    @ApiOperation("挂起流程")
    @Get
    @Mapping("/flow/definition/unActive/{definitionId}")
    public CommonResult<Boolean> unActive(@Path("definitionId") Long definitionId) {
        return CommonResult.data(defService.unActive(definitionId));
    }
}
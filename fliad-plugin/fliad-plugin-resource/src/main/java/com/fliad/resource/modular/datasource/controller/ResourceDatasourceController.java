package com.fliad.resource.modular.datasource.controller;

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
import com.fliad.resource.modular.datasource.entity.ResourceDatasource;
import com.fliad.resource.modular.datasource.param.ResourceDatasourceAddParam;
import com.fliad.resource.modular.datasource.param.ResourceDatasourceEditParam;
import com.fliad.resource.modular.datasource.param.ResourceDatasourceIdParam;
import com.fliad.resource.modular.datasource.param.ResourceDatasourcePageParam;
import com.fliad.resource.modular.datasource.service.ResourceDatasourceService;

import java.util.List;

/**
 * 数据源控制器
 *
 * @author wyl
 * @date  2025/09/24 20:05
 */
@Api(tags = "数据源控制器")
@Controller
@Valid
public class ResourceDatasourceController {

    @Inject
    private ResourceDatasourceService datasourceService;

    /**
     * 获取数据源分页
     *
     * @author wyl
     * @date  2025/09/24 20:05
     */
    @ApiOperation("获取数据源分页")
    @SaCheckPermission("/resource/datasource/page")
    @Get
    @Mapping("/resource/datasource/page")
    public CommonResult<Page<ResourceDatasource>> page(ResourceDatasourcePageParam datasourcePageParam) {
        return CommonResult.data(datasourceService.page(datasourcePageParam));
    }

    /**
     * 添加数据源
     *
     * @author wyl
     * @date  2025/09/24 20:05
     */
    @ApiOperation("添加数据源")
    @CommonLog("添加数据源")
    @SaCheckPermission("/resource/datasource/add")
    @Post
    @Mapping("/resource/datasource/add")
    public CommonResult<String> add(ResourceDatasourceAddParam datasourceAddParam) {
        datasourceService.add(datasourceAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑数据源
     *
     * @author wyl
     * @date  2025/09/24 20:05
     */
    @ApiOperation("编辑数据源")
    @CommonLog("编辑数据源")
    @SaCheckPermission("/resource/datasource/edit")
    @Post
    @Mapping("/resource/datasource/edit")
    public CommonResult<String> edit(ResourceDatasourceEditParam datasourceEditParam) {
        datasourceService.edit(datasourceEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除数据源
     *
     * @author wyl
     * @date  2025/09/24 20:05
     */
    @ApiOperation("删除数据源")
    @CommonLog("删除数据源")
    @SaCheckPermission("/resource/datasource/delete")
    @Post
    @Mapping("/resource/datasource/delete")
    public CommonResult<String> delete(@NotEmpty(message = "集合不能为空")
                                                   CommonValidList<ResourceDatasourceIdParam> datasourceIdParamList) {
        datasourceService.delete(datasourceIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取数据源详情
     *
     * @author wyl
     * @date  2025/09/24 20:05
     */
    @ApiOperation("获取数据源详情")
    @SaCheckPermission("/resource/datasource/detail")
    @Get
    @Mapping("/resource/datasource/detail")
    public CommonResult<ResourceDatasource> detail(ResourceDatasourceIdParam datasourceIdParam) {
        return CommonResult.data(datasourceService.detail(datasourceIdParam));
    }

    @ApiOperation("禁用数据源")
    @Post
    @Mapping("/resource/datasource/disableDatasource")
    public CommonResult<String> disableDatasource(ResourceDatasourceIdParam datasourceIdParam) {
        datasourceService.disableDatasource(datasourceIdParam);
        return CommonResult.ok();
    }

    @ApiOperation("启用数据源")
    @Post
    @Mapping("/resource/datasource/enableDatasource")
    public CommonResult<String> enableDatasource(ResourceDatasourceIdParam datasourceIdParam) {
        datasourceService.enableDatasource(datasourceIdParam);
        return CommonResult.ok();
    }

    /**
     * 复制数据源
     *
     * @author wyl
     * @date 2025/09/26
     */
    @ApiOperation("复制数据源")
    @CommonLog("复制数据源")
    @SaCheckPermission("/resource/datasource/add")
    @Post
    @Mapping("/resource/datasource/copy")
    public CommonResult<String> copy(ResourceDatasourceIdParam datasourceIdParam) {
        datasourceService.copy(datasourceIdParam);
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
    @SaCheckPermission("/resource/datasource/add")
    @Post
    @Mapping("/resource/datasource/installTemplate")
    public CommonResult<String> installTemplate(ResourceDatasourceIdParam datasourceIdParam) {
        datasourceService.installTemplate(datasourceIdParam);
        return CommonResult.ok();
    }

    /**
     * 获取模板列表
     *
     * @author wyl
     * @date 2025/09/26
     */
    @ApiOperation("获取模板列表")
    @SaCheckPermission("/resource/datasource/page")
    @Get
    @Mapping("/resource/datasource/templateList")
    public CommonResult<List<ResourceDatasource>> templateList() {
        return CommonResult.data(datasourceService.listTemplates());
    }
    
    /**
     * 将数据源转换为模板
     *
     * @author wyl
     * @date 2025/11/01
     */
    @ApiOperation("将数据源转换为模板")
    @CommonLog("将数据源转换为模板")
    @SaCheckPermission("/resource/datasource/edit")
    @Post
    @Mapping("/resource/datasource/convertToTemplate")
    public CommonResult<String> convertToTemplate(ResourceDatasourceIdParam datasourceIdParam) {
        datasourceService.convertToTemplate(datasourceIdParam);
        return CommonResult.ok();
    }
}
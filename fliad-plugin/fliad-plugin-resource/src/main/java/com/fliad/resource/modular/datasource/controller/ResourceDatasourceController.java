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
    private ResourceDatasourceService viidDatasourceService;

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
    public CommonResult<Page<ResourceDatasource>> page(ResourceDatasourcePageParam viidDatasourcePageParam) {
        return CommonResult.data(viidDatasourceService.page(viidDatasourcePageParam));
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
    public CommonResult<String> add(ResourceDatasourceAddParam viidDatasourceAddParam) {
        viidDatasourceService.add(viidDatasourceAddParam);
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
    public CommonResult<String> edit(ResourceDatasourceEditParam viidDatasourceEditParam) {
        viidDatasourceService.edit(viidDatasourceEditParam);
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
                                                   CommonValidList<ResourceDatasourceIdParam> viidDatasourceIdParamList) {
        viidDatasourceService.delete(viidDatasourceIdParamList);
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
    public CommonResult<ResourceDatasource> detail(ResourceDatasourceIdParam viidDatasourceIdParam) {
        return CommonResult.data(viidDatasourceService.detail(viidDatasourceIdParam));
    }

    @ApiOperation("禁用数据源")
    @Post
    @Mapping("/resource/datasource/disableDatasource")
    public CommonResult<String> disableDatasource(ResourceDatasourceIdParam viidDatasourceIdParam) {
        viidDatasourceService.disableDatasource(viidDatasourceIdParam);
        return CommonResult.ok();
    }

    @ApiOperation("启用数据源")
    @Post
    @Mapping("/resource/datasource/enableDatasource")
    public CommonResult<String> enableDatasource(ResourceDatasourceIdParam viidDatasourceIdParam) {
        viidDatasourceService.enableDatasource(viidDatasourceIdParam);
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
    public CommonResult<String> copy(ResourceDatasourceIdParam viidDatasourceIdParam) {
        viidDatasourceService.copy(viidDatasourceIdParam);
        return CommonResult.ok();
    }

}
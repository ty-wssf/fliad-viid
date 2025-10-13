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
package com.fliad.viid.modular.datasource.controller;

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
import com.fliad.viid.modular.datasource.entity.ViidDatasource;
import com.fliad.viid.modular.datasource.param.ViidDatasourceAddParam;
import com.fliad.viid.modular.datasource.param.ViidDatasourceEditParam;
import com.fliad.viid.modular.datasource.param.ViidDatasourceIdParam;
import com.fliad.viid.modular.datasource.param.ViidDatasourcePageParam;
import com.fliad.viid.modular.datasource.service.ViidDatasourceService;

/**
 * 数据源控制器
 *
 * @author wyl
 * @date  2025/09/24 20:05
 */
@Api(tags = "数据源控制器")
@Controller
@Valid
public class ViidDatasourceController {

    @Inject
    private ViidDatasourceService viidDatasourceService;

    /**
     * 获取数据源分页
     *
     * @author wyl
     * @date  2025/09/24 20:05
     */
    @ApiOperation("获取数据源分页")
    @SaCheckPermission("/viid/datasource/page")
    @Get
    @Mapping("/viid/datasource/page")
    public CommonResult<Page<ViidDatasource>> page(ViidDatasourcePageParam viidDatasourcePageParam) {
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
    @SaCheckPermission("/viid/datasource/add")
    @Post
    @Mapping("/viid/datasource/add")
    public CommonResult<String> add(ViidDatasourceAddParam viidDatasourceAddParam) {
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
    @SaCheckPermission("/viid/datasource/edit")
    @Post
    @Mapping("/viid/datasource/edit")
    public CommonResult<String> edit(ViidDatasourceEditParam viidDatasourceEditParam) {
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
    @SaCheckPermission("/viid/datasource/delete")
    @Post
    @Mapping("/viid/datasource/delete")
    public CommonResult<String> delete(@NotEmpty(message = "集合不能为空")
                                                   CommonValidList<ViidDatasourceIdParam> viidDatasourceIdParamList) {
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
    @SaCheckPermission("/viid/datasource/detail")
    @Get
    @Mapping("/viid/datasource/detail")
    public CommonResult<ViidDatasource> detail(ViidDatasourceIdParam viidDatasourceIdParam) {
        return CommonResult.data(viidDatasourceService.detail(viidDatasourceIdParam));
    }

    @ApiOperation("禁用数据源")
    @Post
    @Mapping("/viid/datasource/disableDatasource")
    public CommonResult<String> disableDatasource(ViidDatasourceIdParam viidDatasourceIdParam) {
        viidDatasourceService.disableDatasource(viidDatasourceIdParam);
        return CommonResult.ok();
    }

    @ApiOperation("启用数据源")
    @Post
    @Mapping("/viid/datasource/enableDatasource")
    public CommonResult<String> enableDatasource(ViidDatasourceIdParam viidDatasourceIdParam) {
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
    @SaCheckPermission("/viid/datasource/add")
    @Post
    @Mapping("/viid/datasource/copy")
    public CommonResult<String> copy(ViidDatasourceIdParam viidDatasourceIdParam) {
        viidDatasourceService.copy(viidDatasourceIdParam);
        return CommonResult.ok();
    }

}
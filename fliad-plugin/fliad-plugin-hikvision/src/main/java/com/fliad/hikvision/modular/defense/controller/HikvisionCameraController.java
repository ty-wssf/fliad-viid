package com.fliad.hikvision.modular.defense.controller;

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
import com.fliad.hikvision.modular.defense.entity.HikvisionCamera;
import com.fliad.hikvision.modular.defense.param.HikvisionCameraAddParam;
import com.fliad.hikvision.modular.defense.param.HikvisionCameraEditParam;
import com.fliad.hikvision.modular.defense.param.HikvisionCameraIdParam;
import com.fliad.hikvision.modular.defense.param.HikvisionCameraPageParam;
import com.fliad.hikvision.modular.defense.service.HikvisionCameraService;

/**
 * 海康布防控制器
 *
 * @author wyl
 * @date 2025/09/27
 */
@Api(tags = "海康布防控制器")
@Controller
@Valid
public class HikvisionCameraController {

    @Inject
    private HikvisionCameraService hikvisionCameraService;

    /**
     * 获取海康布防分页
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("获取海康布防分页")
    @SaCheckPermission("/hikvision/defense/page")
    @Get
    @Mapping("/hikvision/defense/page")
    public CommonResult<Page<HikvisionCamera>> page(HikvisionCameraPageParam hikvisionCameraPageParam) {
        return CommonResult.data(hikvisionCameraService.page(hikvisionCameraPageParam));
    }

    /**
     * 添加海康布防
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("添加海康布防")
    @CommonLog("添加海康布防")
    @SaCheckPermission("/hikvision/defense/add")
    @Post
    @Mapping("/hikvision/defense/add")
    public CommonResult<String> add(HikvisionCameraAddParam hikvisionCameraAddParam) {
        hikvisionCameraService.add(hikvisionCameraAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑海康布防
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("编辑海康布防")
    @CommonLog("编辑海康布防")
    @SaCheckPermission("/hikvision/defense/edit")
    @Post
    @Mapping("/hikvision/defense/edit")
    public CommonResult<String> edit(HikvisionCameraEditParam hikvisionCameraEditParam) {
        hikvisionCameraService.edit(hikvisionCameraEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除海康布防
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("删除海康布防")
    @CommonLog("删除海康布防")
    @SaCheckPermission("/hikvision/defense/delete")
    @Post
    @Mapping("/hikvision/defense/delete")
    public CommonResult<String> delete(@NotEmpty(message = "集合不能为空")
                                                   CommonValidList<HikvisionCameraIdParam> hikvisionCameraIdParamList) {
        hikvisionCameraService.delete(hikvisionCameraIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取海康布防详情
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("获取海康布防详情")
    @SaCheckPermission("/hikvision/defense/detail")
    @Get
    @Mapping("/hikvision/defense/detail")
    public CommonResult<HikvisionCamera> detail(HikvisionCameraIdParam hikvisionCameraIdParam) {
        return CommonResult.data(hikvisionCameraService.detail(hikvisionCameraIdParam));
    }
}
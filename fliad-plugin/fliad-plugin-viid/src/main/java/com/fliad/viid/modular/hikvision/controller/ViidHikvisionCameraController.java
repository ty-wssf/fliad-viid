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
package com.fliad.viid.modular.hikvision.controller;

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
import com.fliad.viid.modular.hikvision.entity.ViidHikvisionCamera;
import com.fliad.viid.modular.hikvision.param.ViidHikvisionCameraAddParam;
import com.fliad.viid.modular.hikvision.param.ViidHikvisionCameraEditParam;
import com.fliad.viid.modular.hikvision.param.ViidHikvisionCameraIdParam;
import com.fliad.viid.modular.hikvision.param.ViidHikvisionCameraPageParam;
import com.fliad.viid.modular.hikvision.service.ViidHikvisionCameraService;

/**
 * 海康布防控制器
 *
 * @author yubaoshan
 * @date 2025/09/27
 */
@Api(tags = "海康布防控制器")
@Controller
@Valid
public class ViidHikvisionCameraController {

    @Inject
    private ViidHikvisionCameraService viidHikvisionCameraService;

    /**
     * 获取海康布防分页
     *
     * @author yubaoshan
     * @date 2025/09/27
     */
    @ApiOperation("获取海康布防分页")
    @SaCheckPermission("/viid/hikvision/defense/page")
    @Get
    @Mapping("/viid/hikvision/defense/page")
    public CommonResult<Page<ViidHikvisionCamera>> page(ViidHikvisionCameraPageParam viidHikvisionCameraPageParam) {
        return CommonResult.data(viidHikvisionCameraService.page(viidHikvisionCameraPageParam));
    }

    /**
     * 添加海康布防
     *
     * @author yubaoshan
     * @date 2025/09/27
     */
    @ApiOperation("添加海康布防")
    @CommonLog("添加海康布防")
    @SaCheckPermission("/viid/hikvision/defense/add")
    @Post
    @Mapping("/viid/hikvision/defense/add")
    public CommonResult<String> add(ViidHikvisionCameraAddParam viidHikvisionCameraAddParam) {
        viidHikvisionCameraService.add(viidHikvisionCameraAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑海康布防
     *
     * @author yubaoshan
     * @date 2025/09/27
     */
    @ApiOperation("编辑海康布防")
    @CommonLog("编辑海康布防")
    @SaCheckPermission("/viid/hikvision/defense/edit")
    @Post
    @Mapping("/viid/hikvision/defense/edit")
    public CommonResult<String> edit(ViidHikvisionCameraEditParam viidHikvisionCameraEditParam) {
        viidHikvisionCameraService.edit(viidHikvisionCameraEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除海康布防
     *
     * @author yubaoshan
     * @date 2025/09/27
     */
    @ApiOperation("删除海康布防")
    @CommonLog("删除海康布防")
    @SaCheckPermission("/viid/hikvision/defense/delete")
    @Post
    @Mapping("/viid/hikvision/defense/delete")
    public CommonResult<String> delete(@NotEmpty(message = "集合不能为空")
                                                   CommonValidList<ViidHikvisionCameraIdParam> viidHikvisionCameraIdParamList) {
        viidHikvisionCameraService.delete(viidHikvisionCameraIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取海康布防详情
     *
     * @author yubaoshan
     * @date 2025/09/27
     */
    @ApiOperation("获取海康布防详情")
    @SaCheckPermission("/viid/hikvision/defense/detail")
    @Get
    @Mapping("/viid/hikvision/defense/detail")
    public CommonResult<ViidHikvisionCamera> detail(ViidHikvisionCameraIdParam viidHikvisionCameraIdParam) {
        return CommonResult.data(viidHikvisionCameraService.detail(viidHikvisionCameraIdParam));
    }
}
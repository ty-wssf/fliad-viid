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
package com.fliad.viid.modular.tollgate.controller;

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
import com.fliad.viid.modular.tollgate.entity.ViidTollgate;
import com.fliad.viid.modular.tollgate.param.ViidTollgateAddParam;
import com.fliad.viid.modular.tollgate.param.ViidTollgateEditParam;
import com.fliad.viid.modular.tollgate.param.ViidTollgateIdParam;
import com.fliad.viid.modular.tollgate.param.ViidTollgatePageParam;
import com.fliad.viid.modular.tollgate.service.ViidTollgateService;

import java.util.List;

/**
 * 视频卡口控制器
 *
 * @author wyl
 * @date  2025/09/19
 */
@Api(tags = "视频卡口控制器")
@Controller
@Valid
public class ViidTollgateController {

    @Inject
    private ViidTollgateService viidTollgateService;

    /**
     * 获取视频卡口分页
     *
     * @author wyl
     * @date  2025/09/19
     */
    @ApiOperation("获取视频卡口分页")
    @SaCheckPermission("/viid/tollgate/page")
    @Get
    @Mapping("/viid/tollgate/page")
    public CommonResult<Page<ViidTollgate>> page(ViidTollgatePageParam viidTollgatePageParam) {
        return CommonResult.data(viidTollgateService.page(viidTollgatePageParam));
    }

    /**
     * 添加视频卡口
     *
     * @author wyl
     * @date  2025/09/19
     */
    @ApiOperation("添加视频卡口")
    @CommonLog("添加视频卡口")
    @SaCheckPermission("/viid/tollgate/add")
    @Post
    @Mapping("/viid/tollgate/add")
    public CommonResult<String> add(ViidTollgateAddParam viidTollgateAddParam) {
        viidTollgateService.add(viidTollgateAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑视频卡口
     *
     * @author wyl
     * @date  2025/09/19
     */
    @ApiOperation("编辑视频卡口")
    @CommonLog("编辑视频卡口")
    @SaCheckPermission("/viid/tollgate/edit")
    @Post
    @Mapping("/viid/tollgate/edit")
    public CommonResult<String> edit(ViidTollgateEditParam viidTollgateEditParam) {
        viidTollgateService.edit(viidTollgateEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除视频卡口
     *
     * @author wyl
     * @date  2025/09/19
     */
    @ApiOperation("删除视频卡口")
    @CommonLog("删除视频卡口")
    @SaCheckPermission("/viid/tollgate/delete")
    @Post
    @Mapping("/viid/tollgate/delete")
    public CommonResult<String> delete(@NotEmpty(message = "集合不能为空")
                                       CommonValidList<ViidTollgateIdParam> viidTollgateIdParamList) {
        viidTollgateService.delete(viidTollgateIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取视频卡口详情
     *
     * @author wyl
     * @date  2025/09/19
     */
    @ApiOperation("获取视频卡口详情")
    @SaCheckPermission("/viid/tollgate/detail")
    @Get
    @Mapping("/viid/tollgate/detail")
    public CommonResult<ViidTollgate> detail(ViidTollgateIdParam viidTollgateIdParam) {
        return CommonResult.data(viidTollgateService.detail(viidTollgateIdParam));
    }
}
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
package com.fliad.viid.modular.cascadeplatform.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.util.StrUtil;
import com.fliad.viid.modular.subscribe.utils.ViidHttpUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.NotEmpty;
import org.noear.solon.validation.annotation.Valid;
import com.fliad.common.annotation.CommonLog;
import com.fliad.common.pojo.CommonResult;
import com.fliad.common.pojo.CommonValidList;
import com.fliad.viid.modular.cascadeplatform.entity.ViidCascadePlatform;
import com.fliad.viid.modular.cascadeplatform.param.ViidCascadePlatformAddParam;
import com.fliad.viid.modular.cascadeplatform.param.ViidCascadePlatformEditParam;
import com.fliad.viid.modular.cascadeplatform.param.ViidCascadePlatformIdParam;
import com.fliad.viid.modular.cascadeplatform.param.ViidCascadePlatformPageParam;
import com.fliad.viid.modular.cascadeplatform.service.ViidCascadePlatformService;

import java.util.List;

/**
 * 视图库控制器
 *
 * @author wyl
 * @date 2025/08/14 16:24
 */
@Api(tags = "视图库控制器")
@Controller
@Valid
public class ViidCascadePlatformController {

    @Inject
    private ViidCascadePlatformService viidCascadePlatformService;

    /**
     * 获取视图库分页
     *
     * @author wyl
     * @date 2025/08/14 16:24
     */
    @ApiOperation("获取视图库分页")
    @SaCheckPermission("/viid/cascadeplatform/page")
    @Get
    @Mapping("/viid/cascadeplatform/page")
    public CommonResult<Page<ViidCascadePlatform>> page(ViidCascadePlatformPageParam viidCascadePlatformPageParam) {
        return CommonResult.data(viidCascadePlatformService.page(viidCascadePlatformPageParam));
    }

    @ApiOperation("视图库列表")
    @Get
    @Mapping("/viid/cascadeplatform/list")
    public CommonResult<List<ViidCascadePlatform>> list(String type) {
        return CommonResult.data(viidCascadePlatformService.list(QueryWrapper.create().eq(ViidCascadePlatform::getType, type, StrUtil.isNotBlank(type))));
    }

    /**
     * 添加视图库
     *
     * @author wyl
     * @date 2025/08/14 16:24
     */
    @ApiOperation("添加视图库")
    @CommonLog("添加视图库")
    @SaCheckPermission("/viid/cascadeplatform/add")
    @Post
    @Mapping("/viid/cascadeplatform/add")
    public CommonResult<String> add(ViidCascadePlatformAddParam viidCascadePlatformAddParam) {
        viidCascadePlatformService.add(viidCascadePlatformAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑视图库
     *
     * @author wyl
     * @date 2025/08/14 16:24
     */
    @ApiOperation("编辑视图库")
    @CommonLog("编辑视图库")
    @SaCheckPermission("/viid/cascadeplatform/edit")
    @Post
    @Mapping("/viid/cascadeplatform/edit")
    public CommonResult<String> edit(ViidCascadePlatformEditParam viidCascadePlatformEditParam) {
        viidCascadePlatformService.edit(viidCascadePlatformEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除视图库
     *
     * @author wyl
     * @date 2025/08/14 16:24
     */
    @ApiOperation("删除视图库")
    @CommonLog("删除视图库")
    @SaCheckPermission("/viid/cascadeplatform/delete")
    @Post
    @Mapping("/viid/cascadeplatform/delete")
    public CommonResult<String> delete(@NotEmpty(message = "集合不能为空")
                                       CommonValidList<ViidCascadePlatformIdParam> viidCascadePlatformIdParamList) {
        viidCascadePlatformService.delete(viidCascadePlatformIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取视图库详情
     *
     * @author wyl
     * @date 2025/08/14 16:24
     */
    @ApiOperation("获取视图库详情")
    @SaCheckPermission("/viid/cascadeplatform/detail")
    @Get
    @Mapping("/viid/cascadeplatform/detail")
    public CommonResult<ViidCascadePlatform> detail(ViidCascadePlatformIdParam viidCascadePlatformIdParam) {
        return CommonResult.data(viidCascadePlatformService.detail(viidCascadePlatformIdParam));
    }

    /**
     * 手动向上级平台注册
     *
     * @param systemid
     * @return
     */
    @ApiOperation("手动向上级平台注册")
    @Post
    @Mapping("/viid/cascadeplatform/registerSend")
    public CommonResult<String> registerSend(String systemid) {
        ViidCascadePlatform cascadePlatform = viidCascadePlatformService.getOne(QueryWrapper.create()
                .eq(ViidCascadePlatform::getSystemId, systemid)
                .eq(ViidCascadePlatform::getType, "0")
        );
        if (cascadePlatform != null) {
            if (ViidHttpUtil.registerSend(cascadePlatform)) {
                return CommonResult.ok("注册成功");
            }
            return CommonResult.error("注册时发生错误");
        }
        return CommonResult.error("未找到上级平台信息");
    }

    /**
     * 手动向上级平台注销
     *
     * @param systemid
     * @return
     */
    @ApiOperation("手动向上级平台注销")
    @Post
    @Mapping("/viid/cascadeplatform/unregisterSend")
    public CommonResult<String> unregisterSend(String systemid) {
        ViidCascadePlatform cascadePlatform = viidCascadePlatformService.getOne(QueryWrapper.create()
                .eq(ViidCascadePlatform::getSystemId, systemid)
                .eq(ViidCascadePlatform::getType, "0")
        );
        if (cascadePlatform != null) {
            if (ViidHttpUtil.unregisterSend(cascadePlatform)) {
                return CommonResult.ok("注销成功");
            }
            return CommonResult.error("注销时发生错误");
        }
        return CommonResult.error("未找到上级平台信息");
    }

}

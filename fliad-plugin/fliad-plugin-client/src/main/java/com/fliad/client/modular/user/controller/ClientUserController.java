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
package com.fliad.client.modular.user.controller;

import com.mybatisflex.core.paginate.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.NotEmpty;
import org.noear.solon.validation.annotation.Valid;
import org.noear.solon.validation.annotation.Validated;
import com.fliad.client.modular.user.entity.ClientUser;
import com.fliad.client.modular.user.param.ClientUserAddParam;
import com.fliad.client.modular.user.param.ClientUserEditParam;
import com.fliad.client.modular.user.param.ClientUserIdParam;
import com.fliad.client.modular.user.param.ClientUserPageParam;
import com.fliad.client.modular.user.service.ClientUserService;
import com.fliad.common.annotation.CommonLog;
import com.fliad.common.pojo.CommonResult;
import com.fliad.common.pojo.CommonValidList;


/**
 * C端用户控制器
 *
 * @author xuyuxiang
 * @date 2022/4/22 9:34
 **/
@Api(tags = "C端用户控制器")
@Controller
@Valid
public class ClientUserController {

    @Inject
    private ClientUserService clientUserService;

    /**
     * 获取C端用户分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取C端用户分页")
    @Get
    @Mapping("/client/user/page")
    public CommonResult<Page<ClientUser>> page(ClientUserPageParam clientUserPageParam) {
        return CommonResult.data(clientUserService.page(clientUserPageParam));
    }

    /**
     * 添加C端用户
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("添加C端用户")
    @CommonLog("添加C端用户")
    @Post
    @Mapping("/client/user/add")
    public CommonResult<String> add(@Validated ClientUserAddParam clientUserAddParam) {
        clientUserService.add(clientUserAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑C端用户
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("编辑C端用户")
    @CommonLog("编辑C端用户")
    @Post
    @Mapping("/client/user/edit")
    public CommonResult<String> edit(@Validated ClientUserEditParam clientUserEditParam) {
        clientUserService.edit(clientUserEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除C端用户
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("删除C端用户")
    @CommonLog("删除C端用户")
    @Post
    @Mapping("/client/user/delete")
    public CommonResult<String> delete(@Validated @NotEmpty(message = "集合不能为空")
                                                   CommonValidList<ClientUserIdParam> clientUserIdParamList) {
        clientUserService.delete(clientUserIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取C端用户详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取C端用户详情")
    @Get
    @Mapping("/client/user/detail")
    public CommonResult<ClientUser> detail(@Validated ClientUserIdParam clientUserIdParam) {
        return CommonResult.data(clientUserService.detail(clientUserIdParam));
    }
}

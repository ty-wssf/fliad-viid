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
package com.fliad.dev.modular.message.controller;

import com.mybatisflex.core.paginate.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.NotEmpty;
import org.noear.solon.validation.annotation.Valid;
import org.noear.solon.validation.annotation.Validated;
import com.fliad.common.annotation.CommonLog;
import com.fliad.common.pojo.CommonResult;
import com.fliad.common.pojo.CommonValidList;
import com.fliad.dev.modular.message.entity.DevMessage;
import com.fliad.dev.modular.message.param.DevMessageIdParam;
import com.fliad.dev.modular.message.param.DevMessagePageParam;
import com.fliad.dev.modular.message.param.DevMessageSendParam;
import com.fliad.dev.modular.message.result.DevMessageResult;
import com.fliad.dev.modular.message.service.DevMessageService;


/**
 * 站内信控制器
 *
 * @author xuyuxiang
 * @date 2022/6/21 14:57
 **/
@Api(tags = "站内信控制器")
@Controller
@Valid
public class DevMessageController {

    @Inject
    private DevMessageService devMessageService;

    /**
     * 发送站内信
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:47
     */
    @ApiOperation("发送站内信")
    @CommonLog("发送站内信")
    @Post
    @Mapping("/dev/message/send")
    public CommonResult<String> send(@Validated DevMessageSendParam devMessageSendParam) {
        devMessageService.send(devMessageSendParam);
        return CommonResult.ok();
    }

    /**
     * 获取站内信分页
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取站内信分页")
    @Get
    @Mapping("/dev/message/page")
    public CommonResult<Page<DevMessage>> page(DevMessagePageParam devMessagePageParam) {
        return CommonResult.data(devMessageService.page(devMessagePageParam));
    }

    /**
     * 删除站内信
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("删除站内信")
    @CommonLog("删除站内信")
    @Post@Mapping("/dev/message/delete")
    public CommonResult<String> delete(@Validated @NotEmpty(message = "集合不能为空")
                                               CommonValidList<DevMessageIdParam> devMessageIdParamList) {
        devMessageService.delete(devMessageIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取站内信详情
     *
     * @author xuyuxiang
     * @date 2022/4/24 20:00
     */
    @ApiOperation("获取站内信详情")
    @Get@Mapping("/dev/message/detail")
    public CommonResult<DevMessageResult> detail(@Validated DevMessageIdParam devMessageIdParam) {
        return CommonResult.data(devMessageService.detail(devMessageIdParam));
    }
}

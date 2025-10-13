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
package com.fliad.common.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.ContentType;
import cn.hutool.json.JSONUtil;
import org.noear.solon.core.handle.Context;
import com.fliad.common.pojo.CommonResult;

import java.io.IOException;

/**
 * 通用响应工具类
 *
 * @author xuyuxiang
 * @date 2022/8/4 9:40
 **/
public class CommonResponseUtil {

    /**
     * 以流的方式响应错误信息，默认错误消息
     *
     * @author xuyuxiang
     * @date 2022/8/4 9:41
     **/
    public static void renderError(Context ctx) throws IOException {
        renderError(ctx, null);
    }

    /**
     * 以流的方式响应错误信息，指定错误消息
     *
     * @author xuyuxiang
     * @date 2022/8/4 9:41
     **/
    public static void renderError(Context ctx, String msg) throws IOException {
        ctx.charset(CharsetUtil.UTF_8);
        ctx.contentType(ContentType.JSON.toString());
        String json = JSONUtil.toJsonStr(ObjectUtil.isNotEmpty(msg)?CommonResult.error(msg):CommonResult.error());
        ctx.outputAsJson(json);
    }

    /**
     * 以流的方式响应错误信息，指定错误码和错误消息
     *
     * @author xuyuxiang
     * @date 2022/8/4 9:41
     **/
    public static void renderError(Context ctx, Integer code, String msg) throws IOException {
        ctx.charset(CharsetUtil.UTF_8);
        ctx.contentType(ContentType.JSON.toString());
        String json = JSONUtil.toJsonStr(CommonResult.get(code, msg, null));
        ctx.outputAsJson(json);
    }
}

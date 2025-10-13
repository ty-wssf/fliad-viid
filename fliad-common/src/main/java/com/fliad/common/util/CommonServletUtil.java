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

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.core.handle.Context;
import com.fliad.common.exception.CommonException;

/**
 * HttpServlet工具类，获取当前request和response
 *
 * @author xuyuxiang
 * @date 2020/3/30 15:09
 */
@Slf4j
public class CommonServletUtil {

    /**
     * 从请求中中获取参数
     *
     * @author xuyuxiang
     * @date 2021/10/14 10:44
     **/
    public static String getParamFromRequest(String paramName) {
        Context request = getRequest();

        // 1. 尝试从请求体里面读取
        String paramValue = request.param(paramName);

        // 2. 尝试从header里读取
        if (ObjectUtil.isEmpty(paramValue)) {
            paramValue = request.header(paramName);
        }
        // 3. 尝试从cookie里读取
        if (ObjectUtil.isEmpty(paramValue)) {
            paramValue = request.cookie(paramName);
        }
        // 4. 返回
        return paramValue;
    }

    public static Context getRequest() {
        Context context;
        try {
            context = Context.current();
        } catch (Exception e) {
            log.error(">>> 非Web上下文无法获取Request：", e);
            throw new CommonException("非Web上下文无法获取Request");
        }
        if (context == null) {
            throw new CommonException("非Web上下文无法获取Request");
        } else {
            return context;
        }
    }

    public static boolean isWeb() {
        return Context.current() != null;
    }
}

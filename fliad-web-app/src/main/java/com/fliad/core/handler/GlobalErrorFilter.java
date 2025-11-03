package com.fliad.core.handler;

import com.fliad.common.util.CommonServletUtil;
import io.nop.api.core.exceptions.NopException;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.exception.StatusException;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;
import org.noear.solon.validation.ValidatorException;
import com.fliad.common.exception.CommonException;
import com.fliad.common.pojo.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author noear 2022/10/4 created
 */
@Component
public class GlobalErrorFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(GlobalErrorFilter.class);

    @Override
    public void doFilter(Context ctx, FilterChain chain) throws Throwable {
        try {
            chain.doFilter(ctx);
        } catch (CommonException e) {
            ctx.render(CommonResult.error(e.getMsg()));
        } catch (ValidatorException e) {
            //验证器异常
            ctx.render(CommonResult.error(e.getMessage()));
        } catch (StatusException e) {
            //4xx 状态类异常
            log.error(">>> 状态类异常，请求地址：{}，具体信息：", CommonServletUtil.getRequest().url(), e);
            ctx.status(e.getCode());
        } catch (NopException e) {
            log.error(">>> 状态类异常，请求地址：{}，具体信息：", CommonServletUtil.getRequest().url(), e);
            ctx.render(CommonResult.error(e.getMessage()));
        } catch (Throwable e) {
            log.error("", e);
            if (e instanceof Exception) {
                CommonResult<String> rst = GlobalExceptionUtil.getCommonResult((Exception) e);
                ctx.render(rst);
            } else {
                ctx.render(CommonResult.error("服务器异常"));
            }
        }
    }
}

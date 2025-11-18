package com.fliad.dev.core.aop;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import org.noear.solon.core.aspect.Interceptor;
import org.noear.solon.core.aspect.Invocation;
import com.fliad.auth.core.pojo.SaBaseLoginUser;
import com.fliad.auth.core.util.StpLoginUserUtil;
import com.fliad.common.annotation.CommonLog;
import com.fliad.common.exception.CommonException;
import com.fliad.dev.modular.log.util.DevLogUtil;

/**
 * @author noear 2022/10/21 created
 */
public class DevLogInterceptor implements Interceptor {
    @Override
    public Object doIntercept(Invocation inv) throws Throwable {
        CommonLog commonLog = inv.method().getAnnotation(CommonLog.class);

        Object result = null;

        try {
            result = inv.invoke();

            String userName = "未知";
            try {
                SaBaseLoginUser loginUser = StpLoginUserUtil.getLoginUser();
                if (ObjectUtil.isNotNull(loginUser)) {
                    userName = loginUser.getName();
                }
            } catch (Exception ignored) {
            }
            // 异步记录日志
            DevLogUtil.executeOperationLog(commonLog, userName, inv, JSONUtil.toJsonStr(result));

        } catch (CommonException e) {
            String userName = "未知";
            try {
                SaBaseLoginUser loginUser = StpLoginUserUtil.getLoginUser();
                if (ObjectUtil.isNotNull(loginUser)) {
                    userName = loginUser.getName();
                }
            } catch (Exception ignored) {
            }
            //异步记录日志
            DevLogUtil.executeExceptionLog(commonLog, userName, inv, e);
            throw new CommonException(e.getMsg());
        }

        return result;
    }
}

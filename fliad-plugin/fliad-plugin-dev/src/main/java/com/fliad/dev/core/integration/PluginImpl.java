package com.fliad.dev.core.integration;

import org.noear.solon.core.AppContext;
import org.noear.solon.core.Plugin;
import com.fliad.common.annotation.CommonLog;
import com.fliad.dev.core.aop.DevLogInterceptor;

/**
 * @author noear 2022/10/21 created
 */
public class PluginImpl implements Plugin {
    @Override
    public void start(AppContext context) {
        context.beanInterceptorAdd(CommonLog.class, new DevLogInterceptor());
    }
}

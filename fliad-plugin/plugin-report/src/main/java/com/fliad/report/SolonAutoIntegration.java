package com.fliad.report;

import com.fliad.report.service.SolonBeanContainer;
import io.nop.api.core.ioc.BeanContainer;
import io.nop.core.initialize.CoreInitialization;
import org.noear.solon.core.AppContext;
import org.noear.solon.core.Plugin;

/**
 * @author wyl
 * @date 2025年10月25日 17:01
 */
public class SolonAutoIntegration implements Plugin {

    @Override
    public void start(AppContext context) throws Throwable {
        BeanContainer.registerInstance(new SolonBeanContainer(context));
        CoreInitialization.initialize();
    }

    @Override
    public void stop() throws Throwable {
        CoreInitialization.destroy();
    }

}

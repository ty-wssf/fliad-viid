package com.fliad.report;

import com.fliad.report.service.SolonInitializer;
import org.noear.solon.core.AppContext;
import org.noear.solon.core.Plugin;

/**
 * @author wyl
 * @date 2025年10月25日 17:01
 */
public class SolonAutoIntegration implements Plugin {

    @Override
    public void start(AppContext context) throws Throwable {
        context.beanMake(SolonInitializer.class);
    }

}

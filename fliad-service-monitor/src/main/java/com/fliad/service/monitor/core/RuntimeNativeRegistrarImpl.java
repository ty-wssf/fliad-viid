package com.fliad.service.monitor.core;

import org.noear.solon.annotation.Component;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.aot.hint.MemberCategory;
import org.noear.solon.core.AppContext;


@Component
public class RuntimeNativeRegistrarImpl implements RuntimeNativeRegistrar {

    @Override
    public void register(AppContext context, RuntimeNativeMetadata metadata) {
        metadata.registerReflection(SimpleServiceMonitor.ServiceConfig.class, MemberCategory.values());
    }

}

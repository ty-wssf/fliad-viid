package com.fliad.report.core.config;

import io.nop.excel.imp.model.ImportModel;
import io.nop.report.core.build.XptModelLoader;
import org.noear.solon.annotation.Component;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.aot.hint.MemberCategory;
import org.noear.solon.core.AppContext;


@Component
public class RuntimeNativeRegistrarImpl implements RuntimeNativeRegistrar {

    @Override
    public void register(AppContext context, RuntimeNativeMetadata metadata) {
        metadata.registerReflection(XptModelLoader.class, MemberCategory.values());
        metadata.registerReflection(ImportModel.class, MemberCategory.values());
    }

}

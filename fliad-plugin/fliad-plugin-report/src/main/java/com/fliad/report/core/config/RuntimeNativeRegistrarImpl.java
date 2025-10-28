package com.fliad.report.core.config;

import io.nop.excel.imp.model.ImportModel;
import io.nop.excel.imp.model.ImportSheetModel;
import io.nop.report.core.build.XptModelLoader;
import org.noear.solon.annotation.Component;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.aot.hint.MemberCategory;
import org.noear.solon.core.AppContext;
import org.noear.solon.core.util.ClassUtil;
import org.noear.solon.core.util.ScanUtil;


@Component
public class RuntimeNativeRegistrarImpl implements RuntimeNativeRegistrar {

    @Override
    public void register(AppContext context, RuntimeNativeMetadata metadata) {
        /*metadata.registerReflection(XptModelLoader.class, MemberCategory.values());
        metadata.registerReflection(ImportModel.class, MemberCategory.values());
        metadata.registerReflection(ImportSheetModel.class, MemberCategory.values());*/
        ScanUtil.scan(context.getClassLoader(), "io/nop", n -> n.endsWith(".class"))
                .forEach(name -> {
                    String className = name.substring(0, name.length() - 6);
                    className = className.replace('/', '.');
                    Class<?> clz = ClassUtil.loadClass(context.getClassLoader(), className);
                    if (clz != null && clz != Object.class && !clz.isInterface()) {
                        metadata.registerReflection(clz, MemberCategory.values());
                    }
                });
    }

}

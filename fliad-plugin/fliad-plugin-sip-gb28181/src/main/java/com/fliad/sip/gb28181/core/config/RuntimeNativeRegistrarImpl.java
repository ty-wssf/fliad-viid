package com.fliad.sip.gb28181.core.config;

import gov.nist.javax.sip.SipStackImpl;
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
        metadata.registerReflection(SipStackImpl.class, MemberCategory.values());
        metadata.registerReflection(gov.nist.core.LogWriter.class, MemberCategory.values());
        metadata.registerReflection(gov.nist.javax.sip.stack.ServerLog.class, MemberCategory.values());
        metadata.registerReflection(gov.nist.javax.sip.stack.DefaultRouter.class, MemberCategory.values());
        ScanUtil.scan(context.getClassLoader(), "gov/nist", n -> n.endsWith(".class")).forEach(name -> {
            String className = name.substring(0, name.length() - 6);
            className = className.replace('/', '.');
            Class<?> clz = ClassUtil.loadClass(context.getClassLoader(), className);
            if (clz != null && !clz.isInterface() && !clz.isAnnotation() && !clz.isEnum() && !clz.isSynthetic() && !clz.isArray() && !clz.isPrimitive()) {
                metadata.registerReflection(clz, MemberCategory.values());
            }
        });
    }

}

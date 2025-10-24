package com.fliad.sip.gb28181.core.config;

import gov.nist.javax.sip.SipStackImpl;
import org.noear.solon.annotation.Component;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.aot.hint.MemberCategory;
import org.noear.solon.core.AppContext;

@Component
public class RuntimeNativeRegistrarImpl implements RuntimeNativeRegistrar {

    @Override
    public void register(AppContext context, RuntimeNativeMetadata metadata) {
        metadata.registerReflection(SipStackImpl.class, MemberCategory.values());

    }

}

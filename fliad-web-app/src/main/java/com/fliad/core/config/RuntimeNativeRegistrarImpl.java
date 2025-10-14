package com.fliad.core.config;

import com.github.xiaoymin.knife4j.solon.settings.OpenApiBasicAuth;
import com.github.xiaoymin.knife4j.solon.settings.OpenApiExtendSetting;
import com.github.xiaoymin.knife4j.solon.settings.OpenApiSetting;
import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.core.provider.EntitySqlProvider;
import com.mybatisflex.solon.MybatisFlexProperties;
import org.beetl.core.engine.FastRuntimeEngine;
import org.noear.solon.annotation.Component;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.aot.hint.MemberCategory;
import org.noear.solon.core.AppContext;
import org.noear.solon.serialization.prop.JsonProps;

@Component
public class RuntimeNativeRegistrarImpl implements RuntimeNativeRegistrar {

    @Override
    public void register(AppContext context, RuntimeNativeMetadata metadata) {
        metadata.registerReflection(OpenApiSetting.class,  MemberCategory.values());
        metadata.registerReflection(OpenApiExtendSetting.class,  MemberCategory.values());
        metadata.registerReflection(OpenApiBasicAuth.class,  MemberCategory.values());
        metadata.registerReflection(JsonProps.class,  MemberCategory.values());
        metadata.registerReflection(MybatisFlexProperties.class,  MemberCategory.values());
        metadata.registerReflection(MybatisFlexProperties.CoreConfiguration.class,  MemberCategory.values());
        metadata.registerReflection(MybatisFlexProperties.GlobalConfig.class,  MemberCategory.values());
        metadata.registerReflection(MybatisFlexProperties.AdminConfig.class,  MemberCategory.values());
        metadata.registerReflection(MybatisFlexProperties.SeataConfig.class,  MemberCategory.values());
        metadata.registerReflection(MybatisFlexProperties.SeataMode.class,  MemberCategory.values());
        metadata.registerReflection(FlexGlobalConfig.class,  MemberCategory.values());
        metadata.registerReflection(FlexGlobalConfig.KeyConfig.class,  MemberCategory.values());
        metadata.registerReflection(FastRuntimeEngine.class,  MemberCategory.values());
        metadata.registerReflection(EntitySqlProvider.class,  MemberCategory.values());
    }

}

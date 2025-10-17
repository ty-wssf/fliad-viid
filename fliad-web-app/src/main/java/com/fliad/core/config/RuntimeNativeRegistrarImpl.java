package com.fliad.core.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.json.JSONConverter;
import com.fliad.auth.core.pojo.SaBaseClientLoginUser;
import com.fliad.auth.core.pojo.SaBaseLoginUser;
import com.fliad.auth.modular.login.service.impl.AuthServiceImpl;
import com.fliad.auth.modular.third.service.impl.AuthThirdServiceImpl;
import com.fliad.biz.modular.dict.service.impl.BizDictServiceImpl;
import com.fliad.biz.modular.index.service.impl.BizIndexServiceImpl;
import com.fliad.biz.modular.org.service.impl.BizOrgServiceImpl;
import com.fliad.biz.modular.position.service.impl.BizPositionServiceImpl;
import com.fliad.biz.modular.user.service.impl.BizUserServiceImpl;
import com.fliad.dev.core.listener.DevJobListener;
import com.fliad.dev.modular.config.service.impl.DevConfigServiceImpl;
import com.fliad.dev.modular.dict.service.impl.DevDictServiceImpl;
import com.fliad.dev.modular.job.service.impl.DevJobServiceImpl;
import com.fliad.dev.modular.log.provider.DevLogApiProvider;
import com.fliad.dev.modular.log.service.impl.DevLogServiceImpl;
import com.fliad.dev.modular.relation.service.impl.DevRelationServiceImpl;
import com.fliad.dev.modular.slideshow.service.impl.DevSlideshowServiceImpl;
import com.fliad.mobile.modular.resource.service.impl.MobileMenuServiceImpl;
import com.fliad.mobile.modular.resource.service.impl.MobileModuleServiceImpl;
import com.fliad.sys.modular.group.service.impl.SysGroupServiceImpl;
import com.fliad.sys.modular.index.service.impl.SysIndexServiceImpl;
import com.fliad.sys.modular.org.service.impl.SysOrgServiceImpl;
import com.fliad.sys.modular.position.service.impl.SysPositionServiceImpl;
import com.fliad.sys.modular.relation.service.impl.SysRelationServiceImpl;
import com.fliad.sys.modular.resource.service.impl.SysMenuServiceImpl;
import com.fliad.sys.modular.resource.service.impl.SysModuleServiceImpl;
import com.fliad.sys.modular.role.service.impl.SysRoleServiceImpl;
import com.fliad.sys.modular.user.service.impl.SysUserServiceImpl;
import com.fliad.viid.modular.ape.service.impl.ViidApeServiceImpl;
import com.fliad.viid.modular.cascadeplatform.service.impl.ViidCascadePlatformServiceImpl;
import com.fliad.viid.modular.cascadeplatform.service.impl.ViidPlatformStatusServiceImpl;
import com.fliad.viid.modular.cascadeplatform.service.impl.ViidSystemServiceImpl;
import com.fliad.viid.modular.datasource.service.impl.ViidDatasourceServiceImpl;
import com.fliad.viid.modular.subscribe.service.impl.ViidSubscribeServiceImpl;
import com.fliad.viid.modular.tollgate.service.impl.ViidTollgateServiceImpl;
import com.fliad.viid.modular.workflow.service.impl.ViidWorkflowServiceImpl;
import com.github.xiaoymin.knife4j.solon.settings.OpenApiBasicAuth;
import com.github.xiaoymin.knife4j.solon.settings.OpenApiExtendSetting;
import com.github.xiaoymin.knife4j.solon.settings.OpenApiSetting;
import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.core.provider.EntitySqlProvider;
import com.mybatisflex.core.provider.RowSqlProvider;
import com.mybatisflex.solon.MybatisFlexProperties;
import org.h2.server.TcpServer;
import org.noear.solon.annotation.Component;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.aot.hint.MemberCategory;
import org.noear.solon.core.AppContext;
import org.noear.solon.core.util.ClassUtil;
import org.noear.solon.core.util.ScanUtil;
import org.noear.solon.serialization.prop.JsonProps;

import java.lang.reflect.Method;

@Component
public class RuntimeNativeRegistrarImpl implements RuntimeNativeRegistrar {

    @Override
    public void register(AppContext context, RuntimeNativeMetadata metadata) {
        metadata.registerReflection(OpenApiSetting.class, MemberCategory.values());
        metadata.registerReflection(OpenApiExtendSetting.class, MemberCategory.values());
        metadata.registerReflection(OpenApiBasicAuth.class, MemberCategory.values());
        metadata.registerReflection(JsonProps.class, MemberCategory.values());
        metadata.registerReflection(MybatisFlexProperties.class, MemberCategory.values());
        metadata.registerReflection(MybatisFlexProperties.CoreConfiguration.class, MemberCategory.values());
        metadata.registerReflection(MybatisFlexProperties.GlobalConfig.class, MemberCategory.values());
        metadata.registerReflection(MybatisFlexProperties.AdminConfig.class, MemberCategory.values());
        metadata.registerReflection(MybatisFlexProperties.SeataConfig.class, MemberCategory.values());
        metadata.registerReflection(MybatisFlexProperties.SeataMode.class, MemberCategory.values());
        metadata.registerReflection(FlexGlobalConfig.class, MemberCategory.values());
        metadata.registerReflection(FlexGlobalConfig.KeyConfig.class, MemberCategory.values());
        metadata.registerReflection(EntitySqlProvider.class, MemberCategory.values());
        metadata.registerReflection(RowSqlProvider.class, MemberCategory.values());
        metadata.registerReflection(TcpServer.class, MemberCategory.values());
        metadata.registerReflection(JSONConverter.class, MemberCategory.values());
        metadata.registerReflection(Snowflake.class, MemberCategory.values());

        //扫描类文件并处理（采用两段式加载，可以部分bean先处理；剩下的为第二段处理）
        ScanUtil.scan(context.getClassLoader(), "com/fliad", n -> n.endsWith(".class"))
                .forEach(name -> {
                    String className = name.substring(0, name.length() - 6);
                    className = className.replace('/', '.');
                    Class<?> clz = ClassUtil.loadClass(context.getClassLoader(), className);
                    if (clz != null) {
                        metadata.registerReflection(clz, MemberCategory.values());
                        if (clz.isAnnotationPresent(Component.class) && hasLambdaExpressions(clz) && clz != AuthThirdServiceImpl.class) {
                            metadata.registerLambdaSerialization(clz);
                        }
                    }
                });

        metadata.registerResourceInclude("_sql/.*");
        metadata.registerResourceInclude("app-local.yml");

        // 允许访问 java.lang.invoke 包中的内部API，解决反射调用相关问题
        metadata.registerArg("-J--add-opens=java.base/java.lang.invoke=ALL-UNNAMED");
        // 允许访问 java.nio 包中的内部API，通常用于直接内存访问或缓冲区操作
        metadata.registerArg("-J--add-opens=java.base/java.nio=ALL-UNNAMED");
        // 导出 jdk.internal.misc 包，使其对所有模块可见，用于访问Unsafe等内部工具类
        metadata.registerArg("-J--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED");

        // 设置生成的native镜像的目标CPU架构兼容性模式
        metadata.registerArg("-march=compatibility");
    }

    /**
     * 检查类中是否包含Lambda表达式
     *
     * @param clazz 要检查的类
     * @return 如果包含Lambda表达式返回true，否则返回false
     */
    private boolean hasLambdaExpressions(Class<?> clazz) {
        try {
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.getName().contains("deserializeLambda")) {
                    return true;
                }
            }
        } catch (Exception e) {
            // 发生异常表示不是lambda表达式类
        }
        return false;
    }
}

package com.fliad.core.config;

import cn.hutool.json.JSONConverter;
import com.fliad.auth.core.pojo.SaBaseClientLoginUser;
import com.fliad.auth.core.pojo.SaBaseLoginUser;
import com.fliad.auth.modular.login.service.impl.AuthServiceImpl;
import com.fliad.auth.modular.third.service.impl.AuthThirdServiceImpl;
import com.fliad.biz.modular.dict.service.impl.BizDictServiceImpl;
import com.fliad.biz.modular.group.service.impl.BizGroupServiceImpl;
import com.fliad.biz.modular.index.service.impl.BizIndexServiceImpl;
import com.fliad.biz.modular.notice.service.impl.BizNoticeServiceImpl;
import com.fliad.biz.modular.org.service.impl.BizOrgServiceImpl;
import com.fliad.biz.modular.position.service.impl.BizPositionServiceImpl;
import com.fliad.biz.modular.user.service.impl.BizUserServiceImpl;
import com.fliad.client.modular.relation.service.impl.ClientRelationServiceImpl;
import com.fliad.client.modular.user.service.impl.ClientUserServiceImpl;
import com.fliad.dev.core.listener.DevJobListener;
import com.fliad.dev.modular.config.service.impl.DevConfigServiceImpl;
import com.fliad.dev.modular.dev.DevApiProvider;
import com.fliad.dev.modular.dict.service.impl.DevDictServiceImpl;
import com.fliad.dev.modular.email.service.impl.DevEmailServiceImpl;
import com.fliad.dev.modular.file.service.impl.DevFileServiceImpl;
import com.fliad.dev.modular.job.service.impl.DevJobServiceImpl;
import com.fliad.dev.modular.log.provider.DevLogApiProvider;
import com.fliad.dev.modular.log.service.impl.DevLogServiceImpl;
import com.fliad.dev.modular.message.provider.DevMessageProvider;
import com.fliad.dev.modular.message.service.impl.DevMessageServiceImpl;
import com.fliad.dev.modular.relation.service.impl.DevRelationServiceImpl;
import com.fliad.dev.modular.slideshow.service.impl.DevSlideshowServiceImpl;
import com.fliad.dev.modular.sms.service.impl.DevSmsServiceImpl;
import com.fliad.mobile.modular.resource.service.impl.MobileButtonServiceImpl;
import com.fliad.mobile.modular.resource.service.impl.MobileMenuServiceImpl;
import com.fliad.mobile.modular.resource.service.impl.MobileModuleServiceImpl;
import com.fliad.sys.modular.group.service.impl.SysGroupServiceImpl;
import com.fliad.sys.modular.index.service.impl.SysIndexServiceImpl;
import com.fliad.sys.modular.org.service.impl.SysOrgServiceImpl;
import com.fliad.sys.modular.position.service.impl.SysPositionServiceImpl;
import com.fliad.sys.modular.relation.provider.SysRelationApiProvider;
import com.fliad.sys.modular.relation.service.impl.SysRelationServiceImpl;
import com.fliad.sys.modular.resource.service.impl.SysButtonServiceImpl;
import com.fliad.sys.modular.resource.service.impl.SysMenuServiceImpl;
import com.fliad.sys.modular.resource.service.impl.SysModuleServiceImpl;
import com.fliad.sys.modular.role.provider.SysRoleApiProvider;
import com.fliad.sys.modular.role.service.impl.SysRoleServiceImpl;
import com.fliad.sys.modular.user.provider.SysUserApiProvider;
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

        //扫描类文件并处理（采用两段式加载，可以部分bean先处理；剩下的为第二段处理）
        ScanUtil.scan(context.getClassLoader(), "com/fliad", n -> n.endsWith(".class"))
                .forEach(name -> {
                    String className = name.substring(0, name.length() - 6);
                    className = className.replace('/', '.');
                    Class<?> clz = ClassUtil.loadClass(context.getClassLoader(), className);
                    if (clz != null) {
                        metadata.registerReflection(clz, MemberCategory.values());
                    }
                });

        // 手动注册序列化
        metadata.registerSerialization(SaBaseClientLoginUser.class);
        metadata.registerSerialization(SaBaseClientLoginUser.DataScope.class);
        metadata.registerSerialization(SaBaseLoginUser.class);
        metadata.registerSerialization(SaBaseLoginUser.DataScope.class);
        
        // 注册所有基本类型
        metadata.registerSerialization(String.class);
        metadata.registerSerialization(Byte.class);
        metadata.registerSerialization(byte.class);
        metadata.registerSerialization(Short.class);
        metadata.registerSerialization(short.class);
        metadata.registerSerialization(Integer.class);
        metadata.registerSerialization(int.class);
        metadata.registerSerialization(Long.class);
        metadata.registerSerialization(long.class);
        metadata.registerSerialization(Float.class);
        metadata.registerSerialization(float.class);
        metadata.registerSerialization(Double.class);
        metadata.registerSerialization(double.class);
        metadata.registerSerialization(Boolean.class);
        metadata.registerSerialization(boolean.class);
        metadata.registerSerialization(Character.class);
        metadata.registerSerialization(char.class);
        
        // 注册常用包装类型和数组类型
        metadata.registerSerialization(Number.class);
        metadata.registerSerialization(String[].class);
        metadata.registerSerialization(Integer[].class);
        metadata.registerSerialization(int[].class);
        metadata.registerSerialization(Long[].class);
        metadata.registerSerialization(long[].class);
        metadata.registerSerialization(Boolean[].class);
        metadata.registerSerialization(boolean[].class);
        metadata.registerSerialization(Double[].class);
        metadata.registerSerialization(double[].class);

        // 手动注册的lambda序列化
        /*metadata.registerLambdaSerialization(DevSlideshowServiceImpl.class);
        metadata.registerLambdaSerialization(BizNoticeServiceImpl.class);
        metadata.registerLambdaSerialization(SysGroupServiceImpl.class);
        metadata.registerLambdaSerialization(MobileModuleServiceImpl.class);
        metadata.registerLambdaSerialization(MobileMenuServiceImpl.class);
        metadata.registerLambdaSerialization(MobileButtonServiceImpl.class);
        metadata.registerLambdaSerialization(DevSmsServiceImpl.class);
        metadata.registerLambdaSerialization(DevRelationServiceImpl.class);
        metadata.registerLambdaSerialization(DevMessageServiceImpl.class);
        metadata.registerLambdaSerialization(DevLogServiceImpl.class);
        metadata.registerLambdaSerialization(DevFileServiceImpl.class);
        metadata.registerLambdaSerialization(DevEmailServiceImpl.class);
        metadata.registerLambdaSerialization(ClientUserServiceImpl.class);
        metadata.registerLambdaSerialization(ClientRelationServiceImpl.class);
        metadata.registerLambdaSerialization(AuthThirdServiceImpl.class);*/
        metadata.registerLambdaSerialization(SysRelationServiceImpl.class);
        metadata.registerLambdaSerialization(SysOrgServiceImpl.class);
        metadata.registerLambdaSerialization(SysMenuServiceImpl.class);
        metadata.registerLambdaSerialization(SysRoleServiceImpl.class);
        metadata.registerLambdaSerialization(SysUserServiceImpl.class);
        metadata.registerLambdaSerialization(AuthServiceImpl.class);
        metadata.registerLambdaSerialization(DevDictServiceImpl.class);
        metadata.registerLambdaSerialization(DevJobListener.class);
        metadata.registerLambdaSerialization(DevConfigServiceImpl.class);
        metadata.registerLambdaSerialization(DevJobServiceImpl.class);
        metadata.registerLambdaSerialization(ViidApeServiceImpl.class);
        metadata.registerLambdaSerialization(ViidCascadePlatformServiceImpl.class);
        metadata.registerLambdaSerialization(ViidPlatformStatusServiceImpl.class);
        metadata.registerLambdaSerialization(ViidSystemServiceImpl.class);
        metadata.registerLambdaSerialization(ViidDatasourceServiceImpl.class);
        metadata.registerLambdaSerialization(ViidSubscribeServiceImpl.class);
        metadata.registerLambdaSerialization(ViidTollgateServiceImpl.class);
        metadata.registerLambdaSerialization(ViidWorkflowServiceImpl.class);

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

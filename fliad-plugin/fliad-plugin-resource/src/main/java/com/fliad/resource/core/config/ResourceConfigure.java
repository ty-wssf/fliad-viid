package com.fliad.resource.core.config;

import com.github.xiaoymin.knife4j.solon.extension.OpenApiExtensionResolver;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.docs.models.ApiInfo;
import org.noear.solon.docs.DocDocket;
import com.fliad.common.pojo.CommonHttpCodes;

/**
 * 资源管理插件配置类
 *
 * @author fliad
 * @date 2025-10-22
 */
@Configuration
public class ResourceConfigure {
    
    @Inject
    private OpenApiExtensionResolver openApiExtensionResolver;

    /**
     * API文档分组配置
     *
     * @author fliad
     * @date 2025-10-22
     **/
    @Bean("resourceDocApi")
    public DocDocket resourceDocApi() {
        return new DocDocket()
                .info(new ApiInfo()
                        .title("资源管理RESOURCE")
                        .description("资源管理RESOURCE")
                        .version("0.1.0"))
                .globalResponseCodes(new CommonHttpCodes())
                .groupName("资源管理RESOURCE")
                .apis("com.fliad.resource")
                .basicAuth(openApiExtensionResolver.getSetting().getBasic())
                .vendorExtensions(openApiExtensionResolver.buildExtensions());
    }
}
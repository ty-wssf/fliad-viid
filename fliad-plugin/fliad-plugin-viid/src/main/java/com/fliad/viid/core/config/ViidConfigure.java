package com.fliad.viid.core.config;

import com.fliad.common.pojo.CommonHttpCodes;
import com.github.xiaoymin.knife4j.solon.extension.OpenApiExtensionResolver;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.docs.DocDocket;
import org.noear.solon.docs.models.ApiInfo;

@Configuration
public class ViidConfigure {

    @Inject
    private OpenApiExtensionResolver openApiExtensionResolver;

    @Bean("viidDocApi")
    public DocDocket viidDocApi() {
        return new DocDocket()
                .info(new ApiInfo()
                        .title("1400视图库功能VIID")
                        .description("1400视图库功能VIID")
                        // .termsOfService("https://www.xiaonuo.vip")
                        // .contact("SNOWY_TEAM", "https://www.xiaonuo.vip", "xuyuxiang29@foxmail.com")
                        .version("3.5.0"))
                .globalResponseCodes(new CommonHttpCodes())
                .groupName("1400视图库功能VIID")
                .apis("com.fliad.viid")
                .basicAuth(openApiExtensionResolver.getSetting().getBasic())
                .vendorExtensions(openApiExtensionResolver.buildExtensions());
    }

}

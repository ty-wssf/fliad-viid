package com.fliad.report.core.config;

import com.github.xiaoymin.knife4j.solon.extension.OpenApiExtensionResolver;
import io.nop.report.core.XptConstants;
import io.nop.report.core.engine.IReportEngine;
import io.nop.report.core.engine.IReportRendererFactory;
import io.nop.report.core.engine.ReportEngine;
import io.nop.report.core.engine.renderer.HtmlReportRendererFactory;
import io.nop.report.core.engine.renderer.XlsxReportRendererFactory;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.docs.models.ApiInfo;
import org.noear.solon.docs.DocDocket;
import com.fliad.common.pojo.CommonHttpCodes;

import java.util.HashMap;
import java.util.Map;

/**
 * 报表插件配置类
 *
 * @author fliad
 * @date 2025-10-26
 */
@Configuration
public class ReportConfigure {

    @Inject
    private OpenApiExtensionResolver openApiExtensionResolver;

    /**
     * API文档分组配置
     *
     * @author fliad
     * @date 2025-10-26
     **/
    @Bean("reportDocApi")
    public DocDocket reportDocApi() {
        return new DocDocket()
                .info(new ApiInfo()
                        .title("报表管理REPORT")
                        .description("报表管理REPORT")
                        .version("0.1.0"))
                .globalResponseCodes(new CommonHttpCodes())
                .groupName("报表管理REPORT")
                .apis("com.fliad.report")
                .basicAuth(openApiExtensionResolver.getSetting().getBasic())
                .vendorExtensions(openApiExtensionResolver.buildExtensions());
    }

}

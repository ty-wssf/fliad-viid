package com.fliad.dahua.config;

import io.nop.dao.api.IDaoProvider;
import io.nop.orm.IOrmTemplate;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import com.fliad.dahua.util.ImportUtil;
import com.fliad.dahua.service.impl.UniqueValidator;

/**
 * 大华插件配置类
 * 用于初始化静态工具类
 */
@Configuration
public class DahuaConfig {

    @Bean
    public void initDahuaUtils(@Inject IOrmTemplate ormTemplate, @Inject IDaoProvider daoProvider) {
        ImportUtil.setOrmTemplate(ormTemplate);
        UniqueValidator.setDaoProvider(daoProvider);
    }
}
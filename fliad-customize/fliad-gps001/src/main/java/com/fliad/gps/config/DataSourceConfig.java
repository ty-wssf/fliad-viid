package com.fliad.gps.config;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

import javax.sql.DataSource;

/**
 * 数据源配置类
 */
@Configuration
public class DataSourceConfig {

    /**
     * 创建MySQL数据源Bean
     */
    @Bean("mysql")
    public DataSource mysqlDataSource(@Inject("${solon.datasource.mysql}") HikariDataSource dataSource) {
        return dataSource;
    }

    /**
     * 创建Doris数据源Bean
     */
    @Bean("doris")
    public DataSource dorisDataSource(@Inject("${solon.datasource.doris}") HikariDataSource dataSource) {
        return dataSource;
    }
}
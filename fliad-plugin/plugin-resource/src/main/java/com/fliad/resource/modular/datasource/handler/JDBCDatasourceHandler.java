package com.fliad.resource.modular.datasource.handler;

import cn.hutool.core.util.StrUtil;
import com.fliad.resource.modular.datasource.entity.ResourceDatasource;
import org.noear.snack.ONode;
import org.noear.solon.Solon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JDBC数据源处理器
 *
 * @author wyl
 * @date 2025/09/25 10:00
 */
public class JDBCDatasourceHandler implements DatasourceHandler {
    private static final Logger log = LoggerFactory.getLogger(JDBCDatasourceHandler.class);

    @Override
    public void initConnection(ResourceDatasource datasource) {
        initJdbcConnection(datasource);
    }

    @Override
    public void closeConnection(String datasourceId) {
        // JDBC连接由连接池管理，此处无需特殊处理
        log.info("JDBC数据源连接由连接池管理，数据源ID：{}", datasourceId);
    }

    @Override
    public String getSupportedType() {
        return "jdbc";
    }

    /**
     * 初始化 JDBC 连接
     *
     * @param datasource 数据源实体
     */
    private void initJdbcConnection(ResourceDatasource datasource) {
        // 解析配置信息
        if (StrUtil.isBlank(datasource.getContent())) {
            log.warn("数据源配置内容为空，数据源ID：{}", datasource.getId());
            return;
        }

        try {
            // 解析 JDBC 配置
            ONode config = ONode.load(handleEscapeCharacters(datasource.getContent()));
            String driverClassName = config.get("driverClassName").getString();
            String jdbcUrl = config.get("jdbcUrl").getString();
            String username = config.get("username").getString();
            String password = config.get("password").getString();
            String dataSourceName = config.get("dataSourceName").getString();

            // 如果未配置数据源名称，则使用数据源ID作为名称
            if (StrUtil.isBlank(dataSourceName)) {
                dataSourceName = datasource.getId();
            }

            log.info("JDBC配置信息：driverClassName={}, jdbcUrl={}, username={}, dataSourceName={}"
                    , driverClassName, jdbcUrl, username, dataSourceName);

            // 创建数据源
            com.zaxxer.hikari.HikariDataSource hikariDataSource = new com.zaxxer.hikari.HikariDataSource();
            hikariDataSource.setJdbcUrl(jdbcUrl);
            hikariDataSource.setUsername(username);
            hikariDataSource.setPassword(password);
            hikariDataSource.setDriverClassName(driverClassName);
            hikariDataSource.setPoolName(dataSourceName);

            Solon.context().wrapAndPut(dataSourceName, hikariDataSource);

            log.info("JDBC 数据源初始化完成，数据源ID：{}，数据源名称：{}", datasource.getId(), dataSourceName);
        } catch (Exception e) {
            log.error("解析 JDBC 配置失败，数据源ID：{}", datasource.getId(), e);
        }
    }

    /**
     * 处理字符串中的转义字符
     *
     * @param jsonStr 包含可能转义字符的JSON字符串
     * @return 处理后的JSON字符串
     */
    private String handleEscapeCharacters(String jsonStr) {
        if (jsonStr == null || jsonStr.isEmpty()) {
            return jsonStr;
        }

        // 先尝试直接解析
        if (isValidJson(jsonStr)) {
            return jsonStr;
        }

        // 尝试不同的策略来修复转义字符
        String[] strategies = {
                jsonStr.replace("\\\"", "\""),           // 将 \" 替换为 "
                jsonStr.replace("\\\\", "\\"),           // 将 \\ 替换为 \
                jsonStr.replace("\\\"", "\"").replace("\\\\", "\\"),  // 组合策略1
                jsonStr.replace("\\\\\"", "\"").replace("\\\\'", "'"), // 组合策略2
        };

        // 尝试每种策略，找到第一个能生成有效JSON的
        for (String strategy : strategies) {
            if (isValidJson(strategy)) {
                return strategy;
            }
        }

        // 如果所有策略都失败，返回原始字符串
        return jsonStr;
    }

    /**
     * 检查字符串是否为有效的JSON
     *
     * @param jsonStr 待检查的字符串
     * @return 是否为有效的JSON
     */
    private boolean isValidJson(String jsonStr) {
        try {
            ONode.loadStr(jsonStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
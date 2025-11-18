package com.fliad.core.config;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;
import org.noear.solon.core.util.ResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 数据库初始化器
 * 自动执行初始化脚本
 *
 * @author lingma
 */
@Component(index = -10)
public class DataSourceInitializer implements LifecycleBean {

    private static final Logger log = LoggerFactory.getLogger(DataSourceInitializer.class);

    @Inject
    private DataSource dataSource;

    @Inject
    private CustomDbIdProvider customDbIdProvider;

    @Override
    public void start() throws Throwable {
        String databaseId = customDbIdProvider.getDatabaseId(dataSource);
        log.info("检测到{}数据库，开始执行初始化脚本...", databaseId);
        executeInitScript(databaseId);
        log.info("{}数据库初始化脚本执行完成", databaseId);
    }

    /**
     * 执行H2数据库初始化脚本
     */
    private void executeInitScript(String databaseId) {
        try (Connection connection = dataSource.getConnection()) {
            // 执行schema脚本
            for (String u1 : ResourceUtil.scanResources(String.format("classpath:_sql/%s/*.sql", databaseId))) {
                if ((u1.contains("schema") || u1.contains("_create"))) {
                    executeScript(connection, u1);
                }
            }
            executeScript(connection, String.format("_sql/%s/snowy_data.sql", databaseId));
            for (String u1 : ResourceUtil.scanResources(String.format("classpath:_sql/%s/*.sql", databaseId))) {
                if (u1.contains("data") && !u1.contains("snowy_data")) {
                    executeScript(connection, u1);
                }
            }
        } catch (SQLException e) {
            log.error("执行H2数据库初始化脚本失败", e);
        }
    }

    /**
     * 执行单个SQL脚本文件
     *
     * @param connection 数据库连接
     * @param scriptPath 脚本路径
     */
    private void executeScript(Connection connection, String scriptPath) {
        try {
            URL resource = ResourceUtil.findResourceOrFile(null, scriptPath);
            if (resource == null) {
                log.warn("未找到脚本文件: {}", scriptPath);
                return;
            }

            List<String> lines = FileUtil.readLines(resource, "UTF-8");
            StringBuilder sqlBuilder = new StringBuilder();
            Statement statement = connection.createStatement();

            for (String line : lines) {
                // 跳过注释行和空行
                if (StrUtil.isBlank(line) || line.trim().startsWith("--")) {
                    continue;
                }

                sqlBuilder.append(line).append("\n");

                // 检查是否为语句结束符
                if (line.trim().endsWith(";")) {
                    String sql = sqlBuilder.toString().trim();
                    // 去掉结尾的分号
                    if (sql.endsWith(";")) {
                        sql = sql.substring(0, sql.length() - 1);
                    }

                    // 执行非空SQL
                    if (StrUtil.isNotBlank(sql)) {
                        try {
                            statement.execute(sql);
                        } catch (SQLException e) {
                            // 允许单个语句执行失败，因为表可能已经存在或者数据已经存在
                            log.debug("执行SQL语句时遇到预期的错误（表可能已存在或数据已存在）: {}", sql);
                        }
                    }

                    // 重置SQL构建器
                    sqlBuilder.setLength(0);
                }
            }

            statement.close();
            log.info("成功执行脚本: {}", scriptPath);
        } catch (SQLException e) {
            log.error("执行脚本失败: {}", scriptPath, e);
        }
    }
}

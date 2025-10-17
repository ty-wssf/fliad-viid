package com.fliad.core.config;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;
import org.noear.solon.core.util.ResourceUtil;

import javax.sql.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * H2数据库初始化器
 * 当使用H2数据库时，自动执行初始化脚本
 *
 * @author lingma
 */
@Slf4j
@Component(index = -10)
public class H2DataSourceInitializer implements LifecycleBean {

    @Inject
    private DataSource dataSource;

    @Inject
    private CustomDbIdProvider customDbIdProvider;

    @Override
    public void start() throws Throwable {
        // 检查是否为H2数据库
        if ("h2".equals(customDbIdProvider.getDatabaseId(dataSource))) {
            log.info("检测到H2数据库，开始执行初始化脚本...");
            executeInitScript();
            log.info("H2数据库初始化脚本执行完成");
        }
    }

    /**
     * 执行H2数据库初始化脚本
     */
    private void executeInitScript() {
        try (Connection connection = dataSource.getConnection()) {
            // 执行schema脚本
            executeScript(connection, "./_sql/h2/snowy_schema.sql");
            executeScript(connection, "./_sql/h2/biz_schema.sql");
            executeScript(connection, "./_sql/h2/viid_schema.sql");

            // 执行data脚本
            executeScript(connection, "./_sql/h2/snowy_data.sql");
            executeScript(connection, "./_sql/h2/biz_data.sql");
            executeScript(connection, "./_sql/h2/viid_data.sql");

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
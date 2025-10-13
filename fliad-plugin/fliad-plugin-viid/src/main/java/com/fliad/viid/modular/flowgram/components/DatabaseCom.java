package com.fliad.viid.modular.flowgram.components;

import com.fliad.viid.modular.flowgram.domain.TaskReportOutput;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.expression.snel.SnEL;
import org.noear.solon.flow.FlowContext;
import org.noear.solon.flow.Node;
import org.noear.solon.flow.TaskComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;

@Component("database")
public class DatabaseCom implements TaskComponent {
    private static final Logger log = LoggerFactory.getLogger(DatabaseCom.class);

    @Override
    public void run(FlowContext context, Node node) throws Throwable {
        Connection connection = (Connection) node.attachment;
        ONode dataNode; // 提取到方法作用域内

        if (connection == null || connection.isClosed()) {
            // 1. 获取数据库连接配置
            ONode metas = ONode.load(node.getMetas());
            dataNode = metas.select("data");
            ONode connectionNode = dataNode.get("connection");

            // 提取数据库连接配置
            String dbType = String.valueOf(extractConfigFromInputs(context, connectionNode, "type"));
            String host = String.valueOf(extractConfigFromInputs(context, connectionNode, "host"));
            int port = Integer.parseInt(String.valueOf(extractConfigFromInputs(context, connectionNode, "port")));
            String database = String.valueOf(extractConfigFromInputs(context, connectionNode, "database"));
            String username = String.valueOf(extractConfigFromInputs(context, connectionNode, "username"));
            String password = String.valueOf(extractConfigFromInputs(context, connectionNode, "password"));

            // 构建连接字符串
            String url = buildConnectionUrl(dbType, host, port, database);
            log.debug("构建数据库连接URL: {}", url);

            // 创建连接
            try {
                Class.forName(getDriverClassName(dbType));
                connection = DriverManager.getConnection(url, username, password);

                // 保存连接到 attachment 以供后续使用
                node.attachment = connection;
                log.debug("数据库连接已保存到node attachment");
            } catch (ClassNotFoundException e) {
                log.error("找不到数据库驱动类: {}", getDriverClassName(dbType), e);
                throw new RuntimeException("找不到数据库驱动类: " + getDriverClassName(dbType), e);
            } catch (SQLException e) {
                log.error("数据库连接失败", e);
                throw new RuntimeException("数据库连接失败", e);
            }
        } else {
            // 如果连接已存在且打开，也需要获取数据节点
            log.debug("使用已存在的数据库连接");
            ONode metas = ONode.load(node.getMetas());
            dataNode = metas.select("data");
        }

        // 执行数据库操作
        ONode queryNode = dataNode.get("query");
        String queryType = String.valueOf(extractConfigFromInputs(context, queryNode, "queryType"));

        Map<String, Object> resultMap = new HashMap<>();
        boolean success = false;
        String errorMessage = null;
        int rowCount = 0;

        try {
            if ("sql".equals(queryType)) {
                String sql = String.valueOf(extractConfigFromInputs(context, queryNode, "sql"));
                rowCount = executeSqlStatement(connection, sql, context, dataNode);
                success = true;
            } else if ("params".equals(queryType)) {
                String table = String.valueOf(extractConfigFromInputs(context, queryNode, "table"));
                ONode fieldsNode = dataNode.get("fields");
                rowCount = executeInsertStatement(connection, table, fieldsNode, context);
                success = true;
            } else {
                errorMessage = "不支持的查询类型: " + queryType;
               // log.warn(errorMessage);
                throw new RuntimeException(errorMessage);
            }
        } catch (Exception e) {
            throw new RuntimeException("数据库操作失败", e);
        } finally {
            resultMap.put("success", success);
            resultMap.put("rowCount", rowCount);
            context.put("output", resultMap);
            log.debug("数据库操作完成，结果: {}", resultMap);
        }

    }

    /**
     * 根据数据库类型构建连接URL
     *
     * @param dbType   数据库类型
     * @param host     主机地址
     * @param port     端口号
     * @param database 数据库名
     * @return 连接URL
     */
    private String buildConnectionUrl(String dbType, String host, int port, String database) {
        switch (dbType.toLowerCase()) {
            case "mysql":
                return String.format("jdbc:mysql://%s:%d/%s?useSSL=false&serverTimezone=UTC", host, port, database);
            case "postgresql":
                return String.format("jdbc:postgresql://%s:%d/%s", host, port, database);
            case "oracle":
                return String.format("jdbc:oracle:thin:@%s:%d:%s", host, port, database);
            case "sqlserver":
                return String.format("jdbc:sqlserver://%s:%d;databaseName=%s", host, port, database);
            default:
                throw new IllegalArgumentException("不支持的数据库类型: " + dbType);
        }
    }

    /**
     * 根据数据库类型获取驱动类名
     *
     * @param dbType 数据库类型
     * @return 驱动类名
     */
    private String getDriverClassName(String dbType) {
        switch (dbType.toLowerCase()) {
            case "mysql":
                return "com.mysql.cj.jdbc.Driver";
            case "postgresql":
                return "org.postgresql.Driver";
            case "oracle":
                return "oracle.jdbc.driver.OracleDriver";
            case "sqlserver":
                return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            default:
                throw new IllegalArgumentException("不支持的数据库类型: " + dbType);
        }
    }

    /**
     * 执行SQL语句
     *
     * @param connection 数据库连接
     * @param sql        SQL语句
     * @param context    流程上下文
     * @param dataNode   数据节点
     * @return 影响的行数
     * @throws SQLException SQL异常
     */
    private int executeSqlStatement(Connection connection, String sql, FlowContext context, ONode dataNode) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            log.debug("执行SQL语句: {}", sql);
            return stmt.executeUpdate();
        }
    }

    /**
     * 执行插入语句
     *
     * @param connection 数据库连接
     * @param table      表名
     * @param fieldsNode 字段配置节点
     * @param context    流程上下文
     * @return 影响的行数
     * @throws SQLException SQL异常
     */
    private int executeInsertStatement(Connection connection, String table, ONode fieldsNode, FlowContext context) throws SQLException {
        if (fieldsNode == null || fieldsNode.count() == 0) {
            log.warn("没有字段配置，跳过插入操作");
            return 0;
        }

        // 构建字段名和占位符
        List<String> fieldNames = new ArrayList<>();
        List<Object> fieldValues = new ArrayList<>();

        TaskReportOutput report = context.getAs("report");
        fieldsNode.forEach((key, val) -> {
            fieldNames.add(key);
            if ("constant".equals(val.get("type").getString())) {
                fieldValues.add(val.get("content").getString());
            } else if ("ref".equals(val.get("type").getString())) {
                String nodeID = val.get("content").get(0).getString();
                Object value = SnEL.eval(val.get("content").get(1).getString(), report.getNodeStatus(nodeID).getLastSnapshot().getOutputs());
                fieldValues.add(value);
            }
        });

        String placeholders = String.join(",", Collections.nCopies(fieldNames.size(), "?"));
        String sql = String.format("INSERT INTO %s (%s) VALUES (%s)",
                table,
                String.join(",", fieldNames),
                placeholders);

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // 设置参数值
            for (int i = 0; i < fieldValues.size(); i++) {
                // @todo: 根据类型转换
                stmt.setString(i + 1, fieldValues.get(i).toString());
            }

            log.debug("执行插入语句: {}", sql);
            return stmt.executeUpdate();
        }
    }

    /**
     * 从输入值中提取配置项
     *
     * @param flowContext 流程上下文
     * @param configNode  配置节点
     * @param configKey   配置项键名
     * @return 配置项值
     */
    private Object extractConfigFromInputs(FlowContext flowContext, ONode configNode, String configKey) {
        final Object[] value = {null};
        TaskReportOutput report = flowContext.getAs("report");

        if (configNode.contains(configKey)) {
            ONode val = configNode.get(configKey);
            if (val.isValue()) {
                value[0] = val.getString();
            } else if (val.isObject()) {
                if ("constant".equals(val.get("type").getString())) {
                    value[0] = val.get("content").getString();
                } else if ("ref".equals(val.get("type").getString())) {
                    String nodeID = val.get("content").get(0).getString();
                    value[0] = SnEL.eval(val.get("content").get(1).getString(), report.getNodeStatus(nodeID).getLastSnapshot().getOutputs());
                } else if ("template".equals(val.get("type").getString())) {
                    String content = val.get("content").getString();
                    value[0] = content;
                }
            }
        }

        log.trace("提取配置项: {} = {}", configKey, value[0]);
        return value[0];
    }
}

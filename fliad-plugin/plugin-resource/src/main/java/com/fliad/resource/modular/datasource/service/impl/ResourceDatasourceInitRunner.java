package com.fliad.resource.modular.datasource.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import com.fliad.resource.modular.datasource.entity.ResourceDatasource;
import com.fliad.resource.modular.datasource.service.ResourceDatasourceService;
import com.fliad.resource.modular.flowgram.domain.TaskRunInput;
import com.fliad.resource.modular.flowgram.service.FlowgramService;
import com.fliad.resource.modular.workflow.entity.ResourceWorkflow;
import com.fliad.resource.modular.workflow.service.ResourceWorkflowService;
import com.rabbitmq.client.*;
import org.noear.snack.ONode;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Handler;
import org.noear.solon.expression.snel.SnEL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据源初始化运行器
 * 服务启动时初始化数据源，根据订阅类别来订阅数据
 *
 * @author wyl
 * @date 2025/09/25 10:00
 */
@Component
public class ResourceDatasourceInitRunner implements LifecycleBean {
    private static final Logger log = LoggerFactory.getLogger(ResourceDatasourceInitRunner.class);

    @Inject
    private ResourceDatasourceService viidDatasourceService;

    @Inject
    private ResourceWorkflowService viidWorkflowService;

    @Inject
    private FlowgramService flowgramService;

    // 存储数据源连接信息
    private final Map<String, Connection> datasourceConnections = new ConcurrentHashMap<>();

    // 存储数据源频道信息
    private final Map<String, Channel> datasourceChannels = new ConcurrentHashMap<>();

    // 存储定时任务信息
    private final Map<String, String> datasourceCronTaskIds = new ConcurrentHashMap<>();

    // 存储HTTP接口处理器
    private final Map<String, Handler> httpEndpointHandlers = new ConcurrentHashMap<>();


    @Override
    public void start() throws Throwable {
        log.info(">>> 开始初始化数据源 <<<");
        try {
            // 获取所有启用的数据源
            List<ResourceDatasource> enabledDatasources = viidDatasourceService.listByStatus("ENABLE");
            if (enabledDatasources != null && !enabledDatasources.isEmpty()) {
                log.info("找到 {} 个启用的数据源，开始初始化", enabledDatasources.size());
                for (ResourceDatasource datasource : enabledDatasources) {
                    try {
                        // 根据数据源类型和订阅类别初始化连接
                        initDatasourceConnection(datasource);
                    } catch (Exception e) {
                        log.error("初始化数据源失败，数据源ID：{}，标题：{}", datasource.getId(), datasource.getTitle(), e);
                    }
                }
            } else {
                log.info("未找到启用的数据源");
            }
            log.info(">>> 数据源初始化完成 <<<");
        } catch (Exception e) {
            log.error("数据源初始化过程中发生错误", e);
        }
    }

    /**
     * 根据数据源类型和订阅类别初始化连接
     *
     * @param datasource 数据源实体
     */
    private void initDatasourceConnection(ResourceDatasource datasource) {
        log.info("开始初始化数据源，ID：{}，标题：{}，类型：{}，订阅类别：{}",
                datasource.getId(), datasource.getTitle(), datasource.getType(), datasource.getSubscribeDetail());

        // 根据不同类型初始化连接
        switch (datasource.getType()) {
            case "rabbitmq":
                initRabbitMQConnection(datasource);
                break;
            case "cron":
                initCronConnection(datasource);
                break;
            case "jdbc":
                initJdbcConnection(datasource);
                break;
            case "http":
                initHttpEndpoint(datasource);
                break;
            default:
                log.warn("不支持的数据源类型：{}", datasource.getType());
                break;
        }
    }

    /**
     * 初始化 HTTP 接口端点
     *
     * @param datasource 数据源实体
     */
    private void initHttpEndpoint(ResourceDatasource datasource) {
        try {
            // 解析 HTTP 配置
            String content = datasource.getContent();
            if (StrUtil.isBlank(content)) {
                log.warn("HTTP数据源配置内容为空，数据源ID：{}", datasource.getId());
                return;
            }

            ONode config = ONode.load(handleEscapeCharacters(content));
            String path = config.get("path").getString();
            String method = config.get("method").getString();

            log.info("注册HTTP接口：path={}, method={}", path, method);

            // 创建处理器
            Handler handler = new HttpEndpointHandler(datasource);

            // 注册路由
            Solon.app().router().add(path, handler);

            // 存储处理器引用
            httpEndpointHandlers.put(datasource.getId(), handler);

            log.info("HTTP 接口注册完成，数据源ID：{}，路径：{}", datasource.getId(), path);
        } catch (Exception e) {
            log.error("注册 HTTP 接口失败，数据源ID：{}", datasource.getId(), e);
        }
    }

    /**
     * HTTP 接口处理器
     */
    private class HttpEndpointHandler implements Handler {
        private final ResourceDatasource datasource;

        public HttpEndpointHandler(ResourceDatasource datasource) {
            this.datasource = datasource;
        }

        @Override
        public void handle(Context ctx) throws Throwable {
            log.info("处理HTTP请求，数据源ID：{}，订阅类别：{}", datasource.getId(), datasource.getSubscribeDetail());

            // 获取请求体
            String requestBody = ctx.body();

            // 返回成功响应
            ctx.status(200);
            ctx.renderAndReturn("Success");

        }
    }

    /**
     * 初始化 Cron 定时任务连接
     *
     * @param datasource 数据源实体
     */
    private void initCronConnection(ResourceDatasource datasource) {
        try {
            // 解析 Cron 配置
            String content = datasource.getContent();
            if (StrUtil.isBlank(content)) {
                log.warn("数据源配置内容为空，数据源ID：{}", datasource.getId());
                return;
            }

            ONode config = ONode.load(handleEscapeCharacters(content));
            String cronExpression = config.get("cronExpression").getString();
            String payload = config.get("payload").getString();

            // 如果没有配置消息内容，则使用默认消息
            if (StrUtil.isBlank(payload)) {
                payload = "{}";
            }

            log.info("Cron配置信息：cronExpression={}, payload={}", cronExpression, payload);

            // 使用 Hutool 的 CronUtil 来创建定时任务
            String finalPayload = payload;
            String taskId = CronUtil.schedule(datasource.getId(), "0 0/1 * * * ?", new Task() {
                @Override
                public void execute() {
                    log.info("执行定时任务，数据源ID：{}，订阅类别：{}", datasource.getId(), datasource.getSubscribeDetail());
                    try {
                        // 处理定时任务触发
                        if (StrUtil.isNotBlank(datasource.getScriptFilter())) {
                            Map<String, Object> context = ONode.deserialize(finalPayload);
                            Object result = SnEL.eval(datasource.getScriptFilter(), context);
                            // 如果result是布尔类型
                            if (result instanceof Boolean) {
                                if ((Boolean) result) {
                                    processMessage(finalPayload, datasource);
                                } else {
                                    log.info("脚本过滤器结果为false，不处理消息");
                                }
                            } else {
                                log.warn("脚本过滤器结果不是布尔类型");
                            }
                        } else {
                            processMessage(finalPayload, datasource);
                        }
                    } catch (Exception e) {
                        log.error("处理定时任务消息失败，数据源ID：{}", datasource.getId(), e);
                    }
                }
            });

            // 将定时任务ID存储起来，便于后续管理和停止
            datasourceCronTaskIds.put(datasource.getId(), taskId);

            log.info("Cron 数据源初始化完成，数据源ID：{}，定时任务ID：{}", datasource.getId(), taskId);
        } catch (Exception e) {
            log.error("解析 Cron 配置失败，数据源ID：{}", datasource.getId(), e);
        }
    }

    /**
     * 初始化 RabbitMQ 连接
     *
     * @param datasource 数据源实体
     */
    private void initRabbitMQConnection(ResourceDatasource datasource) {
        // 解析配置信息
        if (StrUtil.isBlank(datasource.getContent())) {
            log.warn("数据源配置内容为空，数据源ID：{}", datasource.getId());
            return;
        }

        try {
            // 解析 RabbitMQ 配置
            ONode config = ONode.load(handleEscapeCharacters(datasource.getContent()));
            String host = config.get("host").getString();
            int port = config.get("port").getInt();
            String username = config.get("username").getString();
            String password = config.get("password").getString();
            String exchange = config.get("exchange").getString();
            String routingKey = config.get("routingKey").getString();
            String queueName = config.get("queueName").getString();

            log.info("RabbitMQ配置信息：host={}, port={}, username={}, exchange={}, routingKey={}, queueName={}",
                    host, port, username, exchange, routingKey, queueName);

            // 创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(host);
            factory.setPort(port);
            factory.setUsername(username);
            factory.setPassword(password);

            // 建立连接和频道
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            // 声明交换机
            if (StrUtil.isNotBlank(exchange)) {
                channel.exchangeDeclare(exchange, BuiltinExchangeType.TOPIC, true);
            }

            // 声明队列
            channel.queueDeclare(queueName, true, false, false, null);

            // 绑定队列到交换机
            if (StrUtil.isNotBlank(exchange) && StrUtil.isNotBlank(routingKey)) {
                channel.queueBind(queueName, exchange, routingKey);
            }

            // 根据订阅类别处理订阅逻辑
            String subscribeDetail = datasource.getSubscribeDetail();
            log.info("根据订阅类别 {} 处理数据订阅", subscribeDetail);

            // 创建消费者并处理消息
            createConsumer(channel, queueName, datasource);

            // 将连接信息存储起来，便于后续使用和关闭
            datasourceConnections.put(datasource.getId(), connection);
            datasourceChannels.put(datasource.getId(), channel);

            log.info("RabbitMQ 数据源初始化完成，数据源ID：{}", datasource.getId());
        } catch (Exception e) {
            log.error("解析 RabbitMQ 配置失败，数据源ID：{}", datasource.getId(), e);
        }
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
     * 创建消费者处理消息
     *
     * @param channel    频道
     * @param queueName  队列名
     * @param datasource 数据源
     */
    private void createConsumer(Channel channel, String queueName, ResourceDatasource datasource) {
        try {
            // 创建消费者
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                log.info("接收消息，数据源ID：{}，订阅类别：{}，消息大小：{}",
                        datasource.getId(), datasource.getSubscribeDetail(), message.length());

                try {
                    // 处理接收到的消息
                    if (StrUtil.isNotBlank(datasource.getScriptFilter())) {
                        Map<String, Object> context = ONode.deserialize(message);
                        Object result = SnEL.eval(datasource.getScriptFilter(), context);
                        // 如果result是布尔类型
                        if (result instanceof Boolean) {
                            if ((Boolean) result) {
                                processMessage(message, datasource);
                            } else {
                                log.info("脚本过滤器结果为false，不处理消息");
                            }
                        } else {
                            log.warn("脚本过滤器结果不是布尔类型");
                        }
                    } else {
                        processMessage(message, datasource);
                    }

                    // 手动确认消息
                    channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                } catch (Exception e) {
                    log.error("处理消息失败，数据源ID：{}，队列：{}", datasource.getId(), queueName, e);
                    try {
                        // 拒绝消息并重新入队
                        channel.basicNack(delivery.getEnvelope().getDeliveryTag(), false, true);
                    } catch (IOException ioException) {
                        log.error("拒绝消息失败，数据源ID：{}，队列：{}", datasource.getId(), queueName, ioException);
                    }
                }
            };

            CancelCallback cancelCallback = consumerTag -> {
                log.info("消费者被取消，数据源ID：{}，队列：{}，消费者标签：{}", datasource.getId(), queueName, consumerTag);
            };

            // 开始消费消息
            channel.basicConsume(queueName, false, deliverCallback, cancelCallback);

            log.info("消费者创建成功，数据源ID：{}，队列：{}", datasource.getId(), queueName);
        } catch (Exception e) {
            log.error("创建消费者失败，数据源ID：{}，队列：{}", datasource.getId(), queueName, e);
        }
    }

    /**
     * 处理接收到的消息
     *
     * @param message    消息内容
     * @param datasource 数据源
     */
    private void processMessage(String message, ResourceDatasource datasource) {
        /*log.info("处理消息，数据源ID：{}，订阅类别：{}，消息大小：{}",
                datasource.getId(), datasource.getSubscribeDetail(), message.length());*/

        // 参考 ViidDataController 中的处理方式
        try {
            // 根据订阅类别处理数据
            String subscribeDetail = datasource.getSubscribeDetail();

            // 处理数据
            processDataBySubscribeDetail(message, subscribeDetail);
        } catch (Exception e) {
            log.error("处理消息时发生错误，数据源ID：{}，订阅类别：{}", datasource.getId(), datasource.getSubscribeDetail(), e);
        }
    }

    /**
     * 根据订阅类别处理数据
     *
     * @param message         消息内容
     * @param subscribeDetail 订阅详情
     */
    private void processDataBySubscribeDetail(String message, String subscribeDetail) {
        try {
            log.debug("开始处理数据，订阅类别：{}", subscribeDetail);

            // 获取对应的工作流
            List<ResourceWorkflow> workflowList = viidWorkflowService.findBySubscribeDetail(subscribeDetail);
            log.debug("找到 {} 个工作流处理数据", workflowList.size());

            // 如果没有找到处理流程，打印提示信息
            if (workflowList.isEmpty()) {
                log.warn("未找到处理流程，订阅类别：{}", subscribeDetail);
                return;
            }

            // 执行工作流
            for (ResourceWorkflow workflow : workflowList) {
                TaskRunInput taskRunInput = new TaskRunInput();
                taskRunInput.setSchema(workflow.getContent());
                taskRunInput.setInputs(MapUtil.of("inputs", message));
                flowgramService.taskRun(false, taskRunInput, IdUtil.getSnowflakeNextIdStr());
            }
        } catch (Exception e) {
            log.error("处理数据时发生错误，订阅类别：{}", subscribeDetail, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void stop() throws Throwable {
        log.info(">>> 关闭数据源连接 <<<");
        // 关闭所有数据源连接
        for (Map.Entry<String, Channel> entry : datasourceChannels.entrySet()) {
            try {
                if (entry.getValue() != null && entry.getValue().isOpen()) {
                    entry.getValue().close();
                    log.info("关闭频道，数据源ID：{}", entry.getKey());
                }
            } catch (Exception e) {
                log.error("关闭频道时发生错误，数据源ID：{}", entry.getKey(), e);
            }
        }

        for (Map.Entry<String, Connection> entry : datasourceConnections.entrySet()) {
            try {
                if (entry.getValue() != null && entry.getValue().isOpen()) {
                    entry.getValue().close();
                    log.info("关闭连接，数据源ID：{}", entry.getKey());
                }
            } catch (Exception e) {
                log.error("关闭连接时发生错误，数据源ID：{}", entry.getKey(), e);
            }
        }


        // 取消所有定时任务
        for (Map.Entry<String, String> entry : datasourceCronTaskIds.entrySet()) {
            try {
                CronUtil.remove(entry.getValue());
                log.info("取消定时任务，数据源ID：{}", entry.getKey());
            } catch (Exception e) {
                log.error("取消定时任务时发生错误，数据源ID：{}", entry.getKey(), e);
            }
        }

        datasourceChannels.clear();
        datasourceConnections.clear();
        datasourceCronTaskIds.clear();

        // 停止定时任务调度器
        CronUtil.stop();
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
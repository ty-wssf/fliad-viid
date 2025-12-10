package com.fliad.resource.modular.datasource.handler;

import cn.hutool.core.util.StrUtil;
import com.fliad.resource.modular.datasource.entity.ResourceDatasource;
import com.rabbitmq.client.*;
import org.noear.snack.ONode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * RabbitMQ数据源处理器
 *
 * @author wyl
 * @date 2025/09/25 10:00
 */
public class RabbitMQDatasourceHandler implements DatasourceHandler {
    private static final Logger log = LoggerFactory.getLogger(RabbitMQDatasourceHandler.class);

    // 存储数据源连接信息
    private final Map<String, Connection> datasourceConnections = new ConcurrentHashMap<>();

    // 存储数据源频道信息
    private final Map<String, Channel> datasourceChannels = new ConcurrentHashMap<>();
    
    private final MessageProcessor messageProcessor = new MessageProcessor();

    @Override
    public void initConnection(ResourceDatasource datasource) {
        initRabbitMQConnection(datasource);
    }

    @Override
    public void closeConnection(String datasourceId) {
        // 关闭频道
        Channel channel = datasourceChannels.get(datasourceId);
        if (channel != null && channel.isOpen()) {
            try {
                channel.close();
                log.info("关闭RabbitMQ频道，数据源ID：{}", datasourceId);
            } catch (Exception e) {
                log.error("关闭RabbitMQ频道时发生错误，数据源ID：{}", datasourceId, e);
            }
        }

        // 关闭连接
        Connection connection = datasourceConnections.get(datasourceId);
        if (connection != null && connection.isOpen()) {
            try {
                connection.close();
                log.info("关闭RabbitMQ连接，数据源ID：{}", datasourceId);
            } catch (Exception e) {
                log.error("关闭RabbitMQ连接时发生错误，数据源ID：{}", datasourceId, e);
            }
        }

        // 移除连接信息
        datasourceChannels.remove(datasourceId);
        datasourceConnections.remove(datasourceId);
    }

    @Override
    public String getSupportedType() {
        return "rabbitmq";
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
                    // 构造数据源信息对象
                    DatasourceInfo datasourceInfo = new DatasourceInfo(
                            datasource.getId(),
                            datasource.getTitle(),
                            datasource.getType(),
                            datasource.getSubscribeDetail(),
                            datasource.getContent(),
                            datasource.getScriptFilter()
                    );
                    
                    // 处理接收到的消息
                    messageProcessor.processMessage(message, datasourceInfo, datasource.getScriptFilter());

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
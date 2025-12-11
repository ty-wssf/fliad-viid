package com.fliad.gps.service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Init;
import org.noear.solon.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * RabbitMQ生产者服务类
 */
@Component
public class RabbitMQProducerService {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQProducerService.class);

    // RabbitMQ服务器地址
    @Inject("${rabbitmq.host}")
    private String host;

    // RabbitMQ服务器端口
    @Inject("${rabbitmq.port}")
    private int port;

    // RabbitMQ用户名
    @Inject("${rabbitmq.username}")
    private String username;

    // RabbitMQ密码
    @Inject("${rabbitmq.password}")
    private String password;

    // RabbitMQ交换机名称
    @Inject("${rabbitmq.exchange}")
    private String exchange;

    // RabbitMQ路由键
    @Inject("${rabbitmq.routingKey}")
    private String routingKey;

    // RabbitMQ实时数据路由键
    @Inject("${rabbitmq.realtimeRoutingKey}")
    private String realtimeRoutingKey;

    private Connection connection;
    private Channel channel;

    @Init
    public void init() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(host);
            factory.setPort(port);
            factory.setUsername(username);
            factory.setPassword(password);

            connection = factory.newConnection();
            channel = connection.createChannel();

            // 声明交换机
            if (exchange != null && !exchange.isEmpty()) {
                channel.exchangeDeclare(exchange, "topic", true);
            }

            logger.info("RabbitMQ生产者初始化完成，服务器地址: {}:{}", host, port);
        } catch (IOException | TimeoutException e) {
            logger.error("初始化RabbitMQ生产者时发生错误", e);
            throw new RuntimeException("初始化RabbitMQ生产者失败", e);
        }
    }

    /**
     * 发送消息到指定队列
     *
     * @param message 消息内容
     */
    public void sendMessage(String message) {
        try {
            channel.basicPublish(exchange, routingKey, null, message.getBytes(StandardCharsets.UTF_8));
            logger.debug("成功发送消息到RabbitMQ: {}", message);
        } catch (Exception e) {
            logger.error("发送消息到RabbitMQ时发生错误", e);
            throw new RuntimeException("发送消息到RabbitMQ失败", e);
        }
    }

    /**
     * 发送消息到指定队列，可自定义路由键
     *
     * @param message    消息内容
     * @param routingKey 路由键
     */
    public void sendMessage(String message, String routingKey) {
        try {
            channel.basicPublish(exchange, routingKey, null, message.getBytes(StandardCharsets.UTF_8));
            logger.debug("成功发送消息到RabbitMQ，路由键: {}，消息: {}", routingKey, message);
        } catch (Exception e) {
            logger.error("发送消息到RabbitMQ时发生错误", e);
            throw new RuntimeException("发送消息到RabbitMQ失败", e);
        }
    }

    /**
     * 发送实时GPS数据消息
     *
     * @param message 消息内容
     */
    public void sendRealtimeMessage(String message) {
        sendMessage(message, realtimeRoutingKey);
    }

    /**
     * 关闭RabbitMQ连接
     */
    public void close() {
        try {
            if (channel != null && channel.isOpen()) {
                channel.close();
                logger.info("RabbitMQ频道已关闭");
            }
            if (connection != null && connection.isOpen()) {
                connection.close();
                logger.info("RabbitMQ连接已关闭");
            }
        } catch (Exception e) {
            logger.error("关闭RabbitMQ连接时发生错误", e);
        }
    }
}
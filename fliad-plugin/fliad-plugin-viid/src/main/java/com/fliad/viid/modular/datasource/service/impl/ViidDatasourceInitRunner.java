/*
 * Copyright [2022] [https://www.xiaonuo.vip]
 *
 * Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：
 *
 * 1.请不要删除和修改根目录下的LICENSE文件。
 * 2.请不要删除和修改Snowy源码头部的版权声明。
 * 3.本项目代码可免费商业使用，商业使用请保留源码和相关描述文件的项目出处，作者声明等。
 * 4.分发源码时候，请注明软件出处 https://www.xiaonuo.vip
 * 5.不可二次分发开源参与同类竞品，如有想法可联系团队xiaonuobase@qq.com商议合作。
 * 6.若您的项目无法满足以上几点，需要更多功能代码，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package com.fliad.viid.modular.datasource.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.fliad.viid.modular.datasource.entity.ViidDatasource;
import com.fliad.viid.modular.datasource.service.ViidDatasourceService;
import com.fliad.viid.modular.flowgram.domain.TaskRunInput;
import com.fliad.viid.modular.flowgram.service.FlowgramService;
import com.fliad.viid.modular.workflow.entity.ViidWorkflow;
import com.fliad.viid.modular.workflow.service.ViidWorkflowService;
import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;

/**
 * 数据源初始化运行器
 * 服务启动时初始化数据源，根据订阅类别来订阅数据
 *
 * @author wyl
 * @date 2025/09/25 10:00
 **/
@Slf4j
@Component
public class ViidDatasourceInitRunner implements LifecycleBean {

    @Inject
    private ViidDatasourceService viidDatasourceService;

    @Inject
    private ViidWorkflowService viidWorkflowService;

    @Inject
    private FlowgramService flowgramService;

    // 存储数据源连接信息
    private final Map<String, Connection> datasourceConnections = new ConcurrentHashMap<>();

    // 存储数据源频道信息
    private final Map<String, Channel> datasourceChannels = new ConcurrentHashMap<>();

    @Override
    public void start() throws Throwable {
        log.info(">>> 开始初始化数据源 <<<");
        try {
            // 获取所有启用的数据源
            List<ViidDatasource> enabledDatasources = viidDatasourceService.listByStatus("ENABLE");
            if (enabledDatasources != null && !enabledDatasources.isEmpty()) {
                log.info("找到 {} 个启用的数据源，开始初始化", enabledDatasources.size());
                for (ViidDatasource datasource : enabledDatasources) {
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
    private void initDatasourceConnection(ViidDatasource datasource) {
        log.info("开始初始化数据源，ID：{}，标题：{}，类型：{}，订阅类别：{}",
                datasource.getId(), datasource.getTitle(), datasource.getType(), datasource.getSubscribeDetail());

        // 根据不同类型初始化连接
        switch (datasource.getType()) {
            case "rabbitmq":
                initRabbitMQConnection(datasource);
                break;
            default:
                log.warn("不支持的数据源类型：{}", datasource.getType());
                break;
        }
    }

    /**
     * 初始化 RabbitMQ 连接
     *
     * @param datasource 数据源实体
     */
    private void initRabbitMQConnection(ViidDatasource datasource) {
        // 解析配置信息
        if (StrUtil.isBlank(datasource.getContent())) {
            log.warn("数据源配置内容为空，数据源ID：{}", datasource.getId());
            return;
        }

        try {
            // 解析 RabbitMQ 配置
            Map<String, Object> config = JSONUtil.toBean(datasource.getContent(), Map.class);
            String host = (String) config.get("host");
            Integer port = (Integer) config.get("port");
            String username = (String) config.get("username");
            String password = (String) config.get("password");
            String exchange = (String) config.get("exchange");
            String routingKey = (String) config.get("routingKey");
            String queueName = (String) config.get("queueName");

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
    private void createConsumer(Channel channel, String queueName, ViidDatasource datasource) {
        try {
            // 创建消费者
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                log.info("接收消息，数据源ID：{}，订阅类别：{}，消息大小：{}",
                        datasource.getId(), datasource.getSubscribeDetail(), message.length());

                try {
                    // 处理接收到的消息
                    processMessage(message, datasource);

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
    private void processMessage(String message, ViidDatasource datasource) {
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
            List<ViidWorkflow> workflowList = viidWorkflowService.findBySubscribeDetail(subscribeDetail);
            log.debug("找到 {} 个工作流处理数据", workflowList.size());

            // 如果没有找到处理流程，打印提示信息
            if (workflowList.isEmpty()) {
                log.warn("未找到处理流程，订阅类别：{}", subscribeDetail);
                return;
            }

            // 执行工作流
            for (ViidWorkflow workflow : workflowList) {
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

        datasourceChannels.clear();
        datasourceConnections.clear();
    }
}
package com.fliad.viid.modular.flowgram.components;

import com.fliad.viid.modular.flowgram.domain.TaskReportOutput;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.expression.snel.SnEL;
import org.noear.solon.flow.FlowContext;
import org.noear.solon.flow.Node;
import org.noear.solon.flow.TaskComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component("rabbitmq")
public class RabbitmqCom implements TaskComponent {
    private static final Logger log = LoggerFactory.getLogger(RabbitmqCom.class);

    @Override
    public void run(FlowContext context, Node node) throws Throwable {
        Channel channel = (Channel) node.attachment;
        Connection connection = null;
        ONode inputsValues; // 提取到方法作用域内

        if (channel == null || !channel.isOpen()) {
            // 1. 创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            log.debug("创建新的RabbitMQ连接工厂");

            // 2. 配置服务器参数（根据实际情况修改）
            ONode metas = ONode.load(node.getMetas());
            inputsValues = metas.select("data.inputsValues");

            // 提取 IP 地址配置
            String ip = String.valueOf(extractConfigFromInputs(context, inputsValues, "ip"));
            if (ip != null && !ip.isEmpty()) {
                factory.setHost(ip);
                log.debug("设置RabbitMQ主机地址: {}", ip);
            } else {
                factory.setHost("localhost"); // 默认主机
                log.warn("未配置RabbitMQ主机地址，使用默认值: localhost");
            }

            // 提取端口配置
            String port = String.valueOf(extractConfigFromInputs(context, inputsValues, "port"));
            if (port != null && !port.isEmpty()) {
                try {
                    factory.setPort(Integer.parseInt(port));
                    log.debug("设置RabbitMQ端口: {}", port);
                } catch (NumberFormatException e) {
                    // 默认端口
                    factory.setPort(5672);
                    log.warn("RabbitMQ端口配置无效，使用默认端口: 5672");
                }
            } else {
                // 默认端口
                factory.setPort(5672);
                log.debug("使用默认RabbitMQ端口: 5672");
            }

            // 提取用户名配置
            String username = String.valueOf(extractConfigFromInputs(context, inputsValues, "username"));
            if (username != null && !username.isEmpty()) {
                factory.setUsername(username);
                log.debug("设置RabbitMQ用户名: {}", username);
            } else {
                log.warn("未配置RabbitMQ用户名");
            }

            // 提取密码配置
            String password = String.valueOf(extractConfigFromInputs(context, inputsValues, "password"));
            if (password != null && !password.isEmpty()) {
                factory.setPassword(password);
                log.debug("已设置RabbitMQ密码");
            } else {
                log.warn("未配置RabbitMQ密码");
            }

            // 创建连接和通道
            connection = factory.newConnection();
            channel = connection.createChannel();

            // 保存通道到 attachment 以供后续使用
            node.attachment = channel;
            log.debug("RabbitMQ通道已保存到node attachment");
        } else {
            // 如果 channel 已存在且打开，也需要获取 inputsValues
            log.debug("使用已存在的RabbitMQ通道");
            ONode metas = ONode.load(node.getMetas());
            inputsValues = metas.select("data.inputsValues");
        }

        // 发送消息到 RabbitMQ
        Object msg = extractConfigFromInputs(context, inputsValues, "msg");
        String exchange = String.valueOf(extractConfigFromInputs(context, inputsValues, "exchange"));
        String routingKey = String.valueOf(extractConfigFromInputs(context, inputsValues, "routingKey"));

        if (msg != null) {
            // log.info("准备发送消息到RabbitMQ, exchange: {}, routingKey: {}", exchange, routingKey);
            try {
                // 发送消息
                channel.basicPublish(
                        exchange != null ? exchange : "",
                        routingKey != null ? routingKey : "",
                        null,
                        ONode.stringify(msg).getBytes(StandardCharsets.UTF_8)
                );

                // 创建结果对象
                Map<String, Object> resultMap = new HashMap<>();
                resultMap.put("msg", msg);
                context.put("output", resultMap);
                // log.info("消息已成功发送到RabbitMQ成功");
            } finally {
                // 不再关闭资源，因为我们要复用通道
                log.debug("消息已发送，保持通道开启以供复用");
            }
        } else {
            log.warn("消息内容为空，跳过发送");
        }
    }

    /**
     * 从输入值中提取配置项
     *
     * @param flowContext  流程上下文
     * @param inputsValues 输入值节点
     * @param configKey    配置项键名
     * @return 配置项值
     */
    private Object extractConfigFromInputs(FlowContext flowContext, ONode inputsValues, String configKey) {
        final Object[] value = {null};
        TaskReportOutput report = flowContext.getAs("report");
        inputsValues.forEach((key, val) -> {
            if ("constant".equals(val.get("type").getString())) {
                if (configKey.equals(key)) {
                    value[0] = val.get("content").getString();
                }
            } else if ("ref".equals(val.get("type").getString())) {
                if (configKey.equals(key)) {
                    String nodeID = val.get("content").get(0).getString();
                    value[0] = SnEL.eval(val.get("content").get(1).getString(), report.getNodeStatus(nodeID).getLastSnapshot().getOutputs());
                }
            }
        });
        log.trace("提取配置项: {} = {}", configKey, value[0]);
        return value[0];
    }
}
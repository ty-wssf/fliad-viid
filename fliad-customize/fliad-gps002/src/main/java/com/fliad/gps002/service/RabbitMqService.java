package com.fliad.gps002.service;

import com.fliad.gps002.entity.VehicleRecord;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.noear.snack4.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class RabbitMqService {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqService.class);

    @Inject
    private Connection connection;

    @Inject("${rabbitmq}")
    private com.fliad.gps002.config.RabbitMQProperties rabbitProperties;

    private Channel channel;

    public boolean initialize() {
        try {
            channel = connection.createChannel();

            // Declare exchange
            channel.exchangeDeclare(rabbitProperties.getExchange(), "topic", true);
            return true;
        } catch (IOException e) {
            logger.error("Failed to initialize RabbitMQ channel", e);
            return false;
        }
    }

    public void sendMessage(VehicleRecord record) {
        try {
            String message = ONode.ofBean(record).toString();
            channel.basicPublish(rabbitProperties.getExchange(), "", null, message.getBytes());
            logger.info("Sent message for vehicle: {}", record.getVehicle_no());
        } catch (IOException e) {
            logger.error("Failed to send message to RabbitMQ", e);
        }
    }

    public void close() {
        try {
            if (channel != null && channel.isOpen()) {
                channel.close();
            }
        } catch (IOException | RuntimeException | TimeoutException e) {
            logger.error("Error closing RabbitMQ channel", e);
        }
    }
}
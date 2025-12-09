package com.fliad.gps002.config;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * RabbitMQ配置类
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Connection rabbitConnectionFactory(@Inject("${rabbitmq}") RabbitMQProperties rabbitProps) 
            throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitProps.getHost());
        factory.setPort(rabbitProps.getPort());
        factory.setUsername(rabbitProps.getUsername());
        factory.setPassword(rabbitProps.getPassword());
        
        return factory.newConnection();
    }
}
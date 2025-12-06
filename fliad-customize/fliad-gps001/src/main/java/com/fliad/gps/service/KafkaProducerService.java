package com.fliad.gps.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * Kafka生产者服务类
 */
@Component
public class KafkaProducerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    // Kafka服务器地址
    @Inject("${kafka.bootstrap.servers}")
    private String bootstrapServers;

    private KafkaProducer<String, String> producer;

    @PostConstruct
    public void init() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 提高可靠性
        props.put(ProducerConfig.ACKS_CONFIG, "1");
        props.put(ProducerConfig.RETRIES_CONFIG, 3);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 100);
        
        producer = new KafkaProducer<>(props);
        logger.info("Kafka生产者初始化完成，服务器地址: {}", bootstrapServers);
    }

    /**
     * 发送消息到指定主题
     *
     * @param topic 主题名称
     * @param message 消息内容
     */
    public void sendMessage(String topic, String message) {
        try {
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
            producer.send(record);
            logger.debug("成功发送消息到Kafka主题 '{}': {}", topic, message);
        } catch (Exception e) {
            logger.error("发送消息到Kafka时发生错误", e);
            throw new RuntimeException("发送消息到Kafka失败", e);
        }
    }
    
    /**
     * 关闭Kafka生产者
     */
    public void close() {
        if (producer != null) {
            producer.close();
            logger.info("Kafka生产者已关闭");
        }
    }
}
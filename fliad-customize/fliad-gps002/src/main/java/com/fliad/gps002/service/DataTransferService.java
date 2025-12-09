package com.fliad.gps002.service;

import com.fliad.gps002.entity.GpsData;
import com.fliad.gps002.entity.VehicleRecord;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DataTransferService {
    private static final Logger logger = LoggerFactory.getLogger(DataTransferService.class);
    
    @Inject
    private FtpService ftpService;
    
    @Inject
    private RabbitMqService rabbitMqService;
    
    @Scheduled(fixedRate = 60 * 1000) // 每分钟执行一次
    public void transferData() {
        logger.info("Starting GPS data transfer");
        
        try {
            // 连接FTP
            if (!ftpService.connect()) {
                logger.error("Failed to connect to FTP server");
                return;
            }
            logger.info("Connected to FTP server");
            
            // 初始化RabbitMQ
            if (!rabbitMqService.initialize()) {
                logger.error("Failed to initialize RabbitMQ");
                ftpService.disconnect();
                return;
            }
            logger.info("Initialized RabbitMQ");
            
            // 读取数据
            GpsData gpsData = ftpService.readJsonFile();
            if (gpsData == null) {
                logger.error("Failed to read GPS data from FTP");
                cleanup();
                return;
            }
            
            logger.info("Successfully read {} vehicle records from FTP", gpsData.getRecords().size());
            
            // 发送每条记录到RabbitMQ
            for (VehicleRecord record : gpsData.getRecords()) {
                rabbitMqService.sendMessage(record);
                try {
                    // 小延迟避免消息队列过载
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.warn("Processing thread was interrupted", e);
                    break;
                }
            }
            
            logger.info("Finished processing {} vehicle records", gpsData.getRecords().size());
            
        } catch (Exception e) {
            logger.error("Error during data transfer", e);
        } finally {
            cleanup();
        }
    }
    
    private void cleanup() {
        try {
            ftpService.disconnect();
            rabbitMqService.close();
        } catch (Exception e) {
            logger.error("Error during cleanup", e);
        }
    }
}
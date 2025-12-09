package com.fliad.gps002.service;

import com.fliad.gps002.entity.VehicleRecord;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Init;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class DataTransferService {
    private static final Logger logger = LoggerFactory.getLogger(DataTransferService.class);

    @Inject
    private FtpService ftpService;

    @Inject
    private RabbitMqService rabbitMqService;

    private final AtomicBoolean running = new AtomicBoolean(false);
    private Thread processingThread;

    @Init
    public void startProcessing() {
        if (running.compareAndSet(false, true)) {
            processingThread = new Thread(this::processLoop, "DataTransferService-Thread");
            processingThread.setDaemon(false);
            processingThread.start();
            logger.info("Data transfer service started");
        }
    }

    private void processLoop() {
        while (running.get()) {
            try {
                transferDataOnce();

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.info("Data transfer service interrupted");
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                logger.error("Error in data transfer loop", e);

                // 发生异常时等待一段时间再重试
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    logger.info("Data transfer service interrupted during error wait");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

        logger.info("Data transfer service stopped");
    }

    private void transferDataOnce() {
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

            // 流式处理数据，逐条发送到RabbitMQ
            AtomicLong processedRecords = new AtomicLong(0);
            boolean success = ftpService.processDataFiles(record -> {
                rabbitMqService.sendMessage(record);
                long count = processedRecords.incrementAndGet();

                // 每处理100条记录输出一次日志
                if (count % 1000 == 0) {
                    logger.info("Processed {} records success", count);
                }
            });

            if (success) {
                logger.info("Finished processing vehicle records, total count: {}", processedRecords.get());
            } else {
                logger.error("Failed to process data files");
            }

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

    public void stopProcessing() {
        if (running.compareAndSet(true, false)) {
            if (processingThread != null && processingThread.isAlive()) {
                processingThread.interrupt();
            }
            logger.info("Data transfer service stop requested");
        }
    }
}
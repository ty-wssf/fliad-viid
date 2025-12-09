package com.fliad.gps002.service;

import com.fliad.gps002.entity.GpsData;
import com.fliad.gps002.entity.VehicleRecord;
import org.apache.commons.net.ftp.FTPClient;
import org.noear.snack4.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.util.IoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.net.ftp.FTPFile;

@Component
public class FtpService {
    private static final Logger logger = LoggerFactory.getLogger(FtpService.class);

    @Inject
    private FTPClient ftpClient;

    @Inject("${ftp}")
    private com.fliad.gps002.config.FtpProperties ftpProperties;

    public boolean connect() {
        try {
            ftpClient.connect(ftpProperties.getServer(), ftpProperties.getPort());
            // 设置被动模式
            ftpClient.enterLocalPassiveMode();
            return ftpClient.login(ftpProperties.getUsername(), ftpProperties.getPassword());
        } catch (IOException e) {
            logger.error("Failed to connect to FTP server", e);
            return false;
        }
    }

    public boolean processDataFiles(Consumer<VehicleRecord> recordProcessor) {
        try {
            processJsonFilesRecursively(ftpProperties.getFile(), recordProcessor);
            return true;
        } catch (Exception e) {
            logger.error("Failed to process JSON files from directory: {}", ftpProperties.getFile(), e);
            return false;
        }
    }

    /**
     * 递归处理FTP目录中的所有JSON文件，逐条处理记录
     *
     * @param directoryPath 目录路径
     * @param recordProcessor 记录处理器
     */
    private void processJsonFilesRecursively(String directoryPath, Consumer<VehicleRecord> recordProcessor) throws IOException {
        // 先切换到根目录，确保路径正确性
        ftpClient.changeWorkingDirectory("/");
        
        // 列出目录中的所有文件和子目录
        FTPFile[] files = ftpClient.listFiles(directoryPath);

        if (files != null) {
            for (FTPFile file : files) {
                String fileName = file.getName();
                String fullPath = directoryPath + "/" + fileName;
                
                // 跳过当前目录和父目录
                if (".".equals(fileName) || "..".equals(fileName)) {
                    continue;
                }
                
                // 如果是目录，则递归处理
                if (file.isDirectory()) {
                    processJsonFilesRecursively(fullPath, recordProcessor);
                } 
                // 如果是文件且以.dat结尾，则处理
                else if (file.isFile() && fileName.toLowerCase().endsWith(".dat")) {
                    processJsonFile(fullPath, recordProcessor);
                }
            }
        }
    }
    
    /**
     * 处理单个JSON文件，逐条处理其中的记录
     *
     * @param filePath 文件路径
     * @param recordProcessor 记录处理器
     */
    private void processJsonFile(String filePath, Consumer<VehicleRecord> recordProcessor) {
        try (InputStream inputStream = ftpClient.retrieveFileStream(filePath)) {
            if (inputStream != null) {
                String gpsDataStr = IoUtil.transferToString(inputStream);
                GpsData gpsData = ONode.deserialize(gpsDataStr, GpsData.class);
                if (gpsData != null && gpsData.getRecords() != null) {
                    for (VehicleRecord record : gpsData.getRecords()) {
                        recordProcessor.accept(record);
                    }
                }
                ftpClient.completePendingCommand();
                logger.info("Processed file: {}, records count: {}", filePath, 
                    gpsData != null && gpsData.getRecords() != null ? gpsData.getRecords().size() : 0);
            } else {
                logger.warn("Failed to retrieve file: {}", filePath);
            }
        } catch (Exception e) {
            logger.error("Failed to process JSON file: {}", filePath, e);
        }
    }

    public void disconnect() {
        try {
            if (ftpClient.isConnected()) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            logger.error("Error disconnecting from FTP server", e);
        }
    }
}
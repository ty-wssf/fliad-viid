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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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
                // 如果是文件且以.zip结尾，则处理
                else if (file.isFile() && fileName.toLowerCase().endsWith(".zip")) {
                    processJsonFile(fullPath, recordProcessor);
                }
            }
        }
    }
    
    /**
     * 处理单个ZIP文件，解压后处理其中的JSON数据
     *
     * @param filePath 文件路径
     * @param recordProcessor 记录处理器
     */
    private void processJsonFile(String filePath, Consumer<VehicleRecord> recordProcessor) {
        LocalDateTime zipStart = LocalDateTime.now();
        int fileCount = 0;
        long totalRecords = 0;
        
        try (InputStream inputStream = ftpClient.retrieveFileStream(filePath)) {
            if (inputStream != null) {
                // 使用ZipInputStream处理ZIP文件
                try (ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
                    ZipEntry entry;
                    while ((entry = zipInputStream.getNextEntry()) != null) {
                        // 只处理非目录的文件
                        if (!entry.isDirectory()) {
                            LocalDateTime fileStart = LocalDateTime.now();
                            fileCount++;
                            
                            String gpsDataStr = IoUtil.transferToString(zipInputStream);
                            GpsData gpsData = ONode.deserialize(gpsDataStr, GpsData.class);
                            if (gpsData != null && gpsData.getRecords() != null) {
                                int recordCount = 0;
                                for (VehicleRecord record : gpsData.getRecords()) {
                                    recordProcessor.accept(record);
                                    recordCount++;
                                }
                                totalRecords += recordCount;
                                
                                LocalDateTime fileEnd = LocalDateTime.now();
                                long fileDuration = ChronoUnit.MILLIS.between(fileStart, fileEnd);
                                logger.info("Processed file '{}' from ZIP '{}' with {} records in {} ms", 
                                    entry.getName(), filePath, recordCount, fileDuration);
                            }
                        }
                        // 关闭当前entry
                        zipInputStream.closeEntry();
                    }
                }
                ftpClient.completePendingCommand();
                
                LocalDateTime zipEnd = LocalDateTime.now();
                long zipDuration = ChronoUnit.MILLIS.between(zipStart, zipEnd);
                logger.info("Processed ZIP file: {} with {} files and {} records in {} ms", 
                    filePath, fileCount, totalRecords, zipDuration);
                
                // 删除已处理的文件
                boolean deleted = ftpClient.deleteFile(filePath);
                if (deleted) {
                    logger.info("Successfully deleted file: {}", filePath);
                } else {
                    logger.warn("Failed to delete file: {}", filePath);
                }
            } else {
                logger.warn("Failed to retrieve file: {}", filePath);
            }
        } catch (Exception e) {
            LocalDateTime zipEnd = LocalDateTime.now();
            long zipDuration = ChronoUnit.MILLIS.between(zipStart, zipEnd);
            logger.error("Failed to process ZIP file: {} in {} ms", filePath, zipDuration, e);
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
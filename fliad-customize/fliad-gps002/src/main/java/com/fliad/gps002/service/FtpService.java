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
            return ftpClient.login(ftpProperties.getUsername(), ftpProperties.getPassword());
        } catch (IOException e) {
            logger.error("Failed to connect to FTP server", e);
            return false;
        }
    }

    public GpsData readJsonFile() {
        try {
            return readJsonFilesRecursively(ftpProperties.getFile());
        } catch (Exception e) {
            logger.error("Failed to read JSON files from directory: {}", ftpProperties.getFile(), e);
            return null;
        }
    }

    /**
     * 递归读取FTP目录中的所有JSON文件
     *
     * @param directoryPath 目录路径
     * @return 合并后的GpsData对象
     */
    private GpsData readJsonFilesRecursively(String directoryPath) {
        GpsData mergedData = new GpsData();
        List<VehicleRecord> allRecords = new ArrayList<>();
        
        try {
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
                        GpsData subData = readJsonFilesRecursively(fullPath);
                        if (subData != null && subData.getRecords() != null) {
                            allRecords.addAll(subData.getRecords());
                        }
                    } 
                    // 如果是文件且以.json结尾，则处理
                    else if (file.isFile() && fileName.toLowerCase().endsWith(".json")) {
                        try (InputStream inputStream = ftpClient.retrieveFileStream(fullPath)) {
                            if (inputStream != null) {
                                GpsData gpsData = ONode.ofJson(IoUtil.transferToString(inputStream)).toBean();
                                if (gpsData != null && gpsData.getRecords() != null) {
                                    allRecords.addAll(gpsData.getRecords());
                                }
                                ftpClient.completePendingCommand();
                            } else {
                                logger.warn("Failed to retrieve file: {}", fullPath);
                            }
                        } catch (Exception e) {
                            logger.error("Failed to read JSON file: {}", fullPath, e);
                        }
                    }
                }
            }
            
            // 设置合并后的数据
            mergedData.setRecords(allRecords);
            mergedData.setPageNum(1);
            mergedData.setPageSize(allRecords.size());
            mergedData.setTotalNum(allRecords.size());
            mergedData.setTotalPages(1);
            
        } catch (IOException e) {
            logger.error("Failed to list files in directory: {}", directoryPath, e);
            return null;
        }
        
        return mergedData;
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
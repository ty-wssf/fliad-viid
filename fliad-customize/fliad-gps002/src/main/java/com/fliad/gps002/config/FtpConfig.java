package com.fliad.gps002.config;

import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Inject;
import org.apache.commons.net.ftp.FTPClient;

/**
 * FTP配置类
 */
@Configuration
public class FtpConfig {

    @Bean
    public FTPClient ftpClient(@Inject("${ftp}") FtpProperties ftpProps) {
        FTPClient ftpClient = new FTPClient();
        return ftpClient;
    }
}
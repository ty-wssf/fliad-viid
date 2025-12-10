package com.fliad.gps.service;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import com.fliad.gps.model.GpsData;
import org.noear.snack4.Feature;
import org.noear.snack4.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Doris Stream Load 服务类
 */
@Component
public class DorisStreamLoadService {
    private static final Logger logger = LoggerFactory.getLogger(DorisStreamLoadService.class);

    @Inject("${solon.datasource.doris.username}")
    private String dorisUsername;

    @Inject("${solon.datasource.doris.password}")
    private String dorisPassword;

    @Inject("${solon.datasource.doris.jdbcUrl}")
    private String dorisJdbcUrl;

    // Doris HTTP端口，默认为8030
    @Inject("${solon.datasource.doris.httpPort:8030}")
    private int dorisHttpPort;

    /**
     * 使用Stream Load方式将GPS数据写入Doris
     *
     * @param gpsDataList GPS数据列表
     * @param tableName   目标表名
     */
    public void writeGpsDataToDoris(List<GpsData> gpsDataList, String tableName) {
        if (gpsDataList == null || gpsDataList.isEmpty()) {
            logger.info("没有数据需要写入Doris");
            return;
        }

        try {
            // 从JDBC URL中提取FE地址
            String feAddress = extractFeAddress(dorisJdbcUrl);
            // 替换端口为HTTP端口
            feAddress = replacePort(feAddress, dorisHttpPort);

            String databaseName = extractDatabaseName(dorisJdbcUrl);

            // 构建Stream Load URL
            String streamLoadUrl = String.format("http://%s/api/%s/%s/_stream_load",
                    feAddress, databaseName, tableName);

            // 发送HTTP请求
            String response = sendStreamLoadRequest(streamLoadUrl, ONode.ofBean(gpsDataList, Feature.Write_UseSmlSnakeStyle).toString().getBytes(StandardCharsets.UTF_8));

            logger.info("成功通过Stream Load方式写入 {} 条GPS数据到Doris，响应: {}", gpsDataList.size(), response);
        } catch (Exception e) {
            logger.error("通过Stream Load方式写入Doris时发生错误", e);
            throw new RuntimeException("Stream Load写入失败", e);
        }
    }

    /**
     * 从JDBC URL中提取FE地址
     *
     * @param jdbcUrl JDBC连接URL
     * @return FE地址 (host:port)
     */
    private String extractFeAddress(String jdbcUrl) {
        // jdbc:mysql://10.20.10.61:9030/ods?useSSL=false&serverTimezone=UTC
        String prefix = "jdbc:mysql://";
        if (jdbcUrl.startsWith(prefix)) {
            String hostPortPart = jdbcUrl.substring(prefix.length());
            int slashIndex = hostPortPart.indexOf('/');
            if (slashIndex > 0) {
                return hostPortPart.substring(0, slashIndex);
            }
        }
        throw new IllegalArgumentException("无法从JDBC URL中提取FE地址: " + jdbcUrl);
    }

    /**
     * 替换地址中的端口号
     *
     * @param address 原始地址 (host:port)
     * @param newPort 新端口号
     * @return 替换端口后的地址
     */
    private String replacePort(String address, int newPort) {
        int colonIndex = address.lastIndexOf(':');
        if (colonIndex > 0) {
            // 提取主机名部分
            String host = address.substring(0, colonIndex);
            return host + ":" + newPort;
        } else {
            // 没有找到端口号，直接添加
            return address + ":" + newPort;
        }
    }

    /**
     * 从JDBC URL中提取数据库名
     *
     * @param jdbcUrl JDBC连接URL
     * @return 数据库名
     */
    private String extractDatabaseName(String jdbcUrl) {
        // jdbc:mysql://10.20.10.61:9030/ods?useSSL=false&serverTimezone=UTC
        int lastSlashIndex = jdbcUrl.lastIndexOf('/');
        if (lastSlashIndex > 0) {
            int questionMarkIndex = jdbcUrl.indexOf('?', lastSlashIndex);
            if (questionMarkIndex > 0) {
                return jdbcUrl.substring(lastSlashIndex + 1, questionMarkIndex);
            } else {
                return jdbcUrl.substring(lastSlashIndex + 1);
            }
        }
        throw new IllegalArgumentException("无法从JDBC URL中提取数据库名: " + jdbcUrl);
    }

    /**
     * 发送Stream Load请求
     *
     * @param streamLoadUrl Stream Load URL
     * @param data          要发送的数据
     * @return 响应内容
     */
    private String sendStreamLoadRequest(String streamLoadUrl, byte[] data) throws Exception {
        // 设置认证信息
        String authString = dorisUsername + ":" + dorisPassword;
        String encodedAuth = Base64.encode(authString.getBytes(StandardCharsets.UTF_8));

        // 使用Hutool发送HTTP PUT请求，启用自动重定向处理
        HttpResponse response = HttpRequest.put(streamLoadUrl)
                .setFollowRedirects(true) // 启用自动重定向处理
                .header("Authorization", "Basic " + encodedAuth)
                .header("Expect", "100-continue")
                .header("label", "label_" + System.currentTimeMillis())
                .header("format", "json")
                .header("strip_outer_array", "true")
                .body(data)
                .timeout(30000)
                .execute();

        // 检查最终响应状态
        if (response.getStatus() != HttpStatus.HTTP_OK) {
            throw new RuntimeException("Stream Load请求失败，响应码: " + response.getStatus() + "，响应内容: " + response.body());
        }

        return response.body();
    }
}
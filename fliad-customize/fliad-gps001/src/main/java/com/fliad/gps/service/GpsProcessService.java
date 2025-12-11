package com.fliad.gps.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.fliad.gps.dao.GpsDao;
import com.fliad.gps.entity.Cross;
import com.fliad.gps.entity.RoadSegment;
import com.fliad.gps.model.GpsData;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.io.WKTReader;
import org.noear.snack4.Feature;
import org.noear.snack4.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.util.RunUtil;
import org.noear.solon.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * GPS数据处理服务类（基于Solon框架）
 */
@Component
public class GpsProcessService {
    private static final Logger logger = LoggerFactory.getLogger(GpsProcessService.class);

    // 几何工厂（指定坐标系，WGS84对应SRID=4326）
    private static final GeometryFactory GEOM_FACTORY = new GeometryFactory(new PrecisionModel(), 4326);
    private static final WKTReader WKT_READER = new WKTReader(GEOM_FACTORY);

    @Inject
    private GpsDao gpsDao;

    @Inject("doris")
    private DataSource dorisDataSource;

    @Inject
    private DorisStreamLoadService dorisStreamLoadService;

    @Inject
    private RabbitMQProducerService rabbitMQProducerService;

    @Inject("${gps.api.lkyw.url}")
    private String lkywApiUrl;

    @Inject("${gps.api.lkyw.token}")
    private String lkywApiToken;

    @Inject("${gps.api.hc.url}")
    private String hcApiUrl;

    @Inject("${gps.api.hc.token}")
    private String hcApiToken;

    // 是否写入Doris配置项
    @Inject("${gps.process.writeDoris:true}")
    private boolean writeDoris;

    // 全局共享的GPS处理服务实例
    private GpsProcessingService processingService;

    // 同步任务正在进行标识
    private final AtomicBoolean syncInProgress = new AtomicBoolean(false);

    /**
     * 查询Doris数据库中最新的GPS数据时间戳
     *
     * @return 最新的GPS数据时间戳，如果无数据则返回null
     */
    private Long getLatestGpsTimestampFromDoris() {
        String sql = "SELECT MAX(gps_time) as latest_time FROM gps_data_table";

        try (Connection conn = dorisDataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                String latestTimeString = rs.getString("latest_time");
                if (latestTimeString != null && !latestTimeString.isEmpty()) {
                    // 尝试解析时间字符串
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime latestTime = LocalDateTime.parse(latestTimeString, formatter);
                        return latestTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    } catch (Exception e) {
                        logger.warn("解析最新GPS时间戳时出错: {}", e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            logger.error("查询Doris数据库最新GPS时间戳时发生错误", e);
        }

        return null; // 数据库中没有数据或者查询出错
    }

    /**
     * 服务启动时初始化处理服务
     */
    public void init() {
        try {
            logger.info("初始化GPS处理服务...");

            // 获取路口和路段数据
            List<Cross> crosses = gpsDao.getAllCrosses();
            List<RoadSegment> roadSegments = gpsDao.getAllRoadSegments();

            logger.info("加载路口数据: {} 条", crosses.size());
            logger.info("加载路段数据: {} 条", roadSegments.size());

            // 创建GPS处理服务（只创建一次）
            processingService = new GpsProcessingService(crosses, roadSegments);

            logger.info("GPS处理服务初始化完成");
        } catch (Exception e) {
            logger.error("初始化GPS处理服务时发生错误", e);
        }
    }

    /**
     * 每分钟执行一次的定时任务
     */
    @Scheduled(fixedRate = 60 * 1000)
    public void processGpsDataJob() {
        // 检查是否已经有同步任务正在进行
        if (!syncInProgress.compareAndSet(false, true)) {
            logger.info("检测到有同步任务正在进行，本次调度直接退出");
            return;
        }

        try {
            logger.info("开始处理GPS数据...");

            // 确保处理服务已经初始化
            if (processingService == null) {
                init();

                // 如果初始化仍然失败，则返回
                if (processingService == null) {
                    logger.error("GPS处理服务未初始化，无法处理数据");
                    return;
                }
            }

            // 获取Doris数据库中的最新GPS数据时间戳
            Long latestTimestamp = getLatestGpsTimestampFromDoris();
            long startTime;

            if (latestTimestamp == null) {
                // 第一次同步，使用当前时间前20分钟作为起始时间
                startTime = System.currentTimeMillis() - 20 * 60 * 1000;
                logger.info("首次同步，使用默认起始时间: {} 分钟前", 20);
            } else {
                // 基于最新数据时间继续同步，增加1秒避免重复获取
                startTime = latestTimestamp + 1000;
                logger.info("基于最新数据时间继续同步: {}",
                        LocalDateTime.ofInstant(Instant.ofEpochMilli(startTime), ZoneId.systemDefault()));
            }

            // 设置结束时间为当前时间前5分钟
            long endTimeLimit = System.currentTimeMillis() - 2 * 60 * 1000;

            // 循环同步，直到达到时间限制
            int totalProcessedCount = 0;
            while (startTime < endTimeLimit) {
                // 检查是否已经有其他任务在运行（额外保护）
                if (!syncInProgress.get()) {
                    logger.warn("同步任务被中断");
                    break;
                }

                // 每次同步30秒的数据
                long endTime = Math.min(startTime + 30 * 1000 - 1, endTimeLimit);

                // 转换为日期时间格式
                LocalDateTime startDateTime = Instant.ofEpochMilli(startTime).atZone(ZoneId.systemDefault()).toLocalDateTime();
                LocalDateTime endDateTime = Instant.ofEpochMilli(endTime).atZone(ZoneId.systemDefault()).toLocalDateTime();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String startTimeStr = startDateTime.format(formatter);
                String endTimeStr = endDateTime.format(formatter);

                logger.info("获取时间范围内的GPS数据: {} 至 {}", startTimeStr, endTimeStr);

                // 并行获取两种类型的GPS数据
                CompletableFuture<List<GpsData>> lkywFuture = CompletableFuture.supplyAsync(() ->
                        getGpsData(lkywApiUrl, lkywApiToken, startTimeStr, endTimeStr, 1));
                CompletableFuture<List<GpsData>> hcFuture = CompletableFuture.supplyAsync(() ->
                        getGpsData(hcApiUrl, hcApiToken, startTimeStr, endTimeStr, 2));

                // 等待两个任务完成
                List<GpsData> lkywDataList = lkywFuture.get();
                List<GpsData> hcDataList = hcFuture.get();

                logger.info("获取两客一危GPS数据: {} 条", lkywDataList.size());
                logger.info("获取货车GPS数据: {} 条", hcDataList.size());

                // 合并数据
                List<GpsData> allGpsDataList = new ArrayList<>();
                allGpsDataList.addAll(lkywDataList);
                allGpsDataList.addAll(hcDataList);

                // 写入rabbitmq
                writeToRabbitMQ(allGpsDataList);

                // 将处理后的数据写入Doris数据库（业务，后期考虑解耦）
                if (!allGpsDataList.isEmpty()) {
                    writeToDoris(allGpsDataList);
                    totalProcessedCount += allGpsDataList.size();
                }

                logger.info("时间段 {} 至 {} 数据处理完成，共处理: {} 条数据", startTimeStr, endTimeStr, allGpsDataList.size());

                // 更新下一次循环的起始时间，增加1秒避免重复获取
                startTime = endTime + 1000;

                // 添加短暂延迟，避免对API造成过大压力
                Thread.sleep(100);
            }

            logger.info("本轮GPS数据同步任务完成，总共处理: {} 条数据", totalProcessedCount);
        } catch (InterruptedException | ExecutionException e) {
            logger.error("处理GPS数据时发生错误", e);
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            logger.error("处理GPS数据时发生错误", e);
        } finally {
            // 确保释放同步锁
            syncInProgress.set(false);
            logger.info("GPS数据同步任务结束，释放同步锁");
        }
    }

    // 写入RabbitMQ
    private void writeToRabbitMQ(List<GpsData> allGpsDataList) {
        if (allGpsDataList == null || allGpsDataList.isEmpty()) {
            logger.info("没有GPS数据需要写入RabbitMQ");
            return;
        }

        try {
            // 遍历所有GPS数据并发送到RabbitMQ
            for (GpsData gpsData : allGpsDataList) {
                // 将GpsData对象转换为JSON字符串
                ONode messageJson = ONode.ofBean(gpsData, Feature.Write_UseSmlSnakeStyle);
                messageJson.set("guid", gpsData.getId());
                messageJson.set("partition_date", gpsData.getGpsTime());
                messageJson.set("velocity1", gpsData.getSpeed());
                messageJson.set("velocity2", gpsData.getSpeed());
                messageJson.set("lng", gpsData.getLon());

                // 发送实时GPS数据消息到RabbitMQ
                rabbitMQProducerService.sendRealtimeMessage(messageJson.toString());
                logger.debug("已发送GPS数据到RabbitMQ: 车牌号={}, 车辆类型={}", gpsData.getVehicleNo(), gpsData.getVehicleType());
            }

            logger.info("成功将 {} 条GPS数据写入RabbitMQ", allGpsDataList.size());
        } catch (Exception e) {
            logger.error("写入RabbitMQ时发生错误", e);
        }
    }

    /**
     * 根据车辆类型获取对应的路由键
     *
     * @param vehicleType 车辆类型 1:两客一危 2:货车
     * @return 路由键
     */
    private String getRoutingKeyByVehicleType(int vehicleType) {
        switch (vehicleType) {
            case 1:
                return "vehicle.lkyw"; // 两客一危
            case 2:
                return "vehicle.hc";   // 货车
            default:
                return "vehicle.unknown";
        }
    }

    /**
     * 获取GPS数据
     *
     * @param apiUrl      API地址
     * @param apiToken    API令牌
     * @param startTime   开始时间
     * @param endTime     结束时间
     * @param vehicleType 车辆类型 1:两客一危 2:货车
     * @return GPS数据列表
     */
    private List<GpsData> getGpsData(String apiUrl, String apiToken, String startTime, String endTime, int vehicleType) {
        List<GpsData> gpsDataList = new ArrayList<>();

        try {
            // 创建请求头Map
            Map<String, String> headers = new HashMap<>();
            headers.put("token", apiToken);

            // 构建带查询参数的URL
            String urlWithParams = apiUrl + "?kssj=" + startTime + "&jssj=" + endTime + "&size=10000";

            // 创建请求对象
            HttpRequest request = HttpRequest.get(urlWithParams);

            // 使用addHeaders批量添加请求头
            request = request.addHeaders(headers);

            // 设置超时
            request = request.timeout(30000);

            // 执行请求
            HttpResponse response = request.execute();

            String responseBody = response.body();

            if (!response.isOk()) {
                logger.error("HTTP请求失败，状态码: {}", response.getStatus());
                return gpsDataList;
            }

            // 解析响应数据
            ONode result = ONode.ofJson(responseBody);
            if (result.get("success").getBoolean()) {
                String data = result.get("data").getString();
                ONode hits = ONode.ofJson(data).get("hits").get("hits");
                if (hits.isArray()) {
                    for (int i = 0; i < hits.size(); i++) {
                        ONode record = hits.get(i);

                        GpsData gpsData = new GpsData();
                        gpsData.setId(record.get("_id").getString());
                        ONode source = record.get("_source");
                        gpsData.setVehicleNo(source.get("vehicleNo").getString());
                        gpsData.setVehicleColor(source.get("vehicleColor").getString());
                        gpsData.setGpsTime(source.get("gps_time").getString());
                        gpsData.setLon(source.get("lon").getDouble());
                        gpsData.setLat(source.get("lat").getDouble());
                        gpsData.setSpeed(source.get("vec1").getDouble());
                        gpsData.setDirection(source.get("direction").getDouble());
                        gpsData.setVehicleType(vehicleType); // 设置车辆类型

                        gpsDataList.add(gpsData);
                    }
                }
            } else {
                logger.error("接口调用失败: {}", result.get("msg").getString());
            }
        } catch (Exception e) {
            logger.error("获取GPS数据时发生错误", e);
        }

        return gpsDataList;
    }

    /**
     * 将处理后的GPS数据写入Doris数据库
     *
     * @param gpsDataList GPS数据列表
     */
    private void writeToDoris(List<GpsData> gpsDataList) {
        // 检查是否启用写入Doris
        if (!writeDoris) {
            logger.info("写入Doris功能已禁用，跳过写入操作");
            return;
        }

        // 处理每条GPS数据（复用已有的处理服务）
        for (GpsData gpsData : gpsDataList) {
            processingService.processGpsData(gpsData);
        }

        logger.info("将 {} 条GPS数据写入Doris数据库", gpsDataList.size());

        // 使用Stream Load方式写入Doris
        dorisStreamLoadService.writeGpsDataToDoris(gpsDataList, "gps_data_table");
    }
}
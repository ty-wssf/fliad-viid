package com.fliad.gps.service;

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
import org.noear.snack4.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    @Inject("${gps.api.lkyw.url}")
    private String lkywApiUrl;

    @Inject("${gps.api.lkyw.token}")
    private String lkywApiToken;

    @Inject("${gps.api.hc.url}")
    private String hcApiUrl;

    @Inject("${gps.api.hc.token}")
    private String hcApiToken;

    // 全局共享的GPS处理服务实例
    private GpsProcessingService processingService;

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

            // 获取当前时间和前一分钟时间
            long now = System.currentTimeMillis();
            long endTime = now - 60000; // 1分钟前
            long startTime = endTime - 60000; // 2分钟前

            // 转换为日期时间格式
            LocalDateTime endDateTime = Instant.ofEpochMilli(endTime).atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime startDateTime = Instant.ofEpochMilli(startTime).atZone(ZoneId.systemDefault()).toLocalDateTime();

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

            // 处理每条GPS数据（复用已有的处理服务）
            for (GpsData gpsData : allGpsDataList) {
                processingService.processGpsData(gpsData);
            }

            // 将处理后的数据写入Doris数据库
            writeToDoris(allGpsDataList);

            logger.info("GPS数据处理完成，共处理: {} 条数据", allGpsDataList.size());
        } catch (InterruptedException | ExecutionException e) {
            logger.error("处理GPS数据时发生错误", e);
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            logger.error("处理GPS数据时发生错误", e);
        }
    }

    /**
     * 获取GPS数据
     *
     * @param apiUrl API地址
     * @param apiToken API令牌
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param vehicleType 车辆类型 1:两客一危 2:货车
     * @return GPS数据列表
     */
    private List<GpsData> getGpsData(String apiUrl, String apiToken, String startTime, String endTime, int vehicleType) {
        List<GpsData> gpsDataList = new ArrayList<>();

        try {
            // 创建请求头Map
            Map<String, String> headers = new HashMap<>();
            headers.put("token", apiToken);
            headers.put("Content-Type", "application/json");

            // 创建请求对象
            HttpRequest request = HttpRequest.get(apiUrl);

            // 使用addHeaders批量添加请求头
            request = request.addHeaders(headers);

            // 创建参数 Map
            Map<String, Object> params = new HashMap<>();
            params.put("kssj", startTime);
            params.put("jssj", endTime);
            params.put("size", "1000"); // 增加获取的数据量

            // 转换为 JSON
            String jsonBody = ONode.ofBean(params).toJson();

            // 添加参数
            request = request.body(jsonBody);

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
                ONode hits = result.get("data").get("hits").get("hits");
                if (hits.isArray()) {
                    for (int i = 0; i < hits.size(); i++) {
                        ONode record = hits.get(i);

                        GpsData gpsData = new GpsData();
                        gpsData.setId(record.get("id").getString());
                        gpsData.setVehicleNo(record.get("vehicleNo").getString());
                        gpsData.setVehicleColor(record.get("vehicleColor").getString());
                        gpsData.setGpsTime(record.get("gps_time").getString());
                        gpsData.setLon(record.get("lon").getDouble());
                        gpsData.setLat(record.get("lat").getDouble());
                        gpsData.setSpeed(record.get("vec1").getDouble());
                        gpsData.setDirection(record.get("direction").getDouble());
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
        logger.info("将 {} 条GPS数据写入Doris数据库", gpsDataList.size());

        String sql = "INSERT INTO gps_data_table (id, vehicle_no, vehicle_color, vehicle_type, gps_time, lon, lat, speed, direction, matched_cross_id, matched_road_seg_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dorisDataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);

            for (GpsData gpsData : gpsDataList) {
                stmt.setString(1, gpsData.getId());
                stmt.setString(2, gpsData.getVehicleNo());
                stmt.setString(3, gpsData.getVehicleColor());
                stmt.setInt(4, gpsData.getVehicleType()); // 新增的车辆类型字段
                stmt.setString(5, gpsData.getGpsTime());
                stmt.setDouble(6, gpsData.getLon());
                stmt.setDouble(7, gpsData.getLat());
                stmt.setDouble(8, gpsData.getSpeed());
                stmt.setDouble(9, gpsData.getDirection());
                stmt.setString(10, gpsData.getMatchedCrossId());
                stmt.setString(11, gpsData.getMatchedRoadSegId());

                stmt.addBatch();
            }

            stmt.executeBatch();
            conn.commit();

            logger.info("成功写入 {} 条GPS数据到Doris数据库", gpsDataList.size());
        } catch (Exception e) {
            logger.error("写入Doris数据库时发生错误", e);
        }
    }
}
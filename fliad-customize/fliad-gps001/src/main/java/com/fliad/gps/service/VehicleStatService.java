package com.fliad.gps.service;

import com.fliad.gps.model.VehicleStatData;
import org.noear.snack4.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 车辆统计数据服务类
 */
@Component
public class VehicleStatService {
    private static final Logger logger = LoggerFactory.getLogger(VehicleStatService.class);

    @Inject("doris")
    private DataSource dorisDataSource;

    @Inject
    private KafkaProducerService kafkaProducerService;

    /**
     * 每天凌晨3点执行一次的定时任务，用于统计前一天的车辆数据并推送到Kafka
     */
    @Scheduled(cron = "0 0 3 * * ?")
    public void statAndPushVehicleDataJob() {
        try {
            logger.info("开始执行车辆统计数据任务");

            // 获取昨天的日期
            LocalDate yesterday = LocalDate.now().minusDays(1);

            // 统计路口车辆数据
            List<VehicleStatData> crossStats = statCrossVehicleData(yesterday);
            logger.info("统计到路口车辆数据 {} 条", crossStats.size());

            // 统计路段车辆数据
            List<VehicleStatData> roadSegmentStats = statRoadSegmentVehicleData(yesterday);
            logger.info("统计到路段车辆数据 {} 条", roadSegmentStats.size());

            // 合并数据
            List<VehicleStatData> allStats = new ArrayList<>();
            allStats.addAll(crossStats);
            allStats.addAll(roadSegmentStats);

            // 推送到Kafka
            pushToKafka(allStats);

            logger.info("车辆统计数据任务执行完成，共处理 {} 条数据", allStats.size());
        } catch (Exception e) {
            logger.error("执行车辆统计数据任务时发生错误", e);
        }
    }

    /**
     * 统计指定日期的路口车辆数据
     *
     * @param date 指定日期
     * @return 车辆统计数据列表
     */
    public List<VehicleStatData> statCrossVehicleData(LocalDate date) {
        List<VehicleStatData> stats = new ArrayList<>();

        // 格式化日期，用于SQL查询条件
        String startDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " 00:00:00";
        String endDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " 23:59:59";

        // 按小时统计路口车辆数据的SQL
        String sql = "SELECT " +
                "DATE_FORMAT(gps_time, '%Y%m%d%H') AS data_time, " +
                "matched_cross_id AS road_net_code, " +
                "vehicle_type, " +
                "vehicle_color, " +
                "COUNT(*) AS vehicle_count " +
                "FROM gps_data_table " +
                "WHERE gps_time >= ? AND gps_time <= ? " +
                "AND matched_cross_id IS NOT NULL " +
                "GROUP BY DATE_FORMAT(gps_time, '%Y%m%d%H'), matched_cross_id, vehicle_type, vehicle_color";

        try (Connection conn = dorisDataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, startDate);
            stmt.setString(2, endDate);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    VehicleStatData statData = new VehicleStatData();
                    statData.setDataTime(rs.getString("data_time"));
                    statData.setRoadNetCode(rs.getString("road_net_code"));
                    statData.setRoadNetType(1); // 路口
                    statData.setVehicleType(rs.getString("vehicle_type"));
                    statData.setVehicleColor(rs.getInt("vehicle_color"));
                    statData.setVehicleCount(rs.getInt("vehicle_count"));

                    stats.add(statData);
                }
            }
        } catch (Exception e) {
            logger.error("统计路口车辆数据时发生错误", e);
        }

        return stats;
    }

    /**
     * 统计指定日期的路段车辆数据
     *
     * @param date 指定日期
     * @return 车辆统计数据列表
     */
    public List<VehicleStatData> statRoadSegmentVehicleData(LocalDate date) {
        List<VehicleStatData> stats = new ArrayList<>();

        // 格式化日期，用于SQL查询条件
        String startDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " 00:00:00";
        String endDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " 23:59:59";

        // 按小时统计路段车辆数据的SQL
        String sql = "SELECT " +
                "DATE_FORMAT(gps_time, '%Y%m%d%H') AS data_time, " +
                "matched_road_seg_id AS road_net_code, " +
                "vehicle_type, " +
                "vehicle_color, " +
                "COUNT(*) AS vehicle_count " +
                "FROM gps_data_table " +
                "WHERE gps_time >= ? AND gps_time <= ? " +
                "AND matched_road_seg_id IS NOT NULL " +
                "GROUP BY DATE_FORMAT(gps_time, '%Y%m%d%H'), matched_road_seg_id, vehicle_type, vehicle_color";

        try (Connection conn = dorisDataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, startDate);
            stmt.setString(2, endDate);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    VehicleStatData statData = new VehicleStatData();
                    statData.setDataTime(rs.getString("data_time"));
                    statData.setRoadNetCode(rs.getString("road_net_code"));
                    statData.setRoadNetType(2); // 路段
                    statData.setVehicleType(rs.getString("vehicle_type"));
                    statData.setVehicleColor(rs.getInt("vehicle_color"));
                    statData.setVehicleCount(rs.getInt("vehicle_count"));

                    stats.add(statData);
                }
            }
        } catch (Exception e) {
            logger.error("统计路段车辆数据时发生错误", e);
        }

        return stats;
    }

    /**
     * 将统计数据推送到Kafka
     *
     * @param stats 统计数据列表
     */
    public void pushToKafka(List<VehicleStatData> stats) {
        for (VehicleStatData stat : stats) {
            try {
                String jsonData = ONode.ofBean(stat).toJson();
                kafkaProducerService.sendMessage("vehicle_stat_topic", jsonData);
                logger.debug("推送统计数据到Kafka: {}", jsonData);
            } catch (Exception e) {
                logger.error("推送统计数据到Kafka时发生错误", e);
            }
        }
    }
    
    /**
     * 获取统计数据（公开方法，用于测试）
     * 
     * @param date 指定日期
     * @return 车辆统计数据列表
     */
    public List<VehicleStatData> getStatData(LocalDate date) {
        List<VehicleStatData> crossStats = statCrossVehicleData(date);
        List<VehicleStatData> roadSegmentStats = statRoadSegmentVehicleData(date);
        
        List<VehicleStatData> allStats = new ArrayList<>();
        allStats.addAll(crossStats);
        allStats.addAll(roadSegmentStats);
        
        return allStats;
    }
    
    /**
     * 推送指定日期的统计数据到Kafka（公开方法，用于测试）
     * 
     * @param date 指定日期
     */
    public void pushStatDataToKafka(LocalDate date) {
        List<VehicleStatData> statDataList = getStatData(date);
        pushToKafka(statDataList);
    }
}
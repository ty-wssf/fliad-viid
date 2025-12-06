package com.fliad.gps.controller;

import com.fliad.gps.model.GpsData;
import com.fliad.gps.model.VehicleStatData;
import com.fliad.gps.service.KafkaProducerService;
import com.fliad.gps.service.VehicleStatService;
import com.fliad.gps.service.VehicleStatTestService;
import org.noear.snack4.ONode;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 数据推送测试控制器
 *
 * @author lingma
 * @since 1.0.0
 */
@Controller
@Valid
public class DataPushTestController {
    
    private static final Logger logger = LoggerFactory.getLogger(DataPushTestController.class);
    
    @Inject
    private KafkaProducerService kafkaProducerService;
    
    @Inject
    private VehicleStatService vehicleStatService;
    
    @Inject
    private VehicleStatTestService vehicleStatTestService;
    
    /**
     * 测试单条数据推送
     *
     * @return 推送结果
     */
    @Post
    @Mapping("/push/test")
    public String testPush() {
        // 创建测试GPS数据
        GpsData gpsData = createTestGpsData();
        
        // 记录推送日志
        logger.info("推送测试GPS数据: {}", gpsData);
        
        return "测试推送成功，数据ID：" + gpsData.getId();
    }
    
    /**
     * 测试单条数据推送至Kafka
     *
     * @param topic Kafka主题名称，默认为"gps_data_topic"
     * @return 推送结果
     */
    @Post
    @Mapping("/push/kafka/test")
    public String testPushToKafka(@Param(defaultValue = "gps_data_topic") String topic) {
        // 创建测试GPS数据
        GpsData gpsData = createTestGpsData();
        
        // 将GPS数据转换为JSON格式
        String jsonData = ONode.ofBean(gpsData).toJson();
        
        // 推送数据到Kafka
        kafkaProducerService.sendMessage(topic, jsonData);
        
        logger.info("成功推送测试GPS数据到Kafka，主题: {}，数据: {}", topic, jsonData);
        
        return "测试推送至Kafka成功，数据ID：" + gpsData.getId() + "，主题：" + topic;
    }
    
    /**
     * 测试批量数据推送至Kafka
     *
     * @param topic Kafka主题名称，默认为"gps_data_topic"
     * @param count 推送数据数量，默认为5
     * @return 推送结果
     */
    @Post
    @Mapping("/push/kafka/batchTest")
    public String batchTestPushToKafka(
            @Param(defaultValue = "gps_data_topic") String topic,
            @Param(defaultValue = "5") Integer count) {
        
        List<GpsData> gpsDataList = new ArrayList<>();
        
        // 创建批量测试GPS数据并推送至Kafka
        for (int i = 0; i < count; i++) {
            GpsData gpsData = createTestGpsData();
            gpsDataList.add(gpsData);
            
            // 将GPS数据转换为JSON格式
            String jsonData = ONode.ofBean(gpsData).toJson();
            
            // 推送数据到Kafka
            kafkaProducerService.sendMessage(topic, jsonData);
        }
        
        logger.info("批量推送测试GPS数据到Kafka，主题: {}，数量: {}", topic, gpsDataList.size());
        
        return "批量测试推送至Kafka完成，共推送 " + count + " 条数据，主题：" + topic;
    }
    
    /**
     * 测试车辆统计数据推送至Kafka（模拟手动触发定时任务）
     *
     * @return 推送结果
     */
    @Post
    @Mapping("/push/kafka/statTest")
    public String testStatPushToKafka() {
        try {
            logger.info("开始执行车辆统计数据推送测试");
            
            // 手动调用统计和推送方法
            vehicleStatService.statAndPushVehicleDataJob();
            
            logger.info("车辆统计数据推送测试执行完成");
            return "车辆统计数据推送测试执行完成";
        } catch (Exception e) {
            logger.error("车辆统计数据推送测试执行失败", e);
            return "车辆统计数据推送测试执行失败: " + e.getMessage();
        }
    }
    
    /**
     * 测试推送单条车辆统计数据到Kafka
     *
     * @param topic Kafka主题名称，默认为"vehicle_stat_topic"
     * @return 推送结果
     */
    @Post
    @Mapping("/push/kafka/statSingleTest")
    public String testSingleStatPushToKafka(@Param(defaultValue = "vehicle_stat_topic") String topic) {
        try {
            // 创建测试车辆统计数据
            VehicleStatData statData = createTestVehicleStatData();
            
            // 将统计数据转换为JSON格式
            String jsonData = ONode.ofBean(statData).toJson();
            
            // 推送数据到Kafka
            kafkaProducerService.sendMessage(topic, jsonData);
            
            logger.info("成功推送测试车辆统计数据到Kafka，主题: {}，数据: {}", topic, jsonData);
            
            return "测试车辆统计数据推送至Kafka成功，主题：" + topic;
        } catch (Exception e) {
            logger.error("测试车辆统计数据推送至Kafka失败", e);
            return "测试车辆统计数据推送至Kafka失败: " + e.getMessage();
        }
    }
    
    /**
     * 测试生成并推送批量车辆统计数据到Kafka
     *
     * @param topic Kafka主题名称，默认为"vehicle_stat_topic"
     * @param count 生成并推送的数据条数，默认为10
     * @return 推送结果
     */
    @Post
    @Mapping("/push/kafka/statBatchTest")
    public String testBatchStatPushToKafka(
            @Param(defaultValue = "vehicle_stat_topic") String topic,
            @Param(defaultValue = "10") Integer count) {
        
        return vehicleStatTestService.generateAndPushTestData(count, topic);
    }
    
    /**
     * 创建测试GPS数据
     *
     * @return GpsData测试对象
     */
    private GpsData createTestGpsData() {
        GpsData gpsData = new GpsData();
        gpsData.setId(UUID.randomUUID().toString());
        gpsData.setVehicleNo("湘A" + (int)(Math.random() * 10000));
        gpsData.setVehicleColor("蓝色");
        gpsData.setGpsTime("2025-12-06 10:00:00");
        gpsData.setLon(112.9786 + Math.random() * 0.1 - 0.05); // 长沙附近经纬度
        gpsData.setLat(28.1965 + Math.random() * 0.1 - 0.05);
        gpsData.setSpeed(Math.random() * 120); // 随机速度 0-120 km/h
        gpsData.setDirection(Math.random() * 360); // 随机方向 0-360度
        gpsData.setVehicleType(1); // 默认设置为两客一危
        
        return gpsData;
    }
    
    /**
     * 创建测试车辆统计数据
     *
     * @return VehicleStatData测试对象
     */
    private VehicleStatData createTestVehicleStatData() {
        VehicleStatData statData = new VehicleStatData();
        statData.setDataTime("2025120610"); // YYYYMMDDHH 格式
        statData.setRoadNetCode("CN-001"); // 路网编码
        statData.setRoadNetType((int) (Math.random() * 2) + 1); // 1:路口 2:路段
        statData.setVehicleType("客车");
        statData.setVehicleColor((int) (Math.random() * 5) + 1); // 1-5之间的随机数
        statData.setVehicleCount((int) (Math.random() * 100)); // 0-99之间的随机数
        
        return statData;
    }
}
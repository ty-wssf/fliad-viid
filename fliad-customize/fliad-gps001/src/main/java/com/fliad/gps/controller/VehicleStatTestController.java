package com.fliad.gps.controller;

import com.fliad.gps.model.VehicleStatData;
import com.fliad.gps.service.VehicleStatService;
import org.noear.snack4.ONode;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 车辆统计数据推送测试控制器
 *
 * @author lingma
 * @since 1.0.0
 */
@Controller
@Valid
public class VehicleStatTestController {
    
    private static final Logger logger = LoggerFactory.getLogger(VehicleStatTestController.class);
    
    @Inject
    private VehicleStatService vehicleStatService;
    
    /**
     * 测试获取指定日期的统计数据
     *
     * @param date 日期，格式为 yyyy-MM-dd，默认为昨天
     * @return 统计结果
     */
    @Get
    @Mapping("/stat/data")
    public String getStatData(@Param(defaultValue = "") String date) {
        try {
            LocalDate statDate;
            if (date == null || date.isEmpty()) {
                statDate = LocalDate.now().minusDays(1); // 默认昨天
            } else {
                statDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            
            logger.info("开始获取 {} 的车辆统计数据", statDate);
            
            List<VehicleStatData> statDataList = vehicleStatService.getStatData(statDate);
            
            logger.info("获取到 {} 条车辆统计数据", statDataList.size());
            
            return String.format("获取到 %d 条车辆统计数据", statDataList.size());
        } catch (Exception e) {
            logger.error("获取车辆统计数据失败", e);
            return "获取车辆统计数据失败: " + e.getMessage();
        }
    }
    
    /**
     * 测试推送指定日期的统计数据到Kafka
     *
     * @param date 日期，格式为 yyyy-MM-dd，默认为昨天
     * @return 推送结果
     */
    @Post
    @Mapping("/stat/push")
    public String pushStatData(@Param(defaultValue = "") String date) {
        try {
            LocalDate statDate;
            if (date == null || date.isEmpty()) {
                statDate = LocalDate.now().minusDays(1); // 默认昨天
            } else {
                statDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            
            logger.info("开始推送 {} 的车辆统计数据到Kafka", statDate);
            
            // 获取统计数据
            List<VehicleStatData> statDataList = vehicleStatService.getStatData(statDate);
            
            // 推送到Kafka
            vehicleStatService.pushToKafka(statDataList);
            
            logger.info("成功推送 {} 条车辆统计数据到Kafka", statDataList.size());
            
            return String.format("成功推送 %d 条车辆统计数据到Kafka", statDataList.size());
        } catch (Exception e) {
            logger.error("推送车辆统计数据到Kafka失败", e);
            return "推送车辆统计数据到Kafka失败: " + e.getMessage();
        }
    }
    
    /**
     * 测试获取并显示指定日期的统计数据（JSON格式）
     *
     * @param date 日期，格式为 yyyy-MM-dd，默认为昨天
     * @return 统计数据的JSON表示
     */
    @Get
    @Mapping("/stat/data/json")
    public String getStatDataAsJson(@Param(defaultValue = "") String date) {
        try {
            LocalDate statDate;
            if (date == null || date.isEmpty()) {
                statDate = LocalDate.now().minusDays(1); // 默认昨天
            } else {
                statDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            
            logger.info("开始获取 {} 的车辆统计数据(JSON格式)", statDate);
            
            List<VehicleStatData> statDataList = vehicleStatService.getStatData(statDate);
            
            String jsonData = ONode.ofBean(statDataList).toJson();
            
            logger.info("成功获取 {} 条车辆统计数据(JSON格式)", statDataList.size());
            
            return jsonData;
        } catch (Exception e) {
            logger.error("获取车辆统计数据(JSON格式)失败", e);
            return "获取车辆统计数据(JSON格式)失败: " + e.getMessage();
        }
    }
}
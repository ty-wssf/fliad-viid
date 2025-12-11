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
 * 车辆统计数据测试控制器
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
     * 手动触发车辆统计数据任务（用于测试）
     *
     * @return 执行结果
     */
    @Post
    @Mapping("/test/stat/job")
    public String testStatJob() {
        try {
            logger.info("开始手动执行车辆统计数据任务测试");
            
            // 手动调用统计任务方法
            vehicleStatService.statAndPushVehicleDataJob();
            
            logger.info("车辆统计数据任务测试执行完成");
            return "车辆统计数据任务测试执行完成";
        } catch (Exception e) {
            logger.error("车辆统计数据任务测试执行失败", e);
            return "车辆统计数据任务测试执行失败: " + e.getMessage();
        }
    }
    
    /**
     * 测试获取指定日期的统计数据
     *
     * @param date 日期，格式为 yyyy-MM-dd，默认为昨天
     * @return 统计结果
     */
    @Get
    @Mapping("/test/stat/data")
    public String testGetStatData(@Param(defaultValue = "") String date) {
        try {
            LocalDate statDate;
            if (date == null || date.isEmpty()) {
                statDate = LocalDate.now().minusDays(1); // 默认昨天
            } else {
                statDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            
            logger.info("开始测试获取 {} 的车辆统计数据", statDate);
            
            // 获取统计数据
            List<VehicleStatData> statDataList = vehicleStatService.getStatData(statDate);
            
            logger.info("成功获取 {} 条车辆统计数据", statDataList.size());
            
            return String.format("成功获取 %d 条车辆统计数据", statDataList.size());
        } catch (Exception e) {
            logger.error("测试获取车辆统计数据失败", e);
            return "测试获取车辆统计数据失败: " + e.getMessage();
        }
    }
    
    /**
     * 测试推送指定日期的统计数据到Kafka
     *
     * @param date 日期，格式为 yyyy-MM-dd，默认为昨天
     * @return 推送结果
     */
    @Get
    @Post
    @Mapping("/test/stat/push")
    public String testPushStatData(@Param(defaultValue = "") String date) {
        try {
            LocalDate statDate;
            if (date == null || date.isEmpty()) {
                statDate = LocalDate.now().minusDays(1); // 默认昨天
            } else {
                statDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            
            logger.info("开始测试推送 {} 的车辆统计数据到rabbitmq", statDate);
            
            // 推送统计数据
            vehicleStatService.pushStatDataToRabbitMQ(statDate);
            
            logger.info("车辆统计数据推送测试执行完成");
            return "车辆统计数据推送测试执行完成";
        } catch (Exception e) {
            logger.error("测试推送车辆统计数据到Kafka失败", e);
            return "测试推送车辆统计数据到Kafka失败: " + e.getMessage();
        }
    }
    
    /**
     * 测试获取并显示指定日期的统计数据（JSON格式）
     *
     * @param date 日期，格式为 yyyy-MM-dd，默认为昨天
     * @return 统计数据的JSON表示
     */
    @Get
    @Mapping("/test/stat/data/json")
    public String testGetStatDataAsJson(@Param(defaultValue = "") String date) {
        try {
            LocalDate statDate;
            if (date == null || date.isEmpty()) {
                statDate = LocalDate.now().minusDays(1); // 默认昨天
            } else {
                statDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            
            logger.info("开始测试获取 {} 的车辆统计数据(JSON格式)", statDate);
            
            // 获取统计数据
            List<VehicleStatData> statDataList = vehicleStatService.getStatData(statDate);
            
            // 转换为JSON格式
            String jsonData = ONode.ofBean(statDataList).toJson();
            
            logger.info("成功获取 {} 条车辆统计数据(JSON格式)", statDataList.size());
            
            return jsonData;
        } catch (Exception e) {
            logger.error("测试获取车辆统计数据(JSON格式)失败", e);
            return "测试获取车辆统计数据(JSON格式)失败: " + e.getMessage();
        }
    }
}
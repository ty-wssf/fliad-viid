package com.fliad.gps.service;

import com.fliad.gps.model.VehicleStatData;
import org.noear.snack4.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 车辆统计数据测试服务类
 */
@Component
public class VehicleStatTestService {
    
    private static final Logger logger = LoggerFactory.getLogger(VehicleStatTestService.class);

    @Inject
    private KafkaProducerService kafkaProducerService;
    
    /**
     * 生成并推送测试车辆统计数据
     * 
     * @param count 生成数据条数
     * @param topic 推送的主题
     * @return 推送结果信息
     */
    public String generateAndPushTestData(int count, String topic) {
        try {
            logger.info("开始生成{}条测试车辆统计数据并推送至主题:{}", count, topic);
            
            List<VehicleStatData> testDataList = generateTestData(count);
            
            int successCount = 0;
            for (VehicleStatData data : testDataList) {
                try {
                    String jsonData = ONode.ofBean(data).toJson();
                    kafkaProducerService.sendMessage(topic, jsonData);
                    successCount++;
                } catch (Exception e) {
                    logger.error("推送单条测试数据失败: {}", data, e);
                }
            }
            
            logger.info("测试数据推送完成，成功推送 {}/{} 条数据", successCount, count);
            return String.format("测试数据推送完成，成功推送 %d/%d 条数据", successCount, count);
        } catch (Exception e) {
            logger.error("生成并推送测试车辆统计数据时发生错误", e);
            return "生成并推送测试车辆统计数据失败: " + e.getMessage();
        }
    }
    
    /**
     * 生成指定数量的测试数据
     * 
     * @param count 数据数量
     * @return 测试数据列表
     */
    private List<VehicleStatData> generateTestData(int count) {
        List<VehicleStatData> dataList = new ArrayList<>();
        
        String[] roadNetTypes = {"路口", "路段"};
        String[] vehicleTypes = {"客车", "货车", "危险品运输车"};
        String[] roadNetCodes = {"HN-001", "HN-002", "HN-003", "HN-004", "HN-005"};
        
        for (int i = 0; i < count; i++) {
            VehicleStatData data = new VehicleStatData();
            
            // 生成数据时间 (YYYYMMDDHH格式)
            LocalDate now = LocalDate.now();
            String dataTime = now.toString().replace("-", "") + String.format("%02d", (int)(Math.random() * 24));
            data.setDataTime(dataTime);
            
            // 随机选择路网编码
            data.setRoadNetCode(roadNetCodes[(int)(Math.random() * roadNetCodes.length)]);
            
            // 随机选择路网类型 (1:路口, 2:路段)
            int roadNetType = (int)(Math.random() * 2) + 1;
            data.setRoadNetType(roadNetType);
            
            // 随机选择车辆类型
            data.setVehicleType(vehicleTypes[(int)(Math.random() * vehicleTypes.length)]);
            
            // 随机生成车辆颜色 (1-5)
            data.setVehicleColor((int)(Math.random() * 5) + 1);
            
            // 随机生成车流量数 (1-1000)
            data.setVehicleCount((int)(Math.random() * 1000) + 1);
            
            dataList.add(data);
        }
        
        return dataList;
    }
}
# 湖南永州gps定制模块

## 功能说明

本模块实现了以下功能：
1. 每分钟调用接口获取GPS数据
2. 将GPS数据与MySQL数据库中的路口和路段进行匹配
3. 将匹配后的GPS数据写入Doris数据库
4. 每日凌晨3点统计前一天的车辆数据并推送到Kafka

## 数据库表结构

### 路口表 (table_cross)
```sql
CREATE TABLE `table_cross` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `cross_id` varchar(255) DEFAULT NULL COMMENT '路口id',
  `center_location` varchar(255) DEFAULT NULL COMMENT '中心坐标',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cross_id_idx` (`cross_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='路口表';
```

### 路段表 (table_road_segment)
```sql
CREATE TABLE `table_road_segment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `road_seg_id` varchar(255) DEFAULT NULL COMMENT '路段id',
  `road_seg_locations` text COMMENT '路段坐标序列',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `road_seg_idx` (`road_seg_id`) USING BTREE,
  UNIQUE KEY `uniRoadSegId` (`road_seg_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='路段表';
```

### GPS数据表 (gps_data_table)
```sql
CREATE TABLE `gps_data_table` (
  `id` varchar(64) NOT NULL COMMENT '数据ID',
  `vehicle_no` varchar(32) NOT NULL COMMENT '车辆编号',
  `vehicle_color` varchar(32) DEFAULT NULL COMMENT '车辆颜色',
  `vehicle_type` int NOT NULL COMMENT '车辆类型 1:两客一危 2:货车',
  `gps_time` datetime NOT NULL COMMENT 'GPS时间',
  `lon` double NOT NULL COMMENT '经度',
  `lat` double NOT NULL COMMENT '纬度',
  `speed` double DEFAULT NULL COMMENT '速度',
  `direction` double DEFAULT NULL COMMENT '方向',
  `matched_cross_id` varchar(64) DEFAULT NULL COMMENT '匹配的路口ID',
  `matched_road_seg_id` varchar(64) DEFAULT NULL COMMENT '匹配的路段ID',
  PRIMARY KEY (`id`),
  KEY `idx_vehicle_no` (`vehicle_no`),
  KEY `idx_gps_time` (`gps_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='GPS数据表';
```

## 配置说明

在 `src/main/resources/app.yml` 中配置以下参数：
- MySQL数据库连接信息
- Doris数据库连接信息
- GPS数据接口URL和Token
- Kafka连接信息

## 编译和运行

使用 Maven 编译项目：
```bash
mvn clean package
```

运行程序：
```bash
java -jar target/fliad-gps001-0.1.0.jar
```

## 测试接口

提供以下测试接口用于验证功能：

### 手动触发统计任务
```
POST /test/stat/job
```
手动触发一次完整的车辆统计数据任务，包括统计和推送过程。

### 获取统计数据
```
GET /test/stat/data?date=yyyy-MM-dd
```
获取指定日期的统计数据，默认为昨天。

### 获取统计数据(JSON格式)
```
GET /test/stat/data/json?date=yyyy-MM-dd
```
获取指定日期的统计数据，并以JSON格式返回。

### 推送统计数据
```
POST /test/stat/push?date=yyyy-MM-dd
```
将指定日期的统计数据推送到Kafka，默认为昨天。

## 技术架构

本项目基于Solon框架开发，具有以下特点：
1. 轻量级：相比Spring Boot更加轻量，启动速度快
2. 组件化：通过注解实现依赖注入和组件管理
3. 定时任务：使用@Scheduled注解实现定时任务调度
4. 数据源管理：支持多数据源配置和管理
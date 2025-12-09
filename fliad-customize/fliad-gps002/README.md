# GPS Data Transfer Service (GPS002)

该服务用于从FTP服务器读取GPS数据文件，并将数据发送到RabbitMQ消息队列。

## 功能说明

1. 连接到FTP服务器并读取指定的JSON格式GPS数据文件
2. 解析JSON数据为车辆记录对象
3. 将每条车辆记录作为消息发送到RabbitMQ交换机
4. 基于Solon框架开发，通过配置文件管理各项参数

## 数据格式

输入的JSON文件包含以下结构：
- pageNum: 页码
- pageSize: 每页大小
- totalPages: 总页数
- totalNum: 记录总数
- records: 车辆记录列表

每条车辆记录包含：
- guid: 全球唯一标识符
- vehicle_no: 车牌号
- vehicle_color: 车辆颜色
- encrypt: 是否加密
- date_time: 时间戳
- lng: 经度
- lat: 纬度
- velocity1/velocity2: 速度信息
- mileage: 里程
- direction: 方向
- altitude: 海拔高度
- 各种状态和报警标志位

## 构建和运行

### 构建项目

```bash
mvn clean package
```

这将生成一个包含所有依赖的可执行JAR文件。

### 运行程序

```bash
java -jar target/fliad-gps002-jar-with-dependencies.jar
```

### 配置参数说明

所有配置均通过配置文件`app.yml`进行配置：

```yaml
# FTP配置
ftp:
  server: localhost      # FTP服务器地址
  port: 21               # FTP端口
  username: user         # FTP用户名
  password: password     # FTP密码
  file: /data/12t.txt    # FTP上数据文件路径

# RabbitMQ配置
rabbitmq:
  host: localhost        # RabbitMQ服务器地址
  port: 5672             # RabbitMQ端口
  username: guest        # RabbitMQ用户名
  password: guest        # RabbitMQ密码
  exchange: gps_data_exchange  # RabbitMQ交换机名称
```

## 代码结构

```
src/
├── main/
│   ├── java/
│   │   └── com/fliad/gps002/
│   │       ├── config/
│   │       │   ├── FtpConfig.java           # FTP配置类
│   │       │   ├── FtpProperties.java       # FTP属性类
│   │       │   ├── RabbitMQConfig.java      # RabbitMQ配置类
│   │       │   └── RabbitMQProperties.java  # RabbitMQ属性类
│   │       ├── entity/
│   │       │   ├── GpsData.java             # GPS数据封装类
│   │       │   └── VehicleRecord.java       # 单个车辆记录类
│   │       ├── service/
│   │       │   ├── FtpService.java          # FTP服务类
│   │       │   ├── RabbitMqService.java     # RabbitMQ服务类
│   │       │   └── DataTransferService.java # 数据传输服务类
│   │       ├── Gps002App.java               # 主应用程序入口
│   │       └── Application.java             # 应用程序入口(已废弃)
│   └── resources/
│       └── app.yml                          # 配置文件
└── pom.xml                                  # Maven配置文件
```
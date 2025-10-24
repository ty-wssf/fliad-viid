# SIP GB28181协议插件

该插件实现了国标GB28181协议，用于与视频监控设备进行通信。

## 功能特性

- SIP服务器功能，支持设备注册、注销
- 支持UDP和TCP传输协议
- 媒体流管理（实时视频、录像回放）
- 与媒体服务器集成
- 设备管理与状态跟踪
- 心跳检测机制
- GB28181消息解析和构建
- 自动启动和配置

## 核心组件

### SipServer
SIP服务器核心类，负责初始化和管理SIP协议栈。

### SipDeviceRegistry
设备注册管理器，维护在线设备列表和设备信息。

### MediaStreamManager
媒体流管理器，处理视频流的创建、管理和销毁。

### SipTransportManager
SIP传输管理器，支持多种传输协议（UDP/TCP）。

### MediaServerIntegration
媒体服务器集成接口，与第三方媒体服务器（如ZLMediaKit）进行交互。

### SipMessageHandler
SIP消息处理器，处理各种SIP消息（REGISTER、MESSAGE、INVITE等）。

### SipService
SIP服务主类，协调各个组件工作。

### Gb28181MessageProcessor
GB28181消息处理器，解析和处理国标协议XML消息。

### Gb28181Commander
GB28181命令发送器，用于向设备发送各类国标协议命令。

### SipServerStarter
SIP服务器启动器，负责系统启动时自动初始化SIP服务。

## 配置参数

- `host`: SIP服务器监听地址，默认0.0.0.0
- `port`: SIP服务器监听端口，默认5060
- `transport`: 传输协议（UDP/TCP），默认UDP
- `deviceId`: 本系统设备ID，默认34020000002000000001
- `deviceName`: 本系统设备名称，默认"GB28181 Server"
- `password`: 设备认证密码，默认"admin123"
- `keepaliveTime`: 心跳间隔时间（秒），默认60
- `mediaServerUrl`: 媒体服务器地址
- `mediaServerApiKey`: 媒体服务器API密钥

## 使用方法

### 自动启动（推荐）
插件会通过 [SipServerStarter](src/main/java/com/fliad/sip/gb28181/core/SipServerStarter.java) 类在系统启动时自动初始化和启动SIP服务。

### 手动启动
```java
SipService sipService = new SipService();
sipService.configure("192.168.1.100", 5060, "UDP");
sipService.initialize();
sipService.start();
```

## API接口
插件提供API接口模块 [fliad-plugin-sip-gb28181-api](../../fliad-plugin-api/fliad-plugin-sip-gb28181-api)，包含以下接口：
- [SipServiceApi](../../fliad-plugin-api/fliad-plugin-sip-gb28181-api/src/main/java/com/fliad/sip/gb28181/api/SipServiceApi.java)
- [DeviceRegistryApi](../../fliad-plugin-api/fliad-plugin-sip-gb28181-api/src/main/java/com/fliad/sip/gb28181/api/DeviceRegistryApi.java)
- [MediaStreamApi](../../fliad-plugin-api/fliad-plugin-sip-gb28181-api/src/main/java/com/fliad/sip/gb28181/api/MediaStreamApi.java)

## 依赖

- jain-sip-ri 1.3.0-91
- fliad-common
- fliad-plugin-sip-gb28181-api
- solon 1.10.12
- xml-apis 1.4.01
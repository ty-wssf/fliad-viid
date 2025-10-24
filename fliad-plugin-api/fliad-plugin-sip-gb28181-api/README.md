# SIP GB28181协议插件API

该模块提供了GB28181协议插件的API接口定义。

## 功能接口

### SipServiceApi
SIP服务主接口，提供SIP服务的初始化、配置、启动、停止等核心功能。

### DeviceRegistryApi
设备注册管理接口，提供设备的注册、注销、查询等功能。

### MediaStreamApi
媒体流管理接口，提供媒体流的创建、停止、查询等功能。

## 使用方法

在其他模块中通过Maven依赖引入该API模块：

```xml
<dependency>
    <groupId>com.fliad</groupId>
    <artifactId>fliad-plugin-sip-gb28181-api</artifactId>
</dependency>
```

然后通过依赖注入或直接调用的方式使用相关接口。
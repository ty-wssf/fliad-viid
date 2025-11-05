# 服务监控模块

## 概述

服务监控模块负责监控服务的运行状态，并在服务停止时自动重启服务。该模块基于现有的设备状态管理框架构建，复用了设备状态管理的核心功能。

## 核心组件

### ServiceMonitor
服务监控器，负责监控服务状态并执行自动重启逻辑。

主要功能：
- 定时检测服务运行状态
- 当检测到服务停止时，自动调用服务启动器重启服务
- 维护服务运行状态信息

### ServiceStateListener
服务状态监听器接口，用于检查服务是否正在运行。

### ServiceStarter
服务启动器接口，用于启动已停止的服务。

## 使用方法

### 1. 创建ServiceMonitor实例

```java
DeviceStateManager deviceStateManager = Solon.context().getBean(DeviceStateManager.class);
ServiceMonitor serviceMonitor = new ServiceMonitor(deviceStateManager);
```

### 2. 注册服务监听器

```java
serviceMonitor.registerServiceListener("database", new ServiceStateListener() {
    @Override
    public boolean isServiceRunning(String serviceName) {
        // 检查服务是否正在运行
        return checkDatabaseServiceRunning();
    }
});
```

### 3. 注册服务启动器

```java
serviceMonitor.registerServiceStarter("database", new ServiceStarter() {
    @Override
    public void startService(String serviceName) throws Exception {
        // 启动服务的具体实现
        startDatabaseService();
    }
});
```

### 4. 启动服务监控器

```java
serviceMonitor.start();
```

## 示例

参考 [SystemServiceMonitorExample.java](example/SystemServiceMonitorExample.java) 获取完整的使用示例。

## 注意事项

1. 服务监控器需要依赖 DeviceStateManager，确保在系统中已正确配置
2. 服务状态监听器和启动器需要根据具体服务实现相应接口
3. 服务监控器默认检测间隔为30秒，可通过 `setCheckIntervalMillis` 方法调整
4. 服务监控器实现了 LifecycleBean 接口，可以作为 Solon 组件使用
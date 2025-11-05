# fliad-service-monitor

## 概述

fliad-service-monitor 是一个轻量级的服务监控应用，用于监控服务的运行状态，并在服务停止时自动重启服务。

## 功能特性

1. 定时检测服务运行状态
2. 当检测到服务停止时，自动调用服务启动器重启服务
3. 支持注册多个服务进行监控
4. 轻量级实现，不依赖其他模块

## 核心组件

### SimpleServiceMonitor
轻量级服务监控器，负责监控服务状态并执行自动重启逻辑。

主要功能：
- 定时检测服务运行状态
- 当检测到服务停止时，自动调用服务启动器重启服务
- 维护服务运行状态信息

### ServiceStateListener
服务状态监听器接口，用于检查服务是否正在运行。

### ServiceStarter
服务启动器接口，用于启动已停止的服务。

## 使用方法

### 1. 注册服务监听器

```java
serviceMonitor.registerServiceListener("example-service", new ServiceStateListener() {
    @Override
    public boolean isServiceRunning(String serviceName) {
        // 检查服务是否正在运行
        return checkServiceRunning();
    }
});
```

### 2. 注册服务启动器

```java
serviceMonitor.registerServiceStarter("example-service", new ServiceStarter() {
    @Override
    public void startService(String serviceName) throws Exception {
        // 启动服务的具体实现
        startService();
    }
});
```

### 3. 启动服务监控器

```java
serviceMonitor.start();
```

## 配置

可以通过 `setCheckIntervalMillis` 方法设置服务检测间隔，默认为30秒。

## 示例

应用启动时会自动注册当前进程作为示例进行监控。

## 扩展

可以根据实际需求注册更多的服务监听器和启动器，实现对各种服务的监控和自动重启功能。
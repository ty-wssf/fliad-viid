# 通用状态管理器

## 概述

通用状态管理器用于管理设备或其他实体的在线/离线状态，避免重复处理状态事件。当实体已经在内存中处于在线状态时，收到在线事件不处理；当实体在内存中处于在线状态时，收到离线事件，则需要更新状态。

## 核心组件

### 1. AbstractStateManager（抽象状态管理器）

抽象类，提供了通用的状态管理逻辑，可以用于管理各种实体的在线/离线状态。

### 2. DeviceStateManager（设备状态管理器）

继承自AbstractStateManager，专门用于管理单一类型设备状态。

### 3. MultiDeviceStateManager（多设备状态管理器）

支持管理多种不同类型的设备状态，是核心的多设备管理类。

### 4. DeviceStatusService（设备状态服务）

提供了设备状态管理的完整实现，支持监听器模式。

### 5. DeviceStatusChangeListener（设备状态监听器接口）

用于监听设备在线/离线状态变化的接口。

### 6. MultiDeviceStatusChangeListener（多设备状态监听器接口）

用于监听多种类型设备在线/离线状态变化的接口。

### 7. ScheduledDeviceCheckTask（定时设备检测任务）

定时任务，定期检查在线设备状态，将超时未活动的设备标记为离线。

## 使用方法

### 基本使用（单一设备类型）

```java
// 注入设备状态服务
@Inject
private DeviceStatusService deviceStatusService;

// 处理设备在线事件
deviceStatusService.handleOnlineEvent("device_001");

// 处理设备离线事件
deviceStatusService.handleOfflineEvent("device_001");

// 检查设备是否在线
boolean isOnline = deviceStatusService.isOnline("device_001");
```

### 使用监听器（单一设备类型）

```java
// 实现设备状态监听器接口
public class MyDeviceStatusListener implements DeviceStatusChangeListener {
    @Override
    public void onDeviceOnline(String deviceId) {
        // 设备上线处理逻辑
        updateDatabaseStatus(deviceId, "online");
    }
    
    @Override
    public void onDeviceOffline(String deviceId) {
        // 设备下线处理逻辑
        updateDatabaseStatus(deviceId, "offline");
    }
    
    private void updateDatabaseStatus(String deviceId, String status) {
        // 更新数据库状态
    }
}

// 注册监听器
deviceStatusService.addListener(new MyDeviceStatusListener());
```

### 多设备类型管理

```java
// 注入多设备状态管理器
@Inject
private MultiDeviceStateManager multiDeviceStateManager;

// 注册不同类型设备的状态管理器
multiDeviceStateManager.registerStateManager("camera", cameraDeviceStateManager);
multiDeviceStateManager.registerStateManager("nvr", nvrDeviceStateManager);

// 处理摄像头设备在线事件
CameraDevice camera = new CameraDevice("camera_001", "Camera1", "192.168.1.100", 80);
multiDeviceStateManager.handleOnlineEvent("camera", camera);

// 处理NVR设备在线事件
NvrDevice nvr = new NvrDevice("nvr_001", "NVR1", "192.168.1.101", 80, 16);
multiDeviceStateManager.handleOnlineEvent("nvr", nvr);

// 检查设备是否在线
boolean isCameraOnline = multiDeviceStateManager.isOnline("camera", camera);
boolean isNvrOnline = multiDeviceStateManager.isOnline("nvr", nvr);

// 获取指定类型设备的在线数量
int cameraOnlineCount = multiDeviceStateManager.getOnlineDeviceCount("camera");
int nvrOnlineCount = multiDeviceStateManager.getOnlineDeviceCount("nvr");

// 获取所有在线设备数量
int totalOnlineCount = multiDeviceStateManager.getTotalOnlineDeviceCount();
```

### 多设备监听器

```java
// 实现多设备状态监听器接口
public class MyMultiDeviceStatusListener implements MultiDeviceStatusChangeListener {
    @Override
    public void onDeviceOnline(String deviceType, String deviceId) {
        // 设备上线处理逻辑
        updateDatabaseStatus(deviceType, deviceId, "online");
    }
    
    @Override
    public void onDeviceOffline(String deviceType, String deviceId) {
        // 设备下线处理逻辑
        updateDatabaseStatus(deviceType, deviceId, "offline");
    }
    
    private void updateDatabaseStatus(String deviceType, String deviceId, String status) {
        // 根据设备类型和ID更新数据库状态
    }
}

// 注册监听器
multiDeviceStateManager.addListener(new MyMultiDeviceStatusListener());
```

### 启用定时检测功能

```java
// 启用定时检测功能
multiDeviceStateManager.enableAllScheduledCheck();

// 为特定类型设备设置超时时间
multiDeviceStateManager.setDeviceTimeoutMillis("camera", 300000); // 5分钟
multiDeviceStateManager.setDeviceTimeoutMillis("nvr", 600000);    // 10分钟

// 也可以手动执行检测
int offlineCount = multiDeviceStateManager.performAllScheduledCheck();
```

## 测试

所有组件都包含完整的单元测试和集成测试，位于`src/test/java/com/fliad/common/state`目录下：

- `AbstractStateManagerTest.java` - 抽象状态管理器测试
- `DeviceStateManagerTest.java` - 设备状态管理器测试
- `MultiDeviceStateManagerTest.java` - 多设备状态管理器测试
- `ScheduledDeviceCheckTaskTest.java` - 定时检测任务测试
- `StateIntegrationTest.java` - 集成测试

测试用例覆盖了以下场景：
- 设备上线/下线事件处理
- 重复事件处理避免
- 监听器回调机制
- 多设备类型管理
- 定时检测功能

## 特性

1. **避免重复处理**：当设备已经在内存中处于在线状态时，收到在线事件不处理
2. **状态一致性**：内存状态与缓存状态保持一致
3. **扩展性强**：支持监听器模式，可以自定义状态变更处理逻辑
4. **通用性**：提供抽象类，可以轻松扩展用于管理其他实体状态
5. **异常安全**：监听器异常不会影响主流程执行
6. **定时检测**：支持定时检测超时设备并自动标记为离线
7. **灵活配置**：可配置超时时间和功能开关
8. **多设备支持**：支持同时管理多种不同类型的设备
9. **统一管理**：提供统一接口管理所有类型设备的状态
10. **完整测试**：提供全面的单元测试和集成测试

## 注意事项

1. 需要依赖CommonCacheOperator进行缓存操作
2. 状态变更回调在独立的try-catch块中执行，防止异常影响主流程
3. 可以通过实现AbstractStateManager来管理其他类型的实体状态
4. 定时检测功能默认不开启，需要手动调用enableScheduledCheck()方法开启
5. 超时时间默认为300秒（5分钟），可通过setDeviceTimeoutMillis()方法修改
6. 多设备管理器需要先注册各类型设备的状态管理器才能使用
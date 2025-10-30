# 设备状态管理器测试说明

本目录包含了设备状态管理器相关的单元测试。

## 测试类说明

1. **DeviceStateManagerTest.java** - 使用Mockito模拟缓存操作的DeviceStateManager测试
2. **DeviceTypeStateManagerTest.java** - DeviceTypeStateManager的单元测试
3. **DeviceStateManagerWithMockCacheTest.java** - 使用自定义MockCommonCacheOperator的DeviceStateManager测试
4. **MockCommonCacheOperator.java** - 用于测试的缓存操作器模拟实现

## 运行测试

在项目根目录下执行以下命令：

```bash
# 运行所有测试
mvn test

# 运行特定测试类
mvn test -Dtest=com.fliad.common.state.DeviceStateManagerTest
mvn test -Dtest=com.fliad.common.state.DeviceTypeStateManagerTest
mvn test -Dtest=com.fliad.common.state.DeviceStateManagerWithMockCacheTest

# 运行特定测试方法
mvn test -Dtest=com.fliad.common.state.DeviceStateManagerTest#testHandleOnlineEvent_DefaultDeviceType
```

## 测试覆盖的功能点

- 设备上线/下线事件处理
- 多设备类型支持
- 监听器机制
- 缓存操作验证
- 定时检查功能
- 并发操作处理
- 异常输入处理
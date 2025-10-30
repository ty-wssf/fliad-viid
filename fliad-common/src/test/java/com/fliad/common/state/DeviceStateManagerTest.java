package com.fliad.common.state;

import cn.hutool.core.collection.CollectionUtil;
import com.fliad.common.cache.CommonCacheOperator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * DeviceStateManager 测试类
 */
class DeviceStateManagerTest {

    private DeviceStateManager deviceStateManager;

    @Mock
    private CommonCacheOperator cacheOperator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deviceStateManager = new DeviceStateManager(cacheOperator);
    }

    @Test
    void testHandleOnlineEvent_DefaultDeviceType() {
        String deviceId = "device123";

        // 测试设备上线事件处理
        boolean result = deviceStateManager.handleOnlineEvent(deviceId);

        assertTrue(result);
        assertTrue(deviceStateManager.isOnline(deviceId));
        assertEquals(1, deviceStateManager.getTotalOnlineDeviceCount());

        // 验证缓存操作
        verify(cacheOperator).put(eq("device:online:device123"), eq("1"));
    }

    @Test
    void testHandleOnlineEvent_SpecificDeviceType() {
        String deviceType = "camera";
        String cachePrefix = "device:camera:online:";
        String deviceId = "camera123";

        // 注册新的设备类型
        deviceStateManager.registerDeviceType(deviceType, cachePrefix);

        // 测试设备上线事件处理
        boolean result = deviceStateManager.handleOnlineEvent(deviceType, deviceId);

        assertTrue(result);
        assertTrue(deviceStateManager.isOnline(deviceType, deviceId));
        assertEquals(1, deviceStateManager.getOnlineDeviceCount(deviceType));

        // 验证缓存操作
        verify(cacheOperator).put(eq("device:camera:online:camera123"), eq("1"));
    }

    @Test
    void testHandleOfflineEvent_DefaultDeviceType() {
        String deviceId = "device123";

        // 先让设备上线
        deviceStateManager.handleOnlineEvent(deviceId);
        assertTrue(deviceStateManager.isOnline(deviceId));

        // 测试设备下线事件处理
        boolean result = deviceStateManager.handleOfflineEvent(deviceId);

        assertTrue(result);
        assertFalse(deviceStateManager.isOnline(deviceId));
        assertEquals(0, deviceStateManager.getTotalOnlineDeviceCount());

        // 验证缓存操作
        verify(cacheOperator).remove(eq("device:online:device123"));
    }

    @Test
    void testHandleOfflineEvent_SpecificDeviceType() {
        String deviceType = "camera";
        String cachePrefix = "device:camera:online:";
        String deviceId = "camera123";

        // 注册新的设备类型
        deviceStateManager.registerDeviceType(deviceType, cachePrefix);

        // 先让设备上线
        deviceStateManager.handleOnlineEvent(deviceType, deviceId);
        assertTrue(deviceStateManager.isOnline(deviceType, deviceId));

        // 测试设备下线事件处理
        boolean result = deviceStateManager.handleOfflineEvent(deviceType, deviceId);

        assertTrue(result);
        assertFalse(deviceStateManager.isOnline(deviceType, deviceId));
        assertEquals(0, deviceStateManager.getOnlineDeviceCount(deviceType));

        // 验证缓存操作
        verify(cacheOperator).remove(eq("device:camera:online:camera123"));
    }

    @Test
    void testDeviceStatusChangeListener() throws InterruptedException {
        String deviceId = "device123";
        CountDownLatch onlineLatch = new CountDownLatch(1);
        CountDownLatch offlineLatch = new CountDownLatch(1);

        String localDeviceId = deviceId;

        // 创建监听器
        DeviceStatusChangeListener listener = new DeviceStatusChangeListener() {
            @Override
            public void onDeviceOnline(String deviceId) {
                if (localDeviceId.equals(deviceId)) {
                    onlineLatch.countDown();
                }
            }

            @Override
            public void onDeviceOffline(String deviceId) {
                if (localDeviceId.equals(deviceId)) {
                    offlineLatch.countDown();
                }
            }
        };

        // 添加监听器
        deviceStateManager.addListener(listener);

        // 触发上线事件
        deviceStateManager.handleOnlineEvent(deviceId);
        assertTrue(onlineLatch.await(5, TimeUnit.SECONDS), "设备上线回调未在预期时间内触发");

        // 触发下线事件
        deviceStateManager.handleOfflineEvent(deviceId);
        assertTrue(offlineLatch.await(5, TimeUnit.SECONDS), "设备下线回调未在预期时间内触发");

        // 移除监听器
        deviceStateManager.removeListener(listener);
    }

    @Test
    void testMultiDeviceStatusChangeListener() throws InterruptedException {
        String deviceType = "camera";
        String cachePrefix = "device:camera:online:";
        String deviceId = "camera123";
        CountDownLatch onlineLatch = new CountDownLatch(1);
        CountDownLatch offlineLatch = new CountDownLatch(1);

        // 注册新的设备类型
        deviceStateManager.registerDeviceType(deviceType, cachePrefix);

        String localDeviceId = deviceId;
        String localDeviceType = deviceType;

        // 创建监听器
        MultiDeviceStatusChangeListener listener = new MultiDeviceStatusChangeListener() {
            @Override
            public void onDeviceOnline(String deviceType, String deviceId) {
                if (localDeviceId.equals(deviceId) &&
                        localDeviceType.equals(deviceType)) {
                    onlineLatch.countDown();
                }
            }

            @Override
            public void onDeviceOffline(String deviceType, String deviceId) {
                if (localDeviceId.equals(deviceId) &&
                        localDeviceType.equals(deviceType)) {
                    offlineLatch.countDown();
                }
            }
        };

        // 添加监听器
        deviceStateManager.addListener(listener);

        // 触发上线事件
        deviceStateManager.handleOnlineEvent(deviceType, deviceId);
        assertTrue(onlineLatch.await(5, TimeUnit.SECONDS), "多设备上线回调未在预期时间内触发");

        // 触发下线事件
        deviceStateManager.handleOfflineEvent(deviceType, deviceId);
        assertTrue(offlineLatch.await(5, TimeUnit.SECONDS), "多设备下线回调未在预期时间内触发");

        // 移除监听器
        deviceStateManager.removeListener(listener);
    }

    @Test
    void testGetOnlineDevices() {
        String deviceType = "camera";
        String cachePrefix = "device:camera:online:";
        String deviceId1 = "camera1";
        String deviceId2 = "camera2";

        // 注册新的设备类型
        deviceStateManager.registerDeviceType(deviceType, cachePrefix);

        // 让两个设备上线
        deviceStateManager.handleOnlineEvent(deviceType, deviceId1);
        deviceStateManager.handleOnlineEvent(deviceType, deviceId2);

        // 获取在线设备列表
        Set<String> onlineDevices = deviceStateManager.getOnlineDevices(deviceType);
        assertEquals(2, onlineDevices.size());
        assertTrue(onlineDevices.contains(deviceId1));
        assertTrue(onlineDevices.contains(deviceId2));
    }

    @Test
    void testGetAllOnlineDevices() {
        String cameraType = "camera";
        String cameraCachePrefix = "device:camera:online:";
        String nvrType = "nvr";
        String nvrCachePrefix = "device:nvr:online:";
        String cameraId = "camera1";
        String nvrId = "nvr1";

        // 注册新的设备类型
        deviceStateManager.registerDeviceType(cameraType, cameraCachePrefix);
        deviceStateManager.registerDeviceType(nvrType, nvrCachePrefix);

        // 让设备上线
        deviceStateManager.handleOnlineEvent(cameraType, cameraId);
        deviceStateManager.handleOnlineEvent(nvrType, nvrId);

        // 获取所有在线设备
        Map<String, Set<String>> allOnlineDevices = deviceStateManager.getAllOnlineDevices();
        assertEquals(3, allOnlineDevices.size()); // 包含默认类型

        Set<String> cameraDevices = allOnlineDevices.get(cameraType);
        Set<String> nvrDevices = allOnlineDevices.get(nvrType);

        assertNotNull(cameraDevices);
        assertNotNull(nvrDevices);
        assertTrue(cameraDevices.contains(cameraId));
        assertTrue(nvrDevices.contains(nvrId));
    }

    @Test
    void testRegisterAndUnregisterDeviceType() {
        String deviceType = "camera";
        String cachePrefix = "device:camera:online:";

        // 注册设备类型
        deviceStateManager.registerDeviceType(deviceType, cachePrefix);
        assertTrue(deviceStateManager.getDeviceTypes().contains(deviceType));

        // 尝试重复注册（应该被忽略）
        deviceStateManager.registerDeviceType(deviceType, cachePrefix);
        assertTrue(deviceStateManager.getDeviceTypes().contains(deviceType));

        // 注销设备类型
        deviceStateManager.unregisterDeviceType(deviceType);
        assertFalse(deviceStateManager.getDeviceTypes().contains(deviceType));

        // 尝试注销默认设备类型（应该被拒绝）
        deviceStateManager.unregisterDeviceType("default");
        assertTrue(deviceStateManager.getDeviceTypes().contains("default"));
    }

    @Test
    void testSetDeviceTimeoutMillis() {
        String deviceType = "camera";
        String cachePrefix = "device:camera:online:";
        long timeoutMillis = 5000L;

        // 注册设备类型
        deviceStateManager.registerDeviceType(deviceType, cachePrefix);

        // 设置超时时间
        deviceStateManager.setDeviceTimeoutMillis(deviceType, timeoutMillis);
        // 这个方法没有返回值，所以只能验证没有抛出异常
        assertDoesNotThrow(() -> deviceStateManager.setDeviceTimeoutMillis(deviceType, timeoutMillis));
    }

    @Test
    void testInvalidInputs() {
        // 测试无效输入
        assertFalse(deviceStateManager.handleOnlineEvent(null, "deviceId"));
        assertFalse(deviceStateManager.handleOnlineEvent("", "deviceId"));
        assertFalse(deviceStateManager.handleOnlineEvent("deviceType", null));
        assertFalse(deviceStateManager.handleOnlineEvent("deviceType", ""));

        assertFalse(deviceStateManager.handleOfflineEvent(null, "deviceId"));
        assertFalse(deviceStateManager.handleOfflineEvent("", "deviceId"));
        assertFalse(deviceStateManager.handleOfflineEvent("deviceType", null));
        assertFalse(deviceStateManager.handleOfflineEvent("deviceType", ""));

        assertFalse(deviceStateManager.isOnline(null, "deviceId"));
        assertFalse(deviceStateManager.isOnline("", "deviceId"));
        assertFalse(deviceStateManager.isOnline("deviceType", null));
        assertFalse(deviceStateManager.isOnline("deviceType", ""));
    }
}
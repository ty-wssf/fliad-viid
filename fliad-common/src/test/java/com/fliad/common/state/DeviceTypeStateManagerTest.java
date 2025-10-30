package com.fliad.common.state;

import com.fliad.common.cache.CommonCacheOperator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * DeviceTypeStateManager 测试类
 */
class DeviceTypeStateManagerTest {
    
    private DeviceTypeStateManager deviceTypeStateManager;
    
    @Mock
    private CommonCacheOperator cacheOperator;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deviceTypeStateManager = new DeviceTypeStateManager(cacheOperator, "device:test:online:", "test");
    }
    
    @Test
    void testHandleOnlineEvent() {
        String entityId = "entity123";
        
        // 测试实体上线事件处理
        boolean result = deviceTypeStateManager.handleOnlineEvent(entityId);
        
        assertTrue(result);
        assertTrue(deviceTypeStateManager.isOnlineById(entityId));
        assertEquals(1, deviceTypeStateManager.getOnlineEntityCount());
        
        // 验证缓存操作
        verify(cacheOperator).put(eq("device:test:online:entity123"), eq("1"));
    }
    
    @Test
    void testHandleDuplicateOnlineEvent() {
        String entityId = "entity123";
        
        // 第一次上线
        boolean firstResult = deviceTypeStateManager.handleOnlineEvent(entityId);
        assertTrue(firstResult);
        
        // 重复上线
        boolean secondResult = deviceTypeStateManager.handleOnlineEvent(entityId);
        assertFalse(secondResult); // 应该返回false，因为状态未改变
        
        assertTrue(deviceTypeStateManager.isOnlineById(entityId));
        assertEquals(1, deviceTypeStateManager.getOnlineEntityCount());
    }
    
    @Test
    void testHandleOfflineEvent() {
        String entityId = "entity123";
        
        // 先让实体上线
        deviceTypeStateManager.handleOnlineEvent(entityId);
        assertTrue(deviceTypeStateManager.isOnlineById(entityId));
        
        // 测试实体下线事件处理
        boolean result = deviceTypeStateManager.handleOfflineEvent(entityId);
        
        assertTrue(result);
        assertFalse(deviceTypeStateManager.isOnlineById(entityId));
        assertEquals(0, deviceTypeStateManager.getOnlineEntityCount());
        
        // 验证缓存操作
        verify(cacheOperator).remove(eq("device:test:online:entity123"));
    }
    
    @Test
    void testHandleOfflineEventForNonExistentEntity() {
        String entityId = "entity123";
        
        // 尝试对不存在的实体执行下线操作
        boolean result = deviceTypeStateManager.handleOfflineEvent(entityId);
        
        assertFalse(result);
        assertFalse(deviceTypeStateManager.isOnlineById(entityId));
        assertEquals(0, deviceTypeStateManager.getOnlineEntityCount());
    }
    
    @Test
    void testStatusChangeCallback() throws InterruptedException {
        String entityId = "entity123";
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<String> capturedEntityId = new AtomicReference<>();
        AtomicReference<String> capturedStatus = new AtomicReference<>();
        
        // 设置回调函数
        deviceTypeStateManager.setStatusChangeCallback((id, status) -> {
            capturedEntityId.set(id);
            capturedStatus.set(status);
            latch.countDown();
        });
        
        // 触发上线事件
        deviceTypeStateManager.handleOnlineEvent(entityId);
        
        // 等待回调执行
        assertTrue(latch.await(1, TimeUnit.SECONDS));
        assertEquals(entityId, capturedEntityId.get());
        assertEquals("online", capturedStatus.get());
    }
    
    @Test
    void testGetOnlineEntities() {
        String entityId1 = "entity1";
        String entityId2 = "entity2";
        
        // 让两个实体上线
        deviceTypeStateManager.handleOnlineEvent(entityId1);
        deviceTypeStateManager.handleOnlineEvent(entityId2);
        
        // 获取在线实体列表
        var onlineEntities = deviceTypeStateManager.getOnlineEntities();
        assertEquals(2, onlineEntities.size());
        assertTrue(onlineEntities.contains(entityId1));
        assertTrue(onlineEntities.contains(entityId2));
    }
    
    @Test
    void testEnableAndDisableScheduledCheck() {
        // 默认应该是禁用的
        assertFalse(deviceTypeStateManager.isScheduledCheckEnabled());
        
        // 启用定时检查
        deviceTypeStateManager.enableScheduledCheck();
        assertTrue(deviceTypeStateManager.isScheduledCheckEnabled());
        
        // 禁用定时检查
        deviceTypeStateManager.disableScheduledCheck();
        assertFalse(deviceTypeStateManager.isScheduledCheckEnabled());
    }
    
    @Test
    void testPerformScheduledCheckWithoutEnable() {
        String entityId = "entity123";
        
        // 让实体上线
        deviceTypeStateManager.handleOnlineEvent(entityId);
        
        // 在未启用定时检查的情况下执行检查，应该返回0
        int offlineCount = deviceTypeStateManager.performScheduledCheck();
        assertEquals(0, offlineCount);
        assertTrue(deviceTypeStateManager.isOnlineById(entityId)); // 实体仍然在线
    }
    
    @Test
    void testSetEntityTimeoutMillis() {
        long timeoutMillis = 1000L;
        
        // 设置超时时间
        deviceTypeStateManager.setEntityTimeoutMillis(timeoutMillis);
        
        // 这个方法没有直接的返回值或可验证的行为，所以我们只能确保它不会抛出异常
        assertDoesNotThrow(() -> deviceTypeStateManager.setEntityTimeoutMillis(timeoutMillis));
    }
    
    @Test
    void testInvalidInputs() {
        // 测试无效输入
        assertFalse(deviceTypeStateManager.handleOnlineEvent(null));
        assertFalse(deviceTypeStateManager.handleOnlineEvent(""));
        
        assertFalse(deviceTypeStateManager.handleOfflineEvent(null));
        assertFalse(deviceTypeStateManager.handleOfflineEvent(""));
        
        assertFalse(deviceTypeStateManager.isOnlineById(null));
        assertFalse(deviceTypeStateManager.isOnlineById(""));
    }
}
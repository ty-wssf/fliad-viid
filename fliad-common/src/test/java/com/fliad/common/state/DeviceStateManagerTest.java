/*
 * Copyright [2022] [https://www.xiaonuo.vip]
 *
 * Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：
 *
 * 1.请不要删除和修改根目录下的LICENSE文件。
 * 2.请不要删除和修改Snowy源码头部的版权声明。
 * 3.本项目代码可免费商业使用，商业使用请保留源码和相关描述文件的项目出处，作者声明等。
 * 4.分发源码时候，请注明软件出处 https://www.xiaonuo.vip
 * 5.不可二次分发开源参与同类竞品，如有想法可联系团队xiaonuobase@qq.com商议合作。
 * 6.若您的项目无法满足以上几点，需要更多功能代码，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package com.fliad.common.state;

import com.fliad.common.cache.CommonCacheOperator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * 设备状态管理器测试类
 *
 * @author lingma
 * @date 2025/10/29
 */
public class DeviceStateManagerTest {
    
    @Mock
    private CommonCacheOperator cacheOperator;
    
    private DeviceStateManager deviceStateManager;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        deviceStateManager = new DeviceStateManager(cacheOperator);
    }
    
    @Test
    public void testHandleOnlineEvent() {
        String deviceId = "device_001";
        
        // 第一次处理上线事件，应该返回true
        boolean result1 = deviceStateManager.handleOnlineEvent(deviceId);
        assertTrue(result1, "第一次处理上线事件应该返回true");
        
        // 验证调用了缓存操作
        verify(cacheOperator).put(anyString(), anyString());
        
        // 再次处理相同的上线事件，应该返回false
        boolean result2 = deviceStateManager.handleOnlineEvent(deviceId);
        assertFalse(result2, "重复处理上线事件应该返回false");
    }
    
    @Test
    public void testHandleOfflineEvent() {
        String deviceId = "device_001";
        
        // 处理下线事件，但设备未上线，应该返回false
        boolean result1 = deviceStateManager.handleOfflineEvent(deviceId);
        assertFalse(result1, "设备未上线时处理下线事件应该返回false");
        
        // 先让设备上线
        deviceStateManager.handleOnlineEvent(deviceId);
        
        // 再处理下线事件，应该返回true
        boolean result2 = deviceStateManager.handleOfflineEvent(deviceId);
        assertTrue(result2, "设备上线后处理下线事件应该返回true");
        
        // 验证调用了缓存移除操作
        verify(cacheOperator).remove(anyString());
        
        // 再次处理下线事件，应该返回false
        boolean result3 = deviceStateManager.handleOfflineEvent(deviceId);
        assertFalse(result3, "重复处理下线事件应该返回false");
    }
    
    @Test
    public void testIsOnline() {
        String deviceId = "device_001";
        
        // 设备未上线时，应该返回false
        assertFalse(deviceStateManager.isOnline(deviceId), "设备未上线时应该返回false");
        
        // 设备上线后，应该返回true
        deviceStateManager.handleOnlineEvent(deviceId);
        assertTrue(deviceStateManager.isOnline(deviceId), "设备上线后应该返回true");
        
        // 设备下线后，应该返回false
        deviceStateManager.handleOfflineEvent(deviceId);
        assertFalse(deviceStateManager.isOnline(deviceId), "设备下线后应该返回false");
    }
    
    @Test
    public void testGetOnlineDeviceCount() {
        String device1 = "device_001";
        String device2 = "device_002";
        
        // 初始在线设备数量应该为0
        assertEquals(0, deviceStateManager.getOnlineEntityCount(), "初始在线设备数量应该为0");
        
        // 设备1上线
        deviceStateManager.handleOnlineEvent(device1);
        assertEquals(1, deviceStateManager.getOnlineEntityCount(), "设备1上线后在线设备数量应该为1");
        
        // 设备2上线
        deviceStateManager.handleOnlineEvent(device2);
        assertEquals(2, deviceStateManager.getOnlineEntityCount(), "设备2上线后在线设备数量应该为2");
        
        // 设备1下线
        deviceStateManager.handleOfflineEvent(device1);
        assertEquals(1, deviceStateManager.getOnlineEntityCount(), "设备1下线后在线设备数量应该为1");
    }
}
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
import com.fliad.common.state.example.CameraDevice;
import com.fliad.common.state.example.CameraDeviceStateManager;
import com.fliad.common.state.example.NvrDevice;
import com.fliad.common.state.example.NvrDeviceStateManager;
import com.fliad.common.state.example.TestDeviceStatusListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * 状态管理器集成测试类
 *
 * @author lingma
 * @date 2025/10/29
 */
public class StateIntegrationTest {
    
    @Mock
    private CommonCacheOperator cacheOperator;
    
    private MultiDeviceStateManager multiDeviceStateManager;
    private DeviceStatusService deviceStatusService;
    private TestDeviceStatusListener testListener;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        multiDeviceStateManager = new MultiDeviceStateManager();
        deviceStatusService = new DeviceStatusService();
        
        // 使用反射设置私有字段
        try {
            java.lang.reflect.Field cacheOperatorField = DeviceStatusService.class.getDeclaredField("cacheOperator");
            cacheOperatorField.setAccessible(true);
            cacheOperatorField.set(deviceStatusService, cacheOperator);
            
            java.lang.reflect.Field stateManagerField = DeviceStatusService.class.getDeclaredField("deviceStateManager");
            stateManagerField.setAccessible(true);
            DeviceStateManager deviceStateManager = new DeviceStateManager(cacheOperator);
            stateManagerField.set(deviceStatusService, deviceStateManager);
        } catch (Exception e) {
            fail("无法设置DeviceStatusService的私有字段: " + e.getMessage());
        }
        
        testListener = new TestDeviceStatusListener();
    }
    
    @Test
    public void testMultiDeviceManagement() {
        // 注册监听器
        multiDeviceStateManager.addListener(testListener);
        
        // 创建不同类型的状态管理器
        CameraDeviceStateManager cameraManager = new CameraDeviceStateManager(cacheOperator);
        NvrDeviceStateManager nvrManager = new NvrDeviceStateManager(cacheOperator);
        
        // 注册状态管理器
        multiDeviceStateManager.registerStateManager("camera", cameraManager);
        multiDeviceStateManager.registerStateManager("nvr", nvrManager);
        
        // 创建设备实例
        CameraDevice camera1 = new CameraDevice("camera_001", "Camera1", "192.168.1.100", 80);
        CameraDevice camera2 = new CameraDevice("camera_002", "Camera2", "192.168.1.101", 80);
        NvrDevice nvr1 = new NvrDevice("nvr_001", "NVR1", "192.168.1.102", 80, 16);
        
        // 处理设备上线事件
        multiDeviceStateManager.handleOnlineEvent("camera", camera1);
        multiDeviceStateManager.handleOnlineEvent("camera", camera2);
        multiDeviceStateManager.handleOnlineEvent("nvr", nvr1);
        
        // 验证监听器收到的事件
        assertEquals(3, testListener.getMultiOnlineEvents().size(), "应该收到3个上线事件");
        assertTrue(testListener.getMultiOnlineEvents().contains("camera:camera_001"), "应该包含camera_001上线事件");
        assertTrue(testListener.getMultiOnlineEvents().contains("camera:camera_002"), "应该包含camera_002上线事件");
        assertTrue(testListener.getMultiOnlineEvents().contains("nvr:nvr_001"), "应该包含nvr_001上线事件");
        
        // 验证在线设备数量
        assertEquals(2, multiDeviceStateManager.getOnlineDeviceCount("camera"), "摄像头在线数量应该为2");
        assertEquals(1, multiDeviceStateManager.getOnlineDeviceCount("nvr"), "NVR在线数量应该为1");
        assertEquals(3, multiDeviceStateManager.getTotalOnlineDeviceCount(), "总在线设备数量应该为3");
        
        // 处理设备下线事件
        multiDeviceStateManager.handleOfflineEvent("camera", camera1);
        
        // 验证监听器收到的事件
        assertEquals(1, testListener.getMultiOfflineEvents().size(), "应该收到1个下线事件");
        assertTrue(testListener.getMultiOfflineEvents().contains("camera:camera_001"), "应该包含camera_001下线事件");
        
        // 验证在线设备数量
        assertEquals(1, multiDeviceStateManager.getOnlineDeviceCount("camera"), "摄像头在线数量应该为1");
        assertEquals(1, multiDeviceStateManager.getOnlineDeviceCount("nvr"), "NVR在线数量应该为1");
        assertEquals(2, multiDeviceStateManager.getTotalOnlineDeviceCount(), "总在线设备数量应该为2");
    }
    
    @Test
    public void testSingleDeviceManagement() {
        // 注册监听器
        deviceStatusService.addListener(testListener);
        
        // 处理设备上线事件
        deviceStatusService.handleOnlineEvent("device_001");
        deviceStatusService.handleOnlineEvent("device_002");
        
        // 验证监听器收到的事件
        assertEquals(2, testListener.getOnlineEvents().size(), "应该收到2个上线事件");
        assertTrue(testListener.getOnlineEvents().contains("device_001"), "应该包含device_001上线事件");
        assertTrue(testListener.getOnlineEvents().contains("device_002"), "应该包含device_002上线事件");
        
        // 验证在线设备数量
        assertEquals(2, deviceStatusService.getOnlineDeviceCount(), "在线设备数量应该为2");
        
        // 处理设备下线事件
        deviceStatusService.handleOfflineEvent("device_001");
        
        // 验证监听器收到的事件
        assertEquals(1, testListener.getOfflineEvents().size(), "应该收到1个下线事件");
        assertTrue(testListener.getOfflineEvents().contains("device_001"), "应该包含device_001下线事件");
        
        // 验证在线设备数量
        assertEquals(1, deviceStatusService.getOnlineDeviceCount(), "在线设备数量应该为1");
    }
}
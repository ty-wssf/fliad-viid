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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * 多设备状态管理器测试类
 *
 * @author lingma
 * @date 2025/10/29
 */
public class MultiDeviceStateManagerTest {
    
    @Mock
    private CommonCacheOperator cacheOperator;
    
    private MultiDeviceStateManager multiDeviceStateManager;
    private CameraDeviceStateManager cameraDeviceStateManager;
    private NvrDeviceStateManager nvrDeviceStateManager;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        multiDeviceStateManager = new MultiDeviceStateManager();
        cameraDeviceStateManager = new CameraDeviceStateManager(cacheOperator);
        nvrDeviceStateManager = new NvrDeviceStateManager(cacheOperator);
    }
    
    @Test
    public void testRegisterAndUnregisterStateManager() {
        // 注册状态管理器
        multiDeviceStateManager.registerStateManager("camera", cameraDeviceStateManager);
        multiDeviceStateManager.registerStateManager("nvr", nvrDeviceStateManager);
        
        // 获取状态管理器
        AbstractStateManager<CameraDevice> cameraManager = multiDeviceStateManager.getStateManager("camera");
        AbstractStateManager<NvrDevice> nvrManager = multiDeviceStateManager.getStateManager("nvr");
        
        assertNotNull(cameraManager, "应该能够获取到摄像头状态管理器");
        assertNotNull(nvrManager, "应该能够获取到NVR状态管理器");
        assertSame(cameraDeviceStateManager, cameraManager, "获取到的状态管理器应该与注册的相同");
        assertSame(nvrDeviceStateManager, nvrManager, "获取到的状态管理器应该与注册的相同");
        
        // 移除状态管理器
        multiDeviceStateManager.unregisterStateManager("camera");
        assertNull(multiDeviceStateManager.getStateManager("camera"), "移除后应该无法获取到状态管理器");
    }
    
    @Test
    public void testHandleOnlineEvent() {
        // 注册状态管理器
        multiDeviceStateManager.registerStateManager("camera", cameraDeviceStateManager);
        
        // 创建设备实例
        CameraDevice camera = new CameraDevice("camera_001", "Camera1", "192.168.1.100", 80);
        
        // 处理设备上线事件
        boolean result1 = multiDeviceStateManager.handleOnlineEvent("camera", camera);
        assertTrue(result1, "处理设备上线事件应该返回true");
        
        // 验证设备在线状态
        assertTrue(multiDeviceStateManager.isOnline("camera", camera), "设备应该在线");
        
        // 重复处理上线事件
        boolean result2 = multiDeviceStateManager.handleOnlineEvent("camera", camera);
        assertFalse(result2, "重复处理上线事件应该返回false");
    }
    
    @Test
    public void testHandleOfflineEvent() {
        // 注册状态管理器
        multiDeviceStateManager.registerStateManager("camera", cameraDeviceStateManager);
        
        // 创建设备实例
        CameraDevice camera = new CameraDevice("camera_001", "Camera1", "192.168.1.100", 80);
        
        // 处理设备下线事件，但设备未上线
        boolean result1 = multiDeviceStateManager.handleOfflineEvent("camera", camera);
        assertFalse(result1, "设备未上线时处理下线事件应该返回false");
        
        // 先让设备上线
        multiDeviceStateManager.handleOnlineEvent("camera", camera);
        
        // 再处理设备下线事件
        boolean result2 = multiDeviceStateManager.handleOfflineEvent("camera", camera);
        assertTrue(result2, "设备上线后处理下线事件应该返回true");
        
        // 验证设备离线状态
        assertFalse(multiDeviceStateManager.isOnline("camera", camera), "设备应该离线");
    }
    
    @Test
    public void testGetOnlineDeviceCount() {
        // 注册状态管理器
        multiDeviceStateManager.registerStateManager("camera", cameraDeviceStateManager);
        multiDeviceStateManager.registerStateManager("nvr", nvrDeviceStateManager);
        
        // 创建设备实例
        CameraDevice camera1 = new CameraDevice("camera_001", "Camera1", "192.168.1.100", 80);
        CameraDevice camera2 = new CameraDevice("camera_002", "Camera2", "192.168.1.101", 80);
        NvrDevice nvr1 = new NvrDevice("nvr_001", "NVR1", "192.168.1.102", 80, 16);
        
        // 初始在线设备数量应该为0
        assertEquals(0, multiDeviceStateManager.getOnlineDeviceCount("camera"), "摄像头初始在线数量应该为0");
        assertEquals(0, multiDeviceStateManager.getOnlineDeviceCount("nvr"), "NVR初始在线数量应该为0");
        assertEquals(0, multiDeviceStateManager.getTotalOnlineDeviceCount(), "总在线设备数量应该为0");
        
        // 设备上线
        multiDeviceStateManager.handleOnlineEvent("camera", camera1);
        multiDeviceStateManager.handleOnlineEvent("camera", camera2);
        multiDeviceStateManager.handleOnlineEvent("nvr", nvr1);
        
        // 验证在线设备数量
        assertEquals(2, multiDeviceStateManager.getOnlineDeviceCount("camera"), "摄像头在线数量应该为2");
        assertEquals(1, multiDeviceStateManager.getOnlineDeviceCount("nvr"), "NVR在线数量应该为1");
        assertEquals(3, multiDeviceStateManager.getTotalOnlineDeviceCount(), "总在线设备数量应该为3");
    }
}
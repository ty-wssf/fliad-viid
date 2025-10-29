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

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * 抽象状态管理器测试类
 *
 * @author lingma
 * @date 2025/10/29
 */
public class AbstractStateManagerTest {
    
    @Mock
    private CommonCacheOperator cacheOperator;
    
    private TestStateManager testStateManager;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        testStateManager = new TestStateManager(cacheOperator);
    }
    
    @Test
    public void testHandleOnlineEvent() {
        TestEntity entity1 = new TestEntity("entity_001");
        TestEntity entity2 = new TestEntity("entity_002");
        
        // 第一次处理上线事件，应该返回true
        boolean result1 = testStateManager.handleOnlineEvent(entity1);
        assertTrue(result1, "第一次处理上线事件应该返回true");
        
        // 验证调用了缓存操作
        verify(cacheOperator).put(anyString(), anyString());
        
        // 处理另一个实体的上线事件
        boolean result2 = testStateManager.handleOnlineEvent(entity2);
        assertTrue(result2, "处理不同实体的上线事件应该返回true");
        
        // 再次处理相同的实体上线事件，应该返回false
        boolean result3 = testStateManager.handleOnlineEvent(entity1);
        assertFalse(result3, "重复处理相同实体的上线事件应该返回false");
    }
    
    @Test
    public void testHandleOfflineEvent() {
        TestEntity entity = new TestEntity("entity_001");
        
        // 处理下线事件，但实体未上线，应该返回false
        boolean result1 = testStateManager.handleOfflineEvent(entity);
        assertFalse(result1, "实体未上线时处理下线事件应该返回false");
        
        // 先让实体上线
        testStateManager.handleOnlineEvent(entity);
        
        // 再处理下线事件，应该返回true
        boolean result2 = testStateManager.handleOfflineEvent(entity);
        assertTrue(result2, "实体上线后处理下线事件应该返回true");
        
        // 验证调用了缓存移除操作
        verify(cacheOperator, atLeastOnce()).remove(anyString());
        
        // 再次处理下线事件，应该返回false
        boolean result3 = testStateManager.handleOfflineEvent(entity);
        assertFalse(result3, "重复处理下线事件应该返回false");
    }
    
    @Test
    public void testIsOnline() {
        TestEntity entity = new TestEntity("entity_001");
        
        // 实体未上线时，应该返回false
        assertFalse(testStateManager.isOnline(entity), "实体未上线时应该返回false");
        
        // 实体上线后，应该返回true
        testStateManager.handleOnlineEvent(entity);
        assertTrue(testStateManager.isOnline(entity), "实体上线后应该返回true");
        
        // 实体下线后，应该返回false
        testStateManager.handleOfflineEvent(entity);
        assertFalse(testStateManager.isOnline(entity), "实体下线后应该返回false");
    }
    
    @Test
    public void testCallback() {
        AtomicInteger callbackCount = new AtomicInteger(0);
        testStateManager.setStatusChangeCallback((id, status) -> callbackCount.incrementAndGet());
        
        TestEntity entity = new TestEntity("entity_001");
        
        // 处理上线事件，应该触发回调
        testStateManager.handleOnlineEvent(entity);
        assertEquals(1, callbackCount.get(), "处理上线事件应该触发回调");
        
        // 处理下线事件，应该触发回调
        testStateManager.handleOfflineEvent(entity);
        assertEquals(2, callbackCount.get(), "处理下线事件应该触发回调");
        
        // 重复处理不触发回调
        testStateManager.handleOnlineEvent(entity);
        testStateManager.handleOnlineEvent(entity);
        assertEquals(3, callbackCount.get(), "只有第一次应该触发回调");
    }
    
    /**
     * 测试用的状态管理器实现
     */
    private static class TestStateManager extends AbstractStateManager<TestEntity> {
        
        private static final String TEST_ONLINE_PREFIX = "test:online:";
        
        public TestStateManager(CommonCacheOperator cacheOperator) {
            super(cacheOperator);
        }
        
        @Override
        protected String getOnlineEntityCachePrefix() {
            return TEST_ONLINE_PREFIX;
        }
        
        @Override
        protected String getEntityId(TestEntity entity) {
            return entity != null ? entity.getId() : null;
        }
    }
    
    /**
     * 测试用的实体类
     */
    private static class TestEntity {
        private final String id;
        
        public TestEntity(String id) {
            this.id = id;
        }
        
        public String getId() {
            return id;
        }
    }
}
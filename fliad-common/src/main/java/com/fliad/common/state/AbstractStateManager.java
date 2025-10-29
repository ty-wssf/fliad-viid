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

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.fliad.common.cache.CommonCacheOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;

/**
 * 通用状态管理器抽象类
 * 可用于管理各种实体的在线/离线状态
 *
 * @param <T> 实体类型
 * @author lingma
 * @date 2025/10/29
 */
public abstract class AbstractStateManager<T> {
    
    private static final Logger log = LoggerFactory.getLogger(AbstractStateManager.class);
    
    /**
     * 在线实体缓存key前缀，子类需要重写该方法提供前缀
     */
    protected abstract String getOnlineEntityCachePrefix();
    
    /**
     * 获取实体ID的方法，子类需要实现
     *
     * @param entity 实体对象
     * @return 实体ID
     */
    protected abstract String getEntityId(T entity);
    
    /**
     * 内存中维护的在线实体集合
     */
    private final Set<String> onlineEntities = ConcurrentHashMap.newKeySet();
    
    /**
     * 实体最后活跃时间记录
     */
    private final Map<String, Long> entityLastActiveTime = new ConcurrentHashMap<>();
    
    /**
     * 定时检测功能开关
     */
    private final AtomicBoolean enableScheduledCheck = new AtomicBoolean(false);
    
    /**
     * 实体超时时间（毫秒），默认300秒
     */
    private volatile long entityTimeoutMillis = 300 * 1000L;
    
    /**
     * 状态变更回调函数
     * 参数1: 实体ID
     * 参数2: 状态变更类型(online/offline)
     */
    private BiConsumer<String, String> statusChangeCallback;
    
    private final CommonCacheOperator cacheOperator;
    
    public AbstractStateManager(CommonCacheOperator cacheOperator) {
        this.cacheOperator = cacheOperator;
    }
    
    /**
     * 设置状态变更回调函数
     *
     * @param callback 回调函数
     */
    public void setStatusChangeCallback(BiConsumer<String, String> callback) {
        this.statusChangeCallback = callback;
    }
    
    /**
     * 处理实体上线事件
     * 如果实体已经在内存中处于在线状态，则不处理
     * 如果实体不在线，则更新状态并触发回调
     *
     * @param entity 实体对象
     * @return true-状态已变更，false-状态未变更
     */
    public boolean handleOnlineEvent(T entity) {
        String entityId = getEntityId(entity);
        if (StrUtil.isBlank(entityId)) {
            log.warn("实体ID为空，无法处理上线事件");
            return false;
        }
        
        // 更新实体最后活跃时间
        if (enableScheduledCheck.get()) {
            entityLastActiveTime.put(entityId, System.currentTimeMillis());
        }
        
        // 如果实体已经在内存中在线，不处理
        if (onlineEntities.contains(entityId)) {
            log.debug("实体{}已经在线，无需重复处理上线事件", entityId);
            return false;
        }
        
        // 更新内存状态
        onlineEntities.add(entityId);
        
        // 更新缓存
        cacheOperator.put(getOnlineEntityCachePrefix() + entityId, "1");
        
        // 触发回调
        if (statusChangeCallback != null) {
            try {
                statusChangeCallback.accept(entityId, "online");
            } catch (Exception e) {
                log.error("处理实体上线事件回调异常，实体ID: {}", entityId, e);
            }
        }
        
        log.info("实体{}已上线", entityId);
        return true;
    }
    
    /**
     * 处理实体下线事件
     * 只有当实体在内存中处于在线状态时，才需要处理下线事件
     *
     * @param entity 实体对象
     * @return true-状态已变更，false-状态未变更
     */
    public boolean handleOfflineEvent(T entity) {
        String entityId = getEntityId(entity);
        if (StrUtil.isBlank(entityId)) {
            log.warn("实体ID为空，无法处理下线事件");
            return false;
        }
        
        // 移除实体最后活跃时间记录
        if (enableScheduledCheck.get()) {
            entityLastActiveTime.remove(entityId);
        }
        
        // 只有当实体在线时才处理下线事件
        if (!onlineEntities.contains(entityId)) {
            log.debug("实体{}不在线，无需处理下线事件", entityId);
            return false;
        }
        
        // 更新内存状态
        onlineEntities.remove(entityId);
        
        // 清除缓存
        cacheOperator.remove(getOnlineEntityCachePrefix() + entityId);
        
        // 触发回调
        if (statusChangeCallback != null) {
            try {
                statusChangeCallback.accept(entityId, "offline");
            } catch (Exception e) {
                log.error("处理实体下线事件回调异常，实体ID: {}", entityId, e);
            }
        }
        
        log.info("实体{}已下线", entityId);
        return true;
    }
    
    /**
     * 检查实体是否在线
     *
     * @param entity 实体对象
     * @return true-在线，false-离线
     */
    public boolean isOnline(T entity) {
        String entityId = getEntityId(entity);
        if (StrUtil.isBlank(entityId)) {
            return false;
        }
        return onlineEntities.contains(entityId);
    }
    
    /**
     * 检查实体是否在线（通过ID）
     *
     * @param entityId 实体ID
     * @return true-在线，false-离线
     */
    public boolean isOnlineById(String entityId) {
        if (StrUtil.isBlank(entityId)) {
            return false;
        }
        return onlineEntities.contains(entityId);
    }
    
    /**
     * 获取当前在线实体数量
     *
     * @return 在线实体数量
     */
    public int getOnlineEntityCount() {
        return onlineEntities.size();
    }
    
    /**
     * 获取所有在线实体ID
     *
     * @return 在线实体ID集合
     */
    public Set<String> getOnlineEntities() {
        return CollectionUtil.newHashSet(onlineEntities);
    }
    
    /**
     * 设置实体超时时间
     *
     * @param timeoutMillis 超时时间（毫秒）
     */
    public void setEntityTimeoutMillis(long timeoutMillis) {
        this.entityTimeoutMillis = timeoutMillis;
    }
    
    /**
     * 启用定时检测功能
     */
    public void enableScheduledCheck() {
        this.enableScheduledCheck.set(true);
    }
    
    /**
     * 禁用定时检测功能
     */
    public void disableScheduledCheck() {
        this.enableScheduledCheck.set(false);
    }
    
    /**
     * 检查定时检测功能是否启用
     *
     * @return true-启用，false-禁用
     */
    public boolean isScheduledCheckEnabled() {
        return this.enableScheduledCheck.get();
    }
    
    /**
     * 执行定时检测，将超时的实体标记为离线
     *
     * @return 被标记为离线的实体数量
     */
    public int performScheduledCheck() {
        if (!enableScheduledCheck.get()) {
            return 0;
        }
        
        long currentTime = System.currentTimeMillis();
        int offlineCount = 0;
        
        // 检查所有在线实体
        for (String entityId : getOnlineEntities()) {
            Long lastActiveTime = entityLastActiveTime.get(entityId);
            if (lastActiveTime != null && (currentTime - lastActiveTime) > entityTimeoutMillis) {
                // 实体超时，标记为离线
                if (handleOfflineEventById(entityId)) {
                    offlineCount++;
                }
            }
        }
        
        return offlineCount;
    }
    
    /**
     * 通过实体ID处理实体下线事件
     * 用于定时检测等场景
     *
     * @param entityId 实体ID
     * @return true-状态已变更，false-状态未变更
     */
    private boolean handleOfflineEventById(String entityId) {
        // 移除实体最后活跃时间记录
        if (enableScheduledCheck.get() && StrUtil.isNotBlank(entityId)) {
            entityLastActiveTime.remove(entityId);
        }
        
        // 只有当实体在线时才处理下线事件
        if (!onlineEntities.contains(entityId)) {
            log.debug("实体{}不在线，无需处理下线事件", entityId);
            return false;
        }
        
        // 更新内存状态
        onlineEntities.remove(entityId);
        
        // 清除缓存
        cacheOperator.remove(getOnlineEntityCachePrefix() + entityId);
        
        // 触发回调
        if (statusChangeCallback != null) {
            try {
                statusChangeCallback.accept(entityId, "offline");
            } catch (Exception e) {
                log.error("处理实体下线事件回调异常，实体ID: {}", entityId, e);
            }
        }
        
        log.info("实体{}已下线", entityId);
        return true;
    }
    
    /**
     * 从缓存中恢复实体在线状态
     * 系统启动时调用
     */
    public void restoreOnlineEntitiesFromCache() {
        // 这里可以实现从缓存中恢复实体状态的逻辑
        // 由于缓存的具体实现方式不确定，这里仅提供方法框架
        log.info("开始从缓存恢复实体在线状态");
    }
    
    /**
     * 清空所有在线实体状态
     * 用于系统重启等场景
     */
    public void clearAll() {
        onlineEntities.clear();
        entityLastActiveTime.clear();
        log.info("已清空所有实体在线状态");
    }
}
/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.commons.cache;

import io.nop.api.core.config.IConfigRefreshable;
import io.nop.api.core.util.FutureHelper;
import io.nop.commons.lang.IDestroyable;
import io.nop.commons.metrics.GlobalMeterRegistry;
import io.nop.commons.util.DestroyHelper;
import io.nop.commons.util.StringHelper;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class LocalCache<K, V> implements ICache<K, V>, IConfigRefreshable, IDestroyable {
    static final Logger LOG = LoggerFactory.getLogger(LocalCache.class);

    private final String name;
    private Map<K, V> cache;
    private ICacheLoader<K, V> cacheLoader;
    private CacheConfig config;

    public LocalCache(String name, CacheConfig config, ICacheLoader<K, V> loader) {
        this.name = name;
        this.config = config;
        this.cacheLoader = loader;
        buildCache(config);

        if (config.isUseMetrics())
            registerMetrics();
    }

    public LocalCache(String name, CacheConfig cacheConfig) {
        this(name, cacheConfig, null);
    }

    public void destroy() {
        cache.clear();
    }

    public static <K, V> LocalCache<K, V> newCache(String name, CacheConfig config, ICacheLoader<K, V> loader) {
        return new LocalCache<>(name, config, loader);
    }

    public static <K, V> LocalCache<K, V> newCache(String name, CacheConfig config) {
        return new LocalCache<>(name, config);
    }

    public String getName() {
        return name;
    }

    private void registerMetrics() {
        // 本地缓存暂不支持指标监控
    }

    private void buildCache(CacheConfig config) {
        // 使用ConcurrentHashMap作为本地缓存实现
        this.cache = new ConcurrentHashMap<>();
        
        // 注意：本地实现不支持所有Caffeine的高级特性，如过期策略、最大大小限制等
        // 这些特性需要额外的实现或依赖其他库
    }

    public CacheConfig getConfig() {
        return config;
    }

    @Override
    public void refreshConfig() {
        // 本地缓存不支持动态刷新配置
    }

    public CacheStats stats() {
        CacheStats stats = new CacheStats();
        // 本地实现不支持详细的缓存统计信息
        stats.setHitCount(0);
        stats.setMissCount(0);
        stats.setLoadSuccessCount(0);
        stats.setLoadFailureCount(0);
        stats.setTotalLoadTime(0);
        stats.setEvictionCount(0);
        stats.setEvictionWeight(0);
        return stats;
    }

    @Override
    public V getAndSet(K key, V value) {
        V old = get(key);
        cache.put(key, value);
        return old;
    }

    @Override
    public V get(K key) {
        if (cacheLoader != null) {
            V value = cache.get(key);
            if (value == null) {
                try {
                    value = cacheLoader.load(key);
                    if (value != null) {
                        cache.put(key, value);
                    }
                } catch (Exception e) {
                    LOG.warn("Failed to load cache value for key: " + key, e);
                }
            }
            return value;
        }
        return cache.get(key);
    }

    @Override
    public V getIfPresent(K key) {
        return cache.get(key);
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return cache.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        cache.putAll(map);
    }

    @Override
    public boolean putIfAbsent(K key, V value) {
        V old = cache.get(key);
        if (old == null) {
            cache.put(key, value);
            return true;
        }
        return false;
    }

    @Override
    public void remove(K key) {
        cache.remove(key);
    }

    public void clear() {
        LOG.info("nop.cache.clear:cacheName={}", getName());
        cache.clear();
    }

    @Override
    public Map<K, V> getAll(Collection<? extends K> keys) {
        // 简单实现，不支持批量加载
        Map<K, V> result = new ConcurrentHashMap<>();
        for (K key : keys) {
            V value = get(key);
            if (value != null) {
                result.put(key, value);
            }
        }
        return result;
    }

    @Override
    public Map<K, V> getAllPresent(Collection<? extends K> keys) {
        Map<K, V> result = new ConcurrentHashMap<>();
        for (K key : keys) {
            V value = cache.get(key);
            if (value != null) {
                result.put(key, value);
            }
        }
        return result;
    }

    @Override
    public void removeAll(Collection<? extends K> keys) {
        for (K key : keys) {
            cache.remove(key);
        }
    }

    public void refresh(K key) {
        if (cacheLoader != null) {
            cache.remove(key);
        } else {
            cache.remove(key);
        }
    }

    @Override
    public long estimatedSize() {
        return cache.size();
    }

    @Override
    public @Nullable CompletionStage<V> getAsync(@NonNull K key) {
        return FutureHelper.futureCall(() -> get(key));
    }

    @Override
    public @NonNull CompletionStage<V> computeIfAbsentAsync(@NonNull K key,
                                                            @NonNull Function<? super K, ? extends V> mappingFunction) {
        return FutureHelper.futureCall(() -> computeIfAbsent(key, mappingFunction));
    }

    @Override
    public @NonNull CompletionStage<Map<K, V>> getAllAsync(Collection<? extends K> keys) {
        return FutureHelper.futureCall(() -> getAll(keys));
    }

    @Override
    public void forEachEntry(BiConsumer<? super K, ? super V> consumer) {
        cache.entrySet().forEach(entry -> {
            consumer.accept(entry.getKey(), entry.getValue());
        });
    }

    @Override
    public CompletionStage<Boolean> containsKeyAsync(K key) {
        return FutureHelper.success(containsKey(key));
    }

    @Override
    public CompletionStage<Void> putAsync(K key, V value) {
        put(key, value);
        return FutureHelper.success(null);
    }

    @Override
    public CompletionStage<Void> putAllAsync(Map<? extends K, ? extends V> map) {
        putAll(map);
        return FutureHelper.success(null);
    }

    @Override
    public CompletionStage<Boolean> putIfAbsentAsync(K key, V value) {
        boolean result = putIfAbsent(key, value);
        return FutureHelper.success(result);
    }

    @Override
    public CompletionStage<V> getAndSetAsync(K key, V value) {
        V result = getAndSet(key, value);
        return FutureHelper.success(result);
    }

    @Override
    public CompletionStage<Void> removeAsync(K key) {
        remove(key);
        return FutureHelper.success(null);
    }

    @Override
    public CompletionStage<Boolean> removeIfMatchAsync(K key, V object) {
        return FutureHelper.success(remove(key, object));
    }

    @Override
    public boolean removeIfMatch(K key, V object) {
        return remove(key, object);
    }

    @Override
    public CompletionStage<Void> removeAllAsync(Collection<? extends K> keys) {
        removeAll(keys);
        return FutureHelper.success(null);
    }

    @Override
    public CompletionStage<Void> clearAsync() {
        clear();
        return FutureHelper.success(null);
    }

    @Override
    public CompletionStage<Void> forEachEntryAsync(BiConsumer<? super K, ? super V> consumer) {
        forEachEntry(consumer);
        return FutureHelper.success(null);
    }
}

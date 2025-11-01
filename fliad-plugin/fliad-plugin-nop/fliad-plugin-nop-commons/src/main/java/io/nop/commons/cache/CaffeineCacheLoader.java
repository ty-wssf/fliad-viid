/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.commons.cache;

import com.github.benmanes.caffeine.cache.CacheLoader;
import org.jspecify.annotations.NonNull;
import org.noear.solon.lang.Nullable;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class CaffeineCacheLoader<K, V> implements CacheLoader<K, V> {
    private final ICacheLoader<K, V> loader;

    public CaffeineCacheLoader(ICacheLoader<K, V> loader) {
        this.loader = loader;
    }

    @Nullable
    @Override
    public V load(@NonNull K k) throws Exception {
        return loader.load(k);
    }

    // 修复方法签名以匹配Caffeine 2.9.3版本的接口
    public Map<K, V> loadAll(@NonNull Iterable<? extends K> keys) throws Exception {
        // 将Iterable转换为Set
        Set<K> keySet = new HashSet<>();
        for (K key : keys) {
            keySet.add(key);
        }
        return loader.loadAll(keySet);
    }

    @Override
    public CompletableFuture<V> asyncLoad(@NonNull K key, @NonNull Executor executor) {
        return loader.asyncLoad(key, executor);
    }

    // 注释掉@Override注解，因为在Caffeine 2.9.3中可能没有这个方法
    /*@Override*/
    public CompletableFuture<Map<K, V>> asyncLoadAll(@NonNull Iterable<? extends K> keys,
                                                              @NonNull Executor executor) {
        // 将Iterable转换为Set
        Set<K> keySet = new HashSet<>();
        for (K key : keys) {
            keySet.add(key);
        }
        return loader.asyncLoadAll(keySet, executor);
    }

    @Nullable
    @Override
    public V reload(@NonNull K key, @NonNull V oldValue) throws Exception {
        return loader.reload(key, oldValue);
    }

    // 修复方法签名以匹配Caffeine 2.9.3版本的接口
    public CompletableFuture<V> asyncReload(@NonNull K key, @NonNull V oldValue, @NonNull Executor executor) {
        return loader.asyncReload(key, oldValue, executor);
    }
}
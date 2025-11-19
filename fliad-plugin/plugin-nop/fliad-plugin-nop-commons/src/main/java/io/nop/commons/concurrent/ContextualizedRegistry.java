/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.commons.concurrent;

import org.noear.solon.lang.NonNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContextualizedRegistry<K, V> {
    private final Map<K, V> map = new ConcurrentHashMap<>();

    public boolean isEmpty() {
        return map.isEmpty();
    }

    protected K normalizeKey(K key) {
        return key;
    }

    public V get(@NonNull K key) {
        key = normalizeKey(key);
        return map.get(key);
    }

    public V put(@NonNull K key, V value) {
        key = normalizeKey(key);

        V result = value == null ? map.remove(key) : map.put(key, value);
        return result;
    }

    public V remove(@NonNull K key) {
        key = normalizeKey(key);
        return map.remove(key);
    }

    public boolean remove(@NonNull K key, V value) {
        key = normalizeKey(key);
        return map.remove(key, value);
    }
}

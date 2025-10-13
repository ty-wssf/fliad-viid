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
package com.fliad.common.cache;

import cn.hutool.core.collection.CollectionUtil;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Component;
import org.noear.solon.data.cache.CacheService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 通用Redis缓存操作器
 *
 * @author xuyuxiang
 * @date 2022/6/21 16:00
 **/
@Component
public class CommonCacheOperator {

    /**
     * 所有缓存Key的前缀
     */
    private static final String CACHE_KEY_PREFIX = "Cache:";

    private CacheService cacheService;

    public CommonCacheOperator() {
        Solon.context().getBeanAsync(CacheService.class, cacheService -> {
            this.cacheService = cacheService;
        });
    }

    public void put(String key, Object value) {
        if (cacheService == null) {
            return;
        }
        cacheService.store(CACHE_KEY_PREFIX + key, value, 60 * 60);
    }

    public void put(String key, Object value, long timeoutSeconds) {
        if (cacheService == null) {
            return;
        }
        cacheService.store(CACHE_KEY_PREFIX + key, value, (int) timeoutSeconds);
    }

    public Object get(String key) {
        if (cacheService == null) {
            return null;
        }
        return cacheService.get(CACHE_KEY_PREFIX + key, Object.class);
    }

    public void remove(String... key) {
        if (cacheService == null) {
            return;
        }
        ArrayList<String> keys = CollectionUtil.toList(key);
        List<String> withPrefixKeys = keys.stream().map(i -> CACHE_KEY_PREFIX + i).collect(Collectors.toList());
        for (String withPrefixKey : withPrefixKeys) {
            cacheService.remove(withPrefixKey);
        }
    }

    /*public Collection<String> getAllKeys() {
        if (cacheService == null) {
            return CollectionUtil.newHashSet();
        }
        Set<String> keys = cacheService.keys(CACHE_KEY_PREFIX + "*");
        if (keys != null) {
            // 去掉缓存key的common prefix前缀
            return keys.stream().map(key -> StrUtil.removePrefix(key, CACHE_KEY_PREFIX)).collect(Collectors.toSet());
        } else {
            return CollectionUtil.newHashSet();
        }
    }*/

    /*public Collection<Object> getAllValues() {
        if (redisBucket == null) {
            return CollectionUtil.newArrayList();
        }
        Set<String> keys = redisBucket.keys(CACHE_KEY_PREFIX + "*");
        if (keys != null) {
            String[] keyAry = new String[keys.size()];
            return redisBucket.getMoreAndDeserialize(keys.toArray(keyAry));
        } else {
            return CollectionUtil.newArrayList();
        }
    }

    public Map<String, Object> getAllKeyValues() {
        if (redisBucket == null) {
            return new HashMap<>();
        }
        Collection<String> allKeys = this.getAllKeys();
        HashMap<String, Object> results = MapUtil.newHashMap();
        for (String key : allKeys) {
            results.put(key, this.get(key));
        }
        return results;
    }*/
}

/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.commons.concurrent.lock;

import io.nop.commons.concurrent.lock.impl.ResourceMultiLock;
import org.noear.solon.lang.NonNull;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 分布式锁, 不可重入
 */
public interface IResourceLockManager {
    long getDefaultWaitTime();

    long getDefaultLeaseTime();

    IResourceLock getLock(@NonNull String resourceId, String holderId);

    default IResourceLock getMultiLock(@NonNull Set<String> resourceIds, String holderId) {
        return new ResourceMultiLock(this, resourceIds, holderId, getDefaultWaitTime(), getDefaultLeaseTime());
    }

    /**
     * 根据资源id获取当前的锁信息
     *
     * @return 返回null如果资源没有被锁定
     */
    IResourceLockState getLockState(@NonNull String resourceId);

    boolean forceUnlock(String resourceId);

    default <T> T callWithLock(String resourceId, String holderId, String lockReason, Function<IResourceLock, T> task) {
        IResourceLock lock = getLock(resourceId, holderId);
        lock.setLockReason(lockReason);
        try {
            lock.lock();
            return task.apply(lock);
        } finally {
            lock.unlock();
        }
    }

    default void runWithLock(String resourceId, String holderId, String lockReason, Consumer<IResourceLock> task) {
        IResourceLock lock = getLock(resourceId, holderId);
        lock.setLockReason(lockReason);

        try {
            lock.lock();
            task.accept(lock);
        } finally {
            lock.unlock();
        }
    }
}

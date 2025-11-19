package io.nop.commons.cache;

import io.nop.api.core.util.FutureHelper;
import org.noear.solon.lang.NonNull;
import org.noear.solon.lang.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CompletionStage;
import java.util.function.BiConsumer;
import java.util.function.Function;

public interface ISyncCache<K, V> extends ICache<K, V> {

    @Override
    default CompletionStage<Boolean> containsKeyAsync(K key) {
        return FutureHelper.futureCall(() -> containsKey(key));
    }

    @Override
    default CompletionStage<Void> putAsync(K key, V value) {
        return FutureHelper.futureRun(() -> put(key, value));
    }

    @Override
    default CompletionStage<Void> putAllAsync(Map<? extends K, ? extends V> map) {
        return FutureHelper.futureRun(() -> putAll(map));
    }

    @Override
    default CompletionStage<Boolean> putIfAbsentAsync(K key, V value) {
        return FutureHelper.futureCall(() -> putIfAbsent(key, value));
    }

    @Override
    default CompletionStage<V> getAndSetAsync(K key, V value) {
        return FutureHelper.futureCall(() -> getAndSet(key, value));
    }

    @Override
    default CompletionStage<Void> removeAsync(K key) {
        return FutureHelper.futureRun(() -> remove(key));
    }

    @Override
    default CompletionStage<Boolean> removeIfMatchAsync(K key, V object) {
        return FutureHelper.futureCall(() -> remove(key, object));
    }

    @Override
    default CompletionStage<Void> removeAllAsync(Collection<? extends K> keys) {
        return FutureHelper.futureRun(() -> removeAll(keys));
    }

    @Override
    default CompletionStage<Void> clearAsync() {
        return FutureHelper.futureRun(() -> clear());
    }

    @Override
    default CompletionStage<Void> forEachEntryAsync(BiConsumer<? super K, ? super V> consumer) {
        return FutureHelper.futureRun(() -> forEachEntry(consumer));
    }

    @NonNull
    @Override
    default CompletionStage<V> computeIfAbsentAsync(@NonNull K key, @NonNull Function<? super K, ? extends V> mappingFunction) {
        return FutureHelper.futureCall(() -> computeIfAbsent(key, mappingFunction));
    }

    @Nullable
    @Override
    default CompletionStage<V> getAsync(@NonNull K key) {
        return FutureHelper.futureCall(() -> get(key));
    }

    @NonNull
    @Override
    default CompletionStage<Map<K, V>> getAllAsync(Collection<? extends K> keys) {
        return FutureHelper.futureCall(() -> getAll(keys));
    }
}

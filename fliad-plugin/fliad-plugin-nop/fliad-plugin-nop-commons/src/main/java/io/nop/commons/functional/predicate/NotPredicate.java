/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.commons.functional.predicate;

import org.noear.solon.lang.NonNull;

import java.util.function.Predicate;

public class NotPredicate<T> implements Predicate<T> {
    private final Predicate<T> predicate;

    public NotPredicate(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    public Predicate<T> getPredicate() {
        return predicate;
    }

    @Override
    public boolean test(T t) {
        return !predicate.test(t);
    }

    @NonNull
    @Override
    public Predicate<T> and(@NonNull Predicate<? super T> other) {
        return new AndPredicate<>(this, other);
    }

    @NonNull
    @Override
    public Predicate<T> negate() {
        return predicate;
    }

    @NonNull
    @Override
    public Predicate<T> or(@NonNull Predicate<? super T> other) {
        return new OrPredicate<>(this, other);
    }
}

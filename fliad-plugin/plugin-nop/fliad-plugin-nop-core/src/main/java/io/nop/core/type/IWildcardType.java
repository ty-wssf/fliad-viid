/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.core.type;


import org.noear.solon.lang.NonNull;

public interface IWildcardType extends ITypeWithBound {
    /**
     * 对应 ? extends upperBound。如果没有明确声明，则UpperBound为Object类型
     */
    @NonNull
    IGenericType getUpperBound();

    /**
     * 对应 ? super lowerBound。没有明确声明lower bound，则返回null
     */
    IGenericType getLowerBound();
}

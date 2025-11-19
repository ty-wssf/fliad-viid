/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.orm.loader;

import io.nop.api.core.beans.LongRangeBean;
import io.nop.api.core.util.ICancelToken;
import io.nop.core.lang.sql.SQL;
import io.nop.dataset.IComplexDataSet;
import io.nop.dataset.IDataSet;
import io.nop.orm.eql.ICompiledSql;
import io.nop.orm.session.IOrmSessionImplementor;
import org.noear.solon.lang.NonNull;

import java.util.List;
import java.util.function.Function;

public interface IQueryExecutor {

    long executeUpdate(@NonNull IOrmSessionImplementor session, @NonNull SQL sql);

    <T> T executeQuery(@NonNull IOrmSessionImplementor session, @NonNull SQL sql, LongRangeBean range,
                       @NonNull Function<? super IDataSet, T> callback);

    <T> T executeStatement(@NonNull IOrmSessionImplementor session, @NonNull SQL sql, LongRangeBean range,
                           @NonNull Function<IComplexDataSet, T> callback, ICancelToken cancelToken);

    long executeUpdateSql(@NonNull IOrmSessionImplementor session, ICompiledSql compiled, List<Object> markerValues);

    <T> T executeQuerySql(@NonNull IOrmSessionImplementor session, @NonNull ICompiledSql compiled,
                          @NonNull List<Object> markerValues, LongRangeBean range,
                          @NonNull Function<? super IDataSet, T> callback);

    <T> T executeStatementSql(@NonNull IOrmSessionImplementor session, @NonNull ICompiledSql compiled,
                              @NonNull List<Object> markerValues, LongRangeBean range,
                              @NonNull Function<IComplexDataSet, T> callback, ICancelToken cancelToken);

}

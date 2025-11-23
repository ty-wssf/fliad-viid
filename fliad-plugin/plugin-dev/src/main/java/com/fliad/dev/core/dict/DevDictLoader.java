/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package com.fliad.dev.core.dict;

import io.nop.api.core.annotations.ioc.IgnoreDepends;
import io.nop.api.core.beans.DictBean;
import io.nop.api.core.beans.DictOptionBean;
import io.nop.core.context.IEvalContext;
import io.nop.core.dict.DictProvider;
import io.nop.core.dict.IDictLoader;
import io.nop.core.dict.IDictProvider;
import io.nop.core.i18n.I18nMessageManager;
import com.fliad.dev.modular.dict.entity.DevDict;
import com.fliad.dev.modular.dict.service.DevDictService;
import com.fliad.dev.dao.entity.dao.PluginDevDaoConstants;
import java.util.List;
import java.util.stream.Collectors;
import com.mybatisflex.core.query.QueryWrapper;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Destroy;
import org.noear.solon.annotation.Init;
import org.noear.solon.annotation.Inject;

@Component
public class DevDictLoader implements IDictLoader {
    
    @Inject
    DevDictService devDictService;

    @Init
    public void init() {
        IDictProvider dictProvider = DictProvider.instance();
        dictProvider.addDictLoader(PluginDevDaoConstants.DEV_DICT_PREFIX, this);
    }

    @Override
    public boolean supportDict(String dictName) {
        return dictName.startsWith(PluginDevDaoConstants.DEV_DICT_PREFIX);
    }

    @Destroy
    public void destroy() {
        IDictProvider dictProvider = DictProvider.instance();
        dictProvider.removeDictLoader(PluginDevDaoConstants.DEV_DICT_PREFIX, this);
    }

    @Override
    public DictBean loadDict(String locale, String dictName, IEvalContext ctx) {
        DictBean bean = new DictBean();
        bean.setLocale(I18nMessageManager.instance().getDefaultLocale());
        bean.setName(dictName);

        // Extract the actual dict name by removing the prefix
        String categoryName = dictName.substring(PluginDevDaoConstants.DEV_DICT_PREFIX.length());
        
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(DevDict::getCategory, categoryName);
        queryWrapper.orderBy(DevDict::getSortCode, true); // Order by sortCode ascending
        
        List<DevDict> dictList = devDictService.list(queryWrapper);
        
        List<DictOptionBean> options = dictList.stream().map(dict -> {
            DictOptionBean opt = new DictOptionBean();
            opt.setLabel(dict.getDictLabel());
            opt.setValue(dict.getDictValue());
            opt.setDeprecated(false); // DevDict doesn't seem to have a deprecated flag
            opt.setInternal(false); // DevDict doesn't seem to have an internal flag
            return opt;
        }).collect(Collectors.toList());

        bean.setOptions(options);
        return bean;
    }

    @Override
    public boolean existsDict(String dictName) {
        // Extract the actual dict name by removing the prefix
        String categoryName = dictName.substring(PluginDevDaoConstants.DEV_DICT_PREFIX.length());
        
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(DevDict::getCategory, categoryName);
        
        return devDictService.exists(queryWrapper);
    }
}

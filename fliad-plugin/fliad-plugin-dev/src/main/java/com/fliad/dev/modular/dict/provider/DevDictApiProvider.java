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
package com.fliad.dev.modular.dict.provider;

import com.fliad.dev.api.DevDictApi;
import com.fliad.dev.modular.dict.entity.DevDict;
import com.fliad.dev.modular.dict.param.DevDictListParam;
import com.fliad.dev.modular.dict.service.DevDictService;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import com.fliad.common.cache.CommonCacheOperator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 字典API接口实现类
 *
 * @author xuyuxiang
 * @date 2022/9/2 16:05
 */
@Component
public class DevDictApiProvider implements DevDictApi {

    @Inject
    private DevDictService devDictService;
    
    @Inject
    private CommonCacheOperator commonCacheOperator;
    
    private static final String DICT_CACHE_KEY_PREFIX = "dev-dict:";

    @Override
    public List<ONode> getDictListByParentId(String parentId) {
        String cacheKey = DICT_CACHE_KEY_PREFIX + "parent:" + parentId;
        Object cacheObj = commonCacheOperator.get(cacheKey);
        if (cacheObj != null) {
            return (List<ONode>) cacheObj;
        }
        
        DevDictListParam param = new DevDictListParam();
        param.setParentId(parentId);
        List<DevDict> dictList = devDictService.list(param);
        List<ONode> result = dictList.stream().map(dict -> ONode.load(dict)).collect(Collectors.toList());
        
        commonCacheOperator.put(cacheKey, result, 300); // 缓存5分钟
        return result;
    }
    
    @Override
    public List<ONode> getDictListByCategory(String category) {
        String cacheKey = DICT_CACHE_KEY_PREFIX + "category:" + category;
        Object cacheObj = commonCacheOperator.get(cacheKey);
        if (cacheObj != null) {
            return (List<ONode>) cacheObj;
        }
        
        DevDictListParam param = new DevDictListParam();
        param.setCategory(category);
        List<DevDict> dictList = devDictService.list(param);
        List<ONode> result = dictList.stream().map(dict -> ONode.load(dict)).collect(Collectors.toList());
        
        commonCacheOperator.put(cacheKey, result, 300); // 缓存5分钟
        return result;
    }
}
package com.fliad.biz.modular.index.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.mybatisflex.core.query.QueryWrapper;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import com.fliad.biz.modular.index.param.BizIndexNoticeIdParam;
import com.fliad.biz.modular.index.param.BizIndexNoticeListParam;
import com.fliad.biz.modular.index.param.BizIndexSlideshowListParam;
import com.fliad.biz.modular.index.result.BizIndexNoticeListResult;
import com.fliad.biz.modular.index.result.BizIndexSlideshowDetailResult;
import com.fliad.biz.modular.index.result.BizIndexSlideshowListResult;
import com.fliad.biz.modular.index.service.BizIndexService;
import com.fliad.biz.modular.notice.entity.BizNotice;
import com.fliad.biz.modular.notice.enums.BizNoticeStatusEnum;
import com.fliad.biz.modular.notice.service.BizNoticeService;
import com.fliad.dev.api.DevSlideshowApi;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 业务首页Service接口实现类
 *
 * @author yubaoshan
 * @date  2024/07/13 00:31
 */
@Component
public class BizIndexServiceImpl implements BizIndexService {


    @Inject
    private DevSlideshowApi devSlideshowApi;

    @Inject
    private BizNoticeService bizNoticeService;

    @Override
    public List<BizIndexSlideshowListResult> slideshowListByPlace(BizIndexSlideshowListParam bizIndexSlideshowListParam) {
        return devSlideshowApi.getListByPlace(bizIndexSlideshowListParam.getPlace()).stream()
                .map(jsonObject -> JSONUtil.toBean(jsonObject, BizIndexSlideshowListResult.class)).collect(Collectors.toList());
    }

    @Override
    public List<BizIndexNoticeListResult> noticeListByLimit(BizIndexNoticeListParam bizIndexNoticeListParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(BizNotice::getStatus, BizNoticeStatusEnum.ENABLE.getValue()).orderBy(BizNotice::getCreateTime);
        return bizNoticeService.list(queryWrapper)
                .stream()
                .limit(ObjectUtil.isNotEmpty(bizIndexNoticeListParam.getLimit())? bizIndexNoticeListParam.getLimit().longValue() : 10)
                .map(notice -> JSONUtil.toBean(JSONUtil.toJsonStr(notice), BizIndexNoticeListResult.class)).collect(Collectors.toList());
    }

    @Override
    public BizIndexSlideshowDetailResult noticeDetailById(BizIndexNoticeIdParam bizIndexNoticeIdParam) {
        BizIndexSlideshowDetailResult result = new BizIndexSlideshowDetailResult();
        BeanUtil.copyProperties(bizNoticeService.getById(bizIndexNoticeIdParam.getId()), result);
        return result;
    }
}
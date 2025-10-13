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
package com.fliad.biz.modular.index.service;

import com.fliad.biz.modular.index.param.BizIndexNoticeIdParam;
import com.fliad.biz.modular.index.param.BizIndexNoticeListParam;
import com.fliad.biz.modular.index.param.BizIndexSlideshowListParam;
import com.fliad.biz.modular.index.result.BizIndexNoticeListResult;
import com.fliad.biz.modular.index.result.BizIndexSlideshowDetailResult;
import com.fliad.biz.modular.index.result.BizIndexSlideshowListResult;

import javax.validation.Valid;
import java.util.List;

/**
 * 业务首页Service接口
 *
 * @author yubaoshan
 * @date  2024/07/13 00:31
 */
public interface BizIndexService {

    /**
     * 获取轮播图列表
     *
     * @author yubaoshan
     * @date  2024/07/13 00:31
     */
    List<BizIndexSlideshowListResult> slideshowListByPlace(BizIndexSlideshowListParam bizIndexSlideshowListParam);

    /**
     * 获取通知公告列表
     *
     * @author yubaoshan
     * @date  2024/07/13 00:31
     */
    List<BizIndexNoticeListResult> noticeListByLimit(@Valid BizIndexNoticeListParam bizIndexNoticeListParam);

    /**
     * 获取通知公告详情
     *
     * @author yubaoshan
     * @date  2024/07/13 00:31
     */
    BizIndexSlideshowDetailResult noticeDetailById(BizIndexNoticeIdParam bizIndexNoticeIdParam);
}
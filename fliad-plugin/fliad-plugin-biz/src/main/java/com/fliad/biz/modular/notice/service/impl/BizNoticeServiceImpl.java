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
package com.fliad.biz.modular.notice.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import org.noear.solon.annotation.Component;
import org.noear.solon.data.annotation.Tran;
import com.fliad.biz.modular.notice.entity.BizNotice;
import com.fliad.biz.modular.notice.enums.BizNoticeStatusEnum;
import com.fliad.biz.modular.notice.mapper.BizNoticeMapper;
import com.fliad.biz.modular.notice.param.BizNoticeAddParam;
import com.fliad.biz.modular.notice.param.BizNoticeEditParam;
import com.fliad.biz.modular.notice.param.BizNoticeIdParam;
import com.fliad.biz.modular.notice.param.BizNoticePageParam;
import com.fliad.biz.modular.notice.service.BizNoticeService;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.common.page.CommonPageRequest;

import java.util.List;

/**
 * 通知公告Service接口实现类
 *
 * @author yubaoshan
 * @date 2024/07/11 14:46
 **/
@Component
public class BizNoticeServiceImpl extends ServiceImpl<BizNoticeMapper, BizNotice> implements BizNoticeService {

    @Override
    public Page<BizNotice> page(BizNoticePageParam bizNoticePageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(bizNoticePageParam.getTitle())) {
            queryWrapper.like(BizNotice::getTitle, bizNoticePageParam.getTitle());
        }
        if (ObjectUtil.isNotEmpty(bizNoticePageParam.getType())) {
            queryWrapper.eq(BizNotice::getType, bizNoticePageParam.getType());
        }
        if (ObjectUtil.isNotEmpty(bizNoticePageParam.getPlace())) {
            queryWrapper.like(BizNotice::getPlace, bizNoticePageParam.getPlace());
        }
        if (ObjectUtil.isNotEmpty(bizNoticePageParam.getStatus())) {
            queryWrapper.eq(BizNotice::getStatus, bizNoticePageParam.getStatus());
        }
        if (ObjectUtil.isNotEmpty(bizNoticePageParam.getStartCreateTime()) && ObjectUtil.isNotEmpty(bizNoticePageParam.getEndCreateTime())) {
            queryWrapper.between(BizNotice::getCreateTime, bizNoticePageParam.getStartCreateTime(), bizNoticePageParam.getEndCreateTime());
        }
        if (ObjectUtil.isAllNotEmpty(bizNoticePageParam.getSortField(), bizNoticePageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(bizNoticePageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(bizNoticePageParam.getSortField()), bizNoticePageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy(BizNotice::getId);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Tran
    @Override
    public void add(BizNoticeAddParam bizNoticeAddParam) {
        BizNotice bizNotice = BeanUtil.toBean(bizNoticeAddParam, BizNotice.class);
        this.save(bizNotice);
    }

    @Tran
    @Override
    public void edit(BizNoticeEditParam bizNoticeEditParam) {
        BizNotice bizNotice = this.queryEntity(bizNoticeEditParam.getId());
        BeanUtil.copyProperties(bizNoticeEditParam, bizNotice);
        this.updateById(bizNotice);
    }

    @Tran
    @Override
    public void delete(List<BizNoticeIdParam> bizNoticeIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(bizNoticeIdParamList, BizNoticeIdParam::getId));
    }

    @Override
    public BizNotice detail(BizNoticeIdParam bizNoticeIdParam) {
        return this.queryEntity(bizNoticeIdParam.getId());
    }

    @Override
    public BizNotice queryEntity(String id) {
        BizNotice bizNotice = this.getById(id);
        if (ObjectUtil.isEmpty(bizNotice)) {
            throw new CommonException("通知公告不存在，id值为：{}", id);
        }
        return bizNotice;
    }

    @Tran
    @Override
    public void disableStatus(BizNoticeIdParam bizNoticeIdParam) {
        this.updateChain().eq(BizNotice::getId,
                bizNoticeIdParam.getId()).set(BizNotice::getStatus, BizNoticeStatusEnum.DISABLE.getValue()).update();
    }

    @Tran
    @Override
    public void enableStatus(BizNoticeIdParam bizNoticeIdParam) {
        this.updateChain().eq(BizNotice::getId,
                bizNoticeIdParam.getId()).set(BizNotice::getStatus, BizNoticeStatusEnum.ENABLE.getValue()).update();

    }
}

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
package com.fliad.viid.modular.subscribe.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fliad.viid.modular.cascadeplatform.domain.ResponseStatusListObject;
import com.fliad.viid.modular.cascadeplatform.entity.ViidCascadePlatform;
import com.fliad.viid.modular.cascadeplatform.enums.PlatformTypeEnum;
import com.fliad.viid.modular.cascadeplatform.service.ViidCascadePlatformService;
import com.fliad.viid.modular.cascadeplatform.service.ViidPlatformStatusService;
import com.fliad.viid.modular.subscribe.enums.SubscribeStatusEnum;
import com.fliad.viid.modular.subscribe.param.*;
import com.fliad.viid.modular.subscribe.utils.ViidHttpUtil;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.annotation.Tran;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.viid.modular.subscribe.entity.ViidSubscribe;
import com.fliad.viid.modular.subscribe.mapper.ViidSubscribeMapper;
import com.fliad.viid.modular.subscribe.service.ViidSubscribeService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订阅下发Service接口实现类
 *
 * @author wyl
 * @date 2025/08/22 15:00
 **/
@Component
public class ViidSubscribeServiceImpl extends ServiceImpl<ViidSubscribeMapper, ViidSubscribe> implements ViidSubscribeService {

    @Inject
    ViidCascadePlatformService cascadePlatformService;

    @Override
    public Page<ViidSubscribe> page(ViidSubscribePageParam viidSubscribePageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(viidSubscribePageParam.getTitle())) {
            queryWrapper.like(ViidSubscribe::getTitle, viidSubscribePageParam.getTitle());
        }
        if (ObjectUtil.isNotEmpty(viidSubscribePageParam.getSubscriberRecoverOrgid())) {
            queryWrapper.eq(ViidSubscribe::getSubscriberRecoverOrgid, viidSubscribePageParam.getSubscriberRecoverOrgid());
        }
        if (ObjectUtil.isAllNotEmpty(viidSubscribePageParam.getSortField(), viidSubscribePageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(viidSubscribePageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(viidSubscribePageParam.getSortField()), viidSubscribePageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy(ViidSubscribe::getSubscribeID);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Tran
    @Override
    public void add(ViidSubscribeAddParam viidSubscribeAddParam) {
        ViidSubscribe viidSubscribe = BeanUtil.toBean(viidSubscribeAddParam, ViidSubscribe.class);
        if (StrUtil.isEmptyIfStr(viidSubscribe.getSubscribeStatus())) {
            viidSubscribe.setSubscribeStatus(SubscribeStatusEnum.UN_SUBSCRIBED.getCode());
        }
        this.save(viidSubscribe);
    }

    @Tran
    @Override
    public void edit(ViidSubscribeEditParam viidSubscribeEditParam) {
        ViidSubscribe viidSubscribe = this.queryEntity(viidSubscribeEditParam.getSubscribeID());
        BeanUtil.copyProperties(viidSubscribeEditParam, viidSubscribe);
        this.updateById(viidSubscribe);
    }

    @Tran
    @Override
    public void delete(List<ViidSubscribeIdParam> viidSubscribeIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(viidSubscribeIdParamList, ViidSubscribeIdParam::getSubscribeID));
    }

    @Override
    public ViidSubscribe detail(ViidSubscribeIdParam viidSubscribeIdParam) {
        return this.queryEntity(viidSubscribeIdParam.getSubscribeID());
    }

    @Override
    public ViidSubscribe queryEntity(String id) {
        ViidSubscribe viidSubscribe = this.getById(id);
        if (ObjectUtil.isEmpty(viidSubscribe)) {
            throw new CommonException("订阅下发不存在，id值为：{}", id);
        }
        return viidSubscribe;
    }

    @Override
    public void subscribeSend(ViidSubscribeIdParam viidSubscribeIdParam) {
        ViidSubscribe viidSubscribe = this.queryEntity(viidSubscribeIdParam.getSubscribeID());
        ViidCascadePlatform cascadePlatform = cascadePlatformService.getOne(QueryWrapper.create()
                .eq(ViidCascadePlatform::getId, viidSubscribe.getSubscriberRecoverOrgid())
        );
        String res = ViidHttpUtil.subscribeSend(viidSubscribe, cascadePlatform);
        if (ObjectUtil.isEmpty(res)) {
            throw new CommonException("订阅下发失败，请稍后再试");
        } else if (!ONode.load(res).isObject()) {
            throw new CommonException(res);
        }
        ResponseStatusListObject responseStatusListObject = ONode.deserialize(res, ResponseStatusListObject.class);
        // 说明订阅成功
        if (responseStatusListObject.getResponseStatusListObject().getResponseStatusObject().get(0).getStatusCode() == 0) {
            // 更新订阅状态
            viidSubscribe.setSubscribeStatus(SubscribeStatusEnum.SUBSCRIBING.getCode());
            updateById(viidSubscribe);
        } else {
            throw new CommonException(responseStatusListObject.getResponseStatusListObject().getResponseStatusObject().get(0).getStatusString());
        }
    }

    @Override
    public void subscribeCancel(ViidSubscribeCancelParam viidSubscribeCancelParam) {
        viidSubscribeCancelParam.setCancelTime(new Date());
        ViidSubscribe viidSubscribe = this.queryEntity(viidSubscribeCancelParam.getSubscribeID());
        BeanUtil.copyProperties(viidSubscribeCancelParam, viidSubscribe);
        viidSubscribe.setOperateType("1"); // 取消订阅
        ViidCascadePlatform cascadePlatform = cascadePlatformService.getOne(QueryWrapper.create()
                .eq(ViidCascadePlatform::getId, viidSubscribe.getSubscriberRecoverOrgid())
        );
        String res = ViidHttpUtil.subscribeSend(viidSubscribe, cascadePlatform);
        if (ObjectUtil.isEmpty(res)) {
            throw new CommonException("取消订阅失败，请稍后再试");
        } else if (!ONode.load(res).isObject()) {
            throw new CommonException(res);
        }
        ResponseStatusListObject responseStatusListObject = ONode.deserialize(res, ResponseStatusListObject.class);
        // 说明取消订阅成功
        if (responseStatusListObject.getResponseStatusListObject().getResponseStatusObject().get(0).getStatusCode() == 0) {
            // 更新订阅状态
            viidSubscribe.setSubscribeStatus(SubscribeStatusEnum.UNSUBSCRIBED.getCode());
            updateById(viidSubscribe);
        } else {
            throw new CommonException(responseStatusListObject.getResponseStatusListObject().getResponseStatusObject().get(0).getStatusString());
        }
    }

}

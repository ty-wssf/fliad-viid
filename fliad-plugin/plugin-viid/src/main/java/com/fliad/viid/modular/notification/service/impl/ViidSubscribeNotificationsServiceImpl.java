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
package com.fliad.viid.modular.notification.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import org.noear.solon.annotation.Component;
import org.noear.solon.data.annotation.Tran;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.viid.modular.notification.entity.ViidSubscribeNotifications;
import com.fliad.viid.modular.notification.mapper.ViidSubscribeNotificationsMapper;
import com.fliad.viid.modular.notification.param.ViidSubscribeNotificationsAddParam;
import com.fliad.viid.modular.notification.param.ViidSubscribeNotificationsEditParam;
import com.fliad.viid.modular.notification.param.ViidSubscribeNotificationsIdParam;
import com.fliad.viid.modular.notification.param.ViidSubscribeNotificationsPageParam;
import com.fliad.viid.modular.notification.service.ViidSubscribeNotificationsService;

import java.util.List;

/**
 * 订阅通知Service接口实现类
 *
 * @author wyl
 * @date 2025/09/22
 **/
@Component
public class ViidSubscribeNotificationsServiceImpl extends ServiceImpl<ViidSubscribeNotificationsMapper, ViidSubscribeNotifications> implements ViidSubscribeNotificationsService {

    @Override
    public Page<ViidSubscribeNotifications> page(ViidSubscribeNotificationsPageParam viidSubscribeNotificationsPageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(viidSubscribeNotificationsPageParam.getNotificationID())) {
            queryWrapper.like("NotificationID", viidSubscribeNotificationsPageParam.getNotificationID());
        }
        if (ObjectUtil.isNotEmpty(viidSubscribeNotificationsPageParam.getSubscribeID())) {
            queryWrapper.like("SubscribeID", viidSubscribeNotificationsPageParam.getSubscribeID());
        }
        if (ObjectUtil.isAllNotEmpty(viidSubscribeNotificationsPageParam.getSortField(), viidSubscribeNotificationsPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(viidSubscribeNotificationsPageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(viidSubscribeNotificationsPageParam.getSortField()), viidSubscribeNotificationsPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy("CreateTime", false);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Override
    public void add(ViidSubscribeNotificationsAddParam viidSubscribeNotificationsAddParam) {
        ViidSubscribeNotifications viidSubscribeNotifications = new ViidSubscribeNotifications();
        BeanUtil.copyProperties(viidSubscribeNotificationsAddParam, viidSubscribeNotifications);
        this.save(viidSubscribeNotifications);
    }

    @Override
    @Tran
    public void edit(ViidSubscribeNotificationsEditParam viidSubscribeNotificationsEditParam) {
        ViidSubscribeNotifications viidSubscribeNotifications = this.queryEntity(viidSubscribeNotificationsEditParam.getID());
        BeanUtil.copyProperties(viidSubscribeNotificationsEditParam, viidSubscribeNotifications);
        this.updateById(viidSubscribeNotifications);
    }

    @Override
    @Tran
    public void delete(List<ViidSubscribeNotificationsIdParam> viidSubscribeNotificationsIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(viidSubscribeNotificationsIdParamList, ViidSubscribeNotificationsIdParam::getID));
    }

    @Override
    public ViidSubscribeNotifications detail(ViidSubscribeNotificationsIdParam viidSubscribeNotificationsIdParam) {
        return this.queryEntity(viidSubscribeNotificationsIdParam.getID());
    }

    @Override
    public ViidSubscribeNotifications queryEntity(String id) {
        ViidSubscribeNotifications viidSubscribeNotifications = this.getById(id);
        if (ObjectUtil.isEmpty(viidSubscribeNotifications)) {
            throw new CommonException("订阅通知不存在，id值为：{}", id);
        }
        return viidSubscribeNotifications;
    }
}
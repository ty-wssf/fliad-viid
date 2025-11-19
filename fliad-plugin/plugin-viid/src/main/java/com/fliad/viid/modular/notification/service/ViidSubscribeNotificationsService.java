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
package com.fliad.viid.modular.notification.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import com.fliad.viid.modular.notification.entity.ViidSubscribeNotifications;
import com.fliad.viid.modular.notification.param.ViidSubscribeNotificationsAddParam;
import com.fliad.viid.modular.notification.param.ViidSubscribeNotificationsEditParam;
import com.fliad.viid.modular.notification.param.ViidSubscribeNotificationsIdParam;
import com.fliad.viid.modular.notification.param.ViidSubscribeNotificationsPageParam;

import java.util.List;

/**
 * 订阅通知Service接口
 *
 * @author wyl
 * @date 2025/09/22
 **/
public interface ViidSubscribeNotificationsService extends IService<ViidSubscribeNotifications> {

    /**
     * 获取订阅通知分页
     *
     * @author wyl
     * @date 2025/09/22
     */
    Page<ViidSubscribeNotifications> page(ViidSubscribeNotificationsPageParam viidSubscribeNotificationsPageParam);

    /**
     * 添加订阅通知
     *
     * @author wyl
     * @date 2025/09/22
     */
    void add(ViidSubscribeNotificationsAddParam viidSubscribeNotificationsAddParam);

    /**
     * 编辑订阅通知
     *
     * @author wyl
     * @date 2025/09/22
     */
    void edit(ViidSubscribeNotificationsEditParam viidSubscribeNotificationsEditParam);

    /**
     * 删除订阅通知
     *
     * @author wyl
     * @date 2025/09/22
     */
    void delete(List<ViidSubscribeNotificationsIdParam> viidSubscribeNotificationsIdParamList);

    /**
     * 获取订阅通知详情
     *
     * @author wyl
     * @date 2025/09/22
     */
    ViidSubscribeNotifications detail(ViidSubscribeNotificationsIdParam viidSubscribeNotificationsIdParam);

    /**
     * 获取订阅通知详情
     *
     * @author wyl
     * @date 2025/09/22
     **/
    ViidSubscribeNotifications queryEntity(String id);
}
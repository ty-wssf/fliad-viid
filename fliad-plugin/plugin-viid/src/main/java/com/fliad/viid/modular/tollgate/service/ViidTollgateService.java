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
package com.fliad.viid.modular.tollgate.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import com.fliad.viid.modular.tollgate.entity.ViidTollgate;
import com.fliad.viid.modular.tollgate.param.ViidTollgateAddParam;
import com.fliad.viid.modular.tollgate.param.ViidTollgateEditParam;
import com.fliad.viid.modular.tollgate.param.ViidTollgateIdParam;
import com.fliad.viid.modular.tollgate.param.ViidTollgatePageParam;

import java.util.List;

/**
 * 视频卡口Service接口
 *
 * @author wyl
 * @date  2025/09/19
 **/
public interface ViidTollgateService extends IService<ViidTollgate> {

    /**
     * 获取视频卡口分页
     *
     * @author wyl
     * @date  2025/09/19
     */
    Page<ViidTollgate> page(ViidTollgatePageParam viidTollgatePageParam);

    /**
     * 添加视频卡口
     *
     * @author wyl
     * @date  2025/09/19
     */
    void add(ViidTollgateAddParam viidTollgateAddParam);

    /**
     * 编辑视频卡口
     *
     * @author wyl
     * @date  2025/09/19
     */
    void edit(ViidTollgateEditParam viidTollgateEditParam);

    /**
     * 删除视频卡口
     *
     * @author wyl
     * @date  2025/09/19
     */
    void delete(List<ViidTollgateIdParam> viidTollgateIdParamList);

    /**
     * 获取视频卡口详情
     *
     * @author wyl
     * @date  2025/09/19
     */
    ViidTollgate detail(ViidTollgateIdParam viidTollgateIdParam);

    /**
     * 获取视频卡口详情
     *
     * @author wyl
     * @date  2025/09/19
     **/
    ViidTollgate queryEntity(String id);
}
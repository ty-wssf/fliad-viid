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
package com.fliad.viid.modular.cascadeplatform.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import com.fliad.viid.modular.cascadeplatform.entity.ViidCascadePlatform;
import com.fliad.viid.modular.cascadeplatform.param.ViidCascadePlatformAddParam;
import com.fliad.viid.modular.cascadeplatform.param.ViidCascadePlatformEditParam;
import com.fliad.viid.modular.cascadeplatform.param.ViidCascadePlatformIdParam;
import com.fliad.viid.modular.cascadeplatform.param.ViidCascadePlatformPageParam;

import java.util.List;

/**
 * 视图库Service接口
 *
 * @author wyl
 * @date  2025/08/14 16:24
 **/
public interface ViidCascadePlatformService extends IService<ViidCascadePlatform> {

    /**
     * 获取视图库分页
     *
     * @author wyl
     * @date  2025/08/14 16:24
     */
    Page<ViidCascadePlatform> page(ViidCascadePlatformPageParam viidCascadePlatformPageParam);

    /**
     * 添加视图库
     *
     * @author wyl
     * @date  2025/08/14 16:24
     */
    void add(ViidCascadePlatformAddParam viidCascadePlatformAddParam);

    /**
     * 编辑视图库
     *
     * @author wyl
     * @date  2025/08/14 16:24
     */
    void edit(ViidCascadePlatformEditParam viidCascadePlatformEditParam);

    /**
     * 删除视图库
     *
     * @author wyl
     * @date  2025/08/14 16:24
     */
    void delete(List<ViidCascadePlatformIdParam> viidCascadePlatformIdParamList);

    /**
     * 获取视图库详情
     *
     * @author wyl
     * @date  2025/08/14 16:24
     */
    ViidCascadePlatform detail(ViidCascadePlatformIdParam viidCascadePlatformIdParam);

    /**
     * 获取视图库详情
     *
     * @author wyl
     * @date  2025/08/14 16:24
     **/
    ViidCascadePlatform queryEntity(String id);
}

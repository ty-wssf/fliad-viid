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
package com.fliad.viid.modular.cascadeplatform.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fliad.viid.modular.cascadeplatform.service.ViidPlatformStatusService;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.annotation.Tran;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.viid.modular.cascadeplatform.entity.ViidCascadePlatform;
import com.fliad.viid.modular.cascadeplatform.mapper.ViidCascadePlatformMapper;
import com.fliad.viid.modular.cascadeplatform.param.ViidCascadePlatformAddParam;
import com.fliad.viid.modular.cascadeplatform.param.ViidCascadePlatformEditParam;
import com.fliad.viid.modular.cascadeplatform.param.ViidCascadePlatformIdParam;
import com.fliad.viid.modular.cascadeplatform.param.ViidCascadePlatformPageParam;
import com.fliad.viid.modular.cascadeplatform.service.ViidCascadePlatformService;

import java.util.List;

/**
 * 视图库Service接口实现类
 *
 * @author wyl
 * @date 2025/08/14 16:24
 **/
@Component
public class ViidCascadePlatformServiceImpl extends ServiceImpl<ViidCascadePlatformMapper, ViidCascadePlatform> implements ViidCascadePlatformService {

    @Inject
    ViidPlatformStatusService viidPlatformStatusService;

    @Override
    public Page<ViidCascadePlatform> page(ViidCascadePlatformPageParam viidCascadePlatformPageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(viidCascadePlatformPageParam.getName())) {
            queryWrapper.like(ViidCascadePlatform::getName, viidCascadePlatformPageParam.getName());
        }
        if (ObjectUtil.isNotEmpty(viidCascadePlatformPageParam.getIsOnline())) {
            queryWrapper.eq(ViidCascadePlatform::getIsOnline, viidCascadePlatformPageParam.getIsOnline());
        }
        if (ObjectUtil.isNotEmpty(viidCascadePlatformPageParam.getType())) {
            queryWrapper.eq(ViidCascadePlatform::getType, viidCascadePlatformPageParam.getType());
        }
        if (ObjectUtil.isAllNotEmpty(viidCascadePlatformPageParam.getSortField(), viidCascadePlatformPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(viidCascadePlatformPageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(viidCascadePlatformPageParam.getSortField()), viidCascadePlatformPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy(ViidCascadePlatform::getId);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Tran
    @Override
    public void add(ViidCascadePlatformAddParam viidCascadePlatformAddParam) {
        ViidCascadePlatform viidCascadePlatform = BeanUtil.toBean(viidCascadePlatformAddParam, ViidCascadePlatform.class);
        // 设置默认值
        viidCascadePlatform.setIsRegister("0");
        viidCascadePlatform.setIsOnline("0");
        viidCascadePlatform.setHeartbeatInterval(90L);
        viidCascadePlatform.setKeepaliveTimeoutCount(3);
        this.save(viidCascadePlatform);
    }

    @Tran
    @Override
    public void edit(ViidCascadePlatformEditParam viidCascadePlatformEditParam) {
        ViidCascadePlatform viidCascadePlatform = this.queryEntity(viidCascadePlatformEditParam.getId());
        BeanUtil.copyProperties(viidCascadePlatformEditParam, viidCascadePlatform);
        // 设置默认值
        viidCascadePlatform.setIsRegister("0");
        viidCascadePlatform.setIsOnline("0");
        viidCascadePlatform.setHeartbeatInterval(90L);
        viidCascadePlatform.setKeepaliveTimeoutCount(3);
        this.updateById(viidCascadePlatform);

        viidPlatformStatusService.removeDevice(viidCascadePlatform.getSystemId());
    }

    @Tran
    @Override
    public void delete(List<ViidCascadePlatformIdParam> viidCascadePlatformIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(viidCascadePlatformIdParamList, ViidCascadePlatformIdParam::getId));
    }

    @Override
    public ViidCascadePlatform detail(ViidCascadePlatformIdParam viidCascadePlatformIdParam) {
        return this.queryEntity(viidCascadePlatformIdParam.getId());
    }

    @Override
    public ViidCascadePlatform queryEntity(String id) {
        ViidCascadePlatform viidCascadePlatform = this.getById(id);
        if (ObjectUtil.isEmpty(viidCascadePlatform)) {
            throw new CommonException("视图库不存在，id值为：{}", id);
        }
        return viidCascadePlatform;
    }
}

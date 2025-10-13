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
package com.fliad.viid.modular.tollgate.service.impl;

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
import com.fliad.viid.modular.tollgate.entity.ViidTollgate;
import com.fliad.viid.modular.tollgate.mapper.ViidTollgateMapper;
import com.fliad.viid.modular.tollgate.param.ViidTollgateAddParam;
import com.fliad.viid.modular.tollgate.param.ViidTollgateEditParam;
import com.fliad.viid.modular.tollgate.param.ViidTollgateIdParam;
import com.fliad.viid.modular.tollgate.param.ViidTollgatePageParam;
import com.fliad.viid.modular.tollgate.service.ViidTollgateService;

import java.util.List;

/**
 * 视频卡口Service接口实现类
 *
 * @author wyl
 * @date 2025/09/19
 **/
@Component
public class ViidTollgateServiceImpl extends ServiceImpl<ViidTollgateMapper, ViidTollgate> implements ViidTollgateService {

    @Override
    public Page<ViidTollgate> page(ViidTollgatePageParam viidTollgatePageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(viidTollgatePageParam.getName())) {
            queryWrapper.like(ViidTollgate::getName, viidTollgatePageParam.getName());
        }
        if (ObjectUtil.isAllNotEmpty(viidTollgatePageParam.getSortField(), viidTollgatePageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(viidTollgatePageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(viidTollgatePageParam.getSortField()), viidTollgatePageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy(ViidTollgate::getTollgateID);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Override
    public void add(ViidTollgateAddParam viidTollgateAddParam) {
        ViidTollgate viidTollgate = new ViidTollgate();
        BeanUtil.copyProperties(viidTollgateAddParam, viidTollgate);
        this.save(viidTollgate);
    }

    @Override
    @Tran
    public void edit(ViidTollgateEditParam viidTollgateEditParam) {
        ViidTollgate viidTollgate = this.queryEntity(viidTollgateEditParam.getID());
        BeanUtil.copyProperties(viidTollgateEditParam, viidTollgate);
        this.updateById(viidTollgate);
    }

    @Override
    @Tran
    public void delete(List<ViidTollgateIdParam> viidTollgateIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(viidTollgateIdParamList, ViidTollgateIdParam::getID));
    }

    @Override
    public ViidTollgate detail(ViidTollgateIdParam viidTollgateIdParam) {
        return this.queryEntity(viidTollgateIdParam.getID());
    }

    @Override
    public ViidTollgate queryEntity(String id) {
        ViidTollgate viidTollgate = this.getById(id);
        if (ObjectUtil.isEmpty(viidTollgate)) {
            throw new CommonException("视频卡口不存在，id值为：{}", id);
        }
        return viidTollgate;
    }
}
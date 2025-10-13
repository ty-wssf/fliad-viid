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
package com.fliad.viid.modular.ape.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fliad.viid.modular.subscribe.param.ViidSubscribeIdParam;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import org.noear.solon.annotation.Component;
import org.noear.solon.data.annotation.Tran;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.viid.modular.ape.entity.ViidApe;
import com.fliad.viid.modular.ape.mapper.ViidApeMapper;
import com.fliad.viid.modular.ape.param.ViidApeAddParam;
import com.fliad.viid.modular.ape.param.ViidApeEditParam;
import com.fliad.viid.modular.ape.param.ViidApeIdParam;
import com.fliad.viid.modular.ape.param.ViidApePageParam;
import com.fliad.viid.modular.ape.service.ViidApeService;

import java.util.List;

import static com.fliad.viid.modular.ape.entity.table.ViidApeTableDef.VIID_APE;

/**
 * 采集设备Service接口实现类
 *
 * @author wyl
 * @date 2025/09/19
 **/
@Component
public class ViidApeServiceImpl extends ServiceImpl<ViidApeMapper, ViidApe> implements ViidApeService {

    @Override
    public Page<ViidApe> page(ViidApePageParam viidApePageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(viidApePageParam.getName())) {
            queryWrapper.like(ViidApe::getName, viidApePageParam.getName());
        }
        if (ObjectUtil.isNotEmpty(viidApePageParam.getIPAddr())) {
            queryWrapper.like(ViidApe::getIPAddr, viidApePageParam.getIPAddr());
        }
        if (ObjectUtil.isAllNotEmpty(viidApePageParam.getSortField(), viidApePageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(viidApePageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(viidApePageParam.getSortField()), viidApePageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy(ViidApe::getApeID);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Override
    public void add(ViidApeAddParam viidApeAddParam) {
        ViidApe viidApe = new ViidApe();
        BeanUtil.copyProperties(viidApeAddParam, viidApe);
        viidApe.setIsOnline(0);
        this.save(viidApe);
    }

    @Override
    @Tran
    public void edit(ViidApeEditParam viidApeEditParam) {
        ViidApe viidApe = this.queryEntity(viidApeEditParam.getID());
        BeanUtil.copyProperties(viidApeEditParam, viidApe);
        this.updateById(viidApe);
    }

    @Override
    @Tran
    public void delete(List<ViidApeIdParam> viidApeIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(viidApeIdParamList, ViidApeIdParam::getID));
    }

    @Override
    public ViidApe detail(ViidApeIdParam viidApeIdParam) {
        return this.queryEntity(viidApeIdParam.getID());
    }

    @Override
    public ViidApe queryEntity(String id) {
        ViidApe viidApe = this.getById(id);
        if (ObjectUtil.isEmpty(viidApe)) {
            throw new CommonException("采集设备不存在，id值为：{}", id);
        }
        return viidApe;
    }
}
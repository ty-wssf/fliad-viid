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
package com.fliad.viid.modular.hikvision.service.impl;

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
import com.fliad.viid.modular.hikvision.entity.ViidHikvisionCamera;
import com.fliad.viid.modular.hikvision.mapper.ViidHikvisionCameraMapper;
import com.fliad.viid.modular.hikvision.param.ViidHikvisionCameraAddParam;
import com.fliad.viid.modular.hikvision.param.ViidHikvisionCameraEditParam;
import com.fliad.viid.modular.hikvision.param.ViidHikvisionCameraIdParam;
import com.fliad.viid.modular.hikvision.param.ViidHikvisionCameraPageParam;
import com.fliad.viid.modular.hikvision.service.ViidHikvisionCameraService;

import java.util.List;

/**
 * 海康设备Service接口实现类
 *
 * @author yubaoshan
 * @date 2025/09/27
 **/
@Component
public class ViidHikvisionCameraServiceImpl extends ServiceImpl<ViidHikvisionCameraMapper, ViidHikvisionCamera> implements ViidHikvisionCameraService {

    @Override
    public Page<ViidHikvisionCamera> page(ViidHikvisionCameraPageParam viidHikvisionCameraPageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(viidHikvisionCameraPageParam.getName())) {
            queryWrapper.like("NAME", viidHikvisionCameraPageParam.getName());
        }
        if (ObjectUtil.isNotEmpty(viidHikvisionCameraPageParam.getIpAddr())) {
            queryWrapper.like("IP_ADDR", viidHikvisionCameraPageParam.getIpAddr());
        }
        if (ObjectUtil.isAllNotEmpty(viidHikvisionCameraPageParam.getSortField(), viidHikvisionCameraPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(viidHikvisionCameraPageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(viidHikvisionCameraPageParam.getSortField()), viidHikvisionCameraPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy("ID", false);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Tran
    @Override
    public void add(ViidHikvisionCameraAddParam viidHikvisionCameraAddParam) {
        ViidHikvisionCamera viidHikvisionCamera = BeanUtil.toBean(viidHikvisionCameraAddParam, ViidHikvisionCamera.class);
        this.save(viidHikvisionCamera);
    }

    @Tran
    @Override
    public void edit(ViidHikvisionCameraEditParam viidHikvisionCameraEditParam) {
        ViidHikvisionCamera viidHikvisionCamera = this.queryEntity(viidHikvisionCameraEditParam.getId());
        BeanUtil.copyProperties(viidHikvisionCameraEditParam, viidHikvisionCamera);
        this.updateById(viidHikvisionCamera);
    }

    @Tran
    @Override
    public void delete(List<ViidHikvisionCameraIdParam> viidHikvisionCameraIdParamList) {
        this.removeByIds(CollStreamUtil.toList(viidHikvisionCameraIdParamList, ViidHikvisionCameraIdParam::getId));
    }

    @Override
    public ViidHikvisionCamera detail(ViidHikvisionCameraIdParam viidHikvisionCameraIdParam) {
        return this.queryEntity(viidHikvisionCameraIdParam.getId());
    }

    @Override
    public ViidHikvisionCamera queryEntity(String id) {
        ViidHikvisionCamera viidHikvisionCamera = this.getById(id);
        if (ObjectUtil.isEmpty(viidHikvisionCamera)) {
            throw new CommonException("海康设备不存在，id值为：{}", id);
        }
        return viidHikvisionCamera;
    }
}
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
package com.fliad.resource.modular.datasource.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fliad.resource.modular.datasource.enums.ResourceDatasourceStatus;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import org.noear.solon.annotation.Component;
import org.noear.solon.data.annotation.Tran;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.resource.modular.datasource.entity.ResourceDatasource;
import com.fliad.resource.modular.datasource.mapper.ResourceDatasourceMapper;
import com.fliad.resource.modular.datasource.param.ResourceDatasourceAddParam;
import com.fliad.resource.modular.datasource.param.ResourceDatasourceEditParam;
import com.fliad.resource.modular.datasource.param.ResourceDatasourceIdParam;
import com.fliad.resource.modular.datasource.param.ResourceDatasourcePageParam;
import com.fliad.resource.modular.datasource.service.ResourceDatasourceService;

import java.util.List;

/**
 * 数据源Service接口实现类
 *
 * @author wyl
 * @date 2025/09/24 20:05
 **/
@Component
public class ResourceDatasourceServiceImpl extends ServiceImpl<ResourceDatasourceMapper, ResourceDatasource> implements ResourceDatasourceService {

    @Override
    public Page<ResourceDatasource> page(ResourceDatasourcePageParam viidDatasourcePageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(viidDatasourcePageParam.getTitle())) {
            queryWrapper.like(ResourceDatasource::getTitle, viidDatasourcePageParam.getTitle());
        }
        if (ObjectUtil.isNotEmpty(viidDatasourcePageParam.getType())) {
            queryWrapper.eq(ResourceDatasource::getType, viidDatasourcePageParam.getType());
        }
        if (ObjectUtil.isAllNotEmpty(viidDatasourcePageParam.getSortField(), viidDatasourcePageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(viidDatasourcePageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(viidDatasourcePageParam.getSortField()), viidDatasourcePageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy(ResourceDatasource::getId, false);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Tran
    @Override
    public void add(ResourceDatasourceAddParam viidDatasourceAddParam) {
        ResourceDatasource viidDatasource = BeanUtil.toBean(viidDatasourceAddParam, ResourceDatasource.class);
        // 设置状态
        viidDatasource.setStatus(ResourceDatasourceStatus.DISABLED.getValue());
        this.save(viidDatasource);
    }

    @Tran
    @Override
    public void edit(ResourceDatasourceEditParam viidDatasourceEditParam) {
        ResourceDatasource viidDatasource = this.queryEntity(viidDatasourceEditParam.getId());
        BeanUtil.copyProperties(viidDatasourceEditParam, viidDatasource);
        this.updateById(viidDatasource);
    }

    @Tran
    @Override
    public void delete(List<ResourceDatasourceIdParam> viidDatasourceIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(viidDatasourceIdParamList, ResourceDatasourceIdParam::getId));
    }

    @Override
    public ResourceDatasource detail(ResourceDatasourceIdParam viidDatasourceIdParam) {
        return this.queryEntity(viidDatasourceIdParam.getId());
    }

    @Override
    public ResourceDatasource queryEntity(String id) {
        ResourceDatasource viidDatasource = this.getById(id);
        if (ObjectUtil.isEmpty(viidDatasource)) {
            throw new CommonException("数据源不存在，id值为：{}", id);
        }
        return viidDatasource;
    }

    @Override
    public void disableDatasource(ResourceDatasourceIdParam viidDatasourceIdParam) {
        this.updateChain().eq(ResourceDatasource::getId, viidDatasourceIdParam.getId())
                .set(ResourceDatasource::getStatus, ResourceDatasourceStatus.DISABLED.getValue()).update();
    }

    @Override
    public void enableDatasource(ResourceDatasourceIdParam viidDatasourceIdParam) {
        this.updateChain().eq(ResourceDatasource::getId, viidDatasourceIdParam.getId())
                .set(ResourceDatasource::getStatus, ResourceDatasourceStatus.ENABLE.getValue()).update();
    }

    @Override
    public List<ResourceDatasource> listByStatus(String status) {
        return this.list(new QueryWrapper().eq(ResourceDatasource::getStatus, status));
    }

    @Override
    public void copy(ResourceDatasourceIdParam viidDatasourceIdParam) {
        // 获取原数据源
        ResourceDatasource originalDatasource = this.queryEntity(viidDatasourceIdParam.getId());

        // 创建新数据源对象
        ResourceDatasource newDatasource = new ResourceDatasource();
        // 复制属性，但使用新的ID和标题
        BeanUtil.copyProperties(originalDatasource, newDatasource);
        newDatasource.setId(null); // 生成新的ID
        newDatasource.setTitle(originalDatasource.getTitle() + "_副本"); // 添加副本标识
        newDatasource.setStatus(ResourceDatasourceStatus.DISABLED.getValue()); // 设置为禁用状态

        // 保存新数据源
        this.save(newDatasource);
    }

}
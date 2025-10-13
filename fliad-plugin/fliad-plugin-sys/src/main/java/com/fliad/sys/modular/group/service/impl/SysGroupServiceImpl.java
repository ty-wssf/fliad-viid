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
package com.fliad.sys.modular.group.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fliad.sys.modular.group.param.*;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.annotation.Tran;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.sys.modular.group.entity.SysGroup;
import com.fliad.sys.modular.group.mapper.SysGroupMapper;
import com.fliad.sys.modular.group.service.SysGroupService;
import com.fliad.sys.modular.org.entity.SysOrg;
import com.fliad.sys.modular.org.service.SysOrgService;
import com.fliad.sys.modular.relation.entity.SysRelation;
import com.fliad.sys.modular.relation.enums.SysRelationCategoryEnum;
import com.fliad.sys.modular.relation.service.SysRelationService;
import com.fliad.sys.modular.user.entity.SysUser;
import com.fliad.sys.modular.user.service.SysUserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户组Service接口实现类
 *
 * @author chengchuanyao
 * @date 2025/1/6 11:36
 */
@Component
public class SysGroupServiceImpl extends ServiceImpl<SysGroupMapper, SysGroup> implements SysGroupService {

    @Inject
    private SysRelationService sysRelationService;

    @Inject
    private SysUserService sysUserService;

    @Inject
    private SysOrgService sysOrgService;

    @Override
    public Page<SysGroup> page(SysGroupPageParam sysGroupPageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(ObjectUtil.isNotEmpty(sysGroupPageParam.getName())) {
            queryWrapper.like(SysGroup::getName, sysGroupPageParam.getName());
        }
        if(ObjectUtil.isAllNotEmpty(sysGroupPageParam.getSortField(), sysGroupPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(sysGroupPageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(sysGroupPageParam.getSortField()), sysGroupPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy(SysGroup::getSortCode).asc();
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Tran
    @Override
    public void add(SysGroupAddParam sysGroupAddParam) {
        SysGroup sysGroup = BeanUtil.toBean(sysGroupAddParam, SysGroup.class);
        this.save(sysGroup);
    }

    @Tran
    @Override
    public void edit(SysGroupEditParam sysGroupEditParam) {
        SysGroup sysGroup = this.queryEntity(sysGroupEditParam.getId());
        BeanUtil.copyProperties(sysGroupEditParam, sysGroup);
        this.updateById(sysGroup);
    }

    @Tran
    @Override
    public void delete(List<SysGroupIdParam> sysGroupIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(sysGroupIdParamList, SysGroupIdParam::getId));
    }

    @Override
    public SysGroup detail(SysGroupIdParam sysGroupIdParam) {
        return this.queryEntity(sysGroupIdParam.getId());
    }

    @Override
    public SysGroup queryEntity(String id) {
        SysGroup sysGroup = this.getById(id);
        if(ObjectUtil.isEmpty(sysGroup)) {
            throw new CommonException("用户组不存在，id值为：{}", id);
        }
        return sysGroup;
    }

    @Override
    public List<String> ownUser(SysGroupIdParam sysGroupIdParam) {
        return sysRelationService.getRelationObjectIdListByTargetIdAndCategory(sysGroupIdParam.getId(),
                SysRelationCategoryEnum.SYS_USER_HAS_GROUP.getValue());
    }

    @Override
    public List<Tree<String>> orgTreeSelector() {
        List<SysOrg> sysOrgList = sysOrgService.getAllOrgList();
        List<TreeNode<String>> treeNodeList = sysOrgList.stream().map(sysOrg ->
                        new TreeNode<>(sysOrg.getId(), sysOrg.getParentId(), sysOrg.getName(), sysOrg.getSortCode()))
                .collect(Collectors.toList());
        return TreeUtil.build(treeNodeList, "0");
    }

    @Override
    public Page<SysUser> userSelector(SysGroupSelectorUserParam sysGroupSelectorUserParam) {
        QueryWrapper lambdaQueryWrapper = new QueryWrapper();
        // 只查询部分字段
        lambdaQueryWrapper.select(SysUser::getId, SysUser::getAvatar, SysUser::getOrgId, SysUser::getPositionId, SysUser::getAccount,
                SysUser::getName, SysUser::getSortCode, SysUser::getGender, SysUser::getEntryDate);
        // 如果查询条件为空，则直接查询
        if(ObjectUtil.isAllEmpty(sysGroupSelectorUserParam.getOrgId(), sysGroupSelectorUserParam.getSearchKey())) {
            return sysUserService.getAllUserSelectorList();
        } else {
            if (ObjectUtil.isNotEmpty(sysGroupSelectorUserParam.getOrgId())) {
                // 如果组织id不为空，则查询该组织及其子极其子下的所有人
                List<String> childOrgIdList = CollStreamUtil.toList(sysOrgService.getChildListById(sysOrgService
                        .getAllOrgList(), sysGroupSelectorUserParam.getOrgId(), true), SysOrg::getId);
                if (ObjectUtil.isNotEmpty(childOrgIdList)) {
                    lambdaQueryWrapper.in(SysUser::getOrgId, childOrgIdList);
                } else {
                    return new Page<>();
                }
            }
            if (ObjectUtil.isNotEmpty(sysGroupSelectorUserParam.getSearchKey())) {
                lambdaQueryWrapper.like(SysUser::getName, sysGroupSelectorUserParam.getSearchKey());
            }
            lambdaQueryWrapper.orderBy(SysUser::getSortCode).asc();
            return sysUserService.page(CommonPageRequest.defaultPage(), lambdaQueryWrapper);
        }
    }

    @Override
    public void grantUser(SysGroupGrantUserParam sysGroupGrantUserParam) {
        String id = sysGroupGrantUserParam.getId();
        List<String> grantInfoList = sysGroupGrantUserParam.getGrantInfoList();
        sysRelationService.remove(new QueryWrapper().eq(SysRelation::getTargetId, id)
                .eq(SysRelation::getCategory, SysRelationCategoryEnum.SYS_USER_HAS_GROUP.getValue()));
        sysRelationService.saveBatch(grantInfoList.stream().map(userId -> {
            SysRelation sysRelation = new SysRelation();
            sysRelation.setObjectId(userId);
            sysRelation.setTargetId(id);
            sysRelation.setCategory(SysRelationCategoryEnum.SYS_USER_HAS_GROUP.getValue());
            return sysRelation;
        }).collect(Collectors.toList()));
    }
}

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
package com.fliad.mobile.modular.resource.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Component;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.mobile.modular.resource.entity.MobileButton;
import com.fliad.mobile.modular.resource.entity.MobileMenu;
import com.fliad.mobile.modular.resource.enums.MobileResourceCategoryEnum;
import com.fliad.mobile.modular.resource.mapper.MobileButtonMapper;
import com.fliad.mobile.modular.resource.param.button.MobileButtonAddParam;
import com.fliad.mobile.modular.resource.param.button.MobileButtonEditParam;
import com.fliad.mobile.modular.resource.param.button.MobileButtonIdParam;
import com.fliad.mobile.modular.resource.param.button.MobileButtonPageParam;
import com.fliad.mobile.modular.resource.service.MobileButtonService;
import com.fliad.mobile.modular.resource.service.MobileMenuService;
import com.fliad.sys.api.SysRelationApi;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 移动端按钮Service接口实现类
 *
 * @author xuyuxiang
 * @date 2022/6/27 14:25
 **/
@Component
public class MobileButtonServiceImpl extends ServiceImpl<MobileButtonMapper, MobileButton> implements MobileButtonService {

    @Inject
    private SysRelationApi sysRelationApi;

    @Inject
    private MobileMenuService mobileMenuService;

    @Override
    public Page<MobileButton> page(MobileButtonPageParam mobileButtonPageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(MobileButton::getCategory, MobileResourceCategoryEnum.BUTTON.getValue());
        if(ObjectUtil.isNotEmpty(mobileButtonPageParam.getParentId())) {
            queryWrapper.eq(MobileButton::getParentId, mobileButtonPageParam.getParentId());
        }
        if(ObjectUtil.isNotEmpty(mobileButtonPageParam.getSearchKey())) {
            queryWrapper.like(MobileButton::getTitle, mobileButtonPageParam.getSearchKey());
        }
        if(ObjectUtil.isAllNotEmpty(mobileButtonPageParam.getSortField(), mobileButtonPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(mobileButtonPageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(mobileButtonPageParam.getSortField()),mobileButtonPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy(MobileButton::getSortCode);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Override
    public void add(MobileButtonAddParam mobileButtonAddParam) {
        MobileButton mobileButton = BeanUtil.toBean(mobileButtonAddParam, MobileButton.class);
        boolean repeatCode = this.count(new QueryWrapper()
                .eq(MobileButton::getCategory, MobileResourceCategoryEnum.BUTTON.getValue())
                .eq(MobileButton::getCode, mobileButton.getCode())) > 0;
        if(repeatCode) {
            throw new CommonException("存在重复的移动端按钮，编码为：{}", mobileButton.getCode());
        }
        mobileButton.setCategory(MobileResourceCategoryEnum.BUTTON.getValue());
        this.save(mobileButton);
    }

    @Override
    public void edit(MobileButtonEditParam mobileButtonEditParam) {
        MobileButton mobileButton = this.queryEntity(mobileButtonEditParam.getId());
        BeanUtil.copyProperties(mobileButtonEditParam, mobileButton);
        boolean repeatCode = this.count(new QueryWrapper()
                .eq(MobileButton::getCategory, MobileResourceCategoryEnum.BUTTON.getValue())
                .eq(MobileButton::getCode, mobileButton.getCode())
                .ne(MobileButton::getId, mobileButtonEditParam.getId())) > 0;
        if(repeatCode) {
            throw new CommonException("存在重复的移动端按钮，编码为：{}", mobileButton.getCode());
        }
        this.updateById(mobileButton);
    }

    @Override
    public void delete(List<MobileButtonIdParam> mobileButtonIdParamList) {
        List<String> buttonIdList = CollStreamUtil.toList(mobileButtonIdParamList, MobileButtonIdParam::getId);
        if(ObjectUtil.isNotEmpty(buttonIdList)) {
            // 获取移动端按钮的父菜单id集合
            List<String> parentMenuIdList = mobileMenuService.list(new QueryWrapper().in(MobileMenu::getId, buttonIdList)
                    .eq(MobileMenu::getCategory, MobileResourceCategoryEnum.BUTTON.getValue())).stream().map(MobileMenu::getParentId)
                    .collect(Collectors.toList());
            if(ObjectUtil.isNotEmpty(parentMenuIdList)) {
                // 清除对应的角色与移动端菜单信息中的【授权的移动端按钮信息】
                sysRelationApi.removeRoleHasMobileButtonRelation(parentMenuIdList, buttonIdList);
                // 执行删除
                this.removeByIds(buttonIdList);
            }
        }
    }

    @Override
    public MobileButton detail(MobileButtonIdParam mobileButtonIdParam) {
        return this.queryEntity(mobileButtonIdParam.getId());
    }

    @Override
    public MobileButton queryEntity(String id) {
        MobileButton mobileButton = this.getById(id);
        if(ObjectUtil.isEmpty(mobileButton)) {
            throw new CommonException("移动端按钮不存在，id值为：{}", id);
        }
        return mobileButton;
    }
}

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
package com.fliad.sys.modular.resource.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Component;
import org.noear.solon.data.annotation.Tran;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.common.listener.CommonDataChangeEventCenter;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.sys.core.enums.SysBuildInEnum;
import com.fliad.sys.core.enums.SysDataTypeEnum;
import com.fliad.sys.modular.relation.entity.SysRelation;
import com.fliad.sys.modular.relation.enums.SysRelationCategoryEnum;
import com.fliad.sys.modular.relation.service.SysRelationService;
import com.fliad.sys.modular.resource.entity.SysMenu;
import com.fliad.sys.modular.resource.entity.SysModule;
import com.fliad.sys.modular.resource.enums.SysResourceCategoryEnum;
import com.fliad.sys.modular.resource.mapper.SysModuleMapper;
import com.fliad.sys.modular.resource.param.module.SysModuleAddParam;
import com.fliad.sys.modular.resource.param.module.SysModuleEditParam;
import com.fliad.sys.modular.resource.param.module.SysModuleIdParam;
import com.fliad.sys.modular.resource.param.module.SysModulePageParam;
import com.fliad.sys.modular.resource.service.SysMenuService;
import com.fliad.sys.modular.resource.service.SysModuleService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 模块Service接口实现类
 *
 * @author xuyuxiang
 * @date 2022/6/27 14:25
 **/
@Component
public class SysModuleServiceImpl extends ServiceImpl<SysModuleMapper, SysModule> implements SysModuleService {

    @Inject
    private SysMenuService sysMenuService;

    @Inject
    private SysRelationService sysRelationService;

    @Override
    public Page<SysModule> page(SysModulePageParam sysModulePageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(SysModule::getCategory, SysResourceCategoryEnum.MODULE.getValue());
        if (ObjectUtil.isNotEmpty(sysModulePageParam.getSearchKey())) {
            queryWrapper.like(SysModule::getTitle, sysModulePageParam.getSearchKey());
        }
        if (ObjectUtil.isAllNotEmpty(sysModulePageParam.getSortField(), sysModulePageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(sysModulePageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(sysModulePageParam.getSortField()), sysModulePageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy(SysModule::getSortCode);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Tran
    @Override
    public void add(SysModuleAddParam sysModuleAddParam) {
        SysModule sysModule = BeanUtil.toBean(sysModuleAddParam, SysModule.class);
        boolean repeatTitle = this.count(new QueryWrapper().eq(SysModule::getCategory,
                SysResourceCategoryEnum.MODULE.getValue()).eq(SysModule::getTitle, sysModule.getTitle())) > 0;
        if (repeatTitle) {
            throw new CommonException("存在重复的模块，名称为：{}", sysModule.getTitle());
        }
        sysModule.setCode(RandomUtil.randomString(10));
        sysModule.setCategory(SysResourceCategoryEnum.MODULE.getValue());
        this.save(sysModule);

        // 发布增加事件
        CommonDataChangeEventCenter.doAddWithData(SysDataTypeEnum.RESOURCE.getValue(), JSONUtil.createArray().put(sysModule));
    }

    @Tran
    @Override
    public void edit(SysModuleEditParam sysModuleEditParam) {
        SysModule sysModule = this.queryEntity(sysModuleEditParam.getId());
        BeanUtil.copyProperties(sysModuleEditParam, sysModule);
        boolean repeatTitle = this.count(new QueryWrapper().eq(SysModule::getCategory,
                        SysResourceCategoryEnum.MODULE.getValue()).eq(SysModule::getTitle, sysModule.getTitle())
                .ne(SysModule::getId, sysModule.getId())) > 0;
        if (repeatTitle) {
            throw new CommonException("存在重复的模块，名称为：{}", sysModule.getTitle());
        }
        this.updateById(sysModule);

        // 发布更新事件
        CommonDataChangeEventCenter.doUpdateWithData(SysDataTypeEnum.RESOURCE.getValue(), JSONUtil.createArray().put(sysModule));
    }

    @Override
    public void delete(List<SysModuleIdParam> sysModuleIdParamList) {
        List<String> sysModuleIdList = CollStreamUtil.toList(sysModuleIdParamList, SysModuleIdParam::getId);
        if (ObjectUtil.isNotEmpty(sysModuleIdList)) {
            boolean containsSystemModule = this.listByIds(sysModuleIdList).stream().map(SysModule::getCode)
                    .collect(Collectors.toSet()).contains(SysBuildInEnum.BUILD_IN_MODULE_CODE.getValue());
            if (containsSystemModule) {
                throw new CommonException("不可删除系统内置模块");
            }

            // 获取模块下的菜单、按钮
            List<SysMenu> allMenuList = sysMenuService.list(new QueryWrapper()
                    .in(SysMenu::getCategory, CollectionUtil.newArrayList(SysResourceCategoryEnum.MENU.getValue(),
                            SysResourceCategoryEnum.BUTTON.getValue())));
            if (ObjectUtil.isNotEmpty(allMenuList)) {
                List<String> toDeleteMenuIdList = CollectionUtil.newArrayList(sysModuleIdList);
                allMenuList.stream().filter(sysMenu -> sysModuleIdList.contains(sysMenu.getModule()))
                        .collect(Collectors.toList()).forEach(sysMenu -> toDeleteMenuIdList
                                .addAll(sysMenuService.getChildListById(allMenuList, sysMenu.getId(), true).stream()
                                        .map(SysMenu::getId).collect(Collectors.toList())));
                if (ObjectUtil.isNotEmpty(toDeleteMenuIdList)) {
                    // 清除对应的角色与资源信息
                    sysRelationService.remove(new QueryWrapper().in(SysRelation::getTargetId, toDeleteMenuIdList)
                            .eq(SysRelation::getCategory, SysRelationCategoryEnum.SYS_ROLE_HAS_RESOURCE.getValue()));
                    // 执行删除
                    this.removeByIds(toDeleteMenuIdList);

                    // 发布删除事件
                    CommonDataChangeEventCenter.doDeleteWithDataId(SysDataTypeEnum.RESOURCE.getValue(), toDeleteMenuIdList);
                }
            }
        }
    }

    @Override
    public SysModule detail(SysModuleIdParam sysModuleIdParam) {
        return this.queryEntity(sysModuleIdParam.getId());
    }

    @Override
    public SysModule queryEntity(String id) {
        SysModule sysModule = this.getById(id);
        if (ObjectUtil.isEmpty(sysModule)) {
            throw new CommonException("模块不存在，id值为：{}", id);
        }
        return sysModule;
    }

    @Override
    public List<JSONObject> moduleSelector() {
        QueryWrapper eq = QueryWrapper.create().select(SysModule::getId, SysModule::getTitle).eq(SysModule::getCategory, SysResourceCategoryEnum.MODULE.getValue());
        return this.list(eq).stream()
                .map(item -> JSONUtil.createObj().set("id", item.getId()).set("name", item.getTitle()))
                .collect(Collectors.toList());
    }
}

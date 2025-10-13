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
package com.fliad.sys.modular.role.provider;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Component;
import org.noear.solon.data.annotation.Tran;
import com.fliad.sys.api.SysRoleApi;
import com.fliad.sys.core.enums.SysBuildInEnum;
import com.fliad.sys.modular.relation.entity.SysRelation;
import com.fliad.sys.modular.relation.enums.SysRelationCategoryEnum;
import com.fliad.sys.modular.relation.service.SysRelationService;
import com.fliad.sys.modular.resource.entity.SysButton;
import com.fliad.sys.modular.resource.entity.SysMenu;
import com.fliad.sys.modular.resource.enums.SysResourceCategoryEnum;
import com.fliad.sys.modular.resource.service.SysButtonService;
import com.fliad.sys.modular.resource.service.SysMenuService;
import com.fliad.sys.modular.role.entity.SysRole;
import com.fliad.sys.modular.role.param.SysRoleGrantResourceParam;
import com.fliad.sys.modular.role.param.SysRoleSelectorRoleParam;
import com.fliad.sys.modular.role.service.SysRoleService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色API接口提供者
 *
 * @author xuyuxiang
 * @date 2022/7/22 14:57
 **/
@Component
public class SysRoleApiProvider implements SysRoleApi {

    @Inject
    private SysRoleService sysRoleService;

    @Inject
    private SysMenuService sysMenuService;

    @Inject
    private SysButtonService sysButtonService;

    @Inject
    private SysRelationService sysRelationService;

    @Override
    public boolean orgHasRole(List<String> orgIdList) {
        return sysRoleService.count(new QueryWrapper().in(SysRole::getOrgId, orgIdList)) > 0;
    }

    @SuppressWarnings("ALL")
    @Override
    public Page<JSONObject> roleSelector(String orgId, String category, String searchKey, List<String> dataScopeList, boolean excludeSuperAdmin) {
        SysRoleSelectorRoleParam sysRoleSelectorRoleParam = new SysRoleSelectorRoleParam();
        sysRoleSelectorRoleParam.setOrgId(orgId);
        sysRoleSelectorRoleParam.setCategory(category);
        sysRoleSelectorRoleParam.setSearchKey(searchKey);
        sysRoleSelectorRoleParam.setDataScopeList(dataScopeList);
        sysRoleSelectorRoleParam.setExcludeSuperAdmin(excludeSuperAdmin);
        return BeanUtil.toBean(sysRoleService.roleSelector(sysRoleSelectorRoleParam), Page.class);
    }

    @Tran
    @Override
    public void grantForGenMenuAndButton(String menuId) {
        String superAdminRoleId = sysRoleService.getOne(new QueryWrapper()
                .eq(SysRole::getCode, SysBuildInEnum.BUILD_IN_ROLE_CODE.getValue())).getId();
        SysRoleGrantResourceParam sysRoleGrantResourceParam = new SysRoleGrantResourceParam();
        sysRoleGrantResourceParam.setId(superAdminRoleId);
        SysMenu sysMenu = sysMenuService.queryEntity(menuId);
        SysRoleGrantResourceParam.SysRoleGrantResource sysRoleGrantResource = new SysRoleGrantResourceParam.SysRoleGrantResource();
        sysRoleGrantResource.setMenuId(sysMenu.getId());
        List<String> buttonIdList = sysButtonService.list(new QueryWrapper().eq(SysButton::getParentId,
                        sysMenu.getId()).eq(SysButton::getCategory, SysResourceCategoryEnum.BUTTON.getValue())).stream()
                .map(SysButton::getId).collect(Collectors.toList());
        sysRoleGrantResource.setButtonInfo(buttonIdList);
        sysRoleGrantResourceParam.setGrantInfoList(CollectionUtil.newArrayList(sysRoleGrantResource));

        List<String> menuIdList = sysRoleGrantResourceParam.getGrantInfoList().stream()
                .map(SysRoleGrantResourceParam.SysRoleGrantResource::getMenuId).collect(Collectors.toList());
        List<String> extJsonList = sysRoleGrantResourceParam.getGrantInfoList().stream()
                .map(JSONUtil::toJsonStr).collect(Collectors.toList());

        List<String> existMenuIdList = sysMenuService.list(new QueryWrapper().eq(SysMenu::getCategory,
                SysResourceCategoryEnum.MENU.getValue())).stream().map(SysMenu::getId).collect(Collectors.toList());
        if(ObjectUtil.isNotEmpty(existMenuIdList)) {
            sysRelationService.remove(new QueryWrapper().eq(SysRelation::getObjectId, superAdminRoleId)
                    .eq(SysRelation::getCategory, SysRelationCategoryEnum.SYS_ROLE_HAS_RESOURCE.getValue()).notIn(SysRelation::getTargetId, existMenuIdList));
        }
        sysRelationService.saveRelationBatchWithAppend(superAdminRoleId, menuIdList, SysRelationCategoryEnum.SYS_ROLE_HAS_RESOURCE.getValue(), extJsonList);
    }
}

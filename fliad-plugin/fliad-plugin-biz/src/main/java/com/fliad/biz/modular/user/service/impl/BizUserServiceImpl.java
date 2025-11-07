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
package com.fliad.biz.modular.user.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.PhoneUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fliad.biz.modular.user.param.*;
import com.fliad.common.util.*;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import io.nop.commons.concurrent.executor.GlobalExecutors;
import io.nop.core.lang.eval.IEvalScope;
import io.nop.core.resource.IResource;
import io.nop.core.resource.ResourceConstants;
import io.nop.core.resource.VirtualFileSystem;
import io.nop.core.resource.tpl.ITemplateOutput;
import io.nop.report.core.engine.IReportEngine;
import io.nop.xlang.api.XLang;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.UploadedFile;
import org.noear.solon.data.annotation.Tran;
import com.fliad.auth.core.util.StpLoginUserUtil;
import com.fliad.biz.core.enums.BizBuildInEnum;
import com.fliad.biz.core.enums.BizDataTypeEnum;
import com.fliad.biz.modular.org.entity.BizOrg;
import com.fliad.biz.modular.org.service.BizOrgService;
import com.fliad.biz.modular.position.entity.BizPosition;
import com.fliad.biz.modular.position.service.BizPositionService;
import com.fliad.biz.modular.user.entity.BizUser;
import com.fliad.biz.modular.user.enums.BizRoleCategoryEnum;
import com.fliad.biz.modular.user.enums.BizUserStatusEnum;
import com.fliad.biz.modular.user.mapper.BizUserMapper;
import com.fliad.biz.modular.user.result.BizUserRoleResult;
import com.fliad.biz.modular.user.service.BizUserService;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.common.listener.CommonDataChangeEventCenter;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.dev.api.DevConfigApi;
import com.fliad.sys.api.SysRoleApi;
import com.fliad.sys.api.SysUserApi;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 人员Service接口实现类
 *
 * @author xuyuxiang
 * @date 2022/2/23 18:43
 **/
@Component
public class BizUserServiceImpl extends ServiceImpl<BizUserMapper, BizUser> implements BizUserService {

    private static final Logger log = LoggerFactory.getLogger(BizUserServiceImpl.class);

    private static final String SNOWY_SYS_DEFAULT_PASSWORD_KEY = "SNOWY_SYS_DEFAULT_PASSWORD";

//    @Inject
//    private TransService transService;

    @Inject
    private DevConfigApi devConfigApi;

    @Inject
    private SysUserApi sysUserApi;

    @Inject
    private SysRoleApi sysRoleApi;

    @Inject
    private BizOrgService bizOrgService;

    @Inject
    private BizPositionService bizPositionService;

    @Inject
    IReportEngine reportEngine;

    /**
     * 将base64字符串转换为图片字节数组
     *
     * @param base64String base64编码的图片字符串
     * @return 图片字节数组
     */
    private byte[] base64ToByteArray(String base64String) {
        try {
            // 移除可能存在的data:image/png;base64,前缀
            String base64Data = base64String;
            if (base64String.contains(",")) {
                base64Data = base64String.substring(base64String.indexOf(",") + 1);
            }

            // 使用Java内置Base64解码器解码
            return Base64.getDecoder().decode(base64Data);
        } catch (Exception e) {
            log.error("Base64图片转换失败: {}", e.getMessage(), e);
            return new byte[0]; // 返回空字节数组
        }
    }

    @Override
    public Page<BizUser> page(BizUserPageParam bizUserPageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(bizUserPageParam.getSearchKey())) {
            queryWrapper.and(q -> {
                q.like(BizUser::getAccount, bizUserPageParam.getSearchKey());
            }).or(q -> {
                q.like(BizUser::getName, bizUserPageParam.getSearchKey());
            });
        }
        if (ObjectUtil.isNotEmpty(bizUserPageParam.getOrgId())) {
            queryWrapper.eq(BizUser::getOrgId, bizUserPageParam.getOrgId());
        }
        if (ObjectUtil.isNotEmpty(bizUserPageParam.getUserStatus())) {
            queryWrapper.eq(BizUser::getUserStatus, bizUserPageParam.getUserStatus());
        }
        if (ObjectUtil.isAllNotEmpty(bizUserPageParam.getSortField(), bizUserPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(bizUserPageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(bizUserPageParam.getSortField()), bizUserPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy(BizUser::getSortCode);
        }
        // 排除超管
        queryWrapper.ne(BizUser::getAccount, BizBuildInEnum.BUILD_IN_USER_ACCOUNT.getValue());
        // 校验数据范围
        List<String> loginUserDataScope = StpLoginUserUtil.getLoginUserDataScope();
        if (ObjectUtil.isNotEmpty(loginUserDataScope)) {
            queryWrapper.in(BizUser::getOrgId, loginUserDataScope);
        } else {
            queryWrapper.eq(BizUser::getId, StpUtil.getLoginIdAsString());
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Tran
    @Override
    public void add(BizUserAddParam bizUserAddParam) {
        checkParam(bizUserAddParam);
        BizUser bizUser = BeanUtil.toBean(bizUserAddParam, BizUser.class);
        if (ObjectUtil.isEmpty(bizUser.getAvatar())) {
            // 设置默认头像
            bizUser.setAvatar(CommonAvatarUtil.generateImg(bizUser.getName()));
        }
        // 设置密码
        bizUser.setPassword(CommonCryptogramUtil.doHashValue(devConfigApi.getValueByKey(SNOWY_SYS_DEFAULT_PASSWORD_KEY)));
        // 设置状态
        bizUser.setUserStatus(BizUserStatusEnum.ENABLE.getValue());
        this.save(bizUser);

        // 发布增加事件
        CommonDataChangeEventCenter.doAddWithData(BizDataTypeEnum.USER.getValue(), JSONUtil.createArray().put(bizUser));
    }

    private void checkParam(BizUserAddParam bizUserAddParam) {
        // 校验数据范围
        List<String> loginUserDataScope = StpLoginUserUtil.getLoginUserDataScope();
        if (ObjectUtil.isNotEmpty(loginUserDataScope)) {
            if (!loginUserDataScope.contains(bizUserAddParam.getOrgId())) {
                throw new CommonException("您没有权限在该机构下增加人员，机构id：{}", bizUserAddParam.getOrgId());
            }
        } else {
            throw new CommonException("您没有权限在该机构下增加人员，机构id：{}", bizUserAddParam.getOrgId());
        }
        if (this.count(new QueryWrapper()
                .eq(BizUser::getAccount, bizUserAddParam.getAccount())) > 0) {
            throw new CommonException("存在重复的账号，账号为：{}", bizUserAddParam.getAccount());
        }
        if (ObjectUtil.isNotEmpty(bizUserAddParam.getPhone())) {
            if (!PhoneUtil.isMobile(bizUserAddParam.getPhone())) {
                throw new CommonException("手机号码：{}格式错误", bizUserAddParam.getPhone());
            }
            if (this.count(new QueryWrapper()
                    .eq(BizUser::getPhone, CommonCryptogramUtil.doSm4CbcEncrypt(bizUserAddParam.getPhone()))) > 0) {
                throw new CommonException("存在重复的手机号，手机号为：{}", bizUserAddParam.getPhone());
            }
        }
        if (ObjectUtil.isNotEmpty(bizUserAddParam.getEmail())) {
            if (!CommonEmailUtil.isEmail(bizUserAddParam.getEmail())) {
                throw new CommonException("邮箱：{}格式错误", bizUserAddParam.getEmail());
            }
            if (this.count(new QueryWrapper()
                    .eq(BizUser::getEmail, bizUserAddParam.getEmail())) > 0) {
                throw new CommonException("存在重复的邮箱，邮箱为：{}", bizUserAddParam.getEmail());
            }
        }
    }

    @Tran
    @Override
    public void edit(BizUserEditParam bizUserEditParam) {
        BizUser bizUser = this.queryEntity(bizUserEditParam.getId());
        checkParam(bizUserEditParam);
        boolean updateSuperAdminAccount = bizUser.getAccount().equals(BizBuildInEnum.BUILD_IN_USER_ACCOUNT.getValue()) &&
                !bizUserEditParam.getAccount().equals(BizBuildInEnum.BUILD_IN_USER_ACCOUNT.getValue());
        if (updateSuperAdminAccount) {
            throw new CommonException("不可修改系统内置超管人员账号");
        }
        BeanUtil.copyProperties(bizUserEditParam, bizUser);
        this.updateById(bizUser);

        // 发布更新事件
        CommonDataChangeEventCenter.doUpdateWithData(BizDataTypeEnum.USER.getValue(), JSONUtil.createArray().put(bizUser));
    }

    private void checkParam(BizUserEditParam bizUserEditParam) {
        // 校验数据范围
        List<String> loginUserDataScope = StpLoginUserUtil.getLoginUserDataScope();
        if (ObjectUtil.isNotEmpty(loginUserDataScope)) {
            if (!loginUserDataScope.contains(bizUserEditParam.getOrgId())) {
                throw new CommonException("您没有权限编辑该机构下的人员，机构id：{}", bizUserEditParam.getOrgId());
            }
        } else {
            if (!bizUserEditParam.getId().equals(StpUtil.getLoginIdAsString())) {
                throw new CommonException("您没有权限编辑该机构下的人员，机构id：{}", bizUserEditParam.getOrgId());
            }
        }
        if (this.count(new QueryWrapper()
                .eq(BizUser::getAccount, bizUserEditParam.getAccount())
                .ne(BizUser::getId, bizUserEditParam.getId())) > 0) {
            throw new CommonException("存在重复的账号，账号为：{}", bizUserEditParam.getAccount());
        }
        if (ObjectUtil.isNotEmpty(bizUserEditParam.getPhone())) {
            if (!PhoneUtil.isMobile(bizUserEditParam.getPhone())) {
                throw new CommonException("手机号码：{}格式错误", bizUserEditParam.getPhone());
            }
            if (this.count(new QueryWrapper()
                    .eq(BizUser::getPhone, CommonCryptogramUtil.doSm4CbcEncrypt(bizUserEditParam.getPhone()))
                    .ne(BizUser::getId, bizUserEditParam.getId())) > 0) {
                throw new CommonException("存在重复的手机号，手机号为：{}", bizUserEditParam.getPhone());
            }
        }
        if (ObjectUtil.isNotEmpty(bizUserEditParam.getEmail())) {
            if (!CommonEmailUtil.isEmail(bizUserEditParam.getEmail())) {
                throw new CommonException("邮箱：{}格式错误", bizUserEditParam.getEmail());
            }
            if (this.count(new QueryWrapper()
                    .eq(BizUser::getEmail, bizUserEditParam.getEmail())
                    .ne(BizUser::getId, bizUserEditParam.getId())) > 0) {
                throw new CommonException("存在重复的邮箱，邮箱为：{}", bizUserEditParam.getEmail());
            }
        }
    }

    @Tran
    @Override
    public void delete(List<BizUserIdParam> bizUserIdParamList) {
        List<String> bizUserIdList = CollStreamUtil.toList(bizUserIdParamList, BizUserIdParam::getId);
        if (ObjectUtil.isNotEmpty(bizUserIdList)) {
            boolean containsSuperAdminAccount = this.listByIds(bizUserIdList).stream().map(BizUser::getAccount)
                    .collect(Collectors.toSet()).contains(BizBuildInEnum.BUILD_IN_USER_ACCOUNT.getValue());
            if (containsSuperAdminAccount) {
                throw new CommonException("不可删除系统内置超管人员");
            }
            // 获取这些人员的的机构id集合
            Set<String> userOrgIdList = this.listByIds(bizUserIdList).stream().map(BizUser::getOrgId).collect(Collectors.toSet());
            // 校验数据范围
            List<String> loginUserDataScope = StpLoginUserUtil.getLoginUserDataScope();
            if (ObjectUtil.isNotEmpty(loginUserDataScope)) {
                if (!loginUserDataScope.containsAll(userOrgIdList)) {
                    throw new CommonException("您没有权限删除这些机构下的人员，机构id：{}",
                            CollectionUtil.subtract(userOrgIdList, loginUserDataScope));
                }
            } else {
                if (bizUserIdList.size() != 1 || !bizUserIdList.get(0).equals(StpUtil.getLoginIdAsString())) {
                    throw new CommonException("您没有权限删除这些机构下的人员，机构id：{}", userOrgIdList);
                }
            }
            // 清除【将这些人员作为主管】的信息
            this.updateChain().in(BizUser::getDirectorId, bizUserIdList).set(BizUser::getDirectorId, null).update();
            // 清除【将这些人员作为兼任岗位的主管】的信息
            this.list(new QueryWrapper().isNotNull(BizUser::getPositionJson)).forEach(bizUser -> {
                List<JSONObject> handledJsonObjectList = JSONUtil.toList(JSONUtil.parseArray(bizUser.getPositionJson()),
                        JSONObject.class).stream().peek(jsonObject -> {
                    String directorId = jsonObject.getStr("directorId");
                    if (ObjectUtil.isNotEmpty(directorId) && bizUserIdList.contains(directorId)) {
                        jsonObject.remove("directorId");
                    }
                }).collect(Collectors.toList());
                this.updateChain().eq(BizUser::getId, bizUser.getId()).set(BizUser::getPositionJson, JSONUtil.toJsonStr(handledJsonObjectList)).update();
            });

            // 清除【将这些人员作为主管】的机构的主管信息
            bizOrgService.updateChain().in(BizOrg::getDirectorId, bizUserIdList).set(BizOrg::getDirectorId, null).update();

            // 执行删除
            this.removeByIds(bizUserIdList);

            // 发布删除事件
            CommonDataChangeEventCenter.doDeleteWithDataId(BizDataTypeEnum.USER.getValue(), bizUserIdList);
        }
    }

    @Override
    public BizUser detail(BizUserIdParam bizUserIdParam) {
        return this.queryEntity(bizUserIdParam.getId());
    }

    @Tran
    @Override
    public void disableUser(BizUserIdParam bizUserIdParam) {
        BizUser bizUser = this.detail(bizUserIdParam);
        // 校验数据范围
        List<String> loginUserDataScope = StpLoginUserUtil.getLoginUserDataScope();
        if (ObjectUtil.isNotEmpty(loginUserDataScope)) {
            if (!loginUserDataScope.contains(bizUser.getOrgId())) {
                throw new CommonException("您没有权限禁用该机构下的人员：{}，机构id：{}", bizUser.getName(), bizUser.getOrgId());
            }
        } else {
            if (!bizUser.getId().equals(StpUtil.getLoginIdAsString())) {
                throw new CommonException("您没有权限禁用该机构下的人员：{}，机构id：{}", bizUser.getName(), bizUser.getOrgId());
            }
        }
        this.updateChain().eq(BizUser::getId, bizUserIdParam.getId()).set(BizUser::getUserStatus, BizUserStatusEnum.DISABLED.getValue()).update();
    }

    @Tran
    @Override
    public void enableUser(BizUserIdParam bizUserIdParam) {
        BizUser bizUser = this.detail(bizUserIdParam);
        // 校验数据范围
        List<String> loginUserDataScope = StpLoginUserUtil.getLoginUserDataScope();
        if (ObjectUtil.isNotEmpty(loginUserDataScope)) {
            if (!loginUserDataScope.contains(bizUser.getOrgId())) {
                throw new CommonException("您没有权限启用该机构下的人员：{}，机构id：{}", bizUser.getName(), bizUser.getOrgId());
            }
        } else {
            if (!bizUser.getId().equals(StpUtil.getLoginIdAsString())) {
                throw new CommonException("您没有权限启用该机构下的人员：{}，机构id：{}", bizUser.getName(), bizUser.getOrgId());
            }
        }
        this.updateChain().eq(BizUser::getId, bizUserIdParam.getId()).set(BizUser::getUserStatus, BizUserStatusEnum.ENABLE.getValue()).update();
    }

    @Tran
    @Override
    public void resetPassword(BizUserIdParam bizUserIdParam) {
        BizUser bizUser = this.detail(bizUserIdParam);
        // 校验数据范围
        List<String> loginUserDataScope = StpLoginUserUtil.getLoginUserDataScope();
        if (ObjectUtil.isNotEmpty(loginUserDataScope)) {
            if (!loginUserDataScope.contains(bizUser.getOrgId())) {
                throw new CommonException("您没有权限为该机构下的人员：{}重置密码，机构id：{}", bizUser.getName(), bizUser.getOrgId());
            }
        } else {
            if (!bizUser.getId().equals(StpUtil.getLoginIdAsString())) {
                throw new CommonException("您没有权限为该机构下的人员：{}重置密码，机构id：{}", bizUser.getName(), bizUser.getOrgId());
            }
        }
        this.updateChain().eq(BizUser::getId, bizUserIdParam.getId()).set(BizUser::getPassword,
                CommonCryptogramUtil.doHashValue(devConfigApi.getValueByKey(SNOWY_SYS_DEFAULT_PASSWORD_KEY))).update();
    }

    @Override
    public List<String> ownRole(BizUserIdParam bizUserIdParam) {
        return sysUserApi.ownRole(bizUserIdParam.getId());
    }

    @Tran
    @Override
    public void grantRole(BizUserGrantRoleParam bizUserGrantRoleParam) {
        BizUser bizUser = this.queryEntity(bizUserGrantRoleParam.getId());
        // 校验数据范围
        List<String> loginUserDataScope = StpLoginUserUtil.getLoginUserDataScope();
        if (ObjectUtil.isNotEmpty(loginUserDataScope)) {
            if (!loginUserDataScope.contains(bizUser.getOrgId())) {
                throw new CommonException("您没有权限为该机构下的人员：{}授权角色，机构id：{}", bizUser.getName(), bizUser.getOrgId());
            }
        } else {
            if (!bizUser.getId().equals(StpUtil.getLoginIdAsString())) {
                throw new CommonException("您没有权限为该机构下的人员：{}授权角色，机构id：{}", bizUser.getName(), bizUser.getOrgId());
            }
        }
        sysUserApi.grantRole(bizUserGrantRoleParam.getId(), bizUserGrantRoleParam.getRoleIdList());
    }

    @Override
    public void importUser(UploadedFile file) {
        // TODO 待完善
    }

    @Override
    public void exportUser(BizUserExportParam bizUserExportParam, Context ctx) throws IOException {
        IResource tempFile = null;
        try {
            QueryWrapper queryWrapper = new QueryWrapper();
            // 排除超管
            queryWrapper.ne(BizUser::getAccount, BizBuildInEnum.BUILD_IN_USER_ACCOUNT.getValue());
            // 校验数据范围
            List<String> loginUserDataScope = StpLoginUserUtil.getLoginUserDataScope();
            if (ObjectUtil.isNotEmpty(loginUserDataScope)) {
                queryWrapper.in(BizUser::getOrgId, loginUserDataScope);
            } else {
                queryWrapper.eq(BizUser::getId, StpUtil.getLoginIdAsString());
            }
            if (ObjectUtil.isNotEmpty(bizUserExportParam.getUserIds())) {
                queryWrapper.in(BizUser::getId, StrUtil.split(bizUserExportParam.getUserIds(), StrUtil.COMMA));
            } else {
                if (ObjectUtil.isNotEmpty(bizUserExportParam.getSearchKey())) {
                    queryWrapper.and(q -> {
                                q.like(BizUser::getAccount, bizUserExportParam.getSearchKey());
                            })
                            .or(q -> {
                                q.like(BizUser::getName, bizUserExportParam.getSearchKey());
                            })
                            .or(q -> {
                                q.like(BizUser::getPhone, bizUserExportParam.getSearchKey());
                            });
                }
                if (ObjectUtil.isNotEmpty(bizUserExportParam.getUserStatus())) {
                    queryWrapper.eq(BizUser::getUserStatus, bizUserExportParam.getUserStatus());
                }
            }
            List<BizUser> bizUserList = this.list(queryWrapper);
            if (ObjectUtil.isEmpty(bizUserList)) {
                throw new CommonException("无数据可导出");
            }
            List<Map<String, Object>> list = new ArrayList<>();
            for (int i = 0; i < bizUserList.size(); i++) {
                Map<String, Object> map = BeanUtil.beanToMap(bizUserList.get(i));
                int commaIndex = bizUserList.get(i).getAvatar().indexOf(',');
                map.put("avatar_", java.util.Base64.getDecoder().decode(bizUserList.get(i).getAvatar().substring(commaIndex + 1)));
                list.add(map);
            }
//            transService.transBatch(bizUserList);
            bizUserList = CollectionUtil.sort(bizUserList, Comparator.comparing(BizUser::getOrgId));
            ITemplateOutput output = reportEngine.getRenderer("/nop/report/biz/SNOWY系统B端人员信息清单.xpt.xlsx", "xlsx");
            IEvalScope scope = XLang.newEvalScope();
            scope.setLocalValue("entity", list);
            tempFile = VirtualFileSystem.instance().getResource(ResourceConstants.RESOURCE_NS_TEMP + ":/demo/SNOWY系统B端人员信息清单.xlsx");
            output.generateToResource(tempFile, scope);
            IResource finalTempFile = tempFile;
            GlobalExecutors.globalTimer().schedule(() -> {
                finalTempFile.delete();
                return null;
            }, 5, TimeUnit.MINUTES);

            CommonDownloadUtil.download(tempFile.toFile(), ctx);
        } catch (Exception e) {
            log.error(">>> 人员导出异常：", e);
            CommonResponseUtil.renderError(ctx, "导出失败");
        } finally {
            if (tempFile != null) {
                tempFile.delete();
            }
        }
    }

    @Override
    public void exportUserInfo(BizUserIdParam bizUserIdParam, Context response) throws IOException {

    }

    @Override
    public BizUser queryEntity(String id) {
        BizUser bizUser = this.getById(id);
        if (ObjectUtil.isEmpty(bizUser)) {
            throw new CommonException("人员不存在，id值为：{}", id);
        }
        return bizUser;
    }

    /* ====人员部分所需要用到的选择器==== */

    @Override
    public List<Tree<String>> orgTreeSelector() {
        QueryWrapper queryWrapper = new QueryWrapper();
        // 校验数据范围
        List<String> loginUserDataScope = StpLoginUserUtil.getLoginUserDataScope();
        // 定义机构集合
        Set<BizOrg> bizOrgSet = CollectionUtil.newHashSet();
        if (ObjectUtil.isNotEmpty(loginUserDataScope)) {
            // 获取所有机构
            List<BizOrg> allOrgList = bizOrgService.list();
            loginUserDataScope.forEach(orgId -> bizOrgSet.addAll(bizOrgService.getParentListById(allOrgList, orgId, true)));
            List<String> loginUserDataScopeFullList = bizOrgSet.stream().map(BizOrg::getId).collect(Collectors.toList());
            queryWrapper.in(BizOrg::getId, loginUserDataScopeFullList);
        } else {
            return CollectionUtil.newArrayList();
        }
        queryWrapper.orderBy(BizOrg::getSortCode);
        List<BizOrg> bizOrgList = bizOrgService.list(queryWrapper);
        List<TreeNode<String>> treeNodeList = bizOrgList.stream().map(bizOrg ->
                        new TreeNode<>(bizOrg.getId(), bizOrg.getParentId(), bizOrg.getName(), bizOrg.getSortCode()))
                .collect(Collectors.toList());
        return TreeUtil.build(treeNodeList, "0");
    }

    @Override
    public Page<BizOrg> orgListSelector(BizUserSelectorOrgListParam bizUserSelectorOrgListParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        // 校验数据范围
        List<String> loginUserDataScope = StpLoginUserUtil.getLoginUserDataScope();
        if (ObjectUtil.isNotEmpty(loginUserDataScope)) {
            queryWrapper.in(BizOrg::getId, loginUserDataScope);
        } else {
            return new Page<>();
        }
        // 查询部分字段
        queryWrapper.select(BizOrg::getId, BizOrg::getParentId, BizOrg::getName,
                BizOrg::getCategory, BizOrg::getSortCode);
        if (ObjectUtil.isNotEmpty(bizUserSelectorOrgListParam.getParentId())) {
            queryWrapper.eq(BizOrg::getParentId, bizUserSelectorOrgListParam.getParentId());
        }
        if (ObjectUtil.isNotEmpty(bizUserSelectorOrgListParam.getSearchKey())) {
            queryWrapper.like(BizOrg::getName, bizUserSelectorOrgListParam.getSearchKey());
        }
        queryWrapper.orderBy(BizOrg::getSortCode);
        return bizOrgService.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Override
    public Page<BizPosition> positionSelector(BizUserSelectorPositionParam bizUserSelectorPositionParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        // 校验数据范围
        List<String> loginUserDataScope = StpLoginUserUtil.getLoginUserDataScope();
        if (ObjectUtil.isNotEmpty(loginUserDataScope)) {
            queryWrapper.in(BizPosition::getOrgId, loginUserDataScope);
        } else {
            return new Page<>();
        }
        // 查询部分字段
        queryWrapper.select(BizPosition::getId, BizPosition::getOrgId, BizPosition::getName,
                BizPosition::getCategory, BizPosition::getSortCode);
        if (ObjectUtil.isNotEmpty(bizUserSelectorPositionParam.getOrgId())) {
            queryWrapper.eq(BizPosition::getOrgId, bizUserSelectorPositionParam.getOrgId());
        }
        if (ObjectUtil.isNotEmpty(bizUserSelectorPositionParam.getSearchKey())) {
            queryWrapper.like(BizPosition::getName, bizUserSelectorPositionParam.getSearchKey());
        }
        queryWrapper.orderBy(BizPosition::getSortCode);
        return bizPositionService.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @SuppressWarnings("ALL")
    @Override
    public Page<BizUserRoleResult> roleSelector(BizUserSelectorRoleParam bizUserSelectorRoleParam) {
        // 校验数据范围
        List<String> loginUserDataScope = StpLoginUserUtil.getLoginUserDataScope();
        if (ObjectUtil.isNotEmpty(loginUserDataScope)) {
            if (ObjectUtil.isNotEmpty(bizUserSelectorRoleParam.getOrgId())) {
                if (loginUserDataScope.contains(bizUserSelectorRoleParam.getOrgId())) {
                    return BeanUtil.toBean(sysRoleApi.roleSelector(bizUserSelectorRoleParam.getOrgId(), bizUserSelectorRoleParam.getCategory(),
                            bizUserSelectorRoleParam.getSearchKey(), loginUserDataScope, true), Page.class);
                } else {
                    return new Page<>();
                }
            } else {
                if (ObjectUtil.isNotEmpty(bizUserSelectorRoleParam.getCategory()) & BizRoleCategoryEnum.GLOBAL.getValue().equals(bizUserSelectorRoleParam.getCategory())) {
                    // 查询系统级别的
                    return BeanUtil.toBean(sysRoleApi.roleSelector(null, bizUserSelectorRoleParam.getCategory(),
                            bizUserSelectorRoleParam.getSearchKey(), null, true), Page.class);
                } else {
                    return BeanUtil.toBean(sysRoleApi.roleSelector(null, bizUserSelectorRoleParam.getCategory(),
                            bizUserSelectorRoleParam.getSearchKey(), loginUserDataScope, true), Page.class);
                }
            }
        } else {
            return new Page<>();
        }
    }

    @Override
    public Page<BizUser> userSelector(BizUserSelectorUserParam bizUserSelectorUserParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        // 校验数据范围
        List<String> loginUserDataScope = StpLoginUserUtil.getLoginUserDataScope();
        if (ObjectUtil.isNotEmpty(loginUserDataScope)) {
            queryWrapper.in(BizUser::getOrgId, loginUserDataScope);
        } else {
            return new Page<>();
        }
        // 只查询部分字段
        queryWrapper.select(BizUser::getId, BizUser::getAvatar, BizUser::getOrgId, BizUser::getPositionId, BizUser::getAccount,
                BizUser::getName, BizUser::getSortCode, BizUser::getGender, BizUser::getEntryDate);
        if (ObjectUtil.isNotEmpty(bizUserSelectorUserParam.getOrgId())) {
            // 如果机构id不为空，则查询该机构及其子机构下的所有人
            List<String> childOrgIdList = CollStreamUtil.toList(bizOrgService.getChildListById(bizOrgService
                    .getAllOrgList(), bizUserSelectorUserParam.getOrgId(), true), BizOrg::getId);
            if (ObjectUtil.isNotEmpty(childOrgIdList)) {
                queryWrapper.in(BizUser::getOrgId, childOrgIdList);
            } else {
                return new Page<>();
            }
        }
        if (ObjectUtil.isNotEmpty(bizUserSelectorUserParam.getSearchKey())) {
            queryWrapper.like(BizUser::getName, bizUserSelectorUserParam.getSearchKey());
        }
        queryWrapper.orderBy(BizUser::getSortCode);
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }
}

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
package com.fliad.sys.modular.index.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fliad.sys.modular.index.param.*;
import com.fliad.sys.modular.index.result.*;
import com.mybatisflex.core.query.QueryWrapper;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import com.fliad.auth.api.AuthApi;
import com.fliad.dev.api.DevApi;
import com.fliad.auth.core.pojo.SaBaseLoginUser;
import com.fliad.auth.core.util.StpLoginUserUtil;
import com.fliad.common.pojo.CommonValidList;
import com.fliad.dev.api.DevLogApi;
import com.fliad.dev.api.DevMessageApi;
import com.fliad.dev.api.DevSseApi;
import com.fliad.sys.modular.index.service.SysIndexService;
import com.fliad.sys.modular.org.service.SysOrgService;
import com.fliad.sys.modular.position.service.SysPositionService;
import com.fliad.sys.modular.relation.entity.SysRelation;
import com.fliad.sys.modular.relation.enums.SysRelationCategoryEnum;
import com.fliad.sys.modular.relation.service.SysRelationService;
import com.fliad.sys.modular.role.service.SysRoleService;
import com.fliad.sys.modular.user.service.SysUserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统首页Service接口实现类
 *
 * @author xuyuxiang
 * @date 2022/9/2 10:45
 */
@Component
public class SysIndexServiceImpl implements SysIndexService {

    @Inject
    private SysRelationService sysRelationService;

    @Inject
    private DevMessageApi devMessageApi;

    @Inject
    private DevLogApi devLogApi;

    @Inject
    private DevSseApi devSseApi;

    @Inject
    private SysUserService sysUserService;

    @Inject
    private SysRoleService sysRoleService;

    @Inject
    private SysOrgService sysOrgService;

    @Inject
    private SysPositionService sysPositionService;

    @Inject
    private DevApi devApi;

    @Inject
    private AuthApi authApi;

    @Override
    public void addSchedule(SysIndexScheduleAddParam sysIndexScheduleAddParam) {
        SaBaseLoginUser loginUser = StpLoginUserUtil.getLoginUser();
        sysIndexScheduleAddParam.setScheduleUserId(loginUser.getId());
        sysIndexScheduleAddParam.setScheduleUserName(loginUser.getName());
        sysRelationService.saveRelationWithAppend(loginUser.getId(), sysIndexScheduleAddParam.getScheduleDate(),
                SysRelationCategoryEnum.SYS_USER_SCHEDULE_DATA.getValue(), JSONUtil.toJsonStr(sysIndexScheduleAddParam));
    }

    @Override
    public void deleteSchedule(CommonValidList<SysIndexScheduleIdParam> sysIndexScheduleIdParamList) {
        List<String> scheduleIdList = sysIndexScheduleIdParamList.stream().map(SysIndexScheduleIdParam::getId)
                .collect(Collectors.toList());
        if(ObjectUtil.isNotEmpty(scheduleIdList)) {
            sysRelationService.removeByIds(scheduleIdList);
        }
    }

    @Override
    public List<SysIndexScheduleListResult> scheduleList(SysIndexScheduleListParam sysIndexScheduleListParam) {
        return sysRelationService.list(new QueryWrapper().eq(SysRelation::getObjectId, StpUtil.getLoginIdAsString())
                .eq(SysRelation::getTargetId, sysIndexScheduleListParam.getScheduleDate())
                .eq(SysRelation::getCategory, SysRelationCategoryEnum.SYS_USER_SCHEDULE_DATA.getValue()))
                .stream().map(sysRelation -> {
                    SysIndexScheduleListResult sysIndexScheduleListResult = JSONUtil.toBean(sysRelation.getExtJson(), SysIndexScheduleListResult.class);
                    sysIndexScheduleListResult.setId(sysRelation.getId());
                    return sysIndexScheduleListResult;
                }).collect(Collectors.toList());
    }

    @Override
    public List<SysIndexMessageListResult> messageList(SysIndexMessageListParam sysIndexMessageListParam) {
        return devMessageApi.list(CollectionUtil.newArrayList(StpUtil.getLoginIdAsString()),
                ObjectUtil.isEmpty(sysIndexMessageListParam.getLimit())?10:sysIndexMessageListParam.getLimit()).stream()
                .map(jsonObject -> JSONUtil.toBean(jsonObject, SysIndexMessageListResult.class)).collect(Collectors.toList());
    }

    @Override
    public SysIndexMessageDetailResult messageDetail(SysIndexMessageIdParam sysIndexMessageIdParam) {
        return JSONUtil.toBean(devMessageApi.detail(sysIndexMessageIdParam.getId()), SysIndexMessageDetailResult.class);
    }

    @Override
    public void allMessageMarkRead(){
        devMessageApi.allMessageMarkRead();
    }

    @Override
    public List<SysIndexVisLogListResult> visLogList() {
        return devLogApi.currentUserVisLogList().stream()
                .map(jsonObject -> JSONUtil.toBean(jsonObject, SysIndexVisLogListResult.class)).collect(Collectors.toList());
    }

    @Override
    public List<SysIndexOpLogListResult> opLogList() {
        return devLogApi.currentUserOpLogList().stream()
                .map(jsonObject -> JSONUtil.toBean(jsonObject, SysIndexOpLogListResult.class)).collect(Collectors.toList());
    }

//    @Override
//    public SseEmitter createSseConnect(String clientId){
//        Consumer<CommonSseParam> consumer = m -> {
//            //获取用户未读消息
//            long unreadMessageNum = devMessageApi.unreadCount(m.getLoginId());
//            //发送消息
//            devSseApi.sendMessageToOneClient(m.getClientId(), String.valueOf(unreadMessageNum));
//        };
//        return devSseApi.createSseConnect(clientId,true,false,consumer);
//    }

    @Override
    public SysBizDataCountResult getBizDataCount() {
        SysBizDataCountResult result = new SysBizDataCountResult();
        result.setUserCount(sysUserService.count());
        result.setRoleCount(sysRoleService.count());
        result.setOrgCount(sysOrgService.count());
        result.setPositionCount(sysPositionService.count());
        return result;
    }

    @Override
    public SysOpDataCountResult getOpDataCount() {
        JSONObject devObj = devApi.getDevOpCount();
        SysOpDataCountResult result = BeanUtil.toBean(devObj, SysOpDataCountResult.class);
        JSONObject authObj = authApi.getUserSessionCount();
        result.setBackUserSessionCount(authObj.getLong("backUserSessionCount"));
        result.setClientUserSessionCount(authObj.getLong("clientUserSessionCount"));
        result.setThirdUserCount(authApi.getThirdUserCount());
        return result;
    }

    @Override
    public SysToolDataCountResult getToolDataCount() {
        return BeanUtil.toBean(devApi.getToolDataCount(), SysToolDataCountResult.class);
    }
}

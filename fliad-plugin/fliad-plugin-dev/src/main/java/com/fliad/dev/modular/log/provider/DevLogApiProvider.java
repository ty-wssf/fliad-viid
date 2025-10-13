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
package com.fliad.dev.modular.log.provider;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mybatisflex.core.query.QueryWrapper;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import com.fliad.auth.core.util.StpLoginUserUtil;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.dev.api.DevLogApi;
import com.fliad.dev.modular.log.entity.DevLog;
import com.fliad.dev.modular.log.enums.DevLogCategoryEnum;
import com.fliad.dev.modular.log.service.DevLogService;
import com.fliad.dev.modular.log.util.DevLogUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 日志API接口实现类
 *
 * @author xuyuxiang
 * @date 2022/9/2 16:07
 */
@Component
public class DevLogApiProvider implements DevLogApi {

    @Inject
    private DevLogService devLogService;

    @Override
    public void executeLoginLog(String userName) {
        DevLogUtil.executeLoginLog(userName);
    }

    @Override
    public void executeLogoutLog(String userName) {
        DevLogUtil.executeLogoutLog(userName);
    }

    @Override
    public List<JSONObject> currentUserVisLogList() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper
                .select(DevLog::getName, DevLog::getOpUser, DevLog::getOpTime, DevLog::getOpAddress, DevLog::getOpIp)
                .eq(DevLog::getOpUser, StpLoginUserUtil.getLoginUser().getName())
                .in(DevLog::getCategory, DevLogCategoryEnum.LOGIN.getValue(), DevLogCategoryEnum.LOGOUT.getValue())
                .orderBy(DevLog::getCreateTime);
        return devLogService.page(CommonPageRequest.defaultPage(), queryWrapper)
                .getRecords().stream().map(JSONUtil::parseObj).collect(Collectors.toList());
    }

    @Override
    public List<JSONObject> currentUserOpLogList() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper
                .select(DevLog::getName, DevLog::getOpUser, DevLog::getOpTime, DevLog::getOpAddress, DevLog::getOpIp)
                .eq(DevLog::getOpUser, StpLoginUserUtil.getLoginUser().getName())
                .in(DevLog::getCategory, DevLogCategoryEnum.OPERATE.getValue(), DevLogCategoryEnum.EXCEPTION.getValue())
                .orderBy(DevLog::getCreateTime);

        return devLogService.page(CommonPageRequest.defaultPage(), queryWrapper)
                .getRecords().stream().map(JSONUtil::parseObj).collect(Collectors.toList());
    }
}

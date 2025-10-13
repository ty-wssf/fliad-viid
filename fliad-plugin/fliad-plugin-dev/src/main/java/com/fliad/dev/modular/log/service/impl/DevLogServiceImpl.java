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
package com.fliad.dev.modular.log.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import org.noear.solon.annotation.Component;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.dev.modular.log.entity.DevLog;
import com.fliad.dev.modular.log.enums.DevLogCategoryEnum;
import com.fliad.dev.modular.log.mapper.DevLogMapper;
import com.fliad.dev.modular.log.param.DevLogDeleteParam;
import com.fliad.dev.modular.log.param.DevLogPageParam;
import com.fliad.dev.modular.log.result.DevLogOpBarChartDataResult;
import com.fliad.dev.modular.log.result.DevLogOpPieChartDataResult;
import com.fliad.dev.modular.log.result.DevLogVisLineChartDataResult;
import com.fliad.dev.modular.log.result.DevLogVisPieChartDataResult;
import com.fliad.dev.modular.log.service.DevLogService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 日志Service接口实现类
 *
 * @author xuyuxiang
 * @date 2022/9/2 15:05
 */
@Component
public class DevLogServiceImpl extends ServiceImpl<DevLogMapper, DevLog> implements DevLogService {

    @Override
    public Page<DevLog> page(DevLogPageParam devLogPageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        // page查询中排除较大的字段（提升查询速度）
        queryWrapper.select(DevLog::getId, DevLog::getCategory, DevLog::getName, DevLog::getExeStatus, DevLog::getOpIp, DevLog::getOpAddress, DevLog::getOpBrowser, DevLog::getMethodName, DevLog::getOpOs, DevLog::getClassName, DevLog::getReqMethod, DevLog::getReqUrl, DevLog::getOpTime, DevLog::getOpUser, DevLog::getCreateTime, DevLog::getUpdateTime, DevLog::getOpBrowser, DevLog::getCreateUser, DevLog::getUpdateUser);
        if (ObjectUtil.isNotEmpty(devLogPageParam.getCategory())) {
            queryWrapper.eq(DevLog::getCategory, devLogPageParam.getCategory());
        }
        if (ObjectUtil.isNotEmpty(devLogPageParam.getSearchKey())) {
            queryWrapper.like(DevLog::getName, devLogPageParam.getSearchKey());
        }
        if (ObjectUtil.isAllNotEmpty(devLogPageParam.getSortField(), devLogPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(devLogPageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(devLogPageParam.getSortField()), devLogPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy(DevLog::getOpTime, false);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Override
    public void delete(DevLogDeleteParam devLogDeleteParam) {
        this.remove(new QueryWrapper().eq(DevLog::getCategory, devLogDeleteParam.getCategory()));
    }

    @Override
    public List<DevLogVisLineChartDataResult> visLogLineChartData() {
        DateTime lastWeek = DateUtil.lastWeek();
        DateTime now = DateTime.now();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.in(DevLog::getCategory, DevLogCategoryEnum.LOGIN.getValue(), DevLogCategoryEnum.LOGOUT.getValue())
                .between(DevLog::getOpTime, lastWeek, now).orderBy(DevLog::getOpTime);
        Map<String, List<JSONObject>> listMap = this.list(queryWrapper)
                .stream().map(devLog -> JSONUtil.parseObj(devLog).set("date", DateUtil.formatDate(devLog.getOpTime())))
                .collect(Collectors.groupingBy(jsonObject -> jsonObject.getStr("date")));
        long between = DateUtil.between(lastWeek, now, DateUnit.DAY);
        List<DevLogVisLineChartDataResult> resultList = CollectionUtil.newArrayList();
        for (int i = 1; i <= between; i++) {
            DevLogVisLineChartDataResult devLogVisLineChartDataResult = new DevLogVisLineChartDataResult();
            String date = DateUtil.formatDate(DateUtil.offsetDay(lastWeek, i));
            devLogVisLineChartDataResult.setDate(date);
            List<JSONObject> jsonObjectList = listMap.get(date);
            if (ObjectUtil.isNotEmpty(jsonObjectList)) {
                devLogVisLineChartDataResult.setLoginCount(jsonObjectList.stream().filter(jsonObject -> jsonObject.getStr("category")
                        .equals(DevLogCategoryEnum.LOGIN.getValue())).count());
                devLogVisLineChartDataResult.setLogoutCount(jsonObjectList.stream().filter(jsonObject -> jsonObject.getStr("category")
                        .equals(DevLogCategoryEnum.LOGOUT.getValue())).count());
            } else {
                devLogVisLineChartDataResult.setLoginCount(0L);
                devLogVisLineChartDataResult.setLogoutCount(0L);
            }
            resultList.add(devLogVisLineChartDataResult);
        }
        return resultList;
    }

    @Override
    public List<DevLogVisPieChartDataResult> visLogPieChartData() {
        List<DevLogVisPieChartDataResult> resultList = CollectionUtil.newArrayList();
        DevLogVisPieChartDataResult devLogLoginPieChartDataResult = new DevLogVisPieChartDataResult();
        devLogLoginPieChartDataResult.setType("登录");
        devLogLoginPieChartDataResult.setValue(this.count(new QueryWrapper()
                .eq(DevLog::getCategory, DevLogCategoryEnum.LOGIN.getValue())));
        resultList.add(devLogLoginPieChartDataResult);

        DevLogVisPieChartDataResult devLogLogoutPieChartDataResult = new DevLogVisPieChartDataResult();
        devLogLogoutPieChartDataResult.setType("登出");
        devLogLogoutPieChartDataResult.setValue(this.count(new QueryWrapper()
                .eq(DevLog::getCategory, DevLogCategoryEnum.LOGOUT.getValue())));
        resultList.add(devLogLogoutPieChartDataResult);
        return resultList;
    }

    @Override
    public List<DevLogOpBarChartDataResult> opLogBarChartData() {
        DateTime lastWeek = DateUtil.lastWeek();
        DateTime now = DateTime.now();
        QueryWrapper queryWrapper = QueryWrapper.create();
        queryWrapper
                .select(DevLog::getId,DevLog::getName,DevLog::getOpIp,DevLog::getOpAddress,DevLog::getCategory,DevLog::getClassName,DevLog::getMethodName,DevLog::getOpTime,DevLog::getOpUser)
                .in(DevLog::getCategory, DevLogCategoryEnum.OPERATE.getValue(), DevLogCategoryEnum.EXCEPTION.getValue()).between(DevLog::getOpTime, lastWeek, now)
                .orderBy(DevLog::getOpTime);
        Map<String, List<JSONObject>> listMap = this.list(queryWrapper)
                .stream().map(devLog -> JSONUtil.parseObj(devLog).set("date", DateUtil.formatDate(devLog.getOpTime())))
                .collect(Collectors.groupingBy(jsonObject -> jsonObject.getStr("date")));
        long between = DateUtil.between(lastWeek, now, DateUnit.DAY);
        List<DevLogOpBarChartDataResult> resultList = CollectionUtil.newArrayList();
        for (int i = 1; i <= between; i++) {
            String date = DateUtil.formatDate(DateUtil.offsetDay(lastWeek, i));
            DevLogOpBarChartDataResult devLogOperateBarChartDataResult = new DevLogOpBarChartDataResult();
            devLogOperateBarChartDataResult.setDate(date);
            devLogOperateBarChartDataResult.setName("操作日志");
            DevLogOpBarChartDataResult devLogExceptionBarChartDataResult = new DevLogOpBarChartDataResult();
            devLogExceptionBarChartDataResult.setDate(date);
            devLogExceptionBarChartDataResult.setName("异常日志");
            List<JSONObject> jsonObjectList = listMap.get(date);
            if (ObjectUtil.isNotEmpty(jsonObjectList)) {
                devLogOperateBarChartDataResult.setCount(jsonObjectList.stream().filter(jsonObject -> jsonObject.getStr("category")
                        .equals(DevLogCategoryEnum.OPERATE.getValue())).count());
                devLogExceptionBarChartDataResult.setCount(jsonObjectList.stream().filter(jsonObject -> jsonObject.getStr("category")
                        .equals(DevLogCategoryEnum.EXCEPTION.getValue())).count());
            } else {
                devLogOperateBarChartDataResult.setCount(0L);
                devLogExceptionBarChartDataResult.setCount(0L);
            }
            resultList.add(devLogOperateBarChartDataResult);
            resultList.add(devLogExceptionBarChartDataResult);
        }
        return resultList;
    }

    @Override
    public List<DevLogOpPieChartDataResult> opLogPieChartData() {
        List<DevLogOpPieChartDataResult> resultList = CollectionUtil.newArrayList();
        DevLogOpPieChartDataResult devLogOperatePieChartDataResult = new DevLogOpPieChartDataResult();
        devLogOperatePieChartDataResult.setType("操作日志");
        devLogOperatePieChartDataResult.setValue(this.count(new QueryWrapper()
                .eq(DevLog::getCategory, DevLogCategoryEnum.OPERATE.getValue())));
        resultList.add(devLogOperatePieChartDataResult);

        DevLogOpPieChartDataResult devLogExceptionPieChartDataResult = new DevLogOpPieChartDataResult();
        devLogExceptionPieChartDataResult.setType("异常日志");
        devLogExceptionPieChartDataResult.setValue(this.count(new QueryWrapper()
                .eq(DevLog::getCategory, DevLogCategoryEnum.EXCEPTION.getValue())));
        resultList.add(devLogExceptionPieChartDataResult);
        return resultList;
    }
}

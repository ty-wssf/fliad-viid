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
package com.fliad.dev.core.listener;

import cn.hutool.cron.CronUtil;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.event.AppLoadEndEvent;
import org.noear.solon.core.event.EventListener;
import com.fliad.common.exception.CommonException;
import com.fliad.common.timer.CommonTimerTaskRunner;
import com.fliad.dev.modular.job.entity.DevJob;
import com.fliad.dev.modular.job.enums.DevJobStatusEnum;
import com.fliad.dev.modular.job.service.DevJobService;

/**
 * 定时任务监听器，系统启动时将定时任务启动
 *
 * @author xuyuxiang
 * @date 2022/8/5 16:07
 **/
@Slf4j
@Component
public class DevJobListener implements EventListener<AppLoadEndEvent> {

    @Inject
    DevJobService devJobService;

    @Override
    public void onEvent(AppLoadEndEvent appLoadEndEvent) throws Throwable {
//        QueryWrapper queryWrapper = QueryWrapper.create(new QueryWrapper()
//                .eq(DevJob::getJobStatus, DevJobStatusEnum.RUNNING.getValue()).orderBy(DevJob::getSortCode));
        QueryWrapper eq = new QueryWrapper().eq(DevJob::getJobStatus, DevJobStatusEnum.RUNNING.getValue());
        eq.orderBy(DevJob::getSortCode);
        devJobService.list(eq)
                .forEach(devJob -> CronUtil.schedule(devJob.getId(), devJob.getCronExpression(), () -> {
                    try {
                        // 运行定时任务
                        ((CommonTimerTaskRunner) Solon.context().getBean(Class.forName(devJob.getActionClass()))).action(devJob.getExtJson());
                    } catch (ClassNotFoundException e) {
                        throw new CommonException("定时任务找不到对应的类，名称为：{}", devJob.getActionClass());
                    }
                }));
        // 设置秒级别的启用
        CronUtil.setMatchSecond(true);
        // 启动定时器执行器
        CronUtil.restart();
    }
}

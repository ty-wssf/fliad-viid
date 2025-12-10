package com.fliad.resource.modular.datasource.handler;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import com.fliad.resource.modular.flowgram.domain.TaskRunInput;
import com.fliad.resource.modular.flowgram.service.FlowgramService;
import com.fliad.resource.modular.workflow.entity.ResourceWorkflow;
import com.fliad.resource.modular.workflow.service.ResourceWorkflowService;
import org.noear.solon.annotation.Inject;
import org.noear.solon.expression.snel.SnEL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 通用消息处理器
 *
 * @author wyl
 * @date 2025/09/25 10:00
 */
public class MessageProcessor {
    private static final Logger log = LoggerFactory.getLogger(MessageProcessor.class);

    @Inject
    private ResourceWorkflowService workflowService;

    @Inject
    private FlowgramService flowgramService;

    /**
     * 处理接收到的消息
     *
     * @param message    消息内容
     * @param datasource 数据源实体
     * @param scriptFilter 脚本过滤器
     */
    public void processMessage(String message, DatasourceInfo datasource, String scriptFilter) {
        try {
            // 如果有脚本过滤器，先执行过滤
            if (scriptFilter != null && !scriptFilter.trim().isEmpty()) {
                Map<String, Object> context = org.noear.snack.ONode.deserialize(message);
                Object result = SnEL.eval(scriptFilter, context);
                // 如果result是布尔类型
                if (result instanceof Boolean) {
                    if ((Boolean) result) {
                        // 过滤器返回true，继续处理消息
                        doProcessMessage(message, datasource);
                    } else {
                        log.info("脚本过滤器结果为false，不处理消息，数据源ID：{}", datasource.getId());
                    }
                } else {
                    log.warn("脚本过滤器结果不是布尔类型，数据源ID：{}", datasource.getId());
                    // 不是布尔类型，默认继续处理
                    doProcessMessage(message, datasource);
                }
            } else {
                // 没有过滤器，直接处理消息
                doProcessMessage(message, datasource);
            }
        } catch (Exception e) {
            log.error("处理消息时发生错误，数据源ID：{}，订阅类别：{}", datasource.getId(), datasource.getSubscribeDetail(), e);
        }
    }

    /**
     * 实际处理消息的方法
     *
     * @param message    消息内容
     * @param datasource 数据源信息
     */
    private void doProcessMessage(String message, DatasourceInfo datasource) {
        try {
            log.debug("开始处理消息，数据源ID：{}，订阅类别：{}", datasource.getId(), datasource.getSubscribeDetail());

            // 根据订阅类别处理数据
            String subscribeDetail = datasource.getSubscribeDetail();

            // 处理数据
            processDataBySubscribeDetail(message, subscribeDetail);
        } catch (Exception e) {
            log.error("处理消息时发生错误，数据源ID：{}，订阅类别：{}", datasource.getId(), datasource.getSubscribeDetail(), e);
        }
    }

    /**
     * 根据订阅类别处理数据
     *
     * @param message         消息内容
     * @param subscribeDetail 订阅详情
     */
    private void processDataBySubscribeDetail(String message, String subscribeDetail) {
        try {
            log.debug("开始处理数据，订阅类别：{}", subscribeDetail);

            // 获取对应的工作流
            List<ResourceWorkflow> workflowList = workflowService.findBySubscribeDetail(subscribeDetail);
            log.debug("找到 {} 个工作流处理数据", workflowList.size());

            // 如果没有找到处理流程，打印提示信息
            if (workflowList.isEmpty()) {
                log.warn("未找到处理流程，订阅类别：{}", subscribeDetail);
                return;
            }

            // 执行工作流
            for (ResourceWorkflow workflow : workflowList) {
                TaskRunInput taskRunInput = new TaskRunInput();
                taskRunInput.setSchema(workflow.getContent());
                taskRunInput.setInputs(MapUtil.of("inputs", message));
                flowgramService.taskRun(false, taskRunInput, IdUtil.getSnowflakeNextIdStr());
            }
        } catch (Exception e) {
            log.error("处理数据时发生错误，订阅类别：{}", subscribeDetail, e);
            throw new RuntimeException(e);
        }
    }
}
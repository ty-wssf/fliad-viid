package com.fliad.resource.modular.datasource.handler;

import cn.hutool.core.util.StrUtil;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import com.fliad.resource.modular.datasource.entity.ResourceDatasource;
import org.noear.snack.ONode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Cron数据源处理器
 *
 * @author wyl
 * @date 2025/09/25 10:00
 */
public class CronDatasourceHandler implements DatasourceHandler {
    private static final Logger log = LoggerFactory.getLogger(CronDatasourceHandler.class);

    // 存储定时任务信息
    private final Map<String, String> datasourceCronTaskIds = new ConcurrentHashMap<>();
    
    private final MessageProcessor messageProcessor = new MessageProcessor();

    @Override
    public void initConnection(ResourceDatasource datasource) {
        initCronConnection(datasource);
    }

    @Override
    public void closeConnection(String datasourceId) {
        // 取消定时任务
        String taskId = datasourceCronTaskIds.get(datasourceId);
        if (taskId != null) {
            try {
                CronUtil.remove(taskId);
                log.info("取消Cron定时任务，数据源ID：{}", datasourceId);
            } catch (Exception e) {
                log.error("取消Cron定时任务时发生错误，数据源ID：{}", datasourceId, e);
            }
        }
        
        datasourceCronTaskIds.remove(datasourceId);
    }

    @Override
    public String getSupportedType() {
        return "cron";
    }

    /**
     * 初始化 Cron 定时任务连接
     *
     * @param datasource 数据源实体
     */
    private void initCronConnection(ResourceDatasource datasource) {
        try {
            // 解析 Cron 配置
            String content = datasource.getContent();
            if (StrUtil.isBlank(content)) {
                log.warn("数据源配置内容为空，数据源ID：{}", datasource.getId());
                return;
            }

            ONode config = ONode.load(handleEscapeCharacters(content));
            String cronExpression = config.get("cronExpression").getString();
            String payload = config.get("payload").getString();

            // 如果没有配置消息内容，则使用默认消息
            if (StrUtil.isBlank(payload)) {
                payload = "{}";
            }

            log.info("Cron配置信息：cronExpression={}, payload={}", cronExpression, payload);

            // 使用 Hutool 的 CronUtil 来创建定时任务
            String finalPayload = payload;
            String taskId = CronUtil.schedule(datasource.getId(), cronExpression, new Task() {
                @Override
                public void execute() {
                    log.info("执行定时任务，数据源ID：{}，订阅类别：{}", datasource.getId(), datasource.getSubscribeDetail());
                    try {
                        // 构造数据源信息对象
                        DatasourceInfo datasourceInfo = new DatasourceInfo(
                                datasource.getId(),
                                datasource.getTitle(),
                                datasource.getType(),
                                datasource.getSubscribeDetail(),
                                datasource.getContent(),
                                datasource.getScriptFilter()
                        );
                        
                        // 处理定时任务触发
                        messageProcessor.processMessage(finalPayload, datasourceInfo, datasource.getScriptFilter());
                    } catch (Exception e) {
                        log.error("处理定时任务消息失败，数据源ID：{}", datasource.getId(), e);
                    }
                }
            });

            // 将定时任务ID存储起来，便于后续管理和停止
            datasourceCronTaskIds.put(datasource.getId(), taskId);

            log.info("Cron 数据源初始化完成，数据源ID：{}，定时任务ID：{}", datasource.getId(), taskId);
        } catch (Exception e) {
            log.error("解析 Cron 配置失败，数据源ID：{}", datasource.getId(), e);
        }
    }

    /**
     * 处理字符串中的转义字符
     *
     * @param jsonStr 包含可能转义字符的JSON字符串
     * @return 处理后的JSON字符串
     */
    private String handleEscapeCharacters(String jsonStr) {
        if (jsonStr == null || jsonStr.isEmpty()) {
            return jsonStr;
        }

        // 先尝试直接解析
        if (isValidJson(jsonStr)) {
            return jsonStr;
        }

        // 尝试不同的策略来修复转义字符
        String[] strategies = {
                jsonStr.replace("\\\"", "\""),           // 将 \" 替换为 "
                jsonStr.replace("\\\\", "\\"),           // 将 \\ 替换为 \
                jsonStr.replace("\\\"", "\"").replace("\\\\", "\\"),  // 组合策略1
                jsonStr.replace("\\\\\"", "\"").replace("\\\\'", "'"), // 组合策略2
        };

        // 尝试每种策略，找到第一个能生成有效JSON的
        for (String strategy : strategies) {
            if (isValidJson(strategy)) {
                return strategy;
            }
        }

        // 如果所有策略都失败，返回原始字符串
        return jsonStr;
    }

    /**
     * 检查字符串是否为有效的JSON
     *
     * @param jsonStr 待检查的字符串
     * @return 是否为有效的JSON
     */
    private boolean isValidJson(String jsonStr) {
        try {
            ONode.loadStr(jsonStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
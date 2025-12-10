package com.fliad.resource.modular.datasource.service.impl;

import com.fliad.resource.modular.datasource.entity.ResourceDatasource;
import com.fliad.resource.modular.datasource.service.ResourceDatasourceService;
import com.fliad.resource.modular.datasource.handler.DatasourceHandlerManager;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据源初始化运行器
 * 服务启动时初始化数据源，根据订阅类别来订阅数据
 *
 * @author wyl
 * @date 2025/09/25 10:00
 */
@Component
public class ResourceDatasourceInitRunner implements LifecycleBean {
    private static final Logger log = LoggerFactory.getLogger(ResourceDatasourceInitRunner.class);

    @Inject
    private ResourceDatasourceService viidDatasourceService;

    // 存储已初始化的数据源信息，用于关闭时使用
    private final Map<String, String> initializedDatasources = new ConcurrentHashMap<>();

    @Override
    public void start() throws Throwable {
        log.info(">>> 开始初始化数据源 <<<");
        try {
            // 获取所有启用的数据源
            List<ResourceDatasource> enabledDatasources = viidDatasourceService.listByStatus("ENABLE");
            if (enabledDatasources != null && !enabledDatasources.isEmpty()) {
                log.info("找到 {} 个启用的数据源，开始初始化", enabledDatasources.size());
                for (ResourceDatasource datasource : enabledDatasources) {
                    try {
                        // 根据数据源类型和订阅类别初始化连接
                        initDatasourceConnection(datasource);
                        // 记录已初始化的数据源，用于关闭时使用
                        initializedDatasources.put(datasource.getId(), datasource.getType());
                    } catch (Exception e) {
                        log.error("初始化数据源失败，数据源ID：{}，标题：{}", datasource.getId(), datasource.getTitle(), e);
                    }
                }
            } else {
                log.info("未找到启用的数据源");
            }
            log.info(">>> 数据源初始化完成 <<<");
        } catch (Exception e) {
            log.error("数据源初始化过程中发生错误", e);
        }
    }

    /**
     * 根据数据源类型和订阅类别初始化连接
     *
     * @param datasource 数据源实体
     */
    private void initDatasourceConnection(ResourceDatasource datasource) {
        log.info("开始初始化数据源，ID：{}，标题：{}，类型：{}，订阅类别：{}",
                datasource.getId(), datasource.getTitle(), datasource.getType(), datasource.getSubscribeDetail());

        // 使用处理器管理器处理不同类型的连接
        DatasourceHandlerManager.getInstance().initConnection(datasource);
    }

    @Override
    public void stop() throws Throwable {
        log.info(">>> 关闭数据源连接 <<<");

        // 关闭所有已初始化的数据源连接
        for (Map.Entry<String, String> entry : initializedDatasources.entrySet()) {
            try {
                String datasourceId = entry.getKey();
                String type = entry.getValue();
                DatasourceHandlerManager.getInstance().closeConnection(type, datasourceId);
                log.info("关闭数据源连接，数据源ID：{}，类型：{}", datasourceId, type);
            } catch (Exception e) {
                log.error("关闭数据源连接时发生错误，数据源ID：{}", entry.getKey(), e);
            }
        }

        initializedDatasources.clear();
        log.info(">>> 数据源连接关闭完成 <<<");
    }
}
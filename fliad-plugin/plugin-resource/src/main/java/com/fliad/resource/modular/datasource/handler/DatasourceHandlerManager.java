package com.fliad.resource.modular.datasource.handler;

import com.fliad.resource.modular.datasource.entity.ResourceDatasource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * 数据源处理器管理器
 *
 * @author wyl
 * @date 2025/09/25 10:00
 */
public class DatasourceHandlerManager {
    private static final Logger log = LoggerFactory.getLogger(DatasourceHandlerManager.class);

    private static DatasourceHandlerManager instance;
    
    private final Map<String, DatasourceHandler> handlers = new HashMap<>();

    private DatasourceHandlerManager() {
        loadHandlers();
    }

    public static synchronized DatasourceHandlerManager getInstance() {
        if (instance == null) {
            instance = new DatasourceHandlerManager();
        }
        return instance;
    }

    /**
     * 加载所有数据源处理器
     */
    private void loadHandlers() {
        ServiceLoader<DatasourceHandler> loader = ServiceLoader.load(DatasourceHandler.class);
        for (DatasourceHandler handler : loader) {
            handlers.put(handler.getSupportedType(), handler);
            log.info("加载数据源处理器: {}", handler.getSupportedType());
        }
    }

    /**
     * 获取指定类型的数据源处理器
     *
     * @param type 数据源类型
     * @return 数据源处理器
     */
    public DatasourceHandler getHandler(String type) {
        return handlers.get(type);
    }

    /**
     * 初始化数据源连接
     *
     * @param datasource 数据源实体
     */
    public void initConnection(ResourceDatasource datasource) {
        DatasourceHandler handler = getHandler(datasource.getType());
        if (handler != null) {
            handler.initConnection(datasource);
        } else {
            log.warn("未找到支持的数据源类型处理器: {}", datasource.getType());
        }
    }

    /**
     * 关闭数据源连接
     *
     * @param type 数据源类型
     * @param datasourceId 数据源ID
     */
    public void closeConnection(String type, String datasourceId) {
        DatasourceHandler handler = getHandler(type);
        if (handler != null) {
            handler.closeConnection(datasourceId);
        } else {
            log.warn("未找到支持的数据源类型处理器: {}", type);
        }
    }
}
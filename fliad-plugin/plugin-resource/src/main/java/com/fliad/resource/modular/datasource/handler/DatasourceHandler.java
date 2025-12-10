package com.fliad.resource.modular.datasource.handler;

import com.fliad.resource.modular.datasource.entity.ResourceDatasource;

/**
 * 数据源处理器接口
 *
 * @author wyl
 * @date 2025/09/25 10:00
 */
public interface DatasourceHandler {
    
    /**
     * 初始化数据源连接
     *
     * @param datasource 数据源实体
     */
    void initConnection(ResourceDatasource datasource);
    
    /**
     * 关闭数据源连接
     *
     * @param datasourceId 数据源ID
     */
    void closeConnection(String datasourceId);
    
    /**
     * 获取处理器支持的数据源类型
     *
     * @return 数据源类型
     */
    String getSupportedType();
}
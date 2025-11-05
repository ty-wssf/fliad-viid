package com.fliad.common.state.service;

/**
 * 服务启动器
 * 用于启动已停止的服务
 *
 * @author lingma
 * @date 2025/11/05
 */
public interface ServiceStarter {

    /**
     * 启动服务
     *
     * @param serviceName 服务名称
     * @throws Exception 启动过程中可能发生的异常
     */
    void startService(String serviceName) throws Exception;
}
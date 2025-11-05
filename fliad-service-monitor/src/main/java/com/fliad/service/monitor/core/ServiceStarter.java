package com.fliad.service.monitor.core;

/**
 * 服务启动器
 * 用于启动已停止的服务
 *
 * @author wyl
 * @date 2025年11月05日 21:15
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
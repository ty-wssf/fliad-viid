package com.fliad.service.monitor.core;

/**
 * 服务状态监听器
 * 用于监听服务运行状态
 *
 * @author wyl
 * @date 2025年11月05日 21:15
 */
public interface ServiceStateListener {

    /**
     * 检查服务是否正在运行
     *
     * @param serviceName 服务名称
     * @return true-正在运行，false-已停止
     */
    boolean isServiceRunning(String serviceName);
}
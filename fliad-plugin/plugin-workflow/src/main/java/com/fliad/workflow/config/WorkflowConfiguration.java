package com.fliad.workflow.config;

import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Bean;

/**
 * 工作流配置类
 *
 * @author fliad
 * @date 2025/11/27
 */
@Configuration
public class WorkflowConfiguration {
    
    /**
     * 配置 warm-flow 工作流引擎
     * 
     * @return 工作流引擎配置
     */
    @Bean
    public Object workflowEngine() {
        // TODO: 初始化 warm-flow 工作流引擎
        // 这里应该配置 warm-flow 引擎的相关参数
        System.out.println("Initializing warm-flow workflow engine");
        return new Object();
    }
}
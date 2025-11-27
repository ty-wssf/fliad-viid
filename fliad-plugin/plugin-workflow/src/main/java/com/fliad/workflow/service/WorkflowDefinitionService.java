package com.fliad.workflow.service;

import org.noear.solon.annotation.Component;

/**
 * 工作流定义服务接口
 *
 * @author fliad
 * @date 2025/11/27
 */
@Component
public interface WorkflowDefinitionService {
    
    /**
     * 部署流程定义
     * 
     * @param definitionXml 流程定义XML
     * @return 流程定义ID
     */
    String deployProcessDefinition(String definitionXml);
    
    /**
     * 启动流程实例
     * 
     * @param processDefinitionId 流程定义ID
     * @param businessKey 业务键
     * @param variables 流程变量
     * @return 流程实例ID
     */
    String startProcessInstance(String processDefinitionId, String businessKey, Object variables);
}
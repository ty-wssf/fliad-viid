package com.fliad.workflow.controller;

import com.fliad.workflow.service.WorkflowDefinitionService;
import com.fliad.workflow.service.WorkflowTaskService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

import java.util.List;

/**
 * 工作流控制器
 *
 * @author fliad
 * @date 2025/11/27
 */
@Controller
@Mapping("/workflow")
public class WorkflowController {
    
    @Inject
    private WorkflowDefinitionService workflowDefinitionService;
    
    @Inject
    private WorkflowTaskService workflowTaskService;
    
    /**
     * 部署流程定义
     */
    @Mapping("/deploy")
    public String deployProcessDefinition(String definitionXml) {
        return workflowDefinitionService.deployProcessDefinition(definitionXml);
    }
    
    /**
     * 启动流程实例
     */
    @Mapping("/start")
    public String startProcessInstance(String processDefinitionId, String businessKey, Object variables) {
        return workflowDefinitionService.startProcessInstance(processDefinitionId, businessKey, variables);
    }
    
    /**
     * 获取待办任务列表
     */
    @Mapping("/todo")
    public List<Object> getTodoTasks(String userId) {
        return workflowTaskService.getTodoTasks(userId);
    }
    
    /**
     * 获取已办任务列表
     */
    @Mapping("/done")
    public List<Object> getDoneTasks(String userId) {
        return workflowTaskService.getDoneTasks(userId);
    }
    
    /**
     * 获取抄送任务列表
     */
    @Mapping("/copy")
    public List<Object> getCopyTasks(String userId) {
        return workflowTaskService.getCopyTasks(userId);
    }
    
    /**
     * 完成任务
     */
    @Mapping("/complete")
    public void completeTask(String taskId, Object variables) {
        workflowTaskService.completeTask(taskId, variables);
    }
    
    /**
     * 驳回任务
     */
    @Mapping("/reject")
    public void rejectTask(String taskId, String targetNodeId, Object variables) {
        workflowTaskService.rejectTask(taskId, targetNodeId, variables);
    }
}
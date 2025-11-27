package com.fliad.workflow.service;

import org.noear.solon.annotation.Component;

import java.util.List;

/**
 * 工作流任务服务接口
 *
 * @author fliad
 * @date 2025/11/27
 */
@Component
public interface WorkflowTaskService {
    
    /**
     * 获取当前用户的待办任务列表
     * 
     * @param userId 用户ID
     * @return 待办任务列表
     */
    List<Object> getTodoTasks(String userId);
    
    /**
     * 获取当前用户的已办任务列表
     * 
     * @param userId 用户ID
     * @return 已办任务列表
     */
    List<Object> getDoneTasks(String userId);
    
    /**
     * 获取当前用户的抄送任务列表
     * 
     * @param userId 用户ID
     * @return 抄送任务列表
     */
    List<Object> getCopyTasks(String userId);
    
    /**
     * 完成任务
     * 
     * @param taskId 任务ID
     * @param variables 任务变量
     */
    void completeTask(String taskId, Object variables);
    
    /**
     * 驳回任务
     * 
     * @param taskId 任务ID
     * @param targetNodeId 目标节点ID
     * @param variables 任务变量
     */
    void rejectTask(String taskId, String targetNodeId, Object variables);
}
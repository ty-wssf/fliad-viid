package com.fliad.resource.modular.workflow.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import com.fliad.resource.modular.workflow.entity.ResourceWorkflow;
import com.fliad.resource.modular.workflow.param.ResourceWorkflowAddParam;
import com.fliad.resource.modular.workflow.param.ResourceWorkflowEditParam;
import com.fliad.resource.modular.workflow.param.ResourceWorkflowIdParam;
import com.fliad.resource.modular.workflow.param.ResourceWorkflowPageParam;

import java.util.List;

/**
 * 工作流Service接口
 *
 * @author wyl
 * @date 2025/08/27 14:03
 **/
public interface ResourceWorkflowService extends IService<ResourceWorkflow> {

    /**
     * 获取工作流分页
     *
     * @author wyl
     * @date 2025/08/27 14:03
     */
    Page<ResourceWorkflow> page(ResourceWorkflowPageParam viidWorkflowPageParam);

    /**
     * 添加工作流
     *
     * @author wyl
     * @date 2025/08/27 14:03
     */
    void add(ResourceWorkflowAddParam viidWorkflowAddParam);

    /**
     * 编辑工作流
     *
     * @author wyl
     * @date 2025/08/27 14:03
     */
    void edit(ResourceWorkflowEditParam viidWorkflowEditParam);

    /**
     * 删除工作流
     *
     * @author wyl
     * @date 2025/08/27 14:03
     */
    void delete(List<ResourceWorkflowIdParam> viidWorkflowIdParamList);

    /**
     * 获取工作流详情
     *
     * @author wyl
     * @date 2025/08/27 14:03
     */
    ResourceWorkflow detail(ResourceWorkflowIdParam viidWorkflowIdParam);

    /**
     * 获取工作流详情
     *
     * @author wyl
     * @date 2025/08/27 14:03
     */
    ResourceWorkflow queryEntity(String id);

    /**
     * 复制工作流
     *
     * @param viidWorkflowIdParam 工作流ID参数
     */
    void copy(ResourceWorkflowIdParam viidWorkflowIdParam);

    /**
     * 禁用工作流
     *
     * @param viidWorkflowIdParam
     */
    void disableWorkflow(ResourceWorkflowIdParam viidWorkflowIdParam);

    /**
     * 启用工作流
     *
     * @param viidWorkflowIdParam
     */
    void enableWorkflow(ResourceWorkflowIdParam viidWorkflowIdParam);

    /**
     * 根据订阅详情查找工作流
     *
     * @param subscribeDetail 订阅详情
     * @return 工作流列表
     */
    List<ResourceWorkflow> findBySubscribeDetail(String subscribeDetail);

    /**
     * 安装模板
     *
     * @param viidWorkflowIdParam 模板ID参数
     */
    void installTemplate(ResourceWorkflowIdParam viidWorkflowIdParam);

    /**
     * 获取模板列表
     *
     * @return 模板列表
     */
    List<ResourceWorkflow> listTemplates();
}
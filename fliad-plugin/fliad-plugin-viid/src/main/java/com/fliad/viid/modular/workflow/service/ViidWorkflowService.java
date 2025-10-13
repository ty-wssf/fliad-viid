/*
 * Copyright [2022] [https://www.xiaonuo.vip]
 *
 * Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：
 *
 * 1.请不要删除和修改根目录下的LICENSE文件。
 * 2.请不要删除和修改Snowy源码头部的版权声明。
 * 3.本项目代码可免费商业使用，商业使用请保留源码和相关描述文件的项目出处，作者声明等。
 * 4.分发源码时候，请注明软件出处 https://www.xiaonuo.vip
 * 5.不可二次分发开源参与同类竞品，如有想法可联系团队xiaonuobase@qq.com商议合作。
 * 6.若您的项目无法满足以上几点，需要更多功能代码，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package com.fliad.viid.modular.workflow.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import com.fliad.viid.modular.workflow.entity.ViidWorkflow;
import com.fliad.viid.modular.workflow.param.ViidWorkflowAddParam;
import com.fliad.viid.modular.workflow.param.ViidWorkflowEditParam;
import com.fliad.viid.modular.workflow.param.ViidWorkflowIdParam;
import com.fliad.viid.modular.workflow.param.ViidWorkflowPageParam;

import java.util.List;

/**
 * 工作流Service接口
 *
 * @author wyl
 * @date 2025/08/27 14:03
 **/
public interface ViidWorkflowService extends IService<ViidWorkflow> {

    /**
     * 获取工作流分页
     *
     * @author wyl
     * @date 2025/08/27 14:03
     */
    Page<ViidWorkflow> page(ViidWorkflowPageParam viidWorkflowPageParam);

    /**
     * 添加工作流
     *
     * @author wyl
     * @date 2025/08/27 14:03
     */
    void add(ViidWorkflowAddParam viidWorkflowAddParam);

    /**
     * 编辑工作流
     *
     * @author wyl
     * @date 2025/08/27 14:03
     */
    void edit(ViidWorkflowEditParam viidWorkflowEditParam);

    /**
     * 删除工作流
     *
     * @author wyl
     * @date 2025/08/27 14:03
     */
    void delete(List<ViidWorkflowIdParam> viidWorkflowIdParamList);

    /**
     * 获取工作流详情
     *
     * @author wyl
     * @date 2025/08/27 14:03
     */
    ViidWorkflow detail(ViidWorkflowIdParam viidWorkflowIdParam);

    /**
     * 获取工作流详情
     *
     * @author wyl
     * @date 2025/08/27 14:03
     */
    ViidWorkflow queryEntity(String id);

    /**
     * 复制工作流
     *
     * @param viidWorkflowIdParam 工作流ID参数
     */
    void copy(ViidWorkflowIdParam viidWorkflowIdParam);

    /**
     * 禁用工作流
     *
     * @param viidWorkflowIdParam
     */
    void disableWorkflow(ViidWorkflowIdParam viidWorkflowIdParam);

    /**
     * 启用工作流
     *
     * @param viidWorkflowIdParam
     */
    void enableWorkflow(ViidWorkflowIdParam viidWorkflowIdParam);

    /**
     * 根据订阅详情查找工作流
     *
     * @param subscribeDetail 订阅详情
     * @return 工作流列表
     */
    List<ViidWorkflow> findBySubscribeDetail(String subscribeDetail);

}

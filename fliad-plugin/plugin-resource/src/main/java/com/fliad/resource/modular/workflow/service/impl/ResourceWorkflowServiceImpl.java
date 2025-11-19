package com.fliad.resource.modular.workflow.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fliad.resource.modular.workflow.enums.ResourceWorkflowStatus;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.annotation.Tran;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.resource.modular.workflow.entity.ResourceWorkflow;
import com.fliad.resource.modular.workflow.mapper.ResourceWorkflowMapper;
import com.fliad.resource.modular.workflow.param.ResourceWorkflowAddParam;
import com.fliad.resource.modular.workflow.param.ResourceWorkflowEditParam;
import com.fliad.resource.modular.workflow.param.ResourceWorkflowIdParam;
import com.fliad.resource.modular.workflow.param.ResourceWorkflowPageParam;
import com.fliad.resource.modular.workflow.service.ResourceWorkflowService;
import org.noear.solon.data.cache.CacheService;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * 工作流Service接口实现类
 *
 * @author wyl
 * @date 2025/08/27 14:03
 **/
@Component
public class ResourceWorkflowServiceImpl extends ServiceImpl<ResourceWorkflowMapper, ResourceWorkflow> implements ResourceWorkflowService {

    @Inject
    CacheService cacheService;

    public List<ResourceWorkflow> findBySubscribeDetail(String subscribeDetail) {
        List<ResourceWorkflow> list = cacheService.getOrStore("viid_workflow_list", List.class, 60 * 5, () -> {
            return this.list(QueryWrapper.create().eq(ResourceWorkflow::getStatus, ResourceWorkflowStatus.ENABLE.getValue())
                    .eq(ResourceWorkflow::getIsTemplate, false));
        });
        return list.stream().filter(viidWorkflow -> {
            AtomicBoolean flag = new AtomicBoolean(false);
            ONode.load(viidWorkflow.getSubscribeDetail()).forEach(item -> {
                if (item.getString().equals(subscribeDetail)) {
                    flag.set(true);
                }
            });
            return flag.get();
        }).collect(Collectors.toList());
    }

    @Override
    public Page<ResourceWorkflow> page(ResourceWorkflowPageParam viidWorkflowPageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(viidWorkflowPageParam.getTitle())) {
            queryWrapper.like(ResourceWorkflow::getTitle, viidWorkflowPageParam.getTitle());
        }
        // 默认不显示模板数据
        queryWrapper.eq(ResourceWorkflow::getIsTemplate, false);
        if (ObjectUtil.isAllNotEmpty(viidWorkflowPageParam.getSortField(), viidWorkflowPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(viidWorkflowPageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(viidWorkflowPageParam.getSortField()), viidWorkflowPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy(ResourceWorkflow::getId, false);
        }
        Page<ResourceWorkflow> pageList = this.page(CommonPageRequest.defaultPage(), queryWrapper);
        pageList.getRecords().forEach(item -> {
            removeEscapeCharacters(item);
        });
        return pageList;
    }

    @Tran
    @Override
    public void add(ResourceWorkflowAddParam viidWorkflowAddParam) {
        ResourceWorkflow viidWorkflow = BeanUtil.toBean(viidWorkflowAddParam, ResourceWorkflow.class);
        // 设置状态
        viidWorkflow.setStatus(ResourceWorkflowStatus.DISABLED.getValue());
        // 如果未设置isTemplate，则默认设置为非模板
        if (viidWorkflow.getIsTemplate() == null) {
            viidWorkflow.setIsTemplate(false);
        }
        this.save(viidWorkflow);
        // 使缓存失效
        cacheService.remove("viid_workflow_list");
    }

    @Tran
    @Override
    public void edit(ResourceWorkflowEditParam viidWorkflowEditParam) {
        ResourceWorkflow viidWorkflow = this.queryEntity(viidWorkflowEditParam.getId());
        BeanUtil.copyProperties(viidWorkflowEditParam, viidWorkflow);
        this.updateById(viidWorkflow);
        // 使缓存失效
        cacheService.remove("viid_workflow_list");
    }

    @Tran
    @Override
    public void delete(List<ResourceWorkflowIdParam> viidWorkflowIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(viidWorkflowIdParamList, ResourceWorkflowIdParam::getId));
        // 使缓存失效
        cacheService.remove("viid_workflow_list");
    }

    @Override
    public ResourceWorkflow detail(ResourceWorkflowIdParam viidWorkflowIdParam) {
        ResourceWorkflow viidWorkflow = this.queryEntity(viidWorkflowIdParam.getId());
        removeEscapeCharacters(viidWorkflow);
        return viidWorkflow;
    }

    @Override
    public ResourceWorkflow queryEntity(String id) {
        ResourceWorkflow viidWorkflow = this.getById(id);
        if (ObjectUtil.isEmpty(viidWorkflow)) {
            throw new CommonException("工作流不存在，id值为：{}", id);
        }
        return viidWorkflow;
    }

    @Override
    public void copy(ResourceWorkflowIdParam viidWorkflowIdParam) {
        // 获取原工作流
        ResourceWorkflow originalWorkflow = this.queryEntity(viidWorkflowIdParam.getId());

        // 创建新工作流对象
        ResourceWorkflow newWorkflow = new ResourceWorkflow();
        // 复制属性，但使用新的ID和标题
        BeanUtil.copyProperties(originalWorkflow, newWorkflow);
        newWorkflow.setId(null); // 生成新的ID
        newWorkflow.setTitle(originalWorkflow.getTitle() + "_副本"); // 添加副本标识
        newWorkflow.setStatus(ResourceWorkflowStatus.DISABLED.getValue()); // 设置为禁用状态
        newWorkflow.setIsTemplate(false); // 设置为非模板

        // 保存新工作流
        this.save(newWorkflow);
        // 使缓存失效
        cacheService.remove("viid_workflow_list");
    }

    @Override
    public void disableWorkflow(ResourceWorkflowIdParam viidWorkflowIdParam) {
        this.updateChain().eq(ResourceWorkflow::getId, viidWorkflowIdParam.getId())
                .set(ResourceWorkflow::getStatus, ResourceWorkflowStatus.DISABLED.getValue()).update();
        // 使缓存失效
        cacheService.remove("viid_workflow_list");
    }

    @Override
    public void enableWorkflow(ResourceWorkflowIdParam viidWorkflowIdParam) {
        this.updateChain().eq(ResourceWorkflow::getId, viidWorkflowIdParam.getId())
                .set(ResourceWorkflow::getStatus, ResourceWorkflowStatus.ENABLE.getValue()).update();
        // 使缓存失效
        cacheService.remove("viid_workflow_list");
    }

    /**
     * 安装模板
     * 
     * @param viidWorkflowIdParam 模板ID参数
     */
    @Tran
    @Override
    public void installTemplate(ResourceWorkflowIdParam viidWorkflowIdParam) {
        // 获取模板工作流
        ResourceWorkflow templateWorkflow = this.queryEntity(viidWorkflowIdParam.getId());
        
        // 检查是否为模板
        if (templateWorkflow.getIsTemplate() == null || !templateWorkflow.getIsTemplate()) {
            throw new CommonException("指定的工作流不是模板");
        }
        
        // 创建新工作流对象
        ResourceWorkflow newWorkflow = new ResourceWorkflow();
        // 复制属性，但使用新的ID和标记为非模板
        BeanUtil.copyProperties(templateWorkflow, newWorkflow);
        newWorkflow.setId(null); // 生成新的ID
        newWorkflow.setIsTemplate(false); // 设置为非模板
        newWorkflow.setStatus(ResourceWorkflowStatus.DISABLED.getValue()); // 设置为禁用状态

        // 保存新工作流
        this.save(newWorkflow);
        // 使缓存失效
        cacheService.remove("viid_workflow_list");
    }

    /**
     * 获取模板列表
     * 
     * @return 模板列表
     */
    @Override
    public List<ResourceWorkflow> listTemplates() {
        List<ResourceWorkflow> templateList = this.list(new QueryWrapper().eq(ResourceWorkflow::getIsTemplate, true)
                .orderBy(ResourceWorkflow::getId, false));
        templateList.forEach(item -> {
            removeEscapeCharacters(item);
        });
        return templateList;
    }

    /**
     * 移除字符串中的转义字符
     *
     * @param viidWorkflow 工作流对象
     */
    private void removeEscapeCharacters(ResourceWorkflow viidWorkflow) {
        // 处理 subscribeDetail 字段中的转义字符
        viidWorkflow.setSubscribeDetail(handleEscapeCharacters(viidWorkflow.getSubscribeDetail()));
        
        // 处理 content 字段中的转义字符
        viidWorkflow.setContent(handleEscapeCharacters(viidWorkflow.getContent()));
    }
    
    /**
     * 处理字符串中的转义字符
     * 
     * @param jsonStr 包含可能转义字符的JSON字符串
     * @return 处理后的JSON字符串
     */
    private String handleEscapeCharacters(String jsonStr) {
        if (jsonStr == null || jsonStr.isEmpty()) {
            return jsonStr;
        }
        
        // 先尝试直接解析
        if (isValidJson(jsonStr)) {
            return jsonStr;
        }
        
        // 尝试不同的策略来修复转义字符
        String[] strategies = {
            jsonStr.replace("\\\"", "\""),           // 将 \" 替换为 "
            jsonStr.replace("\\\\", "\\"),           // 将 \\ 替换为 \
            jsonStr.replace("\\\"", "\"").replace("\\\\", "\\"),  // 组合策略1
            jsonStr.replace("\\\\\"", "\"").replace("\\\\'", "'"), // 组合策略2
        };
        
        // 尝试每种策略，找到第一个能生成有效JSON的
        for (String strategy : strategies) {
            if (isValidJson(strategy)) {
                return strategy;
            }
        }
        
        // 如果所有策略都失败，返回原始字符串
        return jsonStr;
    }
    
    /**
     * 检查字符串是否为有效的JSON
     * 
     * @param jsonStr 待检查的字符串
     * @return 是否为有效的JSON
     */
    private boolean isValidJson(String jsonStr) {
        try {
            ONode.loadStr(jsonStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Tran
    @Override
    public void convertToTemplate(ResourceWorkflowIdParam workflowIdParam) {
        ResourceWorkflow workflow = this.queryEntity(workflowIdParam.getId());
        
        // 检查是否已经是模板
        if (workflow.getIsTemplate() != null && workflow.getIsTemplate()) {
            throw new CommonException("该工作流已经是模板");
        }
        
        // 创建新的模板工作流对象
        ResourceWorkflow templateWorkflow = new ResourceWorkflow();
        // 复制属性，但使用新的ID
        BeanUtil.copyProperties(workflow, templateWorkflow);
        templateWorkflow.setId(null); // 生成新的ID
        templateWorkflow.setIsTemplate(true); // 设置为模板
        
        // 保存新模板
        this.save(templateWorkflow);
        
        // 使缓存失效
        cacheService.remove("viid_workflow_list");
    }
}
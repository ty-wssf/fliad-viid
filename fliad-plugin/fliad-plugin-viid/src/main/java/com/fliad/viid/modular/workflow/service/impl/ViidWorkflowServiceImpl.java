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
package com.fliad.viid.modular.workflow.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fliad.viid.modular.workflow.enums.ViidWorkflowStatus;
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
import com.fliad.viid.modular.workflow.entity.ViidWorkflow;
import com.fliad.viid.modular.workflow.mapper.ViidWorkflowMapper;
import com.fliad.viid.modular.workflow.param.ViidWorkflowAddParam;
import com.fliad.viid.modular.workflow.param.ViidWorkflowEditParam;
import com.fliad.viid.modular.workflow.param.ViidWorkflowIdParam;
import com.fliad.viid.modular.workflow.param.ViidWorkflowPageParam;
import com.fliad.viid.modular.workflow.service.ViidWorkflowService;
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
public class ViidWorkflowServiceImpl extends ServiceImpl<ViidWorkflowMapper, ViidWorkflow> implements ViidWorkflowService {

    @Inject
    CacheService cacheService;

    public List<ViidWorkflow> findBySubscribeDetail(String subscribeDetail) {
        List<ViidWorkflow> list = cacheService.getOrStore("viid_workflow_list", List.class, 60 * 5, () -> {
            return this.list(QueryWrapper.create().eq(ViidWorkflow::getStatus, ViidWorkflowStatus.ENABLE.getValue()));
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
    public Page<ViidWorkflow> page(ViidWorkflowPageParam viidWorkflowPageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(viidWorkflowPageParam.getTitle())) {
            queryWrapper.like(ViidWorkflow::getTitle, viidWorkflowPageParam.getTitle());
        }
        if (ObjectUtil.isAllNotEmpty(viidWorkflowPageParam.getSortField(), viidWorkflowPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(viidWorkflowPageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(viidWorkflowPageParam.getSortField()), viidWorkflowPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy(ViidWorkflow::getId, false);
        }
        Page<ViidWorkflow> pageList = this.page(CommonPageRequest.defaultPage(), queryWrapper);
        pageList.getRecords().forEach(item -> {
            removeEscapeCharacters(item);
        });
        return pageList;
    }

    @Tran
    @Override
    public void add(ViidWorkflowAddParam viidWorkflowAddParam) {
        ViidWorkflow viidWorkflow = BeanUtil.toBean(viidWorkflowAddParam, ViidWorkflow.class);
        // 设置状态
        viidWorkflow.setStatus(ViidWorkflowStatus.DISABLED.getValue());
        this.save(viidWorkflow);
        // 使缓存失效
        cacheService.remove("viid_workflow_list");
    }

    @Tran
    @Override
    public void edit(ViidWorkflowEditParam viidWorkflowEditParam) {
        ViidWorkflow viidWorkflow = this.queryEntity(viidWorkflowEditParam.getId());
        BeanUtil.copyProperties(viidWorkflowEditParam, viidWorkflow);
        this.updateById(viidWorkflow);
        // 使缓存失效
        cacheService.remove("viid_workflow_list");
    }

    @Tran
    @Override
    public void delete(List<ViidWorkflowIdParam> viidWorkflowIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(viidWorkflowIdParamList, ViidWorkflowIdParam::getId));
        // 使缓存失效
        cacheService.remove("viid_workflow_list");
    }

    @Override
    public ViidWorkflow detail(ViidWorkflowIdParam viidWorkflowIdParam) {
        ViidWorkflow viidWorkflow = this.queryEntity(viidWorkflowIdParam.getId());
        removeEscapeCharacters(viidWorkflow);
        return viidWorkflow;
    }

    @Override
    public ViidWorkflow queryEntity(String id) {
        ViidWorkflow viidWorkflow = this.getById(id);
        if (ObjectUtil.isEmpty(viidWorkflow)) {
            throw new CommonException("工作流不存在，id值为：{}", id);
        }
        return viidWorkflow;
    }

    @Override
    public void copy(ViidWorkflowIdParam viidWorkflowIdParam) {
        // 获取原工作流
        ViidWorkflow originalWorkflow = this.queryEntity(viidWorkflowIdParam.getId());

        // 创建新工作流对象
        ViidWorkflow newWorkflow = new ViidWorkflow();
        // 复制属性，但使用新的ID和标题
        BeanUtil.copyProperties(originalWorkflow, newWorkflow);
        newWorkflow.setId(null); // 生成新的ID
        newWorkflow.setTitle(originalWorkflow.getTitle() + "_副本"); // 添加副本标识
        newWorkflow.setStatus(ViidWorkflowStatus.DISABLED.getValue()); // 设置为禁用状态

        // 保存新工作流
        this.save(newWorkflow);
        // 使缓存失效
        cacheService.remove("viid_workflow_list");
    }

    @Override
    public void disableWorkflow(ViidWorkflowIdParam viidWorkflowIdParam) {
        this.updateChain().eq(ViidWorkflow::getId, viidWorkflowIdParam.getId())
                .set(ViidWorkflow::getStatus, ViidWorkflowStatus.DISABLED.getValue()).update();
        // 使缓存失效
        cacheService.remove("viid_workflow_list");
    }

    @Override
    public void enableWorkflow(ViidWorkflowIdParam viidWorkflowIdParam) {
        this.updateChain().eq(ViidWorkflow::getId, viidWorkflowIdParam.getId())
                .set(ViidWorkflow::getStatus, ViidWorkflowStatus.ENABLE.getValue()).update();
        // 使缓存失效
        cacheService.remove("viid_workflow_list");
    }

    /**
     * 移除字符串中的转义字符
     *
     * @param viidWorkflow 工作流对象
     */
    private void removeEscapeCharacters(ViidWorkflow viidWorkflow) {
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
}

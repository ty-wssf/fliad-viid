package com.fliad.resource.modular.datasource.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fliad.resource.modular.datasource.enums.ResourceDatasourceStatus;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.data.annotation.Tran;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.resource.modular.datasource.entity.ResourceDatasource;
import com.fliad.resource.modular.datasource.mapper.ResourceDatasourceMapper;
import com.fliad.resource.modular.datasource.param.ResourceDatasourceAddParam;
import com.fliad.resource.modular.datasource.param.ResourceDatasourceEditParam;
import com.fliad.resource.modular.datasource.param.ResourceDatasourceIdParam;
import com.fliad.resource.modular.datasource.param.ResourceDatasourcePageParam;
import com.fliad.resource.modular.datasource.service.ResourceDatasourceService;

import java.util.List;

/**
 * 数据源Service接口实现类
 *
 * @author wyl
 * @date 2025/09/24 20:05
 **/
@Component
public class ResourceDatasourceServiceImpl extends ServiceImpl<ResourceDatasourceMapper, ResourceDatasource> implements ResourceDatasourceService {

    @Override
    public Page<ResourceDatasource> page(ResourceDatasourcePageParam resourceDatasourcePageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(resourceDatasourcePageParam.getTitle())) {
            queryWrapper.like(ResourceDatasource::getTitle, resourceDatasourcePageParam.getTitle());
        }
        if (ObjectUtil.isNotEmpty(resourceDatasourcePageParam.getType())) {
            queryWrapper.eq(ResourceDatasource::getType, resourceDatasourcePageParam.getType());
        }
        // 默认不显示模板数据
        queryWrapper.eq(ResourceDatasource::getIsTemplate, false);
        if (ObjectUtil.isAllNotEmpty(resourceDatasourcePageParam.getSortField(), resourceDatasourcePageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(resourceDatasourcePageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(resourceDatasourcePageParam.getSortField()), resourceDatasourcePageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy(ResourceDatasource::getId, false);
        }
        Page<ResourceDatasource> pageList = this.page(CommonPageRequest.defaultPage(), queryWrapper);
        pageList.getRecords().forEach(item -> {
            removeEscapeCharacters(item);
        });
        return pageList;
    }

    @Tran
    @Override
    public void add(ResourceDatasourceAddParam resourceDatasourceAddParam) {
        ResourceDatasource resourceDatasource = BeanUtil.toBean(resourceDatasourceAddParam, ResourceDatasource.class);
        // 设置状态
        resourceDatasource.setStatus(ResourceDatasourceStatus.DISABLED.getValue());
        // 默认设置为非模板
        resourceDatasource.setIsTemplate(false);
        this.save(resourceDatasource);
    }

    @Tran
    @Override
    public void edit(ResourceDatasourceEditParam resourceDatasourceEditParam) {
        ResourceDatasource resourceDatasource = this.queryEntity(resourceDatasourceEditParam.getId());
        BeanUtil.copyProperties(resourceDatasourceEditParam, resourceDatasource);
        this.updateById(resourceDatasource);
    }

    @Tran
    @Override
    public void delete(List<ResourceDatasourceIdParam> resourceDatasourceIdParamList) {
        // 执行删除
        this.removeByIds(CollStreamUtil.toList(resourceDatasourceIdParamList, ResourceDatasourceIdParam::getId));
    }

    @Override
    public ResourceDatasource detail(ResourceDatasourceIdParam resourceDatasourceIdParam) {
        ResourceDatasource resourceDatasource = this.queryEntity(resourceDatasourceIdParam.getId());
        removeEscapeCharacters(resourceDatasource);
        return resourceDatasource;
    }

    @Override
    public ResourceDatasource queryEntity(String id) {
        ResourceDatasource resourceDatasource = this.getById(id);
        if (ObjectUtil.isEmpty(resourceDatasource)) {
            throw new CommonException("数据源不存在，id值为：{}", id);
        }
        return resourceDatasource;
    }

    @Override
    public void disableDatasource(ResourceDatasourceIdParam resourceDatasourceIdParam) {
        this.updateChain().eq(ResourceDatasource::getId, resourceDatasourceIdParam.getId())
                .set(ResourceDatasource::getStatus, ResourceDatasourceStatus.DISABLED.getValue()).update();
    }

    @Override
    public void enableDatasource(ResourceDatasourceIdParam resourceDatasourceIdParam) {
        this.updateChain().eq(ResourceDatasource::getId, resourceDatasourceIdParam.getId())
                .set(ResourceDatasource::getStatus, ResourceDatasourceStatus.ENABLE.getValue()).update();
    }

    @Override
    public List<ResourceDatasource> listByStatus(String status) {
        return this.list(new QueryWrapper().eq(ResourceDatasource::getStatus, status)
                .eq(ResourceDatasource::getIsTemplate, false));
    }

    @Override
    public void copy(ResourceDatasourceIdParam resourceDatasourceIdParam) {
        // 获取原数据源
        ResourceDatasource originalDatasource = this.queryEntity(resourceDatasourceIdParam.getId());

        // 创建新数据源对象
        ResourceDatasource newDatasource = new ResourceDatasource();
        // 复制属性，但使用新的ID和标题
        BeanUtil.copyProperties(originalDatasource, newDatasource);
        newDatasource.setId(null); // 生成新的ID
        newDatasource.setTitle(originalDatasource.getTitle() + "_副本"); // 添加副本标识
        newDatasource.setStatus(ResourceDatasourceStatus.DISABLED.getValue()); // 设置为禁用状态
        newDatasource.setIsTemplate(false); // 设置为非模板

        // 保存新数据源
        this.save(newDatasource);
    }

    /**
     * 安装模板
     * 
     * @param resourceDatasourceIdParam 模板ID参数
     */
    @Tran
    @Override
    public void installTemplate(ResourceDatasourceIdParam resourceDatasourceIdParam) {
        // 获取模板数据源
        ResourceDatasource templateDatasource = this.queryEntity(resourceDatasourceIdParam.getId());
        
        // 检查是否为模板
        if (templateDatasource.getIsTemplate() == null || !templateDatasource.getIsTemplate()) {
            throw new CommonException("指定的数据源不是模板");
        }
        
        // 创建新数据源对象
        ResourceDatasource newDatasource = new ResourceDatasource();
        // 复制属性，但使用新的ID和标记为非模板
        BeanUtil.copyProperties(templateDatasource, newDatasource);
        newDatasource.setId(null); // 生成新的ID
        newDatasource.setIsTemplate(false); // 设置为非模板
        newDatasource.setStatus(ResourceDatasourceStatus.DISABLED.getValue()); // 设置为禁用状态

        // 保存新数据源
        this.save(newDatasource);
    }

    /**
     * 获取模板列表
     * 
     * @return 模板列表
     */
    @Override
    public List<ResourceDatasource> listTemplates() {
        return this.list(new QueryWrapper().eq(ResourceDatasource::getIsTemplate, true));
    }

    /**
     * 移除字符串中的转义字符
     *
     * @param resourceDatasource 数据源对象
     */
    private void removeEscapeCharacters(ResourceDatasource resourceDatasource) {
        // 处理 content 字段中的转义字符
        resourceDatasource.setContent(handleEscapeCharacters(resourceDatasource.getContent()));
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
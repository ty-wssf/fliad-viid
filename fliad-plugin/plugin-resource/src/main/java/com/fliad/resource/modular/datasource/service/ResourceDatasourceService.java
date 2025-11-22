package com.fliad.resource.modular.datasource.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import com.fliad.resource.modular.datasource.entity.ResourceDatasource;
import com.fliad.resource.modular.datasource.param.ResourceDatasourceAddParam;
import com.fliad.resource.modular.datasource.param.ResourceDatasourceEditParam;
import com.fliad.resource.modular.datasource.param.ResourceDatasourceIdParam;
import com.fliad.resource.modular.datasource.param.ResourceDatasourcePageParam;

import java.util.List;

/**
 * 数据源Service接口
 *
 * @author wyl
 * @date 2025-05-13
 **/
public interface ResourceDatasourceService extends IService<ResourceDatasource> {

    /**
     * 获取数据源分页
     *
     * @author wyl
     * @date 2025-05-13
     */
    Page<ResourceDatasource> page(ResourceDatasourcePageParam viidDatasourcePageParam);

    /**
     * 添加数据源
     *
     * @author wyl
     * @date 2025-05-13
     */
    void add(ResourceDatasourceAddParam viidDatasourceAddParam);

    /**
     * 编辑数据源
     *
     * @author wyl
     * @date 2025-05-13
     */
    void edit(ResourceDatasourceEditParam viidDatasourceEditParam);

    /**
     * 删除数据源
     *
     * @author wyl
     * @date 2025-05-13
     */
    void delete(List<ResourceDatasourceIdParam> viidDatasourceIdParamList);

    /**
     * 获取数据源详情
     *
     * @author wyl
     * @date 2025-05-13
     */
    ResourceDatasource detail(ResourceDatasourceIdParam viidDatasourceIdParam);

    /**
     * 获取数据源详情
     *
     * @author wyl
     * @date 2025-05-13
     **/
    ResourceDatasource queryEntity(String id);

    /**
     * 禁用数据源
     *
     * @param viidDatasourceIdParam
     */
    void disableDatasource(ResourceDatasourceIdParam viidDatasourceIdParam);

    /**
     * 启用数据源
     *
     * @param viidDatasourceIdParam
     */
    void enableDatasource(ResourceDatasourceIdParam viidDatasourceIdParam);

    /**
     * 根据状态获取数据源列表
     *
     * @param status 状态值
     * @return 数据源列表
     */
    List<ResourceDatasource> listByStatus(String status);

    /**
     * 复制数据源
     *
     * @param viidDatasourceIdParam 数据源ID参数
     */
    void copy(ResourceDatasourceIdParam viidDatasourceIdParam);

    /**
     * 安装模板
     *
     * @param viidDatasourceIdParam 模板ID参数
     */
    void installTemplate(ResourceDatasourceIdParam viidDatasourceIdParam);

    /**
     * 获取模板列表
     *
     * @return 模板列表
     */
    List<ResourceDatasource> listTemplates();
    
    /**
     * 将数据源转换为模板
     *
     * @param viidDatasourceIdParam 数据源ID参数
     */
    void convertToTemplate(ResourceDatasourceIdParam viidDatasourceIdParam);
    
    /**
     * 导出数据源为data-init.xml格式
     *
     * @param viidDatasourceIdParam 数据源ID参数
     * @return data-init.xml格式的字符串
     */
    String exportDataInit(ResourceDatasourceIdParam viidDatasourceIdParam);
}
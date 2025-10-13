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
package com.fliad.viid.modular.datasource.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import com.fliad.viid.modular.datasource.entity.ViidDatasource;
import com.fliad.viid.modular.datasource.param.ViidDatasourceAddParam;
import com.fliad.viid.modular.datasource.param.ViidDatasourceEditParam;
import com.fliad.viid.modular.datasource.param.ViidDatasourceIdParam;
import com.fliad.viid.modular.datasource.param.ViidDatasourcePageParam;

import java.util.List;

/**
 * 数据源Service接口
 *
 * @author wyl
 * @date 2025-05-13
 **/
public interface ViidDatasourceService extends IService<ViidDatasource> {

    /**
     * 获取数据源分页
     *
     * @author wyl
     * @date 2025-05-13
     */
    Page<ViidDatasource> page(ViidDatasourcePageParam viidDatasourcePageParam);

    /**
     * 添加数据源
     *
     * @author wyl
     * @date 2025-05-13
     */
    void add(ViidDatasourceAddParam viidDatasourceAddParam);

    /**
     * 编辑数据源
     *
     * @author wyl
     * @date 2025-05-13
     */
    void edit(ViidDatasourceEditParam viidDatasourceEditParam);

    /**
     * 删除数据源
     *
     * @author wyl
     * @date 2025-05-13
     */
    void delete(List<ViidDatasourceIdParam> viidDatasourceIdParamList);

    /**
     * 获取数据源详情
     *
     * @author wyl
     * @date 2025-05-13
     */
    ViidDatasource detail(ViidDatasourceIdParam viidDatasourceIdParam);

    /**
     * 获取数据源详情
     *
     * @author wyl
     * @date 2025-05-13
     **/
    ViidDatasource queryEntity(String id);

    /**
     * 禁用数据源
     *
     * @param viidDatasourceIdParam
     */
    void disableDatasource(ViidDatasourceIdParam viidDatasourceIdParam);

    /**
     * 启用数据源
     *
     * @param viidDatasourceIdParam
     */
    void enableDatasource(ViidDatasourceIdParam viidDatasourceIdParam);

    /**
     * 根据状态获取数据源列表
     *
     * @param status 状态值
     * @return 数据源列表
     */
    List<ViidDatasource> listByStatus(String status);

    /**
     * 复制数据源
     *
     * @param viidDatasourceIdParam 数据源ID参数
     */
    void copy(ViidDatasourceIdParam viidDatasourceIdParam);
}
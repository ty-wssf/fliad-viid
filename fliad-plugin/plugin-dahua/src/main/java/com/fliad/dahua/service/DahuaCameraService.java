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
package com.fliad.dahua.service;

import com.fliad.dahua.dao.entity.DahuaCamera;
import com.fliad.dahua.param.DahuaCameraIdParam;
import com.fliad.dahua.param.DahuaCameraPageParam;
import com.fliad.dahua.param.DahuaExportParam;
import com.mybatisflex.core.paginate.Page;
import org.noear.solon.core.handle.Context;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 大华设备Service接口
 *
 * @author wyl
 * @date 2025/09/27
 **/
public interface DahuaCameraService {

    /**
     * 获取大华设备分页
     *
     * @author wyl
     * @date 2025/09/27
     */
    Page<Map<String, Object>> page(DahuaCameraPageParam viidDahuaCameraPageParam);

    /**
     * 添加大华设备
     *
     * @author wyl
     * @date 2025/09/27
     */
    void add(DahuaCamera dahuaCamera);

    /**
     * 编辑大华设备
     *
     * @author wyl
     * @date 2025/09/27
     */
    void edit(DahuaCamera dahuaCamera);

    /**
     * 删除大华设备
     *
     * @author wyl
     * @date 2025/09/27
     */
    void delete(List<DahuaCameraIdParam> viidDahuaCameraIdParamList);

    /**
     * 获取大华设备详情
     *
     * @author wyl
     * @date 2025/09/27
     */
    DahuaCamera detail(DahuaCameraIdParam viidDahuaCameraIdParam);

    /**
     * 获取大华设备详情
     *
     * @author wyl
     * @date 2025/09/27
     */
    DahuaCamera queryEntity(String id);

    /**
     * 导入大华设备
     *
     * @author wyl
     * @date 2025/09/27
     */
    void importDevices(List<Map<String, Object>> devices);

    /**
     * 导出大华设备
     *
     * @author wyl
     * @date 2025/09/27
     */
    void exportDahuaDevice(DahuaExportParam dahuaExportParam, Context ctx) throws IOException;

}

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
package com.fliad.dahua.modular.defense.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fliad.common.util.CommonDownloadUtil;
import com.fliad.dahua.modular.defense.param.*;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import io.nop.api.core.beans.WebContentBean;
import io.nop.api.core.exceptions.NopException;
import io.nop.commons.concurrent.executor.GlobalExecutors;
import io.nop.core.resource.IResource;
import io.nop.core.resource.ResourceHelper;
import io.nop.report.core.util.ExcelReportHelper;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.handle.Context;
import org.noear.solon.data.annotation.Tran;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.dahua.modular.defense.entity.DahuaCamera;
import com.fliad.dahua.modular.defense.mapper.DahuaCameraMapper;
import com.fliad.dahua.modular.defense.service.DahuaCameraService;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 大华设备Service接口实现类
 *
 * @author wyl
 * @date 2025/09/27
 **/
@Component
public class DahuaCameraServiceImpl extends ServiceImpl<DahuaCameraMapper, DahuaCamera> implements DahuaCameraService {

    @Override
    public Page<DahuaCamera> page(DahuaCameraPageParam viidDahuaCameraPageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(viidDahuaCameraPageParam.getDeviceId())) {
            queryWrapper.like("DEVICE_ID", viidDahuaCameraPageParam.getDeviceId());
        }
        if (ObjectUtil.isNotEmpty(viidDahuaCameraPageParam.getName())) {
            queryWrapper.like("NAME", viidDahuaCameraPageParam.getName());
        }
        if (ObjectUtil.isNotEmpty(viidDahuaCameraPageParam.getIpAddr())) {
            queryWrapper.like("IP_ADDR", viidDahuaCameraPageParam.getIpAddr());
        }
        if (ObjectUtil.isAllNotEmpty(viidDahuaCameraPageParam.getSortField(), viidDahuaCameraPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(viidDahuaCameraPageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(viidDahuaCameraPageParam.getSortField()), viidDahuaCameraPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy("ID", false);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Tran
    @Override
    public void add(DahuaCameraAddParam viidDahuaCameraAddParam) {
        // 检查deviceId唯一性
        checkDeviceIdUnique(viidDahuaCameraAddParam.getDeviceId(), null);
        // 检查设备名称唯一性
        checkDeviceNameUnique(viidDahuaCameraAddParam.getName(), null);
        // 检查设备IP地址唯一性
        checkDeviceIpAddrUnique(viidDahuaCameraAddParam.getIpAddr(), null);

        DahuaCamera viidDahuaCamera = BeanUtil.toBean(viidDahuaCameraAddParam, DahuaCamera.class);
        this.save(viidDahuaCamera);
    }

    @Tran
    @Override
    public void edit(DahuaCameraEditParam viidDahuaCameraEditParam) {
        // 检查deviceId唯一性
        checkDeviceIdUnique(viidDahuaCameraEditParam.getDeviceId(), viidDahuaCameraEditParam.getId());
        // 检查设备名称唯一性
        checkDeviceNameUnique(viidDahuaCameraEditParam.getName(), viidDahuaCameraEditParam.getId());
        // 检查设备IP地址唯一性
        checkDeviceIpAddrUnique(viidDahuaCameraEditParam.getIpAddr(), viidDahuaCameraEditParam.getId());

        DahuaCamera viidDahuaCamera = this.queryEntity(viidDahuaCameraEditParam.getId());
        BeanUtil.copyProperties(viidDahuaCameraEditParam, viidDahuaCamera);
        this.updateById(viidDahuaCamera);
    }

    @Tran
    @Override
    public void delete(List<DahuaCameraIdParam> viidDahuaCameraIdParamList) {
        this.removeByIds(CollStreamUtil.toList(viidDahuaCameraIdParamList, DahuaCameraIdParam::getId));
    }

    @Override
    public DahuaCamera detail(DahuaCameraIdParam viidDahuaCameraIdParam) {
        return this.queryEntity(viidDahuaCameraIdParam.getId());
    }

    @Override
    public DahuaCamera queryEntity(String id) {
        DahuaCamera viidDahuaCamera = this.getById(id);
        if (ObjectUtil.isEmpty(viidDahuaCamera)) {
            throw new CommonException("大华设备不存在，id值为：{}", id);
        }
        return viidDahuaCamera;
    }

    @Tran
    @Override
    public void importDevices(List<Map<String, Object>> devices) {
        // 先检查导入数据中是否存在重复的IP地址
        Set<String> ipSet = new HashSet<>();
        for (Map<String, Object> deviceMap : devices) {
            String ipAddr = (String) deviceMap.get("ipAddr");
            if (ipSet.contains(ipAddr)) {
                throw new CommonException("导入数据中存在重复的IP地址: {}", ipAddr);
            }
            ipSet.add(ipAddr);
        }

        for (Map<String, Object> deviceMap : devices) {
            // 获取设备信息
            String deviceId = (String) deviceMap.get("deviceId");
            String name = (String) deviceMap.get("name");
            String ipAddr = (String) deviceMap.get("ipAddr");

            // 根据IP地址查找现有设备
            DahuaCamera existingCamera = this.getOne(new QueryWrapper().eq("IP_ADDR", ipAddr));

            if (existingCamera != null) {
                // 如果IP地址已存在，则更新设备信息
                // 检查deviceId唯一性，排除当前记录
                checkDeviceIdUnique(deviceId, existingCamera.getId());
                // 检查设备名称唯一性，排除当前记录
                checkDeviceNameUnique(name, existingCamera.getId());

                existingCamera = ONode.deserialize(ONode.load(existingCamera).setAll(deviceMap).toString(), DahuaCamera.class);

                // 保持在线状态不变
                this.updateById(existingCamera);
            } else {
                // 如果IP地址不存在，则新增设备
                // 检查deviceId唯一性
                checkDeviceIdUnique(deviceId, null);
                // 检查设备名称唯一性
                checkDeviceNameUnique(name, null);
                // 检查IP地址唯一性（仅在新增时检查）
                checkDeviceIpAddrUnique(ipAddr, null);

                DahuaCamera dahuaCamera = ONode.deserialize(ONode.stringify(deviceMap), DahuaCamera.class);

                // 处理在线状态
                dahuaCamera.setOnlineStatus(0);

                this.save(dahuaCamera);
            }
        }
    }

    @Override
    public void exportDahuaDevice(DahuaExportParam dahuaExportParam, Context ctx) throws IOException {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(dahuaExportParam.getDeviceId())) {
            queryWrapper.like("DEVICE_ID", dahuaExportParam.getDeviceId());
        }
        if (ObjectUtil.isNotEmpty(dahuaExportParam.getName())) {
            queryWrapper.like("NAME", dahuaExportParam.getName());
        }
        if (ObjectUtil.isNotEmpty(dahuaExportParam.getIpAddr())) {
            queryWrapper.like("IP_ADDR", dahuaExportParam.getIpAddr());
        }
        if (ObjectUtil.isAllNotEmpty(dahuaExportParam.getSortField(), dahuaExportParam.getSortOrder())) {
            CommonSortOrderEnum.validate(dahuaExportParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(dahuaExportParam.getSortField()), dahuaExportParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy("ID", false);
        }
        List<DahuaCamera> list = this.list(queryWrapper);
        Map<String, Object> bean = new HashMap<>();
        bean.put("devices", list);
        IResource resource = ResourceHelper.getTempResource("download");
        try {
            String impPath = "/nop/excel/imp/dahua.imp.xml";
            ExcelReportHelper.saveXlsxObject(impPath, resource, bean);

            GlobalExecutors.globalTimer().schedule(() -> {
                resource.delete();
                return null;
            }, 1, TimeUnit.MINUTES);

            CommonDownloadUtil.download("大华设备数据.xlsx", FileUtil.readBytes(resource.toFile()), ctx);

        } catch (Exception e) {
            resource.delete();
            throw NopException.adapt(e);
        }

    }

    /**
     * 检查设备ID唯一性
     *
     * @param deviceId  设备ID
     * @param excludeId 排除的ID（编辑时使用）
     */
    private void checkDeviceIdUnique(String deviceId, String excludeId) {
        if (StrUtil.isBlank(deviceId)) {
            return;
        }

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("DEVICE_ID", deviceId);
        if (StrUtil.isNotBlank(excludeId)) {
            queryWrapper.ne("ID", excludeId);
        }

        if (this.exists(queryWrapper)) {
            throw new CommonException("设备编号 {} 已存在", deviceId);
        }
    }

    /**
     * 检查设备名称唯一性
     *
     * @param name      设备名称
     * @param excludeId 排除的ID（编辑时使用）
     */
    private void checkDeviceNameUnique(String name, String excludeId) {
        if (StrUtil.isBlank(name)) {
            return;
        }

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("NAME", name);
        if (StrUtil.isNotBlank(excludeId)) {
            queryWrapper.ne("ID", excludeId);
        }

        if (this.exists(queryWrapper)) {
            throw new CommonException("设备名称 {} 已存在", name);
        }
    }

    /**
     * 检查设备IP地址唯一性
     *
     * @param ipAddr    设备IP地址
     * @param excludeId 排除的ID（编辑时使用）
     */
    private void checkDeviceIpAddrUnique(String ipAddr, String excludeId) {
        if (StrUtil.isBlank(ipAddr)) {
            return;
        }

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("IP_ADDR", ipAddr);
        if (StrUtil.isNotBlank(excludeId)) {
            queryWrapper.ne("ID", excludeId);
        }

        if (this.exists(queryWrapper)) {
            throw new CommonException("设备IP地址 {} 已存在", ipAddr);
        }
    }
}
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
package com.fliad.hikvision.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fliad.common.util.CommonDownloadUtil;
import com.fliad.hikvision.param.*;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.solon.service.impl.ServiceImpl;
import io.nop.api.core.exceptions.NopException;
import io.nop.commons.concurrent.executor.GlobalExecutors;
import io.nop.core.reflect.bean.BeanTool;
import io.nop.core.resource.IResource;
import io.nop.core.resource.ResourceHelper;
import io.nop.dao.api.DaoProvider;
import io.nop.dao.api.IEntityDao;
import io.nop.orm.IOrmEntity;
import io.nop.orm.utils.UniqueValidator;
import io.nop.report.core.util.ExcelReportHelper;
import io.nop.xlang.xmeta.IObjMeta;
import io.nop.xlang.xmeta.SchemaLoader;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.handle.Context;
import org.noear.solon.data.annotation.Tran;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.hikvision.modular.defense.entity.HikvisionCamera;
import com.fliad.hikvision.mapper.HikvisionCameraMapper;
import com.fliad.hikvision.service.HikvisionCameraService;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 海康设备Service接口实现类
 *
 * @author wyl
 * @date 2025/09/27
 **/
@Component
public class HikvisionCameraServiceImpl extends ServiceImpl<HikvisionCameraMapper, HikvisionCamera> implements HikvisionCameraService {

    @Override
    public Page<HikvisionCamera> page(HikvisionCameraPageParam viidHikvisionCameraPageParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(viidHikvisionCameraPageParam.getDeviceId())) {
            queryWrapper.like("DEVICE_ID", viidHikvisionCameraPageParam.getDeviceId());
        }
        if (ObjectUtil.isNotEmpty(viidHikvisionCameraPageParam.getName())) {
            queryWrapper.like("NAME", viidHikvisionCameraPageParam.getName());
        }
        if (ObjectUtil.isNotEmpty(viidHikvisionCameraPageParam.getIpAddr())) {
            queryWrapper.like("IP_ADDR", viidHikvisionCameraPageParam.getIpAddr());
        }
        if (ObjectUtil.isAllNotEmpty(viidHikvisionCameraPageParam.getSortField(), viidHikvisionCameraPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(viidHikvisionCameraPageParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(viidHikvisionCameraPageParam.getSortField()), viidHikvisionCameraPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy("ID", false);
        }
        return this.page(CommonPageRequest.defaultPage(), queryWrapper);
    }

    @Tran
    @Override
    public void add(HikvisionCameraAddParam viidHikvisionCameraAddParam) {
        IEntityDao<com.fliad.hikvision.dao.entity.HikvisionCamera> dao = DaoProvider.instance().daoFor(com.fliad.hikvision.dao.entity.HikvisionCamera.class);
        com.fliad.hikvision.dao.entity.HikvisionCamera entity = dao.newEntity();
        BeanTool.instance().setProperties(entity, BeanUtil.beanToMap(viidHikvisionCameraAddParam));

        // 从路径加载
        IObjMeta objMeta = SchemaLoader.loadXMeta("/plugin/dahua/model/DahuaCamera/DahuaCamera.xmeta");
        // 保存前校验唯一性
        UniqueValidator.checkUniqueForSave(entity, objMeta, "HikvisionCamera");
        dao.saveEntity(entity);
    }

    @Tran
    @Override
    public void edit(HikvisionCameraEditParam viidHikvisionCameraEditParam) {
        // 检查deviceId唯一性
        checkDeviceIdUnique(viidHikvisionCameraEditParam.getDeviceId(), viidHikvisionCameraEditParam.getId());
        // 检查设备名称唯一性
        checkDeviceNameUnique(viidHikvisionCameraEditParam.getName(), viidHikvisionCameraEditParam.getId());
        // 检查设备IP地址唯一性
        checkDeviceIpAddrUnique(viidHikvisionCameraEditParam.getIpAddr(), viidHikvisionCameraEditParam.getId());

        HikvisionCamera viidHikvisionCamera = this.queryEntity(viidHikvisionCameraEditParam.getId());
        BeanUtil.copyProperties(viidHikvisionCameraEditParam, viidHikvisionCamera);
        this.updateById(viidHikvisionCamera);
    }

    @Tran
    @Override
    public void delete(List<HikvisionCameraIdParam> viidHikvisionCameraIdParamList) {
        this.removeByIds(CollStreamUtil.toList(viidHikvisionCameraIdParamList, HikvisionCameraIdParam::getId));
    }

    @Override
    public HikvisionCamera detail(HikvisionCameraIdParam viidHikvisionCameraIdParam) {
        return this.queryEntity(viidHikvisionCameraIdParam.getId());
    }

    @Override
    public HikvisionCamera queryEntity(String id) {
        HikvisionCamera viidHikvisionCamera = this.getById(id);
        if (ObjectUtil.isEmpty(viidHikvisionCamera)) {
            throw new CommonException("海康设备不存在，id值为：{}", id);
        }
        return viidHikvisionCamera;
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
            HikvisionCamera existingCamera = this.getOne(new QueryWrapper().eq("IP_ADDR", ipAddr));

            if (existingCamera != null) {
                // 如果IP地址已存在，则更新设备信息
                // 检查deviceId唯一性，排除当前记录
                checkDeviceIdUnique(deviceId, existingCamera.getId());
                // 检查设备名称唯一性，排除当前记录
                checkDeviceNameUnique(name, existingCamera.getId());

                existingCamera = ONode.deserialize(ONode.load(existingCamera).setAll(deviceMap).toString(), HikvisionCamera.class);

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

                HikvisionCamera hikvisionCamera = ONode.deserialize(ONode.stringify(deviceMap), HikvisionCamera.class);

                // 处理在线状态
                hikvisionCamera.setOnlineStatus(0);

                this.save(hikvisionCamera);
            }
        }
    }

    @Override
    public void exportHikvisionDevice(HikvisionExportParam hikvisionExportParam, Context ctx) throws IOException {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ObjectUtil.isNotEmpty(hikvisionExportParam.getDeviceId())) {
            queryWrapper.like("DEVICE_ID", hikvisionExportParam.getDeviceId());
        }
        if (ObjectUtil.isNotEmpty(hikvisionExportParam.getName())) {
            queryWrapper.like("NAME", hikvisionExportParam.getName());
        }
        if (ObjectUtil.isNotEmpty(hikvisionExportParam.getIpAddr())) {
            queryWrapper.like("IP_ADDR", hikvisionExportParam.getIpAddr());
        }
        if (ObjectUtil.isAllNotEmpty(hikvisionExportParam.getSortField(), hikvisionExportParam.getSortOrder())) {
            CommonSortOrderEnum.validate(hikvisionExportParam.getSortOrder());
            queryWrapper.orderBy(StrUtil.toUnderlineCase(hikvisionExportParam.getSortField()), hikvisionExportParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryWrapper.orderBy("ID", false);
        }
        List<HikvisionCamera> list = this.list(queryWrapper);
        Map<String, Object> bean = new HashMap<>();
        bean.put("devices", list);
        IResource resource = ResourceHelper.getTempResource("download");
        try {
            String impPath = "/nop/excel/imp/hikvision.imp.xml";
            ExcelReportHelper.saveXlsxObject(impPath, resource, bean);

            GlobalExecutors.globalTimer().schedule(() -> {
                resource.delete();
                return null;
            }, 1, TimeUnit.MINUTES);

            CommonDownloadUtil.download("海康设备数据.xlsx", FileUtil.readBytes(resource.toFile()), ctx);

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

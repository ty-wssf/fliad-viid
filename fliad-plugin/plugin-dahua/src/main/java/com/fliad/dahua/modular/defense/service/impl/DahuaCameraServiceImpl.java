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
import io.nop.api.core.beans.FilterBeans;
import io.nop.api.core.beans.WebContentBean;
import io.nop.api.core.beans.query.QueryBean;
import io.nop.api.core.exceptions.NopException;
import io.nop.commons.concurrent.executor.GlobalExecutors;
import io.nop.core.resource.IResource;
import io.nop.core.resource.ResourceHelper;
import io.nop.dao.api.DaoProvider;
import io.nop.dao.api.IEntityDao;
import io.nop.orm.IOrmTemplate;
import io.nop.report.core.util.ExcelReportHelper;
import io.nop.xlang.xmeta.IObjMeta;
import io.nop.xlang.xmeta.SchemaLoader;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.handle.Context;
import org.noear.solon.data.annotation.Tran;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.common.page.CommonPageRequest;
import com.fliad.dahua.modular.defense.entity.DahuaCamera;
import com.fliad.dahua.modular.defense.mapper.DahuaCameraMapper;
import com.fliad.dahua.modular.defense.service.DahuaCameraService;

import java.io.IOException;
import java.util.*;
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

    @Inject
    UniqueValidator uniqueValidator;
    @Inject
    IOrmTemplate ormTemplate;

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
    public void add(com.fliad.dahua.dao.entity.DahuaCamera viidDahuaCamera) {
        // 从路径加载
        IObjMeta objMeta = SchemaLoader.loadXMeta("/plugin/dahua/model/DahuaCamera/DahuaCamera.xmeta");
        // 保存前校验唯一性
        uniqueValidator.checkUniqueForSave(viidDahuaCamera, objMeta, "DahuaCamera");
        DaoProvider.instance().daoFor(com.fliad.dahua.dao.entity.DahuaCamera.class).saveEntity(viidDahuaCamera);

    }

    @Tran
    @Override
    public void edit(com.fliad.dahua.dao.entity.DahuaCamera viidDahuaCamera) {
        ormTemplate.runInSession(() -> {
            IObjMeta objMeta = SchemaLoader.loadXMeta("/plugin/dahua/model/DahuaCamera/DahuaCamera.xmeta");

            IEntityDao<com.fliad.dahua.dao.entity.DahuaCamera> dao = DaoProvider.instance().daoFor(com.fliad.dahua.dao.entity.DahuaCamera.class);
            com.fliad.dahua.dao.entity.DahuaCamera oldEntity = dao.requireEntityById(viidDahuaCamera.getId_());

            // 更新前校验唯一性
            uniqueValidator.checkUniqueForUpdate(viidDahuaCamera, objMeta, "DahuaCamera");

            EntityCopyHelper.copyProperties(viidDahuaCamera, oldEntity);
        });
    }

    @Tran
    @Override
    public void delete(List<DahuaCameraIdParam> viidDahuaCameraIdParamList) {
        ormTemplate.runInSession(() -> {
            DaoProvider.instance().daoFor(com.fliad.dahua.dao.entity.DahuaCamera.class)
                    .deleteAllByIds(CollStreamUtil.toList(viidDahuaCameraIdParamList, DahuaCameraIdParam::getId));
        });
    }

    @Override
    public com.fliad.dahua.dao.entity.DahuaCamera detail(DahuaCameraIdParam viidDahuaCameraIdParam) {
        return DaoProvider.instance().daoFor(com.fliad.dahua.dao.entity.DahuaCamera.class).getEntityById(viidDahuaCameraIdParam.getId());
    }

    @Override
    public com.fliad.dahua.dao.entity.DahuaCamera queryEntity(String id) {
        com.fliad.dahua.dao.entity.DahuaCamera viidDahuaCamera = DaoProvider.instance().daoFor(com.fliad.dahua.dao.entity.DahuaCamera.class).getEntityById(id);
        if (ObjectUtil.isEmpty(viidDahuaCamera)) {
            throw new CommonException("大华设备不存在，id值为：{}", id);
        }
        return viidDahuaCamera;
    }

    @Tran
    @Override
    public void importDevices(List<Map<String, Object>> devices) {
        ormTemplate.runInSession(() -> {
            IEntityDao<com.fliad.dahua.dao.entity.DahuaCamera> dao = DaoProvider.instance().daoFor(com.fliad.dahua.dao.entity.DahuaCamera.class);
            IObjMeta objMeta = SchemaLoader.loadXMeta("/plugin/dahua/model/DahuaCamera/DahuaCamera.xmeta");

            List<com.fliad.dahua.dao.entity.DahuaCamera> list = new ArrayList<>();
            for (Map<String, Object> deviceMap : devices) {
                com.fliad.dahua.dao.entity.DahuaCamera device = dao.newEntity();
                device.orm_restoreValues(deviceMap);
                // 保存前校验唯一性
                uniqueValidator.checkUniqueForSave(device, objMeta, "DahuaCamera");
                list.add(device);
            }
            // 保存设备
            dao.batchSaveEntities(list);
        });
    }

    @Override
    public void exportDahuaDevice(DahuaExportParam dahuaExportParam, Context ctx) throws IOException {
        QueryBean queryBean = new QueryBean();
        if (ObjectUtil.isNotEmpty(dahuaExportParam.getDeviceId())) {
            queryBean.addFilter(FilterBeans.like("deviceId", dahuaExportParam.getDeviceId()));
        }
        if (ObjectUtil.isNotEmpty(dahuaExportParam.getName())) {
            queryBean.addFilter(FilterBeans.like("name", dahuaExportParam.getName()));
        }
        if (ObjectUtil.isNotEmpty(dahuaExportParam.getIpAddr())) {
            queryBean.addFilter(FilterBeans.like("ipAddr", dahuaExportParam.getIpAddr()));
        }
        if (ObjectUtil.isAllNotEmpty(dahuaExportParam.getSortField(), dahuaExportParam.getSortOrder())) {
            CommonSortOrderEnum.validate(dahuaExportParam.getSortOrder());
            queryBean.addOrderField(StrUtil.toUnderlineCase(dahuaExportParam.getSortField()), 
                !dahuaExportParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryBean.addOrderField("id", true);
        }
        List<com.fliad.dahua.dao.entity.DahuaCamera> list = DaoProvider.instance().daoFor(com.fliad.dahua.dao.entity.DahuaCamera.class).findAllByQuery(queryBean);
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

}

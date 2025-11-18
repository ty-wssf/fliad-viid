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
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fliad.common.util.CommonDownloadUtil;
import com.fliad.hikvision.dao.entity.HikvisionCamera;
import com.fliad.hikvision.param.*;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.paginate.Page;
import io.nop.api.core.beans.FilterBeans;
import io.nop.api.core.beans.query.QueryBean;
import io.nop.api.core.exceptions.NopException;
import io.nop.commons.concurrent.executor.GlobalExecutors;
import io.nop.core.reflect.bean.BeanTool;
import io.nop.core.resource.IResource;
import io.nop.core.resource.ResourceHelper;
import io.nop.dao.api.DaoProvider;
import io.nop.dao.api.IEntityDao;
import io.nop.orm.IOrmTemplate;
import io.nop.orm.utils.EntityCopyHelper;
import io.nop.orm.utils.ImportUtil;
import io.nop.orm.utils.UniqueValidator;
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
import com.fliad.hikvision.service.HikvisionCameraService;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 海康设备Service接口实现类
 *
 * @author wyl
 * @date 2025/09/27
 **/
@Component
public class HikvisionCameraServiceImpl implements HikvisionCameraService {

    @Inject
    IOrmTemplate ormTemplate;

    @Override
    public Page<HikvisionCamera> page(HikvisionCameraPageParam hikvisionCameraPageParam) {
        QueryBean queryBean = new QueryBean();
        if (ObjectUtil.isNotEmpty(hikvisionCameraPageParam.getDeviceId())) {
            queryBean.addFilter(FilterBeans.like("deviceId", hikvisionCameraPageParam.getDeviceId()));
        }
        if (ObjectUtil.isNotEmpty(hikvisionCameraPageParam.getName())) {
            queryBean.addFilter(FilterBeans.like("name", hikvisionCameraPageParam.getName()));
        }
        if (ObjectUtil.isNotEmpty(hikvisionCameraPageParam.getIpAddr())) {
            queryBean.addFilter(FilterBeans.like("ipAddr", hikvisionCameraPageParam.getIpAddr()));
        }
        if (ObjectUtil.isAllNotEmpty(hikvisionCameraPageParam.getSortField(), hikvisionCameraPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(hikvisionCameraPageParam.getSortOrder());
            queryBean.addOrderField(StrUtil.toUnderlineCase(hikvisionCameraPageParam.getSortField()),
                    !hikvisionCameraPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryBean.addOrderField("id", true);
        }

        // 使用nop-orm的分页方法替换原有的MyBatis-Flex分页
        com.mybatisflex.core.paginate.Page<HikvisionCamera> page = new com.mybatisflex.core.paginate.Page<>();
        page.setPageNumber(hikvisionCameraPageParam.getCurrent());
        page.setPageSize(hikvisionCameraPageParam.getSize());

        IEntityDao<HikvisionCamera> dao = DaoProvider.instance().daoFor(HikvisionCamera.class);
        queryBean.setOffset((long) (hikvisionCameraPageParam.getCurrent() - 1) * hikvisionCameraPageParam.getSize());
        queryBean.setLimit(hikvisionCameraPageParam.getSize());
        List<HikvisionCamera> entities = dao.findPageByQuery(queryBean);

        // 转换成Map
        page.setRecords(entities);
        // 设置总数，这里需要另外查询
        page.setTotalRow(dao.countByQuery(queryBean));

        return page;
    }

    @Tran
    @Override
    public void add(HikvisionCameraAddParam viidHikvisionCameraAddParam) {
        IEntityDao<com.fliad.hikvision.dao.entity.HikvisionCamera> dao = DaoProvider.instance().daoFor(HikvisionCamera.class);
        com.fliad.hikvision.dao.entity.HikvisionCamera entity = dao.newEntity();
        BeanTool.instance().setProperties(entity, BeanUtil.beanToMap(viidHikvisionCameraAddParam));

        // 从路径加载
        IObjMeta objMeta = SchemaLoader.loadXMeta("/plugin/hikvision/model/HikvisionCamera/HikvisionCamera.xmeta");
        // 保存前校验唯一性
        UniqueValidator.checkUniqueForSave(entity, objMeta, "HikvisionCamera");
        dao.saveEntity(entity);
    }

    @Tran
    @Override
    public void edit(HikvisionCameraEditParam viidHikvisionCameraEditParam) {
        ormTemplate.runInSession(() -> {
            IObjMeta objMeta = SchemaLoader.loadXMeta("/plugin/hikvision/model/HikvisionCamera/HikvisionCamera.xmeta");

            IEntityDao<com.fliad.hikvision.dao.entity.HikvisionCamera> dao = DaoProvider.instance().daoFor(HikvisionCamera.class);
            com.fliad.hikvision.dao.entity.HikvisionCamera oldEntity = dao.requireEntityById(viidHikvisionCameraEditParam.getId());

            com.fliad.hikvision.dao.entity.HikvisionCamera newEntity = dao.newEntity();
            BeanTool.instance().setProperties(newEntity, BeanUtil.beanToMap(viidHikvisionCameraEditParam));
            EntityCopyHelper.copyProperties(newEntity, oldEntity);

            // 更新前校验唯一性
            UniqueValidator.checkUniqueForUpdate(oldEntity, objMeta, "DahuaCamera");
        });
    }

    @Tran
    @Override
    public void delete(List<HikvisionCameraIdParam> viidHikvisionCameraIdParamList) {
        ormTemplate.runInSession(() -> {
            DaoProvider.instance().daoFor(HikvisionCamera.class)
                    .deleteAllByIds(CollStreamUtil.toList(viidHikvisionCameraIdParamList, HikvisionCameraIdParam::getId));
        });
    }

    @Override
    public HikvisionCamera detail(HikvisionCameraIdParam viidHikvisionCameraIdParam) {
        return DaoProvider.instance().daoFor(HikvisionCamera.class).getEntityById(viidHikvisionCameraIdParam.getId());
    }

    @Override
    public HikvisionCamera queryEntity(String id) {
        HikvisionCamera hikvisionCamera = DaoProvider.instance().daoFor(HikvisionCamera.class).getEntityById(id);
        if (ObjectUtil.isEmpty(hikvisionCamera)) {
            throw new CommonException("海康设备不存在，id值为：{}", id);
        }
        return hikvisionCamera;
    }

    @Tran
    @Override
    public void importDevices(List<Map<String, Object>> devices) {
        ImportUtil.importEntities(HikvisionCamera.class, "/plugin/hikvision/model/HikvisionCamera/HikvisionCamera.xmeta", devices);
    }

    @Override
    public void exportHikvisionDevice(HikvisionExportParam hikvisionExportParam, Context ctx) {
        QueryBean queryBean = new QueryBean();
        if (ObjectUtil.isNotEmpty(hikvisionExportParam.getDeviceId())) {
            queryBean.addFilter(FilterBeans.like("deviceId", hikvisionExportParam.getDeviceId()));
        }
        if (ObjectUtil.isNotEmpty(hikvisionExportParam.getName())) {
            queryBean.addFilter(FilterBeans.like("name", hikvisionExportParam.getName()));
        }
        if (ObjectUtil.isNotEmpty(hikvisionExportParam.getIpAddr())) {
            queryBean.addFilter(FilterBeans.like("ipAddr", hikvisionExportParam.getIpAddr()));
        }
        if (ObjectUtil.isAllNotEmpty(hikvisionExportParam.getSortField(), hikvisionExportParam.getSortOrder())) {
            CommonSortOrderEnum.validate(hikvisionExportParam.getSortOrder());
            queryBean.addOrderField(StrUtil.toUnderlineCase(hikvisionExportParam.getSortField()),
                    !hikvisionExportParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryBean.addOrderField("id", true);
        }
        List<HikvisionCamera> list = DaoProvider.instance().daoFor(HikvisionCamera.class).findAllByQuery(queryBean);
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

}

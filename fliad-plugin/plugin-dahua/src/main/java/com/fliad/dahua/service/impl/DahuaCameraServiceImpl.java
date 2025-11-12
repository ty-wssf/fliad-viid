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
package com.fliad.dahua.service.impl;

import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fliad.common.util.CommonDownloadUtil;
import com.fliad.dahua.dao.entity.DahuaCamera;
import com.fliad.dahua.param.DahuaCameraIdParam;
import com.fliad.dahua.param.DahuaCameraPageParam;
import com.fliad.dahua.param.DahuaExportParam;
import com.fliad.dahua.service.impl.EntityCopyHelper;
import com.fliad.dahua.util.ImportUtil;
import com.mybatisflex.core.paginate.Page;
import io.nop.api.core.beans.FilterBeans;
import io.nop.api.core.beans.query.QueryBean;
import io.nop.api.core.exceptions.NopException;
import io.nop.commons.concurrent.executor.GlobalExecutors;
import io.nop.core.resource.IResource;
import io.nop.core.resource.ResourceHelper;
import io.nop.dao.api.DaoProvider;
import io.nop.dao.api.IEntityDao;
import io.nop.orm.IOrmTemplate;
import io.nop.orm.support.OrmEntity;
import io.nop.report.core.util.ExcelReportHelper;
import io.nop.xlang.xmeta.IObjMeta;
import io.nop.xlang.xmeta.SchemaLoader;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.handle.Context;
import org.noear.solon.data.annotation.Tran;
import com.fliad.common.enums.CommonSortOrderEnum;
import com.fliad.common.exception.CommonException;
import com.fliad.dahua.service.DahuaCameraService;

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
public class DahuaCameraServiceImpl implements DahuaCameraService {

    @Inject
    UniqueValidator uniqueValidator;
    @Inject
    IOrmTemplate ormTemplate;
    @Inject
    ImportUtil importUtil;

    @Override
    public Page<Map<String, Object>> page(DahuaCameraPageParam viidDahuaCameraPageParam) {
        QueryBean queryBean = new QueryBean();
        if (ObjectUtil.isNotEmpty(viidDahuaCameraPageParam.getDeviceId())) {
            queryBean.addFilter(FilterBeans.like("deviceId", viidDahuaCameraPageParam.getDeviceId()));
        }
        if (ObjectUtil.isNotEmpty(viidDahuaCameraPageParam.getName())) {
            queryBean.addFilter(FilterBeans.like("name", viidDahuaCameraPageParam.getName()));
        }
        if (ObjectUtil.isNotEmpty(viidDahuaCameraPageParam.getIpAddr())) {
            queryBean.addFilter(FilterBeans.like("ipAddr", viidDahuaCameraPageParam.getIpAddr()));
        }
        if (ObjectUtil.isAllNotEmpty(viidDahuaCameraPageParam.getSortField(), viidDahuaCameraPageParam.getSortOrder())) {
            CommonSortOrderEnum.validate(viidDahuaCameraPageParam.getSortOrder());
            queryBean.addOrderField(StrUtil.toUnderlineCase(viidDahuaCameraPageParam.getSortField()),
                    !viidDahuaCameraPageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue()));
        } else {
            queryBean.addOrderField("id", true);
        }

        // 使用nop-orm的分页方法替换原有的MyBatis-Flex分页
        com.mybatisflex.core.paginate.Page<Map<String, Object>> page = new com.mybatisflex.core.paginate.Page<>();
        page.setPageNumber(viidDahuaCameraPageParam.getCurrent());
        page.setPageSize(viidDahuaCameraPageParam.getSize());

        IEntityDao<DahuaCamera> dao = DaoProvider.instance().daoFor(DahuaCamera.class);
        queryBean.setOffset((long) (viidDahuaCameraPageParam.getCurrent() - 1) * viidDahuaCameraPageParam.getSize());
        queryBean.setLimit(viidDahuaCameraPageParam.getSize());
        List<DahuaCamera> entities = dao.findPageByQuery(queryBean);

        page.setRecords(entities.stream().map(OrmEntity::orm_initedValues).collect(Collectors.toList()));
        // 设置总数，这里需要另外查询
        page.setTotalRow(dao.countByQuery(queryBean));

        return page;
    }

    @Tran
    public void add(DahuaCamera viidDahuaCamera) {
        // 从路径加载
        IObjMeta objMeta = SchemaLoader.loadXMeta("/plugin/dahua/model/DahuaCamera/DahuaCamera.xmeta");
        // 保存前校验唯一性
        uniqueValidator.checkUniqueForSave(viidDahuaCamera, objMeta, "DahuaCamera");
        DaoProvider.instance().daoFor(DahuaCamera.class).saveEntity(viidDahuaCamera);

    }

    @Tran
    @Override
    public void edit(DahuaCamera viidDahuaCamera) {
        ormTemplate.runInSession(() -> {
            IObjMeta objMeta = SchemaLoader.loadXMeta("/plugin/dahua/model/DahuaCamera/DahuaCamera.xmeta");

            IEntityDao<DahuaCamera> dao = DaoProvider.instance().daoFor(DahuaCamera.class);
            DahuaCamera oldEntity = dao.requireEntityById(viidDahuaCamera.getId_());

            // 更新前校验唯一性
            uniqueValidator.checkUniqueForUpdate(viidDahuaCamera, objMeta, "DahuaCamera");

            EntityCopyHelper.copyProperties(viidDahuaCamera, oldEntity);
        });
    }

    @Tran
    @Override
    public void delete(List<DahuaCameraIdParam> viidDahuaCameraIdParamList) {
        ormTemplate.runInSession(() -> {
            DaoProvider.instance().daoFor(DahuaCamera.class)
                    .deleteAllByIds(CollStreamUtil.toList(viidDahuaCameraIdParamList, DahuaCameraIdParam::getId));
        });
    }

    @Override
    public DahuaCamera detail(DahuaCameraIdParam viidDahuaCameraIdParam) {
        return DaoProvider.instance().daoFor(DahuaCamera.class).getEntityById(viidDahuaCameraIdParam.getId());
    }

    @Override
    public DahuaCamera queryEntity(String id) {
        DahuaCamera viidDahuaCamera = DaoProvider.instance().daoFor(DahuaCamera.class).getEntityById(id);
        if (ObjectUtil.isEmpty(viidDahuaCamera)) {
            throw new CommonException("大华设备不存在，id值为：{}", id);
        }
        return viidDahuaCamera;
    }

    @Tran
    @Override
    public void importDevices(List<Map<String, Object>> devices) {
        importUtil.importEntities(DahuaCamera.class, "/plugin/dahua/model/DahuaCamera/DahuaCamera.xmeta", devices);
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
        List<DahuaCamera> list = DaoProvider.instance().daoFor(DahuaCamera.class).findAllByQuery(queryBean);
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

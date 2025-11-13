package com.fliad.dahua.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.io.IoUtil;
import com.fliad.common.util.CommonDownloadUtil;
import com.fliad.dahua.dao.entity.DahuaCamera;
import com.fliad.dahua.param.DahuaCameraIdParam;
import com.fliad.dahua.param.DahuaCameraPageParam;
import com.fliad.dahua.param.DahuaExportParam;
import com.mybatisflex.core.paginate.Page;
import io.nop.core.model.object.DynamicObject;
import io.nop.core.reflect.bean.BeanTool;
import io.nop.core.resource.IResource;
import io.nop.dao.api.DaoProvider;
import io.nop.excel.imp.ImportModelHelper;
import io.nop.excel.imp.model.ImportModel;
import io.nop.excel.model.ExcelWorkbook;
import io.nop.ooxml.xlsx.imp.ImportModelToExportModel;
import io.nop.ooxml.xlsx.imp.XlsxObjectLoader;
import io.nop.ooxml.xlsx.output.ExcelTemplate;
import io.nop.xlang.api.XLang;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.*;
import org.noear.solon.boot.web.MimeType;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.UploadedFile;
import org.noear.solon.validation.annotation.NotEmpty;
import org.noear.solon.validation.annotation.Valid;
import com.fliad.common.annotation.CommonLog;
import com.fliad.common.pojo.CommonResult;
import com.fliad.common.pojo.CommonValidList;
import com.fliad.dahua.service.DahuaCameraService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 大华设备控制器
 *
 * @author wyl
 * @date 2025/09/27
 */
@Api(tags = "大华设备控制器")
@Controller
@Valid
public class DahuaCameraController {

    @Inject
    private DahuaCameraService dahuaCameraService;

    /**
     * 获取大华设备分页
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("获取大华设备分页")
    @SaCheckPermission("/dahua/defense/page")
    @Get
    @Mapping("/dahua/defense/page")
    public CommonResult<Page<Map<String, Object>>> page(DahuaCameraPageParam dahuaCameraPageParam) {
        return CommonResult.data(dahuaCameraService.page(dahuaCameraPageParam));
    }

    /**
     * 添加大华设备
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("添加大华设备")
    @CommonLog("添加大华设备")
    @SaCheckPermission("/dahua/defense/add")
    @Post
    @Mapping("/dahua/defense/add")
    public CommonResult<String> add(Map<String, Object> data) {
        DahuaCamera dahuaCamera = DaoProvider.instance().daoFor(DahuaCamera.class).newEntity();
        BeanTool.instance().setProperties(dahuaCamera, data);
        dahuaCameraService.add(dahuaCamera);
        return CommonResult.ok();
    }

    /**
     * 编辑大华设备
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("编辑大华设备")
    @CommonLog("编辑大华设备")
    @SaCheckPermission("/dahua/defense/edit")
    @Post
    @Mapping("/dahua/defense/edit")
    public CommonResult<String> edit(Map<String, Object> data) {
        data.remove(DahuaCamera.PROP_NAME_createTime);
        data.remove(DahuaCamera.PROP_NAME_updateTime);
        DahuaCamera dahuaCamera = DaoProvider.instance().daoFor(DahuaCamera.class).newEntity();
        BeanTool.instance().setProperties(dahuaCamera, data);
        dahuaCameraService.edit(dahuaCamera);
        return CommonResult.ok();
    }

    /**
     * 删除大华设备
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("删除大华设备")
    @CommonLog("删除大华设备")
    @SaCheckPermission("/dahua/defense/delete")
    @Post
    @Mapping("/dahua/defense/delete")
    public CommonResult<String> delete(@NotEmpty(message = "集合不能为空")
                                       CommonValidList<DahuaCameraIdParam> dahuaCameraIdParamList) {
        dahuaCameraService.delete(dahuaCameraIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取大华设备详情
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("获取大华设备详情")
    @SaCheckPermission("/dahua/defense/detail")
    @Get
    @Mapping("/dahua/defense/detail")
    public CommonResult<com.fliad.dahua.dao.entity.DahuaCamera> detail(DahuaCameraIdParam dahuaCameraIdParam) {
        return CommonResult.data(dahuaCameraService.detail(dahuaCameraIdParam));
    }

    /**
     * 导入大华设备
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("导入大华设备")
    @CommonLog("导入大华设备")
    @SaCheckPermission("/dahua/defense/add")
    @Post
    @Mapping("/dahua/defense/import")
    public CommonResult<String> importDevices(UploadedFile file) {
        // 1. 检查上传文件
        if (file == null || file.getContent() == null) {
            return CommonResult.error("上传文件不能为空");
        }

        // 2. 将上传的文件转换为临时资源
        String fileName = file.getName();
        InputStream inputStream = file.getContent();
        IResource resource = new io.nop.core.resource.impl.ByteArrayResource("/" + fileName, IoUtil.readBytes(inputStream), -1);

        // 3. 使用XlsxObjectLoader解析Excel
        String impPath = "/nop/excel/imp/dahua.imp.xml";
        XlsxObjectLoader loader = new XlsxObjectLoader(impPath);
        Object result = loader.parseFromResource(resource);

        // 4. 获取解析后的设备列表
        DynamicObject obj = (DynamicObject) result;
        List<DynamicObject> devices = (List<DynamicObject>) obj.prop_get("devices");

        // 5. 批量保存到数据库
        dahuaCameraService.importDevices(devices.stream().map(DynamicObject::obj_propValues).collect(Collectors.toList()));

        // return CommonResult.ok("导入成功,共导入" + devices.size() + "条设备");
        return CommonResult.ok();
    }

    @ApiOperation("导出大华设备模板")
    @Post
    @Mapping("/dahua/defense/export-template")
    public void exportTemplate(Context context) {
        // 1. 加载导入模型
        String impPath = "/nop/excel/imp/dahua.imp.xml";
        ImportModel importModel = ImportModelHelper.getImportModel(impPath);

        // 2. 转换为Excel模板
        ImportModelToExportModel converter = new ImportModelToExportModel();
        ExcelWorkbook workbook = converter.build(importModel);

        // 3. 生成Excel文件
        ExcelTemplate template = new ExcelTemplate(workbook);
        byte[] bytes = template.generateBytes(XLang.newEvalScope());

        // 4. 输出到响应流
        CommonDownloadUtil.download("大华设备模板.xlsx", bytes, context);
    }

    @Get
    @Produces(MimeType.APPLICATION_OCTET_STREAM_VALUE)
    @Mapping("/dahua/defense/export")
    public void exportDahuaDevice(DahuaExportParam dahuaExportParam, Context context) throws IOException {
        dahuaCameraService.exportDahuaDevice(dahuaExportParam, context);
    }

}

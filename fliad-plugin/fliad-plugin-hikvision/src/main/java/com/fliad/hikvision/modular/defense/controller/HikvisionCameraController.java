package com.fliad.hikvision.modular.defense.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.io.IoUtil;
import com.fliad.common.util.CommonDownloadUtil;
import com.fliad.hikvision.modular.defense.param.*;
import com.mybatisflex.core.paginate.Page;
import io.nop.api.core.beans.ApiResponse;
import io.nop.core.model.object.DynamicObject;
import io.nop.core.resource.IResource;
import io.nop.core.resource.ResourceConstants;
import io.nop.core.resource.VirtualFileSystem;
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
import com.fliad.hikvision.modular.defense.entity.HikvisionCamera;
import com.fliad.hikvision.modular.defense.service.HikvisionCameraService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 海康布防控制器
 *
 * @author wyl
 * @date 2025/09/27
 */
@Api(tags = "海康布防控制器")
@Controller
@Valid
public class HikvisionCameraController {

    @Inject
    private HikvisionCameraService hikvisionCameraService;

    /**
     * 获取海康布防分页
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("获取海康布防分页")
    @SaCheckPermission("/hikvision/defense/page")
    @Get
    @Mapping("/hikvision/defense/page")
    public CommonResult<Page<HikvisionCamera>> page(HikvisionCameraPageParam hikvisionCameraPageParam) {
        return CommonResult.data(hikvisionCameraService.page(hikvisionCameraPageParam));
    }

    /**
     * 添加海康布防
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("添加海康布防")
    @CommonLog("添加海康布防")
    @SaCheckPermission("/hikvision/defense/add")
    @Post
    @Mapping("/hikvision/defense/add")
    public CommonResult<String> add(HikvisionCameraAddParam hikvisionCameraAddParam) {
        hikvisionCameraService.add(hikvisionCameraAddParam);
        return CommonResult.ok();
    }

    /**
     * 编辑海康布防
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("编辑海康布防")
    @CommonLog("编辑海康布防")
    @SaCheckPermission("/hikvision/defense/edit")
    @Post
    @Mapping("/hikvision/defense/edit")
    public CommonResult<String> edit(HikvisionCameraEditParam hikvisionCameraEditParam) {
        hikvisionCameraService.edit(hikvisionCameraEditParam);
        return CommonResult.ok();
    }

    /**
     * 删除海康布防
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("删除海康布防")
    @CommonLog("删除海康布防")
    @SaCheckPermission("/hikvision/defense/delete")
    @Post
    @Mapping("/hikvision/defense/delete")
    public CommonResult<String> delete(@NotEmpty(message = "集合不能为空")
                                       CommonValidList<HikvisionCameraIdParam> hikvisionCameraIdParamList) {
        hikvisionCameraService.delete(hikvisionCameraIdParamList);
        return CommonResult.ok();
    }

    /**
     * 获取海康布防详情
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("获取海康布防详情")
    @SaCheckPermission("/hikvision/defense/detail")
    @Get
    @Mapping("/hikvision/defense/detail")
    public CommonResult<HikvisionCamera> detail(HikvisionCameraIdParam hikvisionCameraIdParam) {
        return CommonResult.data(hikvisionCameraService.detail(hikvisionCameraIdParam));
    }

    /**
     * 导入海康设备
     *
     * @author wyl
     * @date 2025/09/27
     */
    @ApiOperation("导入海康设备")
    @CommonLog("导入海康设备")
    @SaCheckPermission("/hikvision/defense/add")
    @Post
    @Mapping("/hikvision/defense/import")
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
        String impPath = "/nop/excel/imp/hikvision.imp.xml";
        XlsxObjectLoader loader = new XlsxObjectLoader(impPath);
        Object result = loader.parseFromResource(resource);

        // 4. 获取解析后的设备列表
        DynamicObject obj = (DynamicObject) result;
        List<DynamicObject> devices = (List<DynamicObject>) obj.prop_get("devices");

        // 5. 批量保存到数据库
        hikvisionCameraService.importDevices(devices.stream().map(DynamicObject::obj_propValues).collect(Collectors.toList()));

        // return CommonResult.ok("导入成功,共导入" + devices.size() + "条设备");
        return CommonResult.ok();
    }

    @ApiOperation("导出海康设备模板")
    @Post
    @Mapping("/hikvision/defense/export-template")
    public void exportTemplate(Context context) {
        // 1. 加载导入模型
        String impPath = "/nop/excel/imp/hikvision.imp.xml";
        ImportModel importModel = ImportModelHelper.getImportModel(impPath);

        // 2. 转换为Excel模板
        ImportModelToExportModel converter = new ImportModelToExportModel();
        ExcelWorkbook workbook = converter.build(importModel);

        // 3. 生成Excel文件
        ExcelTemplate template = new ExcelTemplate(workbook);
        byte[] bytes = template.generateBytes(XLang.newEvalScope());

        // 4. 输出到响应流
        CommonDownloadUtil.download("海康设备模板.xlsx", bytes, context);
    }

    @Get
    @Produces(MimeType.APPLICATION_OCTET_STREAM_VALUE)
    @Mapping("/hikvision/defense/export")
    public void exportHikvisionDevice(HikvisionExportParam hikvisionExportParam, Context context) throws IOException {
        hikvisionCameraService.exportHikvisionDevice(hikvisionExportParam, context);
    }

}

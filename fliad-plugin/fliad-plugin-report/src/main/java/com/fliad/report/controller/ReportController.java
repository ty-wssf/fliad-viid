package com.fliad.report.controller;

import cn.hutool.json.JSONUtil;
import com.fliad.common.pojo.CommonResult;
import com.fliad.report.service.ReportService;
import com.fliad.common.exception.CommonException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.snack.ONode;
import org.noear.solon.annotation.*;
import org.noear.solon.core.handle.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * 报表控制器，提供生成报表的REST API接口
 */
@Api(tags = "报表控制器")
@Controller
@Mapping("/report")
public class ReportController {

    private static final Logger log = LoggerFactory.getLogger(ReportController.class);

    @Inject
    private ReportService reportService;

    @ApiOperation("test1")
    @Post
    @Mapping("/test1")
    public CommonResult<String> test1(@Param("templatePath") String templatePath, Map<String, Object> data) {
        return CommonResult.data(ONode.stringify(data));
    }

    @ApiOperation("test2")
    @Post
    @Mapping("/test2")
    public CommonResult<String> test2(@Param("templatePath") String templatePath, Test test) {
        return CommonResult.data(ONode.stringify(test));
    }

    /**
     * 生成XLSX格式报表
     *
     * @param templatePath 报表模板路径
     * @param data         报表数据（JSON格式）
     * @return 报表文件
     */
    @ApiOperation("生成XLSX格式报表")
    @Post
    @Mapping("/xlsx")
    public void generateXlsxReport(@Param("templatePath") String templatePath, Map<String, String> data, Context context) {
        generateReport(templatePath, "xlsx", data, context);
    }

    @Get
    @Mapping("/html")
    public void generateHtmlReport(@Param("templatePath") String templatePath, Context context) throws Exception {
        generateHtmlReportDirect(templatePath, context.paramMap().toValueMap(), context);
    }

    /**
     * 生成HTML格式报表
     *
     * @param templatePath 报表模板路径
     * @param data         报表数据（JSON格式）
     * @return 报表文件
     */
    @Post
    @Mapping("/html")
    public void generateHtmlReport(@Param("templatePath") String templatePath, Map<String, String> data, Context context) {
        generateReport(templatePath, "html", data, context);
    }
    
    @Post
    @Mapping("/htmlJson")
    public CommonResult<String> generateHtmlJson(@Param("templatePath") String templatePath, Map<String, String> data) {
        try {
            // 验证模板是否存在
            if (!reportService.isTemplateExists(templatePath)) {
                throw new CommonException("报表模板不存在: " + templatePath);
            }

            // 如果没有提供数据，则使用空数据
            if (data == null) {
                data = new HashMap<>();
            }

            // 生成HTML报表并直接返回内容
            byte[] htmlBytes = reportService.generateHtmlReportBytes(templatePath, data);
            String htmlContent = new String(htmlBytes, StandardCharsets.UTF_8);

            return CommonResult.data(htmlContent);
        } catch (Exception e) {
            log.error("生成报表失败，模板路径: {}", templatePath, e);
            throw new CommonException("生成报表失败: " + e.getMessage());
        }
    }

    /**
     * 直接生成并渲染HTML报表内容
     *
     * @param templatePath 报表模板路径
     * @param data         报表数据
     * @param context      请求上下文
     */
    private void generateHtmlReportDirect(String templatePath, Map<String, String> data, Context context) throws Exception {
        try {
            // 验证模板是否存在
            if (!reportService.isTemplateExists(templatePath)) {
                throw new CommonException("报表模板不存在: " + templatePath);
            }

            // 如果没有提供数据，则使用空数据
            if (data == null) {
                data = new HashMap<>();
            }

            // 生成HTML报表并获取字节内容
            byte[] htmlBytes = reportService.generateHtmlReportBytes(templatePath, data);
            
            // 设置响应头信息，直接渲染HTML而不是下载
            context.contentType("text/html;charset=UTF-8");
            context.output(htmlBytes);
        } catch (Exception e) {
            log.error("生成报表失败，模板路径: {}", templatePath, e);
            throw new CommonException("生成报表失败: " + e.getMessage());
        }
    }

    /**
     * 生成指定格式的报表
     *
     * @param templatePath 报表模板路径
     * @param format       报表格式 (xlsx, html等)
     * @param data         报表数据（JSON格式）
     * @return 报表文件
     */
    private void generateReport(String templatePath, String format, Map<String, String> data, Context context) {
        Path tempFile = null;
        try {
            // 验证模板是否存在
            if (!reportService.isTemplateExists(templatePath)) {
                throw new CommonException("报表模板不存在: " + templatePath);
            }

            // 如果没有提供数据，则使用空数据
            if (data == null) {
                data = new HashMap<>();
            }

            // 创建临时文件
            tempFile = Files.createTempFile("report_", "." + format);
            reportService.generateReport(templatePath, format, data, tempFile.toString());

            context.outputAsFile(tempFile.toFile());
        } catch (Exception e) {
            log.error("生成报表失败，模板路径: {}, 格式: {}", templatePath, format, e);
            throw new CommonException("生成报表失败: " + e.getMessage());
        } finally {
            // 删除临时文件
            if (tempFile != null) {
                try {
                    Files.deleteIfExists(tempFile);
                } catch (Exception e) {
                    log.warn("删除临时文件失败: {}", tempFile, e);
                }
            }
        }
    }
}

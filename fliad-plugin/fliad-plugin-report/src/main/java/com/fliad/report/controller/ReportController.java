/*
package com.fliad.report.controller;

import com.fliad.common.util.CommonDownloadUtil;
import com.fliad.report.service.ReportService;
import com.fliad.common.exception.CommonException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.*;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.DownloadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * 报表控制器，提供生成报表的REST API接口
 *//*

@Api(tags = "报表控制器")
@Controller
@Mapping("/report")
public class ReportController {

    private static final Logger log = LoggerFactory.getLogger(ReportController.class);

    @Inject
    private ReportService reportService;

    */
/**
     * 生成XLSX格式报表
     *
     * @param templatePath 报表模板路径
     * @param data         报表数据（JSON格式）
     * @return 报表文件
     *//*

    @ApiOperation("生成XLSX格式报表")
    @Post
    @Mapping("/xlsx")
    public void generateXlsxReport(@Param("templatePath") String templatePath,
                                   @Body Map<String, Object> data, Context context) {
        generateReport(templatePath, "xlsx", data, context);
    }

    */
/**
     * 生成HTML格式报表
     *
     * @param templatePath 报表模板路径
     * @param data         报表数据（JSON格式）
     * @return 报表文件
     *//*

    @Post
    @Mapping("/html")
    public void generateHtmlReport(@Param("templatePath") String templatePath,
                                   @Body Map<String, Object> data, Context context) {
        generateReport(templatePath, "html", data, context);
    }

    @Get
    @Mapping("/html")
    public String generateHtml(@Param("templatePath") String templatePath,
                               @Body Map<String, Object> data, Context context) {
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
            String htmlContent = new String(htmlBytes, "UTF-8");

            // 设置响应类型为HTML
            context.contentType("text/html;charset=UTF-8");
            return htmlContent;
        } catch (Exception e) {
            log.error("生成报表失败，模板路径: {}", templatePath, e);
            throw new CommonException("生成报表失败: " + e.getMessage());
        }
    }

    */
/**
     * 生成指定格式的报表
     *
     * @param templatePath 报表模板路径
     * @param format       报表格式 (xlsx, html等)
     * @param data         报表数据（JSON格式）
     * @return 报表文件
     *//*

    private void generateReport(String templatePath, String format, Map<String, Object> data, Context context) {
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
}*/

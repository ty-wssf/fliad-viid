/*
package com.fliad.report.service;

import com.fliad.common.exception.CommonException;
import io.nop.core.lang.eval.IEvalScope;
import io.nop.core.resource.impl.FileResource;
import io.nop.core.resource.tpl.ITemplateOutput;
import io.nop.excel.model.ExcelWorkbook;
import io.nop.report.core.build.XptModelLoader;
import io.nop.report.core.engine.IReportEngine;
import io.nop.report.core.engine.ReportEngine;
import io.nop.report.core.engine.renderer.HtmlReportRendererFactory;
import io.nop.report.core.engine.renderer.XlsxReportRendererFactory;
import io.nop.report.core.XptConstants;
import io.nop.xlang.api.XLang;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.util.ResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * 报表服务类，封装NopReport的核心方法
 * 支持生成XLSX、HTML等不同格式的报表
 *//*

@Component
public class ReportService {

    private static final Logger log = LoggerFactory.getLogger(ReportService.class);

    */
/**
     * 生成XLSX格式报表
     *
     * @param templatePath 报表模板路径
     * @param data         报表数据
     * @param outputFile   输出文件路径
     *//*

    public void generateXlsxReport(String templatePath, Map<String, Object> data, String outputFile) {
        generateReport(templatePath, "xlsx", data, outputFile);
    }

    */
/**
     * 生成HTML格式报表
     *
     * @param templatePath 报表模板路径
     * @param data         报表数据
     * @param outputFile   输出文件路径
     *//*

    public void generateHtmlReport(String templatePath, Map<String, Object> data, String outputFile) {
        generateReport(templatePath, "html", data, outputFile);
    }

    */
/**
     * 生成指定格式的报表
     *
     * @param templatePath 报表模板路径
     * @param format       报表格式 (xlsx, html等)
     * @param data         报表数据
     * @param outputFile   输出文件路径
     *//*

    public void generateReport(String templatePath, String format, Map<String, Object> data, String outputFile) {
        try {
            // 创建报表引擎
            IReportEngine reportEngine = newReportEngine();

            ITemplateOutput output = reportEngine.getRenderer(templatePath, format);

            // 创建执行上下文
            IEvalScope scope = XLang.newEvalScope();

            // 设置数据变量
            if (data != null) {
                for (Map.Entry<String, Object> entry : data.entrySet()) {
                    scope.setLocalValue(entry.getKey(), entry.getValue());
                }
            }

            // 确保输出目录存在
            Path outputPath = Paths.get(outputFile);
            Files.createDirectories(outputPath.getParent());

            // 生成报表文件
            File outFile = new File(outputFile);
            output.generateToFile(outFile, scope);

            log.info("报表生成成功，格式: {}, 路径: {}", format, outputFile);
        } catch (Exception e) {
            log.error("生成报表失败，模板路径: {}, 格式: {}", templatePath, format, e);
            throw new CommonException("生成报表失败: " + e.getMessage(), e);
        }
    }

    */
/**
     * 生成XLSX格式报表并返回字节数组
     *
     * @param templatePath 报表模板路径
     * @param data         报表数据
     * @return 报表字节数组
     *//*

    public byte[] generateXlsxReportBytes(String templatePath, Map<String, Object> data) {
        return generateReportBytes(templatePath, "xlsx", data);
    }

    */
/**
     * 生成HTML格式报表并返回字节数组
     *
     * @param templatePath 报表模板路径
     * @param data         报表数据
     * @return 报表字节数组
     *//*

    public byte[] generateHtmlReportBytes(String templatePath, Map<String, Object> data) {
        return generateReportBytes(templatePath, "html", data);
    }

    */
/**
     * 生成指定格式的报表并返回字节数组
     *
     * @param templatePath 报表模板路径
     * @param format       报表格式 (xlsx, html等)
     * @param data         报表数据
     * @return 报表字节数组
     *//*

    public byte[] generateReportBytes(String templatePath, String format, Map<String, Object> data) {
        try {
            // 创建临时文件
            Path tempFile = Files.createTempFile("report_", "." + format);

            try {
                // 生成报表到临时文件
                generateReport(templatePath, format, data, tempFile.toString());

                // 读取文件内容为字节数组
                return Files.readAllBytes(tempFile);
            } finally {
                // 删除临时文件
                try {
                    Files.deleteIfExists(tempFile);
                } catch (Exception e) {
                    log.warn("删除临时文件失败: {}", tempFile, e);
                }
            }
        } catch (Exception e) {
            log.error("生成报表字节数组失败，模板路径: {}, 格式: {}", templatePath, format, e);
            throw new CommonException("生成报表失败: " + e.getMessage(), e);
        }
    }

    */
/**
     * 验证报表模板是否存在
     *
     * @param templatePath 报表模板路径
     * @return 模板是否存在
     *//*

    public boolean isTemplateExists(String templatePath) {
        try {
            return ResourceUtil.getResource("_vfs" + templatePath) != null;
        } catch (Exception e) {
            return false;
        }
    }

    */
/**
     * 创建报表引擎
     *
     * @return 报表引擎实例
     *//*

    IReportEngine newReportEngine() {
        ReportEngine reportEngine = new ReportEngine();
        Map<String, io.nop.report.core.engine.IReportRendererFactory> renderers = new HashMap<>();
        renderers.put(XptConstants.RENDER_TYPE_XLSX, new XlsxReportRendererFactory());
        renderers.put(XptConstants.RENDER_TYPE_HTML, new HtmlReportRendererFactory());
        reportEngine.setRenderers(renderers);
        return reportEngine;
    }
}*/

package com.fliad.report.controller;

import com.fliad.common.pojo.CommonResult;
import io.nop.api.core.annotations.biz.BizQuery;
import io.nop.api.core.annotations.core.Name;
import io.nop.api.core.annotations.core.Optional;
import io.nop.api.core.beans.TreeResultBean;
import io.nop.api.core.util.Guard;
import io.nop.commons.util.StringHelper;
import io.nop.core.lang.eval.IEvalScope;
import io.nop.core.resource.IResource;
import io.nop.core.resource.VirtualFileSystem;
import io.nop.core.resource.tpl.ITextTemplateOutput;
import io.nop.report.core.engine.IReportEngine;
import io.nop.xlang.api.XLang;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.snack.ONode;
import org.noear.solon.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 报表控制器，提供生成报表的REST API接口
 */
@Api(tags = "报表控制器")
@Controller
@Mapping("/report")
public class ReportController {

    @Inject
    IReportEngine reportEngine;

    private static final Logger log = LoggerFactory.getLogger(ReportController.class);
    private final String REPORT_DEMO_PATH = "/nop/report/demo";

    @ApiOperation("getDemoReports")
    @Get
    @Mapping("/getDemoReports")
    public CommonResult<List<TreeResultBean>> getDemoReports() {
        List<? extends IResource> groups = VirtualFileSystem.instance().getChildren(REPORT_DEMO_PATH);
        List<TreeResultBean> nodes = new ArrayList<>();
        for (IResource resource : groups) {
            if (resource.getName().equals("ext"))
                continue;
            List<TreeResultBean> reports = getReportBeans(resource);
            if (!reports.isEmpty()) {
                TreeResultBean bean = new TreeResultBean();
                bean.setLabel(resource.getName());
                bean.setValue(null);
                bean.setChildren(reports);
                nodes.add(bean);
            }
        }
        return CommonResult.data(nodes);
    }

    List<TreeResultBean> getReportBeans(IResource resource) {
        List<? extends IResource> children = VirtualFileSystem.instance().getChildren(resource.getStdPath());
        if (children.isEmpty())
            return Collections.emptyList();

        List<TreeResultBean> ret = new ArrayList<>();
        for (IResource child : children) {
            if (!child.getName().startsWith("~") && child.getName().endsWith(".xpt.xlsx")) {
                TreeResultBean bean = new TreeResultBean();
                String rptName = StringHelper.removeTail(child.getName(), ".xpt.xlsx");
                bean.setLabel(rptName);
                bean.setValue(StringHelper.removeHead(child.getPath(), REPORT_DEMO_PATH));
                ret.add(bean);
            }
        }
        return ret;
    }

    @ApiOperation("renderHtml")
    @Post
    @Mapping("/renderHtml")
    public CommonResult<String> renderHtml(String reportName, Map<String, Object> data) {
        Guard.checkArgument(StringHelper.isValidVPath(reportName));
        String path = REPORT_DEMO_PATH + reportName;

        ITextTemplateOutput output = reportEngine.getHtmlRenderer(path);
        IEvalScope scope = XLang.newEvalScope();
        // 通过scope可以给报表传参数
        if (data != null)
            scope.setLocalValues(data);
        String text = output.generateText(scope);

        return CommonResult.data(text);
    }

}

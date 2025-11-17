package com.fliad.resource.modular.flowgram.components;

import cn.hutool.core.io.FileUtil;
import com.fliad.resource.modular.flowgram.domain.NodeStatus;
import com.fliad.resource.modular.flowgram.domain.TaskReportOutput;
import io.nop.api.core.util.SourceLocation;
import io.nop.core.lang.eval.IEvalScope;
import io.nop.core.lang.xml.XNode;
import io.nop.core.lang.xml.parse.XNodeParser;
import io.nop.core.resource.IResource;
import io.nop.core.resource.ResourceHelper;
import io.nop.core.resource.VirtualFileSystem;
import io.nop.xlang.api.XLang;
import org.noear.snack.ONode;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Component;
import org.noear.solon.expression.snel.SnEL;
import org.noear.solon.flow.FlowContext;
import org.noear.solon.flow.Node;
import org.noear.solon.flow.TaskComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component("code")
public class CodeCom implements TaskComponent {

    private static final Logger log = LoggerFactory.getLogger(CodeCom.class);

    // 缓存ScriptEngineManager，避免重复创建
    private static final ScriptEngineManager SCRIPT_ENGINE_MANAGER = new ScriptEngineManager();

    // 缓存XLang编译工具配置
    private static final Map<String, Object> XLANG_COMPILE_OPTIONS;

    static {
        Map<String, Object> map = new HashMap<>();
        map.put("allowUnregisteredScopeVar", true);
        XLANG_COMPILE_OPTIONS = Collections.unmodifiableMap(map);
    }

    // 系统属性设置（只需执行一次）
    static {
        System.setProperty("polyglot.js.nashorn-compat", "true");
        System.setProperty("graaljs.insecure-scriptengine-access", "true");
    }

    @Override
    public void run(FlowContext context, Node node) throws Exception {
        try {
            Map<String, Object> inputsData = buildInputsData(context, node);
            Object result = executeScript(context, node, inputsData);
            handleExecutionResult(context, result);
        } catch (Exception e) {
            log.error("Code component execution failed for node: {}", node.getId(), e);
            throw new RuntimeException("Script execution failed: " + e.getMessage(), e);
        }
    }

    /**
     * 构建输入数据映射
     */
    private Map<String, Object> buildInputsData(FlowContext context, Node node) {
        TaskReportOutput report = context.getAs("report");
        if (report == null) {
            log.warn("No task report found in context");
            return Collections.emptyMap();
        }

        Map<String, Object> inputsData = new HashMap<>();
        ONode metaNode = ONode.load(node.getMetas());

        metaNode.select("data.inputsValues").forEach((key, valueNode) -> {
            try {
                String type = valueNode.get("type").getString();
                Object value = extractValueByType(context, report, valueNode, type);
                if (value != null) {
                    inputsData.put(key, value);
                }
            } catch (Exception e) {
                log.warn("Failed to extract input value for key: {}, error: {}", key, e.getMessage());
            }
        });

        return inputsData;
    }

    /**
     * 根据类型提取值
     */
    private Object extractValueByType(FlowContext context, TaskReportOutput report,
                                      ONode valueNode, String type) {
        switch (type) {
            case "ref":
                String nodeId = valueNode.get("content").get(0).getString();
                String expression = valueNode.get("content").get(1).getString();
                return evaluateReferenceExpression(report, nodeId, expression);

            case "constant":
                return valueNode.get("content").getString();

            default:
                log.warn("Unknown value type: {}", type);
                return null;
        }
    }

    /**
     * 评估引用表达式
     */
    private Object evaluateReferenceExpression(TaskReportOutput report, String nodeId, String expression) {
        try {
            NodeStatus nodeStatus = report.getNodeStatus(nodeId);
            if (nodeStatus == null || nodeStatus.getLastSnapshot() == null) {
                log.warn("Node status or snapshot not found for node: {}", nodeId);
                return null;
            }
            return SnEL.eval(expression, nodeStatus.getLastSnapshot().getOutputs());
        } catch (Exception e) {
            log.error("Failed to evaluate expression for node {}: {}", nodeId, expression, e);
            return null;
        }
    }

    /**
     * 执行脚本
     */
    private Object executeScript(FlowContext context, Node node, Map<String, Object> inputsData) throws Exception {
        ONode metaNode = ONode.load(node.getMetas());
        String language = metaNode.select("data.script.language").getString();
        String scriptContent = metaNode.select("data.script.content").getString();

        if ("xlang".equals(language)) {
            return executeXlangScript(node, inputsData, scriptContent);
        } else {
            return executeJavaScript(inputsData, scriptContent);
        }
    }

    /**
     * 执行XLang脚本
     */
    private Object executeXlangScript(Node node, Map<String, Object> inputsData, String scriptContent) {
        IEvalScope scope = XLang.newEvalScope();
        scope.setLocalValues(inputsData);

        String scriptPath = "/nop/debug/" + node.getId() + ".xpl";
        if (Solon.cfg().isDebugMode()) {
            // 使用临时文件管理，确保资源清理
            File scriptFile = new File(ResourceHelper.getOverrideVFsDir().getAbsoluteFile() + scriptPath);

            if (!scriptFile.exists()) {
                // 确保目录存在并创建临时文件
                FileUtil.mkdir(scriptFile.getParentFile());
                FileUtil.writeString(scriptContent, scriptFile, StandardCharsets.UTF_8);
            }
            IResource resource = VirtualFileSystem.instance().getResource(scriptPath);
            XNode xnode = XNodeParser.instance().parseFromResource(resource);

            return XLang.newCompileTool()
                    .allowUnregisteredScopeVar(true)
                    .compileTagBody(xnode)
                    .invoke(scope);
        } else {
            XNode xnode = XNodeParser.instance().parseFromText(SourceLocation.fromPath(scriptPath), scriptContent);
            return XLang.newCompileTool()
                    .allowUnregisteredScopeVar(true)
                    .compileTagBody(xnode)
                    .invoke(scope);
        }

    }

    /**
     * 执行JavaScript脚本
     */
    private Object executeJavaScript(Map<String, Object> inputsData, String scriptContent) throws Exception {
        ScriptEngine scriptEngine = SCRIPT_ENGINE_MANAGER.getEngineByName("JavaScript");
        if (scriptEngine == null) {
            throw new IllegalStateException("JavaScript engine not available");
        }

        // 设置执行上下文
        setupScriptEngineContext(scriptEngine, inputsData);

        return scriptEngine.eval(scriptContent);
    }

    /**
     * 设置脚本引擎上下文
     */
    private void setupScriptEngineContext(ScriptEngine scriptEngine, Map<String, Object> inputsData) {
        // 设置输入参数
        inputsData.forEach(scriptEngine::put);

        // 设置工具对象
        scriptEngine.put("log", log);
        scriptEngine.put("utils", new Facade());
    }

    /**
     * 处理执行结果
     */
    private void handleExecutionResult(FlowContext context, Object result) {
        Map<String, Object> output;

        if (result instanceof Map) {
            output = (Map<String, Object>) result;
        } else {
            output = new HashMap<>();
            output.put("result", result);
        }

        context.put("output", output);

        if (log.isDebugEnabled()) {
            log.debug("Script execution completed, output size: {}", output.size());
        }
    }
}

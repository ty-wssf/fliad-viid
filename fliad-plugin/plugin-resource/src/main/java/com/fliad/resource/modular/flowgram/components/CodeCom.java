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
import io.nop.xlang.api.ExprEvalAction;
import io.nop.xlang.api.XLang;
import io.nop.xlang.api.XplModel;
import io.nop.xlang.ast.XLangOutputMode;
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

    private Object executeXlangScript(Node node, Map<String, Object> inputsData, String scriptContent) {
        IEvalScope scope = XLang.newEvalScope();
        scope.setLocalValues(inputsData);

        String scriptPath = "/nop/debug/" + node.getId() + ".xpl";

        if (Solon.cfg().isDebugMode()) {
            // 调试模式:以文件为主
            File scriptFile = new File(ResourceHelper.getOverrideVFsDir().getAbsoluteFile() + scriptPath);

            if (!scriptFile.exists()) {
                FileUtil.mkdir(scriptFile.getParentFile());
                FileUtil.writeString(scriptContent, scriptFile, StandardCharsets.UTF_8);
            }

            // 从文件读取内容并解析 outputMode
            IResource resource = VirtualFileSystem.instance().getResource(scriptPath);
            String fileContent = resource.readText();
            XNode xnode = XNodeParser.instance().parseFromText(resource.location(), fileContent);
            XLangOutputMode outputMode = getOutputModeFromNode(xnode);

            // 使用解析出的 outputMode 来编译模型
            XplModel model = XLang.parseXpl(resource, outputMode);

            return executeByOutputMode(model, scope, outputMode);
        } else {
            // 非调试模式:从内存内容解析
            XNode xnode = XNodeParser.instance().parseFromText(SourceLocation.fromPath(scriptPath), scriptContent);
            XLangOutputMode outputMode = getOutputModeFromNode(xnode);

            ExprEvalAction action = XLang.newCompileTool()
                    .allowUnregisteredScopeVar(true)
                    .compileTagBody(xnode, outputMode);

            return executeByOutputMode(action, scope, outputMode);
        }
    }

    /**
     * 从 XNode 中提取 outputMode 属性
     */
    private XLangOutputMode getOutputModeFromNode(XNode node) {
        // 检查根节点的 xpl:outputMode 属性
        String outputModeStr = node.attrText("outputMode");
        if (outputModeStr != null) {
            XLangOutputMode mode = XLangOutputMode.fromText(outputModeStr);
            if (mode != null) {
                return mode;
            }
        }

        // 如果没有显式指定,使用默认值 html (与 XplModelParser 保持一致)
        return XLangOutputMode.none;
    }

    /**
     * 根据 outputMode 选择正确的执行方法
     */
    private Object executeByOutputMode(ExprEvalAction action, IEvalScope scope, XLangOutputMode outputMode) {
        switch (outputMode) {
            case none:
                // 不允许输出,返回执行结果
                return action.invoke(scope);

            case text:
            case html:
            case xml:
                // 输出文本格式
                return action.generateText(scope);

            case node:
            case xjson:
                // 输出 XNode 对象
                return action.generateNode(scope);

            case sql:
                // SQL 模式也返回文本,但包含参数信息
                return action.generateText(scope);

            default:
                // 默认使用 invoke
                return action.invoke(scope);
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

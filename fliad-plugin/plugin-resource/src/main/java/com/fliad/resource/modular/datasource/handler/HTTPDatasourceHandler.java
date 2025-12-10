package com.fliad.resource.modular.datasource.handler;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.fliad.common.listener.AbstractCommonDataChangeListener;
import com.fliad.resource.modular.datasource.entity.ResourceDatasource;
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
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HTTP数据源处理器
 *
 * @author wyl
 * @date 2025/09/25 10:00
 */
public class HTTPDatasourceHandler extends AbstractCommonDataChangeListener implements DatasourceHandler {
    private static final Logger log = LoggerFactory.getLogger(HTTPDatasourceHandler.class);

    // 存储HTTP接口处理器
    private final Map<String, Handler> httpEndpointHandlers = new ConcurrentHashMap<>();

    @Override
    public void doUpdateWithData(String dataType, JSONObject jsonObject) {
        // 更新事件
    }

    @Override
    public void initConnection(ResourceDatasource datasource) {
        initHttpEndpoint(datasource);
    }

    @Override
    public void closeConnection(String datasourceId) {
        // HTTP端点在应用关闭时自动清理，此处只需移除引用
        httpEndpointHandlers.remove(datasourceId);
        log.info("移除HTTP端点处理器引用，数据源ID：{}", datasourceId);
    }

    @Override
    public String getSupportedType() {
        return "http";
    }

    /**
     * 初始化 HTTP 接口端点
     *
     * @param datasource 数据源实体
     */
    private void initHttpEndpoint(ResourceDatasource datasource) {
        try {
            // 解析 HTTP 配置
            String content = datasource.getContent();
            if (StrUtil.isBlank(content)) {
                log.warn("HTTP数据源配置内容为空，数据源ID：{}", datasource.getId());
                return;
            }

            ONode config = ONode.load(handleEscapeCharacters(content));
            String path = config.get("path").getString();
            String method = config.get("method").getString();

            log.info("注册HTTP接口：path={}, method={}", path, method);

            // 创建处理器
            Handler handler = new HttpEndpointHandler(datasource, config);

            // 注册路由
            Solon.app().router().add(path, handler);

            // 存储处理器引用
            httpEndpointHandlers.put(datasource.getId(), handler);

            log.info("HTTP 接口注册完成，数据源ID：{}，路径：{}", datasource.getId(), path);
        } catch (Exception e) {
            log.error("注册 HTTP 接口失败，数据源ID：{}", datasource.getId(), e);
        }
    }

    /**
     * HTTP 接口处理器
     */
    private static class HttpEndpointHandler implements Handler {
        private final ResourceDatasource datasource;
        private final ONode config;

        public HttpEndpointHandler(ResourceDatasource datasource, ONode config) {
            this.datasource = datasource;
            this.config = config;
        }

        @Override
        public void handle(Context ctx) throws Throwable {
            log.info("处理HTTP请求，数据源ID：{}，订阅类别：{}", datasource.getId(), datasource.getSubscribeDetail());

            // 获取请求体
            String requestBody = ctx.body();
            String script = config.get("script").getString();

            // 构建输入上下文
            Map<String, Object> inputsData = new HashMap<>();
            inputsData.put("requestBody", requestBody);
            inputsData.put("method", ctx.method());
            inputsData.put("path", ctx.path());
            inputsData.put("params", ctx.paramMap());
            inputsData.put("headers", ctx.headerMap());

            Object result = executeXlangScript(datasource.getId(), inputsData, script);
            // 返回成功响应
            ctx.status(200);
            ctx.render(result);
        }
    }

    private static Object executeXlangScript(String id, Map<String, Object> inputsData, String scriptContent) {
        IEvalScope scope = XLang.newEvalScope();
        scope.setLocalValues(inputsData);

        String scriptPath = "/nop/debug/" + id + ".xpl";

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
    private static XLangOutputMode getOutputModeFromNode(XNode node) {
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
    private static Object executeByOutputMode(ExprEvalAction action, IEvalScope scope, XLangOutputMode outputMode) {
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
     * 处理字符串中的转义字符
     *
     * @param jsonStr 包含可能转义字符的JSON字符串
     * @return 处理后的JSON字符串
     */
    private String handleEscapeCharacters(String jsonStr) {
        if (jsonStr == null || jsonStr.isEmpty()) {
            return jsonStr;
        }

        // 先尝试直接解析
        if (isValidJson(jsonStr)) {
            return jsonStr;
        }

        // 尝试不同的策略来修复转义字符
        String[] strategies = {
                jsonStr.replace("\\\"", "\""),           // 将 \" 替换为 "
                jsonStr.replace("\\\\", "\\"),           // 将 \\ 替换为 \
                jsonStr.replace("\\\"", "\"").replace("\\\\", "\\"),  // 组合策略1
                jsonStr.replace("\\\\\"", "\"").replace("\\\\'", "'"), // 组合策略2
        };

        // 尝试每种策略，找到第一个能生成有效JSON的
        for (String strategy : strategies) {
            if (isValidJson(strategy)) {
                return strategy;
            }
        }

        // 如果所有策略都失败，返回原始字符串
        return jsonStr;
    }

    /**
     * 检查字符串是否为有效的JSON
     *
     * @param jsonStr 待检查的字符串
     * @return 是否为有效的JSON
     */
    private boolean isValidJson(String jsonStr) {
        try {
            ONode.loadStr(jsonStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
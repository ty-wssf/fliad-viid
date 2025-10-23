package com.fliad.resource.modular.flowgram.components;

import com.fliad.resource.modular.flowgram.domain.TaskReportOutput;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Value;
import org.noear.snack.ONode;
import org.noear.solon.expression.snel.SnEL;
import org.noear.solon.flow.FlowContext;
import org.noear.solon.flow.Node;
import org.noear.solon.flow.TaskComponent;
import org.noear.solon.net.http.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

// @Component("code")
public class CodeCom1 implements TaskComponent {
    private static final Logger log = LoggerFactory.getLogger(CodeCom1.class);

    @Override
    public void run(FlowContext context, Node node) throws Throwable {
        TaskReportOutput report = context.getAs("report");
        Map<String, Object> inputsData = new HashMap<>();
        ONode.load(node.getMetas()).select("data.inputsValues").forEach((key, value) -> {
            if ("ref".equals(value.get("type").getString())) {
                String nodeID = value.get("content").get(0).getString();

                inputsData.put(key, SnEL.eval(value.get("content").get(1).getString(), report.getNodeStatus(nodeID).getLastSnapshot().getOutputs()));
            } else if ("constant".equals(value.get("type").getString())) {
                inputsData.put(key, value.get("content").getString());
            }
        });

        // 使用GraalVM Polyglot API执行JavaScript代码
        log.debug("执行JavaScript代码：{}", ONode.load(node.getMetas()).select("data.script.content").getString());
        try (Context polyglotContext = Context.newBuilder("js")
                .allowHostAccess(HostAccess.ALL)  // 允许JavaScript访问Java对象的所有公共成员
                .allowPolyglotAccess(org.graalvm.polyglot.PolyglotAccess.NONE)
                .allowExperimentalOptions(true)
                .option("js.syntax-extensions", "true")
                .option("js.load", "true")
                .option("js.print", "true")
                .option("js.global-arguments", "true")
                .option("js.charset", "UTF-8")
                .build()) {

            // 将输入数据绑定到JavaScript上下文
            for (Map.Entry<String, Object> entry : inputsData.entrySet()) {
                polyglotContext.getBindings("js").putMember(entry.getKey(), entry.getValue());
            }

            // 添加日志支持
            polyglotContext.getBindings("js").putMember("log", log);
            polyglotContext.getBindings("js").putMember("httpUtil", HttpUtils.class);

            // 执行脚本
            String scriptContent = ONode.load(node.getMetas()).select("data.script.content").getString();
            Value result = polyglotContext.eval("js", scriptContent);

            // 处理结果
            Map<String, Object> resultMap;
            if (result.hasMembers()) {
                // 如果是JS对象(有成员属性)，直接放入上下文
                resultMap = new HashMap<>(result.as(Map.class));
            } else {
                // 否则包装一层
                resultMap = new HashMap<>();
                if (result.isHostObject()) {
                    resultMap.put("result", result.asHostObject());
                } else if (result.isNumber()) {
                    resultMap.put("result", result.as(Number.class));
                } else if (result.isBoolean()) {
                    resultMap.put("result", result.as(Boolean.class));
                } else {
                    resultMap.put("result", result.asString());
                }
            }
            context.put("output", resultMap);
        } catch (Throwable e) {
            log.error("Error executing JavaScript code with GraalVM Polyglot", e);
            throw e;
        }
    }
}

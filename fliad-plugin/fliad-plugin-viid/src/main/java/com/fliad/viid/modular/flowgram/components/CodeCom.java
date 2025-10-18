package com.fliad.viid.modular.flowgram.components;

import com.fliad.viid.modular.flowgram.domain.TaskReportOutput;
import lombok.extern.slf4j.Slf4j;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Value;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.expression.snel.SnEL;
import org.noear.solon.flow.FlowContext;
import org.noear.solon.flow.Node;
import org.noear.solon.flow.TaskComponent;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component("code")
public class CodeCom implements TaskComponent {

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
        log.info("执行JavaScript代码：{}", ONode.load(node.getMetas()).select("data.script.content").getString());
        try (Context polyglotContext = Context.newBuilder("js")
                .allowHostAccess(HostAccess.ALL)  // 允许JavaScript访问Java对象的所有公共成员
                .allowPolyglotAccess(org.graalvm.polyglot.PolyglotAccess.NONE)
                .build()) {
            
            // 将输入数据绑定到JavaScript上下文
            for (Map.Entry<String, Object> entry : inputsData.entrySet()) {
                polyglotContext.getBindings("js").putMember(entry.getKey(), entry.getValue());
            }
            
            // 添加日志支持
            polyglotContext.getBindings("js").putMember("log", log);
            
            // 执行脚本
            String scriptContent = ONode.load(node.getMetas()).select("data.script.content").getString();
            Value result = polyglotContext.eval("js", scriptContent);
            
            // 处理结果
            if (result.isHostObject() && result.asHostObject() instanceof Map) {
                context.put("output", result.asHostObject());
            } else {
                Map<String, Object> resultMap = new HashMap<>();
                resultMap.put("result", result.isHostObject() ? result.asHostObject() : result.toString());
                context.put("output", resultMap);
            }
        } catch (Throwable e) {
            log.error("Error executing JavaScript code with GraalVM Polyglot", e);
            throw e;
        }
    }
}

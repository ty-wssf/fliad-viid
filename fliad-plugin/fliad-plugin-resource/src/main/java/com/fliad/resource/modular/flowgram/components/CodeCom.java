package com.fliad.resource.modular.flowgram.components;

import com.fliad.resource.modular.flowgram.domain.TaskReportOutput;
import org.noear.snack.ONode;
import org.noear.solon.expression.snel.SnEL;
import org.noear.solon.flow.FlowContext;
import org.noear.solon.flow.Node;
import org.noear.solon.flow.TaskComponent;
import org.slf4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.HashMap;
import java.util.Map;

// @Component("code")
public class CodeCom implements TaskComponent {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CodeCom.class);

    @Override
    public void run(FlowContext context, Node node) throws Throwable {
        System.setProperty("polyglot.js.nashorn-compat", "true");
        System.setProperty("graaljs.insecure-scriptengine-access", "true");

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
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");

        // 将输入数据放入脚本引擎上下文中
        inputsData.forEach(scriptEngine::put);
        // scriptEngine.put("params", inputsData);
        scriptEngine.put("log", log);
        scriptEngine.put("utils", new Facade());

        Object result = scriptEngine.eval(ONode.load(node.getMetas()).select("data.script.content").getString());

        // 根据result类型决定如何放入context
        if (result instanceof Map) {
            context.put("output", result);
        } else {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("result", result);
            context.put("output", resultMap);
        }
    }
}

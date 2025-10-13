package com.fliad.viid.modular.flowgram.components;

import cn.hutool.script.ScriptUtil;
import com.fliad.viid.modular.flowgram.domain.NodeStatus;
import com.fliad.viid.modular.flowgram.domain.TaskReportOutput;
import lombok.extern.slf4j.Slf4j;
import org.noear.liquor.eval.Scripts;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.expression.snel.SnEL;
import org.noear.solon.flow.FlowContext;
import org.noear.solon.flow.Node;
import org.noear.solon.flow.TaskComponent;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component("code")
public class CodeCom implements TaskComponent {

    @Override
    public void run(FlowContext context, Node node) throws Throwable {
        // ScriptUtil.eval("print('Script test!');");
        // ScriptUtil.eval(ONode.load(node.getMetas()).select("data.script.content").getString());
        // ScriptUtil.invoke()
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
package com.fliad.resource.modular.flowgram.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.fliad.resource.modular.flowgram.domain.*;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;
import org.noear.solon.data.cache.CacheService;
import org.noear.solon.expression.snel.SnEL;
import org.noear.solon.flow.*;
import org.noear.solon.flow.driver.SimpleFlowDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class FlowgramService implements LifecycleBean {

    private Logger log = LoggerFactory.getLogger(FlowgramService.class);

    private FlowEngine flowEngine;

    @Inject
    CacheService cacheService;
    // 用于存储全局的FlowContext实例
    // private final Map<String, FlowContext> contextMap = new ConcurrentHashMap<>();

    // 用于缓存Chain对象，key为schema内容的MD5值
    private final Map<String, Chain> chainCache = new ConcurrentHashMap<>();

    @Override
    public void start() throws Throwable {
        flowEngine = FlowEngine.newInstance();
        // 注册驱动
        flowEngine.register(new SimpleFlowDriver() {
            @Override
            public void onNodeStart(FlowExchanger exchanger, Node node) {
                // 只在测试模式下处理 report 相关逻辑
                TaskReportOutput report = exchanger.context().getAs("report");
                if (report != null) {
                    NodeStatus nodeStatus = report.getNodeStatus(node.getId());
                    if (node.getType() == NodeType.START) {
                        nodeStatus.success();
                        nodeStatus.addSnapshot(new Snapshot(node.getId()));
                        nodeStatus.getLastSnapshot().setOutputs(report.getInputs());
                    } else if (node.getType() == NodeType.END) {
                        // ...
                    }
                }
            }

            @Override
            public void onNodeEnd(FlowExchanger exchanger, Node node) {
                // 只在测试模式下处理 report 相关逻辑
                TaskReportOutput report = exchanger.context().getAs("report");
                if (report != null) {
                    NodeStatus nodeStatus = report.getNodeStatus(node.getId());
                    if (node.getType() == NodeType.END) {
                        nodeStatus.addSnapshot(new Snapshot(node.getId()));
                        Map<String, Object> inputsData = new HashMap<>();
                        ONode.load(node.getMetas()).select("data.inputsValues").forEach((key, value) -> {
                            if ("ref".equals(value.get("type").getString())) {
                                String nodeID = value.get("content").get(0).getString();

                                inputsData.put(key, SnEL.eval(value.get("content").get(1).getString(), report.getNodeStatus(nodeID).getLastSnapshot().getOutputs()));
                            } else if ("constant".equals(value.get("type").getString())) {
                                inputsData.put(key, value.get("content").getString());
                            }
                        });
                        nodeStatus.getLastSnapshot().setInputs(inputsData);
                        nodeStatus.getLastSnapshot().setOutputs(inputsData);
                        report.setOutputs(inputsData);
                        nodeStatus.success();
                        // 更新流程整体状态
                        report.getWorkflowStatus().success();
                    }
                }
            }

            @Override
            public void handleTask(FlowExchanger exchanger, Task task) throws Throwable {
                TaskReportOutput report = exchanger.context().getAs("report");
                if (report != null) {
                    NodeStatus nodeStatus = report.getNodeStatus(task.getNode().getId());
                    if (task.getNode().getType() == NodeType.ACTIVITY) {
                        nodeStatus.addSnapshot(new Snapshot(task.getNode().getId()));
                        // 处理输入
                        Map<String, Object> inputsData = new HashMap<>();
                        ONode.load(task.getNode().getMetas()).select("data.inputsValues").forEach((key, value) -> {
                            if ("ref".equals(value.get("type").getString())) {
                                String nodeID = value.get("content").get(0).getString();

                                inputsData.put(key, SnEL.eval(value.get("content").get(1).getString(), report.getNodeStatus(nodeID).getLastSnapshot().getOutputs()));
                            } else if ("constant".equals(value.get("type").getString())) {
                                inputsData.put(key, value.get("content").getString());
                            }
                        });
                        nodeStatus.getLastSnapshot().setInputs(inputsData);

                        try {
                            // 执行任务
                            super.handleTask(exchanger, task);
                            nodeStatus.getLastSnapshot().setOutputs(exchanger.context().getAs("output"));
                            nodeStatus.success();
                        } catch (Throwable e) {
                            nodeStatus.fail();
                            String errorMessage = getStackTraceAsString(e);
                            nodeStatus.getLastSnapshot().setError(errorMessage);
                            report.getWorkflowStatus().fail();
                            throw e;
                        }

                    } else if (task.getNode().getType() == NodeType.INCLUSIVE) {
                        // 执行任务
                        nodeStatus.addSnapshot(new Snapshot(task.getNode().getId()));
                        super.handleTask(exchanger, task);
                        // nodeStatus.getLastSnapshot().setOutputs(exchanger.context().getAs("output"));
                        nodeStatus.success();
                    }
                } else {
                    super.handleTask(exchanger, task);
                }
            }

            @Override
            protected boolean tryAsScriptCondition(FlowExchanger exchanger, Condition condition, String description) throws Throwable {
                if (StrUtil.isNotBlank(description)) {
                    // 执行条件的时候不知道
                    String nodeId = description.split("#")[0];
                    String key = description.split("#")[1];
                    TaskReportOutput report = exchanger.context().getAs("report");
                    if (report != null) {
                        Node node = condition.getChain().getNode(nodeId);
                        Map<String, Object> data = node.getMeta("data");
                        List<Map<String, Object>> conditions = (List<Map<String, Object>>) data.get("conditions");
                        for (Map<String, Object> condition_ : conditions) {
                            if (key.equals(condition_.get("key"))) {
                                ONode conditionNode = ONode.load(condition_);
                                String valueNodeId = conditionNode.select("value.left.content[0]").getString();
                                String valueNodeKey = conditionNode.select("value.left.content[1]").getString();
                                ONode leftValueNodeJson = ONode.load(condition.getChain().getNode(valueNodeId).getMetas());
                                String type = leftValueNodeJson.select(String.format("data.outputs.properties.%s.type", valueNodeKey)).getString();
                                Object leftValue = null;
                                if ("string".equals(type)) {
                                    leftValue = "'" + report.getNodeStatus(valueNodeId).getLastSnapshot().getOutputs().get(valueNodeKey) + "'";
                                } else {
                                    leftValue = report.getNodeStatus(valueNodeId).getLastSnapshot().getOutputs().get(valueNodeKey);
                                }
                                Object rightValue = conditionNode.select("value.right.content").getString();
                                String code = leftValue + convertOperator(conditionNode.select("value.operator").getString()) + rightValue;
                                boolean res = (boolean) SnEL.eval(code, new HashMap());
                                report.getNodeStatus(nodeId).getLastSnapshot().getOutputs().put(valueNodeId + "." + valueNodeKey + convertOperator(conditionNode.select("value.operator").getString()) + rightValue, res);
                                return res;
                            }
                        }
                    }
                } else {
                    return super.tryAsScriptCondition(exchanger, condition, description);
                }
                return super.tryAsScriptCondition(exchanger, condition, description);
            }

            // 转化操作符
            private String convertOperator(String operator) {
                if ("gte".equals(operator)) {
                    return " >= ";
                } else if ("lte".equals(operator)) {
                    return " <= ";
                } else if ("gt".equals(operator)) {
                    return " > ";
                } else if ("lt".equals(operator)) {
                    return " < ";
                } else if ("eq".equals(operator)) {
                    return " == ";
                } else if ("neq".equals(operator)) {
                    return " != ";
                } else if ("contains".equals(operator)) {
                    return " LIKE ";
                } else if ("not contains".equals(operator)) {
                    return " NOT LIKE ";
                } else {
                    return operator;
                }
            }
        });
    }

    public void taskRun(boolean test, TaskRunInput request, String taskId) {
        FlowContext context = FlowContext.of(taskId);
        context.put("report", new TaskReportOutput(context.getInstanceId(), request.getInputs()));

        if (test) {
            cacheService.store(context.getInstanceId(), context, 60);
        }

        // 根据schema内容生成唯一key，用于缓存Chain对象
        String schemaKey = DigestUtil.md5Hex(request.getSchema());
        Chain chain = chainCache.get(schemaKey);

        // 如果缓存中没有找到对应的Chain对象，则构建新的Chain对象并缓存
        if (chain == null) {
            chain = new ChainDecl(IdUtil.getSnowflakeNextIdStr(), "").create(decl -> {
                ONode.load(request.getSchema()).get("nodes").forEach(node -> {
                    NodeDecl nodeDecl;
                    // 开始
                    if (node.get("type").getString().equals("start")) {
                        nodeDecl = NodeDecl.startOf(node.get("id").getString()).title(node.get("data").get("title").getString());
                    } else if (node.get("type").getString().equals("end")) { // 结束
                        nodeDecl = NodeDecl.endOf(node.get("id").getString()).title(node.get("data").get("title").getString());
                    } else if (node.get("type").getString().equals("http")) { // 结束
                        nodeDecl = NodeDecl.activityOf(node.get("id").getString()).title(node.get("data").get("title").getString()).task("@http");
                    } else if (node.get("type").getString().equals("rabbitmq")) {
                        nodeDecl = NodeDecl.activityOf(node.get("id").getString()).title(node.get("data").get("title").getString()).task("@rabbitmq");
                    } else if (node.get("type").getString().equals("database")) {
                        nodeDecl = NodeDecl.activityOf(node.get("id").getString()).title(node.get("data").get("title").getString()).task("@database");
                    } else if (node.get("type").getString().equals("code")) {
                        nodeDecl = NodeDecl.activityOf(node.get("id").getString()).title(node.get("data").get("title").getString()).task("@code");
                    } else if (node.get("type").getString().equals("condition")) { // 条件
                        // 包容网关（类似多选）
                        nodeDecl = NodeDecl.inclusiveOf(node.get("id").getString()).title(node.get("data").get("title").getString());
                    } else {
                        nodeDecl = null;
                        log.warn("没有处理的节点类型：{}", node.get("type").getString());
                    }
                    if (nodeDecl != null) {
                        nodeDecl.metaPut("data", node.get("data").toData());
                        ONode.load(request.getSchema()).get("edges").forEach(edge -> {
                            if (node.get("id").getString().equals(edge.get("sourceNodeID").getString())) {
                                // 条件组件即网关情况
                                if (edge.contains("sourcePortID")) {
                                    node.get("data").get("conditions").forEach(condition -> {
                                        if (edge.get("sourcePortID").getString().equals(condition.get("key").getString())) {
                                            nodeDecl.linkAdd(edge.get("targetNodeID").getString(), l -> {
                                                l.when(node.get("id").getString() + "#" + condition.get("key").getString());
                                            });
                                        }
                                    });
                                } else {
                                    nodeDecl.linkAdd(edge.get("targetNodeID").getString());
                                }
                            }
                        });
                        decl.addNode(nodeDecl);
                    }
                });
            });
            // 将新构建的Chain对象缓存起来
            chainCache.put(schemaKey, chain);
        }

        try {
            flowEngine.eval(chain, context);
        } catch (Throwable e) {
            log.error("任务执行失败：", e);
        }
    }

    public TaskReportOutput taskReport(TaskReportInput request) {
        // 从全局map中获取context
        FlowContext context = cacheService.get(request.getTaskID(), FlowContext.class);

        if (context != null) {
            // 获取存储在context中的报告信息
            return context.getAs("report");
        }

        return null;
    }

    public TaskCancelOutput taskCancel(TaskCancelInput request) {
        // 从全局map中获取context
        FlowContext context = cacheService.get(request.getTaskID(), FlowContext.class);
        if (context != null) {
            if (context.exchanger() != null) {
                // 调用exchanger().stop()方法维护流程状态
                context.exchanger().stop();
            }
            // 从map中移除context
            cacheService.remove(request.getTaskID());
            return new TaskCancelOutput(true);
        }
        return new TaskCancelOutput(false);
    }

    public WorkflowOutputs taskResult(TaskResultInput request) {
        return new WorkflowOutputs();
    }

    public TaskValidateOutput taskValidate(TaskValidateInput request) {
        return new TaskValidateOutput(true);
    }

    /**
     * 将异常堆栈信息转换为字符串
     *
     * @param throwable 异常对象
     * @return 堆栈信息字符串
     */
    private String getStackTraceAsString(Throwable throwable) {
        java.io.StringWriter sw = new java.io.StringWriter();
        java.io.PrintWriter pw = new java.io.PrintWriter(sw);
        throwable.printStackTrace(pw);
        return sw.toString();
    }

    public static void main(String[] args) {
        System.out.println(SnEL.eval("'e' == 'e'", new HashMap()));
    }

}

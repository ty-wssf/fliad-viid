package com.fliad.viid.modular.flowgram.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.fliad.viid.modular.flowgram.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.noear.snack.ONode;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;
import org.noear.solon.core.util.RunUtil;
import org.noear.solon.data.cache.CacheService;
import org.noear.solon.expression.snel.SnEL;
import org.noear.solon.flow.*;
import org.noear.solon.flow.driver.SimpleFlowDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class FlowgramService implements LifecycleBean {

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
                            String errorMessage = e.getMessage();
                            if (e.getCause() != null) {
                                errorMessage += "; Cause: " + e.getCause().getMessage();
                            }
                            nodeStatus.getLastSnapshot().setError(errorMessage);
                            report.getWorkflowStatus().fail();
                            throw e;
                        }

                    }
                } else {
                    super.handleTask(exchanger, task);
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
                    } else {
                        nodeDecl = null;
                        log.warn("没有处理的节点类型：{}", node.get("type").getString());
                    }
                    if (nodeDecl != null) {
                        nodeDecl.metaPut("data", node.get("data").toData());
                        ONode.load(request.getSchema()).get("edges").forEach(edge -> {
                            if (node.get("id").getString().equals(edge.get("sourceNodeID").getString())) {
                                nodeDecl.linkAdd(edge.get("targetNodeID").getString());
                            }
                        });
                        decl.addNode(nodeDecl);
                    }
                });
            });
            // 将新构建的Chain对象缓存起来
            chainCache.put(schemaKey, chain);
        }

        flowEngine.eval(chain, context);
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

}

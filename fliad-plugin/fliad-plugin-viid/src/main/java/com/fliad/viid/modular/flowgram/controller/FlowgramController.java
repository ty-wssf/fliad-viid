package com.fliad.viid.modular.flowgram.controller;

import cn.hutool.core.util.IdUtil;
import com.fliad.viid.modular.flowgram.domain.*;
import com.fliad.viid.modular.flowgram.service.FlowgramService;
import io.swagger.annotations.Api;
import org.noear.snack.ONode;
import org.noear.solon.annotation.*;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.util.RunUtil;

import java.io.IOException;

@Api(tags = "flowgram控制器")
@Controller
@Mapping("/api/task/")
public class FlowgramController {

    @Inject
    FlowgramService flowgramService;

    @Post
    @Mapping("/run")
    public TaskRunOutput taskRun(Context ctx) throws IOException {
        TaskRunInput request = ONode.deserialize(ctx.body(), TaskRunInput.class);
        String taskId = IdUtil.getSnowflakeNextIdStr();
        RunUtil.async(() -> {
            flowgramService.taskRun(true, request, taskId);
        });
        return new TaskRunOutput(taskId);
    }

    @Get
    @Mapping("/report")
    public TaskReportOutput taskReport(String taskID) throws IOException {
        TaskReportInput request = new TaskReportInput(taskID);
        return flowgramService.taskReport(request);
    }

    @Put
    @Mapping("/cancel")
    public TaskCancelOutput taskCancel(Context ctx) throws IOException {
        TaskCancelInput request = ONode.deserialize(ctx.body(), TaskCancelInput.class);
        return flowgramService.taskCancel(request);
    }

    @Post
    @Mapping("/result")
    public WorkflowOutputs taskResult(Context ctx) throws IOException {
        TaskResultInput request = ONode.deserialize(ctx.body(), TaskResultInput.class);
        return flowgramService.taskResult(request);
    }

    @Post
    @Mapping("/validate")
    public TaskValidateOutput taskValidate(Context ctx) throws IOException {
        TaskValidateInput request = ONode.deserialize(ctx.body(), TaskValidateInput.class);
        return flowgramService.taskValidate(request);
    }

}

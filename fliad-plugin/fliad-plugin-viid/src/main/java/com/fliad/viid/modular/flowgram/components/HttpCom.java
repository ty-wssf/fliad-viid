package com.fliad.viid.modular.flowgram.components;

import cn.hutool.core.thread.ThreadUtil;
import org.noear.solon.annotation.Component;
import org.noear.solon.flow.FlowContext;
import org.noear.solon.flow.Node;
import org.noear.solon.flow.TaskComponent;

@Component("http")
public class HttpCom implements TaskComponent {

    @Override
    public void run(FlowContext context, Node node) throws Throwable {
        System.out.println("1");
        ThreadUtil.safeSleep(1000 * 60 * 5);
    }

}

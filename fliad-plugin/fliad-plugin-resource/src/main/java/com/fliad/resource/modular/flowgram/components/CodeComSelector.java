package com.fliad.resource.modular.flowgram.components;

import org.noear.solon.annotation.Component;
import org.noear.solon.core.runtime.NativeDetector;
import org.noear.solon.flow.FlowContext;
import org.noear.solon.flow.Node;
import org.noear.solon.flow.TaskComponent;

@Component("code")
public class CodeComSelector implements TaskComponent {

    private final TaskComponent codeComponent;

    public CodeComSelector() {
        if (NativeDetector.inNativeImage()) {
            this.codeComponent = new CodeCom1();
        } else {
            this.codeComponent = new CodeCom();
        }
    }

    @Override
    public void run(FlowContext context, Node node) throws Throwable {
        codeComponent.run(context, node);
    }
}
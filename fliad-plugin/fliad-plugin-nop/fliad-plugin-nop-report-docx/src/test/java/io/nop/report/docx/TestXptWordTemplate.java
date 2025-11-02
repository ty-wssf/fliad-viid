package io.nop.report.docx;

import io.nop.core.initialize.CoreInitialization;
import io.nop.core.lang.eval.IEvalScope;
import io.nop.core.resource.IResource;
import io.nop.core.resource.VirtualFileSystem;
import io.nop.ooxml.docx.WordTemplate;
import io.nop.report.docx.parse.XptWordTemplateParser;
import io.nop.xlang.api.XLang;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestXptWordTemplate {
    @Test
    public void testXptTable() {
        CoreInitialization.initialize();
        IResource resource = VirtualFileSystem.instance().getResource("/test/test-word-report.docx");
        WordTemplate tpl = new XptWordTemplateParser().parseFromResource(resource);
        IEvalScope scope = XLang.newEvalScope();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("amount", 1000);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "李四");
        map1.put("amount", 2000);

        scope.setLocalValue("data", Arrays.asList(map, map1));
        tpl.generateToFile(new File("target/test-result.docx"), scope);
    }
}

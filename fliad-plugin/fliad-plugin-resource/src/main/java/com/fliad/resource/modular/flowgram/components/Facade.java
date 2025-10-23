package com.fliad.resource.modular.flowgram.components;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.ThreadUtil;
import org.noear.solon.net.http.HttpUtils;

import java.io.File;

/**
 * @author wyl
 * @date 2025年10月23日 21:08
 */
public class Facade {

    public HttpUtils http(String url) {
        return HttpUtils.http(url);
    }

    public void sleep(long millis) {
        ThreadUtil.safeSleep(millis);
    }

    public File writeUtf8String(String content, String path) {
        return FileUtil.writeUtf8String(content, path);
    }

}

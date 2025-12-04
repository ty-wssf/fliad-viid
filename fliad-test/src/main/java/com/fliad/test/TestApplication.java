package com.fliad.test;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;

/**
 * 测试应用启动类
 *
 * @author fliad
 */
@SolonMain
public class TestApplication {

    public static void main(String[] args) {
        Solon.start(TestApplication.class, args, app -> {
        });
    }
}
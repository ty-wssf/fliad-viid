package com.fliad.gps;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;
import org.noear.solon.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SolonMain
public class Gps001App {

    public static void main(String[] args) throws InterruptedException {
        Solon.start(Gps001App.class, args, app -> {
            app.enableHttp(true); // 启用HTTP功能
        });
    }

}
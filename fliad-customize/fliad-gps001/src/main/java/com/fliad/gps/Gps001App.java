package com.fliad.gps;

import org.noear.solon.Solon;
import org.noear.solon.SolonApp;
import org.noear.solon.annotation.SolonMain;
import org.noear.solon.core.runtime.NativeDetector;
import org.noear.solon.scheduling.annotation.EnableScheduling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableScheduling
@SolonMain
public class Gps001App {

    public static void main(String[] args) throws InterruptedException {
        Solon.start(Gps001App.class, args);
    }

}

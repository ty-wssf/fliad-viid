package com.fliad.gps002;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;
import org.noear.solon.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SolonMain
public class Gps002App {

    public static void main(String[] args) throws InterruptedException {
        Solon.start(Gps002App.class, args);
    }

}
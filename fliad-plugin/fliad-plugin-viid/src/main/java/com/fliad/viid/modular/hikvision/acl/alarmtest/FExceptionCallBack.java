package com.fliad.viid.modular.hikvision.acl.alarmtest;

import com.fliad.viid.modular.hikvision.acl.NetSDK.HCNetSDK;
import com.sun.jna.Pointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FExceptionCallBack implements HCNetSDK.FExceptionCallBack {

    private static final Logger log = LoggerFactory.getLogger(FExceptionCallBack.class);

    @Override
    public void invoke(int dwType, int lUserID, int lHandle, Pointer pUser) {
        log.info("异常回调：dwType={}, lUserID={}, lHandle={}", dwType, lUserID, lHandle);
    }

}

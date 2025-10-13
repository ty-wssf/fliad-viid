package com.fliad.viid.modular.hikvision.acl.alarmtest;

import com.fliad.viid.modular.hikvision.acl.NetSDK.HCNetSDK;
import com.sun.jna.Pointer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FExceptionCallBack implements HCNetSDK.FExceptionCallBack {

    @Override
    public void invoke(int dwType, int lUserID, int lHandle, Pointer pUser) {
        log.info("异常回调：dwType={}, lUserID={}, lHandle={}", dwType, lUserID, lHandle);
    }

}

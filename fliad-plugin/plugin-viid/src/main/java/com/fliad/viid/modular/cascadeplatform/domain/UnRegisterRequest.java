package com.fliad.viid.modular.cascadeplatform.domain;

public class UnRegisterRequest {

    private UnRegisterRequest.UnRegisterObject UnRegisterObject;

    public com.fliad.viid.modular.cascadeplatform.domain.UnRegisterRequest.UnRegisterObject getUnRegisterObject() {
        return UnRegisterObject;
    }

    public void setUnRegisterObject(com.fliad.viid.modular.cascadeplatform.domain.UnRegisterRequest.UnRegisterObject unRegisterObject) {
        UnRegisterObject = unRegisterObject;
    }

    public static class UnRegisterObject {
        private String DeviceID;

        public String getDeviceID() {
            return DeviceID;
        }

        public void setDeviceID(String deviceID) {
            DeviceID = deviceID;
        }
    }

}
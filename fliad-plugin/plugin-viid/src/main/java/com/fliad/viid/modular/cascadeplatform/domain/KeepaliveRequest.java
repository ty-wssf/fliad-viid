package com.fliad.viid.modular.cascadeplatform.domain;

public class KeepaliveRequest {

    private KeepaliveObject KeepaliveObject;

    public com.fliad.viid.modular.cascadeplatform.domain.KeepaliveRequest.KeepaliveObject getKeepaliveObject() {
        return KeepaliveObject;
    }

    public void setKeepaliveObject(com.fliad.viid.modular.cascadeplatform.domain.KeepaliveRequest.KeepaliveObject keepaliveObject) {
        KeepaliveObject = keepaliveObject;
    }

    public static class KeepaliveObject {

        private String DeviceID;

        public String getDeviceID() {
            return DeviceID;
        }

        public void setDeviceID(String deviceID) {
            DeviceID = deviceID;
        }
    }
}
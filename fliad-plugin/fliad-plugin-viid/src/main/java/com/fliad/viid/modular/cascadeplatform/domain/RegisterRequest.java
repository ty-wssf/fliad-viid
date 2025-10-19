package com.fliad.viid.modular.cascadeplatform.domain;

/**
 * 注册请求
 */
public class RegisterRequest {

    private RegisterObject RegisterObject;

    public com.fliad.viid.modular.cascadeplatform.domain.RegisterRequest.RegisterObject getRegisterObject() {
        return RegisterObject;
    }

    public void setRegisterObject(com.fliad.viid.modular.cascadeplatform.domain.RegisterRequest.RegisterObject registerObject) {
        RegisterObject = registerObject;
    }

    public static class RegisterObject {
        private String DeviceID;
        private String ProtocolVersion;

        public String getDeviceID() {
            return DeviceID;
        }

        public void setDeviceID(String deviceID) {
            DeviceID = deviceID;
        }

        public String getProtocolVersion() {
            return ProtocolVersion;
        }

        public void setProtocolVersion(String protocolVersion) {
            ProtocolVersion = protocolVersion;
        }
    }

}
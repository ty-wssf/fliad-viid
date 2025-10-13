package com.fliad.viid.modular.cascadeplatform.domain;

import lombok.Data;

/**
 * 注册请求
 */
@Data
public class RegisterRequest {

    private RegisterObject RegisterObject;

    @Data
    public static class RegisterObject {
        private String DeviceID;
        private String ProtocolVersion;
    }

}
package com.fliad.viid.modular.cascadeplatform.domain;

import lombok.Data;

@Data
public class UnRegisterRequest {

    private UnRegisterRequest.UnRegisterObject UnRegisterObject;

    @Data
    public static class UnRegisterObject {
        private String DeviceID;
    }

}

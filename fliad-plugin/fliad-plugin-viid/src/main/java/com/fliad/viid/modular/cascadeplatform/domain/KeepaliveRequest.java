package com.fliad.viid.modular.cascadeplatform.domain;

import lombok.Data;

@Data
public class KeepaliveRequest {

    private KeepaliveObject KeepaliveObject;

    @Data
    public static class KeepaliveObject {

        private String DeviceID;

    }

}

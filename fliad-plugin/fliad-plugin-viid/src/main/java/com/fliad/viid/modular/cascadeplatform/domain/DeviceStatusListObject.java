package com.fliad.viid.modular.cascadeplatform.domain;

import java.io.Serializable;
import java.util.List;

public class DeviceStatusListObject implements Serializable {

    private List<APEStatusObject> APEStatusObject;

    public List<APEStatusObject> getAPEStatusObject() {
        return APEStatusObject;
    }

    public void setAPEStatusObject(List<APEStatusObject> APEStatusObject) {
        this.APEStatusObject = APEStatusObject;
    }
}
package com.fliad.viid.modular.cascadeplatform.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DeviceStatusListObject implements Serializable {

    private List<APEStatusObject> APEStatusObject;

}

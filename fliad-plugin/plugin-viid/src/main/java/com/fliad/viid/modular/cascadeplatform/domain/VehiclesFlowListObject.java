package com.fliad.viid.modular.cascadeplatform.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 车流量对象列表
 */
public class VehiclesFlowListObject implements Serializable {

    private List<VehiclesFlowObject> VehiclesFlowObject;

    public List<VehiclesFlowObject> getVehiclesFlowObject() {
        return VehiclesFlowObject;
    }

    public void setVehiclesFlowObject(List<VehiclesFlowObject> vehiclesFlowObject) {
        VehiclesFlowObject = vehiclesFlowObject;
    }
}
package com.fliad.viid.modular.cascadeplatform.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 车流量对象列表
 */
@Data
public class VehiclesFlowListObject implements Serializable {

    private List<VehiclesFlowObject> VehiclesFlowObject;
}
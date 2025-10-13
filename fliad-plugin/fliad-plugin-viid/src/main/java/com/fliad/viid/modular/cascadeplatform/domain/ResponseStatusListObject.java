package com.fliad.viid.modular.cascadeplatform.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseStatusListObject {

    @JsonProperty("ResponseStatusListObject")
    private ResponseStatusList ResponseStatusListObject;

    public ResponseStatusListObject() {
        this.ResponseStatusListObject = new ResponseStatusList();
        this.ResponseStatusListObject.setResponseStatusObject(new ArrayList<>());
    }

    public void addResponseStatus(ResponseStatus responseStatus) {
        this.ResponseStatusListObject.getResponseStatusObject().add(responseStatus);
    }

    @Data
    public static class ResponseStatusList {
        @JsonProperty("ResponseStatusObject")
        private List<ResponseStatus> ResponseStatusObject;
    }

}
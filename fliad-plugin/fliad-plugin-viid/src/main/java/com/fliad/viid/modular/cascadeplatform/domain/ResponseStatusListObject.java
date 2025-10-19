package com.fliad.viid.modular.cascadeplatform.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

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

    public ResponseStatusList getResponseStatusListObject() {
        return ResponseStatusListObject;
    }

    public void setResponseStatusListObject(ResponseStatusList responseStatusListObject) {
        ResponseStatusListObject = responseStatusListObject;
    }

    public static class ResponseStatusList {
        @JsonProperty("ResponseStatusObject")
        private List<ResponseStatus> ResponseStatusObject;

        public List<ResponseStatus> getResponseStatusObject() {
            return ResponseStatusObject;
        }

        public void setResponseStatusObject(List<ResponseStatus> responseStatusObject) {
            ResponseStatusObject = responseStatusObject;
        }
    }

}
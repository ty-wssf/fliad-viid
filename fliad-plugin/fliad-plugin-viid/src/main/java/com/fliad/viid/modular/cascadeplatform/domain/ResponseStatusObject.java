package com.fliad.viid.modular.cascadeplatform.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class ResponseStatusObject {

    @JsonProperty("ResponseStatusObject")
    private ResponseStatus ResponseStatusObject;

    public ResponseStatusObject(String id, String requestURL, int statusCode, String statusString) {
        this.ResponseStatusObject = new ResponseStatus(id, requestURL, statusCode, statusString);
    }

}
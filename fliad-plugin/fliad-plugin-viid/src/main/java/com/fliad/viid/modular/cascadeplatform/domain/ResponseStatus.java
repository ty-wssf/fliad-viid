package com.fliad.viid.modular.cascadeplatform.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class ResponseStatus {

    @JsonProperty("Id")
    private String Id;
    @JsonProperty("LocalTime")
    private String LocalTime;
    @JsonProperty("RequestURL")
    private String RequestURL;
    @JsonProperty("StatusCode")
    private int StatusCode;
    @JsonProperty("StatusString")
    private String StatusString;

    public ResponseStatus(String Id, String RequestURL, int StatusCode, String StatusString) {
        this.Id = Id;
        this.RequestURL = RequestURL;
        this.StatusCode = StatusCode;
        this.StatusString = StatusString;
        this.LocalTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

}
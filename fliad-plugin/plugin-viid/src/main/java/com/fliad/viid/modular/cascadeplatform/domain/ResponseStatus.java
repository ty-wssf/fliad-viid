package com.fliad.viid.modular.cascadeplatform.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLocalTime() {
        return LocalTime;
    }

    public void setLocalTime(String localTime) {
        LocalTime = localTime;
    }

    public String getRequestURL() {
        return RequestURL;
    }

    public void setRequestURL(String requestURL) {
        RequestURL = requestURL;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public String getStatusString() {
        return StatusString;
    }

    public void setStatusString(String statusString) {
        StatusString = statusString;
    }
}
package com.fliad.viid.modular.cascadeplatform.domain;

public class APEStatusObject {

    private String ApeID;
    private String CurrentTime;
    private String IsOnline;

    public String getApeID() {
        return ApeID;
    }

    public void setApeID(String apeID) {
        ApeID = apeID;
    }

    public String getCurrentTime() {
        return CurrentTime;
    }

    public void setCurrentTime(String currentTime) {
        CurrentTime = currentTime;
    }

    public String getIsOnline() {
        return IsOnline;
    }

    public void setIsOnline(String isOnline) {
        IsOnline = isOnline;
    }
}
package com.fliad.viid.modular.flowgram.domain;

public enum StatusEnum {

    pending("pending"),
    processing("processing"),
    succeeded("succeeded"),
    failed("failed"),
    canceled("canceled");

    private final String value;

    StatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static StatusEnum fromValue(String value) {
        for (StatusEnum status : StatusEnum.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }

}

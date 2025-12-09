package com.fliad.gps002.entity;

public class VehicleRecord {
    private long guid;
    private String vehicle_no;
    private int vehicle_color;
    private boolean encrypt;
    private long date_time;
    private int lng;
    private int lat;
    private int velocity1;
    private int velocity2;
    private int mileage;
    private int direction;
    private int altitude;
    
    // State fields
    private boolean state13;
    private boolean state12;
    private boolean state11;
    private boolean state10;
    private boolean state05;
    private boolean state04;
    private boolean state03;
    private boolean state02;
    private boolean state01;
    private boolean state00;
    
    // Alarm fields
    private boolean alarm28;
    private boolean alarm27;
    private boolean alarm26;
    private boolean alarm25;
    private boolean alarm24;
    private boolean alarm23;
    private boolean alarm22;
    private boolean alarm21;
    private boolean alarm20;
    private boolean alarm19;
    private boolean alarm18;
    private boolean alarm11;
    private boolean alarm10;
    private boolean alarm09;
    private boolean alarm08;
    private boolean alarm07;
    private boolean alarm06;
    private boolean alarm05;
    private boolean alarm04;
    private boolean alarm03;
    private boolean alarm02;
    private boolean alarm01;
    private boolean alarm00;
    
    private long update_time;

    // Getters and setters
    public long getGuid() {
        return guid;
    }

    public void setGuid(long guid) {
        this.guid = guid;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public int getVehicle_color() {
        return vehicle_color;
    }

    public void setVehicle_color(int vehicle_color) {
        this.vehicle_color = vehicle_color;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public long getDate_time() {
        return date_time;
    }

    public void setDate_time(long date_time) {
        this.date_time = date_time;
    }

    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getVelocity1() {
        return velocity1;
    }

    public void setVelocity1(int velocity1) {
        this.velocity1 = velocity1;
    }

    public int getVelocity2() {
        return velocity2;
    }

    public void setVelocity2(int velocity2) {
        this.velocity2 = velocity2;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public boolean isState13() {
        return state13;
    }

    public void setState13(boolean state13) {
        this.state13 = state13;
    }

    public boolean isState12() {
        return state12;
    }

    public void setState12(boolean state12) {
        this.state12 = state12;
    }

    public boolean isState11() {
        return state11;
    }

    public void setState11(boolean state11) {
        this.state11 = state11;
    }

    public boolean isState10() {
        return state10;
    }

    public void setState10(boolean state10) {
        this.state10 = state10;
    }

    public boolean isState05() {
        return state05;
    }

    public void setState05(boolean state05) {
        this.state05 = state05;
    }

    public boolean isState04() {
        return state04;
    }

    public void setState04(boolean state04) {
        this.state04 = state04;
    }

    public boolean isState03() {
        return state03;
    }

    public void setState03(boolean state03) {
        this.state03 = state03;
    }

    public boolean isState02() {
        return state02;
    }

    public void setState02(boolean state02) {
        this.state02 = state02;
    }

    public boolean isState01() {
        return state01;
    }

    public void setState01(boolean state01) {
        this.state01 = state01;
    }

    public boolean isState00() {
        return state00;
    }

    public void setState00(boolean state00) {
        this.state00 = state00;
    }

    public boolean isAlarm28() {
        return alarm28;
    }

    public void setAlarm28(boolean alarm28) {
        this.alarm28 = alarm28;
    }

    public boolean isAlarm27() {
        return alarm27;
    }

    public void setAlarm27(boolean alarm27) {
        this.alarm27 = alarm27;
    }

    public boolean isAlarm26() {
        return alarm26;
    }

    public void setAlarm26(boolean alarm26) {
        this.alarm26 = alarm26;
    }

    public boolean isAlarm25() {
        return alarm25;
    }

    public void setAlarm25(boolean alarm25) {
        this.alarm25 = alarm25;
    }

    public boolean isAlarm24() {
        return alarm24;
    }

    public void setAlarm24(boolean alarm24) {
        this.alarm24 = alarm24;
    }

    public boolean isAlarm23() {
        return alarm23;
    }

    public void setAlarm23(boolean alarm23) {
        this.alarm23 = alarm23;
    }

    public boolean isAlarm22() {
        return alarm22;
    }

    public void setAlarm22(boolean alarm22) {
        this.alarm22 = alarm22;
    }

    public boolean isAlarm21() {
        return alarm21;
    }

    public void setAlarm21(boolean alarm21) {
        this.alarm21 = alarm21;
    }

    public boolean isAlarm20() {
        return alarm20;
    }

    public void setAlarm20(boolean alarm20) {
        this.alarm20 = alarm20;
    }

    public boolean isAlarm19() {
        return alarm19;
    }

    public void setAlarm19(boolean alarm19) {
        this.alarm19 = alarm19;
    }

    public boolean isAlarm18() {
        return alarm18;
    }

    public void setAlarm18(boolean alarm18) {
        this.alarm18 = alarm18;
    }

    public boolean isAlarm11() {
        return alarm11;
    }

    public void setAlarm11(boolean alarm11) {
        this.alarm11 = alarm11;
    }

    public boolean isAlarm10() {
        return alarm10;
    }

    public void setAlarm10(boolean alarm10) {
        this.alarm10 = alarm10;
    }

    public boolean isAlarm09() {
        return alarm09;
    }

    public void setAlarm09(boolean alarm09) {
        this.alarm09 = alarm09;
    }

    public boolean isAlarm08() {
        return alarm08;
    }

    public void setAlarm08(boolean alarm08) {
        this.alarm08 = alarm08;
    }

    public boolean isAlarm07() {
        return alarm07;
    }

    public void setAlarm07(boolean alarm07) {
        this.alarm07 = alarm07;
    }

    public boolean isAlarm06() {
        return alarm06;
    }

    public void setAlarm06(boolean alarm06) {
        this.alarm06 = alarm06;
    }

    public boolean isAlarm05() {
        return alarm05;
    }

    public void setAlarm05(boolean alarm05) {
        this.alarm05 = alarm05;
    }

    public boolean isAlarm04() {
        return alarm04;
    }

    public void setAlarm04(boolean alarm04) {
        this.alarm04 = alarm04;
    }

    public boolean isAlarm03() {
        return alarm03;
    }

    public void setAlarm03(boolean alarm03) {
        this.alarm03 = alarm03;
    }

    public boolean isAlarm02() {
        return alarm02;
    }

    public void setAlarm02(boolean alarm02) {
        this.alarm02 = alarm02;
    }

    public boolean isAlarm01() {
        return alarm01;
    }

    public void setAlarm01(boolean alarm01) {
        this.alarm01 = alarm01;
    }

    public boolean isAlarm00() {
        return alarm00;
    }

    public void setAlarm00(boolean alarm00) {
        this.alarm00 = alarm00;
    }

    public long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }
}
package com.fliad.gps002.entity;

import java.util.List;

public class GpsData {
    private int pageNum;
    private int pageSize;
    private int totalPages;
    private int totalNum;
    private List<VehicleRecord> records;

    // Getters and setters
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<VehicleRecord> getRecords() {
        return records;
    }

    public void setRecords(List<VehicleRecord> records) {
        this.records = records;
    }
}
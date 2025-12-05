package com.fliad.gps.entity;

/**
 * 路口实体类
 */
public class Cross {
    private Long id;
    private String crossId;
    private String centerLocation;

    // 构造函数
    public Cross() {}

    public Cross(Long id, String crossId, String centerLocation) {
        this.id = id;
        this.crossId = crossId;
        this.centerLocation = centerLocation;
    }

    // Getter和Setter方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrossId() {
        return crossId;
    }

    public void setCrossId(String crossId) {
        this.crossId = crossId;
    }

    public String getCenterLocation() {
        return centerLocation;
    }

    public void setCenterLocation(String centerLocation) {
        this.centerLocation = centerLocation;
    }

    @Override
    public String toString() {
        return "Cross{" +
                "id=" + id +
                ", crossId='" + crossId + '\'' +
                ", centerLocation='" + centerLocation + '\'' +
                '}';
    }
}
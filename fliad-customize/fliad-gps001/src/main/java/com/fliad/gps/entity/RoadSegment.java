package com.fliad.gps.entity;

/**
 * 路段实体类
 */
public class RoadSegment {
    private Long id;
    private String roadSegId;
    private String roadSegLocations;

    // 构造函数
    public RoadSegment() {}

    public RoadSegment(Long id, String roadSegId, String roadSegLocations) {
        this.id = id;
        this.roadSegId = roadSegId;
        this.roadSegLocations = roadSegLocations;
    }

    // Getter和Setter方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoadSegId() {
        return roadSegId;
    }

    public void setRoadSegId(String roadSegId) {
        this.roadSegId = roadSegId;
    }

    public String getRoadSegLocations() {
        return roadSegLocations;
    }

    public void setRoadSegLocations(String roadSegLocations) {
        this.roadSegLocations = roadSegLocations;
    }

    @Override
    public String toString() {
        return "RoadSegment{" +
                "id=" + id +
                ", roadSegId='" + roadSegId + '\'' +
                ", roadSegLocations='" + roadSegLocations + '\'' +
                '}';
    }
}
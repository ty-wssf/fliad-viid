package com.fliad.gps.dao;

import com.fliad.gps.entity.Cross;
import com.fliad.gps.entity.RoadSegment;

import java.util.List;

/**
 * GPS数据访问接口
 */
public interface GpsDao {
    /**
     * 获取所有路口数据
     * @return 路口列表
     */
    List<Cross> getAllCrosses();

    /**
     * 获取所有路段数据
     * @return 路段列表
     */
    List<RoadSegment> getAllRoadSegments();
}
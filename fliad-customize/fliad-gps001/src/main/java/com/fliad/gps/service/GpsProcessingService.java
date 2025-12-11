package com.fliad.gps.service;

import com.fliad.gps.entity.Cross;
import com.fliad.gps.entity.RoadSegment;
import com.fliad.gps.model.GpsData;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.index.strtree.STRtree;
import org.locationtech.jts.io.WKTReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GPS数据处理服务类
 */
public class GpsProcessingService {
    private static final Logger logger = LoggerFactory.getLogger(GpsProcessingService.class);
    
    // 几何工厂（指定坐标系，WGS84对应SRID=4326）
    private static final GeometryFactory GEOM_FACTORY = new GeometryFactory(new PrecisionModel(), 4326);
    private static final WKTReader WKT_READER = new WKTReader(GEOM_FACTORY);

    private List<Cross> crosses;
    private List<RoadSegment> roadSegments;
    
    // 预处理的几何对象缓存
    private Map<String, Point> crossPoints;
    private Map<String, LineString> roadLineStrings;
    
    // 空间索引
    private STRtree crossIndex;
    private STRtree roadIndex;

    public GpsProcessingService(List<Cross> crosses, List<RoadSegment> roadSegments) {
        this.crosses = crosses;
        this.roadSegments = roadSegments;
        this.crossPoints = new HashMap<>();
        this.roadLineStrings = new HashMap<>();
        
        // 预处理所有路口点
        preprocessCrosses();
        
        // 预处理所有路段线
        preprocessRoadSegments();
        
        // 构建空间索引
        buildSpatialIndexes();
    }
    
    /**
     * 预处理所有路口点
     */
    private void preprocessCrosses() {
        for (Cross cross : crosses) {
            try {
                String[] coords = cross.getCenterLocation().split(",");
                if (coords.length == 2) {
                    double crossLon = Double.parseDouble(coords[0].trim());
                    double crossLat = Double.parseDouble(coords[1].trim());
                    Point crossPoint = GEOM_FACTORY.createPoint(new Coordinate(crossLon, crossLat));
                    crossPoints.put(cross.getCrossId(), crossPoint);
                }
            } catch (Exception e) {
                logger.warn("预处理路口坐标时出错: {}", cross.getCrossId(), e);
            }
        }
    }
    
    /**
     * 预处理所有路段线
     */
    private void preprocessRoadSegments() {
        for (RoadSegment roadSegment : roadSegments) {
            try {
                String wktFormatCoords = convertToWktFormat(roadSegment.getRoadSegLocations());
                LineString lineString = (LineString) WKT_READER.read("LINESTRING(" + wktFormatCoords + ")");
                roadLineStrings.put(roadSegment.getRoadSegId(), lineString);
            } catch (Exception e) {
                logger.warn("预处理路段坐标时出错: {}", roadSegment.getRoadSegId(), e);
            }
        }
    }
    
    /**
     * 构建空间索引
     */
    private void buildSpatialIndexes() {
        // 构建路口点的空间索引
        crossIndex = new STRtree();
        for (Cross cross : crosses) {
            Point point = crossPoints.get(cross.getCrossId());
            if (point != null) {
                crossIndex.insert(point.getEnvelopeInternal(), cross);
            }
        }
        crossIndex.build();
        
        // 构建路段的空间索引
        roadIndex = new STRtree();
        for (RoadSegment roadSegment : roadSegments) {
            LineString lineString = roadLineStrings.get(roadSegment.getRoadSegId());
            if (lineString != null) {
                roadIndex.insert(lineString.getEnvelopeInternal(), roadSegment);
            }
        }
        roadIndex.build();
    }

    /**
     * 处理GPS数据，匹配路口或路段
     * @param gpsData GPS数据
     */
    public void processGpsData(GpsData gpsData) {
        try {
            // 创建GPS点
            Point gpsPoint = GEOM_FACTORY.createPoint(new Coordinate(gpsData.getLon(), gpsData.getLat()));

            // 首先尝试匹配路口（50米内）
            matchCrossWithIndex(gpsPoint, gpsData);

            // 如果没有匹配到路口，则尝试匹配路段（50米内）
            if (gpsData.getMatchedCrossId() == null) {
                matchRoadSegmentWithIndex(gpsPoint, gpsData);
            }
        } catch (Exception e) {
            logger.error("处理GPS数据时发生错误", e);
        }
    }

    /**
     * 使用空间索引匹配路口
     * @param gpsPoint GPS点
     * @param gpsData GPS数据
     */
    private void matchCrossWithIndex(Point gpsPoint, GpsData gpsData) {
        // 使用缓冲区查询附近的路口
        double bufferDistance = 50.0 / 111319.9; // 转换为度数
        Geometry searchArea = gpsPoint.buffer(bufferDistance);
        List<Cross> nearbyCrosses = crossIndex.query(searchArea.getEnvelopeInternal());
        
        Cross matchedCross = null;
        double minDistance = 50.0;
        
        for (Cross cross : nearbyCrosses) {
            Point crossPoint = crossPoints.get(cross.getCrossId());
            if (crossPoint != null) {
                try {
                    double degreeDistance = gpsPoint.distance(crossPoint);
                    double meterDistance = degreeToMeter(degreeDistance);

                    // 如果距离小于等于50米，且比当前最小距离更近，则更新匹配结果
                    if (meterDistance <= 50 && meterDistance < minDistance) {
                        minDistance = meterDistance;
                        matchedCross = cross;
                    }
                } catch (Exception e) {
                    // 解析坐标出错，跳过该路口
                    logger.debug("匹配路口时出错: {}", cross.getCrossId(), e);
                    continue;
                }
            }
        }
        
        if (matchedCross != null) {
            gpsData.setMatchedCrossId(matchedCross.getCrossId());
        }
    }

    /**
     * 使用空间索引匹配路段
     * @param gpsPoint GPS点
     * @param gpsData GPS数据
     */
    private void matchRoadSegmentWithIndex(Point gpsPoint, GpsData gpsData) {
        // 使用缓冲区查询附近的路段
        double bufferDistance = 50.0 / 111319.9; // 转换为度数
        Geometry searchArea = gpsPoint.buffer(bufferDistance);
        List<RoadSegment> nearbyRoads = roadIndex.query(searchArea.getEnvelopeInternal());
        
        RoadSegment matchedRoad = null;
        double minDistance = 50.0;
        
        for (RoadSegment roadSegment : nearbyRoads) {
            LineString lineString = roadLineStrings.get(roadSegment.getRoadSegId());
            if (lineString != null) {
                try {
                    double degreeDistance = lineString.distance(gpsPoint);
                    double meterDistance = degreeToMeter(degreeDistance);

                    // 如果距离小于等于50米，且比当前最小距离更近，则更新匹配结果
                    if (meterDistance <= 50 && meterDistance < minDistance) {
                        minDistance = meterDistance;
                        matchedRoad = roadSegment;
                    }
                } catch (Exception e) {
                    // 解析坐标出错，跳过该路段
                    logger.debug("匹配路段时出错: {}", roadSegment.getRoadSegId(), e);
                    continue;
                }
            }
        }
        
        if (matchedRoad != null) {
            gpsData.setMatchedRoadSegId(matchedRoad.getRoadSegId());
        }
    }

    /**
     * 将数据库中的坐标格式转换为WKT格式
     * 数据库格式: "112.168336,25.465129,112.168137,25.465399,112.167663,25.46604"
     * WKT格式: "112.168336 25.465129, 112.168137 25.465399, 112.167663 25.46604"
     * 
     * @param dbCoords 数据库中的坐标字符串
     * @return WKT格式的坐标字符串
     */
    private String convertToWktFormat(String dbCoords) {
        if (dbCoords == null || dbCoords.isEmpty()) {
            return "";
        }
        
        String[] coords = dbCoords.split(",");
        StringBuilder wktCoords = new StringBuilder();
        
        // 每两个元素组成一个坐标点（经度,纬度）
        for (int i = 0; i < coords.length; i += 2) {
            if (i > 0) {
                wktCoords.append(", ");
            }
            
            // 确保不会数组越界
            if (i + 1 < coords.length) {
                wktCoords.append(coords[i]).append(" ").append(coords[i + 1]);
            }
        }
        
        return wktCoords.toString();
    }

    /**
     * 经纬度度数差转米（WGS84坐标系，赤道1度≈111319米）
     *
     * @param degree 经纬度度数差
     * @return 对应的距离（米）
     */
    private static double degreeToMeter(double degree) {
        final double METERS_PER_DEGREE = 111319.9; // 赤道每度米数
        return degree * METERS_PER_DEGREE;
    }
}
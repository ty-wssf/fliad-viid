package com.fliad.test.controller;

import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.WKTReader;

/**
 * 基于JTS实现空间匹配（路段/经纬度）
 */
public class JTSSpatialMatchDemo {
    // 几何工厂（指定坐标系，WGS84对应SRID=4326）
    private static final GeometryFactory GEOM_FACTORY = new GeometryFactory(new PrecisionModel(), 4326);
    private static final WKTReader WKT_READER = new WKTReader(GEOM_FACTORY);

    public static void main(String[] args) throws Exception {
        // 1. 定义路段：LineString（对应数据库中的路段坐标序列）
        // WKT格式：LineString(经度1 纬度1, 经度2 纬度2, 经度3 纬度3)
        String roadWkt = "LINESTRING(116.403874 39.914885, 116.404001 39.914999, 116.404128 39.915113)";
        LineString roadLine = (LineString) WKT_READER.read(roadWkt);

        // 2. 定义目标点：Point（经纬度）
        Point targetPoint = GEOM_FACTORY.createPoint(new Coordinate(116.403874, 39.914885));

        // 3. 空间匹配核心操作
        // 3.1 计算点到路段的最短距离（米，需转换：JTS返回的是经纬度单位，需转球面距离）
        double degreeDistance = roadLine.distance(targetPoint);
        double meterDistance = degreeToMeter(degreeDistance); // 经纬度度数转米

        // 3.2 判断是否匹配（距离≤50米）
        double MATCH_THRESHOLD = 50;
        if (meterDistance <= MATCH_THRESHOLD) {
            System.out.println("匹配到路段，距离：" + meterDistance + "米");
        } else {
            System.out.println("未匹配到路段");
        }

        // 3.3 其他空间判断（如点是否在路段的缓冲区范围内）
        Geometry buffer = roadLine.buffer(0.0005); // 0.0005度≈50米缓冲区
        if (buffer.contains(targetPoint)) {
            System.out.println("目标点在路段缓冲区范围内");
        }
    }

    /**
     * 经纬度度数差转米（WGS84坐标系，赤道1度≈111319米）
     */
    private static double degreeToMeter(double degree) {
        final double METERS_PER_DEGREE = 111319.9; // 赤道每度米数
        return degree * METERS_PER_DEGREE;
    }
}
package com.fliad.test.controller;

import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.operation.distance.DistanceOp;
import org.locationtech.jts.algorithm.distance.DiscreteHausdorffDistance;

/**
 * 基于JTS实现点相关计算的具体示例
 */
public class PointCalculationDemo {
    // 几何工厂（指定坐标系，WGS84对应SRID=4326）
    private static final GeometryFactory GEOM_FACTORY = new GeometryFactory(new PrecisionModel(), 4326);
    private static final WKTReader WKT_READER = new WKTReader(GEOM_FACTORY);

    public static void main(String[] args) throws Exception {
        System.out.println("=== JTS点计算示例 ===");
        
        // 1. 创建多个点和线段用于演示
        Point point1 = GEOM_FACTORY.createPoint(new Coordinate(116.403874, 39.914885)); // 北京某点
        Point point2 = GEOM_FACTORY.createPoint(new Coordinate(116.404128, 39.915113)); // 北京另一点
        Point point3 = GEOM_FACTORY.createPoint(new Coordinate(121.476726, 31.233997)); // 上海某点
        
        // 创建线段
        String roadWkt = "LINESTRING(116.403874 39.914885, 116.404001 39.914999, 116.404128 39.915113)";
        LineString roadLine = (LineString) WKT_READER.read(roadWkt);
        
        // 2. 计算两点之间的距离
        System.out.println("\n--- 两点间距离计算 ---");
        double distanceBetweenPoints = point1.distance(point2);
        System.out.println("北京两点间经纬度距离: " + distanceBetweenPoints);
        System.out.println("北京两点间实际距离: " + degreeToMeter(distanceBetweenPoints) + " 米");
        
        // 3. 计算点到线的最短距离
        System.out.println("\n--- 点到线段距离计算 ---");
        double distancePointToLine = roadLine.distance(point1);
        System.out.println("点到线段的经纬度距离: " + distancePointToLine);
        System.out.println("点到线段的实际距离: " + degreeToMeter(distancePointToLine) + " 米");
        
        // 4. 使用DistanceOp获取最近点信息
        System.out.println("\n--- 最近点详细信息 ---");
        DistanceOp distanceOp = new DistanceOp(roadLine, point3);
        Coordinate[] nearestPoints = distanceOp.nearestPoints();
        System.out.println("上海点坐标: (" + point3.getX() + ", " + point3.getY() + ")");
        System.out.println("距离上海点最近的线段上的点: (" + nearestPoints[0].x + ", " + nearestPoints[0].y + ")");
        System.out.println("两点间的经纬度距离: " + distanceOp.distance());
        System.out.println("两点间的实际距离: " + degreeToMeter(distanceOp.distance()) + " 米");
        
        // 5. 点是否在线段上
        System.out.println("\n--- 点与线段关系判断 ---");
        Coordinate startPoint = roadLine.getStartPoint().getCoordinate();
        Point startPointGeometry = GEOM_FACTORY.createPoint(startPoint);
        System.out.println("起点是否在线段上: " + roadLine.intersects(startPointGeometry));
        
        // 6. 缓冲区分析
        System.out.println("\n--- 缓冲区分析 ---");
        Geometry bufferZone = point1.buffer(0.001); // 创建1000米左右的缓冲区
        System.out.println("点的缓冲区面积(经纬度单位): " + bufferZone.getArea());
        System.out.println("点的缓冲区实际面积(平方米): " + degreeSquareToMeterSquare(bufferZone.getArea()) + " 平方米");
        
        // 7. 点是否在多边形内
        System.out.println("\n--- 点与多边形关系 ---");
        Coordinate[] polygonCoords = new Coordinate[] {
            new Coordinate(116.40, 39.91),
            new Coordinate(116.41, 39.91),
            new Coordinate(116.41, 39.92),
            new Coordinate(116.40, 39.92),
            new Coordinate(116.40, 39.91) // 闭合多边形
        };
        Polygon polygon = GEOM_FACTORY.createPolygon(polygonCoords);
        System.out.println("北京某点是否在北京矩形区域内: " + polygon.contains(point1));
        System.out.println("上海点是否在北京矩形区域内: " + polygon.contains(point3));
        
        // 8. Hausdorff距离（两个几何体相似性度量）
        System.out.println("\n--- Hausdorff距离 ---");
        LineString line1 = (LineString) WKT_READER.read("LINESTRING(116.403 39.914, 116.405 39.916)");
        LineString line2 = (LineString) WKT_READER.read("LINESTRING(116.4031 39.9141, 116.4051 39.9161)");
        DiscreteHausdorffDistance hausdorffDistance = new DiscreteHausdorffDistance(line1, line2);
        System.out.println("两条线段的Hausdorff距离: " + hausdorffDistance.distance());
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
    
    /**
     * 经纬度平方单位转平方米
     *
     * @param squareDegree 经纬度平方单位
     * @return 对应的平方米数
     */
    private static double degreeSquareToMeterSquare(double squareDegree) {
        final double METERS_PER_DEGREE = 111319.9; // 赤道每度米数
        return squareDegree * METERS_PER_DEGREE * METERS_PER_DEGREE;
    }
}
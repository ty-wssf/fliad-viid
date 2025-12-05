package com.fliad.gps.dao;

import com.fliad.gps.entity.Cross;
import com.fliad.gps.entity.RoadSegment;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * GPS数据访问实现类（基于Solon框架）
 */
@Component
public class GpsDaoImpl implements GpsDao {
    private static final Logger logger = LoggerFactory.getLogger(GpsDaoImpl.class);
    
    @Inject("mysql")
    private DataSource dataSource;

    @Override
    public List<Cross> getAllCrosses() {
        List<Cross> crosses = new ArrayList<>();
        String sql = "SELECT id, cross_id, center_location FROM table_cross";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cross cross = new Cross();
                cross.setId(rs.getLong("id"));
                cross.setCrossId(rs.getString("cross_id"));
                cross.setCenterLocation(rs.getString("center_location"));
                crosses.add(cross);
            }
        } catch (SQLException e) {
            logger.error("获取路口数据时发生错误", e);
        }

        return crosses;
    }

    @Override
    public List<RoadSegment> getAllRoadSegments() {
        List<RoadSegment> roadSegments = new ArrayList<>();
        String sql = "SELECT id, road_seg_id, road_seg_locations FROM table_road_segment";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                RoadSegment roadSegment = new RoadSegment();
                roadSegment.setId(rs.getLong("id"));
                roadSegment.setRoadSegId(rs.getString("road_seg_id"));
                roadSegment.setRoadSegLocations(rs.getString("road_seg_locations"));
                roadSegments.add(roadSegment);
            }
        } catch (SQLException e) {
            logger.error("获取路段数据时发生错误", e);
        }

        return roadSegments;
    }
}
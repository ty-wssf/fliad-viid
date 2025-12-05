package com.fliad.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;

import java.util.*;

/**
 * GPS数据查询接口模拟控制器
 * 用于测试两客一危车辆和货运车辆GPS数据查询接口
 *
 * @author fliad
 */
@Api(tags = "GPS数据查询接口")
@Controller
@Mapping("/jkfw/region")
public class GpsDataController {

    /**
     * 两客一危车辆GPS数据查询接口
     *
     * @param kssj GPS开始时间 格式：yyyy-mm-dd hh24:mi:ss
     * @param jssj GPS结束时间 格式：yyyy-mm-dd hh24:mi:ss
     * @param size 返回条数 最大值10000条，默认10000条
     * @return 模拟的GPS数据
     */
    @ApiOperation("两客一危车辆GPS数据查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "kssj", value = "GPS开始时间", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "jssj", value = "GPS结束时间", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "返回条数", dataType = "integer", paramType = "query")
    })
    @Get
    @Mapping("/getyzlkywgps")
    public Object getYzlkywgps(String kssj, String jssj, Integer size, Context ctx) {
        // 验证token
        String token = ctx.header("token");
        if (!"8914dfc5-beca-45c9-918c-01791b9c8b62".equals(token)) {
            Map<String, Object> result = new HashMap<>();
            result.put("msg", "token无效");
            result.put("code", "401");
            result.put("data", "");
            result.put("success", false);
            return result;
        }

        // 设置默认size
        if (size == null) {
            size = 10000;
        }

        // 限制最大size
        size = Math.min(size, 10000);

        // 构造模拟数据
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "操作成功");
        result.put("code", "200");
        result.put("success", true);

        Map<String, Object> data = new HashMap<>();
        data.put("total", size);

        List<Map<String, Object>> dataList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Map<String, Object> record = new HashMap<>();
            record.put("id", UUID.randomUUID().toString());
            record.put("vehicleNo", "湘A" + String.format("%05d", new Random().nextInt(100000)));
            record.put("vehicleColor", String.valueOf(new Random().nextInt(5) + 1));
            record.put("gps_time", kssj);
            record.put("lon", 112.256562);
            record.put("lat", 25.630252);
            record.put("vec1", new Random().nextInt(120));
            record.put("direction", new Random().nextInt(360));
            dataList.add(record);
        }

        Map<String, Object> hitMap = new HashMap<>();
        hitMap.put("total", size);
        hitMap.put("hits", dataList);

        data.put("hits", hitMap);
        result.put("data", data);

        return result;
    }

    /**
     * 货运车辆GPS数据查询接口
     *
     * @param kssj GPS开始时间 格式：yyyy-mm-dd hh24:mi:ss
     * @param jssj GPS结束时间 格式：yyyy-mm-dd hh24:mi:ss
     * @param size 返回条数 最大值10000条，默认10000条
     * @return 模拟的GPS数据
     */
    @ApiOperation("货运车辆GPS数据查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "kssj", value = "GPS开始时间", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "jssj", value = "GPS结束时间", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "返回条数", dataType = "integer", paramType = "query")
    })
    @Get
    @Mapping("/getyzhcgps")
    public Object getYzhcgps(String kssj, String jssj, Integer size, Context ctx) {
        // 验证token
        String token = ctx.header("token");
        if (!"8914dfc5-beca-45c9-918c-01791b9c8b62".equals(token)) {
            Map<String, Object> result = new HashMap<>();
            result.put("msg", "token无效");
            result.put("code", "401");
            result.put("data", "");
            result.put("success", false);
            return result;
        }

        // 设置默认size
        if (size == null) {
            size = 10000;
        }

        // 限制最大size
        size = Math.min(size, 10000);

        // 构造模拟数据
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "操作成功");
        result.put("code", "200");
        result.put("success", true);

        Map<String, Object> data = new HashMap<>();
        data.put("total", size);

        List<Map<String, Object>> dataList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Map<String, Object> record = new HashMap<>();
            record.put("id", UUID.randomUUID().toString());
            record.put("vehicleNo", "湘B" + String.format("%05d", new Random().nextInt(100000)));
            record.put("vehicleColor", String.valueOf(new Random().nextInt(5) + 1));
            record.put("gps_time", kssj);
            record.put("lon", 112.0 + new Random().nextDouble() * 2);
            record.put("lat", 28.0 + new Random().nextDouble() * 2);
            record.put("vec1", new Random().nextInt(120));
            record.put("direction", new Random().nextInt(360));
            dataList.add(record);
        }

        Map<String, Object> hitMap = new HashMap<>();
        hitMap.put("total", size);
        hitMap.put("hits", dataList);

        data.put("hits", hitMap);
        result.put("data", data);

        return result;
    }
}
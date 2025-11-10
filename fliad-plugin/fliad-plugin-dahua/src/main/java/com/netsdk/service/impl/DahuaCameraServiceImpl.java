package com.netsdk.service.impl;

import com.netsdk.dao.entity.DahuaCamera;
import com.netsdk.service.DahuaCameraService;
import org.noear.solon.annotation.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 大华摄像头服务实现类
 */
@Component
public class DahuaCameraServiceImpl implements DahuaCameraService {
    
    @Override
    public List<DahuaCamera> list() {
        // 这里应该从数据库或其他数据源获取摄像头列表
        // 目前返回空列表作为示例
        return new ArrayList<>();
    }
}
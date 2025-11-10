package com.netsdk.service;

import com.netsdk.dao.entity.DahuaCamera;

import java.util.List;

/**
 * 大华摄像头服务接口
 */
public interface DahuaCameraService {
    
    /**
     * 获取所有大华摄像头列表
     * @return 摄像头列表
     */
    List<DahuaCamera> list();
}
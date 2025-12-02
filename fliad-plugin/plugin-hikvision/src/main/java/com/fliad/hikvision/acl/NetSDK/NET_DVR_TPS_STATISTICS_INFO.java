package com.fliad.hikvision.acl.NetSDK;

/**
 * @author chengzhihua
 * @description TPS统计过车数据上传
 * @date 2021/2/22
 */
public class NET_DVR_TPS_STATISTICS_INFO extends HIKSDKStructure {
    /**
     * // 结构体大小
     */
    public int dwSize;
    /**
     * //通道号
     */
    public int dwChan;
    /**
     * // 交通参数统计信息
     */
    public NET_DVR_TPS_STATISTICS_PARAM struTPSStatisticsInfo;
    /**
     *  // 保留
     */
    public byte[] byRes = new byte[128];
}

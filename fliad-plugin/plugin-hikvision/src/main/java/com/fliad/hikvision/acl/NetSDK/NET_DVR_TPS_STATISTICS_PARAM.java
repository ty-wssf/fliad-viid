package com.fliad.hikvision.acl.NetSDK;


/**
 * @author chengzhihua
 * @description 交通参数统计信息
 * @date 2021/2/22
 */
public class NET_DVR_TPS_STATISTICS_PARAM extends HIKSDKStructure {
    public byte byStart;          // 开始码
    public byte byCMD;         // 命令号， 08-定时成组数据指令
    public byte[] byRes = new byte[2];        // 预留字节
    public short wDeviceID;      // 设备ID
    public short wDataLen;       // 数据长度
    public byte byTotalLaneNum;  // 有效车道总数
    public byte[] byRes1 = new byte[15];
    public HCNetSDK.NET_DVR_TIME_V30 struStartTime;    //统计开始时间
    public int dwSamplePeriod;    //统计时间,单位秒
    public NET_DVR_TPS_LANE_PARAM[] struLaneParam = new NET_DVR_TPS_LANE_PARAM[8];

}

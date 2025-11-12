package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 驾驶位违规信息
public class EVENT_COMM_SEAT extends NetSDKLib.SdkStructure {
    public int bEnable;                              //是否检测到座驾信息, 类型BOOL, 取值0或者1
    public int emSeatType;                           //座驾类型,0:未识别;1:主驾驶; 取值为EM_COMMON_SEAT_TYPE中的值
    public EVENT_COMM_STATUS stStatus;                            //违规状态
    public int emSafeBeltStatus;                     //安全带状态, 取值为NET_SAFEBELT_STATE中的值
    public int emSunShadeStatus;                     //遮阳板状态, 取值为NET_SUNSHADE_STATE中的值
    public int emCallAction;                         //打电话动作,参见枚举定义 {@link com.netsdk.lib.enumeration.EM_CALL_ACTION_TYPE}
    public int nSafeBeltConf;                        //安全带确信度
    public int nPhoneConf;                           //打电话置信度
    public int nSmokeConf;                           //抽烟置信度
    public byte[] szReserved = new byte[8];             //预留字节
}

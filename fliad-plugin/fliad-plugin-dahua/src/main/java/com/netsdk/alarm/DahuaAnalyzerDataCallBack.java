package com.netsdk.alarm;

import com.netsdk.lib.NetSDKLib;
import com.sun.jna.Pointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * 大华设备智能分析数据回调处理类
 */
public class DahuaAnalyzerDataCallBack implements NetSDKLib.fAnalyzerDataCallBack {
    private static final Logger log = LoggerFactory.getLogger(DahuaAnalyzerDataCallBack.class);

    private final DahuaAlarmManager dahuaAlarmManager;

    public DahuaAnalyzerDataCallBack(DahuaAlarmManager dahuaAlarmManager) {
        this.dahuaAlarmManager = dahuaAlarmManager;
    }

    @Override
    public int invoke(NetSDKLib.LLong lAnalyzerHandle, int dwAlarmType, Pointer pAlarmInfo, Pointer pBuffer, int dwBufSize, Pointer dwUser, int nSequence, Pointer reserved) throws UnsupportedEncodingException {
        try {
            log.info("收到智能分析事件，报警类型: 0x{}", Integer.toHexString(dwAlarmType));

            // 根据不同的报警类型进行处理
            switch (dwAlarmType) {
                case NetSDKLib.EVENT_IVS_ALL:
                    log.info("所有事件");
                    break;
                default:
                    log.info("其他智能分析事件类型: 0x{}", Integer.toHexString(dwAlarmType));
                    break;
            }

            // 这里可以添加具体的智能分析事件处理逻辑
            // 例如解析pAlarmInfo中的事件详细信息

        } catch (Exception e) {
            log.error("处理智能分析事件数据异常", e);
        }
        return 0;
    }
}
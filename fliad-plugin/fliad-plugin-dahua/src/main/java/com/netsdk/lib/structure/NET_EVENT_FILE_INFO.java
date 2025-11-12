package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 事件对应文件信息
public class NET_EVENT_FILE_INFO extends NetSDKLib.SdkStructure {
    public byte bCount;                               // 当前文件所在文件组中的文件总数
    public byte bIndex;                               // 当前文件在文件组中的文件编号(编号1开始)
    public byte bFileTag;                             // 文件标签,具体说明见枚举类型 EM_EVENT_FILETAG
    public byte bFileType;                            // 文件类型,0-普通1-合成2-抠图
    public NET_TIME_EX stuFileTime;                          // 文件时间
    public int nGroupId;                             // 同一组抓拍文件的唯一标识

    @Override
    public String toString() {
        return "事件对应文件信息,NET_EVENT_FILE_INFO{" +
                "bCount=" + bCount +
                ", bIndex=" + bIndex +
                ", bFileTag=" + bFileTag +
                ", bFileType=" + bFileType +
                ", stuFileTime=" + stuFileTime.toStringTime() +
                ", nGroupId=" + nGroupId +
                '}';
    }
}

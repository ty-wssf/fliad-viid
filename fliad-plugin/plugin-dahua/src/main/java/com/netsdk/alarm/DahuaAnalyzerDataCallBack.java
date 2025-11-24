package com.netsdk.alarm;

import cn.hutool.core.io.IoUtil;
import com.fliad.dev.modular.file.provider.DevFileApiProvider;
import com.netsdk.lib.NetSDKLib;
import com.netsdk.lib.structure.DEV_EVENT_TRAFFICJUNCTION_INFO;
import com.netsdk.lib.structure.NET_RIDER_INFO;
import com.sun.jna.Pointer;
import org.noear.snack.ONode;
import org.noear.snack.core.utils.IOUtil;
import org.noear.solon.core.handle.FileBase;
import org.noear.solon.core.handle.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 大华设备智能分析数据回调处理类
 */
public class DahuaAnalyzerDataCallBack implements NetSDKLib.fAnalyzerDataCallBack {
    private static final Logger log = LoggerFactory.getLogger(DahuaAnalyzerDataCallBack.class);

    private final DahuaAlarmManager dahuaAlarmManager;
    private final DevFileApiProvider devFileApiProvider;

    public DahuaAnalyzerDataCallBack(DahuaAlarmManager dahuaAlarmManager, DevFileApiProvider devFileApiProvider) {
        this.dahuaAlarmManager = dahuaAlarmManager;
        this.devFileApiProvider = devFileApiProvider;
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
                case NetSDKLib.EVENT_IVS_TRAFFICJUNCTION:
                    log.info("交通路口事件");
                    DEV_EVENT_TRAFFICJUNCTION_INFO msg = new DEV_EVENT_TRAFFICJUNCTION_INFO();
                    ToolKits.GetPointerData(pAlarmInfo, msg);

                    ONode trafficInfo = new ONode().asObject();
                    try {
                        trafficInfo.set("m_PlateNumber", new String(msg.stuObject.szText, "GBK").trim());
                    } catch (UnsupportedEncodingException e) {
                        log.error("解析交通路口事件号牌号码异常", e);
                    }

                    // 骑车人数
                    trafficInfo.set("nNumOfCycling", msg.stuNonMotor.nNumOfCycling);
                    // 帽子类型
                    trafficInfo.set("emCap", Arrays.stream(msg.stuNonMotor.stuRiderList).map(rider -> rider.emCap).collect(Collectors.toList()).subList(0, msg.stuNonMotor.nNumOfCycling));
                    // trafficInfo.set("emRainShedType", msg.stuNonMotor.emRainShedType);

                    byte[] img_array = pBuffer.getByteArray(0, dwBufSize);
                    UploadedFile file = new UploadedFile("image/jpeg", IoUtil.toStream(img_array), "1.jpg");
                    String url = devFileApiProvider.storageFileWithReturnUrlLocal(file, new ONode().asObject().set("persistence", false));
                    trafficInfo.set("tpurl", url);

                    // 骑车人特征,个数和nNumOfCycling关联
                    NET_RIDER_INFO[] stuRiderList = msg.stuNonMotor.stuRiderList;
                    ONode riderFaceUrls = new ONode().asArray();
                    for (int i = 0; i < stuRiderList.length; i++) {
                        // 骑车人图片二进制数据 @todo  完成骑车人图片存储
                        if (stuRiderList[i].bHasFaceImage == 1 && stuRiderList[i].stuFaceImage.uLength > 0) {
                            byte[] faceImageBytes = pBuffer.getByteArray(stuRiderList[i].stuFaceImage.uOffset, stuRiderList[i].stuFaceImage.uLength);
                            UploadedFile faceImageFile = new UploadedFile("image/jpeg", IoUtil.toStream(faceImageBytes), "rider_" + i + "_face.jpg");
                            String faceImageUrl = devFileApiProvider.storageFileWithReturnUrlLocal(faceImageFile, new ONode().asObject().set("persistence", false));
                            riderFaceUrls.add(faceImageUrl);
                        }
                    }
                    trafficInfo.set("riderFaceUrls", riderFaceUrls);
                    log.info("交通路口事件解析结果: {}", trafficInfo);
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
package com.fliad.hikvision.modular.defense.acl.alarm.handler;

import com.fliad.hikvision.modular.defense.acl.NetSDK.HCNetSDK;
import com.sun.jna.Pointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 交通抓拍结果(新报警信息)处理器
 */
public class ItsPlateResultHandler implements AlarmHandler {
    private static final Logger log = LoggerFactory.getLogger(ItsPlateResultHandler.class);

    @Override
    public void handle(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser) {
        String sbip = "";
        try {
            sbip = new String(pAlarmer.sDeviceIP, "GBK").trim();
        } catch (Exception e) {
            log.error("获取设备IP失败", e);
        }
        log.info("设备IP: {}，报警类型: 交通抓拍结果", sbip);
        String MonitoringSiteID = "";
        String sLicense = "";
        byte VehicleType = 0;
        HCNetSDK.NET_ITS_PLATE_RESULT strItsPlateResult = new HCNetSDK.NET_ITS_PLATE_RESULT();
        strItsPlateResult.write();
        Pointer pItsPlateInfo = strItsPlateResult.getPointer();
        pItsPlateInfo.write(0, pAlarmInfo.getByteArray(0, strItsPlateResult.size()), 0, strItsPlateResult.size());
        strItsPlateResult.read();
        try {
            sLicense = new String(strItsPlateResult.struPlateInfo.sLicense, "GBK").trim();
            VehicleType = strItsPlateResult.byVehicleType;  //0-其他车辆，1-小型车，2-大型车，3- 行人触发，4- 二轮车触发，5- 三轮车触发，6- 机动车触发
            MonitoringSiteID = new String(strItsPlateResult.byMonitoringSiteID).trim();
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            log.error("", e1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            log.error("", e);
        }

        // 车辆信息解析
        short wSpeed = strItsPlateResult.struVehicleInfo.wSpeed; // 车速

        log.info("车牌号：" + sLicense + ":车辆类型：" + VehicleType + ":布防点编号：" + MonitoringSiteID + ":车速：" + wSpeed);

        /**
         * 报警图片保存，车牌，车辆图片
         */
        for (int i = 0; i < strItsPlateResult.dwPicNum; i++) {
            if (strItsPlateResult.struPicInfo[i].dwDataLen > 0) {
                SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
                String newName = sf.format(new Date());
                FileOutputStream fout;
                try {
                    String filename = "./pic/" + newName + "_type[" + strItsPlateResult.struPicInfo[i].byType + "]_ItsPlate.jpg";
                    fout = new FileOutputStream(filename);
                    //将字节写入文件
                    long offset = 0;
                    ByteBuffer buffers = strItsPlateResult.struPicInfo[i].pBuffer.getByteBuffer(offset, strItsPlateResult.struPicInfo[i].dwDataLen);
                    byte[] bytes = new byte[strItsPlateResult.struPicInfo[i].dwDataLen];
                    buffers.rewind();
                    buffers.get(bytes);
                    fout.write(bytes);
                    fout.close();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
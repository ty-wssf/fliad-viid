package com.fliad.hikvision.acl.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 气象数据结构
 */
public class DsWeather implements Serializable {
    private String lsh ;//流水号
    private String sbcs ;//设备厂商
    private String sbxh ;//设备或终端序列号
    private String cjsj ;//采集时间
    private String hjwd ;//环境气温(℃)
    private String lmwd ;//路面温度(℃)
    private String hjsd ;//环境湿度(%RH)
    private String smhd ;//水膜厚度(mm)
    private String bhd ;//冰厚度(mm)
    private String xshd ;//雪深厚度(m)
    private String shxs ;//湿滑系数
    private String lmzk ;//路面状况
    private String qy ;//气压(hPa)
    private String fwj ;//方位角(°)
    private String xdfx ;//相对风向(°)
    private String sjfx ;//实际风向(°)
    private String fsssz ;//风速瞬时值(m/s)
    private String fspjz_1 ;//1分钟平均风速值(m/s)
    private String fspjz_2 ;//10分钟平均风速值(m/s)
    private String yljgljz ;//雨量间隔累计值(mm)

    private String ylrljz ;//雨量日累计值(mm)
    private String rzsjljz ;//日照时间隔累计值(分钟)
    private String rzsrljz ;//日照时日累计值(分钟)
    private String njdssz ;//能见度瞬时值(m)
    private String njdpjz ;//10分钟平均能见度(m)
    private String dl ;//电量(V)
    private Date acceptTime ;//接收服务接收到数据的时间
    private String analysisTime ;//解析服务解析成功之后的时间
    private String sendToMQTime ;//发送到消息队列中的时间
    private String getForMQTime ;//从消息队列中取出的时间

    private String storageTime ;//数据入库时间
    private String sendToMQState ;//是否发送至rabbitMQ,'0'为否，‘1’为是
    private String sendToHJ;//写入汇聚是否成功，1：成功 0:失败

    // 以下字段是为了兼容webhessian接口数据格式
    private String sbbh;//设备编号
    private String jcsd;//检测时段
    private String jczqs;//检测周期数
    private String njd;//能见度
    private String wdu;//温度
    private String fs;//风速
    private String fsdj;//风速等级
    private String jyl;//降雨（积水）量	单位（毫米）
    private String jxl;//
    private String jcsjlx;//有事件时使用以下代码，多个事件时，例“AD”A-大雾,D-降雪（积雪）,E-降雨（积水）,G-大风（横风）,J-温度异常
    private String fspjz;//1分钟风速平均值
    private String fspjz_10;//10分钟风速平均值
    private String jcsj;//监测时间

    public void setLmzk(String lmzk) {
        // dry#干,moist#潮,wet#湿,snow#雪,ice#冰,slushy#泥泞
        if (lmzk == null || lmzk.isEmpty()) {
            this.lmzk = ""; // 或者根据业务设定默认值
            return;
        }
        lmzk = lmzk.toLowerCase();
        switch (lmzk) {
            case "dry":
                this.lmzk = "干";
                break;
            case "moist":
                this.lmzk = "潮";
                break;
            case "wet":
                this.lmzk = "湿";
                break;
            case "snow":
                this.lmzk = "雪";
                break;
            case "ice":
                this.lmzk = "冰";
                break;
            case "slushy":
                this.lmzk = "泥泞";
                break;
            default:
                this.lmzk = lmzk; // 或者抛出异常、记录日志等
                break;
        }
    }

    public String getLsh() {
        return lsh;
    }

    public void setLsh(String lsh) {
        this.lsh = lsh;
    }

    public String getSbcs() {
        return sbcs;
    }

    public void setSbcs(String sbcs) {
        this.sbcs = sbcs;
    }

    public String getSbxh() {
        return sbxh;
    }

    public void setSbxh(String sbxh) {
        this.sbxh = sbxh;
    }

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj;
    }

    public String getHjwd() {
        return hjwd;
    }

    public void setHjwd(String hjwd) {
        this.hjwd = hjwd;
    }

    public String getLmwd() {
        return lmwd;
    }

    public void setLmwd(String lmwd) {
        this.lmwd = lmwd;
    }

    public String getHjsd() {
        return hjsd;
    }

    public void setHjsd(String hjsd) {
        this.hjsd = hjsd;
    }

    public String getSmhd() {
        return smhd;
    }

    public void setSmhd(String smhd) {
        this.smhd = smhd;
    }

    public String getBhd() {
        return bhd;
    }

    public void setBhd(String bhd) {
        this.bhd = bhd;
    }

    public String getXshd() {
        return xshd;
    }

    public void setXshd(String xshd) {
        this.xshd = xshd;
    }

    public String getShxs() {
        return shxs;
    }

    public void setShxs(String shxs) {
        this.shxs = shxs;
    }

    public String getLmzk() {
        return lmzk;
    }

    public String getQy() {
        return qy;
    }

    public void setQy(String qy) {
        this.qy = qy;
    }

    public String getFwj() {
        return fwj;
    }

    public void setFwj(String fwj) {
        this.fwj = fwj;
    }

    public String getXdfx() {
        return xdfx;
    }

    public void setXdfx(String xdfx) {
        this.xdfx = xdfx;
    }

    public String getSjfx() {
        return sjfx;
    }

    public void setSjfx(String sjfx) {
        this.sjfx = sjfx;
    }

    public String getFsssz() {
        return fsssz;
    }

    public void setFsssz(String fsssz) {
        this.fsssz = fsssz;
    }

    public String getFspjz_1() {
        return fspjz_1;
    }

    public void setFspjz_1(String fspjz_1) {
        this.fspjz_1 = fspjz_1;
    }

    public String getFspjz_2() {
        return fspjz_2;
    }

    public void setFspjz_2(String fspjz_2) {
        this.fspjz_2 = fspjz_2;
    }

    public String getYljgljz() {
        return yljgljz;
    }

    public void setYljgljz(String yljgljz) {
        this.yljgljz = yljgljz;
    }

    public String getYlrljz() {
        return ylrljz;
    }

    public void setYlrljz(String ylrljz) {
        this.ylrljz = ylrljz;
    }

    public String getRzsjljz() {
        return rzsjljz;
    }

    public void setRzsjljz(String rzsjljz) {
        this.rzsjljz = rzsjljz;
    }

    public String getRzsrljz() {
        return rzsrljz;
    }

    public void setRzsrljz(String rzsrljz) {
        this.rzsrljz = rzsrljz;
    }

    public String getNjdssz() {
        return njdssz;
    }

    public void setNjdssz(String njdssz) {
        this.njdssz = njdssz;
    }

    public String getNjdpjz() {
        return njdpjz;
    }

    public void setNjdpjz(String njdpjz) {
        this.njdpjz = njdpjz;
    }

    public String getDl() {
        return dl;
    }

    public void setDl(String dl) {
        this.dl = dl;
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getAnalysisTime() {
        return analysisTime;
    }

    public void setAnalysisTime(String analysisTime) {
        this.analysisTime = analysisTime;
    }

    public String getSendToMQTime() {
        return sendToMQTime;
    }

    public void setSendToMQTime(String sendToMQTime) {
        this.sendToMQTime = sendToMQTime;
    }

    public String getGetForMQTime() {
        return getForMQTime;
    }

    public void setGetForMQTime(String getForMQTime) {
        this.getForMQTime = getForMQTime;
    }

    public String getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(String storageTime) {
        this.storageTime = storageTime;
    }

    public String getSendToMQState() {
        return sendToMQState;
    }

    public void setSendToMQState(String sendToMQState) {
        this.sendToMQState = sendToMQState;
    }

    public String getSendToHJ() {
        return sendToHJ;
    }

    public void setSendToHJ(String sendToHJ) {
        this.sendToHJ = sendToHJ;
    }

    public String getSbbh() {
        return sbbh;
    }

    public void setSbbh(String sbbh) {
        this.sbbh = sbbh;
    }

    public String getJcsd() {
        return jcsd;
    }

    public void setJcsd(String jcsd) {
        this.jcsd = jcsd;
    }

    public String getJczqs() {
        return jczqs;
    }

    public void setJczqs(String jczqs) {
        this.jczqs = jczqs;
    }

    public String getNjd() {
        return njd;
    }

    public void setNjd(String njd) {
        this.njd = njd;
    }

    public String getWdu() {
        return wdu;
    }

    public void setWdu(String wdu) {
        this.wdu = wdu;
    }

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public String getFsdj() {
        return fsdj;
    }

    public void setFsdj(String fsdj) {
        this.fsdj = fsdj;
    }

    public String getJyl() {
        return jyl;
    }

    public void setJyl(String jyl) {
        this.jyl = jyl;
    }

    public String getJxl() {
        return jxl;
    }

    public void setJxl(String jxl) {
        this.jxl = jxl;
    }

    public String getJcsjlx() {
        return jcsjlx;
    }

    public void setJcsjlx(String jcsjlx) {
        this.jcsjlx = jcsjlx;
    }

    public String getFspjz() {
        return fspjz;
    }

    public void setFspjz(String fspjz) {
        this.fspjz = fspjz;
    }

    public String getFspjz_10() {
        return fspjz_10;
    }

    public void setFspjz_10(String fspjz_10) {
        this.fspjz_10 = fspjz_10;
    }

    public String getJcsj() {
        return jcsj;
    }

    public void setJcsj(String jcsj) {
        this.jcsj = jcsj;
    }
}

package com.fliad.hikvision.acl.domain;

import java.util.Date;

/**
 * 交通流量信息
 * Created by dzh on 2019-9-12.
 */
public class TrafficFlowInfo {
    /**
     * //流水号',
     */
    private String lsh;
    /**
     * '设备编号',
     */
    private String sbbh;

    /**
     * //车道号',
     */
    private int cdh;
    /**
     * '统计时间',
     */
    private Date tjsd;

    /**
     * '统计周期数',
     */
    private String tjzqs;

    /**
     * '通行车辆数',
     */
    private int txcls;

    /**
     * //大车数',
     */
    private int dcs;
    /**
     * //小车数',
     */
    private int xcs;
    /**
     * //'中型车数',
     */
    private int zxcs;
    /**
     * '摩托车数量',
     */
    private int mtcsl;

    /**
     * '超长车数量',
     */
    private int cccsl;

    /**
     * //'平均速度',
     */
    private double pjsd;
    /**
     * //'平均车长',
     */
    private double pjcc;
    /**
     * '时间占有率',
     */
    private double sjzyl;

    /**
     * '空间占有率',
     */
    private double kjzyl;

    /**
     * '平均车头时距',
     */
    private double pjctsj;

    /**
     * '平均车头间距',
     */
    private double pjctjj;

    /**
     * //车辆密度',
     */
    private double clmd;
    /**
     * //超速车辆',
     */
    private int cscl;
    /**
     * //低速车辆',
     */
    private int dscl;
    /**
     * '平均排队长度',
     */
    private double pjpdcd;

    /**
     * //'接入时间',
     */
    private Date jrsj;
    /**
     * //'发送时间',
     */
    private Date fssj;
    /**
     * //'入库时间',
     */
    private Date rksj;

    public String getLsh() {
        return lsh;
    }

    public void setLsh(String lsh) {
        this.lsh = lsh;
    }

    public String getSbbh() {
        return sbbh;
    }

    public void setSbbh(String sbbh) {
        this.sbbh = sbbh;
    }

    public int getCdh() {
        return cdh;
    }

    public void setCdh(int cdh) {
        this.cdh = cdh;
    }

    public Date getTjsd() {
        return tjsd;
    }

    public void setTjsd(Date tjsd) {
        this.tjsd = tjsd;
    }

    public String getTjzqs() {
        return tjzqs;
    }

    public void setTjzqs(String tjzqs) {
        this.tjzqs = tjzqs;
    }

    public int getTxcls() {
        return txcls;
    }

    public void setTxcls(int txcls) {
        this.txcls = txcls;
    }

    public int getDcs() {
        return dcs;
    }

    public void setDcs(int dcs) {
        this.dcs = dcs;
    }

    public int getXcs() {
        return xcs;
    }

    public void setXcs(int xcs) {
        this.xcs = xcs;
    }

    public int getZxcs() {
        return zxcs;
    }

    public void setZxcs(int zxcs) {
        this.zxcs = zxcs;
    }

    public int getMtcsl() {
        return mtcsl;
    }

    public void setMtcsl(int mtcsl) {
        this.mtcsl = mtcsl;
    }

    public int getCccsl() {
        return cccsl;
    }

    public void setCccsl(int cccsl) {
        this.cccsl = cccsl;
    }

    public double getPjsd() {
        return pjsd;
    }

    public void setPjsd(double pjsd) {
        this.pjsd = pjsd;
    }

    public double getPjcc() {
        return pjcc;
    }

    public void setPjcc(double pjcc) {
        this.pjcc = pjcc;
    }

    public double getSjzyl() {
        return sjzyl;
    }

    public void setSjzyl(double sjzyl) {
        this.sjzyl = sjzyl;
    }

    public double getKjzyl() {
        return kjzyl;
    }

    public void setKjzyl(double kjzyl) {
        this.kjzyl = kjzyl;
    }

    public double getPjctsj() {
        return pjctsj;
    }

    public void setPjctsj(double pjctsj) {
        this.pjctsj = pjctsj;
    }

    public double getPjctjj() {
        return pjctjj;
    }

    public void setPjctjj(double pjctjj) {
        this.pjctjj = pjctjj;
    }

    public double getClmd() {
        return clmd;
    }

    public void setClmd(double clmd) {
        this.clmd = clmd;
    }

    public int getCscl() {
        return cscl;
    }

    public void setCscl(int cscl) {
        this.cscl = cscl;
    }

    public int getDscl() {
        return dscl;
    }

    public void setDscl(int dscl) {
        this.dscl = dscl;
    }

    public double getPjpdcd() {
        return pjpdcd;
    }

    public void setPjpdcd(double pjpdcd) {
        this.pjpdcd = pjpdcd;
    }

    public Date getJrsj() {
        return jrsj;
    }

    public void setJrsj(Date jrsj) {
        this.jrsj = jrsj;
    }

    public Date getFssj() {
        return fssj;
    }

    public void setFssj(Date fssj) {
        this.fssj = fssj;
    }

    public Date getRksj() {
        return rksj;
    }

    public void setRksj(Date rksj) {
        this.rksj = rksj;
    }
}

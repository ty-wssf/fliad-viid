package com.fliad.viid.modular.hikvision.acl.domain;

import lombok.Data;

import java.util.Date;

/**
 * 交通流量信息
 * Created by dzh on 2019-9-12.
 */
@Data
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
}

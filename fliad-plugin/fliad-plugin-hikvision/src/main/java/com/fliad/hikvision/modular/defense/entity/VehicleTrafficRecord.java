/*
 * Copyright [2022] [https://www.xiaonuo.vip]
 *
 * Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：
 *
 * 1.请不要删除和修改根目录下的LICENSE文件。
 * 2.请不要删除和修改Snowy源码头部的版权声明。
 * 3.本项目代码可免费商业使用，商业使用请保留源码和相关描述文件的项目出处，作者声明等。
 * 4.分发源码时候，请注明软件出处 https://www.xiaonuo.vip
 * 5.不可二次分发开源参与同类竞品，如有想法可联系团队xiaonuobase@qq.com商议合作。
 * 6.若您的项目无法满足以上几点，需要更多功能代码，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package com.fliad.hikvision.modular.defense.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 车辆通行记录实体
 *
 * @author yongjiu
 * @date 2025/11/06
 **/
@Table(value = "VEHICLE_TRAFFIC_RECORD")
public class VehicleTrafficRecord {

    /** ID */
    @Id
    @ApiModelProperty(value = "ID", position = 1)
    private String id;

    /** 卡口编号，符合GA/T 16.31与GA/T 543.10要求 */
    @ApiModelProperty(value = "卡口编号", position = 2)
    private String kkbh;

    /** 方向类型 */
    @ApiModelProperty(value = "方向类型", position = 3)
    private String fxlx;

    /** 车道号 */
    @ApiModelProperty(value = "车道号", position = 4)
    private String cdh;

    /** 过车时间，格式yyyy-mm-dd hh24:mi:ss */
    @ApiModelProperty(value = "过车时间", position = 5)
    private Date gcsj;

    /** 违法行为，符合GA/T 16.31与GA/T 543.5要求 */
    @ApiModelProperty(value = "违法行为", position = 6)
    private String wfdm;

    /** 号牌号码，符合GA/T 543.5要求，无牌等用"-"表示 */
    @ApiModelProperty(value = "号牌号码", position = 7)
    private String hphm;

    /** 号牌种类，符合GA/T 16.7与GA/T 543.5要求：01-大型汽车,02-小型汽车,...,99-其他号牌 */
    @ApiModelProperty(value = "号牌种类", position = 8)
    private String hpzl;

    /** 号牌颜色，符合GA/T 543.5要求：1-蓝,2-黄,3-白,4-黑,5-绿,9-其他 */
    @ApiModelProperty(value = "号牌颜色", position = 9)
    private Integer hpys;

    /** 前置号牌号码 */
    @ApiModelProperty(value = "前置号牌号码", position = 10)
    private String fzhphm;

    /** 前置号牌种类 */
    @ApiModelProperty(value = "前置号牌种类", position = 11)
    private String fzhpzl;

    /** 前置号牌颜色 */
    @ApiModelProperty(value = "前置号牌颜色", position = 12)
    private Integer fzhpys;

    /** 车辆类型，符合GA/T 16.4与GA/T 543.5要求 */
    @ApiModelProperty(value = "车辆类型", position = 13)
    private String cllx;

    /** 车外廓长，单位厘米，最长5位 */
    @ApiModelProperty(value = "车外廓长", position = 14)
    private String cwkc;

    /** 车辆品牌，符合GA/T 543.10要求 */
    @ApiModelProperty(value = "车辆品牌", position = 15)
    private String clpp;

    /** 车身颜色，符合GA/T 16.8与GA/T 543.5：A-白,B-灰,C-黄,D-粉,E-红,F-紫,G-绿,H-蓝,I-棕,J-黑 */
    @ApiModelProperty(value = "车身颜色", position = 16)
    private String csys;

    /** 号牌识别可信度，0~100% */
    @ApiModelProperty(value = "号牌识别可信度", position = 17)
    private Integer hpkxd;

    /** 每位号牌识别可信度，格式如"苏-80,B-90,..." */
    @ApiModelProperty(value = "每位号牌识别可信度", position = 18)
    private String mwhpkxd;

    /** 车型识别可信度，0~100% */
    @ApiModelProperty(value = "车型识别可信度", position = 19)
    private Integer cxkxd;

    /** 品牌识别可信度，0~100% */
    @ApiModelProperty(value = "品牌识别可信度", position = 20)
    private Integer ppkxd;

    /** 行为特征，1-不系安全带;2-拨打电话;...多个用分号分隔 */
    @ApiModelProperty(value = "行为特征", position = 21)
    private String xwtz;

    /** 图片路径 */
    @ApiModelProperty(value = "图片路径", position = 22)
    private String tplj;

    /** 通行图片1 */
    @ApiModelProperty(value = "通行图片1", position = 23)
    private String tp1;

    /** 通行图片2 */
    @ApiModelProperty(value = "通行图片2", position = 24)
    private String tp2;

    /** 通行图片3 */
    @ApiModelProperty(value = "通行图片3", position = 25)
    private String tp3;

    /** 特征图片 */
    @ApiModelProperty(value = "特征图片", position = 26)
    private String tztp;

    /** 驾驶人图片 */
    @ApiModelProperty(value = "驾驶人图片", position = 27)
    private String jsrtp;

    /** 车辆速度，单位km/h */
    @ApiModelProperty(value = "车辆速度", position = 28)
    private Integer clsd;

    /** rfid标签芯片识别号 */
    @ApiModelProperty(value = "rfid标签芯片识别号", position = 29)
    private String tid;

    /** 载客人数 */
    @ApiModelProperty(value = "载客人数", position = 30)
    private Integer zkrs;

    /** rfid标识卡号码 */
    @ApiModelProperty(value = "rfid标识卡号码", position = 31)
    private String cid;

    /** 摄像机设备编号 */
    @ApiModelProperty(value = "摄像机设备编号", position = 32)
    private String sxjbh;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKkbh() {
        return kkbh;
    }

    public void setKkbh(String kkbh) {
        this.kkbh = kkbh;
    }

    public String getFxlx() {
        return fxlx;
    }

    public void setFxlx(String fxlx) {
        this.fxlx = fxlx;
    }

    public String getCdh() {
        return cdh;
    }

    public void setCdh(String cdh) {
        this.cdh = cdh;
    }

    public Date getGcsj() {
        return gcsj;
    }

    public void setGcsj(Date gcsj) {
        this.gcsj = gcsj;
    }

    public String getWfdm() {
        return wfdm;
    }

    public void setWfdm(String wfdm) {
        this.wfdm = wfdm;
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm;
    }

    public String getHpzl() {
        return hpzl;
    }

    public void setHpzl(String hpzl) {
        this.hpzl = hpzl;
    }

    public Integer getHpys() {
        return hpys;
    }

    public void setHpys(Integer hpys) {
        this.hpys = hpys;
    }

    public String getFzhphm() {
        return fzhphm;
    }

    public void setFzhphm(String fzhphm) {
        this.fzhphm = fzhphm;
    }

    public String getFzhpzl() {
        return fzhpzl;
    }

    public void setFzhpzl(String fzhpzl) {
        this.fzhpzl = fzhpzl;
    }

    public Integer getFzhpys() {
        return fzhpys;
    }

    public void setFzhpys(Integer fzhpys) {
        this.fzhpys = fzhpys;
    }

    public String getCllx() {
        return cllx;
    }

    public void setCllx(String cllx) {
        this.cllx = cllx;
    }

    public String getCwkc() {
        return cwkc;
    }

    public void setCwkc(String cwkc) {
        this.cwkc = cwkc;
    }

    public String getClpp() {
        return clpp;
    }

    public void setClpp(String clpp) {
        this.clpp = clpp;
    }

    public String getCsys() {
        return csys;
    }

    public void setCsys(String csys) {
        this.csys = csys;
    }

    public Integer getHpkxd() {
        return hpkxd;
    }

    public void setHpkxd(Integer hpkxd) {
        this.hpkxd = hpkxd;
    }

    public String getMwhpkxd() {
        return mwhpkxd;
    }

    public void setMwhpkxd(String mwhpkxd) {
        this.mwhpkxd = mwhpkxd;
    }

    public Integer getCxkxd() {
        return cxkxd;
    }

    public void setCxkxd(Integer cxkxd) {
        this.cxkxd = cxkxd;
    }

    public Integer getPpkxd() {
        return ppkxd;
    }

    public void setPpkxd(Integer ppkxd) {
        this.ppkxd = ppkxd;
    }

    public String getXwtz() {
        return xwtz;
    }

    public void setXwtz(String xwtz) {
        this.xwtz = xwtz;
    }

    public String getTplj() {
        return tplj;
    }

    public void setTplj(String tplj) {
        this.tplj = tplj;
    }

    public String getTp1() {
        return tp1;
    }

    public void setTp1(String tp1) {
        this.tp1 = tp1;
    }

    public String getTp2() {
        return tp2;
    }

    public void setTp2(String tp2) {
        this.tp2 = tp2;
    }

    public String getTp3() {
        return tp3;
    }

    public void setTp3(String tp3) {
        this.tp3 = tp3;
    }

    public String getTztp() {
        return tztp;
    }

    public void setTztp(String tztp) {
        this.tztp = tztp;
    }

    public String getJsrtp() {
        return jsrtp;
    }

    public void setJsrtp(String jsrtp) {
        this.jsrtp = jsrtp;
    }

    public Integer getClsd() {
        return clsd;
    }

    public void setClsd(Integer clsd) {
        this.clsd = clsd;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Integer getZkrs() {
        return zkrs;
    }

    public void setZkrs(Integer zkrs) {
        this.zkrs = zkrs;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSxjbh() {
        return sxjbh;
    }

    public void setSxjbh(String sxjbh) {
        this.sxjbh = sxjbh;
    }
}
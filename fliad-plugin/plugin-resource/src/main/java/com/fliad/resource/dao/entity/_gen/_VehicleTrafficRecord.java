package com.fliad.resource.dao.entity._gen;

import io.nop.orm.model.IEntityModel;
import io.nop.orm.support.DynamicOrmEntity;
import io.nop.orm.support.OrmEntitySet; //NOPMD - suppressed UnusedImports - Auto Gen Code
import io.nop.orm.IOrmEntitySet; //NOPMD - suppressed UnusedImports - Auto Gen Code
import io.nop.api.core.convert.ConvertHelper;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

import com.fliad.resource.dao.entity.VehicleTrafficRecord;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  车辆通行记录信息表: vehicle_traffic_record
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _VehicleTrafficRecord extends DynamicOrmEntity{
    
    /* 主键: ID VARCHAR */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 卡口编号，符合GA/T 16.31与GA/T 543.10要求: KKBH VARCHAR */
    public static final String PROP_NAME_kkbh = "kkbh";
    public static final int PROP_ID_kkbh = 2;
    
    /* 方向类型: FXLX VARCHAR */
    public static final String PROP_NAME_fxlx = "fxlx";
    public static final int PROP_ID_fxlx = 3;
    
    /* 车道号: CDH VARCHAR */
    public static final String PROP_NAME_cdh = "cdh";
    public static final int PROP_ID_cdh = 4;
    
    /* 过车时间，格式yyyy-mm-dd hh24:mi:ss: GCSJ DATETIME */
    public static final String PROP_NAME_gcsj = "gcsj";
    public static final int PROP_ID_gcsj = 5;
    
    /* 违法行为，符合GA/T 16.31与GA/T 543.5要求: WFDM VARCHAR */
    public static final String PROP_NAME_wfdm = "wfdm";
    public static final int PROP_ID_wfdm = 6;
    
    /* 号牌号码，符合GA/T 543.5要求，无牌等用"-"表示: HPHM VARCHAR */
    public static final String PROP_NAME_hphm = "hphm";
    public static final int PROP_ID_hphm = 7;
    
    /* 号牌种类，符合GA/T 16.7与GA/T 543.5要求：01-大型汽车,02-小型汽车,...,99-其他号牌: HPZL VARCHAR */
    public static final String PROP_NAME_hpzl = "hpzl";
    public static final int PROP_ID_hpzl = 8;
    
    /* 号牌颜色，符合GB 1.1-2009：0-白色,1-黄色,2-蓝色,3-黑色,4-绿色,5-未识别,9-其他颜色: HPYS TINYINT */
    public static final String PROP_NAME_hpys = "hpys";
    public static final int PROP_ID_hpys = 9;
    
    /* 辅助号牌号码，无牌等用"-"表示: FZHPHM VARCHAR */
    public static final String PROP_NAME_fzhphm = "fzhphm";
    public static final int PROP_ID_fzhphm = 10;
    
    /* 辅助号牌种类，符合GA/T 16.7与GA/T 543.5要求: FZHPZL VARCHAR */
    public static final String PROP_NAME_fzhpzl = "fzhpzl";
    public static final int PROP_ID_fzhpzl = 11;
    
    /* 辅助号牌颜色：0-白色,1-黄色,2-蓝色,3-黑色,4-绿色,5-未识别,9-其他颜色: FZHPYS TINYINT */
    public static final String PROP_NAME_fzhpys = "fzhpys";
    public static final int PROP_ID_fzhpys = 12;
    
    /* 车辆类型，符合GA/T 16.4与GA/T 543.5要求: CLLX VARCHAR */
    public static final String PROP_NAME_cllx = "cllx";
    public static final int PROP_ID_cllx = 13;
    
    /* 车外廓长，单位厘米，最长5位: CWKC VARCHAR */
    public static final String PROP_NAME_cwkc = "cwkc";
    public static final int PROP_ID_cwkc = 14;
    
    /* 车辆品牌，符合GA/T 543.10要求: CLPP VARCHAR */
    public static final String PROP_NAME_clpp = "clpp";
    public static final int PROP_ID_clpp = 15;
    
    /* 车身颜色，符合GA/T 16.8与GA/T 543.5：A-白,B-灰,C-黄,D-粉,E-红,F-紫,G-绿,H-蓝,I-棕,J-黑: CSYS VARCHAR */
    public static final String PROP_NAME_csys = "csys";
    public static final int PROP_ID_csys = 16;
    
    /* 号牌识别可信度，0~100%: HPKXD TINYINT */
    public static final String PROP_NAME_hpkxd = "hpkxd";
    public static final int PROP_ID_hpkxd = 17;
    
    /* 每位号牌识别可信度，格式如"苏-80,B-90,...": MWHPKXD VARCHAR */
    public static final String PROP_NAME_mwhpkxd = "mwhpkxd";
    public static final int PROP_ID_mwhpkxd = 18;
    
    /* 车型识别可信度，0~100%: CXKXD TINYINT */
    public static final String PROP_NAME_cxkxd = "cxkxd";
    public static final int PROP_ID_cxkxd = 19;
    
    /* 品牌识别可信度，0~100%: PPKXD TINYINT */
    public static final String PROP_NAME_ppkxd = "ppkxd";
    public static final int PROP_ID_ppkxd = 20;
    
    /* 行为特征，1-不系安全带;2-拨打电话;...多个用分号分隔: XWTZ VARCHAR */
    public static final String PROP_NAME_xwtz = "xwtz";
    public static final int PROP_ID_xwtz = 21;
    
    /* 图片路径: TPLJ VARCHAR */
    public static final String PROP_NAME_tplj = "tplj";
    public static final int PROP_ID_tplj = 22;
    
    /* 通行图片1: TP1 VARCHAR */
    public static final String PROP_NAME_tp1 = "tp1";
    public static final int PROP_ID_tp1 = 23;
    
    /* 通行图片2: TP2 VARCHAR */
    public static final String PROP_NAME_tp2 = "tp2";
    public static final int PROP_ID_tp2 = 24;
    
    /* 通行图片3: TP3 VARCHAR */
    public static final String PROP_NAME_tp3 = "tp3";
    public static final int PROP_ID_tp3 = 25;
    
    /* 特征图片: TZTP VARCHAR */
    public static final String PROP_NAME_tztp = "tztp";
    public static final int PROP_ID_tztp = 26;
    
    /* 驾驶人图片: JSRTP VARCHAR */
    public static final String PROP_NAME_jsrtp = "jsrtp";
    public static final int PROP_ID_jsrtp = 27;
    
    /* 车辆速度，单位km/h: CLSD INTEGER */
    public static final String PROP_NAME_clsd = "clsd";
    public static final int PROP_ID_clsd = 28;
    
    /* rfid标签芯片识别号: TID VARCHAR */
    public static final String PROP_NAME_tid = "tid";
    public static final int PROP_ID_tid = 29;
    
    /* 载客人数: ZKRS INTEGER */
    public static final String PROP_NAME_zkrs = "zkrs";
    public static final int PROP_ID_zkrs = 30;
    
    /* rfid标识卡号码: CID VARCHAR */
    public static final String PROP_NAME_cid = "cid";
    public static final int PROP_ID_cid = 31;
    
    /* 摄像机设备编号: SXJBH VARCHAR */
    public static final String PROP_NAME_sxjbh = "sxjbh";
    public static final int PROP_ID_sxjbh = 32;
    

    private static int _PROP_ID_BOUND = 33;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[33];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_kkbh] = PROP_NAME_kkbh;
          PROP_NAME_TO_ID.put(PROP_NAME_kkbh, PROP_ID_kkbh);
      
          PROP_ID_TO_NAME[PROP_ID_fxlx] = PROP_NAME_fxlx;
          PROP_NAME_TO_ID.put(PROP_NAME_fxlx, PROP_ID_fxlx);
      
          PROP_ID_TO_NAME[PROP_ID_cdh] = PROP_NAME_cdh;
          PROP_NAME_TO_ID.put(PROP_NAME_cdh, PROP_ID_cdh);
      
          PROP_ID_TO_NAME[PROP_ID_gcsj] = PROP_NAME_gcsj;
          PROP_NAME_TO_ID.put(PROP_NAME_gcsj, PROP_ID_gcsj);
      
          PROP_ID_TO_NAME[PROP_ID_wfdm] = PROP_NAME_wfdm;
          PROP_NAME_TO_ID.put(PROP_NAME_wfdm, PROP_ID_wfdm);
      
          PROP_ID_TO_NAME[PROP_ID_hphm] = PROP_NAME_hphm;
          PROP_NAME_TO_ID.put(PROP_NAME_hphm, PROP_ID_hphm);
      
          PROP_ID_TO_NAME[PROP_ID_hpzl] = PROP_NAME_hpzl;
          PROP_NAME_TO_ID.put(PROP_NAME_hpzl, PROP_ID_hpzl);
      
          PROP_ID_TO_NAME[PROP_ID_hpys] = PROP_NAME_hpys;
          PROP_NAME_TO_ID.put(PROP_NAME_hpys, PROP_ID_hpys);
      
          PROP_ID_TO_NAME[PROP_ID_fzhphm] = PROP_NAME_fzhphm;
          PROP_NAME_TO_ID.put(PROP_NAME_fzhphm, PROP_ID_fzhphm);
      
          PROP_ID_TO_NAME[PROP_ID_fzhpzl] = PROP_NAME_fzhpzl;
          PROP_NAME_TO_ID.put(PROP_NAME_fzhpzl, PROP_ID_fzhpzl);
      
          PROP_ID_TO_NAME[PROP_ID_fzhpys] = PROP_NAME_fzhpys;
          PROP_NAME_TO_ID.put(PROP_NAME_fzhpys, PROP_ID_fzhpys);
      
          PROP_ID_TO_NAME[PROP_ID_cllx] = PROP_NAME_cllx;
          PROP_NAME_TO_ID.put(PROP_NAME_cllx, PROP_ID_cllx);
      
          PROP_ID_TO_NAME[PROP_ID_cwkc] = PROP_NAME_cwkc;
          PROP_NAME_TO_ID.put(PROP_NAME_cwkc, PROP_ID_cwkc);
      
          PROP_ID_TO_NAME[PROP_ID_clpp] = PROP_NAME_clpp;
          PROP_NAME_TO_ID.put(PROP_NAME_clpp, PROP_ID_clpp);
      
          PROP_ID_TO_NAME[PROP_ID_csys] = PROP_NAME_csys;
          PROP_NAME_TO_ID.put(PROP_NAME_csys, PROP_ID_csys);
      
          PROP_ID_TO_NAME[PROP_ID_hpkxd] = PROP_NAME_hpkxd;
          PROP_NAME_TO_ID.put(PROP_NAME_hpkxd, PROP_ID_hpkxd);
      
          PROP_ID_TO_NAME[PROP_ID_mwhpkxd] = PROP_NAME_mwhpkxd;
          PROP_NAME_TO_ID.put(PROP_NAME_mwhpkxd, PROP_ID_mwhpkxd);
      
          PROP_ID_TO_NAME[PROP_ID_cxkxd] = PROP_NAME_cxkxd;
          PROP_NAME_TO_ID.put(PROP_NAME_cxkxd, PROP_ID_cxkxd);
      
          PROP_ID_TO_NAME[PROP_ID_ppkxd] = PROP_NAME_ppkxd;
          PROP_NAME_TO_ID.put(PROP_NAME_ppkxd, PROP_ID_ppkxd);
      
          PROP_ID_TO_NAME[PROP_ID_xwtz] = PROP_NAME_xwtz;
          PROP_NAME_TO_ID.put(PROP_NAME_xwtz, PROP_ID_xwtz);
      
          PROP_ID_TO_NAME[PROP_ID_tplj] = PROP_NAME_tplj;
          PROP_NAME_TO_ID.put(PROP_NAME_tplj, PROP_ID_tplj);
      
          PROP_ID_TO_NAME[PROP_ID_tp1] = PROP_NAME_tp1;
          PROP_NAME_TO_ID.put(PROP_NAME_tp1, PROP_ID_tp1);
      
          PROP_ID_TO_NAME[PROP_ID_tp2] = PROP_NAME_tp2;
          PROP_NAME_TO_ID.put(PROP_NAME_tp2, PROP_ID_tp2);
      
          PROP_ID_TO_NAME[PROP_ID_tp3] = PROP_NAME_tp3;
          PROP_NAME_TO_ID.put(PROP_NAME_tp3, PROP_ID_tp3);
      
          PROP_ID_TO_NAME[PROP_ID_tztp] = PROP_NAME_tztp;
          PROP_NAME_TO_ID.put(PROP_NAME_tztp, PROP_ID_tztp);
      
          PROP_ID_TO_NAME[PROP_ID_jsrtp] = PROP_NAME_jsrtp;
          PROP_NAME_TO_ID.put(PROP_NAME_jsrtp, PROP_ID_jsrtp);
      
          PROP_ID_TO_NAME[PROP_ID_clsd] = PROP_NAME_clsd;
          PROP_NAME_TO_ID.put(PROP_NAME_clsd, PROP_ID_clsd);
      
          PROP_ID_TO_NAME[PROP_ID_tid] = PROP_NAME_tid;
          PROP_NAME_TO_ID.put(PROP_NAME_tid, PROP_ID_tid);
      
          PROP_ID_TO_NAME[PROP_ID_zkrs] = PROP_NAME_zkrs;
          PROP_NAME_TO_ID.put(PROP_NAME_zkrs, PROP_ID_zkrs);
      
          PROP_ID_TO_NAME[PROP_ID_cid] = PROP_NAME_cid;
          PROP_NAME_TO_ID.put(PROP_NAME_cid, PROP_ID_cid);
      
          PROP_ID_TO_NAME[PROP_ID_sxjbh] = PROP_NAME_sxjbh;
          PROP_NAME_TO_ID.put(PROP_NAME_sxjbh, PROP_ID_sxjbh);
      
    }

    
    /* 主键: ID */
    private java.lang.String _id_;
    
    /* 卡口编号，符合GA/T 16.31与GA/T 543.10要求: KKBH */
    private java.lang.String _kkbh;
    
    /* 方向类型: FXLX */
    private java.lang.String _fxlx;
    
    /* 车道号: CDH */
    private java.lang.String _cdh;
    
    /* 过车时间，格式yyyy-mm-dd hh24:mi:ss: GCSJ */
    private java.time.LocalDateTime _gcsj;
    
    /* 违法行为，符合GA/T 16.31与GA/T 543.5要求: WFDM */
    private java.lang.String _wfdm;
    
    /* 号牌号码，符合GA/T 543.5要求，无牌等用"-"表示: HPHM */
    private java.lang.String _hphm;
    
    /* 号牌种类，符合GA/T 16.7与GA/T 543.5要求：01-大型汽车,02-小型汽车,...,99-其他号牌: HPZL */
    private java.lang.String _hpzl;
    
    /* 号牌颜色，符合GB 1.1-2009：0-白色,1-黄色,2-蓝色,3-黑色,4-绿色,5-未识别,9-其他颜色: HPYS */
    private java.lang.Byte _hpys;
    
    /* 辅助号牌号码，无牌等用"-"表示: FZHPHM */
    private java.lang.String _fzhphm;
    
    /* 辅助号牌种类，符合GA/T 16.7与GA/T 543.5要求: FZHPZL */
    private java.lang.String _fzhpzl;
    
    /* 辅助号牌颜色：0-白色,1-黄色,2-蓝色,3-黑色,4-绿色,5-未识别,9-其他颜色: FZHPYS */
    private java.lang.Byte _fzhpys;
    
    /* 车辆类型，符合GA/T 16.4与GA/T 543.5要求: CLLX */
    private java.lang.String _cllx;
    
    /* 车外廓长，单位厘米，最长5位: CWKC */
    private java.lang.String _cwkc;
    
    /* 车辆品牌，符合GA/T 543.10要求: CLPP */
    private java.lang.String _clpp;
    
    /* 车身颜色，符合GA/T 16.8与GA/T 543.5：A-白,B-灰,C-黄,D-粉,E-红,F-紫,G-绿,H-蓝,I-棕,J-黑: CSYS */
    private java.lang.String _csys;
    
    /* 号牌识别可信度，0~100%: HPKXD */
    private java.lang.Byte _hpkxd;
    
    /* 每位号牌识别可信度，格式如"苏-80,B-90,...": MWHPKXD */
    private java.lang.String _mwhpkxd;
    
    /* 车型识别可信度，0~100%: CXKXD */
    private java.lang.Byte _cxkxd;
    
    /* 品牌识别可信度，0~100%: PPKXD */
    private java.lang.Byte _ppkxd;
    
    /* 行为特征，1-不系安全带;2-拨打电话;...多个用分号分隔: XWTZ */
    private java.lang.String _xwtz;
    
    /* 图片路径: TPLJ */
    private java.lang.String _tplj;
    
    /* 通行图片1: TP1 */
    private java.lang.String _tp1;
    
    /* 通行图片2: TP2 */
    private java.lang.String _tp2;
    
    /* 通行图片3: TP3 */
    private java.lang.String _tp3;
    
    /* 特征图片: TZTP */
    private java.lang.String _tztp;
    
    /* 驾驶人图片: JSRTP */
    private java.lang.String _jsrtp;
    
    /* 车辆速度，单位km/h: CLSD */
    private java.lang.Integer _clsd;
    
    /* rfid标签芯片识别号: TID */
    private java.lang.String _tid;
    
    /* 载客人数: ZKRS */
    private java.lang.Integer _zkrs;
    
    /* rfid标识卡号码: CID */
    private java.lang.String _cid;
    
    /* 摄像机设备编号: SXJBH */
    private java.lang.String _sxjbh;
    

    public _VehicleTrafficRecord(){
        // for debug
    }

    protected VehicleTrafficRecord newInstance(){
        VehicleTrafficRecord entity = new VehicleTrafficRecord();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public VehicleTrafficRecord cloneInstance() {
        VehicleTrafficRecord entity = newInstance();
        orm_forEachInitedProp((value, propId) -> {
            entity.orm_propValue(propId,value);
        });
        return entity;
    }

    @Override
    public String orm_entityName() {
      // 如果存在实体模型对象，则以模型对象上的设置为准
      IEntityModel entityModel = orm_entityModel();
      if(entityModel != null)
          return entityModel.getName();
      return "com.fliad.resource.dao.entity.VehicleTrafficRecord";
    }

    @Override
    public int orm_propIdBound(){
      IEntityModel entityModel = orm_entityModel();
      if(entityModel != null)
          return entityModel.getPropIdBound();
      return _PROP_ID_BOUND;
    }

    @Override
    public Object orm_id() {
    
        return buildSimpleId(PROP_ID_id_);
     
    }

    @Override
    public boolean orm_isPrimary(int propId) {
        
            return propId == PROP_ID_id_;
          
    }

    @Override
    public String orm_propName(int propId) {
        if(propId >= PROP_ID_TO_NAME.length)
            return super.orm_propName(propId);
        String propName = PROP_ID_TO_NAME[propId];
        if(propName == null)
           return super.orm_propName(propId);
        return propName;
    }

    @Override
    public int orm_propId(String propName) {
        Integer propId = PROP_NAME_TO_ID.get(propName);
        if(propId == null)
            return super.orm_propId(propName);
        return propId;
    }

    @Override
    public Object orm_propValue(int propId) {
        switch(propId){
        
            case PROP_ID_id_:
               return getId_();
        
            case PROP_ID_kkbh:
               return getKkbh();
        
            case PROP_ID_fxlx:
               return getFxlx();
        
            case PROP_ID_cdh:
               return getCdh();
        
            case PROP_ID_gcsj:
               return getGcsj();
        
            case PROP_ID_wfdm:
               return getWfdm();
        
            case PROP_ID_hphm:
               return getHphm();
        
            case PROP_ID_hpzl:
               return getHpzl();
        
            case PROP_ID_hpys:
               return getHpys();
        
            case PROP_ID_fzhphm:
               return getFzhphm();
        
            case PROP_ID_fzhpzl:
               return getFzhpzl();
        
            case PROP_ID_fzhpys:
               return getFzhpys();
        
            case PROP_ID_cllx:
               return getCllx();
        
            case PROP_ID_cwkc:
               return getCwkc();
        
            case PROP_ID_clpp:
               return getClpp();
        
            case PROP_ID_csys:
               return getCsys();
        
            case PROP_ID_hpkxd:
               return getHpkxd();
        
            case PROP_ID_mwhpkxd:
               return getMwhpkxd();
        
            case PROP_ID_cxkxd:
               return getCxkxd();
        
            case PROP_ID_ppkxd:
               return getPpkxd();
        
            case PROP_ID_xwtz:
               return getXwtz();
        
            case PROP_ID_tplj:
               return getTplj();
        
            case PROP_ID_tp1:
               return getTp1();
        
            case PROP_ID_tp2:
               return getTp2();
        
            case PROP_ID_tp3:
               return getTp3();
        
            case PROP_ID_tztp:
               return getTztp();
        
            case PROP_ID_jsrtp:
               return getJsrtp();
        
            case PROP_ID_clsd:
               return getClsd();
        
            case PROP_ID_tid:
               return getTid();
        
            case PROP_ID_zkrs:
               return getZkrs();
        
            case PROP_ID_cid:
               return getCid();
        
            case PROP_ID_sxjbh:
               return getSxjbh();
        
           default:
              return super.orm_propValue(propId);
        }
    }

    

    @Override
    public void orm_propValue(int propId, Object value){
        switch(propId){
        
            case PROP_ID_id_:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_id_));
               }
               setId_(typedValue);
               break;
            }
        
            case PROP_ID_kkbh:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_kkbh));
               }
               setKkbh(typedValue);
               break;
            }
        
            case PROP_ID_fxlx:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_fxlx));
               }
               setFxlx(typedValue);
               break;
            }
        
            case PROP_ID_cdh:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_cdh));
               }
               setCdh(typedValue);
               break;
            }
        
            case PROP_ID_gcsj:{
               java.time.LocalDateTime typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLocalDateTime(value,
                       err-> newTypeConversionError(PROP_NAME_gcsj));
               }
               setGcsj(typedValue);
               break;
            }
        
            case PROP_ID_wfdm:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_wfdm));
               }
               setWfdm(typedValue);
               break;
            }
        
            case PROP_ID_hphm:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_hphm));
               }
               setHphm(typedValue);
               break;
            }
        
            case PROP_ID_hpzl:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_hpzl));
               }
               setHpzl(typedValue);
               break;
            }
        
            case PROP_ID_hpys:{
               java.lang.Byte typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toByte(value,
                       err-> newTypeConversionError(PROP_NAME_hpys));
               }
               setHpys(typedValue);
               break;
            }
        
            case PROP_ID_fzhphm:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_fzhphm));
               }
               setFzhphm(typedValue);
               break;
            }
        
            case PROP_ID_fzhpzl:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_fzhpzl));
               }
               setFzhpzl(typedValue);
               break;
            }
        
            case PROP_ID_fzhpys:{
               java.lang.Byte typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toByte(value,
                       err-> newTypeConversionError(PROP_NAME_fzhpys));
               }
               setFzhpys(typedValue);
               break;
            }
        
            case PROP_ID_cllx:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_cllx));
               }
               setCllx(typedValue);
               break;
            }
        
            case PROP_ID_cwkc:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_cwkc));
               }
               setCwkc(typedValue);
               break;
            }
        
            case PROP_ID_clpp:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_clpp));
               }
               setClpp(typedValue);
               break;
            }
        
            case PROP_ID_csys:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_csys));
               }
               setCsys(typedValue);
               break;
            }
        
            case PROP_ID_hpkxd:{
               java.lang.Byte typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toByte(value,
                       err-> newTypeConversionError(PROP_NAME_hpkxd));
               }
               setHpkxd(typedValue);
               break;
            }
        
            case PROP_ID_mwhpkxd:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_mwhpkxd));
               }
               setMwhpkxd(typedValue);
               break;
            }
        
            case PROP_ID_cxkxd:{
               java.lang.Byte typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toByte(value,
                       err-> newTypeConversionError(PROP_NAME_cxkxd));
               }
               setCxkxd(typedValue);
               break;
            }
        
            case PROP_ID_ppkxd:{
               java.lang.Byte typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toByte(value,
                       err-> newTypeConversionError(PROP_NAME_ppkxd));
               }
               setPpkxd(typedValue);
               break;
            }
        
            case PROP_ID_xwtz:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_xwtz));
               }
               setXwtz(typedValue);
               break;
            }
        
            case PROP_ID_tplj:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_tplj));
               }
               setTplj(typedValue);
               break;
            }
        
            case PROP_ID_tp1:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_tp1));
               }
               setTp1(typedValue);
               break;
            }
        
            case PROP_ID_tp2:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_tp2));
               }
               setTp2(typedValue);
               break;
            }
        
            case PROP_ID_tp3:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_tp3));
               }
               setTp3(typedValue);
               break;
            }
        
            case PROP_ID_tztp:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_tztp));
               }
               setTztp(typedValue);
               break;
            }
        
            case PROP_ID_jsrtp:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_jsrtp));
               }
               setJsrtp(typedValue);
               break;
            }
        
            case PROP_ID_clsd:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_clsd));
               }
               setClsd(typedValue);
               break;
            }
        
            case PROP_ID_tid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_tid));
               }
               setTid(typedValue);
               break;
            }
        
            case PROP_ID_zkrs:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_zkrs));
               }
               setZkrs(typedValue);
               break;
            }
        
            case PROP_ID_cid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_cid));
               }
               setCid(typedValue);
               break;
            }
        
            case PROP_ID_sxjbh:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_sxjbh));
               }
               setSxjbh(typedValue);
               break;
            }
        
           default:
              super.orm_propValue(propId,value);
        }
    }

    @Override
    public void orm_internalSet(int propId, Object value) {
        switch(propId){
        
            case PROP_ID_id_:{
               onInitProp(propId);
               this._id_ = (java.lang.String)value;
               orm_id(); // 如果是设置主键字段，则触发watcher
               break;
            }
        
            case PROP_ID_kkbh:{
               onInitProp(propId);
               this._kkbh = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_fxlx:{
               onInitProp(propId);
               this._fxlx = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_cdh:{
               onInitProp(propId);
               this._cdh = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_gcsj:{
               onInitProp(propId);
               this._gcsj = (java.time.LocalDateTime)value;
               
               break;
            }
        
            case PROP_ID_wfdm:{
               onInitProp(propId);
               this._wfdm = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_hphm:{
               onInitProp(propId);
               this._hphm = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_hpzl:{
               onInitProp(propId);
               this._hpzl = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_hpys:{
               onInitProp(propId);
               this._hpys = (java.lang.Byte)value;
               
               break;
            }
        
            case PROP_ID_fzhphm:{
               onInitProp(propId);
               this._fzhphm = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_fzhpzl:{
               onInitProp(propId);
               this._fzhpzl = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_fzhpys:{
               onInitProp(propId);
               this._fzhpys = (java.lang.Byte)value;
               
               break;
            }
        
            case PROP_ID_cllx:{
               onInitProp(propId);
               this._cllx = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_cwkc:{
               onInitProp(propId);
               this._cwkc = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_clpp:{
               onInitProp(propId);
               this._clpp = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_csys:{
               onInitProp(propId);
               this._csys = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_hpkxd:{
               onInitProp(propId);
               this._hpkxd = (java.lang.Byte)value;
               
               break;
            }
        
            case PROP_ID_mwhpkxd:{
               onInitProp(propId);
               this._mwhpkxd = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_cxkxd:{
               onInitProp(propId);
               this._cxkxd = (java.lang.Byte)value;
               
               break;
            }
        
            case PROP_ID_ppkxd:{
               onInitProp(propId);
               this._ppkxd = (java.lang.Byte)value;
               
               break;
            }
        
            case PROP_ID_xwtz:{
               onInitProp(propId);
               this._xwtz = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_tplj:{
               onInitProp(propId);
               this._tplj = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_tp1:{
               onInitProp(propId);
               this._tp1 = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_tp2:{
               onInitProp(propId);
               this._tp2 = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_tp3:{
               onInitProp(propId);
               this._tp3 = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_tztp:{
               onInitProp(propId);
               this._tztp = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_jsrtp:{
               onInitProp(propId);
               this._jsrtp = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_clsd:{
               onInitProp(propId);
               this._clsd = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_tid:{
               onInitProp(propId);
               this._tid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_zkrs:{
               onInitProp(propId);
               this._zkrs = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_cid:{
               onInitProp(propId);
               this._cid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_sxjbh:{
               onInitProp(propId);
               this._sxjbh = (java.lang.String)value;
               
               break;
            }
        
           default:
              super.orm_internalSet(propId,value);
        }
    }

    
    /**
     * 主键: ID
     */
    public final java.lang.String getId_(){
         onPropGet(PROP_ID_id_);
         return _id_;
    }

    /**
     * 主键: ID
     */
    public final void setId_(java.lang.String value){
        if(onPropSet(PROP_ID_id_,value)){
            this._id_ = value;
            internalClearRefs(PROP_ID_id_);
            orm_id();
        }
    }
    
    /**
     * 卡口编号，符合GA/T 16.31与GA/T 543.10要求: KKBH
     */
    public final java.lang.String getKkbh(){
         onPropGet(PROP_ID_kkbh);
         return _kkbh;
    }

    /**
     * 卡口编号，符合GA/T 16.31与GA/T 543.10要求: KKBH
     */
    public final void setKkbh(java.lang.String value){
        if(onPropSet(PROP_ID_kkbh,value)){
            this._kkbh = value;
            internalClearRefs(PROP_ID_kkbh);
            
        }
    }
    
    /**
     * 方向类型: FXLX
     */
    public final java.lang.String getFxlx(){
         onPropGet(PROP_ID_fxlx);
         return _fxlx;
    }

    /**
     * 方向类型: FXLX
     */
    public final void setFxlx(java.lang.String value){
        if(onPropSet(PROP_ID_fxlx,value)){
            this._fxlx = value;
            internalClearRefs(PROP_ID_fxlx);
            
        }
    }
    
    /**
     * 车道号: CDH
     */
    public final java.lang.String getCdh(){
         onPropGet(PROP_ID_cdh);
         return _cdh;
    }

    /**
     * 车道号: CDH
     */
    public final void setCdh(java.lang.String value){
        if(onPropSet(PROP_ID_cdh,value)){
            this._cdh = value;
            internalClearRefs(PROP_ID_cdh);
            
        }
    }
    
    /**
     * 过车时间，格式yyyy-mm-dd hh24:mi:ss: GCSJ
     */
    public final java.time.LocalDateTime getGcsj(){
         onPropGet(PROP_ID_gcsj);
         return _gcsj;
    }

    /**
     * 过车时间，格式yyyy-mm-dd hh24:mi:ss: GCSJ
     */
    public final void setGcsj(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_gcsj,value)){
            this._gcsj = value;
            internalClearRefs(PROP_ID_gcsj);
            
        }
    }
    
    /**
     * 违法行为，符合GA/T 16.31与GA/T 543.5要求: WFDM
     */
    public final java.lang.String getWfdm(){
         onPropGet(PROP_ID_wfdm);
         return _wfdm;
    }

    /**
     * 违法行为，符合GA/T 16.31与GA/T 543.5要求: WFDM
     */
    public final void setWfdm(java.lang.String value){
        if(onPropSet(PROP_ID_wfdm,value)){
            this._wfdm = value;
            internalClearRefs(PROP_ID_wfdm);
            
        }
    }
    
    /**
     * 号牌号码，符合GA/T 543.5要求，无牌等用"-"表示: HPHM
     */
    public final java.lang.String getHphm(){
         onPropGet(PROP_ID_hphm);
         return _hphm;
    }

    /**
     * 号牌号码，符合GA/T 543.5要求，无牌等用"-"表示: HPHM
     */
    public final void setHphm(java.lang.String value){
        if(onPropSet(PROP_ID_hphm,value)){
            this._hphm = value;
            internalClearRefs(PROP_ID_hphm);
            
        }
    }
    
    /**
     * 号牌种类，符合GA/T 16.7与GA/T 543.5要求：01-大型汽车,02-小型汽车,...,99-其他号牌: HPZL
     */
    public final java.lang.String getHpzl(){
         onPropGet(PROP_ID_hpzl);
         return _hpzl;
    }

    /**
     * 号牌种类，符合GA/T 16.7与GA/T 543.5要求：01-大型汽车,02-小型汽车,...,99-其他号牌: HPZL
     */
    public final void setHpzl(java.lang.String value){
        if(onPropSet(PROP_ID_hpzl,value)){
            this._hpzl = value;
            internalClearRefs(PROP_ID_hpzl);
            
        }
    }
    
    /**
     * 号牌颜色，符合GB 1.1-2009：0-白色,1-黄色,2-蓝色,3-黑色,4-绿色,5-未识别,9-其他颜色: HPYS
     */
    public final java.lang.Byte getHpys(){
         onPropGet(PROP_ID_hpys);
         return _hpys;
    }

    /**
     * 号牌颜色，符合GB 1.1-2009：0-白色,1-黄色,2-蓝色,3-黑色,4-绿色,5-未识别,9-其他颜色: HPYS
     */
    public final void setHpys(java.lang.Byte value){
        if(onPropSet(PROP_ID_hpys,value)){
            this._hpys = value;
            internalClearRefs(PROP_ID_hpys);
            
        }
    }
    
    /**
     * 辅助号牌号码，无牌等用"-"表示: FZHPHM
     */
    public final java.lang.String getFzhphm(){
         onPropGet(PROP_ID_fzhphm);
         return _fzhphm;
    }

    /**
     * 辅助号牌号码，无牌等用"-"表示: FZHPHM
     */
    public final void setFzhphm(java.lang.String value){
        if(onPropSet(PROP_ID_fzhphm,value)){
            this._fzhphm = value;
            internalClearRefs(PROP_ID_fzhphm);
            
        }
    }
    
    /**
     * 辅助号牌种类，符合GA/T 16.7与GA/T 543.5要求: FZHPZL
     */
    public final java.lang.String getFzhpzl(){
         onPropGet(PROP_ID_fzhpzl);
         return _fzhpzl;
    }

    /**
     * 辅助号牌种类，符合GA/T 16.7与GA/T 543.5要求: FZHPZL
     */
    public final void setFzhpzl(java.lang.String value){
        if(onPropSet(PROP_ID_fzhpzl,value)){
            this._fzhpzl = value;
            internalClearRefs(PROP_ID_fzhpzl);
            
        }
    }
    
    /**
     * 辅助号牌颜色：0-白色,1-黄色,2-蓝色,3-黑色,4-绿色,5-未识别,9-其他颜色: FZHPYS
     */
    public final java.lang.Byte getFzhpys(){
         onPropGet(PROP_ID_fzhpys);
         return _fzhpys;
    }

    /**
     * 辅助号牌颜色：0-白色,1-黄色,2-蓝色,3-黑色,4-绿色,5-未识别,9-其他颜色: FZHPYS
     */
    public final void setFzhpys(java.lang.Byte value){
        if(onPropSet(PROP_ID_fzhpys,value)){
            this._fzhpys = value;
            internalClearRefs(PROP_ID_fzhpys);
            
        }
    }
    
    /**
     * 车辆类型，符合GA/T 16.4与GA/T 543.5要求: CLLX
     */
    public final java.lang.String getCllx(){
         onPropGet(PROP_ID_cllx);
         return _cllx;
    }

    /**
     * 车辆类型，符合GA/T 16.4与GA/T 543.5要求: CLLX
     */
    public final void setCllx(java.lang.String value){
        if(onPropSet(PROP_ID_cllx,value)){
            this._cllx = value;
            internalClearRefs(PROP_ID_cllx);
            
        }
    }
    
    /**
     * 车外廓长，单位厘米，最长5位: CWKC
     */
    public final java.lang.String getCwkc(){
         onPropGet(PROP_ID_cwkc);
         return _cwkc;
    }

    /**
     * 车外廓长，单位厘米，最长5位: CWKC
     */
    public final void setCwkc(java.lang.String value){
        if(onPropSet(PROP_ID_cwkc,value)){
            this._cwkc = value;
            internalClearRefs(PROP_ID_cwkc);
            
        }
    }
    
    /**
     * 车辆品牌，符合GA/T 543.10要求: CLPP
     */
    public final java.lang.String getClpp(){
         onPropGet(PROP_ID_clpp);
         return _clpp;
    }

    /**
     * 车辆品牌，符合GA/T 543.10要求: CLPP
     */
    public final void setClpp(java.lang.String value){
        if(onPropSet(PROP_ID_clpp,value)){
            this._clpp = value;
            internalClearRefs(PROP_ID_clpp);
            
        }
    }
    
    /**
     * 车身颜色，符合GA/T 16.8与GA/T 543.5：A-白,B-灰,C-黄,D-粉,E-红,F-紫,G-绿,H-蓝,I-棕,J-黑: CSYS
     */
    public final java.lang.String getCsys(){
         onPropGet(PROP_ID_csys);
         return _csys;
    }

    /**
     * 车身颜色，符合GA/T 16.8与GA/T 543.5：A-白,B-灰,C-黄,D-粉,E-红,F-紫,G-绿,H-蓝,I-棕,J-黑: CSYS
     */
    public final void setCsys(java.lang.String value){
        if(onPropSet(PROP_ID_csys,value)){
            this._csys = value;
            internalClearRefs(PROP_ID_csys);
            
        }
    }
    
    /**
     * 号牌识别可信度，0~100%: HPKXD
     */
    public final java.lang.Byte getHpkxd(){
         onPropGet(PROP_ID_hpkxd);
         return _hpkxd;
    }

    /**
     * 号牌识别可信度，0~100%: HPKXD
     */
    public final void setHpkxd(java.lang.Byte value){
        if(onPropSet(PROP_ID_hpkxd,value)){
            this._hpkxd = value;
            internalClearRefs(PROP_ID_hpkxd);
            
        }
    }
    
    /**
     * 每位号牌识别可信度，格式如"苏-80,B-90,...": MWHPKXD
     */
    public final java.lang.String getMwhpkxd(){
         onPropGet(PROP_ID_mwhpkxd);
         return _mwhpkxd;
    }

    /**
     * 每位号牌识别可信度，格式如"苏-80,B-90,...": MWHPKXD
     */
    public final void setMwhpkxd(java.lang.String value){
        if(onPropSet(PROP_ID_mwhpkxd,value)){
            this._mwhpkxd = value;
            internalClearRefs(PROP_ID_mwhpkxd);
            
        }
    }
    
    /**
     * 车型识别可信度，0~100%: CXKXD
     */
    public final java.lang.Byte getCxkxd(){
         onPropGet(PROP_ID_cxkxd);
         return _cxkxd;
    }

    /**
     * 车型识别可信度，0~100%: CXKXD
     */
    public final void setCxkxd(java.lang.Byte value){
        if(onPropSet(PROP_ID_cxkxd,value)){
            this._cxkxd = value;
            internalClearRefs(PROP_ID_cxkxd);
            
        }
    }
    
    /**
     * 品牌识别可信度，0~100%: PPKXD
     */
    public final java.lang.Byte getPpkxd(){
         onPropGet(PROP_ID_ppkxd);
         return _ppkxd;
    }

    /**
     * 品牌识别可信度，0~100%: PPKXD
     */
    public final void setPpkxd(java.lang.Byte value){
        if(onPropSet(PROP_ID_ppkxd,value)){
            this._ppkxd = value;
            internalClearRefs(PROP_ID_ppkxd);
            
        }
    }
    
    /**
     * 行为特征，1-不系安全带;2-拨打电话;...多个用分号分隔: XWTZ
     */
    public final java.lang.String getXwtz(){
         onPropGet(PROP_ID_xwtz);
         return _xwtz;
    }

    /**
     * 行为特征，1-不系安全带;2-拨打电话;...多个用分号分隔: XWTZ
     */
    public final void setXwtz(java.lang.String value){
        if(onPropSet(PROP_ID_xwtz,value)){
            this._xwtz = value;
            internalClearRefs(PROP_ID_xwtz);
            
        }
    }
    
    /**
     * 图片路径: TPLJ
     */
    public final java.lang.String getTplj(){
         onPropGet(PROP_ID_tplj);
         return _tplj;
    }

    /**
     * 图片路径: TPLJ
     */
    public final void setTplj(java.lang.String value){
        if(onPropSet(PROP_ID_tplj,value)){
            this._tplj = value;
            internalClearRefs(PROP_ID_tplj);
            
        }
    }
    
    /**
     * 通行图片1: TP1
     */
    public final java.lang.String getTp1(){
         onPropGet(PROP_ID_tp1);
         return _tp1;
    }

    /**
     * 通行图片1: TP1
     */
    public final void setTp1(java.lang.String value){
        if(onPropSet(PROP_ID_tp1,value)){
            this._tp1 = value;
            internalClearRefs(PROP_ID_tp1);
            
        }
    }
    
    /**
     * 通行图片2: TP2
     */
    public final java.lang.String getTp2(){
         onPropGet(PROP_ID_tp2);
         return _tp2;
    }

    /**
     * 通行图片2: TP2
     */
    public final void setTp2(java.lang.String value){
        if(onPropSet(PROP_ID_tp2,value)){
            this._tp2 = value;
            internalClearRefs(PROP_ID_tp2);
            
        }
    }
    
    /**
     * 通行图片3: TP3
     */
    public final java.lang.String getTp3(){
         onPropGet(PROP_ID_tp3);
         return _tp3;
    }

    /**
     * 通行图片3: TP3
     */
    public final void setTp3(java.lang.String value){
        if(onPropSet(PROP_ID_tp3,value)){
            this._tp3 = value;
            internalClearRefs(PROP_ID_tp3);
            
        }
    }
    
    /**
     * 特征图片: TZTP
     */
    public final java.lang.String getTztp(){
         onPropGet(PROP_ID_tztp);
         return _tztp;
    }

    /**
     * 特征图片: TZTP
     */
    public final void setTztp(java.lang.String value){
        if(onPropSet(PROP_ID_tztp,value)){
            this._tztp = value;
            internalClearRefs(PROP_ID_tztp);
            
        }
    }
    
    /**
     * 驾驶人图片: JSRTP
     */
    public final java.lang.String getJsrtp(){
         onPropGet(PROP_ID_jsrtp);
         return _jsrtp;
    }

    /**
     * 驾驶人图片: JSRTP
     */
    public final void setJsrtp(java.lang.String value){
        if(onPropSet(PROP_ID_jsrtp,value)){
            this._jsrtp = value;
            internalClearRefs(PROP_ID_jsrtp);
            
        }
    }
    
    /**
     * 车辆速度，单位km/h: CLSD
     */
    public final java.lang.Integer getClsd(){
         onPropGet(PROP_ID_clsd);
         return _clsd;
    }

    /**
     * 车辆速度，单位km/h: CLSD
     */
    public final void setClsd(java.lang.Integer value){
        if(onPropSet(PROP_ID_clsd,value)){
            this._clsd = value;
            internalClearRefs(PROP_ID_clsd);
            
        }
    }
    
    /**
     * rfid标签芯片识别号: TID
     */
    public final java.lang.String getTid(){
         onPropGet(PROP_ID_tid);
         return _tid;
    }

    /**
     * rfid标签芯片识别号: TID
     */
    public final void setTid(java.lang.String value){
        if(onPropSet(PROP_ID_tid,value)){
            this._tid = value;
            internalClearRefs(PROP_ID_tid);
            
        }
    }
    
    /**
     * 载客人数: ZKRS
     */
    public final java.lang.Integer getZkrs(){
         onPropGet(PROP_ID_zkrs);
         return _zkrs;
    }

    /**
     * 载客人数: ZKRS
     */
    public final void setZkrs(java.lang.Integer value){
        if(onPropSet(PROP_ID_zkrs,value)){
            this._zkrs = value;
            internalClearRefs(PROP_ID_zkrs);
            
        }
    }
    
    /**
     * rfid标识卡号码: CID
     */
    public final java.lang.String getCid(){
         onPropGet(PROP_ID_cid);
         return _cid;
    }

    /**
     * rfid标识卡号码: CID
     */
    public final void setCid(java.lang.String value){
        if(onPropSet(PROP_ID_cid,value)){
            this._cid = value;
            internalClearRefs(PROP_ID_cid);
            
        }
    }
    
    /**
     * 摄像机设备编号: SXJBH
     */
    public final java.lang.String getSxjbh(){
         onPropGet(PROP_ID_sxjbh);
         return _sxjbh;
    }

    /**
     * 摄像机设备编号: SXJBH
     */
    public final void setSxjbh(java.lang.String value){
        if(onPropSet(PROP_ID_sxjbh,value)){
            this._sxjbh = value;
            internalClearRefs(PROP_ID_sxjbh);
            
        }
    }
    
}
// resume CPD analysis - CPD-ON

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

import com.fliad.resource.dao.entity.ViidTollgate;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  视频卡口对象表: viid_tollgate
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _ViidTollgate extends DynamicOrmEntity{
    
    /* 主键: ID VARCHAR */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 卡口ID，全局唯一标识，对应DeviceIDType类型，必选字段: TOLLGATEID VARCHAR */
    public static final String PROP_NAME_tollgateid = "tollgateid";
    public static final int PROP_ID_tollgateid = 2;
    
    /* 卡口名称，对应DeviceNameType类型，必选字段: NAME VARCHAR */
    public static final String PROP_NAME_name = "name";
    public static final int PROP_ID_name = 3;
    
    /* 卡口经度，对应LongitudeType类型，必选字段: LONGITUDE DECIMAL */
    public static final String PROP_NAME_longitude = "longitude";
    public static final int PROP_ID_longitude = 4;
    
    /* 卡口纬度，对应LatitudeType类型，必选字段: LATITUDE DECIMAL */
    public static final String PROP_NAME_latitude = "latitude";
    public static final int PROP_ID_latitude = 5;
    
    /* 安装地点行政区划代码，对应PlaceCodeType类型，必选字段: PLACECODE VARCHAR */
    public static final String PROP_NAME_placecode = "placecode";
    public static final int PROP_ID_placecode = 6;
    
    /* 位置名，具体到位置或街道门牌号，由(乡镇街道)+(街路巷)+(门牌号)+(门楼详细地址)构成，可选字段: PLACE VARCHAR */
    public static final String PROP_NAME_place = "place";
    public static final int PROP_ID_place = 7;
    
    /* 卡口状态，1-正常，2-停用，9-其他，对应StatusType类型，必选字段: STATUS TINYINT */
    public static final String PROP_NAME_status = "status";
    public static final int PROP_ID_status = 8;
    
    /* 卡口类型，对应TollgateType类型，必选字段: TOLLGATECAT VARCHAR */
    public static final String PROP_NAME_tollgatecat = "tollgatecat";
    public static final int PROP_ID_tollgatecat = 9;
    
    /* 卡口用途，80-治安卡口，81-交通卡口，82-其他，必选字段: TOLLGATEUSAGE TINYINT */
    public static final String PROP_NAME_tollgateusage = "tollgateusage";
    public static final int PROP_ID_tollgateusage = 10;
    
    /* 卡口车道数，整数类型，可选字段: LANENUM INTEGER */
    public static final String PROP_NAME_lanenum = "lanenum";
    public static final int PROP_ID_lanenum = 11;
    
    /* 管辖单位代码，对应OrgCodeType类型，可选字段: ORGCODE VARCHAR */
    public static final String PROP_NAME_orgcode = "orgcode";
    public static final int PROP_ID_orgcode = 12;
    
    /* 卡口启用时间，启用时间之后的数据有效，可选字段: ACTIVETIME DATETIME */
    public static final String PROP_NAME_activetime = "activetime";
    public static final int PROP_ID_activetime = 13;
    

    private static int _PROP_ID_BOUND = 14;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[14];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_tollgateid] = PROP_NAME_tollgateid;
          PROP_NAME_TO_ID.put(PROP_NAME_tollgateid, PROP_ID_tollgateid);
      
          PROP_ID_TO_NAME[PROP_ID_name] = PROP_NAME_name;
          PROP_NAME_TO_ID.put(PROP_NAME_name, PROP_ID_name);
      
          PROP_ID_TO_NAME[PROP_ID_longitude] = PROP_NAME_longitude;
          PROP_NAME_TO_ID.put(PROP_NAME_longitude, PROP_ID_longitude);
      
          PROP_ID_TO_NAME[PROP_ID_latitude] = PROP_NAME_latitude;
          PROP_NAME_TO_ID.put(PROP_NAME_latitude, PROP_ID_latitude);
      
          PROP_ID_TO_NAME[PROP_ID_placecode] = PROP_NAME_placecode;
          PROP_NAME_TO_ID.put(PROP_NAME_placecode, PROP_ID_placecode);
      
          PROP_ID_TO_NAME[PROP_ID_place] = PROP_NAME_place;
          PROP_NAME_TO_ID.put(PROP_NAME_place, PROP_ID_place);
      
          PROP_ID_TO_NAME[PROP_ID_status] = PROP_NAME_status;
          PROP_NAME_TO_ID.put(PROP_NAME_status, PROP_ID_status);
      
          PROP_ID_TO_NAME[PROP_ID_tollgatecat] = PROP_NAME_tollgatecat;
          PROP_NAME_TO_ID.put(PROP_NAME_tollgatecat, PROP_ID_tollgatecat);
      
          PROP_ID_TO_NAME[PROP_ID_tollgateusage] = PROP_NAME_tollgateusage;
          PROP_NAME_TO_ID.put(PROP_NAME_tollgateusage, PROP_ID_tollgateusage);
      
          PROP_ID_TO_NAME[PROP_ID_lanenum] = PROP_NAME_lanenum;
          PROP_NAME_TO_ID.put(PROP_NAME_lanenum, PROP_ID_lanenum);
      
          PROP_ID_TO_NAME[PROP_ID_orgcode] = PROP_NAME_orgcode;
          PROP_NAME_TO_ID.put(PROP_NAME_orgcode, PROP_ID_orgcode);
      
          PROP_ID_TO_NAME[PROP_ID_activetime] = PROP_NAME_activetime;
          PROP_NAME_TO_ID.put(PROP_NAME_activetime, PROP_ID_activetime);
      
    }

    
    /* 主键: ID */
    private java.lang.String _id_;
    
    /* 卡口ID，全局唯一标识，对应DeviceIDType类型，必选字段: TOLLGATEID */
    private java.lang.String _tollgateid;
    
    /* 卡口名称，对应DeviceNameType类型，必选字段: NAME */
    private java.lang.String _name;
    
    /* 卡口经度，对应LongitudeType类型，必选字段: LONGITUDE */
    private java.math.BigDecimal _longitude;
    
    /* 卡口纬度，对应LatitudeType类型，必选字段: LATITUDE */
    private java.math.BigDecimal _latitude;
    
    /* 安装地点行政区划代码，对应PlaceCodeType类型，必选字段: PLACECODE */
    private java.lang.String _placecode;
    
    /* 位置名，具体到位置或街道门牌号，由(乡镇街道)+(街路巷)+(门牌号)+(门楼详细地址)构成，可选字段: PLACE */
    private java.lang.String _place;
    
    /* 卡口状态，1-正常，2-停用，9-其他，对应StatusType类型，必选字段: STATUS */
    private java.lang.Byte _status;
    
    /* 卡口类型，对应TollgateType类型，必选字段: TOLLGATECAT */
    private java.lang.String _tollgatecat;
    
    /* 卡口用途，80-治安卡口，81-交通卡口，82-其他，必选字段: TOLLGATEUSAGE */
    private java.lang.Byte _tollgateusage;
    
    /* 卡口车道数，整数类型，可选字段: LANENUM */
    private java.lang.Integer _lanenum;
    
    /* 管辖单位代码，对应OrgCodeType类型，可选字段: ORGCODE */
    private java.lang.String _orgcode;
    
    /* 卡口启用时间，启用时间之后的数据有效，可选字段: ACTIVETIME */
    private java.time.LocalDateTime _activetime;
    

    public _ViidTollgate(){
        // for debug
    }

    protected ViidTollgate newInstance(){
        ViidTollgate entity = new ViidTollgate();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public ViidTollgate cloneInstance() {
        ViidTollgate entity = newInstance();
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
      return "com.fliad.resource.dao.entity.ViidTollgate";
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
        
            case PROP_ID_tollgateid:
               return getTollgateid();
        
            case PROP_ID_name:
               return getName();
        
            case PROP_ID_longitude:
               return getLongitude();
        
            case PROP_ID_latitude:
               return getLatitude();
        
            case PROP_ID_placecode:
               return getPlacecode();
        
            case PROP_ID_place:
               return getPlace();
        
            case PROP_ID_status:
               return getStatus();
        
            case PROP_ID_tollgatecat:
               return getTollgatecat();
        
            case PROP_ID_tollgateusage:
               return getTollgateusage();
        
            case PROP_ID_lanenum:
               return getLanenum();
        
            case PROP_ID_orgcode:
               return getOrgcode();
        
            case PROP_ID_activetime:
               return getActivetime();
        
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
        
            case PROP_ID_tollgateid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_tollgateid));
               }
               setTollgateid(typedValue);
               break;
            }
        
            case PROP_ID_name:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_name));
               }
               setName(typedValue);
               break;
            }
        
            case PROP_ID_longitude:{
               java.math.BigDecimal typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toBigDecimal(value,
                       err-> newTypeConversionError(PROP_NAME_longitude));
               }
               setLongitude(typedValue);
               break;
            }
        
            case PROP_ID_latitude:{
               java.math.BigDecimal typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toBigDecimal(value,
                       err-> newTypeConversionError(PROP_NAME_latitude));
               }
               setLatitude(typedValue);
               break;
            }
        
            case PROP_ID_placecode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_placecode));
               }
               setPlacecode(typedValue);
               break;
            }
        
            case PROP_ID_place:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_place));
               }
               setPlace(typedValue);
               break;
            }
        
            case PROP_ID_status:{
               java.lang.Byte typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toByte(value,
                       err-> newTypeConversionError(PROP_NAME_status));
               }
               setStatus(typedValue);
               break;
            }
        
            case PROP_ID_tollgatecat:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_tollgatecat));
               }
               setTollgatecat(typedValue);
               break;
            }
        
            case PROP_ID_tollgateusage:{
               java.lang.Byte typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toByte(value,
                       err-> newTypeConversionError(PROP_NAME_tollgateusage));
               }
               setTollgateusage(typedValue);
               break;
            }
        
            case PROP_ID_lanenum:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_lanenum));
               }
               setLanenum(typedValue);
               break;
            }
        
            case PROP_ID_orgcode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_orgcode));
               }
               setOrgcode(typedValue);
               break;
            }
        
            case PROP_ID_activetime:{
               java.time.LocalDateTime typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLocalDateTime(value,
                       err-> newTypeConversionError(PROP_NAME_activetime));
               }
               setActivetime(typedValue);
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
        
            case PROP_ID_tollgateid:{
               onInitProp(propId);
               this._tollgateid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_name:{
               onInitProp(propId);
               this._name = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_longitude:{
               onInitProp(propId);
               this._longitude = (java.math.BigDecimal)value;
               
               break;
            }
        
            case PROP_ID_latitude:{
               onInitProp(propId);
               this._latitude = (java.math.BigDecimal)value;
               
               break;
            }
        
            case PROP_ID_placecode:{
               onInitProp(propId);
               this._placecode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_place:{
               onInitProp(propId);
               this._place = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_status:{
               onInitProp(propId);
               this._status = (java.lang.Byte)value;
               
               break;
            }
        
            case PROP_ID_tollgatecat:{
               onInitProp(propId);
               this._tollgatecat = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_tollgateusage:{
               onInitProp(propId);
               this._tollgateusage = (java.lang.Byte)value;
               
               break;
            }
        
            case PROP_ID_lanenum:{
               onInitProp(propId);
               this._lanenum = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_orgcode:{
               onInitProp(propId);
               this._orgcode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_activetime:{
               onInitProp(propId);
               this._activetime = (java.time.LocalDateTime)value;
               
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
     * 卡口ID，全局唯一标识，对应DeviceIDType类型，必选字段: TOLLGATEID
     */
    public final java.lang.String getTollgateid(){
         onPropGet(PROP_ID_tollgateid);
         return _tollgateid;
    }

    /**
     * 卡口ID，全局唯一标识，对应DeviceIDType类型，必选字段: TOLLGATEID
     */
    public final void setTollgateid(java.lang.String value){
        if(onPropSet(PROP_ID_tollgateid,value)){
            this._tollgateid = value;
            internalClearRefs(PROP_ID_tollgateid);
            
        }
    }
    
    /**
     * 卡口名称，对应DeviceNameType类型，必选字段: NAME
     */
    public final java.lang.String getName(){
         onPropGet(PROP_ID_name);
         return _name;
    }

    /**
     * 卡口名称，对应DeviceNameType类型，必选字段: NAME
     */
    public final void setName(java.lang.String value){
        if(onPropSet(PROP_ID_name,value)){
            this._name = value;
            internalClearRefs(PROP_ID_name);
            
        }
    }
    
    /**
     * 卡口经度，对应LongitudeType类型，必选字段: LONGITUDE
     */
    public final java.math.BigDecimal getLongitude(){
         onPropGet(PROP_ID_longitude);
         return _longitude;
    }

    /**
     * 卡口经度，对应LongitudeType类型，必选字段: LONGITUDE
     */
    public final void setLongitude(java.math.BigDecimal value){
        if(onPropSet(PROP_ID_longitude,value)){
            this._longitude = value;
            internalClearRefs(PROP_ID_longitude);
            
        }
    }
    
    /**
     * 卡口纬度，对应LatitudeType类型，必选字段: LATITUDE
     */
    public final java.math.BigDecimal getLatitude(){
         onPropGet(PROP_ID_latitude);
         return _latitude;
    }

    /**
     * 卡口纬度，对应LatitudeType类型，必选字段: LATITUDE
     */
    public final void setLatitude(java.math.BigDecimal value){
        if(onPropSet(PROP_ID_latitude,value)){
            this._latitude = value;
            internalClearRefs(PROP_ID_latitude);
            
        }
    }
    
    /**
     * 安装地点行政区划代码，对应PlaceCodeType类型，必选字段: PLACECODE
     */
    public final java.lang.String getPlacecode(){
         onPropGet(PROP_ID_placecode);
         return _placecode;
    }

    /**
     * 安装地点行政区划代码，对应PlaceCodeType类型，必选字段: PLACECODE
     */
    public final void setPlacecode(java.lang.String value){
        if(onPropSet(PROP_ID_placecode,value)){
            this._placecode = value;
            internalClearRefs(PROP_ID_placecode);
            
        }
    }
    
    /**
     * 位置名，具体到位置或街道门牌号，由(乡镇街道)+(街路巷)+(门牌号)+(门楼详细地址)构成，可选字段: PLACE
     */
    public final java.lang.String getPlace(){
         onPropGet(PROP_ID_place);
         return _place;
    }

    /**
     * 位置名，具体到位置或街道门牌号，由(乡镇街道)+(街路巷)+(门牌号)+(门楼详细地址)构成，可选字段: PLACE
     */
    public final void setPlace(java.lang.String value){
        if(onPropSet(PROP_ID_place,value)){
            this._place = value;
            internalClearRefs(PROP_ID_place);
            
        }
    }
    
    /**
     * 卡口状态，1-正常，2-停用，9-其他，对应StatusType类型，必选字段: STATUS
     */
    public final java.lang.Byte getStatus(){
         onPropGet(PROP_ID_status);
         return _status;
    }

    /**
     * 卡口状态，1-正常，2-停用，9-其他，对应StatusType类型，必选字段: STATUS
     */
    public final void setStatus(java.lang.Byte value){
        if(onPropSet(PROP_ID_status,value)){
            this._status = value;
            internalClearRefs(PROP_ID_status);
            
        }
    }
    
    /**
     * 卡口类型，对应TollgateType类型，必选字段: TOLLGATECAT
     */
    public final java.lang.String getTollgatecat(){
         onPropGet(PROP_ID_tollgatecat);
         return _tollgatecat;
    }

    /**
     * 卡口类型，对应TollgateType类型，必选字段: TOLLGATECAT
     */
    public final void setTollgatecat(java.lang.String value){
        if(onPropSet(PROP_ID_tollgatecat,value)){
            this._tollgatecat = value;
            internalClearRefs(PROP_ID_tollgatecat);
            
        }
    }
    
    /**
     * 卡口用途，80-治安卡口，81-交通卡口，82-其他，必选字段: TOLLGATEUSAGE
     */
    public final java.lang.Byte getTollgateusage(){
         onPropGet(PROP_ID_tollgateusage);
         return _tollgateusage;
    }

    /**
     * 卡口用途，80-治安卡口，81-交通卡口，82-其他，必选字段: TOLLGATEUSAGE
     */
    public final void setTollgateusage(java.lang.Byte value){
        if(onPropSet(PROP_ID_tollgateusage,value)){
            this._tollgateusage = value;
            internalClearRefs(PROP_ID_tollgateusage);
            
        }
    }
    
    /**
     * 卡口车道数，整数类型，可选字段: LANENUM
     */
    public final java.lang.Integer getLanenum(){
         onPropGet(PROP_ID_lanenum);
         return _lanenum;
    }

    /**
     * 卡口车道数，整数类型，可选字段: LANENUM
     */
    public final void setLanenum(java.lang.Integer value){
        if(onPropSet(PROP_ID_lanenum,value)){
            this._lanenum = value;
            internalClearRefs(PROP_ID_lanenum);
            
        }
    }
    
    /**
     * 管辖单位代码，对应OrgCodeType类型，可选字段: ORGCODE
     */
    public final java.lang.String getOrgcode(){
         onPropGet(PROP_ID_orgcode);
         return _orgcode;
    }

    /**
     * 管辖单位代码，对应OrgCodeType类型，可选字段: ORGCODE
     */
    public final void setOrgcode(java.lang.String value){
        if(onPropSet(PROP_ID_orgcode,value)){
            this._orgcode = value;
            internalClearRefs(PROP_ID_orgcode);
            
        }
    }
    
    /**
     * 卡口启用时间，启用时间之后的数据有效，可选字段: ACTIVETIME
     */
    public final java.time.LocalDateTime getActivetime(){
         onPropGet(PROP_ID_activetime);
         return _activetime;
    }

    /**
     * 卡口启用时间，启用时间之后的数据有效，可选字段: ACTIVETIME
     */
    public final void setActivetime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_activetime,value)){
            this._activetime = value;
            internalClearRefs(PROP_ID_activetime);
            
        }
    }
    
}
// resume CPD analysis - CPD-ON

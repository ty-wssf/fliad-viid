package com.fliad.viid.dao.entity._gen;

import io.nop.orm.model.IEntityModel;
import io.nop.orm.support.DynamicOrmEntity;
import io.nop.orm.support.OrmEntitySet; //NOPMD - suppressed UnusedImports - Auto Gen Code
import io.nop.orm.IOrmEntitySet; //NOPMD - suppressed UnusedImports - Auto Gen Code
import io.nop.api.core.convert.ConvertHelper;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

import com.fliad.viid.dao.entity.ViidSubscribeNotifications;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  订阅通知表: viid_subscribe_notifications
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _ViidSubscribeNotifications extends DynamicOrmEntity{
    
    /* 主键: ID VARCHAR */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 通知标识: NOTIFICATIONID VARCHAR */
    public static final String PROP_NAME_notificationid = "notificationid";
    public static final int PROP_ID_notificationid = 2;
    
    /* 订阅标识: SUBSCRIBEID VARCHAR */
    public static final String PROP_NAME_subscribeid = "subscribeid";
    public static final int PROP_ID_subscribeid = 3;
    
    /* 订阅标题: TITLE VARCHAR */
    public static final String PROP_NAME_title = "title";
    public static final int PROP_ID_title = 4;
    
    /* 触发时间: TRIGGERTIME DATETIME */
    public static final String PROP_NAME_triggertime = "triggertime";
    public static final int PROP_ID_triggertime = 5;
    
    /* 信息标识: INFOIDS VARCHAR */
    public static final String PROP_NAME_infoids = "infoids";
    public static final int PROP_ID_infoids = 6;
    
    /* 请求字段数据（根据InfoIDs存储DeviceStatusList或者VehiclesFlowListObject等真实字段的数据）: REQUESTDATA CLOB */
    public static final String PROP_NAME_requestdata = "requestdata";
    public static final int PROP_ID_requestdata = 7;
    
    /* 响应字段数据（存储处理当前数据接口处理结果）: RESPONSEDATA CLOB */
    public static final String PROP_NAME_responsedata = "responsedata";
    public static final int PROP_ID_responsedata = 8;
    
    /* 请求耗时（毫秒）: REQUESTCOST INTEGER */
    public static final String PROP_NAME_requestcost = "requestcost";
    public static final int PROP_ID_requestcost = 9;
    
    /* 创建时间: CREATETIME DATETIME */
    public static final String PROP_NAME_createtime = "createtime";
    public static final int PROP_ID_createtime = 10;
    
    /* 更新时间: UPDATETIME DATETIME */
    public static final String PROP_NAME_updatetime = "updatetime";
    public static final int PROP_ID_updatetime = 11;
    

    private static int _PROP_ID_BOUND = 12;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[12];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_notificationid] = PROP_NAME_notificationid;
          PROP_NAME_TO_ID.put(PROP_NAME_notificationid, PROP_ID_notificationid);
      
          PROP_ID_TO_NAME[PROP_ID_subscribeid] = PROP_NAME_subscribeid;
          PROP_NAME_TO_ID.put(PROP_NAME_subscribeid, PROP_ID_subscribeid);
      
          PROP_ID_TO_NAME[PROP_ID_title] = PROP_NAME_title;
          PROP_NAME_TO_ID.put(PROP_NAME_title, PROP_ID_title);
      
          PROP_ID_TO_NAME[PROP_ID_triggertime] = PROP_NAME_triggertime;
          PROP_NAME_TO_ID.put(PROP_NAME_triggertime, PROP_ID_triggertime);
      
          PROP_ID_TO_NAME[PROP_ID_infoids] = PROP_NAME_infoids;
          PROP_NAME_TO_ID.put(PROP_NAME_infoids, PROP_ID_infoids);
      
          PROP_ID_TO_NAME[PROP_ID_requestdata] = PROP_NAME_requestdata;
          PROP_NAME_TO_ID.put(PROP_NAME_requestdata, PROP_ID_requestdata);
      
          PROP_ID_TO_NAME[PROP_ID_responsedata] = PROP_NAME_responsedata;
          PROP_NAME_TO_ID.put(PROP_NAME_responsedata, PROP_ID_responsedata);
      
          PROP_ID_TO_NAME[PROP_ID_requestcost] = PROP_NAME_requestcost;
          PROP_NAME_TO_ID.put(PROP_NAME_requestcost, PROP_ID_requestcost);
      
          PROP_ID_TO_NAME[PROP_ID_createtime] = PROP_NAME_createtime;
          PROP_NAME_TO_ID.put(PROP_NAME_createtime, PROP_ID_createtime);
      
          PROP_ID_TO_NAME[PROP_ID_updatetime] = PROP_NAME_updatetime;
          PROP_NAME_TO_ID.put(PROP_NAME_updatetime, PROP_ID_updatetime);
      
    }

    
    /* 主键: ID */
    private java.lang.String _id_;
    
    /* 通知标识: NOTIFICATIONID */
    private java.lang.String _notificationid;
    
    /* 订阅标识: SUBSCRIBEID */
    private java.lang.String _subscribeid;
    
    /* 订阅标题: TITLE */
    private java.lang.String _title;
    
    /* 触发时间: TRIGGERTIME */
    private java.time.LocalDateTime _triggertime;
    
    /* 信息标识: INFOIDS */
    private java.lang.String _infoids;
    
    /* 请求字段数据（根据InfoIDs存储DeviceStatusList或者VehiclesFlowListObject等真实字段的数据）: REQUESTDATA */
    private java.lang.String _requestdata;
    
    /* 响应字段数据（存储处理当前数据接口处理结果）: RESPONSEDATA */
    private java.lang.String _responsedata;
    
    /* 请求耗时（毫秒）: REQUESTCOST */
    private java.lang.Integer _requestcost;
    
    /* 创建时间: CREATETIME */
    private java.time.LocalDateTime _createtime;
    
    /* 更新时间: UPDATETIME */
    private java.time.LocalDateTime _updatetime;
    

    public _ViidSubscribeNotifications(){
        // for debug
    }

    protected ViidSubscribeNotifications newInstance(){
        ViidSubscribeNotifications entity = new ViidSubscribeNotifications();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public ViidSubscribeNotifications cloneInstance() {
        ViidSubscribeNotifications entity = newInstance();
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
      return "com.fliad.viid.dao.entity.ViidSubscribeNotifications";
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
        
            case PROP_ID_notificationid:
               return getNotificationid();
        
            case PROP_ID_subscribeid:
               return getSubscribeid();
        
            case PROP_ID_title:
               return getTitle();
        
            case PROP_ID_triggertime:
               return getTriggertime();
        
            case PROP_ID_infoids:
               return getInfoids();
        
            case PROP_ID_requestdata:
               return getRequestdata();
        
            case PROP_ID_responsedata:
               return getResponsedata();
        
            case PROP_ID_requestcost:
               return getRequestcost();
        
            case PROP_ID_createtime:
               return getCreatetime();
        
            case PROP_ID_updatetime:
               return getUpdatetime();
        
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
        
            case PROP_ID_notificationid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_notificationid));
               }
               setNotificationid(typedValue);
               break;
            }
        
            case PROP_ID_subscribeid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_subscribeid));
               }
               setSubscribeid(typedValue);
               break;
            }
        
            case PROP_ID_title:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_title));
               }
               setTitle(typedValue);
               break;
            }
        
            case PROP_ID_triggertime:{
               java.time.LocalDateTime typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLocalDateTime(value,
                       err-> newTypeConversionError(PROP_NAME_triggertime));
               }
               setTriggertime(typedValue);
               break;
            }
        
            case PROP_ID_infoids:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_infoids));
               }
               setInfoids(typedValue);
               break;
            }
        
            case PROP_ID_requestdata:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_requestdata));
               }
               setRequestdata(typedValue);
               break;
            }
        
            case PROP_ID_responsedata:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_responsedata));
               }
               setResponsedata(typedValue);
               break;
            }
        
            case PROP_ID_requestcost:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_requestcost));
               }
               setRequestcost(typedValue);
               break;
            }
        
            case PROP_ID_createtime:{
               java.time.LocalDateTime typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLocalDateTime(value,
                       err-> newTypeConversionError(PROP_NAME_createtime));
               }
               setCreatetime(typedValue);
               break;
            }
        
            case PROP_ID_updatetime:{
               java.time.LocalDateTime typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLocalDateTime(value,
                       err-> newTypeConversionError(PROP_NAME_updatetime));
               }
               setUpdatetime(typedValue);
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
        
            case PROP_ID_notificationid:{
               onInitProp(propId);
               this._notificationid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_subscribeid:{
               onInitProp(propId);
               this._subscribeid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_title:{
               onInitProp(propId);
               this._title = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_triggertime:{
               onInitProp(propId);
               this._triggertime = (java.time.LocalDateTime)value;
               
               break;
            }
        
            case PROP_ID_infoids:{
               onInitProp(propId);
               this._infoids = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_requestdata:{
               onInitProp(propId);
               this._requestdata = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_responsedata:{
               onInitProp(propId);
               this._responsedata = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_requestcost:{
               onInitProp(propId);
               this._requestcost = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_createtime:{
               onInitProp(propId);
               this._createtime = (java.time.LocalDateTime)value;
               
               break;
            }
        
            case PROP_ID_updatetime:{
               onInitProp(propId);
               this._updatetime = (java.time.LocalDateTime)value;
               
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
     * 通知标识: NOTIFICATIONID
     */
    public final java.lang.String getNotificationid(){
         onPropGet(PROP_ID_notificationid);
         return _notificationid;
    }

    /**
     * 通知标识: NOTIFICATIONID
     */
    public final void setNotificationid(java.lang.String value){
        if(onPropSet(PROP_ID_notificationid,value)){
            this._notificationid = value;
            internalClearRefs(PROP_ID_notificationid);
            
        }
    }
    
    /**
     * 订阅标识: SUBSCRIBEID
     */
    public final java.lang.String getSubscribeid(){
         onPropGet(PROP_ID_subscribeid);
         return _subscribeid;
    }

    /**
     * 订阅标识: SUBSCRIBEID
     */
    public final void setSubscribeid(java.lang.String value){
        if(onPropSet(PROP_ID_subscribeid,value)){
            this._subscribeid = value;
            internalClearRefs(PROP_ID_subscribeid);
            
        }
    }
    
    /**
     * 订阅标题: TITLE
     */
    public final java.lang.String getTitle(){
         onPropGet(PROP_ID_title);
         return _title;
    }

    /**
     * 订阅标题: TITLE
     */
    public final void setTitle(java.lang.String value){
        if(onPropSet(PROP_ID_title,value)){
            this._title = value;
            internalClearRefs(PROP_ID_title);
            
        }
    }
    
    /**
     * 触发时间: TRIGGERTIME
     */
    public final java.time.LocalDateTime getTriggertime(){
         onPropGet(PROP_ID_triggertime);
         return _triggertime;
    }

    /**
     * 触发时间: TRIGGERTIME
     */
    public final void setTriggertime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_triggertime,value)){
            this._triggertime = value;
            internalClearRefs(PROP_ID_triggertime);
            
        }
    }
    
    /**
     * 信息标识: INFOIDS
     */
    public final java.lang.String getInfoids(){
         onPropGet(PROP_ID_infoids);
         return _infoids;
    }

    /**
     * 信息标识: INFOIDS
     */
    public final void setInfoids(java.lang.String value){
        if(onPropSet(PROP_ID_infoids,value)){
            this._infoids = value;
            internalClearRefs(PROP_ID_infoids);
            
        }
    }
    
    /**
     * 请求字段数据（根据InfoIDs存储DeviceStatusList或者VehiclesFlowListObject等真实字段的数据）: REQUESTDATA
     */
    public final java.lang.String getRequestdata(){
         onPropGet(PROP_ID_requestdata);
         return _requestdata;
    }

    /**
     * 请求字段数据（根据InfoIDs存储DeviceStatusList或者VehiclesFlowListObject等真实字段的数据）: REQUESTDATA
     */
    public final void setRequestdata(java.lang.String value){
        if(onPropSet(PROP_ID_requestdata,value)){
            this._requestdata = value;
            internalClearRefs(PROP_ID_requestdata);
            
        }
    }
    
    /**
     * 响应字段数据（存储处理当前数据接口处理结果）: RESPONSEDATA
     */
    public final java.lang.String getResponsedata(){
         onPropGet(PROP_ID_responsedata);
         return _responsedata;
    }

    /**
     * 响应字段数据（存储处理当前数据接口处理结果）: RESPONSEDATA
     */
    public final void setResponsedata(java.lang.String value){
        if(onPropSet(PROP_ID_responsedata,value)){
            this._responsedata = value;
            internalClearRefs(PROP_ID_responsedata);
            
        }
    }
    
    /**
     * 请求耗时（毫秒）: REQUESTCOST
     */
    public final java.lang.Integer getRequestcost(){
         onPropGet(PROP_ID_requestcost);
         return _requestcost;
    }

    /**
     * 请求耗时（毫秒）: REQUESTCOST
     */
    public final void setRequestcost(java.lang.Integer value){
        if(onPropSet(PROP_ID_requestcost,value)){
            this._requestcost = value;
            internalClearRefs(PROP_ID_requestcost);
            
        }
    }
    
    /**
     * 创建时间: CREATETIME
     */
    public final java.time.LocalDateTime getCreatetime(){
         onPropGet(PROP_ID_createtime);
         return _createtime;
    }

    /**
     * 创建时间: CREATETIME
     */
    public final void setCreatetime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_createtime,value)){
            this._createtime = value;
            internalClearRefs(PROP_ID_createtime);
            
        }
    }
    
    /**
     * 更新时间: UPDATETIME
     */
    public final java.time.LocalDateTime getUpdatetime(){
         onPropGet(PROP_ID_updatetime);
         return _updatetime;
    }

    /**
     * 更新时间: UPDATETIME
     */
    public final void setUpdatetime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_updatetime,value)){
            this._updatetime = value;
            internalClearRefs(PROP_ID_updatetime);
            
        }
    }
    
}
// resume CPD analysis - CPD-ON

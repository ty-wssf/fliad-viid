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

import com.fliad.viid.dao.entity.ViidCascadePlatform;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  级联信息表: viid_cascade_platform
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _ViidCascadePlatform extends DynamicOrmEntity{
    
    /* 主键: ID VARCHAR */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 平台ID: SYSTEM_ID VARCHAR */
    public static final String PROP_NAME_systemId = "systemId";
    public static final int PROP_ID_systemId = 2;
    
    /* 平台名称: NAME VARCHAR */
    public static final String PROP_NAME_name = "name";
    public static final int PROP_ID_name = 3;
    
    /* IP地址: IP_ADDR VARCHAR */
    public static final String PROP_NAME_ipAddr = "ipAddr";
    public static final int PROP_ID_ipAddr = 4;
    
    /* 端口: PORT VARCHAR */
    public static final String PROP_NAME_port = "port";
    public static final int PROP_ID_port = 5;
    
    /* 是否注册: IS_REGISTER VARCHAR */
    public static final String PROP_NAME_isRegister = "isRegister";
    public static final int PROP_ID_isRegister = 6;
    
    /* 是否在线: IS_ONLINE VARCHAR */
    public static final String PROP_NAME_isOnline = "isOnline";
    public static final int PROP_ID_isOnline = 7;
    
    /* 最后在线时间: LAST_ONLINE_TIME DATETIME */
    public static final String PROP_NAME_lastOnlineTime = "lastOnlineTime";
    public static final int PROP_ID_lastOnlineTime = 8;
    
    /* 级联平台类型（0上级 1下级）: TYPE VARCHAR */
    public static final String PROP_NAME_type = "type";
    public static final int PROP_ID_type = 9;
    
    /* 用户ID: USER_ID VARCHAR */
    public static final String PROP_NAME_userId = "userId";
    public static final int PROP_ID_userId = 10;
    
    /* 密码: PASSWORD VARCHAR */
    public static final String PROP_NAME_password = "password";
    public static final int PROP_ID_password = 11;
    
    /* 心跳间隔: HEARTBEAT_INTERVAL INTEGER */
    public static final String PROP_NAME_heartbeatInterval = "heartbeatInterval";
    public static final int PROP_ID_heartbeatInterval = 12;
    
    /* 心跳间隔: KEEPALIVE_TIMEOUT_COUNT INTEGER */
    public static final String PROP_NAME_keepaliveTimeoutCount = "keepaliveTimeoutCount";
    public static final int PROP_ID_keepaliveTimeoutCount = 13;
    

    private static int _PROP_ID_BOUND = 14;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[14];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_systemId] = PROP_NAME_systemId;
          PROP_NAME_TO_ID.put(PROP_NAME_systemId, PROP_ID_systemId);
      
          PROP_ID_TO_NAME[PROP_ID_name] = PROP_NAME_name;
          PROP_NAME_TO_ID.put(PROP_NAME_name, PROP_ID_name);
      
          PROP_ID_TO_NAME[PROP_ID_ipAddr] = PROP_NAME_ipAddr;
          PROP_NAME_TO_ID.put(PROP_NAME_ipAddr, PROP_ID_ipAddr);
      
          PROP_ID_TO_NAME[PROP_ID_port] = PROP_NAME_port;
          PROP_NAME_TO_ID.put(PROP_NAME_port, PROP_ID_port);
      
          PROP_ID_TO_NAME[PROP_ID_isRegister] = PROP_NAME_isRegister;
          PROP_NAME_TO_ID.put(PROP_NAME_isRegister, PROP_ID_isRegister);
      
          PROP_ID_TO_NAME[PROP_ID_isOnline] = PROP_NAME_isOnline;
          PROP_NAME_TO_ID.put(PROP_NAME_isOnline, PROP_ID_isOnline);
      
          PROP_ID_TO_NAME[PROP_ID_lastOnlineTime] = PROP_NAME_lastOnlineTime;
          PROP_NAME_TO_ID.put(PROP_NAME_lastOnlineTime, PROP_ID_lastOnlineTime);
      
          PROP_ID_TO_NAME[PROP_ID_type] = PROP_NAME_type;
          PROP_NAME_TO_ID.put(PROP_NAME_type, PROP_ID_type);
      
          PROP_ID_TO_NAME[PROP_ID_userId] = PROP_NAME_userId;
          PROP_NAME_TO_ID.put(PROP_NAME_userId, PROP_ID_userId);
      
          PROP_ID_TO_NAME[PROP_ID_password] = PROP_NAME_password;
          PROP_NAME_TO_ID.put(PROP_NAME_password, PROP_ID_password);
      
          PROP_ID_TO_NAME[PROP_ID_heartbeatInterval] = PROP_NAME_heartbeatInterval;
          PROP_NAME_TO_ID.put(PROP_NAME_heartbeatInterval, PROP_ID_heartbeatInterval);
      
          PROP_ID_TO_NAME[PROP_ID_keepaliveTimeoutCount] = PROP_NAME_keepaliveTimeoutCount;
          PROP_NAME_TO_ID.put(PROP_NAME_keepaliveTimeoutCount, PROP_ID_keepaliveTimeoutCount);
      
    }

    
    /* 主键: ID */
    private java.lang.String _id_;
    
    /* 平台ID: SYSTEM_ID */
    private java.lang.String _systemId;
    
    /* 平台名称: NAME */
    private java.lang.String _name;
    
    /* IP地址: IP_ADDR */
    private java.lang.String _ipAddr;
    
    /* 端口: PORT */
    private java.lang.String _port;
    
    /* 是否注册: IS_REGISTER */
    private java.lang.String _isRegister;
    
    /* 是否在线: IS_ONLINE */
    private java.lang.String _isOnline;
    
    /* 最后在线时间: LAST_ONLINE_TIME */
    private java.time.LocalDateTime _lastOnlineTime;
    
    /* 级联平台类型（0上级 1下级）: TYPE */
    private java.lang.String _type;
    
    /* 用户ID: USER_ID */
    private java.lang.String _userId;
    
    /* 密码: PASSWORD */
    private java.lang.String _password;
    
    /* 心跳间隔: HEARTBEAT_INTERVAL */
    private java.lang.Integer _heartbeatInterval;
    
    /* 心跳间隔: KEEPALIVE_TIMEOUT_COUNT */
    private java.lang.Integer _keepaliveTimeoutCount;
    

    public _ViidCascadePlatform(){
        // for debug
    }

    protected ViidCascadePlatform newInstance(){
        ViidCascadePlatform entity = new ViidCascadePlatform();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public ViidCascadePlatform cloneInstance() {
        ViidCascadePlatform entity = newInstance();
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
      return "com.fliad.viid.dao.entity.ViidCascadePlatform";
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
        
            case PROP_ID_systemId:
               return getSystemId();
        
            case PROP_ID_name:
               return getName();
        
            case PROP_ID_ipAddr:
               return getIpAddr();
        
            case PROP_ID_port:
               return getPort();
        
            case PROP_ID_isRegister:
               return getIsRegister();
        
            case PROP_ID_isOnline:
               return getIsOnline();
        
            case PROP_ID_lastOnlineTime:
               return getLastOnlineTime();
        
            case PROP_ID_type:
               return getType();
        
            case PROP_ID_userId:
               return getUserId();
        
            case PROP_ID_password:
               return getPassword();
        
            case PROP_ID_heartbeatInterval:
               return getHeartbeatInterval();
        
            case PROP_ID_keepaliveTimeoutCount:
               return getKeepaliveTimeoutCount();
        
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
        
            case PROP_ID_systemId:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_systemId));
               }
               setSystemId(typedValue);
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
        
            case PROP_ID_ipAddr:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_ipAddr));
               }
               setIpAddr(typedValue);
               break;
            }
        
            case PROP_ID_port:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_port));
               }
               setPort(typedValue);
               break;
            }
        
            case PROP_ID_isRegister:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_isRegister));
               }
               setIsRegister(typedValue);
               break;
            }
        
            case PROP_ID_isOnline:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_isOnline));
               }
               setIsOnline(typedValue);
               break;
            }
        
            case PROP_ID_lastOnlineTime:{
               java.time.LocalDateTime typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLocalDateTime(value,
                       err-> newTypeConversionError(PROP_NAME_lastOnlineTime));
               }
               setLastOnlineTime(typedValue);
               break;
            }
        
            case PROP_ID_type:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_type));
               }
               setType(typedValue);
               break;
            }
        
            case PROP_ID_userId:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_userId));
               }
               setUserId(typedValue);
               break;
            }
        
            case PROP_ID_password:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_password));
               }
               setPassword(typedValue);
               break;
            }
        
            case PROP_ID_heartbeatInterval:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_heartbeatInterval));
               }
               setHeartbeatInterval(typedValue);
               break;
            }
        
            case PROP_ID_keepaliveTimeoutCount:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_keepaliveTimeoutCount));
               }
               setKeepaliveTimeoutCount(typedValue);
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
        
            case PROP_ID_systemId:{
               onInitProp(propId);
               this._systemId = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_name:{
               onInitProp(propId);
               this._name = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_ipAddr:{
               onInitProp(propId);
               this._ipAddr = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_port:{
               onInitProp(propId);
               this._port = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_isRegister:{
               onInitProp(propId);
               this._isRegister = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_isOnline:{
               onInitProp(propId);
               this._isOnline = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_lastOnlineTime:{
               onInitProp(propId);
               this._lastOnlineTime = (java.time.LocalDateTime)value;
               
               break;
            }
        
            case PROP_ID_type:{
               onInitProp(propId);
               this._type = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_userId:{
               onInitProp(propId);
               this._userId = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_password:{
               onInitProp(propId);
               this._password = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_heartbeatInterval:{
               onInitProp(propId);
               this._heartbeatInterval = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_keepaliveTimeoutCount:{
               onInitProp(propId);
               this._keepaliveTimeoutCount = (java.lang.Integer)value;
               
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
     * 平台ID: SYSTEM_ID
     */
    public final java.lang.String getSystemId(){
         onPropGet(PROP_ID_systemId);
         return _systemId;
    }

    /**
     * 平台ID: SYSTEM_ID
     */
    public final void setSystemId(java.lang.String value){
        if(onPropSet(PROP_ID_systemId,value)){
            this._systemId = value;
            internalClearRefs(PROP_ID_systemId);
            
        }
    }
    
    /**
     * 平台名称: NAME
     */
    public final java.lang.String getName(){
         onPropGet(PROP_ID_name);
         return _name;
    }

    /**
     * 平台名称: NAME
     */
    public final void setName(java.lang.String value){
        if(onPropSet(PROP_ID_name,value)){
            this._name = value;
            internalClearRefs(PROP_ID_name);
            
        }
    }
    
    /**
     * IP地址: IP_ADDR
     */
    public final java.lang.String getIpAddr(){
         onPropGet(PROP_ID_ipAddr);
         return _ipAddr;
    }

    /**
     * IP地址: IP_ADDR
     */
    public final void setIpAddr(java.lang.String value){
        if(onPropSet(PROP_ID_ipAddr,value)){
            this._ipAddr = value;
            internalClearRefs(PROP_ID_ipAddr);
            
        }
    }
    
    /**
     * 端口: PORT
     */
    public final java.lang.String getPort(){
         onPropGet(PROP_ID_port);
         return _port;
    }

    /**
     * 端口: PORT
     */
    public final void setPort(java.lang.String value){
        if(onPropSet(PROP_ID_port,value)){
            this._port = value;
            internalClearRefs(PROP_ID_port);
            
        }
    }
    
    /**
     * 是否注册: IS_REGISTER
     */
    public final java.lang.String getIsRegister(){
         onPropGet(PROP_ID_isRegister);
         return _isRegister;
    }

    /**
     * 是否注册: IS_REGISTER
     */
    public final void setIsRegister(java.lang.String value){
        if(onPropSet(PROP_ID_isRegister,value)){
            this._isRegister = value;
            internalClearRefs(PROP_ID_isRegister);
            
        }
    }
    
    /**
     * 是否在线: IS_ONLINE
     */
    public final java.lang.String getIsOnline(){
         onPropGet(PROP_ID_isOnline);
         return _isOnline;
    }

    /**
     * 是否在线: IS_ONLINE
     */
    public final void setIsOnline(java.lang.String value){
        if(onPropSet(PROP_ID_isOnline,value)){
            this._isOnline = value;
            internalClearRefs(PROP_ID_isOnline);
            
        }
    }
    
    /**
     * 最后在线时间: LAST_ONLINE_TIME
     */
    public final java.time.LocalDateTime getLastOnlineTime(){
         onPropGet(PROP_ID_lastOnlineTime);
         return _lastOnlineTime;
    }

    /**
     * 最后在线时间: LAST_ONLINE_TIME
     */
    public final void setLastOnlineTime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_lastOnlineTime,value)){
            this._lastOnlineTime = value;
            internalClearRefs(PROP_ID_lastOnlineTime);
            
        }
    }
    
    /**
     * 级联平台类型（0上级 1下级）: TYPE
     */
    public final java.lang.String getType(){
         onPropGet(PROP_ID_type);
         return _type;
    }

    /**
     * 级联平台类型（0上级 1下级）: TYPE
     */
    public final void setType(java.lang.String value){
        if(onPropSet(PROP_ID_type,value)){
            this._type = value;
            internalClearRefs(PROP_ID_type);
            
        }
    }
    
    /**
     * 用户ID: USER_ID
     */
    public final java.lang.String getUserId(){
         onPropGet(PROP_ID_userId);
         return _userId;
    }

    /**
     * 用户ID: USER_ID
     */
    public final void setUserId(java.lang.String value){
        if(onPropSet(PROP_ID_userId,value)){
            this._userId = value;
            internalClearRefs(PROP_ID_userId);
            
        }
    }
    
    /**
     * 密码: PASSWORD
     */
    public final java.lang.String getPassword(){
         onPropGet(PROP_ID_password);
         return _password;
    }

    /**
     * 密码: PASSWORD
     */
    public final void setPassword(java.lang.String value){
        if(onPropSet(PROP_ID_password,value)){
            this._password = value;
            internalClearRefs(PROP_ID_password);
            
        }
    }
    
    /**
     * 心跳间隔: HEARTBEAT_INTERVAL
     */
    public final java.lang.Integer getHeartbeatInterval(){
         onPropGet(PROP_ID_heartbeatInterval);
         return _heartbeatInterval;
    }

    /**
     * 心跳间隔: HEARTBEAT_INTERVAL
     */
    public final void setHeartbeatInterval(java.lang.Integer value){
        if(onPropSet(PROP_ID_heartbeatInterval,value)){
            this._heartbeatInterval = value;
            internalClearRefs(PROP_ID_heartbeatInterval);
            
        }
    }
    
    /**
     * 心跳间隔: KEEPALIVE_TIMEOUT_COUNT
     */
    public final java.lang.Integer getKeepaliveTimeoutCount(){
         onPropGet(PROP_ID_keepaliveTimeoutCount);
         return _keepaliveTimeoutCount;
    }

    /**
     * 心跳间隔: KEEPALIVE_TIMEOUT_COUNT
     */
    public final void setKeepaliveTimeoutCount(java.lang.Integer value){
        if(onPropSet(PROP_ID_keepaliveTimeoutCount,value)){
            this._keepaliveTimeoutCount = value;
            internalClearRefs(PROP_ID_keepaliveTimeoutCount);
            
        }
    }
    
}
// resume CPD analysis - CPD-ON

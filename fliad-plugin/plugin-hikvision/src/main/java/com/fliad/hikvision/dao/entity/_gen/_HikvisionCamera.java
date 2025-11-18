package com.fliad.hikvision.dao.entity._gen;

import io.nop.orm.model.IEntityModel;
import io.nop.orm.support.DynamicOrmEntity;
import io.nop.orm.support.OrmEntitySet; //NOPMD - suppressed UnusedImports - Auto Gen Code
import io.nop.orm.IOrmEntitySet; //NOPMD - suppressed UnusedImports - Auto Gen Code
import io.nop.api.core.convert.ConvertHelper;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

import com.fliad.hikvision.dao.entity.HikvisionCamera;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  海康布防表: HIKVISION_CAMERA
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _HikvisionCamera extends DynamicOrmEntity{
    
    /* 主键: ID BIGINT */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 设备编号: DEVICE_ID VARCHAR */
    public static final String PROP_NAME_deviceId = "deviceId";
    public static final int PROP_ID_deviceId = 2;
    
    /* 设备名称: NAME VARCHAR */
    public static final String PROP_NAME_name = "name";
    public static final int PROP_ID_name = 3;
    
    /* 设备IP地址: IP_ADDR VARCHAR */
    public static final String PROP_NAME_ipAddr = "ipAddr";
    public static final int PROP_ID_ipAddr = 4;
    
    /* 端口号: PORT INTEGER */
    public static final String PROP_NAME_port = "port";
    public static final int PROP_ID_port = 5;
    
    /* 用户名: USERNAME VARCHAR */
    public static final String PROP_NAME_username = "username";
    public static final int PROP_ID_username = 6;
    
    /* 密码: PASSWORD VARCHAR */
    public static final String PROP_NAME_password = "password";
    public static final int PROP_ID_password = 7;
    
    /* 启用状态：1=启用，0=禁用: ENABLE_STATUS INTEGER */
    public static final String PROP_NAME_enableStatus = "enableStatus";
    public static final int PROP_ID_enableStatus = 8;
    
    /* 在线状态：1=在线，0=离线: ONLINE_STATUS INTEGER */
    public static final String PROP_NAME_onlineStatus = "onlineStatus";
    public static final int PROP_ID_onlineStatus = 9;
    
    /* 创建时间: CREATE_TIME TIMESTAMP */
    public static final String PROP_NAME_createTime = "createTime";
    public static final int PROP_ID_createTime = 10;
    
    /* 更新时间: UPDATE_TIME TIMESTAMP */
    public static final String PROP_NAME_updateTime = "updateTime";
    public static final int PROP_ID_updateTime = 11;
    

    private static int _PROP_ID_BOUND = 12;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[12];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_deviceId] = PROP_NAME_deviceId;
          PROP_NAME_TO_ID.put(PROP_NAME_deviceId, PROP_ID_deviceId);
      
          PROP_ID_TO_NAME[PROP_ID_name] = PROP_NAME_name;
          PROP_NAME_TO_ID.put(PROP_NAME_name, PROP_ID_name);
      
          PROP_ID_TO_NAME[PROP_ID_ipAddr] = PROP_NAME_ipAddr;
          PROP_NAME_TO_ID.put(PROP_NAME_ipAddr, PROP_ID_ipAddr);
      
          PROP_ID_TO_NAME[PROP_ID_port] = PROP_NAME_port;
          PROP_NAME_TO_ID.put(PROP_NAME_port, PROP_ID_port);
      
          PROP_ID_TO_NAME[PROP_ID_username] = PROP_NAME_username;
          PROP_NAME_TO_ID.put(PROP_NAME_username, PROP_ID_username);
      
          PROP_ID_TO_NAME[PROP_ID_password] = PROP_NAME_password;
          PROP_NAME_TO_ID.put(PROP_NAME_password, PROP_ID_password);
      
          PROP_ID_TO_NAME[PROP_ID_enableStatus] = PROP_NAME_enableStatus;
          PROP_NAME_TO_ID.put(PROP_NAME_enableStatus, PROP_ID_enableStatus);
      
          PROP_ID_TO_NAME[PROP_ID_onlineStatus] = PROP_NAME_onlineStatus;
          PROP_NAME_TO_ID.put(PROP_NAME_onlineStatus, PROP_ID_onlineStatus);
      
          PROP_ID_TO_NAME[PROP_ID_createTime] = PROP_NAME_createTime;
          PROP_NAME_TO_ID.put(PROP_NAME_createTime, PROP_ID_createTime);
      
          PROP_ID_TO_NAME[PROP_ID_updateTime] = PROP_NAME_updateTime;
          PROP_NAME_TO_ID.put(PROP_NAME_updateTime, PROP_ID_updateTime);
      
    }

    
    /* 主键: ID */
    private java.lang.Long _id_;
    
    /* 设备编号: DEVICE_ID */
    private java.lang.String _deviceId;
    
    /* 设备名称: NAME */
    private java.lang.String _name;
    
    /* 设备IP地址: IP_ADDR */
    private java.lang.String _ipAddr;
    
    /* 端口号: PORT */
    private java.lang.Integer _port;
    
    /* 用户名: USERNAME */
    private java.lang.String _username;
    
    /* 密码: PASSWORD */
    private java.lang.String _password;
    
    /* 启用状态：1=启用，0=禁用: ENABLE_STATUS */
    private java.lang.Integer _enableStatus;
    
    /* 在线状态：1=在线，0=离线: ONLINE_STATUS */
    private java.lang.Integer _onlineStatus;
    
    /* 创建时间: CREATE_TIME */
    private java.sql.Timestamp _createTime;
    
    /* 更新时间: UPDATE_TIME */
    private java.sql.Timestamp _updateTime;
    

    public _HikvisionCamera(){
        // for debug
    }

    protected HikvisionCamera newInstance(){
        HikvisionCamera entity = new HikvisionCamera();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public HikvisionCamera cloneInstance() {
        HikvisionCamera entity = newInstance();
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
      return "com.fliad.hikvision.dao.entity.HikvisionCamera";
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
        
            case PROP_ID_deviceId:
               return getDeviceId();
        
            case PROP_ID_name:
               return getName();
        
            case PROP_ID_ipAddr:
               return getIpAddr();
        
            case PROP_ID_port:
               return getPort();
        
            case PROP_ID_username:
               return getUsername();
        
            case PROP_ID_password:
               return getPassword();
        
            case PROP_ID_enableStatus:
               return getEnableStatus();
        
            case PROP_ID_onlineStatus:
               return getOnlineStatus();
        
            case PROP_ID_createTime:
               return getCreateTime();
        
            case PROP_ID_updateTime:
               return getUpdateTime();
        
           default:
              return super.orm_propValue(propId);
        }
    }

    

    @Override
    public void orm_propValue(int propId, Object value){
        switch(propId){
        
            case PROP_ID_id_:{
               java.lang.Long typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLong(value,
                       err-> newTypeConversionError(PROP_NAME_id_));
               }
               setId_(typedValue);
               break;
            }
        
            case PROP_ID_deviceId:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_deviceId));
               }
               setDeviceId(typedValue);
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
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_port));
               }
               setPort(typedValue);
               break;
            }
        
            case PROP_ID_username:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_username));
               }
               setUsername(typedValue);
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
        
            case PROP_ID_enableStatus:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_enableStatus));
               }
               setEnableStatus(typedValue);
               break;
            }
        
            case PROP_ID_onlineStatus:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_onlineStatus));
               }
               setOnlineStatus(typedValue);
               break;
            }
        
            case PROP_ID_createTime:{
               java.sql.Timestamp typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toTimestamp(value,
                       err-> newTypeConversionError(PROP_NAME_createTime));
               }
               setCreateTime(typedValue);
               break;
            }
        
            case PROP_ID_updateTime:{
               java.sql.Timestamp typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toTimestamp(value,
                       err-> newTypeConversionError(PROP_NAME_updateTime));
               }
               setUpdateTime(typedValue);
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
               this._id_ = (java.lang.Long)value;
               orm_id(); // 如果是设置主键字段，则触发watcher
               break;
            }
        
            case PROP_ID_deviceId:{
               onInitProp(propId);
               this._deviceId = (java.lang.String)value;
               
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
               this._port = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_username:{
               onInitProp(propId);
               this._username = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_password:{
               onInitProp(propId);
               this._password = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_enableStatus:{
               onInitProp(propId);
               this._enableStatus = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_onlineStatus:{
               onInitProp(propId);
               this._onlineStatus = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_createTime:{
               onInitProp(propId);
               this._createTime = (java.sql.Timestamp)value;
               
               break;
            }
        
            case PROP_ID_updateTime:{
               onInitProp(propId);
               this._updateTime = (java.sql.Timestamp)value;
               
               break;
            }
        
           default:
              super.orm_internalSet(propId,value);
        }
    }

    
    /**
     * 主键: ID
     */
    public final java.lang.Long getId_(){
         onPropGet(PROP_ID_id_);
         return _id_;
    }

    /**
     * 主键: ID
     */
    public final void setId_(java.lang.Long value){
        if(onPropSet(PROP_ID_id_,value)){
            this._id_ = value;
            internalClearRefs(PROP_ID_id_);
            orm_id();
        }
    }
    
    /**
     * 设备编号: DEVICE_ID
     */
    public final java.lang.String getDeviceId(){
         onPropGet(PROP_ID_deviceId);
         return _deviceId;
    }

    /**
     * 设备编号: DEVICE_ID
     */
    public final void setDeviceId(java.lang.String value){
        if(onPropSet(PROP_ID_deviceId,value)){
            this._deviceId = value;
            internalClearRefs(PROP_ID_deviceId);
            
        }
    }
    
    /**
     * 设备名称: NAME
     */
    public final java.lang.String getName(){
         onPropGet(PROP_ID_name);
         return _name;
    }

    /**
     * 设备名称: NAME
     */
    public final void setName(java.lang.String value){
        if(onPropSet(PROP_ID_name,value)){
            this._name = value;
            internalClearRefs(PROP_ID_name);
            
        }
    }
    
    /**
     * 设备IP地址: IP_ADDR
     */
    public final java.lang.String getIpAddr(){
         onPropGet(PROP_ID_ipAddr);
         return _ipAddr;
    }

    /**
     * 设备IP地址: IP_ADDR
     */
    public final void setIpAddr(java.lang.String value){
        if(onPropSet(PROP_ID_ipAddr,value)){
            this._ipAddr = value;
            internalClearRefs(PROP_ID_ipAddr);
            
        }
    }
    
    /**
     * 端口号: PORT
     */
    public final java.lang.Integer getPort(){
         onPropGet(PROP_ID_port);
         return _port;
    }

    /**
     * 端口号: PORT
     */
    public final void setPort(java.lang.Integer value){
        if(onPropSet(PROP_ID_port,value)){
            this._port = value;
            internalClearRefs(PROP_ID_port);
            
        }
    }
    
    /**
     * 用户名: USERNAME
     */
    public final java.lang.String getUsername(){
         onPropGet(PROP_ID_username);
         return _username;
    }

    /**
     * 用户名: USERNAME
     */
    public final void setUsername(java.lang.String value){
        if(onPropSet(PROP_ID_username,value)){
            this._username = value;
            internalClearRefs(PROP_ID_username);
            
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
     * 启用状态：1=启用，0=禁用: ENABLE_STATUS
     */
    public final java.lang.Integer getEnableStatus(){
         onPropGet(PROP_ID_enableStatus);
         return _enableStatus;
    }

    /**
     * 启用状态：1=启用，0=禁用: ENABLE_STATUS
     */
    public final void setEnableStatus(java.lang.Integer value){
        if(onPropSet(PROP_ID_enableStatus,value)){
            this._enableStatus = value;
            internalClearRefs(PROP_ID_enableStatus);
            
        }
    }
    
    /**
     * 在线状态：1=在线，0=离线: ONLINE_STATUS
     */
    public final java.lang.Integer getOnlineStatus(){
         onPropGet(PROP_ID_onlineStatus);
         return _onlineStatus;
    }

    /**
     * 在线状态：1=在线，0=离线: ONLINE_STATUS
     */
    public final void setOnlineStatus(java.lang.Integer value){
        if(onPropSet(PROP_ID_onlineStatus,value)){
            this._onlineStatus = value;
            internalClearRefs(PROP_ID_onlineStatus);
            
        }
    }
    
    /**
     * 创建时间: CREATE_TIME
     */
    public final java.sql.Timestamp getCreateTime(){
         onPropGet(PROP_ID_createTime);
         return _createTime;
    }

    /**
     * 创建时间: CREATE_TIME
     */
    public final void setCreateTime(java.sql.Timestamp value){
        if(onPropSet(PROP_ID_createTime,value)){
            this._createTime = value;
            internalClearRefs(PROP_ID_createTime);
            
        }
    }
    
    /**
     * 更新时间: UPDATE_TIME
     */
    public final java.sql.Timestamp getUpdateTime(){
         onPropGet(PROP_ID_updateTime);
         return _updateTime;
    }

    /**
     * 更新时间: UPDATE_TIME
     */
    public final void setUpdateTime(java.sql.Timestamp value){
        if(onPropSet(PROP_ID_updateTime,value)){
            this._updateTime = value;
            internalClearRefs(PROP_ID_updateTime);
            
        }
    }
    
}
// resume CPD analysis - CPD-ON

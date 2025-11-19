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

import com.fliad.resource.dao.entity.DevConfig;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  配置: dev_config
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _DevConfig extends DynamicOrmEntity{
    
    /* Id: ID VARCHAR */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 配置键: CONFIG_KEY VARCHAR */
    public static final String PROP_NAME_configKey = "configKey";
    public static final int PROP_ID_configKey = 2;
    
    /* 配置值: CONFIG_VALUE CLOB */
    public static final String PROP_NAME_configValue = "configValue";
    public static final int PROP_ID_configValue = 3;
    
    /* 分类: CATEGORY VARCHAR */
    public static final String PROP_NAME_category = "category";
    public static final int PROP_ID_category = 4;
    
    /* 备注: REMARK VARCHAR */
    public static final String PROP_NAME_remark = "remark";
    public static final int PROP_ID_remark = 5;
    
    /* 排序码: SORT_CODE INTEGER */
    public static final String PROP_NAME_sortCode = "sortCode";
    public static final int PROP_ID_sortCode = 6;
    
    /* 扩展信息: EXT_JSON CLOB */
    public static final String PROP_NAME_extJson = "extJson";
    public static final int PROP_ID_extJson = 7;
    
    /* 删除标志: DELETE_FLAG VARCHAR */
    public static final String PROP_NAME_deleteFlag = "deleteFlag";
    public static final int PROP_ID_deleteFlag = 8;
    
    /* 创建时间: CREATE_TIME DATETIME */
    public static final String PROP_NAME_createTime = "createTime";
    public static final int PROP_ID_createTime = 9;
    
    /* 创建用户: CREATE_USER VARCHAR */
    public static final String PROP_NAME_createUser = "createUser";
    public static final int PROP_ID_createUser = 10;
    
    /* 修改时间: UPDATE_TIME DATETIME */
    public static final String PROP_NAME_updateTime = "updateTime";
    public static final int PROP_ID_updateTime = 11;
    
    /* 修改用户: UPDATE_USER VARCHAR */
    public static final String PROP_NAME_updateUser = "updateUser";
    public static final int PROP_ID_updateUser = 12;
    

    private static int _PROP_ID_BOUND = 13;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[13];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_configKey] = PROP_NAME_configKey;
          PROP_NAME_TO_ID.put(PROP_NAME_configKey, PROP_ID_configKey);
      
          PROP_ID_TO_NAME[PROP_ID_configValue] = PROP_NAME_configValue;
          PROP_NAME_TO_ID.put(PROP_NAME_configValue, PROP_ID_configValue);
      
          PROP_ID_TO_NAME[PROP_ID_category] = PROP_NAME_category;
          PROP_NAME_TO_ID.put(PROP_NAME_category, PROP_ID_category);
      
          PROP_ID_TO_NAME[PROP_ID_remark] = PROP_NAME_remark;
          PROP_NAME_TO_ID.put(PROP_NAME_remark, PROP_ID_remark);
      
          PROP_ID_TO_NAME[PROP_ID_sortCode] = PROP_NAME_sortCode;
          PROP_NAME_TO_ID.put(PROP_NAME_sortCode, PROP_ID_sortCode);
      
          PROP_ID_TO_NAME[PROP_ID_extJson] = PROP_NAME_extJson;
          PROP_NAME_TO_ID.put(PROP_NAME_extJson, PROP_ID_extJson);
      
          PROP_ID_TO_NAME[PROP_ID_deleteFlag] = PROP_NAME_deleteFlag;
          PROP_NAME_TO_ID.put(PROP_NAME_deleteFlag, PROP_ID_deleteFlag);
      
          PROP_ID_TO_NAME[PROP_ID_createTime] = PROP_NAME_createTime;
          PROP_NAME_TO_ID.put(PROP_NAME_createTime, PROP_ID_createTime);
      
          PROP_ID_TO_NAME[PROP_ID_createUser] = PROP_NAME_createUser;
          PROP_NAME_TO_ID.put(PROP_NAME_createUser, PROP_ID_createUser);
      
          PROP_ID_TO_NAME[PROP_ID_updateTime] = PROP_NAME_updateTime;
          PROP_NAME_TO_ID.put(PROP_NAME_updateTime, PROP_ID_updateTime);
      
          PROP_ID_TO_NAME[PROP_ID_updateUser] = PROP_NAME_updateUser;
          PROP_NAME_TO_ID.put(PROP_NAME_updateUser, PROP_ID_updateUser);
      
    }

    
    /* Id: ID */
    private java.lang.String _id_;
    
    /* 配置键: CONFIG_KEY */
    private java.lang.String _configKey;
    
    /* 配置值: CONFIG_VALUE */
    private java.lang.String _configValue;
    
    /* 分类: CATEGORY */
    private java.lang.String _category;
    
    /* 备注: REMARK */
    private java.lang.String _remark;
    
    /* 排序码: SORT_CODE */
    private java.lang.Integer _sortCode;
    
    /* 扩展信息: EXT_JSON */
    private java.lang.String _extJson;
    
    /* 删除标志: DELETE_FLAG */
    private java.lang.String _deleteFlag;
    
    /* 创建时间: CREATE_TIME */
    private java.time.LocalDateTime _createTime;
    
    /* 创建用户: CREATE_USER */
    private java.lang.String _createUser;
    
    /* 修改时间: UPDATE_TIME */
    private java.time.LocalDateTime _updateTime;
    
    /* 修改用户: UPDATE_USER */
    private java.lang.String _updateUser;
    

    public _DevConfig(){
        // for debug
    }

    protected DevConfig newInstance(){
        DevConfig entity = new DevConfig();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public DevConfig cloneInstance() {
        DevConfig entity = newInstance();
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
      return "com.fliad.resource.dao.entity.DevConfig";
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
        
            case PROP_ID_configKey:
               return getConfigKey();
        
            case PROP_ID_configValue:
               return getConfigValue();
        
            case PROP_ID_category:
               return getCategory();
        
            case PROP_ID_remark:
               return getRemark();
        
            case PROP_ID_sortCode:
               return getSortCode();
        
            case PROP_ID_extJson:
               return getExtJson();
        
            case PROP_ID_deleteFlag:
               return getDeleteFlag();
        
            case PROP_ID_createTime:
               return getCreateTime();
        
            case PROP_ID_createUser:
               return getCreateUser();
        
            case PROP_ID_updateTime:
               return getUpdateTime();
        
            case PROP_ID_updateUser:
               return getUpdateUser();
        
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
        
            case PROP_ID_configKey:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_configKey));
               }
               setConfigKey(typedValue);
               break;
            }
        
            case PROP_ID_configValue:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_configValue));
               }
               setConfigValue(typedValue);
               break;
            }
        
            case PROP_ID_category:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_category));
               }
               setCategory(typedValue);
               break;
            }
        
            case PROP_ID_remark:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_remark));
               }
               setRemark(typedValue);
               break;
            }
        
            case PROP_ID_sortCode:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_sortCode));
               }
               setSortCode(typedValue);
               break;
            }
        
            case PROP_ID_extJson:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_extJson));
               }
               setExtJson(typedValue);
               break;
            }
        
            case PROP_ID_deleteFlag:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_deleteFlag));
               }
               setDeleteFlag(typedValue);
               break;
            }
        
            case PROP_ID_createTime:{
               java.time.LocalDateTime typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLocalDateTime(value,
                       err-> newTypeConversionError(PROP_NAME_createTime));
               }
               setCreateTime(typedValue);
               break;
            }
        
            case PROP_ID_createUser:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_createUser));
               }
               setCreateUser(typedValue);
               break;
            }
        
            case PROP_ID_updateTime:{
               java.time.LocalDateTime typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLocalDateTime(value,
                       err-> newTypeConversionError(PROP_NAME_updateTime));
               }
               setUpdateTime(typedValue);
               break;
            }
        
            case PROP_ID_updateUser:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_updateUser));
               }
               setUpdateUser(typedValue);
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
        
            case PROP_ID_configKey:{
               onInitProp(propId);
               this._configKey = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_configValue:{
               onInitProp(propId);
               this._configValue = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_category:{
               onInitProp(propId);
               this._category = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_remark:{
               onInitProp(propId);
               this._remark = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_sortCode:{
               onInitProp(propId);
               this._sortCode = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_extJson:{
               onInitProp(propId);
               this._extJson = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_deleteFlag:{
               onInitProp(propId);
               this._deleteFlag = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_createTime:{
               onInitProp(propId);
               this._createTime = (java.time.LocalDateTime)value;
               
               break;
            }
        
            case PROP_ID_createUser:{
               onInitProp(propId);
               this._createUser = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_updateTime:{
               onInitProp(propId);
               this._updateTime = (java.time.LocalDateTime)value;
               
               break;
            }
        
            case PROP_ID_updateUser:{
               onInitProp(propId);
               this._updateUser = (java.lang.String)value;
               
               break;
            }
        
           default:
              super.orm_internalSet(propId,value);
        }
    }

    
    /**
     * Id: ID
     */
    public final java.lang.String getId_(){
         onPropGet(PROP_ID_id_);
         return _id_;
    }

    /**
     * Id: ID
     */
    public final void setId_(java.lang.String value){
        if(onPropSet(PROP_ID_id_,value)){
            this._id_ = value;
            internalClearRefs(PROP_ID_id_);
            orm_id();
        }
    }
    
    /**
     * 配置键: CONFIG_KEY
     */
    public final java.lang.String getConfigKey(){
         onPropGet(PROP_ID_configKey);
         return _configKey;
    }

    /**
     * 配置键: CONFIG_KEY
     */
    public final void setConfigKey(java.lang.String value){
        if(onPropSet(PROP_ID_configKey,value)){
            this._configKey = value;
            internalClearRefs(PROP_ID_configKey);
            
        }
    }
    
    /**
     * 配置值: CONFIG_VALUE
     */
    public final java.lang.String getConfigValue(){
         onPropGet(PROP_ID_configValue);
         return _configValue;
    }

    /**
     * 配置值: CONFIG_VALUE
     */
    public final void setConfigValue(java.lang.String value){
        if(onPropSet(PROP_ID_configValue,value)){
            this._configValue = value;
            internalClearRefs(PROP_ID_configValue);
            
        }
    }
    
    /**
     * 分类: CATEGORY
     */
    public final java.lang.String getCategory(){
         onPropGet(PROP_ID_category);
         return _category;
    }

    /**
     * 分类: CATEGORY
     */
    public final void setCategory(java.lang.String value){
        if(onPropSet(PROP_ID_category,value)){
            this._category = value;
            internalClearRefs(PROP_ID_category);
            
        }
    }
    
    /**
     * 备注: REMARK
     */
    public final java.lang.String getRemark(){
         onPropGet(PROP_ID_remark);
         return _remark;
    }

    /**
     * 备注: REMARK
     */
    public final void setRemark(java.lang.String value){
        if(onPropSet(PROP_ID_remark,value)){
            this._remark = value;
            internalClearRefs(PROP_ID_remark);
            
        }
    }
    
    /**
     * 排序码: SORT_CODE
     */
    public final java.lang.Integer getSortCode(){
         onPropGet(PROP_ID_sortCode);
         return _sortCode;
    }

    /**
     * 排序码: SORT_CODE
     */
    public final void setSortCode(java.lang.Integer value){
        if(onPropSet(PROP_ID_sortCode,value)){
            this._sortCode = value;
            internalClearRefs(PROP_ID_sortCode);
            
        }
    }
    
    /**
     * 扩展信息: EXT_JSON
     */
    public final java.lang.String getExtJson(){
         onPropGet(PROP_ID_extJson);
         return _extJson;
    }

    /**
     * 扩展信息: EXT_JSON
     */
    public final void setExtJson(java.lang.String value){
        if(onPropSet(PROP_ID_extJson,value)){
            this._extJson = value;
            internalClearRefs(PROP_ID_extJson);
            
        }
    }
    
    /**
     * 删除标志: DELETE_FLAG
     */
    public final java.lang.String getDeleteFlag(){
         onPropGet(PROP_ID_deleteFlag);
         return _deleteFlag;
    }

    /**
     * 删除标志: DELETE_FLAG
     */
    public final void setDeleteFlag(java.lang.String value){
        if(onPropSet(PROP_ID_deleteFlag,value)){
            this._deleteFlag = value;
            internalClearRefs(PROP_ID_deleteFlag);
            
        }
    }
    
    /**
     * 创建时间: CREATE_TIME
     */
    public final java.time.LocalDateTime getCreateTime(){
         onPropGet(PROP_ID_createTime);
         return _createTime;
    }

    /**
     * 创建时间: CREATE_TIME
     */
    public final void setCreateTime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_createTime,value)){
            this._createTime = value;
            internalClearRefs(PROP_ID_createTime);
            
        }
    }
    
    /**
     * 创建用户: CREATE_USER
     */
    public final java.lang.String getCreateUser(){
         onPropGet(PROP_ID_createUser);
         return _createUser;
    }

    /**
     * 创建用户: CREATE_USER
     */
    public final void setCreateUser(java.lang.String value){
        if(onPropSet(PROP_ID_createUser,value)){
            this._createUser = value;
            internalClearRefs(PROP_ID_createUser);
            
        }
    }
    
    /**
     * 修改时间: UPDATE_TIME
     */
    public final java.time.LocalDateTime getUpdateTime(){
         onPropGet(PROP_ID_updateTime);
         return _updateTime;
    }

    /**
     * 修改时间: UPDATE_TIME
     */
    public final void setUpdateTime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_updateTime,value)){
            this._updateTime = value;
            internalClearRefs(PROP_ID_updateTime);
            
        }
    }
    
    /**
     * 修改用户: UPDATE_USER
     */
    public final java.lang.String getUpdateUser(){
         onPropGet(PROP_ID_updateUser);
         return _updateUser;
    }

    /**
     * 修改用户: UPDATE_USER
     */
    public final void setUpdateUser(java.lang.String value){
        if(onPropSet(PROP_ID_updateUser,value)){
            this._updateUser = value;
            internalClearRefs(PROP_ID_updateUser);
            
        }
    }
    
}
// resume CPD analysis - CPD-ON

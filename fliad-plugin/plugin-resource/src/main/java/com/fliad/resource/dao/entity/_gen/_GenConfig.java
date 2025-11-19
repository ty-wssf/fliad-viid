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

import com.fliad.resource.dao.entity.GenConfig;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  生成配置: gen_config
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _GenConfig extends DynamicOrmEntity{
    
    /* 主键: ID VARCHAR */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 基础ID: BASIC_ID VARCHAR */
    public static final String PROP_NAME_basicId = "basicId";
    public static final int PROP_ID_basicId = 2;
    
    /* 是否主键: IS_TABLE_KEY VARCHAR */
    public static final String PROP_NAME_isTableKey = "isTableKey";
    public static final int PROP_ID_isTableKey = 3;
    
    /* 字段: FIELD_NAME VARCHAR */
    public static final String PROP_NAME_fieldName = "fieldName";
    public static final int PROP_ID_fieldName = 4;
    
    /* 名称: FIELD_REMARK VARCHAR */
    public static final String PROP_NAME_fieldRemark = "fieldRemark";
    public static final int PROP_ID_fieldRemark = 5;
    
    /* 类型: FIELD_TYPE VARCHAR */
    public static final String PROP_NAME_fieldType = "fieldType";
    public static final int PROP_ID_fieldType = 6;
    
    /* 实体类型: FIELD_JAVA_TYPE VARCHAR */
    public static final String PROP_NAME_fieldJavaType = "fieldJavaType";
    public static final int PROP_ID_fieldJavaType = 7;
    
    /* 作用类型: EFFECT_TYPE VARCHAR */
    public static final String PROP_NAME_effectType = "effectType";
    public static final int PROP_ID_effectType = 8;
    
    /* 字典: DICT_TYPE_CODE VARCHAR */
    public static final String PROP_NAME_dictTypeCode = "dictTypeCode";
    public static final int PROP_ID_dictTypeCode = 9;
    
    /* 列表显示: WHETHER_TABLE VARCHAR */
    public static final String PROP_NAME_whetherTable = "whetherTable";
    public static final int PROP_ID_whetherTable = 10;
    
    /* 列省略: WHETHER_RETRACT VARCHAR */
    public static final String PROP_NAME_whetherRetract = "whetherRetract";
    public static final int PROP_ID_whetherRetract = 11;
    
    /* 是否增改: WHETHER_ADD_UPDATE VARCHAR */
    public static final String PROP_NAME_whetherAddUpdate = "whetherAddUpdate";
    public static final int PROP_ID_whetherAddUpdate = 12;
    
    /* 必填: WHETHER_REQUIRED VARCHAR */
    public static final String PROP_NAME_whetherRequired = "whetherRequired";
    public static final int PROP_ID_whetherRequired = 13;
    
    /* 查询: QUERY_WHETHER VARCHAR */
    public static final String PROP_NAME_queryWhether = "queryWhether";
    public static final int PROP_ID_queryWhether = 14;
    
    /* 查询方式: QUERY_TYPE VARCHAR */
    public static final String PROP_NAME_queryType = "queryType";
    public static final int PROP_ID_queryType = 15;
    
    /* 排序: SORT_CODE INTEGER */
    public static final String PROP_NAME_sortCode = "sortCode";
    public static final int PROP_ID_sortCode = 16;
    
    /* 删除标志: DELETE_FLAG VARCHAR */
    public static final String PROP_NAME_deleteFlag = "deleteFlag";
    public static final int PROP_ID_deleteFlag = 17;
    
    /* 创建时间: CREATE_TIME DATETIME */
    public static final String PROP_NAME_createTime = "createTime";
    public static final int PROP_ID_createTime = 18;
    
    /* 创建用户: CREATE_USER VARCHAR */
    public static final String PROP_NAME_createUser = "createUser";
    public static final int PROP_ID_createUser = 19;
    
    /* 修改时间: UPDATE_TIME DATETIME */
    public static final String PROP_NAME_updateTime = "updateTime";
    public static final int PROP_ID_updateTime = 20;
    
    /* 修改用户: UPDATE_USER VARCHAR */
    public static final String PROP_NAME_updateUser = "updateUser";
    public static final int PROP_ID_updateUser = 21;
    

    private static int _PROP_ID_BOUND = 22;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[22];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_basicId] = PROP_NAME_basicId;
          PROP_NAME_TO_ID.put(PROP_NAME_basicId, PROP_ID_basicId);
      
          PROP_ID_TO_NAME[PROP_ID_isTableKey] = PROP_NAME_isTableKey;
          PROP_NAME_TO_ID.put(PROP_NAME_isTableKey, PROP_ID_isTableKey);
      
          PROP_ID_TO_NAME[PROP_ID_fieldName] = PROP_NAME_fieldName;
          PROP_NAME_TO_ID.put(PROP_NAME_fieldName, PROP_ID_fieldName);
      
          PROP_ID_TO_NAME[PROP_ID_fieldRemark] = PROP_NAME_fieldRemark;
          PROP_NAME_TO_ID.put(PROP_NAME_fieldRemark, PROP_ID_fieldRemark);
      
          PROP_ID_TO_NAME[PROP_ID_fieldType] = PROP_NAME_fieldType;
          PROP_NAME_TO_ID.put(PROP_NAME_fieldType, PROP_ID_fieldType);
      
          PROP_ID_TO_NAME[PROP_ID_fieldJavaType] = PROP_NAME_fieldJavaType;
          PROP_NAME_TO_ID.put(PROP_NAME_fieldJavaType, PROP_ID_fieldJavaType);
      
          PROP_ID_TO_NAME[PROP_ID_effectType] = PROP_NAME_effectType;
          PROP_NAME_TO_ID.put(PROP_NAME_effectType, PROP_ID_effectType);
      
          PROP_ID_TO_NAME[PROP_ID_dictTypeCode] = PROP_NAME_dictTypeCode;
          PROP_NAME_TO_ID.put(PROP_NAME_dictTypeCode, PROP_ID_dictTypeCode);
      
          PROP_ID_TO_NAME[PROP_ID_whetherTable] = PROP_NAME_whetherTable;
          PROP_NAME_TO_ID.put(PROP_NAME_whetherTable, PROP_ID_whetherTable);
      
          PROP_ID_TO_NAME[PROP_ID_whetherRetract] = PROP_NAME_whetherRetract;
          PROP_NAME_TO_ID.put(PROP_NAME_whetherRetract, PROP_ID_whetherRetract);
      
          PROP_ID_TO_NAME[PROP_ID_whetherAddUpdate] = PROP_NAME_whetherAddUpdate;
          PROP_NAME_TO_ID.put(PROP_NAME_whetherAddUpdate, PROP_ID_whetherAddUpdate);
      
          PROP_ID_TO_NAME[PROP_ID_whetherRequired] = PROP_NAME_whetherRequired;
          PROP_NAME_TO_ID.put(PROP_NAME_whetherRequired, PROP_ID_whetherRequired);
      
          PROP_ID_TO_NAME[PROP_ID_queryWhether] = PROP_NAME_queryWhether;
          PROP_NAME_TO_ID.put(PROP_NAME_queryWhether, PROP_ID_queryWhether);
      
          PROP_ID_TO_NAME[PROP_ID_queryType] = PROP_NAME_queryType;
          PROP_NAME_TO_ID.put(PROP_NAME_queryType, PROP_ID_queryType);
      
          PROP_ID_TO_NAME[PROP_ID_sortCode] = PROP_NAME_sortCode;
          PROP_NAME_TO_ID.put(PROP_NAME_sortCode, PROP_ID_sortCode);
      
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

    
    /* 主键: ID */
    private java.lang.String _id_;
    
    /* 基础ID: BASIC_ID */
    private java.lang.String _basicId;
    
    /* 是否主键: IS_TABLE_KEY */
    private java.lang.String _isTableKey;
    
    /* 字段: FIELD_NAME */
    private java.lang.String _fieldName;
    
    /* 名称: FIELD_REMARK */
    private java.lang.String _fieldRemark;
    
    /* 类型: FIELD_TYPE */
    private java.lang.String _fieldType;
    
    /* 实体类型: FIELD_JAVA_TYPE */
    private java.lang.String _fieldJavaType;
    
    /* 作用类型: EFFECT_TYPE */
    private java.lang.String _effectType;
    
    /* 字典: DICT_TYPE_CODE */
    private java.lang.String _dictTypeCode;
    
    /* 列表显示: WHETHER_TABLE */
    private java.lang.String _whetherTable;
    
    /* 列省略: WHETHER_RETRACT */
    private java.lang.String _whetherRetract;
    
    /* 是否增改: WHETHER_ADD_UPDATE */
    private java.lang.String _whetherAddUpdate;
    
    /* 必填: WHETHER_REQUIRED */
    private java.lang.String _whetherRequired;
    
    /* 查询: QUERY_WHETHER */
    private java.lang.String _queryWhether;
    
    /* 查询方式: QUERY_TYPE */
    private java.lang.String _queryType;
    
    /* 排序: SORT_CODE */
    private java.lang.Integer _sortCode;
    
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
    

    public _GenConfig(){
        // for debug
    }

    protected GenConfig newInstance(){
        GenConfig entity = new GenConfig();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public GenConfig cloneInstance() {
        GenConfig entity = newInstance();
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
      return "com.fliad.resource.dao.entity.GenConfig";
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
        
            case PROP_ID_basicId:
               return getBasicId();
        
            case PROP_ID_isTableKey:
               return getIsTableKey();
        
            case PROP_ID_fieldName:
               return getFieldName();
        
            case PROP_ID_fieldRemark:
               return getFieldRemark();
        
            case PROP_ID_fieldType:
               return getFieldType();
        
            case PROP_ID_fieldJavaType:
               return getFieldJavaType();
        
            case PROP_ID_effectType:
               return getEffectType();
        
            case PROP_ID_dictTypeCode:
               return getDictTypeCode();
        
            case PROP_ID_whetherTable:
               return getWhetherTable();
        
            case PROP_ID_whetherRetract:
               return getWhetherRetract();
        
            case PROP_ID_whetherAddUpdate:
               return getWhetherAddUpdate();
        
            case PROP_ID_whetherRequired:
               return getWhetherRequired();
        
            case PROP_ID_queryWhether:
               return getQueryWhether();
        
            case PROP_ID_queryType:
               return getQueryType();
        
            case PROP_ID_sortCode:
               return getSortCode();
        
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
        
            case PROP_ID_basicId:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_basicId));
               }
               setBasicId(typedValue);
               break;
            }
        
            case PROP_ID_isTableKey:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_isTableKey));
               }
               setIsTableKey(typedValue);
               break;
            }
        
            case PROP_ID_fieldName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_fieldName));
               }
               setFieldName(typedValue);
               break;
            }
        
            case PROP_ID_fieldRemark:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_fieldRemark));
               }
               setFieldRemark(typedValue);
               break;
            }
        
            case PROP_ID_fieldType:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_fieldType));
               }
               setFieldType(typedValue);
               break;
            }
        
            case PROP_ID_fieldJavaType:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_fieldJavaType));
               }
               setFieldJavaType(typedValue);
               break;
            }
        
            case PROP_ID_effectType:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_effectType));
               }
               setEffectType(typedValue);
               break;
            }
        
            case PROP_ID_dictTypeCode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_dictTypeCode));
               }
               setDictTypeCode(typedValue);
               break;
            }
        
            case PROP_ID_whetherTable:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_whetherTable));
               }
               setWhetherTable(typedValue);
               break;
            }
        
            case PROP_ID_whetherRetract:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_whetherRetract));
               }
               setWhetherRetract(typedValue);
               break;
            }
        
            case PROP_ID_whetherAddUpdate:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_whetherAddUpdate));
               }
               setWhetherAddUpdate(typedValue);
               break;
            }
        
            case PROP_ID_whetherRequired:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_whetherRequired));
               }
               setWhetherRequired(typedValue);
               break;
            }
        
            case PROP_ID_queryWhether:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_queryWhether));
               }
               setQueryWhether(typedValue);
               break;
            }
        
            case PROP_ID_queryType:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_queryType));
               }
               setQueryType(typedValue);
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
        
            case PROP_ID_basicId:{
               onInitProp(propId);
               this._basicId = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_isTableKey:{
               onInitProp(propId);
               this._isTableKey = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_fieldName:{
               onInitProp(propId);
               this._fieldName = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_fieldRemark:{
               onInitProp(propId);
               this._fieldRemark = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_fieldType:{
               onInitProp(propId);
               this._fieldType = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_fieldJavaType:{
               onInitProp(propId);
               this._fieldJavaType = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_effectType:{
               onInitProp(propId);
               this._effectType = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_dictTypeCode:{
               onInitProp(propId);
               this._dictTypeCode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_whetherTable:{
               onInitProp(propId);
               this._whetherTable = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_whetherRetract:{
               onInitProp(propId);
               this._whetherRetract = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_whetherAddUpdate:{
               onInitProp(propId);
               this._whetherAddUpdate = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_whetherRequired:{
               onInitProp(propId);
               this._whetherRequired = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_queryWhether:{
               onInitProp(propId);
               this._queryWhether = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_queryType:{
               onInitProp(propId);
               this._queryType = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_sortCode:{
               onInitProp(propId);
               this._sortCode = (java.lang.Integer)value;
               
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
     * 基础ID: BASIC_ID
     */
    public final java.lang.String getBasicId(){
         onPropGet(PROP_ID_basicId);
         return _basicId;
    }

    /**
     * 基础ID: BASIC_ID
     */
    public final void setBasicId(java.lang.String value){
        if(onPropSet(PROP_ID_basicId,value)){
            this._basicId = value;
            internalClearRefs(PROP_ID_basicId);
            
        }
    }
    
    /**
     * 是否主键: IS_TABLE_KEY
     */
    public final java.lang.String getIsTableKey(){
         onPropGet(PROP_ID_isTableKey);
         return _isTableKey;
    }

    /**
     * 是否主键: IS_TABLE_KEY
     */
    public final void setIsTableKey(java.lang.String value){
        if(onPropSet(PROP_ID_isTableKey,value)){
            this._isTableKey = value;
            internalClearRefs(PROP_ID_isTableKey);
            
        }
    }
    
    /**
     * 字段: FIELD_NAME
     */
    public final java.lang.String getFieldName(){
         onPropGet(PROP_ID_fieldName);
         return _fieldName;
    }

    /**
     * 字段: FIELD_NAME
     */
    public final void setFieldName(java.lang.String value){
        if(onPropSet(PROP_ID_fieldName,value)){
            this._fieldName = value;
            internalClearRefs(PROP_ID_fieldName);
            
        }
    }
    
    /**
     * 名称: FIELD_REMARK
     */
    public final java.lang.String getFieldRemark(){
         onPropGet(PROP_ID_fieldRemark);
         return _fieldRemark;
    }

    /**
     * 名称: FIELD_REMARK
     */
    public final void setFieldRemark(java.lang.String value){
        if(onPropSet(PROP_ID_fieldRemark,value)){
            this._fieldRemark = value;
            internalClearRefs(PROP_ID_fieldRemark);
            
        }
    }
    
    /**
     * 类型: FIELD_TYPE
     */
    public final java.lang.String getFieldType(){
         onPropGet(PROP_ID_fieldType);
         return _fieldType;
    }

    /**
     * 类型: FIELD_TYPE
     */
    public final void setFieldType(java.lang.String value){
        if(onPropSet(PROP_ID_fieldType,value)){
            this._fieldType = value;
            internalClearRefs(PROP_ID_fieldType);
            
        }
    }
    
    /**
     * 实体类型: FIELD_JAVA_TYPE
     */
    public final java.lang.String getFieldJavaType(){
         onPropGet(PROP_ID_fieldJavaType);
         return _fieldJavaType;
    }

    /**
     * 实体类型: FIELD_JAVA_TYPE
     */
    public final void setFieldJavaType(java.lang.String value){
        if(onPropSet(PROP_ID_fieldJavaType,value)){
            this._fieldJavaType = value;
            internalClearRefs(PROP_ID_fieldJavaType);
            
        }
    }
    
    /**
     * 作用类型: EFFECT_TYPE
     */
    public final java.lang.String getEffectType(){
         onPropGet(PROP_ID_effectType);
         return _effectType;
    }

    /**
     * 作用类型: EFFECT_TYPE
     */
    public final void setEffectType(java.lang.String value){
        if(onPropSet(PROP_ID_effectType,value)){
            this._effectType = value;
            internalClearRefs(PROP_ID_effectType);
            
        }
    }
    
    /**
     * 字典: DICT_TYPE_CODE
     */
    public final java.lang.String getDictTypeCode(){
         onPropGet(PROP_ID_dictTypeCode);
         return _dictTypeCode;
    }

    /**
     * 字典: DICT_TYPE_CODE
     */
    public final void setDictTypeCode(java.lang.String value){
        if(onPropSet(PROP_ID_dictTypeCode,value)){
            this._dictTypeCode = value;
            internalClearRefs(PROP_ID_dictTypeCode);
            
        }
    }
    
    /**
     * 列表显示: WHETHER_TABLE
     */
    public final java.lang.String getWhetherTable(){
         onPropGet(PROP_ID_whetherTable);
         return _whetherTable;
    }

    /**
     * 列表显示: WHETHER_TABLE
     */
    public final void setWhetherTable(java.lang.String value){
        if(onPropSet(PROP_ID_whetherTable,value)){
            this._whetherTable = value;
            internalClearRefs(PROP_ID_whetherTable);
            
        }
    }
    
    /**
     * 列省略: WHETHER_RETRACT
     */
    public final java.lang.String getWhetherRetract(){
         onPropGet(PROP_ID_whetherRetract);
         return _whetherRetract;
    }

    /**
     * 列省略: WHETHER_RETRACT
     */
    public final void setWhetherRetract(java.lang.String value){
        if(onPropSet(PROP_ID_whetherRetract,value)){
            this._whetherRetract = value;
            internalClearRefs(PROP_ID_whetherRetract);
            
        }
    }
    
    /**
     * 是否增改: WHETHER_ADD_UPDATE
     */
    public final java.lang.String getWhetherAddUpdate(){
         onPropGet(PROP_ID_whetherAddUpdate);
         return _whetherAddUpdate;
    }

    /**
     * 是否增改: WHETHER_ADD_UPDATE
     */
    public final void setWhetherAddUpdate(java.lang.String value){
        if(onPropSet(PROP_ID_whetherAddUpdate,value)){
            this._whetherAddUpdate = value;
            internalClearRefs(PROP_ID_whetherAddUpdate);
            
        }
    }
    
    /**
     * 必填: WHETHER_REQUIRED
     */
    public final java.lang.String getWhetherRequired(){
         onPropGet(PROP_ID_whetherRequired);
         return _whetherRequired;
    }

    /**
     * 必填: WHETHER_REQUIRED
     */
    public final void setWhetherRequired(java.lang.String value){
        if(onPropSet(PROP_ID_whetherRequired,value)){
            this._whetherRequired = value;
            internalClearRefs(PROP_ID_whetherRequired);
            
        }
    }
    
    /**
     * 查询: QUERY_WHETHER
     */
    public final java.lang.String getQueryWhether(){
         onPropGet(PROP_ID_queryWhether);
         return _queryWhether;
    }

    /**
     * 查询: QUERY_WHETHER
     */
    public final void setQueryWhether(java.lang.String value){
        if(onPropSet(PROP_ID_queryWhether,value)){
            this._queryWhether = value;
            internalClearRefs(PROP_ID_queryWhether);
            
        }
    }
    
    /**
     * 查询方式: QUERY_TYPE
     */
    public final java.lang.String getQueryType(){
         onPropGet(PROP_ID_queryType);
         return _queryType;
    }

    /**
     * 查询方式: QUERY_TYPE
     */
    public final void setQueryType(java.lang.String value){
        if(onPropSet(PROP_ID_queryType,value)){
            this._queryType = value;
            internalClearRefs(PROP_ID_queryType);
            
        }
    }
    
    /**
     * 排序: SORT_CODE
     */
    public final java.lang.Integer getSortCode(){
         onPropGet(PROP_ID_sortCode);
         return _sortCode;
    }

    /**
     * 排序: SORT_CODE
     */
    public final void setSortCode(java.lang.Integer value){
        if(onPropSet(PROP_ID_sortCode,value)){
            this._sortCode = value;
            internalClearRefs(PROP_ID_sortCode);
            
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

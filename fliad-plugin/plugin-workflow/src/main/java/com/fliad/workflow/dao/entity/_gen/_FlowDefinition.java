package com.fliad.workflow.dao.entity._gen;

import io.nop.orm.model.IEntityModel;
import io.nop.orm.support.DynamicOrmEntity;
import io.nop.orm.support.OrmEntitySet; //NOPMD - suppressed UnusedImports - Auto Gen Code
import io.nop.orm.IOrmEntitySet; //NOPMD - suppressed UnusedImports - Auto Gen Code
import io.nop.api.core.convert.ConvertHelper;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

import com.fliad.workflow.dao.entity.FlowDefinition;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  流程定义表: flow_definition
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _FlowDefinition extends DynamicOrmEntity{
    
    /* 主键id: ID BIGINT */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 流程编码: FLOW_CODE VARCHAR */
    public static final String PROP_NAME_flowCode = "flowCode";
    public static final int PROP_ID_flowCode = 2;
    
    /* 流程名称: FLOW_NAME VARCHAR */
    public static final String PROP_NAME_flowName = "flowName";
    public static final int PROP_ID_flowName = 3;
    
    /* 设计器模型（CLASSICS经典模型 MIMIC仿钉钉模型）: MODEL_VALUE VARCHAR */
    public static final String PROP_NAME_modelValue = "modelValue";
    public static final int PROP_ID_modelValue = 4;
    
    /* 流程类别: CATEGORY VARCHAR */
    public static final String PROP_NAME_category = "category";
    public static final int PROP_ID_category = 5;
    
    /* 流程版本: VERSION VARCHAR */
    public static final String PROP_NAME_version = "version";
    public static final int PROP_ID_version = 6;
    
    /* 是否发布（0未发布 1已发布 9失效）: IS_PUBLISH BOOLEAN */
    public static final String PROP_NAME_isPublish = "isPublish";
    public static final int PROP_ID_isPublish = 7;
    
    /* 审批表单是否自定义（Y是 N否）: FORM_CUSTOM CHAR */
    public static final String PROP_NAME_formCustom = "formCustom";
    public static final int PROP_ID_formCustom = 8;
    
    /* 审批表单路径: FORM_PATH VARCHAR */
    public static final String PROP_NAME_formPath = "formPath";
    public static final int PROP_ID_formPath = 9;
    
    /* 流程激活状态（0挂起 1激活）: ACTIVITY_STATUS BOOLEAN */
    public static final String PROP_NAME_activityStatus = "activityStatus";
    public static final int PROP_ID_activityStatus = 10;
    
    /* 监听器类型: LISTENER_TYPE VARCHAR */
    public static final String PROP_NAME_listenerType = "listenerType";
    public static final int PROP_ID_listenerType = 11;
    
    /* 监听器路径: LISTENER_PATH VARCHAR */
    public static final String PROP_NAME_listenerPath = "listenerPath";
    public static final int PROP_ID_listenerPath = 12;
    
    /* 业务详情 存业务表对象json字符串: EXT VARCHAR */
    public static final String PROP_NAME_ext = "ext";
    public static final int PROP_ID_ext = 13;
    
    /* 创建时间: CREATE_TIME DATETIME */
    public static final String PROP_NAME_createTime = "createTime";
    public static final int PROP_ID_createTime = 14;
    
    /* 创建人: CREATE_BY VARCHAR */
    public static final String PROP_NAME_createBy = "createBy";
    public static final int PROP_ID_createBy = 15;
    
    /* 更新时间: UPDATE_TIME DATETIME */
    public static final String PROP_NAME_updateTime = "updateTime";
    public static final int PROP_ID_updateTime = 16;
    
    /* 更新人: UPDATE_BY VARCHAR */
    public static final String PROP_NAME_updateBy = "updateBy";
    public static final int PROP_ID_updateBy = 17;
    
    /* 删除标志: DEL_FLAG CHAR */
    public static final String PROP_NAME_delFlag = "delFlag";
    public static final int PROP_ID_delFlag = 18;
    
    /* 租户id: TENANT_ID VARCHAR */
    public static final String PROP_NAME_tenantId = "tenantId";
    public static final int PROP_ID_tenantId = 19;
    

    private static int _PROP_ID_BOUND = 20;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[20];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_flowCode] = PROP_NAME_flowCode;
          PROP_NAME_TO_ID.put(PROP_NAME_flowCode, PROP_ID_flowCode);
      
          PROP_ID_TO_NAME[PROP_ID_flowName] = PROP_NAME_flowName;
          PROP_NAME_TO_ID.put(PROP_NAME_flowName, PROP_ID_flowName);
      
          PROP_ID_TO_NAME[PROP_ID_modelValue] = PROP_NAME_modelValue;
          PROP_NAME_TO_ID.put(PROP_NAME_modelValue, PROP_ID_modelValue);
      
          PROP_ID_TO_NAME[PROP_ID_category] = PROP_NAME_category;
          PROP_NAME_TO_ID.put(PROP_NAME_category, PROP_ID_category);
      
          PROP_ID_TO_NAME[PROP_ID_version] = PROP_NAME_version;
          PROP_NAME_TO_ID.put(PROP_NAME_version, PROP_ID_version);
      
          PROP_ID_TO_NAME[PROP_ID_isPublish] = PROP_NAME_isPublish;
          PROP_NAME_TO_ID.put(PROP_NAME_isPublish, PROP_ID_isPublish);
      
          PROP_ID_TO_NAME[PROP_ID_formCustom] = PROP_NAME_formCustom;
          PROP_NAME_TO_ID.put(PROP_NAME_formCustom, PROP_ID_formCustom);
      
          PROP_ID_TO_NAME[PROP_ID_formPath] = PROP_NAME_formPath;
          PROP_NAME_TO_ID.put(PROP_NAME_formPath, PROP_ID_formPath);
      
          PROP_ID_TO_NAME[PROP_ID_activityStatus] = PROP_NAME_activityStatus;
          PROP_NAME_TO_ID.put(PROP_NAME_activityStatus, PROP_ID_activityStatus);
      
          PROP_ID_TO_NAME[PROP_ID_listenerType] = PROP_NAME_listenerType;
          PROP_NAME_TO_ID.put(PROP_NAME_listenerType, PROP_ID_listenerType);
      
          PROP_ID_TO_NAME[PROP_ID_listenerPath] = PROP_NAME_listenerPath;
          PROP_NAME_TO_ID.put(PROP_NAME_listenerPath, PROP_ID_listenerPath);
      
          PROP_ID_TO_NAME[PROP_ID_ext] = PROP_NAME_ext;
          PROP_NAME_TO_ID.put(PROP_NAME_ext, PROP_ID_ext);
      
          PROP_ID_TO_NAME[PROP_ID_createTime] = PROP_NAME_createTime;
          PROP_NAME_TO_ID.put(PROP_NAME_createTime, PROP_ID_createTime);
      
          PROP_ID_TO_NAME[PROP_ID_createBy] = PROP_NAME_createBy;
          PROP_NAME_TO_ID.put(PROP_NAME_createBy, PROP_ID_createBy);
      
          PROP_ID_TO_NAME[PROP_ID_updateTime] = PROP_NAME_updateTime;
          PROP_NAME_TO_ID.put(PROP_NAME_updateTime, PROP_ID_updateTime);
      
          PROP_ID_TO_NAME[PROP_ID_updateBy] = PROP_NAME_updateBy;
          PROP_NAME_TO_ID.put(PROP_NAME_updateBy, PROP_ID_updateBy);
      
          PROP_ID_TO_NAME[PROP_ID_delFlag] = PROP_NAME_delFlag;
          PROP_NAME_TO_ID.put(PROP_NAME_delFlag, PROP_ID_delFlag);
      
          PROP_ID_TO_NAME[PROP_ID_tenantId] = PROP_NAME_tenantId;
          PROP_NAME_TO_ID.put(PROP_NAME_tenantId, PROP_ID_tenantId);
      
    }

    
    /* 主键id: ID */
    private java.lang.Long _id_;
    
    /* 流程编码: FLOW_CODE */
    private java.lang.String _flowCode;
    
    /* 流程名称: FLOW_NAME */
    private java.lang.String _flowName;
    
    /* 设计器模型（CLASSICS经典模型 MIMIC仿钉钉模型）: MODEL_VALUE */
    private java.lang.String _modelValue;
    
    /* 流程类别: CATEGORY */
    private java.lang.String _category;
    
    /* 流程版本: VERSION */
    private java.lang.String _version;
    
    /* 是否发布（0未发布 1已发布 9失效）: IS_PUBLISH */
    private java.lang.Boolean _isPublish;
    
    /* 审批表单是否自定义（Y是 N否）: FORM_CUSTOM */
    private java.lang.String _formCustom;
    
    /* 审批表单路径: FORM_PATH */
    private java.lang.String _formPath;
    
    /* 流程激活状态（0挂起 1激活）: ACTIVITY_STATUS */
    private java.lang.Boolean _activityStatus;
    
    /* 监听器类型: LISTENER_TYPE */
    private java.lang.String _listenerType;
    
    /* 监听器路径: LISTENER_PATH */
    private java.lang.String _listenerPath;
    
    /* 业务详情 存业务表对象json字符串: EXT */
    private java.lang.String _ext;
    
    /* 创建时间: CREATE_TIME */
    private java.time.LocalDateTime _createTime;
    
    /* 创建人: CREATE_BY */
    private java.lang.String _createBy;
    
    /* 更新时间: UPDATE_TIME */
    private java.time.LocalDateTime _updateTime;
    
    /* 更新人: UPDATE_BY */
    private java.lang.String _updateBy;
    
    /* 删除标志: DEL_FLAG */
    private java.lang.String _delFlag;
    
    /* 租户id: TENANT_ID */
    private java.lang.String _tenantId;
    

    public _FlowDefinition(){
        // for debug
    }

    protected FlowDefinition newInstance(){
        FlowDefinition entity = new FlowDefinition();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public FlowDefinition cloneInstance() {
        FlowDefinition entity = newInstance();
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
      return "com.fliad.workflow.dao.entity.FlowDefinition";
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
        
            case PROP_ID_flowCode:
               return getFlowCode();
        
            case PROP_ID_flowName:
               return getFlowName();
        
            case PROP_ID_modelValue:
               return getModelValue();
        
            case PROP_ID_category:
               return getCategory();
        
            case PROP_ID_version:
               return getVersion();
        
            case PROP_ID_isPublish:
               return getIsPublish();
        
            case PROP_ID_formCustom:
               return getFormCustom();
        
            case PROP_ID_formPath:
               return getFormPath();
        
            case PROP_ID_activityStatus:
               return getActivityStatus();
        
            case PROP_ID_listenerType:
               return getListenerType();
        
            case PROP_ID_listenerPath:
               return getListenerPath();
        
            case PROP_ID_ext:
               return getExt();
        
            case PROP_ID_createTime:
               return getCreateTime();
        
            case PROP_ID_createBy:
               return getCreateBy();
        
            case PROP_ID_updateTime:
               return getUpdateTime();
        
            case PROP_ID_updateBy:
               return getUpdateBy();
        
            case PROP_ID_delFlag:
               return getDelFlag();
        
            case PROP_ID_tenantId:
               return getTenantId();
        
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
        
            case PROP_ID_flowCode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_flowCode));
               }
               setFlowCode(typedValue);
               break;
            }
        
            case PROP_ID_flowName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_flowName));
               }
               setFlowName(typedValue);
               break;
            }
        
            case PROP_ID_modelValue:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_modelValue));
               }
               setModelValue(typedValue);
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
        
            case PROP_ID_version:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_version));
               }
               setVersion(typedValue);
               break;
            }
        
            case PROP_ID_isPublish:{
               java.lang.Boolean typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toBoolean(value,
                       err-> newTypeConversionError(PROP_NAME_isPublish));
               }
               setIsPublish(typedValue);
               break;
            }
        
            case PROP_ID_formCustom:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_formCustom));
               }
               setFormCustom(typedValue);
               break;
            }
        
            case PROP_ID_formPath:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_formPath));
               }
               setFormPath(typedValue);
               break;
            }
        
            case PROP_ID_activityStatus:{
               java.lang.Boolean typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toBoolean(value,
                       err-> newTypeConversionError(PROP_NAME_activityStatus));
               }
               setActivityStatus(typedValue);
               break;
            }
        
            case PROP_ID_listenerType:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_listenerType));
               }
               setListenerType(typedValue);
               break;
            }
        
            case PROP_ID_listenerPath:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_listenerPath));
               }
               setListenerPath(typedValue);
               break;
            }
        
            case PROP_ID_ext:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_ext));
               }
               setExt(typedValue);
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
        
            case PROP_ID_createBy:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_createBy));
               }
               setCreateBy(typedValue);
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
        
            case PROP_ID_updateBy:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_updateBy));
               }
               setUpdateBy(typedValue);
               break;
            }
        
            case PROP_ID_delFlag:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_delFlag));
               }
               setDelFlag(typedValue);
               break;
            }
        
            case PROP_ID_tenantId:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_tenantId));
               }
               setTenantId(typedValue);
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
        
            case PROP_ID_flowCode:{
               onInitProp(propId);
               this._flowCode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_flowName:{
               onInitProp(propId);
               this._flowName = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_modelValue:{
               onInitProp(propId);
               this._modelValue = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_category:{
               onInitProp(propId);
               this._category = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_version:{
               onInitProp(propId);
               this._version = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_isPublish:{
               onInitProp(propId);
               this._isPublish = (java.lang.Boolean)value;
               
               break;
            }
        
            case PROP_ID_formCustom:{
               onInitProp(propId);
               this._formCustom = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_formPath:{
               onInitProp(propId);
               this._formPath = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_activityStatus:{
               onInitProp(propId);
               this._activityStatus = (java.lang.Boolean)value;
               
               break;
            }
        
            case PROP_ID_listenerType:{
               onInitProp(propId);
               this._listenerType = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_listenerPath:{
               onInitProp(propId);
               this._listenerPath = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_ext:{
               onInitProp(propId);
               this._ext = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_createTime:{
               onInitProp(propId);
               this._createTime = (java.time.LocalDateTime)value;
               
               break;
            }
        
            case PROP_ID_createBy:{
               onInitProp(propId);
               this._createBy = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_updateTime:{
               onInitProp(propId);
               this._updateTime = (java.time.LocalDateTime)value;
               
               break;
            }
        
            case PROP_ID_updateBy:{
               onInitProp(propId);
               this._updateBy = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_delFlag:{
               onInitProp(propId);
               this._delFlag = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_tenantId:{
               onInitProp(propId);
               this._tenantId = (java.lang.String)value;
               
               break;
            }
        
           default:
              super.orm_internalSet(propId,value);
        }
    }

    
    /**
     * 主键id: ID
     */
    public final java.lang.Long getId_(){
         onPropGet(PROP_ID_id_);
         return _id_;
    }

    /**
     * 主键id: ID
     */
    public final void setId_(java.lang.Long value){
        if(onPropSet(PROP_ID_id_,value)){
            this._id_ = value;
            internalClearRefs(PROP_ID_id_);
            orm_id();
        }
    }
    
    /**
     * 流程编码: FLOW_CODE
     */
    public final java.lang.String getFlowCode(){
         onPropGet(PROP_ID_flowCode);
         return _flowCode;
    }

    /**
     * 流程编码: FLOW_CODE
     */
    public final void setFlowCode(java.lang.String value){
        if(onPropSet(PROP_ID_flowCode,value)){
            this._flowCode = value;
            internalClearRefs(PROP_ID_flowCode);
            
        }
    }
    
    /**
     * 流程名称: FLOW_NAME
     */
    public final java.lang.String getFlowName(){
         onPropGet(PROP_ID_flowName);
         return _flowName;
    }

    /**
     * 流程名称: FLOW_NAME
     */
    public final void setFlowName(java.lang.String value){
        if(onPropSet(PROP_ID_flowName,value)){
            this._flowName = value;
            internalClearRefs(PROP_ID_flowName);
            
        }
    }
    
    /**
     * 设计器模型（CLASSICS经典模型 MIMIC仿钉钉模型）: MODEL_VALUE
     */
    public final java.lang.String getModelValue(){
         onPropGet(PROP_ID_modelValue);
         return _modelValue;
    }

    /**
     * 设计器模型（CLASSICS经典模型 MIMIC仿钉钉模型）: MODEL_VALUE
     */
    public final void setModelValue(java.lang.String value){
        if(onPropSet(PROP_ID_modelValue,value)){
            this._modelValue = value;
            internalClearRefs(PROP_ID_modelValue);
            
        }
    }
    
    /**
     * 流程类别: CATEGORY
     */
    public final java.lang.String getCategory(){
         onPropGet(PROP_ID_category);
         return _category;
    }

    /**
     * 流程类别: CATEGORY
     */
    public final void setCategory(java.lang.String value){
        if(onPropSet(PROP_ID_category,value)){
            this._category = value;
            internalClearRefs(PROP_ID_category);
            
        }
    }
    
    /**
     * 流程版本: VERSION
     */
    public final java.lang.String getVersion(){
         onPropGet(PROP_ID_version);
         return _version;
    }

    /**
     * 流程版本: VERSION
     */
    public final void setVersion(java.lang.String value){
        if(onPropSet(PROP_ID_version,value)){
            this._version = value;
            internalClearRefs(PROP_ID_version);
            
        }
    }
    
    /**
     * 是否发布（0未发布 1已发布 9失效）: IS_PUBLISH
     */
    public final java.lang.Boolean getIsPublish(){
         onPropGet(PROP_ID_isPublish);
         return _isPublish;
    }

    /**
     * 是否发布（0未发布 1已发布 9失效）: IS_PUBLISH
     */
    public final void setIsPublish(java.lang.Boolean value){
        if(onPropSet(PROP_ID_isPublish,value)){
            this._isPublish = value;
            internalClearRefs(PROP_ID_isPublish);
            
        }
    }
    
    /**
     * 审批表单是否自定义（Y是 N否）: FORM_CUSTOM
     */
    public final java.lang.String getFormCustom(){
         onPropGet(PROP_ID_formCustom);
         return _formCustom;
    }

    /**
     * 审批表单是否自定义（Y是 N否）: FORM_CUSTOM
     */
    public final void setFormCustom(java.lang.String value){
        if(onPropSet(PROP_ID_formCustom,value)){
            this._formCustom = value;
            internalClearRefs(PROP_ID_formCustom);
            
        }
    }
    
    /**
     * 审批表单路径: FORM_PATH
     */
    public final java.lang.String getFormPath(){
         onPropGet(PROP_ID_formPath);
         return _formPath;
    }

    /**
     * 审批表单路径: FORM_PATH
     */
    public final void setFormPath(java.lang.String value){
        if(onPropSet(PROP_ID_formPath,value)){
            this._formPath = value;
            internalClearRefs(PROP_ID_formPath);
            
        }
    }
    
    /**
     * 流程激活状态（0挂起 1激活）: ACTIVITY_STATUS
     */
    public final java.lang.Boolean getActivityStatus(){
         onPropGet(PROP_ID_activityStatus);
         return _activityStatus;
    }

    /**
     * 流程激活状态（0挂起 1激活）: ACTIVITY_STATUS
     */
    public final void setActivityStatus(java.lang.Boolean value){
        if(onPropSet(PROP_ID_activityStatus,value)){
            this._activityStatus = value;
            internalClearRefs(PROP_ID_activityStatus);
            
        }
    }
    
    /**
     * 监听器类型: LISTENER_TYPE
     */
    public final java.lang.String getListenerType(){
         onPropGet(PROP_ID_listenerType);
         return _listenerType;
    }

    /**
     * 监听器类型: LISTENER_TYPE
     */
    public final void setListenerType(java.lang.String value){
        if(onPropSet(PROP_ID_listenerType,value)){
            this._listenerType = value;
            internalClearRefs(PROP_ID_listenerType);
            
        }
    }
    
    /**
     * 监听器路径: LISTENER_PATH
     */
    public final java.lang.String getListenerPath(){
         onPropGet(PROP_ID_listenerPath);
         return _listenerPath;
    }

    /**
     * 监听器路径: LISTENER_PATH
     */
    public final void setListenerPath(java.lang.String value){
        if(onPropSet(PROP_ID_listenerPath,value)){
            this._listenerPath = value;
            internalClearRefs(PROP_ID_listenerPath);
            
        }
    }
    
    /**
     * 业务详情 存业务表对象json字符串: EXT
     */
    public final java.lang.String getExt(){
         onPropGet(PROP_ID_ext);
         return _ext;
    }

    /**
     * 业务详情 存业务表对象json字符串: EXT
     */
    public final void setExt(java.lang.String value){
        if(onPropSet(PROP_ID_ext,value)){
            this._ext = value;
            internalClearRefs(PROP_ID_ext);
            
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
     * 创建人: CREATE_BY
     */
    public final java.lang.String getCreateBy(){
         onPropGet(PROP_ID_createBy);
         return _createBy;
    }

    /**
     * 创建人: CREATE_BY
     */
    public final void setCreateBy(java.lang.String value){
        if(onPropSet(PROP_ID_createBy,value)){
            this._createBy = value;
            internalClearRefs(PROP_ID_createBy);
            
        }
    }
    
    /**
     * 更新时间: UPDATE_TIME
     */
    public final java.time.LocalDateTime getUpdateTime(){
         onPropGet(PROP_ID_updateTime);
         return _updateTime;
    }

    /**
     * 更新时间: UPDATE_TIME
     */
    public final void setUpdateTime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_updateTime,value)){
            this._updateTime = value;
            internalClearRefs(PROP_ID_updateTime);
            
        }
    }
    
    /**
     * 更新人: UPDATE_BY
     */
    public final java.lang.String getUpdateBy(){
         onPropGet(PROP_ID_updateBy);
         return _updateBy;
    }

    /**
     * 更新人: UPDATE_BY
     */
    public final void setUpdateBy(java.lang.String value){
        if(onPropSet(PROP_ID_updateBy,value)){
            this._updateBy = value;
            internalClearRefs(PROP_ID_updateBy);
            
        }
    }
    
    /**
     * 删除标志: DEL_FLAG
     */
    public final java.lang.String getDelFlag(){
         onPropGet(PROP_ID_delFlag);
         return _delFlag;
    }

    /**
     * 删除标志: DEL_FLAG
     */
    public final void setDelFlag(java.lang.String value){
        if(onPropSet(PROP_ID_delFlag,value)){
            this._delFlag = value;
            internalClearRefs(PROP_ID_delFlag);
            
        }
    }
    
    /**
     * 租户id: TENANT_ID
     */
    public final java.lang.String getTenantId(){
         onPropGet(PROP_ID_tenantId);
         return _tenantId;
    }

    /**
     * 租户id: TENANT_ID
     */
    public final void setTenantId(java.lang.String value){
        if(onPropSet(PROP_ID_tenantId,value)){
            this._tenantId = value;
            internalClearRefs(PROP_ID_tenantId);
            
        }
    }
    
}
// resume CPD analysis - CPD-ON

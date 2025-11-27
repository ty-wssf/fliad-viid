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

import com.fliad.workflow.dao.entity.FlowUser;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  流程用户表: flow_user
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _FlowUser extends DynamicOrmEntity{
    
    /* 主键id: ID BIGINT */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 人员类型（1待办任务的审批人权限 2待办任务的转办人权限 3待办任务的委托人权限）: TYPE CHAR */
    public static final String PROP_NAME_type = "type";
    public static final int PROP_ID_type = 2;
    
    /* 权限人: PROCESSED_BY VARCHAR */
    public static final String PROP_NAME_processedBy = "processedBy";
    public static final int PROP_ID_processedBy = 3;
    
    /* 任务表id: ASSOCIATED BIGINT */
    public static final String PROP_NAME_associated = "associated";
    public static final int PROP_ID_associated = 4;
    
    /* 创建时间: CREATE_TIME DATETIME */
    public static final String PROP_NAME_createTime = "createTime";
    public static final int PROP_ID_createTime = 5;
    
    /* 创建人: CREATE_BY VARCHAR */
    public static final String PROP_NAME_createBy = "createBy";
    public static final int PROP_ID_createBy = 6;
    
    /* 更新时间: UPDATE_TIME DATETIME */
    public static final String PROP_NAME_updateTime = "updateTime";
    public static final int PROP_ID_updateTime = 7;
    
    /* 创建人: UPDATE_BY VARCHAR */
    public static final String PROP_NAME_updateBy = "updateBy";
    public static final int PROP_ID_updateBy = 8;
    
    /* 删除标志: DEL_FLAG CHAR */
    public static final String PROP_NAME_delFlag = "delFlag";
    public static final int PROP_ID_delFlag = 9;
    
    /* 租户id: TENANT_ID VARCHAR */
    public static final String PROP_NAME_tenantId = "tenantId";
    public static final int PROP_ID_tenantId = 10;
    

    private static int _PROP_ID_BOUND = 11;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[11];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_type] = PROP_NAME_type;
          PROP_NAME_TO_ID.put(PROP_NAME_type, PROP_ID_type);
      
          PROP_ID_TO_NAME[PROP_ID_processedBy] = PROP_NAME_processedBy;
          PROP_NAME_TO_ID.put(PROP_NAME_processedBy, PROP_ID_processedBy);
      
          PROP_ID_TO_NAME[PROP_ID_associated] = PROP_NAME_associated;
          PROP_NAME_TO_ID.put(PROP_NAME_associated, PROP_ID_associated);
      
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
    
    /* 人员类型（1待办任务的审批人权限 2待办任务的转办人权限 3待办任务的委托人权限）: TYPE */
    private java.lang.String _type;
    
    /* 权限人: PROCESSED_BY */
    private java.lang.String _processedBy;
    
    /* 任务表id: ASSOCIATED */
    private java.lang.Long _associated;
    
    /* 创建时间: CREATE_TIME */
    private java.time.LocalDateTime _createTime;
    
    /* 创建人: CREATE_BY */
    private java.lang.String _createBy;
    
    /* 更新时间: UPDATE_TIME */
    private java.time.LocalDateTime _updateTime;
    
    /* 创建人: UPDATE_BY */
    private java.lang.String _updateBy;
    
    /* 删除标志: DEL_FLAG */
    private java.lang.String _delFlag;
    
    /* 租户id: TENANT_ID */
    private java.lang.String _tenantId;
    

    public _FlowUser(){
        // for debug
    }

    protected FlowUser newInstance(){
        FlowUser entity = new FlowUser();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public FlowUser cloneInstance() {
        FlowUser entity = newInstance();
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
      return "com.fliad.workflow.dao.entity.FlowUser";
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
        
            case PROP_ID_type:
               return getType();
        
            case PROP_ID_processedBy:
               return getProcessedBy();
        
            case PROP_ID_associated:
               return getAssociated();
        
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
        
            case PROP_ID_type:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_type));
               }
               setType(typedValue);
               break;
            }
        
            case PROP_ID_processedBy:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_processedBy));
               }
               setProcessedBy(typedValue);
               break;
            }
        
            case PROP_ID_associated:{
               java.lang.Long typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLong(value,
                       err-> newTypeConversionError(PROP_NAME_associated));
               }
               setAssociated(typedValue);
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
        
            case PROP_ID_type:{
               onInitProp(propId);
               this._type = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_processedBy:{
               onInitProp(propId);
               this._processedBy = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_associated:{
               onInitProp(propId);
               this._associated = (java.lang.Long)value;
               
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
     * 人员类型（1待办任务的审批人权限 2待办任务的转办人权限 3待办任务的委托人权限）: TYPE
     */
    public final java.lang.String getType(){
         onPropGet(PROP_ID_type);
         return _type;
    }

    /**
     * 人员类型（1待办任务的审批人权限 2待办任务的转办人权限 3待办任务的委托人权限）: TYPE
     */
    public final void setType(java.lang.String value){
        if(onPropSet(PROP_ID_type,value)){
            this._type = value;
            internalClearRefs(PROP_ID_type);
            
        }
    }
    
    /**
     * 权限人: PROCESSED_BY
     */
    public final java.lang.String getProcessedBy(){
         onPropGet(PROP_ID_processedBy);
         return _processedBy;
    }

    /**
     * 权限人: PROCESSED_BY
     */
    public final void setProcessedBy(java.lang.String value){
        if(onPropSet(PROP_ID_processedBy,value)){
            this._processedBy = value;
            internalClearRefs(PROP_ID_processedBy);
            
        }
    }
    
    /**
     * 任务表id: ASSOCIATED
     */
    public final java.lang.Long getAssociated(){
         onPropGet(PROP_ID_associated);
         return _associated;
    }

    /**
     * 任务表id: ASSOCIATED
     */
    public final void setAssociated(java.lang.Long value){
        if(onPropSet(PROP_ID_associated,value)){
            this._associated = value;
            internalClearRefs(PROP_ID_associated);
            
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
     * 创建人: UPDATE_BY
     */
    public final java.lang.String getUpdateBy(){
         onPropGet(PROP_ID_updateBy);
         return _updateBy;
    }

    /**
     * 创建人: UPDATE_BY
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

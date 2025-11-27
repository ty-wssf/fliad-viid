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

import com.fliad.workflow.dao.entity.FlowSkip;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  节点跳转关联表: flow_skip
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _FlowSkip extends DynamicOrmEntity{
    
    /* 主键id: ID BIGINT */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 流程定义id: DEFINITION_ID BIGINT */
    public static final String PROP_NAME_definitionId = "definitionId";
    public static final int PROP_ID_definitionId = 2;
    
    /* 当前流程节点的编码: NOW_NODE_CODE VARCHAR */
    public static final String PROP_NAME_nowNodeCode = "nowNodeCode";
    public static final int PROP_ID_nowNodeCode = 3;
    
    /* 当前节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NOW_NODE_TYPE BOOLEAN */
    public static final String PROP_NAME_nowNodeType = "nowNodeType";
    public static final int PROP_ID_nowNodeType = 4;
    
    /* 下一个流程节点的编码: NEXT_NODE_CODE VARCHAR */
    public static final String PROP_NAME_nextNodeCode = "nextNodeCode";
    public static final int PROP_ID_nextNodeCode = 5;
    
    /* 下一个节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NEXT_NODE_TYPE BOOLEAN */
    public static final String PROP_NAME_nextNodeType = "nextNodeType";
    public static final int PROP_ID_nextNodeType = 6;
    
    /* 跳转名称: SKIP_NAME VARCHAR */
    public static final String PROP_NAME_skipName = "skipName";
    public static final int PROP_ID_skipName = 7;
    
    /* 跳转类型（PASS审批通过 REJECT退回）: SKIP_TYPE VARCHAR */
    public static final String PROP_NAME_skipType = "skipType";
    public static final int PROP_ID_skipType = 8;
    
    /* 跳转条件: SKIP_CONDITION VARCHAR */
    public static final String PROP_NAME_skipCondition = "skipCondition";
    public static final int PROP_ID_skipCondition = 9;
    
    /* 坐标: COORDINATE VARCHAR */
    public static final String PROP_NAME_coordinate = "coordinate";
    public static final int PROP_ID_coordinate = 10;
    
    /* 创建时间: CREATE_TIME DATETIME */
    public static final String PROP_NAME_createTime = "createTime";
    public static final int PROP_ID_createTime = 11;
    
    /* 创建人: CREATE_BY VARCHAR */
    public static final String PROP_NAME_createBy = "createBy";
    public static final int PROP_ID_createBy = 12;
    
    /* 更新时间: UPDATE_TIME DATETIME */
    public static final String PROP_NAME_updateTime = "updateTime";
    public static final int PROP_ID_updateTime = 13;
    
    /* 更新人: UPDATE_BY VARCHAR */
    public static final String PROP_NAME_updateBy = "updateBy";
    public static final int PROP_ID_updateBy = 14;
    
    /* 删除标志: DEL_FLAG CHAR */
    public static final String PROP_NAME_delFlag = "delFlag";
    public static final int PROP_ID_delFlag = 15;
    
    /* 租户id: TENANT_ID VARCHAR */
    public static final String PROP_NAME_tenantId = "tenantId";
    public static final int PROP_ID_tenantId = 16;
    

    private static int _PROP_ID_BOUND = 17;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[17];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_definitionId] = PROP_NAME_definitionId;
          PROP_NAME_TO_ID.put(PROP_NAME_definitionId, PROP_ID_definitionId);
      
          PROP_ID_TO_NAME[PROP_ID_nowNodeCode] = PROP_NAME_nowNodeCode;
          PROP_NAME_TO_ID.put(PROP_NAME_nowNodeCode, PROP_ID_nowNodeCode);
      
          PROP_ID_TO_NAME[PROP_ID_nowNodeType] = PROP_NAME_nowNodeType;
          PROP_NAME_TO_ID.put(PROP_NAME_nowNodeType, PROP_ID_nowNodeType);
      
          PROP_ID_TO_NAME[PROP_ID_nextNodeCode] = PROP_NAME_nextNodeCode;
          PROP_NAME_TO_ID.put(PROP_NAME_nextNodeCode, PROP_ID_nextNodeCode);
      
          PROP_ID_TO_NAME[PROP_ID_nextNodeType] = PROP_NAME_nextNodeType;
          PROP_NAME_TO_ID.put(PROP_NAME_nextNodeType, PROP_ID_nextNodeType);
      
          PROP_ID_TO_NAME[PROP_ID_skipName] = PROP_NAME_skipName;
          PROP_NAME_TO_ID.put(PROP_NAME_skipName, PROP_ID_skipName);
      
          PROP_ID_TO_NAME[PROP_ID_skipType] = PROP_NAME_skipType;
          PROP_NAME_TO_ID.put(PROP_NAME_skipType, PROP_ID_skipType);
      
          PROP_ID_TO_NAME[PROP_ID_skipCondition] = PROP_NAME_skipCondition;
          PROP_NAME_TO_ID.put(PROP_NAME_skipCondition, PROP_ID_skipCondition);
      
          PROP_ID_TO_NAME[PROP_ID_coordinate] = PROP_NAME_coordinate;
          PROP_NAME_TO_ID.put(PROP_NAME_coordinate, PROP_ID_coordinate);
      
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
    
    /* 流程定义id: DEFINITION_ID */
    private java.lang.Long _definitionId;
    
    /* 当前流程节点的编码: NOW_NODE_CODE */
    private java.lang.String _nowNodeCode;
    
    /* 当前节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NOW_NODE_TYPE */
    private java.lang.Boolean _nowNodeType;
    
    /* 下一个流程节点的编码: NEXT_NODE_CODE */
    private java.lang.String _nextNodeCode;
    
    /* 下一个节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NEXT_NODE_TYPE */
    private java.lang.Boolean _nextNodeType;
    
    /* 跳转名称: SKIP_NAME */
    private java.lang.String _skipName;
    
    /* 跳转类型（PASS审批通过 REJECT退回）: SKIP_TYPE */
    private java.lang.String _skipType;
    
    /* 跳转条件: SKIP_CONDITION */
    private java.lang.String _skipCondition;
    
    /* 坐标: COORDINATE */
    private java.lang.String _coordinate;
    
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
    

    public _FlowSkip(){
        // for debug
    }

    protected FlowSkip newInstance(){
        FlowSkip entity = new FlowSkip();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public FlowSkip cloneInstance() {
        FlowSkip entity = newInstance();
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
      return "com.fliad.workflow.dao.entity.FlowSkip";
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
        
            case PROP_ID_definitionId:
               return getDefinitionId();
        
            case PROP_ID_nowNodeCode:
               return getNowNodeCode();
        
            case PROP_ID_nowNodeType:
               return getNowNodeType();
        
            case PROP_ID_nextNodeCode:
               return getNextNodeCode();
        
            case PROP_ID_nextNodeType:
               return getNextNodeType();
        
            case PROP_ID_skipName:
               return getSkipName();
        
            case PROP_ID_skipType:
               return getSkipType();
        
            case PROP_ID_skipCondition:
               return getSkipCondition();
        
            case PROP_ID_coordinate:
               return getCoordinate();
        
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
        
            case PROP_ID_definitionId:{
               java.lang.Long typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLong(value,
                       err-> newTypeConversionError(PROP_NAME_definitionId));
               }
               setDefinitionId(typedValue);
               break;
            }
        
            case PROP_ID_nowNodeCode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_nowNodeCode));
               }
               setNowNodeCode(typedValue);
               break;
            }
        
            case PROP_ID_nowNodeType:{
               java.lang.Boolean typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toBoolean(value,
                       err-> newTypeConversionError(PROP_NAME_nowNodeType));
               }
               setNowNodeType(typedValue);
               break;
            }
        
            case PROP_ID_nextNodeCode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_nextNodeCode));
               }
               setNextNodeCode(typedValue);
               break;
            }
        
            case PROP_ID_nextNodeType:{
               java.lang.Boolean typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toBoolean(value,
                       err-> newTypeConversionError(PROP_NAME_nextNodeType));
               }
               setNextNodeType(typedValue);
               break;
            }
        
            case PROP_ID_skipName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_skipName));
               }
               setSkipName(typedValue);
               break;
            }
        
            case PROP_ID_skipType:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_skipType));
               }
               setSkipType(typedValue);
               break;
            }
        
            case PROP_ID_skipCondition:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_skipCondition));
               }
               setSkipCondition(typedValue);
               break;
            }
        
            case PROP_ID_coordinate:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_coordinate));
               }
               setCoordinate(typedValue);
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
        
            case PROP_ID_definitionId:{
               onInitProp(propId);
               this._definitionId = (java.lang.Long)value;
               
               break;
            }
        
            case PROP_ID_nowNodeCode:{
               onInitProp(propId);
               this._nowNodeCode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_nowNodeType:{
               onInitProp(propId);
               this._nowNodeType = (java.lang.Boolean)value;
               
               break;
            }
        
            case PROP_ID_nextNodeCode:{
               onInitProp(propId);
               this._nextNodeCode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_nextNodeType:{
               onInitProp(propId);
               this._nextNodeType = (java.lang.Boolean)value;
               
               break;
            }
        
            case PROP_ID_skipName:{
               onInitProp(propId);
               this._skipName = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_skipType:{
               onInitProp(propId);
               this._skipType = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_skipCondition:{
               onInitProp(propId);
               this._skipCondition = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_coordinate:{
               onInitProp(propId);
               this._coordinate = (java.lang.String)value;
               
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
     * 流程定义id: DEFINITION_ID
     */
    public final java.lang.Long getDefinitionId(){
         onPropGet(PROP_ID_definitionId);
         return _definitionId;
    }

    /**
     * 流程定义id: DEFINITION_ID
     */
    public final void setDefinitionId(java.lang.Long value){
        if(onPropSet(PROP_ID_definitionId,value)){
            this._definitionId = value;
            internalClearRefs(PROP_ID_definitionId);
            
        }
    }
    
    /**
     * 当前流程节点的编码: NOW_NODE_CODE
     */
    public final java.lang.String getNowNodeCode(){
         onPropGet(PROP_ID_nowNodeCode);
         return _nowNodeCode;
    }

    /**
     * 当前流程节点的编码: NOW_NODE_CODE
     */
    public final void setNowNodeCode(java.lang.String value){
        if(onPropSet(PROP_ID_nowNodeCode,value)){
            this._nowNodeCode = value;
            internalClearRefs(PROP_ID_nowNodeCode);
            
        }
    }
    
    /**
     * 当前节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NOW_NODE_TYPE
     */
    public final java.lang.Boolean getNowNodeType(){
         onPropGet(PROP_ID_nowNodeType);
         return _nowNodeType;
    }

    /**
     * 当前节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NOW_NODE_TYPE
     */
    public final void setNowNodeType(java.lang.Boolean value){
        if(onPropSet(PROP_ID_nowNodeType,value)){
            this._nowNodeType = value;
            internalClearRefs(PROP_ID_nowNodeType);
            
        }
    }
    
    /**
     * 下一个流程节点的编码: NEXT_NODE_CODE
     */
    public final java.lang.String getNextNodeCode(){
         onPropGet(PROP_ID_nextNodeCode);
         return _nextNodeCode;
    }

    /**
     * 下一个流程节点的编码: NEXT_NODE_CODE
     */
    public final void setNextNodeCode(java.lang.String value){
        if(onPropSet(PROP_ID_nextNodeCode,value)){
            this._nextNodeCode = value;
            internalClearRefs(PROP_ID_nextNodeCode);
            
        }
    }
    
    /**
     * 下一个节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NEXT_NODE_TYPE
     */
    public final java.lang.Boolean getNextNodeType(){
         onPropGet(PROP_ID_nextNodeType);
         return _nextNodeType;
    }

    /**
     * 下一个节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NEXT_NODE_TYPE
     */
    public final void setNextNodeType(java.lang.Boolean value){
        if(onPropSet(PROP_ID_nextNodeType,value)){
            this._nextNodeType = value;
            internalClearRefs(PROP_ID_nextNodeType);
            
        }
    }
    
    /**
     * 跳转名称: SKIP_NAME
     */
    public final java.lang.String getSkipName(){
         onPropGet(PROP_ID_skipName);
         return _skipName;
    }

    /**
     * 跳转名称: SKIP_NAME
     */
    public final void setSkipName(java.lang.String value){
        if(onPropSet(PROP_ID_skipName,value)){
            this._skipName = value;
            internalClearRefs(PROP_ID_skipName);
            
        }
    }
    
    /**
     * 跳转类型（PASS审批通过 REJECT退回）: SKIP_TYPE
     */
    public final java.lang.String getSkipType(){
         onPropGet(PROP_ID_skipType);
         return _skipType;
    }

    /**
     * 跳转类型（PASS审批通过 REJECT退回）: SKIP_TYPE
     */
    public final void setSkipType(java.lang.String value){
        if(onPropSet(PROP_ID_skipType,value)){
            this._skipType = value;
            internalClearRefs(PROP_ID_skipType);
            
        }
    }
    
    /**
     * 跳转条件: SKIP_CONDITION
     */
    public final java.lang.String getSkipCondition(){
         onPropGet(PROP_ID_skipCondition);
         return _skipCondition;
    }

    /**
     * 跳转条件: SKIP_CONDITION
     */
    public final void setSkipCondition(java.lang.String value){
        if(onPropSet(PROP_ID_skipCondition,value)){
            this._skipCondition = value;
            internalClearRefs(PROP_ID_skipCondition);
            
        }
    }
    
    /**
     * 坐标: COORDINATE
     */
    public final java.lang.String getCoordinate(){
         onPropGet(PROP_ID_coordinate);
         return _coordinate;
    }

    /**
     * 坐标: COORDINATE
     */
    public final void setCoordinate(java.lang.String value){
        if(onPropSet(PROP_ID_coordinate,value)){
            this._coordinate = value;
            internalClearRefs(PROP_ID_coordinate);
            
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

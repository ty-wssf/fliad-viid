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

import com.fliad.workflow.dao.entity.FlowTask;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  待办任务表: flow_task
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _FlowTask extends DynamicOrmEntity{
    
    /* 主键id: ID BIGINT */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 对应flow_definition表的id: DEFINITION_ID BIGINT */
    public static final String PROP_NAME_definitionId = "definitionId";
    public static final int PROP_ID_definitionId = 2;
    
    /* 对应flow_instance表的id: INSTANCE_ID BIGINT */
    public static final String PROP_NAME_instanceId = "instanceId";
    public static final int PROP_ID_instanceId = 3;
    
    /* 节点编码: NODE_CODE VARCHAR */
    public static final String PROP_NAME_nodeCode = "nodeCode";
    public static final int PROP_ID_nodeCode = 4;
    
    /* 节点名称: NODE_NAME VARCHAR */
    public static final String PROP_NAME_nodeName = "nodeName";
    public static final int PROP_ID_nodeName = 5;
    
    /* 节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NODE_TYPE BOOLEAN */
    public static final String PROP_NAME_nodeType = "nodeType";
    public static final int PROP_ID_nodeType = 6;
    
    /* 流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）: FLOW_STATUS VARCHAR */
    public static final String PROP_NAME_flowStatus = "flowStatus";
    public static final int PROP_ID_flowStatus = 7;
    
    /* 审批表单是否自定义（Y是 N否）: FORM_CUSTOM CHAR */
    public static final String PROP_NAME_formCustom = "formCustom";
    public static final int PROP_ID_formCustom = 8;
    
    /* 审批表单路径: FORM_PATH VARCHAR */
    public static final String PROP_NAME_formPath = "formPath";
    public static final int PROP_ID_formPath = 9;
    
    /* 创建时间: CREATE_TIME DATETIME */
    public static final String PROP_NAME_createTime = "createTime";
    public static final int PROP_ID_createTime = 10;
    
    /* 创建人: CREATE_BY VARCHAR */
    public static final String PROP_NAME_createBy = "createBy";
    public static final int PROP_ID_createBy = 11;
    
    /* 更新时间: UPDATE_TIME DATETIME */
    public static final String PROP_NAME_updateTime = "updateTime";
    public static final int PROP_ID_updateTime = 12;
    
    /* 更新人: UPDATE_BY VARCHAR */
    public static final String PROP_NAME_updateBy = "updateBy";
    public static final int PROP_ID_updateBy = 13;
    
    /* 删除标志: DEL_FLAG CHAR */
    public static final String PROP_NAME_delFlag = "delFlag";
    public static final int PROP_ID_delFlag = 14;
    
    /* 租户id: TENANT_ID VARCHAR */
    public static final String PROP_NAME_tenantId = "tenantId";
    public static final int PROP_ID_tenantId = 15;
    

    private static int _PROP_ID_BOUND = 16;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[16];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_definitionId] = PROP_NAME_definitionId;
          PROP_NAME_TO_ID.put(PROP_NAME_definitionId, PROP_ID_definitionId);
      
          PROP_ID_TO_NAME[PROP_ID_instanceId] = PROP_NAME_instanceId;
          PROP_NAME_TO_ID.put(PROP_NAME_instanceId, PROP_ID_instanceId);
      
          PROP_ID_TO_NAME[PROP_ID_nodeCode] = PROP_NAME_nodeCode;
          PROP_NAME_TO_ID.put(PROP_NAME_nodeCode, PROP_ID_nodeCode);
      
          PROP_ID_TO_NAME[PROP_ID_nodeName] = PROP_NAME_nodeName;
          PROP_NAME_TO_ID.put(PROP_NAME_nodeName, PROP_ID_nodeName);
      
          PROP_ID_TO_NAME[PROP_ID_nodeType] = PROP_NAME_nodeType;
          PROP_NAME_TO_ID.put(PROP_NAME_nodeType, PROP_ID_nodeType);
      
          PROP_ID_TO_NAME[PROP_ID_flowStatus] = PROP_NAME_flowStatus;
          PROP_NAME_TO_ID.put(PROP_NAME_flowStatus, PROP_ID_flowStatus);
      
          PROP_ID_TO_NAME[PROP_ID_formCustom] = PROP_NAME_formCustom;
          PROP_NAME_TO_ID.put(PROP_NAME_formCustom, PROP_ID_formCustom);
      
          PROP_ID_TO_NAME[PROP_ID_formPath] = PROP_NAME_formPath;
          PROP_NAME_TO_ID.put(PROP_NAME_formPath, PROP_ID_formPath);
      
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
    
    /* 对应flow_definition表的id: DEFINITION_ID */
    private java.lang.Long _definitionId;
    
    /* 对应flow_instance表的id: INSTANCE_ID */
    private java.lang.Long _instanceId;
    
    /* 节点编码: NODE_CODE */
    private java.lang.String _nodeCode;
    
    /* 节点名称: NODE_NAME */
    private java.lang.String _nodeName;
    
    /* 节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NODE_TYPE */
    private java.lang.Boolean _nodeType;
    
    /* 流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）: FLOW_STATUS */
    private java.lang.String _flowStatus;
    
    /* 审批表单是否自定义（Y是 N否）: FORM_CUSTOM */
    private java.lang.String _formCustom;
    
    /* 审批表单路径: FORM_PATH */
    private java.lang.String _formPath;
    
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
    

    public _FlowTask(){
        // for debug
    }

    protected FlowTask newInstance(){
        FlowTask entity = new FlowTask();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public FlowTask cloneInstance() {
        FlowTask entity = newInstance();
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
      return "com.fliad.workflow.dao.entity.FlowTask";
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
        
            case PROP_ID_instanceId:
               return getInstanceId();
        
            case PROP_ID_nodeCode:
               return getNodeCode();
        
            case PROP_ID_nodeName:
               return getNodeName();
        
            case PROP_ID_nodeType:
               return getNodeType();
        
            case PROP_ID_flowStatus:
               return getFlowStatus();
        
            case PROP_ID_formCustom:
               return getFormCustom();
        
            case PROP_ID_formPath:
               return getFormPath();
        
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
        
            case PROP_ID_instanceId:{
               java.lang.Long typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLong(value,
                       err-> newTypeConversionError(PROP_NAME_instanceId));
               }
               setInstanceId(typedValue);
               break;
            }
        
            case PROP_ID_nodeCode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_nodeCode));
               }
               setNodeCode(typedValue);
               break;
            }
        
            case PROP_ID_nodeName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_nodeName));
               }
               setNodeName(typedValue);
               break;
            }
        
            case PROP_ID_nodeType:{
               java.lang.Boolean typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toBoolean(value,
                       err-> newTypeConversionError(PROP_NAME_nodeType));
               }
               setNodeType(typedValue);
               break;
            }
        
            case PROP_ID_flowStatus:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_flowStatus));
               }
               setFlowStatus(typedValue);
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
        
            case PROP_ID_instanceId:{
               onInitProp(propId);
               this._instanceId = (java.lang.Long)value;
               
               break;
            }
        
            case PROP_ID_nodeCode:{
               onInitProp(propId);
               this._nodeCode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_nodeName:{
               onInitProp(propId);
               this._nodeName = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_nodeType:{
               onInitProp(propId);
               this._nodeType = (java.lang.Boolean)value;
               
               break;
            }
        
            case PROP_ID_flowStatus:{
               onInitProp(propId);
               this._flowStatus = (java.lang.String)value;
               
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
     * 对应flow_definition表的id: DEFINITION_ID
     */
    public final java.lang.Long getDefinitionId(){
         onPropGet(PROP_ID_definitionId);
         return _definitionId;
    }

    /**
     * 对应flow_definition表的id: DEFINITION_ID
     */
    public final void setDefinitionId(java.lang.Long value){
        if(onPropSet(PROP_ID_definitionId,value)){
            this._definitionId = value;
            internalClearRefs(PROP_ID_definitionId);
            
        }
    }
    
    /**
     * 对应flow_instance表的id: INSTANCE_ID
     */
    public final java.lang.Long getInstanceId(){
         onPropGet(PROP_ID_instanceId);
         return _instanceId;
    }

    /**
     * 对应flow_instance表的id: INSTANCE_ID
     */
    public final void setInstanceId(java.lang.Long value){
        if(onPropSet(PROP_ID_instanceId,value)){
            this._instanceId = value;
            internalClearRefs(PROP_ID_instanceId);
            
        }
    }
    
    /**
     * 节点编码: NODE_CODE
     */
    public final java.lang.String getNodeCode(){
         onPropGet(PROP_ID_nodeCode);
         return _nodeCode;
    }

    /**
     * 节点编码: NODE_CODE
     */
    public final void setNodeCode(java.lang.String value){
        if(onPropSet(PROP_ID_nodeCode,value)){
            this._nodeCode = value;
            internalClearRefs(PROP_ID_nodeCode);
            
        }
    }
    
    /**
     * 节点名称: NODE_NAME
     */
    public final java.lang.String getNodeName(){
         onPropGet(PROP_ID_nodeName);
         return _nodeName;
    }

    /**
     * 节点名称: NODE_NAME
     */
    public final void setNodeName(java.lang.String value){
        if(onPropSet(PROP_ID_nodeName,value)){
            this._nodeName = value;
            internalClearRefs(PROP_ID_nodeName);
            
        }
    }
    
    /**
     * 节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NODE_TYPE
     */
    public final java.lang.Boolean getNodeType(){
         onPropGet(PROP_ID_nodeType);
         return _nodeType;
    }

    /**
     * 节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NODE_TYPE
     */
    public final void setNodeType(java.lang.Boolean value){
        if(onPropSet(PROP_ID_nodeType,value)){
            this._nodeType = value;
            internalClearRefs(PROP_ID_nodeType);
            
        }
    }
    
    /**
     * 流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）: FLOW_STATUS
     */
    public final java.lang.String getFlowStatus(){
         onPropGet(PROP_ID_flowStatus);
         return _flowStatus;
    }

    /**
     * 流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）: FLOW_STATUS
     */
    public final void setFlowStatus(java.lang.String value){
        if(onPropSet(PROP_ID_flowStatus,value)){
            this._flowStatus = value;
            internalClearRefs(PROP_ID_flowStatus);
            
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

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

import com.fliad.workflow.dao.entity.FlowHisTask;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  历史任务记录表: flow_his_task
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _FlowHisTask extends DynamicOrmEntity{
    
    /* 主键id: ID BIGINT */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 对应flow_definition表的id: DEFINITION_ID BIGINT */
    public static final String PROP_NAME_definitionId = "definitionId";
    public static final int PROP_ID_definitionId = 2;
    
    /* 对应flow_instance表的id: INSTANCE_ID BIGINT */
    public static final String PROP_NAME_instanceId = "instanceId";
    public static final int PROP_ID_instanceId = 3;
    
    /* 对应flow_task表的id: TASK_ID BIGINT */
    public static final String PROP_NAME_taskId = "taskId";
    public static final int PROP_ID_taskId = 4;
    
    /* 开始节点编码: NODE_CODE VARCHAR */
    public static final String PROP_NAME_nodeCode = "nodeCode";
    public static final int PROP_ID_nodeCode = 5;
    
    /* 开始节点名称: NODE_NAME VARCHAR */
    public static final String PROP_NAME_nodeName = "nodeName";
    public static final int PROP_ID_nodeName = 6;
    
    /* 开始节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NODE_TYPE BOOLEAN */
    public static final String PROP_NAME_nodeType = "nodeType";
    public static final int PROP_ID_nodeType = 7;
    
    /* 目标节点编码: TARGET_NODE_CODE VARCHAR */
    public static final String PROP_NAME_targetNodeCode = "targetNodeCode";
    public static final int PROP_ID_targetNodeCode = 8;
    
    /* 结束节点名称: TARGET_NODE_NAME VARCHAR */
    public static final String PROP_NAME_targetNodeName = "targetNodeName";
    public static final int PROP_ID_targetNodeName = 9;
    
    /* 审批人: APPROVER VARCHAR */
    public static final String PROP_NAME_approver = "approver";
    public static final int PROP_ID_approver = 10;
    
    /* 协作方式(1审批 2转办 3委派 4会签 5票签 6加签 7减签): COOPERATE_TYPE BOOLEAN */
    public static final String PROP_NAME_cooperateType = "cooperateType";
    public static final int PROP_ID_cooperateType = 11;
    
    /* 协作人: COLLABORATOR VARCHAR */
    public static final String PROP_NAME_collaborator = "collaborator";
    public static final int PROP_ID_collaborator = 12;
    
    /* 流转类型（PASS通过 REJECT退回 NONE无动作）: SKIP_TYPE VARCHAR */
    public static final String PROP_NAME_skipType = "skipType";
    public static final int PROP_ID_skipType = 13;
    
    /* 流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）: FLOW_STATUS VARCHAR */
    public static final String PROP_NAME_flowStatus = "flowStatus";
    public static final int PROP_ID_flowStatus = 14;
    
    /* 审批表单是否自定义（Y是 N否）: FORM_CUSTOM CHAR */
    public static final String PROP_NAME_formCustom = "formCustom";
    public static final int PROP_ID_formCustom = 15;
    
    /* 审批表单路径: FORM_PATH VARCHAR */
    public static final String PROP_NAME_formPath = "formPath";
    public static final int PROP_ID_formPath = 16;
    
    /* 审批意见: MESSAGE VARCHAR */
    public static final String PROP_NAME_message = "message";
    public static final int PROP_ID_message = 17;
    
    /* 任务变量: VARIABLE VARCHAR */
    public static final String PROP_NAME_variable = "variable";
    public static final int PROP_ID_variable = 18;
    
    /* 业务详情 存业务表对象json字符串: EXT VARCHAR */
    public static final String PROP_NAME_ext = "ext";
    public static final int PROP_ID_ext = 19;
    
    /* 任务开始时间: CREATE_TIME DATETIME */
    public static final String PROP_NAME_createTime = "createTime";
    public static final int PROP_ID_createTime = 20;
    
    /* 审批完成时间: UPDATE_TIME DATETIME */
    public static final String PROP_NAME_updateTime = "updateTime";
    public static final int PROP_ID_updateTime = 21;
    
    /* 删除标志: DEL_FLAG CHAR */
    public static final String PROP_NAME_delFlag = "delFlag";
    public static final int PROP_ID_delFlag = 22;
    
    /* 租户id: TENANT_ID VARCHAR */
    public static final String PROP_NAME_tenantId = "tenantId";
    public static final int PROP_ID_tenantId = 23;
    

    private static int _PROP_ID_BOUND = 24;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[24];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_definitionId] = PROP_NAME_definitionId;
          PROP_NAME_TO_ID.put(PROP_NAME_definitionId, PROP_ID_definitionId);
      
          PROP_ID_TO_NAME[PROP_ID_instanceId] = PROP_NAME_instanceId;
          PROP_NAME_TO_ID.put(PROP_NAME_instanceId, PROP_ID_instanceId);
      
          PROP_ID_TO_NAME[PROP_ID_taskId] = PROP_NAME_taskId;
          PROP_NAME_TO_ID.put(PROP_NAME_taskId, PROP_ID_taskId);
      
          PROP_ID_TO_NAME[PROP_ID_nodeCode] = PROP_NAME_nodeCode;
          PROP_NAME_TO_ID.put(PROP_NAME_nodeCode, PROP_ID_nodeCode);
      
          PROP_ID_TO_NAME[PROP_ID_nodeName] = PROP_NAME_nodeName;
          PROP_NAME_TO_ID.put(PROP_NAME_nodeName, PROP_ID_nodeName);
      
          PROP_ID_TO_NAME[PROP_ID_nodeType] = PROP_NAME_nodeType;
          PROP_NAME_TO_ID.put(PROP_NAME_nodeType, PROP_ID_nodeType);
      
          PROP_ID_TO_NAME[PROP_ID_targetNodeCode] = PROP_NAME_targetNodeCode;
          PROP_NAME_TO_ID.put(PROP_NAME_targetNodeCode, PROP_ID_targetNodeCode);
      
          PROP_ID_TO_NAME[PROP_ID_targetNodeName] = PROP_NAME_targetNodeName;
          PROP_NAME_TO_ID.put(PROP_NAME_targetNodeName, PROP_ID_targetNodeName);
      
          PROP_ID_TO_NAME[PROP_ID_approver] = PROP_NAME_approver;
          PROP_NAME_TO_ID.put(PROP_NAME_approver, PROP_ID_approver);
      
          PROP_ID_TO_NAME[PROP_ID_cooperateType] = PROP_NAME_cooperateType;
          PROP_NAME_TO_ID.put(PROP_NAME_cooperateType, PROP_ID_cooperateType);
      
          PROP_ID_TO_NAME[PROP_ID_collaborator] = PROP_NAME_collaborator;
          PROP_NAME_TO_ID.put(PROP_NAME_collaborator, PROP_ID_collaborator);
      
          PROP_ID_TO_NAME[PROP_ID_skipType] = PROP_NAME_skipType;
          PROP_NAME_TO_ID.put(PROP_NAME_skipType, PROP_ID_skipType);
      
          PROP_ID_TO_NAME[PROP_ID_flowStatus] = PROP_NAME_flowStatus;
          PROP_NAME_TO_ID.put(PROP_NAME_flowStatus, PROP_ID_flowStatus);
      
          PROP_ID_TO_NAME[PROP_ID_formCustom] = PROP_NAME_formCustom;
          PROP_NAME_TO_ID.put(PROP_NAME_formCustom, PROP_ID_formCustom);
      
          PROP_ID_TO_NAME[PROP_ID_formPath] = PROP_NAME_formPath;
          PROP_NAME_TO_ID.put(PROP_NAME_formPath, PROP_ID_formPath);
      
          PROP_ID_TO_NAME[PROP_ID_message] = PROP_NAME_message;
          PROP_NAME_TO_ID.put(PROP_NAME_message, PROP_ID_message);
      
          PROP_ID_TO_NAME[PROP_ID_variable] = PROP_NAME_variable;
          PROP_NAME_TO_ID.put(PROP_NAME_variable, PROP_ID_variable);
      
          PROP_ID_TO_NAME[PROP_ID_ext] = PROP_NAME_ext;
          PROP_NAME_TO_ID.put(PROP_NAME_ext, PROP_ID_ext);
      
          PROP_ID_TO_NAME[PROP_ID_createTime] = PROP_NAME_createTime;
          PROP_NAME_TO_ID.put(PROP_NAME_createTime, PROP_ID_createTime);
      
          PROP_ID_TO_NAME[PROP_ID_updateTime] = PROP_NAME_updateTime;
          PROP_NAME_TO_ID.put(PROP_NAME_updateTime, PROP_ID_updateTime);
      
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
    
    /* 对应flow_task表的id: TASK_ID */
    private java.lang.Long _taskId;
    
    /* 开始节点编码: NODE_CODE */
    private java.lang.String _nodeCode;
    
    /* 开始节点名称: NODE_NAME */
    private java.lang.String _nodeName;
    
    /* 开始节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NODE_TYPE */
    private java.lang.Boolean _nodeType;
    
    /* 目标节点编码: TARGET_NODE_CODE */
    private java.lang.String _targetNodeCode;
    
    /* 结束节点名称: TARGET_NODE_NAME */
    private java.lang.String _targetNodeName;
    
    /* 审批人: APPROVER */
    private java.lang.String _approver;
    
    /* 协作方式(1审批 2转办 3委派 4会签 5票签 6加签 7减签): COOPERATE_TYPE */
    private java.lang.Boolean _cooperateType;
    
    /* 协作人: COLLABORATOR */
    private java.lang.String _collaborator;
    
    /* 流转类型（PASS通过 REJECT退回 NONE无动作）: SKIP_TYPE */
    private java.lang.String _skipType;
    
    /* 流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）: FLOW_STATUS */
    private java.lang.String _flowStatus;
    
    /* 审批表单是否自定义（Y是 N否）: FORM_CUSTOM */
    private java.lang.String _formCustom;
    
    /* 审批表单路径: FORM_PATH */
    private java.lang.String _formPath;
    
    /* 审批意见: MESSAGE */
    private java.lang.String _message;
    
    /* 任务变量: VARIABLE */
    private java.lang.String _variable;
    
    /* 业务详情 存业务表对象json字符串: EXT */
    private java.lang.String _ext;
    
    /* 任务开始时间: CREATE_TIME */
    private java.time.LocalDateTime _createTime;
    
    /* 审批完成时间: UPDATE_TIME */
    private java.time.LocalDateTime _updateTime;
    
    /* 删除标志: DEL_FLAG */
    private java.lang.String _delFlag;
    
    /* 租户id: TENANT_ID */
    private java.lang.String _tenantId;
    

    public _FlowHisTask(){
        // for debug
    }

    protected FlowHisTask newInstance(){
        FlowHisTask entity = new FlowHisTask();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public FlowHisTask cloneInstance() {
        FlowHisTask entity = newInstance();
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
      return "com.fliad.workflow.dao.entity.FlowHisTask";
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
        
            case PROP_ID_taskId:
               return getTaskId();
        
            case PROP_ID_nodeCode:
               return getNodeCode();
        
            case PROP_ID_nodeName:
               return getNodeName();
        
            case PROP_ID_nodeType:
               return getNodeType();
        
            case PROP_ID_targetNodeCode:
               return getTargetNodeCode();
        
            case PROP_ID_targetNodeName:
               return getTargetNodeName();
        
            case PROP_ID_approver:
               return getApprover();
        
            case PROP_ID_cooperateType:
               return getCooperateType();
        
            case PROP_ID_collaborator:
               return getCollaborator();
        
            case PROP_ID_skipType:
               return getSkipType();
        
            case PROP_ID_flowStatus:
               return getFlowStatus();
        
            case PROP_ID_formCustom:
               return getFormCustom();
        
            case PROP_ID_formPath:
               return getFormPath();
        
            case PROP_ID_message:
               return getMessage();
        
            case PROP_ID_variable:
               return getVariable();
        
            case PROP_ID_ext:
               return getExt();
        
            case PROP_ID_createTime:
               return getCreateTime();
        
            case PROP_ID_updateTime:
               return getUpdateTime();
        
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
        
            case PROP_ID_taskId:{
               java.lang.Long typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLong(value,
                       err-> newTypeConversionError(PROP_NAME_taskId));
               }
               setTaskId(typedValue);
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
        
            case PROP_ID_targetNodeCode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_targetNodeCode));
               }
               setTargetNodeCode(typedValue);
               break;
            }
        
            case PROP_ID_targetNodeName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_targetNodeName));
               }
               setTargetNodeName(typedValue);
               break;
            }
        
            case PROP_ID_approver:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_approver));
               }
               setApprover(typedValue);
               break;
            }
        
            case PROP_ID_cooperateType:{
               java.lang.Boolean typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toBoolean(value,
                       err-> newTypeConversionError(PROP_NAME_cooperateType));
               }
               setCooperateType(typedValue);
               break;
            }
        
            case PROP_ID_collaborator:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_collaborator));
               }
               setCollaborator(typedValue);
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
        
            case PROP_ID_message:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_message));
               }
               setMessage(typedValue);
               break;
            }
        
            case PROP_ID_variable:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_variable));
               }
               setVariable(typedValue);
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
        
            case PROP_ID_updateTime:{
               java.time.LocalDateTime typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLocalDateTime(value,
                       err-> newTypeConversionError(PROP_NAME_updateTime));
               }
               setUpdateTime(typedValue);
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
        
            case PROP_ID_taskId:{
               onInitProp(propId);
               this._taskId = (java.lang.Long)value;
               
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
        
            case PROP_ID_targetNodeCode:{
               onInitProp(propId);
               this._targetNodeCode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_targetNodeName:{
               onInitProp(propId);
               this._targetNodeName = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_approver:{
               onInitProp(propId);
               this._approver = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_cooperateType:{
               onInitProp(propId);
               this._cooperateType = (java.lang.Boolean)value;
               
               break;
            }
        
            case PROP_ID_collaborator:{
               onInitProp(propId);
               this._collaborator = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_skipType:{
               onInitProp(propId);
               this._skipType = (java.lang.String)value;
               
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
        
            case PROP_ID_message:{
               onInitProp(propId);
               this._message = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_variable:{
               onInitProp(propId);
               this._variable = (java.lang.String)value;
               
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
        
            case PROP_ID_updateTime:{
               onInitProp(propId);
               this._updateTime = (java.time.LocalDateTime)value;
               
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
     * 对应flow_task表的id: TASK_ID
     */
    public final java.lang.Long getTaskId(){
         onPropGet(PROP_ID_taskId);
         return _taskId;
    }

    /**
     * 对应flow_task表的id: TASK_ID
     */
    public final void setTaskId(java.lang.Long value){
        if(onPropSet(PROP_ID_taskId,value)){
            this._taskId = value;
            internalClearRefs(PROP_ID_taskId);
            
        }
    }
    
    /**
     * 开始节点编码: NODE_CODE
     */
    public final java.lang.String getNodeCode(){
         onPropGet(PROP_ID_nodeCode);
         return _nodeCode;
    }

    /**
     * 开始节点编码: NODE_CODE
     */
    public final void setNodeCode(java.lang.String value){
        if(onPropSet(PROP_ID_nodeCode,value)){
            this._nodeCode = value;
            internalClearRefs(PROP_ID_nodeCode);
            
        }
    }
    
    /**
     * 开始节点名称: NODE_NAME
     */
    public final java.lang.String getNodeName(){
         onPropGet(PROP_ID_nodeName);
         return _nodeName;
    }

    /**
     * 开始节点名称: NODE_NAME
     */
    public final void setNodeName(java.lang.String value){
        if(onPropSet(PROP_ID_nodeName,value)){
            this._nodeName = value;
            internalClearRefs(PROP_ID_nodeName);
            
        }
    }
    
    /**
     * 开始节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NODE_TYPE
     */
    public final java.lang.Boolean getNodeType(){
         onPropGet(PROP_ID_nodeType);
         return _nodeType;
    }

    /**
     * 开始节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）: NODE_TYPE
     */
    public final void setNodeType(java.lang.Boolean value){
        if(onPropSet(PROP_ID_nodeType,value)){
            this._nodeType = value;
            internalClearRefs(PROP_ID_nodeType);
            
        }
    }
    
    /**
     * 目标节点编码: TARGET_NODE_CODE
     */
    public final java.lang.String getTargetNodeCode(){
         onPropGet(PROP_ID_targetNodeCode);
         return _targetNodeCode;
    }

    /**
     * 目标节点编码: TARGET_NODE_CODE
     */
    public final void setTargetNodeCode(java.lang.String value){
        if(onPropSet(PROP_ID_targetNodeCode,value)){
            this._targetNodeCode = value;
            internalClearRefs(PROP_ID_targetNodeCode);
            
        }
    }
    
    /**
     * 结束节点名称: TARGET_NODE_NAME
     */
    public final java.lang.String getTargetNodeName(){
         onPropGet(PROP_ID_targetNodeName);
         return _targetNodeName;
    }

    /**
     * 结束节点名称: TARGET_NODE_NAME
     */
    public final void setTargetNodeName(java.lang.String value){
        if(onPropSet(PROP_ID_targetNodeName,value)){
            this._targetNodeName = value;
            internalClearRefs(PROP_ID_targetNodeName);
            
        }
    }
    
    /**
     * 审批人: APPROVER
     */
    public final java.lang.String getApprover(){
         onPropGet(PROP_ID_approver);
         return _approver;
    }

    /**
     * 审批人: APPROVER
     */
    public final void setApprover(java.lang.String value){
        if(onPropSet(PROP_ID_approver,value)){
            this._approver = value;
            internalClearRefs(PROP_ID_approver);
            
        }
    }
    
    /**
     * 协作方式(1审批 2转办 3委派 4会签 5票签 6加签 7减签): COOPERATE_TYPE
     */
    public final java.lang.Boolean getCooperateType(){
         onPropGet(PROP_ID_cooperateType);
         return _cooperateType;
    }

    /**
     * 协作方式(1审批 2转办 3委派 4会签 5票签 6加签 7减签): COOPERATE_TYPE
     */
    public final void setCooperateType(java.lang.Boolean value){
        if(onPropSet(PROP_ID_cooperateType,value)){
            this._cooperateType = value;
            internalClearRefs(PROP_ID_cooperateType);
            
        }
    }
    
    /**
     * 协作人: COLLABORATOR
     */
    public final java.lang.String getCollaborator(){
         onPropGet(PROP_ID_collaborator);
         return _collaborator;
    }

    /**
     * 协作人: COLLABORATOR
     */
    public final void setCollaborator(java.lang.String value){
        if(onPropSet(PROP_ID_collaborator,value)){
            this._collaborator = value;
            internalClearRefs(PROP_ID_collaborator);
            
        }
    }
    
    /**
     * 流转类型（PASS通过 REJECT退回 NONE无动作）: SKIP_TYPE
     */
    public final java.lang.String getSkipType(){
         onPropGet(PROP_ID_skipType);
         return _skipType;
    }

    /**
     * 流转类型（PASS通过 REJECT退回 NONE无动作）: SKIP_TYPE
     */
    public final void setSkipType(java.lang.String value){
        if(onPropSet(PROP_ID_skipType,value)){
            this._skipType = value;
            internalClearRefs(PROP_ID_skipType);
            
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
     * 审批意见: MESSAGE
     */
    public final java.lang.String getMessage(){
         onPropGet(PROP_ID_message);
         return _message;
    }

    /**
     * 审批意见: MESSAGE
     */
    public final void setMessage(java.lang.String value){
        if(onPropSet(PROP_ID_message,value)){
            this._message = value;
            internalClearRefs(PROP_ID_message);
            
        }
    }
    
    /**
     * 任务变量: VARIABLE
     */
    public final java.lang.String getVariable(){
         onPropGet(PROP_ID_variable);
         return _variable;
    }

    /**
     * 任务变量: VARIABLE
     */
    public final void setVariable(java.lang.String value){
        if(onPropSet(PROP_ID_variable,value)){
            this._variable = value;
            internalClearRefs(PROP_ID_variable);
            
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
     * 任务开始时间: CREATE_TIME
     */
    public final java.time.LocalDateTime getCreateTime(){
         onPropGet(PROP_ID_createTime);
         return _createTime;
    }

    /**
     * 任务开始时间: CREATE_TIME
     */
    public final void setCreateTime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_createTime,value)){
            this._createTime = value;
            internalClearRefs(PROP_ID_createTime);
            
        }
    }
    
    /**
     * 审批完成时间: UPDATE_TIME
     */
    public final java.time.LocalDateTime getUpdateTime(){
         onPropGet(PROP_ID_updateTime);
         return _updateTime;
    }

    /**
     * 审批完成时间: UPDATE_TIME
     */
    public final void setUpdateTime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_updateTime,value)){
            this._updateTime = value;
            internalClearRefs(PROP_ID_updateTime);
            
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

package com.fliad.dev.dao.entity._gen;

import io.nop.orm.model.IEntityModel;
import io.nop.orm.support.DynamicOrmEntity;
import io.nop.orm.support.OrmEntitySet; //NOPMD - suppressed UnusedImports - Auto Gen Code
import io.nop.orm.IOrmEntitySet; //NOPMD - suppressed UnusedImports - Auto Gen Code
import io.nop.api.core.convert.ConvertHelper;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

import com.fliad.dev.dao.entity.DevLog;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  日志: DEV_LOG
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _DevLog extends DynamicOrmEntity{
    
    /* 主键: ID VARCHAR */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 日志分类: CATEGORY VARCHAR */
    public static final String PROP_NAME_category = "category";
    public static final int PROP_ID_category = 2;
    
    /* 日志名称: NAME VARCHAR */
    public static final String PROP_NAME_name = "name";
    public static final int PROP_ID_name = 3;
    
    /* 执行状态: EXE_STATUS VARCHAR */
    public static final String PROP_NAME_exeStatus = "exeStatus";
    public static final int PROP_ID_exeStatus = 4;
    
    /* 具体消息: EXE_MESSAGE CLOB */
    public static final String PROP_NAME_exeMessage = "exeMessage";
    public static final int PROP_ID_exeMessage = 5;
    
    /* 操作ip: OP_IP VARCHAR */
    public static final String PROP_NAME_opIp = "opIp";
    public static final int PROP_ID_opIp = 6;
    
    /* 操作地址: OP_ADDRESS VARCHAR */
    public static final String PROP_NAME_opAddress = "opAddress";
    public static final int PROP_ID_opAddress = 7;
    
    /* 操作浏览器: OP_BROWSER VARCHAR */
    public static final String PROP_NAME_opBrowser = "opBrowser";
    public static final int PROP_ID_opBrowser = 8;
    
    /* 操作系统: OP_OS VARCHAR */
    public static final String PROP_NAME_opOs = "opOs";
    public static final int PROP_ID_opOs = 9;
    
    /* 类名称: CLASS_NAME VARCHAR */
    public static final String PROP_NAME_className = "className";
    public static final int PROP_ID_className = 10;
    
    /* 方法名称: METHOD_NAME VARCHAR */
    public static final String PROP_NAME_methodName = "methodName";
    public static final int PROP_ID_methodName = 11;
    
    /* 请求方式: REQ_METHOD VARCHAR */
    public static final String PROP_NAME_reqMethod = "reqMethod";
    public static final int PROP_ID_reqMethod = 12;
    
    /* 请求地址: REQ_URL CLOB */
    public static final String PROP_NAME_reqUrl = "reqUrl";
    public static final int PROP_ID_reqUrl = 13;
    
    /* 请求参数: PARAM_JSON CLOB */
    public static final String PROP_NAME_paramJson = "paramJson";
    public static final int PROP_ID_paramJson = 14;
    
    /* 返回结果: RESULT_JSON CLOB */
    public static final String PROP_NAME_resultJson = "resultJson";
    public static final int PROP_ID_resultJson = 15;
    
    /* 操作时间: OP_TIME DATETIME */
    public static final String PROP_NAME_opTime = "opTime";
    public static final int PROP_ID_opTime = 16;
    
    /* 操作人姓名: OP_USER VARCHAR */
    public static final String PROP_NAME_opUser = "opUser";
    public static final int PROP_ID_opUser = 17;
    
    /* 签名数据: SIGN_DATA CLOB */
    public static final String PROP_NAME_signData = "signData";
    public static final int PROP_ID_signData = 18;
    
    /* 创建时间: CREATE_TIME DATETIME */
    public static final String PROP_NAME_createTime = "createTime";
    public static final int PROP_ID_createTime = 19;
    
    /* 创建用户: CREATE_USER VARCHAR */
    public static final String PROP_NAME_createUser = "createUser";
    public static final int PROP_ID_createUser = 20;
    
    /* 修改时间: UPDATE_TIME DATETIME */
    public static final String PROP_NAME_updateTime = "updateTime";
    public static final int PROP_ID_updateTime = 21;
    
    /* 修改用户: UPDATE_USER VARCHAR */
    public static final String PROP_NAME_updateUser = "updateUser";
    public static final int PROP_ID_updateUser = 22;
    

    private static int _PROP_ID_BOUND = 23;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[23];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_category] = PROP_NAME_category;
          PROP_NAME_TO_ID.put(PROP_NAME_category, PROP_ID_category);
      
          PROP_ID_TO_NAME[PROP_ID_name] = PROP_NAME_name;
          PROP_NAME_TO_ID.put(PROP_NAME_name, PROP_ID_name);
      
          PROP_ID_TO_NAME[PROP_ID_exeStatus] = PROP_NAME_exeStatus;
          PROP_NAME_TO_ID.put(PROP_NAME_exeStatus, PROP_ID_exeStatus);
      
          PROP_ID_TO_NAME[PROP_ID_exeMessage] = PROP_NAME_exeMessage;
          PROP_NAME_TO_ID.put(PROP_NAME_exeMessage, PROP_ID_exeMessage);
      
          PROP_ID_TO_NAME[PROP_ID_opIp] = PROP_NAME_opIp;
          PROP_NAME_TO_ID.put(PROP_NAME_opIp, PROP_ID_opIp);
      
          PROP_ID_TO_NAME[PROP_ID_opAddress] = PROP_NAME_opAddress;
          PROP_NAME_TO_ID.put(PROP_NAME_opAddress, PROP_ID_opAddress);
      
          PROP_ID_TO_NAME[PROP_ID_opBrowser] = PROP_NAME_opBrowser;
          PROP_NAME_TO_ID.put(PROP_NAME_opBrowser, PROP_ID_opBrowser);
      
          PROP_ID_TO_NAME[PROP_ID_opOs] = PROP_NAME_opOs;
          PROP_NAME_TO_ID.put(PROP_NAME_opOs, PROP_ID_opOs);
      
          PROP_ID_TO_NAME[PROP_ID_className] = PROP_NAME_className;
          PROP_NAME_TO_ID.put(PROP_NAME_className, PROP_ID_className);
      
          PROP_ID_TO_NAME[PROP_ID_methodName] = PROP_NAME_methodName;
          PROP_NAME_TO_ID.put(PROP_NAME_methodName, PROP_ID_methodName);
      
          PROP_ID_TO_NAME[PROP_ID_reqMethod] = PROP_NAME_reqMethod;
          PROP_NAME_TO_ID.put(PROP_NAME_reqMethod, PROP_ID_reqMethod);
      
          PROP_ID_TO_NAME[PROP_ID_reqUrl] = PROP_NAME_reqUrl;
          PROP_NAME_TO_ID.put(PROP_NAME_reqUrl, PROP_ID_reqUrl);
      
          PROP_ID_TO_NAME[PROP_ID_paramJson] = PROP_NAME_paramJson;
          PROP_NAME_TO_ID.put(PROP_NAME_paramJson, PROP_ID_paramJson);
      
          PROP_ID_TO_NAME[PROP_ID_resultJson] = PROP_NAME_resultJson;
          PROP_NAME_TO_ID.put(PROP_NAME_resultJson, PROP_ID_resultJson);
      
          PROP_ID_TO_NAME[PROP_ID_opTime] = PROP_NAME_opTime;
          PROP_NAME_TO_ID.put(PROP_NAME_opTime, PROP_ID_opTime);
      
          PROP_ID_TO_NAME[PROP_ID_opUser] = PROP_NAME_opUser;
          PROP_NAME_TO_ID.put(PROP_NAME_opUser, PROP_ID_opUser);
      
          PROP_ID_TO_NAME[PROP_ID_signData] = PROP_NAME_signData;
          PROP_NAME_TO_ID.put(PROP_NAME_signData, PROP_ID_signData);
      
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
    
    /* 日志分类: CATEGORY */
    private java.lang.String _category;
    
    /* 日志名称: NAME */
    private java.lang.String _name;
    
    /* 执行状态: EXE_STATUS */
    private java.lang.String _exeStatus;
    
    /* 具体消息: EXE_MESSAGE */
    private java.lang.String _exeMessage;
    
    /* 操作ip: OP_IP */
    private java.lang.String _opIp;
    
    /* 操作地址: OP_ADDRESS */
    private java.lang.String _opAddress;
    
    /* 操作浏览器: OP_BROWSER */
    private java.lang.String _opBrowser;
    
    /* 操作系统: OP_OS */
    private java.lang.String _opOs;
    
    /* 类名称: CLASS_NAME */
    private java.lang.String _className;
    
    /* 方法名称: METHOD_NAME */
    private java.lang.String _methodName;
    
    /* 请求方式: REQ_METHOD */
    private java.lang.String _reqMethod;
    
    /* 请求地址: REQ_URL */
    private java.lang.String _reqUrl;
    
    /* 请求参数: PARAM_JSON */
    private java.lang.String _paramJson;
    
    /* 返回结果: RESULT_JSON */
    private java.lang.String _resultJson;
    
    /* 操作时间: OP_TIME */
    private java.time.LocalDateTime _opTime;
    
    /* 操作人姓名: OP_USER */
    private java.lang.String _opUser;
    
    /* 签名数据: SIGN_DATA */
    private java.lang.String _signData;
    
    /* 创建时间: CREATE_TIME */
    private java.time.LocalDateTime _createTime;
    
    /* 创建用户: CREATE_USER */
    private java.lang.String _createUser;
    
    /* 修改时间: UPDATE_TIME */
    private java.time.LocalDateTime _updateTime;
    
    /* 修改用户: UPDATE_USER */
    private java.lang.String _updateUser;
    

    public _DevLog(){
        // for debug
    }

    protected DevLog newInstance(){
        DevLog entity = new DevLog();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public DevLog cloneInstance() {
        DevLog entity = newInstance();
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
      return "com.fliad.dev.dao.entity.DevLog";
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
        
            case PROP_ID_category:
               return getCategory();
        
            case PROP_ID_name:
               return getName();
        
            case PROP_ID_exeStatus:
               return getExeStatus();
        
            case PROP_ID_exeMessage:
               return getExeMessage();
        
            case PROP_ID_opIp:
               return getOpIp();
        
            case PROP_ID_opAddress:
               return getOpAddress();
        
            case PROP_ID_opBrowser:
               return getOpBrowser();
        
            case PROP_ID_opOs:
               return getOpOs();
        
            case PROP_ID_className:
               return getClassName();
        
            case PROP_ID_methodName:
               return getMethodName();
        
            case PROP_ID_reqMethod:
               return getReqMethod();
        
            case PROP_ID_reqUrl:
               return getReqUrl();
        
            case PROP_ID_paramJson:
               return getParamJson();
        
            case PROP_ID_resultJson:
               return getResultJson();
        
            case PROP_ID_opTime:
               return getOpTime();
        
            case PROP_ID_opUser:
               return getOpUser();
        
            case PROP_ID_signData:
               return getSignData();
        
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
        
            case PROP_ID_category:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_category));
               }
               setCategory(typedValue);
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
        
            case PROP_ID_exeStatus:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_exeStatus));
               }
               setExeStatus(typedValue);
               break;
            }
        
            case PROP_ID_exeMessage:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_exeMessage));
               }
               setExeMessage(typedValue);
               break;
            }
        
            case PROP_ID_opIp:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_opIp));
               }
               setOpIp(typedValue);
               break;
            }
        
            case PROP_ID_opAddress:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_opAddress));
               }
               setOpAddress(typedValue);
               break;
            }
        
            case PROP_ID_opBrowser:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_opBrowser));
               }
               setOpBrowser(typedValue);
               break;
            }
        
            case PROP_ID_opOs:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_opOs));
               }
               setOpOs(typedValue);
               break;
            }
        
            case PROP_ID_className:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_className));
               }
               setClassName(typedValue);
               break;
            }
        
            case PROP_ID_methodName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_methodName));
               }
               setMethodName(typedValue);
               break;
            }
        
            case PROP_ID_reqMethod:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_reqMethod));
               }
               setReqMethod(typedValue);
               break;
            }
        
            case PROP_ID_reqUrl:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_reqUrl));
               }
               setReqUrl(typedValue);
               break;
            }
        
            case PROP_ID_paramJson:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_paramJson));
               }
               setParamJson(typedValue);
               break;
            }
        
            case PROP_ID_resultJson:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_resultJson));
               }
               setResultJson(typedValue);
               break;
            }
        
            case PROP_ID_opTime:{
               java.time.LocalDateTime typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLocalDateTime(value,
                       err-> newTypeConversionError(PROP_NAME_opTime));
               }
               setOpTime(typedValue);
               break;
            }
        
            case PROP_ID_opUser:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_opUser));
               }
               setOpUser(typedValue);
               break;
            }
        
            case PROP_ID_signData:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_signData));
               }
               setSignData(typedValue);
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
        
            case PROP_ID_category:{
               onInitProp(propId);
               this._category = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_name:{
               onInitProp(propId);
               this._name = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_exeStatus:{
               onInitProp(propId);
               this._exeStatus = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_exeMessage:{
               onInitProp(propId);
               this._exeMessage = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_opIp:{
               onInitProp(propId);
               this._opIp = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_opAddress:{
               onInitProp(propId);
               this._opAddress = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_opBrowser:{
               onInitProp(propId);
               this._opBrowser = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_opOs:{
               onInitProp(propId);
               this._opOs = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_className:{
               onInitProp(propId);
               this._className = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_methodName:{
               onInitProp(propId);
               this._methodName = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_reqMethod:{
               onInitProp(propId);
               this._reqMethod = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_reqUrl:{
               onInitProp(propId);
               this._reqUrl = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_paramJson:{
               onInitProp(propId);
               this._paramJson = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_resultJson:{
               onInitProp(propId);
               this._resultJson = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_opTime:{
               onInitProp(propId);
               this._opTime = (java.time.LocalDateTime)value;
               
               break;
            }
        
            case PROP_ID_opUser:{
               onInitProp(propId);
               this._opUser = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_signData:{
               onInitProp(propId);
               this._signData = (java.lang.String)value;
               
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
     * 日志分类: CATEGORY
     */
    public final java.lang.String getCategory(){
         onPropGet(PROP_ID_category);
         return _category;
    }

    /**
     * 日志分类: CATEGORY
     */
    public final void setCategory(java.lang.String value){
        if(onPropSet(PROP_ID_category,value)){
            this._category = value;
            internalClearRefs(PROP_ID_category);
            
        }
    }
    
    /**
     * 日志名称: NAME
     */
    public final java.lang.String getName(){
         onPropGet(PROP_ID_name);
         return _name;
    }

    /**
     * 日志名称: NAME
     */
    public final void setName(java.lang.String value){
        if(onPropSet(PROP_ID_name,value)){
            this._name = value;
            internalClearRefs(PROP_ID_name);
            
        }
    }
    
    /**
     * 执行状态: EXE_STATUS
     */
    public final java.lang.String getExeStatus(){
         onPropGet(PROP_ID_exeStatus);
         return _exeStatus;
    }

    /**
     * 执行状态: EXE_STATUS
     */
    public final void setExeStatus(java.lang.String value){
        if(onPropSet(PROP_ID_exeStatus,value)){
            this._exeStatus = value;
            internalClearRefs(PROP_ID_exeStatus);
            
        }
    }
    
    /**
     * 具体消息: EXE_MESSAGE
     */
    public final java.lang.String getExeMessage(){
         onPropGet(PROP_ID_exeMessage);
         return _exeMessage;
    }

    /**
     * 具体消息: EXE_MESSAGE
     */
    public final void setExeMessage(java.lang.String value){
        if(onPropSet(PROP_ID_exeMessage,value)){
            this._exeMessage = value;
            internalClearRefs(PROP_ID_exeMessage);
            
        }
    }
    
    /**
     * 操作ip: OP_IP
     */
    public final java.lang.String getOpIp(){
         onPropGet(PROP_ID_opIp);
         return _opIp;
    }

    /**
     * 操作ip: OP_IP
     */
    public final void setOpIp(java.lang.String value){
        if(onPropSet(PROP_ID_opIp,value)){
            this._opIp = value;
            internalClearRefs(PROP_ID_opIp);
            
        }
    }
    
    /**
     * 操作地址: OP_ADDRESS
     */
    public final java.lang.String getOpAddress(){
         onPropGet(PROP_ID_opAddress);
         return _opAddress;
    }

    /**
     * 操作地址: OP_ADDRESS
     */
    public final void setOpAddress(java.lang.String value){
        if(onPropSet(PROP_ID_opAddress,value)){
            this._opAddress = value;
            internalClearRefs(PROP_ID_opAddress);
            
        }
    }
    
    /**
     * 操作浏览器: OP_BROWSER
     */
    public final java.lang.String getOpBrowser(){
         onPropGet(PROP_ID_opBrowser);
         return _opBrowser;
    }

    /**
     * 操作浏览器: OP_BROWSER
     */
    public final void setOpBrowser(java.lang.String value){
        if(onPropSet(PROP_ID_opBrowser,value)){
            this._opBrowser = value;
            internalClearRefs(PROP_ID_opBrowser);
            
        }
    }
    
    /**
     * 操作系统: OP_OS
     */
    public final java.lang.String getOpOs(){
         onPropGet(PROP_ID_opOs);
         return _opOs;
    }

    /**
     * 操作系统: OP_OS
     */
    public final void setOpOs(java.lang.String value){
        if(onPropSet(PROP_ID_opOs,value)){
            this._opOs = value;
            internalClearRefs(PROP_ID_opOs);
            
        }
    }
    
    /**
     * 类名称: CLASS_NAME
     */
    public final java.lang.String getClassName(){
         onPropGet(PROP_ID_className);
         return _className;
    }

    /**
     * 类名称: CLASS_NAME
     */
    public final void setClassName(java.lang.String value){
        if(onPropSet(PROP_ID_className,value)){
            this._className = value;
            internalClearRefs(PROP_ID_className);
            
        }
    }
    
    /**
     * 方法名称: METHOD_NAME
     */
    public final java.lang.String getMethodName(){
         onPropGet(PROP_ID_methodName);
         return _methodName;
    }

    /**
     * 方法名称: METHOD_NAME
     */
    public final void setMethodName(java.lang.String value){
        if(onPropSet(PROP_ID_methodName,value)){
            this._methodName = value;
            internalClearRefs(PROP_ID_methodName);
            
        }
    }
    
    /**
     * 请求方式: REQ_METHOD
     */
    public final java.lang.String getReqMethod(){
         onPropGet(PROP_ID_reqMethod);
         return _reqMethod;
    }

    /**
     * 请求方式: REQ_METHOD
     */
    public final void setReqMethod(java.lang.String value){
        if(onPropSet(PROP_ID_reqMethod,value)){
            this._reqMethod = value;
            internalClearRefs(PROP_ID_reqMethod);
            
        }
    }
    
    /**
     * 请求地址: REQ_URL
     */
    public final java.lang.String getReqUrl(){
         onPropGet(PROP_ID_reqUrl);
         return _reqUrl;
    }

    /**
     * 请求地址: REQ_URL
     */
    public final void setReqUrl(java.lang.String value){
        if(onPropSet(PROP_ID_reqUrl,value)){
            this._reqUrl = value;
            internalClearRefs(PROP_ID_reqUrl);
            
        }
    }
    
    /**
     * 请求参数: PARAM_JSON
     */
    public final java.lang.String getParamJson(){
         onPropGet(PROP_ID_paramJson);
         return _paramJson;
    }

    /**
     * 请求参数: PARAM_JSON
     */
    public final void setParamJson(java.lang.String value){
        if(onPropSet(PROP_ID_paramJson,value)){
            this._paramJson = value;
            internalClearRefs(PROP_ID_paramJson);
            
        }
    }
    
    /**
     * 返回结果: RESULT_JSON
     */
    public final java.lang.String getResultJson(){
         onPropGet(PROP_ID_resultJson);
         return _resultJson;
    }

    /**
     * 返回结果: RESULT_JSON
     */
    public final void setResultJson(java.lang.String value){
        if(onPropSet(PROP_ID_resultJson,value)){
            this._resultJson = value;
            internalClearRefs(PROP_ID_resultJson);
            
        }
    }
    
    /**
     * 操作时间: OP_TIME
     */
    public final java.time.LocalDateTime getOpTime(){
         onPropGet(PROP_ID_opTime);
         return _opTime;
    }

    /**
     * 操作时间: OP_TIME
     */
    public final void setOpTime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_opTime,value)){
            this._opTime = value;
            internalClearRefs(PROP_ID_opTime);
            
        }
    }
    
    /**
     * 操作人姓名: OP_USER
     */
    public final java.lang.String getOpUser(){
         onPropGet(PROP_ID_opUser);
         return _opUser;
    }

    /**
     * 操作人姓名: OP_USER
     */
    public final void setOpUser(java.lang.String value){
        if(onPropSet(PROP_ID_opUser,value)){
            this._opUser = value;
            internalClearRefs(PROP_ID_opUser);
            
        }
    }
    
    /**
     * 签名数据: SIGN_DATA
     */
    public final java.lang.String getSignData(){
         onPropGet(PROP_ID_signData);
         return _signData;
    }

    /**
     * 签名数据: SIGN_DATA
     */
    public final void setSignData(java.lang.String value){
        if(onPropSet(PROP_ID_signData,value)){
            this._signData = value;
            internalClearRefs(PROP_ID_signData);
            
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

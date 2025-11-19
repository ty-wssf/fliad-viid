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

import com.fliad.resource.dao.entity.DevSms;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  短信: dev_sms
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _DevSms extends DynamicOrmEntity{
    
    /* Id: ID VARCHAR */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 短信引擎: ENGINE VARCHAR */
    public static final String PROP_NAME_engine = "engine";
    public static final int PROP_ID_engine = 2;
    
    /* 手机号: PHONE_NUMBERS VARCHAR */
    public static final String PROP_NAME_phoneNumbers = "phoneNumbers";
    public static final int PROP_ID_phoneNumbers = 3;
    
    /* 短信签名: SIGN_NAME VARCHAR */
    public static final String PROP_NAME_signName = "signName";
    public static final int PROP_ID_signName = 4;
    
    /* 模板编码: TEMPLATE_CODE VARCHAR */
    public static final String PROP_NAME_templateCode = "templateCode";
    public static final int PROP_ID_templateCode = 5;
    
    /* 发送参数: TEMPLATE_PARAM VARCHAR */
    public static final String PROP_NAME_templateParam = "templateParam";
    public static final int PROP_ID_templateParam = 6;
    
    /* 回执信息: RECEIPT_INFO CLOB */
    public static final String PROP_NAME_receiptInfo = "receiptInfo";
    public static final int PROP_ID_receiptInfo = 7;
    
    /* 扩展信息: EXT_JSON CLOB */
    public static final String PROP_NAME_extJson = "extJson";
    public static final int PROP_ID_extJson = 8;
    
    /* 删除标志: DELETE_FLAG VARCHAR */
    public static final String PROP_NAME_deleteFlag = "deleteFlag";
    public static final int PROP_ID_deleteFlag = 9;
    
    /* 创建时间: CREATE_TIME DATETIME */
    public static final String PROP_NAME_createTime = "createTime";
    public static final int PROP_ID_createTime = 10;
    
    /* 创建用户: CREATE_USER VARCHAR */
    public static final String PROP_NAME_createUser = "createUser";
    public static final int PROP_ID_createUser = 11;
    
    /* 修改时间: UPDATE_TIME DATETIME */
    public static final String PROP_NAME_updateTime = "updateTime";
    public static final int PROP_ID_updateTime = 12;
    
    /* 修改用户: UPDATE_USER VARCHAR */
    public static final String PROP_NAME_updateUser = "updateUser";
    public static final int PROP_ID_updateUser = 13;
    

    private static int _PROP_ID_BOUND = 14;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[14];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_engine] = PROP_NAME_engine;
          PROP_NAME_TO_ID.put(PROP_NAME_engine, PROP_ID_engine);
      
          PROP_ID_TO_NAME[PROP_ID_phoneNumbers] = PROP_NAME_phoneNumbers;
          PROP_NAME_TO_ID.put(PROP_NAME_phoneNumbers, PROP_ID_phoneNumbers);
      
          PROP_ID_TO_NAME[PROP_ID_signName] = PROP_NAME_signName;
          PROP_NAME_TO_ID.put(PROP_NAME_signName, PROP_ID_signName);
      
          PROP_ID_TO_NAME[PROP_ID_templateCode] = PROP_NAME_templateCode;
          PROP_NAME_TO_ID.put(PROP_NAME_templateCode, PROP_ID_templateCode);
      
          PROP_ID_TO_NAME[PROP_ID_templateParam] = PROP_NAME_templateParam;
          PROP_NAME_TO_ID.put(PROP_NAME_templateParam, PROP_ID_templateParam);
      
          PROP_ID_TO_NAME[PROP_ID_receiptInfo] = PROP_NAME_receiptInfo;
          PROP_NAME_TO_ID.put(PROP_NAME_receiptInfo, PROP_ID_receiptInfo);
      
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
    
    /* 短信引擎: ENGINE */
    private java.lang.String _engine;
    
    /* 手机号: PHONE_NUMBERS */
    private java.lang.String _phoneNumbers;
    
    /* 短信签名: SIGN_NAME */
    private java.lang.String _signName;
    
    /* 模板编码: TEMPLATE_CODE */
    private java.lang.String _templateCode;
    
    /* 发送参数: TEMPLATE_PARAM */
    private java.lang.String _templateParam;
    
    /* 回执信息: RECEIPT_INFO */
    private java.lang.String _receiptInfo;
    
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
    

    public _DevSms(){
        // for debug
    }

    protected DevSms newInstance(){
        DevSms entity = new DevSms();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public DevSms cloneInstance() {
        DevSms entity = newInstance();
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
      return "com.fliad.resource.dao.entity.DevSms";
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
        
            case PROP_ID_engine:
               return getEngine();
        
            case PROP_ID_phoneNumbers:
               return getPhoneNumbers();
        
            case PROP_ID_signName:
               return getSignName();
        
            case PROP_ID_templateCode:
               return getTemplateCode();
        
            case PROP_ID_templateParam:
               return getTemplateParam();
        
            case PROP_ID_receiptInfo:
               return getReceiptInfo();
        
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
        
            case PROP_ID_engine:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_engine));
               }
               setEngine(typedValue);
               break;
            }
        
            case PROP_ID_phoneNumbers:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_phoneNumbers));
               }
               setPhoneNumbers(typedValue);
               break;
            }
        
            case PROP_ID_signName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_signName));
               }
               setSignName(typedValue);
               break;
            }
        
            case PROP_ID_templateCode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_templateCode));
               }
               setTemplateCode(typedValue);
               break;
            }
        
            case PROP_ID_templateParam:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_templateParam));
               }
               setTemplateParam(typedValue);
               break;
            }
        
            case PROP_ID_receiptInfo:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_receiptInfo));
               }
               setReceiptInfo(typedValue);
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
        
            case PROP_ID_engine:{
               onInitProp(propId);
               this._engine = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_phoneNumbers:{
               onInitProp(propId);
               this._phoneNumbers = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_signName:{
               onInitProp(propId);
               this._signName = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_templateCode:{
               onInitProp(propId);
               this._templateCode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_templateParam:{
               onInitProp(propId);
               this._templateParam = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_receiptInfo:{
               onInitProp(propId);
               this._receiptInfo = (java.lang.String)value;
               
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
     * 短信引擎: ENGINE
     */
    public final java.lang.String getEngine(){
         onPropGet(PROP_ID_engine);
         return _engine;
    }

    /**
     * 短信引擎: ENGINE
     */
    public final void setEngine(java.lang.String value){
        if(onPropSet(PROP_ID_engine,value)){
            this._engine = value;
            internalClearRefs(PROP_ID_engine);
            
        }
    }
    
    /**
     * 手机号: PHONE_NUMBERS
     */
    public final java.lang.String getPhoneNumbers(){
         onPropGet(PROP_ID_phoneNumbers);
         return _phoneNumbers;
    }

    /**
     * 手机号: PHONE_NUMBERS
     */
    public final void setPhoneNumbers(java.lang.String value){
        if(onPropSet(PROP_ID_phoneNumbers,value)){
            this._phoneNumbers = value;
            internalClearRefs(PROP_ID_phoneNumbers);
            
        }
    }
    
    /**
     * 短信签名: SIGN_NAME
     */
    public final java.lang.String getSignName(){
         onPropGet(PROP_ID_signName);
         return _signName;
    }

    /**
     * 短信签名: SIGN_NAME
     */
    public final void setSignName(java.lang.String value){
        if(onPropSet(PROP_ID_signName,value)){
            this._signName = value;
            internalClearRefs(PROP_ID_signName);
            
        }
    }
    
    /**
     * 模板编码: TEMPLATE_CODE
     */
    public final java.lang.String getTemplateCode(){
         onPropGet(PROP_ID_templateCode);
         return _templateCode;
    }

    /**
     * 模板编码: TEMPLATE_CODE
     */
    public final void setTemplateCode(java.lang.String value){
        if(onPropSet(PROP_ID_templateCode,value)){
            this._templateCode = value;
            internalClearRefs(PROP_ID_templateCode);
            
        }
    }
    
    /**
     * 发送参数: TEMPLATE_PARAM
     */
    public final java.lang.String getTemplateParam(){
         onPropGet(PROP_ID_templateParam);
         return _templateParam;
    }

    /**
     * 发送参数: TEMPLATE_PARAM
     */
    public final void setTemplateParam(java.lang.String value){
        if(onPropSet(PROP_ID_templateParam,value)){
            this._templateParam = value;
            internalClearRefs(PROP_ID_templateParam);
            
        }
    }
    
    /**
     * 回执信息: RECEIPT_INFO
     */
    public final java.lang.String getReceiptInfo(){
         onPropGet(PROP_ID_receiptInfo);
         return _receiptInfo;
    }

    /**
     * 回执信息: RECEIPT_INFO
     */
    public final void setReceiptInfo(java.lang.String value){
        if(onPropSet(PROP_ID_receiptInfo,value)){
            this._receiptInfo = value;
            internalClearRefs(PROP_ID_receiptInfo);
            
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

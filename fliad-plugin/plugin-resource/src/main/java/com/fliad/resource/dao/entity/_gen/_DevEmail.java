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

import com.fliad.resource.dao.entity.DevEmail;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  邮件: dev_email
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _DevEmail extends DynamicOrmEntity{
    
    /* Id: ID VARCHAR */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 邮件引擎: ENGINE VARCHAR */
    public static final String PROP_NAME_engine = "engine";
    public static final int PROP_ID_engine = 2;
    
    /* 发件人邮箱: SEND_ACCOUNT VARCHAR */
    public static final String PROP_NAME_sendAccount = "sendAccount";
    public static final int PROP_ID_sendAccount = 3;
    
    /* 发件人昵称: SEND_USER VARCHAR */
    public static final String PROP_NAME_sendUser = "sendUser";
    public static final int PROP_ID_sendUser = 4;
    
    /* 接收人: RECEIVE_ACCOUNTS VARCHAR */
    public static final String PROP_NAME_receiveAccounts = "receiveAccounts";
    public static final int PROP_ID_receiveAccounts = 5;
    
    /* 邮件主题: SUBJECT VARCHAR */
    public static final String PROP_NAME_subject = "subject";
    public static final int PROP_ID_subject = 6;
    
    /* 邮件正文: CONTENT CLOB */
    public static final String PROP_NAME_content = "content";
    public static final int PROP_ID_content = 7;
    
    /* 标签名: TAG_NAME VARCHAR */
    public static final String PROP_NAME_tagName = "tagName";
    public static final int PROP_ID_tagName = 8;
    
    /* 模板名: TEMPLATE_NAME VARCHAR */
    public static final String PROP_NAME_templateName = "templateName";
    public static final int PROP_ID_templateName = 9;
    
    /* 发送参数: TEMPLATE_PARAM VARCHAR */
    public static final String PROP_NAME_templateParam = "templateParam";
    public static final int PROP_ID_templateParam = 10;
    
    /* 回执信息: RECEIPT_INFO CLOB */
    public static final String PROP_NAME_receiptInfo = "receiptInfo";
    public static final int PROP_ID_receiptInfo = 11;
    
    /* 扩展信息: EXT_JSON CLOB */
    public static final String PROP_NAME_extJson = "extJson";
    public static final int PROP_ID_extJson = 12;
    
    /* 删除标志: DELETE_FLAG VARCHAR */
    public static final String PROP_NAME_deleteFlag = "deleteFlag";
    public static final int PROP_ID_deleteFlag = 13;
    
    /* 创建时间: CREATE_TIME DATETIME */
    public static final String PROP_NAME_createTime = "createTime";
    public static final int PROP_ID_createTime = 14;
    
    /* 创建用户: CREATE_USER VARCHAR */
    public static final String PROP_NAME_createUser = "createUser";
    public static final int PROP_ID_createUser = 15;
    
    /* 修改时间: UPDATE_TIME DATETIME */
    public static final String PROP_NAME_updateTime = "updateTime";
    public static final int PROP_ID_updateTime = 16;
    
    /* 修改用户: UPDATE_USER VARCHAR */
    public static final String PROP_NAME_updateUser = "updateUser";
    public static final int PROP_ID_updateUser = 17;
    

    private static int _PROP_ID_BOUND = 18;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[18];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_engine] = PROP_NAME_engine;
          PROP_NAME_TO_ID.put(PROP_NAME_engine, PROP_ID_engine);
      
          PROP_ID_TO_NAME[PROP_ID_sendAccount] = PROP_NAME_sendAccount;
          PROP_NAME_TO_ID.put(PROP_NAME_sendAccount, PROP_ID_sendAccount);
      
          PROP_ID_TO_NAME[PROP_ID_sendUser] = PROP_NAME_sendUser;
          PROP_NAME_TO_ID.put(PROP_NAME_sendUser, PROP_ID_sendUser);
      
          PROP_ID_TO_NAME[PROP_ID_receiveAccounts] = PROP_NAME_receiveAccounts;
          PROP_NAME_TO_ID.put(PROP_NAME_receiveAccounts, PROP_ID_receiveAccounts);
      
          PROP_ID_TO_NAME[PROP_ID_subject] = PROP_NAME_subject;
          PROP_NAME_TO_ID.put(PROP_NAME_subject, PROP_ID_subject);
      
          PROP_ID_TO_NAME[PROP_ID_content] = PROP_NAME_content;
          PROP_NAME_TO_ID.put(PROP_NAME_content, PROP_ID_content);
      
          PROP_ID_TO_NAME[PROP_ID_tagName] = PROP_NAME_tagName;
          PROP_NAME_TO_ID.put(PROP_NAME_tagName, PROP_ID_tagName);
      
          PROP_ID_TO_NAME[PROP_ID_templateName] = PROP_NAME_templateName;
          PROP_NAME_TO_ID.put(PROP_NAME_templateName, PROP_ID_templateName);
      
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
    
    /* 邮件引擎: ENGINE */
    private java.lang.String _engine;
    
    /* 发件人邮箱: SEND_ACCOUNT */
    private java.lang.String _sendAccount;
    
    /* 发件人昵称: SEND_USER */
    private java.lang.String _sendUser;
    
    /* 接收人: RECEIVE_ACCOUNTS */
    private java.lang.String _receiveAccounts;
    
    /* 邮件主题: SUBJECT */
    private java.lang.String _subject;
    
    /* 邮件正文: CONTENT */
    private java.lang.String _content;
    
    /* 标签名: TAG_NAME */
    private java.lang.String _tagName;
    
    /* 模板名: TEMPLATE_NAME */
    private java.lang.String _templateName;
    
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
    

    public _DevEmail(){
        // for debug
    }

    protected DevEmail newInstance(){
        DevEmail entity = new DevEmail();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public DevEmail cloneInstance() {
        DevEmail entity = newInstance();
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
      return "com.fliad.resource.dao.entity.DevEmail";
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
        
            case PROP_ID_sendAccount:
               return getSendAccount();
        
            case PROP_ID_sendUser:
               return getSendUser();
        
            case PROP_ID_receiveAccounts:
               return getReceiveAccounts();
        
            case PROP_ID_subject:
               return getSubject();
        
            case PROP_ID_content:
               return getContent();
        
            case PROP_ID_tagName:
               return getTagName();
        
            case PROP_ID_templateName:
               return getTemplateName();
        
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
        
            case PROP_ID_sendAccount:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_sendAccount));
               }
               setSendAccount(typedValue);
               break;
            }
        
            case PROP_ID_sendUser:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_sendUser));
               }
               setSendUser(typedValue);
               break;
            }
        
            case PROP_ID_receiveAccounts:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_receiveAccounts));
               }
               setReceiveAccounts(typedValue);
               break;
            }
        
            case PROP_ID_subject:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_subject));
               }
               setSubject(typedValue);
               break;
            }
        
            case PROP_ID_content:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_content));
               }
               setContent(typedValue);
               break;
            }
        
            case PROP_ID_tagName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_tagName));
               }
               setTagName(typedValue);
               break;
            }
        
            case PROP_ID_templateName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_templateName));
               }
               setTemplateName(typedValue);
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
        
            case PROP_ID_sendAccount:{
               onInitProp(propId);
               this._sendAccount = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_sendUser:{
               onInitProp(propId);
               this._sendUser = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_receiveAccounts:{
               onInitProp(propId);
               this._receiveAccounts = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_subject:{
               onInitProp(propId);
               this._subject = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_content:{
               onInitProp(propId);
               this._content = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_tagName:{
               onInitProp(propId);
               this._tagName = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_templateName:{
               onInitProp(propId);
               this._templateName = (java.lang.String)value;
               
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
     * 邮件引擎: ENGINE
     */
    public final java.lang.String getEngine(){
         onPropGet(PROP_ID_engine);
         return _engine;
    }

    /**
     * 邮件引擎: ENGINE
     */
    public final void setEngine(java.lang.String value){
        if(onPropSet(PROP_ID_engine,value)){
            this._engine = value;
            internalClearRefs(PROP_ID_engine);
            
        }
    }
    
    /**
     * 发件人邮箱: SEND_ACCOUNT
     */
    public final java.lang.String getSendAccount(){
         onPropGet(PROP_ID_sendAccount);
         return _sendAccount;
    }

    /**
     * 发件人邮箱: SEND_ACCOUNT
     */
    public final void setSendAccount(java.lang.String value){
        if(onPropSet(PROP_ID_sendAccount,value)){
            this._sendAccount = value;
            internalClearRefs(PROP_ID_sendAccount);
            
        }
    }
    
    /**
     * 发件人昵称: SEND_USER
     */
    public final java.lang.String getSendUser(){
         onPropGet(PROP_ID_sendUser);
         return _sendUser;
    }

    /**
     * 发件人昵称: SEND_USER
     */
    public final void setSendUser(java.lang.String value){
        if(onPropSet(PROP_ID_sendUser,value)){
            this._sendUser = value;
            internalClearRefs(PROP_ID_sendUser);
            
        }
    }
    
    /**
     * 接收人: RECEIVE_ACCOUNTS
     */
    public final java.lang.String getReceiveAccounts(){
         onPropGet(PROP_ID_receiveAccounts);
         return _receiveAccounts;
    }

    /**
     * 接收人: RECEIVE_ACCOUNTS
     */
    public final void setReceiveAccounts(java.lang.String value){
        if(onPropSet(PROP_ID_receiveAccounts,value)){
            this._receiveAccounts = value;
            internalClearRefs(PROP_ID_receiveAccounts);
            
        }
    }
    
    /**
     * 邮件主题: SUBJECT
     */
    public final java.lang.String getSubject(){
         onPropGet(PROP_ID_subject);
         return _subject;
    }

    /**
     * 邮件主题: SUBJECT
     */
    public final void setSubject(java.lang.String value){
        if(onPropSet(PROP_ID_subject,value)){
            this._subject = value;
            internalClearRefs(PROP_ID_subject);
            
        }
    }
    
    /**
     * 邮件正文: CONTENT
     */
    public final java.lang.String getContent(){
         onPropGet(PROP_ID_content);
         return _content;
    }

    /**
     * 邮件正文: CONTENT
     */
    public final void setContent(java.lang.String value){
        if(onPropSet(PROP_ID_content,value)){
            this._content = value;
            internalClearRefs(PROP_ID_content);
            
        }
    }
    
    /**
     * 标签名: TAG_NAME
     */
    public final java.lang.String getTagName(){
         onPropGet(PROP_ID_tagName);
         return _tagName;
    }

    /**
     * 标签名: TAG_NAME
     */
    public final void setTagName(java.lang.String value){
        if(onPropSet(PROP_ID_tagName,value)){
            this._tagName = value;
            internalClearRefs(PROP_ID_tagName);
            
        }
    }
    
    /**
     * 模板名: TEMPLATE_NAME
     */
    public final java.lang.String getTemplateName(){
         onPropGet(PROP_ID_templateName);
         return _templateName;
    }

    /**
     * 模板名: TEMPLATE_NAME
     */
    public final void setTemplateName(java.lang.String value){
        if(onPropSet(PROP_ID_templateName,value)){
            this._templateName = value;
            internalClearRefs(PROP_ID_templateName);
            
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

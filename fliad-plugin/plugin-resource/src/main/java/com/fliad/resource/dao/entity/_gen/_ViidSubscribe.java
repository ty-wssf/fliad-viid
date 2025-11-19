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

import com.fliad.resource.dao.entity.ViidSubscribe;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  订阅信息表: viid_subscribe
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _ViidSubscribe extends DynamicOrmEntity{
    
    /* 订阅标识符: SUBSCRIBEID VARCHAR */
    public static final String PROP_NAME_subscribeid = "subscribeid";
    public static final int PROP_ID_subscribeid = 1;
    
    /* 订阅标题: TITLE VARCHAR */
    public static final String PROP_NAME_title = "title";
    public static final int PROP_ID_title = 2;
    
    /* 订阅类别: SUBSCRIBEDETAIL VARCHAR */
    public static final String PROP_NAME_subscribedetail = "subscribedetail";
    public static final int PROP_ID_subscribedetail = 3;
    
    /* 订阅资源路径: RESOURCEURI VARCHAR */
    public static final String PROP_NAME_resourceuri = "resourceuri";
    public static final int PROP_ID_resourceuri = 4;
    
    /* 申请人: APPLICANTNAME VARCHAR */
    public static final String PROP_NAME_applicantname = "applicantname";
    public static final int PROP_ID_applicantname = 5;
    
    /* 申请单位: APPLICANTORG VARCHAR */
    public static final String PROP_NAME_applicantorg = "applicantorg";
    public static final int PROP_ID_applicantorg = 6;
    
    /* 开始时间: BEGINTIME VARCHAR */
    public static final String PROP_NAME_begintime = "begintime";
    public static final int PROP_ID_begintime = 7;
    
    /* 结束时间: ENDTIME VARCHAR */
    public static final String PROP_NAME_endtime = "endtime";
    public static final int PROP_ID_endtime = 8;
    
    /* 信息接收地址: RECEIVEADDR VARCHAR */
    public static final String PROP_NAME_receiveaddr = "receiveaddr";
    public static final int PROP_ID_receiveaddr = 9;
    
    /* 信息上报间隔时间: REPORTINTERVAL INTEGER */
    public static final String PROP_NAME_reportinterval = "reportinterval";
    public static final int PROP_ID_reportinterval = 10;
    
    /* 理由: REASON VARCHAR */
    public static final String PROP_NAME_reason = "reason";
    public static final int PROP_ID_reason = 11;
    
    /* 操作类型: OPERATETYPE VARCHAR */
    public static final String PROP_NAME_operatetype = "operatetype";
    public static final int PROP_ID_operatetype = 12;
    
    /* 订阅执行状态: SUBSCRIBESTATUS VARCHAR */
    public static final String PROP_NAME_subscribestatus = "subscribestatus";
    public static final int PROP_ID_subscribestatus = 13;
    
    /* 订阅取消单位: SUBSCRIBECANCELORG VARCHAR */
    public static final String PROP_NAME_subscribecancelorg = "subscribecancelorg";
    public static final int PROP_ID_subscribecancelorg = 14;
    
    /* 订阅取消人: SUBSCRIBECANCELPERSON VARCHAR */
    public static final String PROP_NAME_subscribecancelperson = "subscribecancelperson";
    public static final int PROP_ID_subscribecancelperson = 15;
    
    /* 取消时间: CANCELTIME DATETIME */
    public static final String PROP_NAME_canceltime = "canceltime";
    public static final int PROP_ID_canceltime = 16;
    
    /* 取消原因: CANCELREASON VARCHAR */
    public static final String PROP_NAME_cancelreason = "cancelreason";
    public static final int PROP_ID_cancelreason = 17;
    
    /* 0 订阅上级 1被订阅: SUBSCRIBETYPE VARCHAR */
    public static final String PROP_NAME_subscribetype = "subscribetype";
    public static final int PROP_ID_subscribetype = 18;
    
    /* 订阅发起方ID: SUBSCRIBERSENDORGID VARCHAR */
    public static final String PROP_NAME_subscribersendorgid = "subscribersendorgid";
    public static final int PROP_ID_subscribersendorgid = 19;
    
    /* 被订阅方ID: SUBSCRIBERRECOVERORGID VARCHAR */
    public static final String PROP_NAME_subscriberrecoverorgid = "subscriberrecoverorgid";
    public static final int PROP_ID_subscriberrecoverorgid = 20;
    

    private static int _PROP_ID_BOUND = 21;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_subscribeid);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_subscribeid};

    private static final String[] PROP_ID_TO_NAME = new String[21];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_subscribeid] = PROP_NAME_subscribeid;
          PROP_NAME_TO_ID.put(PROP_NAME_subscribeid, PROP_ID_subscribeid);
      
          PROP_ID_TO_NAME[PROP_ID_title] = PROP_NAME_title;
          PROP_NAME_TO_ID.put(PROP_NAME_title, PROP_ID_title);
      
          PROP_ID_TO_NAME[PROP_ID_subscribedetail] = PROP_NAME_subscribedetail;
          PROP_NAME_TO_ID.put(PROP_NAME_subscribedetail, PROP_ID_subscribedetail);
      
          PROP_ID_TO_NAME[PROP_ID_resourceuri] = PROP_NAME_resourceuri;
          PROP_NAME_TO_ID.put(PROP_NAME_resourceuri, PROP_ID_resourceuri);
      
          PROP_ID_TO_NAME[PROP_ID_applicantname] = PROP_NAME_applicantname;
          PROP_NAME_TO_ID.put(PROP_NAME_applicantname, PROP_ID_applicantname);
      
          PROP_ID_TO_NAME[PROP_ID_applicantorg] = PROP_NAME_applicantorg;
          PROP_NAME_TO_ID.put(PROP_NAME_applicantorg, PROP_ID_applicantorg);
      
          PROP_ID_TO_NAME[PROP_ID_begintime] = PROP_NAME_begintime;
          PROP_NAME_TO_ID.put(PROP_NAME_begintime, PROP_ID_begintime);
      
          PROP_ID_TO_NAME[PROP_ID_endtime] = PROP_NAME_endtime;
          PROP_NAME_TO_ID.put(PROP_NAME_endtime, PROP_ID_endtime);
      
          PROP_ID_TO_NAME[PROP_ID_receiveaddr] = PROP_NAME_receiveaddr;
          PROP_NAME_TO_ID.put(PROP_NAME_receiveaddr, PROP_ID_receiveaddr);
      
          PROP_ID_TO_NAME[PROP_ID_reportinterval] = PROP_NAME_reportinterval;
          PROP_NAME_TO_ID.put(PROP_NAME_reportinterval, PROP_ID_reportinterval);
      
          PROP_ID_TO_NAME[PROP_ID_reason] = PROP_NAME_reason;
          PROP_NAME_TO_ID.put(PROP_NAME_reason, PROP_ID_reason);
      
          PROP_ID_TO_NAME[PROP_ID_operatetype] = PROP_NAME_operatetype;
          PROP_NAME_TO_ID.put(PROP_NAME_operatetype, PROP_ID_operatetype);
      
          PROP_ID_TO_NAME[PROP_ID_subscribestatus] = PROP_NAME_subscribestatus;
          PROP_NAME_TO_ID.put(PROP_NAME_subscribestatus, PROP_ID_subscribestatus);
      
          PROP_ID_TO_NAME[PROP_ID_subscribecancelorg] = PROP_NAME_subscribecancelorg;
          PROP_NAME_TO_ID.put(PROP_NAME_subscribecancelorg, PROP_ID_subscribecancelorg);
      
          PROP_ID_TO_NAME[PROP_ID_subscribecancelperson] = PROP_NAME_subscribecancelperson;
          PROP_NAME_TO_ID.put(PROP_NAME_subscribecancelperson, PROP_ID_subscribecancelperson);
      
          PROP_ID_TO_NAME[PROP_ID_canceltime] = PROP_NAME_canceltime;
          PROP_NAME_TO_ID.put(PROP_NAME_canceltime, PROP_ID_canceltime);
      
          PROP_ID_TO_NAME[PROP_ID_cancelreason] = PROP_NAME_cancelreason;
          PROP_NAME_TO_ID.put(PROP_NAME_cancelreason, PROP_ID_cancelreason);
      
          PROP_ID_TO_NAME[PROP_ID_subscribetype] = PROP_NAME_subscribetype;
          PROP_NAME_TO_ID.put(PROP_NAME_subscribetype, PROP_ID_subscribetype);
      
          PROP_ID_TO_NAME[PROP_ID_subscribersendorgid] = PROP_NAME_subscribersendorgid;
          PROP_NAME_TO_ID.put(PROP_NAME_subscribersendorgid, PROP_ID_subscribersendorgid);
      
          PROP_ID_TO_NAME[PROP_ID_subscriberrecoverorgid] = PROP_NAME_subscriberrecoverorgid;
          PROP_NAME_TO_ID.put(PROP_NAME_subscriberrecoverorgid, PROP_ID_subscriberrecoverorgid);
      
    }

    
    /* 订阅标识符: SUBSCRIBEID */
    private java.lang.String _subscribeid;
    
    /* 订阅标题: TITLE */
    private java.lang.String _title;
    
    /* 订阅类别: SUBSCRIBEDETAIL */
    private java.lang.String _subscribedetail;
    
    /* 订阅资源路径: RESOURCEURI */
    private java.lang.String _resourceuri;
    
    /* 申请人: APPLICANTNAME */
    private java.lang.String _applicantname;
    
    /* 申请单位: APPLICANTORG */
    private java.lang.String _applicantorg;
    
    /* 开始时间: BEGINTIME */
    private java.lang.String _begintime;
    
    /* 结束时间: ENDTIME */
    private java.lang.String _endtime;
    
    /* 信息接收地址: RECEIVEADDR */
    private java.lang.String _receiveaddr;
    
    /* 信息上报间隔时间: REPORTINTERVAL */
    private java.lang.Integer _reportinterval;
    
    /* 理由: REASON */
    private java.lang.String _reason;
    
    /* 操作类型: OPERATETYPE */
    private java.lang.String _operatetype;
    
    /* 订阅执行状态: SUBSCRIBESTATUS */
    private java.lang.String _subscribestatus;
    
    /* 订阅取消单位: SUBSCRIBECANCELORG */
    private java.lang.String _subscribecancelorg;
    
    /* 订阅取消人: SUBSCRIBECANCELPERSON */
    private java.lang.String _subscribecancelperson;
    
    /* 取消时间: CANCELTIME */
    private java.time.LocalDateTime _canceltime;
    
    /* 取消原因: CANCELREASON */
    private java.lang.String _cancelreason;
    
    /* 0 订阅上级 1被订阅: SUBSCRIBETYPE */
    private java.lang.String _subscribetype;
    
    /* 订阅发起方ID: SUBSCRIBERSENDORGID */
    private java.lang.String _subscribersendorgid;
    
    /* 被订阅方ID: SUBSCRIBERRECOVERORGID */
    private java.lang.String _subscriberrecoverorgid;
    

    public _ViidSubscribe(){
        // for debug
    }

    protected ViidSubscribe newInstance(){
        ViidSubscribe entity = new ViidSubscribe();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public ViidSubscribe cloneInstance() {
        ViidSubscribe entity = newInstance();
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
      return "com.fliad.resource.dao.entity.ViidSubscribe";
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
    
        return buildSimpleId(PROP_ID_subscribeid);
     
    }

    @Override
    public boolean orm_isPrimary(int propId) {
        
            return propId == PROP_ID_subscribeid;
          
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
        
            case PROP_ID_subscribeid:
               return getSubscribeid();
        
            case PROP_ID_title:
               return getTitle();
        
            case PROP_ID_subscribedetail:
               return getSubscribedetail();
        
            case PROP_ID_resourceuri:
               return getResourceuri();
        
            case PROP_ID_applicantname:
               return getApplicantname();
        
            case PROP_ID_applicantorg:
               return getApplicantorg();
        
            case PROP_ID_begintime:
               return getBegintime();
        
            case PROP_ID_endtime:
               return getEndtime();
        
            case PROP_ID_receiveaddr:
               return getReceiveaddr();
        
            case PROP_ID_reportinterval:
               return getReportinterval();
        
            case PROP_ID_reason:
               return getReason();
        
            case PROP_ID_operatetype:
               return getOperatetype();
        
            case PROP_ID_subscribestatus:
               return getSubscribestatus();
        
            case PROP_ID_subscribecancelorg:
               return getSubscribecancelorg();
        
            case PROP_ID_subscribecancelperson:
               return getSubscribecancelperson();
        
            case PROP_ID_canceltime:
               return getCanceltime();
        
            case PROP_ID_cancelreason:
               return getCancelreason();
        
            case PROP_ID_subscribetype:
               return getSubscribetype();
        
            case PROP_ID_subscribersendorgid:
               return getSubscribersendorgid();
        
            case PROP_ID_subscriberrecoverorgid:
               return getSubscriberrecoverorgid();
        
           default:
              return super.orm_propValue(propId);
        }
    }

    

    @Override
    public void orm_propValue(int propId, Object value){
        switch(propId){
        
            case PROP_ID_subscribeid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_subscribeid));
               }
               setSubscribeid(typedValue);
               break;
            }
        
            case PROP_ID_title:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_title));
               }
               setTitle(typedValue);
               break;
            }
        
            case PROP_ID_subscribedetail:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_subscribedetail));
               }
               setSubscribedetail(typedValue);
               break;
            }
        
            case PROP_ID_resourceuri:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_resourceuri));
               }
               setResourceuri(typedValue);
               break;
            }
        
            case PROP_ID_applicantname:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_applicantname));
               }
               setApplicantname(typedValue);
               break;
            }
        
            case PROP_ID_applicantorg:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_applicantorg));
               }
               setApplicantorg(typedValue);
               break;
            }
        
            case PROP_ID_begintime:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_begintime));
               }
               setBegintime(typedValue);
               break;
            }
        
            case PROP_ID_endtime:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_endtime));
               }
               setEndtime(typedValue);
               break;
            }
        
            case PROP_ID_receiveaddr:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_receiveaddr));
               }
               setReceiveaddr(typedValue);
               break;
            }
        
            case PROP_ID_reportinterval:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_reportinterval));
               }
               setReportinterval(typedValue);
               break;
            }
        
            case PROP_ID_reason:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_reason));
               }
               setReason(typedValue);
               break;
            }
        
            case PROP_ID_operatetype:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_operatetype));
               }
               setOperatetype(typedValue);
               break;
            }
        
            case PROP_ID_subscribestatus:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_subscribestatus));
               }
               setSubscribestatus(typedValue);
               break;
            }
        
            case PROP_ID_subscribecancelorg:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_subscribecancelorg));
               }
               setSubscribecancelorg(typedValue);
               break;
            }
        
            case PROP_ID_subscribecancelperson:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_subscribecancelperson));
               }
               setSubscribecancelperson(typedValue);
               break;
            }
        
            case PROP_ID_canceltime:{
               java.time.LocalDateTime typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLocalDateTime(value,
                       err-> newTypeConversionError(PROP_NAME_canceltime));
               }
               setCanceltime(typedValue);
               break;
            }
        
            case PROP_ID_cancelreason:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_cancelreason));
               }
               setCancelreason(typedValue);
               break;
            }
        
            case PROP_ID_subscribetype:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_subscribetype));
               }
               setSubscribetype(typedValue);
               break;
            }
        
            case PROP_ID_subscribersendorgid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_subscribersendorgid));
               }
               setSubscribersendorgid(typedValue);
               break;
            }
        
            case PROP_ID_subscriberrecoverorgid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_subscriberrecoverorgid));
               }
               setSubscriberrecoverorgid(typedValue);
               break;
            }
        
           default:
              super.orm_propValue(propId,value);
        }
    }

    @Override
    public void orm_internalSet(int propId, Object value) {
        switch(propId){
        
            case PROP_ID_subscribeid:{
               onInitProp(propId);
               this._subscribeid = (java.lang.String)value;
               orm_id(); // 如果是设置主键字段，则触发watcher
               break;
            }
        
            case PROP_ID_title:{
               onInitProp(propId);
               this._title = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_subscribedetail:{
               onInitProp(propId);
               this._subscribedetail = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_resourceuri:{
               onInitProp(propId);
               this._resourceuri = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_applicantname:{
               onInitProp(propId);
               this._applicantname = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_applicantorg:{
               onInitProp(propId);
               this._applicantorg = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_begintime:{
               onInitProp(propId);
               this._begintime = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_endtime:{
               onInitProp(propId);
               this._endtime = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_receiveaddr:{
               onInitProp(propId);
               this._receiveaddr = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_reportinterval:{
               onInitProp(propId);
               this._reportinterval = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_reason:{
               onInitProp(propId);
               this._reason = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_operatetype:{
               onInitProp(propId);
               this._operatetype = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_subscribestatus:{
               onInitProp(propId);
               this._subscribestatus = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_subscribecancelorg:{
               onInitProp(propId);
               this._subscribecancelorg = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_subscribecancelperson:{
               onInitProp(propId);
               this._subscribecancelperson = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_canceltime:{
               onInitProp(propId);
               this._canceltime = (java.time.LocalDateTime)value;
               
               break;
            }
        
            case PROP_ID_cancelreason:{
               onInitProp(propId);
               this._cancelreason = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_subscribetype:{
               onInitProp(propId);
               this._subscribetype = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_subscribersendorgid:{
               onInitProp(propId);
               this._subscribersendorgid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_subscriberrecoverorgid:{
               onInitProp(propId);
               this._subscriberrecoverorgid = (java.lang.String)value;
               
               break;
            }
        
           default:
              super.orm_internalSet(propId,value);
        }
    }

    
    /**
     * 订阅标识符: SUBSCRIBEID
     */
    public final java.lang.String getSubscribeid(){
         onPropGet(PROP_ID_subscribeid);
         return _subscribeid;
    }

    /**
     * 订阅标识符: SUBSCRIBEID
     */
    public final void setSubscribeid(java.lang.String value){
        if(onPropSet(PROP_ID_subscribeid,value)){
            this._subscribeid = value;
            internalClearRefs(PROP_ID_subscribeid);
            orm_id();
        }
    }
    
    /**
     * 订阅标题: TITLE
     */
    public final java.lang.String getTitle(){
         onPropGet(PROP_ID_title);
         return _title;
    }

    /**
     * 订阅标题: TITLE
     */
    public final void setTitle(java.lang.String value){
        if(onPropSet(PROP_ID_title,value)){
            this._title = value;
            internalClearRefs(PROP_ID_title);
            
        }
    }
    
    /**
     * 订阅类别: SUBSCRIBEDETAIL
     */
    public final java.lang.String getSubscribedetail(){
         onPropGet(PROP_ID_subscribedetail);
         return _subscribedetail;
    }

    /**
     * 订阅类别: SUBSCRIBEDETAIL
     */
    public final void setSubscribedetail(java.lang.String value){
        if(onPropSet(PROP_ID_subscribedetail,value)){
            this._subscribedetail = value;
            internalClearRefs(PROP_ID_subscribedetail);
            
        }
    }
    
    /**
     * 订阅资源路径: RESOURCEURI
     */
    public final java.lang.String getResourceuri(){
         onPropGet(PROP_ID_resourceuri);
         return _resourceuri;
    }

    /**
     * 订阅资源路径: RESOURCEURI
     */
    public final void setResourceuri(java.lang.String value){
        if(onPropSet(PROP_ID_resourceuri,value)){
            this._resourceuri = value;
            internalClearRefs(PROP_ID_resourceuri);
            
        }
    }
    
    /**
     * 申请人: APPLICANTNAME
     */
    public final java.lang.String getApplicantname(){
         onPropGet(PROP_ID_applicantname);
         return _applicantname;
    }

    /**
     * 申请人: APPLICANTNAME
     */
    public final void setApplicantname(java.lang.String value){
        if(onPropSet(PROP_ID_applicantname,value)){
            this._applicantname = value;
            internalClearRefs(PROP_ID_applicantname);
            
        }
    }
    
    /**
     * 申请单位: APPLICANTORG
     */
    public final java.lang.String getApplicantorg(){
         onPropGet(PROP_ID_applicantorg);
         return _applicantorg;
    }

    /**
     * 申请单位: APPLICANTORG
     */
    public final void setApplicantorg(java.lang.String value){
        if(onPropSet(PROP_ID_applicantorg,value)){
            this._applicantorg = value;
            internalClearRefs(PROP_ID_applicantorg);
            
        }
    }
    
    /**
     * 开始时间: BEGINTIME
     */
    public final java.lang.String getBegintime(){
         onPropGet(PROP_ID_begintime);
         return _begintime;
    }

    /**
     * 开始时间: BEGINTIME
     */
    public final void setBegintime(java.lang.String value){
        if(onPropSet(PROP_ID_begintime,value)){
            this._begintime = value;
            internalClearRefs(PROP_ID_begintime);
            
        }
    }
    
    /**
     * 结束时间: ENDTIME
     */
    public final java.lang.String getEndtime(){
         onPropGet(PROP_ID_endtime);
         return _endtime;
    }

    /**
     * 结束时间: ENDTIME
     */
    public final void setEndtime(java.lang.String value){
        if(onPropSet(PROP_ID_endtime,value)){
            this._endtime = value;
            internalClearRefs(PROP_ID_endtime);
            
        }
    }
    
    /**
     * 信息接收地址: RECEIVEADDR
     */
    public final java.lang.String getReceiveaddr(){
         onPropGet(PROP_ID_receiveaddr);
         return _receiveaddr;
    }

    /**
     * 信息接收地址: RECEIVEADDR
     */
    public final void setReceiveaddr(java.lang.String value){
        if(onPropSet(PROP_ID_receiveaddr,value)){
            this._receiveaddr = value;
            internalClearRefs(PROP_ID_receiveaddr);
            
        }
    }
    
    /**
     * 信息上报间隔时间: REPORTINTERVAL
     */
    public final java.lang.Integer getReportinterval(){
         onPropGet(PROP_ID_reportinterval);
         return _reportinterval;
    }

    /**
     * 信息上报间隔时间: REPORTINTERVAL
     */
    public final void setReportinterval(java.lang.Integer value){
        if(onPropSet(PROP_ID_reportinterval,value)){
            this._reportinterval = value;
            internalClearRefs(PROP_ID_reportinterval);
            
        }
    }
    
    /**
     * 理由: REASON
     */
    public final java.lang.String getReason(){
         onPropGet(PROP_ID_reason);
         return _reason;
    }

    /**
     * 理由: REASON
     */
    public final void setReason(java.lang.String value){
        if(onPropSet(PROP_ID_reason,value)){
            this._reason = value;
            internalClearRefs(PROP_ID_reason);
            
        }
    }
    
    /**
     * 操作类型: OPERATETYPE
     */
    public final java.lang.String getOperatetype(){
         onPropGet(PROP_ID_operatetype);
         return _operatetype;
    }

    /**
     * 操作类型: OPERATETYPE
     */
    public final void setOperatetype(java.lang.String value){
        if(onPropSet(PROP_ID_operatetype,value)){
            this._operatetype = value;
            internalClearRefs(PROP_ID_operatetype);
            
        }
    }
    
    /**
     * 订阅执行状态: SUBSCRIBESTATUS
     */
    public final java.lang.String getSubscribestatus(){
         onPropGet(PROP_ID_subscribestatus);
         return _subscribestatus;
    }

    /**
     * 订阅执行状态: SUBSCRIBESTATUS
     */
    public final void setSubscribestatus(java.lang.String value){
        if(onPropSet(PROP_ID_subscribestatus,value)){
            this._subscribestatus = value;
            internalClearRefs(PROP_ID_subscribestatus);
            
        }
    }
    
    /**
     * 订阅取消单位: SUBSCRIBECANCELORG
     */
    public final java.lang.String getSubscribecancelorg(){
         onPropGet(PROP_ID_subscribecancelorg);
         return _subscribecancelorg;
    }

    /**
     * 订阅取消单位: SUBSCRIBECANCELORG
     */
    public final void setSubscribecancelorg(java.lang.String value){
        if(onPropSet(PROP_ID_subscribecancelorg,value)){
            this._subscribecancelorg = value;
            internalClearRefs(PROP_ID_subscribecancelorg);
            
        }
    }
    
    /**
     * 订阅取消人: SUBSCRIBECANCELPERSON
     */
    public final java.lang.String getSubscribecancelperson(){
         onPropGet(PROP_ID_subscribecancelperson);
         return _subscribecancelperson;
    }

    /**
     * 订阅取消人: SUBSCRIBECANCELPERSON
     */
    public final void setSubscribecancelperson(java.lang.String value){
        if(onPropSet(PROP_ID_subscribecancelperson,value)){
            this._subscribecancelperson = value;
            internalClearRefs(PROP_ID_subscribecancelperson);
            
        }
    }
    
    /**
     * 取消时间: CANCELTIME
     */
    public final java.time.LocalDateTime getCanceltime(){
         onPropGet(PROP_ID_canceltime);
         return _canceltime;
    }

    /**
     * 取消时间: CANCELTIME
     */
    public final void setCanceltime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_canceltime,value)){
            this._canceltime = value;
            internalClearRefs(PROP_ID_canceltime);
            
        }
    }
    
    /**
     * 取消原因: CANCELREASON
     */
    public final java.lang.String getCancelreason(){
         onPropGet(PROP_ID_cancelreason);
         return _cancelreason;
    }

    /**
     * 取消原因: CANCELREASON
     */
    public final void setCancelreason(java.lang.String value){
        if(onPropSet(PROP_ID_cancelreason,value)){
            this._cancelreason = value;
            internalClearRefs(PROP_ID_cancelreason);
            
        }
    }
    
    /**
     * 0 订阅上级 1被订阅: SUBSCRIBETYPE
     */
    public final java.lang.String getSubscribetype(){
         onPropGet(PROP_ID_subscribetype);
         return _subscribetype;
    }

    /**
     * 0 订阅上级 1被订阅: SUBSCRIBETYPE
     */
    public final void setSubscribetype(java.lang.String value){
        if(onPropSet(PROP_ID_subscribetype,value)){
            this._subscribetype = value;
            internalClearRefs(PROP_ID_subscribetype);
            
        }
    }
    
    /**
     * 订阅发起方ID: SUBSCRIBERSENDORGID
     */
    public final java.lang.String getSubscribersendorgid(){
         onPropGet(PROP_ID_subscribersendorgid);
         return _subscribersendorgid;
    }

    /**
     * 订阅发起方ID: SUBSCRIBERSENDORGID
     */
    public final void setSubscribersendorgid(java.lang.String value){
        if(onPropSet(PROP_ID_subscribersendorgid,value)){
            this._subscribersendorgid = value;
            internalClearRefs(PROP_ID_subscribersendorgid);
            
        }
    }
    
    /**
     * 被订阅方ID: SUBSCRIBERRECOVERORGID
     */
    public final java.lang.String getSubscriberrecoverorgid(){
         onPropGet(PROP_ID_subscriberrecoverorgid);
         return _subscriberrecoverorgid;
    }

    /**
     * 被订阅方ID: SUBSCRIBERRECOVERORGID
     */
    public final void setSubscriberrecoverorgid(java.lang.String value){
        if(onPropSet(PROP_ID_subscriberrecoverorgid,value)){
            this._subscriberrecoverorgid = value;
            internalClearRefs(PROP_ID_subscriberrecoverorgid);
            
        }
    }
    
}
// resume CPD analysis - CPD-ON

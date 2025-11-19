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

import com.fliad.resource.dao.entity.SysRelation;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  关系: sys_relation
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _SysRelation extends DynamicOrmEntity{
    
    /* Id: ID VARCHAR */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 对象ID: OBJECT_ID VARCHAR */
    public static final String PROP_NAME_objectId = "objectId";
    public static final int PROP_ID_objectId = 2;
    
    /* 目标ID: TARGET_ID VARCHAR */
    public static final String PROP_NAME_targetId = "targetId";
    public static final int PROP_ID_targetId = 3;
    
    /* 分类: CATEGORY VARCHAR */
    public static final String PROP_NAME_category = "category";
    public static final int PROP_ID_category = 4;
    
    /* 扩展信息: EXT_JSON CLOB */
    public static final String PROP_NAME_extJson = "extJson";
    public static final int PROP_ID_extJson = 5;
    

    private static int _PROP_ID_BOUND = 6;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[6];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_objectId] = PROP_NAME_objectId;
          PROP_NAME_TO_ID.put(PROP_NAME_objectId, PROP_ID_objectId);
      
          PROP_ID_TO_NAME[PROP_ID_targetId] = PROP_NAME_targetId;
          PROP_NAME_TO_ID.put(PROP_NAME_targetId, PROP_ID_targetId);
      
          PROP_ID_TO_NAME[PROP_ID_category] = PROP_NAME_category;
          PROP_NAME_TO_ID.put(PROP_NAME_category, PROP_ID_category);
      
          PROP_ID_TO_NAME[PROP_ID_extJson] = PROP_NAME_extJson;
          PROP_NAME_TO_ID.put(PROP_NAME_extJson, PROP_ID_extJson);
      
    }

    
    /* Id: ID */
    private java.lang.String _id_;
    
    /* 对象ID: OBJECT_ID */
    private java.lang.String _objectId;
    
    /* 目标ID: TARGET_ID */
    private java.lang.String _targetId;
    
    /* 分类: CATEGORY */
    private java.lang.String _category;
    
    /* 扩展信息: EXT_JSON */
    private java.lang.String _extJson;
    

    public _SysRelation(){
        // for debug
    }

    protected SysRelation newInstance(){
        SysRelation entity = new SysRelation();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public SysRelation cloneInstance() {
        SysRelation entity = newInstance();
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
      return "com.fliad.resource.dao.entity.SysRelation";
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
        
            case PROP_ID_objectId:
               return getObjectId();
        
            case PROP_ID_targetId:
               return getTargetId();
        
            case PROP_ID_category:
               return getCategory();
        
            case PROP_ID_extJson:
               return getExtJson();
        
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
        
            case PROP_ID_objectId:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_objectId));
               }
               setObjectId(typedValue);
               break;
            }
        
            case PROP_ID_targetId:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_targetId));
               }
               setTargetId(typedValue);
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
        
            case PROP_ID_extJson:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_extJson));
               }
               setExtJson(typedValue);
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
        
            case PROP_ID_objectId:{
               onInitProp(propId);
               this._objectId = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_targetId:{
               onInitProp(propId);
               this._targetId = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_category:{
               onInitProp(propId);
               this._category = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_extJson:{
               onInitProp(propId);
               this._extJson = (java.lang.String)value;
               
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
     * 对象ID: OBJECT_ID
     */
    public final java.lang.String getObjectId(){
         onPropGet(PROP_ID_objectId);
         return _objectId;
    }

    /**
     * 对象ID: OBJECT_ID
     */
    public final void setObjectId(java.lang.String value){
        if(onPropSet(PROP_ID_objectId,value)){
            this._objectId = value;
            internalClearRefs(PROP_ID_objectId);
            
        }
    }
    
    /**
     * 目标ID: TARGET_ID
     */
    public final java.lang.String getTargetId(){
         onPropGet(PROP_ID_targetId);
         return _targetId;
    }

    /**
     * 目标ID: TARGET_ID
     */
    public final void setTargetId(java.lang.String value){
        if(onPropSet(PROP_ID_targetId,value)){
            this._targetId = value;
            internalClearRefs(PROP_ID_targetId);
            
        }
    }
    
    /**
     * 分类: CATEGORY
     */
    public final java.lang.String getCategory(){
         onPropGet(PROP_ID_category);
         return _category;
    }

    /**
     * 分类: CATEGORY
     */
    public final void setCategory(java.lang.String value){
        if(onPropSet(PROP_ID_category,value)){
            this._category = value;
            internalClearRefs(PROP_ID_category);
            
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
    
}
// resume CPD analysis - CPD-ON

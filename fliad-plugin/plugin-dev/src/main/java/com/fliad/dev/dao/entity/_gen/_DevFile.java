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

import com.fliad.dev.dao.entity.DevFile;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  文件: DEV_FILE
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _DevFile extends DynamicOrmEntity{
    
    /* Id: ID VARCHAR */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 存储引擎: ENGINE VARCHAR */
    public static final String PROP_NAME_engine = "engine";
    public static final int PROP_ID_engine = 2;
    
    /* 存储桶: BUCKET VARCHAR */
    public static final String PROP_NAME_bucket = "bucket";
    public static final int PROP_ID_bucket = 3;
    
    /* 文件名称: NAME VARCHAR */
    public static final String PROP_NAME_name = "name";
    public static final int PROP_ID_name = 4;
    
    /* 文件后缀: SUFFIX VARCHAR */
    public static final String PROP_NAME_suffix = "suffix";
    public static final int PROP_ID_suffix = 5;
    
    /* 文件大小kb: SIZE_KB BIGINT */
    public static final String PROP_NAME_sizeKb = "sizeKb";
    public static final int PROP_ID_sizeKb = 6;
    
    /* 文件大小（格式化后）: SIZE_INFO VARCHAR */
    public static final String PROP_NAME_sizeInfo = "sizeInfo";
    public static final int PROP_ID_sizeInfo = 7;
    
    /* 文件的对象名（唯一名称）: OBJ_NAME VARCHAR */
    public static final String PROP_NAME_objName = "objName";
    public static final int PROP_ID_objName = 8;
    
    /* 文件存储路径: STORAGE_PATH VARCHAR */
    public static final String PROP_NAME_storagePath = "storagePath";
    public static final int PROP_ID_storagePath = 9;
    
    /* 文件下载路径: DOWNLOAD_PATH VARCHAR */
    public static final String PROP_NAME_downloadPath = "downloadPath";
    public static final int PROP_ID_downloadPath = 10;
    
    /* 图片缩略图: THUMBNAIL CLOB */
    public static final String PROP_NAME_thumbnail = "thumbnail";
    public static final int PROP_ID_thumbnail = 11;
    
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
      
          PROP_ID_TO_NAME[PROP_ID_bucket] = PROP_NAME_bucket;
          PROP_NAME_TO_ID.put(PROP_NAME_bucket, PROP_ID_bucket);
      
          PROP_ID_TO_NAME[PROP_ID_name] = PROP_NAME_name;
          PROP_NAME_TO_ID.put(PROP_NAME_name, PROP_ID_name);
      
          PROP_ID_TO_NAME[PROP_ID_suffix] = PROP_NAME_suffix;
          PROP_NAME_TO_ID.put(PROP_NAME_suffix, PROP_ID_suffix);
      
          PROP_ID_TO_NAME[PROP_ID_sizeKb] = PROP_NAME_sizeKb;
          PROP_NAME_TO_ID.put(PROP_NAME_sizeKb, PROP_ID_sizeKb);
      
          PROP_ID_TO_NAME[PROP_ID_sizeInfo] = PROP_NAME_sizeInfo;
          PROP_NAME_TO_ID.put(PROP_NAME_sizeInfo, PROP_ID_sizeInfo);
      
          PROP_ID_TO_NAME[PROP_ID_objName] = PROP_NAME_objName;
          PROP_NAME_TO_ID.put(PROP_NAME_objName, PROP_ID_objName);
      
          PROP_ID_TO_NAME[PROP_ID_storagePath] = PROP_NAME_storagePath;
          PROP_NAME_TO_ID.put(PROP_NAME_storagePath, PROP_ID_storagePath);
      
          PROP_ID_TO_NAME[PROP_ID_downloadPath] = PROP_NAME_downloadPath;
          PROP_NAME_TO_ID.put(PROP_NAME_downloadPath, PROP_ID_downloadPath);
      
          PROP_ID_TO_NAME[PROP_ID_thumbnail] = PROP_NAME_thumbnail;
          PROP_NAME_TO_ID.put(PROP_NAME_thumbnail, PROP_ID_thumbnail);
      
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
    
    /* 存储引擎: ENGINE */
    private java.lang.String _engine;
    
    /* 存储桶: BUCKET */
    private java.lang.String _bucket;
    
    /* 文件名称: NAME */
    private java.lang.String _name;
    
    /* 文件后缀: SUFFIX */
    private java.lang.String _suffix;
    
    /* 文件大小kb: SIZE_KB */
    private java.lang.Long _sizeKb;
    
    /* 文件大小（格式化后）: SIZE_INFO */
    private java.lang.String _sizeInfo;
    
    /* 文件的对象名（唯一名称）: OBJ_NAME */
    private java.lang.String _objName;
    
    /* 文件存储路径: STORAGE_PATH */
    private java.lang.String _storagePath;
    
    /* 文件下载路径: DOWNLOAD_PATH */
    private java.lang.String _downloadPath;
    
    /* 图片缩略图: THUMBNAIL */
    private java.lang.String _thumbnail;
    
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
    

    public _DevFile(){
        // for debug
    }

    protected DevFile newInstance(){
        DevFile entity = new DevFile();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public DevFile cloneInstance() {
        DevFile entity = newInstance();
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
      return "com.fliad.dev.dao.entity.DevFile";
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
        
            case PROP_ID_bucket:
               return getBucket();
        
            case PROP_ID_name:
               return getName();
        
            case PROP_ID_suffix:
               return getSuffix();
        
            case PROP_ID_sizeKb:
               return getSizeKb();
        
            case PROP_ID_sizeInfo:
               return getSizeInfo();
        
            case PROP_ID_objName:
               return getObjName();
        
            case PROP_ID_storagePath:
               return getStoragePath();
        
            case PROP_ID_downloadPath:
               return getDownloadPath();
        
            case PROP_ID_thumbnail:
               return getThumbnail();
        
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
        
            case PROP_ID_bucket:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_bucket));
               }
               setBucket(typedValue);
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
        
            case PROP_ID_suffix:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_suffix));
               }
               setSuffix(typedValue);
               break;
            }
        
            case PROP_ID_sizeKb:{
               java.lang.Long typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLong(value,
                       err-> newTypeConversionError(PROP_NAME_sizeKb));
               }
               setSizeKb(typedValue);
               break;
            }
        
            case PROP_ID_sizeInfo:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_sizeInfo));
               }
               setSizeInfo(typedValue);
               break;
            }
        
            case PROP_ID_objName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_objName));
               }
               setObjName(typedValue);
               break;
            }
        
            case PROP_ID_storagePath:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_storagePath));
               }
               setStoragePath(typedValue);
               break;
            }
        
            case PROP_ID_downloadPath:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_downloadPath));
               }
               setDownloadPath(typedValue);
               break;
            }
        
            case PROP_ID_thumbnail:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_thumbnail));
               }
               setThumbnail(typedValue);
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
        
            case PROP_ID_bucket:{
               onInitProp(propId);
               this._bucket = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_name:{
               onInitProp(propId);
               this._name = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_suffix:{
               onInitProp(propId);
               this._suffix = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_sizeKb:{
               onInitProp(propId);
               this._sizeKb = (java.lang.Long)value;
               
               break;
            }
        
            case PROP_ID_sizeInfo:{
               onInitProp(propId);
               this._sizeInfo = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_objName:{
               onInitProp(propId);
               this._objName = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_storagePath:{
               onInitProp(propId);
               this._storagePath = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_downloadPath:{
               onInitProp(propId);
               this._downloadPath = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_thumbnail:{
               onInitProp(propId);
               this._thumbnail = (java.lang.String)value;
               
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
     * 存储引擎: ENGINE
     */
    public final java.lang.String getEngine(){
         onPropGet(PROP_ID_engine);
         return _engine;
    }

    /**
     * 存储引擎: ENGINE
     */
    public final void setEngine(java.lang.String value){
        if(onPropSet(PROP_ID_engine,value)){
            this._engine = value;
            internalClearRefs(PROP_ID_engine);
            
        }
    }
    
    /**
     * 存储桶: BUCKET
     */
    public final java.lang.String getBucket(){
         onPropGet(PROP_ID_bucket);
         return _bucket;
    }

    /**
     * 存储桶: BUCKET
     */
    public final void setBucket(java.lang.String value){
        if(onPropSet(PROP_ID_bucket,value)){
            this._bucket = value;
            internalClearRefs(PROP_ID_bucket);
            
        }
    }
    
    /**
     * 文件名称: NAME
     */
    public final java.lang.String getName(){
         onPropGet(PROP_ID_name);
         return _name;
    }

    /**
     * 文件名称: NAME
     */
    public final void setName(java.lang.String value){
        if(onPropSet(PROP_ID_name,value)){
            this._name = value;
            internalClearRefs(PROP_ID_name);
            
        }
    }
    
    /**
     * 文件后缀: SUFFIX
     */
    public final java.lang.String getSuffix(){
         onPropGet(PROP_ID_suffix);
         return _suffix;
    }

    /**
     * 文件后缀: SUFFIX
     */
    public final void setSuffix(java.lang.String value){
        if(onPropSet(PROP_ID_suffix,value)){
            this._suffix = value;
            internalClearRefs(PROP_ID_suffix);
            
        }
    }
    
    /**
     * 文件大小kb: SIZE_KB
     */
    public final java.lang.Long getSizeKb(){
         onPropGet(PROP_ID_sizeKb);
         return _sizeKb;
    }

    /**
     * 文件大小kb: SIZE_KB
     */
    public final void setSizeKb(java.lang.Long value){
        if(onPropSet(PROP_ID_sizeKb,value)){
            this._sizeKb = value;
            internalClearRefs(PROP_ID_sizeKb);
            
        }
    }
    
    /**
     * 文件大小（格式化后）: SIZE_INFO
     */
    public final java.lang.String getSizeInfo(){
         onPropGet(PROP_ID_sizeInfo);
         return _sizeInfo;
    }

    /**
     * 文件大小（格式化后）: SIZE_INFO
     */
    public final void setSizeInfo(java.lang.String value){
        if(onPropSet(PROP_ID_sizeInfo,value)){
            this._sizeInfo = value;
            internalClearRefs(PROP_ID_sizeInfo);
            
        }
    }
    
    /**
     * 文件的对象名（唯一名称）: OBJ_NAME
     */
    public final java.lang.String getObjName(){
         onPropGet(PROP_ID_objName);
         return _objName;
    }

    /**
     * 文件的对象名（唯一名称）: OBJ_NAME
     */
    public final void setObjName(java.lang.String value){
        if(onPropSet(PROP_ID_objName,value)){
            this._objName = value;
            internalClearRefs(PROP_ID_objName);
            
        }
    }
    
    /**
     * 文件存储路径: STORAGE_PATH
     */
    public final java.lang.String getStoragePath(){
         onPropGet(PROP_ID_storagePath);
         return _storagePath;
    }

    /**
     * 文件存储路径: STORAGE_PATH
     */
    public final void setStoragePath(java.lang.String value){
        if(onPropSet(PROP_ID_storagePath,value)){
            this._storagePath = value;
            internalClearRefs(PROP_ID_storagePath);
            
        }
    }
    
    /**
     * 文件下载路径: DOWNLOAD_PATH
     */
    public final java.lang.String getDownloadPath(){
         onPropGet(PROP_ID_downloadPath);
         return _downloadPath;
    }

    /**
     * 文件下载路径: DOWNLOAD_PATH
     */
    public final void setDownloadPath(java.lang.String value){
        if(onPropSet(PROP_ID_downloadPath,value)){
            this._downloadPath = value;
            internalClearRefs(PROP_ID_downloadPath);
            
        }
    }
    
    /**
     * 图片缩略图: THUMBNAIL
     */
    public final java.lang.String getThumbnail(){
         onPropGet(PROP_ID_thumbnail);
         return _thumbnail;
    }

    /**
     * 图片缩略图: THUMBNAIL
     */
    public final void setThumbnail(java.lang.String value){
        if(onPropSet(PROP_ID_thumbnail,value)){
            this._thumbnail = value;
            internalClearRefs(PROP_ID_thumbnail);
            
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

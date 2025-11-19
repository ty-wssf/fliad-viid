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

import com.fliad.resource.dao.entity.MobileResource;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  移动资源: mobile_resource
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _MobileResource extends DynamicOrmEntity{
    
    /* 主键: ID VARCHAR */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 父ID: PARENT_ID VARCHAR */
    public static final String PROP_NAME_parentId = "parentId";
    public static final int PROP_ID_parentId = 2;
    
    /* 名称: TITLE VARCHAR */
    public static final String PROP_NAME_title = "title";
    public static final int PROP_ID_title = 3;
    
    /* 编码: CODE VARCHAR */
    public static final String PROP_NAME_code = "code";
    public static final int PROP_ID_code = 4;
    
    /* 分类: CATEGORY VARCHAR */
    public static final String PROP_NAME_category = "category";
    public static final int PROP_ID_category = 5;
    
    /* 模块: MODULE VARCHAR */
    public static final String PROP_NAME_module = "module";
    public static final int PROP_ID_module = 6;
    
    /* 菜单类型: MENU_TYPE VARCHAR */
    public static final String PROP_NAME_menuType = "menuType";
    public static final int PROP_ID_menuType = 7;
    
    /* 路径: PATH VARCHAR */
    public static final String PROP_NAME_path = "path";
    public static final int PROP_ID_path = 8;
    
    /* 图标: ICON VARCHAR */
    public static final String PROP_NAME_icon = "icon";
    public static final int PROP_ID_icon = 9;
    
    /* 颜色: COLOR VARCHAR */
    public static final String PROP_NAME_color = "color";
    public static final int PROP_ID_color = 10;
    
    /* 规则类型: REG_TYPE VARCHAR */
    public static final String PROP_NAME_regType = "regType";
    public static final int PROP_ID_regType = 11;
    
    /* 可用状态: STATUS VARCHAR */
    public static final String PROP_NAME_status = "status";
    public static final int PROP_ID_status = 12;
    
    /* 排序码: SORT_CODE INTEGER */
    public static final String PROP_NAME_sortCode = "sortCode";
    public static final int PROP_ID_sortCode = 13;
    
    /* 扩展信息: EXT_JSON CLOB */
    public static final String PROP_NAME_extJson = "extJson";
    public static final int PROP_ID_extJson = 14;
    
    /* 删除标志: DELETE_FLAG VARCHAR */
    public static final String PROP_NAME_deleteFlag = "deleteFlag";
    public static final int PROP_ID_deleteFlag = 15;
    
    /* 创建时间: CREATE_TIME DATETIME */
    public static final String PROP_NAME_createTime = "createTime";
    public static final int PROP_ID_createTime = 16;
    
    /* 创建用户: CREATE_USER VARCHAR */
    public static final String PROP_NAME_createUser = "createUser";
    public static final int PROP_ID_createUser = 17;
    
    /* 修改时间: UPDATE_TIME DATETIME */
    public static final String PROP_NAME_updateTime = "updateTime";
    public static final int PROP_ID_updateTime = 18;
    
    /* 修改用户: UPDATE_USER VARCHAR */
    public static final String PROP_NAME_updateUser = "updateUser";
    public static final int PROP_ID_updateUser = 19;
    

    private static int _PROP_ID_BOUND = 20;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[20];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_parentId] = PROP_NAME_parentId;
          PROP_NAME_TO_ID.put(PROP_NAME_parentId, PROP_ID_parentId);
      
          PROP_ID_TO_NAME[PROP_ID_title] = PROP_NAME_title;
          PROP_NAME_TO_ID.put(PROP_NAME_title, PROP_ID_title);
      
          PROP_ID_TO_NAME[PROP_ID_code] = PROP_NAME_code;
          PROP_NAME_TO_ID.put(PROP_NAME_code, PROP_ID_code);
      
          PROP_ID_TO_NAME[PROP_ID_category] = PROP_NAME_category;
          PROP_NAME_TO_ID.put(PROP_NAME_category, PROP_ID_category);
      
          PROP_ID_TO_NAME[PROP_ID_module] = PROP_NAME_module;
          PROP_NAME_TO_ID.put(PROP_NAME_module, PROP_ID_module);
      
          PROP_ID_TO_NAME[PROP_ID_menuType] = PROP_NAME_menuType;
          PROP_NAME_TO_ID.put(PROP_NAME_menuType, PROP_ID_menuType);
      
          PROP_ID_TO_NAME[PROP_ID_path] = PROP_NAME_path;
          PROP_NAME_TO_ID.put(PROP_NAME_path, PROP_ID_path);
      
          PROP_ID_TO_NAME[PROP_ID_icon] = PROP_NAME_icon;
          PROP_NAME_TO_ID.put(PROP_NAME_icon, PROP_ID_icon);
      
          PROP_ID_TO_NAME[PROP_ID_color] = PROP_NAME_color;
          PROP_NAME_TO_ID.put(PROP_NAME_color, PROP_ID_color);
      
          PROP_ID_TO_NAME[PROP_ID_regType] = PROP_NAME_regType;
          PROP_NAME_TO_ID.put(PROP_NAME_regType, PROP_ID_regType);
      
          PROP_ID_TO_NAME[PROP_ID_status] = PROP_NAME_status;
          PROP_NAME_TO_ID.put(PROP_NAME_status, PROP_ID_status);
      
          PROP_ID_TO_NAME[PROP_ID_sortCode] = PROP_NAME_sortCode;
          PROP_NAME_TO_ID.put(PROP_NAME_sortCode, PROP_ID_sortCode);
      
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

    
    /* 主键: ID */
    private java.lang.String _id_;
    
    /* 父ID: PARENT_ID */
    private java.lang.String _parentId;
    
    /* 名称: TITLE */
    private java.lang.String _title;
    
    /* 编码: CODE */
    private java.lang.String _code;
    
    /* 分类: CATEGORY */
    private java.lang.String _category;
    
    /* 模块: MODULE */
    private java.lang.String _module;
    
    /* 菜单类型: MENU_TYPE */
    private java.lang.String _menuType;
    
    /* 路径: PATH */
    private java.lang.String _path;
    
    /* 图标: ICON */
    private java.lang.String _icon;
    
    /* 颜色: COLOR */
    private java.lang.String _color;
    
    /* 规则类型: REG_TYPE */
    private java.lang.String _regType;
    
    /* 可用状态: STATUS */
    private java.lang.String _status;
    
    /* 排序码: SORT_CODE */
    private java.lang.Integer _sortCode;
    
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
    

    public _MobileResource(){
        // for debug
    }

    protected MobileResource newInstance(){
        MobileResource entity = new MobileResource();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public MobileResource cloneInstance() {
        MobileResource entity = newInstance();
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
      return "com.fliad.resource.dao.entity.MobileResource";
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
        
            case PROP_ID_parentId:
               return getParentId();
        
            case PROP_ID_title:
               return getTitle();
        
            case PROP_ID_code:
               return getCode();
        
            case PROP_ID_category:
               return getCategory();
        
            case PROP_ID_module:
               return getModule();
        
            case PROP_ID_menuType:
               return getMenuType();
        
            case PROP_ID_path:
               return getPath();
        
            case PROP_ID_icon:
               return getIcon();
        
            case PROP_ID_color:
               return getColor();
        
            case PROP_ID_regType:
               return getRegType();
        
            case PROP_ID_status:
               return getStatus();
        
            case PROP_ID_sortCode:
               return getSortCode();
        
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
        
            case PROP_ID_parentId:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_parentId));
               }
               setParentId(typedValue);
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
        
            case PROP_ID_code:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_code));
               }
               setCode(typedValue);
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
        
            case PROP_ID_module:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_module));
               }
               setModule(typedValue);
               break;
            }
        
            case PROP_ID_menuType:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_menuType));
               }
               setMenuType(typedValue);
               break;
            }
        
            case PROP_ID_path:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_path));
               }
               setPath(typedValue);
               break;
            }
        
            case PROP_ID_icon:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_icon));
               }
               setIcon(typedValue);
               break;
            }
        
            case PROP_ID_color:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_color));
               }
               setColor(typedValue);
               break;
            }
        
            case PROP_ID_regType:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_regType));
               }
               setRegType(typedValue);
               break;
            }
        
            case PROP_ID_status:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_status));
               }
               setStatus(typedValue);
               break;
            }
        
            case PROP_ID_sortCode:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_sortCode));
               }
               setSortCode(typedValue);
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
        
            case PROP_ID_parentId:{
               onInitProp(propId);
               this._parentId = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_title:{
               onInitProp(propId);
               this._title = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_code:{
               onInitProp(propId);
               this._code = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_category:{
               onInitProp(propId);
               this._category = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_module:{
               onInitProp(propId);
               this._module = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_menuType:{
               onInitProp(propId);
               this._menuType = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_path:{
               onInitProp(propId);
               this._path = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_icon:{
               onInitProp(propId);
               this._icon = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_color:{
               onInitProp(propId);
               this._color = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_regType:{
               onInitProp(propId);
               this._regType = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_status:{
               onInitProp(propId);
               this._status = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_sortCode:{
               onInitProp(propId);
               this._sortCode = (java.lang.Integer)value;
               
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
     * 父ID: PARENT_ID
     */
    public final java.lang.String getParentId(){
         onPropGet(PROP_ID_parentId);
         return _parentId;
    }

    /**
     * 父ID: PARENT_ID
     */
    public final void setParentId(java.lang.String value){
        if(onPropSet(PROP_ID_parentId,value)){
            this._parentId = value;
            internalClearRefs(PROP_ID_parentId);
            
        }
    }
    
    /**
     * 名称: TITLE
     */
    public final java.lang.String getTitle(){
         onPropGet(PROP_ID_title);
         return _title;
    }

    /**
     * 名称: TITLE
     */
    public final void setTitle(java.lang.String value){
        if(onPropSet(PROP_ID_title,value)){
            this._title = value;
            internalClearRefs(PROP_ID_title);
            
        }
    }
    
    /**
     * 编码: CODE
     */
    public final java.lang.String getCode(){
         onPropGet(PROP_ID_code);
         return _code;
    }

    /**
     * 编码: CODE
     */
    public final void setCode(java.lang.String value){
        if(onPropSet(PROP_ID_code,value)){
            this._code = value;
            internalClearRefs(PROP_ID_code);
            
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
     * 模块: MODULE
     */
    public final java.lang.String getModule(){
         onPropGet(PROP_ID_module);
         return _module;
    }

    /**
     * 模块: MODULE
     */
    public final void setModule(java.lang.String value){
        if(onPropSet(PROP_ID_module,value)){
            this._module = value;
            internalClearRefs(PROP_ID_module);
            
        }
    }
    
    /**
     * 菜单类型: MENU_TYPE
     */
    public final java.lang.String getMenuType(){
         onPropGet(PROP_ID_menuType);
         return _menuType;
    }

    /**
     * 菜单类型: MENU_TYPE
     */
    public final void setMenuType(java.lang.String value){
        if(onPropSet(PROP_ID_menuType,value)){
            this._menuType = value;
            internalClearRefs(PROP_ID_menuType);
            
        }
    }
    
    /**
     * 路径: PATH
     */
    public final java.lang.String getPath(){
         onPropGet(PROP_ID_path);
         return _path;
    }

    /**
     * 路径: PATH
     */
    public final void setPath(java.lang.String value){
        if(onPropSet(PROP_ID_path,value)){
            this._path = value;
            internalClearRefs(PROP_ID_path);
            
        }
    }
    
    /**
     * 图标: ICON
     */
    public final java.lang.String getIcon(){
         onPropGet(PROP_ID_icon);
         return _icon;
    }

    /**
     * 图标: ICON
     */
    public final void setIcon(java.lang.String value){
        if(onPropSet(PROP_ID_icon,value)){
            this._icon = value;
            internalClearRefs(PROP_ID_icon);
            
        }
    }
    
    /**
     * 颜色: COLOR
     */
    public final java.lang.String getColor(){
         onPropGet(PROP_ID_color);
         return _color;
    }

    /**
     * 颜色: COLOR
     */
    public final void setColor(java.lang.String value){
        if(onPropSet(PROP_ID_color,value)){
            this._color = value;
            internalClearRefs(PROP_ID_color);
            
        }
    }
    
    /**
     * 规则类型: REG_TYPE
     */
    public final java.lang.String getRegType(){
         onPropGet(PROP_ID_regType);
         return _regType;
    }

    /**
     * 规则类型: REG_TYPE
     */
    public final void setRegType(java.lang.String value){
        if(onPropSet(PROP_ID_regType,value)){
            this._regType = value;
            internalClearRefs(PROP_ID_regType);
            
        }
    }
    
    /**
     * 可用状态: STATUS
     */
    public final java.lang.String getStatus(){
         onPropGet(PROP_ID_status);
         return _status;
    }

    /**
     * 可用状态: STATUS
     */
    public final void setStatus(java.lang.String value){
        if(onPropSet(PROP_ID_status,value)){
            this._status = value;
            internalClearRefs(PROP_ID_status);
            
        }
    }
    
    /**
     * 排序码: SORT_CODE
     */
    public final java.lang.Integer getSortCode(){
         onPropGet(PROP_ID_sortCode);
         return _sortCode;
    }

    /**
     * 排序码: SORT_CODE
     */
    public final void setSortCode(java.lang.Integer value){
        if(onPropSet(PROP_ID_sortCode,value)){
            this._sortCode = value;
            internalClearRefs(PROP_ID_sortCode);
            
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

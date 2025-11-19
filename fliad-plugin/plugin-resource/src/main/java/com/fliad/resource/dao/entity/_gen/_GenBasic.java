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

import com.fliad.resource.dao.entity.GenBasic;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  生成基础: gen_basic
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _GenBasic extends DynamicOrmEntity{
    
    /* 主键: ID VARCHAR */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 主表: DB_TABLE VARCHAR */
    public static final String PROP_NAME_dbTable = "dbTable";
    public static final int PROP_ID_dbTable = 2;
    
    /* 主表主键: DB_TABLE_KEY VARCHAR */
    public static final String PROP_NAME_dbTableKey = "dbTableKey";
    public static final int PROP_ID_dbTableKey = 3;
    
    /* 插件名: PLUGIN_NAME VARCHAR */
    public static final String PROP_NAME_pluginName = "pluginName";
    public static final int PROP_ID_pluginName = 4;
    
    /* 模块名: MODULE_NAME VARCHAR */
    public static final String PROP_NAME_moduleName = "moduleName";
    public static final int PROP_ID_moduleName = 5;
    
    /* 移除表前缀: TABLE_PREFIX VARCHAR */
    public static final String PROP_NAME_tablePrefix = "tablePrefix";
    public static final int PROP_ID_tablePrefix = 6;
    
    /* 生成方式: GENERATE_TYPE VARCHAR */
    public static final String PROP_NAME_generateType = "generateType";
    public static final int PROP_ID_generateType = 7;
    
    /* 所属模块: MODULE VARCHAR */
    public static final String PROP_NAME_module = "module";
    public static final int PROP_ID_module = 8;
    
    /* 上级目录: MENU_PID VARCHAR */
    public static final String PROP_NAME_menuPid = "menuPid";
    public static final int PROP_ID_menuPid = 9;
    
    /* 移动端所属模块: MOBILE_MODULE VARCHAR */
    public static final String PROP_NAME_mobileModule = "mobileModule";
    public static final int PROP_ID_mobileModule = 10;
    
    /* 功能名: FUNCTION_NAME VARCHAR */
    public static final String PROP_NAME_functionName = "functionName";
    public static final int PROP_ID_functionName = 11;
    
    /* 业务名: BUS_NAME VARCHAR */
    public static final String PROP_NAME_busName = "busName";
    public static final int PROP_ID_busName = 12;
    
    /* 类名: CLASS_NAME VARCHAR */
    public static final String PROP_NAME_className = "className";
    public static final int PROP_ID_className = 13;
    
    /* 表单布局: FORM_LAYOUT VARCHAR */
    public static final String PROP_NAME_formLayout = "formLayout";
    public static final int PROP_ID_formLayout = 14;
    
    /* 使用栅格: GRID_WHETHER VARCHAR */
    public static final String PROP_NAME_gridWhether = "gridWhether";
    public static final int PROP_ID_gridWhether = 15;
    
    /* 包名: PACKAGE_NAME VARCHAR */
    public static final String PROP_NAME_packageName = "packageName";
    public static final int PROP_ID_packageName = 16;
    
    /* 作者: AUTHOR_NAME VARCHAR */
    public static final String PROP_NAME_authorName = "authorName";
    public static final int PROP_ID_authorName = 17;
    
    /* 排序: SORT_CODE INTEGER */
    public static final String PROP_NAME_sortCode = "sortCode";
    public static final int PROP_ID_sortCode = 18;
    
    /* 删除标志: DELETE_FLAG VARCHAR */
    public static final String PROP_NAME_deleteFlag = "deleteFlag";
    public static final int PROP_ID_deleteFlag = 19;
    
    /* 创建时间: CREATE_TIME DATETIME */
    public static final String PROP_NAME_createTime = "createTime";
    public static final int PROP_ID_createTime = 20;
    
    /* 创建用户: CREATE_USER VARCHAR */
    public static final String PROP_NAME_createUser = "createUser";
    public static final int PROP_ID_createUser = 21;
    
    /* 修改时间: UPDATE_TIME DATETIME */
    public static final String PROP_NAME_updateTime = "updateTime";
    public static final int PROP_ID_updateTime = 22;
    
    /* 修改用户: UPDATE_USER VARCHAR */
    public static final String PROP_NAME_updateUser = "updateUser";
    public static final int PROP_ID_updateUser = 23;
    

    private static int _PROP_ID_BOUND = 24;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[24];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_dbTable] = PROP_NAME_dbTable;
          PROP_NAME_TO_ID.put(PROP_NAME_dbTable, PROP_ID_dbTable);
      
          PROP_ID_TO_NAME[PROP_ID_dbTableKey] = PROP_NAME_dbTableKey;
          PROP_NAME_TO_ID.put(PROP_NAME_dbTableKey, PROP_ID_dbTableKey);
      
          PROP_ID_TO_NAME[PROP_ID_pluginName] = PROP_NAME_pluginName;
          PROP_NAME_TO_ID.put(PROP_NAME_pluginName, PROP_ID_pluginName);
      
          PROP_ID_TO_NAME[PROP_ID_moduleName] = PROP_NAME_moduleName;
          PROP_NAME_TO_ID.put(PROP_NAME_moduleName, PROP_ID_moduleName);
      
          PROP_ID_TO_NAME[PROP_ID_tablePrefix] = PROP_NAME_tablePrefix;
          PROP_NAME_TO_ID.put(PROP_NAME_tablePrefix, PROP_ID_tablePrefix);
      
          PROP_ID_TO_NAME[PROP_ID_generateType] = PROP_NAME_generateType;
          PROP_NAME_TO_ID.put(PROP_NAME_generateType, PROP_ID_generateType);
      
          PROP_ID_TO_NAME[PROP_ID_module] = PROP_NAME_module;
          PROP_NAME_TO_ID.put(PROP_NAME_module, PROP_ID_module);
      
          PROP_ID_TO_NAME[PROP_ID_menuPid] = PROP_NAME_menuPid;
          PROP_NAME_TO_ID.put(PROP_NAME_menuPid, PROP_ID_menuPid);
      
          PROP_ID_TO_NAME[PROP_ID_mobileModule] = PROP_NAME_mobileModule;
          PROP_NAME_TO_ID.put(PROP_NAME_mobileModule, PROP_ID_mobileModule);
      
          PROP_ID_TO_NAME[PROP_ID_functionName] = PROP_NAME_functionName;
          PROP_NAME_TO_ID.put(PROP_NAME_functionName, PROP_ID_functionName);
      
          PROP_ID_TO_NAME[PROP_ID_busName] = PROP_NAME_busName;
          PROP_NAME_TO_ID.put(PROP_NAME_busName, PROP_ID_busName);
      
          PROP_ID_TO_NAME[PROP_ID_className] = PROP_NAME_className;
          PROP_NAME_TO_ID.put(PROP_NAME_className, PROP_ID_className);
      
          PROP_ID_TO_NAME[PROP_ID_formLayout] = PROP_NAME_formLayout;
          PROP_NAME_TO_ID.put(PROP_NAME_formLayout, PROP_ID_formLayout);
      
          PROP_ID_TO_NAME[PROP_ID_gridWhether] = PROP_NAME_gridWhether;
          PROP_NAME_TO_ID.put(PROP_NAME_gridWhether, PROP_ID_gridWhether);
      
          PROP_ID_TO_NAME[PROP_ID_packageName] = PROP_NAME_packageName;
          PROP_NAME_TO_ID.put(PROP_NAME_packageName, PROP_ID_packageName);
      
          PROP_ID_TO_NAME[PROP_ID_authorName] = PROP_NAME_authorName;
          PROP_NAME_TO_ID.put(PROP_NAME_authorName, PROP_ID_authorName);
      
          PROP_ID_TO_NAME[PROP_ID_sortCode] = PROP_NAME_sortCode;
          PROP_NAME_TO_ID.put(PROP_NAME_sortCode, PROP_ID_sortCode);
      
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
    
    /* 主表: DB_TABLE */
    private java.lang.String _dbTable;
    
    /* 主表主键: DB_TABLE_KEY */
    private java.lang.String _dbTableKey;
    
    /* 插件名: PLUGIN_NAME */
    private java.lang.String _pluginName;
    
    /* 模块名: MODULE_NAME */
    private java.lang.String _moduleName;
    
    /* 移除表前缀: TABLE_PREFIX */
    private java.lang.String _tablePrefix;
    
    /* 生成方式: GENERATE_TYPE */
    private java.lang.String _generateType;
    
    /* 所属模块: MODULE */
    private java.lang.String _module;
    
    /* 上级目录: MENU_PID */
    private java.lang.String _menuPid;
    
    /* 移动端所属模块: MOBILE_MODULE */
    private java.lang.String _mobileModule;
    
    /* 功能名: FUNCTION_NAME */
    private java.lang.String _functionName;
    
    /* 业务名: BUS_NAME */
    private java.lang.String _busName;
    
    /* 类名: CLASS_NAME */
    private java.lang.String _className;
    
    /* 表单布局: FORM_LAYOUT */
    private java.lang.String _formLayout;
    
    /* 使用栅格: GRID_WHETHER */
    private java.lang.String _gridWhether;
    
    /* 包名: PACKAGE_NAME */
    private java.lang.String _packageName;
    
    /* 作者: AUTHOR_NAME */
    private java.lang.String _authorName;
    
    /* 排序: SORT_CODE */
    private java.lang.Integer _sortCode;
    
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
    

    public _GenBasic(){
        // for debug
    }

    protected GenBasic newInstance(){
        GenBasic entity = new GenBasic();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public GenBasic cloneInstance() {
        GenBasic entity = newInstance();
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
      return "com.fliad.resource.dao.entity.GenBasic";
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
        
            case PROP_ID_dbTable:
               return getDbTable();
        
            case PROP_ID_dbTableKey:
               return getDbTableKey();
        
            case PROP_ID_pluginName:
               return getPluginName();
        
            case PROP_ID_moduleName:
               return getModuleName();
        
            case PROP_ID_tablePrefix:
               return getTablePrefix();
        
            case PROP_ID_generateType:
               return getGenerateType();
        
            case PROP_ID_module:
               return getModule();
        
            case PROP_ID_menuPid:
               return getMenuPid();
        
            case PROP_ID_mobileModule:
               return getMobileModule();
        
            case PROP_ID_functionName:
               return getFunctionName();
        
            case PROP_ID_busName:
               return getBusName();
        
            case PROP_ID_className:
               return getClassName();
        
            case PROP_ID_formLayout:
               return getFormLayout();
        
            case PROP_ID_gridWhether:
               return getGridWhether();
        
            case PROP_ID_packageName:
               return getPackageName();
        
            case PROP_ID_authorName:
               return getAuthorName();
        
            case PROP_ID_sortCode:
               return getSortCode();
        
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
        
            case PROP_ID_dbTable:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_dbTable));
               }
               setDbTable(typedValue);
               break;
            }
        
            case PROP_ID_dbTableKey:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_dbTableKey));
               }
               setDbTableKey(typedValue);
               break;
            }
        
            case PROP_ID_pluginName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_pluginName));
               }
               setPluginName(typedValue);
               break;
            }
        
            case PROP_ID_moduleName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_moduleName));
               }
               setModuleName(typedValue);
               break;
            }
        
            case PROP_ID_tablePrefix:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_tablePrefix));
               }
               setTablePrefix(typedValue);
               break;
            }
        
            case PROP_ID_generateType:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_generateType));
               }
               setGenerateType(typedValue);
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
        
            case PROP_ID_menuPid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_menuPid));
               }
               setMenuPid(typedValue);
               break;
            }
        
            case PROP_ID_mobileModule:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_mobileModule));
               }
               setMobileModule(typedValue);
               break;
            }
        
            case PROP_ID_functionName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_functionName));
               }
               setFunctionName(typedValue);
               break;
            }
        
            case PROP_ID_busName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_busName));
               }
               setBusName(typedValue);
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
        
            case PROP_ID_formLayout:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_formLayout));
               }
               setFormLayout(typedValue);
               break;
            }
        
            case PROP_ID_gridWhether:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_gridWhether));
               }
               setGridWhether(typedValue);
               break;
            }
        
            case PROP_ID_packageName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_packageName));
               }
               setPackageName(typedValue);
               break;
            }
        
            case PROP_ID_authorName:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_authorName));
               }
               setAuthorName(typedValue);
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
        
            case PROP_ID_dbTable:{
               onInitProp(propId);
               this._dbTable = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_dbTableKey:{
               onInitProp(propId);
               this._dbTableKey = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_pluginName:{
               onInitProp(propId);
               this._pluginName = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_moduleName:{
               onInitProp(propId);
               this._moduleName = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_tablePrefix:{
               onInitProp(propId);
               this._tablePrefix = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_generateType:{
               onInitProp(propId);
               this._generateType = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_module:{
               onInitProp(propId);
               this._module = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_menuPid:{
               onInitProp(propId);
               this._menuPid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_mobileModule:{
               onInitProp(propId);
               this._mobileModule = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_functionName:{
               onInitProp(propId);
               this._functionName = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_busName:{
               onInitProp(propId);
               this._busName = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_className:{
               onInitProp(propId);
               this._className = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_formLayout:{
               onInitProp(propId);
               this._formLayout = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_gridWhether:{
               onInitProp(propId);
               this._gridWhether = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_packageName:{
               onInitProp(propId);
               this._packageName = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_authorName:{
               onInitProp(propId);
               this._authorName = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_sortCode:{
               onInitProp(propId);
               this._sortCode = (java.lang.Integer)value;
               
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
     * 主表: DB_TABLE
     */
    public final java.lang.String getDbTable(){
         onPropGet(PROP_ID_dbTable);
         return _dbTable;
    }

    /**
     * 主表: DB_TABLE
     */
    public final void setDbTable(java.lang.String value){
        if(onPropSet(PROP_ID_dbTable,value)){
            this._dbTable = value;
            internalClearRefs(PROP_ID_dbTable);
            
        }
    }
    
    /**
     * 主表主键: DB_TABLE_KEY
     */
    public final java.lang.String getDbTableKey(){
         onPropGet(PROP_ID_dbTableKey);
         return _dbTableKey;
    }

    /**
     * 主表主键: DB_TABLE_KEY
     */
    public final void setDbTableKey(java.lang.String value){
        if(onPropSet(PROP_ID_dbTableKey,value)){
            this._dbTableKey = value;
            internalClearRefs(PROP_ID_dbTableKey);
            
        }
    }
    
    /**
     * 插件名: PLUGIN_NAME
     */
    public final java.lang.String getPluginName(){
         onPropGet(PROP_ID_pluginName);
         return _pluginName;
    }

    /**
     * 插件名: PLUGIN_NAME
     */
    public final void setPluginName(java.lang.String value){
        if(onPropSet(PROP_ID_pluginName,value)){
            this._pluginName = value;
            internalClearRefs(PROP_ID_pluginName);
            
        }
    }
    
    /**
     * 模块名: MODULE_NAME
     */
    public final java.lang.String getModuleName(){
         onPropGet(PROP_ID_moduleName);
         return _moduleName;
    }

    /**
     * 模块名: MODULE_NAME
     */
    public final void setModuleName(java.lang.String value){
        if(onPropSet(PROP_ID_moduleName,value)){
            this._moduleName = value;
            internalClearRefs(PROP_ID_moduleName);
            
        }
    }
    
    /**
     * 移除表前缀: TABLE_PREFIX
     */
    public final java.lang.String getTablePrefix(){
         onPropGet(PROP_ID_tablePrefix);
         return _tablePrefix;
    }

    /**
     * 移除表前缀: TABLE_PREFIX
     */
    public final void setTablePrefix(java.lang.String value){
        if(onPropSet(PROP_ID_tablePrefix,value)){
            this._tablePrefix = value;
            internalClearRefs(PROP_ID_tablePrefix);
            
        }
    }
    
    /**
     * 生成方式: GENERATE_TYPE
     */
    public final java.lang.String getGenerateType(){
         onPropGet(PROP_ID_generateType);
         return _generateType;
    }

    /**
     * 生成方式: GENERATE_TYPE
     */
    public final void setGenerateType(java.lang.String value){
        if(onPropSet(PROP_ID_generateType,value)){
            this._generateType = value;
            internalClearRefs(PROP_ID_generateType);
            
        }
    }
    
    /**
     * 所属模块: MODULE
     */
    public final java.lang.String getModule(){
         onPropGet(PROP_ID_module);
         return _module;
    }

    /**
     * 所属模块: MODULE
     */
    public final void setModule(java.lang.String value){
        if(onPropSet(PROP_ID_module,value)){
            this._module = value;
            internalClearRefs(PROP_ID_module);
            
        }
    }
    
    /**
     * 上级目录: MENU_PID
     */
    public final java.lang.String getMenuPid(){
         onPropGet(PROP_ID_menuPid);
         return _menuPid;
    }

    /**
     * 上级目录: MENU_PID
     */
    public final void setMenuPid(java.lang.String value){
        if(onPropSet(PROP_ID_menuPid,value)){
            this._menuPid = value;
            internalClearRefs(PROP_ID_menuPid);
            
        }
    }
    
    /**
     * 移动端所属模块: MOBILE_MODULE
     */
    public final java.lang.String getMobileModule(){
         onPropGet(PROP_ID_mobileModule);
         return _mobileModule;
    }

    /**
     * 移动端所属模块: MOBILE_MODULE
     */
    public final void setMobileModule(java.lang.String value){
        if(onPropSet(PROP_ID_mobileModule,value)){
            this._mobileModule = value;
            internalClearRefs(PROP_ID_mobileModule);
            
        }
    }
    
    /**
     * 功能名: FUNCTION_NAME
     */
    public final java.lang.String getFunctionName(){
         onPropGet(PROP_ID_functionName);
         return _functionName;
    }

    /**
     * 功能名: FUNCTION_NAME
     */
    public final void setFunctionName(java.lang.String value){
        if(onPropSet(PROP_ID_functionName,value)){
            this._functionName = value;
            internalClearRefs(PROP_ID_functionName);
            
        }
    }
    
    /**
     * 业务名: BUS_NAME
     */
    public final java.lang.String getBusName(){
         onPropGet(PROP_ID_busName);
         return _busName;
    }

    /**
     * 业务名: BUS_NAME
     */
    public final void setBusName(java.lang.String value){
        if(onPropSet(PROP_ID_busName,value)){
            this._busName = value;
            internalClearRefs(PROP_ID_busName);
            
        }
    }
    
    /**
     * 类名: CLASS_NAME
     */
    public final java.lang.String getClassName(){
         onPropGet(PROP_ID_className);
         return _className;
    }

    /**
     * 类名: CLASS_NAME
     */
    public final void setClassName(java.lang.String value){
        if(onPropSet(PROP_ID_className,value)){
            this._className = value;
            internalClearRefs(PROP_ID_className);
            
        }
    }
    
    /**
     * 表单布局: FORM_LAYOUT
     */
    public final java.lang.String getFormLayout(){
         onPropGet(PROP_ID_formLayout);
         return _formLayout;
    }

    /**
     * 表单布局: FORM_LAYOUT
     */
    public final void setFormLayout(java.lang.String value){
        if(onPropSet(PROP_ID_formLayout,value)){
            this._formLayout = value;
            internalClearRefs(PROP_ID_formLayout);
            
        }
    }
    
    /**
     * 使用栅格: GRID_WHETHER
     */
    public final java.lang.String getGridWhether(){
         onPropGet(PROP_ID_gridWhether);
         return _gridWhether;
    }

    /**
     * 使用栅格: GRID_WHETHER
     */
    public final void setGridWhether(java.lang.String value){
        if(onPropSet(PROP_ID_gridWhether,value)){
            this._gridWhether = value;
            internalClearRefs(PROP_ID_gridWhether);
            
        }
    }
    
    /**
     * 包名: PACKAGE_NAME
     */
    public final java.lang.String getPackageName(){
         onPropGet(PROP_ID_packageName);
         return _packageName;
    }

    /**
     * 包名: PACKAGE_NAME
     */
    public final void setPackageName(java.lang.String value){
        if(onPropSet(PROP_ID_packageName,value)){
            this._packageName = value;
            internalClearRefs(PROP_ID_packageName);
            
        }
    }
    
    /**
     * 作者: AUTHOR_NAME
     */
    public final java.lang.String getAuthorName(){
         onPropGet(PROP_ID_authorName);
         return _authorName;
    }

    /**
     * 作者: AUTHOR_NAME
     */
    public final void setAuthorName(java.lang.String value){
        if(onPropSet(PROP_ID_authorName,value)){
            this._authorName = value;
            internalClearRefs(PROP_ID_authorName);
            
        }
    }
    
    /**
     * 排序: SORT_CODE
     */
    public final java.lang.Integer getSortCode(){
         onPropGet(PROP_ID_sortCode);
         return _sortCode;
    }

    /**
     * 排序: SORT_CODE
     */
    public final void setSortCode(java.lang.Integer value){
        if(onPropSet(PROP_ID_sortCode,value)){
            this._sortCode = value;
            internalClearRefs(PROP_ID_sortCode);
            
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

package com.fliad.viid.dao.entity._gen;

import io.nop.orm.model.IEntityModel;
import io.nop.orm.support.DynamicOrmEntity;
import io.nop.orm.support.OrmEntitySet; //NOPMD - suppressed UnusedImports - Auto Gen Code
import io.nop.orm.IOrmEntitySet; //NOPMD - suppressed UnusedImports - Auto Gen Code
import io.nop.api.core.convert.ConvertHelper;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

import com.fliad.viid.dao.entity.ViidApe;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  采集设备表: viid_ape
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _ViidApe extends DynamicOrmEntity{
    
    /* 主键: ID VARCHAR */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 设备唯一标识（DeviceIDType）: APEID VARCHAR */
    public static final String PROP_NAME_apeid = "apeid";
    public static final int PROP_ID_apeid = 2;
    
    /* 设备名称: NAME VARCHAR */
    public static final String PROP_NAME_name = "name";
    public static final int PROP_ID_name = 3;
    
    /* 设备型号: MODEL VARCHAR */
    public static final String PROP_NAME_model = "model";
    public static final int PROP_ID_model = 4;
    
    /* IPv4地址: IPADDR VARCHAR */
    public static final String PROP_NAME_ipaddr = "ipaddr";
    public static final int PROP_ID_ipaddr = 5;
    
    /* IPv6地址: IPV6ADDR VARCHAR */
    public static final String PROP_NAME_ipv6addr = "ipv6addr";
    public static final int PROP_ID_ipv6addr = 6;
    
    /* 网络端口号: PORT INTEGER */
    public static final String PROP_NAME_port = "port";
    public static final int PROP_ID_port = 7;
    
    /* 经度（-180~180，保留6位小数）: LONGITUDE DECIMAL */
    public static final String PROP_NAME_longitude = "longitude";
    public static final int PROP_ID_longitude = 8;
    
    /* 纬度（-90~90，保留6位小数）: LATITUDE DECIMAL */
    public static final String PROP_NAME_latitude = "latitude";
    public static final int PROP_ID_latitude = 9;
    
    /* 安装地点行政区划代码（GB/T 2260）: PLACECODE VARCHAR */
    public static final String PROP_NAME_placecode = "placecode";
    public static final int PROP_ID_placecode = 10;
    
    /* 具体位置描述（乡镇街道+街路巷+门楼牌号+详细地址）: PLACE VARCHAR */
    public static final String PROP_NAME_place = "place";
    public static final int PROP_ID_place = 11;
    
    /* 管辖单位代码: ORGCODE VARCHAR */
    public static final String PROP_NAME_orgcode = "orgcode";
    public static final int PROP_ID_orgcode = 12;
    
    /* 车辆抓拍方向：0=拍车头，1=拍车尾，兼容无视频卡口信息设备: CAPDIRECTION BOOLEAN */
    public static final String PROP_NAME_capdirection = "capdirection";
    public static final int PROP_ID_capdirection = 13;
    
    /* 监视方向（如东、东北）: MONITORDIRECTION VARCHAR */
    public static final String PROP_NAME_monitordirection = "monitordirection";
    public static final int PROP_ID_monitordirection = 14;
    
    /* 监视区域说明: MONITORAREADESC VARCHAR */
    public static final String PROP_NAME_monitorareadesc = "monitorareadesc";
    public static final int PROP_ID_monitorareadesc = 15;
    
    /* 设备在线状态：1=在线，0=离线: ISONLINE BOOLEAN */
    public static final String PROP_NAME_isonline = "isonline";
    public static final int PROP_ID_isonline = 16;
    
    /* 所属采集系统设备ID: OWNERAPSID VARCHAR */
    public static final String PROP_NAME_ownerapsid = "ownerapsid";
    public static final int PROP_ID_ownerapsid = 17;
    
    /* 设备登录账号: USERID VARCHAR */
    public static final String PROP_NAME_userid = "userid";
    public static final int PROP_ID_userid = 18;
    
    /* 设备登录密码（建议加密存储）: PASSWORD VARCHAR */
    public static final String PROP_NAME_password = "password";
    public static final int PROP_ID_password = 19;
    
    /* 功能类型（多选，/分隔：1=车辆卡口,2=人员卡口,3=微卡口,4=特征摄像机,5=普通监控,6=高空瞭望摄像机,99=其他）: FUNCTIONTYPE VARCHAR */
    public static final String PROP_NAME_functiontype = "functiontype";
    public static final int PROP_ID_functiontype = 20;
    
    /* 位置类型（多选，/分隔：1=省际检查站,2=党政机关,3=车站码头,4=中心广场,5=体育场馆,6=商业中心,7=宗教场所,8=校园周边,9=治安复杂区域,10=交通干线,11=医院周边,12=金融机构周边,13=危险物品场所周边,14=博物馆展览馆,15=重点水域、航道,96=市际公安检查站,97=涉外场所,98=边境沿线,99=旅游景区）: POSITIONTYPE VARCHAR */
    public static final String PROP_NAME_positiontype = "positiontype";
    public static final int PROP_ID_positiontype = 21;
    
    /* 记录创建时间: CREATE_TIME DATETIME */
    public static final String PROP_NAME_createTime = "createTime";
    public static final int PROP_ID_createTime = 22;
    
    /* 记录最后更新时间: UPDATE_TIME DATETIME */
    public static final String PROP_NAME_updateTime = "updateTime";
    public static final int PROP_ID_updateTime = 23;
    

    private static int _PROP_ID_BOUND = 24;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[24];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_apeid] = PROP_NAME_apeid;
          PROP_NAME_TO_ID.put(PROP_NAME_apeid, PROP_ID_apeid);
      
          PROP_ID_TO_NAME[PROP_ID_name] = PROP_NAME_name;
          PROP_NAME_TO_ID.put(PROP_NAME_name, PROP_ID_name);
      
          PROP_ID_TO_NAME[PROP_ID_model] = PROP_NAME_model;
          PROP_NAME_TO_ID.put(PROP_NAME_model, PROP_ID_model);
      
          PROP_ID_TO_NAME[PROP_ID_ipaddr] = PROP_NAME_ipaddr;
          PROP_NAME_TO_ID.put(PROP_NAME_ipaddr, PROP_ID_ipaddr);
      
          PROP_ID_TO_NAME[PROP_ID_ipv6addr] = PROP_NAME_ipv6addr;
          PROP_NAME_TO_ID.put(PROP_NAME_ipv6addr, PROP_ID_ipv6addr);
      
          PROP_ID_TO_NAME[PROP_ID_port] = PROP_NAME_port;
          PROP_NAME_TO_ID.put(PROP_NAME_port, PROP_ID_port);
      
          PROP_ID_TO_NAME[PROP_ID_longitude] = PROP_NAME_longitude;
          PROP_NAME_TO_ID.put(PROP_NAME_longitude, PROP_ID_longitude);
      
          PROP_ID_TO_NAME[PROP_ID_latitude] = PROP_NAME_latitude;
          PROP_NAME_TO_ID.put(PROP_NAME_latitude, PROP_ID_latitude);
      
          PROP_ID_TO_NAME[PROP_ID_placecode] = PROP_NAME_placecode;
          PROP_NAME_TO_ID.put(PROP_NAME_placecode, PROP_ID_placecode);
      
          PROP_ID_TO_NAME[PROP_ID_place] = PROP_NAME_place;
          PROP_NAME_TO_ID.put(PROP_NAME_place, PROP_ID_place);
      
          PROP_ID_TO_NAME[PROP_ID_orgcode] = PROP_NAME_orgcode;
          PROP_NAME_TO_ID.put(PROP_NAME_orgcode, PROP_ID_orgcode);
      
          PROP_ID_TO_NAME[PROP_ID_capdirection] = PROP_NAME_capdirection;
          PROP_NAME_TO_ID.put(PROP_NAME_capdirection, PROP_ID_capdirection);
      
          PROP_ID_TO_NAME[PROP_ID_monitordirection] = PROP_NAME_monitordirection;
          PROP_NAME_TO_ID.put(PROP_NAME_monitordirection, PROP_ID_monitordirection);
      
          PROP_ID_TO_NAME[PROP_ID_monitorareadesc] = PROP_NAME_monitorareadesc;
          PROP_NAME_TO_ID.put(PROP_NAME_monitorareadesc, PROP_ID_monitorareadesc);
      
          PROP_ID_TO_NAME[PROP_ID_isonline] = PROP_NAME_isonline;
          PROP_NAME_TO_ID.put(PROP_NAME_isonline, PROP_ID_isonline);
      
          PROP_ID_TO_NAME[PROP_ID_ownerapsid] = PROP_NAME_ownerapsid;
          PROP_NAME_TO_ID.put(PROP_NAME_ownerapsid, PROP_ID_ownerapsid);
      
          PROP_ID_TO_NAME[PROP_ID_userid] = PROP_NAME_userid;
          PROP_NAME_TO_ID.put(PROP_NAME_userid, PROP_ID_userid);
      
          PROP_ID_TO_NAME[PROP_ID_password] = PROP_NAME_password;
          PROP_NAME_TO_ID.put(PROP_NAME_password, PROP_ID_password);
      
          PROP_ID_TO_NAME[PROP_ID_functiontype] = PROP_NAME_functiontype;
          PROP_NAME_TO_ID.put(PROP_NAME_functiontype, PROP_ID_functiontype);
      
          PROP_ID_TO_NAME[PROP_ID_positiontype] = PROP_NAME_positiontype;
          PROP_NAME_TO_ID.put(PROP_NAME_positiontype, PROP_ID_positiontype);
      
          PROP_ID_TO_NAME[PROP_ID_createTime] = PROP_NAME_createTime;
          PROP_NAME_TO_ID.put(PROP_NAME_createTime, PROP_ID_createTime);
      
          PROP_ID_TO_NAME[PROP_ID_updateTime] = PROP_NAME_updateTime;
          PROP_NAME_TO_ID.put(PROP_NAME_updateTime, PROP_ID_updateTime);
      
    }

    
    /* 主键: ID */
    private java.lang.String _id_;
    
    /* 设备唯一标识（DeviceIDType）: APEID */
    private java.lang.String _apeid;
    
    /* 设备名称: NAME */
    private java.lang.String _name;
    
    /* 设备型号: MODEL */
    private java.lang.String _model;
    
    /* IPv4地址: IPADDR */
    private java.lang.String _ipaddr;
    
    /* IPv6地址: IPV6ADDR */
    private java.lang.String _ipv6addr;
    
    /* 网络端口号: PORT */
    private java.lang.Integer _port;
    
    /* 经度（-180~180，保留6位小数）: LONGITUDE */
    private java.math.BigDecimal _longitude;
    
    /* 纬度（-90~90，保留6位小数）: LATITUDE */
    private java.math.BigDecimal _latitude;
    
    /* 安装地点行政区划代码（GB/T 2260）: PLACECODE */
    private java.lang.String _placecode;
    
    /* 具体位置描述（乡镇街道+街路巷+门楼牌号+详细地址）: PLACE */
    private java.lang.String _place;
    
    /* 管辖单位代码: ORGCODE */
    private java.lang.String _orgcode;
    
    /* 车辆抓拍方向：0=拍车头，1=拍车尾，兼容无视频卡口信息设备: CAPDIRECTION */
    private java.lang.Boolean _capdirection;
    
    /* 监视方向（如东、东北）: MONITORDIRECTION */
    private java.lang.String _monitordirection;
    
    /* 监视区域说明: MONITORAREADESC */
    private java.lang.String _monitorareadesc;
    
    /* 设备在线状态：1=在线，0=离线: ISONLINE */
    private java.lang.Boolean _isonline;
    
    /* 所属采集系统设备ID: OWNERAPSID */
    private java.lang.String _ownerapsid;
    
    /* 设备登录账号: USERID */
    private java.lang.String _userid;
    
    /* 设备登录密码（建议加密存储）: PASSWORD */
    private java.lang.String _password;
    
    /* 功能类型（多选，/分隔：1=车辆卡口,2=人员卡口,3=微卡口,4=特征摄像机,5=普通监控,6=高空瞭望摄像机,99=其他）: FUNCTIONTYPE */
    private java.lang.String _functiontype;
    
    /* 位置类型（多选，/分隔：1=省际检查站,2=党政机关,3=车站码头,4=中心广场,5=体育场馆,6=商业中心,7=宗教场所,8=校园周边,9=治安复杂区域,10=交通干线,11=医院周边,12=金融机构周边,13=危险物品场所周边,14=博物馆展览馆,15=重点水域、航道,96=市际公安检查站,97=涉外场所,98=边境沿线,99=旅游景区）: POSITIONTYPE */
    private java.lang.String _positiontype;
    
    /* 记录创建时间: CREATE_TIME */
    private java.time.LocalDateTime _createTime;
    
    /* 记录最后更新时间: UPDATE_TIME */
    private java.time.LocalDateTime _updateTime;
    

    public _ViidApe(){
        // for debug
    }

    protected ViidApe newInstance(){
        ViidApe entity = new ViidApe();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public ViidApe cloneInstance() {
        ViidApe entity = newInstance();
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
      return "com.fliad.viid.dao.entity.ViidApe";
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
        
            case PROP_ID_apeid:
               return getApeid();
        
            case PROP_ID_name:
               return getName();
        
            case PROP_ID_model:
               return getModel();
        
            case PROP_ID_ipaddr:
               return getIpaddr();
        
            case PROP_ID_ipv6addr:
               return getIpv6addr();
        
            case PROP_ID_port:
               return getPort();
        
            case PROP_ID_longitude:
               return getLongitude();
        
            case PROP_ID_latitude:
               return getLatitude();
        
            case PROP_ID_placecode:
               return getPlacecode();
        
            case PROP_ID_place:
               return getPlace();
        
            case PROP_ID_orgcode:
               return getOrgcode();
        
            case PROP_ID_capdirection:
               return getCapdirection();
        
            case PROP_ID_monitordirection:
               return getMonitordirection();
        
            case PROP_ID_monitorareadesc:
               return getMonitorareadesc();
        
            case PROP_ID_isonline:
               return getIsonline();
        
            case PROP_ID_ownerapsid:
               return getOwnerapsid();
        
            case PROP_ID_userid:
               return getUserid();
        
            case PROP_ID_password:
               return getPassword();
        
            case PROP_ID_functiontype:
               return getFunctiontype();
        
            case PROP_ID_positiontype:
               return getPositiontype();
        
            case PROP_ID_createTime:
               return getCreateTime();
        
            case PROP_ID_updateTime:
               return getUpdateTime();
        
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
        
            case PROP_ID_apeid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_apeid));
               }
               setApeid(typedValue);
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
        
            case PROP_ID_model:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_model));
               }
               setModel(typedValue);
               break;
            }
        
            case PROP_ID_ipaddr:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_ipaddr));
               }
               setIpaddr(typedValue);
               break;
            }
        
            case PROP_ID_ipv6addr:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_ipv6addr));
               }
               setIpv6addr(typedValue);
               break;
            }
        
            case PROP_ID_port:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_port));
               }
               setPort(typedValue);
               break;
            }
        
            case PROP_ID_longitude:{
               java.math.BigDecimal typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toBigDecimal(value,
                       err-> newTypeConversionError(PROP_NAME_longitude));
               }
               setLongitude(typedValue);
               break;
            }
        
            case PROP_ID_latitude:{
               java.math.BigDecimal typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toBigDecimal(value,
                       err-> newTypeConversionError(PROP_NAME_latitude));
               }
               setLatitude(typedValue);
               break;
            }
        
            case PROP_ID_placecode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_placecode));
               }
               setPlacecode(typedValue);
               break;
            }
        
            case PROP_ID_place:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_place));
               }
               setPlace(typedValue);
               break;
            }
        
            case PROP_ID_orgcode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_orgcode));
               }
               setOrgcode(typedValue);
               break;
            }
        
            case PROP_ID_capdirection:{
               java.lang.Boolean typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toBoolean(value,
                       err-> newTypeConversionError(PROP_NAME_capdirection));
               }
               setCapdirection(typedValue);
               break;
            }
        
            case PROP_ID_monitordirection:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_monitordirection));
               }
               setMonitordirection(typedValue);
               break;
            }
        
            case PROP_ID_monitorareadesc:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_monitorareadesc));
               }
               setMonitorareadesc(typedValue);
               break;
            }
        
            case PROP_ID_isonline:{
               java.lang.Boolean typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toBoolean(value,
                       err-> newTypeConversionError(PROP_NAME_isonline));
               }
               setIsonline(typedValue);
               break;
            }
        
            case PROP_ID_ownerapsid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_ownerapsid));
               }
               setOwnerapsid(typedValue);
               break;
            }
        
            case PROP_ID_userid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_userid));
               }
               setUserid(typedValue);
               break;
            }
        
            case PROP_ID_password:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_password));
               }
               setPassword(typedValue);
               break;
            }
        
            case PROP_ID_functiontype:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_functiontype));
               }
               setFunctiontype(typedValue);
               break;
            }
        
            case PROP_ID_positiontype:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_positiontype));
               }
               setPositiontype(typedValue);
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
        
            case PROP_ID_apeid:{
               onInitProp(propId);
               this._apeid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_name:{
               onInitProp(propId);
               this._name = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_model:{
               onInitProp(propId);
               this._model = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_ipaddr:{
               onInitProp(propId);
               this._ipaddr = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_ipv6addr:{
               onInitProp(propId);
               this._ipv6addr = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_port:{
               onInitProp(propId);
               this._port = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_longitude:{
               onInitProp(propId);
               this._longitude = (java.math.BigDecimal)value;
               
               break;
            }
        
            case PROP_ID_latitude:{
               onInitProp(propId);
               this._latitude = (java.math.BigDecimal)value;
               
               break;
            }
        
            case PROP_ID_placecode:{
               onInitProp(propId);
               this._placecode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_place:{
               onInitProp(propId);
               this._place = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_orgcode:{
               onInitProp(propId);
               this._orgcode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_capdirection:{
               onInitProp(propId);
               this._capdirection = (java.lang.Boolean)value;
               
               break;
            }
        
            case PROP_ID_monitordirection:{
               onInitProp(propId);
               this._monitordirection = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_monitorareadesc:{
               onInitProp(propId);
               this._monitorareadesc = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_isonline:{
               onInitProp(propId);
               this._isonline = (java.lang.Boolean)value;
               
               break;
            }
        
            case PROP_ID_ownerapsid:{
               onInitProp(propId);
               this._ownerapsid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_userid:{
               onInitProp(propId);
               this._userid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_password:{
               onInitProp(propId);
               this._password = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_functiontype:{
               onInitProp(propId);
               this._functiontype = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_positiontype:{
               onInitProp(propId);
               this._positiontype = (java.lang.String)value;
               
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
     * 设备唯一标识（DeviceIDType）: APEID
     */
    public final java.lang.String getApeid(){
         onPropGet(PROP_ID_apeid);
         return _apeid;
    }

    /**
     * 设备唯一标识（DeviceIDType）: APEID
     */
    public final void setApeid(java.lang.String value){
        if(onPropSet(PROP_ID_apeid,value)){
            this._apeid = value;
            internalClearRefs(PROP_ID_apeid);
            
        }
    }
    
    /**
     * 设备名称: NAME
     */
    public final java.lang.String getName(){
         onPropGet(PROP_ID_name);
         return _name;
    }

    /**
     * 设备名称: NAME
     */
    public final void setName(java.lang.String value){
        if(onPropSet(PROP_ID_name,value)){
            this._name = value;
            internalClearRefs(PROP_ID_name);
            
        }
    }
    
    /**
     * 设备型号: MODEL
     */
    public final java.lang.String getModel(){
         onPropGet(PROP_ID_model);
         return _model;
    }

    /**
     * 设备型号: MODEL
     */
    public final void setModel(java.lang.String value){
        if(onPropSet(PROP_ID_model,value)){
            this._model = value;
            internalClearRefs(PROP_ID_model);
            
        }
    }
    
    /**
     * IPv4地址: IPADDR
     */
    public final java.lang.String getIpaddr(){
         onPropGet(PROP_ID_ipaddr);
         return _ipaddr;
    }

    /**
     * IPv4地址: IPADDR
     */
    public final void setIpaddr(java.lang.String value){
        if(onPropSet(PROP_ID_ipaddr,value)){
            this._ipaddr = value;
            internalClearRefs(PROP_ID_ipaddr);
            
        }
    }
    
    /**
     * IPv6地址: IPV6ADDR
     */
    public final java.lang.String getIpv6addr(){
         onPropGet(PROP_ID_ipv6addr);
         return _ipv6addr;
    }

    /**
     * IPv6地址: IPV6ADDR
     */
    public final void setIpv6addr(java.lang.String value){
        if(onPropSet(PROP_ID_ipv6addr,value)){
            this._ipv6addr = value;
            internalClearRefs(PROP_ID_ipv6addr);
            
        }
    }
    
    /**
     * 网络端口号: PORT
     */
    public final java.lang.Integer getPort(){
         onPropGet(PROP_ID_port);
         return _port;
    }

    /**
     * 网络端口号: PORT
     */
    public final void setPort(java.lang.Integer value){
        if(onPropSet(PROP_ID_port,value)){
            this._port = value;
            internalClearRefs(PROP_ID_port);
            
        }
    }
    
    /**
     * 经度（-180~180，保留6位小数）: LONGITUDE
     */
    public final java.math.BigDecimal getLongitude(){
         onPropGet(PROP_ID_longitude);
         return _longitude;
    }

    /**
     * 经度（-180~180，保留6位小数）: LONGITUDE
     */
    public final void setLongitude(java.math.BigDecimal value){
        if(onPropSet(PROP_ID_longitude,value)){
            this._longitude = value;
            internalClearRefs(PROP_ID_longitude);
            
        }
    }
    
    /**
     * 纬度（-90~90，保留6位小数）: LATITUDE
     */
    public final java.math.BigDecimal getLatitude(){
         onPropGet(PROP_ID_latitude);
         return _latitude;
    }

    /**
     * 纬度（-90~90，保留6位小数）: LATITUDE
     */
    public final void setLatitude(java.math.BigDecimal value){
        if(onPropSet(PROP_ID_latitude,value)){
            this._latitude = value;
            internalClearRefs(PROP_ID_latitude);
            
        }
    }
    
    /**
     * 安装地点行政区划代码（GB/T 2260）: PLACECODE
     */
    public final java.lang.String getPlacecode(){
         onPropGet(PROP_ID_placecode);
         return _placecode;
    }

    /**
     * 安装地点行政区划代码（GB/T 2260）: PLACECODE
     */
    public final void setPlacecode(java.lang.String value){
        if(onPropSet(PROP_ID_placecode,value)){
            this._placecode = value;
            internalClearRefs(PROP_ID_placecode);
            
        }
    }
    
    /**
     * 具体位置描述（乡镇街道+街路巷+门楼牌号+详细地址）: PLACE
     */
    public final java.lang.String getPlace(){
         onPropGet(PROP_ID_place);
         return _place;
    }

    /**
     * 具体位置描述（乡镇街道+街路巷+门楼牌号+详细地址）: PLACE
     */
    public final void setPlace(java.lang.String value){
        if(onPropSet(PROP_ID_place,value)){
            this._place = value;
            internalClearRefs(PROP_ID_place);
            
        }
    }
    
    /**
     * 管辖单位代码: ORGCODE
     */
    public final java.lang.String getOrgcode(){
         onPropGet(PROP_ID_orgcode);
         return _orgcode;
    }

    /**
     * 管辖单位代码: ORGCODE
     */
    public final void setOrgcode(java.lang.String value){
        if(onPropSet(PROP_ID_orgcode,value)){
            this._orgcode = value;
            internalClearRefs(PROP_ID_orgcode);
            
        }
    }
    
    /**
     * 车辆抓拍方向：0=拍车头，1=拍车尾，兼容无视频卡口信息设备: CAPDIRECTION
     */
    public final java.lang.Boolean getCapdirection(){
         onPropGet(PROP_ID_capdirection);
         return _capdirection;
    }

    /**
     * 车辆抓拍方向：0=拍车头，1=拍车尾，兼容无视频卡口信息设备: CAPDIRECTION
     */
    public final void setCapdirection(java.lang.Boolean value){
        if(onPropSet(PROP_ID_capdirection,value)){
            this._capdirection = value;
            internalClearRefs(PROP_ID_capdirection);
            
        }
    }
    
    /**
     * 监视方向（如东、东北）: MONITORDIRECTION
     */
    public final java.lang.String getMonitordirection(){
         onPropGet(PROP_ID_monitordirection);
         return _monitordirection;
    }

    /**
     * 监视方向（如东、东北）: MONITORDIRECTION
     */
    public final void setMonitordirection(java.lang.String value){
        if(onPropSet(PROP_ID_monitordirection,value)){
            this._monitordirection = value;
            internalClearRefs(PROP_ID_monitordirection);
            
        }
    }
    
    /**
     * 监视区域说明: MONITORAREADESC
     */
    public final java.lang.String getMonitorareadesc(){
         onPropGet(PROP_ID_monitorareadesc);
         return _monitorareadesc;
    }

    /**
     * 监视区域说明: MONITORAREADESC
     */
    public final void setMonitorareadesc(java.lang.String value){
        if(onPropSet(PROP_ID_monitorareadesc,value)){
            this._monitorareadesc = value;
            internalClearRefs(PROP_ID_monitorareadesc);
            
        }
    }
    
    /**
     * 设备在线状态：1=在线，0=离线: ISONLINE
     */
    public final java.lang.Boolean getIsonline(){
         onPropGet(PROP_ID_isonline);
         return _isonline;
    }

    /**
     * 设备在线状态：1=在线，0=离线: ISONLINE
     */
    public final void setIsonline(java.lang.Boolean value){
        if(onPropSet(PROP_ID_isonline,value)){
            this._isonline = value;
            internalClearRefs(PROP_ID_isonline);
            
        }
    }
    
    /**
     * 所属采集系统设备ID: OWNERAPSID
     */
    public final java.lang.String getOwnerapsid(){
         onPropGet(PROP_ID_ownerapsid);
         return _ownerapsid;
    }

    /**
     * 所属采集系统设备ID: OWNERAPSID
     */
    public final void setOwnerapsid(java.lang.String value){
        if(onPropSet(PROP_ID_ownerapsid,value)){
            this._ownerapsid = value;
            internalClearRefs(PROP_ID_ownerapsid);
            
        }
    }
    
    /**
     * 设备登录账号: USERID
     */
    public final java.lang.String getUserid(){
         onPropGet(PROP_ID_userid);
         return _userid;
    }

    /**
     * 设备登录账号: USERID
     */
    public final void setUserid(java.lang.String value){
        if(onPropSet(PROP_ID_userid,value)){
            this._userid = value;
            internalClearRefs(PROP_ID_userid);
            
        }
    }
    
    /**
     * 设备登录密码（建议加密存储）: PASSWORD
     */
    public final java.lang.String getPassword(){
         onPropGet(PROP_ID_password);
         return _password;
    }

    /**
     * 设备登录密码（建议加密存储）: PASSWORD
     */
    public final void setPassword(java.lang.String value){
        if(onPropSet(PROP_ID_password,value)){
            this._password = value;
            internalClearRefs(PROP_ID_password);
            
        }
    }
    
    /**
     * 功能类型（多选，/分隔：1=车辆卡口,2=人员卡口,3=微卡口,4=特征摄像机,5=普通监控,6=高空瞭望摄像机,99=其他）: FUNCTIONTYPE
     */
    public final java.lang.String getFunctiontype(){
         onPropGet(PROP_ID_functiontype);
         return _functiontype;
    }

    /**
     * 功能类型（多选，/分隔：1=车辆卡口,2=人员卡口,3=微卡口,4=特征摄像机,5=普通监控,6=高空瞭望摄像机,99=其他）: FUNCTIONTYPE
     */
    public final void setFunctiontype(java.lang.String value){
        if(onPropSet(PROP_ID_functiontype,value)){
            this._functiontype = value;
            internalClearRefs(PROP_ID_functiontype);
            
        }
    }
    
    /**
     * 位置类型（多选，/分隔：1=省际检查站,2=党政机关,3=车站码头,4=中心广场,5=体育场馆,6=商业中心,7=宗教场所,8=校园周边,9=治安复杂区域,10=交通干线,11=医院周边,12=金融机构周边,13=危险物品场所周边,14=博物馆展览馆,15=重点水域、航道,96=市际公安检查站,97=涉外场所,98=边境沿线,99=旅游景区）: POSITIONTYPE
     */
    public final java.lang.String getPositiontype(){
         onPropGet(PROP_ID_positiontype);
         return _positiontype;
    }

    /**
     * 位置类型（多选，/分隔：1=省际检查站,2=党政机关,3=车站码头,4=中心广场,5=体育场馆,6=商业中心,7=宗教场所,8=校园周边,9=治安复杂区域,10=交通干线,11=医院周边,12=金融机构周边,13=危险物品场所周边,14=博物馆展览馆,15=重点水域、航道,96=市际公安检查站,97=涉外场所,98=边境沿线,99=旅游景区）: POSITIONTYPE
     */
    public final void setPositiontype(java.lang.String value){
        if(onPropSet(PROP_ID_positiontype,value)){
            this._positiontype = value;
            internalClearRefs(PROP_ID_positiontype);
            
        }
    }
    
    /**
     * 记录创建时间: CREATE_TIME
     */
    public final java.time.LocalDateTime getCreateTime(){
         onPropGet(PROP_ID_createTime);
         return _createTime;
    }

    /**
     * 记录创建时间: CREATE_TIME
     */
    public final void setCreateTime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_createTime,value)){
            this._createTime = value;
            internalClearRefs(PROP_ID_createTime);
            
        }
    }
    
    /**
     * 记录最后更新时间: UPDATE_TIME
     */
    public final java.time.LocalDateTime getUpdateTime(){
         onPropGet(PROP_ID_updateTime);
         return _updateTime;
    }

    /**
     * 记录最后更新时间: UPDATE_TIME
     */
    public final void setUpdateTime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_updateTime,value)){
            this._updateTime = value;
            internalClearRefs(PROP_ID_updateTime);
            
        }
    }
    
}
// resume CPD analysis - CPD-ON

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

import com.fliad.resource.dao.entity.ClientUser;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  C端用户: client_user
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _ClientUser extends DynamicOrmEntity{
    
    /* Id: ID VARCHAR */
    public static final String PROP_NAME_id_ = "id_";
    public static final int PROP_ID_id_ = 1;
    
    /* 头像: AVATAR CLOB */
    public static final String PROP_NAME_avatar = "avatar";
    public static final int PROP_ID_avatar = 2;
    
    /* 签名: SIGNATURE CLOB */
    public static final String PROP_NAME_signature = "signature";
    public static final int PROP_ID_signature = 3;
    
    /* 账号: ACCOUNT VARCHAR */
    public static final String PROP_NAME_account = "account";
    public static final int PROP_ID_account = 4;
    
    /* 密码: PASSWORD VARCHAR */
    public static final String PROP_NAME_password = "password";
    public static final int PROP_ID_password = 5;
    
    /* 姓名: NAME VARCHAR */
    public static final String PROP_NAME_name = "name";
    public static final int PROP_ID_name = 6;
    
    /* 昵称: NICKNAME VARCHAR */
    public static final String PROP_NAME_nickname = "nickname";
    public static final int PROP_ID_nickname = 7;
    
    /* 性别: GENDER VARCHAR */
    public static final String PROP_NAME_gender = "gender";
    public static final int PROP_ID_gender = 8;
    
    /* 年龄: AGE VARCHAR */
    public static final String PROP_NAME_age = "age";
    public static final int PROP_ID_age = 9;
    
    /* 出生日期: BIRTHDAY VARCHAR */
    public static final String PROP_NAME_birthday = "birthday";
    public static final int PROP_ID_birthday = 10;
    
    /* 民族: NATION VARCHAR */
    public static final String PROP_NAME_nation = "nation";
    public static final int PROP_ID_nation = 11;
    
    /* 籍贯: NATIVE_PLACE VARCHAR */
    public static final String PROP_NAME_nativePlace = "nativePlace";
    public static final int PROP_ID_nativePlace = 12;
    
    /* 家庭住址: HOME_ADDRESS VARCHAR */
    public static final String PROP_NAME_homeAddress = "homeAddress";
    public static final int PROP_ID_homeAddress = 13;
    
    /* 通信地址: MAILING_ADDRESS VARCHAR */
    public static final String PROP_NAME_mailingAddress = "mailingAddress";
    public static final int PROP_ID_mailingAddress = 14;
    
    /* 证件类型: ID_CARD_TYPE VARCHAR */
    public static final String PROP_NAME_idCardType = "idCardType";
    public static final int PROP_ID_idCardType = 15;
    
    /* 证件号码: ID_CARD_NUMBER VARCHAR */
    public static final String PROP_NAME_idCardNumber = "idCardNumber";
    public static final int PROP_ID_idCardNumber = 16;
    
    /* 文化程度: CULTURE_LEVEL VARCHAR */
    public static final String PROP_NAME_cultureLevel = "cultureLevel";
    public static final int PROP_ID_cultureLevel = 17;
    
    /* 政治面貌: POLITICAL_OUTLOOK VARCHAR */
    public static final String PROP_NAME_politicalOutlook = "politicalOutlook";
    public static final int PROP_ID_politicalOutlook = 18;
    
    /* 毕业院校: COLLEGE VARCHAR */
    public static final String PROP_NAME_college = "college";
    public static final int PROP_ID_college = 19;
    
    /* 学历: EDUCATION VARCHAR */
    public static final String PROP_NAME_education = "education";
    public static final int PROP_ID_education = 20;
    
    /* 学制: EDU_LENGTH VARCHAR */
    public static final String PROP_NAME_eduLength = "eduLength";
    public static final int PROP_ID_eduLength = 21;
    
    /* 学位: DEGREE VARCHAR */
    public static final String PROP_NAME_degree = "degree";
    public static final int PROP_ID_degree = 22;
    
    /* 手机: PHONE VARCHAR */
    public static final String PROP_NAME_phone = "phone";
    public static final int PROP_ID_phone = 23;
    
    /* 邮箱: EMAIL VARCHAR */
    public static final String PROP_NAME_email = "email";
    public static final int PROP_ID_email = 24;
    
    /* 家庭电话: HOME_TEL VARCHAR */
    public static final String PROP_NAME_homeTel = "homeTel";
    public static final int PROP_ID_homeTel = 25;
    
    /* 办公电话: OFFICE_TEL VARCHAR */
    public static final String PROP_NAME_officeTel = "officeTel";
    public static final int PROP_ID_officeTel = 26;
    
    /* 紧急联系人: EMERGENCY_CONTACT VARCHAR */
    public static final String PROP_NAME_emergencyContact = "emergencyContact";
    public static final int PROP_ID_emergencyContact = 27;
    
    /* 紧急联系人电话: EMERGENCY_PHONE VARCHAR */
    public static final String PROP_NAME_emergencyPhone = "emergencyPhone";
    public static final int PROP_ID_emergencyPhone = 28;
    
    /* 紧急联系人地址: EMERGENCY_ADDRESS VARCHAR */
    public static final String PROP_NAME_emergencyAddress = "emergencyAddress";
    public static final int PROP_ID_emergencyAddress = 29;
    
    /* 上次登录ip: LAST_LOGIN_IP VARCHAR */
    public static final String PROP_NAME_lastLoginIp = "lastLoginIp";
    public static final int PROP_ID_lastLoginIp = 30;
    
    /* 上次登录地点: LAST_LOGIN_ADDRESS VARCHAR */
    public static final String PROP_NAME_lastLoginAddress = "lastLoginAddress";
    public static final int PROP_ID_lastLoginAddress = 31;
    
    /* 上次登录时间: LAST_LOGIN_TIME DATETIME */
    public static final String PROP_NAME_lastLoginTime = "lastLoginTime";
    public static final int PROP_ID_lastLoginTime = 32;
    
    /* 上次登录设备: LAST_LOGIN_DEVICE VARCHAR */
    public static final String PROP_NAME_lastLoginDevice = "lastLoginDevice";
    public static final int PROP_ID_lastLoginDevice = 33;
    
    /* 最新登录ip: LATEST_LOGIN_IP VARCHAR */
    public static final String PROP_NAME_latestLoginIp = "latestLoginIp";
    public static final int PROP_ID_latestLoginIp = 34;
    
    /* 最新登录地点: LATEST_LOGIN_ADDRESS VARCHAR */
    public static final String PROP_NAME_latestLoginAddress = "latestLoginAddress";
    public static final int PROP_ID_latestLoginAddress = 35;
    
    /* 最新登录时间: LATEST_LOGIN_TIME DATETIME */
    public static final String PROP_NAME_latestLoginTime = "latestLoginTime";
    public static final int PROP_ID_latestLoginTime = 36;
    
    /* 最新登录设备: LATEST_LOGIN_DEVICE VARCHAR */
    public static final String PROP_NAME_latestLoginDevice = "latestLoginDevice";
    public static final int PROP_ID_latestLoginDevice = 37;
    
    /* 用户状态: USER_STATUS VARCHAR */
    public static final String PROP_NAME_userStatus = "userStatus";
    public static final int PROP_ID_userStatus = 38;
    
    /* 排序码: SORT_CODE INTEGER */
    public static final String PROP_NAME_sortCode = "sortCode";
    public static final int PROP_ID_sortCode = 39;
    
    /* 扩展信息: EXT_JSON CLOB */
    public static final String PROP_NAME_extJson = "extJson";
    public static final int PROP_ID_extJson = 40;
    
    /* 删除标志: DELETE_FLAG VARCHAR */
    public static final String PROP_NAME_deleteFlag = "deleteFlag";
    public static final int PROP_ID_deleteFlag = 41;
    
    /* 创建时间: CREATE_TIME DATETIME */
    public static final String PROP_NAME_createTime = "createTime";
    public static final int PROP_ID_createTime = 42;
    
    /* 创建用户: CREATE_USER VARCHAR */
    public static final String PROP_NAME_createUser = "createUser";
    public static final int PROP_ID_createUser = 43;
    
    /* 修改时间: UPDATE_TIME DATETIME */
    public static final String PROP_NAME_updateTime = "updateTime";
    public static final int PROP_ID_updateTime = 44;
    
    /* 修改用户: UPDATE_USER VARCHAR */
    public static final String PROP_NAME_updateUser = "updateUser";
    public static final int PROP_ID_updateUser = 45;
    

    private static int _PROP_ID_BOUND = 46;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_id_);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_id_};

    private static final String[] PROP_ID_TO_NAME = new String[46];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_id_] = PROP_NAME_id_;
          PROP_NAME_TO_ID.put(PROP_NAME_id_, PROP_ID_id_);
      
          PROP_ID_TO_NAME[PROP_ID_avatar] = PROP_NAME_avatar;
          PROP_NAME_TO_ID.put(PROP_NAME_avatar, PROP_ID_avatar);
      
          PROP_ID_TO_NAME[PROP_ID_signature] = PROP_NAME_signature;
          PROP_NAME_TO_ID.put(PROP_NAME_signature, PROP_ID_signature);
      
          PROP_ID_TO_NAME[PROP_ID_account] = PROP_NAME_account;
          PROP_NAME_TO_ID.put(PROP_NAME_account, PROP_ID_account);
      
          PROP_ID_TO_NAME[PROP_ID_password] = PROP_NAME_password;
          PROP_NAME_TO_ID.put(PROP_NAME_password, PROP_ID_password);
      
          PROP_ID_TO_NAME[PROP_ID_name] = PROP_NAME_name;
          PROP_NAME_TO_ID.put(PROP_NAME_name, PROP_ID_name);
      
          PROP_ID_TO_NAME[PROP_ID_nickname] = PROP_NAME_nickname;
          PROP_NAME_TO_ID.put(PROP_NAME_nickname, PROP_ID_nickname);
      
          PROP_ID_TO_NAME[PROP_ID_gender] = PROP_NAME_gender;
          PROP_NAME_TO_ID.put(PROP_NAME_gender, PROP_ID_gender);
      
          PROP_ID_TO_NAME[PROP_ID_age] = PROP_NAME_age;
          PROP_NAME_TO_ID.put(PROP_NAME_age, PROP_ID_age);
      
          PROP_ID_TO_NAME[PROP_ID_birthday] = PROP_NAME_birthday;
          PROP_NAME_TO_ID.put(PROP_NAME_birthday, PROP_ID_birthday);
      
          PROP_ID_TO_NAME[PROP_ID_nation] = PROP_NAME_nation;
          PROP_NAME_TO_ID.put(PROP_NAME_nation, PROP_ID_nation);
      
          PROP_ID_TO_NAME[PROP_ID_nativePlace] = PROP_NAME_nativePlace;
          PROP_NAME_TO_ID.put(PROP_NAME_nativePlace, PROP_ID_nativePlace);
      
          PROP_ID_TO_NAME[PROP_ID_homeAddress] = PROP_NAME_homeAddress;
          PROP_NAME_TO_ID.put(PROP_NAME_homeAddress, PROP_ID_homeAddress);
      
          PROP_ID_TO_NAME[PROP_ID_mailingAddress] = PROP_NAME_mailingAddress;
          PROP_NAME_TO_ID.put(PROP_NAME_mailingAddress, PROP_ID_mailingAddress);
      
          PROP_ID_TO_NAME[PROP_ID_idCardType] = PROP_NAME_idCardType;
          PROP_NAME_TO_ID.put(PROP_NAME_idCardType, PROP_ID_idCardType);
      
          PROP_ID_TO_NAME[PROP_ID_idCardNumber] = PROP_NAME_idCardNumber;
          PROP_NAME_TO_ID.put(PROP_NAME_idCardNumber, PROP_ID_idCardNumber);
      
          PROP_ID_TO_NAME[PROP_ID_cultureLevel] = PROP_NAME_cultureLevel;
          PROP_NAME_TO_ID.put(PROP_NAME_cultureLevel, PROP_ID_cultureLevel);
      
          PROP_ID_TO_NAME[PROP_ID_politicalOutlook] = PROP_NAME_politicalOutlook;
          PROP_NAME_TO_ID.put(PROP_NAME_politicalOutlook, PROP_ID_politicalOutlook);
      
          PROP_ID_TO_NAME[PROP_ID_college] = PROP_NAME_college;
          PROP_NAME_TO_ID.put(PROP_NAME_college, PROP_ID_college);
      
          PROP_ID_TO_NAME[PROP_ID_education] = PROP_NAME_education;
          PROP_NAME_TO_ID.put(PROP_NAME_education, PROP_ID_education);
      
          PROP_ID_TO_NAME[PROP_ID_eduLength] = PROP_NAME_eduLength;
          PROP_NAME_TO_ID.put(PROP_NAME_eduLength, PROP_ID_eduLength);
      
          PROP_ID_TO_NAME[PROP_ID_degree] = PROP_NAME_degree;
          PROP_NAME_TO_ID.put(PROP_NAME_degree, PROP_ID_degree);
      
          PROP_ID_TO_NAME[PROP_ID_phone] = PROP_NAME_phone;
          PROP_NAME_TO_ID.put(PROP_NAME_phone, PROP_ID_phone);
      
          PROP_ID_TO_NAME[PROP_ID_email] = PROP_NAME_email;
          PROP_NAME_TO_ID.put(PROP_NAME_email, PROP_ID_email);
      
          PROP_ID_TO_NAME[PROP_ID_homeTel] = PROP_NAME_homeTel;
          PROP_NAME_TO_ID.put(PROP_NAME_homeTel, PROP_ID_homeTel);
      
          PROP_ID_TO_NAME[PROP_ID_officeTel] = PROP_NAME_officeTel;
          PROP_NAME_TO_ID.put(PROP_NAME_officeTel, PROP_ID_officeTel);
      
          PROP_ID_TO_NAME[PROP_ID_emergencyContact] = PROP_NAME_emergencyContact;
          PROP_NAME_TO_ID.put(PROP_NAME_emergencyContact, PROP_ID_emergencyContact);
      
          PROP_ID_TO_NAME[PROP_ID_emergencyPhone] = PROP_NAME_emergencyPhone;
          PROP_NAME_TO_ID.put(PROP_NAME_emergencyPhone, PROP_ID_emergencyPhone);
      
          PROP_ID_TO_NAME[PROP_ID_emergencyAddress] = PROP_NAME_emergencyAddress;
          PROP_NAME_TO_ID.put(PROP_NAME_emergencyAddress, PROP_ID_emergencyAddress);
      
          PROP_ID_TO_NAME[PROP_ID_lastLoginIp] = PROP_NAME_lastLoginIp;
          PROP_NAME_TO_ID.put(PROP_NAME_lastLoginIp, PROP_ID_lastLoginIp);
      
          PROP_ID_TO_NAME[PROP_ID_lastLoginAddress] = PROP_NAME_lastLoginAddress;
          PROP_NAME_TO_ID.put(PROP_NAME_lastLoginAddress, PROP_ID_lastLoginAddress);
      
          PROP_ID_TO_NAME[PROP_ID_lastLoginTime] = PROP_NAME_lastLoginTime;
          PROP_NAME_TO_ID.put(PROP_NAME_lastLoginTime, PROP_ID_lastLoginTime);
      
          PROP_ID_TO_NAME[PROP_ID_lastLoginDevice] = PROP_NAME_lastLoginDevice;
          PROP_NAME_TO_ID.put(PROP_NAME_lastLoginDevice, PROP_ID_lastLoginDevice);
      
          PROP_ID_TO_NAME[PROP_ID_latestLoginIp] = PROP_NAME_latestLoginIp;
          PROP_NAME_TO_ID.put(PROP_NAME_latestLoginIp, PROP_ID_latestLoginIp);
      
          PROP_ID_TO_NAME[PROP_ID_latestLoginAddress] = PROP_NAME_latestLoginAddress;
          PROP_NAME_TO_ID.put(PROP_NAME_latestLoginAddress, PROP_ID_latestLoginAddress);
      
          PROP_ID_TO_NAME[PROP_ID_latestLoginTime] = PROP_NAME_latestLoginTime;
          PROP_NAME_TO_ID.put(PROP_NAME_latestLoginTime, PROP_ID_latestLoginTime);
      
          PROP_ID_TO_NAME[PROP_ID_latestLoginDevice] = PROP_NAME_latestLoginDevice;
          PROP_NAME_TO_ID.put(PROP_NAME_latestLoginDevice, PROP_ID_latestLoginDevice);
      
          PROP_ID_TO_NAME[PROP_ID_userStatus] = PROP_NAME_userStatus;
          PROP_NAME_TO_ID.put(PROP_NAME_userStatus, PROP_ID_userStatus);
      
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

    
    /* Id: ID */
    private java.lang.String _id_;
    
    /* 头像: AVATAR */
    private java.lang.String _avatar;
    
    /* 签名: SIGNATURE */
    private java.lang.String _signature;
    
    /* 账号: ACCOUNT */
    private java.lang.String _account;
    
    /* 密码: PASSWORD */
    private java.lang.String _password;
    
    /* 姓名: NAME */
    private java.lang.String _name;
    
    /* 昵称: NICKNAME */
    private java.lang.String _nickname;
    
    /* 性别: GENDER */
    private java.lang.String _gender;
    
    /* 年龄: AGE */
    private java.lang.String _age;
    
    /* 出生日期: BIRTHDAY */
    private java.lang.String _birthday;
    
    /* 民族: NATION */
    private java.lang.String _nation;
    
    /* 籍贯: NATIVE_PLACE */
    private java.lang.String _nativePlace;
    
    /* 家庭住址: HOME_ADDRESS */
    private java.lang.String _homeAddress;
    
    /* 通信地址: MAILING_ADDRESS */
    private java.lang.String _mailingAddress;
    
    /* 证件类型: ID_CARD_TYPE */
    private java.lang.String _idCardType;
    
    /* 证件号码: ID_CARD_NUMBER */
    private java.lang.String _idCardNumber;
    
    /* 文化程度: CULTURE_LEVEL */
    private java.lang.String _cultureLevel;
    
    /* 政治面貌: POLITICAL_OUTLOOK */
    private java.lang.String _politicalOutlook;
    
    /* 毕业院校: COLLEGE */
    private java.lang.String _college;
    
    /* 学历: EDUCATION */
    private java.lang.String _education;
    
    /* 学制: EDU_LENGTH */
    private java.lang.String _eduLength;
    
    /* 学位: DEGREE */
    private java.lang.String _degree;
    
    /* 手机: PHONE */
    private java.lang.String _phone;
    
    /* 邮箱: EMAIL */
    private java.lang.String _email;
    
    /* 家庭电话: HOME_TEL */
    private java.lang.String _homeTel;
    
    /* 办公电话: OFFICE_TEL */
    private java.lang.String _officeTel;
    
    /* 紧急联系人: EMERGENCY_CONTACT */
    private java.lang.String _emergencyContact;
    
    /* 紧急联系人电话: EMERGENCY_PHONE */
    private java.lang.String _emergencyPhone;
    
    /* 紧急联系人地址: EMERGENCY_ADDRESS */
    private java.lang.String _emergencyAddress;
    
    /* 上次登录ip: LAST_LOGIN_IP */
    private java.lang.String _lastLoginIp;
    
    /* 上次登录地点: LAST_LOGIN_ADDRESS */
    private java.lang.String _lastLoginAddress;
    
    /* 上次登录时间: LAST_LOGIN_TIME */
    private java.time.LocalDateTime _lastLoginTime;
    
    /* 上次登录设备: LAST_LOGIN_DEVICE */
    private java.lang.String _lastLoginDevice;
    
    /* 最新登录ip: LATEST_LOGIN_IP */
    private java.lang.String _latestLoginIp;
    
    /* 最新登录地点: LATEST_LOGIN_ADDRESS */
    private java.lang.String _latestLoginAddress;
    
    /* 最新登录时间: LATEST_LOGIN_TIME */
    private java.time.LocalDateTime _latestLoginTime;
    
    /* 最新登录设备: LATEST_LOGIN_DEVICE */
    private java.lang.String _latestLoginDevice;
    
    /* 用户状态: USER_STATUS */
    private java.lang.String _userStatus;
    
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
    

    public _ClientUser(){
        // for debug
    }

    protected ClientUser newInstance(){
        ClientUser entity = new ClientUser();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public ClientUser cloneInstance() {
        ClientUser entity = newInstance();
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
      return "com.fliad.resource.dao.entity.ClientUser";
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
        
            case PROP_ID_avatar:
               return getAvatar();
        
            case PROP_ID_signature:
               return getSignature();
        
            case PROP_ID_account:
               return getAccount();
        
            case PROP_ID_password:
               return getPassword();
        
            case PROP_ID_name:
               return getName();
        
            case PROP_ID_nickname:
               return getNickname();
        
            case PROP_ID_gender:
               return getGender();
        
            case PROP_ID_age:
               return getAge();
        
            case PROP_ID_birthday:
               return getBirthday();
        
            case PROP_ID_nation:
               return getNation();
        
            case PROP_ID_nativePlace:
               return getNativePlace();
        
            case PROP_ID_homeAddress:
               return getHomeAddress();
        
            case PROP_ID_mailingAddress:
               return getMailingAddress();
        
            case PROP_ID_idCardType:
               return getIdCardType();
        
            case PROP_ID_idCardNumber:
               return getIdCardNumber();
        
            case PROP_ID_cultureLevel:
               return getCultureLevel();
        
            case PROP_ID_politicalOutlook:
               return getPoliticalOutlook();
        
            case PROP_ID_college:
               return getCollege();
        
            case PROP_ID_education:
               return getEducation();
        
            case PROP_ID_eduLength:
               return getEduLength();
        
            case PROP_ID_degree:
               return getDegree();
        
            case PROP_ID_phone:
               return getPhone();
        
            case PROP_ID_email:
               return getEmail();
        
            case PROP_ID_homeTel:
               return getHomeTel();
        
            case PROP_ID_officeTel:
               return getOfficeTel();
        
            case PROP_ID_emergencyContact:
               return getEmergencyContact();
        
            case PROP_ID_emergencyPhone:
               return getEmergencyPhone();
        
            case PROP_ID_emergencyAddress:
               return getEmergencyAddress();
        
            case PROP_ID_lastLoginIp:
               return getLastLoginIp();
        
            case PROP_ID_lastLoginAddress:
               return getLastLoginAddress();
        
            case PROP_ID_lastLoginTime:
               return getLastLoginTime();
        
            case PROP_ID_lastLoginDevice:
               return getLastLoginDevice();
        
            case PROP_ID_latestLoginIp:
               return getLatestLoginIp();
        
            case PROP_ID_latestLoginAddress:
               return getLatestLoginAddress();
        
            case PROP_ID_latestLoginTime:
               return getLatestLoginTime();
        
            case PROP_ID_latestLoginDevice:
               return getLatestLoginDevice();
        
            case PROP_ID_userStatus:
               return getUserStatus();
        
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
        
            case PROP_ID_avatar:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_avatar));
               }
               setAvatar(typedValue);
               break;
            }
        
            case PROP_ID_signature:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_signature));
               }
               setSignature(typedValue);
               break;
            }
        
            case PROP_ID_account:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_account));
               }
               setAccount(typedValue);
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
        
            case PROP_ID_name:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_name));
               }
               setName(typedValue);
               break;
            }
        
            case PROP_ID_nickname:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_nickname));
               }
               setNickname(typedValue);
               break;
            }
        
            case PROP_ID_gender:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_gender));
               }
               setGender(typedValue);
               break;
            }
        
            case PROP_ID_age:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_age));
               }
               setAge(typedValue);
               break;
            }
        
            case PROP_ID_birthday:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_birthday));
               }
               setBirthday(typedValue);
               break;
            }
        
            case PROP_ID_nation:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_nation));
               }
               setNation(typedValue);
               break;
            }
        
            case PROP_ID_nativePlace:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_nativePlace));
               }
               setNativePlace(typedValue);
               break;
            }
        
            case PROP_ID_homeAddress:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_homeAddress));
               }
               setHomeAddress(typedValue);
               break;
            }
        
            case PROP_ID_mailingAddress:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_mailingAddress));
               }
               setMailingAddress(typedValue);
               break;
            }
        
            case PROP_ID_idCardType:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_idCardType));
               }
               setIdCardType(typedValue);
               break;
            }
        
            case PROP_ID_idCardNumber:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_idCardNumber));
               }
               setIdCardNumber(typedValue);
               break;
            }
        
            case PROP_ID_cultureLevel:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_cultureLevel));
               }
               setCultureLevel(typedValue);
               break;
            }
        
            case PROP_ID_politicalOutlook:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_politicalOutlook));
               }
               setPoliticalOutlook(typedValue);
               break;
            }
        
            case PROP_ID_college:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_college));
               }
               setCollege(typedValue);
               break;
            }
        
            case PROP_ID_education:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_education));
               }
               setEducation(typedValue);
               break;
            }
        
            case PROP_ID_eduLength:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_eduLength));
               }
               setEduLength(typedValue);
               break;
            }
        
            case PROP_ID_degree:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_degree));
               }
               setDegree(typedValue);
               break;
            }
        
            case PROP_ID_phone:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_phone));
               }
               setPhone(typedValue);
               break;
            }
        
            case PROP_ID_email:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_email));
               }
               setEmail(typedValue);
               break;
            }
        
            case PROP_ID_homeTel:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_homeTel));
               }
               setHomeTel(typedValue);
               break;
            }
        
            case PROP_ID_officeTel:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_officeTel));
               }
               setOfficeTel(typedValue);
               break;
            }
        
            case PROP_ID_emergencyContact:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_emergencyContact));
               }
               setEmergencyContact(typedValue);
               break;
            }
        
            case PROP_ID_emergencyPhone:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_emergencyPhone));
               }
               setEmergencyPhone(typedValue);
               break;
            }
        
            case PROP_ID_emergencyAddress:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_emergencyAddress));
               }
               setEmergencyAddress(typedValue);
               break;
            }
        
            case PROP_ID_lastLoginIp:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_lastLoginIp));
               }
               setLastLoginIp(typedValue);
               break;
            }
        
            case PROP_ID_lastLoginAddress:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_lastLoginAddress));
               }
               setLastLoginAddress(typedValue);
               break;
            }
        
            case PROP_ID_lastLoginTime:{
               java.time.LocalDateTime typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLocalDateTime(value,
                       err-> newTypeConversionError(PROP_NAME_lastLoginTime));
               }
               setLastLoginTime(typedValue);
               break;
            }
        
            case PROP_ID_lastLoginDevice:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_lastLoginDevice));
               }
               setLastLoginDevice(typedValue);
               break;
            }
        
            case PROP_ID_latestLoginIp:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_latestLoginIp));
               }
               setLatestLoginIp(typedValue);
               break;
            }
        
            case PROP_ID_latestLoginAddress:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_latestLoginAddress));
               }
               setLatestLoginAddress(typedValue);
               break;
            }
        
            case PROP_ID_latestLoginTime:{
               java.time.LocalDateTime typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLocalDateTime(value,
                       err-> newTypeConversionError(PROP_NAME_latestLoginTime));
               }
               setLatestLoginTime(typedValue);
               break;
            }
        
            case PROP_ID_latestLoginDevice:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_latestLoginDevice));
               }
               setLatestLoginDevice(typedValue);
               break;
            }
        
            case PROP_ID_userStatus:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_userStatus));
               }
               setUserStatus(typedValue);
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
        
            case PROP_ID_avatar:{
               onInitProp(propId);
               this._avatar = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_signature:{
               onInitProp(propId);
               this._signature = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_account:{
               onInitProp(propId);
               this._account = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_password:{
               onInitProp(propId);
               this._password = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_name:{
               onInitProp(propId);
               this._name = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_nickname:{
               onInitProp(propId);
               this._nickname = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_gender:{
               onInitProp(propId);
               this._gender = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_age:{
               onInitProp(propId);
               this._age = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_birthday:{
               onInitProp(propId);
               this._birthday = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_nation:{
               onInitProp(propId);
               this._nation = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_nativePlace:{
               onInitProp(propId);
               this._nativePlace = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_homeAddress:{
               onInitProp(propId);
               this._homeAddress = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_mailingAddress:{
               onInitProp(propId);
               this._mailingAddress = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_idCardType:{
               onInitProp(propId);
               this._idCardType = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_idCardNumber:{
               onInitProp(propId);
               this._idCardNumber = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_cultureLevel:{
               onInitProp(propId);
               this._cultureLevel = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_politicalOutlook:{
               onInitProp(propId);
               this._politicalOutlook = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_college:{
               onInitProp(propId);
               this._college = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_education:{
               onInitProp(propId);
               this._education = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_eduLength:{
               onInitProp(propId);
               this._eduLength = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_degree:{
               onInitProp(propId);
               this._degree = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_phone:{
               onInitProp(propId);
               this._phone = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_email:{
               onInitProp(propId);
               this._email = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_homeTel:{
               onInitProp(propId);
               this._homeTel = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_officeTel:{
               onInitProp(propId);
               this._officeTel = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_emergencyContact:{
               onInitProp(propId);
               this._emergencyContact = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_emergencyPhone:{
               onInitProp(propId);
               this._emergencyPhone = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_emergencyAddress:{
               onInitProp(propId);
               this._emergencyAddress = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_lastLoginIp:{
               onInitProp(propId);
               this._lastLoginIp = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_lastLoginAddress:{
               onInitProp(propId);
               this._lastLoginAddress = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_lastLoginTime:{
               onInitProp(propId);
               this._lastLoginTime = (java.time.LocalDateTime)value;
               
               break;
            }
        
            case PROP_ID_lastLoginDevice:{
               onInitProp(propId);
               this._lastLoginDevice = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_latestLoginIp:{
               onInitProp(propId);
               this._latestLoginIp = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_latestLoginAddress:{
               onInitProp(propId);
               this._latestLoginAddress = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_latestLoginTime:{
               onInitProp(propId);
               this._latestLoginTime = (java.time.LocalDateTime)value;
               
               break;
            }
        
            case PROP_ID_latestLoginDevice:{
               onInitProp(propId);
               this._latestLoginDevice = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_userStatus:{
               onInitProp(propId);
               this._userStatus = (java.lang.String)value;
               
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
     * 头像: AVATAR
     */
    public final java.lang.String getAvatar(){
         onPropGet(PROP_ID_avatar);
         return _avatar;
    }

    /**
     * 头像: AVATAR
     */
    public final void setAvatar(java.lang.String value){
        if(onPropSet(PROP_ID_avatar,value)){
            this._avatar = value;
            internalClearRefs(PROP_ID_avatar);
            
        }
    }
    
    /**
     * 签名: SIGNATURE
     */
    public final java.lang.String getSignature(){
         onPropGet(PROP_ID_signature);
         return _signature;
    }

    /**
     * 签名: SIGNATURE
     */
    public final void setSignature(java.lang.String value){
        if(onPropSet(PROP_ID_signature,value)){
            this._signature = value;
            internalClearRefs(PROP_ID_signature);
            
        }
    }
    
    /**
     * 账号: ACCOUNT
     */
    public final java.lang.String getAccount(){
         onPropGet(PROP_ID_account);
         return _account;
    }

    /**
     * 账号: ACCOUNT
     */
    public final void setAccount(java.lang.String value){
        if(onPropSet(PROP_ID_account,value)){
            this._account = value;
            internalClearRefs(PROP_ID_account);
            
        }
    }
    
    /**
     * 密码: PASSWORD
     */
    public final java.lang.String getPassword(){
         onPropGet(PROP_ID_password);
         return _password;
    }

    /**
     * 密码: PASSWORD
     */
    public final void setPassword(java.lang.String value){
        if(onPropSet(PROP_ID_password,value)){
            this._password = value;
            internalClearRefs(PROP_ID_password);
            
        }
    }
    
    /**
     * 姓名: NAME
     */
    public final java.lang.String getName(){
         onPropGet(PROP_ID_name);
         return _name;
    }

    /**
     * 姓名: NAME
     */
    public final void setName(java.lang.String value){
        if(onPropSet(PROP_ID_name,value)){
            this._name = value;
            internalClearRefs(PROP_ID_name);
            
        }
    }
    
    /**
     * 昵称: NICKNAME
     */
    public final java.lang.String getNickname(){
         onPropGet(PROP_ID_nickname);
         return _nickname;
    }

    /**
     * 昵称: NICKNAME
     */
    public final void setNickname(java.lang.String value){
        if(onPropSet(PROP_ID_nickname,value)){
            this._nickname = value;
            internalClearRefs(PROP_ID_nickname);
            
        }
    }
    
    /**
     * 性别: GENDER
     */
    public final java.lang.String getGender(){
         onPropGet(PROP_ID_gender);
         return _gender;
    }

    /**
     * 性别: GENDER
     */
    public final void setGender(java.lang.String value){
        if(onPropSet(PROP_ID_gender,value)){
            this._gender = value;
            internalClearRefs(PROP_ID_gender);
            
        }
    }
    
    /**
     * 年龄: AGE
     */
    public final java.lang.String getAge(){
         onPropGet(PROP_ID_age);
         return _age;
    }

    /**
     * 年龄: AGE
     */
    public final void setAge(java.lang.String value){
        if(onPropSet(PROP_ID_age,value)){
            this._age = value;
            internalClearRefs(PROP_ID_age);
            
        }
    }
    
    /**
     * 出生日期: BIRTHDAY
     */
    public final java.lang.String getBirthday(){
         onPropGet(PROP_ID_birthday);
         return _birthday;
    }

    /**
     * 出生日期: BIRTHDAY
     */
    public final void setBirthday(java.lang.String value){
        if(onPropSet(PROP_ID_birthday,value)){
            this._birthday = value;
            internalClearRefs(PROP_ID_birthday);
            
        }
    }
    
    /**
     * 民族: NATION
     */
    public final java.lang.String getNation(){
         onPropGet(PROP_ID_nation);
         return _nation;
    }

    /**
     * 民族: NATION
     */
    public final void setNation(java.lang.String value){
        if(onPropSet(PROP_ID_nation,value)){
            this._nation = value;
            internalClearRefs(PROP_ID_nation);
            
        }
    }
    
    /**
     * 籍贯: NATIVE_PLACE
     */
    public final java.lang.String getNativePlace(){
         onPropGet(PROP_ID_nativePlace);
         return _nativePlace;
    }

    /**
     * 籍贯: NATIVE_PLACE
     */
    public final void setNativePlace(java.lang.String value){
        if(onPropSet(PROP_ID_nativePlace,value)){
            this._nativePlace = value;
            internalClearRefs(PROP_ID_nativePlace);
            
        }
    }
    
    /**
     * 家庭住址: HOME_ADDRESS
     */
    public final java.lang.String getHomeAddress(){
         onPropGet(PROP_ID_homeAddress);
         return _homeAddress;
    }

    /**
     * 家庭住址: HOME_ADDRESS
     */
    public final void setHomeAddress(java.lang.String value){
        if(onPropSet(PROP_ID_homeAddress,value)){
            this._homeAddress = value;
            internalClearRefs(PROP_ID_homeAddress);
            
        }
    }
    
    /**
     * 通信地址: MAILING_ADDRESS
     */
    public final java.lang.String getMailingAddress(){
         onPropGet(PROP_ID_mailingAddress);
         return _mailingAddress;
    }

    /**
     * 通信地址: MAILING_ADDRESS
     */
    public final void setMailingAddress(java.lang.String value){
        if(onPropSet(PROP_ID_mailingAddress,value)){
            this._mailingAddress = value;
            internalClearRefs(PROP_ID_mailingAddress);
            
        }
    }
    
    /**
     * 证件类型: ID_CARD_TYPE
     */
    public final java.lang.String getIdCardType(){
         onPropGet(PROP_ID_idCardType);
         return _idCardType;
    }

    /**
     * 证件类型: ID_CARD_TYPE
     */
    public final void setIdCardType(java.lang.String value){
        if(onPropSet(PROP_ID_idCardType,value)){
            this._idCardType = value;
            internalClearRefs(PROP_ID_idCardType);
            
        }
    }
    
    /**
     * 证件号码: ID_CARD_NUMBER
     */
    public final java.lang.String getIdCardNumber(){
         onPropGet(PROP_ID_idCardNumber);
         return _idCardNumber;
    }

    /**
     * 证件号码: ID_CARD_NUMBER
     */
    public final void setIdCardNumber(java.lang.String value){
        if(onPropSet(PROP_ID_idCardNumber,value)){
            this._idCardNumber = value;
            internalClearRefs(PROP_ID_idCardNumber);
            
        }
    }
    
    /**
     * 文化程度: CULTURE_LEVEL
     */
    public final java.lang.String getCultureLevel(){
         onPropGet(PROP_ID_cultureLevel);
         return _cultureLevel;
    }

    /**
     * 文化程度: CULTURE_LEVEL
     */
    public final void setCultureLevel(java.lang.String value){
        if(onPropSet(PROP_ID_cultureLevel,value)){
            this._cultureLevel = value;
            internalClearRefs(PROP_ID_cultureLevel);
            
        }
    }
    
    /**
     * 政治面貌: POLITICAL_OUTLOOK
     */
    public final java.lang.String getPoliticalOutlook(){
         onPropGet(PROP_ID_politicalOutlook);
         return _politicalOutlook;
    }

    /**
     * 政治面貌: POLITICAL_OUTLOOK
     */
    public final void setPoliticalOutlook(java.lang.String value){
        if(onPropSet(PROP_ID_politicalOutlook,value)){
            this._politicalOutlook = value;
            internalClearRefs(PROP_ID_politicalOutlook);
            
        }
    }
    
    /**
     * 毕业院校: COLLEGE
     */
    public final java.lang.String getCollege(){
         onPropGet(PROP_ID_college);
         return _college;
    }

    /**
     * 毕业院校: COLLEGE
     */
    public final void setCollege(java.lang.String value){
        if(onPropSet(PROP_ID_college,value)){
            this._college = value;
            internalClearRefs(PROP_ID_college);
            
        }
    }
    
    /**
     * 学历: EDUCATION
     */
    public final java.lang.String getEducation(){
         onPropGet(PROP_ID_education);
         return _education;
    }

    /**
     * 学历: EDUCATION
     */
    public final void setEducation(java.lang.String value){
        if(onPropSet(PROP_ID_education,value)){
            this._education = value;
            internalClearRefs(PROP_ID_education);
            
        }
    }
    
    /**
     * 学制: EDU_LENGTH
     */
    public final java.lang.String getEduLength(){
         onPropGet(PROP_ID_eduLength);
         return _eduLength;
    }

    /**
     * 学制: EDU_LENGTH
     */
    public final void setEduLength(java.lang.String value){
        if(onPropSet(PROP_ID_eduLength,value)){
            this._eduLength = value;
            internalClearRefs(PROP_ID_eduLength);
            
        }
    }
    
    /**
     * 学位: DEGREE
     */
    public final java.lang.String getDegree(){
         onPropGet(PROP_ID_degree);
         return _degree;
    }

    /**
     * 学位: DEGREE
     */
    public final void setDegree(java.lang.String value){
        if(onPropSet(PROP_ID_degree,value)){
            this._degree = value;
            internalClearRefs(PROP_ID_degree);
            
        }
    }
    
    /**
     * 手机: PHONE
     */
    public final java.lang.String getPhone(){
         onPropGet(PROP_ID_phone);
         return _phone;
    }

    /**
     * 手机: PHONE
     */
    public final void setPhone(java.lang.String value){
        if(onPropSet(PROP_ID_phone,value)){
            this._phone = value;
            internalClearRefs(PROP_ID_phone);
            
        }
    }
    
    /**
     * 邮箱: EMAIL
     */
    public final java.lang.String getEmail(){
         onPropGet(PROP_ID_email);
         return _email;
    }

    /**
     * 邮箱: EMAIL
     */
    public final void setEmail(java.lang.String value){
        if(onPropSet(PROP_ID_email,value)){
            this._email = value;
            internalClearRefs(PROP_ID_email);
            
        }
    }
    
    /**
     * 家庭电话: HOME_TEL
     */
    public final java.lang.String getHomeTel(){
         onPropGet(PROP_ID_homeTel);
         return _homeTel;
    }

    /**
     * 家庭电话: HOME_TEL
     */
    public final void setHomeTel(java.lang.String value){
        if(onPropSet(PROP_ID_homeTel,value)){
            this._homeTel = value;
            internalClearRefs(PROP_ID_homeTel);
            
        }
    }
    
    /**
     * 办公电话: OFFICE_TEL
     */
    public final java.lang.String getOfficeTel(){
         onPropGet(PROP_ID_officeTel);
         return _officeTel;
    }

    /**
     * 办公电话: OFFICE_TEL
     */
    public final void setOfficeTel(java.lang.String value){
        if(onPropSet(PROP_ID_officeTel,value)){
            this._officeTel = value;
            internalClearRefs(PROP_ID_officeTel);
            
        }
    }
    
    /**
     * 紧急联系人: EMERGENCY_CONTACT
     */
    public final java.lang.String getEmergencyContact(){
         onPropGet(PROP_ID_emergencyContact);
         return _emergencyContact;
    }

    /**
     * 紧急联系人: EMERGENCY_CONTACT
     */
    public final void setEmergencyContact(java.lang.String value){
        if(onPropSet(PROP_ID_emergencyContact,value)){
            this._emergencyContact = value;
            internalClearRefs(PROP_ID_emergencyContact);
            
        }
    }
    
    /**
     * 紧急联系人电话: EMERGENCY_PHONE
     */
    public final java.lang.String getEmergencyPhone(){
         onPropGet(PROP_ID_emergencyPhone);
         return _emergencyPhone;
    }

    /**
     * 紧急联系人电话: EMERGENCY_PHONE
     */
    public final void setEmergencyPhone(java.lang.String value){
        if(onPropSet(PROP_ID_emergencyPhone,value)){
            this._emergencyPhone = value;
            internalClearRefs(PROP_ID_emergencyPhone);
            
        }
    }
    
    /**
     * 紧急联系人地址: EMERGENCY_ADDRESS
     */
    public final java.lang.String getEmergencyAddress(){
         onPropGet(PROP_ID_emergencyAddress);
         return _emergencyAddress;
    }

    /**
     * 紧急联系人地址: EMERGENCY_ADDRESS
     */
    public final void setEmergencyAddress(java.lang.String value){
        if(onPropSet(PROP_ID_emergencyAddress,value)){
            this._emergencyAddress = value;
            internalClearRefs(PROP_ID_emergencyAddress);
            
        }
    }
    
    /**
     * 上次登录ip: LAST_LOGIN_IP
     */
    public final java.lang.String getLastLoginIp(){
         onPropGet(PROP_ID_lastLoginIp);
         return _lastLoginIp;
    }

    /**
     * 上次登录ip: LAST_LOGIN_IP
     */
    public final void setLastLoginIp(java.lang.String value){
        if(onPropSet(PROP_ID_lastLoginIp,value)){
            this._lastLoginIp = value;
            internalClearRefs(PROP_ID_lastLoginIp);
            
        }
    }
    
    /**
     * 上次登录地点: LAST_LOGIN_ADDRESS
     */
    public final java.lang.String getLastLoginAddress(){
         onPropGet(PROP_ID_lastLoginAddress);
         return _lastLoginAddress;
    }

    /**
     * 上次登录地点: LAST_LOGIN_ADDRESS
     */
    public final void setLastLoginAddress(java.lang.String value){
        if(onPropSet(PROP_ID_lastLoginAddress,value)){
            this._lastLoginAddress = value;
            internalClearRefs(PROP_ID_lastLoginAddress);
            
        }
    }
    
    /**
     * 上次登录时间: LAST_LOGIN_TIME
     */
    public final java.time.LocalDateTime getLastLoginTime(){
         onPropGet(PROP_ID_lastLoginTime);
         return _lastLoginTime;
    }

    /**
     * 上次登录时间: LAST_LOGIN_TIME
     */
    public final void setLastLoginTime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_lastLoginTime,value)){
            this._lastLoginTime = value;
            internalClearRefs(PROP_ID_lastLoginTime);
            
        }
    }
    
    /**
     * 上次登录设备: LAST_LOGIN_DEVICE
     */
    public final java.lang.String getLastLoginDevice(){
         onPropGet(PROP_ID_lastLoginDevice);
         return _lastLoginDevice;
    }

    /**
     * 上次登录设备: LAST_LOGIN_DEVICE
     */
    public final void setLastLoginDevice(java.lang.String value){
        if(onPropSet(PROP_ID_lastLoginDevice,value)){
            this._lastLoginDevice = value;
            internalClearRefs(PROP_ID_lastLoginDevice);
            
        }
    }
    
    /**
     * 最新登录ip: LATEST_LOGIN_IP
     */
    public final java.lang.String getLatestLoginIp(){
         onPropGet(PROP_ID_latestLoginIp);
         return _latestLoginIp;
    }

    /**
     * 最新登录ip: LATEST_LOGIN_IP
     */
    public final void setLatestLoginIp(java.lang.String value){
        if(onPropSet(PROP_ID_latestLoginIp,value)){
            this._latestLoginIp = value;
            internalClearRefs(PROP_ID_latestLoginIp);
            
        }
    }
    
    /**
     * 最新登录地点: LATEST_LOGIN_ADDRESS
     */
    public final java.lang.String getLatestLoginAddress(){
         onPropGet(PROP_ID_latestLoginAddress);
         return _latestLoginAddress;
    }

    /**
     * 最新登录地点: LATEST_LOGIN_ADDRESS
     */
    public final void setLatestLoginAddress(java.lang.String value){
        if(onPropSet(PROP_ID_latestLoginAddress,value)){
            this._latestLoginAddress = value;
            internalClearRefs(PROP_ID_latestLoginAddress);
            
        }
    }
    
    /**
     * 最新登录时间: LATEST_LOGIN_TIME
     */
    public final java.time.LocalDateTime getLatestLoginTime(){
         onPropGet(PROP_ID_latestLoginTime);
         return _latestLoginTime;
    }

    /**
     * 最新登录时间: LATEST_LOGIN_TIME
     */
    public final void setLatestLoginTime(java.time.LocalDateTime value){
        if(onPropSet(PROP_ID_latestLoginTime,value)){
            this._latestLoginTime = value;
            internalClearRefs(PROP_ID_latestLoginTime);
            
        }
    }
    
    /**
     * 最新登录设备: LATEST_LOGIN_DEVICE
     */
    public final java.lang.String getLatestLoginDevice(){
         onPropGet(PROP_ID_latestLoginDevice);
         return _latestLoginDevice;
    }

    /**
     * 最新登录设备: LATEST_LOGIN_DEVICE
     */
    public final void setLatestLoginDevice(java.lang.String value){
        if(onPropSet(PROP_ID_latestLoginDevice,value)){
            this._latestLoginDevice = value;
            internalClearRefs(PROP_ID_latestLoginDevice);
            
        }
    }
    
    /**
     * 用户状态: USER_STATUS
     */
    public final java.lang.String getUserStatus(){
         onPropGet(PROP_ID_userStatus);
         return _userStatus;
    }

    /**
     * 用户状态: USER_STATUS
     */
    public final void setUserStatus(java.lang.String value){
        if(onPropSet(PROP_ID_userStatus,value)){
            this._userStatus = value;
            internalClearRefs(PROP_ID_userStatus);
            
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

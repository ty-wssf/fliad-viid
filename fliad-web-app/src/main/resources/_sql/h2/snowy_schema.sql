-- ----------------------------
-- Table structure for AUTH_THIRD_USER
-- ----------------------------
CREATE TABLE AUTH_THIRD_USER (
  ID varchar(20) NOT NULL,
  THIRD_ID varchar(255) DEFAULT NULL,
  USER_ID varchar(20) DEFAULT NULL,
  AVATAR longtext,
  NAME varchar(255) DEFAULT NULL,
  NICKNAME varchar(255) DEFAULT NULL,
  GENDER varchar(255) DEFAULT NULL,
  CATEGORY varchar(255) DEFAULT NULL,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for CLIENT_RELATION
-- ----------------------------
CREATE TABLE CLIENT_RELATION (
  ID varchar(20) NOT NULL,
  OBJECT_ID varchar(255) DEFAULT NULL,
  TARGET_ID varchar(255) DEFAULT NULL,
  CATEGORY varchar(255) DEFAULT NULL,
  EXT_JSON longtext,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for CLIENT_USER
-- ----------------------------
CREATE TABLE CLIENT_USER (
  ID varchar(20) NOT NULL,
  AVATAR longtext,
  SIGNATURE longtext,
  ACCOUNT varchar(255) DEFAULT NULL,
  PASSWORD varchar(255) DEFAULT NULL,
  NAME varchar(255) DEFAULT NULL,
  NICKNAME varchar(255) DEFAULT NULL,
  GENDER varchar(255) DEFAULT NULL,
  AGE varchar(255) DEFAULT NULL,
  BIRTHDAY varchar(255) DEFAULT NULL,
  NATION varchar(255) DEFAULT NULL,
  NATIVE_PLACE varchar(255) DEFAULT NULL,
  HOME_ADDRESS text,
  MAILING_ADDRESS text,
  ID_CARD_TYPE varchar(255) DEFAULT NULL,
  ID_CARD_NUMBER varchar(255) DEFAULT NULL,
  CULTURE_LEVEL varchar(255) DEFAULT NULL,
  POLITICAL_OUTLOOK varchar(255) DEFAULT NULL,
  COLLEGE varchar(255) DEFAULT NULL,
  EDUCATION varchar(255) DEFAULT NULL,
  EDU_LENGTH varchar(255) DEFAULT NULL,
  DEGREE varchar(255) DEFAULT NULL,
  PHONE varchar(255) DEFAULT NULL,
  EMAIL varchar(255) DEFAULT NULL,
  HOME_TEL varchar(255) DEFAULT NULL,
  OFFICE_TEL varchar(255) DEFAULT NULL,
  EMERGENCY_CONTACT varchar(255) DEFAULT NULL,
  EMERGENCY_PHONE varchar(255) DEFAULT NULL,
  EMERGENCY_ADDRESS text,
  LAST_LOGIN_IP varchar(255) DEFAULT NULL,
  LAST_LOGIN_ADDRESS varchar(255) DEFAULT NULL,
  LAST_LOGIN_TIME datetime DEFAULT NULL,
  LAST_LOGIN_DEVICE text,
  LATEST_LOGIN_IP varchar(255) DEFAULT NULL,
  LATEST_LOGIN_ADDRESS varchar(255) DEFAULT NULL,
  LATEST_LOGIN_TIME datetime DEFAULT NULL,
  LATEST_LOGIN_DEVICE text,
  USER_STATUS varchar(255) DEFAULT NULL,
  SORT_CODE int DEFAULT NULL,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for DEV_CONFIG
-- ----------------------------
CREATE TABLE DEV_CONFIG (
  ID varchar(20) NOT NULL,
  CONFIG_KEY varchar(255) DEFAULT NULL,
  CONFIG_VALUE longtext,
  CATEGORY varchar(255) DEFAULT NULL,
  REMARK varchar(255) DEFAULT NULL,
  SORT_CODE int DEFAULT NULL,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for DEV_DICT
-- ----------------------------
CREATE TABLE DEV_DICT (
  ID varchar(20) NOT NULL,
  PARENT_ID varchar(20) DEFAULT NULL,
  DICT_LABEL varchar(255) DEFAULT NULL,
  DICT_VALUE varchar(255) DEFAULT NULL,
  CATEGORY varchar(255) DEFAULT NULL,
  SORT_CODE int DEFAULT NULL,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for DEV_EMAIL
-- ----------------------------
CREATE TABLE DEV_EMAIL (
  ID varchar(20) NOT NULL,
  ENGINE varchar(255) DEFAULT NULL,
  SEND_ACCOUNT varchar(255) DEFAULT NULL,
  SEND_USER varchar(255) DEFAULT NULL,
  RECEIVE_ACCOUNTS text,
  SUBJECT text,
  CONTENT longtext,
  TAG_NAME varchar(255) DEFAULT NULL,
  TEMPLATE_NAME text,
  TEMPLATE_PARAM text,
  RECEIPT_INFO longtext,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for DEV_FILE
-- ----------------------------
CREATE TABLE DEV_FILE (
  ID varchar(20) NOT NULL,
  ENGINE varchar(255) DEFAULT NULL,
  BUCKET varchar(255) DEFAULT NULL,
  NAME text,
  SUFFIX varchar(255) DEFAULT NULL,
  SIZE_KB bigint DEFAULT NULL,
  SIZE_INFO varchar(255) DEFAULT NULL,
  OBJ_NAME text,
  STORAGE_PATH text,
  DOWNLOAD_PATH text,
  THUMBNAIL longtext,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for DEV_JOB
-- ----------------------------
CREATE TABLE DEV_JOB (
  ID varchar(20) NOT NULL,
  NAME varchar(255) DEFAULT NULL,
  CODE varchar(255) DEFAULT NULL,
  CATEGORY varchar(255) DEFAULT NULL,
  ACTION_CLASS varchar(255) DEFAULT NULL,
  CRON_EXPRESSION varchar(255) DEFAULT NULL,
  JOB_STATUS varchar(255) DEFAULT NULL,
  SORT_CODE int DEFAULT NULL,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for DEV_LOG
-- ----------------------------
CREATE TABLE DEV_LOG (
  ID varchar(20) NOT NULL,
  CATEGORY varchar(255) DEFAULT NULL,
  NAME varchar(255) DEFAULT NULL,
  EXE_STATUS varchar(255) DEFAULT NULL,
  EXE_MESSAGE longtext,
  OP_IP varchar(255) DEFAULT NULL,
  OP_ADDRESS varchar(255) DEFAULT NULL,
  OP_BROWSER varchar(255) DEFAULT NULL,
  OP_OS varchar(255) DEFAULT NULL,
  CLASS_NAME varchar(255) DEFAULT NULL,
  METHOD_NAME varchar(255) DEFAULT NULL,
  REQ_METHOD varchar(255) DEFAULT NULL,
  REQ_URL longtext,
  PARAM_JSON longtext,
  RESULT_JSON longtext,
  OP_TIME datetime DEFAULT NULL,
  OP_USER varchar(255) DEFAULT NULL,
  SIGN_DATA longtext,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for DEV_MESSAGE
-- ----------------------------
CREATE TABLE DEV_MESSAGE (
  ID varchar(20) NOT NULL,
  CATEGORY varchar(255) DEFAULT NULL,
  SUBJECT text,
  CONTENT longtext,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for DEV_RELATION
-- ----------------------------
CREATE TABLE DEV_RELATION (
  ID varchar(20) NOT NULL,
  OBJECT_ID varchar(255) DEFAULT NULL,
  TARGET_ID varchar(255) DEFAULT NULL,
  CATEGORY varchar(255) DEFAULT NULL,
  EXT_JSON longtext,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for DEV_SMS
-- ----------------------------
CREATE TABLE DEV_SMS (
  ID varchar(20) NOT NULL,
  ENGINE varchar(255) DEFAULT NULL,
  PHONE_NUMBERS text,
  SIGN_NAME text,
  TEMPLATE_CODE text,
  TEMPLATE_PARAM text,
  RECEIPT_INFO longtext,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for GEN_BASIC
-- ----------------------------
CREATE TABLE GEN_BASIC (
  ID varchar(20) NOT NULL,
  DB_TABLE varchar(255) DEFAULT NULL,
  DB_TABLE_KEY varchar(255) DEFAULT NULL,
  PLUGIN_NAME varchar(255) DEFAULT NULL,
  MODULE_NAME varchar(255) DEFAULT NULL,
  TABLE_PREFIX varchar(255) DEFAULT NULL,
  GENERATE_TYPE varchar(255) DEFAULT NULL,
  MODULE varchar(255) DEFAULT NULL,
  MENU_PID varchar(255) DEFAULT NULL,
  MOBILE_MODULE varchar(255) DEFAULT NULL,
  FUNCTION_NAME varchar(255) DEFAULT NULL,
  BUS_NAME varchar(255) DEFAULT NULL,
  CLASS_NAME varchar(255) DEFAULT NULL,
  FORM_LAYOUT varchar(255) DEFAULT NULL,
  GRID_WHETHER varchar(255) DEFAULT NULL,
  PACKAGE_NAME varchar(255) DEFAULT NULL,
  AUTHOR_NAME varchar(255) DEFAULT NULL,
  SORT_CODE int DEFAULT NULL,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for GEN_CONFIG
-- ----------------------------
CREATE TABLE GEN_CONFIG (
  ID varchar(20) NOT NULL,
  BASIC_ID varchar(20) DEFAULT NULL,
  IS_TABLE_KEY varchar(255) DEFAULT NULL,
  FIELD_NAME varchar(255) DEFAULT NULL,
  FIELD_REMARK varchar(255) DEFAULT NULL,
  FIELD_TYPE varchar(255) DEFAULT NULL,
  FIELD_JAVA_TYPE varchar(255) DEFAULT NULL,
  EFFECT_TYPE varchar(255) DEFAULT NULL,
  DICT_TYPE_CODE varchar(255) DEFAULT NULL,
  WHETHER_TABLE varchar(255) DEFAULT NULL,
  WHETHER_RETRACT varchar(255) DEFAULT NULL,
  WHETHER_ADD_UPDATE varchar(255) DEFAULT NULL,
  WHETHER_REQUIRED varchar(255) DEFAULT NULL,
  QUERY_WHETHER varchar(255) DEFAULT NULL,
  QUERY_TYPE varchar(255) DEFAULT NULL,
  SORT_CODE int DEFAULT NULL,
  DELETE_FLAG varchar(20) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for MOBILE_RESOURCE
-- ----------------------------
CREATE TABLE MOBILE_RESOURCE (
  ID varchar(20) NOT NULL,
  PARENT_ID varchar(255) DEFAULT NULL,
  TITLE varchar(255) DEFAULT NULL,
  CODE varchar(255) DEFAULT NULL,
  CATEGORY varchar(255) DEFAULT NULL,
  MODULE varchar(255) DEFAULT NULL,
  MENU_TYPE varchar(255) DEFAULT NULL,
  PATH varchar(255) DEFAULT NULL,
  ICON varchar(255) DEFAULT NULL,
  COLOR varchar(255) DEFAULT NULL,
  REG_TYPE varchar(255) DEFAULT NULL,
  STATUS varchar(255) DEFAULT NULL,
  SORT_CODE int DEFAULT NULL,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for SYS_GROUP
-- ----------------------------
CREATE TABLE SYS_GROUP (
  ID varchar(50) NOT NULL,
  NAME varchar(200) NOT NULL,
  REMARK varchar(500) DEFAULT NULL,
  SORT_CODE int DEFAULT NULL,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for SYS_ORG
-- ----------------------------
CREATE TABLE SYS_ORG (
  ID varchar(20) NOT NULL,
  PARENT_ID varchar(20) DEFAULT NULL,
  DIRECTOR_ID varchar(20) DEFAULT NULL,
  NAME varchar(255) DEFAULT NULL,
  CODE varchar(255) DEFAULT NULL,
  CATEGORY varchar(255) DEFAULT NULL,
  SORT_CODE int DEFAULT NULL,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for SYS_POSITION
-- ----------------------------
CREATE TABLE SYS_POSITION (
  ID varchar(20) NOT NULL,
  ORG_ID varchar(20) DEFAULT NULL,
  NAME varchar(255) DEFAULT NULL,
  CODE varchar(255) DEFAULT NULL,
  CATEGORY varchar(255) DEFAULT NULL,
  SORT_CODE int DEFAULT NULL,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for SYS_RELATION
-- ----------------------------
CREATE TABLE SYS_RELATION (
  ID varchar(20) NOT NULL,
  OBJECT_ID varchar(255) DEFAULT NULL,
  TARGET_ID varchar(255) DEFAULT NULL,
  CATEGORY varchar(255) DEFAULT NULL,
  EXT_JSON longtext,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for SYS_RESOURCE
-- ----------------------------
CREATE TABLE SYS_RESOURCE (
  ID varchar(20) NOT NULL,
  PARENT_ID varchar(255) DEFAULT NULL,
  TITLE varchar(255) DEFAULT NULL,
  NAME varchar(255) DEFAULT NULL,
  CODE varchar(255) DEFAULT NULL,
  CATEGORY varchar(255) DEFAULT NULL,
  MODULE varchar(255) DEFAULT NULL,
  MENU_TYPE varchar(255) DEFAULT NULL,
  PATH text,
  COMPONENT varchar(255) DEFAULT NULL,
  ICON varchar(255) DEFAULT NULL,
  COLOR varchar(255) DEFAULT NULL,
  VISIBLE varchar(255) DEFAULT NULL,
  SORT_CODE int DEFAULT NULL,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for SYS_ROLE
-- ----------------------------
CREATE TABLE SYS_ROLE (
  ID varchar(20) NOT NULL,
  ORG_ID varchar(20) DEFAULT NULL,
  NAME varchar(255) DEFAULT NULL,
  CODE varchar(255) DEFAULT NULL,
  CATEGORY varchar(255) DEFAULT NULL,
  SORT_CODE int DEFAULT NULL,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for SYS_USER
-- ----------------------------
CREATE TABLE SYS_USER (
  ID varchar(20) NOT NULL,
  AVATAR longtext,
  SIGNATURE longtext,
  ACCOUNT varchar(255) DEFAULT NULL,
  PASSWORD varchar(255) DEFAULT NULL,
  NAME varchar(255) DEFAULT NULL,
  NICKNAME varchar(255) DEFAULT NULL,
  GENDER varchar(255) DEFAULT NULL,
  AGE varchar(255) DEFAULT NULL,
  BIRTHDAY varchar(255) DEFAULT NULL,
  NATION varchar(255) DEFAULT NULL,
  NATIVE_PLACE varchar(255) DEFAULT NULL,
  HOME_ADDRESS text,
  MAILING_ADDRESS text,
  ID_CARD_TYPE varchar(255) DEFAULT NULL,
  ID_CARD_NUMBER varchar(255) DEFAULT NULL,
  CULTURE_LEVEL varchar(255) DEFAULT NULL,
  POLITICAL_OUTLOOK varchar(255) DEFAULT NULL,
  COLLEGE varchar(255) DEFAULT NULL,
  EDUCATION varchar(255) DEFAULT NULL,
  EDU_LENGTH varchar(255) DEFAULT NULL,
  DEGREE varchar(255) DEFAULT NULL,
  PHONE varchar(255) DEFAULT NULL,
  EMAIL varchar(255) DEFAULT NULL,
  HOME_TEL varchar(255) DEFAULT NULL,
  OFFICE_TEL varchar(255) DEFAULT NULL,
  EMERGENCY_CONTACT varchar(255) DEFAULT NULL,
  EMERGENCY_PHONE varchar(255) DEFAULT NULL,
  EMERGENCY_ADDRESS text,
  EMP_NO varchar(255) DEFAULT NULL,
  ENTRY_DATE varchar(255) DEFAULT NULL,
  ORG_ID varchar(20) DEFAULT NULL,
  POSITION_ID varchar(20) DEFAULT NULL,
  POSITION_LEVEL varchar(255) DEFAULT NULL,
  DIRECTOR_ID varchar(20) DEFAULT NULL,
  POSITION_JSON longtext,
  LAST_LOGIN_IP varchar(255) DEFAULT NULL,
  LAST_LOGIN_ADDRESS varchar(255) DEFAULT NULL,
  LAST_LOGIN_TIME datetime DEFAULT NULL,
  LAST_LOGIN_DEVICE text,
  LATEST_LOGIN_IP varchar(255) DEFAULT NULL,
  LATEST_LOGIN_ADDRESS varchar(255) DEFAULT NULL,
  LATEST_LOGIN_TIME datetime DEFAULT NULL,
  LATEST_LOGIN_DEVICE text,
  USER_STATUS varchar(255) DEFAULT NULL,
  SORT_CODE int DEFAULT NULL,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for BIZ_NOTICE
-- ----------------------------
CREATE TABLE BIZ_NOTICE (
   ID varchar(20) NOT NULL,
   TITLE varchar(200) DEFAULT NULL,
   IMAGE varchar(200) DEFAULT NULL,
   CONTENT text,
   DIGEST varchar(300) DEFAULT NULL,
   TYPE varchar(50) DEFAULT NULL,
   PLACE varchar(50) DEFAULT NULL,
   STATUS varchar(10) DEFAULT NULL,
   SORT_CODE int DEFAULT NULL,
   REMARK varchar(500) DEFAULT NULL,
   EXT_JSON longtext,
   DELETE_FLAG varchar(255) DEFAULT NULL,
   CREATE_TIME datetime DEFAULT NULL,
   CREATE_USER varchar(20) DEFAULT NULL,
   UPDATE_TIME datetime DEFAULT NULL,
   UPDATE_USER varchar(20) DEFAULT NULL,
   PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for DEV_SLIDESHOW
-- ----------------------------
CREATE TABLE DEV_SLIDESHOW (
  ID varchar(20) NOT NULL,
  TITLE varchar(200) DEFAULT NULL,
  PLACE varchar(500) DEFAULT NULL,
  IMAGE varchar(200) DEFAULT NULL,
  PATH_DETAILS varchar(500) DEFAULT NULL,
  STATUS varchar(10) DEFAULT NULL,
  SORT_CODE int DEFAULT NULL,
  EXT_JSON longtext,
  DELETE_FLAG varchar(255) DEFAULT NULL,
  CREATE_TIME datetime DEFAULT NULL,
  CREATE_USER varchar(20) DEFAULT NULL,
  UPDATE_TIME datetime DEFAULT NULL,
  UPDATE_USER varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
);

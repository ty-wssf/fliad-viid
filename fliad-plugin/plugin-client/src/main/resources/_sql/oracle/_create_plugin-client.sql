
CREATE TABLE client_relation(
  ID VARCHAR2(20) NOT NULL ,
  OBJECT_ID VARCHAR2(255)  ,
  TARGET_ID VARCHAR2(255)  ,
  CATEGORY VARCHAR2(255)  ,
  EXT_JSON CLOB  ,
  constraint PK_client_relation primary key (ID)
);

CREATE TABLE client_user(
  ID VARCHAR2(20) NOT NULL ,
  AVATAR CLOB  ,
  SIGNATURE CLOB  ,
  ACCOUNT VARCHAR2(255)  ,
  PASSWORD VARCHAR2(255)  ,
  NAME VARCHAR2(255)  ,
  NICKNAME VARCHAR2(255)  ,
  GENDER VARCHAR2(255)  ,
  AGE VARCHAR2(255)  ,
  BIRTHDAY VARCHAR2(255)  ,
  NATION VARCHAR2(255)  ,
  NATIVE_PLACE VARCHAR2(255)  ,
  HOME_ADDRESS CLOB  ,
  MAILING_ADDRESS CLOB  ,
  ID_CARD_TYPE VARCHAR2(255)  ,
  ID_CARD_NUMBER VARCHAR2(255)  ,
  CULTURE_LEVEL VARCHAR2(255)  ,
  POLITICAL_OUTLOOK VARCHAR2(255)  ,
  COLLEGE VARCHAR2(255)  ,
  EDUCATION VARCHAR2(255)  ,
  EDU_LENGTH VARCHAR2(255)  ,
  DEGREE VARCHAR2(255)  ,
  PHONE VARCHAR2(255)  ,
  EMAIL VARCHAR2(255)  ,
  HOME_TEL VARCHAR2(255)  ,
  OFFICE_TEL VARCHAR2(255)  ,
  EMERGENCY_CONTACT VARCHAR2(255)  ,
  EMERGENCY_PHONE VARCHAR2(255)  ,
  EMERGENCY_ADDRESS CLOB  ,
  LAST_LOGIN_IP VARCHAR2(255)  ,
  LAST_LOGIN_ADDRESS VARCHAR2(255)  ,
  LAST_LOGIN_TIME DATE  ,
  LAST_LOGIN_DEVICE CLOB  ,
  LATEST_LOGIN_IP VARCHAR2(255)  ,
  LATEST_LOGIN_ADDRESS VARCHAR2(255)  ,
  LATEST_LOGIN_TIME DATE  ,
  LATEST_LOGIN_DEVICE CLOB  ,
  USER_STATUS VARCHAR2(255)  ,
  SORT_CODE INTEGER  ,
  EXT_JSON CLOB  ,
  DELETE_FLAG VARCHAR2(255)  ,
  CREATE_TIME DATE  ,
  CREATE_USER VARCHAR2(20)  ,
  UPDATE_TIME DATE  ,
  UPDATE_USER VARCHAR2(20)  ,
  constraint PK_client_user primary key (ID)
);


      COMMENT ON TABLE client_relation IS '关系';
                
      COMMENT ON COLUMN client_relation.ID IS 'Id';
                    
      COMMENT ON COLUMN client_relation.OBJECT_ID IS '对象ID';
                    
      COMMENT ON COLUMN client_relation.TARGET_ID IS '目标ID';
                    
      COMMENT ON COLUMN client_relation.CATEGORY IS '分类';
                    
      COMMENT ON COLUMN client_relation.EXT_JSON IS '扩展信息';
                    
      COMMENT ON TABLE client_user IS 'C端用户';
                
      COMMENT ON COLUMN client_user.ID IS 'Id';
                    
      COMMENT ON COLUMN client_user.AVATAR IS '头像';
                    
      COMMENT ON COLUMN client_user.SIGNATURE IS '签名';
                    
      COMMENT ON COLUMN client_user.ACCOUNT IS '账号';
                    
      COMMENT ON COLUMN client_user.PASSWORD IS '密码';
                    
      COMMENT ON COLUMN client_user.NAME IS '姓名';
                    
      COMMENT ON COLUMN client_user.NICKNAME IS '昵称';
                    
      COMMENT ON COLUMN client_user.GENDER IS '性别';
                    
      COMMENT ON COLUMN client_user.AGE IS '年龄';
                    
      COMMENT ON COLUMN client_user.BIRTHDAY IS '出生日期';
                    
      COMMENT ON COLUMN client_user.NATION IS '民族';
                    
      COMMENT ON COLUMN client_user.NATIVE_PLACE IS '籍贯';
                    
      COMMENT ON COLUMN client_user.HOME_ADDRESS IS '家庭住址';
                    
      COMMENT ON COLUMN client_user.MAILING_ADDRESS IS '通信地址';
                    
      COMMENT ON COLUMN client_user.ID_CARD_TYPE IS '证件类型';
                    
      COMMENT ON COLUMN client_user.ID_CARD_NUMBER IS '证件号码';
                    
      COMMENT ON COLUMN client_user.CULTURE_LEVEL IS '文化程度';
                    
      COMMENT ON COLUMN client_user.POLITICAL_OUTLOOK IS '政治面貌';
                    
      COMMENT ON COLUMN client_user.COLLEGE IS '毕业院校';
                    
      COMMENT ON COLUMN client_user.EDUCATION IS '学历';
                    
      COMMENT ON COLUMN client_user.EDU_LENGTH IS '学制';
                    
      COMMENT ON COLUMN client_user.DEGREE IS '学位';
                    
      COMMENT ON COLUMN client_user.PHONE IS '手机';
                    
      COMMENT ON COLUMN client_user.EMAIL IS '邮箱';
                    
      COMMENT ON COLUMN client_user.HOME_TEL IS '家庭电话';
                    
      COMMENT ON COLUMN client_user.OFFICE_TEL IS '办公电话';
                    
      COMMENT ON COLUMN client_user.EMERGENCY_CONTACT IS '紧急联系人';
                    
      COMMENT ON COLUMN client_user.EMERGENCY_PHONE IS '紧急联系人电话';
                    
      COMMENT ON COLUMN client_user.EMERGENCY_ADDRESS IS '紧急联系人地址';
                    
      COMMENT ON COLUMN client_user.LAST_LOGIN_IP IS '上次登录ip';
                    
      COMMENT ON COLUMN client_user.LAST_LOGIN_ADDRESS IS '上次登录地点';
                    
      COMMENT ON COLUMN client_user.LAST_LOGIN_TIME IS '上次登录时间';
                    
      COMMENT ON COLUMN client_user.LAST_LOGIN_DEVICE IS '上次登录设备';
                    
      COMMENT ON COLUMN client_user.LATEST_LOGIN_IP IS '最新登录ip';
                    
      COMMENT ON COLUMN client_user.LATEST_LOGIN_ADDRESS IS '最新登录地点';
                    
      COMMENT ON COLUMN client_user.LATEST_LOGIN_TIME IS '最新登录时间';
                    
      COMMENT ON COLUMN client_user.LATEST_LOGIN_DEVICE IS '最新登录设备';
                    
      COMMENT ON COLUMN client_user.USER_STATUS IS '用户状态';
                    
      COMMENT ON COLUMN client_user.SORT_CODE IS '排序码';
                    
      COMMENT ON COLUMN client_user.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN client_user.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN client_user.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN client_user.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN client_user.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN client_user.UPDATE_USER IS '修改用户';
                    


CREATE TABLE client_relation(
  ID VARCHAR(20) NOT NULL  COMMENT 'Id' ,
  OBJECT_ID VARCHAR(255)   COMMENT '对象ID' ,
  TARGET_ID VARCHAR(255)   COMMENT '目标ID' ,
  CATEGORY VARCHAR(255)   COMMENT '分类' ,
  EXT_JSON CLOB   COMMENT '扩展信息' ,
  constraint PK_client_relation primary key (ID)
);

CREATE TABLE client_user(
  ID VARCHAR(20) NOT NULL  COMMENT 'Id' ,
  AVATAR CLOB   COMMENT '头像' ,
  SIGNATURE CLOB   COMMENT '签名' ,
  ACCOUNT VARCHAR(255)   COMMENT '账号' ,
  PASSWORD VARCHAR(255)   COMMENT '密码' ,
  NAME VARCHAR(255)   COMMENT '姓名' ,
  NICKNAME VARCHAR(255)   COMMENT '昵称' ,
  GENDER VARCHAR(255)   COMMENT '性别' ,
  AGE VARCHAR(255)   COMMENT '年龄' ,
  BIRTHDAY VARCHAR(255)   COMMENT '出生日期' ,
  NATION VARCHAR(255)   COMMENT '民族' ,
  NATIVE_PLACE VARCHAR(255)   COMMENT '籍贯' ,
  HOME_ADDRESS VARCHAR(65535)   COMMENT '家庭住址' ,
  MAILING_ADDRESS VARCHAR(65535)   COMMENT '通信地址' ,
  ID_CARD_TYPE VARCHAR(255)   COMMENT '证件类型' ,
  ID_CARD_NUMBER VARCHAR(255)   COMMENT '证件号码' ,
  CULTURE_LEVEL VARCHAR(255)   COMMENT '文化程度' ,
  POLITICAL_OUTLOOK VARCHAR(255)   COMMENT '政治面貌' ,
  COLLEGE VARCHAR(255)   COMMENT '毕业院校' ,
  EDUCATION VARCHAR(255)   COMMENT '学历' ,
  EDU_LENGTH VARCHAR(255)   COMMENT '学制' ,
  DEGREE VARCHAR(255)   COMMENT '学位' ,
  PHONE VARCHAR(255)   COMMENT '手机' ,
  EMAIL VARCHAR(255)   COMMENT '邮箱' ,
  HOME_TEL VARCHAR(255)   COMMENT '家庭电话' ,
  OFFICE_TEL VARCHAR(255)   COMMENT '办公电话' ,
  EMERGENCY_CONTACT VARCHAR(255)   COMMENT '紧急联系人' ,
  EMERGENCY_PHONE VARCHAR(255)   COMMENT '紧急联系人电话' ,
  EMERGENCY_ADDRESS VARCHAR(65535)   COMMENT '紧急联系人地址' ,
  LAST_LOGIN_IP VARCHAR(255)   COMMENT '上次登录ip' ,
  LAST_LOGIN_ADDRESS VARCHAR(255)   COMMENT '上次登录地点' ,
  LAST_LOGIN_TIME DATETIME   COMMENT '上次登录时间' ,
  LAST_LOGIN_DEVICE VARCHAR(65535)   COMMENT '上次登录设备' ,
  LATEST_LOGIN_IP VARCHAR(255)   COMMENT '最新登录ip' ,
  LATEST_LOGIN_ADDRESS VARCHAR(255)   COMMENT '最新登录地点' ,
  LATEST_LOGIN_TIME DATETIME   COMMENT '最新登录时间' ,
  LATEST_LOGIN_DEVICE VARCHAR(65535)   COMMENT '最新登录设备' ,
  USER_STATUS VARCHAR(255)   COMMENT '用户状态' ,
  SORT_CODE INTEGER   COMMENT '排序码' ,
  EXT_JSON CLOB   COMMENT '扩展信息' ,
  DELETE_FLAG VARCHAR(255)   COMMENT '删除标志' ,
  CREATE_TIME DATETIME   COMMENT '创建时间' ,
  CREATE_USER VARCHAR(20)   COMMENT '创建用户' ,
  UPDATE_TIME DATETIME   COMMENT '修改时间' ,
  UPDATE_USER VARCHAR(20)   COMMENT '修改用户' ,
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
                    

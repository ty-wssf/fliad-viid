
CREATE TABLE sys_group(
  ID VARCHAR(50) NOT NULL ,
  NAME VARCHAR(200) NOT NULL ,
  REMARK VARCHAR(500)  ,
  SORT_CODE INT4  ,
  EXT_JSON TEXT  ,
  DELETE_FLAG VARCHAR(255)  ,
  CREATE_TIME TIMESTAMP  ,
  CREATE_USER VARCHAR(20)  ,
  UPDATE_TIME TIMESTAMP  ,
  UPDATE_USER VARCHAR(20)  ,
  constraint PK_sys_group primary key (ID)
);

CREATE TABLE sys_org(
  ID VARCHAR(20) NOT NULL ,
  PARENT_ID VARCHAR(20)  ,
  DIRECTOR_ID VARCHAR(20)  ,
  NAME VARCHAR(255)  ,
  CODE VARCHAR(255)  ,
  CATEGORY VARCHAR(255)  ,
  SORT_CODE INT4  ,
  EXT_JSON TEXT  ,
  DELETE_FLAG VARCHAR(255)  ,
  CREATE_TIME TIMESTAMP  ,
  CREATE_USER VARCHAR(20)  ,
  UPDATE_TIME TIMESTAMP  ,
  UPDATE_USER VARCHAR(20)  ,
  constraint PK_sys_org primary key (ID)
);

CREATE TABLE sys_position(
  ID VARCHAR(20) NOT NULL ,
  ORG_ID VARCHAR(20)  ,
  NAME VARCHAR(255)  ,
  CODE VARCHAR(255)  ,
  CATEGORY VARCHAR(255)  ,
  SORT_CODE INT4  ,
  EXT_JSON TEXT  ,
  DELETE_FLAG VARCHAR(255)  ,
  CREATE_TIME TIMESTAMP  ,
  CREATE_USER VARCHAR(20)  ,
  UPDATE_TIME TIMESTAMP  ,
  UPDATE_USER VARCHAR(20)  ,
  constraint PK_sys_position primary key (ID)
);

CREATE TABLE sys_relation(
  ID VARCHAR(20) NOT NULL ,
  OBJECT_ID VARCHAR(255)  ,
  TARGET_ID VARCHAR(255)  ,
  CATEGORY VARCHAR(255)  ,
  EXT_JSON TEXT  ,
  constraint PK_sys_relation primary key (ID)
);

CREATE TABLE sys_resource(
  ID VARCHAR(20) NOT NULL ,
  PARENT_ID VARCHAR(255)  ,
  TITLE VARCHAR(255)  ,
  NAME VARCHAR(255)  ,
  CODE VARCHAR(255)  ,
  CATEGORY VARCHAR(255)  ,
  MODULE VARCHAR(255)  ,
  MENU_TYPE VARCHAR(255)  ,
  PATH TEXT  ,
  COMPONENT VARCHAR(255)  ,
  ICON VARCHAR(255)  ,
  COLOR VARCHAR(255)  ,
  VISIBLE VARCHAR(255)  ,
  SORT_CODE INT4  ,
  EXT_JSON TEXT  ,
  DELETE_FLAG VARCHAR(255)  ,
  CREATE_TIME TIMESTAMP  ,
  CREATE_USER VARCHAR(20)  ,
  UPDATE_TIME TIMESTAMP  ,
  UPDATE_USER VARCHAR(20)  ,
  constraint PK_sys_resource primary key (ID)
);

CREATE TABLE sys_role(
  ID VARCHAR(20) NOT NULL ,
  ORG_ID VARCHAR(20)  ,
  NAME VARCHAR(255)  ,
  CODE VARCHAR(255)  ,
  CATEGORY VARCHAR(255)  ,
  SORT_CODE INT4  ,
  EXT_JSON TEXT  ,
  DELETE_FLAG VARCHAR(255)  ,
  CREATE_TIME TIMESTAMP  ,
  CREATE_USER VARCHAR(20)  ,
  UPDATE_TIME TIMESTAMP  ,
  UPDATE_USER VARCHAR(20)  ,
  constraint PK_sys_role primary key (ID)
);

CREATE TABLE sys_user(
  ID VARCHAR(20) NOT NULL ,
  AVATAR TEXT  ,
  SIGNATURE TEXT  ,
  ACCOUNT VARCHAR(255)  ,
  PASSWORD VARCHAR(255)  ,
  NAME VARCHAR(255)  ,
  NICKNAME VARCHAR(255)  ,
  GENDER VARCHAR(255)  ,
  AGE VARCHAR(255)  ,
  BIRTHDAY VARCHAR(255)  ,
  NATION VARCHAR(255)  ,
  NATIVE_PLACE VARCHAR(255)  ,
  HOME_ADDRESS TEXT  ,
  MAILING_ADDRESS TEXT  ,
  ID_CARD_TYPE VARCHAR(255)  ,
  ID_CARD_NUMBER VARCHAR(255)  ,
  CULTURE_LEVEL VARCHAR(255)  ,
  POLITICAL_OUTLOOK VARCHAR(255)  ,
  COLLEGE VARCHAR(255)  ,
  EDUCATION VARCHAR(255)  ,
  EDU_LENGTH VARCHAR(255)  ,
  DEGREE VARCHAR(255)  ,
  PHONE VARCHAR(255)  ,
  EMAIL VARCHAR(255)  ,
  HOME_TEL VARCHAR(255)  ,
  OFFICE_TEL VARCHAR(255)  ,
  EMERGENCY_CONTACT VARCHAR(255)  ,
  EMERGENCY_PHONE VARCHAR(255)  ,
  EMERGENCY_ADDRESS TEXT  ,
  EMP_NO VARCHAR(255)  ,
  ENTRY_DATE VARCHAR(255)  ,
  ORG_ID VARCHAR(20)  ,
  POSITION_ID VARCHAR(20)  ,
  POSITION_LEVEL VARCHAR(255)  ,
  DIRECTOR_ID VARCHAR(20)  ,
  POSITION_JSON TEXT  ,
  LAST_LOGIN_IP VARCHAR(255)  ,
  LAST_LOGIN_ADDRESS VARCHAR(255)  ,
  LAST_LOGIN_TIME TIMESTAMP  ,
  LAST_LOGIN_DEVICE TEXT  ,
  LATEST_LOGIN_IP VARCHAR(255)  ,
  LATEST_LOGIN_ADDRESS VARCHAR(255)  ,
  LATEST_LOGIN_TIME TIMESTAMP  ,
  LATEST_LOGIN_DEVICE TEXT  ,
  USER_STATUS VARCHAR(255)  ,
  SORT_CODE INT4  ,
  EXT_JSON TEXT  ,
  DELETE_FLAG VARCHAR(255)  ,
  CREATE_TIME TIMESTAMP  ,
  CREATE_USER VARCHAR(20)  ,
  UPDATE_TIME TIMESTAMP  ,
  UPDATE_USER VARCHAR(20)  ,
  constraint PK_sys_user primary key (ID)
);


      COMMENT ON TABLE sys_group IS '用户组';
                
      COMMENT ON COLUMN sys_group.ID IS '主键';
                    
      COMMENT ON COLUMN sys_group.NAME IS '名称';
                    
      COMMENT ON COLUMN sys_group.REMARK IS '备注';
                    
      COMMENT ON COLUMN sys_group.SORT_CODE IS '排序码';
                    
      COMMENT ON COLUMN sys_group.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN sys_group.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN sys_group.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN sys_group.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN sys_group.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN sys_group.UPDATE_USER IS '修改用户';
                    
      COMMENT ON TABLE sys_org IS '组织';
                
      COMMENT ON COLUMN sys_org.ID IS 'Id';
                    
      COMMENT ON COLUMN sys_org.PARENT_ID IS '父id';
                    
      COMMENT ON COLUMN sys_org.DIRECTOR_ID IS '主管ID';
                    
      COMMENT ON COLUMN sys_org.NAME IS '名称';
                    
      COMMENT ON COLUMN sys_org.CODE IS '编码';
                    
      COMMENT ON COLUMN sys_org.CATEGORY IS '分类';
                    
      COMMENT ON COLUMN sys_org.SORT_CODE IS '排序码';
                    
      COMMENT ON COLUMN sys_org.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN sys_org.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN sys_org.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN sys_org.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN sys_org.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN sys_org.UPDATE_USER IS '修改用户';
                    
      COMMENT ON TABLE sys_position IS '职位';
                
      COMMENT ON COLUMN sys_position.ID IS 'Id';
                    
      COMMENT ON COLUMN sys_position.ORG_ID IS '组织id';
                    
      COMMENT ON COLUMN sys_position.NAME IS '名称';
                    
      COMMENT ON COLUMN sys_position.CODE IS '编码';
                    
      COMMENT ON COLUMN sys_position.CATEGORY IS '分类';
                    
      COMMENT ON COLUMN sys_position.SORT_CODE IS '排序码';
                    
      COMMENT ON COLUMN sys_position.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN sys_position.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN sys_position.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN sys_position.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN sys_position.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN sys_position.UPDATE_USER IS '修改用户';
                    
      COMMENT ON TABLE sys_relation IS '关系';
                
      COMMENT ON COLUMN sys_relation.ID IS 'Id';
                    
      COMMENT ON COLUMN sys_relation.OBJECT_ID IS '对象ID';
                    
      COMMENT ON COLUMN sys_relation.TARGET_ID IS '目标ID';
                    
      COMMENT ON COLUMN sys_relation.CATEGORY IS '分类';
                    
      COMMENT ON COLUMN sys_relation.EXT_JSON IS '扩展信息';
                    
      COMMENT ON TABLE sys_resource IS '资源';
                
      COMMENT ON COLUMN sys_resource.ID IS 'Id';
                    
      COMMENT ON COLUMN sys_resource.PARENT_ID IS '父id';
                    
      COMMENT ON COLUMN sys_resource.TITLE IS '标题';
                    
      COMMENT ON COLUMN sys_resource.NAME IS '别名';
                    
      COMMENT ON COLUMN sys_resource.CODE IS '编码';
                    
      COMMENT ON COLUMN sys_resource.CATEGORY IS '分类';
                    
      COMMENT ON COLUMN sys_resource.MODULE IS '模块';
                    
      COMMENT ON COLUMN sys_resource.MENU_TYPE IS '菜单类型';
                    
      COMMENT ON COLUMN sys_resource.PATH IS '路径';
                    
      COMMENT ON COLUMN sys_resource.COMPONENT IS '组件';
                    
      COMMENT ON COLUMN sys_resource.ICON IS '图标';
                    
      COMMENT ON COLUMN sys_resource.COLOR IS '颜色';
                    
      COMMENT ON COLUMN sys_resource.VISIBLE IS '是否可见';
                    
      COMMENT ON COLUMN sys_resource.SORT_CODE IS '排序码';
                    
      COMMENT ON COLUMN sys_resource.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN sys_resource.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN sys_resource.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN sys_resource.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN sys_resource.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN sys_resource.UPDATE_USER IS '修改用户';
                    
      COMMENT ON TABLE sys_role IS '角色';
                
      COMMENT ON COLUMN sys_role.ID IS 'Id';
                    
      COMMENT ON COLUMN sys_role.ORG_ID IS '组织id';
                    
      COMMENT ON COLUMN sys_role.NAME IS '名称';
                    
      COMMENT ON COLUMN sys_role.CODE IS '编码';
                    
      COMMENT ON COLUMN sys_role.CATEGORY IS '分类';
                    
      COMMENT ON COLUMN sys_role.SORT_CODE IS '排序码';
                    
      COMMENT ON COLUMN sys_role.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN sys_role.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN sys_role.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN sys_role.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN sys_role.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN sys_role.UPDATE_USER IS '修改用户';
                    
      COMMENT ON TABLE sys_user IS '用户';
                
      COMMENT ON COLUMN sys_user.ID IS 'Id';
                    
      COMMENT ON COLUMN sys_user.AVATAR IS '头像';
                    
      COMMENT ON COLUMN sys_user.SIGNATURE IS '签名';
                    
      COMMENT ON COLUMN sys_user.ACCOUNT IS '账号';
                    
      COMMENT ON COLUMN sys_user.PASSWORD IS '密码';
                    
      COMMENT ON COLUMN sys_user.NAME IS '姓名';
                    
      COMMENT ON COLUMN sys_user.NICKNAME IS '昵称';
                    
      COMMENT ON COLUMN sys_user.GENDER IS '性别';
                    
      COMMENT ON COLUMN sys_user.AGE IS '年龄';
                    
      COMMENT ON COLUMN sys_user.BIRTHDAY IS '出生日期';
                    
      COMMENT ON COLUMN sys_user.NATION IS '民族';
                    
      COMMENT ON COLUMN sys_user.NATIVE_PLACE IS '籍贯';
                    
      COMMENT ON COLUMN sys_user.HOME_ADDRESS IS '家庭住址';
                    
      COMMENT ON COLUMN sys_user.MAILING_ADDRESS IS '通信地址';
                    
      COMMENT ON COLUMN sys_user.ID_CARD_TYPE IS '证件类型';
                    
      COMMENT ON COLUMN sys_user.ID_CARD_NUMBER IS '证件号码';
                    
      COMMENT ON COLUMN sys_user.CULTURE_LEVEL IS '文化程度';
                    
      COMMENT ON COLUMN sys_user.POLITICAL_OUTLOOK IS '政治面貌';
                    
      COMMENT ON COLUMN sys_user.COLLEGE IS '毕业院校';
                    
      COMMENT ON COLUMN sys_user.EDUCATION IS '学历';
                    
      COMMENT ON COLUMN sys_user.EDU_LENGTH IS '学制';
                    
      COMMENT ON COLUMN sys_user.DEGREE IS '学位';
                    
      COMMENT ON COLUMN sys_user.PHONE IS '手机';
                    
      COMMENT ON COLUMN sys_user.EMAIL IS '邮箱';
                    
      COMMENT ON COLUMN sys_user.HOME_TEL IS '家庭电话';
                    
      COMMENT ON COLUMN sys_user.OFFICE_TEL IS '办公电话';
                    
      COMMENT ON COLUMN sys_user.EMERGENCY_CONTACT IS '紧急联系人';
                    
      COMMENT ON COLUMN sys_user.EMERGENCY_PHONE IS '紧急联系人电话';
                    
      COMMENT ON COLUMN sys_user.EMERGENCY_ADDRESS IS '紧急联系人地址';
                    
      COMMENT ON COLUMN sys_user.EMP_NO IS '员工编号';
                    
      COMMENT ON COLUMN sys_user.ENTRY_DATE IS '入职日期';
                    
      COMMENT ON COLUMN sys_user.ORG_ID IS '机构id';
                    
      COMMENT ON COLUMN sys_user.POSITION_ID IS '职位id';
                    
      COMMENT ON COLUMN sys_user.POSITION_LEVEL IS '职级';
                    
      COMMENT ON COLUMN sys_user.DIRECTOR_ID IS '主管id';
                    
      COMMENT ON COLUMN sys_user.POSITION_JSON IS '兼任信息';
                    
      COMMENT ON COLUMN sys_user.LAST_LOGIN_IP IS '上次登录ip';
                    
      COMMENT ON COLUMN sys_user.LAST_LOGIN_ADDRESS IS '上次登录地点';
                    
      COMMENT ON COLUMN sys_user.LAST_LOGIN_TIME IS '上次登录时间';
                    
      COMMENT ON COLUMN sys_user.LAST_LOGIN_DEVICE IS '上次登录设备';
                    
      COMMENT ON COLUMN sys_user.LATEST_LOGIN_IP IS '最新登录ip';
                    
      COMMENT ON COLUMN sys_user.LATEST_LOGIN_ADDRESS IS '最新登录地点';
                    
      COMMENT ON COLUMN sys_user.LATEST_LOGIN_TIME IS '最新登录时间';
                    
      COMMENT ON COLUMN sys_user.LATEST_LOGIN_DEVICE IS '最新登录设备';
                    
      COMMENT ON COLUMN sys_user.USER_STATUS IS '用户状态';
                    
      COMMENT ON COLUMN sys_user.SORT_CODE IS '排序码';
                    
      COMMENT ON COLUMN sys_user.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN sys_user.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN sys_user.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN sys_user.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN sys_user.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN sys_user.UPDATE_USER IS '修改用户';
                    

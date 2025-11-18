
CREATE TABLE AUTH_THIRD_USER(
  ID VARCHAR(20) NOT NULL  COMMENT 'Id' ,
  THIRD_ID VARCHAR(255)   COMMENT '三方用户id' ,
  USER_ID VARCHAR(20)   COMMENT '系统用户id' ,
  AVATAR CLOB   COMMENT '头像' ,
  NAME VARCHAR(255)   COMMENT '姓名' ,
  NICKNAME VARCHAR(255)   COMMENT '昵称' ,
  GENDER VARCHAR(255)   COMMENT '性别' ,
  CATEGORY VARCHAR(255)   COMMENT '分类' ,
  EXT_JSON CLOB   COMMENT '扩展信息' ,
  DELETE_FLAG VARCHAR(255)   COMMENT '删除标志' ,
  CREATE_TIME DATETIME   COMMENT '创建时间' ,
  CREATE_USER VARCHAR(20)   COMMENT '创建用户' ,
  UPDATE_TIME DATETIME   COMMENT '修改时间' ,
  UPDATE_USER VARCHAR(20)   COMMENT '修改用户' ,
  constraint PK_AUTH_THIRD_USER primary key (ID)
);


      COMMENT ON TABLE AUTH_THIRD_USER IS '三方用户';
                
      COMMENT ON COLUMN AUTH_THIRD_USER.ID IS 'Id';
                    
      COMMENT ON COLUMN AUTH_THIRD_USER.THIRD_ID IS '三方用户id';
                    
      COMMENT ON COLUMN AUTH_THIRD_USER.USER_ID IS '系统用户id';
                    
      COMMENT ON COLUMN AUTH_THIRD_USER.AVATAR IS '头像';
                    
      COMMENT ON COLUMN AUTH_THIRD_USER.NAME IS '姓名';
                    
      COMMENT ON COLUMN AUTH_THIRD_USER.NICKNAME IS '昵称';
                    
      COMMENT ON COLUMN AUTH_THIRD_USER.GENDER IS '性别';
                    
      COMMENT ON COLUMN AUTH_THIRD_USER.CATEGORY IS '分类';
                    
      COMMENT ON COLUMN AUTH_THIRD_USER.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN AUTH_THIRD_USER.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN AUTH_THIRD_USER.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN AUTH_THIRD_USER.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN AUTH_THIRD_USER.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN AUTH_THIRD_USER.UPDATE_USER IS '修改用户';
                    

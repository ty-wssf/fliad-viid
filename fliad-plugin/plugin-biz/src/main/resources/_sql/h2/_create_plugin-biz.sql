
CREATE TABLE BIZ_NOTICE(
  ID VARCHAR(20) NOT NULL  COMMENT '主键' ,
  TITLE VARCHAR(200)   COMMENT '标题' ,
  IMAGE VARCHAR(200)   COMMENT '封面图' ,
  CONTENT VARCHAR(65535)   COMMENT '内容' ,
  DIGEST VARCHAR(300)   COMMENT '摘要' ,
  TYPE VARCHAR(50)   COMMENT '类型' ,
  PLACE VARCHAR(50)   COMMENT '发布位置' ,
  STATUS VARCHAR(10)   COMMENT '状态' ,
  SORT_CODE INTEGER   COMMENT '排序' ,
  REMARK VARCHAR(500)   COMMENT '备注' ,
  EXT_JSON CLOB   COMMENT '扩展信息' ,
  DELETE_FLAG VARCHAR(255)   COMMENT '删除标志' ,
  CREATE_TIME DATETIME   COMMENT '创建时间' ,
  CREATE_USER VARCHAR(20)   COMMENT '创建用户' ,
  UPDATE_TIME DATETIME   COMMENT '更新时间' ,
  UPDATE_USER VARCHAR(20)   COMMENT '更新用户' ,
  constraint PK_BIZ_NOTICE primary key (ID)
);


      COMMENT ON TABLE BIZ_NOTICE IS '通知公告';
                
      COMMENT ON COLUMN BIZ_NOTICE.ID IS '主键';
                    
      COMMENT ON COLUMN BIZ_NOTICE.TITLE IS '标题';
                    
      COMMENT ON COLUMN BIZ_NOTICE.IMAGE IS '封面图';
                    
      COMMENT ON COLUMN BIZ_NOTICE.CONTENT IS '内容';
                    
      COMMENT ON COLUMN BIZ_NOTICE.DIGEST IS '摘要';
                    
      COMMENT ON COLUMN BIZ_NOTICE.TYPE IS '类型';
                    
      COMMENT ON COLUMN BIZ_NOTICE.PLACE IS '发布位置';
                    
      COMMENT ON COLUMN BIZ_NOTICE.STATUS IS '状态';
                    
      COMMENT ON COLUMN BIZ_NOTICE.SORT_CODE IS '排序';
                    
      COMMENT ON COLUMN BIZ_NOTICE.REMARK IS '备注';
                    
      COMMENT ON COLUMN BIZ_NOTICE.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN BIZ_NOTICE.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN BIZ_NOTICE.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN BIZ_NOTICE.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN BIZ_NOTICE.UPDATE_TIME IS '更新时间';
                    
      COMMENT ON COLUMN BIZ_NOTICE.UPDATE_USER IS '更新用户';
                    

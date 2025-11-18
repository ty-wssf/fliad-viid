
CREATE TABLE BIZ_NOTICE(
  ID VARCHAR(20) NOT NULL ,
  TITLE VARCHAR(200)  ,
  IMAGE VARCHAR(200)  ,
  CONTENT TEXT  ,
  DIGEST VARCHAR(300)  ,
  TYPE VARCHAR(50)  ,
  PLACE VARCHAR(50)  ,
  STATUS VARCHAR(10)  ,
  SORT_CODE INT4  ,
  REMARK VARCHAR(500)  ,
  EXT_JSON TEXT  ,
  DELETE_FLAG VARCHAR(255)  ,
  CREATE_TIME TIMESTAMP  ,
  CREATE_USER VARCHAR(20)  ,
  UPDATE_TIME TIMESTAMP  ,
  UPDATE_USER VARCHAR(20)  ,
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
                    

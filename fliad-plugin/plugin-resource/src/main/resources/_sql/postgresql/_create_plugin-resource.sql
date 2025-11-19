
CREATE TABLE resource_datasource(
  ID VARCHAR(20) NOT NULL ,
  IS_TEMPLATE BOOLEAN default false   ,
  TITLE VARCHAR(255)  ,
  SUBSCRIBE_DETAIL VARCHAR(255)  ,
  TYPE VARCHAR(50)  ,
  REMARK VARCHAR(255)  ,
  CONTENT TEXT  ,
  CREATE_TIME TIMESTAMP  ,
  CREATE_USER VARCHAR(20)  ,
  UPDATE_TIME TIMESTAMP  ,
  UPDATE_USER VARCHAR(20)  ,
  STATUS VARCHAR(10)  ,
  SCRIPT_FILTER TEXT  ,
  constraint PK_resource_datasource primary key (ID)
);

CREATE TABLE resource_workflow(
  ID VARCHAR(20) NOT NULL ,
  IS_TEMPLATE BOOLEAN default false   ,
  TITLE VARCHAR(255)  ,
  SUBSCRIBE_DETAIL VARCHAR(255)  ,
  STATUS VARCHAR(10)  ,
  REMARK VARCHAR(255)  ,
  CONTENT TEXT  ,
  CREATE_TIME TIMESTAMP  ,
  CREATE_USER VARCHAR(20)  ,
  UPDATE_TIME TIMESTAMP  ,
  UPDATE_USER VARCHAR(20)  ,
  constraint PK_resource_workflow primary key (ID)
);


      COMMENT ON TABLE resource_datasource IS '数据源';
                
      COMMENT ON COLUMN resource_datasource.ID IS 'Id';
                    
      COMMENT ON COLUMN resource_datasource.IS_TEMPLATE IS '是否为模板';
                    
      COMMENT ON COLUMN resource_datasource.TITLE IS '标题';
                    
      COMMENT ON COLUMN resource_datasource.SUBSCRIBE_DETAIL IS '订阅类别';
                    
      COMMENT ON COLUMN resource_datasource.TYPE IS '类型';
                    
      COMMENT ON COLUMN resource_datasource.REMARK IS '备注';
                    
      COMMENT ON COLUMN resource_datasource.CONTENT IS '数据源配置的 JSON 内容';
                    
      COMMENT ON COLUMN resource_datasource.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN resource_datasource.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN resource_datasource.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN resource_datasource.UPDATE_USER IS '修改用户';
                    
      COMMENT ON COLUMN resource_datasource.STATUS IS '状态';
                    
      COMMENT ON COLUMN resource_datasource.SCRIPT_FILTER IS '脚本过滤器';
                    
      COMMENT ON TABLE resource_workflow IS '工作流';
                
      COMMENT ON COLUMN resource_workflow.ID IS 'Id';
                    
      COMMENT ON COLUMN resource_workflow.IS_TEMPLATE IS '是否为模板';
                    
      COMMENT ON COLUMN resource_workflow.TITLE IS '标题';
                    
      COMMENT ON COLUMN resource_workflow.SUBSCRIBE_DETAIL IS '订阅类别';
                    
      COMMENT ON COLUMN resource_workflow.STATUS IS '状态';
                    
      COMMENT ON COLUMN resource_workflow.REMARK IS '备注';
                    
      COMMENT ON COLUMN resource_workflow.CONTENT IS '工作流设计的 JSON 内容';
                    
      COMMENT ON COLUMN resource_workflow.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN resource_workflow.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN resource_workflow.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN resource_workflow.UPDATE_USER IS '修改用户';
                    

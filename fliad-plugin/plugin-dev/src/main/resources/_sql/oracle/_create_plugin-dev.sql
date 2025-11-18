
CREATE TABLE DEV_CONFIG(
  ID VARCHAR2(20) NOT NULL ,
  CONFIG_KEY VARCHAR2(255)  ,
  CONFIG_VALUE CLOB  ,
  CATEGORY VARCHAR2(255)  ,
  REMARK VARCHAR2(255)  ,
  SORT_CODE INTEGER  ,
  EXT_JSON CLOB  ,
  DELETE_FLAG VARCHAR2(255)  ,
  CREATE_TIME DATE  ,
  CREATE_USER VARCHAR2(20)  ,
  UPDATE_TIME DATE  ,
  UPDATE_USER VARCHAR2(20)  ,
  constraint PK_DEV_CONFIG primary key (ID)
);

CREATE TABLE DEV_DICT(
  ID VARCHAR2(20) NOT NULL ,
  PARENT_ID VARCHAR2(20)  ,
  DICT_LABEL VARCHAR2(255)  ,
  DICT_VALUE VARCHAR2(255)  ,
  CATEGORY VARCHAR2(255)  ,
  SORT_CODE INTEGER  ,
  EXT_JSON CLOB  ,
  DELETE_FLAG VARCHAR2(255)  ,
  CREATE_TIME DATE  ,
  CREATE_USER VARCHAR2(20)  ,
  UPDATE_TIME DATE  ,
  UPDATE_USER VARCHAR2(20)  ,
  constraint PK_DEV_DICT primary key (ID)
);

CREATE TABLE DEV_EMAIL(
  ID VARCHAR2(20) NOT NULL ,
  ENGINE VARCHAR2(255)  ,
  SEND_ACCOUNT VARCHAR2(255)  ,
  SEND_USER VARCHAR2(255)  ,
  RECEIVE_ACCOUNTS CLOB  ,
  SUBJECT CLOB  ,
  CONTENT CLOB  ,
  TAG_NAME VARCHAR2(255)  ,
  TEMPLATE_NAME CLOB  ,
  TEMPLATE_PARAM CLOB  ,
  RECEIPT_INFO CLOB  ,
  EXT_JSON CLOB  ,
  DELETE_FLAG VARCHAR2(255)  ,
  CREATE_TIME DATE  ,
  CREATE_USER VARCHAR2(20)  ,
  UPDATE_TIME DATE  ,
  UPDATE_USER VARCHAR2(20)  ,
  constraint PK_DEV_EMAIL primary key (ID)
);

CREATE TABLE DEV_FILE(
  ID VARCHAR2(20) NOT NULL ,
  ENGINE VARCHAR2(255)  ,
  BUCKET VARCHAR2(255)  ,
  NAME CLOB  ,
  SUFFIX VARCHAR2(255)  ,
  SIZE_KB NUMBER(20)  ,
  SIZE_INFO VARCHAR2(255)  ,
  OBJ_NAME CLOB  ,
  STORAGE_PATH CLOB  ,
  DOWNLOAD_PATH CLOB  ,
  THUMBNAIL CLOB  ,
  EXT_JSON CLOB  ,
  DELETE_FLAG VARCHAR2(255)  ,
  CREATE_TIME DATE  ,
  CREATE_USER VARCHAR2(20)  ,
  UPDATE_TIME DATE  ,
  UPDATE_USER VARCHAR2(20)  ,
  constraint PK_DEV_FILE primary key (ID)
);

CREATE TABLE DEV_JOB(
  ID VARCHAR2(20) NOT NULL ,
  NAME VARCHAR2(255)  ,
  CODE VARCHAR2(255)  ,
  CATEGORY VARCHAR2(255)  ,
  ACTION_CLASS VARCHAR2(255)  ,
  CRON_EXPRESSION VARCHAR2(255)  ,
  JOB_STATUS VARCHAR2(255)  ,
  SORT_CODE INTEGER  ,
  EXT_JSON CLOB  ,
  DELETE_FLAG VARCHAR2(255)  ,
  CREATE_TIME DATE  ,
  CREATE_USER VARCHAR2(20)  ,
  UPDATE_TIME DATE  ,
  UPDATE_USER VARCHAR2(20)  ,
  constraint PK_DEV_JOB primary key (ID)
);

CREATE TABLE DEV_LOG(
  ID VARCHAR2(20) NOT NULL ,
  CATEGORY VARCHAR2(255)  ,
  NAME VARCHAR2(255)  ,
  EXE_STATUS VARCHAR2(255)  ,
  EXE_MESSAGE CLOB  ,
  OP_IP VARCHAR2(255)  ,
  OP_ADDRESS VARCHAR2(255)  ,
  OP_BROWSER VARCHAR2(255)  ,
  OP_OS VARCHAR2(255)  ,
  CLASS_NAME VARCHAR2(255)  ,
  METHOD_NAME VARCHAR2(255)  ,
  REQ_METHOD VARCHAR2(255)  ,
  REQ_URL CLOB  ,
  PARAM_JSON CLOB  ,
  RESULT_JSON CLOB  ,
  OP_TIME DATE  ,
  OP_USER VARCHAR2(255)  ,
  SIGN_DATA CLOB  ,
  CREATE_TIME DATE  ,
  CREATE_USER VARCHAR2(20)  ,
  UPDATE_TIME DATE  ,
  UPDATE_USER VARCHAR2(20)  ,
  constraint PK_DEV_LOG primary key (ID)
);

CREATE TABLE DEV_MESSAGE(
  ID VARCHAR2(20) NOT NULL ,
  CATEGORY VARCHAR2(255)  ,
  SUBJECT CLOB  ,
  CONTENT CLOB  ,
  EXT_JSON CLOB  ,
  DELETE_FLAG VARCHAR2(255)  ,
  CREATE_TIME DATE  ,
  CREATE_USER VARCHAR2(20)  ,
  UPDATE_TIME DATE  ,
  UPDATE_USER VARCHAR2(20)  ,
  constraint PK_DEV_MESSAGE primary key (ID)
);

CREATE TABLE DEV_RELATION(
  ID VARCHAR2(20) NOT NULL ,
  OBJECT_ID VARCHAR2(255)  ,
  TARGET_ID VARCHAR2(255)  ,
  CATEGORY VARCHAR2(255)  ,
  EXT_JSON CLOB  ,
  constraint PK_DEV_RELATION primary key (ID)
);

CREATE TABLE DEV_SLIDESHOW(
  ID VARCHAR2(20) NOT NULL ,
  TITLE VARCHAR2(200)  ,
  PLACE VARCHAR2(500)  ,
  IMAGE VARCHAR2(200)  ,
  PATH_DETAILS VARCHAR2(500)  ,
  STATUS VARCHAR2(10)  ,
  SORT_CODE INTEGER  ,
  EXT_JSON CLOB  ,
  DELETE_FLAG VARCHAR2(255)  ,
  CREATE_TIME DATE  ,
  CREATE_USER VARCHAR2(20)  ,
  UPDATE_TIME DATE  ,
  UPDATE_USER VARCHAR2(20)  ,
  constraint PK_DEV_SLIDESHOW primary key (ID)
);

CREATE TABLE DEV_SMS(
  ID VARCHAR2(20) NOT NULL ,
  ENGINE VARCHAR2(255)  ,
  PHONE_NUMBERS CLOB  ,
  SIGN_NAME CLOB  ,
  TEMPLATE_CODE CLOB  ,
  TEMPLATE_PARAM CLOB  ,
  RECEIPT_INFO CLOB  ,
  EXT_JSON CLOB  ,
  DELETE_FLAG VARCHAR2(255)  ,
  CREATE_TIME DATE  ,
  CREATE_USER VARCHAR2(20)  ,
  UPDATE_TIME DATE  ,
  UPDATE_USER VARCHAR2(20)  ,
  constraint PK_DEV_SMS primary key (ID)
);


      COMMENT ON TABLE DEV_CONFIG IS '配置';
                
      COMMENT ON COLUMN DEV_CONFIG.ID IS 'Id';
                    
      COMMENT ON COLUMN DEV_CONFIG.CONFIG_KEY IS '配置键';
                    
      COMMENT ON COLUMN DEV_CONFIG.CONFIG_VALUE IS '配置值';
                    
      COMMENT ON COLUMN DEV_CONFIG.CATEGORY IS '分类';
                    
      COMMENT ON COLUMN DEV_CONFIG.REMARK IS '备注';
                    
      COMMENT ON COLUMN DEV_CONFIG.SORT_CODE IS '排序码';
                    
      COMMENT ON COLUMN DEV_CONFIG.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN DEV_CONFIG.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN DEV_CONFIG.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN DEV_CONFIG.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN DEV_CONFIG.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN DEV_CONFIG.UPDATE_USER IS '修改用户';
                    
      COMMENT ON TABLE DEV_DICT IS '字典';
                
      COMMENT ON COLUMN DEV_DICT.ID IS 'Id';
                    
      COMMENT ON COLUMN DEV_DICT.PARENT_ID IS '父id';
                    
      COMMENT ON COLUMN DEV_DICT.DICT_LABEL IS '字典文字';
                    
      COMMENT ON COLUMN DEV_DICT.DICT_VALUE IS '字典值';
                    
      COMMENT ON COLUMN DEV_DICT.CATEGORY IS '分类';
                    
      COMMENT ON COLUMN DEV_DICT.SORT_CODE IS '排序码';
                    
      COMMENT ON COLUMN DEV_DICT.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN DEV_DICT.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN DEV_DICT.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN DEV_DICT.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN DEV_DICT.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN DEV_DICT.UPDATE_USER IS '修改用户';
                    
      COMMENT ON TABLE DEV_EMAIL IS '邮件';
                
      COMMENT ON COLUMN DEV_EMAIL.ID IS 'Id';
                    
      COMMENT ON COLUMN DEV_EMAIL.ENGINE IS '邮件引擎';
                    
      COMMENT ON COLUMN DEV_EMAIL.SEND_ACCOUNT IS '发件人邮箱';
                    
      COMMENT ON COLUMN DEV_EMAIL.SEND_USER IS '发件人昵称';
                    
      COMMENT ON COLUMN DEV_EMAIL.RECEIVE_ACCOUNTS IS '接收人';
                    
      COMMENT ON COLUMN DEV_EMAIL.SUBJECT IS '邮件主题';
                    
      COMMENT ON COLUMN DEV_EMAIL.CONTENT IS '邮件正文';
                    
      COMMENT ON COLUMN DEV_EMAIL.TAG_NAME IS '标签名';
                    
      COMMENT ON COLUMN DEV_EMAIL.TEMPLATE_NAME IS '模板名';
                    
      COMMENT ON COLUMN DEV_EMAIL.TEMPLATE_PARAM IS '发送参数';
                    
      COMMENT ON COLUMN DEV_EMAIL.RECEIPT_INFO IS '回执信息';
                    
      COMMENT ON COLUMN DEV_EMAIL.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN DEV_EMAIL.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN DEV_EMAIL.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN DEV_EMAIL.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN DEV_EMAIL.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN DEV_EMAIL.UPDATE_USER IS '修改用户';
                    
      COMMENT ON TABLE DEV_FILE IS '文件';
                
      COMMENT ON COLUMN DEV_FILE.ID IS 'Id';
                    
      COMMENT ON COLUMN DEV_FILE.ENGINE IS '存储引擎';
                    
      COMMENT ON COLUMN DEV_FILE.BUCKET IS '存储桶';
                    
      COMMENT ON COLUMN DEV_FILE.NAME IS '文件名称';
                    
      COMMENT ON COLUMN DEV_FILE.SUFFIX IS '文件后缀';
                    
      COMMENT ON COLUMN DEV_FILE.SIZE_KB IS '文件大小kb';
                    
      COMMENT ON COLUMN DEV_FILE.SIZE_INFO IS '文件大小（格式化后）';
                    
      COMMENT ON COLUMN DEV_FILE.OBJ_NAME IS '文件的对象名（唯一名称）';
                    
      COMMENT ON COLUMN DEV_FILE.STORAGE_PATH IS '文件存储路径';
                    
      COMMENT ON COLUMN DEV_FILE.DOWNLOAD_PATH IS '文件下载路径';
                    
      COMMENT ON COLUMN DEV_FILE.THUMBNAIL IS '图片缩略图';
                    
      COMMENT ON COLUMN DEV_FILE.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN DEV_FILE.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN DEV_FILE.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN DEV_FILE.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN DEV_FILE.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN DEV_FILE.UPDATE_USER IS '修改用户';
                    
      COMMENT ON TABLE DEV_JOB IS '定时任务';
                
      COMMENT ON COLUMN DEV_JOB.ID IS 'Id';
                    
      COMMENT ON COLUMN DEV_JOB.NAME IS '名称';
                    
      COMMENT ON COLUMN DEV_JOB.CODE IS '编码';
                    
      COMMENT ON COLUMN DEV_JOB.CATEGORY IS '分类';
                    
      COMMENT ON COLUMN DEV_JOB.ACTION_CLASS IS '任务类名';
                    
      COMMENT ON COLUMN DEV_JOB.CRON_EXPRESSION IS 'cron表达式';
                    
      COMMENT ON COLUMN DEV_JOB.JOB_STATUS IS '任务状态';
                    
      COMMENT ON COLUMN DEV_JOB.SORT_CODE IS '排序码';
                    
      COMMENT ON COLUMN DEV_JOB.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN DEV_JOB.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN DEV_JOB.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN DEV_JOB.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN DEV_JOB.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN DEV_JOB.UPDATE_USER IS '修改用户';
                    
      COMMENT ON TABLE DEV_LOG IS '日志';
                
      COMMENT ON COLUMN DEV_LOG.ID IS '主键';
                    
      COMMENT ON COLUMN DEV_LOG.CATEGORY IS '日志分类';
                    
      COMMENT ON COLUMN DEV_LOG.NAME IS '日志名称';
                    
      COMMENT ON COLUMN DEV_LOG.EXE_STATUS IS '执行状态';
                    
      COMMENT ON COLUMN DEV_LOG.EXE_MESSAGE IS '具体消息';
                    
      COMMENT ON COLUMN DEV_LOG.OP_IP IS '操作ip';
                    
      COMMENT ON COLUMN DEV_LOG.OP_ADDRESS IS '操作地址';
                    
      COMMENT ON COLUMN DEV_LOG.OP_BROWSER IS '操作浏览器';
                    
      COMMENT ON COLUMN DEV_LOG.OP_OS IS '操作系统';
                    
      COMMENT ON COLUMN DEV_LOG.CLASS_NAME IS '类名称';
                    
      COMMENT ON COLUMN DEV_LOG.METHOD_NAME IS '方法名称';
                    
      COMMENT ON COLUMN DEV_LOG.REQ_METHOD IS '请求方式';
                    
      COMMENT ON COLUMN DEV_LOG.REQ_URL IS '请求地址';
                    
      COMMENT ON COLUMN DEV_LOG.PARAM_JSON IS '请求参数';
                    
      COMMENT ON COLUMN DEV_LOG.RESULT_JSON IS '返回结果';
                    
      COMMENT ON COLUMN DEV_LOG.OP_TIME IS '操作时间';
                    
      COMMENT ON COLUMN DEV_LOG.OP_USER IS '操作人姓名';
                    
      COMMENT ON COLUMN DEV_LOG.SIGN_DATA IS '签名数据';
                    
      COMMENT ON COLUMN DEV_LOG.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN DEV_LOG.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN DEV_LOG.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN DEV_LOG.UPDATE_USER IS '修改用户';
                    
      COMMENT ON TABLE DEV_MESSAGE IS '站内信';
                
      COMMENT ON COLUMN DEV_MESSAGE.ID IS 'Id';
                    
      COMMENT ON COLUMN DEV_MESSAGE.CATEGORY IS '分类';
                    
      COMMENT ON COLUMN DEV_MESSAGE.SUBJECT IS '主题';
                    
      COMMENT ON COLUMN DEV_MESSAGE.CONTENT IS '正文';
                    
      COMMENT ON COLUMN DEV_MESSAGE.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN DEV_MESSAGE.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN DEV_MESSAGE.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN DEV_MESSAGE.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN DEV_MESSAGE.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN DEV_MESSAGE.UPDATE_USER IS '修改用户';
                    
      COMMENT ON TABLE DEV_RELATION IS '关系';
                
      COMMENT ON COLUMN DEV_RELATION.ID IS 'Id';
                    
      COMMENT ON COLUMN DEV_RELATION.OBJECT_ID IS '对象ID';
                    
      COMMENT ON COLUMN DEV_RELATION.TARGET_ID IS '目标ID';
                    
      COMMENT ON COLUMN DEV_RELATION.CATEGORY IS '分类';
                    
      COMMENT ON COLUMN DEV_RELATION.EXT_JSON IS '扩展信息';
                    
      COMMENT ON TABLE DEV_SLIDESHOW IS '轮播图';
                
      COMMENT ON COLUMN DEV_SLIDESHOW.ID IS '主键';
                    
      COMMENT ON COLUMN DEV_SLIDESHOW.TITLE IS '标题';
                    
      COMMENT ON COLUMN DEV_SLIDESHOW.PLACE IS '展示位置';
                    
      COMMENT ON COLUMN DEV_SLIDESHOW.IMAGE IS '图片';
                    
      COMMENT ON COLUMN DEV_SLIDESHOW.PATH_DETAILS IS '路径详情';
                    
      COMMENT ON COLUMN DEV_SLIDESHOW.STATUS IS '状态';
                    
      COMMENT ON COLUMN DEV_SLIDESHOW.SORT_CODE IS '排序';
                    
      COMMENT ON COLUMN DEV_SLIDESHOW.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN DEV_SLIDESHOW.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN DEV_SLIDESHOW.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN DEV_SLIDESHOW.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN DEV_SLIDESHOW.UPDATE_TIME IS '更新时间';
                    
      COMMENT ON COLUMN DEV_SLIDESHOW.UPDATE_USER IS '更新用户';
                    
      COMMENT ON TABLE DEV_SMS IS '短信';
                
      COMMENT ON COLUMN DEV_SMS.ID IS 'Id';
                    
      COMMENT ON COLUMN DEV_SMS.ENGINE IS '短信引擎';
                    
      COMMENT ON COLUMN DEV_SMS.PHONE_NUMBERS IS '手机号';
                    
      COMMENT ON COLUMN DEV_SMS.SIGN_NAME IS '短信签名';
                    
      COMMENT ON COLUMN DEV_SMS.TEMPLATE_CODE IS '模板编码';
                    
      COMMENT ON COLUMN DEV_SMS.TEMPLATE_PARAM IS '发送参数';
                    
      COMMENT ON COLUMN DEV_SMS.RECEIPT_INFO IS '回执信息';
                    
      COMMENT ON COLUMN DEV_SMS.EXT_JSON IS '扩展信息';
                    
      COMMENT ON COLUMN DEV_SMS.DELETE_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN DEV_SMS.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN DEV_SMS.CREATE_USER IS '创建用户';
                    
      COMMENT ON COLUMN DEV_SMS.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN DEV_SMS.UPDATE_USER IS '修改用户';
                    

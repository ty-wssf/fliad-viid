
CREATE TABLE flow_definition(
  ID BIGINT NOT NULL  COMMENT '主键id' ,
  FLOW_CODE VARCHAR(40) NOT NULL  COMMENT '流程编码' ,
  FLOW_NAME VARCHAR(100) NOT NULL  COMMENT '流程名称' ,
  MODEL_VALUE VARCHAR(40) NOT NULL  COMMENT '设计器模型（CLASSICS经典模型 MIMIC仿钉钉模型）' ,
  CATEGORY VARCHAR(100)   COMMENT '流程类别' ,
  VERSION VARCHAR(20) NOT NULL  COMMENT '流程版本' ,
  IS_PUBLISH BOOLEAN default false  NOT NULL  COMMENT '是否发布（0未发布 1已发布 9失效）' ,
  FORM_CUSTOM CHAR(1)   COMMENT '审批表单是否自定义（Y是 N否）' ,
  FORM_PATH VARCHAR(100)   COMMENT '审批表单路径' ,
  ACTIVITY_STATUS BOOLEAN default true  NOT NULL  COMMENT '流程激活状态（0挂起 1激活）' ,
  LISTENER_TYPE VARCHAR(100)   COMMENT '监听器类型' ,
  LISTENER_PATH VARCHAR(400)   COMMENT '监听器路径' ,
  EXT VARCHAR(500)   COMMENT '业务详情 存业务表对象json字符串' ,
  CREATE_TIME DATETIME   COMMENT '创建时间' ,
  CREATE_BY VARCHAR(64)   COMMENT '创建人' ,
  UPDATE_TIME DATETIME   COMMENT '更新时间' ,
  UPDATE_BY VARCHAR(64)   COMMENT '更新人' ,
  DEL_FLAG CHAR(1) default '0'    COMMENT '删除标志' ,
  TENANT_ID VARCHAR(40)   COMMENT '租户id' ,
  constraint PK_flow_definition primary key (ID)
);

CREATE TABLE flow_his_task(
  ID BIGINT NOT NULL  COMMENT '主键id' ,
  DEFINITION_ID BIGINT NOT NULL  COMMENT '对应flow_definition表的id' ,
  INSTANCE_ID BIGINT NOT NULL  COMMENT '对应flow_instance表的id' ,
  TASK_ID BIGINT NOT NULL  COMMENT '对应flow_task表的id' ,
  NODE_CODE VARCHAR(100)   COMMENT '开始节点编码' ,
  NODE_NAME VARCHAR(100)   COMMENT '开始节点名称' ,
  NODE_TYPE BOOLEAN   COMMENT '开始节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）' ,
  TARGET_NODE_CODE VARCHAR(200)   COMMENT '目标节点编码' ,
  TARGET_NODE_NAME VARCHAR(200)   COMMENT '结束节点名称' ,
  APPROVER VARCHAR(40)   COMMENT '审批人' ,
  COOPERATE_TYPE BOOLEAN default false  NOT NULL  COMMENT '协作方式(1审批 2转办 3委派 4会签 5票签 6加签 7减签)' ,
  COLLABORATOR VARCHAR(500)   COMMENT '协作人' ,
  SKIP_TYPE VARCHAR(10) NOT NULL  COMMENT '流转类型（PASS通过 REJECT退回 NONE无动作）' ,
  FLOW_STATUS VARCHAR(20) NOT NULL  COMMENT '流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）' ,
  FORM_CUSTOM CHAR(1)   COMMENT '审批表单是否自定义（Y是 N否）' ,
  FORM_PATH VARCHAR(100)   COMMENT '审批表单路径' ,
  MESSAGE VARCHAR(500)   COMMENT '审批意见' ,
  VARIABLE VARCHAR(65535)   COMMENT '任务变量' ,
  EXT VARCHAR(65535)   COMMENT '业务详情 存业务表对象json字符串' ,
  CREATE_TIME DATETIME   COMMENT '任务开始时间' ,
  UPDATE_TIME DATETIME   COMMENT '审批完成时间' ,
  DEL_FLAG CHAR(1) default '0'    COMMENT '删除标志' ,
  TENANT_ID VARCHAR(40)   COMMENT '租户id' ,
  constraint PK_flow_his_task primary key (ID)
);

CREATE TABLE flow_instance(
  ID BIGINT NOT NULL  COMMENT '主键id' ,
  DEFINITION_ID BIGINT NOT NULL  COMMENT '对应flow_definition表的id' ,
  BUSINESS_ID VARCHAR(40) NOT NULL  COMMENT '业务id' ,
  NODE_TYPE BOOLEAN NOT NULL  COMMENT '节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）' ,
  NODE_CODE VARCHAR(40) NOT NULL  COMMENT '流程节点编码' ,
  NODE_NAME VARCHAR(100)   COMMENT '流程节点名称' ,
  VARIABLE VARCHAR(65535)   COMMENT '任务变量' ,
  FLOW_STATUS VARCHAR(20) NOT NULL  COMMENT '流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）' ,
  ACTIVITY_STATUS BOOLEAN default true  NOT NULL  COMMENT '流程激活状态（0挂起 1激活）' ,
  DEF_JSON VARCHAR(65535)   COMMENT '流程定义json' ,
  CREATE_TIME DATETIME   COMMENT '创建时间' ,
  CREATE_BY VARCHAR(64)   COMMENT '创建人' ,
  UPDATE_TIME DATETIME   COMMENT '更新时间' ,
  UPDATE_BY VARCHAR(64)   COMMENT '更新人' ,
  EXT VARCHAR(500)   COMMENT '扩展字段，预留给业务系统使用' ,
  DEL_FLAG CHAR(1) default '0'    COMMENT '删除标志' ,
  TENANT_ID VARCHAR(40)   COMMENT '租户id' ,
  constraint PK_flow_instance primary key (ID)
);

CREATE TABLE flow_node(
  ID BIGINT NOT NULL  COMMENT '主键id' ,
  NODE_TYPE BOOLEAN NOT NULL  COMMENT '节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）' ,
  DEFINITION_ID BIGINT NOT NULL  COMMENT '流程定义id' ,
  NODE_CODE VARCHAR(100) NOT NULL  COMMENT '流程节点编码' ,
  NODE_NAME VARCHAR(100)   COMMENT '流程节点名称' ,
  PERMISSION_FLAG VARCHAR(200)   COMMENT '权限标识（权限类型:权限标识，可以多个，用@@隔开)' ,
  NODE_RATIO VARCHAR(200)   COMMENT '流程签署比例值' ,
  COORDINATE VARCHAR(100)   COMMENT '坐标' ,
  ANY_NODE_SKIP VARCHAR(100)   COMMENT '任意结点跳转' ,
  LISTENER_TYPE VARCHAR(100)   COMMENT '监听器类型' ,
  LISTENER_PATH VARCHAR(400)   COMMENT '监听器路径' ,
  FORM_CUSTOM CHAR(1)   COMMENT '审批表单是否自定义（Y是 N否）' ,
  FORM_PATH VARCHAR(100)   COMMENT '审批表单路径' ,
  VERSION VARCHAR(20) NOT NULL  COMMENT '版本' ,
  CREATE_TIME DATETIME   COMMENT '创建时间' ,
  CREATE_BY VARCHAR(64)   COMMENT '创建人' ,
  UPDATE_TIME DATETIME   COMMENT '更新时间' ,
  UPDATE_BY VARCHAR(64)   COMMENT '更新人' ,
  EXT VARCHAR(65535)   COMMENT '节点扩展属性' ,
  DEL_FLAG CHAR(1) default '0'    COMMENT '删除标志' ,
  TENANT_ID VARCHAR(40)   COMMENT '租户id' ,
  constraint PK_flow_node primary key (ID)
);

CREATE TABLE flow_skip(
  ID BIGINT NOT NULL  COMMENT '主键id' ,
  DEFINITION_ID BIGINT NOT NULL  COMMENT '流程定义id' ,
  NOW_NODE_CODE VARCHAR(100) NOT NULL  COMMENT '当前流程节点的编码' ,
  NOW_NODE_TYPE BOOLEAN   COMMENT '当前节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）' ,
  NEXT_NODE_CODE VARCHAR(100) NOT NULL  COMMENT '下一个流程节点的编码' ,
  NEXT_NODE_TYPE BOOLEAN   COMMENT '下一个节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）' ,
  SKIP_NAME VARCHAR(100)   COMMENT '跳转名称' ,
  SKIP_TYPE VARCHAR(40)   COMMENT '跳转类型（PASS审批通过 REJECT退回）' ,
  SKIP_CONDITION VARCHAR(200)   COMMENT '跳转条件' ,
  COORDINATE VARCHAR(100)   COMMENT '坐标' ,
  CREATE_TIME DATETIME   COMMENT '创建时间' ,
  CREATE_BY VARCHAR(64)   COMMENT '创建人' ,
  UPDATE_TIME DATETIME   COMMENT '更新时间' ,
  UPDATE_BY VARCHAR(64)   COMMENT '更新人' ,
  DEL_FLAG CHAR(1) default '0'    COMMENT '删除标志' ,
  TENANT_ID VARCHAR(40)   COMMENT '租户id' ,
  constraint PK_flow_skip primary key (ID)
);

CREATE TABLE flow_task(
  ID BIGINT NOT NULL  COMMENT '主键id' ,
  DEFINITION_ID BIGINT NOT NULL  COMMENT '对应flow_definition表的id' ,
  INSTANCE_ID BIGINT NOT NULL  COMMENT '对应flow_instance表的id' ,
  NODE_CODE VARCHAR(100) NOT NULL  COMMENT '节点编码' ,
  NODE_NAME VARCHAR(100)   COMMENT '节点名称' ,
  NODE_TYPE BOOLEAN NOT NULL  COMMENT '节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）' ,
  FLOW_STATUS VARCHAR(20) NOT NULL  COMMENT '流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）' ,
  FORM_CUSTOM CHAR(1)   COMMENT '审批表单是否自定义（Y是 N否）' ,
  FORM_PATH VARCHAR(100)   COMMENT '审批表单路径' ,
  CREATE_TIME DATETIME   COMMENT '创建时间' ,
  CREATE_BY VARCHAR(64)   COMMENT '创建人' ,
  UPDATE_TIME DATETIME   COMMENT '更新时间' ,
  UPDATE_BY VARCHAR(64)   COMMENT '更新人' ,
  DEL_FLAG CHAR(1) default '0'    COMMENT '删除标志' ,
  TENANT_ID VARCHAR(40)   COMMENT '租户id' ,
  constraint PK_flow_task primary key (ID)
);

CREATE TABLE flow_user(
  ID BIGINT NOT NULL  COMMENT '主键id' ,
  TYPE CHAR(1) NOT NULL  COMMENT '人员类型（1待办任务的审批人权限 2待办任务的转办人权限 3待办任务的委托人权限）' ,
  PROCESSED_BY VARCHAR(80)   COMMENT '权限人' ,
  ASSOCIATED BIGINT NOT NULL  COMMENT '任务表id' ,
  CREATE_TIME DATETIME   COMMENT '创建时间' ,
  CREATE_BY VARCHAR(80)   COMMENT '创建人' ,
  UPDATE_TIME DATETIME   COMMENT '更新时间' ,
  UPDATE_BY VARCHAR(64)   COMMENT '创建人' ,
  DEL_FLAG CHAR(1) default '0'    COMMENT '删除标志' ,
  TENANT_ID VARCHAR(40)   COMMENT '租户id' ,
  constraint PK_flow_user primary key (ID)
);


      COMMENT ON TABLE flow_definition IS '流程定义表';
                
      COMMENT ON COLUMN flow_definition.ID IS '主键id';
                    
      COMMENT ON COLUMN flow_definition.FLOW_CODE IS '流程编码';
                    
      COMMENT ON COLUMN flow_definition.FLOW_NAME IS '流程名称';
                    
      COMMENT ON COLUMN flow_definition.MODEL_VALUE IS '设计器模型（CLASSICS经典模型 MIMIC仿钉钉模型）';
                    
      COMMENT ON COLUMN flow_definition.CATEGORY IS '流程类别';
                    
      COMMENT ON COLUMN flow_definition.VERSION IS '流程版本';
                    
      COMMENT ON COLUMN flow_definition.IS_PUBLISH IS '是否发布（0未发布 1已发布 9失效）';
                    
      COMMENT ON COLUMN flow_definition.FORM_CUSTOM IS '审批表单是否自定义（Y是 N否）';
                    
      COMMENT ON COLUMN flow_definition.FORM_PATH IS '审批表单路径';
                    
      COMMENT ON COLUMN flow_definition.ACTIVITY_STATUS IS '流程激活状态（0挂起 1激活）';
                    
      COMMENT ON COLUMN flow_definition.LISTENER_TYPE IS '监听器类型';
                    
      COMMENT ON COLUMN flow_definition.LISTENER_PATH IS '监听器路径';
                    
      COMMENT ON COLUMN flow_definition.EXT IS '业务详情 存业务表对象json字符串';
                    
      COMMENT ON COLUMN flow_definition.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN flow_definition.CREATE_BY IS '创建人';
                    
      COMMENT ON COLUMN flow_definition.UPDATE_TIME IS '更新时间';
                    
      COMMENT ON COLUMN flow_definition.UPDATE_BY IS '更新人';
                    
      COMMENT ON COLUMN flow_definition.DEL_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN flow_definition.TENANT_ID IS '租户id';
                    
      COMMENT ON TABLE flow_his_task IS '历史任务记录表';
                
      COMMENT ON COLUMN flow_his_task.ID IS '主键id';
                    
      COMMENT ON COLUMN flow_his_task.DEFINITION_ID IS '对应flow_definition表的id';
                    
      COMMENT ON COLUMN flow_his_task.INSTANCE_ID IS '对应flow_instance表的id';
                    
      COMMENT ON COLUMN flow_his_task.TASK_ID IS '对应flow_task表的id';
                    
      COMMENT ON COLUMN flow_his_task.NODE_CODE IS '开始节点编码';
                    
      COMMENT ON COLUMN flow_his_task.NODE_NAME IS '开始节点名称';
                    
      COMMENT ON COLUMN flow_his_task.NODE_TYPE IS '开始节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）';
                    
      COMMENT ON COLUMN flow_his_task.TARGET_NODE_CODE IS '目标节点编码';
                    
      COMMENT ON COLUMN flow_his_task.TARGET_NODE_NAME IS '结束节点名称';
                    
      COMMENT ON COLUMN flow_his_task.APPROVER IS '审批人';
                    
      COMMENT ON COLUMN flow_his_task.COOPERATE_TYPE IS '协作方式(1审批 2转办 3委派 4会签 5票签 6加签 7减签)';
                    
      COMMENT ON COLUMN flow_his_task.COLLABORATOR IS '协作人';
                    
      COMMENT ON COLUMN flow_his_task.SKIP_TYPE IS '流转类型（PASS通过 REJECT退回 NONE无动作）';
                    
      COMMENT ON COLUMN flow_his_task.FLOW_STATUS IS '流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）';
                    
      COMMENT ON COLUMN flow_his_task.FORM_CUSTOM IS '审批表单是否自定义（Y是 N否）';
                    
      COMMENT ON COLUMN flow_his_task.FORM_PATH IS '审批表单路径';
                    
      COMMENT ON COLUMN flow_his_task.MESSAGE IS '审批意见';
                    
      COMMENT ON COLUMN flow_his_task.VARIABLE IS '任务变量';
                    
      COMMENT ON COLUMN flow_his_task.EXT IS '业务详情 存业务表对象json字符串';
                    
      COMMENT ON COLUMN flow_his_task.CREATE_TIME IS '任务开始时间';
                    
      COMMENT ON COLUMN flow_his_task.UPDATE_TIME IS '审批完成时间';
                    
      COMMENT ON COLUMN flow_his_task.DEL_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN flow_his_task.TENANT_ID IS '租户id';
                    
      COMMENT ON TABLE flow_instance IS '流程实例表';
                
      COMMENT ON COLUMN flow_instance.ID IS '主键id';
                    
      COMMENT ON COLUMN flow_instance.DEFINITION_ID IS '对应flow_definition表的id';
                    
      COMMENT ON COLUMN flow_instance.BUSINESS_ID IS '业务id';
                    
      COMMENT ON COLUMN flow_instance.NODE_TYPE IS '节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）';
                    
      COMMENT ON COLUMN flow_instance.NODE_CODE IS '流程节点编码';
                    
      COMMENT ON COLUMN flow_instance.NODE_NAME IS '流程节点名称';
                    
      COMMENT ON COLUMN flow_instance.VARIABLE IS '任务变量';
                    
      COMMENT ON COLUMN flow_instance.FLOW_STATUS IS '流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）';
                    
      COMMENT ON COLUMN flow_instance.ACTIVITY_STATUS IS '流程激活状态（0挂起 1激活）';
                    
      COMMENT ON COLUMN flow_instance.DEF_JSON IS '流程定义json';
                    
      COMMENT ON COLUMN flow_instance.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN flow_instance.CREATE_BY IS '创建人';
                    
      COMMENT ON COLUMN flow_instance.UPDATE_TIME IS '更新时间';
                    
      COMMENT ON COLUMN flow_instance.UPDATE_BY IS '更新人';
                    
      COMMENT ON COLUMN flow_instance.EXT IS '扩展字段，预留给业务系统使用';
                    
      COMMENT ON COLUMN flow_instance.DEL_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN flow_instance.TENANT_ID IS '租户id';
                    
      COMMENT ON TABLE flow_node IS '流程节点表';
                
      COMMENT ON COLUMN flow_node.ID IS '主键id';
                    
      COMMENT ON COLUMN flow_node.NODE_TYPE IS '节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）';
                    
      COMMENT ON COLUMN flow_node.DEFINITION_ID IS '流程定义id';
                    
      COMMENT ON COLUMN flow_node.NODE_CODE IS '流程节点编码';
                    
      COMMENT ON COLUMN flow_node.NODE_NAME IS '流程节点名称';
                    
      COMMENT ON COLUMN flow_node.PERMISSION_FLAG IS '权限标识（权限类型:权限标识，可以多个，用@@隔开)';
                    
      COMMENT ON COLUMN flow_node.NODE_RATIO IS '流程签署比例值';
                    
      COMMENT ON COLUMN flow_node.COORDINATE IS '坐标';
                    
      COMMENT ON COLUMN flow_node.ANY_NODE_SKIP IS '任意结点跳转';
                    
      COMMENT ON COLUMN flow_node.LISTENER_TYPE IS '监听器类型';
                    
      COMMENT ON COLUMN flow_node.LISTENER_PATH IS '监听器路径';
                    
      COMMENT ON COLUMN flow_node.FORM_CUSTOM IS '审批表单是否自定义（Y是 N否）';
                    
      COMMENT ON COLUMN flow_node.FORM_PATH IS '审批表单路径';
                    
      COMMENT ON COLUMN flow_node.VERSION IS '版本';
                    
      COMMENT ON COLUMN flow_node.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN flow_node.CREATE_BY IS '创建人';
                    
      COMMENT ON COLUMN flow_node.UPDATE_TIME IS '更新时间';
                    
      COMMENT ON COLUMN flow_node.UPDATE_BY IS '更新人';
                    
      COMMENT ON COLUMN flow_node.EXT IS '节点扩展属性';
                    
      COMMENT ON COLUMN flow_node.DEL_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN flow_node.TENANT_ID IS '租户id';
                    
      COMMENT ON TABLE flow_skip IS '节点跳转关联表';
                
      COMMENT ON COLUMN flow_skip.ID IS '主键id';
                    
      COMMENT ON COLUMN flow_skip.DEFINITION_ID IS '流程定义id';
                    
      COMMENT ON COLUMN flow_skip.NOW_NODE_CODE IS '当前流程节点的编码';
                    
      COMMENT ON COLUMN flow_skip.NOW_NODE_TYPE IS '当前节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）';
                    
      COMMENT ON COLUMN flow_skip.NEXT_NODE_CODE IS '下一个流程节点的编码';
                    
      COMMENT ON COLUMN flow_skip.NEXT_NODE_TYPE IS '下一个节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）';
                    
      COMMENT ON COLUMN flow_skip.SKIP_NAME IS '跳转名称';
                    
      COMMENT ON COLUMN flow_skip.SKIP_TYPE IS '跳转类型（PASS审批通过 REJECT退回）';
                    
      COMMENT ON COLUMN flow_skip.SKIP_CONDITION IS '跳转条件';
                    
      COMMENT ON COLUMN flow_skip.COORDINATE IS '坐标';
                    
      COMMENT ON COLUMN flow_skip.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN flow_skip.CREATE_BY IS '创建人';
                    
      COMMENT ON COLUMN flow_skip.UPDATE_TIME IS '更新时间';
                    
      COMMENT ON COLUMN flow_skip.UPDATE_BY IS '更新人';
                    
      COMMENT ON COLUMN flow_skip.DEL_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN flow_skip.TENANT_ID IS '租户id';
                    
      COMMENT ON TABLE flow_task IS '待办任务表';
                
      COMMENT ON COLUMN flow_task.ID IS '主键id';
                    
      COMMENT ON COLUMN flow_task.DEFINITION_ID IS '对应flow_definition表的id';
                    
      COMMENT ON COLUMN flow_task.INSTANCE_ID IS '对应flow_instance表的id';
                    
      COMMENT ON COLUMN flow_task.NODE_CODE IS '节点编码';
                    
      COMMENT ON COLUMN flow_task.NODE_NAME IS '节点名称';
                    
      COMMENT ON COLUMN flow_task.NODE_TYPE IS '节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）';
                    
      COMMENT ON COLUMN flow_task.FLOW_STATUS IS '流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）';
                    
      COMMENT ON COLUMN flow_task.FORM_CUSTOM IS '审批表单是否自定义（Y是 N否）';
                    
      COMMENT ON COLUMN flow_task.FORM_PATH IS '审批表单路径';
                    
      COMMENT ON COLUMN flow_task.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN flow_task.CREATE_BY IS '创建人';
                    
      COMMENT ON COLUMN flow_task.UPDATE_TIME IS '更新时间';
                    
      COMMENT ON COLUMN flow_task.UPDATE_BY IS '更新人';
                    
      COMMENT ON COLUMN flow_task.DEL_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN flow_task.TENANT_ID IS '租户id';
                    
      COMMENT ON TABLE flow_user IS '流程用户表';
                
      COMMENT ON COLUMN flow_user.ID IS '主键id';
                    
      COMMENT ON COLUMN flow_user.TYPE IS '人员类型（1待办任务的审批人权限 2待办任务的转办人权限 3待办任务的委托人权限）';
                    
      COMMENT ON COLUMN flow_user.PROCESSED_BY IS '权限人';
                    
      COMMENT ON COLUMN flow_user.ASSOCIATED IS '任务表id';
                    
      COMMENT ON COLUMN flow_user.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN flow_user.CREATE_BY IS '创建人';
                    
      COMMENT ON COLUMN flow_user.UPDATE_TIME IS '更新时间';
                    
      COMMENT ON COLUMN flow_user.UPDATE_BY IS '创建人';
                    
      COMMENT ON COLUMN flow_user.DEL_FLAG IS '删除标志';
                    
      COMMENT ON COLUMN flow_user.TENANT_ID IS '租户id';
                    

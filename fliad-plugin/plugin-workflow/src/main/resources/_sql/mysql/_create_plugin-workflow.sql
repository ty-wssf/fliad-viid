
CREATE TABLE flow_definition(
  ID BIGINT NOT NULL    COMMENT '主键id',
  FLOW_CODE VARCHAR(40) NOT NULL    COMMENT '流程编码',
  FLOW_NAME VARCHAR(100) NOT NULL    COMMENT '流程名称',
  MODEL_VALUE VARCHAR(40) NOT NULL    COMMENT '设计器模型（CLASSICS经典模型 MIMIC仿钉钉模型）',
  CATEGORY VARCHAR(100) NULL    COMMENT '流程类别',
  VERSION VARCHAR(20) NOT NULL    COMMENT '流程版本',
  IS_PUBLISH BOOLEAN default 0  NOT NULL    COMMENT '是否发布（0未发布 1已发布 9失效）',
  FORM_CUSTOM CHAR(1) NULL    COMMENT '审批表单是否自定义（Y是 N否）',
  FORM_PATH VARCHAR(100) NULL    COMMENT '审批表单路径',
  ACTIVITY_STATUS BOOLEAN default 1  NOT NULL    COMMENT '流程激活状态（0挂起 1激活）',
  LISTENER_TYPE VARCHAR(100) NULL    COMMENT '监听器类型',
  LISTENER_PATH VARCHAR(400) NULL    COMMENT '监听器路径',
  EXT VARCHAR(500) NULL    COMMENT '业务详情 存业务表对象json字符串',
  CREATE_TIME DATETIME NULL    COMMENT '创建时间',
  CREATE_BY VARCHAR(64) NULL    COMMENT '创建人',
  UPDATE_TIME DATETIME NULL    COMMENT '更新时间',
  UPDATE_BY VARCHAR(64) NULL    COMMENT '更新人',
  DEL_FLAG CHAR(1) default '0'  NULL    COMMENT '删除标志',
  TENANT_ID VARCHAR(40) NULL    COMMENT '租户id',
  constraint PK_flow_definition primary key (ID)
);

CREATE TABLE flow_his_task(
  ID BIGINT NOT NULL    COMMENT '主键id',
  DEFINITION_ID BIGINT NOT NULL    COMMENT '对应flow_definition表的id',
  INSTANCE_ID BIGINT NOT NULL    COMMENT '对应flow_instance表的id',
  TASK_ID BIGINT NOT NULL    COMMENT '对应flow_task表的id',
  NODE_CODE VARCHAR(100) NULL    COMMENT '开始节点编码',
  NODE_NAME VARCHAR(100) NULL    COMMENT '开始节点名称',
  NODE_TYPE BOOLEAN NULL    COMMENT '开始节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）',
  TARGET_NODE_CODE VARCHAR(200) NULL    COMMENT '目标节点编码',
  TARGET_NODE_NAME VARCHAR(200) NULL    COMMENT '结束节点名称',
  APPROVER VARCHAR(40) NULL    COMMENT '审批人',
  COOPERATE_TYPE BOOLEAN default 0  NOT NULL    COMMENT '协作方式(1审批 2转办 3委派 4会签 5票签 6加签 7减签)',
  COLLABORATOR VARCHAR(500) NULL    COMMENT '协作人',
  SKIP_TYPE VARCHAR(10) NOT NULL    COMMENT '流转类型（PASS通过 REJECT退回 NONE无动作）',
  FLOW_STATUS VARCHAR(20) NOT NULL    COMMENT '流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）',
  FORM_CUSTOM CHAR(1) NULL    COMMENT '审批表单是否自定义（Y是 N否）',
  FORM_PATH VARCHAR(100) NULL    COMMENT '审批表单路径',
  MESSAGE VARCHAR(500) NULL    COMMENT '审批意见',
  VARIABLE TEXT NULL    COMMENT '任务变量',
  EXT TEXT NULL    COMMENT '业务详情 存业务表对象json字符串',
  CREATE_TIME DATETIME NULL    COMMENT '任务开始时间',
  UPDATE_TIME DATETIME NULL    COMMENT '审批完成时间',
  DEL_FLAG CHAR(1) default '0'  NULL    COMMENT '删除标志',
  TENANT_ID VARCHAR(40) NULL    COMMENT '租户id',
  constraint PK_flow_his_task primary key (ID)
);

CREATE TABLE flow_instance(
  ID BIGINT NOT NULL    COMMENT '主键id',
  DEFINITION_ID BIGINT NOT NULL    COMMENT '对应flow_definition表的id',
  BUSINESS_ID VARCHAR(40) NOT NULL    COMMENT '业务id',
  NODE_TYPE BOOLEAN NOT NULL    COMMENT '节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）',
  NODE_CODE VARCHAR(40) NOT NULL    COMMENT '流程节点编码',
  NODE_NAME VARCHAR(100) NULL    COMMENT '流程节点名称',
  VARIABLE TEXT NULL    COMMENT '任务变量',
  FLOW_STATUS VARCHAR(20) NOT NULL    COMMENT '流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）',
  ACTIVITY_STATUS BOOLEAN default 1  NOT NULL    COMMENT '流程激活状态（0挂起 1激活）',
  DEF_JSON TEXT NULL    COMMENT '流程定义json',
  CREATE_TIME DATETIME NULL    COMMENT '创建时间',
  CREATE_BY VARCHAR(64) NULL    COMMENT '创建人',
  UPDATE_TIME DATETIME NULL    COMMENT '更新时间',
  UPDATE_BY VARCHAR(64) NULL    COMMENT '更新人',
  EXT VARCHAR(500) NULL    COMMENT '扩展字段，预留给业务系统使用',
  DEL_FLAG CHAR(1) default '0'  NULL    COMMENT '删除标志',
  TENANT_ID VARCHAR(40) NULL    COMMENT '租户id',
  constraint PK_flow_instance primary key (ID)
);

CREATE TABLE flow_node(
  ID BIGINT NOT NULL    COMMENT '主键id',
  NODE_TYPE BOOLEAN NOT NULL    COMMENT '节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）',
  DEFINITION_ID BIGINT NOT NULL    COMMENT '流程定义id',
  NODE_CODE VARCHAR(100) NOT NULL    COMMENT '流程节点编码',
  NODE_NAME VARCHAR(100) NULL    COMMENT '流程节点名称',
  PERMISSION_FLAG VARCHAR(200) NULL    COMMENT '权限标识（权限类型:权限标识，可以多个，用@@隔开)',
  NODE_RATIO VARCHAR(200) NULL    COMMENT '流程签署比例值',
  COORDINATE VARCHAR(100) NULL    COMMENT '坐标',
  ANY_NODE_SKIP VARCHAR(100) NULL    COMMENT '任意结点跳转',
  LISTENER_TYPE VARCHAR(100) NULL    COMMENT '监听器类型',
  LISTENER_PATH VARCHAR(400) NULL    COMMENT '监听器路径',
  FORM_CUSTOM CHAR(1) NULL    COMMENT '审批表单是否自定义（Y是 N否）',
  FORM_PATH VARCHAR(100) NULL    COMMENT '审批表单路径',
  VERSION VARCHAR(20) NOT NULL    COMMENT '版本',
  CREATE_TIME DATETIME NULL    COMMENT '创建时间',
  CREATE_BY VARCHAR(64) NULL    COMMENT '创建人',
  UPDATE_TIME DATETIME NULL    COMMENT '更新时间',
  UPDATE_BY VARCHAR(64) NULL    COMMENT '更新人',
  EXT TEXT NULL    COMMENT '节点扩展属性',
  DEL_FLAG CHAR(1) default '0'  NULL    COMMENT '删除标志',
  TENANT_ID VARCHAR(40) NULL    COMMENT '租户id',
  constraint PK_flow_node primary key (ID)
);

CREATE TABLE flow_skip(
  ID BIGINT NOT NULL    COMMENT '主键id',
  DEFINITION_ID BIGINT NOT NULL    COMMENT '流程定义id',
  NOW_NODE_CODE VARCHAR(100) NOT NULL    COMMENT '当前流程节点的编码',
  NOW_NODE_TYPE BOOLEAN NULL    COMMENT '当前节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）',
  NEXT_NODE_CODE VARCHAR(100) NOT NULL    COMMENT '下一个流程节点的编码',
  NEXT_NODE_TYPE BOOLEAN NULL    COMMENT '下一个节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）',
  SKIP_NAME VARCHAR(100) NULL    COMMENT '跳转名称',
  SKIP_TYPE VARCHAR(40) NULL    COMMENT '跳转类型（PASS审批通过 REJECT退回）',
  SKIP_CONDITION VARCHAR(200) NULL    COMMENT '跳转条件',
  COORDINATE VARCHAR(100) NULL    COMMENT '坐标',
  CREATE_TIME DATETIME NULL    COMMENT '创建时间',
  CREATE_BY VARCHAR(64) NULL    COMMENT '创建人',
  UPDATE_TIME DATETIME NULL    COMMENT '更新时间',
  UPDATE_BY VARCHAR(64) NULL    COMMENT '更新人',
  DEL_FLAG CHAR(1) default '0'  NULL    COMMENT '删除标志',
  TENANT_ID VARCHAR(40) NULL    COMMENT '租户id',
  constraint PK_flow_skip primary key (ID)
);

CREATE TABLE flow_task(
  ID BIGINT NOT NULL    COMMENT '主键id',
  DEFINITION_ID BIGINT NOT NULL    COMMENT '对应flow_definition表的id',
  INSTANCE_ID BIGINT NOT NULL    COMMENT '对应flow_instance表的id',
  NODE_CODE VARCHAR(100) NOT NULL    COMMENT '节点编码',
  NODE_NAME VARCHAR(100) NULL    COMMENT '节点名称',
  NODE_TYPE BOOLEAN NOT NULL    COMMENT '节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）',
  FLOW_STATUS VARCHAR(20) NOT NULL    COMMENT '流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）',
  FORM_CUSTOM CHAR(1) NULL    COMMENT '审批表单是否自定义（Y是 N否）',
  FORM_PATH VARCHAR(100) NULL    COMMENT '审批表单路径',
  CREATE_TIME DATETIME NULL    COMMENT '创建时间',
  CREATE_BY VARCHAR(64) NULL    COMMENT '创建人',
  UPDATE_TIME DATETIME NULL    COMMENT '更新时间',
  UPDATE_BY VARCHAR(64) NULL    COMMENT '更新人',
  DEL_FLAG CHAR(1) default '0'  NULL    COMMENT '删除标志',
  TENANT_ID VARCHAR(40) NULL    COMMENT '租户id',
  constraint PK_flow_task primary key (ID)
);

CREATE TABLE flow_user(
  ID BIGINT NOT NULL    COMMENT '主键id',
  TYPE CHAR(1) NOT NULL    COMMENT '人员类型（1待办任务的审批人权限 2待办任务的转办人权限 3待办任务的委托人权限）',
  PROCESSED_BY VARCHAR(80) NULL    COMMENT '权限人',
  ASSOCIATED BIGINT NOT NULL    COMMENT '任务表id',
  CREATE_TIME DATETIME NULL    COMMENT '创建时间',
  CREATE_BY VARCHAR(80) NULL    COMMENT '创建人',
  UPDATE_TIME DATETIME NULL    COMMENT '更新时间',
  UPDATE_BY VARCHAR(64) NULL    COMMENT '创建人',
  DEL_FLAG CHAR(1) default '0'  NULL    COMMENT '删除标志',
  TENANT_ID VARCHAR(40) NULL    COMMENT '租户id',
  constraint PK_flow_user primary key (ID)
);


   ALTER TABLE flow_definition COMMENT '流程定义表';
                
   ALTER TABLE flow_his_task COMMENT '历史任务记录表';
                
   ALTER TABLE flow_instance COMMENT '流程实例表';
                
   ALTER TABLE flow_node COMMENT '流程节点表';
                
   ALTER TABLE flow_skip COMMENT '节点跳转关联表';
                
   ALTER TABLE flow_task COMMENT '待办任务表';
                
   ALTER TABLE flow_user COMMENT '流程用户表';
                

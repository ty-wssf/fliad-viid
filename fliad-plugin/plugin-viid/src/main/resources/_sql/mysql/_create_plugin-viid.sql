
CREATE TABLE viid_ape(
  ID VARCHAR(20) NOT NULL    COMMENT '主键',
  APEID VARCHAR(64) NOT NULL    COMMENT '设备唯一标识（DeviceIDType）',
  NAME VARCHAR(128) NOT NULL    COMMENT '设备名称',
  MODEL VARCHAR(64) NOT NULL    COMMENT '设备型号',
  IPADDR VARCHAR(64) NOT NULL    COMMENT 'IPv4地址',
  IPV6ADDR VARCHAR(128) NULL    COMMENT 'IPv6地址',
  PORT INTEGER NOT NULL    COMMENT '网络端口号',
  LONGITUDE DECIMAL(10,6) NOT NULL    COMMENT '经度（-180~180，保留6位小数）',
  LATITUDE DECIMAL(10,6) NOT NULL    COMMENT '纬度（-90~90，保留6位小数）',
  PLACECODE VARCHAR(12) NOT NULL    COMMENT '安装地点行政区划代码（GB/T 2260）',
  PLACE VARCHAR(256) NULL    COMMENT '具体位置描述（乡镇街道+街路巷+门楼牌号+详细地址）',
  ORGCODE VARCHAR(64) NULL    COMMENT '管辖单位代码',
  CAPDIRECTION BOOLEAN NULL    COMMENT '车辆抓拍方向：0=拍车头，1=拍车尾，兼容无视频卡口信息设备',
  MONITORDIRECTION VARCHAR(32) NULL    COMMENT '监视方向（如东、东北）',
  MONITORAREADESC VARCHAR(256) NULL    COMMENT '监视区域说明',
  ISONLINE BOOLEAN NOT NULL    COMMENT '设备在线状态：1=在线，0=离线',
  OWNERAPSID VARCHAR(64) NULL    COMMENT '所属采集系统设备ID',
  USERID VARCHAR(64) NULL    COMMENT '设备登录账号',
  PASSWORD VARCHAR(128) NULL    COMMENT '设备登录密码（建议加密存储）',
  FUNCTIONTYPE VARCHAR(64) NOT NULL    COMMENT '功能类型（多选，/分隔：1=车辆卡口,2=人员卡口,3=微卡口,4=特征摄像机,5=普通监控,6=高空瞭望摄像机,99=其他）',
  POSITIONTYPE VARCHAR(128) NULL    COMMENT '位置类型（多选，/分隔：1=省际检查站,2=党政机关,3=车站码头,4=中心广场,5=体育场馆,6=商业中心,7=宗教场所,8=校园周边,9=治安复杂区域,10=交通干线,11=医院周边,12=金融机构周边,13=危险物品场所周边,14=博物馆展览馆,15=重点水域、航道,96=市际公安检查站,97=涉外场所,98=边境沿线,99=旅游景区）',
  CREATE_TIME DATETIME NOT NULL    COMMENT '记录创建时间',
  UPDATE_TIME DATETIME NOT NULL    COMMENT '记录最后更新时间',
  constraint IDX_APE_ID unique (APEID),
  constraint PK_viid_ape primary key (ID)
);

CREATE TABLE viid_cascade_platform(
  ID VARCHAR(20) NOT NULL    COMMENT '主键',
  SYSTEM_ID VARCHAR(20) NOT NULL    COMMENT '平台ID',
  NAME VARCHAR(100) NULL    COMMENT '平台名称',
  IP_ADDR VARCHAR(30) NULL    COMMENT 'IP地址',
  PORT VARCHAR(6) NULL    COMMENT '端口',
  IS_REGISTER VARCHAR(1) NULL    COMMENT '是否注册',
  IS_ONLINE VARCHAR(1) NULL    COMMENT '是否在线',
  LAST_ONLINE_TIME DATETIME NULL    COMMENT '最后在线时间',
  TYPE VARCHAR(255) NULL    COMMENT '级联平台类型（0上级 1下级）',
  USER_ID VARCHAR(64) NULL    COMMENT '用户ID',
  PASSWORD VARCHAR(32) NULL    COMMENT '密码',
  HEARTBEAT_INTERVAL INTEGER NULL    COMMENT '心跳间隔',
  KEEPALIVE_TIMEOUT_COUNT INTEGER NULL    COMMENT '心跳间隔',
  constraint PK_viid_cascade_platform primary key (ID)
);

CREATE TABLE viid_subscribe(
  SUBSCRIBEID VARCHAR(40) NOT NULL    COMMENT '订阅标识符',
  TITLE VARCHAR(255) NULL    COMMENT '订阅标题',
  SUBSCRIBEDETAIL VARCHAR(255) NULL    COMMENT '订阅类别',
  RESOURCEURI VARCHAR(255) NULL    COMMENT '订阅资源路径',
  APPLICANTNAME VARCHAR(50) NULL    COMMENT '申请人',
  APPLICANTORG VARCHAR(50) NULL    COMMENT '申请单位',
  BEGINTIME VARCHAR(15) NULL    COMMENT '开始时间',
  ENDTIME VARCHAR(15) NULL    COMMENT '结束时间',
  RECEIVEADDR VARCHAR(255) NULL    COMMENT '信息接收地址',
  REPORTINTERVAL INTEGER NULL    COMMENT '信息上报间隔时间',
  REASON VARCHAR(255) NULL    COMMENT '理由',
  OPERATETYPE VARCHAR(5) NULL    COMMENT '操作类型',
  SUBSCRIBESTATUS VARCHAR(5) NULL    COMMENT '订阅执行状态',
  SUBSCRIBECANCELORG VARCHAR(50) NULL    COMMENT '订阅取消单位',
  SUBSCRIBECANCELPERSON VARCHAR(32) NULL    COMMENT '订阅取消人',
  CANCELTIME DATETIME NULL    COMMENT '取消时间',
  CANCELREASON VARCHAR(64) NULL    COMMENT '取消原因',
  SUBSCRIBETYPE VARCHAR(1) NULL    COMMENT '0 订阅上级 1被订阅',
  SUBSCRIBERSENDORGID VARCHAR(255) NULL    COMMENT '订阅发起方ID',
  SUBSCRIBERRECOVERORGID VARCHAR(255) NULL    COMMENT '被订阅方ID',
  constraint PK_viid_subscribe primary key (SUBSCRIBEID)
);

CREATE TABLE viid_subscribe_notifications(
  ID VARCHAR(20) NOT NULL    COMMENT '主键',
  NOTIFICATIONID VARCHAR(64) NOT NULL    COMMENT '通知标识',
  SUBSCRIBEID VARCHAR(64) NOT NULL    COMMENT '订阅标识',
  TITLE VARCHAR(256) NULL    COMMENT '订阅标题',
  TRIGGERTIME DATETIME NULL    COMMENT '触发时间',
  INFOIDS VARCHAR(512) NULL    COMMENT '信息标识',
  REQUESTDATA LONGTEXT NULL    COMMENT '请求字段数据（根据InfoIDs存储DeviceStatusList或者VehiclesFlowListObject等真实字段的数据）',
  RESPONSEDATA LONGTEXT NULL    COMMENT '响应字段数据（存储处理当前数据接口处理结果）',
  REQUESTCOST INTEGER NULL    COMMENT '请求耗时（毫秒）',
  CREATETIME DATETIME NOT NULL    COMMENT '创建时间',
  UPDATETIME DATETIME NOT NULL    COMMENT '更新时间',
  constraint PK_viid_subscribe_notifications primary key (ID)
);

CREATE TABLE viid_tollgate(
  ID VARCHAR(20) NOT NULL    COMMENT '主键',
  TOLLGATEID VARCHAR(64) NOT NULL    COMMENT '卡口ID，全局唯一标识，对应DeviceIDType类型，必选字段',
  NAME VARCHAR(128) NOT NULL    COMMENT '卡口名称，对应DeviceNameType类型，必选字段',
  LONGITUDE DECIMAL(10,6) NOT NULL    COMMENT '卡口经度，对应LongitudeType类型，必选字段',
  LATITUDE DECIMAL(10,6) NOT NULL    COMMENT '卡口纬度，对应LatitudeType类型，必选字段',
  PLACECODE VARCHAR(20) NOT NULL    COMMENT '安装地点行政区划代码，对应PlaceCodeType类型，必选字段',
  PLACE VARCHAR(256) NULL    COMMENT '位置名，具体到位置或街道门牌号，由(乡镇街道)+(街路巷)+(门牌号)+(门楼详细地址)构成，可选字段',
  STATUS TINYINT NOT NULL    COMMENT '卡口状态，1-正常，2-停用，9-其他，对应StatusType类型，必选字段',
  TOLLGATECAT VARCHAR(32) NOT NULL    COMMENT '卡口类型，对应TollgateType类型，必选字段',
  TOLLGATEUSAGE TINYINT NOT NULL    COMMENT '卡口用途，80-治安卡口，81-交通卡口，82-其他，必选字段',
  LANENUM INTEGER NULL    COMMENT '卡口车道数，整数类型，可选字段',
  ORGCODE VARCHAR(32) NULL    COMMENT '管辖单位代码，对应OrgCodeType类型，可选字段',
  ACTIVETIME DATETIME NULL    COMMENT '卡口启用时间，启用时间之后的数据有效，可选字段',
  constraint IDX_TOLLGATE_ID unique (TOLLGATEID),
  constraint PK_viid_tollgate primary key (ID)
);


   ALTER TABLE viid_ape COMMENT '采集设备表';
                
   ALTER TABLE viid_cascade_platform COMMENT '级联信息表';
                
   ALTER TABLE viid_subscribe COMMENT '订阅信息表';
                
   ALTER TABLE viid_subscribe_notifications COMMENT '订阅通知表';
                
   ALTER TABLE viid_tollgate COMMENT '视频卡口对象表';
                

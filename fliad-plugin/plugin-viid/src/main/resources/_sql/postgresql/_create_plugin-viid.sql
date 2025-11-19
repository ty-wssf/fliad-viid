
CREATE TABLE viid_ape(
  ID VARCHAR(20) NOT NULL ,
  APEID VARCHAR(64) NOT NULL ,
  NAME VARCHAR(128) NOT NULL ,
  MODEL VARCHAR(64) NOT NULL ,
  IPADDR VARCHAR(64) NOT NULL ,
  IPV6ADDR VARCHAR(128)  ,
  PORT INT4 NOT NULL ,
  LONGITUDE NUMERIC(10,6) NOT NULL ,
  LATITUDE NUMERIC(10,6) NOT NULL ,
  PLACECODE VARCHAR(12) NOT NULL ,
  PLACE VARCHAR(256)  ,
  ORGCODE VARCHAR(64)  ,
  CAPDIRECTION BOOLEAN  ,
  MONITORDIRECTION VARCHAR(32)  ,
  MONITORAREADESC VARCHAR(256)  ,
  ISONLINE BOOLEAN NOT NULL ,
  OWNERAPSID VARCHAR(64)  ,
  USERID VARCHAR(64)  ,
  PASSWORD VARCHAR(128)  ,
  FUNCTIONTYPE VARCHAR(64) NOT NULL ,
  POSITIONTYPE VARCHAR(128)  ,
  CREATE_TIME TIMESTAMP NOT NULL ,
  UPDATE_TIME TIMESTAMP NOT NULL ,
  constraint IDX_APE_ID unique (APEID),
  constraint PK_viid_ape primary key (ID)
);

CREATE TABLE viid_cascade_platform(
  ID VARCHAR(20) NOT NULL ,
  SYSTEM_ID VARCHAR(20) NOT NULL ,
  NAME VARCHAR(100)  ,
  IP_ADDR VARCHAR(30)  ,
  PORT VARCHAR(6)  ,
  IS_REGISTER VARCHAR(1)  ,
  IS_ONLINE VARCHAR(1)  ,
  LAST_ONLINE_TIME TIMESTAMP  ,
  TYPE VARCHAR(255)  ,
  USER_ID VARCHAR(64)  ,
  PASSWORD VARCHAR(32)  ,
  HEARTBEAT_INTERVAL INT4  ,
  KEEPALIVE_TIMEOUT_COUNT INT4  ,
  constraint PK_viid_cascade_platform primary key (ID)
);

CREATE TABLE viid_subscribe(
  SUBSCRIBEID VARCHAR(40) NOT NULL ,
  TITLE VARCHAR(255)  ,
  SUBSCRIBEDETAIL VARCHAR(255)  ,
  RESOURCEURI VARCHAR(255)  ,
  APPLICANTNAME VARCHAR(50)  ,
  APPLICANTORG VARCHAR(50)  ,
  BEGINTIME VARCHAR(15)  ,
  ENDTIME VARCHAR(15)  ,
  RECEIVEADDR VARCHAR(255)  ,
  REPORTINTERVAL INT4  ,
  REASON VARCHAR(255)  ,
  OPERATETYPE VARCHAR(5)  ,
  SUBSCRIBESTATUS VARCHAR(5)  ,
  SUBSCRIBECANCELORG VARCHAR(50)  ,
  SUBSCRIBECANCELPERSON VARCHAR(32)  ,
  CANCELTIME TIMESTAMP  ,
  CANCELREASON VARCHAR(64)  ,
  SUBSCRIBETYPE VARCHAR(1)  ,
  SUBSCRIBERSENDORGID VARCHAR(255)  ,
  SUBSCRIBERRECOVERORGID VARCHAR(255)  ,
  constraint PK_viid_subscribe primary key (SUBSCRIBEID)
);

CREATE TABLE viid_subscribe_notifications(
  ID VARCHAR(20) NOT NULL ,
  NOTIFICATIONID VARCHAR(64) NOT NULL ,
  SUBSCRIBEID VARCHAR(64) NOT NULL ,
  TITLE VARCHAR(256)  ,
  TRIGGERTIME TIMESTAMP  ,
  INFOIDS VARCHAR(512)  ,
  REQUESTDATA TEXT  ,
  RESPONSEDATA TEXT  ,
  REQUESTCOST INT4  ,
  CREATETIME TIMESTAMP NOT NULL ,
  UPDATETIME TIMESTAMP NOT NULL ,
  constraint PK_viid_subscribe_notifications primary key (ID)
);

CREATE TABLE viid_tollgate(
  ID VARCHAR(20) NOT NULL ,
  TOLLGATEID VARCHAR(64) NOT NULL ,
  NAME VARCHAR(128) NOT NULL ,
  LONGITUDE NUMERIC(10,6) NOT NULL ,
  LATITUDE NUMERIC(10,6) NOT NULL ,
  PLACECODE VARCHAR(20) NOT NULL ,
  PLACE VARCHAR(256)  ,
  STATUS INT4 NOT NULL ,
  TOLLGATECAT VARCHAR(32) NOT NULL ,
  TOLLGATEUSAGE INT4 NOT NULL ,
  LANENUM INT4  ,
  ORGCODE VARCHAR(32)  ,
  ACTIVETIME TIMESTAMP  ,
  constraint IDX_TOLLGATE_ID unique (TOLLGATEID),
  constraint PK_viid_tollgate primary key (ID)
);


      COMMENT ON TABLE viid_ape IS '采集设备表';
                
      COMMENT ON COLUMN viid_ape.ID IS '主键';
                    
      COMMENT ON COLUMN viid_ape.APEID IS '设备唯一标识（DeviceIDType）';
                    
      COMMENT ON COLUMN viid_ape.NAME IS '设备名称';
                    
      COMMENT ON COLUMN viid_ape.MODEL IS '设备型号';
                    
      COMMENT ON COLUMN viid_ape.IPADDR IS 'IPv4地址';
                    
      COMMENT ON COLUMN viid_ape.IPV6ADDR IS 'IPv6地址';
                    
      COMMENT ON COLUMN viid_ape.PORT IS '网络端口号';
                    
      COMMENT ON COLUMN viid_ape.LONGITUDE IS '经度（-180~180，保留6位小数）';
                    
      COMMENT ON COLUMN viid_ape.LATITUDE IS '纬度（-90~90，保留6位小数）';
                    
      COMMENT ON COLUMN viid_ape.PLACECODE IS '安装地点行政区划代码（GB/T 2260）';
                    
      COMMENT ON COLUMN viid_ape.PLACE IS '具体位置描述（乡镇街道+街路巷+门楼牌号+详细地址）';
                    
      COMMENT ON COLUMN viid_ape.ORGCODE IS '管辖单位代码';
                    
      COMMENT ON COLUMN viid_ape.CAPDIRECTION IS '车辆抓拍方向：0=拍车头，1=拍车尾，兼容无视频卡口信息设备';
                    
      COMMENT ON COLUMN viid_ape.MONITORDIRECTION IS '监视方向（如东、东北）';
                    
      COMMENT ON COLUMN viid_ape.MONITORAREADESC IS '监视区域说明';
                    
      COMMENT ON COLUMN viid_ape.ISONLINE IS '设备在线状态：1=在线，0=离线';
                    
      COMMENT ON COLUMN viid_ape.OWNERAPSID IS '所属采集系统设备ID';
                    
      COMMENT ON COLUMN viid_ape.USERID IS '设备登录账号';
                    
      COMMENT ON COLUMN viid_ape.PASSWORD IS '设备登录密码（建议加密存储）';
                    
      COMMENT ON COLUMN viid_ape.FUNCTIONTYPE IS '功能类型（多选，/分隔：1=车辆卡口,2=人员卡口,3=微卡口,4=特征摄像机,5=普通监控,6=高空瞭望摄像机,99=其他）';
                    
      COMMENT ON COLUMN viid_ape.POSITIONTYPE IS '位置类型（多选，/分隔：1=省际检查站,2=党政机关,3=车站码头,4=中心广场,5=体育场馆,6=商业中心,7=宗教场所,8=校园周边,9=治安复杂区域,10=交通干线,11=医院周边,12=金融机构周边,13=危险物品场所周边,14=博物馆展览馆,15=重点水域、航道,96=市际公安检查站,97=涉外场所,98=边境沿线,99=旅游景区）';
                    
      COMMENT ON COLUMN viid_ape.CREATE_TIME IS '记录创建时间';
                    
      COMMENT ON COLUMN viid_ape.UPDATE_TIME IS '记录最后更新时间';
                    
      COMMENT ON TABLE viid_cascade_platform IS '级联信息表';
                
      COMMENT ON COLUMN viid_cascade_platform.ID IS '主键';
                    
      COMMENT ON COLUMN viid_cascade_platform.SYSTEM_ID IS '平台ID';
                    
      COMMENT ON COLUMN viid_cascade_platform.NAME IS '平台名称';
                    
      COMMENT ON COLUMN viid_cascade_platform.IP_ADDR IS 'IP地址';
                    
      COMMENT ON COLUMN viid_cascade_platform.PORT IS '端口';
                    
      COMMENT ON COLUMN viid_cascade_platform.IS_REGISTER IS '是否注册';
                    
      COMMENT ON COLUMN viid_cascade_platform.IS_ONLINE IS '是否在线';
                    
      COMMENT ON COLUMN viid_cascade_platform.LAST_ONLINE_TIME IS '最后在线时间';
                    
      COMMENT ON COLUMN viid_cascade_platform.TYPE IS '级联平台类型（0上级 1下级）';
                    
      COMMENT ON COLUMN viid_cascade_platform.USER_ID IS '用户ID';
                    
      COMMENT ON COLUMN viid_cascade_platform.PASSWORD IS '密码';
                    
      COMMENT ON COLUMN viid_cascade_platform.HEARTBEAT_INTERVAL IS '心跳间隔';
                    
      COMMENT ON COLUMN viid_cascade_platform.KEEPALIVE_TIMEOUT_COUNT IS '心跳间隔';
                    
      COMMENT ON TABLE viid_subscribe IS '订阅信息表';
                
      COMMENT ON COLUMN viid_subscribe.SUBSCRIBEID IS '订阅标识符';
                    
      COMMENT ON COLUMN viid_subscribe.TITLE IS '订阅标题';
                    
      COMMENT ON COLUMN viid_subscribe.SUBSCRIBEDETAIL IS '订阅类别';
                    
      COMMENT ON COLUMN viid_subscribe.RESOURCEURI IS '订阅资源路径';
                    
      COMMENT ON COLUMN viid_subscribe.APPLICANTNAME IS '申请人';
                    
      COMMENT ON COLUMN viid_subscribe.APPLICANTORG IS '申请单位';
                    
      COMMENT ON COLUMN viid_subscribe.BEGINTIME IS '开始时间';
                    
      COMMENT ON COLUMN viid_subscribe.ENDTIME IS '结束时间';
                    
      COMMENT ON COLUMN viid_subscribe.RECEIVEADDR IS '信息接收地址';
                    
      COMMENT ON COLUMN viid_subscribe.REPORTINTERVAL IS '信息上报间隔时间';
                    
      COMMENT ON COLUMN viid_subscribe.REASON IS '理由';
                    
      COMMENT ON COLUMN viid_subscribe.OPERATETYPE IS '操作类型';
                    
      COMMENT ON COLUMN viid_subscribe.SUBSCRIBESTATUS IS '订阅执行状态';
                    
      COMMENT ON COLUMN viid_subscribe.SUBSCRIBECANCELORG IS '订阅取消单位';
                    
      COMMENT ON COLUMN viid_subscribe.SUBSCRIBECANCELPERSON IS '订阅取消人';
                    
      COMMENT ON COLUMN viid_subscribe.CANCELTIME IS '取消时间';
                    
      COMMENT ON COLUMN viid_subscribe.CANCELREASON IS '取消原因';
                    
      COMMENT ON COLUMN viid_subscribe.SUBSCRIBETYPE IS '0 订阅上级 1被订阅';
                    
      COMMENT ON COLUMN viid_subscribe.SUBSCRIBERSENDORGID IS '订阅发起方ID';
                    
      COMMENT ON COLUMN viid_subscribe.SUBSCRIBERRECOVERORGID IS '被订阅方ID';
                    
      COMMENT ON TABLE viid_subscribe_notifications IS '订阅通知表';
                
      COMMENT ON COLUMN viid_subscribe_notifications.ID IS '主键';
                    
      COMMENT ON COLUMN viid_subscribe_notifications.NOTIFICATIONID IS '通知标识';
                    
      COMMENT ON COLUMN viid_subscribe_notifications.SUBSCRIBEID IS '订阅标识';
                    
      COMMENT ON COLUMN viid_subscribe_notifications.TITLE IS '订阅标题';
                    
      COMMENT ON COLUMN viid_subscribe_notifications.TRIGGERTIME IS '触发时间';
                    
      COMMENT ON COLUMN viid_subscribe_notifications.INFOIDS IS '信息标识';
                    
      COMMENT ON COLUMN viid_subscribe_notifications.REQUESTDATA IS '请求字段数据（根据InfoIDs存储DeviceStatusList或者VehiclesFlowListObject等真实字段的数据）';
                    
      COMMENT ON COLUMN viid_subscribe_notifications.RESPONSEDATA IS '响应字段数据（存储处理当前数据接口处理结果）';
                    
      COMMENT ON COLUMN viid_subscribe_notifications.REQUESTCOST IS '请求耗时（毫秒）';
                    
      COMMENT ON COLUMN viid_subscribe_notifications.CREATETIME IS '创建时间';
                    
      COMMENT ON COLUMN viid_subscribe_notifications.UPDATETIME IS '更新时间';
                    
      COMMENT ON TABLE viid_tollgate IS '视频卡口对象表';
                
      COMMENT ON COLUMN viid_tollgate.ID IS '主键';
                    
      COMMENT ON COLUMN viid_tollgate.TOLLGATEID IS '卡口ID，全局唯一标识，对应DeviceIDType类型，必选字段';
                    
      COMMENT ON COLUMN viid_tollgate.NAME IS '卡口名称，对应DeviceNameType类型，必选字段';
                    
      COMMENT ON COLUMN viid_tollgate.LONGITUDE IS '卡口经度，对应LongitudeType类型，必选字段';
                    
      COMMENT ON COLUMN viid_tollgate.LATITUDE IS '卡口纬度，对应LatitudeType类型，必选字段';
                    
      COMMENT ON COLUMN viid_tollgate.PLACECODE IS '安装地点行政区划代码，对应PlaceCodeType类型，必选字段';
                    
      COMMENT ON COLUMN viid_tollgate.PLACE IS '位置名，具体到位置或街道门牌号，由(乡镇街道)+(街路巷)+(门牌号)+(门楼详细地址)构成，可选字段';
                    
      COMMENT ON COLUMN viid_tollgate.STATUS IS '卡口状态，1-正常，2-停用，9-其他，对应StatusType类型，必选字段';
                    
      COMMENT ON COLUMN viid_tollgate.TOLLGATECAT IS '卡口类型，对应TollgateType类型，必选字段';
                    
      COMMENT ON COLUMN viid_tollgate.TOLLGATEUSAGE IS '卡口用途，80-治安卡口，81-交通卡口，82-其他，必选字段';
                    
      COMMENT ON COLUMN viid_tollgate.LANENUM IS '卡口车道数，整数类型，可选字段';
                    
      COMMENT ON COLUMN viid_tollgate.ORGCODE IS '管辖单位代码，对应OrgCodeType类型，可选字段';
                    
      COMMENT ON COLUMN viid_tollgate.ACTIVETIME IS '卡口启用时间，启用时间之后的数据有效，可选字段';
                    

SET NAMES utf8mb4;
SET
    FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for VIID_CASCADE_PLATFORM
-- ----------------------------
DROP TABLE IF EXISTS `VIID_CASCADE_PLATFORM`;
CREATE TABLE `VIID_CASCADE_PLATFORM`
(
    `ID`                      varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
    `SYSTEM_ID`               varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '平台ID',
    `NAME`                    varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '平台名称',
    `IP_ADDR`                 varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT 'IP地址',
    `PORT`                    varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci   DEFAULT NULL COMMENT '端口',
    `IS_REGISTER`             varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci   DEFAULT NULL COMMENT '是否注册',
    `IS_ONLINE`               varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci   DEFAULT NULL COMMENT '是否在线',
    `LAST_ONLINE_TIME`        datetime                                                      DEFAULT NULL COMMENT '最后在线时间',
    `TYPE`                    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '级联平台类型（0上级 1下级）',
    `USER_ID`                 varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '用户ID',
    `PASSWORD`                varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '密码',
    `HEARTBEAT_INTERVAL`      int(11) COMMENT '心跳间隔',
    `KEEPALIVE_TIMEOUT_COUNT` int(11) COMMENT '心跳间隔',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='级联信息表';

-- ----------------------------
-- Table structure for VIID_APE
-- ----------------------------
DROP TABLE IF EXISTS `VIID_APE`;
CREATE TABLE `VIID_APE`
(
    `ID`               varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
    `ApeID`            VARCHAR(64)                                                  NOT NULL COMMENT '设备唯一标识（DeviceIDType）',
    `Name`             VARCHAR(128)                                                 NOT NULL COMMENT '设备名称',
    `Model`            VARCHAR(64)                                                  NOT NULL COMMENT '设备型号',
    `IPAddr`           VARCHAR(64)                                                  NOT NULL COMMENT 'IPv4地址',
    `IPV6Addr`         VARCHAR(128)                                                          DEFAULT NULL COMMENT 'IPv6地址',
    `Port`             INT(5)                                                       NOT NULL COMMENT '网络端口号',
    `Longitude`        DECIMAL(10, 6)                                               NOT NULL COMMENT '经度（-180~180，保留6位小数）',
    `Latitude`         DECIMAL(10, 6)                                               NOT NULL COMMENT '纬度（-90~90，保留6位小数）',
    `PlaceCode`        VARCHAR(12)                                                  NOT NULL COMMENT '安装地点行政区划代码（GB/T 2260）',
    `Place`            VARCHAR(256)                                                          DEFAULT NULL COMMENT '具体位置描述（乡镇街道+街路巷+门楼牌号+详细地址）',
    `OrgCode`          VARCHAR(64)                                                           DEFAULT NULL COMMENT '管辖单位代码',
    `CapDirection`     TINYINT(1)                                                            DEFAULT NULL COMMENT '车辆抓拍方向：0=拍车头，1=拍车尾，兼容无视频卡口信息设备',
    `MonitorDirection` VARCHAR(32)                                                           DEFAULT NULL COMMENT '监视方向（如东、东北）',
    `MonitorAreaDesc`  VARCHAR(256)                                                          DEFAULT NULL COMMENT '监视区域说明',
    `IsOnline`         TINYINT(1)                                                   NOT NULL COMMENT '设备在线状态：1=在线，0=离线',
    `OwnerApsID`       VARCHAR(64)                                                           DEFAULT NULL COMMENT '所属采集系统设备ID',
    `UserId`           VARCHAR(64)                                                           DEFAULT NULL COMMENT '设备登录账号',
    `Password`         VARCHAR(128)                                                          DEFAULT NULL COMMENT '设备登录密码（建议加密存储）',
    `FunctionType`     VARCHAR(64)                                                  NOT NULL COMMENT '功能类型（多选，/分隔：1=车辆卡口,2=人员卡口,3=微卡口,4=特征摄像机,5=普通监控,6=高空瞭望摄像机,99=其他）',
    `PositionType`     VARCHAR(128)                                                          DEFAULT NULL COMMENT '位置类型（多选，/分隔：1=省际检查站,2=党政机关,3=车站码头,4=中心广场,5=体育场馆,6=商业中心,7=宗教场所,8=校园周边,9=治安复杂区域,10=交通干线,11=医院周边,12=金融机构周边,13=危险物品场所周边,14=博物馆展览馆,15=重点水域、航道,96=市际公安检查站,97=涉外场所,98=边境沿线,99=旅游景区）',
    `create_time`      DATETIME                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
    `update_time`      DATETIME                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最后更新时间',
    PRIMARY KEY (`ID`),
    UNIQUE KEY `idx_ape_id` (`ApeID`)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='采集设备表';

-- ----------------------------
-- Table structure for VIID_TOLLGATE
-- ----------------------------
DROP TABLE IF EXISTS `VIID_TOLLGATE`;
CREATE TABLE `VIID_TOLLGATE`
(
    `ID`            varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
    `TollgateID`    VARCHAR(64)                                                  NOT NULL COMMENT '卡口ID，全局唯一标识，对应DeviceIDType类型，必选字段',
    `Name`          VARCHAR(128)                                                 NOT NULL COMMENT '卡口名称，对应DeviceNameType类型，必选字段',
    `Longitude`     DECIMAL(10, 6)                                               NOT NULL COMMENT '卡口经度，对应LongitudeType类型，必选字段',
    `Latitude`      DECIMAL(10, 6)                                               NOT NULL COMMENT '卡口纬度，对应LatitudeType类型，必选字段',
    `PlaceCode`     VARCHAR(20)                                                  NOT NULL COMMENT '安装地点行政区划代码，对应PlaceCodeType类型，必选字段',
    `Place`         VARCHAR(256) DEFAULT NULL COMMENT '位置名，具体到位置或街道门牌号，由(乡镇街道)+(街路巷)+(门牌号)+(门楼详细地址)构成，可选字段',
    `Status`        TINYINT                                                      NOT NULL COMMENT '卡口状态，1-正常，2-停用，9-其他，对应StatusType类型，必选字段',
    `TollgateCat`   VARCHAR(32)                                                  NOT NULL COMMENT '卡口类型，对应TollgateType类型，必选字段',
    `TollgateUsage` TINYINT                                                      NOT NULL COMMENT '卡口用途，80-治安卡口，81-交通卡口，82-其他，必选字段',
    `LaneNum`       INT          DEFAULT NULL COMMENT '卡口车道数，整数类型，可选字段',
    `OrgCode`       VARCHAR(32)  DEFAULT NULL COMMENT '管辖单位代码，对应OrgCodeType类型，可选字段',
    `ActiveTime`    DATETIME     DEFAULT NULL COMMENT '卡口启用时间，启用时间之后的数据有效，可选字段',
    PRIMARY KEY (`ID`),
    UNIQUE KEY `idx_tollgate_id` (`TollgateID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='视频卡口对象表';

-- ----------------------------
-- Table structure for VIID_SUBSCRIBE_NOTIFICATIONS
-- ----------------------------
DROP TABLE IF EXISTS `VIID_SUBSCRIBE_NOTIFICATIONS`;
CREATE TABLE `VIID_SUBSCRIBE_NOTIFICATIONS`
(
    `ID`             varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
    `NotificationID` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '通知标识',
    `SubscribeID`    varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订阅标识',
    `Title`          varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT NULL COMMENT '订阅标题',
    `TriggerTime`    datetime                                                              DEFAULT NULL COMMENT '触发时间',
    `InfoIDs`        varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT NULL COMMENT '信息标识',
    `RequestData`    longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '请求字段数据（根据InfoIDs存储DeviceStatusList或者VehiclesFlowListObject等真实字段的数据）',
    `ResponseData`   longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '响应字段数据（存储处理当前数据接口处理结果）',
    `RequestCost`    int                                                                   DEFAULT NULL COMMENT '请求耗时（毫秒）',
    `CreateTime`     datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `UpdateTime`     datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订阅通知表';

-- ----------------------------
-- Table structure for viid_subscribe
-- ----------------------------
DROP TABLE IF EXISTS `VIID_SUBSCRIBE`;
CREATE TABLE `VIID_SUBSCRIBE`
(
    `SubscribeID`            varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订阅标识符',
    `Title`                  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订阅标题',
    `SubscribeDetail`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订阅类别',
    `ResourceURI`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订阅资源路径',
    `ApplicantName`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '申请人',
    `ApplicantOrg`           varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '申请单位',
    `BeginTime`              varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '开始时间',
    `EndTime`                varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '结束时间',
    `ReceiveAddr`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '信息接收地址',
    `ReportInterval`         int(5)                                                        DEFAULT NULL COMMENT '信息上报间隔时间',
    `Reason`                 varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '理由',
    `OperateType`            varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci   DEFAULT NULL COMMENT '操作类型',
    `SubscribeStatus`        varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci   DEFAULT NULL COMMENT '订阅执行状态',
    `SubscribeCancelOrg`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '订阅取消单位',
    `SubscribeCancelPerson`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '订阅取消人',
    `CancelTime`             datetime                                                      DEFAULT NULL COMMENT '取消时间',
    `CancelReason`           varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '取消原因',
    `SubscribeType`          varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci   DEFAULT NULL COMMENT '0 订阅上级 1被订阅',
    `SubscriberSendOrgID`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订阅发起方ID',
    `SubscriberRecoverOrgID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '被订阅方ID',
    PRIMARY KEY (`SubscribeID`)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='订阅信息表';

-- ----------------------------
-- Table structure for VIID_WORKFLOW
-- ----------------------------
DROP TABLE IF EXISTS `VIID_WORKFLOW`;
CREATE TABLE `VIID_WORKFLOW`
(
    `ID`               varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `TITLE`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
    `SUBSCRIBE_DETAIL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci      DEFAULT NULL COMMENT '订阅类别',
    `STATUS`           varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '状态',
    `REMARK`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
    `CONTENT`          text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         NULL DEFAULT NULL COMMENT '工作流设计的 JSON 内容',
    `CREATE_TIME`      datetime                                                      NULL DEFAULT NULL COMMENT '创建时间',
    `CREATE_USER`      varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '创建用户',
    `UPDATE_TIME`      datetime                                                      NULL DEFAULT NULL COMMENT '修改时间',
    `UPDATE_USER`      varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '修改用户',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '工作流'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for VIID_DATASOURCE
-- ----------------------------
DROP TABLE IF EXISTS `VIID_DATASOURCE`;
CREATE TABLE `VIID_DATASOURCE`
(
    `ID`          varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `TITLE`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
    `SUBSCRIBE_DETAIL`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订阅类别',
    `TYPE`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '类型',
    `REMARK`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
    `CONTENT`     text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         NULL DEFAULT NULL COMMENT '数据源配置的 JSON 内容',
    `CREATE_TIME` datetime                                                      NULL DEFAULT NULL COMMENT '创建时间',
    `CREATE_USER` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '创建用户',
    `UPDATE_TIME` datetime                                                      NULL DEFAULT NULL COMMENT '修改时间',
    `UPDATE_USER` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '修改用户',
    `STATUS`      varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '状态',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '数据源'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for VIID_HIKVISION_CAMERA
-- ----------------------------
DROP TABLE IF EXISTS `VIID_HIKVISION_CAMERA`;
CREATE TABLE `VIID_HIKVISION_CAMERA`
(
    `ID`               varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '主键',
    `NAME`             varchar(128)                                                 NOT NULL COMMENT '设备名称',
    `IP_ADDR`          varchar(64)                                                  NOT NULL COMMENT '设备IP地址',
    `PORT`             int(5)                                                       NOT NULL COMMENT '端口号',
    `USERNAME`         varchar(64)                                                  NOT NULL COMMENT '用户名',
    `PASSWORD`         varchar(128)                                                 NOT NULL COMMENT '密码',
    `ENABLE_STATUS`    tinyint(1)                                                   NOT NULL DEFAULT 1 COMMENT '启用状态：1=启用，0=禁用',
    `ONLINE_STATUS`    tinyint(1)                                                   NOT NULL DEFAULT 0 COMMENT '在线状态：1=在线，0=离线',
    `CREATE_TIME`      datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `UPDATE_TIME`      datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `idx_hikvision_camera_name` (`NAME`)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='海康布防表';

SET
    FOREIGN_KEY_CHECKS = 1;
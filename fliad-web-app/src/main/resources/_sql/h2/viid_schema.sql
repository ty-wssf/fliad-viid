-- ----------------------------
-- Table structure for VIID_CASCADE_PLATFORM
-- ----------------------------
DROP TABLE IF EXISTS VIID_CASCADE_PLATFORM;
CREATE TABLE VIID_CASCADE_PLATFORM
(
    ID                      varchar(20) NOT NULL,
    SYSTEM_ID               varchar(20) NOT NULL,
    NAME                    varchar(100) DEFAULT NULL,
    IP_ADDR                 varchar(30) DEFAULT NULL,
    PORT                    varchar(6) DEFAULT NULL,
    IS_REGISTER             varchar(1) DEFAULT NULL,
    IS_ONLINE               varchar(1) DEFAULT NULL,
    LAST_ONLINE_TIME        datetime DEFAULT NULL,
    TYPE                    varchar(255) DEFAULT NULL,
    USER_ID                 varchar(64) DEFAULT NULL,
    PASSWORD                varchar(32) DEFAULT NULL,
    HEARTBEAT_INTERVAL      int,
    KEEPALIVE_TIMEOUT_COUNT int,
    PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for VIID_APE
-- ----------------------------
DROP TABLE IF EXISTS VIID_APE;
CREATE TABLE VIID_APE
(
    ID               varchar(20) NOT NULL,
    ApeID            VARCHAR(64) NOT NULL,
    Name             VARCHAR(128) NOT NULL,
    Model            VARCHAR(64) NOT NULL,
    IPAddr           VARCHAR(64) NOT NULL,
    IPV6Addr         VARCHAR(128) DEFAULT NULL,
    Port             INT NOT NULL,
    Longitude        DECIMAL(10, 6) NOT NULL,
    Latitude         DECIMAL(10, 6) NOT NULL,
    PlaceCode        VARCHAR(12) NOT NULL,
    Place            VARCHAR(256) DEFAULT NULL,
    OrgCode          VARCHAR(64) DEFAULT NULL,
    CapDirection     TINYINT DEFAULT NULL,
    MonitorDirection VARCHAR(32) DEFAULT NULL,
    MonitorAreaDesc  VARCHAR(256) DEFAULT NULL,
    IsOnline         TINYINT NOT NULL,
    OwnerApsID       VARCHAR(64) DEFAULT NULL,
    UserId           VARCHAR(64) DEFAULT NULL,
    Password         VARCHAR(128) DEFAULT NULL,
    FunctionType     VARCHAR(64) NOT NULL,
    PositionType     VARCHAR(128) DEFAULT NULL,
    create_time      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (ID),
    UNIQUE (ApeID)
);

-- ----------------------------
-- Table structure for VIID_TOLLGATE
-- ----------------------------
DROP TABLE IF EXISTS VIID_TOLLGATE;
CREATE TABLE VIID_TOLLGATE
(
    ID            varchar(20) NOT NULL,
    TollgateID    VARCHAR(64) NOT NULL,
    Name          VARCHAR(128) NOT NULL,
    Longitude     DECIMAL(10, 6) NOT NULL,
    Latitude      DECIMAL(10, 6) NOT NULL,
    PlaceCode     VARCHAR(20) NOT NULL,
    Place         VARCHAR(256) DEFAULT NULL,
    Status        TINYINT NOT NULL,
    TollgateCat   VARCHAR(32) NOT NULL,
    TollgateUsage TINYINT NOT NULL,
    LaneNum       INT DEFAULT NULL,
    OrgCode       VARCHAR(32) DEFAULT NULL,
    ActiveTime    DATETIME DEFAULT NULL,
    PRIMARY KEY (ID),
    UNIQUE (TollgateID)
);

-- ----------------------------
-- Table structure for VIID_SUBSCRIBE_NOTIFICATIONS
-- ----------------------------
DROP TABLE IF EXISTS VIID_SUBSCRIBE_NOTIFICATIONS;
CREATE TABLE VIID_SUBSCRIBE_NOTIFICATIONS
(
    ID             varchar(20) NOT NULL,
    NotificationID varchar(64) NOT NULL,
    SubscribeID    varchar(64) NOT NULL,
    Title          varchar(256) DEFAULT NULL,
    TriggerTime    datetime DEFAULT NULL,
    InfoIDs        varchar(512) DEFAULT NULL,
    RequestData    longtext,
    ResponseData   longtext,
    RequestCost    int DEFAULT NULL,
    CreateTime     datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UpdateTime     datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for viid_subscribe
-- ----------------------------
DROP TABLE IF EXISTS VIID_SUBSCRIBE;
CREATE TABLE VIID_SUBSCRIBE
(
    SubscribeID            varchar(40) NOT NULL,
    Title                  varchar(255) DEFAULT NULL,
    SubscribeDetail        varchar(255) DEFAULT NULL,
    ResourceURI            varchar(255) DEFAULT NULL,
    ApplicantName          varchar(50) DEFAULT NULL,
    ApplicantOrg           varchar(50) DEFAULT NULL,
    BeginTime              varchar(15) DEFAULT NULL,
    EndTime                varchar(15) DEFAULT NULL,
    ReceiveAddr            varchar(255) DEFAULT NULL,
    ReportInterval         int DEFAULT NULL,
    Reason                 varchar(255) DEFAULT NULL,
    OperateType            varchar(5) DEFAULT NULL,
    SubscribeStatus        varchar(5) DEFAULT NULL,
    SubscribeCancelOrg     varchar(50) DEFAULT NULL,
    SubscribeCancelPerson  varchar(32) DEFAULT NULL,
    CancelTime             datetime DEFAULT NULL,
    CancelReason           varchar(64) DEFAULT NULL,
    SubscribeType          varchar(1) DEFAULT NULL,
    SubscriberSendOrgID    varchar(255) DEFAULT NULL,
    SubscriberRecoverOrgID varchar(255) DEFAULT NULL,
    PRIMARY KEY (SubscribeID)
);

-- ----------------------------
-- Table structure for VIID_WORKFLOW
-- ----------------------------
DROP TABLE IF EXISTS VIID_WORKFLOW;
CREATE TABLE VIID_WORKFLOW
(
    ID               varchar(20) NOT NULL,
    TITLE            varchar(255) DEFAULT NULL,
    SUBSCRIBE_DETAIL varchar(255) DEFAULT NULL,
    STATUS           varchar(10) DEFAULT NULL,
    REMARK           varchar(255) DEFAULT NULL,
    CONTENT          text,
    CREATE_TIME      datetime DEFAULT NULL,
    CREATE_USER      varchar(20) DEFAULT NULL,
    UPDATE_TIME      datetime DEFAULT NULL,
    UPDATE_USER      varchar(20) DEFAULT NULL,
    PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for VIID_DATASOURCE
-- ----------------------------
DROP TABLE IF EXISTS VIID_DATASOURCE;
CREATE TABLE VIID_DATASOURCE
(
    ID          varchar(20) NOT NULL,
    TITLE       varchar(255) DEFAULT NULL,
    SUBSCRIBE_DETAIL varchar(255) DEFAULT NULL,
    TYPE        varchar(50) DEFAULT NULL,
    REMARK      varchar(255) DEFAULT NULL,
    CONTENT     text,
    CREATE_TIME datetime DEFAULT NULL,
    CREATE_USER varchar(20) DEFAULT NULL,
    UPDATE_TIME datetime DEFAULT NULL,
    UPDATE_USER varchar(20) DEFAULT NULL,
    STATUS      varchar(10) DEFAULT NULL,
    PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for VIID_HIKVISION_CAMERA
-- ----------------------------
DROP TABLE IF EXISTS VIID_HIKVISION_CAMERA;
CREATE TABLE VIID_HIKVISION_CAMERA
(
    ID               varchar(20) NOT NULL,
    NAME             varchar(128) NOT NULL,
    IP_ADDR          varchar(64) NOT NULL,
    PORT             int NOT NULL,
    USERNAME         varchar(64) NOT NULL,
    PASSWORD         varchar(128) NOT NULL,
    ENABLE_STATUS    tinyint NOT NULL DEFAULT 1,
    ONLINE_STATUS    tinyint NOT NULL DEFAULT 0,
    CREATE_TIME      datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATE_TIME      datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (ID),
    UNIQUE (NAME)
);

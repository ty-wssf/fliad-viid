-- ----------------------------
-- Table structure for VIID_WORKFLOW
-- ----------------------------
CREATE TABLE RESOURCE_WORKFLOW
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
    IS_TEMPLATE      boolean DEFAULT FALSE,
    PRIMARY KEY (ID)
);

-- ----------------------------
-- Table structure for VIID_DATASOURCE
-- ----------------------------
CREATE TABLE RESOURCE_DATASOURCE
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
    IS_TEMPLATE boolean DEFAULT FALSE,
    PRIMARY KEY (ID)
);
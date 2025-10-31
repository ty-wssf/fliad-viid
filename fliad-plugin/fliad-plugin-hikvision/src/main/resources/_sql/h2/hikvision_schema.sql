-- ----------------------------
-- Table structure for VIID_HIKVISION_CAMERA
-- ----------------------------
CREATE TABLE HIKVISION_CAMERA
(
    ID               varchar(20) NOT NULL,
    DEVICE_ID        varchar(64) DEFAULT NULL COMMENT '设备编号',
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
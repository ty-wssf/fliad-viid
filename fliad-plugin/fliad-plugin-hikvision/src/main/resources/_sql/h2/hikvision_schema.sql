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


CREATE TABLE VEHICLE_TRAFFIC_RECORD
(
    id      varchar(20) NOT NULL,
    kkbh    VARCHAR(50)  DEFAULT NULL,
    fxlx    VARCHAR(20)  DEFAULT NULL,
    cdh     VARCHAR(10)  DEFAULT NULL,
    gcsj    TIMESTAMP     DEFAULT NULL,
    wfdm    VARCHAR(20)  DEFAULT NULL,
    hphm    VARCHAR(20)  NOT NULL,
    hpzl    VARCHAR(2)   NOT NULL,
    hpys    TINYINT      NOT NULL,
    fzhphm  VARCHAR(20)  DEFAULT '-',
    fzhpzl  VARCHAR(2)   DEFAULT NULL,
    fzhpys  TINYINT      DEFAULT NULL,
    cllx    VARCHAR(20)  DEFAULT NULL,
    cwkc    VARCHAR(5)   DEFAULT NULL,
    clpp    VARCHAR(50)  DEFAULT NULL,
    csys    VARCHAR(2)      DEFAULT NULL,
    hpkxd   TINYINT      DEFAULT NULL,
    mwhpkxd VARCHAR(200) DEFAULT NULL,
    cxkxd   TINYINT      DEFAULT NULL,
    ppkxd   TINYINT      DEFAULT NULL,
    xwtz    VARCHAR(50)  DEFAULT NULL,
    tplj    VARCHAR(255) DEFAULT NULL,
    tp1     VARCHAR(255) DEFAULT NULL,
    tp2     VARCHAR(255) DEFAULT NULL,
    tp3     VARCHAR(255) DEFAULT NULL,
    tztp    VARCHAR(255) DEFAULT NULL,
    jsrtp   VARCHAR(255) DEFAULT NULL,
    clsd    INT          DEFAULT NULL,
    tid     VARCHAR(50)  DEFAULT NULL,
    zkrs    INT          DEFAULT NULL,
    cid     VARCHAR(50)  DEFAULT NULL,
    sxjbh   VARCHAR(50)  DEFAULT NULL,
    PRIMARY KEY (id)
);
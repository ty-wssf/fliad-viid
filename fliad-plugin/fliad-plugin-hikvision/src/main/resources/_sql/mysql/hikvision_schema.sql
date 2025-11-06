-- ----------------------------
-- Table structure for VIID_HIKVISION_CAMERA
-- ----------------------------
CREATE TABLE `HIKVISION_CAMERA`
(
    `ID`               varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '主键',
    `DEVICE_ID`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '设备编号',
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

CREATE TABLE VEHICLE_TRAFFIC_RECORD
(
    id      varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
    kkbh    VARCHAR(50)  DEFAULT NULL COMMENT '卡口编号，符合GA/T 16.31与GA/T 543.10要求',
    fxlx    VARCHAR(20)  DEFAULT NULL COMMENT '方向类型',
    cdh     VARCHAR(10)  DEFAULT NULL COMMENT '车道号',
    gcsj    DATETIME     DEFAULT NULL COMMENT '过车时间，格式yyyy-mm-dd hh24:mi:ss',
    wfdm    VARCHAR(20)  DEFAULT NULL COMMENT '违法行为，符合GA/T 16.31与GA/T 543.5要求',
    hphm    VARCHAR(20)  NOT NULL COMMENT '号牌号码，符合GA/T 543.5要求，无牌等用"-"表示',
    hpzl    VARCHAR(2)   NOT NULL COMMENT '号牌种类，符合GA/T 16.7与GA/T 543.5要求：01-大型汽车,02-小型汽车,...,99-其他号牌',
    hpys    TINYINT      NOT NULL COMMENT '号牌颜色，符合GB 1.1-2009：0-白色,1-黄色,2-蓝色,3-黑色,4-绿色,5-未识别,9-其他颜色',
    fzhphm  VARCHAR(20)  DEFAULT '-' COMMENT '辅助号牌号码，无牌等用"-"表示',
    fzhpzl  VARCHAR(2)   DEFAULT NULL COMMENT '辅助号牌种类，符合GA/T 16.7与GA/T 543.5要求',
    fzhpys  TINYINT      DEFAULT NULL COMMENT '辅助号牌颜色：0-白色,1-黄色,2-蓝色,3-黑色,4-绿色,5-未识别,9-其他颜色',
    cllx    VARCHAR(20)  DEFAULT NULL COMMENT '车辆类型，符合GA/T 16.4与GA/T 543.5要求',
    cwkc    VARCHAR(5)   DEFAULT NULL COMMENT '车外廓长，单位厘米，最长5位',
    clpp    VARCHAR(50)  DEFAULT NULL COMMENT '车辆品牌，符合GA/T 543.10要求',
    csys    CHAR(1)      DEFAULT NULL COMMENT '车身颜色，符合GA/T 16.8与GA/T 543.5：A-白,B-灰,C-黄,D-粉,E-红,F-紫,G-绿,H-蓝,I-棕,J-黑',
    hpkxd   TINYINT      DEFAULT NULL COMMENT '号牌识别可信度，0~100%',
    mwhpkxd VARCHAR(200) DEFAULT NULL COMMENT '每位号牌识别可信度，格式如"苏-80,B-90,..."',
    cxkxd   TINYINT      DEFAULT NULL COMMENT '车型识别可信度，0~100%',
    ppkxd   TINYINT      DEFAULT NULL COMMENT '品牌识别可信度，0~100%',
    xwtz    VARCHAR(50)  DEFAULT NULL COMMENT '行为特征，1-不系安全带;2-拨打电话;...多个用分号分隔',
    tplj    VARCHAR(255) DEFAULT NULL COMMENT '图片路径',
    tp1     VARCHAR(255) DEFAULT NULL COMMENT '通行图片1',
    tp2     VARCHAR(255) DEFAULT NULL COMMENT '通行图片2',
    tp3     VARCHAR(255) DEFAULT NULL COMMENT '通行图片3',
    tztp    VARCHAR(255) DEFAULT NULL COMMENT '特征图片',
    jsrtp   VARCHAR(255) DEFAULT NULL COMMENT '驾驶人图片',
    clsd    INT          DEFAULT NULL COMMENT '车辆速度，单位km/h',
    tid     VARCHAR(50)  DEFAULT NULL COMMENT 'rfid标签芯片识别号',
    zkrs    INT          DEFAULT NULL COMMENT '载客人数',
    cid     VARCHAR(50)  DEFAULT NULL COMMENT 'rfid标识卡号码',
    sxjbh   VARCHAR(50)  DEFAULT NULL COMMENT '摄像机设备编号',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='车辆通行记录信息表';
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
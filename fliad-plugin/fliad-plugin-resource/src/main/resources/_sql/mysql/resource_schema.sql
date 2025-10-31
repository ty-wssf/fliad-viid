-- ----------------------------
-- Table structure for VIID_WORKFLOW
-- ----------------------------
CREATE TABLE `RESOURCE_WORKFLOW`
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
    `IS_TEMPLATE`      tinyint(1)                                                    NULL DEFAULT 0 COMMENT '是否为模板',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '工作流'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for VIID_DATASOURCE
-- ----------------------------
CREATE TABLE `RESOURCE_DATASOURCE`
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
    `IS_TEMPLATE` tinyint(1)                                                    NULL DEFAULT 0 COMMENT '是否为模板',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '数据源'
  ROW_FORMAT = DYNAMIC;
-- 大华布防启用配置，默认不启用
INSERT INTO DEV_CONFIG
VALUES ('2980000000000000012', 'dahua_defense', '0', 'BIZ_DEFINE', '大华布防启用配置 0: 不启用 1： 监听  2： 布防', 100, null,
        'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null, null);
INSERT INTO DEV_CONFIG
VALUES ('2980000000000000112', 'dahua_defense_image_path', './pic', 'BIZ_DEFINE', '大华布防图片路径', 100, null,
        'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null, null);
INSERT INTO DEV_CONFIG
VALUES ('2980000000000000212', 'dahua_defense_image_gateway', 'http://127.0.0.1:82/', 'BIZ_DEFINE', '大华布防图片访问网关', 100, null,
        'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null, null);

-- 大华布防模块
INSERT INTO SYS_RESOURCE
VALUES ('2980000000000000023', '0', '大华布防', null, null, 'MENU', '1548901111999773976', 'CATALOG',
        '/7365927918486163458', null, 'appstore-outlined', null, 'TRUE', 123, null, 'NOT_DELETE', '2025-10-29 10:00:00',
        '1543837863788879871', null, null);

-- 大华设备管理功能资源
-- 大华设备主菜单
INSERT INTO SYS_RESOURCE
VALUES ('2980000000000000031', '2980000000000000023', '大华设备', 'dahua', 'DAHUA_DEFENSE_MANAGE', 'MENU',
        '1548901111999773976', 'MENU', '/dahua', 'dahua/defense/index', 'appstore-outlined', null,
        'TRUE', 105, null, 'NOT_DELETE', '2025-09-27 10:00:00', '1543837863788879871', null, null);
-- 大华布防操作按钮
INSERT INTO SYS_RESOURCE
VALUES ('2980000000000000032', '2980000000000000031', '新增大华设备', null, 'dahuaDefenseAdd', 'BUTTON', null,
        null,
        null, null, null, null, null, 1, null, 'NOT_DELETE', '2025-09-27 10:00:00', '1543837863788879871', null, null);
INSERT INTO SYS_RESOURCE
VALUES ('2980000000000000033', '2980000000000000031', '编辑大华设备', null, 'dahuaDefenseEdit', 'BUTTON', null,
        null,
        null, null, null, null, null, 2, null, 'NOT_DELETE', '2025-09-27 10:00:00', '1543837863788879871', null, null);
INSERT INTO SYS_RESOURCE
VALUES ('2980000000000000034', '2980000000000000031', '删除大华设备', null, 'dahuaDefenseDelete', 'BUTTON', null,
        null, null, null, null, null, null, 3, null, 'NOT_DELETE', '2025-09-27 10:00:00', '1543837863788879871', null,
        null);
INSERT INTO SYS_RESOURCE
VALUES ('2980000000000000035', '2980000000000000031', '批量删除大华设备', null, 'dahuaDefenseBatchDelete',
        'BUTTON', null,
        null, null, null, null, null, null, 4, null, 'NOT_DELETE', '2025-09-27 10:00:00', '1543837863788879871', null,
        null);

-- 为业务管理员角色关联大华布防模块
INSERT INTO SYS_RELATION (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3297000000000000056', '1570687866138206209', '2980000000000000023', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"2980000000000000023","buttonInfo":[]}');

-- 为业务管理员角色关联大华设备功能资源
INSERT INTO SYS_RELATION (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3297000000000000069', '1570687866138206209', '2980000000000000031', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"2980000000000000031","buttonInfo":["2980000000000000032","2980000000000000033","2980000000000000034","2980000000000000035"]}');

-- 为业务管理员角色关联大华布防所有权限标识
INSERT INTO SYS_RELATION (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3297000000000000057', '1570687866138206209', '/dahua/defense/page', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/dahua/defense/page","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO SYS_RELATION (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3297000000000000058', '1570687866138206209', '/dahua/defense/add', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/dahua/defense/add","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO SYS_RELATION (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3297000000000000059', '1570687866138206209', '/dahua/defense/edit', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/dahua/defense/edit","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO SYS_RELATION (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3297000000000000060', '1570687866138206209', '/dahua/defense/delete', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/dahua/defense/delete","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO SYS_RELATION (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3297000000000000061', '1570687866138206209', '/dahua/defense/detail', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/dahua/defense/detail","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');
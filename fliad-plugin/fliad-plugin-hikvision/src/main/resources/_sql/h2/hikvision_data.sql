-- 海康布防启用配置，默认不启用
INSERT INTO dev_config
VALUES ('1980000000000000011', 'hikvision_defense', '0', 'BIZ_DEFINE', '海康布防启用配置', 100, null,
        'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null, null);

-- 海康布防模块
INSERT INTO sys_resource
VALUES ('1980000000000000022', '0', '海康布防', null, null, 'MENU', '1548901111999773976', 'CATALOG',
        '/7365927918486163457', null, 'appstore-outlined', null, 'TRUE', 122, null, 'NOT_DELETE', '2025-10-29 10:00:00',
        '1543837863788879871', null, null);

-- 海康设备管理功能资源
-- 海康设备主菜单
INSERT INTO sys_resource
VALUES ('1980000000000000026', '1980000000000000022', '海康设备', 'hikvision', 'HIKVISION_DEFENSE_MANAGE', 'MENU',
        '1548901111999773976', 'MENU', '/hikvision', 'hikvision/defense/index', 'appstore-outlined', null,
        'TRUE', 104, null, 'NOT_DELETE', '2025-09-27 10:00:00', '1543837863788879871', null, null);
-- 海康布防操作按钮
INSERT INTO sys_resource
VALUES ('1980000000000000027', '1980000000000000026', '新增海康设备', null, 'hikvisionDefenseAdd', 'BUTTON', null,
        null,
        null, null, null, null, null, 1, null, 'NOT_DELETE', '2025-09-27 10:00:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1980000000000000028', '1980000000000000026', '编辑海康设备', null, 'hikvisionDefenseEdit', 'BUTTON', null,
        null,
        null, null, null, null, null, 2, null, 'NOT_DELETE', '2025-09-27 10:00:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1980000000000000029', '1980000000000000026', '删除海康设备', null, 'hikvisionDefenseDelete', 'BUTTON', null,
        null, null, null, null, null, null, 3, null, 'NOT_DELETE', '2025-09-27 10:00:00', '1543837863788879871', null,
        null);
INSERT INTO sys_resource
VALUES ('1980000000000000030', '1980000000000000026', '批量删除海康设备', null, 'hikvisionDefenseBatchDelete',
        'BUTTON', null,
        null, null, null, null, null, null, 4, null, 'NOT_DELETE', '2025-09-27 10:00:00', '1543837863788879871', null,
        null);

-- 为业务管理员角色关联海康布防模块
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000050', '1570687866138206209', '1980000000000000022', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"1980000000000000022","buttonInfo":[]}');

-- 为业务管理员角色关联海康设备功能资源
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000068', '1570687866138206209', '1980000000000000026', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"1980000000000000026","buttonInfo":["1980000000000000027","1980000000000000028","1980000000000000029","1980000000000000030"]}');

-- 为业务管理员角色关联海康布防所有权限标识
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000051', '1570687866138206209', '/hikvision/defense/page', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/hikvision/defense/page","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000052', '1570687866138206209', '/hikvision/defense/add', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/hikvision/defense/add","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000053', '1570687866138206209', '/hikvision/defense/edit', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/hikvision/defense/edit","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000054', '1570687866138206209', '/hikvision/defense/delete', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/hikvision/defense/delete","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000055', '1570687866138206209', '/hikvision/defense/detail', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/hikvision/defense/detail","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

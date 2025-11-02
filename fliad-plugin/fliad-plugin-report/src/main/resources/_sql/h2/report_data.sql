SET NAMES utf8mb4;

-- 报表管理模块
INSERT INTO sys_resource
VALUES ('317770316242853889', '0', '报表管理', null, null, 'MENU', '1548901111999773976', 'CATALOG',
        '/7365927662977552385', null, 'pie-chart-outlined', null, 'TRUE', 112, null, 'NOT_DELETE', '2025-08-26 10:06:47',
        '1543837863788879871', null, null);
-- 报表演示主菜单
INSERT INTO sys_resource
VALUES ('1990000000000000001', '317770316242853889', '报表演示', 'reportdemo', 'REPORT_DEMO', 'MENU',
        '1548901111999773976', 'MENU', '/report/demo', 'report/demo/index', 'pie-chart-outlined', null,
        'TRUE', 100, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null, null);
-- 报表演示操作按钮
INSERT INTO sys_resource
VALUES ('1990000000000000002', '1990000000000000001', '新增报表', null, 'reportDemoAdd', 'BUTTON', null, null,
        null, null, null, null, null, 1, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1990000000000000003', '1990000000000000001', '编辑报表', null, 'reportDemoEdit', 'BUTTON', null, null,
        null, null, null, null, null, 2, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1990000000000000004', '1990000000000000001', '删除报表', null, 'reportDemoDelete', 'BUTTON', null,
        null, null, null, null, null, null, 3, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null,
        null);
INSERT INTO sys_resource
VALUES ('1990000000000000005', '1990000000000000001', '批量删除报表', null, 'reportDemoBatchDelete', 'BUTTON',
        null,
        null, null, null, null, null, null, 4, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null,
        null);
-- 报表模板相关按钮
INSERT INTO sys_resource
VALUES ('1990000000000000006', '1990000000000000001', '安装报表模板', null, 'reportDemoInstallTemplate', 'BUTTON',
        null, null, null, null, null, null, null, 5, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null,
        null);

-- 为业务管理员角色关联报表管理模块功能资源
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3897000000000000001', '1570687866138206209', '317770316242853889', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"317770316242853889","buttonInfo":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3897000000000000004', '1570687866138206209', '1990000000000000001', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"1990000000000000001","buttonInfo":["1990000000000000002","1990000000000000003","1990000000000000004","1990000000000000005","1990000000000000006"]}');
        
-- 为业务管理员角色关联报表管理模块权限标识
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3897000000000000011', '1570687866138206209', '/report/demo/page', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/report/demo/page","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3897000000000000012', '1570687866138206209', '/report/demo/add', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/report/demo/add","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3897000000000000013', '1570687866138206209', '/report/demo/delete', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/report/demo/delete","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3897000000000000014', '1570687866138206209', '/report/demo/copy', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/report/demo/copy","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3897000000000000025', '1570687866138206209', '/report/demo/edit', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/report/demo/edit","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

-- 添加模板相关权限
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3897000000000000031', '1570687866138206209', '/report/demo/installTemplate', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/report/demo/installTemplate","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3897000000000000032', '1570687866138206209', '/report/demo/templateList', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/report/demo/templateList","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');
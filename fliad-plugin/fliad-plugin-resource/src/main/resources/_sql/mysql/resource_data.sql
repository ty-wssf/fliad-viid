SET NAMES utf8mb4;

-- 资源管理模块
INSERT INTO sys_resource
VALUES ('317770316242853888', '0', '资源管理', null, null, 'MENU', '1548901111999773976', 'CATALOG',
        '/7365927662977552384', null, 'appstore-outlined', null, 'TRUE', 111, null, 'NOT_DELETE', '2025-08-26 10:06:47',
        '1543837863788879871', null, null);
-- 数据源功能资源
-- 数据源主菜单
INSERT INTO sys_resource
VALUES ('1980000000000000001', '317770316242853888', '数据源', 'datasource', 'DATASOURCE_MANAGE', 'MENU',
        '1548901111999773976', 'MENU', '/resource/datasource', 'resource/datasource/index', 'appstore-outlined', null,
        'TRUE', 100, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null, null);
-- 数据源操作按钮
INSERT INTO sys_resource
VALUES ('1980000000000000002', '1980000000000000001', '新增数据源', null, 'viidDatasourceAdd', 'BUTTON', null, null,
        null, null, null, null, null, 1, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1980000000000000003', '1980000000000000001', '编辑数据源', null, 'viidDatasourceEdit', 'BUTTON', null, null,
        null, null, null, null, null, 2, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1980000000000000004', '1980000000000000001', '删除数据源', null, 'viidDatasourceDelete', 'BUTTON', null,
        null, null, null, null, null, null, 3, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null,
        null);
INSERT INTO sys_resource
VALUES ('1980000000000000005', '1980000000000000001', '批量删除数据源', null, 'viidDatasourceBatchDelete', 'BUTTON',
        null,
        null, null, null, null, null, null, 4, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null,
        null);
-- 数据源模板相关按钮
INSERT INTO sys_resource
VALUES ('1980000000000000006', '1980000000000000001', '安装数据源模板', null, 'viidDatasourceInstallTemplate', 'BUTTON',
        null, null, null, null, null, null, null, 5, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null,
        null);
-- 工作流主菜单
INSERT INTO SYS_RESOURCE
VALUES ('1968883972877418496', '317770316242853888', '工作流', 'workflow', 'j4DOSt5Aun', 'MENU',
        '1548901111999773976', 'MENU', '/resource/workflow', 'resource/workflow/index', 'appstore-outlined', NULL, NULL, 102,
        NULL,
        'NOT_DELETE', NULL, NULL, NULL, NULL);
-- 工作流操作按钮
INSERT INTO SYS_RESOURCE
VALUES ('1968883972881612800', '1968883972877418496', '新增工作流', NULL, 'viidWorkflowAdd', 'BUTTON', NULL, NULL, NULL,
        NULL, NULL, NULL, NULL, 1, NULL, 'NOT_DELETE', NULL, NULL, NULL, NULL);
INSERT INTO SYS_RESOURCE
VALUES ('1968883972881612803', '1968883972877418496', '批量删除工作流', NULL, 'viidWorkflowBatchDelete', 'BUTTON', NULL,
        NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 'NOT_DELETE', NULL, NULL, NULL, NULL);
INSERT INTO SYS_RESOURCE
VALUES ('1968883972881612801', '1968883972877418496', '编辑工作流', NULL, 'viidWorkflowEdit', 'BUTTON', NULL, NULL,
        NULL, NULL, NULL, NULL, NULL, 3, NULL, 'NOT_DELETE', NULL, NULL, NULL, NULL);
INSERT INTO SYS_RESOURCE
VALUES ('1968883972881612802', '1968883972877418496', '删除工作流', NULL, 'viidWorkflowDelete', 'BUTTON', NULL, NULL,
        NULL, NULL, NULL, NULL, NULL, 4, NULL, 'NOT_DELETE', NULL, NULL, NULL, NULL);
-- 工作流模板相关按钮
INSERT INTO SYS_RESOURCE
VALUES ('1968883972881612804', '1968883972877418496', '安装工作流模板', NULL, 'viidWorkflowInstallTemplate', 'BUTTON', NULL,
        NULL, NULL, NULL, NULL, NULL, NULL, 5, NULL, 'NOT_DELETE', NULL, NULL, NULL, NULL);

-- 为业务管理员角色关联资源管理模块功能资源
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000001', '1570687866138206209', '317770316242853888', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"317770316242853888","buttonInfo":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000003', '1570687866138206209', '1968883972877418496', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"1968883972877418496","buttonInfo":["1968883972881612800","1968883972881612803","1968883972881612801","1968883972881612802","1968883972881612804"]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000004', '1570687866138206209', '1980000000000000001', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"1980000000000000001","buttonInfo":["1980000000000000002","1980000000000000003","1980000000000000004","1980000000000000005","1980000000000000006"]}');

-- 为业务管理员角色关联资源管理模块权限标识
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000011', '1570687866138206209', '/resource/workflow/page', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/resource/workflow/page","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000012', '1570687866138206209', '/resource/workflow/add', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/resource/workflow/add","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000013', '1570687866138206209', '/resource/workflow/delete', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/resource/workflow/delete","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000014', '1570687866138206209', '/resource/workflow/copy', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/resource/workflow/copy","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000025', '1570687866138206209', '/resource/datasource/page', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/resource/datasource/page","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000026', '1570687866138206209', '/resource/datasource/add', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/resource/datasource/add","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000027', '1570687866138206209', '/resource/datasource/edit', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/resource/datasource/edit","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000028', '1570687866138206209', '/resource/datasource/delete', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/resource/datasource/delete","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000029', '1570687866138206209', '/resource/datasource/detail', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/resource/datasource/detail","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000030', '1570687866138206209', '/resource/datasource/copy', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/resource/datasource/copy","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

-- 添加模板相关权限
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000031', '1570687866138206209', '/resource/datasource/installTemplate', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/resource/datasource/installTemplate","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000032', '1570687866138206209', '/resource/datasource/templateList', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/resource/datasource/templateList","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000033', '1570687866138206209', '/resource/workflow/installTemplate', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/resource/workflow/installTemplate","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000034', '1570687866138206209', '/resource/workflow/templateList', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/resource/workflow/templateList","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');
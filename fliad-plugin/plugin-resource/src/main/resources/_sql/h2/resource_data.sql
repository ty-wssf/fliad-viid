-- 资源管理模块
INSERT INTO SYS_RESOURCE
VALUES ('317770316242853888', '0', '资源管理', null, null, 'MENU', '1548901111999773976', 'CATALOG',
        '/7365927662977552384', null, 'appstore-outlined', null, 'TRUE', 111, null, 'NOT_DELETE', '2025-08-26 10:06:47',
        '1543837863788879871', null, null);
-- 数据源功能资源
-- 数据源主菜单
INSERT INTO SYS_RESOURCE
VALUES ('1980000000000000001', '317770316242853888', '数据源', 'datasource', 'DATASOURCE_MANAGE', 'MENU',
        '1548901111999773976', 'MENU', '/resource/datasource', 'resource/datasource/index', 'appstore-outlined', null,
        'TRUE', 100, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null, null);
-- 数据源操作按钮
INSERT INTO SYS_RESOURCE
VALUES ('1980000000000000002', '1980000000000000001', '新增数据源', null, 'viidDatasourceAdd', 'BUTTON', null, null,
        null, null, null, null, null, 1, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null, null);
INSERT INTO SYS_RESOURCE
VALUES ('1980000000000000003', '1980000000000000001', '编辑数据源', null, 'viidDatasourceEdit', 'BUTTON', null, null,
        null, null, null, null, null, 2, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null, null);
INSERT INTO SYS_RESOURCE
VALUES ('1980000000000000004', '1980000000000000001', '删除数据源', null, 'viidDatasourceDelete', 'BUTTON', null,
        null, null, null, null, null, null, 3, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null,
        null);
INSERT INTO SYS_RESOURCE
VALUES ('1980000000000000005', '1980000000000000001', '批量删除数据源', null, 'viidDatasourceBatchDelete', 'BUTTON',
        null,
        null, null, null, null, null, null, 4, null, 'NOT_DELETE', '2025-09-24 20:05:00', '1543837863788879871', null,
        null);
-- 数据源模板相关按钮
INSERT INTO SYS_RESOURCE
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

SET NAMES utf8mb4;

-- 视图库功能资源
-- 资源管理模块
INSERT INTO sys_resource
VALUES ('317770316242853888', '0', '资源管理', null, null, 'MENU', '1548901111999773976', 'CATALOG',
        '/7365927662977552384', null, 'appstore-outlined', null, 'TRUE', 111, null, 'NOT_DELETE', '2025-08-26 10:06:47',
        '1543837863788879871', null, null);
-- 数据源功能资源
-- 数据源主菜单
INSERT INTO sys_resource
VALUES ('1980000000000000001', '317770316242853888', '数据源', 'datasource', 'DATASOURCE_MANAGE', 'MENU',
        '1548901111999773976', 'MENU', '/viid/datasource', 'viid/datasource/index', 'appstore-outlined', null,
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
-- 视图库主菜单
INSERT INTO sys_resource
VALUES ('313516724900175872', '317770316242853888', '视图库', 'cascadeplatform', 'CoJEA1gOuN', 'MENU',
        '1548901111999773976', 'MENU', '/viid/cascadeplatform', 'viid/cascadeplatform/index', 'appstore-outlined', null,
        'TRUE', 101, null, 'NOT_DELETE', '2025-08-14 16:24:32', '1543837863788879871', '2025-08-26 10:03:16',
        '1543837863788879871');
-- 视图库操作按钮
INSERT INTO sys_resource
VALUES ('1960168590876450816', '313516724900175872', '新增视图库', NULL, 'viidCascadePlatformAdd', 'BUTTON', NULL, NULL,
        NULL, NULL, NULL, NULL, NULL, 1, NULL, 'NOT_DELETE', NULL, NULL, NULL, NULL);
INSERT INTO sys_resource
VALUES ('1960168590876450819', '313516724900175872', '批量删除视图库', NULL, 'viidCascadePlatformBatchDelete', 'BUTTON',
        NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 'NOT_DELETE', NULL, NULL, NULL, NULL);
INSERT INTO sys_resource
VALUES ('1960168590876450817', '313516724900175872', '编辑视图库', NULL, 'viidCascadePlatformEdit', 'BUTTON', NULL,
        NULL, NULL, NULL, NULL, NULL, NULL, 3, NULL, 'NOT_DELETE', NULL, NULL, NULL, NULL);
INSERT INTO sys_resource
VALUES ('1960168590876450818', '313516724900175872', '删除视图库', NULL, 'viidCascadePlatformDelete', 'BUTTON', NULL,
        NULL, NULL, NULL, NULL, NULL, NULL, 4, NULL, 'NOT_DELETE', NULL, NULL, NULL, NULL);
-- 工作流主菜单
INSERT INTO SYS_RESOURCE
VALUES ('1968883972877418496', '317770316242853888', '工作流', 'workflow', 'j4DOSt5Aun', 'MENU',
        '1548901111999773976', 'MENU', '/viid/workflow', 'viid/workflow/index', 'appstore-outlined', NULL, NULL, 102,
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

-- 订阅管理模块
INSERT INTO sys_resource
VALUES ('317770571755659264', '0', '订阅管理', null, null, 'MENU', '1548901111999773976', 'CATALOG',
        '/7365927918486163456', null, 'appstore-outlined', null, 'TRUE', 121, null, 'NOT_DELETE', '2025-08-26 10:07:48',
        '1543837863788879871', null, null);
-- 下级订阅主菜单
INSERT INTO sys_resource
VALUES ('316394739489427456', '317770571755659264', '下级订阅', 'subscribeDown', '9BX0tJv57h', 'MENU',
        '1548901111999773976', 'MENU', '/viid/subscribe/down', 'viid/subscribe/down/index', 'appstore-outlined', null,
        'TRUE', 101, null, 'NOT_DELETE', '2025-08-22 15:00:44', '1543837863788879871', '2025-08-26 10:03:26',
        '1543837863788879871');
-- 下级订阅操作按钮
INSERT INTO sys_resource
VALUES ('316394739841748992', '316394739489427456', '新增下级订阅', null, 'viidSubscribeDownAdd', 'BUTTON', null, null,
        null, null, null, null, null, 1, null, 'NOT_DELETE', '2025-08-22 15:00:44', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('316394740080824320', '316394739489427456', '编辑下级订阅', null, 'viidSubscribeDownEdit', 'BUTTON', null, null,
        null, null, null, null, null, 2, null, 'NOT_DELETE', '2025-08-22 15:00:44', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('316394740311511040', '316394739489427456', '删除下级订阅', null, 'viidSubscribeDownDelete', 'BUTTON', null,
        null, null, null, null, null, null, 3, null, 'NOT_DELETE', '2025-08-22 15:00:44', '1543837863788879871', null,
        null);
INSERT INTO sys_resource
VALUES ('316394740550586368', '316394739489427456', '批量删除', null, 'viidSubscribeBatchDownDelete', 'BUTTON', null,
        null, null, null, null, null, null, 4, null, 'NOT_DELETE', '2025-08-22 15:00:44', '1543837863788879871', null,
        null);

-- 采集设备管理功能资源
-- 采集设备主菜单
INSERT INTO sys_resource
VALUES ('1975125938436898816', '317770316242853888', '采集设备', 'ape', 'APE_MANAGE', 'MENU',
        '1548901111999773976', 'MENU', '/viid/ape', 'viid/ape/index', 'appstore-outlined', null,
        'TRUE', 102, null, 'NOT_DELETE', '2025-09-19 10:00:00', '1543837863788879871', null, null);
-- 采集设备操作按钮
INSERT INTO sys_resource
VALUES ('1975125938436898817', '1975125938436898816', '新增采集设备', null, 'viidApeAdd', 'BUTTON', null, null,
        null, null, null, null, null, 1, null, 'NOT_DELETE', '2025-09-19 10:00:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1975125938436898818', '1975125938436898816', '编辑采集设备', null, 'viidApeEdit', 'BUTTON', null, null,
        null, null, null, null, null, 2, null, 'NOT_DELETE', '2025-09-19 10:00:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1975125938436898819', '1975125938436898816', '删除采集设备', null, 'viidApeDelete', 'BUTTON', null,
        null, null, null, null, null, null, 3, null, 'NOT_DELETE', '2025-09-19 10:00:00', '1543837863788879871', null,
        null);
INSERT INTO sys_resource
VALUES ('1975125938436898820', '1975125938436898816', '批量删除采集设备', null, 'viidApeBatchDelete', 'BUTTON', null,
        null, null, null, null, null, null, 4, null, 'NOT_DELETE', '2025-09-19 10:00:00', '1543837863788879871', null,
        null);

-- 视频卡口管理功能资源
-- 视频卡口主菜单
INSERT INTO sys_resource
VALUES ('1975125938436898821', '317770316242853888', '视频卡口', 'tollgate', 'TOLLGATE_MANAGE', 'MENU',
        '1548901111999773976', 'MENU', '/viid/tollgate', 'viid/tollgate/index', 'appstore-outlined', null,
        'TRUE', 103, null, 'NOT_DELETE', '2025-09-19 10:00:00', '1543837863788879871', null, null);
-- 视频卡口操作按钮
INSERT INTO sys_resource
VALUES ('1975125938436898822', '1975125938436898821', '新增视频卡口', null, 'viidTollgateAdd', 'BUTTON', null, null,
        null, null, null, null, null, 1, null, 'NOT_DELETE', '2025-09-19 10:00:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1975125938436898823', '1975125938436898821', '编辑视频卡口', null, 'viidTollgateEdit', 'BUTTON', null, null,
        null, null, null, null, null, 2, null, 'NOT_DELETE', '2025-09-19 10:00:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1975125938436898824', '1975125938436898821', '删除视频卡口', null, 'viidTollgateDelete', 'BUTTON', null,
        null, null, null, null, null, null, 3, null, 'NOT_DELETE', '2025-09-19 10:00:00', '1543837863788879871', null,
        null);
INSERT INTO sys_resource
VALUES ('1975125938436898825', '1975125938436898821', '批量删除视频卡口', null, 'viidTollgateBatchDelete', 'BUTTON',
        null,
        null, null, null, null, null, null, 4, null, 'NOT_DELETE', '2025-09-19 10:00:00', '1543837863788879871', null,
        null);

-- 订阅通知管理功能资源
-- 订阅通知主菜单
INSERT INTO sys_resource
VALUES ('1979521093836898816', '317770571755659264', '下级通知', 'notification', 'NOTIFICATION_MANAGE', 'MENU',
        '1548901111999773976', 'MENU', '/viid/notification', 'viid/notification/index', 'appstore-outlined', null,
        'TRUE', 102, null, 'NOT_DELETE', '2025-09-22 10:00:00', '1543837863788879871', null, null);
-- 订阅通知操作按钮
INSERT INTO sys_resource
VALUES ('1979521093836898817', '1979521093836898816', '新增下级通知', null, 'viidNotificationAdd', 'BUTTON', null, null,
        null, null, null, null, null, 1, null, 'NOT_DELETE', '2025-09-22 10:00:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1979521093836898818', '1979521093836898816', '编辑下级通知', null, 'viidNotificationEdit', 'BUTTON', null,
        null,
        null, null, null, null, null, 2, null, 'NOT_DELETE', '2025-09-22 10:00:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1979521093836898819', '1979521093836898816', '删除下级通知', null, 'viidNotificationDelete', 'BUTTON', null,
        null, null, null, null, null, null, 3, null, 'NOT_DELETE', '2025-09-22 10:00:00', '1543837863788879871', null,
        null);
INSERT INTO sys_resource
VALUES ('1979521093836898820', '1979521093836898816', '批量删除下级通知', null, 'viidNotificationBatchDelete', 'BUTTON',
        null,
        null, null, null, null, null, null, 4, null, 'NOT_DELETE', '2025-09-22 10:00:00', '1543837863788879871', null,
        null);
INSERT INTO sys_resource
VALUES ('1979521093836898821', '1979521093836898816', '下级通知详情', null, 'viidNotificationDetail', 'BUTTON', null,
        null, null, null, null, null, null, 5, null, 'NOT_DELETE', '2025-09-22 10:00:00', '1543837863788879871', null,
        null);

-- 业务配置功能资源
-- 业务配置主菜单
INSERT INTO sys_resource
VALUES ('1979521093836898822', '0', '业务配置', 'bizConfig', 'BIZ_CONFIG', 'MENU',
        '1548901111999773976', 'MENU', '/viid/config', 'viid/config/index', 'setting-outlined', null,
        'TRUE', 101, null, 'NOT_DELETE', '2025-09-22 10:00:00', '1543837863788879871', null, null);

-- 业务模块配置
INSERT INTO dev_config
VALUES ('327614447551016960', 'viid_local_id', '51200200005030000001', 'BIZ_DEFINE', '当前视图库标识符', 99, null,
        'NOT_DELETE', '2025-09-22 14:03:51', '1543837863788879871', '2025-09-22 14:04:05', '1543837863788879871');

-- 海康布防启用配置，默认不启用
INSERT INTO dev_config
VALUES ('1980000000000000011', 'hikvision_defense_enabled', 'false', 'BIZ_DEFINE', '海康布防启用配置', 100, null,
        'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null, null);

-- 业务模块字典
-- 视图库是否在线字典
INSERT INTO dev_dict
VALUES ('313428651361271808', '0', '视图库是否在线', 'VIID_ONLINE', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-14 10:34:34', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('313428746781687808', '313428651361271808', '在线', '1', 'BIZ', 99, null, 'NOT_DELETE', '2025-08-14 10:34:56',
        '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('313428842223075328', '313428651361271808', '离线', '0', 'BIZ', 99, null, 'NOT_DELETE', '2025-08-14 10:35:19',
        '1543837863788879871', null, null);
-- 视图库类型字典
INSERT INTO dev_dict
VALUES ('313510871660765184', '0', '视图库类型', 'VIID_TYPE', 'BIZ', 99, null, 'NOT_DELETE', '2025-08-14 16:01:17',
        '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('313511059246817280', '313510871660765184', '上级', '0', 'BIZ', 99, null, 'NOT_DELETE', '2025-08-14 16:02:01',
        '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('313511112522866688', '313510871660765184', '下级', '1', 'BIZ', 99, null, 'NOT_DELETE', '2025-08-14 16:02:14',
        '1543837863788879871', null, null);
-- 视图库是否注册字典
INSERT INTO dev_dict
VALUES ('315291870530985984', '0', '视图库是否注册', 'VIID_REGISTER', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-19 13:58:20', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('315291969550114816', '315291870530985984', '已注册', '1', 'BIZ', 99, null, 'NOT_DELETE', '2025-08-19 13:58:43',
        '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('315292006959112192', '315291870530985984', '未注册', '0', 'BIZ', 99, null, 'NOT_DELETE', '2025-08-19 13:58:52',
        '1543837863788879871', null, null);
-- 视图库订阅类别字典
INSERT INTO dev_dict
VALUES ('317404597701394432', '0', '视图库订阅类别', 'VIID_Subscribe_Detail_Type', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:53:33', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317404701040656384', '317404597701394432', '案（事）件目录', '1', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:53:58', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317404783479701504', '317404597701394432', '单个案（事）件内容', '2', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:54:17', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317404839721123840', '317404597701394432', '采集设备目录', '3', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:54:31', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317404997540200448', '317404597701394432', '采集设备状态', '4', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:55:09', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317405043987922944', '317404597701394432', '采集系统目录', '5', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:55:20', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317405131921506304', '317404597701394432', '采集系统状态', '6', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:55:41', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317405192424341504', '317404597701394432', '视频卡口目录', '7', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:55:55', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317405325346029568', '317404597701394432', '单个卡口记录', '8', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:56:27', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317405433047367680', '317404597701394432', '车道目录', '9', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:56:52', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317405478270353408', '317404597701394432', '单个车道记录', '10', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:57:03', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317405529835126784', '317404597701394432', '人员信息', '11', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:57:15', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317405628363522048', '317404597701394432', '人脸信息', '12', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:57:39', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317405670340116480', '317404597701394432', '车辆信息', '13', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:57:49', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317405732168351744', '317404597701394432', '非机动车辆信息', '14', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:58:04', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317405771552866304', '317404597701394432', '物品信息', '15', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:58:13', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317405821066625024', '317404597701394432', '文件信息', '16', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-25 09:58:25', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('327614447551016961', '317404597701394432', '华为流量定制', '101', 'BIZ', 100, null, 'NOT_DELETE',
        '2025-09-23 10:00:00', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('327614447551016962', '317404597701394432', '大华非机动车定制', '102', 'BIZ', 101, null, 'NOT_DELETE',
        '2025-09-26 10:00:00', '1543837863788879871', null, null);
-- 视图库订阅通知数据结构字段映射字典
INSERT INTO dev_dict
VALUES ('328800000000000000', '0', '视图库订阅通知数据结构字段映射', 'VIID_Subscribe_Notification_Field_Mapping', 'BIZ',
        100, null, 'NOT_DELETE',
        '2025-09-29 10:00:00', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('328800000000000001', '328800000000000000', 'DeviceStatusList.APEStatusObject', '4', 'BIZ', 1, null,
        'NOT_DELETE',
        '2025-09-29 10:00:00', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('328800000000000002', '328800000000000000', 'FaceObjectList.FaceList', '12', 'BIZ', 2, null, 'NOT_DELETE',
        '2025-09-29 10:00:00', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('328800000000000003', '328800000000000000', 'MotorVehicleObjectList.MotorVehicleList', '13', 'BIZ', 3, null,
        'NOT_DELETE',
        '2025-09-29 10:00:00', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('328800000000000004', '328800000000000000', 'NonMotorVehicleObjectList.NonMotorVehicleList', '14', 'BIZ', 4,
        null, 'NOT_DELETE',
        '2025-09-29 10:00:00', '1543837863788879871', null, null);
-- 视图库订阅执行状态字典
INSERT INTO dev_dict
VALUES ('317834568739684352', '0', '视图库订阅执行状态', 'VIID_Subscribe_Status', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-26 14:22:06', '1543837863788879871', '2025-08-26 14:28:24', '1543837863788879871');
INSERT INTO dev_dict
VALUES ('317834616491835392', '317834568739684352', '订阅中', '0', 'BIZ', 99, null, 'NOT_DELETE', '2025-08-26 14:22:18',
        '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317834661358305280', '317834568739684352', '已取消订阅', '1', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-26 14:22:28', '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317834700147228672', '317834568739684352', '未订阅', '9', 'BIZ', 99, null, 'NOT_DELETE', '2025-08-26 14:22:38',
        '1543837863788879871', null, null);
INSERT INTO dev_dict
VALUES ('317834759811203072', '317834568739684352', '订阅到期', '2', 'BIZ', 99, null, 'NOT_DELETE',
        '2025-08-26 14:22:52', '1543837863788879871', null, null);

-- 工作流配置
-- 添加采集设备状态通用处理流程工作流配置（订阅类别4）
delete
from viid_workflow
where id = '318200689091252224';
INSERT INTO viid_workflow
VALUES ('318200689091252224', '采集设备状态通用处理流程', '["4"]', 'DISABLED', '采集设备状态发送rabbitmq流程',
        '{"nodes":[{"id":"start_0","type":"start","meta":{"position":{"x":180,"y":89.5}},"data":{"title":"Start","outputs":{"type":"object","properties":{"inputs":{"type":"string","default":"Hello Flow."}},"required":["inputs"]}}},{"id":"end_0","type":"end","meta":{"position":{"x":1560,"y":89.5}},"data":{"title":"End","inputsValues":{"output":{"type":"ref","content":["start_0","inputs"],"extra":{"index":0}}},"inputs":{"type":"object","properties":{"output":{"type":"string"}}}}},{"id":"rabbitmq_3c8kV","type":"rabbitmq","meta":{"position":{"x":640,"y":0}},"data":{"title":"Rabbitmq_1","inputsValues":{"ip":{"type":"constant","content":"127.0.0.1","schema":{"type":"string"}},"port":{"type":"constant","content":5672},"username":{"type":"constant","content":"xxx"},"password":{"type":"constant","content":"xxx","schema":{"type":"string"}},"exchange":{"type":"constant","content":"BCHT_ITS_DATA"},"routingKey":{"type":"constant","content":"APEStatusObject"},"msg":{"type":"ref","content":["start_0","inputs"]}},"inputs":{"type":"object","required":["ip","port","username","password","exchange","routingKey"],"properties":{"ip":{"type":"string"},"port":{"type":"number"},"username":{"type":"string"},"password":{"type":"string"},"exchange":{"type":"string"},"routingKey":{"type":"string"},"msg":{"type":"string"}}},"outputs":{}}},{"id":"code_JILVd","type":"code","meta":{"position":{"x":1100,"y":0}},"data":{"title":"Code_1","inputsValues":{"inputs":{"type":"ref","content":["start_0","inputs"],"extra":{"index":0}}},"script":{"language":"javascript","content":"log.info(\\"Processing device status data: {}\\", inputs);\\n// Add your custom processing logic here\\ntrue;"},"outputs":{"type":"object","properties":{},"required":[]},"inputs":{"type":"object","properties":{"inputs":{"type":"string"}}}}}],"edges":[{"sourceNodeID":"start_0","targetNodeID":"rabbitmq_3c8kV"},{"sourceNodeID":"code_JILVd","targetNodeID":"end_0"},{"sourceNodeID":"rabbitmq_3c8kV","targetNodeID":"code_JILVd"}]}',
        null, null, null, null);
-- 添加华为流量定制通用处理流程工作流配置（订阅类别101）
delete
from viid_workflow
where id = '327614447551016962';
INSERT INTO viid_workflow
VALUES ('327614447551016962', '华为流量定制通用处理流程', '["101"]', 'DISABLED', '华为流量定制处理流程',
        '{"nodes":[{"id":"start_0","type":"start","meta":{"position":{"x":180,"y":89.5}},"data":{"title":"Start","outputs":{"type":"object","properties":{"inputs":{"type":"string","default":"Hello Flow."}},"required":["inputs"]}}},{"id":"end_0","type":"end","meta":{"position":{"x":1560,"y":89.5}},"data":{"title":"End","inputsValues":{"output":{"type":"ref","content":["start_0","inputs"],"extra":{"index":0}}},"inputs":{"type":"object","properties":{"output":{"type":"string"}}}}},{"id":"rabbitmq_3c8kV","type":"rabbitmq","meta":{"position":{"x":640,"y":0}},"data":{"title":"Rabbitmq_1","inputsValues":{"ip":{"type":"constant","content":"127.0.0.1","schema":{"type":"string"}},"port":{"type":"constant","content":5672},"username":{"type":"constant","content":"xxx"},"password":{"type":"constant","content":"xxx","schema":{"type":"string"}},"exchange":{"type":"constant","content":"BCHT_ITS_DATA"},"routingKey":{"type":"constant","content":"VehiclesFlowObject"},"msg":{"type":"ref","content":["start_0","inputs"]}},"inputs":{"type":"object","required":["ip","port","username","password","exchange","routingKey"],"properties":{"ip":{"type":"string"},"port":{"type":"number"},"username":{"type":"string"},"password":{"type":"string"},"exchange":{"type":"string"},"routingKey":{"type":"string"},"msg":{"type":"string"}}},"outputs":{}}},{"id":"code_JILVd","type":"code","meta":{"position":{"x":1100,"y":0}},"data":{"title":"Code_1","inputsValues":{"inputs":{"type":"ref","content":["start_0","inputs"],"extra":{"index":0}}},"script":{"language":"javascript","content":"log.info(\\"Processing HUAWEI flow data: {}\\", inputs);\\n// Add your custom processing logic here\\ntrue;"},"outputs":{"type":"object","properties":{},"required":[]},"inputs":{"type":"object","properties":{"inputs":{"type":"string"}}}}}],"edges":[{"sourceNodeID":"start_0","targetNodeID":"rabbitmq_3c8kV"},{"sourceNodeID":"code_JILVd","targetNodeID":"end_0"},{"sourceNodeID":"rabbitmq_3c8kV","targetNodeID":"code_JILVd"}]}',
        null, null, null, null);

-- 添加人脸信息处理流程工作流配置（订阅类别12）
delete
from viid_workflow
where id = '327614447551016963';
INSERT INTO viid_workflow
VALUES ('327614447551016963', '人脸信息通用处理流程', '["12"]', 'DISABLED', '人脸信息处理流程',
        '{"nodes":[{"id":"start_0","type":"start","meta":{"position":{"x":180,"y":89.5}},"data":{"title":"Start","outputs":{"type":"object","properties":{"inputs":{"type":"string","default":"Hello Flow."}},"required":["inputs"]}}},{"id":"end_0","type":"end","meta":{"position":{"x":1560,"y":89.5}},"data":{"title":"End","inputsValues":{"output":{"type":"ref","content":["start_0","inputs"],"extra":{"index":0}}},"inputs":{"type":"object","properties":{"output":{"type":"string"}}}}},{"id":"rabbitmq_3c8kV","type":"rabbitmq","meta":{"position":{"x":640,"y":0}},"data":{"title":"Rabbitmq_1","inputsValues":{"ip":{"type":"constant","content":"127.0.0.1","schema":{"type":"string"}},"port":{"type":"constant","content":5672},"username":{"type":"constant","content":"xxx"},"password":{"type":"constant","content":"xxx","schema":{"type":"string"}},"exchange":{"type":"constant","content":"BCHT_ITS_DATA"},"routingKey":{"type":"constant","content":"FaceList"},"msg":{"type":"ref","content":["start_0","inputs"]}},"inputs":{"type":"object","required":["ip","port","username","password","exchange","routingKey"],"properties":{"ip":{"type":"string"},"port":{"type":"number"},"username":{"type":"string"},"password":{"type":"string"},"exchange":{"type":"string"},"routingKey":{"type":"string"},"msg":{"type":"string"}}},"outputs":{}}},{"id":"code_JILVd","type":"code","meta":{"position":{"x":1100,"y":0}},"data":{"title":"Code_1","inputsValues":{"inputs":{"type":"ref","content":["start_0","inputs"],"extra":{"index":0}}},"script":{"language":"javascript","content":"log.info(\\"Processing face data: {}\\", inputs);\\n// Add your custom processing logic here\\ntrue;"},"outputs":{"type":"object","properties":{},"required":[]},"inputs":{"type":"object","properties":{"inputs":{"type":"string"}}}}}],"edges":[{"sourceNodeID":"start_0","targetNodeID":"rabbitmq_3c8kV"},{"sourceNodeID":"code_JILVd","targetNodeID":"end_0"},{"sourceNodeID":"rabbitmq_3c8kV","targetNodeID":"code_JILVd"}]}',
        null, null, null, null);

-- 添加机动车信息处理流程工作流配置（订阅类别13）
delete
from viid_workflow
where id = '327614447551016964';
INSERT INTO viid_workflow
VALUES ('327614447551016964', '机动车信息通用处理流程', '["13"]', 'DISABLED', '机动车信息处理流程',
        '{"nodes":[{"id":"start_0","type":"start","meta":{"position":{"x":180,"y":89.5}},"data":{"title":"Start","outputs":{"type":"object","properties":{"inputs":{"type":"string","default":"Hello Flow."}},"required":["inputs"]}}},{"id":"end_0","type":"end","meta":{"position":{"x":1560,"y":89.5}},"data":{"title":"End","inputsValues":{"output":{"type":"ref","content":["start_0","inputs"],"extra":{"index":0}}},"inputs":{"type":"object","properties":{"output":{"type":"string"}}}}},{"id":"rabbitmq_3c8kV","type":"rabbitmq","meta":{"position":{"x":640,"y":0}},"data":{"title":"Rabbitmq_1","inputsValues":{"ip":{"type":"constant","content":"127.0.0.1","schema":{"type":"string"}},"port":{"type":"constant","content":5672},"username":{"type":"constant","content":"xxx"},"password":{"type":"constant","content":"xxx","schema":{"type":"string"}},"exchange":{"type":"constant","content":"BCHT_ITS_DATA"},"routingKey":{"type":"constant","content":"MotorVehicleList"},"msg":{"type":"ref","content":["start_0","inputs"]}},"inputs":{"type":"object","required":["ip","port","username","password","exchange","routingKey"],"properties":{"ip":{"type":"string"},"port":{"type":"number"},"username":{"type":"string"},"password":{"type":"string"},"exchange":{"type":"string"},"routingKey":{"type":"string"},"msg":{"type":"string"}}},"outputs":{}}},{"id":"code_JILVd","type":"code","meta":{"position":{"x":1100,"y":0}},"data":{"title":"Code_1","inputsValues":{"inputs":{"type":"ref","content":["start_0","inputs"],"extra":{"index":0}}},"script":{"language":"javascript","content":"log.info(\\"Processing motor vehicle data: {}\\", inputs);\\n// Add your custom processing logic here\\ntrue;"},"outputs":{"type":"object","properties":{},"required":[]},"inputs":{"type":"object","properties":{"inputs":{"type":"string"}}}}}],"edges":[{"sourceNodeID":"start_0","targetNodeID":"rabbitmq_3c8kV"},{"sourceNodeID":"code_JILVd","targetNodeID":"end_0"},{"sourceNodeID":"rabbitmq_3c8kV","targetNodeID":"code_JILVd"}]}',
        null, null, null, null);

-- 添加非机动车信息处理流程工作流配置（订阅类别14）
delete
from viid_workflow
where id = '327614447551016965';
INSERT INTO viid_workflow
VALUES ('327614447551016965', '非机动车信息通用处理流程', '["14"]', 'DISABLED', '非机动车信息处理流程',
        '{"nodes":[{"id":"start_0","type":"start","meta":{"position":{"x":180,"y":89.5}},"data":{"title":"Start","outputs":{"type":"object","properties":{"inputs":{"type":"string","default":"Hello Flow."}},"required":["inputs"]}}},{"id":"end_0","type":"end","meta":{"position":{"x":1560,"y":89.5}},"data":{"title":"End","inputsValues":{"output":{"type":"ref","content":["start_0","inputs"],"extra":{"index":0}}},"inputs":{"type":"object","properties":{"output":{"type":"string"}}}}},{"id":"rabbitmq_3c8kV","type":"rabbitmq","meta":{"position":{"x":640,"y":0}},"data":{"title":"Rabbitmq_1","inputsValues":{"ip":{"type":"constant","content":"127.0.0.1","schema":{"type":"string"}},"port":{"type":"constant","content":5672},"username":{"type":"constant","content":"xxx"},"password":{"type":"constant","content":"xxx","schema":{"type":"string"}},"exchange":{"type":"constant","content":"BCHT_ITS_DATA"},"routingKey":{"type":"constant","content":"NonMotorVehicleList"},"msg":{"type":"ref","content":["start_0","inputs"]}},"inputs":{"type":"object","required":["ip","port","username","password","exchange","routingKey"],"properties":{"ip":{"type":"string"},"port":{"type":"number"},"username":{"type":"string"},"password":{"type":"string"},"exchange":{"type":"string"},"routingKey":{"type":"string"},"msg":{"type":"string"}}},"outputs":{}}},{"id":"code_JILVd","type":"code","meta":{"position":{"x":1100,"y":0}},"data":{"title":"Code_1","inputsValues":{"inputs":{"type":"ref","content":["start_0","inputs"],"extra":{"index":0}}},"script":{"language":"javascript","content":"log.info(\\"Processing non-motor vehicle data: {}\\", inputs);\\n// Add your custom processing logic here\\ntrue;"},"outputs":{"type":"object","properties":{},"required":[]},"inputs":{"type":"object","properties":{"inputs":{"type":"string"}}}}}],"edges":[{"sourceNodeID":"start_0","targetNodeID":"rabbitmq_3c8kV"},{"sourceNodeID":"code_JILVd","targetNodeID":"end_0"},{"sourceNodeID":"rabbitmq_3c8kV","targetNodeID":"code_JILVd"}]}',
        null, null, null, null);

-- 添加机动车对象转百诚机动车对象后上传RabbitMQ流程（订阅类别13，增强版）
delete
from viid_workflow
where id = '327614447551016966';
INSERT INTO viid_workflow
VALUES ('327614447551016966', '机动车转百诚对象并上传RabbitMQ流程', '["13"]', 'DISABLED',
        '机动车转百诚对象并上传RabbitMQ流程',
        '{"nodes":[{"id":"start_0","type":"start","meta":{"position":{"x":180,"y":89.5}},"data":{"title":"Start","outputs":{"type":"object","properties":{"inputs":{"type":"string","default":"Hello Flow."}},"required":["inputs"]}}},{"id":"end_0","type":"end","meta":{"position":{"x":1560,"y":89.5}},"data":{"title":"End","inputsValues":{"output":{"type":"ref","content":["rabbitmq_3c8kV","msg"],"extra":{"index":0}}},"inputs":{"type":"object","properties":{"output":{"type":"object"}}}}},{"id":"rabbitmq_3c8kV","type":"rabbitmq","meta":{"position":{"x":1100,"y":0}},"data":{"title":"Rabbitmq_1","inputsValues":{"ip":{"type":"constant","content":"127.0.0.1","schema":{"type":"string"}},"port":{"type":"constant","content":5672},"username":{"type":"constant","content":"xxx"},"password":{"type":"constant","content":"xxx","schema":{"type":"string"}},"exchange":{"type":"constant","content":"BCHT_ITS_DATA"},"routingKey":{"type":"constant","content":"BaiChengMotorVehicle"},"msg":{"type":"ref","content":["code_1","baiChengVehicle"]}},"inputs":{"type":"object","required":["ip","port","username","password","exchange","routingKey"],"properties":{"ip":{"type":"string"},"port":{"type":"number"},"username":{"type":"string"},"password":{"type":"string"},"exchange":{"type":"string"},"routingKey":{"type":"string"},"msg":{"type":"object"}}},"outputs":{"type":"object","properties":{"msg":{"type":"object"}},"required":["msg"]}}},{"id":"code_1","type":"code","meta":{"position":{"x":640,"y":0}},"data":{"title":"ConvertToBaiCheng","inputsValues":{"inputs":{"type":"ref","content":["start_0","inputs"],"extra":{"index":0}}},"script":{"language":"javascript","content":"log.info(\\"Converting motor vehicle data to BaiCheng format: {}\\", inputs);\\n\\n// Parse the input JSON string to an object\\nvar motorVehicle = JSON.parse(inputs);\\n\\n// 车牌颜色转换逻辑\\n// 视图库车牌颜色字典:\\n// 1 黑, 2 白, 3 灰, 4 红, 5 蓝, 6 黄, 7 橙, 8 棕, 9 绿, 10 紫, 11 青, 12 粉, 13 透明, 99 其他\\n// 百诚颜色字典:\\n// 0-白色，1-黄色，2-蓝色，3-黑色，4-绿色，5-未识别，9-其他颜色\\nfunction convertPlateColor(viewLibColor) {\\n    var colorMap = {\\n        \\"1\\": \\"3\\",   // 黑 -> 黑色\\n        \\"2\\": \\"0\\",   // 白 -> 白色\\n        \\"3\\": \\"9\\",   // 灰 -> 其他颜色\\n        \\"4\\": \\"9\\",   // 红 -> 其他颜色\\n        \\"5\\": \\"2\\",   // 蓝 -> 蓝色\\n        \\"6\\": \\"1\\",   // 黄 -> 黄色\\n        \\"7\\": \\"9\\",   // 橙 -> 其他颜色\\n        \\"8\\": \\"9\\",   // 棕 -> 其他颜色\\n        \\"9\\": \\"4\\",   // 绿 -> 绿色\\n        \\"10\\": \\"9\\",  // 紫 -> 其他颜色\\n        \\"11\\": \\"9\\",  // 青 -> 其他颜色\\n        \\"12\\": \\"9\\",  // 粉 -> 其他颜色\\n        \\"13\\": \\"9\\",  // 透明 -> 其他颜色\\n        \\"99\\": \\"9\\"   // 其他 -> 其他颜色\\n    };\\n    return colorMap[viewLibColor] || \\"5\\";  // 默认返回未识别\\n}\\n\\n// 车身颜色转换逻辑\\n// 视图库车身颜色字典:\\n// 1 黑, 2 白, 3 灰, 4 红, 5 蓝, 6 黄, 7 橙, 8 棕, 9 绿, 10 紫, 11 青, 12 粉, 13 透明, 99 其他\\n// 百诚车身颜色字典:\\n// A-白,B-灰,C-黄,D-粉,E-红,F-紫,G-绿,H-蓝,I-棕,J-黑\\nfunction convertVehicleColor(viewLibColor) {\\n    var colorMap = {\\n        \\"1\\": \\"J\\",   // 黑 -> 黑\\n        \\"2\\": \\"A\\",   // 白 -> 白\\n        \\"3\\": \\"B\\",   // 灰 -> 灰\\n        \\"4\\": \\"E\\",   // 红 -> 红\\n        \\"5\\": \\"H\\",   // 蓝 -> 蓝\\n        \\"6\\": \\"C\\",   // 黄 -> 黄\\n        \\"7\\": \\"9\\",   // 橙 -> 其他\\n        \\"8\\": \\"I\\",   // 棕 -> 棕\\n        \\"9\\": \\"G\\",   // 绿 -> 绿\\n        \\"10\\": \\"F\\",  // 紫 -> 紫\\n        \\"11\\": \\"9\\",  // 青 -> 其他\\n        \\"12\\": \\"D\\",  // 粉 -> 粉\\n        \\"13\\": \\"9\\",  // 透明 -> 其他\\n        \\"99\\": \\"9\\"   // 其他 -> 其他\\n    };\\n    return colorMap[viewLibColor] || \\"9\\";  // 默认返回其他\\n}\\n\\nvar baiChengPlateColor = convertPlateColor(motorVehicle.PlateColor);\\nvar baiChengVehicleColor = convertVehicleColor(motorVehicle.VehicleColor);\\n\\n// Create BaiCheng motor vehicle object\\nvar baiChengVehicle = {\\n    gcbh: motorVehicle.MotorVehicleID,\\n    sbbh: motorVehicle.DeviceID || \\"\\",\\n    sbxh: motorVehicle.DeviceID || \\"\\",\\n    jgsjStr: motorVehicle.PassTime || motorVehicle.CaptureTime || \\"\\",\\n    hphm: motorVehicle.PlateNo || \\"\\",\\n    hpzl: motorVehicle.PlateClass || \\"\\",\\n    hpys: baiChengPlateColor,\\n    cwkc: parseFloat(motorVehicle.VehicleLength) || 0,\\n    clys: baiChengVehicleColor,\\n    cllx: motorVehicle.VehicleClass || \\"\\",\\n    sd: parseFloat(motorVehicle.Speed) || 0,\\n    cdbh: parseInt(motorVehicle.LaneNo) || 0,\\n    fx: motorVehicle.Direction || \\"\\",\\n    cid: motorVehicle.CID || \\"\\",\\n    tid: motorVehicle.TID || \\"\\",\\n    tpurl: motorVehicle.StorageUrl1 || \\"\\",\\n    tpurl1: motorVehicle.StorageUrl2 || \\"\\",\\n    tpurl2: motorVehicle.StorageUrl3 || \\"\\"\\n};\\n\\nlog.info(\\"Converted to BaiCheng format: {}\\", JSON.stringify(baiChengVehicle));\\n\\n// Return the converted object\\nvar result = {\\n    baiChengVehicle: baiChengVehicle\\n};\\nresult;"},"outputs":{"type":"object","properties":{"baiChengVehicle":{"type":"object"}},"required":["baiChengVehicle"]},"inputs":{"type":"object","properties":{"inputs":{"type":"string"}}}}}],"edges":[{"sourceNodeID":"start_0","targetNodeID":"code_1"},{"sourceNodeID":"code_1","targetNodeID":"rabbitmq_3c8kV"},{"sourceNodeID":"rabbitmq_3c8kV","targetNodeID":"end_0"}]}',
        null, null, null, null);

-- 存储数据库模版
delete
from viid_workflow
where id = '328276760230690816';
INSERT INTO viid_workflow
VALUES ('328276760230690816', '存储数据库模版', '["102"]', 'DISABLED', null,
        '{"nodes":[{"id":"start_0","type":"start","meta":{"position":{"x":180,"y":104.5}},"data":{"title":"Start","outputs":{"type":"object","properties":{"inputs":{"type":"string","default":"Hello Flow."}},"required":[]}}},{"id":"end_0","type":"end","meta":{"position":{"x":2020,"y":104.5}},"data":{"title":"End","inputsValues":{},"inputs":{"type":"object","properties":{}}}},{"id":"database_-UOd0","type":"database","meta":{"position":{"x":1100,"y":0}},"data":{"title":"数据库_1","connection":{"type":"mysql","port":3306,"host":{"type":"constant","content":"127.0.0.1","schema":{"type":"string"}},"database":{"type":"constant","content":"test","schema":{"type":"string"}},"username":{"type":"constant","content":"root","schema":{"type":"string"}},"password":{"type":"constant","content":"xxx","schema":{"type":"string"}}},"query":{"queryType":"params","table":{"type":"constant","content":"test","schema":{"type":"string"}}},"fields":{"aaa":{"type":"ref","content":["code_JVcnU","aaa"],"extra":{"index":0}},"nnn":{"type":"ref","content":["code_JVcnU","nnn"],"extra":{"index":1}}},"outputs":{"type":"object","properties":{"rowCount":{"type":"integer","description":"影响的行数"},"success":{"type":"boolean","description":"写入是否成功"},"errorMessage":{"type":"string","description":"错误信息"}}},"params":{"type":"object","properties":{"aaa":{"type":"string"},"nnn":{"type":"integer"}}}}},{"id":"code_JVcnU","type":"code","meta":{"position":{"x":640,"y":15}},"data":{"title":"字符串转化为对象","inputsValues":{"inputs":{"type":"ref","content":["start_0","inputs"],"extra":{"index":0}}},"script":{"language":"javascript","content":"var inputsJson = JSON.parse(inputs);\\n// 返回一个对象\\ninputsJson;\\n\\n"},"outputs":{"type":"object","properties":{"aaa":{"type":"string"},"nnn":{"type":"integer","extra":{"index":2}}},"required":[]},"inputs":{"type":"object","properties":{"inputs":{"type":"string"}}}}},{"id":"257855","type":"code","meta":{"position":{"x":1560,"y":15}},"data":{"title":"日志打印","inputsValues":{"success":{"type":"ref","content":["database_-UOd0","success"],"extra":{"index":0}}},"script":{"language":"javascript","content":"// var inputsJson = JSON.parse(inputs);\\n// 返回一个对象\\n// inputsJson;\\nlog.info(\\"数据存储结果：{}\\", success);\\n\\n"},"outputs":{"type":"object","properties":{"aaa":{"type":"string"}},"required":[]},"inputs":{"type":"object","properties":{"success":{"type":"boolean"}}}}}],"edges":[{"sourceNodeID":"start_0","targetNodeID":"code_JVcnU"},{"sourceNodeID":"257855","targetNodeID":"end_0"},{"sourceNodeID":"code_JVcnU","targetNodeID":"database_-UOd0"},{"sourceNodeID":"database_-UOd0","targetNodeID":"257855"}]}',
        null, null, null, null);

-- 数据源模版配置
delete
from viid_datasource
where id = '328661015419015168';
INSERT INTO viid_datasource
VALUES ('328661015419015168', '订阅RabbitMQ数据模版', '102', 'rabbitmq', '1',
        '{"host":"127.0.0.1","port":5672,"username":"xxx","password":"xxx","exchange":"BCHT_ITS_DATA","routingKey":"test","queueName":"test"}',
        null, null, null, null, 'DISABLED');

-- 为业务管理员角色关联VIID所有功能资源
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000001', '1570687866138206209', '317770316242853888', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"317770316242853888","buttonInfo":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000002', '1570687866138206209', '313516724900175872', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"313516724900175872","buttonInfo":["1960168590876450816","1960168590876450819","1960168590876450817","1960168590876450818"]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000003', '1570687866138206209', '1968883972877418496', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"1968883972877418496","buttonInfo":["1968883972881612800","1968883972881612803","1968883972881612801","1968883972881612802"]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000004', '1570687866138206209', '1980000000000000001', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"1980000000000000001","buttonInfo":["1980000000000000002","1980000000000000003","1980000000000000004","1980000000000000005"]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000005', '1570687866138206209', '317770571755659264', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"317770571755659264","buttonInfo":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000006', '1570687866138206209', '316394739489427456', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"316394739489427456","buttonInfo":["316394739841748992","316394740080824320","316394740311511040","316394740550586368"]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000007', '1570687866138206209', '1975125938436898816', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"1975125938436898816","buttonInfo":["1975125938436898817","1975125938436898818","1975125938436898819","1975125938436898820"]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000008', '1570687866138206209', '1975125938436898821', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"1975125938436898821","buttonInfo":["1975125938436898822","1975125938436898823","1975125938436898824","1975125938436898825"]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000009', '1570687866138206209', '1979521093836898816', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"1979521093836898816","buttonInfo":["1979521093836898817","1979521093836898818","1979521093836898819","1979521093836898820","1979521093836898821"]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000010', '1570687866138206209', '1979521093836898822', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"1979521093836898822","buttonInfo":[]}');

-- 为业务管理员角色关联VIID所有权限标识
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000011', '1570687866138206209', '/viid/workflow/page', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/workflow/page","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000012', '1570687866138206209', '/viid/workflow/add', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/workflow/add","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000013', '1570687866138206209', '/viid/workflow/delete', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/workflow/delete","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000014', '1570687866138206209', '/viid/workflow/copy', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/workflow/copy","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000015', '1570687866138206209', '/viid/subscribe/page', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/subscribe/page","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000016', '1570687866138206209', '/viid/subscribe/add', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/subscribe/add","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000017', '1570687866138206209', '/viid/subscribe/edit', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/subscribe/edit","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000018', '1570687866138206209', '/viid/subscribe/delete', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/subscribe/delete","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000019', '1570687866138206209', '/viid/subscribe/detail', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/subscribe/detail","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000020', '1570687866138206209', '/viid/cascadeplatform/page', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/cascadeplatform/page","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000021', '1570687866138206209', '/viid/cascadeplatform/add', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/cascadeplatform/add","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000022', '1570687866138206209', '/viid/cascadeplatform/edit', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/cascadeplatform/edit","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000023', '1570687866138206209', '/viid/cascadeplatform/delete', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/cascadeplatform/delete","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000024', '1570687866138206209', '/viid/cascadeplatform/detail', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/cascadeplatform/detail","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000025', '1570687866138206209', '/viid/datasource/page', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/datasource/page","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000026', '1570687866138206209', '/viid/datasource/add', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/datasource/add","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000027', '1570687866138206209', '/viid/datasource/edit', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/datasource/edit","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000028', '1570687866138206209', '/viid/datasource/delete', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/datasource/delete","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000029', '1570687866138206209', '/viid/datasource/detail', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/datasource/detail","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000030', '1570687866138206209', '/viid/datasource/copy', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/datasource/copy","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000031', '1570687866138206209', '/viid/ape/page', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/ape/page","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000032', '1570687866138206209', '/viid/ape/add', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/ape/add","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000033', '1570687866138206209', '/viid/ape/edit', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/ape/edit","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000034', '1570687866138206209', '/viid/ape/delete', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/ape/delete","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000035', '1570687866138206209', '/viid/ape/detail', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/ape/detail","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000036', '1570687866138206209', '/viid/tollgate/page', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/tollgate/page","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000037', '1570687866138206209', '/viid/tollgate/add', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/tollgate/add","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000038', '1570687866138206209', '/viid/tollgate/edit', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/tollgate/edit","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000039', '1570687866138206209', '/viid/tollgate/delete', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/tollgate/delete","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000040', '1570687866138206209', '/viid/tollgate/detail', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/tollgate/detail","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000041', '1570687866138206209', '/viid/notification/page', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/notification/page","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000042', '1570687866138206209', '/viid/notification/add', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/notification/add","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000043', '1570687866138206209', '/viid/notification/edit', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/notification/edit","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000044', '1570687866138206209', '/viid/notification/delete', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/notification/delete","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000045', '1570687866138206209', '/viid/notification/detail', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/notification/detail","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

-- 为业务管理员角色关联业务首页
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000046', '1570687866138206209', '1813959658013433858', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"1813959658013433858","buttonInfo":[]}');

-- 为业务管理员角色关联业务首页对应的权限标识
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000047', '1570687866138206209', '/biz/index/slideshow/list', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/biz/index/slideshow/list","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000048', '1570687866138206209', '/biz/index/notice/list', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/biz/index/notice/list","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000049', '1570687866138206209', '/biz/index/notice/detail', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/biz/index/notice/detail","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

-- 为业务管理员角色关联海康布防功能资源
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000050', '1570687866138206209', '1980000000000000006', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"1980000000000000006","buttonInfo":["1980000000000000007","1980000000000000008","1980000000000000009","1980000000000000010"]}');

-- 为业务管理员角色关联海康布防所有权限标识
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000051', '1570687866138206209', '/viid/hikvision/defense/page', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/hikvision/defense/page","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000052', '1570687866138206209', '/viid/hikvision/defense/add', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/hikvision/defense/add","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000053', '1570687866138206209', '/viid/hikvision/defense/edit', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/hikvision/defense/edit","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000054', '1570687866138206209', '/viid/hikvision/defense/delete', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/hikvision/defense/delete","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000055', '1570687866138206209', '/viid/hikvision/defense/detail', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/hikvision/defense/detail","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');


-- 海康布防管理功能资源
-- 海康布防主菜单
INSERT INTO sys_resource
VALUES ('1980000000000000006', '317770316242853888', '海康布防', 'hikvision', 'HIKVISION_DEFENSE_MANAGE', 'MENU',
        '1548901111999773976', 'MENU', '/viid/hikvision', 'viid/hikvision/index', 'appstore-outlined', null,
        'TRUE', 104, null, 'NOT_DELETE', '2025-09-27 10:00:00', '1543837863788879871', null, null);
-- 海康布防操作按钮
INSERT INTO sys_resource
VALUES ('1980000000000000007', '1980000000000000006', '新增海康布防', null, 'viidHikvisionDefenseAdd', 'BUTTON', null,
        null,
        null, null, null, null, null, 1, null, 'NOT_DELETE', '2025-09-27 10:00:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1980000000000000008', '1980000000000000006', '编辑海康布防', null, 'viidHikvisionDefenseEdit', 'BUTTON', null,
        null,
        null, null, null, null, null, 2, null, 'NOT_DELETE', '2025-09-27 10:00:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1980000000000000009', '1980000000000000006', '删除海康布防', null, 'viidHikvisionDefenseDelete', 'BUTTON', null,
        null, null, null, null, null, null, 3, null, 'NOT_DELETE', '2025-09-27 10:00:00', '1543837863788879871', null,
        null);
INSERT INTO sys_resource
VALUES ('1980000000000000010', '1980000000000000006', '批量删除海康布防', null, 'viidHikvisionDefenseBatchDelete',
        'BUTTON', null,
        null, null, null, null, null, null, 4, null, 'NOT_DELETE', '2025-09-27 10:00:00', '1543837863788879871', null,
        null);

-- 上级订阅主菜单
INSERT INTO sys_resource
VALUES ('1980000000000000011', '317770571755659264', '上级订阅', 'subscribeUp', 'SUBSCRIBE_UP_MANAGE', 'MENU',
        '1548901111999773976', 'MENU', '/viid/subscribe/up', 'viid/subscribe/up/index', 'appstore-outlined', null,
        'TRUE', 99, null, 'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null, null);
-- 上级订阅操作按钮
INSERT INTO sys_resource
VALUES ('1980000000000000012', '1980000000000000011', '新增上级订阅', null, 'viidSubscribeUpAdd', 'BUTTON', null, null,
        null, null, null, null, null, 1, null, 'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1980000000000000013', '1980000000000000011', '编辑上级订阅', null, 'viidSubscribeUpEdit', 'BUTTON', null, null,
        null, null, null, null, null, 2, null, 'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1980000000000000014', '1980000000000000011', '删除上级订阅', null, 'viidSubscribeUpDelete', 'BUTTON', null,
        null, null, null, null, null, null, 3, null, 'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null,
        null);
INSERT INTO sys_resource
VALUES ('1980000000000000015', '1980000000000000011', '批量删除上级订阅', null, 'viidSubscribeUpBatchDelete', 'BUTTON',
        null,
        null, null, null, null, null, null, 4, null, 'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null,
        null);

-- 上级通知主菜单
INSERT INTO sys_resource
VALUES ('1980000000000000016', '317770571755659264', '上级通知', 'notificationUp', 'NOTIFICATION_UP_MANAGE', 'MENU',
        '1548901111999773976', 'MENU', '/viid/notification/up', 'viid/notification/up/index', 'appstore-outlined', null,
        'TRUE', 100, null, 'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null, null);
-- 上级通知操作按钮
INSERT INTO sys_resource
VALUES ('1980000000000000017', '1980000000000000016', '新增上级通知', null, 'viidNotificationUpAdd', 'BUTTON', null, null,
        null, null, null, null, null, 1, null, 'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1980000000000000018', '1980000000000000016', '编辑上级通知', null, 'viidNotificationUpEdit', 'BUTTON', null,
        null,
        null, null, null, null, null, 2, null, 'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null, null);
INSERT INTO sys_resource
VALUES ('1980000000000000019', '1980000000000000016', '删除上级通知', null, 'viidNotificationUpDelete', 'BUTTON', null,
        null, null, null, null, null, null, 3, null, 'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null,
        null);
INSERT INTO sys_resource
VALUES ('1980000000000000020', '1980000000000000016', '批量删除上级通知', null, 'viidNotificationUpBatchDelete', 'BUTTON',
        null,
        null, null, null, null, null, null, 4, null, 'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null,
        null);
INSERT INTO sys_resource
VALUES ('1980000000000000021', '1980000000000000016', '上级通知详情', null, 'viidNotificationUpDetail', 'BUTTON', null,
        null, null, null, null, null, null, 5, null, 'NOT_DELETE', '2025-10-11 10:00:00', '1543837863788879871', null,
        null);

-- 为业务管理员角色关联上级订阅功能资源
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000056', '1570687866138206209', '1980000000000000011', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"1980000000000000011","buttonInfo":["1980000000000000012","1980000000000000013","1980000000000000014","1980000000000000015"]}');

-- 为业务管理员角色关联上级通知功能资源
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000057', '1570687866138206209', '1980000000000000016', 'SYS_ROLE_HAS_RESOURCE',
        '{"menuId":"1980000000000000016","buttonInfo":["1980000000000000017","1980000000000000018","1980000000000000019","1980000000000000020","1980000000000000021"]}');

-- 为业务管理员角色关联上级订阅所有权限标识
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000058', '1570687866138206209', '/viid/subscribe/up/page', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/subscribe/up/page","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000059', '1570687866138206209', '/viid/subscribe/up/add', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/subscribe/up/add","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000060', '1570687866138206209', '/viid/subscribe/up/edit', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/subscribe/up/edit","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000061', '1570687866138206209', '/viid/subscribe/up/delete', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/subscribe/up/delete","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000062', '1570687866138206209', '/viid/subscribe/up/detail', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/subscribe/up/detail","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

-- 为业务管理员角色关联上级通知所有权限标识
INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000063', '1570687866138206209', '/viid/notification/up/page', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/notification/up/page","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000064', '1570687866138206209', '/viid/notification/up/add', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/notification/up/add","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000065', '1570687866138206209', '/viid/notification/up/edit', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/notification/up/edit","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000066', '1570687866138206209', '/viid/notification/up/delete', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/notification/up/delete","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');

INSERT INTO sys_relation (ID, OBJECT_ID, TARGET_ID, CATEGORY, EXT_JSON)
VALUES ('3287000000000000067', '1570687866138206209', '/viid/notification/up/detail', 'SYS_ROLE_HAS_PERMISSION',
        '{"apiUrl":"/viid/notification/up/detail","scopeCategory":"SCOPE_ALL","scopeDefineOrgIdList":[]}');


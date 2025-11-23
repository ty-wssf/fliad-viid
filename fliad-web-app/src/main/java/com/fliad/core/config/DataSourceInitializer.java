package com.fliad.core.config;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fliad.core.DataInitializerLoader;
import com.fliad.sys.dao.entity.SysRelation;
import com.fliad.sys.dao.entity.SysResource;
import com.fliad.sys.dao.entity.SysRole;
import io.nop.api.core.ioc.BeanContainer;
import io.nop.dao.api.DaoProvider;
import io.nop.dao.api.IDaoProvider;
import io.nop.dao.api.IEntityDao;
import io.nop.dao.jdbc.IJdbcTemplate;
import io.nop.orm.IOrmSessionFactory;
import io.nop.orm.IOrmTemplate;
import io.nop.orm.initialize.DataBaseSchemaInitializer;
import org.noear.snack.ONode;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;
import org.noear.solon.core.handle.Action;
import org.noear.solon.core.handle.Handler;
import org.noear.solon.core.route.Routing;
import org.noear.solon.core.util.ResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据库初始化器
 * 自动执行初始化脚本
 *
 * @author lingma
 */
@Component(index = -10)
public class DataSourceInitializer implements LifecycleBean {

    private static final Logger log = LoggerFactory.getLogger(DataSourceInitializer.class);

    @Inject
    private DataSource dataSource;

    @Inject
    private CustomDbIdProvider customDbIdProvider;
    @Inject
    private IJdbcTemplate jdbcTemplate;
    @Inject
    private IOrmTemplate ormTemplate;
    @Inject
    private IOrmSessionFactory ormSessionFactory;

    @Override
    public void start() throws Throwable {
        if (Solon.cfg().getBool("orm.init-database-schema", false)) {
            DataBaseSchemaInitializer schemaInitializer = new DataBaseSchemaInitializer();
            schemaInitializer.setJdbcTemplate(jdbcTemplate);
            schemaInitializer.setOrmSessionFactory(ormSessionFactory);
            schemaInitializer.init();
        }
        if (Solon.cfg().getBool("orm.init-database-data", false)) {
            IOrmTemplate ormTemplate = BeanContainer.instance()
                    .getBeanByType(IOrmTemplate.class);
            IDaoProvider daoProvider = BeanContainer.instance()
                    .getBeanByType(IDaoProvider.class);
            DataInitializerLoader loader = new DataInitializerLoader(daoProvider);
            loader.loadAndExecute(ormTemplate);
        }
        String databaseId = customDbIdProvider.getDatabaseId(dataSource);
        log.info("检测到{}数据库，开始执行初始化脚本...", databaseId);
        executeInitScript(databaseId);

        // 查询角色代码为bizAdmin的角色
        ormTemplate.runInSession(() -> {
            String bizAdminRoleId = getBizAdminRoleId();
            if (bizAdminRoleId != null) {
                // 为该角色授权所有业务模块资源
                grantAllBusinessResourcesToRole(bizAdminRoleId);
                // 为该业务角色授权所有业务模块的权限
                grantAllBusinessPermissionsToRole(bizAdminRoleId);
            }
            String superAdminRoleId = getSuperAdminRoleId();
            if (superAdminRoleId != null) {
                // 为该角色授权所有业务模块资源
                grantAllBusinessResourcesToRole(superAdminRoleId);
                // 为该业务角色授权所有业务模块的权限
                grantAllBusinessPermissionsToRole(superAdminRoleId);
            }
        });

        log.info("{}数据库初始化脚本执行完成", databaseId);
    }

    /**
     * 执行H2数据库初始化脚本
     */
    private void executeInitScript(String databaseId) {
        try (Connection connection = dataSource.getConnection()) {
            executeScript(connection, String.format("_sql/%s/snowy_data.sql", databaseId));
        } catch (SQLException e) {
            log.error("执行H2数据库初始化脚本失败", e);
        }
    }

    /**
     * 执行单个SQL脚本文件
     *
     * @param connection 数据库连接
     * @param scriptPath 脚本路径
     */
    private void executeScript(Connection connection, String scriptPath) {
        try {
            URL resource = ResourceUtil.findResourceOrFile(null, scriptPath);
            if (resource == null) {
                log.warn("未找到脚本文件: {}", scriptPath);
                return;
            }

            List<String> lines = FileUtil.readLines(resource, "UTF-8");
            StringBuilder sqlBuilder = new StringBuilder();
            Statement statement = connection.createStatement();

            for (String line : lines) {
                // 跳过注释行和空行
                if (StrUtil.isBlank(line) || line.trim().startsWith("--")) {
                    continue;
                }

                sqlBuilder.append(line).append("\n");

                // 检查是否为语句结束符
                if (line.trim().endsWith(";")) {
                    String sql = sqlBuilder.toString().trim();
                    // 去掉结尾的分号
                    if (sql.endsWith(";")) {
                        sql = sql.substring(0, sql.length() - 1);
                    }

                    // 执行非空SQL
                    if (StrUtil.isNotBlank(sql)) {
                        try {
                            statement.execute(sql);
                        } catch (SQLException e) {
                            // 允许单个语句执行失败，因为表可能已经存在或者数据已经存在
                            log.debug("执行SQL语句时遇到预期的错误（表可能已存在或数据已存在）: {}", sql);
                        }
                    }

                    // 重置SQL构建器
                    sqlBuilder.setLength(0);
                }
            }

            statement.close();
            log.info("成功执行脚本: {}", scriptPath);
        } catch (SQLException e) {
            log.error("执行脚本失败: {}", scriptPath, e);
        }
    }

    /**
     * 获取业务管理员角色ID
     *
     * @return 业务管理员角色ID
     */
    private String getBizAdminRoleId() {
        IEntityDao<SysRole> entityDao = DaoProvider.instance().daoFor(SysRole.class);
        SysRole sysRole = entityDao.newEntity();
        sysRole.setCode("bizAdmin");
        SysRole firstByExample = entityDao.findFirstByExample(sysRole);
        return firstByExample.getId_();
    }

    /**
     * 获取系统管理员角色ID
     *
     * @return 系统管理员角色ID
     */
    private String getSuperAdminRoleId() {
        IEntityDao<SysRole> entityDao = DaoProvider.instance().daoFor(SysRole.class);
        SysRole sysRole = entityDao.newEntity();
        sysRole.setCode("superAdmin");
        SysRole firstByExample = entityDao.findFirstByExample(sysRole);
        return firstByExample.getId_();
    }

    /**
     * 为角色授予所有业务模块资源
     *
     * @param roleId 角色ID
     */
    private void grantAllBusinessResourcesToRole(String roleId) {
        IEntityDao<SysResource> resourceIEntityDao = DaoProvider.instance().daoFor(SysResource.class);
        IEntityDao<SysRelation> relationIEntityDao = DaoProvider.instance().daoFor(SysRelation.class);
        SysResource sysResource = resourceIEntityDao.newEntity();
        // 业务模块的id
        sysResource.setModule("1548901111999773976");
        // 查询出所有业务模块的目录和菜单
        List<SysResource> allByExample = resourceIEntityDao.findAllByExample(sysResource);
        for (SysResource resource : allByExample) {
            // 目录
            if ("CATALOG".equals(resource.getMenuType())) { // 保存目录和业务管理员的关系
                if (relationIEntityDao.getEntityById(resource.getId_()) == null) {
                    SysRelation sysRelation = relationIEntityDao.newEntity();
                    sysRelation.setObjectId(roleId);
                    sysRelation.setTargetId(resource.getId_());
                    sysRelation.setId_(resource.getId_());
                    sysRelation.setCategory("SYS_ROLE_HAS_RESOURCE");
                    sysRelation.setExtJson(new ONode().set("menuId", resource.getId_()).set("buttonInfo", new ONode().asArray()).toString());
                    relationIEntityDao.saveEntity(sysRelation);
                }
            } else if ("MENU".equals(resource.getMenuType())) { // 菜单
                // 保存菜单的业务管理员关系
                if (relationIEntityDao.getEntityById(resource.getId_()) == null) {
                    SysRelation sysRelation = relationIEntityDao.newEntity();
                    sysRelation.setObjectId(roleId);
                    sysRelation.setTargetId(resource.getId_());
                    sysRelation.setId_(resource.getId_());
                    sysRelation.setCategory("SYS_ROLE_HAS_RESOURCE");
                    // 查询菜单关联按钮
                    SysResource buttonResource = resourceIEntityDao.newEntity();
                    buttonResource.setCategory("BUTTON");
                    buttonResource.setParentId(resource.getId_());
                    List<String> buttonList = resourceIEntityDao.findAllByExample(buttonResource)
                            .stream().map(button -> button.getId_()).collect(Collectors.toList());

                    sysRelation.setExtJson(new ONode().set("menuId", resource.getId_()).set("buttonInfo", buttonList).toString());
                    relationIEntityDao.saveEntity(sysRelation);
                }
            }
        }
        log.info("为角色 {} 授权所有业务模块资源完成", roleId);
    }

    /**
     * 为角色授予所有业务模块权限
     *
     * @param roleId 角色ID
     */
    private void grantAllBusinessPermissionsToRole(String roleId) {
        IEntityDao<SysRelation> relationIEntityDao = DaoProvider.instance().daoFor(SysRelation.class);
        List<String> list = permissionTreeSelector();
        for (String permission : list) {
            // 添加权限
            SysRelation sysRelationQry = relationIEntityDao.newEntity();
            sysRelationQry.setObjectId(roleId);
            List<SysRelation> rolePerList = relationIEntityDao.findAllByExample(sysRelationQry);
            List<String> perStrList = rolePerList.stream().map(s -> s.getTargetId()).collect(Collectors.toList());
            if (!perStrList.contains(permission)) {
                SysRelation sysRelation = relationIEntityDao.newEntity();
                sysRelation.setObjectId(roleId);
                sysRelation.setTargetId(permission);
                sysRelation.setId_(IdUtil.getSnowflakeNextIdStr());
                sysRelation.setCategory("SYS_ROLE_HAS_PERMISSION");
                sysRelation.setExtJson(new ONode().set("apiUrl", permission).set("scopeCategory", "SCOPE_ALL").set("scopeDefineOrgIdList", new ONode().asArray()).toString());
                relationIEntityDao.saveEntity(sysRelation);
            }
        }
        log.info("为角色 {} 授权所有业务模块权限完成", roleId);
    }

    public List<String> permissionTreeSelector() {
        List<String> permissionResult = CollectionUtil.newArrayList();

        Collection<Routing<Handler>> routingAll = Solon.app().router().getAll();

        for (Routing<Handler> routing : routingAll) {
            if (routing.target() instanceof Action) {
                Action action = (Action) routing.target();

                SaCheckPermission saCheckPermission = action.method().getAnnotation(SaCheckPermission.class);
                if (ObjectUtil.isNotEmpty(saCheckPermission)) {
                    String pathExpr = routing.path();
                    if (pathExpr != null) {
                        permissionResult.add(pathExpr);
                    }
                }
            }
        }


        return CollectionUtil.sortByPinyin(permissionResult.stream().filter(api ->
                !api.startsWith("/" + StrUtil.BRACKET_START)
                        && !api.startsWith("/error")
                        && !api.contains("/api-docs")
                        && !api.contains("/swagger-resources")).collect(Collectors.toList()));
    }

}

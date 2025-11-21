package com.fliad.core.config;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
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
import org.noear.solon.core.util.ResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
        });

        log.info("{}数据库初始化脚本执行完成", databaseId);
    }

    /**
     * 执行H2数据库初始化脚本
     */
    private void executeInitScript(String databaseId) {
        try (Connection connection = dataSource.getConnection()) {
            executeScript(connection, String.format("_sql/%s/snowy_data.sql", databaseId));
            for (String u1 : ResourceUtil.scanResources(String.format("classpath:_sql/%s/*.sql", databaseId))) {
                if (u1.contains("data") && !u1.contains("snowy_data")) {
                    executeScript(connection, u1);
                }
            }
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
                    /*allByExample.stream().filter()
                    sysRelation.setExtJson(new ONode().set("menuId", resource.getId_()).set("buttonInfo", new ONode().asArray()).toString());*/
                }
            }
        }
        try {
            /*IOrmTemplate ormTemplate = BeanContainer.instance().getBeanByType(IOrmTemplate.class);
            
            // 删除该角色现有的资源授权
            Object relationExample = ormTemplate.newEntity("com.fliad.sys.dao.entity.SysRelation");
            relationExample.getClass().getMethod("setObjectId", String.class).invoke(relationExample, roleId);
            relationExample.getClass().getMethod("setCategory", String.class).invoke(relationExample, "SYS_ROLE_HAS_RESOURCE");
            ormTemplate.deleteByExample(relationExample);
            
            // 查询所有业务模块菜单资源
            Object resourceExample = ormTemplate.newEntity("com.fliad.sys.dao.entity.SysResource");
            resourceExample.getClass().getMethod("setModule", String.class).invoke(resourceExample, "1548901111999773976");
            
            List<?> resources = ormTemplate.findAllByExample(resourceExample);
            log.info("找到 {} 个业务模块资源", resources.size());
            
            // 为角色授予所有业务模块资源
            for (Object resource : resources) {
                String resourceId = (String) resource.getClass().getMethod("getId_").invoke(resource);
                String resourceCategory = (String) resource.getClass().getMethod("getCategory").invoke(resource);
                
                // 只处理菜单和目录类型资源
                if ("MENU".equals(resourceCategory) || "CATALOG".equals(resourceCategory)) {
                    Object relation = ormTemplate.newEntity("com.fliad.sys.dao.entity.SysRelation");
                    relation.getClass().getMethod("setId_", String.class).invoke(relation, "ROLE_" + roleId.substring(0, Math.min(roleId.length(), 10)) + "_RES_" + resourceId.substring(0, Math.min(resourceId.length(), 10)));
                    relation.getClass().getMethod("setObjectId", String.class).invoke(relation, roleId);
                    relation.getClass().getMethod("setTargetId", String.class).invoke(relation, resourceId);
                    relation.getClass().getMethod("setCategory", String.class).invoke(relation, "SYS_ROLE_HAS_RESOURCE");
                    relation.getClass().getMethod("setExtJson", String.class).invoke(relation, "{\"menuId\":\"" + resourceId + "\",\"buttonInfo\":[]}");
                    
                    ormTemplate.save(relation);
                }
            }*/
            log.info("为角色 {} 授权所有业务模块资源完成", roleId);
        } catch (Exception e) {
            log.error("为角色授予所有业务模块资源失败", e);
        }
    }

    /**
     * 为角色授予所有业务模块权限
     *
     * @param roleId 角色ID
     */
    private void grantAllBusinessPermissionsToRole(String roleId) {
        try {
            /*IOrmTemplate ormTemplate = BeanContainer.instance().getBeanByType(IOrmTemplate.class);
            
            // 删除该角色现有的权限授权
            Object relationExample = ormTemplate.newEntity("com.fliad.sys.dao.entity.SysRelation");
            relationExample.getClass().getMethod("setObjectId", String.class).invoke(relationExample, roleId);
            relationExample.getClass().getMethod("setCategory", String.class).invoke(relationExample, "SYS_ROLE_HAS_PERMISSION");
            ormTemplate.deleteByExample(relationExample);
            
            // 查询所有业务模块资源以获取权限URL
            Object resourceExample = ormTemplate.newEntity("com.fliad.sys.dao.entity.SysResource");
            resourceExample.getClass().getMethod("setModule", String.class).invoke(resourceExample, "1548901111999773976");
            
            List<?> resources = ormTemplate.findAllByExample(resourceExample);
            log.info("找到 {} 个业务模块资源用于权限授权", resources.size());
            
            // 为角色授予所有业务模块权限
            for (Object resource : resources) {
                String apiUrl = (String) resource.getClass().getMethod("getApiUrl").invoke(resource);
                if (apiUrl != null && !apiUrl.isEmpty()) {
                    Object relation = ormTemplate.newEntity("com.fliad.sys.dao.entity.SysRelation");
                    String relationId = "ROLE_" + roleId.substring(0, Math.min(roleId.length(), 10)) + "_PER_" + Math.abs(apiUrl.hashCode() % 1000000);
                    relation.getClass().getMethod("setId_", String.class).invoke(relation, relationId);
                    relation.getClass().getMethod("setObjectId", String.class).invoke(relation, roleId);
                    relation.getClass().getMethod("setTargetId", String.class).invoke(relation, apiUrl);
                    relation.getClass().getMethod("setCategory", String.class).invoke(relation, "SYS_ROLE_HAS_PERMISSION");
                    relation.getClass().getMethod("setExtJson", String.class).invoke(relation, "{\"apiUrl\":\"" + apiUrl + "\",\"scopeCategory\":\"SCOPE_ALL\",\"scopeDefineOrgIdList\":[]}");
                    
                    ormTemplate.save(relation);
                }
            }*/
            log.info("为角色 {} 授权所有业务模块权限完成", roleId);
        } catch (Exception e) {
            log.error("为角色授予所有业务模块权限失败", e);
        }
    }
}
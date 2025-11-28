package com.fliad.workflow;

import com.fliad.dev.modular.dict.mapper.DevDictMapper;
import com.mybatisflex.core.FlexGlobalConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dromara.warm.flow.orm.mapper.*;
import org.dromara.warm.plugin.modes.solon.config.BeanConfig;
import org.noear.solon.Solon;
import org.noear.solon.core.AppContext;
import org.noear.solon.core.Plugin;
import org.noear.solon.core.event.EventBus;

/**
 * @author wyl
 * @date 2025年11月28日 20:17
 */
public class XPluginImpl implements Plugin {
    @Override
    public void start(AppContext context) throws Throwable {
        context.beanMake(BeanConfig.class);
        EventBus.subscribe(FlexGlobalConfig.class, e -> {
            e.getConfiguration().addMapper(FlowDefinitionMapper.class);
            e.getConfiguration().addMapper(FlowFormMapper.class);
            e.getConfiguration().addMapper(FlowHisTaskMapper.class);
            e.getConfiguration().addMapper(FlowInstanceMapper.class);
            e.getConfiguration().addMapper(FlowNodeMapper.class);
            e.getConfiguration().addMapper(FlowSkipMapper.class);
            e.getConfiguration().addMapper(FlowTaskMapper.class);
            e.getConfiguration().addMapper(FlowUserMapper.class);
        });
        Solon.context().subBeansOfType(DevDictMapper.class, dictMapper -> {
            System.out.println();
        });
        context.lifecycle(() -> {
            /*final MybatisAdapter mybatisAdapter = MybatisAdapterManager.getAll().values().iterator().next();
            context.beanInject(mybatisAdapter.getMapper(FlowDefinitionMapper.class));
            context.beanInject(mybatisAdapter.getMapper(FlowFormMapper.class));
            context.beanInject(mybatisAdapter.getMapper(FlowHisTaskMapper.class));
            context.beanInject(mybatisAdapter.getMapper(FlowInstanceMapper.class));
            context.beanInject(mybatisAdapter.getMapper(FlowNodeMapper.class));
            context.beanInject(mybatisAdapter.getMapper(FlowSkipMapper.class));
            context.beanInject(mybatisAdapter.getMapper(FlowTaskMapper.class));
            context.beanInject(mybatisAdapter.getMapper(FlowUserMapper.class));*/
        });
    }
}

package com.fliad.viid.modular.subscribe.wrapper;

import cn.hutool.json.JSONObject;
import com.fliad.common.annotation.CommonWrapperField;
import com.fliad.common.pojo.CommonWrapperInterface;
import com.fliad.viid.modular.cascadeplatform.entity.ViidCascadePlatform;
import com.fliad.viid.modular.cascadeplatform.service.ViidCascadePlatformService;
import com.fliad.viid.modular.subscribe.entity.ViidSubscribe;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.Solon;

import java.util.Optional;


@Slf4j
public class ViidSubscribeWrapper implements CommonWrapperInterface<ViidSubscribe> {

    private static ViidCascadePlatformService viidCascadePlatformService;

    static {
        //异步订阅方式，根据bean type获取Bean（已存在或产生时，会通知回调；否则，一直不回调）
        Solon.context().getBeanAsync(ViidCascadePlatformService.class, bean -> {
            viidCascadePlatformService = bean;
        });
    }

    @Override
    public JSONObject doWrap(ViidSubscribe viidSubscribe) {
        // 后期可通过反射进行处理
        JSONObject entries = new JSONObject();
        // 订阅目标节点
        Optional.ofNullable(viidSubscribe.getSubscriberRecoverOrgid()).ifPresent(subscriberrecoverorgid -> {
            CommonWrapperField wrapperField = null;
            try {
                wrapperField = viidSubscribe.getClass().getDeclaredField("SubscriberRecoverOrgid").getAnnotation(CommonWrapperField.class);
            } catch (NoSuchFieldException e) {
                setLog(subscriberrecoverorgid);
            }
            QueryWrapper queryWrapper = QueryWrapper.create().select("name").eq("id", subscriberrecoverorgid);
            ViidCascadePlatform cascadePlatform = viidCascadePlatformService.getMapper().selectOneByQuery(queryWrapper);
            if (null != cascadePlatform) {
                entries.set(wrapperField.ref(), cascadePlatform.getName());
            }
        });
        return entries;
    }

    protected void setLog(String field) {
        log.info("字段：{}，未找到注解。", field);
    }

}

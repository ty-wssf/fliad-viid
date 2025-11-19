package com.fliad.viid.modular.cascadeplatform.domain;

import java.io.Serializable;

/**
 * 订阅通知请求
 */
public class SubscribeNotificationRequest implements Serializable {

    private SubscribeNotificationListObject SubscribeNotificationListObject;

    public com.fliad.viid.modular.cascadeplatform.domain.SubscribeNotificationListObject getSubscribeNotificationListObject() {
        return SubscribeNotificationListObject;
    }

    public void setSubscribeNotificationListObject(com.fliad.viid.modular.cascadeplatform.domain.SubscribeNotificationListObject subscribeNotificationListObject) {
        SubscribeNotificationListObject = subscribeNotificationListObject;
    }
}
package com.fliad.viid.modular.cascadeplatform.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 订阅通知请求
 */
@Data
public class SubscribeNotificationRequest implements Serializable {

    private SubscribeNotificationListObject SubscribeNotificationListObject;

}

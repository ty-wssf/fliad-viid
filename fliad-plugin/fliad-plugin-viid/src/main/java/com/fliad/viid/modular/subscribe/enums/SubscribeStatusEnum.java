package com.fliad.viid.modular.subscribe.enums;

import lombok.Getter;

/**
 * 订阅执行状态枚举
 */
@Getter
public enum SubscribeStatusEnum {

    /**
     * 订阅中
     */
    SUBSCRIBING("0", "订阅中"),

    /**
     * 已取消订阅
     */
    UNSUBSCRIBED("1", "已取消订阅"),

    /**
     * 订阅到期
     */
    EXPIRED("2", "订阅到期"),

    /**
     * 未订阅
     */
    UN_SUBSCRIBED("9", "未订阅");

    private final String code;
    private final String name;

    SubscribeStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据code获取枚举对象
     *
     * @param code 状态码
     * @return 枚举对象
     */
    public static SubscribeStatusEnum getByCode(String code) {
        for (SubscribeStatusEnum status : SubscribeStatusEnum.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }

}
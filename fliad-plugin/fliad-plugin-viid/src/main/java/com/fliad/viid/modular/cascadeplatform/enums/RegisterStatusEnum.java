/*
 * Copyright [2022] [https://www.xiaonuo.vip]
 *
 * Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：
 *
 * 1.请不要删除和修改根目录下的LICENSE文件。
 * 2.请不要删除和修改Snowy源码头部的版权声明。
 * 3.本项目代码可免费商业使用，商业使用请保留源码和相关描述文件的项目出处，作者声明等。
 * 4.分发源码时候，请注明软件出处 https://www.xiaonuo.vip
 * 5.不可二次分发开源参与同类竞品，如有想法可联系团队xiaonuobase@qq.com商议合作。
 * 6.若您的项目无法满足以上几点，需要更多功能代码，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package com.fliad.viid.modular.cascadeplatform.enums;

import lombok.Getter;

/**
 * 注册状态枚举
 *
 * @author wyl
 * @date  2025/08/14 16:24
 **/
@Getter
public enum RegisterStatusEnum {

    /** 未注册 */
    UNREGISTERED("0", "未注册"),
    
    /** 已注册 */
    REGISTERED("1", "已注册");

    private final String code;
    private final String name;

    RegisterStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
    
    /**
     * 根据code获取枚举对象
     * @param code 状态码
     * @return 枚举对象
     */
    public static RegisterStatusEnum getByCode(String code) {
        for (RegisterStatusEnum status : RegisterStatusEnum.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }
}
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
 * 平台类型枚举
 *
 * @author wyl
 * @date  2025/08/14 16:24
 **/
@Getter
public enum PlatformTypeEnum {

    /** 上级平台 */
    SUPERIOR("0", "上级平台"),
    
    /** 下级平台 */
    SUBORDINATE("1", "下级平台");

    private final String code;
    private final String name;

    PlatformTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
    
    /**
     * 根据code获取枚举对象
     * @param code 类型码
     * @return 枚举对象
     */
    public static PlatformTypeEnum getByCode(String code) {
        for (PlatformTypeEnum type : PlatformTypeEnum.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

}
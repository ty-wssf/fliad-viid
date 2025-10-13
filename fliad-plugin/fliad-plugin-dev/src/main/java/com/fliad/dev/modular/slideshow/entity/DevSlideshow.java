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
package com.fliad.dev.modular.slideshow.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import com.fliad.common.pojo.CommonEntity;

/**
 * 轮播图实体
 *
 * @author yubaoshan
 * @date  2024/07/13 00:31
 **/
@Getter
@Setter
@Table(value = "DEV_SLIDESHOW")
public class DevSlideshow extends CommonEntity {

    /** 主键 */
    @Id
    @ApiModelProperty(value = "主键", position = 1)
    private String id;

    /** 标题 */
    @ApiModelProperty(value = "标题", position = 2)
    private String title;

    /** 展示位置 */
    @ApiModelProperty(value = "展示位置", position = 3)
    private String place;

    /** 图片 */
    @ApiModelProperty(value = "图片", position = 4)
    private String image;

    /** 路径详情 */
    @ApiModelProperty(value = "路径详情", position = 5)
    private String pathDetails;

    /** 状态 */
    @ApiModelProperty(value = "状态", position = 6)
    private String status;

    /** 排序 */
    @ApiModelProperty(value = "排序", position = 7)
    private Integer sortCode;

    /** 扩展信息 */
    @ApiModelProperty(value = "扩展信息", position = 8)
    private String extJson;
}

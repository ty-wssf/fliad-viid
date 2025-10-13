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
package com.fliad.biz.modular.notice.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.noear.solon.validation.annotation.NotBlank;

/**
 * 通知公告编辑参数
 *
 * @author yubaoshan
 * @date  2024/07/11 14:46
 **/
@Getter
@Setter
public class BizNoticeEditParam {

    /** 主键 */
    @ApiModelProperty(value = "主键", required = true, position = 1)
    @NotBlank(message = "id不能为空")
    private String id;

    /** 标题 */
    @ApiModelProperty(value = "标题", position = 2)
    @NotBlank(message = "title不能为空")
    private String title;

    /** 封面图 */
    @ApiModelProperty(value = "封面图", position = 3)
    private String image;

    /** 内容 */
    @ApiModelProperty(value = "内容", position = 4)
    @NotBlank(message = "content不能为空")
    private String content;

    /** 摘要 */
    @ApiModelProperty(value = "摘要", position = 5)
    @NotBlank(message = "digest不能为空")
    private String digest;

    /** 类型 */
    @ApiModelProperty(value = "类型", position = 6)
    @NotBlank(message = "type不能为空")
    private String type;

    /** 发布位置 */
    @ApiModelProperty(value = "发布位置", position = 7)
    @NotBlank(message = "place不能为空")
    private String place;

    /** 排序 */
    @ApiModelProperty(value = "排序", position = 9)
    private Integer sortCode;

    /** 备注 */
    @ApiModelProperty(value = "备注", position = 10)
    private String remark;

}

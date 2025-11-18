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
package com.fliad.biz.modular.position.param;

import io.swagger.annotations.ApiModelProperty;

import org.noear.solon.validation.annotation.NotBlank;
import org.noear.solon.validation.annotation.NotNull;


/**
 * 岗位添加参数
 *
 * @author xuyuxiang
 * @date 2022/4/21 16:13
 **/

public class BizPositionAddParam {

    /** 机构id */
    @ApiModelProperty(value = "机构id", required = true, position = 1)
    @NotBlank(message = "orgId不能为空")
    private String orgId;

    /** 名称 */
    @ApiModelProperty(value = "名称", required = true, position = 2)
    @NotBlank(message = "name不能为空")
    private String name;

    /** 分类 */
    @ApiModelProperty(value = "分类", required = true, position = 3)
    @NotBlank(message = "category不能为空")
    private String category;

    /** 排序码 */
    @ApiModelProperty(value = "排序码", required = true, position = 4)
    @NotNull(message = "sortCode不能为空")
    private Integer sortCode;

    /** 扩展JSON */
    @ApiModelProperty(value = "扩展JSON", position = 5)
    private String extJson;

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setSortCode(Integer sortCode) {
        this.sortCode = sortCode;
    }

    public Integer getSortCode() {
        return sortCode;
    }

    public void setExtJson(String extJson) {
        this.extJson = extJson;
    }

    public String getExtJson() {
        return extJson;
    }
}

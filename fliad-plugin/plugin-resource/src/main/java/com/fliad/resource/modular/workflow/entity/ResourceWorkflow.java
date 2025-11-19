package com.fliad.resource.modular.workflow.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import io.swagger.annotations.ApiModelProperty;
import org.noear.solon.validation.annotation.NotBlank;

import java.util.Date;

/**
 * 工作流实体
 *
 * @author wyl
 * @date  2025/08/27 14:03
 **/
@Table(value = "RESOURCE_WORKFLOW")
public class ResourceWorkflow {

    /** ID */
    @Id
    @ApiModelProperty(value = "ID", position = 1)
    private String id;

    /** 标题 */
    @ApiModelProperty(value = "标题", position = 2)
    private String title;

    /** 状态 */
    @ApiModelProperty(value = "状态", position = 3)
    private String status;

    /** 订阅类别 */
    @ApiModelProperty(value = "订阅类别", required = true, position = 3)
    @NotBlank(message = "subscribedetail不能为空")
    private String subscribeDetail;

    /** 备注 */
    @ApiModelProperty(value = "备注", position = 4)
    private String remark;

    /** 工作流设计的 JSON 内容 */
    @ApiModelProperty(value = "工作流设计的 JSON 内容", position = 5)
    private String content;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间", position = 6)
    private Date createTime;

    /** 创建用户 */
    @ApiModelProperty(value = "创建用户", position = 7)
    private String createUser;

    /** 修改时间 */
    @ApiModelProperty(value = "修改时间", position = 8)
    private Date updateTime;

    /** 修改用户 */
    @ApiModelProperty(value = "修改用户", position = 9)
    private String updateUser;

    /** 是否为模板 */
    @ApiModelProperty(value = "是否为模板", position = 10)
    private Boolean isTemplate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubscribeDetail() {
        return subscribeDetail;
    }

    public void setSubscribeDetail(String subscribeDetail) {
        this.subscribeDetail = subscribeDetail;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Boolean getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Boolean isTemplate) {
        this.isTemplate = isTemplate;
    }
}
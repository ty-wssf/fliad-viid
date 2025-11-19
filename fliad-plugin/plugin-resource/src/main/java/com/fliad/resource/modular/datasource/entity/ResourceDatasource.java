package com.fliad.resource.modular.datasource.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 数据源实体
 *
 * @author wyl
 * @date  2025/09/24 20:05
 */
@Table(value = "RESOURCE_DATASOURCE")
public class ResourceDatasource {

    /** ID */
    @Id
    @ApiModelProperty(value = "ID", position = 1)
    private String id;

    /** 标题 */
    @ApiModelProperty(value = "标题", position = 2)
    private String title;

    /** 订阅类别 */
    @ApiModelProperty(value = "订阅类别", position = 2)
    private String subscribeDetail;

    /** 类型 */
    @ApiModelProperty(value = "类型", position = 3)
    private String type;

    /** 状态 */
    @ApiModelProperty(value = "状态", position = 4)
    private String status;

    /** 备注 */
    @ApiModelProperty(value = "备注", position = 5)
    private String remark;

    /** 数据源配置的 JSON 内容 */
    @ApiModelProperty(value = "数据源配置的 JSON 内容", position = 6)
    private String content;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间", position = 7)
    private Date createTime;

    /** 创建用户 */
    @ApiModelProperty(value = "创建用户", position = 8)
    private String createUser;

    /** 修改时间 */
    @ApiModelProperty(value = "修改时间", position = 9)
    private Date updateTime;

    /** 修改用户 */
    @ApiModelProperty(value = "修改用户", position = 10)
    private String updateUser;

    /** 是否为模板 */
    @ApiModelProperty(value = "是否为模板", position = 11)
    private Boolean isTemplate;

    /** 脚本过滤器 */
    @ApiModelProperty(value = "脚本过滤器", position = 12)
    private String scriptFilter;

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

    public String getSubscribeDetail() {
        return subscribeDetail;
    }

    public void setSubscribeDetail(String subscribeDetail) {
        this.subscribeDetail = subscribeDetail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getScriptFilter() {
        return scriptFilter;
    }

    public void setScriptFilter(String scriptFilter) {
        this.scriptFilter = scriptFilter;
    }
}
/*
 *    Copyright 2024-2025, Warm-Flow (290631660@qq.com).
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.fliad.workflow.entity;

import org.dromara.warm.flow.core.entity.Form;

import java.util.Date;


/**
 * @author vanlin
 * @since 2024/8/19 10:30
 */
public class FlowFormImpl implements Form {

    /**
     * 主键
     */
    private Long id;

    /**
     * 表单编码
     */
    private String formCode;

    /**
     * 表单名称
     */
    private String formName;

    /**
     * 表单版本
     */
    private String version;

    /**
     * 是否发布（0未发布 1已发布 9失效）
     */
    private Integer isPublish;

    /**
     * 表单类型（0内置表单 存 form_content        1外挂表单 存form_path）
     */
    private Integer formType;

    /**
     * 表单路径
     */
    private String formPath;

    /**
     * 表单内容
     */
    private String formContent;

    /**
     * 表单扩展，用户自行使用
     */
    private String ext;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 删除标记
     */
    private String delFlag;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public FlowFormImpl setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String getFormCode() {
        return formCode;
    }

    @Override
    public FlowFormImpl setFormCode(String formCode) {
        this.formCode = formCode;
        return this;
    }

    @Override
    public String getFormName() {
        return formName;
    }

    @Override
    public FlowFormImpl setFormName(String formName) {
        this.formName = formName;
        return this;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public FlowFormImpl setVersion(String version) {
        this.version = version;
        return this;
    }

    @Override
    public Integer getIsPublish() {
        return isPublish;
    }

    @Override
    public FlowFormImpl setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
        return this;
    }

    @Override
    public Integer getFormType() {
        return formType;
    }

    @Override
    public FlowFormImpl setFormType(Integer formType) {
        this.formType = formType;
        return this;
    }

    @Override
    public String getFormPath() {
        return formPath;
    }

    @Override
    public FlowFormImpl setFormPath(String formPath) {
        this.formPath = formPath;
        return this;
    }

    @Override
    public String getFormContent() {
        return formContent;
    }

    @Override
    public FlowFormImpl setFormContent(String formContent) {
        this.formContent = formContent;
        return this;
    }

    @Override
    public String getExt() {
        return ext;
    }

    @Override
    public FlowFormImpl setExt(String ext) {
        this.ext = ext;
        return this;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public FlowFormImpl setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public FlowFormImpl setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public FlowFormImpl setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    @Override
    public String getUpdateBy() {
        return updateBy;
    }

    @Override
    public FlowFormImpl setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    @Override
    public String getTenantId() {
        return tenantId;
    }

    @Override
    public FlowFormImpl setTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    @Override
    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public FlowFormImpl setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }
}

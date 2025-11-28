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

import org.dromara.warm.flow.core.entity.User;

import java.util.Date;


/**
 * 流程用户对象 flow_user
 *
 * @author xiarg
 * @since 2024/5/10 10:58
 */
public class FlowUserImpl implements User {

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人：比如作为委托的人保存
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

    /**
     * 人员类型（1待办任务的审批人权限 2待办任务的转办人权限 3待办任务的委托人权限）
     */
    private String type;

    /**
     * 权限人
     */
    private String processedBy;

    /**
     * 任务表ID
     */
    private Long associated;

    public Long getId() {
        return id;
    }

    public FlowUserImpl setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public FlowUserImpl setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public FlowUserImpl setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public FlowUserImpl setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public FlowUserImpl setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public String getTenantId() {
        return tenantId;
    }

    public FlowUserImpl setTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public FlowUserImpl setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public String getType() {
        return type;
    }

    public FlowUserImpl setType(String type) {
        this.type = type;
        return this;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public FlowUserImpl setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
        return this;
    }

    public Long getAssociated() {
        return associated;
    }

    public FlowUserImpl setAssociated(Long associated) {
        this.associated = associated;
        return this;
    }
}
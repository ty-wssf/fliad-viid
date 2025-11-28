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

import org.dromara.warm.flow.core.entity.Instance;

import java.util.Date;


/**
 * 流程实例对象 flow_instance
 *
 * @author warm
 * @since 2023-03-29
 */
public class FlowInstanceImpl implements Instance {

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

    /**
     * 对应flow_definition表的id
     */
    private Long definitionId;

    /**
     * 流程名称
     */
    private String flowName;

    /**
     * 业务ID
     */
    private String businessId;

    /**
     * @see org.dromara.warm.flow.core.enums.NodeType
     * 节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）
     */
    private Integer nodeType;

    /**
     * 流程节点编码   每个流程的nodeCode是唯一的,即definitionId+nodeCode唯一,在数据库层面做了控制
     */
    private String nodeCode;

    /**
     * 流程节点名称
     */
    private String nodeName;

    /**
     * 流程变量
     */
    private String variable;

    /**
     * @see org.dromara.warm.flow.core.enums.FlowStatus
     * 流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）
     */
    private String flowStatus;

    /**
     * @see org.dromara.warm.flow.core.enums.ActivityStatus
     * 流程激活状态（0挂起 1激活）
     */
    private Integer activityStatus;

    /**
     * 审批表单是否自定义（Y=是 N=否）
     */
    private String formCustom;

    /**
     * 审批表单是否自定义（Y=是 N=否）
     */
    private String formPath;

    /**
     * 流程定义json
     */
    private String defJson;

    /**
     * 扩展字段，预留给业务系统使用
     */
    private String ext;

    public Long getId() {
        return id;
    }

    public FlowInstanceImpl setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public FlowInstanceImpl setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public FlowInstanceImpl setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public FlowInstanceImpl setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public FlowInstanceImpl setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public String getTenantId() {
        return tenantId;
    }

    public FlowInstanceImpl setTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public FlowInstanceImpl setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public Long getDefinitionId() {
        return definitionId;
    }

    public FlowInstanceImpl setDefinitionId(Long definitionId) {
        this.definitionId = definitionId;
        return this;
    }

    public String getFlowName() {
        return flowName;
    }

    public FlowInstanceImpl setFlowName(String flowName) {
        this.flowName = flowName;
        return this;
    }

    public String getBusinessId() {
        return businessId;
    }

    public FlowInstanceImpl setBusinessId(String businessId) {
        this.businessId = businessId;
        return this;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public FlowInstanceImpl setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
        return this;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public FlowInstanceImpl setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
        return this;
    }

    public String getNodeName() {
        return nodeName;
    }

    public FlowInstanceImpl setNodeName(String nodeName) {
        this.nodeName = nodeName;
        return this;
    }

    public String getVariable() {
        return variable;
    }

    public FlowInstanceImpl setVariable(String variable) {
        this.variable = variable;
        return this;
    }

    public String getFlowStatus() {
        return flowStatus;
    }

    public FlowInstanceImpl setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
        return this;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public FlowInstanceImpl setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
        return this;
    }

    public String getFormCustom() {
        return formCustom;
    }

    public FlowInstanceImpl setFormCustom(String formCustom) {
        this.formCustom = formCustom;
        return this;
    }

    public String getFormPath() {
        return formPath;
    }

    public FlowInstanceImpl setFormPath(String formPath) {
        this.formPath = formPath;
        return this;
    }

    public String getDefJson() {
        return defJson;
    }

    public FlowInstanceImpl setDefJson(String defJson) {
        this.defJson = defJson;
        return this;
    }

    public String getExt() {
        return ext;
    }

    public FlowInstanceImpl setExt(String ext) {
        this.ext = ext;
        return this;
    }
}

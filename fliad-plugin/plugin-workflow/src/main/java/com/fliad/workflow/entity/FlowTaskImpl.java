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

import org.dromara.warm.flow.core.entity.Task;
import org.dromara.warm.flow.core.entity.User;

import java.util.Date;
import java.util.List;

/**
 * 待办任务记录对象 flow_task
 *
 * @author warm
 * @since 2023-03-29
 */
public class FlowTaskImpl implements Task {

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
     * 流程实例表id
     */
    private Long instanceId;

    /**
     * 流程名称
     */
    private String flowName;

    /**
     * 业务id
     */
    private String businessId;

    /**
     * 节点编码
     */
    private String nodeCode;

    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * 节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）
     */
    private Integer nodeType;

    /**
     * 流程状态（0待提交 1审批中 2审批通过 4终止 5作废 6撤销 8已完成 9已退回 10失效 11拿回）
     * @see org.dromara.warm.flow.core.enums.FlowStatus
     */
    private String flowStatus;

    /**
     * 权限标识 permissionFlag的list形式
     */
    private List<String> permissionList;

    /**
     * 流程用户列表
     */
    private List<User> userList;

    /**
     * 审批表单是否自定义（Y=是 N=否）
     */
    private String formCustom;

    /**
     * 审批表单
     */
    private String formPath;

    public Long getId() {
        return id;
    }

    public FlowTaskImpl setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public FlowTaskImpl setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public FlowTaskImpl setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public FlowTaskImpl setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public FlowTaskImpl setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public String getTenantId() {
        return tenantId;
    }

    public FlowTaskImpl setTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public FlowTaskImpl setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public Long getDefinitionId() {
        return definitionId;
    }

    public FlowTaskImpl setDefinitionId(Long definitionId) {
        this.definitionId = definitionId;
        return this;
    }

    public Long getInstanceId() {
        return instanceId;
    }

    public FlowTaskImpl setInstanceId(Long instanceId) {
        this.instanceId = instanceId;
        return this;
    }

    public String getFlowName() {
        return flowName;
    }

    public FlowTaskImpl setFlowName(String flowName) {
        this.flowName = flowName;
        return this;
    }

    public String getBusinessId() {
        return businessId;
    }

    public FlowTaskImpl setBusinessId(String businessId) {
        this.businessId = businessId;
        return this;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public FlowTaskImpl setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
        return this;
    }

    public String getNodeName() {
        return nodeName;
    }

    public FlowTaskImpl setNodeName(String nodeName) {
        this.nodeName = nodeName;
        return this;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public FlowTaskImpl setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
        return this;
    }

    public String getFlowStatus() {
        return flowStatus;
    }

    public FlowTaskImpl setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
        return this;
    }

    public List<String> getPermissionList() {
        return permissionList;
    }

    public FlowTaskImpl setPermissionList(List<String> permissionList) {
        this.permissionList = permissionList;
        return this;
    }

    public List<User> getUserList() {
        return userList;
    }

    public FlowTaskImpl setUserList(List<User> userList) {
        this.userList = userList;
        return this;
    }

    public String getFormCustom() {
        return formCustom;
    }

    public FlowTaskImpl setFormCustom(String formCustom) {
        this.formCustom = formCustom;
        return this;
    }

    public String getFormPath() {
        return formPath;
    }

    public FlowTaskImpl setFormPath(String formPath) {
        this.formPath = formPath;
        return this;
    }
}
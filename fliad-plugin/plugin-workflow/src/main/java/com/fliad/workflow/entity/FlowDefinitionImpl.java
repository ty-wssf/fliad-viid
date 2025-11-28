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

import org.dromara.warm.flow.core.entity.Definition;
import org.dromara.warm.flow.core.entity.Node;
import org.dromara.warm.flow.core.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 流程定义对象 flow_definition
 *
 * @author warm
 * @since 2023-03-29
 */
public class FlowDefinitionImpl implements Definition {

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
     * 流程编码
     */
    private String flowCode;

    /**
     * 流程名称
     */
    private String flowName;

    /**
     * 设计器模型（CLASSICS经典模型 MIMIC仿钉钉模型）
     */
    private String modelValue;

    /**
     * 流程类别
     */
    private String category;

    /**
     * 流程版本
     */
    private String version;

    /**
     * 是否发布（0未开启 1开启）
     */
    private Integer isPublish;

    /**
     * 审批表单是否自定义（Y是 N否）
     */
    private String formCustom;

    /**
     * 审批表单路径
     */
    private String formPath;

    /**
     * 流程激活状态（0挂起 1激活）
     */
    private Integer activityStatus;

    /**
     * 监听器类型
     */
    private String listenerType;

    /**
     * 监听器路径
     */
    private String listenerPath;

    /**
     * 扩展字段，预留给业务系统使用
     */
    private String ext;

    private List<Node> nodeList = new ArrayList<>();

    /**
     * 流程权限人
     */
    private List<User> userList = new ArrayList<>();


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Definition setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public Definition setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public Definition setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public Definition setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    @Override
    public String getUpdateBy() {
        return updateBy;
    }

    @Override
    public Definition setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    @Override
    public String getTenantId() {
        return tenantId;
    }

    @Override
    public Definition setTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    @Override
    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public Definition setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String getFlowCode() {
        return flowCode;
    }

    @Override
    public Definition setFlowCode(String flowCode) {
        this.flowCode = flowCode;
        return this;
    }

    @Override
    public String getFlowName() {
        return flowName;
    }

    @Override
    public Definition setFlowName(String flowName) {
        this.flowName = flowName;
        return this;
    }

    @Override
    public String getModelValue() {
        return modelValue;
    }

    @Override
    public Definition setModelValue(String modelValue) {
        this.modelValue = modelValue;
        return this;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public Definition setCategory(String category) {
        this.category = category;
        return this;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public Definition setVersion(String version) {
        this.version = version;
        return this;
    }

    @Override
    public Integer getIsPublish() {
        return isPublish;
    }

    @Override
    public Definition setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
        return this;
    }

    @Override
    public String getFormCustom() {
        return formCustom;
    }

    @Override
    public Definition setFormCustom(String formCustom) {
        this.formCustom = formCustom;
        return this;
    }

    @Override
    public String getFormPath() {
        return formPath;
    }

    @Override
    public Definition setFormPath(String formPath) {
        this.formPath = formPath;
        return this;
    }

    @Override
    public Integer getActivityStatus() {
        return activityStatus;
    }

    @Override
    public Definition setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
        return this;
    }

    @Override
    public String getListenerType() {
        return listenerType;
    }

    @Override
    public Definition setListenerType(String listenerType) {
        this.listenerType = listenerType;
        return this;
    }

    @Override
    public String getListenerPath() {
        return listenerPath;
    }

    @Override
    public Definition setListenerPath(String listenerPath) {
        this.listenerPath = listenerPath;
        return this;
    }

    @Override
    public String getExt() {
        return ext;
    }

    @Override
    public Definition setExt(String ext) {
        this.ext = ext;
        return this;
    }

    @Override
    public List<Node> getNodeList() {
        return nodeList;
    }

    @Override
    public Definition setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
        return this;
    }

    @Override
    public List<User> getUserList() {
        return userList;
    }

    @Override
    public Definition setUserList(List<User> userList) {
        this.userList = userList;
        return this;
    }
}

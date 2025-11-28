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

import org.dromara.warm.flow.core.entity.Node;
import org.dromara.warm.flow.core.entity.Skip;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 流程节点对象 flow_node
 *
 * @author warm
 * @since 2023-03-29
 */
public class FlowNodeImpl implements Node {

    /**
     * 跳转条件
     */
    List<Skip> skipList = new ArrayList<>();
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
     * 节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）
     */
    private Integer nodeType;
    /**
     * 流程id
     */
    private Long definitionId;
    /**
     * 流程节点编码   每个流程的nodeCode是唯一的,即definitionId+nodeCode唯一,在数据库层面做了控制
     */
    private String nodeCode;
    /**
     * 流程节点名称
     */
    private String nodeName;
    /**
     * 权限标识（权限类型:权限标识，可以多个，用@@隔开)
     */
    private String permissionFlag;
    /**
     * 流程签署比例值
     */
    private String nodeRatio;
    /**
     * 流程节点坐标
     */
    private String coordinate;
    /**
     * 版本
     *
     * @deprecated 下个版本废弃
     */
    @Deprecated
    private String version;
    /**
     * 任意结点跳转
     */
    private String anyNodeSkip;
    /**
     * 监听器类型
     */
    private String listenerType;
    /**
     * 监听器路径
     */
    private String listenerPath;
    /**
     * 审批表单是否自定义（Y=是 N=否）
     */
    private String formCustom;

    /**
     * 审批表单路径
     */
    private String formPath;

    /**
     * 节点扩展属性
     */
    private String ext;

    public List<Skip> getSkipList() {
        return skipList;
    }

    public FlowNodeImpl setSkipList(List<Skip> skipList) {
        this.skipList = skipList;
        return this;
    }

    public Long getId() {
        return id;
    }

    public FlowNodeImpl setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public FlowNodeImpl setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public FlowNodeImpl setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public FlowNodeImpl setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public FlowNodeImpl setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public String getTenantId() {
        return tenantId;
    }

    public FlowNodeImpl setTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public FlowNodeImpl setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public FlowNodeImpl setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
        return this;
    }

    public Long getDefinitionId() {
        return definitionId;
    }

    public FlowNodeImpl setDefinitionId(Long definitionId) {
        this.definitionId = definitionId;
        return this;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public FlowNodeImpl setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
        return this;
    }

    public String getNodeName() {
        return nodeName;
    }

    public FlowNodeImpl setNodeName(String nodeName) {
        this.nodeName = nodeName;
        return this;
    }

    public String getPermissionFlag() {
        return permissionFlag;
    }

    public FlowNodeImpl setPermissionFlag(String permissionFlag) {
        this.permissionFlag = permissionFlag;
        return this;
    }

    public String getNodeRatio() {
        return nodeRatio;
    }

    public FlowNodeImpl setNodeRatio(String nodeRatio) {
        this.nodeRatio = nodeRatio;
        return this;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public FlowNodeImpl setCoordinate(String coordinate) {
        this.coordinate = coordinate;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public FlowNodeImpl setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getAnyNodeSkip() {
        return anyNodeSkip;
    }

    public FlowNodeImpl setAnyNodeSkip(String anyNodeSkip) {
        this.anyNodeSkip = anyNodeSkip;
        return this;
    }

    public String getListenerType() {
        return listenerType;
    }

    public FlowNodeImpl setListenerType(String listenerType) {
        this.listenerType = listenerType;
        return this;
    }

    public String getListenerPath() {
        return listenerPath;
    }

    public FlowNodeImpl setListenerPath(String listenerPath) {
        this.listenerPath = listenerPath;
        return this;
    }

    public String getFormCustom() {
        return formCustom;
    }

    public FlowNodeImpl setFormCustom(String formCustom) {
        this.formCustom = formCustom;
        return this;
    }

    public String getFormPath() {
        return formPath;
    }

    public FlowNodeImpl setFormPath(String formPath) {
        this.formPath = formPath;
        return this;
    }

    public String getExt() {
        return ext;
    }

    public FlowNodeImpl setExt(String ext) {
        this.ext = ext;
        return this;
    }
}
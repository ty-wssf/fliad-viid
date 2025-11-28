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

import org.dromara.warm.flow.core.entity.Skip;

import java.util.Date;


/**
 * 节点跳转关联对象 flow_skip
 *
 * @author warm
 * @since 2023-03-29
 */
public class FlowSkipImpl implements Skip {

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
     * 流程id
     */
    private Long definitionId;

    /**
     * 节点id
     */
    private Long nodeId;

    /**
     * 当前流程节点的编码
     */
    private String nowNodeCode;

    /**
     * 当前节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）
     */
    private Integer nowNodeType;

    /**
     * 下一个流程节点的编码
     */
    private String nextNodeCode;

    /**
     * 下一个节点类型（0开始节点 1中间节点 2结束节点 3互斥网关 4并行网关）
     */
    private Integer nextNodeType;

    /**
     * 跳转名称
     */
    private String skipName;

    /**
     * 跳转类型（PASS审批通过 REJECT退回）
     */
    private String skipType;

    /**
     * 跳转条件
     */
    private String skipCondition;

    /**
     * 流程跳转坐标
     */
    private String coordinate;

    public Long getId() {
        return id;
    }

    public FlowSkipImpl setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public FlowSkipImpl setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public FlowSkipImpl setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public FlowSkipImpl setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public FlowSkipImpl setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public String getTenantId() {
        return tenantId;
    }

    public FlowSkipImpl setTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public FlowSkipImpl setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public Long getDefinitionId() {
        return definitionId;
    }

    public FlowSkipImpl setDefinitionId(Long definitionId) {
        this.definitionId = definitionId;
        return this;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public FlowSkipImpl setNodeId(Long nodeId) {
        this.nodeId = nodeId;
        return this;
    }

    public String getNowNodeCode() {
        return nowNodeCode;
    }

    public FlowSkipImpl setNowNodeCode(String nowNodeCode) {
        this.nowNodeCode = nowNodeCode;
        return this;
    }

    public Integer getNowNodeType() {
        return nowNodeType;
    }

    public FlowSkipImpl setNowNodeType(Integer nowNodeType) {
        this.nowNodeType = nowNodeType;
        return this;
    }

    public String getNextNodeCode() {
        return nextNodeCode;
    }

    public FlowSkipImpl setNextNodeCode(String nextNodeCode) {
        this.nextNodeCode = nextNodeCode;
        return this;
    }

    public Integer getNextNodeType() {
        return nextNodeType;
    }

    public FlowSkipImpl setNextNodeType(Integer nextNodeType) {
        this.nextNodeType = nextNodeType;
        return this;
    }

    public String getSkipName() {
        return skipName;
    }

    public FlowSkipImpl setSkipName(String skipName) {
        this.skipName = skipName;
        return this;
    }

    public String getSkipType() {
        return skipType;
    }

    public FlowSkipImpl setSkipType(String skipType) {
        this.skipType = skipType;
        return this;
    }

    public String getSkipCondition() {
        return skipCondition;
    }

    public FlowSkipImpl setSkipCondition(String skipCondition) {
        this.skipCondition = skipCondition;
        return this;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public FlowSkipImpl setCoordinate(String coordinate) {
        this.coordinate = coordinate;
        return this;
    }
}
package com.fliad.viid.modular.subscribe.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mybatisflex.annotation.Column;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class ViidSubscribeCancelParam extends ViidSubscribeIdParam {

    /**
     * 订阅取消单位
     */
    @JsonProperty("SubscribeCancelOrg")
    @ApiModelProperty(value = "订阅取消单位", position = 14)
    @Column("SubscribeCancelOrg")
    private String SubscribeCancelOrg;

    /**
     * 订阅取消人
     */
    @JsonProperty("SubscribeCancelPerson")
    @ApiModelProperty(value = "订阅取消人", position = 15)
    @Column("SubscribeCancelPerson")
    private String SubscribeCancelPerson;

    /**
     * 取消时间
     */
    @JsonProperty("CancelTime")
    @ApiModelProperty(value = "取消时间", position = 16)
    @Column("CancelTime")
    private Date CancelTime;

    /**
     * 取消原因
     */
    @JsonProperty("CancelReason")
    @ApiModelProperty(value = "取消原因", position = 17)
    @Column("CancelReason")
    private String CancelReason;

    public String getSubscribeCancelOrg() {
        return SubscribeCancelOrg;
    }

    public void setSubscribeCancelOrg(String SubscribeCancelOrg) {
        this.SubscribeCancelOrg = SubscribeCancelOrg;
    }

    public String getSubscribeCancelPerson() {
        return SubscribeCancelPerson;
    }

    public void setSubscribeCancelPerson(String SubscribeCancelPerson) {
        this.SubscribeCancelPerson = SubscribeCancelPerson;
    }

    public Date getCancelTime() {
        return CancelTime;
    }

    public void setCancelTime(Date CancelTime) {
        this.CancelTime = CancelTime;
    }

    public String getCancelReason() {
        return CancelReason;
    }

    public void setCancelReason(String CancelReason) {
        this.CancelReason = CancelReason;
    }
}

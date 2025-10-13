/*
 * Copyright [2022] [https://www.xiaonuo.vip]
 *
 * Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：
 *
 * 1.请不要删除和修改根目录下的LICENSE文件。
 * 2.请不要删除和修改Snowy源码头部的版权声明。
 * 3.本项目代码可免费商业使用，商业使用请保留源码和相关描述文件的项目出处，作者声明等。
 * 4.分发源码时候，请注明软件出处 https://www.xiaonuo.vip
 * 5.不可二次分发开源参与同类竞品，如有想法可联系团队xiaonuobase@qq.com商议合作。
 * 6.若您的项目无法满足以上几点，需要更多功能代码，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package com.fliad.viid.modular.ape.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.annotation.Column;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采集设备实体
 *
 * @author wyl
 * @date  2025/09/19
 **/
@Getter
@Setter
@Table(value = "viid_ape")
public class ViidApe {

    /** 主键ID */
    @JsonProperty("ID")
    @Id
    @ApiModelProperty(value = "主键ID", position = 1)
    @Column("ID")
    private String ID;

    /** 设备唯一标识（DeviceIDType） */
    @JsonProperty("ApeID")
    @ApiModelProperty(value = "设备唯一标识（DeviceIDType）", position = 2)
    @Column("ApeID")
    private String ApeID;

    /** 设备名称 */
    @JsonProperty("Name")
    @ApiModelProperty(value = "设备名称", position = 3)
    @Column("Name")
    private String Name;

    /** 设备型号 */
    @JsonProperty("Model")
    @ApiModelProperty(value = "设备型号", position = 4)
    @Column("Model")
    private String Model;

    /** IPv4地址 */
    @JsonProperty("IPAddr")
    @ApiModelProperty(value = "IPv4地址", position = 5)
    @Column("IPAddr")
    private String IPAddr;

    /** IPv6地址 */
    @JsonProperty("IPV6Addr")
    @ApiModelProperty(value = "IPv6地址", position = 6)
    @Column("IPV6Addr")
    private String IPV6Addr;

    /** 网络端口号 */
    @JsonProperty("Port")
    @ApiModelProperty(value = "网络端口号", position = 7)
    @Column("Port")
    private Integer Port;

    /** 经度（-180~180，保留6位小数） */
    @JsonProperty("Longitude")
    @ApiModelProperty(value = "经度（-180~180，保留6位小数）", position = 8)
    @Column("Longitude")
    private BigDecimal Longitude;

    /** 纬度（-90~90，保留6位小数） */
    @JsonProperty("Latitude")
    @ApiModelProperty(value = "纬度（-90~90，保留6位小数）", position = 9)
    @Column("Latitude")
    private BigDecimal Latitude;

    /** 安装地点行政区划代码（GB/T 2260） */
    @JsonProperty("PlaceCode")
    @ApiModelProperty(value = "安装地点行政区划代码（GB/T 2260）", position = 10)
    @Column("PlaceCode")
    private String PlaceCode;

    /** 具体位置描述（乡镇街道+街路巷+门楼牌号+详细地址） */
    @JsonProperty("Place")
    @ApiModelProperty(value = "具体位置描述（乡镇街道+街路巷+门楼牌号+详细地址）", position = 11)
    @Column("Place")
    private String Place;

    /** 管辖单位代码 */
    @JsonProperty("OrgCode")
    @ApiModelProperty(value = "管辖单位代码", position = 12)
    @Column("OrgCode")
    private String OrgCode;

    /** 车辆抓拍方向：0=拍车头，1=拍车尾，兼容无视频卡口信息设备 */
    @JsonProperty("CapDirection")
    @ApiModelProperty(value = "车辆抓拍方向：0=拍车头，1=拍车尾，兼容无视频卡口信息设备", position = 13)
    @Column("CapDirection")
    private Integer CapDirection;

    /** 监视方向（如东、东北） */
    @JsonProperty("MonitorDirection")
    @ApiModelProperty(value = "监视方向（如东、东北）", position = 14)
    @Column("MonitorDirection")
    private String MonitorDirection;

    /** 监视区域说明 */
    @JsonProperty("MonitorAreaDesc")
    @ApiModelProperty(value = "监视区域说明", position = 15)
    @Column("MonitorAreaDesc")
    private String MonitorAreaDesc;

    /** 设备在线状态：1=在线，0=离线 */
    @JsonProperty("IsOnline")
    @ApiModelProperty(value = "设备在线状态：1=在线，0=离线", position = 16)
    @Column("IsOnline")
    private Integer IsOnline;

    /** 所属采集系统设备ID */
    @JsonProperty("OwnerApsID")
    @ApiModelProperty(value = "所属采集系统设备ID", position = 17)
    @Column("OwnerApsID")
    private String OwnerApsID;

    /** 设备登录账号 */
    @JsonProperty("UserId")
    @ApiModelProperty(value = "设备登录账号", position = 18)
    @Column("UserId")
    private String UserId;

    /** 设备登录密码（建议加密存储） */
    @JsonProperty("Password")
    @ApiModelProperty(value = "设备登录密码（建议加密存储）", position = 19)
    @Column("Password")
    private String Password;

    /** 功能类型（多选，/分隔：1=车辆卡口,2=人员卡口,3=微卡口,4=特征摄像机,5=普通监控,6=高空瞭望摄像机,99=其他） */
    @JsonProperty("FunctionType")
    @ApiModelProperty(value = "功能类型（多选，/分隔：1=车辆卡口,2=人员卡口,3=微卡口,4=特征摄像机,5=普通监控,6=高空瞭望摄像机,99=其他）", position = 20)
    @Column("FunctionType")
    private String FunctionType;

    /** 位置类型（多选，/分隔：1=省际检查站,2=党政机关,3=车站码头,4=中心广场,5=体育场馆,6=商业中心,7=宗教场所,8=校园周边,9=治安复杂区域,10=交通干线,11=医院周边,12=金融机构周边,13=危险物品场所周边,14=博物馆展览馆,15=重点水域、航道,96=市际公安检查站,97=涉外场所,98=边境沿线,99=旅游景区） */
    @JsonProperty("PositionType")
    @ApiModelProperty(value = "位置类型（多选，/分隔：1=省际检查站,2=党政机关,3=车站码头,4=中心广场,5=体育场馆,6=商业中心,7=宗教场所,8=校园周边,9=治安复杂区域,10=交通干线,11=医院周边,12=金融机构周边,13=危险物品场所周边,14=博物馆展览馆,15=重点水域、航道,96=市际公安检查站,97=涉外场所,98=边境沿线,99=旅游景区）", position = 21)
    @Column("PositionType")
    private String PositionType;

    /** 记录创建时间 */
    @JsonProperty("CreateTime")
    @ApiModelProperty(value = "记录创建时间", position = 22)
    private Date CreateTime;

    /** 记录最后更新时间 */
    @JsonProperty("UpdateTime")
    @ApiModelProperty(value = "记录最后更新时间", position = 23)
    private Date UpdateTime;

}
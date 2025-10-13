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
package com.fliad.viid.modular.tollgate.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import org.noear.solon.validation.annotation.NotBlank;
import org.noear.solon.validation.annotation.NotNull;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 视频卡口编辑参数
 *
 * @author wyl
 * @date  2025/09/19
 **/
@Getter
@Setter
public class ViidTollgateEditParam {

    /** 主键ID */
    @ApiModelProperty(value = "主键ID", position = 1)
    private String ID;

    /** 卡口ID，全局唯一标识，对应DeviceIDType类型，必选字段 */
    @ApiModelProperty(value = "卡口ID，全局唯一标识，对应DeviceIDType类型，必选字段", required = true, position = 2)
    @NotBlank(message = "tollgateId不能为空")
    private String TollgateID;

    /** 卡口名称，对应DeviceNameType类型，必选字段 */
    @ApiModelProperty(value = "卡口名称，对应DeviceNameType类型，必选字段", required = true, position = 3)
    @NotBlank(message = "name不能为空")
    private String Name;

    /** 卡口经度，对应LongitudeType类型，必选字段 */
    @ApiModelProperty(value = "卡口经度，对应LongitudeType类型，必选字段", required = true, position = 4)
    @NotNull(message = "longitude不能为空")
    private BigDecimal Longitude;

    /** 卡口纬度，对应LatitudeType类型，必选字段 */
    @ApiModelProperty(value = "卡口纬度，对应LatitudeType类型，必选字段", required = true, position = 5)
    @NotNull(message = "latitude不能为空")
    private BigDecimal Latitude;

    /** 安装地点行政区划代码，对应PlaceCodeType类型，必选字段 */
    @ApiModelProperty(value = "安装地点行政区划代码，对应PlaceCodeType类型，必选字段", required = true, position = 6)
    @NotBlank(message = "placeCode不能为空")
    private String PlaceCode;

    /** 位置名，具体到位置或街道门牌号，由(乡镇街道)+(街路巷)+(门牌号)+(门楼详细地址)构成，可选字段 */
    @ApiModelProperty(value = "位置名，具体到位置或街道门牌号，由(乡镇街道)+(街路巷)+(门牌号)+(门楼详细地址)构成，可选字段", position = 7)
    private String Place;

    /** 卡口状态，1-正常，2-停用，9-其他，对应StatusType类型，必选字段 */
    @ApiModelProperty(value = "卡口状态，1-正常，2-停用，9-其他，对应StatusType类型，必选字段", required = true, position = 8)
    @NotNull(message = "status不能为空")
    private Integer Status;

    /** 卡口类型，对应TollgateType类型，必选字段 */
    @ApiModelProperty(value = "卡口类型，对应TollgateType类型，必选字段", required = true, position = 9)
    @NotBlank(message = "tollgateCat不能为空")
    private String TollgateCat;

    /** 卡口用途，80-治安卡口，81-交通卡口，82-其他，必选字段 */
    @ApiModelProperty(value = "卡口用途，80-治安卡口，81-交通卡口，82-其他，必选字段", required = true, position = 10)
    @NotNull(message = "tollgateUsage不能为空")
    private Integer TollgateUsage;

    /** 卡口车道数，整数类型，可选字段 */
    @ApiModelProperty(value = "卡口车道数，整数类型，可选字段", position = 11)
    private Integer LaneNum;

    /** 管辖单位代码，对应OrgCodeType类型，可选字段 */
    @ApiModelProperty(value = "管辖单位代码，对应OrgCodeType类型，可选字段", position = 12)
    private String OrgCode;

    /** 卡口启用时间，启用时间之后的数据有效，可选字段 */
    @ApiModelProperty(value = "卡口启用时间，启用时间之后的数据有效，可选字段", position = 13)
    private Date ActiveTime;

}
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
package com.fliad.viid.modular.ape.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import org.noear.solon.validation.annotation.NotBlank;
import org.noear.solon.validation.annotation.NotNull;

import java.math.BigDecimal;

/**
 * 采集设备添加参数
 *
 * @author wyl
 * @date  2025/09/19
 **/
@Getter
@Setter
public class ViidApeAddParam {

    /** 设备唯一标识（DeviceIDType） */
    @ApiModelProperty(value = "设备唯一标识（DeviceIDType）", required = true, position = 2)
    @NotBlank(message = "ApeId不能为空")
    private String ApeID;

    /** 设备名称 */
    @ApiModelProperty(value = "设备名称", required = true, position = 3)
    @NotBlank(message = "Name不能为空")
    private String Name;

    /** 设备型号 */
    @ApiModelProperty(value = "设备型号", required = true, position = 4)
    @NotBlank(message = "Model不能为空")
    private String Model;

    /** IPv4地址 */
    @ApiModelProperty(value = "IPv4地址", required = true, position = 5)
    @NotBlank(message = "IPAddr不能为空")
    private String IPAddr;

    /** IPv6地址 */
    @ApiModelProperty(value = "IPv6地址", position = 6)
    private String IPV6Addr;

    /** 网络端口号 */
    @ApiModelProperty(value = "网络端口号", required = true, position = 7)
    @NotNull(message = "Port不能为空")
    private Integer Port;

    /** 经度（-180~180，保留6位小数） */
    @ApiModelProperty(value = "经度（-180~180，保留6位小数）", required = true, position = 8)
    @NotNull(message = "Longitude不能为空")
    private BigDecimal Longitude;

    /** 纬度（-90~90，保留6位小数） */
    @ApiModelProperty(value = "纬度（-90~90，保留6位小数）", required = true, position = 9)
    @NotNull(message = "Latitude不能为空")
    private BigDecimal Latitude;

    /** 安装地点行政区划代码（GB/T 2260） */
    @ApiModelProperty(value = "安装地点行政区划代码（GB/T 2260）", required = true, position = 10)
    @NotBlank(message = "PlaceCode不能为空")
    private String PlaceCode;

    /** 具体位置描述（乡镇街道+街路巷+门楼牌号+详细地址） */
    @ApiModelProperty(value = "具体位置描述（乡镇街道+街路巷+门楼牌号+详细地址）", position = 11)
    private String Place;

    /** 管辖单位代码 */
    @ApiModelProperty(value = "管辖单位代码", position = 12)
    private String OrgCode;

    /** 车辆抓拍方向：0=拍车头，1=拍车尾，兼容无视频卡口信息设备 */
    @ApiModelProperty(value = "车辆抓拍方向：0=拍车头，1=拍车尾，兼容无视频卡口信息设备", position = 13)
    private Integer CapDirection;

    /** 监视方向（如东、东北） */
    @ApiModelProperty(value = "监视方向（如东、东北）", position = 14)
    private String MonitorDirection;

    /** 监视区域说明 */
    @ApiModelProperty(value = "监视区域说明", position = 15)
    private String MonitorAreaDesc;

    /** 所属采集系统设备ID */
    @ApiModelProperty(value = "所属采集系统设备ID", position = 17)
    private String OwnerApsID;

    /** 设备登录账号 */
    @ApiModelProperty(value = "设备登录账号", position = 18)
    private String UserId;

    /** 设备登录密码（建议加密存储） */
    @ApiModelProperty(value = "设备登录密码（建议加密存储）", position = 19)
    private String Password;

    /** 功能类型（多选，/分隔：1=车辆卡口,2=人员卡口,3=微卡口,4=特征摄像机,5=普通监控,6=高空瞭望摄像机,99=其他） */
    @ApiModelProperty(value = "功能类型（多选，/分隔：1=车辆卡口,2=人员卡口,3=微卡口,4=特征摄像机,5=普通监控,6=高空瞭望摄像机,99=其他）", required = true, position = 20)
    @NotBlank(message = "FunctionType不能为空")
    private String FunctionType;

    /** 位置类型（多选，/分隔：1=省际检查站,2=党政机关,3=车站码头,4=中心广场,5=体育场馆,6=商业中心,7=宗教场所,8=校园周边,9=治安复杂区域,10=交通干线,11=医院周边,12=金融机构周边,13=危险物品场所周边,14=博物馆展览馆,15=重点水域、航道,96=市际公安检查站,97=涉外场所,98=边境沿线,99=旅游景区） */
    @ApiModelProperty(value = "位置类型（多选，/分隔：1=省际检查站,2=党政机关,3=车站码头,4=中心广场,5=体育场馆,6=商业中心,7=宗教场所,8=校园周边,9=治安复杂区域,10=交通干线,11=医院周边,12=金融机构周边,13=危险物品场所周边,14=博物馆展览馆,15=重点水域、航道,96=市际公安检查站,97=涉外场所,98=边境沿线,99=旅游景区）", position = 21)
    private String PositionType;

}
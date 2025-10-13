package com.fliad.viid.modular.cascadeplatform.domain;

import lombok.Data;

/**
 * 图像子对象（参照《视图库对接技术要求》附录A.8）
 * 说明：用于存储车辆相关子图像信息，去除部分必选属性以支持简单图片交互
 */
@Data
public class SubImageInfo {

    // 1. 事件类型（关联图像采集的事件场景，如“卡口抓拍”“案事件标注”，可选）
    private String EventSort;
    // 2. 图像标识（子图像唯一ID，可选，支持简单图片交互场景）
    private String ImageID;
    // 3. 设备编码（采集该子图像的设备ID，必选）
    private String DeviceID;
    // 4. 存储路径（子图像访问URI路径，可选，支持不指定存储路径场景）
    private String StoragePath;
    // 5. 图像类型（参照ImageType定义：01-车辆大图、02-车辆局部图等，必选）
    private String Type;
    // 6. 文件格式（图像文件格式：01-JPG、02-PNG、03-BMP，必选）
    private String FileFormat;
    // 7. 抓拍时间（子图像采集时间，可选，支持非抓拍图片交互）
    private String ShotTime;
    // 8. 图像数据（base64编码的图像二进制数据，可选）
    private String Data;
    // 9. 图像宽度（像素值，可选）
    private Integer Width;
    // 10. 图像高度（像素值，可选）
    private Integer Height;
    // 11. 特征值信息（该子图像对应的特征值数据，可选）
    private FeatureInfo FeatureInfoObject;

}

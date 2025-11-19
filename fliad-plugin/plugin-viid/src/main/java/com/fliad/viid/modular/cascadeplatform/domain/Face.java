package com.fliad.viid.modular.cascadeplatform.domain;

import com.fliad.viid.modular.cascadeplatform.domain.SubImageInfo;

import java.util.List;

/**
 * 人脸对象（参照《视图库对接技术要求(试行)_20180521.pdf》附录A.9）
 * 说明：字段首字母大写，忽略set/get方法，包含人脸基础属性及特征信息，必选（R）/可选（O）参照文档定义
 */
public class Face {

    // 1. 人脸唯一标识（用于区分不同人脸对象，必选）
    private String FaceID;
    // 2. 信息分类（数据采集方式：0-人工采集、1-自动采集，必选）
    private Integer InfoKind;
    // 3. 来源图像标识（关联原始图像/视频的唯一ID，必选）
    private String SourceID;
    // 4. 设备编码（采集人脸的设备编号，自动采集必选，可选）
    private String DeviceID;
    // 5. 人脸区域坐标（图像中人脸外接矩形坐标：左上角X/Y、右下角X/Y，自动采集必选，可选）
    private String FaceRegion;
    // 6. 抓拍时间（人脸被采集的时间，格式：yyyyMMddHHmmss，必选）
    private String CaptureTime;
    // 7. 证件种类（已知身份人脸的证件类型：01-居民身份证、02-护照等，可选）
    private String IDType;
    // 8. 证件号码（对应证件的编号，可选）
    private String IDNumber;
    // 9. 姓名（人脸对应的人员姓名，可选）
    private String Name;
    // 10. 性别（0-未知、1-男、2-女，可选）
    private Integer Gender;
    // 11. 年龄（估算年龄，范围1-150，可选）
    private Integer Age;
    // 12. 民族（参照GB/T 3304-1991，用两位数字编码，可选）
    private String Nation;
    // 13. 国籍（参照GB/T 2659-2000，用三位字母编码，可选）
    private String Nationality;
    // 14. 发型（01-短发、02-长发、03-光头、04-辫子等，可选）
    private String HairStyle;
    // 15. 发色（01-黑色、02-棕色、03-金色等，可选）
    private String HairColor;
    // 16. 脸型（01-圆形、02-方形、03-长形等，可选）
    private String FaceShape;
    // 17. 是否戴眼镜（0-否、1-是，可选）
    private Integer IsGlasses;
    // 18. 是否戴口罩（0-否、1-是，可选）
    private Integer IsMask;
    // 19. 是否戴帽子（0-否、1-是，可选）
    private Integer IsHat;
    // 20. 表情（01-平静、02-微笑、03-愤怒等，可选）
    private String Expression;
    // 21. 姿态（人脸偏转角度：俯仰角、偏航角、翻滚角，可选）
    private String Posture;
    // 22. 人脸质量评分（0-100分，自动采集必选，可选）
    private Integer QualityScore;
    // 23. 特征值（人脸特征提取结果，base64编码，必选）
    private String FeatureData;
    // 24. 特征值算法版本（提取特征值的算法版本，必选）
    private String FeatureVersion;
    // 25. 人脸图像URL（人脸特写图像存储地址，必选）
    private String FaceImageUrl;
    // 26. 全景图像URL（包含人脸的全景图像地址，可选）
    private String PanoramaUrl;
    // 27. 关联人员ID（关联的人员对象唯一标识，可选）
    private String PersonID;
    // 28. 附属信息（其他补充说明，可选）
    private String AttachInfo;
    // 29. 子图像列表（包含人脸不同角度的子图像，可选）
    private List<SubImageInfo> SubImageList;

}
package com.fliad.viid.modular.cascadeplatform.domain;

import lombok.Data;

/**
 * 特征值对象（参照《视图库对接技术要求》附录A.7）
 * 说明：描述不同厂商算法提取的特征值
 */
@Data
public class FeatureInfo {

    // 1. 厂商（提取特征值的算法厂商名称，如“海康威视”“大华”，必选）
    private String Vendor;
    // 2. 算法版本（特征值提取算法的版本号，如“V2.1.0”，必选）
    private String AlgorithmVersion;
    // 3. 特征值数据（base64编码的特征值二进制数据，必选）
    private String FeatureData;

}

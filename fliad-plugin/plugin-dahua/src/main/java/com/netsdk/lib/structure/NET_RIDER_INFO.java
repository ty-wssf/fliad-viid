package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 骑车人信息
public class NET_RIDER_INFO extends NetSDKLib.SdkStructure {
    public int bFeatureValid;                        // 是否识别到特征信息, TRUE时下面数据才有效, 1-true; 0-false
    public int emSex;                                // 性别, 对应枚举  EM_SEX_TYPE
    public int nAge;                                 // 年龄
    public int emHelmet;                             // 头盔状态, 对应枚举  EM_NONMOTOR_OBJECT_STATUS
    public int emCall;                               // 是否在打电话, 对应枚举 EM_NONMOTOR_OBJECT_STATUS
    public int emBag;                                // 是否有背包, 对应枚举 EM_NONMOTOR_OBJECT_STATUS
    public int emCarrierBag;                         // 有没有手提包, 对应枚举 EM_NONMOTOR_OBJECT_STATUS
    public int emUmbrella;                           // 是否打伞, 对应枚举 EM_NONMOTOR_OBJECT_STATUS
    public int emGlasses;                            // 是否有带眼镜, 对应枚举 EM_NONMOTOR_OBJECT_STATUS
    public int emMask;                               // 是否带口罩, 对应枚举 EM_NONMOTOR_OBJECT_STATUS
    public int emEmotion;                            // 表情, 对应枚举 EM_EMOTION_TYPE
    public int emUpClothes;                          // 上衣类型, 对应枚举 EM_CLOTHES_TYPE
    public int emDownClothes;                        // 下衣类型, 对应枚举 EM_CLOTHES_TYPE
    public int emUpperBodyColor;                     // 上衣颜色, 对应枚举 EM_OBJECT_COLOR_TYPE
    public int emLowerBodyColor;                     // 下衣颜色, 对应枚举 EM_OBJECT_COLOR_TYPE
    public int bHasFaceImage;                        // 是否有骑车人人脸抠图信息
    public RIDER_FACE_IMAGE_INFO stuFaceImage = new RIDER_FACE_IMAGE_INFO(); // 骑车人人脸特写描述
    public int bHasFaceAttributes;                   // 是否有人脸属性
    public NET_FACE_ATTRIBUTE_EX stuFaceAttributes = new NET_FACE_ATTRIBUTE_EX(); // 人脸属性
    public int emHasHat;                             //是否戴帽子,参见枚举定义 {@link com.netsdk.lib.NetSDKLib.EM_HAS_HAT}
    public int emCap;                                //帽类型,参见枚举定义 {@link com.netsdk.lib.NetSDKLib.EM_CAP_TYPE}
    public int emHairStyle;                          //头发样式,参见枚举定义 {@link com.netsdk.lib.NetSDKLib.EM_HAIR_STYLE}
    public NET_FACE_FEATURE_VECTOR_INFO stuFaceFeatureVectorInfo = new NET_FACE_FEATURE_VECTOR_INFO(); //目标特征值数据在二进制数据中的位置信息,参见结构体定义 {@link com.netsdk.lib.structure.NET_FACE_FEATURE_VECTOR_INFO}
    public int emFaceFeatureVersion;                 //目标特征值版本号,参见枚举定义 {@link com.netsdk.lib.NetSDKLib.EM_FEATURE_VERSION}
    public NET_HUMAN_FEATURE_VECTOR_INFO stuHumanFeatureVectorInfo = new NET_HUMAN_FEATURE_VECTOR_INFO(); //人体特征值数据在二进制数据中的位置信息,参见结构体定义 {@link com.netsdk.lib.structure.NET_HUMAN_FEATURE_VECTOR_INFO}
    public int emHumanFeatureVersion;                //人体特征值版本号,参见枚举定义 {@link com.netsdk.lib.NetSDKLib.EM_FEATURE_VERSION}
    public int nAgeConf;                             //年龄段置信度
    public int nUpColorConf;                         //上衣颜色置信度
    public int nDownColorConf;                       //下衣颜色置信度
    public int nUpTypeConf;                          //上衣种类置信度
    public int nDownTypeConf;                        //下衣种类置信度
    public int nHatTypeConf;                         //帽子类型置信度
    public int nHairTypeConf;                        //发型种类置信度
    public int emUpperPattern;                       //上半身衣服图案,参见枚举定义 {@link com.netsdk.lib.NetSDKLib.EM_CLOTHES_PATTERN}
    public int nUpClothes;                           //上衣类型 0:未知 1:长袖 2:短袖 3:长款大衣 4:夹克及牛仔服 5:T恤,6:运动装 7:羽绒服 8:衬衫 9:连衣裙 10:西装 11:毛衣 12:无袖 13:背心
    public int emUniformStyle;                       //制服类型,参见枚举定义 {@link com.netsdk.lib.enumeration.EM_UNIFORM_STYLE}
    public int nRainCoat;                            //是否有雨披 0:未识别 1:无 2:有
    public int emCoatStyle;                          //上衣款式,参见枚举定义 {@link com.netsdk.lib.NetSDKLib.EM_COAT_TYPE}
    public int emAgeSeg;                             //年龄段,参见枚举定义 {@link com.netsdk.lib.enumeration.EM_AGE_SEG}
    public int nShoulderBag;                         //是否有肩包 0-未识别 1-无 2-有
    public int nMessengerBag;                        //是否有斜挎包 0-未识别 1-无 2-有
    public int bNewUpClothes;                        //是否支持新上衣类型
    public int emNewUpClothes;                       //新上衣类型,参见枚举定义 {@link com.netsdk.lib.enumeration.EM_NEWUPCLOTHES_TYPE}
    public int bNewDownClothes;                      //是否支持新下衣类型
    public int emNewDownClothes;                     //新下衣类型,参见枚举定义 {@link com.netsdk.lib.enumeration.EM_NEWDOWNCLOTHES_TYPE}
    public NET_HUMAN_RECT stuHumanRect = new NET_HUMAN_RECT();  //骑车人坐标图信息,参见结构体定义 {@link com.netsdk.lib.structure.NET_HUMAN_RECT}
    public byte[] byReserved = new byte[100];           // 保留
}

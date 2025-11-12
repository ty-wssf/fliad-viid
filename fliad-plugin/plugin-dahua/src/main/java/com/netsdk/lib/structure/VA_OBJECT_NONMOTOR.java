package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

// 非机动车对象
public class VA_OBJECT_NONMOTOR extends NetSDKLib.SdkStructure {
    /**
     * 物体ID,每个ID表示一个唯一的物体
     */
    public int nObjectID;
    /**
     * 非机动车子类型
     */
    public int emCategory;
    /**
     * 包围盒， 非机动车矩形框，0~8191相对坐标
     */
    public DH_RECT stuBoundingBox = new DH_RECT();
    /**
     * 包围盒， 非机动车矩形框，绝对坐标
     */
    public DH_RECT stuOriginalBoundingBox = new DH_RECT();
    /**
     * 非机动车颜色, RGBA
     */
    public NET_COLOR_RGBA stuMainColor = new NET_COLOR_RGBA();
    /**
     * 非机动车颜色, 枚举
     */
    public int emColor;
    /**
     * 是否有抠图
     */
    public int bHasImage;
    /**
     * 物体截图
     */
    public NET_NONMOTOR_PIC_INFO stuImage = new NET_NONMOTOR_PIC_INFO();
    /**
     * 骑车人数量
     */
    public int nNumOfCycling;
    /**
     * 骑车人特征,个数和nNumOfCycling关联
     */
    public NET_RIDER_INFO[] stuRiderList = new NET_RIDER_INFO[NetSDKLib.MAX_RIDER_NUM];
    /**
     * 全景广角图
     */
    public SCENE_IMAGE_INFO stuSceneImage = new SCENE_IMAGE_INFO();
    /**
     * 人脸全景广角图
     */
    public FACE_SCENE_IMAGE stuFaceSceneImage = new FACE_SCENE_IMAGE();
    /**
     * 检测到的人脸数量
     */
    public int nNumOfFace;
    /**
     * 物体速度，单位为km/h
     */
    public float fSpeed;
    /**
     * 非机动车特征值数据在二进制数据中的位置信息
     */
    public NET_NONMOTOR_FEATURE_VECTOR_INFO stuNonMotorFeatureVectorInfo = new NET_NONMOTOR_FEATURE_VECTOR_INFO();
    /**
     * 非机动车特征值版本号
     */
    public int emNonMotorFeatureVersion;
    /**
     * 非机动车牌信息
     */
    public NET_NONMOTOR_PLATE_INFO stuNomotorPlateInfo = new NET_NONMOTOR_PLATE_INFO();
    /**
     * 物体型心(不是包围盒中心), 0-8191相对坐标, 相对于大图
     */
    public NET_POINT stuObjCenter = new NET_POINT();
    /**
     * 人脸特征值数据在二进制数据中的位置信息, 废弃
     */
    public NET_FACE_FEATURE_VECTOR_INFO stuFaceFeatureVectorInfo = new NET_FACE_FEATURE_VECTOR_INFO();
    /**
     * 人脸特征值版本号, 废弃
     */
    public int emFaceFeatureVersion;
    /**
     * 非机动车类型置信度
     */
    public int nCategoryConf;
    /**
     * 非机动车特征值版本号-字符串
     */
    public byte[] szNonMotorFeatureVersion = new byte[32];
    /**
     * 非机动车的角度 {@link com.netsdk.lib.enumeration.EM_OBJECT_NONMOTORANGLE_TYPE}
     */
    public int emNonMotorAngle;
    /**
     * 非机动车车篮 {@link com.netsdk.lib.enumeration.EM_OBJECT_BASKET_TYPE}
     */
    public int emBasket;
    /**
     * 非机动车后备箱 {@link com.netsdk.lib.enumeration.EM_OBJECT_STORAGEBOX_TYPE}
     */
    public int emStorageBox;
    /**
     * 非机动车完整度评分，范围[0,100]，越大越完整
     */
    public int nCompleteScore;
    /**
     * 非机动车清晰度分值 取值范围为[1,100], 越大越清晰, 0为无效值
     */
    public int nClarityScore;
    /**
     * 目标出现的帧号
     */
    public int nStartSequence;
    /**
     * 目标消失的帧号
     */
    public int nEndSequence;
    /**
     * 非机动车车身及骑手整体，是否虚检，0: 否，1: 是
     */
    public int bIsErrorDetect;
    /**
     * 图像成像光源类型, 0:未知, 1:可见光成像, 2:近红外成像(灰度图), 3:热红外成像(伪彩色)
     */
    public int nImageLightType;
    /**
     * 非机动车综合质量评分，范围[0,100]，越大质量越好
     */
    public int nAbsScore;
    /**
     * 雨棚（伞）类型 {@link com.netsdk.lib.enumeration.EM_RAIN_SHED_TYPE}
     */
    public int emRainShedType;
    /**
     * 智能物体全局唯一物体标识
     * 有效数据位21位，包含’\0’
     * 前2位%d%d:01-视频片段, 02-图片, 03-文件, 99-其他
     * 中间14位YYYYMMDDhhmmss:年月日时分秒
     * 后5位%u%u%u%u%u：物体ID，如00001
     */
    public byte[] szSerialUUID = new byte[22];
    /**
     * 对齐
     */
    public byte[] szReserved = new byte[2];
    /**
     * 非机动车的骑手和车身是否单独提取, 0:否, 1:是
     */
    public int nHumanFeatureExtractSingle;
    /**
     * 结构化非机动车支持人体图
     */
    public SCENE_IMAGE_INFO stuHumanImage = new SCENE_IMAGE_INFO();
    public int bIsVehicleHumanAssociation;           //是否已经成功完成人车关联
    /**
     * 保留
     */
    public byte[] byReserved = new byte[2844];

    public VA_OBJECT_NONMOTOR() {
        for (int i = 0; i < stuRiderList.length; i++) {
            stuRiderList[i] = new NET_RIDER_INFO();
        }

    }
}

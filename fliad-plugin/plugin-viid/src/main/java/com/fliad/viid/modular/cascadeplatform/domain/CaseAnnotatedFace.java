package com.fliad.viid.modular.cascadeplatform.domain;

import java.util.List;

/**
 * 案事件标注人脸对象（参照文档附录A.11.1，案事件标注场景下的人脸扩展信息）
 */
public class CaseAnnotatedFace {
    // 1. 人脸标识（必选）
    private String FaceID;
    // 2. 信息分类（人工采集/自动采集，必选）
    private String InfoKind;
    // 3. 来源图像信息标识（可选）
    private String SourceID;
    // 4. 设备编码（自动采集必选，可选）
    private String DeviceID;
    // 5. 人脸区域左上角X坐标（自动采集必选，可选）
    private Integer LeftTopX;
    // 6. 人脸区域左上角Y坐标（自动采集必选，可选）
    private Integer LeftTopY;
    // 7. 人脸区域右下角X坐标（自动采集必选，可选）
    private Integer RightBtmX;
    // 8. 人脸区域右下角Y坐标（自动采集必选，可选）
    private Integer RightBtmY;
    // 9. 位置标记时间（可选）
    private String LocationMarkTime;
    // 10. 人脸出现时间（人工采集时有效，可选）
    private String FaceAppearTime;
    // 11. 人脸消失时间（可选）
    private String FaceDisAppearTime;
    // 12. 证件种类（已知身份人脸数据必选，可选）
    private String IDType;
    // 13. 证件号码（已知身份人脸数据必选，可选）
    private String IDNumber;
    // 14. 姓名（已知身份人脸数据必选，可选）
    private String Name;
    // 15. 曾用名（可选）
    private String UsedName;
    // 16. 绰号（可选）
    private String Alias;
    // 17. 性别代码（已知身份人脸数据必选，可选）
    private String GenderCode;
    // 18. 年龄上限（最大可能年龄，可选）
    private Integer AgeUpLimit;
    // 19. 年龄下限（最小可能年龄，可选）
    private Integer AgeLowerLimit;
    // 20. 民族代码（中国各民族罗马字母拼写法和代码，已知身份人脸数据必选，可选）
    private String EthicCode;
    // 21. 国籍代码（世界各国和地区名称代码，可选）
    private String NationalityCode;
    // 22. 籍贯省市县代码（可选）
    private String NativeCityCode;
    // 23. 居住地行政区划（可选）
    private String ResidenceAdminDivision;
    // 24. 汉语口音代码（汉语口音编码规则，可选）
    private String ChineseAccentCode;
    // 25. 职业类别代码（职业分类与代码，不含"&#45;&#45;"，可选）
    private String JobCategoryCode;
    // 26. 同行人脸数（被标注人脸的同行人脸数，可选）
    private Integer AccompanyNumber;
    // 27. 肤色（可选）
    private String SkinColor;
    // 28. 发型（可选）
    private String HairStyle;
    // 29. 发色（可选）
    private String HairColor;
    // 30. 脸型（可选）
    private String FaceStyle;
    // 31. 脸部特征（可选）
    private String FacialFeature;
    // 32. 体貌特征（可选）
    private String PhysicalFeature;
    // 33. 口罩颜色（可选）
    private String RespiratorColor;
    // 34. 帽子款式（可选）
    private String CapStyle;
    // 35. 帽子颜色（可选）
    private String CapColor;
    // 36. 眼镜款式（可选）
    private String GlassStyle;
    // 37. 眼镜颜色（可选）
    private String GlassColor;
    // 38. 是否驾驶员（0:否，1:是，2:不确定，可选）
    private Integer IsDriver;
    // 39. 是否涉外人员（0:否，1:是，2:不确定，可选）
    private Integer IsForeigner;
    // 40. 护照证件种类（可选）
    private String PassportType;
    // 41. 出入境人员类别代码（出入境人员分类代码，可选）
    private String ImmigrantTypeCode;
    // 42. 是否涉恐人员（0:否，1:是，2:不确定，可选）
    private Integer IsSuspectedTerrorist;
    // 43. 涉恐人员编号（可选）
    private String SuspectedTerroristNumber;
    // 44. 是否涉案人员（0:否，1:是，2:不确定，可选）
    private Integer IsCriminalInvolved;
    // 45. 涉案人员专长代码（可选）
    private String CriminalInvolvedSpecilisationCode;
    // 46. 体表特殊标记（可选）
    private String BodySpeciallMark;
    // 47. 作案手段（可选）
    private String CrimeMethod;
    // 48. 作案特点代码（可选）
    private String CrimeCharacterCode;
    // 49. 在逃人员编号（可选）
    private String EscapedCriminalNumber;
    // 50. 是否在押人员（0:否，1:是，2:不确定，人工采集必填，可选）
    private Integer IsDetainees;
    // 51. 看守所编码（可选）
    private String DetentionHouseCode;
    // 52. 在押人员身份（参照文档附录B，可选）
    private String DetaineesIdentity;
    // 53. 在押人员特殊身份（可选）
    private String DetaineesSpecialIdentity;
    // 54. 成员类型代码（可选）
    private String MemberTypeCode;
    // 55. 是否被害人（0:否，1:是，2:不确定，可选）
    private Integer IsVictim;
    // 56. 被害人种类（可选）
    private String VictimType;
    // 57. 受伤害程度（可选）
    private String InjuredDegree;
    // 58. 尸体状况代码（可选）
    private String CorpseConditionCode;
    // 59. 是否可疑人（0:否，1:是，2:不确定，可选）
    private Integer IsSuspiciousPerson;
    // 60. 姿态分布（1:平视，2:微仰，3:微俯，4:左微侧脸，5:左斜侧脸，6:左全侧脸，7:右微侧脸，8:右斜侧脸，9:右全侧脸，可选）
    private Integer Attitude;
    // 61. 人脸相似度（取值范围[0,1]，可选）
    private Double SimilarityDegree;
    // 62. 眉型（多个特征用英文半角分号";"分隔，可选）
    private String EyebrowStyle;
    // 63. 鼻型（多个特征用英文半角分号";"分隔，可选）
    private String NoseStyle;
    // 64. 胡型（可选）
    private String MustacheStyle;
    // 65. 嘴唇（多个特征用英文半角分号";"分隔，可选）
    private String LipStyle;
    // 66. 皱纹眼袋（多个特征用英文半角分号";"分隔，可选）
    private String WrinklePouch;
    // 67. 痤疮色斑（多个特征用英文半角分号";"分隔，可选）
    private String AcneStain;
    // 68. 黑痣胎记（多个特征用英文半角分号";"分隔，可选）
    private String FreckleBirthmark;
    // 69. 疤痕酒窝（多个特征用英文半角分号";"分隔，可选）
    private String ScarDimple;
    // 70. 其他特征（多个特征用英文半角分号";"分隔，可选）
    private String OtherFeature;
    // 71. 图像列表（包含0或多个子图像对象，可选）
    private List<SubImageInfo> SubImageList;
    // 72. 拍摄时间（自动采集时必填，可选）
    private String ShotTime;
    // 73. 特征值列表（人脸特征值列表，可选）
    private List<FeatureInfo> FeatureList;
    // 74. 归属分类标签标识（可选）
    private String TabID;

    public String getFaceID() {
        return FaceID;
    }

    public void setFaceID(String faceID) {
        FaceID = faceID;
    }

    public String getInfoKind() {
        return InfoKind;
    }

    public void setInfoKind(String infoKind) {
        InfoKind = infoKind;
    }

    public String getSourceID() {
        return SourceID;
    }

    public void setSourceID(String sourceID) {
        SourceID = sourceID;
    }

    public String getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(String deviceID) {
        DeviceID = deviceID;
    }

    public Integer getLeftTopX() {
        return LeftTopX;
    }

    public void setLeftTopX(Integer leftTopX) {
        LeftTopX = leftTopX;
    }

    public Integer getLeftTopY() {
        return LeftTopY;
    }

    public void setLeftTopY(Integer leftTopY) {
        LeftTopY = leftTopY;
    }

    public Integer getRightBtmX() {
        return RightBtmX;
    }

    public void setRightBtmX(Integer rightBtmX) {
        RightBtmX = rightBtmX;
    }

    public Integer getRightBtmY() {
        return RightBtmY;
    }

    public void setRightBtmY(Integer rightBtmY) {
        RightBtmY = rightBtmY;
    }

    public String getLocationMarkTime() {
        return LocationMarkTime;
    }

    public void setLocationMarkTime(String locationMarkTime) {
        LocationMarkTime = locationMarkTime;
    }

    public String getFaceAppearTime() {
        return FaceAppearTime;
    }

    public void setFaceAppearTime(String faceAppearTime) {
        FaceAppearTime = faceAppearTime;
    }

    public String getFaceDisAppearTime() {
        return FaceDisAppearTime;
    }

    public void setFaceDisAppearTime(String faceDisAppearTime) {
        FaceDisAppearTime = faceDisAppearTime;
    }

    public String getIDType() {
        return IDType;
    }

    public void setIDType(String IDType) {
        this.IDType = IDType;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsedName() {
        return UsedName;
    }

    public void setUsedName(String usedName) {
        UsedName = usedName;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String alias) {
        Alias = alias;
    }

    public String getGenderCode() {
        return GenderCode;
    }

    public void setGenderCode(String genderCode) {
        GenderCode = genderCode;
    }

    public Integer getAgeUpLimit() {
        return AgeUpLimit;
    }

    public void setAgeUpLimit(Integer ageUpLimit) {
        AgeUpLimit = ageUpLimit;
    }

    public Integer getAgeLowerLimit() {
        return AgeLowerLimit;
    }

    public void setAgeLowerLimit(Integer ageLowerLimit) {
        AgeLowerLimit = ageLowerLimit;
    }

    public String getEthicCode() {
        return EthicCode;
    }

    public void setEthicCode(String ethicCode) {
        EthicCode = ethicCode;
    }

    public String getNationalityCode() {
        return NationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        NationalityCode = nationalityCode;
    }

    public String getNativeCityCode() {
        return NativeCityCode;
    }

    public void setNativeCityCode(String nativeCityCode) {
        NativeCityCode = nativeCityCode;
    }

    public String getResidenceAdminDivision() {
        return ResidenceAdminDivision;
    }

    public void setResidenceAdminDivision(String residenceAdminDivision) {
        ResidenceAdminDivision = residenceAdminDivision;
    }

    public String getChineseAccentCode() {
        return ChineseAccentCode;
    }

    public void setChineseAccentCode(String chineseAccentCode) {
        ChineseAccentCode = chineseAccentCode;
    }

    public String getJobCategoryCode() {
        return JobCategoryCode;
    }

    public void setJobCategoryCode(String jobCategoryCode) {
        JobCategoryCode = jobCategoryCode;
    }

    public Integer getAccompanyNumber() {
        return AccompanyNumber;
    }

    public void setAccompanyNumber(Integer accompanyNumber) {
        AccompanyNumber = accompanyNumber;
    }

    public String getSkinColor() {
        return SkinColor;
    }

    public void setSkinColor(String skinColor) {
        SkinColor = skinColor;
    }

    public String getHairStyle() {
        return HairStyle;
    }

    public void setHairStyle(String hairStyle) {
        HairStyle = hairStyle;
    }

    public String getHairColor() {
        return HairColor;
    }

    public void setHairColor(String hairColor) {
        HairColor = hairColor;
    }

    public String getFaceStyle() {
        return FaceStyle;
    }

    public void setFaceStyle(String faceStyle) {
        FaceStyle = faceStyle;
    }

    public String getFacialFeature() {
        return FacialFeature;
    }

    public void setFacialFeature(String facialFeature) {
        FacialFeature = facialFeature;
    }

    public String getPhysicalFeature() {
        return PhysicalFeature;
    }

    public void setPhysicalFeature(String physicalFeature) {
        PhysicalFeature = physicalFeature;
    }

    public String getRespiratorColor() {
        return RespiratorColor;
    }

    public void setRespiratorColor(String respiratorColor) {
        RespiratorColor = respiratorColor;
    }

    public String getCapStyle() {
        return CapStyle;
    }

    public void setCapStyle(String capStyle) {
        CapStyle = capStyle;
    }

    public String getCapColor() {
        return CapColor;
    }

    public void setCapColor(String capColor) {
        CapColor = capColor;
    }

    public String getGlassStyle() {
        return GlassStyle;
    }

    public void setGlassStyle(String glassStyle) {
        GlassStyle = glassStyle;
    }

    public String getGlassColor() {
        return GlassColor;
    }

    public void setGlassColor(String glassColor) {
        GlassColor = glassColor;
    }

    public Integer getIsDriver() {
        return IsDriver;
    }

    public void setIsDriver(Integer isDriver) {
        IsDriver = isDriver;
    }

    public Integer getIsForeigner() {
        return IsForeigner;
    }

    public void setIsForeigner(Integer isForeigner) {
        IsForeigner = isForeigner;
    }

    public String getPassportType() {
        return PassportType;
    }

    public void setPassportType(String passportType) {
        PassportType = passportType;
    }

    public String getImmigrantTypeCode() {
        return ImmigrantTypeCode;
    }

    public void setImmigrantTypeCode(String immigrantTypeCode) {
        ImmigrantTypeCode = immigrantTypeCode;
    }

    public Integer getIsSuspectedTerrorist() {
        return IsSuspectedTerrorist;
    }

    public void setIsSuspectedTerrorist(Integer isSuspectedTerrorist) {
        IsSuspectedTerrorist = isSuspectedTerrorist;
    }

    public String getSuspectedTerroristNumber() {
        return SuspectedTerroristNumber;
    }

    public void setSuspectedTerroristNumber(String suspectedTerroristNumber) {
        SuspectedTerroristNumber = suspectedTerroristNumber;
    }

    public Integer getIsCriminalInvolved() {
        return IsCriminalInvolved;
    }

    public void setIsCriminalInvolved(Integer isCriminalInvolved) {
        IsCriminalInvolved = isCriminalInvolved;
    }

    public String getCriminalInvolvedSpecilisationCode() {
        return CriminalInvolvedSpecilisationCode;
    }

    public void setCriminalInvolvedSpecilisationCode(String criminalInvolvedSpecilisationCode) {
        CriminalInvolvedSpecilisationCode = criminalInvolvedSpecilisationCode;
    }

    public String getBodySpeciallMark() {
        return BodySpeciallMark;
    }

    public void setBodySpeciallMark(String bodySpeciallMark) {
        BodySpeciallMark = bodySpeciallMark;
    }

    public String getCrimeMethod() {
        return CrimeMethod;
    }

    public void setCrimeMethod(String crimeMethod) {
        CrimeMethod = crimeMethod;
    }

    public String getCrimeCharacterCode() {
        return CrimeCharacterCode;
    }

    public void setCrimeCharacterCode(String crimeCharacterCode) {
        CrimeCharacterCode = crimeCharacterCode;
    }

    public String getEscapedCriminalNumber() {
        return EscapedCriminalNumber;
    }

    public void setEscapedCriminalNumber(String escapedCriminalNumber) {
        EscapedCriminalNumber = escapedCriminalNumber;
    }

    public Integer getIsDetainees() {
        return IsDetainees;
    }

    public void setIsDetainees(Integer isDetainees) {
        IsDetainees = isDetainees;
    }

    public String getDetentionHouseCode() {
        return DetentionHouseCode;
    }

    public void setDetentionHouseCode(String detentionHouseCode) {
        DetentionHouseCode = detentionHouseCode;
    }

    public String getDetaineesIdentity() {
        return DetaineesIdentity;
    }

    public void setDetaineesIdentity(String detaineesIdentity) {
        DetaineesIdentity = detaineesIdentity;
    }

    public String getDetaineesSpecialIdentity() {
        return DetaineesSpecialIdentity;
    }

    public void setDetaineesSpecialIdentity(String detaineesSpecialIdentity) {
        DetaineesSpecialIdentity = detaineesSpecialIdentity;
    }

    public String getMemberTypeCode() {
        return MemberTypeCode;
    }

    public void setMemberTypeCode(String memberTypeCode) {
        MemberTypeCode = memberTypeCode;
    }

    public Integer getIsVictim() {
        return IsVictim;
    }

    public void setIsVictim(Integer isVictim) {
        IsVictim = isVictim;
    }

    public String getVictimType() {
        return VictimType;
    }

    public void setVictimType(String victimType) {
        VictimType = victimType;
    }

    public String getInjuredDegree() {
        return InjuredDegree;
    }

    public void setInjuredDegree(String injuredDegree) {
        InjuredDegree = injuredDegree;
    }

    public String getCorpseConditionCode() {
        return CorpseConditionCode;
    }

    public void setCorpseConditionCode(String corpseConditionCode) {
        CorpseConditionCode = corpseConditionCode;
    }

    public Integer getIsSuspiciousPerson() {
        return IsSuspiciousPerson;
    }

    public void setIsSuspiciousPerson(Integer isSuspiciousPerson) {
        IsSuspiciousPerson = isSuspiciousPerson;
    }

    public Integer getAttitude() {
        return Attitude;
    }

    public void setAttitude(Integer attitude) {
        Attitude = attitude;
    }

    public Double getSimilarityDegree() {
        return SimilarityDegree;
    }

    public void setSimilarityDegree(Double similarityDegree) {
        SimilarityDegree = similarityDegree;
    }

    public String getEyebrowStyle() {
        return EyebrowStyle;
    }

    public void setEyebrowStyle(String eyebrowStyle) {
        EyebrowStyle = eyebrowStyle;
    }

    public String getNoseStyle() {
        return NoseStyle;
    }

    public void setNoseStyle(String noseStyle) {
        NoseStyle = noseStyle;
    }

    public String getMustacheStyle() {
        return MustacheStyle;
    }

    public void setMustacheStyle(String mustacheStyle) {
        MustacheStyle = mustacheStyle;
    }

    public String getLipStyle() {
        return LipStyle;
    }

    public void setLipStyle(String lipStyle) {
        LipStyle = lipStyle;
    }

    public String getWrinklePouch() {
        return WrinklePouch;
    }

    public void setWrinklePouch(String wrinklePouch) {
        WrinklePouch = wrinklePouch;
    }

    public String getAcneStain() {
        return AcneStain;
    }

    public void setAcneStain(String acneStain) {
        AcneStain = acneStain;
    }

    public String getFreckleBirthmark() {
        return FreckleBirthmark;
    }

    public void setFreckleBirthmark(String freckleBirthmark) {
        FreckleBirthmark = freckleBirthmark;
    }

    public String getScarDimple() {
        return ScarDimple;
    }

    public void setScarDimple(String scarDimple) {
        ScarDimple = scarDimple;
    }

    public String getOtherFeature() {
        return OtherFeature;
    }

    public void setOtherFeature(String otherFeature) {
        OtherFeature = otherFeature;
    }

    public List<SubImageInfo> getSubImageList() {
        return SubImageList;
    }

    public void setSubImageList(List<SubImageInfo> subImageList) {
        SubImageList = subImageList;
    }

    public String getShotTime() {
        return ShotTime;
    }

    public void setShotTime(String shotTime) {
        ShotTime = shotTime;
    }

    public List<FeatureInfo> getFeatureList() {
        return FeatureList;
    }

    public void setFeatureList(List<FeatureInfo> featureList) {
        FeatureList = featureList;
    }

    public String getTabID() {
        return TabID;
    }

    public void setTabID(String tabID) {
        TabID = tabID;
    }
}
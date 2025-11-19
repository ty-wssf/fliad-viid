package com.fliad.viid.modular.cascadeplatform.domain;

import java.util.List;

/**
 * 案事件标注人员对象（参照文档附录A.11.2，案事件标注场景下的人员扩展信息）
 */
public class CaseAnnotatedPerson {

    // 1. 人员标识（必选）
    private String PersonID;
    // 2. 信息分类（人工采集/自动采集，必选）
    private String InfoKind;
    // 3. 来源图像信息标识（必选）
    private String SourceID;
    // 4. 设备编码（自动采集必选，可选）
    private String DeviceID;
    // 5. 人员轮廓左上角X坐标（自动采集必选，可选）
    private Integer LeftTopX;
    // 6. 人员轮廓左上角Y坐标（自动采集必选，可选）
    private Integer LeftTopY;
    // 7. 人员轮廓右下角X坐标（自动采集必选，可选）
    private Integer RightBtmX;
    // 8. 人员轮廓右下角Y坐标（自动采集必选，可选）
    private Integer RightBtmY;
    // 9. 位置标记时间（人工采集时有效，可选）
    private String LocationMarkTime;
    // 10. 人员出现时间（可选）
    private String PersonAppearTime;
    // 11. 人员消失时间（可选）
    private String PersonDisAppearTime;
    // 12. 证件种类（可选）
    private String IDType;
    // 13. 证件号码（有效证件号码，可选）
    private String IDNumber;
    // 14. 姓名（人员中文姓名全称，可选）
    private String Name;
    // 15. 曾用名（可选）
    private String UsedName;
    // 16. 绰号（可选）
    private String Alias;
    // 17. 性别代码（可选）
    private String GenderCode;
    // 18. 年龄上限（最大可能年龄，可选）
    private Integer AgeUpLimit;
    // 19. 年龄下限（最小可能年龄，可选）
    private Integer AgeLowerLimit;
    // 20. 民族代码（中国各民族罗马字母拼写法和代码，可选）
    private String EthicCode;
    // 21. 国籍代码（世界各国和地区名称代码，可选）
    private String NationalityCode;
    // 22. 籍贯省市县代码（可选）
    private String NativeCityCode;
    // 23. 居住地行政区划（可选）
    private String ResidenceAdminDivision;
    // 24. 汉语口音代码（汉语口音编码规则，可选）
    private String ChineseAccentCode;
    // 25. 单位名称（人员所在工作单位，可选）
    private String PersonOrg;
    // 26. 职业类别代码（职业分类与代码，不含"&#45;&#45;"，可选）
    private String JobCategory;
    // 27. 同行人数（被标注人的同行人数，可选）
    private Integer AccompanyNumber;
    // 28. 身高上限（单位：cm，可选）
    private Integer HeightUpLimit;
    // 29. 身高下限（单位：cm，可选）
    private Integer HeightLowerLimit;
    // 30. 体型（可选）
    private String BodyType;
    // 31. 肤色（可选）
    private String SkinColor;
    // 32. 发型（可选）
    private String HairStyle;
    // 33. 发色（可选）
    private String HairColor;
    // 34. 姿态（可选）
    private String Gesture;
    // 35. 状态（可选）
    private String Status;
    // 36. 脸型（可选）
    private String FaceStyle;
    // 37. 脸部特征（可选）
    private String FacialFeature;
    // 38. 体貌特征（可选）
    private String PhysicalFeature;
    // 39. 体表特征（可选）
    private String BodyFeature;
    // 40. 习惯动作（可选）
    private String HabitualMovement;
    // 41. 行为（可选）
    private String Behavior;
    // 42. 行为描述（可选）
    private String BehaviorDescription;
    // 43. 附属物（多个用英文半角分号";"分隔，可选）
    private String Appendant;
    // 44. 附属物描述（可选）
    private String AppendantDescription;
    // 45. 伞颜色（可选）
    private String UmbrellaColor;
    // 46. 口罩颜色（可选）
    private String RespiratorColor;
    // 47. 帽子款式（可选）
    private String CapStyle;
    // 48. 帽子颜色（可选）
    private String CapColor;
    // 49. 眼镜款式（可选）
    private String GlassStyle;
    // 50. 眼镜颜色（可选）
    private String GlassColor;
    // 51. 围巾颜色（可选）
    private String ScarfColor;
    // 52. 包款式（可选）
    private String BagStyle;
    // 53. 包颜色（可选）
    private String BagColor;
    // 54. 上衣款式（可选）
    private String CoatStyle;
    // 55. 上衣长度（可选）
    private String CoatLength;
    // 56. 上衣颜色（可选）
    private String CoatColor;
    // 57. 裤子款式（可选）
    private String TrousersStyle;
    // 58. 裤子颜色（可选）
    private String TrousersColor;
    // 59. 裤子长度（可选）
    private String TrousersLen;
    // 60. 鞋子款式（可选）
    private String ShoesStyle;
    // 61. 鞋子颜色（可选）
    private String ShoesColor;
    // 62. 是否驾驶员（0:否，1:是，2:不确定，人工采集必选，可选）
    private Integer IsDriver;
    // 63. 是否涉外人员（0:否，1:是，2:不确定，可选）
    private Integer IsForeigner;
    // 64. 护照证件种类（可选）
    private String PassportType;
    // 65. 出入境人员类别代码（出入境人员分类代码，可选）
    private String ImmigrantTypeCode;
    // 66. 是否涉恐人员（0:否，1:是，2:不确定，可选）
    private Integer IsSuspectedTerrorist;
    // 67. 涉恐人员编号（可选）
    private String SuspectedTerroristNumber;
    // 68. 是否涉案人员（0:否，1:是，2:不确定，可选）
    private Integer IsCriminalInvolved;
    // 69. 涉案人员专长代码（可选）
    private String CriminalInvolvedSpecilisationCode;
    // 70. 体表特殊标记（可选）
    private String BodySpeciallMark;
    // 71. 作案手段（可选）
    private String CrimeMethod;
    // 72. 作案特点代码（可选）
    private String CrimeCharacterCode;
    // 73. 在逃人员编号（可选）
    private String EscapedCriminalNumber;
    // 74. 是否在押人员（0:否，1:是，2:不确定，人工采集必填，可选）
    private Integer IsDetainees;
    // 75. 看守所编码（可选）
    private String DetentionHouseCode;
    // 76. 在押人员身份（参照文档附录B，可选）
    private String DetaineesIdentity;
    // 77. 在押人员特殊身份（可选）
    private String DetaineesSpecialIdentity;
    // 78. 成员类型代码（可选）
    private String MemberTypeCode;
    // 79. 是否被害人（0:否，1:是，2:不确定，人工采集必选，可选）
    private Integer IsVictim;
    // 80. 被害人种类（可选）
    private String VictimType;
    // 81. 受伤害程度（可选）
    private String InjuredDegree;
    // 82. 尸体状况代码（可选）
    private String CorpseConditionCode;
    // 83. 是否可疑人（0:否，1:是，2:不确定，人工采集必选，可选）
    private Integer IsSuspiciousPerson;
    // 84. 图像列表（包含0或多个子图像对象，可选）
    private List<SubImageInfo> SubImageList;
    // 85. 特征值列表（可选）
    private List<FeatureInfo> FeatureList;
    // 86. 归属分类标签标识（可选）
    private String TabID;

    public String getPersonID() {
        return PersonID;
    }

    public void setPersonID(String personID) {
        PersonID = personID;
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

    public String getPersonAppearTime() {
        return PersonAppearTime;
    }

    public void setPersonAppearTime(String personAppearTime) {
        PersonAppearTime = personAppearTime;
    }

    public String getPersonDisAppearTime() {
        return PersonDisAppearTime;
    }

    public void setPersonDisAppearTime(String personDisAppearTime) {
        PersonDisAppearTime = personDisAppearTime;
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

    public String getPersonOrg() {
        return PersonOrg;
    }

    public void setPersonOrg(String personOrg) {
        PersonOrg = personOrg;
    }

    public String getJobCategory() {
        return JobCategory;
    }

    public void setJobCategory(String jobCategory) {
        JobCategory = jobCategory;
    }

    public Integer getAccompanyNumber() {
        return AccompanyNumber;
    }

    public void setAccompanyNumber(Integer accompanyNumber) {
        AccompanyNumber = accompanyNumber;
    }

    public Integer getHeightUpLimit() {
        return HeightUpLimit;
    }

    public void setHeightUpLimit(Integer heightUpLimit) {
        HeightUpLimit = heightUpLimit;
    }

    public Integer getHeightLowerLimit() {
        return HeightLowerLimit;
    }

    public void setHeightLowerLimit(Integer heightLowerLimit) {
        HeightLowerLimit = heightLowerLimit;
    }

    public String getBodyType() {
        return BodyType;
    }

    public void setBodyType(String bodyType) {
        BodyType = bodyType;
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

    public String getGesture() {
        return Gesture;
    }

    public void setGesture(String gesture) {
        Gesture = gesture;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
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

    public String getBodyFeature() {
        return BodyFeature;
    }

    public void setBodyFeature(String bodyFeature) {
        BodyFeature = bodyFeature;
    }

    public String getHabitualMovement() {
        return HabitualMovement;
    }

    public void setHabitualMovement(String habitualMovement) {
        HabitualMovement = habitualMovement;
    }

    public String getBehavior() {
        return Behavior;
    }

    public void setBehavior(String behavior) {
        Behavior = behavior;
    }

    public String getBehaviorDescription() {
        return BehaviorDescription;
    }

    public void setBehaviorDescription(String behaviorDescription) {
        BehaviorDescription = behaviorDescription;
    }

    public String getAppendant() {
        return Appendant;
    }

    public void setAppendant(String appendant) {
        Appendant = appendant;
    }

    public String getAppendantDescription() {
        return AppendantDescription;
    }

    public void setAppendantDescription(String appendantDescription) {
        AppendantDescription = appendantDescription;
    }

    public String getUmbrellaColor() {
        return UmbrellaColor;
    }

    public void setUmbrellaColor(String umbrellaColor) {
        UmbrellaColor = umbrellaColor;
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

    public String getScarfColor() {
        return ScarfColor;
    }

    public void setScarfColor(String scarfColor) {
        ScarfColor = scarfColor;
    }

    public String getBagStyle() {
        return BagStyle;
    }

    public void setBagStyle(String bagStyle) {
        BagStyle = bagStyle;
    }

    public String getBagColor() {
        return BagColor;
    }

    public void setBagColor(String bagColor) {
        BagColor = bagColor;
    }

    public String getCoatStyle() {
        return CoatStyle;
    }

    public void setCoatStyle(String coatStyle) {
        CoatStyle = coatStyle;
    }

    public String getCoatLength() {
        return CoatLength;
    }

    public void setCoatLength(String coatLength) {
        CoatLength = coatLength;
    }

    public String getCoatColor() {
        return CoatColor;
    }

    public void setCoatColor(String coatColor) {
        CoatColor = coatColor;
    }

    public String getTrousersStyle() {
        return TrousersStyle;
    }

    public void setTrousersStyle(String trousersStyle) {
        TrousersStyle = trousersStyle;
    }

    public String getTrousersColor() {
        return TrousersColor;
    }

    public void setTrousersColor(String trousersColor) {
        TrousersColor = trousersColor;
    }

    public String getTrousersLen() {
        return TrousersLen;
    }

    public void setTrousersLen(String trousersLen) {
        TrousersLen = trousersLen;
    }

    public String getShoesStyle() {
        return ShoesStyle;
    }

    public void setShoesStyle(String shoesStyle) {
        ShoesStyle = shoesStyle;
    }

    public String getShoesColor() {
        return ShoesColor;
    }

    public void setShoesColor(String shoesColor) {
        ShoesColor = shoesColor;
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

    public List<SubImageInfo> getSubImageList() {
        return SubImageList;
    }

    public void setSubImageList(List<SubImageInfo> subImageList) {
        SubImageList = subImageList;
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
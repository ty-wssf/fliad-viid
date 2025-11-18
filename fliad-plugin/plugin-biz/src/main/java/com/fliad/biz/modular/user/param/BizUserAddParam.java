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
package com.fliad.biz.modular.user.param;

import io.swagger.annotations.ApiModelProperty;

import org.noear.solon.validation.annotation.NotBlank;


/**
 * 人员添加参数
 *
 * @author xuyuxiang
 * @date 2022/7/26 15:36
 **/

public class BizUserAddParam {

    /** 账号 */
    @ApiModelProperty(value = "账号", required = true, position = 1)
    @NotBlank(message = "account不能为空")
    private String account;

    /** 姓名 */
    @ApiModelProperty(value = "姓名", required = true, position = 2)
    @NotBlank(message = "name不能为空")
    private String name;

    /** 机构id */
    @ApiModelProperty(value = "机构id", required = true, position = 3)
    @NotBlank(message = "orgId不能为空")
    private String orgId;

    /** 岗位id */
    @ApiModelProperty(value = "岗位id", required = true, position = 4)
    @NotBlank(message = "positionId不能为空")
    private String positionId;

    /** 岗级 */
    @ApiModelProperty(value = "岗级", position = 5)
    private String positionLevel;

    /** 主管id */
    @ApiModelProperty(value = "主管id", position = 6)
    private String directorId;

    /** 头像 */
    @ApiModelProperty(value = "头像，图片base64", position = 7)
    private String avatar;

    /** 签名 */
    @ApiModelProperty(value = "签名，图片base64", position = 8)
    private String signature;

    /** 昵称 */
    @ApiModelProperty(value = "昵称", position = 9)
    private String nickname;

    /** 性别 */
    @ApiModelProperty(value = "性别", position = 10)
    private String gender;

    /** 年龄 */
    @ApiModelProperty(value = "年龄", position = 11)
    private String age;

    /** 出生日期 */
    @ApiModelProperty(value = "出生日期", position = 12)
    private String birthday;

    /** 民族 */
    @ApiModelProperty(value = "民族", position = 13)
    private String nation;

    /** 籍贯 */
    @ApiModelProperty(value = "籍贯", position = 14)
    private String nativePlace;

    /** 家庭住址 */
    @ApiModelProperty(value = "家庭住址", position = 15)
    private String homeAddress;

    /** 通信地址 */
    @ApiModelProperty(value = "通信地址", position = 16)
    private String mailingAddress;

    /** 证件类型 */
    @ApiModelProperty(value = "证件类型", position = 17)
    private String idCardType;

    /** 证件号码 */
    @ApiModelProperty(value = "证件号码", position = 18)
    private String idCardNumber;

    /** 文化程度 */
    @ApiModelProperty(value = "文化程度", position = 19)
    private String cultureLevel;

    /** 政治面貌 */
    @ApiModelProperty(value = "政治面貌", position = 20)
    private String politicalOutlook;

    /** 毕业院校 */
    @ApiModelProperty(value = "毕业院校", position = 21)
    private String college;

    /** 学历 */
    @ApiModelProperty(value = "学历", position = 22)
    private String education;

    /** 学制 */
    @ApiModelProperty(value = "学制", position = 23)
    private String eduLength;

    /** 学位 */
    @ApiModelProperty(value = "学位", position = 24)
    private String degree;

    /** 手机 */
    @ApiModelProperty(value = "手机", position = 25)
    private String phone;

    /** 邮箱 */
    @ApiModelProperty(value = "邮箱", position = 26)
    private String email;

    /** 家庭电话 */
    @ApiModelProperty(value = "家庭电话", position = 27)
    private String homeTel;

    /** 办公电话 */
    @ApiModelProperty(value = "办公电话", position = 28)
    private String officeTel;

    /** 紧急联系人 */
    @ApiModelProperty(value = "紧急联系人", position = 29)
    private String emergencyContact;

    /** 紧急联系人电话 */
    @ApiModelProperty(value = "紧急联系人电话", position = 30)
    private String emergencyPhone;

    /** 紧急联系人地址 */
    @ApiModelProperty(value = "紧急联系人地址", position = 31)
    private String emergencyAddress;

    /** 员工编号 */
    @ApiModelProperty(value = "员工编号", position = 32)
    private String empNo;

    /** 入职日期 */
    @ApiModelProperty(value = "员工编号", position = 33)
    private String entryDate;

    /** 兼任信息 */
    @ApiModelProperty(value = "兼任信息", position = 34)
    private String positionJson;

    /** 排序码 */
    @ApiModelProperty(value = "排序码", position = 35)
    private Integer sortCode;

    /** 扩展信息 */
    @ApiModelProperty(value = "扩展信息", position = 36)
    private String extJson;

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionLevel(String positionLevel) {
        this.positionLevel = positionLevel;
    }

    public String getPositionLevel() {
        return positionLevel;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    public String getDirectorId() {
        return directorId;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNation() {
        return nation;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    public String getIdCardType() {
        return idCardType;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setCultureLevel(String cultureLevel) {
        this.cultureLevel = cultureLevel;
    }

    public String getCultureLevel() {
        return cultureLevel;
    }

    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook;
    }

    public String getPoliticalOutlook() {
        return politicalOutlook;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCollege() {
        return college;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducation() {
        return education;
    }

    public void setEduLength(String eduLength) {
        this.eduLength = eduLength;
    }

    public String getEduLength() {
        return eduLength;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setHomeTel(String homeTel) {
        this.homeTel = homeTel;
    }

    public String getHomeTel() {
        return homeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }

    public String getOfficeTel() {
        return officeTel;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyAddress(String emergencyAddress) {
        this.emergencyAddress = emergencyAddress;
    }

    public String getEmergencyAddress() {
        return emergencyAddress;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setPositionJson(String positionJson) {
        this.positionJson = positionJson;
    }

    public String getPositionJson() {
        return positionJson;
    }

    public void setSortCode(Integer sortCode) {
        this.sortCode = sortCode;
    }

    public Integer getSortCode() {
        return sortCode;
    }

    public void setExtJson(String extJson) {
        this.extJson = extJson;
    }

    public String getExtJson() {
        return extJson;
    }
}

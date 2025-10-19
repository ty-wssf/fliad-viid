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
package com.fliad.auth.core.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 基础的B端登录用户对象，可继承此类扩展更多属性
 *
 * @author xuyuxiang
 * @date 2021/12/23 21:49
 */
public abstract class SaBaseLoginUser implements Serializable {

    /** id */
    @ApiModelProperty(value = "id", position = 1)
    private String id;

    /** 头像 */
    @ApiModelProperty(value = "头像", position = 3)
    private String avatar;

    /** 签名 */
    @ApiModelProperty(value = "签名", position = 4)
    private String signature;

    /** 账号 */
    @ApiModelProperty(value = "账号", position = 5)
    private String account;

    /** 姓名 */
    @ApiModelProperty(value = "姓名", position = 6)
    private String name;

    /** 昵称 */
    @ApiModelProperty(value = "昵称", position = 7)
    private String nickname;

    /** 性别 */
    @ApiModelProperty(value = "性别", position = 8)
    private String gender;

    /** 年龄 */
    @ApiModelProperty(value = "年龄", position = 9)
    private String age;

    /** 出生日期 */
    @ApiModelProperty(value = "出生日期", position = 10)
    private String birthday;

    /** 民族 */
    @ApiModelProperty(value = "民族", position = 11)
    private String nation;

    /** 籍贯 */
    @ApiModelProperty(value = "籍贯", position = 12)
    private String nativePlace;

    /** 家庭住址 */
    @ApiModelProperty(value = "家庭住址", position = 13)
    private String homeAddress;

    /** 通信地址 */
    @ApiModelProperty(value = "通信地址", position = 14)
    private String mailingAddress;

    /** 证件类型 */
    @ApiModelProperty(value = "证件类型", position = 15)
    private String idCardType;

    /** 证件号码 */
    @ApiModelProperty(value = "证件号码", position = 16)
    private String idCardNumber;

    /** 文化程度 */
    @ApiModelProperty(value = "文化程度", position = 17)
    private String cultureLevel;

    /** 政治面貌 */
    @ApiModelProperty(value = "政治面貌", position = 18)
    private String politicalOutlook;

    /** 毕业院校 */
    @ApiModelProperty(value = "毕业院校", position = 19)
    private String college;

    /** 学历 */
    @ApiModelProperty(value = "学历", position = 20)
    private String education;

    /** 学制 */
    @ApiModelProperty(value = "学制", position = 21)
    private String eduLength;

    /** 学位 */
    @ApiModelProperty(value = "学位", position = 22)
    private String degree;

    /** 手机 */
    @ApiModelProperty(value = "手机", position = 23)
    private String phone;

    /** 邮箱 */
    @ApiModelProperty(value = "邮箱", position = 24)
    private String email;

    /** 家庭电话 */
    @ApiModelProperty(value = "家庭电话", position = 25)
    private String homeTel;

    /** 办公电话 */
    @ApiModelProperty(value = "办公电话", position = 26)
    private String officeTel;

    /** 紧急联系人 */
    @ApiModelProperty(value = "紧急联系人", position = 27)
    private String emergencyContact;

    /** 紧急联系人电话 */
    @ApiModelProperty(value = "紧急联系人电话", position = 28)
    private String emergencyPhone;

    /** 紧急联系人地址 */
    @ApiModelProperty(value = "紧急联系人地址", position = 29)
    private String emergencyAddress;

    /** 员工编号 */
    @ApiModelProperty(value = "员工编号", position = 30)
    private String empNo;

    /** 入职日期 */
    @ApiModelProperty(value = "入职日期", position = 31)
    private String entryDate;

    /** 组织id */
    @ApiModelProperty(value = "组织id", position = 32)
    private String orgId;

    /** 组织名称 */
    @ApiModelProperty(value = "组织名称", position = 33)
    private String orgName;

    /** 职位id */
    @ApiModelProperty(value = "职位id", position = 34)
    private String positionId;

    /** 职位名称 */
    @ApiModelProperty(value = "职位名称", position = 35)
    private String positionName;

    /** 职级 */
    @ApiModelProperty(value = "职级", position = 36)
    private String positionLevel;

    /** 主管id */
    @ApiModelProperty(value = "主管id", position = 37)
    private String directorId;

    /** 兼任信息 */
    @ApiModelProperty(value = "兼任信息", position = 38)
    private String positionJson;

    /** 上次登录ip */
    @ApiModelProperty(value = "上次登录ip", position = 39)
    private String lastLoginIp;

    /** 上次登录地点 */
    @ApiModelProperty(value = "上次登录地点", position = 40)
    private String lastLoginAddress;

    /** 上次登录时间 */
    @ApiModelProperty(value = "上次登录时间", position = 41)
    private Date lastLoginTime;

    /** 上次登录设备 */
    @ApiModelProperty(value = "上次登录设备", position = 42)
    private String lastLoginDevice;

    /** 最新登录ip */
    @ApiModelProperty(value = "最新登录ip", position = 43)
    private String latestLoginIp;

    /** 最新登录地点 */
    @ApiModelProperty(value = "最新登录地点", position = 44)
    private String latestLoginAddress;

    /** 最新登录时间 */
    @ApiModelProperty(value = "最新登录时间", position = 45)
    private Date latestLoginTime;

    /** 最新登录设备 */
    @ApiModelProperty(value = "最新登录设备", position = 46)
    private String latestLoginDevice;

    /** 用户状态 */
    @ApiModelProperty(value = "用户状态", position = 47)
    private String userStatus;

    /** 排序码 */
    @ApiModelProperty(value = "排序码", position = 48)
    private Integer sortCode;

    /** 扩展信息 */
    @ApiModelProperty(value = "扩展信息", position = 49)
    private String extJson;

    /** 按钮码集合 */
    @ApiModelProperty(value = "按钮码集合", position = 50)
    private List<String> buttonCodeList;

    /** 移动端按钮码集合 */
    @ApiModelProperty(value = "移动端按钮码集合", position = 51)
    private List<String> mobileButtonCodeList;

    /** 权限码集合 */
    @ApiModelProperty(value = "权限码集合", position = 52, hidden = true)
    private List<String> permissionCodeList;

    /** 角色码集合 */
    @ApiModelProperty(value = "角色码集合", position = 53, hidden = true)
    private List<String> roleCodeList;

    /** 数据范围集合 */
    @ApiModelProperty(value = "数据范围集合", position = 54, hidden = true)
    private List<DataScope> dataScopeList;

    /** 用户密码hash值 */
    @JsonIgnore
    @ApiModelProperty(value = "用户密码hash值", position = 55)
    private String password;

    /** 是否可登录，由继承类实现 */
    public abstract Boolean getEnabled();

    /**
     * 数据范围类
     *
     * @author xuyuxiang
     * @date 2022/8/15 13:57
     **/
    @Getter
    @Setter
    public static class DataScope implements Serializable {

        /** API接口 */
        @ApiModelProperty(value = "API接口", position = 1)
        private String apiUrl;

        /** 数据范围 */
        @ApiModelProperty(value = "数据范围", position = 2)
        private List<String> dataScope;
    }

    public String getPositionLevel() {
        return positionLevel;
    }

    public void setPositionLevel(String positionLevel) {
        this.positionLevel = positionLevel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getCultureLevel() {
        return cultureLevel;
    }

    public void setCultureLevel(String cultureLevel) {
        this.cultureLevel = cultureLevel;
    }

    public String getPoliticalOutlook() {
        return politicalOutlook;
    }

    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEduLength() {
        return eduLength;
    }

    public void setEduLength(String eduLength) {
        this.eduLength = eduLength;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeTel() {
        return homeTel;
    }

    public void setHomeTel(String homeTel) {
        this.homeTel = homeTel;
    }

    public String getOfficeTel() {
        return officeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getEmergencyAddress() {
        return emergencyAddress;
    }

    public void setEmergencyAddress(String emergencyAddress) {
        this.emergencyAddress = emergencyAddress;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getDirectorId() {
        return directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    public String getPositionJson() {
        return positionJson;
    }

    public void setPositionJson(String positionJson) {
        this.positionJson = positionJson;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastLoginAddress() {
        return lastLoginAddress;
    }

    public void setLastLoginAddress(String lastLoginAddress) {
        this.lastLoginAddress = lastLoginAddress;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginDevice() {
        return lastLoginDevice;
    }

    public void setLastLoginDevice(String lastLoginDevice) {
        this.lastLoginDevice = lastLoginDevice;
    }

    public String getLatestLoginIp() {
        return latestLoginIp;
    }

    public void setLatestLoginIp(String latestLoginIp) {
        this.latestLoginIp = latestLoginIp;
    }

    public String getLatestLoginAddress() {
        return latestLoginAddress;
    }

    public void setLatestLoginAddress(String latestLoginAddress) {
        this.latestLoginAddress = latestLoginAddress;
    }

    public Date getLatestLoginTime() {
        return latestLoginTime;
    }

    public void setLatestLoginTime(Date latestLoginTime) {
        this.latestLoginTime = latestLoginTime;
    }

    public String getLatestLoginDevice() {
        return latestLoginDevice;
    }

    public void setLatestLoginDevice(String latestLoginDevice) {
        this.latestLoginDevice = latestLoginDevice;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getSortCode() {
        return sortCode;
    }

    public void setSortCode(Integer sortCode) {
        this.sortCode = sortCode;
    }

    public String getExtJson() {
        return extJson;
    }

    public void setExtJson(String extJson) {
        this.extJson = extJson;
    }

    public List<String> getButtonCodeList() {
        return buttonCodeList;
    }

    public void setButtonCodeList(List<String> buttonCodeList) {
        this.buttonCodeList = buttonCodeList;
    }

    public List<String> getMobileButtonCodeList() {
        return mobileButtonCodeList;
    }

    public void setMobileButtonCodeList(List<String> mobileButtonCodeList) {
        this.mobileButtonCodeList = mobileButtonCodeList;
    }

    public List<String> getPermissionCodeList() {
        return permissionCodeList;
    }

    public void setPermissionCodeList(List<String> permissionCodeList) {
        this.permissionCodeList = permissionCodeList;
    }

    public List<String> getRoleCodeList() {
        return roleCodeList;
    }

    public void setRoleCodeList(List<String> roleCodeList) {
        this.roleCodeList = roleCodeList;
    }

    public List<DataScope> getDataScopeList() {
        return dataScopeList;
    }

    public void setDataScopeList(List<DataScope> dataScopeList) {
        this.dataScopeList = dataScopeList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

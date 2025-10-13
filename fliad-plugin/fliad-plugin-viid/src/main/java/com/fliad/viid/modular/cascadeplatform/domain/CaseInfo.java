package com.fliad.viid.modular.cascadeplatform.domain;

import java.util.List;

/**
 * 案事件对象（参照《视图库对接技术要求(试行)_20180521.pdf》附录A.11）
 * 说明：字段首字母大写，忽略set/get方法，包含必选（R）和可选（O）字段，字段类型及约束参照文档定义
 */
public class CaseInfo {
    // 1. 案事件唯一标识（必选）
    private String CaseID;
    // 2. 案件关联标识（可选）
    private String CaseLinkMark;
    // 3. 案件名称（必选）
    private String CaseName;
    // 4. 案件类别（参照GA 240.1案件类别代码，必选）
    private String CaseCategory;
    // 5. 简要案情（案事件主要信息描述，必选）
    private String CaseAbstract;
    // 6. 线索标识（视频/图像标识列表，多个用英文半角分号“;”分隔，必选）
    private String ClueID;
    // 7. 事发时间上限（必选）
    private String TimeUpLimit;
    // 8. 事发时间下限（必选）
    private String TimeLowLimit;
    // 9. 案事件创建时间（必选）
    private String CreateTime;
    // 10. 事发地点行政区划代码（必选）
    private String PlaceCode;
    // 11. 事发地点区划内详细地址（必选）
    private String PlaceFullAddress;
    // 12. 可疑人数量（案件相关可疑人数量，可选）
    private Integer SuspectNumber;
    // 13. 发现人标识符（列表形式，多个用“;”间隔，可选）
    private String WitnessIDs;
    // 14. 创建人姓名（中文姓名全称，可选）
    private String CreatorName;
    // 15. 创建人证件类型（案件入库时创建人的有效证件类型，可选）
    private String CreatorIDType;
    // 16. 创建人证件号码（案件入库时创建人的有效证件号码，可选）
    private String CreatorID;
    // 17. 创建人单位名称（案件入库时创建人的所在单位名称，可选）
    private String CreatorOrg;
    // 18. 事发地经度（可选）
    private String Longitude;
    // 19. 事发地纬度（可选）
    private String Latitude;
    // 20. 机动车标识符（列表形式，多个用“;”间隔，可选）
    private String MotorVehicleIDs;
    // 21. 非机动车标识符（列表形式，多个用“;”间隔，可选）
    private String NonMotorVehicleIDs;
    // 22. 人员标识符（列表形式，多个用“;”间隔，可选）
    private String PersonIDs;
    // 23. 人脸标识符（列表形式，多个用“;”间隔，可选）
    private String FaceIDs;
    // 24. 物品标识符（列表形式，多个用“;”间隔，可选）
    private String ThingIDs;
    // 25. 文件标识符（列表形式，多个用“;”间隔，可选）
    private String FileIDs;
    // 26. 场景标识符（列表形式，多个用“;”间隔，可选）
    private String SceneIDs;
    // 27. 相关案件标识（关联案件标识，列表形式，多个用“;”间隔，可选）
    private String RelateCaseIdList;
    // 28. 父案件标识（被归并后指向父案件，可选）
    private String ParentCaseId;
    // 29. 案件状态（0:事件，1:已立案，2:已侦破，3:侦破待复核，4:已结案，5:结案待复核，6:并案待复核，7:撤案待复核，8:结案归档，9:并案归档，10:撤案归档，必选）
    private Integer State;

}
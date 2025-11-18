
CREATE TABLE HIKVISION_CAMERA(
  ID BIGINT NOT NULL  COMMENT '主键' ,
  DEVICE_ID VARCHAR(64)   COMMENT '设备编号' ,
  NAME VARCHAR(128) NOT NULL  COMMENT '设备名称' ,
  IP_ADDR VARCHAR(64) NOT NULL  COMMENT '设备IP地址' ,
  PORT INTEGER NOT NULL  COMMENT '端口号' ,
  USERNAME VARCHAR(64) NOT NULL  COMMENT '用户名' ,
  PASSWORD VARCHAR(128) NOT NULL  COMMENT '密码' ,
  ENABLE_STATUS VARCHAR(1) default '1'  NOT NULL  COMMENT '启用状态：1=启用，0=禁用' ,
  ONLINE_STATUS VARCHAR(1) default '0'  NOT NULL  COMMENT '在线状态：1=在线，0=离线' ,
  CREATE_TIME TIMESTAMP NOT NULL  COMMENT '创建时间' ,
  UPDATE_TIME TIMESTAMP NOT NULL  COMMENT '更新时间' ,
  constraint IDX_HIKVISION_CAMERA_NAME unique (NAME),
  constraint PK_HIKVISION_CAMERA primary key (ID)
);

CREATE TABLE VEHICLE_TRAFFIC_RECORD(
  ID VARCHAR(20) NOT NULL  COMMENT '主键' ,
  KKBH VARCHAR(50)   COMMENT '卡口编号，符合GA/T 16.31与GA/T 543.10要求' ,
  FXLX VARCHAR(20)   COMMENT '方向类型' ,
  CDH VARCHAR(10)   COMMENT '车道号' ,
  GCSJ DATETIME   COMMENT '过车时间，格式yyyy-mm-dd hh24:mi:ss' ,
  WFDM VARCHAR(20)   COMMENT '违法行为，符合GA/T 16.31与GA/T 543.5要求' ,
  HPHM VARCHAR(20) NOT NULL  COMMENT '号牌号码，符合GA/T 543.5要求，无牌等用"-"表示' ,
  HPZL VARCHAR(2) NOT NULL  COMMENT '号牌种类，符合GA/T 16.7与GA/T 543.5要求：01-大型汽车,02-小型汽车,...,99-其他号牌' ,
  HPYS TINYINT NOT NULL  COMMENT '号牌颜色，符合GB 1.1-2009：0-白色,1-黄色,2-蓝色,3-黑色,4-绿色,5-未识别,9-其他颜色' ,
  FZHPHM VARCHAR(20)   COMMENT '辅助号牌号码，无牌等用"-"表示' ,
  FZHPZL VARCHAR(2)   COMMENT '辅助号牌种类，符合GA/T 16.7与GA/T 543.5要求' ,
  FZHPYS TINYINT   COMMENT '辅助号牌颜色：0-白色,1-黄色,2-蓝色,3-黑色,4-绿色,5-未识别,9-其他颜色' ,
  CLLX VARCHAR(20)   COMMENT '车辆类型，符合GA/T 16.4与GA/T 543.5要求' ,
  CWKC VARCHAR(5)   COMMENT '车外廓长，单位厘米，最长5位' ,
  CLPP VARCHAR(50)   COMMENT '车辆品牌，符合GA/T 543.10要求' ,
  CSYS VARCHAR(2)   COMMENT '车身颜色，符合GA/T 16.8与GA/T 543.5：A-白,B-灰,C-黄,D-粉,E-红,F-紫,G-绿,H-蓝,I-棕,J-黑' ,
  HPKXD TINYINT   COMMENT '号牌识别可信度，0~100%' ,
  MWHPKXD VARCHAR(200)   COMMENT '每位号牌识别可信度，格式如"苏-80,B-90,..."' ,
  CXKXD TINYINT   COMMENT '车型识别可信度，0~100%' ,
  PPKXD TINYINT   COMMENT '品牌识别可信度，0~100%' ,
  XWTZ VARCHAR(50)   COMMENT '行为特征，1-不系安全带;2-拨打电话;...多个用分号分隔' ,
  TPLJ VARCHAR(255)   COMMENT '图片路径' ,
  TP1 VARCHAR(255)   COMMENT '通行图片1' ,
  TP2 VARCHAR(255)   COMMENT '通行图片2' ,
  TP3 VARCHAR(255)   COMMENT '通行图片3' ,
  TZTP VARCHAR(255)   COMMENT '特征图片' ,
  JSRTP VARCHAR(255)   COMMENT '驾驶人图片' ,
  CLSD INTEGER   COMMENT '车辆速度，单位km/h' ,
  TID VARCHAR(50)   COMMENT 'rfid标签芯片识别号' ,
  ZKRS INTEGER   COMMENT '载客人数' ,
  CID VARCHAR(50)   COMMENT 'rfid标识卡号码' ,
  SXJBH VARCHAR(50)   COMMENT '摄像机设备编号' ,
  constraint PK_VEHICLE_TRAFFIC_RECORD primary key (ID)
);


      COMMENT ON TABLE HIKVISION_CAMERA IS '海康布防表';
                
      COMMENT ON COLUMN HIKVISION_CAMERA.ID IS '主键';
                    
      COMMENT ON COLUMN HIKVISION_CAMERA.DEVICE_ID IS '设备编号';
                    
      COMMENT ON COLUMN HIKVISION_CAMERA.NAME IS '设备名称';
                    
      COMMENT ON COLUMN HIKVISION_CAMERA.IP_ADDR IS '设备IP地址';
                    
      COMMENT ON COLUMN HIKVISION_CAMERA.PORT IS '端口号';
                    
      COMMENT ON COLUMN HIKVISION_CAMERA.USERNAME IS '用户名';
                    
      COMMENT ON COLUMN HIKVISION_CAMERA.PASSWORD IS '密码';
                    
      COMMENT ON COLUMN HIKVISION_CAMERA.ENABLE_STATUS IS '启用状态：1=启用，0=禁用';
                    
      COMMENT ON COLUMN HIKVISION_CAMERA.ONLINE_STATUS IS '在线状态：1=在线，0=离线';
                    
      COMMENT ON COLUMN HIKVISION_CAMERA.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN HIKVISION_CAMERA.UPDATE_TIME IS '更新时间';
                    
      COMMENT ON TABLE VEHICLE_TRAFFIC_RECORD IS '车辆通行记录信息表';
                
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.ID IS '主键';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.KKBH IS '卡口编号，符合GA/T 16.31与GA/T 543.10要求';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.FXLX IS '方向类型';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.CDH IS '车道号';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.GCSJ IS '过车时间，格式yyyy-mm-dd hh24:mi:ss';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.WFDM IS '违法行为，符合GA/T 16.31与GA/T 543.5要求';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.HPHM IS '号牌号码，符合GA/T 543.5要求，无牌等用"-"表示';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.HPZL IS '号牌种类，符合GA/T 16.7与GA/T 543.5要求：01-大型汽车,02-小型汽车,...,99-其他号牌';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.HPYS IS '号牌颜色，符合GB 1.1-2009：0-白色,1-黄色,2-蓝色,3-黑色,4-绿色,5-未识别,9-其他颜色';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.FZHPHM IS '辅助号牌号码，无牌等用"-"表示';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.FZHPZL IS '辅助号牌种类，符合GA/T 16.7与GA/T 543.5要求';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.FZHPYS IS '辅助号牌颜色：0-白色,1-黄色,2-蓝色,3-黑色,4-绿色,5-未识别,9-其他颜色';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.CLLX IS '车辆类型，符合GA/T 16.4与GA/T 543.5要求';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.CWKC IS '车外廓长，单位厘米，最长5位';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.CLPP IS '车辆品牌，符合GA/T 543.10要求';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.CSYS IS '车身颜色，符合GA/T 16.8与GA/T 543.5：A-白,B-灰,C-黄,D-粉,E-红,F-紫,G-绿,H-蓝,I-棕,J-黑';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.HPKXD IS '号牌识别可信度，0~100%';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.MWHPKXD IS '每位号牌识别可信度，格式如"苏-80,B-90,..."';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.CXKXD IS '车型识别可信度，0~100%';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.PPKXD IS '品牌识别可信度，0~100%';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.XWTZ IS '行为特征，1-不系安全带;2-拨打电话;...多个用分号分隔';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.TPLJ IS '图片路径';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.TP1 IS '通行图片1';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.TP2 IS '通行图片2';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.TP3 IS '通行图片3';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.TZTP IS '特征图片';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.JSRTP IS '驾驶人图片';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.CLSD IS '车辆速度，单位km/h';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.TID IS 'rfid标签芯片识别号';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.ZKRS IS '载客人数';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.CID IS 'rfid标识卡号码';
                    
      COMMENT ON COLUMN VEHICLE_TRAFFIC_RECORD.SXJBH IS '摄像机设备编号';
                    

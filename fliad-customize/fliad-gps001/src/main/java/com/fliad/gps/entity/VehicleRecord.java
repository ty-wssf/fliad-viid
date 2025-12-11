package com.fliad.gps.entity;

/**
 * 重点车辆实体类
 * 对应数据库表结构，包含车辆基本信息、状态信息和报警信息
 */
public class VehicleRecord {
    /**
     * 全局唯一标识符
     */
    private long guid;

    /**
     * 车牌号
     * 字符串类型，最大长度50
     */
    private String vehicle_no;

    /**
     * 车牌颜色代码
     * 1-蓝色、2-黄色、3-黑色、4-白色、9-其它
     */
    private int vehicle_color;

    /**
     * 车辆类型 1:两客一危 2:货车
     */
    private int vehicle_type;

    /**
     * 车牌颜色标签
     * 对应vehicle_color的文本描述
     */
    private String vehicle_color_label;

    /**
     * 加密标识
     * 0-未加密，1-已加密
     */
    private boolean encrypt;

    /**
     * GPS定位时间
     * 时间格式：时间戳
     */
    private long date_time;

    /**
     * GPS定位时间
     * 时间格式：yyyy-MM-dd HH:mm:ss
     */
    private String partition_date;

    /**
     * 经度
     * 单位：1*10^-6度
     */
    private int lng;

    /**
     * 纬度
     * 单位：1*10^-6度
     */
    private int lat;

    /**
     * 所属路口id
     */
    private String matched_cross_id;

    /**
     * 所属路段id
     */
    private String matched_road_seg_id;

    /**
     * 卫星定位车载终端上传行车速度
     * 单位：km/h
     */
    private double velocity1;

    /**
     * 行驶记录仪上传行车速度
     * 单位：km/h
     */
    private double velocity2;

    /**
     * 车辆上传行车里程数
     * 单位：km
     */
    private int mileage;

    /**
     * 方向
     * 0-359度，正北为0，顺时针方向
     */
    private int direction;

    /**
     * 海拔高度
     * 单位：米(m)
     */
    private int altitude;

    // 状态字段 (stateXX)

    /**
     * 车门锁状态
     * 0-车门解锁、1-车门加锁
     */
    private boolean state12;

    /**
     * 车辆电路状态
     * 0-车辆电路正常、1-车辆电路断开
     */
    private boolean state11;

    /**
     * 车辆油路状态
     * 0-车辆油路正常、1-车辆油路断开
     */
    private boolean state10;

    /**
     * 经纬度加密标识
     * 0-经纬度未经保密插件加密、1-经纬度已经保密插件加密
     */
    private boolean state05;

    /**
     * 营运状态
     * 0-运营、1-停运
     */
    private boolean state04;

    /**
     * 经度方向
     * 0-东经、1-西经
     */
    private boolean state03;

    /**
     * 纬度方向
     * 0-北纬、1-南纬
     */
    private boolean state02;

    /**
     * 定位状态
     * 0-未定位、1-定位
     */
    private boolean state01;

    /**
     * ACC状态
     * 0-关、1-开
     */
    private boolean state00;

    // 保留的状态字段
    private boolean state13;

    // 报警字段 (alarmXX)

    /**
     * 车辆非法位移报警
     * 1-车辆非法位移
     */
    private boolean alarm28;

    /**
     * 车辆非法点火报警
     * 1-车辆非法点火
     */
    private boolean alarm27;

    /**
     * 车辆被盗报警
     * 1-车辆被盗
     */
    private boolean alarm26;

    /**
     * 车辆油量异常报警
     * 1-车辆油量异常
     */
    private boolean alarm25;

    /**
     * 车辆VSS故障报警
     * 1-车辆VSS故障
     */
    private boolean alarm24;

    /**
     * 路线偏移报警
     * 1-路线偏移
     */
    private boolean alarm23;

    /**
     * 路段行驶时间不足/过长报警
     * 1-路段行驶时间不足/过长
     */
    private boolean alarm22;

    /**
     * 进出路线报警
     * 1-进出路线
     */
    private boolean alarm21;

    /**
     * 进出区域报警
     * 1-进出区域
     */
    private boolean alarm20;

    /**
     * 超时停车报警
     * 1-超时停车
     */
    private boolean alarm19;

    /**
     * 当天累计驾驶超时报警
     * 1-当天累计驾驶超时
     */
    private boolean alarm18;

    /**
     * 摄像头故障报警
     * 1-摄像头故障
     */
    private boolean alarm11;

    /**
     * TTS模块故障报警
     * 1-TTS模块故障
     */
    private boolean alarm10;

    /**
     * 终端LCD或显示器故障报警
     * 1-终端LCD或显示器故障
     */
    private boolean alarm09;

    /**
     * 终端主电源掉电报警
     * 1-终端主电源掉电
     */
    private boolean alarm08;

    /**
     * 终端主电源欠压报警
     * 1-终端主电源欠压
     */
    private boolean alarm07;

    /**
     * GNSS天线短路报警
     * 1-GNSS天线短路
     */
    private boolean alarm06;

    /**
     * GNSS天线未接或被剪断报警
     * 1-GNSS天线未接或被剪断
     */
    private boolean alarm05;

    /**
     * GNSS模块发生故障报警
     * 1-GNSS模块发生故障
     */
    private boolean alarm04;

    /**
     * 预警报警
     * 1-预警
     */
    private boolean alarm03;

    /**
     * 疲劳驾驶报警
     * 1-疲劳驾驶
     */
    private boolean alarm02;

    /**
     * 超速报警
     * 1-超速
     */
    private boolean alarm01;

    /**
     * 紧急报警触动报警开关后触发报警
     * 1-紧急报警触动报警开关后触发
     */
    private boolean alarm00;

    /**
     * 更新时间
     * 记录数据更新的时间戳
     */
    private long update_time;

    // Getters and setters
    public long getGuid() {
        return guid;
    }

    public void setGuid(long guid) {
        this.guid = guid;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public int getVehicle_color() {
        return vehicle_color;
    }

    public void setVehicle_color(int vehicle_color) {
        this.vehicle_color = vehicle_color;
    }

    public String getVehicle_color_label() {
        return vehicle_color_label;
    }

    public void setVehicle_color_label(String vehicle_color_label) {
        this.vehicle_color_label = vehicle_color_label;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public long getDate_time() {
        return date_time;
    }

    public void setDate_time(long date_time) {
        this.date_time = date_time;
    }

    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public double getVelocity1() {
        return velocity1;
    }

    public void setVelocity1(double velocity1) {
        this.velocity1 = velocity1;
    }

    public double getVelocity2() {
        return velocity2;
    }

    public void setVelocity2(double velocity2) {
        this.velocity2 = velocity2;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public boolean isState13() {
        return state13;
    }

    public void setState13(boolean state13) {
        this.state13 = state13;
    }

    public boolean isState12() {
        return state12;
    }

    public void setState12(boolean state12) {
        this.state12 = state12;
    }

    public boolean isState11() {
        return state11;
    }

    public void setState11(boolean state11) {
        this.state11 = state11;
    }

    public boolean isState10() {
        return state10;
    }

    public void setState10(boolean state10) {
        this.state10 = state10;
    }

    public boolean isState05() {
        return state05;
    }

    public void setState05(boolean state05) {
        this.state05 = state05;
    }

    public boolean isState04() {
        return state04;
    }

    public void setState04(boolean state04) {
        this.state04 = state04;
    }

    public boolean isState03() {
        return state03;
    }

    public void setState03(boolean state03) {
        this.state03 = state03;
    }

    public boolean isState02() {
        return state02;
    }

    public void setState02(boolean state02) {
        this.state02 = state02;
    }

    public boolean isState01() {
        return state01;
    }

    public void setState01(boolean state01) {
        this.state01 = state01;
    }

    public boolean isState00() {
        return state00;
    }

    public void setState00(boolean state00) {
        this.state00 = state00;
    }

    public boolean isAlarm28() {
        return alarm28;
    }

    public void setAlarm28(boolean alarm28) {
        this.alarm28 = alarm28;
    }

    public boolean isAlarm27() {
        return alarm27;
    }

    public void setAlarm27(boolean alarm27) {
        this.alarm27 = alarm27;
    }

    public boolean isAlarm26() {
        return alarm26;
    }

    public void setAlarm26(boolean alarm26) {
        this.alarm26 = alarm26;
    }

    public boolean isAlarm25() {
        return alarm25;
    }

    public void setAlarm25(boolean alarm25) {
        this.alarm25 = alarm25;
    }

    public boolean isAlarm24() {
        return alarm24;
    }

    public void setAlarm24(boolean alarm24) {
        this.alarm24 = alarm24;
    }

    public boolean isAlarm23() {
        return alarm23;
    }

    public void setAlarm23(boolean alarm23) {
        this.alarm23 = alarm23;
    }

    public boolean isAlarm22() {
        return alarm22;
    }

    public void setAlarm22(boolean alarm22) {
        this.alarm22 = alarm22;
    }

    public boolean isAlarm21() {
        return alarm21;
    }

    public void setAlarm21(boolean alarm21) {
        this.alarm21 = alarm21;
    }

    public boolean isAlarm20() {
        return alarm20;
    }

    public void setAlarm20(boolean alarm20) {
        this.alarm20 = alarm20;
    }

    public boolean isAlarm19() {
        return alarm19;
    }

    public void setAlarm19(boolean alarm19) {
        this.alarm19 = alarm19;
    }

    public boolean isAlarm18() {
        return alarm18;
    }

    public void setAlarm18(boolean alarm18) {
        this.alarm18 = alarm18;
    }

    public boolean isAlarm11() {
        return alarm11;
    }

    public void setAlarm11(boolean alarm11) {
        this.alarm11 = alarm11;
    }

    public boolean isAlarm10() {
        return alarm10;
    }

    public void setAlarm10(boolean alarm10) {
        this.alarm10 = alarm10;
    }

    public boolean isAlarm09() {
        return alarm09;
    }

    public void setAlarm09(boolean alarm09) {
        this.alarm09 = alarm09;
    }

    public boolean isAlarm08() {
        return alarm08;
    }

    public void setAlarm08(boolean alarm08) {
        this.alarm08 = alarm08;
    }

    public boolean isAlarm07() {
        return alarm07;
    }

    public void setAlarm07(boolean alarm07) {
        this.alarm07 = alarm07;
    }

    public boolean isAlarm06() {
        return alarm06;
    }

    public void setAlarm06(boolean alarm06) {
        this.alarm06 = alarm06;
    }

    public boolean isAlarm05() {
        return alarm05;
    }

    public void setAlarm05(boolean alarm05) {
        this.alarm05 = alarm05;
    }

    public boolean isAlarm04() {
        return alarm04;
    }

    public void setAlarm04(boolean alarm04) {
        this.alarm04 = alarm04;
    }

    public boolean isAlarm03() {
        return alarm03;
    }

    public void setAlarm03(boolean alarm03) {
        this.alarm03 = alarm03;
    }

    public boolean isAlarm02() {
        return alarm02;
    }

    public void setAlarm02(boolean alarm02) {
        this.alarm02 = alarm02;
    }

    public boolean isAlarm01() {
        return alarm01;
    }

    public void setAlarm01(boolean alarm01) {
        this.alarm01 = alarm01;
    }

    public boolean isAlarm00() {
        return alarm00;
    }

    public void setAlarm00(boolean alarm00) {
        this.alarm00 = alarm00;
    }

    public long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    public int getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(int vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getMatched_cross_id() {
        return matched_cross_id;
    }

    public void setMatched_cross_id(String matched_cross_id) {
        this.matched_cross_id = matched_cross_id;
    }

    public String getMatched_road_seg_id() {
        return matched_road_seg_id;
    }

    public void setMatched_road_seg_id(String matched_road_seg_id) {
        this.matched_road_seg_id = matched_road_seg_id;
    }

}
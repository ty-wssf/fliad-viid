package com.netsdk.lib.structure;

import com.netsdk.lib.NetSDKLib;

//视频分析物体信息结构体
public class NET_MSG_OBJECT extends NetSDKLib.SdkStructure {
    public int nObjectID;                            //物体ID,每个ID表示一个唯一的物体
    public byte[] szObjectType = new byte[128];         //物体类型
    public int nConfidence;                          //置信度(0~255),值越大表示置信度越高
    public int nAction;                              //物体动作:1:Appear2:Move3:Stay
    public DH_RECT BoundingBox = new DH_RECT();          //包围盒
    public NET_POINT Center = new NET_POINT();             //物体型心
    public int nPolygonNum;                          //多边形顶点个数
    public NET_POINT[] Contour = new NET_POINT[NetSDKLib.NET_MAX_POLYGON_NUM]; //较精确的轮廓多边形
    public int rgbaMainColor;                        //表示车牌、车身等物体主要颜色；按字节表示,分别为红、绿、蓝和透明度,例如:RGB值为(0,255,0),透明度为0时,其值为0x00ff0000.
    public byte[] szText = new byte[128];               // 物体上相关的带0结束符文本,比如车牌,集装箱号等等
    // "ObjectType"为"Vehicle"或者"Logo"时（尽量使用Logo。Vehicle是为了兼容老产品）表示车标,支持：
    // "Unknown"未知
    // "Audi" 奥迪
    // "Honda" 本田
    // "Buick" 别克
    // "Volkswagen" 大众
    // "Toyota" 丰田
    // "BMW" 宝马
    // "Peugeot" 标致
    // "Ford" 福特
    // "Mazda" 马自达
    // "Nissan" 尼桑
    // "Hyundai" 现代
    // "Suzuki" 铃木
    // "Citroen" 雪铁龙
    // "Benz" 奔驰
    // "BYD" 比亚迪
    // "Geely" 吉利
    // "Lexus" 雷克萨斯
    // "Chevrolet" 雪佛兰
    // "Chery" 奇瑞
    // "Kia" 起亚
    // "Charade" 夏利
    // "DF" 东风
    // "Naveco" 依维柯
    // "SGMW" 五菱
    // "Jinbei" 金杯
    // "JAC" 江淮
    // "Emgrand" 帝豪
    // "ChangAn" 长安
    // "Great Wall" 长城
    // "Skoda" 斯柯达
    // "BaoJun" 宝骏
    // "Subaru" 斯巴鲁
    // "LandWind" 陆风
    // "Luxgen" 纳智捷
    // "Renault" 雷诺
    // "Mitsubishi" 三菱
    // "Roewe" 荣威
    // "Cadillac" 凯迪拉克
    // "MG" 名爵
    // "Zotye" 众泰
    // "ZhongHua" 中华
    // "Foton" 福田
    // "SongHuaJiang" 松花江
    // "Opel" 欧宝
    // "HongQi" 一汽红旗
    // "Fiat" 菲亚特
    // "Jaguar" 捷豹
    // "Volvo" 沃尔沃
    // "Acura" 讴歌
    // "Porsche" 保时捷
    // "Jeep" 吉普
    // "Bentley" 宾利
    // "Bugatti" 布加迪
    // "ChuanQi" 传祺
    // "Daewoo" 大宇
    // "DongNan" 东南
    // "Ferrari" 法拉利
    // "Fudi" 福迪
    // "Huapu" 华普
    // "HawTai" 华泰
    // "JMC" 江铃
    // "JingLong" 金龙客车
    // "JoyLong" 九龙
    // "Karry" 开瑞
    // "Chrysler" 克莱斯勒
    // "Lamborghini" 兰博基尼
    // "RollsRoyce" 劳斯莱斯
    // "Linian" 理念
    // "LiFan" 力帆
    // "LieBao" 猎豹
    // "Lincoln" 林肯
    // "LandRover" 路虎
    // "Lotus" 路特斯
    // "Maserati" 玛莎拉蒂
    // "Maybach" 迈巴赫
    // "Mclaren" 迈凯轮
    // "Youngman" 青年客车
    // "Tesla" 特斯拉
    // "Rely" 威麟
    // "Lsuzu" 五十铃
    // "Yiqi" 一汽
    // "Infiniti" 英菲尼迪
    // "YuTong" 宇通客车
    // "AnKai" 安凯客车
    // "Canghe" 昌河
    // "HaiMa" 海马
    // "Crown" 丰田皇冠
    // "HuangHai" 黄海
    // "JinLv" 金旅客车
    // "JinNing" 精灵
    // "KuBo" 酷博
    // "Europestar" 莲花
    // "MINI" 迷你
    // "Gleagle" 全球鹰
    // "ShiDai" 时代
    // "ShuangHuan" 双环
    // "TianYe" 田野
    // "WeiZi" 威姿
    // "Englon" 英伦
    // "ZhongTong" 中通客车
    // "Changan" 长安轿车
    // "Yuejin" 跃进
    // "Taurus" 金牛星
    // "Alto" 奥拓
    // "Weiwang" 威旺
    // "Chenglong" 乘龙
    // "Haige" 海格
    // "Shaolin" 少林客车
    // "Beifang" 北方客车
    // "Beijing" 北京汽车
    // "Hafu" 哈弗
    public byte[] szObjectSubType = new byte[62];       // 物体子类别,根据不同的物体类型,可以取以下子类型：
    // Vehicle Category:"Unknown"  未知,"Motor" 机动车,"Non-Motor":非机动车,"Bus": 公交车,"Bicycle" 自行车,"Motorcycle":摩托车,"PassengerCar":客车,
    // "LargeTruck":大货车,    "MidTruck":中货车,"SaloonCar":轿车,"Microbus":面包车,"MicroTruck":小货车,"Tricycle":三轮车,    "Passerby":行人
    // Plate Category："Unknown" 未知,"Normal" 蓝牌黑牌,"Yellow" 黄牌,"DoubleYellow" 双层黄尾牌,"Police" 警牌,
    // "SAR" 港澳特区号牌,"Trainning" 教练车号牌
    // "Personal" 个性号牌,"Agri" 农用牌,"Embassy" 使馆号牌,"Moto" 摩托车号牌,"Tractor" 拖拉机号牌,"Other" 其他号牌
    // HumanFace Category:"Normal" 普通人脸,"HideEye" 眼部遮挡,"HideNose" 鼻子遮挡,"HideMouth" 嘴部遮挡
    public short wColorLogoIndex;                      // 车标索引
    public short wSubBrand;                            // 车辆子品牌 需要通过映射表得到真正的子品牌 映射表详见开发手册
    public byte byReserved1;
    public byte bPicEnble;                            //是否有物体对应图片文件信息, 类型小bool, 取值0或者1
    public NET_PIC_INFO stPicInfo = new NET_PIC_INFO();       //物体对应图片信息
    public byte bShotFrame;                           //是否是抓拍张的识别结果,  类型小bool, 取值0或者1
    public byte bColor;                               //物体颜色(rgbaMainColor)是否可用, 类型小bool, 取值0或者1
    public byte byReserved2;
    public byte byTimeType;                           //时间表示类型,详见 EM_TIME_TYPE 说明
    public NET_TIME_EX stuCurrentTime = new NET_TIME_EX();   //针对视频浓缩,当前时间戳（物体抓拍或识别时,会将此识别智能帧附在一个视频帧或jpeg图片中,此帧所在原始视频中的出现时间）
    public NET_TIME_EX stuStartTime = new NET_TIME_EX();     //开始时间戳（物体开始出现时）
    public NET_TIME_EX stuEndTime = new NET_TIME_EX();       //结束时间戳（物体最后出现时）
    public DH_RECT stuOriginalBoundingBox = new DH_RECT(); //包围盒(绝对坐标)
    public DH_RECT stuSignBoundingBox = new DH_RECT();   //车标坐标包围盒
    public int dwCurrentSequence;                    //当前帧序号（抓下这个物体时的帧）
    public int dwBeginSequence;                      //开始帧序号（物体开始出现时的帧序号）
    public int dwEndSequence;                        //结束帧序号（物体消逝时的帧序号）
    public long nBeginFileOffse;                      //开始时文件偏移,单位:字（物体开始出现时,视频帧在原始视频文件中相对于文件起始处的偏移）
    public long nEndFileOffset;                       //结束时文件偏移,单位:字节（物体消逝时,视频帧在原始视频文件中相对于文件起始处的偏移）
    public byte[] byColorSimilar = new byte[EM_COLOR_TYPE.NET_COLOR_TYPE_MAX]; //物体颜色相似度,取值范围：0-100,数组下标值代表某种颜色,详见 EM_COLOR_TYPE
    public byte[] byUpperBodyColorSimilar = new byte[EM_COLOR_TYPE.NET_COLOR_TYPE_MAX]; //上半身物体颜色相似度(物体类型为人时有效)
    public byte[] byLowerBodyColorSimilar = new byte[EM_COLOR_TYPE.NET_COLOR_TYPE_MAX]; //下半身物体颜色相似度(物体类型为人时有效)
    public int nRelativeID;                          //相关物体ID
    public byte[] szSubText = new byte[20];             //"ObjectType"为"Vehicle"或者"Logo"时,表示车标下的某一车系,比如奥迪A6L,由于车系较多,SDK实现时透传此字段,设备如实填写。
    public short wBrandYear;                           // 车辆品牌年款 需要通过映射表得到真正的年款 映射表详见开发手册

    protected int getNativeAlignment(Class<?> type, Object value, boolean isFirstElement) {
        int alignment = super.getNativeAlignment(type, value, isFirstElement);
        return Math.min(4, alignment);
    }

    public NET_MSG_OBJECT() {

        for (int i = 0; i < Contour.length; i++) {
            Contour[i] = new NET_POINT();
        }
    }
}

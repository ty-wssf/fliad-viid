package com.fliad.resource.dao.entity._gen;

import io.nop.orm.model.IEntityModel;
import io.nop.orm.support.DynamicOrmEntity;
import io.nop.orm.support.OrmEntitySet; //NOPMD - suppressed UnusedImports - Auto Gen Code
import io.nop.orm.IOrmEntitySet; //NOPMD - suppressed UnusedImports - Auto Gen Code
import io.nop.api.core.convert.ConvertHelper;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

import com.fliad.resource.dao.entity.DahuaNonMotorVehicle;

// tell cpd to start ignoring code - CPD-OFF
/**
 *  Dahuanonmotorvehicle: dahua_non_motor_vehicle
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable","java:S3008","java:S1602","java:S1128","java:S1161",
        "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement","java:S116","java:S115","java:S101","java:S3776"})
public class _DahuaNonMotorVehicle extends DynamicOrmEntity{
    
    /* Absscore: ABSSCORE INTEGER */
    public static final String PROP_NAME_absscore = "absscore";
    public static final int PROP_ID_absscore = 1;
    
    /* Accompanynumber: ACCOMPANYNUMBER INTEGER */
    public static final String PROP_NAME_accompanynumber = "accompanynumber";
    public static final int PROP_ID_accompanynumber = 2;
    
    /* Accompanynumberreliability: ACCOMPANYNUMBERRELIABILITY INTEGER */
    public static final String PROP_NAME_accompanynumberreliability = "accompanynumberreliability";
    public static final int PROP_ID_accompanynumberreliability = 3;
    
    /* Age: AGE INTEGER */
    public static final String PROP_NAME_age = "age";
    public static final int PROP_ID_age = 4;
    
    /* Agegroup: AGEGROUP INTEGER */
    public static final String PROP_NAME_agegroup = "agegroup";
    public static final int PROP_ID_agegroup = 5;
    
    /* Agegroupreliability: AGEGROUPRELIABILITY INTEGER */
    public static final String PROP_NAME_agegroupreliability = "agegroupreliability";
    public static final int PROP_ID_agegroupreliability = 6;
    
    /* Agelowerlimit: AGELOWERLIMIT INTEGER */
    public static final String PROP_NAME_agelowerlimit = "agelowerlimit";
    public static final int PROP_ID_agelowerlimit = 7;
    
    /* Agereliability: AGERELIABILITY INTEGER */
    public static final String PROP_NAME_agereliability = "agereliability";
    public static final int PROP_ID_agereliability = 8;
    
    /* Ageuplimit: AGEUPLIMIT INTEGER */
    public static final String PROP_NAME_ageuplimit = "ageuplimit";
    public static final int PROP_ID_ageuplimit = 9;
    
    /* Algorithmversion: ALGORITHMVERSION VARCHAR */
    public static final String PROP_NAME_algorithmversion = "algorithmversion";
    public static final int PROP_ID_algorithmversion = 10;
    
    /* Alias: ALIAS VARCHAR */
    public static final String PROP_NAME_alias = "alias";
    public static final int PROP_ID_alias = 11;
    
    /* Appendant: APPENDANT VARCHAR */
    public static final String PROP_NAME_appendant = "appendant";
    public static final int PROP_ID_appendant = 12;
    
    /* Appendantdescription: APPENDANTDESCRIPTION VARCHAR */
    public static final String PROP_NAME_appendantdescription = "appendantdescription";
    public static final int PROP_ID_appendantdescription = 13;
    
    /* Baby: BABY VARCHAR */
    public static final String PROP_NAME_baby = "baby";
    public static final int PROP_ID_baby = 14;
    
    /* Bag1reliability: BAG1RELIABILITY INTEGER */
    public static final String PROP_NAME_bag1reliability = "bag1reliability";
    public static final int PROP_ID_bag1reliability = 15;
    
    /* Bag1style: BAG1STYLE VARCHAR */
    public static final String PROP_NAME_bag1style = "bag1style";
    public static final int PROP_ID_bag1style = 16;
    
    /* Bag2reliability: BAG2RELIABILITY INTEGER */
    public static final String PROP_NAME_bag2reliability = "bag2reliability";
    public static final int PROP_ID_bag2reliability = 17;
    
    /* Bag2style: BAG2STYLE VARCHAR */
    public static final String PROP_NAME_bag2style = "bag2style";
    public static final int PROP_ID_bag2style = 18;
    
    /* Bag3reliability: BAG3RELIABILITY INTEGER */
    public static final String PROP_NAME_bag3reliability = "bag3reliability";
    public static final int PROP_ID_bag3reliability = 19;
    
    /* Bag3style: BAG3STYLE VARCHAR */
    public static final String PROP_NAME_bag3style = "bag3style";
    public static final int PROP_ID_bag3style = 20;
    
    /* Bagcolor: BAGCOLOR VARCHAR */
    public static final String PROP_NAME_bagcolor = "bagcolor";
    public static final int PROP_ID_bagcolor = 21;
    
    /* Bagstyle: BAGSTYLE VARCHAR */
    public static final String PROP_NAME_bagstyle = "bagstyle";
    public static final int PROP_ID_bagstyle = 22;
    
    /* Bagstylereliability: BAGSTYLERELIABILITY INTEGER */
    public static final String PROP_NAME_bagstylereliability = "bagstylereliability";
    public static final int PROP_ID_bagstylereliability = 23;
    
    /* Behavior: BEHAVIOR VARCHAR */
    public static final String PROP_NAME_behavior = "behavior";
    public static final int PROP_ID_behavior = 24;
    
    /* Behaviordescription: BEHAVIORDESCRIPTION VARCHAR */
    public static final String PROP_NAME_behaviordescription = "behaviordescription";
    public static final int PROP_ID_behaviordescription = 25;
    
    /* Bodyfeature: BODYFEATURE VARCHAR */
    public static final String PROP_NAME_bodyfeature = "bodyfeature";
    public static final int PROP_ID_bodyfeature = 26;
    
    /* Bodyspeciallmark: BODYSPECIALLMARK VARCHAR */
    public static final String PROP_NAME_bodyspeciallmark = "bodyspeciallmark";
    public static final int PROP_ID_bodyspeciallmark = 27;
    
    /* Bodytype: BODYTYPE VARCHAR */
    public static final String PROP_NAME_bodytype = "bodytype";
    public static final int PROP_ID_bodytype = 28;
    
    /* Cacheimgurl: CACHEIMGURL VARCHAR */
    public static final String PROP_NAME_cacheimgurl = "cacheimgurl";
    public static final int PROP_ID_cacheimgurl = 29;
    
    /* Cacheplateimgurl: CACHEPLATEIMGURL VARCHAR */
    public static final String PROP_NAME_cacheplateimgurl = "cacheplateimgurl";
    public static final int PROP_ID_cacheplateimgurl = 30;
    
    /* Cachetargetimgurl: CACHETARGETIMGURL VARCHAR */
    public static final String PROP_NAME_cachetargetimgurl = "cachetargetimgurl";
    public static final int PROP_ID_cachetargetimgurl = 31;
    
    /* Capcolor: CAPCOLOR VARCHAR */
    public static final String PROP_NAME_capcolor = "capcolor";
    public static final int PROP_ID_capcolor = 32;
    
    /* Capcolorreliability: CAPCOLORRELIABILITY INTEGER */
    public static final String PROP_NAME_capcolorreliability = "capcolorreliability";
    public static final int PROP_ID_capcolorreliability = 33;
    
    /* Capstyle: CAPSTYLE VARCHAR */
    public static final String PROP_NAME_capstyle = "capstyle";
    public static final int PROP_ID_capstyle = 34;
    
    /* Capstylereliability: CAPSTYLERELIABILITY INTEGER */
    public static final String PROP_NAME_capstylereliability = "capstylereliability";
    public static final int PROP_ID_capstylereliability = 35;
    
    /* Captime: CAPTIME BIGINT */
    public static final String PROP_NAME_captime = "captime";
    public static final int PROP_ID_captime = 36;
    
    /* Channelcode: CHANNELCODE VARCHAR */
    public static final String PROP_NAME_channelcode = "channelcode";
    public static final int PROP_ID_channelcode = 37;
    
    /* Channelid: CHANNELID VARCHAR */
    public static final String PROP_NAME_channelid = "channelid";
    public static final int PROP_ID_channelid = 38;
    
    /* Chineseaccentcode: CHINESEACCENTCODE VARCHAR */
    public static final String PROP_NAME_chineseaccentcode = "chineseaccentcode";
    public static final int PROP_ID_chineseaccentcode = 39;
    
    /* Coatcolor: COATCOLOR VARCHAR */
    public static final String PROP_NAME_coatcolor = "coatcolor";
    public static final int PROP_ID_coatcolor = 40;
    
    /* Coatcolorreliability: COATCOLORRELIABILITY INTEGER */
    public static final String PROP_NAME_coatcolorreliability = "coatcolorreliability";
    public static final int PROP_ID_coatcolorreliability = 41;
    
    /* Coatlength: COATLENGTH VARCHAR */
    public static final String PROP_NAME_coatlength = "coatlength";
    public static final int PROP_ID_coatlength = 42;
    
    /* Coatlengthreliability: COATLENGTHRELIABILITY INTEGER */
    public static final String PROP_NAME_coatlengthreliability = "coatlengthreliability";
    public static final int PROP_ID_coatlengthreliability = 43;
    
    /* Coatstyle: COATSTYLE VARCHAR */
    public static final String PROP_NAME_coatstyle = "coatstyle";
    public static final int PROP_ID_coatstyle = 44;
    
    /* Coatstylereliability: COATSTYLERELIABILITY INTEGER */
    public static final String PROP_NAME_coatstylereliability = "coatstylereliability";
    public static final int PROP_ID_coatstylereliability = 45;
    
    /* Coattexture: COATTEXTURE VARCHAR */
    public static final String PROP_NAME_coattexture = "coattexture";
    public static final int PROP_ID_coattexture = 46;
    
    /* Coattexturereliability: COATTEXTURERELIABILITY INTEGER */
    public static final String PROP_NAME_coattexturereliability = "coattexturereliability";
    public static final int PROP_ID_coattexturereliability = 47;
    
    /* Completescore: COMPLETESCORE INTEGER */
    public static final String PROP_NAME_completescore = "completescore";
    public static final int PROP_ID_completescore = 48;
    
    /* Corpseconditioncode: CORPSECONDITIONCODE VARCHAR */
    public static final String PROP_NAME_corpseconditioncode = "corpseconditioncode";
    public static final int PROP_ID_corpseconditioncode = 49;
    
    /* Crimecharactercode: CRIMECHARACTERCODE VARCHAR */
    public static final String PROP_NAME_crimecharactercode = "crimecharactercode";
    public static final int PROP_ID_crimecharactercode = 50;
    
    /* Crimemethod: CRIMEMETHOD VARCHAR */
    public static final String PROP_NAME_crimemethod = "crimemethod";
    public static final int PROP_ID_crimemethod = 51;
    
    /* Criminalinvolvedcode: CRIMINALINVOLVEDCODE VARCHAR */
    public static final String PROP_NAME_criminalinvolvedcode = "criminalinvolvedcode";
    public static final int PROP_ID_criminalinvolvedcode = 52;
    
    /* Datasource: DATASOURCE INTEGER */
    public static final String PROP_NAME_datasource = "datasource";
    public static final int PROP_ID_datasource = 53;
    
    /* Datatracetag: DATATRACETAG VARCHAR */
    public static final String PROP_NAME_datatracetag = "datatracetag";
    public static final int PROP_ID_datatracetag = 54;
    
    /* Detaineesidentity: DETAINEESIDENTITY VARCHAR */
    public static final String PROP_NAME_detaineesidentity = "detaineesidentity";
    public static final int PROP_ID_detaineesidentity = 55;
    
    /* Detaineesspecialidentity: DETAINEESSPECIALIDENTITY VARCHAR */
    public static final String PROP_NAME_detaineesspecialidentity = "detaineesspecialidentity";
    public static final int PROP_ID_detaineesspecialidentity = 56;
    
    /* Detectobject: DETECTOBJECT INTEGER */
    public static final String PROP_NAME_detectobject = "detectobject";
    public static final int PROP_ID_detectobject = 57;
    
    /* Detectionscore: DETECTIONSCORE INTEGER */
    public static final String PROP_NAME_detectionscore = "detectionscore";
    public static final int PROP_ID_detectionscore = 58;
    
    /* Detentionhousecode: DETENTIONHOUSECODE VARCHAR */
    public static final String PROP_NAME_detentionhousecode = "detentionhousecode";
    public static final int PROP_ID_detentionhousecode = 59;
    
    /* Devicecode: DEVICECODE VARCHAR */
    public static final String PROP_NAME_devicecode = "devicecode";
    public static final int PROP_ID_devicecode = 60;
    
    /* Deviceid: DEVICEID VARCHAR */
    public static final String PROP_NAME_deviceid = "deviceid";
    public static final int PROP_ID_deviceid = 61;
    
    /* Emclasstype: EMCLASSTYPE INTEGER */
    public static final String PROP_NAME_emclasstype = "emclasstype";
    public static final int PROP_ID_emclasstype = 62;
    
    /* Escapedcriminalnumber: ESCAPEDCRIMINALNUMBER VARCHAR */
    public static final String PROP_NAME_escapedcriminalnumber = "escapedcriminalnumber";
    public static final int PROP_ID_escapedcriminalnumber = 63;
    
    /* Event: EVENT VARCHAR */
    public static final String PROP_NAME_event = "event";
    public static final int PROP_ID_event = 64;
    
    /* Extrecordid: EXTRECORDID VARCHAR */
    public static final String PROP_NAME_extrecordid = "extrecordid";
    public static final int PROP_ID_extrecordid = 65;
    
    /* Extrecordsource: EXTRECORDSOURCE INTEGER */
    public static final String PROP_NAME_extrecordsource = "extrecordsource";
    public static final int PROP_ID_extrecordsource = 66;
    
    /* Extractedflag: EXTRACTEDFLAG INTEGER */
    public static final String PROP_NAME_extractedflag = "extractedflag";
    public static final int PROP_ID_extractedflag = 67;
    
    /* Facedirect: FACEDIRECT INTEGER */
    public static final String PROP_NAME_facedirect = "facedirect";
    public static final int PROP_ID_facedirect = 68;
    
    /* Facedirectreliability: FACEDIRECTRELIABILITY INTEGER */
    public static final String PROP_NAME_facedirectreliability = "facedirectreliability";
    public static final int PROP_ID_facedirectreliability = 69;
    
    /* Facestyle: FACESTYLE VARCHAR */
    public static final String PROP_NAME_facestyle = "facestyle";
    public static final int PROP_ID_facestyle = 70;
    
    /* Facialfeature: FACIALFEATURE VARCHAR */
    public static final String PROP_NAME_facialfeature = "facialfeature";
    public static final int PROP_ID_facialfeature = 71;
    
    /* Featuredata: FEATUREDATA VARCHAR */
    public static final String PROP_NAME_featuredata = "featuredata";
    public static final int PROP_ID_featuredata = 72;
    
    /* Featureid: FEATUREID VARCHAR */
    public static final String PROP_NAME_featureid = "featureid";
    public static final int PROP_ID_featureid = 73;
    
    /* Gender: GENDER INTEGER */
    public static final String PROP_NAME_gender = "gender";
    public static final int PROP_ID_gender = 74;
    
    /* Genderreliability: GENDERRELIABILITY INTEGER */
    public static final String PROP_NAME_genderreliability = "genderreliability";
    public static final int PROP_ID_genderreliability = 75;
    
    /* Gesture: GESTURE VARCHAR */
    public static final String PROP_NAME_gesture = "gesture";
    public static final int PROP_ID_gesture = 76;
    
    /* Glasscolor: GLASSCOLOR VARCHAR */
    public static final String PROP_NAME_glasscolor = "glasscolor";
    public static final int PROP_ID_glasscolor = 77;
    
    /* Glassstyle: GLASSSTYLE VARCHAR */
    public static final String PROP_NAME_glassstyle = "glassstyle";
    public static final int PROP_ID_glassstyle = 78;
    
    /* Habitualmovemen: HABITUALMOVEMEN VARCHAR */
    public static final String PROP_NAME_habitualmovemen = "habitualmovemen";
    public static final int PROP_ID_habitualmovemen = 79;
    
    /* Haircolor: HAIRCOLOR VARCHAR */
    public static final String PROP_NAME_haircolor = "haircolor";
    public static final int PROP_ID_haircolor = 80;
    
    /* Hairstyle: HAIRSTYLE VARCHAR */
    public static final String PROP_NAME_hairstyle = "hairstyle";
    public static final int PROP_ID_hairstyle = 81;
    
    /* Hairstylereliability: HAIRSTYLERELIABILITY INTEGER */
    public static final String PROP_NAME_hairstylereliability = "hairstylereliability";
    public static final int PROP_ID_hairstylereliability = 82;
    
    /* Hairtype: HAIRTYPE INTEGER */
    public static final String PROP_NAME_hairtype = "hairtype";
    public static final int PROP_ID_hairtype = 83;
    
    /* Hasbag: HASBAG INTEGER */
    public static final String PROP_NAME_hasbag = "hasbag";
    public static final int PROP_ID_hasbag = 84;
    
    /* Hasbagreliability: HASBAGRELIABILITY INTEGER */
    public static final String PROP_NAME_hasbagreliability = "hasbagreliability";
    public static final int PROP_ID_hasbagreliability = 85;
    
    /* Hasbasket: HASBASKET INTEGER */
    public static final String PROP_NAME_hasbasket = "hasbasket";
    public static final int PROP_ID_hasbasket = 86;
    
    /* Hascarrierbag: HASCARRIERBAG INTEGER */
    public static final String PROP_NAME_hascarrierbag = "hascarrierbag";
    public static final int PROP_ID_hascarrierbag = 87;
    
    /* Hascarrystuff: HASCARRYSTUFF INTEGER */
    public static final String PROP_NAME_hascarrystuff = "hascarrystuff";
    public static final int PROP_ID_hascarrystuff = 88;
    
    /* Hascart: HASCART INTEGER */
    public static final String PROP_NAME_hascart = "hascart";
    public static final int PROP_ID_hascart = 89;
    
    /* Hasdownbody: HASDOWNBODY INTEGER */
    public static final String PROP_NAME_hasdownbody = "hasdownbody";
    public static final int PROP_ID_hasdownbody = 90;
    
    /* Hasdownbodyreliability: HASDOWNBODYRELIABILITY INTEGER */
    public static final String PROP_NAME_hasdownbodyreliability = "hasdownbodyreliability";
    public static final int PROP_ID_hasdownbodyreliability = 91;
    
    /* Haserrordetect: HASERRORDETECT INTEGER */
    public static final String PROP_NAME_haserrordetect = "haserrordetect";
    public static final int PROP_ID_haserrordetect = 92;
    
    /* Hashead: HASHEAD INTEGER */
    public static final String PROP_NAME_hashead = "hashead";
    public static final int PROP_ID_hashead = 93;
    
    /* Hasheadreliability: HASHEADRELIABILITY INTEGER */
    public static final String PROP_NAME_hasheadreliability = "hasheadreliability";
    public static final int PROP_ID_hasheadreliability = 94;
    
    /* Hasmirror: HASMIRROR INTEGER */
    public static final String PROP_NAME_hasmirror = "hasmirror";
    public static final int PROP_ID_hasmirror = 95;
    
    /* Hasraincoat: HASRAINCOAT INTEGER */
    public static final String PROP_NAME_hasraincoat = "hasraincoat";
    public static final int PROP_ID_hasraincoat = 96;
    
    /* Hasrespirator: HASRESPIRATOR INTEGER */
    public static final String PROP_NAME_hasrespirator = "hasrespirator";
    public static final int PROP_ID_hasrespirator = 97;
    
    /* Hastrunk: HASTRUNK INTEGER */
    public static final String PROP_NAME_hastrunk = "hastrunk";
    public static final int PROP_ID_hastrunk = 98;
    
    /* Hasvehicle: HASVEHICLE INTEGER */
    public static final String PROP_NAME_hasvehicle = "hasvehicle";
    public static final int PROP_ID_hasvehicle = 99;
    
    /* Hasvest: HASVEST INTEGER */
    public static final String PROP_NAME_hasvest = "hasvest";
    public static final int PROP_ID_hasvest = 100;
    
    /* Hasvestreliability: HASVESTRELIABILITY INTEGER */
    public static final String PROP_NAME_hasvestreliability = "hasvestreliability";
    public static final int PROP_ID_hasvestreliability = 101;
    
    /* Hat: HAT INTEGER */
    public static final String PROP_NAME_hat = "hat";
    public static final int PROP_ID_hat = 102;
    
    /* Hatreliability: HATRELIABILITY INTEGER */
    public static final String PROP_NAME_hatreliability = "hatreliability";
    public static final int PROP_ID_hatreliability = 103;
    
    /* Heightlowerlimit: HEIGHTLOWERLIMIT INTEGER */
    public static final String PROP_NAME_heightlowerlimit = "heightlowerlimit";
    public static final int PROP_ID_heightlowerlimit = 104;
    
    /* Heightuplimit: HEIGHTUPLIMIT INTEGER */
    public static final String PROP_NAME_heightuplimit = "heightuplimit";
    public static final int PROP_ID_heightuplimit = 105;
    
    /* Humanlist: HUMANLIST VARCHAR */
    public static final String PROP_NAME_humanlist = "humanlist";
    public static final int PROP_ID_humanlist = 106;
    
    /* Idnumber: IDNUMBER VARCHAR */
    public static final String PROP_NAME_idnumber = "idnumber";
    public static final int PROP_ID_idnumber = 107;
    
    /* Idtype: IDTYPE VARCHAR */
    public static final String PROP_NAME_idtype = "idtype";
    public static final int PROP_ID_idtype = 108;
    
    /* Imgheight: IMGHEIGHT INTEGER */
    public static final String PROP_NAME_imgheight = "imgheight";
    public static final int PROP_ID_imgheight = 109;
    
    /* Imgurl: IMGURL VARCHAR */
    public static final String PROP_NAME_imgurl = "imgurl";
    public static final int PROP_ID_imgurl = 110;
    
    /* Imgwidth: IMGWIDTH INTEGER */
    public static final String PROP_NAME_imgwidth = "imgwidth";
    public static final int PROP_ID_imgwidth = 111;
    
    /* Immigranttypecode: IMMIGRANTTYPECODE VARCHAR */
    public static final String PROP_NAME_immigranttypecode = "immigranttypecode";
    public static final int PROP_ID_immigranttypecode = 112;
    
    /* Infokind: INFOKIND INTEGER */
    public static final String PROP_NAME_infokind = "infokind";
    public static final int PROP_ID_infokind = 113;
    
    /* Injureddegree: INJUREDDEGREE VARCHAR */
    public static final String PROP_NAME_injureddegree = "injureddegree";
    public static final int PROP_ID_injureddegree = 114;
    
    /* Iqascore: IQASCORE INTEGER */
    public static final String PROP_NAME_iqascore = "iqascore";
    public static final int PROP_ID_iqascore = 115;
    
    /* Iscriminalinvolved: ISCRIMINALINVOLVED INTEGER */
    public static final String PROP_NAME_iscriminalinvolved = "iscriminalinvolved";
    public static final int PROP_ID_iscriminalinvolved = 116;
    
    /* Isdetainees: ISDETAINEES INTEGER */
    public static final String PROP_NAME_isdetainees = "isdetainees";
    public static final int PROP_ID_isdetainees = 117;
    
    /* Isdriver: ISDRIVER INTEGER */
    public static final String PROP_NAME_isdriver = "isdriver";
    public static final int PROP_ID_isdriver = 118;
    
    /* Isforeigner: ISFOREIGNER INTEGER */
    public static final String PROP_NAME_isforeigner = "isforeigner";
    public static final int PROP_ID_isforeigner = 119;
    
    /* Isnoncomplete: ISNONCOMPLETE INTEGER */
    public static final String PROP_NAME_isnoncomplete = "isnoncomplete";
    public static final int PROP_ID_isnoncomplete = 120;
    
    /* Issuspectedterrorist: ISSUSPECTEDTERRORIST INTEGER */
    public static final String PROP_NAME_issuspectedterrorist = "issuspectedterrorist";
    public static final int PROP_ID_issuspectedterrorist = 121;
    
    /* Issuspiciousperson: ISSUSPICIOUSPERSON INTEGER */
    public static final String PROP_NAME_issuspiciousperson = "issuspiciousperson";
    public static final int PROP_ID_issuspiciousperson = 122;
    
    /* Isvictim: ISVICTIM INTEGER */
    public static final String PROP_NAME_isvictim = "isvictim";
    public static final int PROP_ID_isvictim = 123;
    
    /* Jobcategory: JOBCATEGORY VARCHAR */
    public static final String PROP_NAME_jobcategory = "jobcategory";
    public static final int PROP_ID_jobcategory = 124;
    
    /* Locationmarktime: LOCATIONMARKTIME BIGINT */
    public static final String PROP_NAME_locationmarktime = "locationmarktime";
    public static final int PROP_ID_locationmarktime = 125;
    
    /* Mask: MASK INTEGER */
    public static final String PROP_NAME_mask = "mask";
    public static final int PROP_ID_mask = 126;
    
    /* Maskcolor: MASKCOLOR INTEGER */
    public static final String PROP_NAME_maskcolor = "maskcolor";
    public static final int PROP_ID_maskcolor = 127;
    
    /* Membertypecode: MEMBERTYPECODE VARCHAR */
    public static final String PROP_NAME_membertypecode = "membertypecode";
    public static final int PROP_ID_membertypecode = 128;
    
    /* Name: NAME VARCHAR */
    public static final String PROP_NAME_name = "name";
    public static final int PROP_ID_name = 129;
    
    /* Nationalitycode: NATIONALITYCODE VARCHAR */
    public static final String PROP_NAME_nationalitycode = "nationalitycode";
    public static final int PROP_ID_nationalitycode = 130;
    
    /* Nativecitycode: NATIVECITYCODE VARCHAR */
    public static final String PROP_NAME_nativecitycode = "nativecitycode";
    public static final int PROP_ID_nativecitycode = 131;
    
    /* Nonvehicleumbrellacolor: NONVEHICLEUMBRELLACOLOR VARCHAR */
    public static final String PROP_NAME_nonvehicleumbrellacolor = "nonvehicleumbrellacolor";
    public static final int PROP_ID_nonvehicleumbrellacolor = 132;
    
    /* Nonvehicleumbrellatype: NONVEHICLEUMBRELLATYPE INTEGER */
    public static final String PROP_NAME_nonvehicleumbrellatype = "nonvehicleumbrellatype";
    public static final int PROP_ID_nonvehicleumbrellatype = 133;
    
    /* Nonvehicleumbrellatypereliability: NONVEHICLEUMBRELLATYPERELIABILITY INTEGER */
    public static final String PROP_NAME_nonvehicleumbrellatypereliability = "nonvehicleumbrellatypereliability";
    public static final int PROP_ID_nonvehicleumbrellatypereliability = 134;
    
    /* Objsize: OBJSIZE INTEGER */
    public static final String PROP_NAME_objsize = "objsize";
    public static final int PROP_ID_objsize = 135;
    
    /* Objectsubtype: OBJECTSUBTYPE INTEGER */
    public static final String PROP_NAME_objectsubtype = "objectsubtype";
    public static final int PROP_ID_objectsubtype = 136;
    
    /* Passenger: PASSENGER INTEGER */
    public static final String PROP_NAME_passenger = "passenger";
    public static final int PROP_ID_passenger = 137;
    
    /* Passporttype: PASSPORTTYPE VARCHAR */
    public static final String PROP_NAME_passporttype = "passporttype";
    public static final int PROP_ID_passporttype = 138;
    
    /* Personappeartime: PERSONAPPEARTIME BIGINT */
    public static final String PROP_NAME_personappeartime = "personappeartime";
    public static final int PROP_ID_personappeartime = 139;
    
    /* Personbottom: PERSONBOTTOM INTEGER */
    public static final String PROP_NAME_personbottom = "personbottom";
    public static final int PROP_ID_personbottom = 140;
    
    /* Persondisappeartime: PERSONDISAPPEARTIME BIGINT */
    public static final String PROP_NAME_persondisappeartime = "persondisappeartime";
    public static final int PROP_ID_persondisappeartime = 141;
    
    /* Personimgid: PERSONIMGID VARCHAR */
    public static final String PROP_NAME_personimgid = "personimgid";
    public static final int PROP_ID_personimgid = 142;
    
    /* Personleft: PERSONLEFT INTEGER */
    public static final String PROP_NAME_personleft = "personleft";
    public static final int PROP_ID_personleft = 143;
    
    /* Personorg: PERSONORG VARCHAR */
    public static final String PROP_NAME_personorg = "personorg";
    public static final int PROP_ID_personorg = 144;
    
    /* Personright: PERSONRIGHT INTEGER */
    public static final String PROP_NAME_personright = "personright";
    public static final int PROP_ID_personright = 145;
    
    /* Persontop: PERSONTOP INTEGER */
    public static final String PROP_NAME_persontop = "persontop";
    public static final int PROP_ID_persontop = 146;
    
    /* Physicalfeature: PHYSICALFEATURE VARCHAR */
    public static final String PROP_NAME_physicalfeature = "physicalfeature";
    public static final int PROP_ID_physicalfeature = 147;
    
    /* Picrecordid: PICRECORDID VARCHAR */
    public static final String PROP_NAME_picrecordid = "picrecordid";
    public static final int PROP_ID_picrecordid = 148;
    
    /* Platebottom: PLATEBOTTOM INTEGER */
    public static final String PROP_NAME_platebottom = "platebottom";
    public static final int PROP_ID_platebottom = 149;
    
    /* Platecolor: PLATECOLOR VARCHAR */
    public static final String PROP_NAME_platecolor = "platecolor";
    public static final int PROP_ID_platecolor = 150;
    
    /* Plateimgurl: PLATEIMGURL VARCHAR */
    public static final String PROP_NAME_plateimgurl = "plateimgurl";
    public static final int PROP_ID_plateimgurl = 151;
    
    /* Plateleft: PLATELEFT INTEGER */
    public static final String PROP_NAME_plateleft = "plateleft";
    public static final int PROP_ID_plateleft = 152;
    
    /* Platenum: PLATENUM VARCHAR */
    public static final String PROP_NAME_platenum = "platenum";
    public static final int PROP_ID_platenum = 153;
    
    /* Plateright: PLATERIGHT INTEGER */
    public static final String PROP_NAME_plateright = "plateright";
    public static final int PROP_ID_plateright = 154;
    
    /* Platetop: PLATETOP INTEGER */
    public static final String PROP_NAME_platetop = "platetop";
    public static final int PROP_ID_platetop = 155;
    
    /* Posture: POSTURE INTEGER */
    public static final String PROP_NAME_posture = "posture";
    public static final int PROP_ID_posture = 156;
    
    /* Posturereliability: POSTURERELIABILITY INTEGER */
    public static final String PROP_NAME_posturereliability = "posturereliability";
    public static final int PROP_ID_posturereliability = 157;
    
    /* Prevmsgrecordid: PREVMSGRECORDID VARCHAR */
    public static final String PROP_NAME_prevmsgrecordid = "prevmsgrecordid";
    public static final int PROP_ID_prevmsgrecordid = 158;
    
    /* Qescore: QESCORE INTEGER */
    public static final String PROP_NAME_qescore = "qescore";
    public static final int PROP_ID_qescore = 159;
    
    /* Raincoatreliability: RAINCOATRELIABILITY INTEGER */
    public static final String PROP_NAME_raincoatreliability = "raincoatreliability";
    public static final int PROP_ID_raincoatreliability = 160;
    
    /* Recordid: RECORDID VARCHAR */
    public static final String PROP_NAME_recordid = "recordid";
    public static final int PROP_ID_recordid = 161;
    
    /* Relatedface: RELATEDFACE INTEGER */
    public static final String PROP_NAME_relatedface = "relatedface";
    public static final int PROP_ID_relatedface = 162;
    
    /* Relatedgait: RELATEDGAIT INTEGER */
    public static final String PROP_NAME_relatedgait = "relatedgait";
    public static final int PROP_ID_relatedgait = 163;
    
    /* Relatednonvehicle: RELATEDNONVEHICLE INTEGER */
    public static final String PROP_NAME_relatednonvehicle = "relatednonvehicle";
    public static final int PROP_ID_relatednonvehicle = 164;
    
    /* Relatednonvehiclelist: RELATEDNONVEHICLELIST VARCHAR */
    public static final String PROP_NAME_relatednonvehiclelist = "relatednonvehiclelist";
    public static final int PROP_ID_relatednonvehiclelist = 165;
    
    /* Relatedperson: RELATEDPERSON INTEGER */
    public static final String PROP_NAME_relatedperson = "relatedperson";
    public static final int PROP_ID_relatedperson = 166;
    
    /* Reliablity: RELIABLITY INTEGER */
    public static final String PROP_NAME_reliablity = "reliablity";
    public static final int PROP_ID_reliablity = 167;
    
    /* Residenceadmindivision: RESIDENCEADMINDIVISION VARCHAR */
    public static final String PROP_NAME_residenceadmindivision = "residenceadmindivision";
    public static final int PROP_ID_residenceadmindivision = 168;
    
    /* Respiratorcolor: RESPIRATORCOLOR VARCHAR */
    public static final String PROP_NAME_respiratorcolor = "respiratorcolor";
    public static final int PROP_ID_respiratorcolor = 169;
    
    /* Rfidinfo: RFIDINFO VARCHAR */
    public static final String PROP_NAME_rfidinfo = "rfidinfo";
    public static final int PROP_ID_rfidinfo = 170;
    
    /* Ridervehicle: RIDERVEHICLE INTEGER */
    public static final String PROP_NAME_ridervehicle = "ridervehicle";
    public static final int PROP_ID_ridervehicle = 171;
    
    /* Snumber: SNUMBER VARCHAR */
    public static final String PROP_NAME_snumber = "snumber";
    public static final int PROP_ID_snumber = 172;
    
    /* Scarfcolor: SCARFCOLOR VARCHAR */
    public static final String PROP_NAME_scarfcolor = "scarfcolor";
    public static final int PROP_ID_scarfcolor = 173;
    
    /* Shoescolor: SHOESCOLOR VARCHAR */
    public static final String PROP_NAME_shoescolor = "shoescolor";
    public static final int PROP_ID_shoescolor = 174;
    
    /* Shoesstyle: SHOESSTYLE VARCHAR */
    public static final String PROP_NAME_shoesstyle = "shoesstyle";
    public static final int PROP_ID_shoesstyle = 175;
    
    /* Skincolor: SKINCOLOR VARCHAR */
    public static final String PROP_NAME_skincolor = "skincolor";
    public static final int PROP_ID_skincolor = 176;
    
    /* Sourceid: SOURCEID VARCHAR */
    public static final String PROP_NAME_sourceid = "sourceid";
    public static final int PROP_ID_sourceid = 177;
    
    /* Status: STATUS VARCHAR */
    public static final String PROP_NAME_status = "status";
    public static final int PROP_ID_status = 178;
    
    /* Suspectedterroristnumber: SUSPECTEDTERRORISTNUMBER VARCHAR */
    public static final String PROP_NAME_suspectedterroristnumber = "suspectedterroristnumber";
    public static final int PROP_ID_suspectedterroristnumber = 179;
    
    /* Targetimgurl: TARGETIMGURL VARCHAR */
    public static final String PROP_NAME_targetimgurl = "targetimgurl";
    public static final int PROP_ID_targetimgurl = 180;
    
    /* Traceserviceinputtime: TRACESERVICEINPUTTIME BIGINT */
    public static final String PROP_NAME_traceserviceinputtime = "traceserviceinputtime";
    public static final int PROP_ID_traceserviceinputtime = 181;
    
    /* Tracethingsinputtime: TRACETHINGSINPUTTIME BIGINT */
    public static final String PROP_NAME_tracethingsinputtime = "tracethingsinputtime";
    public static final int PROP_ID_tracethingsinputtime = 182;
    
    /* Trouserscolor: TROUSERSCOLOR VARCHAR */
    public static final String PROP_NAME_trouserscolor = "trouserscolor";
    public static final int PROP_ID_trouserscolor = 183;
    
    /* Trouserscolorreliability: TROUSERSCOLORRELIABILITY INTEGER */
    public static final String PROP_NAME_trouserscolorreliability = "trouserscolorreliability";
    public static final int PROP_ID_trouserscolorreliability = 184;
    
    /* Trouserslen: TROUSERSLEN VARCHAR */
    public static final String PROP_NAME_trouserslen = "trouserslen";
    public static final int PROP_ID_trouserslen = 185;
    
    /* Trouserslenreliability: TROUSERSLENRELIABILITY INTEGER */
    public static final String PROP_NAME_trouserslenreliability = "trouserslenreliability";
    public static final int PROP_ID_trouserslenreliability = 186;
    
    /* Trousersstyle: TROUSERSSTYLE VARCHAR */
    public static final String PROP_NAME_trousersstyle = "trousersstyle";
    public static final int PROP_ID_trousersstyle = 187;
    
    /* Uid: UID VARCHAR */
    public static final String PROP_NAME_uid = "uid";
    public static final int PROP_ID_uid = 188;
    
    /* Umbrella: UMBRELLA INTEGER */
    public static final String PROP_NAME_umbrella = "umbrella";
    public static final int PROP_ID_umbrella = 189;
    
    /* Umbrellacolor: UMBRELLACOLOR VARCHAR */
    public static final String PROP_NAME_umbrellacolor = "umbrellacolor";
    public static final int PROP_ID_umbrellacolor = 190;
    
    /* Umbrellareliability: UMBRELLARELIABILITY INTEGER */
    public static final String PROP_NAME_umbrellareliability = "umbrellareliability";
    public static final int PROP_ID_umbrellareliability = 191;
    
    /* Uniformstyle: UNIFORMSTYLE INTEGER */
    public static final String PROP_NAME_uniformstyle = "uniformstyle";
    public static final int PROP_ID_uniformstyle = 192;
    
    /* Uniformstylereliability: UNIFORMSTYLERELIABILITY INTEGER */
    public static final String PROP_NAME_uniformstylereliability = "uniformstylereliability";
    public static final int PROP_ID_uniformstylereliability = 193;
    
    /* Usedname: USEDNAME VARCHAR */
    public static final String PROP_NAME_usedname = "usedname";
    public static final int PROP_ID_usedname = 194;
    
    /* Userchannelcode: USERCHANNELCODE VARCHAR */
    public static final String PROP_NAME_userchannelcode = "userchannelcode";
    public static final int PROP_ID_userchannelcode = 195;
    
    /* Vehiclecolor: VEHICLECOLOR VARCHAR */
    public static final String PROP_NAME_vehiclecolor = "vehiclecolor";
    public static final int PROP_ID_vehiclecolor = 196;
    
    /* Vehicletype: VEHICLETYPE INTEGER */
    public static final String PROP_NAME_vehicletype = "vehicletype";
    public static final int PROP_ID_vehicletype = 197;
    
    /* Vehicletypereliability: VEHICLETYPERELIABILITY INTEGER */
    public static final String PROP_NAME_vehicletypereliability = "vehicletypereliability";
    public static final int PROP_ID_vehicletypereliability = 198;
    
    /* Vendor: VENDOR VARCHAR */
    public static final String PROP_NAME_vendor = "vendor";
    public static final int PROP_ID_vendor = 199;
    
    /* Victimtype: VICTIMTYPE VARCHAR */
    public static final String PROP_NAME_victimtype = "victimtype";
    public static final int PROP_ID_victimtype = 200;
    

    private static int _PROP_ID_BOUND = 201;

    

    protected static final List<String> PK_PROP_NAMES = Arrays.asList(PROP_NAME_absscore);
    protected static final int[] PK_PROP_IDS = new int[]{PROP_ID_absscore};

    private static final String[] PROP_ID_TO_NAME = new String[201];
    private static final Map<String,Integer> PROP_NAME_TO_ID = new HashMap<>();
    static{
      
          PROP_ID_TO_NAME[PROP_ID_absscore] = PROP_NAME_absscore;
          PROP_NAME_TO_ID.put(PROP_NAME_absscore, PROP_ID_absscore);
      
          PROP_ID_TO_NAME[PROP_ID_accompanynumber] = PROP_NAME_accompanynumber;
          PROP_NAME_TO_ID.put(PROP_NAME_accompanynumber, PROP_ID_accompanynumber);
      
          PROP_ID_TO_NAME[PROP_ID_accompanynumberreliability] = PROP_NAME_accompanynumberreliability;
          PROP_NAME_TO_ID.put(PROP_NAME_accompanynumberreliability, PROP_ID_accompanynumberreliability);
      
          PROP_ID_TO_NAME[PROP_ID_age] = PROP_NAME_age;
          PROP_NAME_TO_ID.put(PROP_NAME_age, PROP_ID_age);
      
          PROP_ID_TO_NAME[PROP_ID_agegroup] = PROP_NAME_agegroup;
          PROP_NAME_TO_ID.put(PROP_NAME_agegroup, PROP_ID_agegroup);
      
          PROP_ID_TO_NAME[PROP_ID_agegroupreliability] = PROP_NAME_agegroupreliability;
          PROP_NAME_TO_ID.put(PROP_NAME_agegroupreliability, PROP_ID_agegroupreliability);
      
          PROP_ID_TO_NAME[PROP_ID_agelowerlimit] = PROP_NAME_agelowerlimit;
          PROP_NAME_TO_ID.put(PROP_NAME_agelowerlimit, PROP_ID_agelowerlimit);
      
          PROP_ID_TO_NAME[PROP_ID_agereliability] = PROP_NAME_agereliability;
          PROP_NAME_TO_ID.put(PROP_NAME_agereliability, PROP_ID_agereliability);
      
          PROP_ID_TO_NAME[PROP_ID_ageuplimit] = PROP_NAME_ageuplimit;
          PROP_NAME_TO_ID.put(PROP_NAME_ageuplimit, PROP_ID_ageuplimit);
      
          PROP_ID_TO_NAME[PROP_ID_algorithmversion] = PROP_NAME_algorithmversion;
          PROP_NAME_TO_ID.put(PROP_NAME_algorithmversion, PROP_ID_algorithmversion);
      
          PROP_ID_TO_NAME[PROP_ID_alias] = PROP_NAME_alias;
          PROP_NAME_TO_ID.put(PROP_NAME_alias, PROP_ID_alias);
      
          PROP_ID_TO_NAME[PROP_ID_appendant] = PROP_NAME_appendant;
          PROP_NAME_TO_ID.put(PROP_NAME_appendant, PROP_ID_appendant);
      
          PROP_ID_TO_NAME[PROP_ID_appendantdescription] = PROP_NAME_appendantdescription;
          PROP_NAME_TO_ID.put(PROP_NAME_appendantdescription, PROP_ID_appendantdescription);
      
          PROP_ID_TO_NAME[PROP_ID_baby] = PROP_NAME_baby;
          PROP_NAME_TO_ID.put(PROP_NAME_baby, PROP_ID_baby);
      
          PROP_ID_TO_NAME[PROP_ID_bag1reliability] = PROP_NAME_bag1reliability;
          PROP_NAME_TO_ID.put(PROP_NAME_bag1reliability, PROP_ID_bag1reliability);
      
          PROP_ID_TO_NAME[PROP_ID_bag1style] = PROP_NAME_bag1style;
          PROP_NAME_TO_ID.put(PROP_NAME_bag1style, PROP_ID_bag1style);
      
          PROP_ID_TO_NAME[PROP_ID_bag2reliability] = PROP_NAME_bag2reliability;
          PROP_NAME_TO_ID.put(PROP_NAME_bag2reliability, PROP_ID_bag2reliability);
      
          PROP_ID_TO_NAME[PROP_ID_bag2style] = PROP_NAME_bag2style;
          PROP_NAME_TO_ID.put(PROP_NAME_bag2style, PROP_ID_bag2style);
      
          PROP_ID_TO_NAME[PROP_ID_bag3reliability] = PROP_NAME_bag3reliability;
          PROP_NAME_TO_ID.put(PROP_NAME_bag3reliability, PROP_ID_bag3reliability);
      
          PROP_ID_TO_NAME[PROP_ID_bag3style] = PROP_NAME_bag3style;
          PROP_NAME_TO_ID.put(PROP_NAME_bag3style, PROP_ID_bag3style);
      
          PROP_ID_TO_NAME[PROP_ID_bagcolor] = PROP_NAME_bagcolor;
          PROP_NAME_TO_ID.put(PROP_NAME_bagcolor, PROP_ID_bagcolor);
      
          PROP_ID_TO_NAME[PROP_ID_bagstyle] = PROP_NAME_bagstyle;
          PROP_NAME_TO_ID.put(PROP_NAME_bagstyle, PROP_ID_bagstyle);
      
          PROP_ID_TO_NAME[PROP_ID_bagstylereliability] = PROP_NAME_bagstylereliability;
          PROP_NAME_TO_ID.put(PROP_NAME_bagstylereliability, PROP_ID_bagstylereliability);
      
          PROP_ID_TO_NAME[PROP_ID_behavior] = PROP_NAME_behavior;
          PROP_NAME_TO_ID.put(PROP_NAME_behavior, PROP_ID_behavior);
      
          PROP_ID_TO_NAME[PROP_ID_behaviordescription] = PROP_NAME_behaviordescription;
          PROP_NAME_TO_ID.put(PROP_NAME_behaviordescription, PROP_ID_behaviordescription);
      
          PROP_ID_TO_NAME[PROP_ID_bodyfeature] = PROP_NAME_bodyfeature;
          PROP_NAME_TO_ID.put(PROP_NAME_bodyfeature, PROP_ID_bodyfeature);
      
          PROP_ID_TO_NAME[PROP_ID_bodyspeciallmark] = PROP_NAME_bodyspeciallmark;
          PROP_NAME_TO_ID.put(PROP_NAME_bodyspeciallmark, PROP_ID_bodyspeciallmark);
      
          PROP_ID_TO_NAME[PROP_ID_bodytype] = PROP_NAME_bodytype;
          PROP_NAME_TO_ID.put(PROP_NAME_bodytype, PROP_ID_bodytype);
      
          PROP_ID_TO_NAME[PROP_ID_cacheimgurl] = PROP_NAME_cacheimgurl;
          PROP_NAME_TO_ID.put(PROP_NAME_cacheimgurl, PROP_ID_cacheimgurl);
      
          PROP_ID_TO_NAME[PROP_ID_cacheplateimgurl] = PROP_NAME_cacheplateimgurl;
          PROP_NAME_TO_ID.put(PROP_NAME_cacheplateimgurl, PROP_ID_cacheplateimgurl);
      
          PROP_ID_TO_NAME[PROP_ID_cachetargetimgurl] = PROP_NAME_cachetargetimgurl;
          PROP_NAME_TO_ID.put(PROP_NAME_cachetargetimgurl, PROP_ID_cachetargetimgurl);
      
          PROP_ID_TO_NAME[PROP_ID_capcolor] = PROP_NAME_capcolor;
          PROP_NAME_TO_ID.put(PROP_NAME_capcolor, PROP_ID_capcolor);
      
          PROP_ID_TO_NAME[PROP_ID_capcolorreliability] = PROP_NAME_capcolorreliability;
          PROP_NAME_TO_ID.put(PROP_NAME_capcolorreliability, PROP_ID_capcolorreliability);
      
          PROP_ID_TO_NAME[PROP_ID_capstyle] = PROP_NAME_capstyle;
          PROP_NAME_TO_ID.put(PROP_NAME_capstyle, PROP_ID_capstyle);
      
          PROP_ID_TO_NAME[PROP_ID_capstylereliability] = PROP_NAME_capstylereliability;
          PROP_NAME_TO_ID.put(PROP_NAME_capstylereliability, PROP_ID_capstylereliability);
      
          PROP_ID_TO_NAME[PROP_ID_captime] = PROP_NAME_captime;
          PROP_NAME_TO_ID.put(PROP_NAME_captime, PROP_ID_captime);
      
          PROP_ID_TO_NAME[PROP_ID_channelcode] = PROP_NAME_channelcode;
          PROP_NAME_TO_ID.put(PROP_NAME_channelcode, PROP_ID_channelcode);
      
          PROP_ID_TO_NAME[PROP_ID_channelid] = PROP_NAME_channelid;
          PROP_NAME_TO_ID.put(PROP_NAME_channelid, PROP_ID_channelid);
      
          PROP_ID_TO_NAME[PROP_ID_chineseaccentcode] = PROP_NAME_chineseaccentcode;
          PROP_NAME_TO_ID.put(PROP_NAME_chineseaccentcode, PROP_ID_chineseaccentcode);
      
          PROP_ID_TO_NAME[PROP_ID_coatcolor] = PROP_NAME_coatcolor;
          PROP_NAME_TO_ID.put(PROP_NAME_coatcolor, PROP_ID_coatcolor);
      
          PROP_ID_TO_NAME[PROP_ID_coatcolorreliability] = PROP_NAME_coatcolorreliability;
          PROP_NAME_TO_ID.put(PROP_NAME_coatcolorreliability, PROP_ID_coatcolorreliability);
      
          PROP_ID_TO_NAME[PROP_ID_coatlength] = PROP_NAME_coatlength;
          PROP_NAME_TO_ID.put(PROP_NAME_coatlength, PROP_ID_coatlength);
      
          PROP_ID_TO_NAME[PROP_ID_coatlengthreliability] = PROP_NAME_coatlengthreliability;
          PROP_NAME_TO_ID.put(PROP_NAME_coatlengthreliability, PROP_ID_coatlengthreliability);
      
          PROP_ID_TO_NAME[PROP_ID_coatstyle] = PROP_NAME_coatstyle;
          PROP_NAME_TO_ID.put(PROP_NAME_coatstyle, PROP_ID_coatstyle);
      
          PROP_ID_TO_NAME[PROP_ID_coatstylereliability] = PROP_NAME_coatstylereliability;
          PROP_NAME_TO_ID.put(PROP_NAME_coatstylereliability, PROP_ID_coatstylereliability);
      
          PROP_ID_TO_NAME[PROP_ID_coattexture] = PROP_NAME_coattexture;
          PROP_NAME_TO_ID.put(PROP_NAME_coattexture, PROP_ID_coattexture);
      
          PROP_ID_TO_NAME[PROP_ID_coattexturereliability] = PROP_NAME_coattexturereliability;
          PROP_NAME_TO_ID.put(PROP_NAME_coattexturereliability, PROP_ID_coattexturereliability);
      
          PROP_ID_TO_NAME[PROP_ID_completescore] = PROP_NAME_completescore;
          PROP_NAME_TO_ID.put(PROP_NAME_completescore, PROP_ID_completescore);
      
          PROP_ID_TO_NAME[PROP_ID_corpseconditioncode] = PROP_NAME_corpseconditioncode;
          PROP_NAME_TO_ID.put(PROP_NAME_corpseconditioncode, PROP_ID_corpseconditioncode);
      
          PROP_ID_TO_NAME[PROP_ID_crimecharactercode] = PROP_NAME_crimecharactercode;
          PROP_NAME_TO_ID.put(PROP_NAME_crimecharactercode, PROP_ID_crimecharactercode);
      
          PROP_ID_TO_NAME[PROP_ID_crimemethod] = PROP_NAME_crimemethod;
          PROP_NAME_TO_ID.put(PROP_NAME_crimemethod, PROP_ID_crimemethod);
      
          PROP_ID_TO_NAME[PROP_ID_criminalinvolvedcode] = PROP_NAME_criminalinvolvedcode;
          PROP_NAME_TO_ID.put(PROP_NAME_criminalinvolvedcode, PROP_ID_criminalinvolvedcode);
      
          PROP_ID_TO_NAME[PROP_ID_datasource] = PROP_NAME_datasource;
          PROP_NAME_TO_ID.put(PROP_NAME_datasource, PROP_ID_datasource);
      
          PROP_ID_TO_NAME[PROP_ID_datatracetag] = PROP_NAME_datatracetag;
          PROP_NAME_TO_ID.put(PROP_NAME_datatracetag, PROP_ID_datatracetag);
      
          PROP_ID_TO_NAME[PROP_ID_detaineesidentity] = PROP_NAME_detaineesidentity;
          PROP_NAME_TO_ID.put(PROP_NAME_detaineesidentity, PROP_ID_detaineesidentity);
      
          PROP_ID_TO_NAME[PROP_ID_detaineesspecialidentity] = PROP_NAME_detaineesspecialidentity;
          PROP_NAME_TO_ID.put(PROP_NAME_detaineesspecialidentity, PROP_ID_detaineesspecialidentity);
      
          PROP_ID_TO_NAME[PROP_ID_detectobject] = PROP_NAME_detectobject;
          PROP_NAME_TO_ID.put(PROP_NAME_detectobject, PROP_ID_detectobject);
      
          PROP_ID_TO_NAME[PROP_ID_detectionscore] = PROP_NAME_detectionscore;
          PROP_NAME_TO_ID.put(PROP_NAME_detectionscore, PROP_ID_detectionscore);
      
          PROP_ID_TO_NAME[PROP_ID_detentionhousecode] = PROP_NAME_detentionhousecode;
          PROP_NAME_TO_ID.put(PROP_NAME_detentionhousecode, PROP_ID_detentionhousecode);
      
          PROP_ID_TO_NAME[PROP_ID_devicecode] = PROP_NAME_devicecode;
          PROP_NAME_TO_ID.put(PROP_NAME_devicecode, PROP_ID_devicecode);
      
          PROP_ID_TO_NAME[PROP_ID_deviceid] = PROP_NAME_deviceid;
          PROP_NAME_TO_ID.put(PROP_NAME_deviceid, PROP_ID_deviceid);
      
          PROP_ID_TO_NAME[PROP_ID_emclasstype] = PROP_NAME_emclasstype;
          PROP_NAME_TO_ID.put(PROP_NAME_emclasstype, PROP_ID_emclasstype);
      
          PROP_ID_TO_NAME[PROP_ID_escapedcriminalnumber] = PROP_NAME_escapedcriminalnumber;
          PROP_NAME_TO_ID.put(PROP_NAME_escapedcriminalnumber, PROP_ID_escapedcriminalnumber);
      
          PROP_ID_TO_NAME[PROP_ID_event] = PROP_NAME_event;
          PROP_NAME_TO_ID.put(PROP_NAME_event, PROP_ID_event);
      
          PROP_ID_TO_NAME[PROP_ID_extrecordid] = PROP_NAME_extrecordid;
          PROP_NAME_TO_ID.put(PROP_NAME_extrecordid, PROP_ID_extrecordid);
      
          PROP_ID_TO_NAME[PROP_ID_extrecordsource] = PROP_NAME_extrecordsource;
          PROP_NAME_TO_ID.put(PROP_NAME_extrecordsource, PROP_ID_extrecordsource);
      
          PROP_ID_TO_NAME[PROP_ID_extractedflag] = PROP_NAME_extractedflag;
          PROP_NAME_TO_ID.put(PROP_NAME_extractedflag, PROP_ID_extractedflag);
      
          PROP_ID_TO_NAME[PROP_ID_facedirect] = PROP_NAME_facedirect;
          PROP_NAME_TO_ID.put(PROP_NAME_facedirect, PROP_ID_facedirect);
      
          PROP_ID_TO_NAME[PROP_ID_facedirectreliability] = PROP_NAME_facedirectreliability;
          PROP_NAME_TO_ID.put(PROP_NAME_facedirectreliability, PROP_ID_facedirectreliability);
      
          PROP_ID_TO_NAME[PROP_ID_facestyle] = PROP_NAME_facestyle;
          PROP_NAME_TO_ID.put(PROP_NAME_facestyle, PROP_ID_facestyle);
      
          PROP_ID_TO_NAME[PROP_ID_facialfeature] = PROP_NAME_facialfeature;
          PROP_NAME_TO_ID.put(PROP_NAME_facialfeature, PROP_ID_facialfeature);
      
          PROP_ID_TO_NAME[PROP_ID_featuredata] = PROP_NAME_featuredata;
          PROP_NAME_TO_ID.put(PROP_NAME_featuredata, PROP_ID_featuredata);
      
          PROP_ID_TO_NAME[PROP_ID_featureid] = PROP_NAME_featureid;
          PROP_NAME_TO_ID.put(PROP_NAME_featureid, PROP_ID_featureid);
      
          PROP_ID_TO_NAME[PROP_ID_gender] = PROP_NAME_gender;
          PROP_NAME_TO_ID.put(PROP_NAME_gender, PROP_ID_gender);
      
          PROP_ID_TO_NAME[PROP_ID_genderreliability] = PROP_NAME_genderreliability;
          PROP_NAME_TO_ID.put(PROP_NAME_genderreliability, PROP_ID_genderreliability);
      
          PROP_ID_TO_NAME[PROP_ID_gesture] = PROP_NAME_gesture;
          PROP_NAME_TO_ID.put(PROP_NAME_gesture, PROP_ID_gesture);
      
          PROP_ID_TO_NAME[PROP_ID_glasscolor] = PROP_NAME_glasscolor;
          PROP_NAME_TO_ID.put(PROP_NAME_glasscolor, PROP_ID_glasscolor);
      
          PROP_ID_TO_NAME[PROP_ID_glassstyle] = PROP_NAME_glassstyle;
          PROP_NAME_TO_ID.put(PROP_NAME_glassstyle, PROP_ID_glassstyle);
      
          PROP_ID_TO_NAME[PROP_ID_habitualmovemen] = PROP_NAME_habitualmovemen;
          PROP_NAME_TO_ID.put(PROP_NAME_habitualmovemen, PROP_ID_habitualmovemen);
      
          PROP_ID_TO_NAME[PROP_ID_haircolor] = PROP_NAME_haircolor;
          PROP_NAME_TO_ID.put(PROP_NAME_haircolor, PROP_ID_haircolor);
      
          PROP_ID_TO_NAME[PROP_ID_hairstyle] = PROP_NAME_hairstyle;
          PROP_NAME_TO_ID.put(PROP_NAME_hairstyle, PROP_ID_hairstyle);
      
          PROP_ID_TO_NAME[PROP_ID_hairstylereliability] = PROP_NAME_hairstylereliability;
          PROP_NAME_TO_ID.put(PROP_NAME_hairstylereliability, PROP_ID_hairstylereliability);
      
          PROP_ID_TO_NAME[PROP_ID_hairtype] = PROP_NAME_hairtype;
          PROP_NAME_TO_ID.put(PROP_NAME_hairtype, PROP_ID_hairtype);
      
          PROP_ID_TO_NAME[PROP_ID_hasbag] = PROP_NAME_hasbag;
          PROP_NAME_TO_ID.put(PROP_NAME_hasbag, PROP_ID_hasbag);
      
          PROP_ID_TO_NAME[PROP_ID_hasbagreliability] = PROP_NAME_hasbagreliability;
          PROP_NAME_TO_ID.put(PROP_NAME_hasbagreliability, PROP_ID_hasbagreliability);
      
          PROP_ID_TO_NAME[PROP_ID_hasbasket] = PROP_NAME_hasbasket;
          PROP_NAME_TO_ID.put(PROP_NAME_hasbasket, PROP_ID_hasbasket);
      
          PROP_ID_TO_NAME[PROP_ID_hascarrierbag] = PROP_NAME_hascarrierbag;
          PROP_NAME_TO_ID.put(PROP_NAME_hascarrierbag, PROP_ID_hascarrierbag);
      
          PROP_ID_TO_NAME[PROP_ID_hascarrystuff] = PROP_NAME_hascarrystuff;
          PROP_NAME_TO_ID.put(PROP_NAME_hascarrystuff, PROP_ID_hascarrystuff);
      
          PROP_ID_TO_NAME[PROP_ID_hascart] = PROP_NAME_hascart;
          PROP_NAME_TO_ID.put(PROP_NAME_hascart, PROP_ID_hascart);
      
          PROP_ID_TO_NAME[PROP_ID_hasdownbody] = PROP_NAME_hasdownbody;
          PROP_NAME_TO_ID.put(PROP_NAME_hasdownbody, PROP_ID_hasdownbody);
      
          PROP_ID_TO_NAME[PROP_ID_hasdownbodyreliability] = PROP_NAME_hasdownbodyreliability;
          PROP_NAME_TO_ID.put(PROP_NAME_hasdownbodyreliability, PROP_ID_hasdownbodyreliability);
      
          PROP_ID_TO_NAME[PROP_ID_haserrordetect] = PROP_NAME_haserrordetect;
          PROP_NAME_TO_ID.put(PROP_NAME_haserrordetect, PROP_ID_haserrordetect);
      
          PROP_ID_TO_NAME[PROP_ID_hashead] = PROP_NAME_hashead;
          PROP_NAME_TO_ID.put(PROP_NAME_hashead, PROP_ID_hashead);
      
          PROP_ID_TO_NAME[PROP_ID_hasheadreliability] = PROP_NAME_hasheadreliability;
          PROP_NAME_TO_ID.put(PROP_NAME_hasheadreliability, PROP_ID_hasheadreliability);
      
          PROP_ID_TO_NAME[PROP_ID_hasmirror] = PROP_NAME_hasmirror;
          PROP_NAME_TO_ID.put(PROP_NAME_hasmirror, PROP_ID_hasmirror);
      
          PROP_ID_TO_NAME[PROP_ID_hasraincoat] = PROP_NAME_hasraincoat;
          PROP_NAME_TO_ID.put(PROP_NAME_hasraincoat, PROP_ID_hasraincoat);
      
          PROP_ID_TO_NAME[PROP_ID_hasrespirator] = PROP_NAME_hasrespirator;
          PROP_NAME_TO_ID.put(PROP_NAME_hasrespirator, PROP_ID_hasrespirator);
      
          PROP_ID_TO_NAME[PROP_ID_hastrunk] = PROP_NAME_hastrunk;
          PROP_NAME_TO_ID.put(PROP_NAME_hastrunk, PROP_ID_hastrunk);
      
          PROP_ID_TO_NAME[PROP_ID_hasvehicle] = PROP_NAME_hasvehicle;
          PROP_NAME_TO_ID.put(PROP_NAME_hasvehicle, PROP_ID_hasvehicle);
      
          PROP_ID_TO_NAME[PROP_ID_hasvest] = PROP_NAME_hasvest;
          PROP_NAME_TO_ID.put(PROP_NAME_hasvest, PROP_ID_hasvest);
      
          PROP_ID_TO_NAME[PROP_ID_hasvestreliability] = PROP_NAME_hasvestreliability;
          PROP_NAME_TO_ID.put(PROP_NAME_hasvestreliability, PROP_ID_hasvestreliability);
      
          PROP_ID_TO_NAME[PROP_ID_hat] = PROP_NAME_hat;
          PROP_NAME_TO_ID.put(PROP_NAME_hat, PROP_ID_hat);
      
          PROP_ID_TO_NAME[PROP_ID_hatreliability] = PROP_NAME_hatreliability;
          PROP_NAME_TO_ID.put(PROP_NAME_hatreliability, PROP_ID_hatreliability);
      
          PROP_ID_TO_NAME[PROP_ID_heightlowerlimit] = PROP_NAME_heightlowerlimit;
          PROP_NAME_TO_ID.put(PROP_NAME_heightlowerlimit, PROP_ID_heightlowerlimit);
      
          PROP_ID_TO_NAME[PROP_ID_heightuplimit] = PROP_NAME_heightuplimit;
          PROP_NAME_TO_ID.put(PROP_NAME_heightuplimit, PROP_ID_heightuplimit);
      
          PROP_ID_TO_NAME[PROP_ID_humanlist] = PROP_NAME_humanlist;
          PROP_NAME_TO_ID.put(PROP_NAME_humanlist, PROP_ID_humanlist);
      
          PROP_ID_TO_NAME[PROP_ID_idnumber] = PROP_NAME_idnumber;
          PROP_NAME_TO_ID.put(PROP_NAME_idnumber, PROP_ID_idnumber);
      
          PROP_ID_TO_NAME[PROP_ID_idtype] = PROP_NAME_idtype;
          PROP_NAME_TO_ID.put(PROP_NAME_idtype, PROP_ID_idtype);
      
          PROP_ID_TO_NAME[PROP_ID_imgheight] = PROP_NAME_imgheight;
          PROP_NAME_TO_ID.put(PROP_NAME_imgheight, PROP_ID_imgheight);
      
          PROP_ID_TO_NAME[PROP_ID_imgurl] = PROP_NAME_imgurl;
          PROP_NAME_TO_ID.put(PROP_NAME_imgurl, PROP_ID_imgurl);
      
          PROP_ID_TO_NAME[PROP_ID_imgwidth] = PROP_NAME_imgwidth;
          PROP_NAME_TO_ID.put(PROP_NAME_imgwidth, PROP_ID_imgwidth);
      
          PROP_ID_TO_NAME[PROP_ID_immigranttypecode] = PROP_NAME_immigranttypecode;
          PROP_NAME_TO_ID.put(PROP_NAME_immigranttypecode, PROP_ID_immigranttypecode);
      
          PROP_ID_TO_NAME[PROP_ID_infokind] = PROP_NAME_infokind;
          PROP_NAME_TO_ID.put(PROP_NAME_infokind, PROP_ID_infokind);
      
          PROP_ID_TO_NAME[PROP_ID_injureddegree] = PROP_NAME_injureddegree;
          PROP_NAME_TO_ID.put(PROP_NAME_injureddegree, PROP_ID_injureddegree);
      
          PROP_ID_TO_NAME[PROP_ID_iqascore] = PROP_NAME_iqascore;
          PROP_NAME_TO_ID.put(PROP_NAME_iqascore, PROP_ID_iqascore);
      
          PROP_ID_TO_NAME[PROP_ID_iscriminalinvolved] = PROP_NAME_iscriminalinvolved;
          PROP_NAME_TO_ID.put(PROP_NAME_iscriminalinvolved, PROP_ID_iscriminalinvolved);
      
          PROP_ID_TO_NAME[PROP_ID_isdetainees] = PROP_NAME_isdetainees;
          PROP_NAME_TO_ID.put(PROP_NAME_isdetainees, PROP_ID_isdetainees);
      
          PROP_ID_TO_NAME[PROP_ID_isdriver] = PROP_NAME_isdriver;
          PROP_NAME_TO_ID.put(PROP_NAME_isdriver, PROP_ID_isdriver);
      
          PROP_ID_TO_NAME[PROP_ID_isforeigner] = PROP_NAME_isforeigner;
          PROP_NAME_TO_ID.put(PROP_NAME_isforeigner, PROP_ID_isforeigner);
      
          PROP_ID_TO_NAME[PROP_ID_isnoncomplete] = PROP_NAME_isnoncomplete;
          PROP_NAME_TO_ID.put(PROP_NAME_isnoncomplete, PROP_ID_isnoncomplete);
      
          PROP_ID_TO_NAME[PROP_ID_issuspectedterrorist] = PROP_NAME_issuspectedterrorist;
          PROP_NAME_TO_ID.put(PROP_NAME_issuspectedterrorist, PROP_ID_issuspectedterrorist);
      
          PROP_ID_TO_NAME[PROP_ID_issuspiciousperson] = PROP_NAME_issuspiciousperson;
          PROP_NAME_TO_ID.put(PROP_NAME_issuspiciousperson, PROP_ID_issuspiciousperson);
      
          PROP_ID_TO_NAME[PROP_ID_isvictim] = PROP_NAME_isvictim;
          PROP_NAME_TO_ID.put(PROP_NAME_isvictim, PROP_ID_isvictim);
      
          PROP_ID_TO_NAME[PROP_ID_jobcategory] = PROP_NAME_jobcategory;
          PROP_NAME_TO_ID.put(PROP_NAME_jobcategory, PROP_ID_jobcategory);
      
          PROP_ID_TO_NAME[PROP_ID_locationmarktime] = PROP_NAME_locationmarktime;
          PROP_NAME_TO_ID.put(PROP_NAME_locationmarktime, PROP_ID_locationmarktime);
      
          PROP_ID_TO_NAME[PROP_ID_mask] = PROP_NAME_mask;
          PROP_NAME_TO_ID.put(PROP_NAME_mask, PROP_ID_mask);
      
          PROP_ID_TO_NAME[PROP_ID_maskcolor] = PROP_NAME_maskcolor;
          PROP_NAME_TO_ID.put(PROP_NAME_maskcolor, PROP_ID_maskcolor);
      
          PROP_ID_TO_NAME[PROP_ID_membertypecode] = PROP_NAME_membertypecode;
          PROP_NAME_TO_ID.put(PROP_NAME_membertypecode, PROP_ID_membertypecode);
      
          PROP_ID_TO_NAME[PROP_ID_name] = PROP_NAME_name;
          PROP_NAME_TO_ID.put(PROP_NAME_name, PROP_ID_name);
      
          PROP_ID_TO_NAME[PROP_ID_nationalitycode] = PROP_NAME_nationalitycode;
          PROP_NAME_TO_ID.put(PROP_NAME_nationalitycode, PROP_ID_nationalitycode);
      
          PROP_ID_TO_NAME[PROP_ID_nativecitycode] = PROP_NAME_nativecitycode;
          PROP_NAME_TO_ID.put(PROP_NAME_nativecitycode, PROP_ID_nativecitycode);
      
          PROP_ID_TO_NAME[PROP_ID_nonvehicleumbrellacolor] = PROP_NAME_nonvehicleumbrellacolor;
          PROP_NAME_TO_ID.put(PROP_NAME_nonvehicleumbrellacolor, PROP_ID_nonvehicleumbrellacolor);
      
          PROP_ID_TO_NAME[PROP_ID_nonvehicleumbrellatype] = PROP_NAME_nonvehicleumbrellatype;
          PROP_NAME_TO_ID.put(PROP_NAME_nonvehicleumbrellatype, PROP_ID_nonvehicleumbrellatype);
      
          PROP_ID_TO_NAME[PROP_ID_nonvehicleumbrellatypereliability] = PROP_NAME_nonvehicleumbrellatypereliability;
          PROP_NAME_TO_ID.put(PROP_NAME_nonvehicleumbrellatypereliability, PROP_ID_nonvehicleumbrellatypereliability);
      
          PROP_ID_TO_NAME[PROP_ID_objsize] = PROP_NAME_objsize;
          PROP_NAME_TO_ID.put(PROP_NAME_objsize, PROP_ID_objsize);
      
          PROP_ID_TO_NAME[PROP_ID_objectsubtype] = PROP_NAME_objectsubtype;
          PROP_NAME_TO_ID.put(PROP_NAME_objectsubtype, PROP_ID_objectsubtype);
      
          PROP_ID_TO_NAME[PROP_ID_passenger] = PROP_NAME_passenger;
          PROP_NAME_TO_ID.put(PROP_NAME_passenger, PROP_ID_passenger);
      
          PROP_ID_TO_NAME[PROP_ID_passporttype] = PROP_NAME_passporttype;
          PROP_NAME_TO_ID.put(PROP_NAME_passporttype, PROP_ID_passporttype);
      
          PROP_ID_TO_NAME[PROP_ID_personappeartime] = PROP_NAME_personappeartime;
          PROP_NAME_TO_ID.put(PROP_NAME_personappeartime, PROP_ID_personappeartime);
      
          PROP_ID_TO_NAME[PROP_ID_personbottom] = PROP_NAME_personbottom;
          PROP_NAME_TO_ID.put(PROP_NAME_personbottom, PROP_ID_personbottom);
      
          PROP_ID_TO_NAME[PROP_ID_persondisappeartime] = PROP_NAME_persondisappeartime;
          PROP_NAME_TO_ID.put(PROP_NAME_persondisappeartime, PROP_ID_persondisappeartime);
      
          PROP_ID_TO_NAME[PROP_ID_personimgid] = PROP_NAME_personimgid;
          PROP_NAME_TO_ID.put(PROP_NAME_personimgid, PROP_ID_personimgid);
      
          PROP_ID_TO_NAME[PROP_ID_personleft] = PROP_NAME_personleft;
          PROP_NAME_TO_ID.put(PROP_NAME_personleft, PROP_ID_personleft);
      
          PROP_ID_TO_NAME[PROP_ID_personorg] = PROP_NAME_personorg;
          PROP_NAME_TO_ID.put(PROP_NAME_personorg, PROP_ID_personorg);
      
          PROP_ID_TO_NAME[PROP_ID_personright] = PROP_NAME_personright;
          PROP_NAME_TO_ID.put(PROP_NAME_personright, PROP_ID_personright);
      
          PROP_ID_TO_NAME[PROP_ID_persontop] = PROP_NAME_persontop;
          PROP_NAME_TO_ID.put(PROP_NAME_persontop, PROP_ID_persontop);
      
          PROP_ID_TO_NAME[PROP_ID_physicalfeature] = PROP_NAME_physicalfeature;
          PROP_NAME_TO_ID.put(PROP_NAME_physicalfeature, PROP_ID_physicalfeature);
      
          PROP_ID_TO_NAME[PROP_ID_picrecordid] = PROP_NAME_picrecordid;
          PROP_NAME_TO_ID.put(PROP_NAME_picrecordid, PROP_ID_picrecordid);
      
          PROP_ID_TO_NAME[PROP_ID_platebottom] = PROP_NAME_platebottom;
          PROP_NAME_TO_ID.put(PROP_NAME_platebottom, PROP_ID_platebottom);
      
          PROP_ID_TO_NAME[PROP_ID_platecolor] = PROP_NAME_platecolor;
          PROP_NAME_TO_ID.put(PROP_NAME_platecolor, PROP_ID_platecolor);
      
          PROP_ID_TO_NAME[PROP_ID_plateimgurl] = PROP_NAME_plateimgurl;
          PROP_NAME_TO_ID.put(PROP_NAME_plateimgurl, PROP_ID_plateimgurl);
      
          PROP_ID_TO_NAME[PROP_ID_plateleft] = PROP_NAME_plateleft;
          PROP_NAME_TO_ID.put(PROP_NAME_plateleft, PROP_ID_plateleft);
      
          PROP_ID_TO_NAME[PROP_ID_platenum] = PROP_NAME_platenum;
          PROP_NAME_TO_ID.put(PROP_NAME_platenum, PROP_ID_platenum);
      
          PROP_ID_TO_NAME[PROP_ID_plateright] = PROP_NAME_plateright;
          PROP_NAME_TO_ID.put(PROP_NAME_plateright, PROP_ID_plateright);
      
          PROP_ID_TO_NAME[PROP_ID_platetop] = PROP_NAME_platetop;
          PROP_NAME_TO_ID.put(PROP_NAME_platetop, PROP_ID_platetop);
      
          PROP_ID_TO_NAME[PROP_ID_posture] = PROP_NAME_posture;
          PROP_NAME_TO_ID.put(PROP_NAME_posture, PROP_ID_posture);
      
          PROP_ID_TO_NAME[PROP_ID_posturereliability] = PROP_NAME_posturereliability;
          PROP_NAME_TO_ID.put(PROP_NAME_posturereliability, PROP_ID_posturereliability);
      
          PROP_ID_TO_NAME[PROP_ID_prevmsgrecordid] = PROP_NAME_prevmsgrecordid;
          PROP_NAME_TO_ID.put(PROP_NAME_prevmsgrecordid, PROP_ID_prevmsgrecordid);
      
          PROP_ID_TO_NAME[PROP_ID_qescore] = PROP_NAME_qescore;
          PROP_NAME_TO_ID.put(PROP_NAME_qescore, PROP_ID_qescore);
      
          PROP_ID_TO_NAME[PROP_ID_raincoatreliability] = PROP_NAME_raincoatreliability;
          PROP_NAME_TO_ID.put(PROP_NAME_raincoatreliability, PROP_ID_raincoatreliability);
      
          PROP_ID_TO_NAME[PROP_ID_recordid] = PROP_NAME_recordid;
          PROP_NAME_TO_ID.put(PROP_NAME_recordid, PROP_ID_recordid);
      
          PROP_ID_TO_NAME[PROP_ID_relatedface] = PROP_NAME_relatedface;
          PROP_NAME_TO_ID.put(PROP_NAME_relatedface, PROP_ID_relatedface);
      
          PROP_ID_TO_NAME[PROP_ID_relatedgait] = PROP_NAME_relatedgait;
          PROP_NAME_TO_ID.put(PROP_NAME_relatedgait, PROP_ID_relatedgait);
      
          PROP_ID_TO_NAME[PROP_ID_relatednonvehicle] = PROP_NAME_relatednonvehicle;
          PROP_NAME_TO_ID.put(PROP_NAME_relatednonvehicle, PROP_ID_relatednonvehicle);
      
          PROP_ID_TO_NAME[PROP_ID_relatednonvehiclelist] = PROP_NAME_relatednonvehiclelist;
          PROP_NAME_TO_ID.put(PROP_NAME_relatednonvehiclelist, PROP_ID_relatednonvehiclelist);
      
          PROP_ID_TO_NAME[PROP_ID_relatedperson] = PROP_NAME_relatedperson;
          PROP_NAME_TO_ID.put(PROP_NAME_relatedperson, PROP_ID_relatedperson);
      
          PROP_ID_TO_NAME[PROP_ID_reliablity] = PROP_NAME_reliablity;
          PROP_NAME_TO_ID.put(PROP_NAME_reliablity, PROP_ID_reliablity);
      
          PROP_ID_TO_NAME[PROP_ID_residenceadmindivision] = PROP_NAME_residenceadmindivision;
          PROP_NAME_TO_ID.put(PROP_NAME_residenceadmindivision, PROP_ID_residenceadmindivision);
      
          PROP_ID_TO_NAME[PROP_ID_respiratorcolor] = PROP_NAME_respiratorcolor;
          PROP_NAME_TO_ID.put(PROP_NAME_respiratorcolor, PROP_ID_respiratorcolor);
      
          PROP_ID_TO_NAME[PROP_ID_rfidinfo] = PROP_NAME_rfidinfo;
          PROP_NAME_TO_ID.put(PROP_NAME_rfidinfo, PROP_ID_rfidinfo);
      
          PROP_ID_TO_NAME[PROP_ID_ridervehicle] = PROP_NAME_ridervehicle;
          PROP_NAME_TO_ID.put(PROP_NAME_ridervehicle, PROP_ID_ridervehicle);
      
          PROP_ID_TO_NAME[PROP_ID_snumber] = PROP_NAME_snumber;
          PROP_NAME_TO_ID.put(PROP_NAME_snumber, PROP_ID_snumber);
      
          PROP_ID_TO_NAME[PROP_ID_scarfcolor] = PROP_NAME_scarfcolor;
          PROP_NAME_TO_ID.put(PROP_NAME_scarfcolor, PROP_ID_scarfcolor);
      
          PROP_ID_TO_NAME[PROP_ID_shoescolor] = PROP_NAME_shoescolor;
          PROP_NAME_TO_ID.put(PROP_NAME_shoescolor, PROP_ID_shoescolor);
      
          PROP_ID_TO_NAME[PROP_ID_shoesstyle] = PROP_NAME_shoesstyle;
          PROP_NAME_TO_ID.put(PROP_NAME_shoesstyle, PROP_ID_shoesstyle);
      
          PROP_ID_TO_NAME[PROP_ID_skincolor] = PROP_NAME_skincolor;
          PROP_NAME_TO_ID.put(PROP_NAME_skincolor, PROP_ID_skincolor);
      
          PROP_ID_TO_NAME[PROP_ID_sourceid] = PROP_NAME_sourceid;
          PROP_NAME_TO_ID.put(PROP_NAME_sourceid, PROP_ID_sourceid);
      
          PROP_ID_TO_NAME[PROP_ID_status] = PROP_NAME_status;
          PROP_NAME_TO_ID.put(PROP_NAME_status, PROP_ID_status);
      
          PROP_ID_TO_NAME[PROP_ID_suspectedterroristnumber] = PROP_NAME_suspectedterroristnumber;
          PROP_NAME_TO_ID.put(PROP_NAME_suspectedterroristnumber, PROP_ID_suspectedterroristnumber);
      
          PROP_ID_TO_NAME[PROP_ID_targetimgurl] = PROP_NAME_targetimgurl;
          PROP_NAME_TO_ID.put(PROP_NAME_targetimgurl, PROP_ID_targetimgurl);
      
          PROP_ID_TO_NAME[PROP_ID_traceserviceinputtime] = PROP_NAME_traceserviceinputtime;
          PROP_NAME_TO_ID.put(PROP_NAME_traceserviceinputtime, PROP_ID_traceserviceinputtime);
      
          PROP_ID_TO_NAME[PROP_ID_tracethingsinputtime] = PROP_NAME_tracethingsinputtime;
          PROP_NAME_TO_ID.put(PROP_NAME_tracethingsinputtime, PROP_ID_tracethingsinputtime);
      
          PROP_ID_TO_NAME[PROP_ID_trouserscolor] = PROP_NAME_trouserscolor;
          PROP_NAME_TO_ID.put(PROP_NAME_trouserscolor, PROP_ID_trouserscolor);
      
          PROP_ID_TO_NAME[PROP_ID_trouserscolorreliability] = PROP_NAME_trouserscolorreliability;
          PROP_NAME_TO_ID.put(PROP_NAME_trouserscolorreliability, PROP_ID_trouserscolorreliability);
      
          PROP_ID_TO_NAME[PROP_ID_trouserslen] = PROP_NAME_trouserslen;
          PROP_NAME_TO_ID.put(PROP_NAME_trouserslen, PROP_ID_trouserslen);
      
          PROP_ID_TO_NAME[PROP_ID_trouserslenreliability] = PROP_NAME_trouserslenreliability;
          PROP_NAME_TO_ID.put(PROP_NAME_trouserslenreliability, PROP_ID_trouserslenreliability);
      
          PROP_ID_TO_NAME[PROP_ID_trousersstyle] = PROP_NAME_trousersstyle;
          PROP_NAME_TO_ID.put(PROP_NAME_trousersstyle, PROP_ID_trousersstyle);
      
          PROP_ID_TO_NAME[PROP_ID_uid] = PROP_NAME_uid;
          PROP_NAME_TO_ID.put(PROP_NAME_uid, PROP_ID_uid);
      
          PROP_ID_TO_NAME[PROP_ID_umbrella] = PROP_NAME_umbrella;
          PROP_NAME_TO_ID.put(PROP_NAME_umbrella, PROP_ID_umbrella);
      
          PROP_ID_TO_NAME[PROP_ID_umbrellacolor] = PROP_NAME_umbrellacolor;
          PROP_NAME_TO_ID.put(PROP_NAME_umbrellacolor, PROP_ID_umbrellacolor);
      
          PROP_ID_TO_NAME[PROP_ID_umbrellareliability] = PROP_NAME_umbrellareliability;
          PROP_NAME_TO_ID.put(PROP_NAME_umbrellareliability, PROP_ID_umbrellareliability);
      
          PROP_ID_TO_NAME[PROP_ID_uniformstyle] = PROP_NAME_uniformstyle;
          PROP_NAME_TO_ID.put(PROP_NAME_uniformstyle, PROP_ID_uniformstyle);
      
          PROP_ID_TO_NAME[PROP_ID_uniformstylereliability] = PROP_NAME_uniformstylereliability;
          PROP_NAME_TO_ID.put(PROP_NAME_uniformstylereliability, PROP_ID_uniformstylereliability);
      
          PROP_ID_TO_NAME[PROP_ID_usedname] = PROP_NAME_usedname;
          PROP_NAME_TO_ID.put(PROP_NAME_usedname, PROP_ID_usedname);
      
          PROP_ID_TO_NAME[PROP_ID_userchannelcode] = PROP_NAME_userchannelcode;
          PROP_NAME_TO_ID.put(PROP_NAME_userchannelcode, PROP_ID_userchannelcode);
      
          PROP_ID_TO_NAME[PROP_ID_vehiclecolor] = PROP_NAME_vehiclecolor;
          PROP_NAME_TO_ID.put(PROP_NAME_vehiclecolor, PROP_ID_vehiclecolor);
      
          PROP_ID_TO_NAME[PROP_ID_vehicletype] = PROP_NAME_vehicletype;
          PROP_NAME_TO_ID.put(PROP_NAME_vehicletype, PROP_ID_vehicletype);
      
          PROP_ID_TO_NAME[PROP_ID_vehicletypereliability] = PROP_NAME_vehicletypereliability;
          PROP_NAME_TO_ID.put(PROP_NAME_vehicletypereliability, PROP_ID_vehicletypereliability);
      
          PROP_ID_TO_NAME[PROP_ID_vendor] = PROP_NAME_vendor;
          PROP_NAME_TO_ID.put(PROP_NAME_vendor, PROP_ID_vendor);
      
          PROP_ID_TO_NAME[PROP_ID_victimtype] = PROP_NAME_victimtype;
          PROP_NAME_TO_ID.put(PROP_NAME_victimtype, PROP_ID_victimtype);
      
    }

    
    /* Absscore: ABSSCORE */
    private java.lang.Integer _absscore;
    
    /* Accompanynumber: ACCOMPANYNUMBER */
    private java.lang.Integer _accompanynumber;
    
    /* Accompanynumberreliability: ACCOMPANYNUMBERRELIABILITY */
    private java.lang.Integer _accompanynumberreliability;
    
    /* Age: AGE */
    private java.lang.Integer _age;
    
    /* Agegroup: AGEGROUP */
    private java.lang.Integer _agegroup;
    
    /* Agegroupreliability: AGEGROUPRELIABILITY */
    private java.lang.Integer _agegroupreliability;
    
    /* Agelowerlimit: AGELOWERLIMIT */
    private java.lang.Integer _agelowerlimit;
    
    /* Agereliability: AGERELIABILITY */
    private java.lang.Integer _agereliability;
    
    /* Ageuplimit: AGEUPLIMIT */
    private java.lang.Integer _ageuplimit;
    
    /* Algorithmversion: ALGORITHMVERSION */
    private java.lang.String _algorithmversion;
    
    /* Alias: ALIAS */
    private java.lang.String _alias;
    
    /* Appendant: APPENDANT */
    private java.lang.String _appendant;
    
    /* Appendantdescription: APPENDANTDESCRIPTION */
    private java.lang.String _appendantdescription;
    
    /* Baby: BABY */
    private java.lang.String _baby;
    
    /* Bag1reliability: BAG1RELIABILITY */
    private java.lang.Integer _bag1reliability;
    
    /* Bag1style: BAG1STYLE */
    private java.lang.String _bag1style;
    
    /* Bag2reliability: BAG2RELIABILITY */
    private java.lang.Integer _bag2reliability;
    
    /* Bag2style: BAG2STYLE */
    private java.lang.String _bag2style;
    
    /* Bag3reliability: BAG3RELIABILITY */
    private java.lang.Integer _bag3reliability;
    
    /* Bag3style: BAG3STYLE */
    private java.lang.String _bag3style;
    
    /* Bagcolor: BAGCOLOR */
    private java.lang.String _bagcolor;
    
    /* Bagstyle: BAGSTYLE */
    private java.lang.String _bagstyle;
    
    /* Bagstylereliability: BAGSTYLERELIABILITY */
    private java.lang.Integer _bagstylereliability;
    
    /* Behavior: BEHAVIOR */
    private java.lang.String _behavior;
    
    /* Behaviordescription: BEHAVIORDESCRIPTION */
    private java.lang.String _behaviordescription;
    
    /* Bodyfeature: BODYFEATURE */
    private java.lang.String _bodyfeature;
    
    /* Bodyspeciallmark: BODYSPECIALLMARK */
    private java.lang.String _bodyspeciallmark;
    
    /* Bodytype: BODYTYPE */
    private java.lang.String _bodytype;
    
    /* Cacheimgurl: CACHEIMGURL */
    private java.lang.String _cacheimgurl;
    
    /* Cacheplateimgurl: CACHEPLATEIMGURL */
    private java.lang.String _cacheplateimgurl;
    
    /* Cachetargetimgurl: CACHETARGETIMGURL */
    private java.lang.String _cachetargetimgurl;
    
    /* Capcolor: CAPCOLOR */
    private java.lang.String _capcolor;
    
    /* Capcolorreliability: CAPCOLORRELIABILITY */
    private java.lang.Integer _capcolorreliability;
    
    /* Capstyle: CAPSTYLE */
    private java.lang.String _capstyle;
    
    /* Capstylereliability: CAPSTYLERELIABILITY */
    private java.lang.Integer _capstylereliability;
    
    /* Captime: CAPTIME */
    private java.lang.Long _captime;
    
    /* Channelcode: CHANNELCODE */
    private java.lang.String _channelcode;
    
    /* Channelid: CHANNELID */
    private java.lang.String _channelid;
    
    /* Chineseaccentcode: CHINESEACCENTCODE */
    private java.lang.String _chineseaccentcode;
    
    /* Coatcolor: COATCOLOR */
    private java.lang.String _coatcolor;
    
    /* Coatcolorreliability: COATCOLORRELIABILITY */
    private java.lang.Integer _coatcolorreliability;
    
    /* Coatlength: COATLENGTH */
    private java.lang.String _coatlength;
    
    /* Coatlengthreliability: COATLENGTHRELIABILITY */
    private java.lang.Integer _coatlengthreliability;
    
    /* Coatstyle: COATSTYLE */
    private java.lang.String _coatstyle;
    
    /* Coatstylereliability: COATSTYLERELIABILITY */
    private java.lang.Integer _coatstylereliability;
    
    /* Coattexture: COATTEXTURE */
    private java.lang.String _coattexture;
    
    /* Coattexturereliability: COATTEXTURERELIABILITY */
    private java.lang.Integer _coattexturereliability;
    
    /* Completescore: COMPLETESCORE */
    private java.lang.Integer _completescore;
    
    /* Corpseconditioncode: CORPSECONDITIONCODE */
    private java.lang.String _corpseconditioncode;
    
    /* Crimecharactercode: CRIMECHARACTERCODE */
    private java.lang.String _crimecharactercode;
    
    /* Crimemethod: CRIMEMETHOD */
    private java.lang.String _crimemethod;
    
    /* Criminalinvolvedcode: CRIMINALINVOLVEDCODE */
    private java.lang.String _criminalinvolvedcode;
    
    /* Datasource: DATASOURCE */
    private java.lang.Integer _datasource;
    
    /* Datatracetag: DATATRACETAG */
    private java.lang.String _datatracetag;
    
    /* Detaineesidentity: DETAINEESIDENTITY */
    private java.lang.String _detaineesidentity;
    
    /* Detaineesspecialidentity: DETAINEESSPECIALIDENTITY */
    private java.lang.String _detaineesspecialidentity;
    
    /* Detectobject: DETECTOBJECT */
    private java.lang.Integer _detectobject;
    
    /* Detectionscore: DETECTIONSCORE */
    private java.lang.Integer _detectionscore;
    
    /* Detentionhousecode: DETENTIONHOUSECODE */
    private java.lang.String _detentionhousecode;
    
    /* Devicecode: DEVICECODE */
    private java.lang.String _devicecode;
    
    /* Deviceid: DEVICEID */
    private java.lang.String _deviceid;
    
    /* Emclasstype: EMCLASSTYPE */
    private java.lang.Integer _emclasstype;
    
    /* Escapedcriminalnumber: ESCAPEDCRIMINALNUMBER */
    private java.lang.String _escapedcriminalnumber;
    
    /* Event: EVENT */
    private java.lang.String _event;
    
    /* Extrecordid: EXTRECORDID */
    private java.lang.String _extrecordid;
    
    /* Extrecordsource: EXTRECORDSOURCE */
    private java.lang.Integer _extrecordsource;
    
    /* Extractedflag: EXTRACTEDFLAG */
    private java.lang.Integer _extractedflag;
    
    /* Facedirect: FACEDIRECT */
    private java.lang.Integer _facedirect;
    
    /* Facedirectreliability: FACEDIRECTRELIABILITY */
    private java.lang.Integer _facedirectreliability;
    
    /* Facestyle: FACESTYLE */
    private java.lang.String _facestyle;
    
    /* Facialfeature: FACIALFEATURE */
    private java.lang.String _facialfeature;
    
    /* Featuredata: FEATUREDATA */
    private java.lang.String _featuredata;
    
    /* Featureid: FEATUREID */
    private java.lang.String _featureid;
    
    /* Gender: GENDER */
    private java.lang.Integer _gender;
    
    /* Genderreliability: GENDERRELIABILITY */
    private java.lang.Integer _genderreliability;
    
    /* Gesture: GESTURE */
    private java.lang.String _gesture;
    
    /* Glasscolor: GLASSCOLOR */
    private java.lang.String _glasscolor;
    
    /* Glassstyle: GLASSSTYLE */
    private java.lang.String _glassstyle;
    
    /* Habitualmovemen: HABITUALMOVEMEN */
    private java.lang.String _habitualmovemen;
    
    /* Haircolor: HAIRCOLOR */
    private java.lang.String _haircolor;
    
    /* Hairstyle: HAIRSTYLE */
    private java.lang.String _hairstyle;
    
    /* Hairstylereliability: HAIRSTYLERELIABILITY */
    private java.lang.Integer _hairstylereliability;
    
    /* Hairtype: HAIRTYPE */
    private java.lang.Integer _hairtype;
    
    /* Hasbag: HASBAG */
    private java.lang.Integer _hasbag;
    
    /* Hasbagreliability: HASBAGRELIABILITY */
    private java.lang.Integer _hasbagreliability;
    
    /* Hasbasket: HASBASKET */
    private java.lang.Integer _hasbasket;
    
    /* Hascarrierbag: HASCARRIERBAG */
    private java.lang.Integer _hascarrierbag;
    
    /* Hascarrystuff: HASCARRYSTUFF */
    private java.lang.Integer _hascarrystuff;
    
    /* Hascart: HASCART */
    private java.lang.Integer _hascart;
    
    /* Hasdownbody: HASDOWNBODY */
    private java.lang.Integer _hasdownbody;
    
    /* Hasdownbodyreliability: HASDOWNBODYRELIABILITY */
    private java.lang.Integer _hasdownbodyreliability;
    
    /* Haserrordetect: HASERRORDETECT */
    private java.lang.Integer _haserrordetect;
    
    /* Hashead: HASHEAD */
    private java.lang.Integer _hashead;
    
    /* Hasheadreliability: HASHEADRELIABILITY */
    private java.lang.Integer _hasheadreliability;
    
    /* Hasmirror: HASMIRROR */
    private java.lang.Integer _hasmirror;
    
    /* Hasraincoat: HASRAINCOAT */
    private java.lang.Integer _hasraincoat;
    
    /* Hasrespirator: HASRESPIRATOR */
    private java.lang.Integer _hasrespirator;
    
    /* Hastrunk: HASTRUNK */
    private java.lang.Integer _hastrunk;
    
    /* Hasvehicle: HASVEHICLE */
    private java.lang.Integer _hasvehicle;
    
    /* Hasvest: HASVEST */
    private java.lang.Integer _hasvest;
    
    /* Hasvestreliability: HASVESTRELIABILITY */
    private java.lang.Integer _hasvestreliability;
    
    /* Hat: HAT */
    private java.lang.Integer _hat;
    
    /* Hatreliability: HATRELIABILITY */
    private java.lang.Integer _hatreliability;
    
    /* Heightlowerlimit: HEIGHTLOWERLIMIT */
    private java.lang.Integer _heightlowerlimit;
    
    /* Heightuplimit: HEIGHTUPLIMIT */
    private java.lang.Integer _heightuplimit;
    
    /* Humanlist: HUMANLIST */
    private java.lang.String _humanlist;
    
    /* Idnumber: IDNUMBER */
    private java.lang.String _idnumber;
    
    /* Idtype: IDTYPE */
    private java.lang.String _idtype;
    
    /* Imgheight: IMGHEIGHT */
    private java.lang.Integer _imgheight;
    
    /* Imgurl: IMGURL */
    private java.lang.String _imgurl;
    
    /* Imgwidth: IMGWIDTH */
    private java.lang.Integer _imgwidth;
    
    /* Immigranttypecode: IMMIGRANTTYPECODE */
    private java.lang.String _immigranttypecode;
    
    /* Infokind: INFOKIND */
    private java.lang.Integer _infokind;
    
    /* Injureddegree: INJUREDDEGREE */
    private java.lang.String _injureddegree;
    
    /* Iqascore: IQASCORE */
    private java.lang.Integer _iqascore;
    
    /* Iscriminalinvolved: ISCRIMINALINVOLVED */
    private java.lang.Integer _iscriminalinvolved;
    
    /* Isdetainees: ISDETAINEES */
    private java.lang.Integer _isdetainees;
    
    /* Isdriver: ISDRIVER */
    private java.lang.Integer _isdriver;
    
    /* Isforeigner: ISFOREIGNER */
    private java.lang.Integer _isforeigner;
    
    /* Isnoncomplete: ISNONCOMPLETE */
    private java.lang.Integer _isnoncomplete;
    
    /* Issuspectedterrorist: ISSUSPECTEDTERRORIST */
    private java.lang.Integer _issuspectedterrorist;
    
    /* Issuspiciousperson: ISSUSPICIOUSPERSON */
    private java.lang.Integer _issuspiciousperson;
    
    /* Isvictim: ISVICTIM */
    private java.lang.Integer _isvictim;
    
    /* Jobcategory: JOBCATEGORY */
    private java.lang.String _jobcategory;
    
    /* Locationmarktime: LOCATIONMARKTIME */
    private java.lang.Long _locationmarktime;
    
    /* Mask: MASK */
    private java.lang.Integer _mask;
    
    /* Maskcolor: MASKCOLOR */
    private java.lang.Integer _maskcolor;
    
    /* Membertypecode: MEMBERTYPECODE */
    private java.lang.String _membertypecode;
    
    /* Name: NAME */
    private java.lang.String _name;
    
    /* Nationalitycode: NATIONALITYCODE */
    private java.lang.String _nationalitycode;
    
    /* Nativecitycode: NATIVECITYCODE */
    private java.lang.String _nativecitycode;
    
    /* Nonvehicleumbrellacolor: NONVEHICLEUMBRELLACOLOR */
    private java.lang.String _nonvehicleumbrellacolor;
    
    /* Nonvehicleumbrellatype: NONVEHICLEUMBRELLATYPE */
    private java.lang.Integer _nonvehicleumbrellatype;
    
    /* Nonvehicleumbrellatypereliability: NONVEHICLEUMBRELLATYPERELIABILITY */
    private java.lang.Integer _nonvehicleumbrellatypereliability;
    
    /* Objsize: OBJSIZE */
    private java.lang.Integer _objsize;
    
    /* Objectsubtype: OBJECTSUBTYPE */
    private java.lang.Integer _objectsubtype;
    
    /* Passenger: PASSENGER */
    private java.lang.Integer _passenger;
    
    /* Passporttype: PASSPORTTYPE */
    private java.lang.String _passporttype;
    
    /* Personappeartime: PERSONAPPEARTIME */
    private java.lang.Long _personappeartime;
    
    /* Personbottom: PERSONBOTTOM */
    private java.lang.Integer _personbottom;
    
    /* Persondisappeartime: PERSONDISAPPEARTIME */
    private java.lang.Long _persondisappeartime;
    
    /* Personimgid: PERSONIMGID */
    private java.lang.String _personimgid;
    
    /* Personleft: PERSONLEFT */
    private java.lang.Integer _personleft;
    
    /* Personorg: PERSONORG */
    private java.lang.String _personorg;
    
    /* Personright: PERSONRIGHT */
    private java.lang.Integer _personright;
    
    /* Persontop: PERSONTOP */
    private java.lang.Integer _persontop;
    
    /* Physicalfeature: PHYSICALFEATURE */
    private java.lang.String _physicalfeature;
    
    /* Picrecordid: PICRECORDID */
    private java.lang.String _picrecordid;
    
    /* Platebottom: PLATEBOTTOM */
    private java.lang.Integer _platebottom;
    
    /* Platecolor: PLATECOLOR */
    private java.lang.String _platecolor;
    
    /* Plateimgurl: PLATEIMGURL */
    private java.lang.String _plateimgurl;
    
    /* Plateleft: PLATELEFT */
    private java.lang.Integer _plateleft;
    
    /* Platenum: PLATENUM */
    private java.lang.String _platenum;
    
    /* Plateright: PLATERIGHT */
    private java.lang.Integer _plateright;
    
    /* Platetop: PLATETOP */
    private java.lang.Integer _platetop;
    
    /* Posture: POSTURE */
    private java.lang.Integer _posture;
    
    /* Posturereliability: POSTURERELIABILITY */
    private java.lang.Integer _posturereliability;
    
    /* Prevmsgrecordid: PREVMSGRECORDID */
    private java.lang.String _prevmsgrecordid;
    
    /* Qescore: QESCORE */
    private java.lang.Integer _qescore;
    
    /* Raincoatreliability: RAINCOATRELIABILITY */
    private java.lang.Integer _raincoatreliability;
    
    /* Recordid: RECORDID */
    private java.lang.String _recordid;
    
    /* Relatedface: RELATEDFACE */
    private java.lang.Integer _relatedface;
    
    /* Relatedgait: RELATEDGAIT */
    private java.lang.Integer _relatedgait;
    
    /* Relatednonvehicle: RELATEDNONVEHICLE */
    private java.lang.Integer _relatednonvehicle;
    
    /* Relatednonvehiclelist: RELATEDNONVEHICLELIST */
    private java.lang.String _relatednonvehiclelist;
    
    /* Relatedperson: RELATEDPERSON */
    private java.lang.Integer _relatedperson;
    
    /* Reliablity: RELIABLITY */
    private java.lang.Integer _reliablity;
    
    /* Residenceadmindivision: RESIDENCEADMINDIVISION */
    private java.lang.String _residenceadmindivision;
    
    /* Respiratorcolor: RESPIRATORCOLOR */
    private java.lang.String _respiratorcolor;
    
    /* Rfidinfo: RFIDINFO */
    private java.lang.String _rfidinfo;
    
    /* Ridervehicle: RIDERVEHICLE */
    private java.lang.Integer _ridervehicle;
    
    /* Snumber: SNUMBER */
    private java.lang.String _snumber;
    
    /* Scarfcolor: SCARFCOLOR */
    private java.lang.String _scarfcolor;
    
    /* Shoescolor: SHOESCOLOR */
    private java.lang.String _shoescolor;
    
    /* Shoesstyle: SHOESSTYLE */
    private java.lang.String _shoesstyle;
    
    /* Skincolor: SKINCOLOR */
    private java.lang.String _skincolor;
    
    /* Sourceid: SOURCEID */
    private java.lang.String _sourceid;
    
    /* Status: STATUS */
    private java.lang.String _status;
    
    /* Suspectedterroristnumber: SUSPECTEDTERRORISTNUMBER */
    private java.lang.String _suspectedterroristnumber;
    
    /* Targetimgurl: TARGETIMGURL */
    private java.lang.String _targetimgurl;
    
    /* Traceserviceinputtime: TRACESERVICEINPUTTIME */
    private java.lang.Long _traceserviceinputtime;
    
    /* Tracethingsinputtime: TRACETHINGSINPUTTIME */
    private java.lang.Long _tracethingsinputtime;
    
    /* Trouserscolor: TROUSERSCOLOR */
    private java.lang.String _trouserscolor;
    
    /* Trouserscolorreliability: TROUSERSCOLORRELIABILITY */
    private java.lang.Integer _trouserscolorreliability;
    
    /* Trouserslen: TROUSERSLEN */
    private java.lang.String _trouserslen;
    
    /* Trouserslenreliability: TROUSERSLENRELIABILITY */
    private java.lang.Integer _trouserslenreliability;
    
    /* Trousersstyle: TROUSERSSTYLE */
    private java.lang.String _trousersstyle;
    
    /* Uid: UID */
    private java.lang.String _uid;
    
    /* Umbrella: UMBRELLA */
    private java.lang.Integer _umbrella;
    
    /* Umbrellacolor: UMBRELLACOLOR */
    private java.lang.String _umbrellacolor;
    
    /* Umbrellareliability: UMBRELLARELIABILITY */
    private java.lang.Integer _umbrellareliability;
    
    /* Uniformstyle: UNIFORMSTYLE */
    private java.lang.Integer _uniformstyle;
    
    /* Uniformstylereliability: UNIFORMSTYLERELIABILITY */
    private java.lang.Integer _uniformstylereliability;
    
    /* Usedname: USEDNAME */
    private java.lang.String _usedname;
    
    /* Userchannelcode: USERCHANNELCODE */
    private java.lang.String _userchannelcode;
    
    /* Vehiclecolor: VEHICLECOLOR */
    private java.lang.String _vehiclecolor;
    
    /* Vehicletype: VEHICLETYPE */
    private java.lang.Integer _vehicletype;
    
    /* Vehicletypereliability: VEHICLETYPERELIABILITY */
    private java.lang.Integer _vehicletypereliability;
    
    /* Vendor: VENDOR */
    private java.lang.String _vendor;
    
    /* Victimtype: VICTIMTYPE */
    private java.lang.String _victimtype;
    

    public _DahuaNonMotorVehicle(){
        // for debug
    }

    protected DahuaNonMotorVehicle newInstance(){
        DahuaNonMotorVehicle entity = new DahuaNonMotorVehicle();
        entity.orm_attach(orm_enhancer());
        entity.orm_entityModel(orm_entityModel());
        return entity;
    }

    @Override
    public DahuaNonMotorVehicle cloneInstance() {
        DahuaNonMotorVehicle entity = newInstance();
        orm_forEachInitedProp((value, propId) -> {
            entity.orm_propValue(propId,value);
        });
        return entity;
    }

    @Override
    public String orm_entityName() {
      // 如果存在实体模型对象，则以模型对象上的设置为准
      IEntityModel entityModel = orm_entityModel();
      if(entityModel != null)
          return entityModel.getName();
      return "com.fliad.resource.dao.entity.DahuaNonMotorVehicle";
    }

    @Override
    public int orm_propIdBound(){
      IEntityModel entityModel = orm_entityModel();
      if(entityModel != null)
          return entityModel.getPropIdBound();
      return _PROP_ID_BOUND;
    }

    @Override
    public Object orm_id() {
    
        return buildSimpleId(PROP_ID_absscore);
     
    }

    @Override
    public boolean orm_isPrimary(int propId) {
        
            return propId == PROP_ID_absscore;
          
    }

    @Override
    public String orm_propName(int propId) {
        if(propId >= PROP_ID_TO_NAME.length)
            return super.orm_propName(propId);
        String propName = PROP_ID_TO_NAME[propId];
        if(propName == null)
           return super.orm_propName(propId);
        return propName;
    }

    @Override
    public int orm_propId(String propName) {
        Integer propId = PROP_NAME_TO_ID.get(propName);
        if(propId == null)
            return super.orm_propId(propName);
        return propId;
    }

    @Override
    public Object orm_propValue(int propId) {
        switch(propId){
        
            case PROP_ID_absscore:
               return getAbsscore();
        
            case PROP_ID_accompanynumber:
               return getAccompanynumber();
        
            case PROP_ID_accompanynumberreliability:
               return getAccompanynumberreliability();
        
            case PROP_ID_age:
               return getAge();
        
            case PROP_ID_agegroup:
               return getAgegroup();
        
            case PROP_ID_agegroupreliability:
               return getAgegroupreliability();
        
            case PROP_ID_agelowerlimit:
               return getAgelowerlimit();
        
            case PROP_ID_agereliability:
               return getAgereliability();
        
            case PROP_ID_ageuplimit:
               return getAgeuplimit();
        
            case PROP_ID_algorithmversion:
               return getAlgorithmversion();
        
            case PROP_ID_alias:
               return getAlias();
        
            case PROP_ID_appendant:
               return getAppendant();
        
            case PROP_ID_appendantdescription:
               return getAppendantdescription();
        
            case PROP_ID_baby:
               return getBaby();
        
            case PROP_ID_bag1reliability:
               return getBag1reliability();
        
            case PROP_ID_bag1style:
               return getBag1style();
        
            case PROP_ID_bag2reliability:
               return getBag2reliability();
        
            case PROP_ID_bag2style:
               return getBag2style();
        
            case PROP_ID_bag3reliability:
               return getBag3reliability();
        
            case PROP_ID_bag3style:
               return getBag3style();
        
            case PROP_ID_bagcolor:
               return getBagcolor();
        
            case PROP_ID_bagstyle:
               return getBagstyle();
        
            case PROP_ID_bagstylereliability:
               return getBagstylereliability();
        
            case PROP_ID_behavior:
               return getBehavior();
        
            case PROP_ID_behaviordescription:
               return getBehaviordescription();
        
            case PROP_ID_bodyfeature:
               return getBodyfeature();
        
            case PROP_ID_bodyspeciallmark:
               return getBodyspeciallmark();
        
            case PROP_ID_bodytype:
               return getBodytype();
        
            case PROP_ID_cacheimgurl:
               return getCacheimgurl();
        
            case PROP_ID_cacheplateimgurl:
               return getCacheplateimgurl();
        
            case PROP_ID_cachetargetimgurl:
               return getCachetargetimgurl();
        
            case PROP_ID_capcolor:
               return getCapcolor();
        
            case PROP_ID_capcolorreliability:
               return getCapcolorreliability();
        
            case PROP_ID_capstyle:
               return getCapstyle();
        
            case PROP_ID_capstylereliability:
               return getCapstylereliability();
        
            case PROP_ID_captime:
               return getCaptime();
        
            case PROP_ID_channelcode:
               return getChannelcode();
        
            case PROP_ID_channelid:
               return getChannelid();
        
            case PROP_ID_chineseaccentcode:
               return getChineseaccentcode();
        
            case PROP_ID_coatcolor:
               return getCoatcolor();
        
            case PROP_ID_coatcolorreliability:
               return getCoatcolorreliability();
        
            case PROP_ID_coatlength:
               return getCoatlength();
        
            case PROP_ID_coatlengthreliability:
               return getCoatlengthreliability();
        
            case PROP_ID_coatstyle:
               return getCoatstyle();
        
            case PROP_ID_coatstylereliability:
               return getCoatstylereliability();
        
            case PROP_ID_coattexture:
               return getCoattexture();
        
            case PROP_ID_coattexturereliability:
               return getCoattexturereliability();
        
            case PROP_ID_completescore:
               return getCompletescore();
        
            case PROP_ID_corpseconditioncode:
               return getCorpseconditioncode();
        
            case PROP_ID_crimecharactercode:
               return getCrimecharactercode();
        
            case PROP_ID_crimemethod:
               return getCrimemethod();
        
            case PROP_ID_criminalinvolvedcode:
               return getCriminalinvolvedcode();
        
            case PROP_ID_datasource:
               return getDatasource();
        
            case PROP_ID_datatracetag:
               return getDatatracetag();
        
            case PROP_ID_detaineesidentity:
               return getDetaineesidentity();
        
            case PROP_ID_detaineesspecialidentity:
               return getDetaineesspecialidentity();
        
            case PROP_ID_detectobject:
               return getDetectobject();
        
            case PROP_ID_detectionscore:
               return getDetectionscore();
        
            case PROP_ID_detentionhousecode:
               return getDetentionhousecode();
        
            case PROP_ID_devicecode:
               return getDevicecode();
        
            case PROP_ID_deviceid:
               return getDeviceid();
        
            case PROP_ID_emclasstype:
               return getEmclasstype();
        
            case PROP_ID_escapedcriminalnumber:
               return getEscapedcriminalnumber();
        
            case PROP_ID_event:
               return getEvent();
        
            case PROP_ID_extrecordid:
               return getExtrecordid();
        
            case PROP_ID_extrecordsource:
               return getExtrecordsource();
        
            case PROP_ID_extractedflag:
               return getExtractedflag();
        
            case PROP_ID_facedirect:
               return getFacedirect();
        
            case PROP_ID_facedirectreliability:
               return getFacedirectreliability();
        
            case PROP_ID_facestyle:
               return getFacestyle();
        
            case PROP_ID_facialfeature:
               return getFacialfeature();
        
            case PROP_ID_featuredata:
               return getFeaturedata();
        
            case PROP_ID_featureid:
               return getFeatureid();
        
            case PROP_ID_gender:
               return getGender();
        
            case PROP_ID_genderreliability:
               return getGenderreliability();
        
            case PROP_ID_gesture:
               return getGesture();
        
            case PROP_ID_glasscolor:
               return getGlasscolor();
        
            case PROP_ID_glassstyle:
               return getGlassstyle();
        
            case PROP_ID_habitualmovemen:
               return getHabitualmovemen();
        
            case PROP_ID_haircolor:
               return getHaircolor();
        
            case PROP_ID_hairstyle:
               return getHairstyle();
        
            case PROP_ID_hairstylereliability:
               return getHairstylereliability();
        
            case PROP_ID_hairtype:
               return getHairtype();
        
            case PROP_ID_hasbag:
               return getHasbag();
        
            case PROP_ID_hasbagreliability:
               return getHasbagreliability();
        
            case PROP_ID_hasbasket:
               return getHasbasket();
        
            case PROP_ID_hascarrierbag:
               return getHascarrierbag();
        
            case PROP_ID_hascarrystuff:
               return getHascarrystuff();
        
            case PROP_ID_hascart:
               return getHascart();
        
            case PROP_ID_hasdownbody:
               return getHasdownbody();
        
            case PROP_ID_hasdownbodyreliability:
               return getHasdownbodyreliability();
        
            case PROP_ID_haserrordetect:
               return getHaserrordetect();
        
            case PROP_ID_hashead:
               return getHashead();
        
            case PROP_ID_hasheadreliability:
               return getHasheadreliability();
        
            case PROP_ID_hasmirror:
               return getHasmirror();
        
            case PROP_ID_hasraincoat:
               return getHasraincoat();
        
            case PROP_ID_hasrespirator:
               return getHasrespirator();
        
            case PROP_ID_hastrunk:
               return getHastrunk();
        
            case PROP_ID_hasvehicle:
               return getHasvehicle();
        
            case PROP_ID_hasvest:
               return getHasvest();
        
            case PROP_ID_hasvestreliability:
               return getHasvestreliability();
        
            case PROP_ID_hat:
               return getHat();
        
            case PROP_ID_hatreliability:
               return getHatreliability();
        
            case PROP_ID_heightlowerlimit:
               return getHeightlowerlimit();
        
            case PROP_ID_heightuplimit:
               return getHeightuplimit();
        
            case PROP_ID_humanlist:
               return getHumanlist();
        
            case PROP_ID_idnumber:
               return getIdnumber();
        
            case PROP_ID_idtype:
               return getIdtype();
        
            case PROP_ID_imgheight:
               return getImgheight();
        
            case PROP_ID_imgurl:
               return getImgurl();
        
            case PROP_ID_imgwidth:
               return getImgwidth();
        
            case PROP_ID_immigranttypecode:
               return getImmigranttypecode();
        
            case PROP_ID_infokind:
               return getInfokind();
        
            case PROP_ID_injureddegree:
               return getInjureddegree();
        
            case PROP_ID_iqascore:
               return getIqascore();
        
            case PROP_ID_iscriminalinvolved:
               return getIscriminalinvolved();
        
            case PROP_ID_isdetainees:
               return getIsdetainees();
        
            case PROP_ID_isdriver:
               return getIsdriver();
        
            case PROP_ID_isforeigner:
               return getIsforeigner();
        
            case PROP_ID_isnoncomplete:
               return getIsnoncomplete();
        
            case PROP_ID_issuspectedterrorist:
               return getIssuspectedterrorist();
        
            case PROP_ID_issuspiciousperson:
               return getIssuspiciousperson();
        
            case PROP_ID_isvictim:
               return getIsvictim();
        
            case PROP_ID_jobcategory:
               return getJobcategory();
        
            case PROP_ID_locationmarktime:
               return getLocationmarktime();
        
            case PROP_ID_mask:
               return getMask();
        
            case PROP_ID_maskcolor:
               return getMaskcolor();
        
            case PROP_ID_membertypecode:
               return getMembertypecode();
        
            case PROP_ID_name:
               return getName();
        
            case PROP_ID_nationalitycode:
               return getNationalitycode();
        
            case PROP_ID_nativecitycode:
               return getNativecitycode();
        
            case PROP_ID_nonvehicleumbrellacolor:
               return getNonvehicleumbrellacolor();
        
            case PROP_ID_nonvehicleumbrellatype:
               return getNonvehicleumbrellatype();
        
            case PROP_ID_nonvehicleumbrellatypereliability:
               return getNonvehicleumbrellatypereliability();
        
            case PROP_ID_objsize:
               return getObjsize();
        
            case PROP_ID_objectsubtype:
               return getObjectsubtype();
        
            case PROP_ID_passenger:
               return getPassenger();
        
            case PROP_ID_passporttype:
               return getPassporttype();
        
            case PROP_ID_personappeartime:
               return getPersonappeartime();
        
            case PROP_ID_personbottom:
               return getPersonbottom();
        
            case PROP_ID_persondisappeartime:
               return getPersondisappeartime();
        
            case PROP_ID_personimgid:
               return getPersonimgid();
        
            case PROP_ID_personleft:
               return getPersonleft();
        
            case PROP_ID_personorg:
               return getPersonorg();
        
            case PROP_ID_personright:
               return getPersonright();
        
            case PROP_ID_persontop:
               return getPersontop();
        
            case PROP_ID_physicalfeature:
               return getPhysicalfeature();
        
            case PROP_ID_picrecordid:
               return getPicrecordid();
        
            case PROP_ID_platebottom:
               return getPlatebottom();
        
            case PROP_ID_platecolor:
               return getPlatecolor();
        
            case PROP_ID_plateimgurl:
               return getPlateimgurl();
        
            case PROP_ID_plateleft:
               return getPlateleft();
        
            case PROP_ID_platenum:
               return getPlatenum();
        
            case PROP_ID_plateright:
               return getPlateright();
        
            case PROP_ID_platetop:
               return getPlatetop();
        
            case PROP_ID_posture:
               return getPosture();
        
            case PROP_ID_posturereliability:
               return getPosturereliability();
        
            case PROP_ID_prevmsgrecordid:
               return getPrevmsgrecordid();
        
            case PROP_ID_qescore:
               return getQescore();
        
            case PROP_ID_raincoatreliability:
               return getRaincoatreliability();
        
            case PROP_ID_recordid:
               return getRecordid();
        
            case PROP_ID_relatedface:
               return getRelatedface();
        
            case PROP_ID_relatedgait:
               return getRelatedgait();
        
            case PROP_ID_relatednonvehicle:
               return getRelatednonvehicle();
        
            case PROP_ID_relatednonvehiclelist:
               return getRelatednonvehiclelist();
        
            case PROP_ID_relatedperson:
               return getRelatedperson();
        
            case PROP_ID_reliablity:
               return getReliablity();
        
            case PROP_ID_residenceadmindivision:
               return getResidenceadmindivision();
        
            case PROP_ID_respiratorcolor:
               return getRespiratorcolor();
        
            case PROP_ID_rfidinfo:
               return getRfidinfo();
        
            case PROP_ID_ridervehicle:
               return getRidervehicle();
        
            case PROP_ID_snumber:
               return getSnumber();
        
            case PROP_ID_scarfcolor:
               return getScarfcolor();
        
            case PROP_ID_shoescolor:
               return getShoescolor();
        
            case PROP_ID_shoesstyle:
               return getShoesstyle();
        
            case PROP_ID_skincolor:
               return getSkincolor();
        
            case PROP_ID_sourceid:
               return getSourceid();
        
            case PROP_ID_status:
               return getStatus();
        
            case PROP_ID_suspectedterroristnumber:
               return getSuspectedterroristnumber();
        
            case PROP_ID_targetimgurl:
               return getTargetimgurl();
        
            case PROP_ID_traceserviceinputtime:
               return getTraceserviceinputtime();
        
            case PROP_ID_tracethingsinputtime:
               return getTracethingsinputtime();
        
            case PROP_ID_trouserscolor:
               return getTrouserscolor();
        
            case PROP_ID_trouserscolorreliability:
               return getTrouserscolorreliability();
        
            case PROP_ID_trouserslen:
               return getTrouserslen();
        
            case PROP_ID_trouserslenreliability:
               return getTrouserslenreliability();
        
            case PROP_ID_trousersstyle:
               return getTrousersstyle();
        
            case PROP_ID_uid:
               return getUid();
        
            case PROP_ID_umbrella:
               return getUmbrella();
        
            case PROP_ID_umbrellacolor:
               return getUmbrellacolor();
        
            case PROP_ID_umbrellareliability:
               return getUmbrellareliability();
        
            case PROP_ID_uniformstyle:
               return getUniformstyle();
        
            case PROP_ID_uniformstylereliability:
               return getUniformstylereliability();
        
            case PROP_ID_usedname:
               return getUsedname();
        
            case PROP_ID_userchannelcode:
               return getUserchannelcode();
        
            case PROP_ID_vehiclecolor:
               return getVehiclecolor();
        
            case PROP_ID_vehicletype:
               return getVehicletype();
        
            case PROP_ID_vehicletypereliability:
               return getVehicletypereliability();
        
            case PROP_ID_vendor:
               return getVendor();
        
            case PROP_ID_victimtype:
               return getVictimtype();
        
           default:
              return super.orm_propValue(propId);
        }
    }

    

    @Override
    public void orm_propValue(int propId, Object value){
        switch(propId){
        
            case PROP_ID_absscore:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_absscore));
               }
               setAbsscore(typedValue);
               break;
            }
        
            case PROP_ID_accompanynumber:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_accompanynumber));
               }
               setAccompanynumber(typedValue);
               break;
            }
        
            case PROP_ID_accompanynumberreliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_accompanynumberreliability));
               }
               setAccompanynumberreliability(typedValue);
               break;
            }
        
            case PROP_ID_age:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_age));
               }
               setAge(typedValue);
               break;
            }
        
            case PROP_ID_agegroup:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_agegroup));
               }
               setAgegroup(typedValue);
               break;
            }
        
            case PROP_ID_agegroupreliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_agegroupreliability));
               }
               setAgegroupreliability(typedValue);
               break;
            }
        
            case PROP_ID_agelowerlimit:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_agelowerlimit));
               }
               setAgelowerlimit(typedValue);
               break;
            }
        
            case PROP_ID_agereliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_agereliability));
               }
               setAgereliability(typedValue);
               break;
            }
        
            case PROP_ID_ageuplimit:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_ageuplimit));
               }
               setAgeuplimit(typedValue);
               break;
            }
        
            case PROP_ID_algorithmversion:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_algorithmversion));
               }
               setAlgorithmversion(typedValue);
               break;
            }
        
            case PROP_ID_alias:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_alias));
               }
               setAlias(typedValue);
               break;
            }
        
            case PROP_ID_appendant:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_appendant));
               }
               setAppendant(typedValue);
               break;
            }
        
            case PROP_ID_appendantdescription:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_appendantdescription));
               }
               setAppendantdescription(typedValue);
               break;
            }
        
            case PROP_ID_baby:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_baby));
               }
               setBaby(typedValue);
               break;
            }
        
            case PROP_ID_bag1reliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_bag1reliability));
               }
               setBag1reliability(typedValue);
               break;
            }
        
            case PROP_ID_bag1style:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_bag1style));
               }
               setBag1style(typedValue);
               break;
            }
        
            case PROP_ID_bag2reliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_bag2reliability));
               }
               setBag2reliability(typedValue);
               break;
            }
        
            case PROP_ID_bag2style:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_bag2style));
               }
               setBag2style(typedValue);
               break;
            }
        
            case PROP_ID_bag3reliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_bag3reliability));
               }
               setBag3reliability(typedValue);
               break;
            }
        
            case PROP_ID_bag3style:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_bag3style));
               }
               setBag3style(typedValue);
               break;
            }
        
            case PROP_ID_bagcolor:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_bagcolor));
               }
               setBagcolor(typedValue);
               break;
            }
        
            case PROP_ID_bagstyle:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_bagstyle));
               }
               setBagstyle(typedValue);
               break;
            }
        
            case PROP_ID_bagstylereliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_bagstylereliability));
               }
               setBagstylereliability(typedValue);
               break;
            }
        
            case PROP_ID_behavior:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_behavior));
               }
               setBehavior(typedValue);
               break;
            }
        
            case PROP_ID_behaviordescription:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_behaviordescription));
               }
               setBehaviordescription(typedValue);
               break;
            }
        
            case PROP_ID_bodyfeature:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_bodyfeature));
               }
               setBodyfeature(typedValue);
               break;
            }
        
            case PROP_ID_bodyspeciallmark:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_bodyspeciallmark));
               }
               setBodyspeciallmark(typedValue);
               break;
            }
        
            case PROP_ID_bodytype:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_bodytype));
               }
               setBodytype(typedValue);
               break;
            }
        
            case PROP_ID_cacheimgurl:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_cacheimgurl));
               }
               setCacheimgurl(typedValue);
               break;
            }
        
            case PROP_ID_cacheplateimgurl:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_cacheplateimgurl));
               }
               setCacheplateimgurl(typedValue);
               break;
            }
        
            case PROP_ID_cachetargetimgurl:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_cachetargetimgurl));
               }
               setCachetargetimgurl(typedValue);
               break;
            }
        
            case PROP_ID_capcolor:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_capcolor));
               }
               setCapcolor(typedValue);
               break;
            }
        
            case PROP_ID_capcolorreliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_capcolorreliability));
               }
               setCapcolorreliability(typedValue);
               break;
            }
        
            case PROP_ID_capstyle:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_capstyle));
               }
               setCapstyle(typedValue);
               break;
            }
        
            case PROP_ID_capstylereliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_capstylereliability));
               }
               setCapstylereliability(typedValue);
               break;
            }
        
            case PROP_ID_captime:{
               java.lang.Long typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLong(value,
                       err-> newTypeConversionError(PROP_NAME_captime));
               }
               setCaptime(typedValue);
               break;
            }
        
            case PROP_ID_channelcode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_channelcode));
               }
               setChannelcode(typedValue);
               break;
            }
        
            case PROP_ID_channelid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_channelid));
               }
               setChannelid(typedValue);
               break;
            }
        
            case PROP_ID_chineseaccentcode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_chineseaccentcode));
               }
               setChineseaccentcode(typedValue);
               break;
            }
        
            case PROP_ID_coatcolor:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_coatcolor));
               }
               setCoatcolor(typedValue);
               break;
            }
        
            case PROP_ID_coatcolorreliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_coatcolorreliability));
               }
               setCoatcolorreliability(typedValue);
               break;
            }
        
            case PROP_ID_coatlength:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_coatlength));
               }
               setCoatlength(typedValue);
               break;
            }
        
            case PROP_ID_coatlengthreliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_coatlengthreliability));
               }
               setCoatlengthreliability(typedValue);
               break;
            }
        
            case PROP_ID_coatstyle:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_coatstyle));
               }
               setCoatstyle(typedValue);
               break;
            }
        
            case PROP_ID_coatstylereliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_coatstylereliability));
               }
               setCoatstylereliability(typedValue);
               break;
            }
        
            case PROP_ID_coattexture:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_coattexture));
               }
               setCoattexture(typedValue);
               break;
            }
        
            case PROP_ID_coattexturereliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_coattexturereliability));
               }
               setCoattexturereliability(typedValue);
               break;
            }
        
            case PROP_ID_completescore:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_completescore));
               }
               setCompletescore(typedValue);
               break;
            }
        
            case PROP_ID_corpseconditioncode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_corpseconditioncode));
               }
               setCorpseconditioncode(typedValue);
               break;
            }
        
            case PROP_ID_crimecharactercode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_crimecharactercode));
               }
               setCrimecharactercode(typedValue);
               break;
            }
        
            case PROP_ID_crimemethod:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_crimemethod));
               }
               setCrimemethod(typedValue);
               break;
            }
        
            case PROP_ID_criminalinvolvedcode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_criminalinvolvedcode));
               }
               setCriminalinvolvedcode(typedValue);
               break;
            }
        
            case PROP_ID_datasource:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_datasource));
               }
               setDatasource(typedValue);
               break;
            }
        
            case PROP_ID_datatracetag:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_datatracetag));
               }
               setDatatracetag(typedValue);
               break;
            }
        
            case PROP_ID_detaineesidentity:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_detaineesidentity));
               }
               setDetaineesidentity(typedValue);
               break;
            }
        
            case PROP_ID_detaineesspecialidentity:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_detaineesspecialidentity));
               }
               setDetaineesspecialidentity(typedValue);
               break;
            }
        
            case PROP_ID_detectobject:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_detectobject));
               }
               setDetectobject(typedValue);
               break;
            }
        
            case PROP_ID_detectionscore:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_detectionscore));
               }
               setDetectionscore(typedValue);
               break;
            }
        
            case PROP_ID_detentionhousecode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_detentionhousecode));
               }
               setDetentionhousecode(typedValue);
               break;
            }
        
            case PROP_ID_devicecode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_devicecode));
               }
               setDevicecode(typedValue);
               break;
            }
        
            case PROP_ID_deviceid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_deviceid));
               }
               setDeviceid(typedValue);
               break;
            }
        
            case PROP_ID_emclasstype:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_emclasstype));
               }
               setEmclasstype(typedValue);
               break;
            }
        
            case PROP_ID_escapedcriminalnumber:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_escapedcriminalnumber));
               }
               setEscapedcriminalnumber(typedValue);
               break;
            }
        
            case PROP_ID_event:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_event));
               }
               setEvent(typedValue);
               break;
            }
        
            case PROP_ID_extrecordid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_extrecordid));
               }
               setExtrecordid(typedValue);
               break;
            }
        
            case PROP_ID_extrecordsource:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_extrecordsource));
               }
               setExtrecordsource(typedValue);
               break;
            }
        
            case PROP_ID_extractedflag:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_extractedflag));
               }
               setExtractedflag(typedValue);
               break;
            }
        
            case PROP_ID_facedirect:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_facedirect));
               }
               setFacedirect(typedValue);
               break;
            }
        
            case PROP_ID_facedirectreliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_facedirectreliability));
               }
               setFacedirectreliability(typedValue);
               break;
            }
        
            case PROP_ID_facestyle:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_facestyle));
               }
               setFacestyle(typedValue);
               break;
            }
        
            case PROP_ID_facialfeature:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_facialfeature));
               }
               setFacialfeature(typedValue);
               break;
            }
        
            case PROP_ID_featuredata:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_featuredata));
               }
               setFeaturedata(typedValue);
               break;
            }
        
            case PROP_ID_featureid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_featureid));
               }
               setFeatureid(typedValue);
               break;
            }
        
            case PROP_ID_gender:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_gender));
               }
               setGender(typedValue);
               break;
            }
        
            case PROP_ID_genderreliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_genderreliability));
               }
               setGenderreliability(typedValue);
               break;
            }
        
            case PROP_ID_gesture:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_gesture));
               }
               setGesture(typedValue);
               break;
            }
        
            case PROP_ID_glasscolor:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_glasscolor));
               }
               setGlasscolor(typedValue);
               break;
            }
        
            case PROP_ID_glassstyle:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_glassstyle));
               }
               setGlassstyle(typedValue);
               break;
            }
        
            case PROP_ID_habitualmovemen:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_habitualmovemen));
               }
               setHabitualmovemen(typedValue);
               break;
            }
        
            case PROP_ID_haircolor:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_haircolor));
               }
               setHaircolor(typedValue);
               break;
            }
        
            case PROP_ID_hairstyle:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_hairstyle));
               }
               setHairstyle(typedValue);
               break;
            }
        
            case PROP_ID_hairstylereliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hairstylereliability));
               }
               setHairstylereliability(typedValue);
               break;
            }
        
            case PROP_ID_hairtype:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hairtype));
               }
               setHairtype(typedValue);
               break;
            }
        
            case PROP_ID_hasbag:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hasbag));
               }
               setHasbag(typedValue);
               break;
            }
        
            case PROP_ID_hasbagreliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hasbagreliability));
               }
               setHasbagreliability(typedValue);
               break;
            }
        
            case PROP_ID_hasbasket:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hasbasket));
               }
               setHasbasket(typedValue);
               break;
            }
        
            case PROP_ID_hascarrierbag:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hascarrierbag));
               }
               setHascarrierbag(typedValue);
               break;
            }
        
            case PROP_ID_hascarrystuff:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hascarrystuff));
               }
               setHascarrystuff(typedValue);
               break;
            }
        
            case PROP_ID_hascart:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hascart));
               }
               setHascart(typedValue);
               break;
            }
        
            case PROP_ID_hasdownbody:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hasdownbody));
               }
               setHasdownbody(typedValue);
               break;
            }
        
            case PROP_ID_hasdownbodyreliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hasdownbodyreliability));
               }
               setHasdownbodyreliability(typedValue);
               break;
            }
        
            case PROP_ID_haserrordetect:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_haserrordetect));
               }
               setHaserrordetect(typedValue);
               break;
            }
        
            case PROP_ID_hashead:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hashead));
               }
               setHashead(typedValue);
               break;
            }
        
            case PROP_ID_hasheadreliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hasheadreliability));
               }
               setHasheadreliability(typedValue);
               break;
            }
        
            case PROP_ID_hasmirror:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hasmirror));
               }
               setHasmirror(typedValue);
               break;
            }
        
            case PROP_ID_hasraincoat:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hasraincoat));
               }
               setHasraincoat(typedValue);
               break;
            }
        
            case PROP_ID_hasrespirator:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hasrespirator));
               }
               setHasrespirator(typedValue);
               break;
            }
        
            case PROP_ID_hastrunk:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hastrunk));
               }
               setHastrunk(typedValue);
               break;
            }
        
            case PROP_ID_hasvehicle:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hasvehicle));
               }
               setHasvehicle(typedValue);
               break;
            }
        
            case PROP_ID_hasvest:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hasvest));
               }
               setHasvest(typedValue);
               break;
            }
        
            case PROP_ID_hasvestreliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hasvestreliability));
               }
               setHasvestreliability(typedValue);
               break;
            }
        
            case PROP_ID_hat:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hat));
               }
               setHat(typedValue);
               break;
            }
        
            case PROP_ID_hatreliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_hatreliability));
               }
               setHatreliability(typedValue);
               break;
            }
        
            case PROP_ID_heightlowerlimit:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_heightlowerlimit));
               }
               setHeightlowerlimit(typedValue);
               break;
            }
        
            case PROP_ID_heightuplimit:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_heightuplimit));
               }
               setHeightuplimit(typedValue);
               break;
            }
        
            case PROP_ID_humanlist:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_humanlist));
               }
               setHumanlist(typedValue);
               break;
            }
        
            case PROP_ID_idnumber:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_idnumber));
               }
               setIdnumber(typedValue);
               break;
            }
        
            case PROP_ID_idtype:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_idtype));
               }
               setIdtype(typedValue);
               break;
            }
        
            case PROP_ID_imgheight:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_imgheight));
               }
               setImgheight(typedValue);
               break;
            }
        
            case PROP_ID_imgurl:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_imgurl));
               }
               setImgurl(typedValue);
               break;
            }
        
            case PROP_ID_imgwidth:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_imgwidth));
               }
               setImgwidth(typedValue);
               break;
            }
        
            case PROP_ID_immigranttypecode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_immigranttypecode));
               }
               setImmigranttypecode(typedValue);
               break;
            }
        
            case PROP_ID_infokind:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_infokind));
               }
               setInfokind(typedValue);
               break;
            }
        
            case PROP_ID_injureddegree:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_injureddegree));
               }
               setInjureddegree(typedValue);
               break;
            }
        
            case PROP_ID_iqascore:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_iqascore));
               }
               setIqascore(typedValue);
               break;
            }
        
            case PROP_ID_iscriminalinvolved:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_iscriminalinvolved));
               }
               setIscriminalinvolved(typedValue);
               break;
            }
        
            case PROP_ID_isdetainees:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_isdetainees));
               }
               setIsdetainees(typedValue);
               break;
            }
        
            case PROP_ID_isdriver:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_isdriver));
               }
               setIsdriver(typedValue);
               break;
            }
        
            case PROP_ID_isforeigner:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_isforeigner));
               }
               setIsforeigner(typedValue);
               break;
            }
        
            case PROP_ID_isnoncomplete:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_isnoncomplete));
               }
               setIsnoncomplete(typedValue);
               break;
            }
        
            case PROP_ID_issuspectedterrorist:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_issuspectedterrorist));
               }
               setIssuspectedterrorist(typedValue);
               break;
            }
        
            case PROP_ID_issuspiciousperson:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_issuspiciousperson));
               }
               setIssuspiciousperson(typedValue);
               break;
            }
        
            case PROP_ID_isvictim:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_isvictim));
               }
               setIsvictim(typedValue);
               break;
            }
        
            case PROP_ID_jobcategory:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_jobcategory));
               }
               setJobcategory(typedValue);
               break;
            }
        
            case PROP_ID_locationmarktime:{
               java.lang.Long typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLong(value,
                       err-> newTypeConversionError(PROP_NAME_locationmarktime));
               }
               setLocationmarktime(typedValue);
               break;
            }
        
            case PROP_ID_mask:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_mask));
               }
               setMask(typedValue);
               break;
            }
        
            case PROP_ID_maskcolor:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_maskcolor));
               }
               setMaskcolor(typedValue);
               break;
            }
        
            case PROP_ID_membertypecode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_membertypecode));
               }
               setMembertypecode(typedValue);
               break;
            }
        
            case PROP_ID_name:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_name));
               }
               setName(typedValue);
               break;
            }
        
            case PROP_ID_nationalitycode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_nationalitycode));
               }
               setNationalitycode(typedValue);
               break;
            }
        
            case PROP_ID_nativecitycode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_nativecitycode));
               }
               setNativecitycode(typedValue);
               break;
            }
        
            case PROP_ID_nonvehicleumbrellacolor:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_nonvehicleumbrellacolor));
               }
               setNonvehicleumbrellacolor(typedValue);
               break;
            }
        
            case PROP_ID_nonvehicleumbrellatype:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_nonvehicleumbrellatype));
               }
               setNonvehicleumbrellatype(typedValue);
               break;
            }
        
            case PROP_ID_nonvehicleumbrellatypereliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_nonvehicleumbrellatypereliability));
               }
               setNonvehicleumbrellatypereliability(typedValue);
               break;
            }
        
            case PROP_ID_objsize:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_objsize));
               }
               setObjsize(typedValue);
               break;
            }
        
            case PROP_ID_objectsubtype:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_objectsubtype));
               }
               setObjectsubtype(typedValue);
               break;
            }
        
            case PROP_ID_passenger:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_passenger));
               }
               setPassenger(typedValue);
               break;
            }
        
            case PROP_ID_passporttype:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_passporttype));
               }
               setPassporttype(typedValue);
               break;
            }
        
            case PROP_ID_personappeartime:{
               java.lang.Long typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLong(value,
                       err-> newTypeConversionError(PROP_NAME_personappeartime));
               }
               setPersonappeartime(typedValue);
               break;
            }
        
            case PROP_ID_personbottom:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_personbottom));
               }
               setPersonbottom(typedValue);
               break;
            }
        
            case PROP_ID_persondisappeartime:{
               java.lang.Long typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLong(value,
                       err-> newTypeConversionError(PROP_NAME_persondisappeartime));
               }
               setPersondisappeartime(typedValue);
               break;
            }
        
            case PROP_ID_personimgid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_personimgid));
               }
               setPersonimgid(typedValue);
               break;
            }
        
            case PROP_ID_personleft:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_personleft));
               }
               setPersonleft(typedValue);
               break;
            }
        
            case PROP_ID_personorg:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_personorg));
               }
               setPersonorg(typedValue);
               break;
            }
        
            case PROP_ID_personright:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_personright));
               }
               setPersonright(typedValue);
               break;
            }
        
            case PROP_ID_persontop:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_persontop));
               }
               setPersontop(typedValue);
               break;
            }
        
            case PROP_ID_physicalfeature:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_physicalfeature));
               }
               setPhysicalfeature(typedValue);
               break;
            }
        
            case PROP_ID_picrecordid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_picrecordid));
               }
               setPicrecordid(typedValue);
               break;
            }
        
            case PROP_ID_platebottom:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_platebottom));
               }
               setPlatebottom(typedValue);
               break;
            }
        
            case PROP_ID_platecolor:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_platecolor));
               }
               setPlatecolor(typedValue);
               break;
            }
        
            case PROP_ID_plateimgurl:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_plateimgurl));
               }
               setPlateimgurl(typedValue);
               break;
            }
        
            case PROP_ID_plateleft:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_plateleft));
               }
               setPlateleft(typedValue);
               break;
            }
        
            case PROP_ID_platenum:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_platenum));
               }
               setPlatenum(typedValue);
               break;
            }
        
            case PROP_ID_plateright:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_plateright));
               }
               setPlateright(typedValue);
               break;
            }
        
            case PROP_ID_platetop:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_platetop));
               }
               setPlatetop(typedValue);
               break;
            }
        
            case PROP_ID_posture:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_posture));
               }
               setPosture(typedValue);
               break;
            }
        
            case PROP_ID_posturereliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_posturereliability));
               }
               setPosturereliability(typedValue);
               break;
            }
        
            case PROP_ID_prevmsgrecordid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_prevmsgrecordid));
               }
               setPrevmsgrecordid(typedValue);
               break;
            }
        
            case PROP_ID_qescore:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_qescore));
               }
               setQescore(typedValue);
               break;
            }
        
            case PROP_ID_raincoatreliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_raincoatreliability));
               }
               setRaincoatreliability(typedValue);
               break;
            }
        
            case PROP_ID_recordid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_recordid));
               }
               setRecordid(typedValue);
               break;
            }
        
            case PROP_ID_relatedface:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_relatedface));
               }
               setRelatedface(typedValue);
               break;
            }
        
            case PROP_ID_relatedgait:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_relatedgait));
               }
               setRelatedgait(typedValue);
               break;
            }
        
            case PROP_ID_relatednonvehicle:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_relatednonvehicle));
               }
               setRelatednonvehicle(typedValue);
               break;
            }
        
            case PROP_ID_relatednonvehiclelist:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_relatednonvehiclelist));
               }
               setRelatednonvehiclelist(typedValue);
               break;
            }
        
            case PROP_ID_relatedperson:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_relatedperson));
               }
               setRelatedperson(typedValue);
               break;
            }
        
            case PROP_ID_reliablity:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_reliablity));
               }
               setReliablity(typedValue);
               break;
            }
        
            case PROP_ID_residenceadmindivision:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_residenceadmindivision));
               }
               setResidenceadmindivision(typedValue);
               break;
            }
        
            case PROP_ID_respiratorcolor:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_respiratorcolor));
               }
               setRespiratorcolor(typedValue);
               break;
            }
        
            case PROP_ID_rfidinfo:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_rfidinfo));
               }
               setRfidinfo(typedValue);
               break;
            }
        
            case PROP_ID_ridervehicle:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_ridervehicle));
               }
               setRidervehicle(typedValue);
               break;
            }
        
            case PROP_ID_snumber:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_snumber));
               }
               setSnumber(typedValue);
               break;
            }
        
            case PROP_ID_scarfcolor:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_scarfcolor));
               }
               setScarfcolor(typedValue);
               break;
            }
        
            case PROP_ID_shoescolor:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_shoescolor));
               }
               setShoescolor(typedValue);
               break;
            }
        
            case PROP_ID_shoesstyle:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_shoesstyle));
               }
               setShoesstyle(typedValue);
               break;
            }
        
            case PROP_ID_skincolor:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_skincolor));
               }
               setSkincolor(typedValue);
               break;
            }
        
            case PROP_ID_sourceid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_sourceid));
               }
               setSourceid(typedValue);
               break;
            }
        
            case PROP_ID_status:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_status));
               }
               setStatus(typedValue);
               break;
            }
        
            case PROP_ID_suspectedterroristnumber:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_suspectedterroristnumber));
               }
               setSuspectedterroristnumber(typedValue);
               break;
            }
        
            case PROP_ID_targetimgurl:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_targetimgurl));
               }
               setTargetimgurl(typedValue);
               break;
            }
        
            case PROP_ID_traceserviceinputtime:{
               java.lang.Long typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLong(value,
                       err-> newTypeConversionError(PROP_NAME_traceserviceinputtime));
               }
               setTraceserviceinputtime(typedValue);
               break;
            }
        
            case PROP_ID_tracethingsinputtime:{
               java.lang.Long typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toLong(value,
                       err-> newTypeConversionError(PROP_NAME_tracethingsinputtime));
               }
               setTracethingsinputtime(typedValue);
               break;
            }
        
            case PROP_ID_trouserscolor:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_trouserscolor));
               }
               setTrouserscolor(typedValue);
               break;
            }
        
            case PROP_ID_trouserscolorreliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_trouserscolorreliability));
               }
               setTrouserscolorreliability(typedValue);
               break;
            }
        
            case PROP_ID_trouserslen:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_trouserslen));
               }
               setTrouserslen(typedValue);
               break;
            }
        
            case PROP_ID_trouserslenreliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_trouserslenreliability));
               }
               setTrouserslenreliability(typedValue);
               break;
            }
        
            case PROP_ID_trousersstyle:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_trousersstyle));
               }
               setTrousersstyle(typedValue);
               break;
            }
        
            case PROP_ID_uid:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_uid));
               }
               setUid(typedValue);
               break;
            }
        
            case PROP_ID_umbrella:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_umbrella));
               }
               setUmbrella(typedValue);
               break;
            }
        
            case PROP_ID_umbrellacolor:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_umbrellacolor));
               }
               setUmbrellacolor(typedValue);
               break;
            }
        
            case PROP_ID_umbrellareliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_umbrellareliability));
               }
               setUmbrellareliability(typedValue);
               break;
            }
        
            case PROP_ID_uniformstyle:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_uniformstyle));
               }
               setUniformstyle(typedValue);
               break;
            }
        
            case PROP_ID_uniformstylereliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_uniformstylereliability));
               }
               setUniformstylereliability(typedValue);
               break;
            }
        
            case PROP_ID_usedname:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_usedname));
               }
               setUsedname(typedValue);
               break;
            }
        
            case PROP_ID_userchannelcode:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_userchannelcode));
               }
               setUserchannelcode(typedValue);
               break;
            }
        
            case PROP_ID_vehiclecolor:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_vehiclecolor));
               }
               setVehiclecolor(typedValue);
               break;
            }
        
            case PROP_ID_vehicletype:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_vehicletype));
               }
               setVehicletype(typedValue);
               break;
            }
        
            case PROP_ID_vehicletypereliability:{
               java.lang.Integer typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toInteger(value,
                       err-> newTypeConversionError(PROP_NAME_vehicletypereliability));
               }
               setVehicletypereliability(typedValue);
               break;
            }
        
            case PROP_ID_vendor:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_vendor));
               }
               setVendor(typedValue);
               break;
            }
        
            case PROP_ID_victimtype:{
               java.lang.String typedValue = null;
               if(value != null){
                   typedValue = ConvertHelper.toString(value,
                       err-> newTypeConversionError(PROP_NAME_victimtype));
               }
               setVictimtype(typedValue);
               break;
            }
        
           default:
              super.orm_propValue(propId,value);
        }
    }

    @Override
    public void orm_internalSet(int propId, Object value) {
        switch(propId){
        
            case PROP_ID_absscore:{
               onInitProp(propId);
               this._absscore = (java.lang.Integer)value;
               orm_id(); // 如果是设置主键字段，则触发watcher
               break;
            }
        
            case PROP_ID_accompanynumber:{
               onInitProp(propId);
               this._accompanynumber = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_accompanynumberreliability:{
               onInitProp(propId);
               this._accompanynumberreliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_age:{
               onInitProp(propId);
               this._age = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_agegroup:{
               onInitProp(propId);
               this._agegroup = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_agegroupreliability:{
               onInitProp(propId);
               this._agegroupreliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_agelowerlimit:{
               onInitProp(propId);
               this._agelowerlimit = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_agereliability:{
               onInitProp(propId);
               this._agereliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_ageuplimit:{
               onInitProp(propId);
               this._ageuplimit = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_algorithmversion:{
               onInitProp(propId);
               this._algorithmversion = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_alias:{
               onInitProp(propId);
               this._alias = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_appendant:{
               onInitProp(propId);
               this._appendant = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_appendantdescription:{
               onInitProp(propId);
               this._appendantdescription = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_baby:{
               onInitProp(propId);
               this._baby = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_bag1reliability:{
               onInitProp(propId);
               this._bag1reliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_bag1style:{
               onInitProp(propId);
               this._bag1style = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_bag2reliability:{
               onInitProp(propId);
               this._bag2reliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_bag2style:{
               onInitProp(propId);
               this._bag2style = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_bag3reliability:{
               onInitProp(propId);
               this._bag3reliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_bag3style:{
               onInitProp(propId);
               this._bag3style = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_bagcolor:{
               onInitProp(propId);
               this._bagcolor = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_bagstyle:{
               onInitProp(propId);
               this._bagstyle = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_bagstylereliability:{
               onInitProp(propId);
               this._bagstylereliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_behavior:{
               onInitProp(propId);
               this._behavior = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_behaviordescription:{
               onInitProp(propId);
               this._behaviordescription = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_bodyfeature:{
               onInitProp(propId);
               this._bodyfeature = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_bodyspeciallmark:{
               onInitProp(propId);
               this._bodyspeciallmark = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_bodytype:{
               onInitProp(propId);
               this._bodytype = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_cacheimgurl:{
               onInitProp(propId);
               this._cacheimgurl = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_cacheplateimgurl:{
               onInitProp(propId);
               this._cacheplateimgurl = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_cachetargetimgurl:{
               onInitProp(propId);
               this._cachetargetimgurl = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_capcolor:{
               onInitProp(propId);
               this._capcolor = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_capcolorreliability:{
               onInitProp(propId);
               this._capcolorreliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_capstyle:{
               onInitProp(propId);
               this._capstyle = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_capstylereliability:{
               onInitProp(propId);
               this._capstylereliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_captime:{
               onInitProp(propId);
               this._captime = (java.lang.Long)value;
               
               break;
            }
        
            case PROP_ID_channelcode:{
               onInitProp(propId);
               this._channelcode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_channelid:{
               onInitProp(propId);
               this._channelid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_chineseaccentcode:{
               onInitProp(propId);
               this._chineseaccentcode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_coatcolor:{
               onInitProp(propId);
               this._coatcolor = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_coatcolorreliability:{
               onInitProp(propId);
               this._coatcolorreliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_coatlength:{
               onInitProp(propId);
               this._coatlength = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_coatlengthreliability:{
               onInitProp(propId);
               this._coatlengthreliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_coatstyle:{
               onInitProp(propId);
               this._coatstyle = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_coatstylereliability:{
               onInitProp(propId);
               this._coatstylereliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_coattexture:{
               onInitProp(propId);
               this._coattexture = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_coattexturereliability:{
               onInitProp(propId);
               this._coattexturereliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_completescore:{
               onInitProp(propId);
               this._completescore = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_corpseconditioncode:{
               onInitProp(propId);
               this._corpseconditioncode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_crimecharactercode:{
               onInitProp(propId);
               this._crimecharactercode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_crimemethod:{
               onInitProp(propId);
               this._crimemethod = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_criminalinvolvedcode:{
               onInitProp(propId);
               this._criminalinvolvedcode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_datasource:{
               onInitProp(propId);
               this._datasource = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_datatracetag:{
               onInitProp(propId);
               this._datatracetag = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_detaineesidentity:{
               onInitProp(propId);
               this._detaineesidentity = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_detaineesspecialidentity:{
               onInitProp(propId);
               this._detaineesspecialidentity = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_detectobject:{
               onInitProp(propId);
               this._detectobject = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_detectionscore:{
               onInitProp(propId);
               this._detectionscore = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_detentionhousecode:{
               onInitProp(propId);
               this._detentionhousecode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_devicecode:{
               onInitProp(propId);
               this._devicecode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_deviceid:{
               onInitProp(propId);
               this._deviceid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_emclasstype:{
               onInitProp(propId);
               this._emclasstype = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_escapedcriminalnumber:{
               onInitProp(propId);
               this._escapedcriminalnumber = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_event:{
               onInitProp(propId);
               this._event = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_extrecordid:{
               onInitProp(propId);
               this._extrecordid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_extrecordsource:{
               onInitProp(propId);
               this._extrecordsource = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_extractedflag:{
               onInitProp(propId);
               this._extractedflag = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_facedirect:{
               onInitProp(propId);
               this._facedirect = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_facedirectreliability:{
               onInitProp(propId);
               this._facedirectreliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_facestyle:{
               onInitProp(propId);
               this._facestyle = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_facialfeature:{
               onInitProp(propId);
               this._facialfeature = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_featuredata:{
               onInitProp(propId);
               this._featuredata = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_featureid:{
               onInitProp(propId);
               this._featureid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_gender:{
               onInitProp(propId);
               this._gender = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_genderreliability:{
               onInitProp(propId);
               this._genderreliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_gesture:{
               onInitProp(propId);
               this._gesture = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_glasscolor:{
               onInitProp(propId);
               this._glasscolor = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_glassstyle:{
               onInitProp(propId);
               this._glassstyle = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_habitualmovemen:{
               onInitProp(propId);
               this._habitualmovemen = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_haircolor:{
               onInitProp(propId);
               this._haircolor = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_hairstyle:{
               onInitProp(propId);
               this._hairstyle = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_hairstylereliability:{
               onInitProp(propId);
               this._hairstylereliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hairtype:{
               onInitProp(propId);
               this._hairtype = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hasbag:{
               onInitProp(propId);
               this._hasbag = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hasbagreliability:{
               onInitProp(propId);
               this._hasbagreliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hasbasket:{
               onInitProp(propId);
               this._hasbasket = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hascarrierbag:{
               onInitProp(propId);
               this._hascarrierbag = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hascarrystuff:{
               onInitProp(propId);
               this._hascarrystuff = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hascart:{
               onInitProp(propId);
               this._hascart = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hasdownbody:{
               onInitProp(propId);
               this._hasdownbody = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hasdownbodyreliability:{
               onInitProp(propId);
               this._hasdownbodyreliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_haserrordetect:{
               onInitProp(propId);
               this._haserrordetect = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hashead:{
               onInitProp(propId);
               this._hashead = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hasheadreliability:{
               onInitProp(propId);
               this._hasheadreliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hasmirror:{
               onInitProp(propId);
               this._hasmirror = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hasraincoat:{
               onInitProp(propId);
               this._hasraincoat = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hasrespirator:{
               onInitProp(propId);
               this._hasrespirator = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hastrunk:{
               onInitProp(propId);
               this._hastrunk = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hasvehicle:{
               onInitProp(propId);
               this._hasvehicle = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hasvest:{
               onInitProp(propId);
               this._hasvest = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hasvestreliability:{
               onInitProp(propId);
               this._hasvestreliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hat:{
               onInitProp(propId);
               this._hat = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_hatreliability:{
               onInitProp(propId);
               this._hatreliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_heightlowerlimit:{
               onInitProp(propId);
               this._heightlowerlimit = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_heightuplimit:{
               onInitProp(propId);
               this._heightuplimit = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_humanlist:{
               onInitProp(propId);
               this._humanlist = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_idnumber:{
               onInitProp(propId);
               this._idnumber = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_idtype:{
               onInitProp(propId);
               this._idtype = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_imgheight:{
               onInitProp(propId);
               this._imgheight = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_imgurl:{
               onInitProp(propId);
               this._imgurl = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_imgwidth:{
               onInitProp(propId);
               this._imgwidth = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_immigranttypecode:{
               onInitProp(propId);
               this._immigranttypecode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_infokind:{
               onInitProp(propId);
               this._infokind = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_injureddegree:{
               onInitProp(propId);
               this._injureddegree = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_iqascore:{
               onInitProp(propId);
               this._iqascore = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_iscriminalinvolved:{
               onInitProp(propId);
               this._iscriminalinvolved = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_isdetainees:{
               onInitProp(propId);
               this._isdetainees = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_isdriver:{
               onInitProp(propId);
               this._isdriver = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_isforeigner:{
               onInitProp(propId);
               this._isforeigner = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_isnoncomplete:{
               onInitProp(propId);
               this._isnoncomplete = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_issuspectedterrorist:{
               onInitProp(propId);
               this._issuspectedterrorist = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_issuspiciousperson:{
               onInitProp(propId);
               this._issuspiciousperson = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_isvictim:{
               onInitProp(propId);
               this._isvictim = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_jobcategory:{
               onInitProp(propId);
               this._jobcategory = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_locationmarktime:{
               onInitProp(propId);
               this._locationmarktime = (java.lang.Long)value;
               
               break;
            }
        
            case PROP_ID_mask:{
               onInitProp(propId);
               this._mask = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_maskcolor:{
               onInitProp(propId);
               this._maskcolor = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_membertypecode:{
               onInitProp(propId);
               this._membertypecode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_name:{
               onInitProp(propId);
               this._name = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_nationalitycode:{
               onInitProp(propId);
               this._nationalitycode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_nativecitycode:{
               onInitProp(propId);
               this._nativecitycode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_nonvehicleumbrellacolor:{
               onInitProp(propId);
               this._nonvehicleumbrellacolor = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_nonvehicleumbrellatype:{
               onInitProp(propId);
               this._nonvehicleumbrellatype = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_nonvehicleumbrellatypereliability:{
               onInitProp(propId);
               this._nonvehicleumbrellatypereliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_objsize:{
               onInitProp(propId);
               this._objsize = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_objectsubtype:{
               onInitProp(propId);
               this._objectsubtype = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_passenger:{
               onInitProp(propId);
               this._passenger = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_passporttype:{
               onInitProp(propId);
               this._passporttype = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_personappeartime:{
               onInitProp(propId);
               this._personappeartime = (java.lang.Long)value;
               
               break;
            }
        
            case PROP_ID_personbottom:{
               onInitProp(propId);
               this._personbottom = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_persondisappeartime:{
               onInitProp(propId);
               this._persondisappeartime = (java.lang.Long)value;
               
               break;
            }
        
            case PROP_ID_personimgid:{
               onInitProp(propId);
               this._personimgid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_personleft:{
               onInitProp(propId);
               this._personleft = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_personorg:{
               onInitProp(propId);
               this._personorg = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_personright:{
               onInitProp(propId);
               this._personright = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_persontop:{
               onInitProp(propId);
               this._persontop = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_physicalfeature:{
               onInitProp(propId);
               this._physicalfeature = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_picrecordid:{
               onInitProp(propId);
               this._picrecordid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_platebottom:{
               onInitProp(propId);
               this._platebottom = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_platecolor:{
               onInitProp(propId);
               this._platecolor = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_plateimgurl:{
               onInitProp(propId);
               this._plateimgurl = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_plateleft:{
               onInitProp(propId);
               this._plateleft = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_platenum:{
               onInitProp(propId);
               this._platenum = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_plateright:{
               onInitProp(propId);
               this._plateright = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_platetop:{
               onInitProp(propId);
               this._platetop = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_posture:{
               onInitProp(propId);
               this._posture = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_posturereliability:{
               onInitProp(propId);
               this._posturereliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_prevmsgrecordid:{
               onInitProp(propId);
               this._prevmsgrecordid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_qescore:{
               onInitProp(propId);
               this._qescore = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_raincoatreliability:{
               onInitProp(propId);
               this._raincoatreliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_recordid:{
               onInitProp(propId);
               this._recordid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_relatedface:{
               onInitProp(propId);
               this._relatedface = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_relatedgait:{
               onInitProp(propId);
               this._relatedgait = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_relatednonvehicle:{
               onInitProp(propId);
               this._relatednonvehicle = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_relatednonvehiclelist:{
               onInitProp(propId);
               this._relatednonvehiclelist = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_relatedperson:{
               onInitProp(propId);
               this._relatedperson = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_reliablity:{
               onInitProp(propId);
               this._reliablity = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_residenceadmindivision:{
               onInitProp(propId);
               this._residenceadmindivision = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_respiratorcolor:{
               onInitProp(propId);
               this._respiratorcolor = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_rfidinfo:{
               onInitProp(propId);
               this._rfidinfo = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_ridervehicle:{
               onInitProp(propId);
               this._ridervehicle = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_snumber:{
               onInitProp(propId);
               this._snumber = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_scarfcolor:{
               onInitProp(propId);
               this._scarfcolor = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_shoescolor:{
               onInitProp(propId);
               this._shoescolor = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_shoesstyle:{
               onInitProp(propId);
               this._shoesstyle = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_skincolor:{
               onInitProp(propId);
               this._skincolor = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_sourceid:{
               onInitProp(propId);
               this._sourceid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_status:{
               onInitProp(propId);
               this._status = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_suspectedterroristnumber:{
               onInitProp(propId);
               this._suspectedterroristnumber = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_targetimgurl:{
               onInitProp(propId);
               this._targetimgurl = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_traceserviceinputtime:{
               onInitProp(propId);
               this._traceserviceinputtime = (java.lang.Long)value;
               
               break;
            }
        
            case PROP_ID_tracethingsinputtime:{
               onInitProp(propId);
               this._tracethingsinputtime = (java.lang.Long)value;
               
               break;
            }
        
            case PROP_ID_trouserscolor:{
               onInitProp(propId);
               this._trouserscolor = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_trouserscolorreliability:{
               onInitProp(propId);
               this._trouserscolorreliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_trouserslen:{
               onInitProp(propId);
               this._trouserslen = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_trouserslenreliability:{
               onInitProp(propId);
               this._trouserslenreliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_trousersstyle:{
               onInitProp(propId);
               this._trousersstyle = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_uid:{
               onInitProp(propId);
               this._uid = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_umbrella:{
               onInitProp(propId);
               this._umbrella = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_umbrellacolor:{
               onInitProp(propId);
               this._umbrellacolor = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_umbrellareliability:{
               onInitProp(propId);
               this._umbrellareliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_uniformstyle:{
               onInitProp(propId);
               this._uniformstyle = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_uniformstylereliability:{
               onInitProp(propId);
               this._uniformstylereliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_usedname:{
               onInitProp(propId);
               this._usedname = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_userchannelcode:{
               onInitProp(propId);
               this._userchannelcode = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_vehiclecolor:{
               onInitProp(propId);
               this._vehiclecolor = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_vehicletype:{
               onInitProp(propId);
               this._vehicletype = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_vehicletypereliability:{
               onInitProp(propId);
               this._vehicletypereliability = (java.lang.Integer)value;
               
               break;
            }
        
            case PROP_ID_vendor:{
               onInitProp(propId);
               this._vendor = (java.lang.String)value;
               
               break;
            }
        
            case PROP_ID_victimtype:{
               onInitProp(propId);
               this._victimtype = (java.lang.String)value;
               
               break;
            }
        
           default:
              super.orm_internalSet(propId,value);
        }
    }

    
    /**
     * Absscore: ABSSCORE
     */
    public final java.lang.Integer getAbsscore(){
         onPropGet(PROP_ID_absscore);
         return _absscore;
    }

    /**
     * Absscore: ABSSCORE
     */
    public final void setAbsscore(java.lang.Integer value){
        if(onPropSet(PROP_ID_absscore,value)){
            this._absscore = value;
            internalClearRefs(PROP_ID_absscore);
            orm_id();
        }
    }
    
    /**
     * Accompanynumber: ACCOMPANYNUMBER
     */
    public final java.lang.Integer getAccompanynumber(){
         onPropGet(PROP_ID_accompanynumber);
         return _accompanynumber;
    }

    /**
     * Accompanynumber: ACCOMPANYNUMBER
     */
    public final void setAccompanynumber(java.lang.Integer value){
        if(onPropSet(PROP_ID_accompanynumber,value)){
            this._accompanynumber = value;
            internalClearRefs(PROP_ID_accompanynumber);
            
        }
    }
    
    /**
     * Accompanynumberreliability: ACCOMPANYNUMBERRELIABILITY
     */
    public final java.lang.Integer getAccompanynumberreliability(){
         onPropGet(PROP_ID_accompanynumberreliability);
         return _accompanynumberreliability;
    }

    /**
     * Accompanynumberreliability: ACCOMPANYNUMBERRELIABILITY
     */
    public final void setAccompanynumberreliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_accompanynumberreliability,value)){
            this._accompanynumberreliability = value;
            internalClearRefs(PROP_ID_accompanynumberreliability);
            
        }
    }
    
    /**
     * Age: AGE
     */
    public final java.lang.Integer getAge(){
         onPropGet(PROP_ID_age);
         return _age;
    }

    /**
     * Age: AGE
     */
    public final void setAge(java.lang.Integer value){
        if(onPropSet(PROP_ID_age,value)){
            this._age = value;
            internalClearRefs(PROP_ID_age);
            
        }
    }
    
    /**
     * Agegroup: AGEGROUP
     */
    public final java.lang.Integer getAgegroup(){
         onPropGet(PROP_ID_agegroup);
         return _agegroup;
    }

    /**
     * Agegroup: AGEGROUP
     */
    public final void setAgegroup(java.lang.Integer value){
        if(onPropSet(PROP_ID_agegroup,value)){
            this._agegroup = value;
            internalClearRefs(PROP_ID_agegroup);
            
        }
    }
    
    /**
     * Agegroupreliability: AGEGROUPRELIABILITY
     */
    public final java.lang.Integer getAgegroupreliability(){
         onPropGet(PROP_ID_agegroupreliability);
         return _agegroupreliability;
    }

    /**
     * Agegroupreliability: AGEGROUPRELIABILITY
     */
    public final void setAgegroupreliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_agegroupreliability,value)){
            this._agegroupreliability = value;
            internalClearRefs(PROP_ID_agegroupreliability);
            
        }
    }
    
    /**
     * Agelowerlimit: AGELOWERLIMIT
     */
    public final java.lang.Integer getAgelowerlimit(){
         onPropGet(PROP_ID_agelowerlimit);
         return _agelowerlimit;
    }

    /**
     * Agelowerlimit: AGELOWERLIMIT
     */
    public final void setAgelowerlimit(java.lang.Integer value){
        if(onPropSet(PROP_ID_agelowerlimit,value)){
            this._agelowerlimit = value;
            internalClearRefs(PROP_ID_agelowerlimit);
            
        }
    }
    
    /**
     * Agereliability: AGERELIABILITY
     */
    public final java.lang.Integer getAgereliability(){
         onPropGet(PROP_ID_agereliability);
         return _agereliability;
    }

    /**
     * Agereliability: AGERELIABILITY
     */
    public final void setAgereliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_agereliability,value)){
            this._agereliability = value;
            internalClearRefs(PROP_ID_agereliability);
            
        }
    }
    
    /**
     * Ageuplimit: AGEUPLIMIT
     */
    public final java.lang.Integer getAgeuplimit(){
         onPropGet(PROP_ID_ageuplimit);
         return _ageuplimit;
    }

    /**
     * Ageuplimit: AGEUPLIMIT
     */
    public final void setAgeuplimit(java.lang.Integer value){
        if(onPropSet(PROP_ID_ageuplimit,value)){
            this._ageuplimit = value;
            internalClearRefs(PROP_ID_ageuplimit);
            
        }
    }
    
    /**
     * Algorithmversion: ALGORITHMVERSION
     */
    public final java.lang.String getAlgorithmversion(){
         onPropGet(PROP_ID_algorithmversion);
         return _algorithmversion;
    }

    /**
     * Algorithmversion: ALGORITHMVERSION
     */
    public final void setAlgorithmversion(java.lang.String value){
        if(onPropSet(PROP_ID_algorithmversion,value)){
            this._algorithmversion = value;
            internalClearRefs(PROP_ID_algorithmversion);
            
        }
    }
    
    /**
     * Alias: ALIAS
     */
    public final java.lang.String getAlias(){
         onPropGet(PROP_ID_alias);
         return _alias;
    }

    /**
     * Alias: ALIAS
     */
    public final void setAlias(java.lang.String value){
        if(onPropSet(PROP_ID_alias,value)){
            this._alias = value;
            internalClearRefs(PROP_ID_alias);
            
        }
    }
    
    /**
     * Appendant: APPENDANT
     */
    public final java.lang.String getAppendant(){
         onPropGet(PROP_ID_appendant);
         return _appendant;
    }

    /**
     * Appendant: APPENDANT
     */
    public final void setAppendant(java.lang.String value){
        if(onPropSet(PROP_ID_appendant,value)){
            this._appendant = value;
            internalClearRefs(PROP_ID_appendant);
            
        }
    }
    
    /**
     * Appendantdescription: APPENDANTDESCRIPTION
     */
    public final java.lang.String getAppendantdescription(){
         onPropGet(PROP_ID_appendantdescription);
         return _appendantdescription;
    }

    /**
     * Appendantdescription: APPENDANTDESCRIPTION
     */
    public final void setAppendantdescription(java.lang.String value){
        if(onPropSet(PROP_ID_appendantdescription,value)){
            this._appendantdescription = value;
            internalClearRefs(PROP_ID_appendantdescription);
            
        }
    }
    
    /**
     * Baby: BABY
     */
    public final java.lang.String getBaby(){
         onPropGet(PROP_ID_baby);
         return _baby;
    }

    /**
     * Baby: BABY
     */
    public final void setBaby(java.lang.String value){
        if(onPropSet(PROP_ID_baby,value)){
            this._baby = value;
            internalClearRefs(PROP_ID_baby);
            
        }
    }
    
    /**
     * Bag1reliability: BAG1RELIABILITY
     */
    public final java.lang.Integer getBag1reliability(){
         onPropGet(PROP_ID_bag1reliability);
         return _bag1reliability;
    }

    /**
     * Bag1reliability: BAG1RELIABILITY
     */
    public final void setBag1reliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_bag1reliability,value)){
            this._bag1reliability = value;
            internalClearRefs(PROP_ID_bag1reliability);
            
        }
    }
    
    /**
     * Bag1style: BAG1STYLE
     */
    public final java.lang.String getBag1style(){
         onPropGet(PROP_ID_bag1style);
         return _bag1style;
    }

    /**
     * Bag1style: BAG1STYLE
     */
    public final void setBag1style(java.lang.String value){
        if(onPropSet(PROP_ID_bag1style,value)){
            this._bag1style = value;
            internalClearRefs(PROP_ID_bag1style);
            
        }
    }
    
    /**
     * Bag2reliability: BAG2RELIABILITY
     */
    public final java.lang.Integer getBag2reliability(){
         onPropGet(PROP_ID_bag2reliability);
         return _bag2reliability;
    }

    /**
     * Bag2reliability: BAG2RELIABILITY
     */
    public final void setBag2reliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_bag2reliability,value)){
            this._bag2reliability = value;
            internalClearRefs(PROP_ID_bag2reliability);
            
        }
    }
    
    /**
     * Bag2style: BAG2STYLE
     */
    public final java.lang.String getBag2style(){
         onPropGet(PROP_ID_bag2style);
         return _bag2style;
    }

    /**
     * Bag2style: BAG2STYLE
     */
    public final void setBag2style(java.lang.String value){
        if(onPropSet(PROP_ID_bag2style,value)){
            this._bag2style = value;
            internalClearRefs(PROP_ID_bag2style);
            
        }
    }
    
    /**
     * Bag3reliability: BAG3RELIABILITY
     */
    public final java.lang.Integer getBag3reliability(){
         onPropGet(PROP_ID_bag3reliability);
         return _bag3reliability;
    }

    /**
     * Bag3reliability: BAG3RELIABILITY
     */
    public final void setBag3reliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_bag3reliability,value)){
            this._bag3reliability = value;
            internalClearRefs(PROP_ID_bag3reliability);
            
        }
    }
    
    /**
     * Bag3style: BAG3STYLE
     */
    public final java.lang.String getBag3style(){
         onPropGet(PROP_ID_bag3style);
         return _bag3style;
    }

    /**
     * Bag3style: BAG3STYLE
     */
    public final void setBag3style(java.lang.String value){
        if(onPropSet(PROP_ID_bag3style,value)){
            this._bag3style = value;
            internalClearRefs(PROP_ID_bag3style);
            
        }
    }
    
    /**
     * Bagcolor: BAGCOLOR
     */
    public final java.lang.String getBagcolor(){
         onPropGet(PROP_ID_bagcolor);
         return _bagcolor;
    }

    /**
     * Bagcolor: BAGCOLOR
     */
    public final void setBagcolor(java.lang.String value){
        if(onPropSet(PROP_ID_bagcolor,value)){
            this._bagcolor = value;
            internalClearRefs(PROP_ID_bagcolor);
            
        }
    }
    
    /**
     * Bagstyle: BAGSTYLE
     */
    public final java.lang.String getBagstyle(){
         onPropGet(PROP_ID_bagstyle);
         return _bagstyle;
    }

    /**
     * Bagstyle: BAGSTYLE
     */
    public final void setBagstyle(java.lang.String value){
        if(onPropSet(PROP_ID_bagstyle,value)){
            this._bagstyle = value;
            internalClearRefs(PROP_ID_bagstyle);
            
        }
    }
    
    /**
     * Bagstylereliability: BAGSTYLERELIABILITY
     */
    public final java.lang.Integer getBagstylereliability(){
         onPropGet(PROP_ID_bagstylereliability);
         return _bagstylereliability;
    }

    /**
     * Bagstylereliability: BAGSTYLERELIABILITY
     */
    public final void setBagstylereliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_bagstylereliability,value)){
            this._bagstylereliability = value;
            internalClearRefs(PROP_ID_bagstylereliability);
            
        }
    }
    
    /**
     * Behavior: BEHAVIOR
     */
    public final java.lang.String getBehavior(){
         onPropGet(PROP_ID_behavior);
         return _behavior;
    }

    /**
     * Behavior: BEHAVIOR
     */
    public final void setBehavior(java.lang.String value){
        if(onPropSet(PROP_ID_behavior,value)){
            this._behavior = value;
            internalClearRefs(PROP_ID_behavior);
            
        }
    }
    
    /**
     * Behaviordescription: BEHAVIORDESCRIPTION
     */
    public final java.lang.String getBehaviordescription(){
         onPropGet(PROP_ID_behaviordescription);
         return _behaviordescription;
    }

    /**
     * Behaviordescription: BEHAVIORDESCRIPTION
     */
    public final void setBehaviordescription(java.lang.String value){
        if(onPropSet(PROP_ID_behaviordescription,value)){
            this._behaviordescription = value;
            internalClearRefs(PROP_ID_behaviordescription);
            
        }
    }
    
    /**
     * Bodyfeature: BODYFEATURE
     */
    public final java.lang.String getBodyfeature(){
         onPropGet(PROP_ID_bodyfeature);
         return _bodyfeature;
    }

    /**
     * Bodyfeature: BODYFEATURE
     */
    public final void setBodyfeature(java.lang.String value){
        if(onPropSet(PROP_ID_bodyfeature,value)){
            this._bodyfeature = value;
            internalClearRefs(PROP_ID_bodyfeature);
            
        }
    }
    
    /**
     * Bodyspeciallmark: BODYSPECIALLMARK
     */
    public final java.lang.String getBodyspeciallmark(){
         onPropGet(PROP_ID_bodyspeciallmark);
         return _bodyspeciallmark;
    }

    /**
     * Bodyspeciallmark: BODYSPECIALLMARK
     */
    public final void setBodyspeciallmark(java.lang.String value){
        if(onPropSet(PROP_ID_bodyspeciallmark,value)){
            this._bodyspeciallmark = value;
            internalClearRefs(PROP_ID_bodyspeciallmark);
            
        }
    }
    
    /**
     * Bodytype: BODYTYPE
     */
    public final java.lang.String getBodytype(){
         onPropGet(PROP_ID_bodytype);
         return _bodytype;
    }

    /**
     * Bodytype: BODYTYPE
     */
    public final void setBodytype(java.lang.String value){
        if(onPropSet(PROP_ID_bodytype,value)){
            this._bodytype = value;
            internalClearRefs(PROP_ID_bodytype);
            
        }
    }
    
    /**
     * Cacheimgurl: CACHEIMGURL
     */
    public final java.lang.String getCacheimgurl(){
         onPropGet(PROP_ID_cacheimgurl);
         return _cacheimgurl;
    }

    /**
     * Cacheimgurl: CACHEIMGURL
     */
    public final void setCacheimgurl(java.lang.String value){
        if(onPropSet(PROP_ID_cacheimgurl,value)){
            this._cacheimgurl = value;
            internalClearRefs(PROP_ID_cacheimgurl);
            
        }
    }
    
    /**
     * Cacheplateimgurl: CACHEPLATEIMGURL
     */
    public final java.lang.String getCacheplateimgurl(){
         onPropGet(PROP_ID_cacheplateimgurl);
         return _cacheplateimgurl;
    }

    /**
     * Cacheplateimgurl: CACHEPLATEIMGURL
     */
    public final void setCacheplateimgurl(java.lang.String value){
        if(onPropSet(PROP_ID_cacheplateimgurl,value)){
            this._cacheplateimgurl = value;
            internalClearRefs(PROP_ID_cacheplateimgurl);
            
        }
    }
    
    /**
     * Cachetargetimgurl: CACHETARGETIMGURL
     */
    public final java.lang.String getCachetargetimgurl(){
         onPropGet(PROP_ID_cachetargetimgurl);
         return _cachetargetimgurl;
    }

    /**
     * Cachetargetimgurl: CACHETARGETIMGURL
     */
    public final void setCachetargetimgurl(java.lang.String value){
        if(onPropSet(PROP_ID_cachetargetimgurl,value)){
            this._cachetargetimgurl = value;
            internalClearRefs(PROP_ID_cachetargetimgurl);
            
        }
    }
    
    /**
     * Capcolor: CAPCOLOR
     */
    public final java.lang.String getCapcolor(){
         onPropGet(PROP_ID_capcolor);
         return _capcolor;
    }

    /**
     * Capcolor: CAPCOLOR
     */
    public final void setCapcolor(java.lang.String value){
        if(onPropSet(PROP_ID_capcolor,value)){
            this._capcolor = value;
            internalClearRefs(PROP_ID_capcolor);
            
        }
    }
    
    /**
     * Capcolorreliability: CAPCOLORRELIABILITY
     */
    public final java.lang.Integer getCapcolorreliability(){
         onPropGet(PROP_ID_capcolorreliability);
         return _capcolorreliability;
    }

    /**
     * Capcolorreliability: CAPCOLORRELIABILITY
     */
    public final void setCapcolorreliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_capcolorreliability,value)){
            this._capcolorreliability = value;
            internalClearRefs(PROP_ID_capcolorreliability);
            
        }
    }
    
    /**
     * Capstyle: CAPSTYLE
     */
    public final java.lang.String getCapstyle(){
         onPropGet(PROP_ID_capstyle);
         return _capstyle;
    }

    /**
     * Capstyle: CAPSTYLE
     */
    public final void setCapstyle(java.lang.String value){
        if(onPropSet(PROP_ID_capstyle,value)){
            this._capstyle = value;
            internalClearRefs(PROP_ID_capstyle);
            
        }
    }
    
    /**
     * Capstylereliability: CAPSTYLERELIABILITY
     */
    public final java.lang.Integer getCapstylereliability(){
         onPropGet(PROP_ID_capstylereliability);
         return _capstylereliability;
    }

    /**
     * Capstylereliability: CAPSTYLERELIABILITY
     */
    public final void setCapstylereliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_capstylereliability,value)){
            this._capstylereliability = value;
            internalClearRefs(PROP_ID_capstylereliability);
            
        }
    }
    
    /**
     * Captime: CAPTIME
     */
    public final java.lang.Long getCaptime(){
         onPropGet(PROP_ID_captime);
         return _captime;
    }

    /**
     * Captime: CAPTIME
     */
    public final void setCaptime(java.lang.Long value){
        if(onPropSet(PROP_ID_captime,value)){
            this._captime = value;
            internalClearRefs(PROP_ID_captime);
            
        }
    }
    
    /**
     * Channelcode: CHANNELCODE
     */
    public final java.lang.String getChannelcode(){
         onPropGet(PROP_ID_channelcode);
         return _channelcode;
    }

    /**
     * Channelcode: CHANNELCODE
     */
    public final void setChannelcode(java.lang.String value){
        if(onPropSet(PROP_ID_channelcode,value)){
            this._channelcode = value;
            internalClearRefs(PROP_ID_channelcode);
            
        }
    }
    
    /**
     * Channelid: CHANNELID
     */
    public final java.lang.String getChannelid(){
         onPropGet(PROP_ID_channelid);
         return _channelid;
    }

    /**
     * Channelid: CHANNELID
     */
    public final void setChannelid(java.lang.String value){
        if(onPropSet(PROP_ID_channelid,value)){
            this._channelid = value;
            internalClearRefs(PROP_ID_channelid);
            
        }
    }
    
    /**
     * Chineseaccentcode: CHINESEACCENTCODE
     */
    public final java.lang.String getChineseaccentcode(){
         onPropGet(PROP_ID_chineseaccentcode);
         return _chineseaccentcode;
    }

    /**
     * Chineseaccentcode: CHINESEACCENTCODE
     */
    public final void setChineseaccentcode(java.lang.String value){
        if(onPropSet(PROP_ID_chineseaccentcode,value)){
            this._chineseaccentcode = value;
            internalClearRefs(PROP_ID_chineseaccentcode);
            
        }
    }
    
    /**
     * Coatcolor: COATCOLOR
     */
    public final java.lang.String getCoatcolor(){
         onPropGet(PROP_ID_coatcolor);
         return _coatcolor;
    }

    /**
     * Coatcolor: COATCOLOR
     */
    public final void setCoatcolor(java.lang.String value){
        if(onPropSet(PROP_ID_coatcolor,value)){
            this._coatcolor = value;
            internalClearRefs(PROP_ID_coatcolor);
            
        }
    }
    
    /**
     * Coatcolorreliability: COATCOLORRELIABILITY
     */
    public final java.lang.Integer getCoatcolorreliability(){
         onPropGet(PROP_ID_coatcolorreliability);
         return _coatcolorreliability;
    }

    /**
     * Coatcolorreliability: COATCOLORRELIABILITY
     */
    public final void setCoatcolorreliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_coatcolorreliability,value)){
            this._coatcolorreliability = value;
            internalClearRefs(PROP_ID_coatcolorreliability);
            
        }
    }
    
    /**
     * Coatlength: COATLENGTH
     */
    public final java.lang.String getCoatlength(){
         onPropGet(PROP_ID_coatlength);
         return _coatlength;
    }

    /**
     * Coatlength: COATLENGTH
     */
    public final void setCoatlength(java.lang.String value){
        if(onPropSet(PROP_ID_coatlength,value)){
            this._coatlength = value;
            internalClearRefs(PROP_ID_coatlength);
            
        }
    }
    
    /**
     * Coatlengthreliability: COATLENGTHRELIABILITY
     */
    public final java.lang.Integer getCoatlengthreliability(){
         onPropGet(PROP_ID_coatlengthreliability);
         return _coatlengthreliability;
    }

    /**
     * Coatlengthreliability: COATLENGTHRELIABILITY
     */
    public final void setCoatlengthreliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_coatlengthreliability,value)){
            this._coatlengthreliability = value;
            internalClearRefs(PROP_ID_coatlengthreliability);
            
        }
    }
    
    /**
     * Coatstyle: COATSTYLE
     */
    public final java.lang.String getCoatstyle(){
         onPropGet(PROP_ID_coatstyle);
         return _coatstyle;
    }

    /**
     * Coatstyle: COATSTYLE
     */
    public final void setCoatstyle(java.lang.String value){
        if(onPropSet(PROP_ID_coatstyle,value)){
            this._coatstyle = value;
            internalClearRefs(PROP_ID_coatstyle);
            
        }
    }
    
    /**
     * Coatstylereliability: COATSTYLERELIABILITY
     */
    public final java.lang.Integer getCoatstylereliability(){
         onPropGet(PROP_ID_coatstylereliability);
         return _coatstylereliability;
    }

    /**
     * Coatstylereliability: COATSTYLERELIABILITY
     */
    public final void setCoatstylereliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_coatstylereliability,value)){
            this._coatstylereliability = value;
            internalClearRefs(PROP_ID_coatstylereliability);
            
        }
    }
    
    /**
     * Coattexture: COATTEXTURE
     */
    public final java.lang.String getCoattexture(){
         onPropGet(PROP_ID_coattexture);
         return _coattexture;
    }

    /**
     * Coattexture: COATTEXTURE
     */
    public final void setCoattexture(java.lang.String value){
        if(onPropSet(PROP_ID_coattexture,value)){
            this._coattexture = value;
            internalClearRefs(PROP_ID_coattexture);
            
        }
    }
    
    /**
     * Coattexturereliability: COATTEXTURERELIABILITY
     */
    public final java.lang.Integer getCoattexturereliability(){
         onPropGet(PROP_ID_coattexturereliability);
         return _coattexturereliability;
    }

    /**
     * Coattexturereliability: COATTEXTURERELIABILITY
     */
    public final void setCoattexturereliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_coattexturereliability,value)){
            this._coattexturereliability = value;
            internalClearRefs(PROP_ID_coattexturereliability);
            
        }
    }
    
    /**
     * Completescore: COMPLETESCORE
     */
    public final java.lang.Integer getCompletescore(){
         onPropGet(PROP_ID_completescore);
         return _completescore;
    }

    /**
     * Completescore: COMPLETESCORE
     */
    public final void setCompletescore(java.lang.Integer value){
        if(onPropSet(PROP_ID_completescore,value)){
            this._completescore = value;
            internalClearRefs(PROP_ID_completescore);
            
        }
    }
    
    /**
     * Corpseconditioncode: CORPSECONDITIONCODE
     */
    public final java.lang.String getCorpseconditioncode(){
         onPropGet(PROP_ID_corpseconditioncode);
         return _corpseconditioncode;
    }

    /**
     * Corpseconditioncode: CORPSECONDITIONCODE
     */
    public final void setCorpseconditioncode(java.lang.String value){
        if(onPropSet(PROP_ID_corpseconditioncode,value)){
            this._corpseconditioncode = value;
            internalClearRefs(PROP_ID_corpseconditioncode);
            
        }
    }
    
    /**
     * Crimecharactercode: CRIMECHARACTERCODE
     */
    public final java.lang.String getCrimecharactercode(){
         onPropGet(PROP_ID_crimecharactercode);
         return _crimecharactercode;
    }

    /**
     * Crimecharactercode: CRIMECHARACTERCODE
     */
    public final void setCrimecharactercode(java.lang.String value){
        if(onPropSet(PROP_ID_crimecharactercode,value)){
            this._crimecharactercode = value;
            internalClearRefs(PROP_ID_crimecharactercode);
            
        }
    }
    
    /**
     * Crimemethod: CRIMEMETHOD
     */
    public final java.lang.String getCrimemethod(){
         onPropGet(PROP_ID_crimemethod);
         return _crimemethod;
    }

    /**
     * Crimemethod: CRIMEMETHOD
     */
    public final void setCrimemethod(java.lang.String value){
        if(onPropSet(PROP_ID_crimemethod,value)){
            this._crimemethod = value;
            internalClearRefs(PROP_ID_crimemethod);
            
        }
    }
    
    /**
     * Criminalinvolvedcode: CRIMINALINVOLVEDCODE
     */
    public final java.lang.String getCriminalinvolvedcode(){
         onPropGet(PROP_ID_criminalinvolvedcode);
         return _criminalinvolvedcode;
    }

    /**
     * Criminalinvolvedcode: CRIMINALINVOLVEDCODE
     */
    public final void setCriminalinvolvedcode(java.lang.String value){
        if(onPropSet(PROP_ID_criminalinvolvedcode,value)){
            this._criminalinvolvedcode = value;
            internalClearRefs(PROP_ID_criminalinvolvedcode);
            
        }
    }
    
    /**
     * Datasource: DATASOURCE
     */
    public final java.lang.Integer getDatasource(){
         onPropGet(PROP_ID_datasource);
         return _datasource;
    }

    /**
     * Datasource: DATASOURCE
     */
    public final void setDatasource(java.lang.Integer value){
        if(onPropSet(PROP_ID_datasource,value)){
            this._datasource = value;
            internalClearRefs(PROP_ID_datasource);
            
        }
    }
    
    /**
     * Datatracetag: DATATRACETAG
     */
    public final java.lang.String getDatatracetag(){
         onPropGet(PROP_ID_datatracetag);
         return _datatracetag;
    }

    /**
     * Datatracetag: DATATRACETAG
     */
    public final void setDatatracetag(java.lang.String value){
        if(onPropSet(PROP_ID_datatracetag,value)){
            this._datatracetag = value;
            internalClearRefs(PROP_ID_datatracetag);
            
        }
    }
    
    /**
     * Detaineesidentity: DETAINEESIDENTITY
     */
    public final java.lang.String getDetaineesidentity(){
         onPropGet(PROP_ID_detaineesidentity);
         return _detaineesidentity;
    }

    /**
     * Detaineesidentity: DETAINEESIDENTITY
     */
    public final void setDetaineesidentity(java.lang.String value){
        if(onPropSet(PROP_ID_detaineesidentity,value)){
            this._detaineesidentity = value;
            internalClearRefs(PROP_ID_detaineesidentity);
            
        }
    }
    
    /**
     * Detaineesspecialidentity: DETAINEESSPECIALIDENTITY
     */
    public final java.lang.String getDetaineesspecialidentity(){
         onPropGet(PROP_ID_detaineesspecialidentity);
         return _detaineesspecialidentity;
    }

    /**
     * Detaineesspecialidentity: DETAINEESSPECIALIDENTITY
     */
    public final void setDetaineesspecialidentity(java.lang.String value){
        if(onPropSet(PROP_ID_detaineesspecialidentity,value)){
            this._detaineesspecialidentity = value;
            internalClearRefs(PROP_ID_detaineesspecialidentity);
            
        }
    }
    
    /**
     * Detectobject: DETECTOBJECT
     */
    public final java.lang.Integer getDetectobject(){
         onPropGet(PROP_ID_detectobject);
         return _detectobject;
    }

    /**
     * Detectobject: DETECTOBJECT
     */
    public final void setDetectobject(java.lang.Integer value){
        if(onPropSet(PROP_ID_detectobject,value)){
            this._detectobject = value;
            internalClearRefs(PROP_ID_detectobject);
            
        }
    }
    
    /**
     * Detectionscore: DETECTIONSCORE
     */
    public final java.lang.Integer getDetectionscore(){
         onPropGet(PROP_ID_detectionscore);
         return _detectionscore;
    }

    /**
     * Detectionscore: DETECTIONSCORE
     */
    public final void setDetectionscore(java.lang.Integer value){
        if(onPropSet(PROP_ID_detectionscore,value)){
            this._detectionscore = value;
            internalClearRefs(PROP_ID_detectionscore);
            
        }
    }
    
    /**
     * Detentionhousecode: DETENTIONHOUSECODE
     */
    public final java.lang.String getDetentionhousecode(){
         onPropGet(PROP_ID_detentionhousecode);
         return _detentionhousecode;
    }

    /**
     * Detentionhousecode: DETENTIONHOUSECODE
     */
    public final void setDetentionhousecode(java.lang.String value){
        if(onPropSet(PROP_ID_detentionhousecode,value)){
            this._detentionhousecode = value;
            internalClearRefs(PROP_ID_detentionhousecode);
            
        }
    }
    
    /**
     * Devicecode: DEVICECODE
     */
    public final java.lang.String getDevicecode(){
         onPropGet(PROP_ID_devicecode);
         return _devicecode;
    }

    /**
     * Devicecode: DEVICECODE
     */
    public final void setDevicecode(java.lang.String value){
        if(onPropSet(PROP_ID_devicecode,value)){
            this._devicecode = value;
            internalClearRefs(PROP_ID_devicecode);
            
        }
    }
    
    /**
     * Deviceid: DEVICEID
     */
    public final java.lang.String getDeviceid(){
         onPropGet(PROP_ID_deviceid);
         return _deviceid;
    }

    /**
     * Deviceid: DEVICEID
     */
    public final void setDeviceid(java.lang.String value){
        if(onPropSet(PROP_ID_deviceid,value)){
            this._deviceid = value;
            internalClearRefs(PROP_ID_deviceid);
            
        }
    }
    
    /**
     * Emclasstype: EMCLASSTYPE
     */
    public final java.lang.Integer getEmclasstype(){
         onPropGet(PROP_ID_emclasstype);
         return _emclasstype;
    }

    /**
     * Emclasstype: EMCLASSTYPE
     */
    public final void setEmclasstype(java.lang.Integer value){
        if(onPropSet(PROP_ID_emclasstype,value)){
            this._emclasstype = value;
            internalClearRefs(PROP_ID_emclasstype);
            
        }
    }
    
    /**
     * Escapedcriminalnumber: ESCAPEDCRIMINALNUMBER
     */
    public final java.lang.String getEscapedcriminalnumber(){
         onPropGet(PROP_ID_escapedcriminalnumber);
         return _escapedcriminalnumber;
    }

    /**
     * Escapedcriminalnumber: ESCAPEDCRIMINALNUMBER
     */
    public final void setEscapedcriminalnumber(java.lang.String value){
        if(onPropSet(PROP_ID_escapedcriminalnumber,value)){
            this._escapedcriminalnumber = value;
            internalClearRefs(PROP_ID_escapedcriminalnumber);
            
        }
    }
    
    /**
     * Event: EVENT
     */
    public final java.lang.String getEvent(){
         onPropGet(PROP_ID_event);
         return _event;
    }

    /**
     * Event: EVENT
     */
    public final void setEvent(java.lang.String value){
        if(onPropSet(PROP_ID_event,value)){
            this._event = value;
            internalClearRefs(PROP_ID_event);
            
        }
    }
    
    /**
     * Extrecordid: EXTRECORDID
     */
    public final java.lang.String getExtrecordid(){
         onPropGet(PROP_ID_extrecordid);
         return _extrecordid;
    }

    /**
     * Extrecordid: EXTRECORDID
     */
    public final void setExtrecordid(java.lang.String value){
        if(onPropSet(PROP_ID_extrecordid,value)){
            this._extrecordid = value;
            internalClearRefs(PROP_ID_extrecordid);
            
        }
    }
    
    /**
     * Extrecordsource: EXTRECORDSOURCE
     */
    public final java.lang.Integer getExtrecordsource(){
         onPropGet(PROP_ID_extrecordsource);
         return _extrecordsource;
    }

    /**
     * Extrecordsource: EXTRECORDSOURCE
     */
    public final void setExtrecordsource(java.lang.Integer value){
        if(onPropSet(PROP_ID_extrecordsource,value)){
            this._extrecordsource = value;
            internalClearRefs(PROP_ID_extrecordsource);
            
        }
    }
    
    /**
     * Extractedflag: EXTRACTEDFLAG
     */
    public final java.lang.Integer getExtractedflag(){
         onPropGet(PROP_ID_extractedflag);
         return _extractedflag;
    }

    /**
     * Extractedflag: EXTRACTEDFLAG
     */
    public final void setExtractedflag(java.lang.Integer value){
        if(onPropSet(PROP_ID_extractedflag,value)){
            this._extractedflag = value;
            internalClearRefs(PROP_ID_extractedflag);
            
        }
    }
    
    /**
     * Facedirect: FACEDIRECT
     */
    public final java.lang.Integer getFacedirect(){
         onPropGet(PROP_ID_facedirect);
         return _facedirect;
    }

    /**
     * Facedirect: FACEDIRECT
     */
    public final void setFacedirect(java.lang.Integer value){
        if(onPropSet(PROP_ID_facedirect,value)){
            this._facedirect = value;
            internalClearRefs(PROP_ID_facedirect);
            
        }
    }
    
    /**
     * Facedirectreliability: FACEDIRECTRELIABILITY
     */
    public final java.lang.Integer getFacedirectreliability(){
         onPropGet(PROP_ID_facedirectreliability);
         return _facedirectreliability;
    }

    /**
     * Facedirectreliability: FACEDIRECTRELIABILITY
     */
    public final void setFacedirectreliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_facedirectreliability,value)){
            this._facedirectreliability = value;
            internalClearRefs(PROP_ID_facedirectreliability);
            
        }
    }
    
    /**
     * Facestyle: FACESTYLE
     */
    public final java.lang.String getFacestyle(){
         onPropGet(PROP_ID_facestyle);
         return _facestyle;
    }

    /**
     * Facestyle: FACESTYLE
     */
    public final void setFacestyle(java.lang.String value){
        if(onPropSet(PROP_ID_facestyle,value)){
            this._facestyle = value;
            internalClearRefs(PROP_ID_facestyle);
            
        }
    }
    
    /**
     * Facialfeature: FACIALFEATURE
     */
    public final java.lang.String getFacialfeature(){
         onPropGet(PROP_ID_facialfeature);
         return _facialfeature;
    }

    /**
     * Facialfeature: FACIALFEATURE
     */
    public final void setFacialfeature(java.lang.String value){
        if(onPropSet(PROP_ID_facialfeature,value)){
            this._facialfeature = value;
            internalClearRefs(PROP_ID_facialfeature);
            
        }
    }
    
    /**
     * Featuredata: FEATUREDATA
     */
    public final java.lang.String getFeaturedata(){
         onPropGet(PROP_ID_featuredata);
         return _featuredata;
    }

    /**
     * Featuredata: FEATUREDATA
     */
    public final void setFeaturedata(java.lang.String value){
        if(onPropSet(PROP_ID_featuredata,value)){
            this._featuredata = value;
            internalClearRefs(PROP_ID_featuredata);
            
        }
    }
    
    /**
     * Featureid: FEATUREID
     */
    public final java.lang.String getFeatureid(){
         onPropGet(PROP_ID_featureid);
         return _featureid;
    }

    /**
     * Featureid: FEATUREID
     */
    public final void setFeatureid(java.lang.String value){
        if(onPropSet(PROP_ID_featureid,value)){
            this._featureid = value;
            internalClearRefs(PROP_ID_featureid);
            
        }
    }
    
    /**
     * Gender: GENDER
     */
    public final java.lang.Integer getGender(){
         onPropGet(PROP_ID_gender);
         return _gender;
    }

    /**
     * Gender: GENDER
     */
    public final void setGender(java.lang.Integer value){
        if(onPropSet(PROP_ID_gender,value)){
            this._gender = value;
            internalClearRefs(PROP_ID_gender);
            
        }
    }
    
    /**
     * Genderreliability: GENDERRELIABILITY
     */
    public final java.lang.Integer getGenderreliability(){
         onPropGet(PROP_ID_genderreliability);
         return _genderreliability;
    }

    /**
     * Genderreliability: GENDERRELIABILITY
     */
    public final void setGenderreliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_genderreliability,value)){
            this._genderreliability = value;
            internalClearRefs(PROP_ID_genderreliability);
            
        }
    }
    
    /**
     * Gesture: GESTURE
     */
    public final java.lang.String getGesture(){
         onPropGet(PROP_ID_gesture);
         return _gesture;
    }

    /**
     * Gesture: GESTURE
     */
    public final void setGesture(java.lang.String value){
        if(onPropSet(PROP_ID_gesture,value)){
            this._gesture = value;
            internalClearRefs(PROP_ID_gesture);
            
        }
    }
    
    /**
     * Glasscolor: GLASSCOLOR
     */
    public final java.lang.String getGlasscolor(){
         onPropGet(PROP_ID_glasscolor);
         return _glasscolor;
    }

    /**
     * Glasscolor: GLASSCOLOR
     */
    public final void setGlasscolor(java.lang.String value){
        if(onPropSet(PROP_ID_glasscolor,value)){
            this._glasscolor = value;
            internalClearRefs(PROP_ID_glasscolor);
            
        }
    }
    
    /**
     * Glassstyle: GLASSSTYLE
     */
    public final java.lang.String getGlassstyle(){
         onPropGet(PROP_ID_glassstyle);
         return _glassstyle;
    }

    /**
     * Glassstyle: GLASSSTYLE
     */
    public final void setGlassstyle(java.lang.String value){
        if(onPropSet(PROP_ID_glassstyle,value)){
            this._glassstyle = value;
            internalClearRefs(PROP_ID_glassstyle);
            
        }
    }
    
    /**
     * Habitualmovemen: HABITUALMOVEMEN
     */
    public final java.lang.String getHabitualmovemen(){
         onPropGet(PROP_ID_habitualmovemen);
         return _habitualmovemen;
    }

    /**
     * Habitualmovemen: HABITUALMOVEMEN
     */
    public final void setHabitualmovemen(java.lang.String value){
        if(onPropSet(PROP_ID_habitualmovemen,value)){
            this._habitualmovemen = value;
            internalClearRefs(PROP_ID_habitualmovemen);
            
        }
    }
    
    /**
     * Haircolor: HAIRCOLOR
     */
    public final java.lang.String getHaircolor(){
         onPropGet(PROP_ID_haircolor);
         return _haircolor;
    }

    /**
     * Haircolor: HAIRCOLOR
     */
    public final void setHaircolor(java.lang.String value){
        if(onPropSet(PROP_ID_haircolor,value)){
            this._haircolor = value;
            internalClearRefs(PROP_ID_haircolor);
            
        }
    }
    
    /**
     * Hairstyle: HAIRSTYLE
     */
    public final java.lang.String getHairstyle(){
         onPropGet(PROP_ID_hairstyle);
         return _hairstyle;
    }

    /**
     * Hairstyle: HAIRSTYLE
     */
    public final void setHairstyle(java.lang.String value){
        if(onPropSet(PROP_ID_hairstyle,value)){
            this._hairstyle = value;
            internalClearRefs(PROP_ID_hairstyle);
            
        }
    }
    
    /**
     * Hairstylereliability: HAIRSTYLERELIABILITY
     */
    public final java.lang.Integer getHairstylereliability(){
         onPropGet(PROP_ID_hairstylereliability);
         return _hairstylereliability;
    }

    /**
     * Hairstylereliability: HAIRSTYLERELIABILITY
     */
    public final void setHairstylereliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_hairstylereliability,value)){
            this._hairstylereliability = value;
            internalClearRefs(PROP_ID_hairstylereliability);
            
        }
    }
    
    /**
     * Hairtype: HAIRTYPE
     */
    public final java.lang.Integer getHairtype(){
         onPropGet(PROP_ID_hairtype);
         return _hairtype;
    }

    /**
     * Hairtype: HAIRTYPE
     */
    public final void setHairtype(java.lang.Integer value){
        if(onPropSet(PROP_ID_hairtype,value)){
            this._hairtype = value;
            internalClearRefs(PROP_ID_hairtype);
            
        }
    }
    
    /**
     * Hasbag: HASBAG
     */
    public final java.lang.Integer getHasbag(){
         onPropGet(PROP_ID_hasbag);
         return _hasbag;
    }

    /**
     * Hasbag: HASBAG
     */
    public final void setHasbag(java.lang.Integer value){
        if(onPropSet(PROP_ID_hasbag,value)){
            this._hasbag = value;
            internalClearRefs(PROP_ID_hasbag);
            
        }
    }
    
    /**
     * Hasbagreliability: HASBAGRELIABILITY
     */
    public final java.lang.Integer getHasbagreliability(){
         onPropGet(PROP_ID_hasbagreliability);
         return _hasbagreliability;
    }

    /**
     * Hasbagreliability: HASBAGRELIABILITY
     */
    public final void setHasbagreliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_hasbagreliability,value)){
            this._hasbagreliability = value;
            internalClearRefs(PROP_ID_hasbagreliability);
            
        }
    }
    
    /**
     * Hasbasket: HASBASKET
     */
    public final java.lang.Integer getHasbasket(){
         onPropGet(PROP_ID_hasbasket);
         return _hasbasket;
    }

    /**
     * Hasbasket: HASBASKET
     */
    public final void setHasbasket(java.lang.Integer value){
        if(onPropSet(PROP_ID_hasbasket,value)){
            this._hasbasket = value;
            internalClearRefs(PROP_ID_hasbasket);
            
        }
    }
    
    /**
     * Hascarrierbag: HASCARRIERBAG
     */
    public final java.lang.Integer getHascarrierbag(){
         onPropGet(PROP_ID_hascarrierbag);
         return _hascarrierbag;
    }

    /**
     * Hascarrierbag: HASCARRIERBAG
     */
    public final void setHascarrierbag(java.lang.Integer value){
        if(onPropSet(PROP_ID_hascarrierbag,value)){
            this._hascarrierbag = value;
            internalClearRefs(PROP_ID_hascarrierbag);
            
        }
    }
    
    /**
     * Hascarrystuff: HASCARRYSTUFF
     */
    public final java.lang.Integer getHascarrystuff(){
         onPropGet(PROP_ID_hascarrystuff);
         return _hascarrystuff;
    }

    /**
     * Hascarrystuff: HASCARRYSTUFF
     */
    public final void setHascarrystuff(java.lang.Integer value){
        if(onPropSet(PROP_ID_hascarrystuff,value)){
            this._hascarrystuff = value;
            internalClearRefs(PROP_ID_hascarrystuff);
            
        }
    }
    
    /**
     * Hascart: HASCART
     */
    public final java.lang.Integer getHascart(){
         onPropGet(PROP_ID_hascart);
         return _hascart;
    }

    /**
     * Hascart: HASCART
     */
    public final void setHascart(java.lang.Integer value){
        if(onPropSet(PROP_ID_hascart,value)){
            this._hascart = value;
            internalClearRefs(PROP_ID_hascart);
            
        }
    }
    
    /**
     * Hasdownbody: HASDOWNBODY
     */
    public final java.lang.Integer getHasdownbody(){
         onPropGet(PROP_ID_hasdownbody);
         return _hasdownbody;
    }

    /**
     * Hasdownbody: HASDOWNBODY
     */
    public final void setHasdownbody(java.lang.Integer value){
        if(onPropSet(PROP_ID_hasdownbody,value)){
            this._hasdownbody = value;
            internalClearRefs(PROP_ID_hasdownbody);
            
        }
    }
    
    /**
     * Hasdownbodyreliability: HASDOWNBODYRELIABILITY
     */
    public final java.lang.Integer getHasdownbodyreliability(){
         onPropGet(PROP_ID_hasdownbodyreliability);
         return _hasdownbodyreliability;
    }

    /**
     * Hasdownbodyreliability: HASDOWNBODYRELIABILITY
     */
    public final void setHasdownbodyreliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_hasdownbodyreliability,value)){
            this._hasdownbodyreliability = value;
            internalClearRefs(PROP_ID_hasdownbodyreliability);
            
        }
    }
    
    /**
     * Haserrordetect: HASERRORDETECT
     */
    public final java.lang.Integer getHaserrordetect(){
         onPropGet(PROP_ID_haserrordetect);
         return _haserrordetect;
    }

    /**
     * Haserrordetect: HASERRORDETECT
     */
    public final void setHaserrordetect(java.lang.Integer value){
        if(onPropSet(PROP_ID_haserrordetect,value)){
            this._haserrordetect = value;
            internalClearRefs(PROP_ID_haserrordetect);
            
        }
    }
    
    /**
     * Hashead: HASHEAD
     */
    public final java.lang.Integer getHashead(){
         onPropGet(PROP_ID_hashead);
         return _hashead;
    }

    /**
     * Hashead: HASHEAD
     */
    public final void setHashead(java.lang.Integer value){
        if(onPropSet(PROP_ID_hashead,value)){
            this._hashead = value;
            internalClearRefs(PROP_ID_hashead);
            
        }
    }
    
    /**
     * Hasheadreliability: HASHEADRELIABILITY
     */
    public final java.lang.Integer getHasheadreliability(){
         onPropGet(PROP_ID_hasheadreliability);
         return _hasheadreliability;
    }

    /**
     * Hasheadreliability: HASHEADRELIABILITY
     */
    public final void setHasheadreliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_hasheadreliability,value)){
            this._hasheadreliability = value;
            internalClearRefs(PROP_ID_hasheadreliability);
            
        }
    }
    
    /**
     * Hasmirror: HASMIRROR
     */
    public final java.lang.Integer getHasmirror(){
         onPropGet(PROP_ID_hasmirror);
         return _hasmirror;
    }

    /**
     * Hasmirror: HASMIRROR
     */
    public final void setHasmirror(java.lang.Integer value){
        if(onPropSet(PROP_ID_hasmirror,value)){
            this._hasmirror = value;
            internalClearRefs(PROP_ID_hasmirror);
            
        }
    }
    
    /**
     * Hasraincoat: HASRAINCOAT
     */
    public final java.lang.Integer getHasraincoat(){
         onPropGet(PROP_ID_hasraincoat);
         return _hasraincoat;
    }

    /**
     * Hasraincoat: HASRAINCOAT
     */
    public final void setHasraincoat(java.lang.Integer value){
        if(onPropSet(PROP_ID_hasraincoat,value)){
            this._hasraincoat = value;
            internalClearRefs(PROP_ID_hasraincoat);
            
        }
    }
    
    /**
     * Hasrespirator: HASRESPIRATOR
     */
    public final java.lang.Integer getHasrespirator(){
         onPropGet(PROP_ID_hasrespirator);
         return _hasrespirator;
    }

    /**
     * Hasrespirator: HASRESPIRATOR
     */
    public final void setHasrespirator(java.lang.Integer value){
        if(onPropSet(PROP_ID_hasrespirator,value)){
            this._hasrespirator = value;
            internalClearRefs(PROP_ID_hasrespirator);
            
        }
    }
    
    /**
     * Hastrunk: HASTRUNK
     */
    public final java.lang.Integer getHastrunk(){
         onPropGet(PROP_ID_hastrunk);
         return _hastrunk;
    }

    /**
     * Hastrunk: HASTRUNK
     */
    public final void setHastrunk(java.lang.Integer value){
        if(onPropSet(PROP_ID_hastrunk,value)){
            this._hastrunk = value;
            internalClearRefs(PROP_ID_hastrunk);
            
        }
    }
    
    /**
     * Hasvehicle: HASVEHICLE
     */
    public final java.lang.Integer getHasvehicle(){
         onPropGet(PROP_ID_hasvehicle);
         return _hasvehicle;
    }

    /**
     * Hasvehicle: HASVEHICLE
     */
    public final void setHasvehicle(java.lang.Integer value){
        if(onPropSet(PROP_ID_hasvehicle,value)){
            this._hasvehicle = value;
            internalClearRefs(PROP_ID_hasvehicle);
            
        }
    }
    
    /**
     * Hasvest: HASVEST
     */
    public final java.lang.Integer getHasvest(){
         onPropGet(PROP_ID_hasvest);
         return _hasvest;
    }

    /**
     * Hasvest: HASVEST
     */
    public final void setHasvest(java.lang.Integer value){
        if(onPropSet(PROP_ID_hasvest,value)){
            this._hasvest = value;
            internalClearRefs(PROP_ID_hasvest);
            
        }
    }
    
    /**
     * Hasvestreliability: HASVESTRELIABILITY
     */
    public final java.lang.Integer getHasvestreliability(){
         onPropGet(PROP_ID_hasvestreliability);
         return _hasvestreliability;
    }

    /**
     * Hasvestreliability: HASVESTRELIABILITY
     */
    public final void setHasvestreliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_hasvestreliability,value)){
            this._hasvestreliability = value;
            internalClearRefs(PROP_ID_hasvestreliability);
            
        }
    }
    
    /**
     * Hat: HAT
     */
    public final java.lang.Integer getHat(){
         onPropGet(PROP_ID_hat);
         return _hat;
    }

    /**
     * Hat: HAT
     */
    public final void setHat(java.lang.Integer value){
        if(onPropSet(PROP_ID_hat,value)){
            this._hat = value;
            internalClearRefs(PROP_ID_hat);
            
        }
    }
    
    /**
     * Hatreliability: HATRELIABILITY
     */
    public final java.lang.Integer getHatreliability(){
         onPropGet(PROP_ID_hatreliability);
         return _hatreliability;
    }

    /**
     * Hatreliability: HATRELIABILITY
     */
    public final void setHatreliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_hatreliability,value)){
            this._hatreliability = value;
            internalClearRefs(PROP_ID_hatreliability);
            
        }
    }
    
    /**
     * Heightlowerlimit: HEIGHTLOWERLIMIT
     */
    public final java.lang.Integer getHeightlowerlimit(){
         onPropGet(PROP_ID_heightlowerlimit);
         return _heightlowerlimit;
    }

    /**
     * Heightlowerlimit: HEIGHTLOWERLIMIT
     */
    public final void setHeightlowerlimit(java.lang.Integer value){
        if(onPropSet(PROP_ID_heightlowerlimit,value)){
            this._heightlowerlimit = value;
            internalClearRefs(PROP_ID_heightlowerlimit);
            
        }
    }
    
    /**
     * Heightuplimit: HEIGHTUPLIMIT
     */
    public final java.lang.Integer getHeightuplimit(){
         onPropGet(PROP_ID_heightuplimit);
         return _heightuplimit;
    }

    /**
     * Heightuplimit: HEIGHTUPLIMIT
     */
    public final void setHeightuplimit(java.lang.Integer value){
        if(onPropSet(PROP_ID_heightuplimit,value)){
            this._heightuplimit = value;
            internalClearRefs(PROP_ID_heightuplimit);
            
        }
    }
    
    /**
     * Humanlist: HUMANLIST
     */
    public final java.lang.String getHumanlist(){
         onPropGet(PROP_ID_humanlist);
         return _humanlist;
    }

    /**
     * Humanlist: HUMANLIST
     */
    public final void setHumanlist(java.lang.String value){
        if(onPropSet(PROP_ID_humanlist,value)){
            this._humanlist = value;
            internalClearRefs(PROP_ID_humanlist);
            
        }
    }
    
    /**
     * Idnumber: IDNUMBER
     */
    public final java.lang.String getIdnumber(){
         onPropGet(PROP_ID_idnumber);
         return _idnumber;
    }

    /**
     * Idnumber: IDNUMBER
     */
    public final void setIdnumber(java.lang.String value){
        if(onPropSet(PROP_ID_idnumber,value)){
            this._idnumber = value;
            internalClearRefs(PROP_ID_idnumber);
            
        }
    }
    
    /**
     * Idtype: IDTYPE
     */
    public final java.lang.String getIdtype(){
         onPropGet(PROP_ID_idtype);
         return _idtype;
    }

    /**
     * Idtype: IDTYPE
     */
    public final void setIdtype(java.lang.String value){
        if(onPropSet(PROP_ID_idtype,value)){
            this._idtype = value;
            internalClearRefs(PROP_ID_idtype);
            
        }
    }
    
    /**
     * Imgheight: IMGHEIGHT
     */
    public final java.lang.Integer getImgheight(){
         onPropGet(PROP_ID_imgheight);
         return _imgheight;
    }

    /**
     * Imgheight: IMGHEIGHT
     */
    public final void setImgheight(java.lang.Integer value){
        if(onPropSet(PROP_ID_imgheight,value)){
            this._imgheight = value;
            internalClearRefs(PROP_ID_imgheight);
            
        }
    }
    
    /**
     * Imgurl: IMGURL
     */
    public final java.lang.String getImgurl(){
         onPropGet(PROP_ID_imgurl);
         return _imgurl;
    }

    /**
     * Imgurl: IMGURL
     */
    public final void setImgurl(java.lang.String value){
        if(onPropSet(PROP_ID_imgurl,value)){
            this._imgurl = value;
            internalClearRefs(PROP_ID_imgurl);
            
        }
    }
    
    /**
     * Imgwidth: IMGWIDTH
     */
    public final java.lang.Integer getImgwidth(){
         onPropGet(PROP_ID_imgwidth);
         return _imgwidth;
    }

    /**
     * Imgwidth: IMGWIDTH
     */
    public final void setImgwidth(java.lang.Integer value){
        if(onPropSet(PROP_ID_imgwidth,value)){
            this._imgwidth = value;
            internalClearRefs(PROP_ID_imgwidth);
            
        }
    }
    
    /**
     * Immigranttypecode: IMMIGRANTTYPECODE
     */
    public final java.lang.String getImmigranttypecode(){
         onPropGet(PROP_ID_immigranttypecode);
         return _immigranttypecode;
    }

    /**
     * Immigranttypecode: IMMIGRANTTYPECODE
     */
    public final void setImmigranttypecode(java.lang.String value){
        if(onPropSet(PROP_ID_immigranttypecode,value)){
            this._immigranttypecode = value;
            internalClearRefs(PROP_ID_immigranttypecode);
            
        }
    }
    
    /**
     * Infokind: INFOKIND
     */
    public final java.lang.Integer getInfokind(){
         onPropGet(PROP_ID_infokind);
         return _infokind;
    }

    /**
     * Infokind: INFOKIND
     */
    public final void setInfokind(java.lang.Integer value){
        if(onPropSet(PROP_ID_infokind,value)){
            this._infokind = value;
            internalClearRefs(PROP_ID_infokind);
            
        }
    }
    
    /**
     * Injureddegree: INJUREDDEGREE
     */
    public final java.lang.String getInjureddegree(){
         onPropGet(PROP_ID_injureddegree);
         return _injureddegree;
    }

    /**
     * Injureddegree: INJUREDDEGREE
     */
    public final void setInjureddegree(java.lang.String value){
        if(onPropSet(PROP_ID_injureddegree,value)){
            this._injureddegree = value;
            internalClearRefs(PROP_ID_injureddegree);
            
        }
    }
    
    /**
     * Iqascore: IQASCORE
     */
    public final java.lang.Integer getIqascore(){
         onPropGet(PROP_ID_iqascore);
         return _iqascore;
    }

    /**
     * Iqascore: IQASCORE
     */
    public final void setIqascore(java.lang.Integer value){
        if(onPropSet(PROP_ID_iqascore,value)){
            this._iqascore = value;
            internalClearRefs(PROP_ID_iqascore);
            
        }
    }
    
    /**
     * Iscriminalinvolved: ISCRIMINALINVOLVED
     */
    public final java.lang.Integer getIscriminalinvolved(){
         onPropGet(PROP_ID_iscriminalinvolved);
         return _iscriminalinvolved;
    }

    /**
     * Iscriminalinvolved: ISCRIMINALINVOLVED
     */
    public final void setIscriminalinvolved(java.lang.Integer value){
        if(onPropSet(PROP_ID_iscriminalinvolved,value)){
            this._iscriminalinvolved = value;
            internalClearRefs(PROP_ID_iscriminalinvolved);
            
        }
    }
    
    /**
     * Isdetainees: ISDETAINEES
     */
    public final java.lang.Integer getIsdetainees(){
         onPropGet(PROP_ID_isdetainees);
         return _isdetainees;
    }

    /**
     * Isdetainees: ISDETAINEES
     */
    public final void setIsdetainees(java.lang.Integer value){
        if(onPropSet(PROP_ID_isdetainees,value)){
            this._isdetainees = value;
            internalClearRefs(PROP_ID_isdetainees);
            
        }
    }
    
    /**
     * Isdriver: ISDRIVER
     */
    public final java.lang.Integer getIsdriver(){
         onPropGet(PROP_ID_isdriver);
         return _isdriver;
    }

    /**
     * Isdriver: ISDRIVER
     */
    public final void setIsdriver(java.lang.Integer value){
        if(onPropSet(PROP_ID_isdriver,value)){
            this._isdriver = value;
            internalClearRefs(PROP_ID_isdriver);
            
        }
    }
    
    /**
     * Isforeigner: ISFOREIGNER
     */
    public final java.lang.Integer getIsforeigner(){
         onPropGet(PROP_ID_isforeigner);
         return _isforeigner;
    }

    /**
     * Isforeigner: ISFOREIGNER
     */
    public final void setIsforeigner(java.lang.Integer value){
        if(onPropSet(PROP_ID_isforeigner,value)){
            this._isforeigner = value;
            internalClearRefs(PROP_ID_isforeigner);
            
        }
    }
    
    /**
     * Isnoncomplete: ISNONCOMPLETE
     */
    public final java.lang.Integer getIsnoncomplete(){
         onPropGet(PROP_ID_isnoncomplete);
         return _isnoncomplete;
    }

    /**
     * Isnoncomplete: ISNONCOMPLETE
     */
    public final void setIsnoncomplete(java.lang.Integer value){
        if(onPropSet(PROP_ID_isnoncomplete,value)){
            this._isnoncomplete = value;
            internalClearRefs(PROP_ID_isnoncomplete);
            
        }
    }
    
    /**
     * Issuspectedterrorist: ISSUSPECTEDTERRORIST
     */
    public final java.lang.Integer getIssuspectedterrorist(){
         onPropGet(PROP_ID_issuspectedterrorist);
         return _issuspectedterrorist;
    }

    /**
     * Issuspectedterrorist: ISSUSPECTEDTERRORIST
     */
    public final void setIssuspectedterrorist(java.lang.Integer value){
        if(onPropSet(PROP_ID_issuspectedterrorist,value)){
            this._issuspectedterrorist = value;
            internalClearRefs(PROP_ID_issuspectedterrorist);
            
        }
    }
    
    /**
     * Issuspiciousperson: ISSUSPICIOUSPERSON
     */
    public final java.lang.Integer getIssuspiciousperson(){
         onPropGet(PROP_ID_issuspiciousperson);
         return _issuspiciousperson;
    }

    /**
     * Issuspiciousperson: ISSUSPICIOUSPERSON
     */
    public final void setIssuspiciousperson(java.lang.Integer value){
        if(onPropSet(PROP_ID_issuspiciousperson,value)){
            this._issuspiciousperson = value;
            internalClearRefs(PROP_ID_issuspiciousperson);
            
        }
    }
    
    /**
     * Isvictim: ISVICTIM
     */
    public final java.lang.Integer getIsvictim(){
         onPropGet(PROP_ID_isvictim);
         return _isvictim;
    }

    /**
     * Isvictim: ISVICTIM
     */
    public final void setIsvictim(java.lang.Integer value){
        if(onPropSet(PROP_ID_isvictim,value)){
            this._isvictim = value;
            internalClearRefs(PROP_ID_isvictim);
            
        }
    }
    
    /**
     * Jobcategory: JOBCATEGORY
     */
    public final java.lang.String getJobcategory(){
         onPropGet(PROP_ID_jobcategory);
         return _jobcategory;
    }

    /**
     * Jobcategory: JOBCATEGORY
     */
    public final void setJobcategory(java.lang.String value){
        if(onPropSet(PROP_ID_jobcategory,value)){
            this._jobcategory = value;
            internalClearRefs(PROP_ID_jobcategory);
            
        }
    }
    
    /**
     * Locationmarktime: LOCATIONMARKTIME
     */
    public final java.lang.Long getLocationmarktime(){
         onPropGet(PROP_ID_locationmarktime);
         return _locationmarktime;
    }

    /**
     * Locationmarktime: LOCATIONMARKTIME
     */
    public final void setLocationmarktime(java.lang.Long value){
        if(onPropSet(PROP_ID_locationmarktime,value)){
            this._locationmarktime = value;
            internalClearRefs(PROP_ID_locationmarktime);
            
        }
    }
    
    /**
     * Mask: MASK
     */
    public final java.lang.Integer getMask(){
         onPropGet(PROP_ID_mask);
         return _mask;
    }

    /**
     * Mask: MASK
     */
    public final void setMask(java.lang.Integer value){
        if(onPropSet(PROP_ID_mask,value)){
            this._mask = value;
            internalClearRefs(PROP_ID_mask);
            
        }
    }
    
    /**
     * Maskcolor: MASKCOLOR
     */
    public final java.lang.Integer getMaskcolor(){
         onPropGet(PROP_ID_maskcolor);
         return _maskcolor;
    }

    /**
     * Maskcolor: MASKCOLOR
     */
    public final void setMaskcolor(java.lang.Integer value){
        if(onPropSet(PROP_ID_maskcolor,value)){
            this._maskcolor = value;
            internalClearRefs(PROP_ID_maskcolor);
            
        }
    }
    
    /**
     * Membertypecode: MEMBERTYPECODE
     */
    public final java.lang.String getMembertypecode(){
         onPropGet(PROP_ID_membertypecode);
         return _membertypecode;
    }

    /**
     * Membertypecode: MEMBERTYPECODE
     */
    public final void setMembertypecode(java.lang.String value){
        if(onPropSet(PROP_ID_membertypecode,value)){
            this._membertypecode = value;
            internalClearRefs(PROP_ID_membertypecode);
            
        }
    }
    
    /**
     * Name: NAME
     */
    public final java.lang.String getName(){
         onPropGet(PROP_ID_name);
         return _name;
    }

    /**
     * Name: NAME
     */
    public final void setName(java.lang.String value){
        if(onPropSet(PROP_ID_name,value)){
            this._name = value;
            internalClearRefs(PROP_ID_name);
            
        }
    }
    
    /**
     * Nationalitycode: NATIONALITYCODE
     */
    public final java.lang.String getNationalitycode(){
         onPropGet(PROP_ID_nationalitycode);
         return _nationalitycode;
    }

    /**
     * Nationalitycode: NATIONALITYCODE
     */
    public final void setNationalitycode(java.lang.String value){
        if(onPropSet(PROP_ID_nationalitycode,value)){
            this._nationalitycode = value;
            internalClearRefs(PROP_ID_nationalitycode);
            
        }
    }
    
    /**
     * Nativecitycode: NATIVECITYCODE
     */
    public final java.lang.String getNativecitycode(){
         onPropGet(PROP_ID_nativecitycode);
         return _nativecitycode;
    }

    /**
     * Nativecitycode: NATIVECITYCODE
     */
    public final void setNativecitycode(java.lang.String value){
        if(onPropSet(PROP_ID_nativecitycode,value)){
            this._nativecitycode = value;
            internalClearRefs(PROP_ID_nativecitycode);
            
        }
    }
    
    /**
     * Nonvehicleumbrellacolor: NONVEHICLEUMBRELLACOLOR
     */
    public final java.lang.String getNonvehicleumbrellacolor(){
         onPropGet(PROP_ID_nonvehicleumbrellacolor);
         return _nonvehicleumbrellacolor;
    }

    /**
     * Nonvehicleumbrellacolor: NONVEHICLEUMBRELLACOLOR
     */
    public final void setNonvehicleumbrellacolor(java.lang.String value){
        if(onPropSet(PROP_ID_nonvehicleumbrellacolor,value)){
            this._nonvehicleumbrellacolor = value;
            internalClearRefs(PROP_ID_nonvehicleumbrellacolor);
            
        }
    }
    
    /**
     * Nonvehicleumbrellatype: NONVEHICLEUMBRELLATYPE
     */
    public final java.lang.Integer getNonvehicleumbrellatype(){
         onPropGet(PROP_ID_nonvehicleumbrellatype);
         return _nonvehicleumbrellatype;
    }

    /**
     * Nonvehicleumbrellatype: NONVEHICLEUMBRELLATYPE
     */
    public final void setNonvehicleumbrellatype(java.lang.Integer value){
        if(onPropSet(PROP_ID_nonvehicleumbrellatype,value)){
            this._nonvehicleumbrellatype = value;
            internalClearRefs(PROP_ID_nonvehicleumbrellatype);
            
        }
    }
    
    /**
     * Nonvehicleumbrellatypereliability: NONVEHICLEUMBRELLATYPERELIABILITY
     */
    public final java.lang.Integer getNonvehicleumbrellatypereliability(){
         onPropGet(PROP_ID_nonvehicleumbrellatypereliability);
         return _nonvehicleumbrellatypereliability;
    }

    /**
     * Nonvehicleumbrellatypereliability: NONVEHICLEUMBRELLATYPERELIABILITY
     */
    public final void setNonvehicleumbrellatypereliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_nonvehicleumbrellatypereliability,value)){
            this._nonvehicleumbrellatypereliability = value;
            internalClearRefs(PROP_ID_nonvehicleumbrellatypereliability);
            
        }
    }
    
    /**
     * Objsize: OBJSIZE
     */
    public final java.lang.Integer getObjsize(){
         onPropGet(PROP_ID_objsize);
         return _objsize;
    }

    /**
     * Objsize: OBJSIZE
     */
    public final void setObjsize(java.lang.Integer value){
        if(onPropSet(PROP_ID_objsize,value)){
            this._objsize = value;
            internalClearRefs(PROP_ID_objsize);
            
        }
    }
    
    /**
     * Objectsubtype: OBJECTSUBTYPE
     */
    public final java.lang.Integer getObjectsubtype(){
         onPropGet(PROP_ID_objectsubtype);
         return _objectsubtype;
    }

    /**
     * Objectsubtype: OBJECTSUBTYPE
     */
    public final void setObjectsubtype(java.lang.Integer value){
        if(onPropSet(PROP_ID_objectsubtype,value)){
            this._objectsubtype = value;
            internalClearRefs(PROP_ID_objectsubtype);
            
        }
    }
    
    /**
     * Passenger: PASSENGER
     */
    public final java.lang.Integer getPassenger(){
         onPropGet(PROP_ID_passenger);
         return _passenger;
    }

    /**
     * Passenger: PASSENGER
     */
    public final void setPassenger(java.lang.Integer value){
        if(onPropSet(PROP_ID_passenger,value)){
            this._passenger = value;
            internalClearRefs(PROP_ID_passenger);
            
        }
    }
    
    /**
     * Passporttype: PASSPORTTYPE
     */
    public final java.lang.String getPassporttype(){
         onPropGet(PROP_ID_passporttype);
         return _passporttype;
    }

    /**
     * Passporttype: PASSPORTTYPE
     */
    public final void setPassporttype(java.lang.String value){
        if(onPropSet(PROP_ID_passporttype,value)){
            this._passporttype = value;
            internalClearRefs(PROP_ID_passporttype);
            
        }
    }
    
    /**
     * Personappeartime: PERSONAPPEARTIME
     */
    public final java.lang.Long getPersonappeartime(){
         onPropGet(PROP_ID_personappeartime);
         return _personappeartime;
    }

    /**
     * Personappeartime: PERSONAPPEARTIME
     */
    public final void setPersonappeartime(java.lang.Long value){
        if(onPropSet(PROP_ID_personappeartime,value)){
            this._personappeartime = value;
            internalClearRefs(PROP_ID_personappeartime);
            
        }
    }
    
    /**
     * Personbottom: PERSONBOTTOM
     */
    public final java.lang.Integer getPersonbottom(){
         onPropGet(PROP_ID_personbottom);
         return _personbottom;
    }

    /**
     * Personbottom: PERSONBOTTOM
     */
    public final void setPersonbottom(java.lang.Integer value){
        if(onPropSet(PROP_ID_personbottom,value)){
            this._personbottom = value;
            internalClearRefs(PROP_ID_personbottom);
            
        }
    }
    
    /**
     * Persondisappeartime: PERSONDISAPPEARTIME
     */
    public final java.lang.Long getPersondisappeartime(){
         onPropGet(PROP_ID_persondisappeartime);
         return _persondisappeartime;
    }

    /**
     * Persondisappeartime: PERSONDISAPPEARTIME
     */
    public final void setPersondisappeartime(java.lang.Long value){
        if(onPropSet(PROP_ID_persondisappeartime,value)){
            this._persondisappeartime = value;
            internalClearRefs(PROP_ID_persondisappeartime);
            
        }
    }
    
    /**
     * Personimgid: PERSONIMGID
     */
    public final java.lang.String getPersonimgid(){
         onPropGet(PROP_ID_personimgid);
         return _personimgid;
    }

    /**
     * Personimgid: PERSONIMGID
     */
    public final void setPersonimgid(java.lang.String value){
        if(onPropSet(PROP_ID_personimgid,value)){
            this._personimgid = value;
            internalClearRefs(PROP_ID_personimgid);
            
        }
    }
    
    /**
     * Personleft: PERSONLEFT
     */
    public final java.lang.Integer getPersonleft(){
         onPropGet(PROP_ID_personleft);
         return _personleft;
    }

    /**
     * Personleft: PERSONLEFT
     */
    public final void setPersonleft(java.lang.Integer value){
        if(onPropSet(PROP_ID_personleft,value)){
            this._personleft = value;
            internalClearRefs(PROP_ID_personleft);
            
        }
    }
    
    /**
     * Personorg: PERSONORG
     */
    public final java.lang.String getPersonorg(){
         onPropGet(PROP_ID_personorg);
         return _personorg;
    }

    /**
     * Personorg: PERSONORG
     */
    public final void setPersonorg(java.lang.String value){
        if(onPropSet(PROP_ID_personorg,value)){
            this._personorg = value;
            internalClearRefs(PROP_ID_personorg);
            
        }
    }
    
    /**
     * Personright: PERSONRIGHT
     */
    public final java.lang.Integer getPersonright(){
         onPropGet(PROP_ID_personright);
         return _personright;
    }

    /**
     * Personright: PERSONRIGHT
     */
    public final void setPersonright(java.lang.Integer value){
        if(onPropSet(PROP_ID_personright,value)){
            this._personright = value;
            internalClearRefs(PROP_ID_personright);
            
        }
    }
    
    /**
     * Persontop: PERSONTOP
     */
    public final java.lang.Integer getPersontop(){
         onPropGet(PROP_ID_persontop);
         return _persontop;
    }

    /**
     * Persontop: PERSONTOP
     */
    public final void setPersontop(java.lang.Integer value){
        if(onPropSet(PROP_ID_persontop,value)){
            this._persontop = value;
            internalClearRefs(PROP_ID_persontop);
            
        }
    }
    
    /**
     * Physicalfeature: PHYSICALFEATURE
     */
    public final java.lang.String getPhysicalfeature(){
         onPropGet(PROP_ID_physicalfeature);
         return _physicalfeature;
    }

    /**
     * Physicalfeature: PHYSICALFEATURE
     */
    public final void setPhysicalfeature(java.lang.String value){
        if(onPropSet(PROP_ID_physicalfeature,value)){
            this._physicalfeature = value;
            internalClearRefs(PROP_ID_physicalfeature);
            
        }
    }
    
    /**
     * Picrecordid: PICRECORDID
     */
    public final java.lang.String getPicrecordid(){
         onPropGet(PROP_ID_picrecordid);
         return _picrecordid;
    }

    /**
     * Picrecordid: PICRECORDID
     */
    public final void setPicrecordid(java.lang.String value){
        if(onPropSet(PROP_ID_picrecordid,value)){
            this._picrecordid = value;
            internalClearRefs(PROP_ID_picrecordid);
            
        }
    }
    
    /**
     * Platebottom: PLATEBOTTOM
     */
    public final java.lang.Integer getPlatebottom(){
         onPropGet(PROP_ID_platebottom);
         return _platebottom;
    }

    /**
     * Platebottom: PLATEBOTTOM
     */
    public final void setPlatebottom(java.lang.Integer value){
        if(onPropSet(PROP_ID_platebottom,value)){
            this._platebottom = value;
            internalClearRefs(PROP_ID_platebottom);
            
        }
    }
    
    /**
     * Platecolor: PLATECOLOR
     */
    public final java.lang.String getPlatecolor(){
         onPropGet(PROP_ID_platecolor);
         return _platecolor;
    }

    /**
     * Platecolor: PLATECOLOR
     */
    public final void setPlatecolor(java.lang.String value){
        if(onPropSet(PROP_ID_platecolor,value)){
            this._platecolor = value;
            internalClearRefs(PROP_ID_platecolor);
            
        }
    }
    
    /**
     * Plateimgurl: PLATEIMGURL
     */
    public final java.lang.String getPlateimgurl(){
         onPropGet(PROP_ID_plateimgurl);
         return _plateimgurl;
    }

    /**
     * Plateimgurl: PLATEIMGURL
     */
    public final void setPlateimgurl(java.lang.String value){
        if(onPropSet(PROP_ID_plateimgurl,value)){
            this._plateimgurl = value;
            internalClearRefs(PROP_ID_plateimgurl);
            
        }
    }
    
    /**
     * Plateleft: PLATELEFT
     */
    public final java.lang.Integer getPlateleft(){
         onPropGet(PROP_ID_plateleft);
         return _plateleft;
    }

    /**
     * Plateleft: PLATELEFT
     */
    public final void setPlateleft(java.lang.Integer value){
        if(onPropSet(PROP_ID_plateleft,value)){
            this._plateleft = value;
            internalClearRefs(PROP_ID_plateleft);
            
        }
    }
    
    /**
     * Platenum: PLATENUM
     */
    public final java.lang.String getPlatenum(){
         onPropGet(PROP_ID_platenum);
         return _platenum;
    }

    /**
     * Platenum: PLATENUM
     */
    public final void setPlatenum(java.lang.String value){
        if(onPropSet(PROP_ID_platenum,value)){
            this._platenum = value;
            internalClearRefs(PROP_ID_platenum);
            
        }
    }
    
    /**
     * Plateright: PLATERIGHT
     */
    public final java.lang.Integer getPlateright(){
         onPropGet(PROP_ID_plateright);
         return _plateright;
    }

    /**
     * Plateright: PLATERIGHT
     */
    public final void setPlateright(java.lang.Integer value){
        if(onPropSet(PROP_ID_plateright,value)){
            this._plateright = value;
            internalClearRefs(PROP_ID_plateright);
            
        }
    }
    
    /**
     * Platetop: PLATETOP
     */
    public final java.lang.Integer getPlatetop(){
         onPropGet(PROP_ID_platetop);
         return _platetop;
    }

    /**
     * Platetop: PLATETOP
     */
    public final void setPlatetop(java.lang.Integer value){
        if(onPropSet(PROP_ID_platetop,value)){
            this._platetop = value;
            internalClearRefs(PROP_ID_platetop);
            
        }
    }
    
    /**
     * Posture: POSTURE
     */
    public final java.lang.Integer getPosture(){
         onPropGet(PROP_ID_posture);
         return _posture;
    }

    /**
     * Posture: POSTURE
     */
    public final void setPosture(java.lang.Integer value){
        if(onPropSet(PROP_ID_posture,value)){
            this._posture = value;
            internalClearRefs(PROP_ID_posture);
            
        }
    }
    
    /**
     * Posturereliability: POSTURERELIABILITY
     */
    public final java.lang.Integer getPosturereliability(){
         onPropGet(PROP_ID_posturereliability);
         return _posturereliability;
    }

    /**
     * Posturereliability: POSTURERELIABILITY
     */
    public final void setPosturereliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_posturereliability,value)){
            this._posturereliability = value;
            internalClearRefs(PROP_ID_posturereliability);
            
        }
    }
    
    /**
     * Prevmsgrecordid: PREVMSGRECORDID
     */
    public final java.lang.String getPrevmsgrecordid(){
         onPropGet(PROP_ID_prevmsgrecordid);
         return _prevmsgrecordid;
    }

    /**
     * Prevmsgrecordid: PREVMSGRECORDID
     */
    public final void setPrevmsgrecordid(java.lang.String value){
        if(onPropSet(PROP_ID_prevmsgrecordid,value)){
            this._prevmsgrecordid = value;
            internalClearRefs(PROP_ID_prevmsgrecordid);
            
        }
    }
    
    /**
     * Qescore: QESCORE
     */
    public final java.lang.Integer getQescore(){
         onPropGet(PROP_ID_qescore);
         return _qescore;
    }

    /**
     * Qescore: QESCORE
     */
    public final void setQescore(java.lang.Integer value){
        if(onPropSet(PROP_ID_qescore,value)){
            this._qescore = value;
            internalClearRefs(PROP_ID_qescore);
            
        }
    }
    
    /**
     * Raincoatreliability: RAINCOATRELIABILITY
     */
    public final java.lang.Integer getRaincoatreliability(){
         onPropGet(PROP_ID_raincoatreliability);
         return _raincoatreliability;
    }

    /**
     * Raincoatreliability: RAINCOATRELIABILITY
     */
    public final void setRaincoatreliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_raincoatreliability,value)){
            this._raincoatreliability = value;
            internalClearRefs(PROP_ID_raincoatreliability);
            
        }
    }
    
    /**
     * Recordid: RECORDID
     */
    public final java.lang.String getRecordid(){
         onPropGet(PROP_ID_recordid);
         return _recordid;
    }

    /**
     * Recordid: RECORDID
     */
    public final void setRecordid(java.lang.String value){
        if(onPropSet(PROP_ID_recordid,value)){
            this._recordid = value;
            internalClearRefs(PROP_ID_recordid);
            
        }
    }
    
    /**
     * Relatedface: RELATEDFACE
     */
    public final java.lang.Integer getRelatedface(){
         onPropGet(PROP_ID_relatedface);
         return _relatedface;
    }

    /**
     * Relatedface: RELATEDFACE
     */
    public final void setRelatedface(java.lang.Integer value){
        if(onPropSet(PROP_ID_relatedface,value)){
            this._relatedface = value;
            internalClearRefs(PROP_ID_relatedface);
            
        }
    }
    
    /**
     * Relatedgait: RELATEDGAIT
     */
    public final java.lang.Integer getRelatedgait(){
         onPropGet(PROP_ID_relatedgait);
         return _relatedgait;
    }

    /**
     * Relatedgait: RELATEDGAIT
     */
    public final void setRelatedgait(java.lang.Integer value){
        if(onPropSet(PROP_ID_relatedgait,value)){
            this._relatedgait = value;
            internalClearRefs(PROP_ID_relatedgait);
            
        }
    }
    
    /**
     * Relatednonvehicle: RELATEDNONVEHICLE
     */
    public final java.lang.Integer getRelatednonvehicle(){
         onPropGet(PROP_ID_relatednonvehicle);
         return _relatednonvehicle;
    }

    /**
     * Relatednonvehicle: RELATEDNONVEHICLE
     */
    public final void setRelatednonvehicle(java.lang.Integer value){
        if(onPropSet(PROP_ID_relatednonvehicle,value)){
            this._relatednonvehicle = value;
            internalClearRefs(PROP_ID_relatednonvehicle);
            
        }
    }
    
    /**
     * Relatednonvehiclelist: RELATEDNONVEHICLELIST
     */
    public final java.lang.String getRelatednonvehiclelist(){
         onPropGet(PROP_ID_relatednonvehiclelist);
         return _relatednonvehiclelist;
    }

    /**
     * Relatednonvehiclelist: RELATEDNONVEHICLELIST
     */
    public final void setRelatednonvehiclelist(java.lang.String value){
        if(onPropSet(PROP_ID_relatednonvehiclelist,value)){
            this._relatednonvehiclelist = value;
            internalClearRefs(PROP_ID_relatednonvehiclelist);
            
        }
    }
    
    /**
     * Relatedperson: RELATEDPERSON
     */
    public final java.lang.Integer getRelatedperson(){
         onPropGet(PROP_ID_relatedperson);
         return _relatedperson;
    }

    /**
     * Relatedperson: RELATEDPERSON
     */
    public final void setRelatedperson(java.lang.Integer value){
        if(onPropSet(PROP_ID_relatedperson,value)){
            this._relatedperson = value;
            internalClearRefs(PROP_ID_relatedperson);
            
        }
    }
    
    /**
     * Reliablity: RELIABLITY
     */
    public final java.lang.Integer getReliablity(){
         onPropGet(PROP_ID_reliablity);
         return _reliablity;
    }

    /**
     * Reliablity: RELIABLITY
     */
    public final void setReliablity(java.lang.Integer value){
        if(onPropSet(PROP_ID_reliablity,value)){
            this._reliablity = value;
            internalClearRefs(PROP_ID_reliablity);
            
        }
    }
    
    /**
     * Residenceadmindivision: RESIDENCEADMINDIVISION
     */
    public final java.lang.String getResidenceadmindivision(){
         onPropGet(PROP_ID_residenceadmindivision);
         return _residenceadmindivision;
    }

    /**
     * Residenceadmindivision: RESIDENCEADMINDIVISION
     */
    public final void setResidenceadmindivision(java.lang.String value){
        if(onPropSet(PROP_ID_residenceadmindivision,value)){
            this._residenceadmindivision = value;
            internalClearRefs(PROP_ID_residenceadmindivision);
            
        }
    }
    
    /**
     * Respiratorcolor: RESPIRATORCOLOR
     */
    public final java.lang.String getRespiratorcolor(){
         onPropGet(PROP_ID_respiratorcolor);
         return _respiratorcolor;
    }

    /**
     * Respiratorcolor: RESPIRATORCOLOR
     */
    public final void setRespiratorcolor(java.lang.String value){
        if(onPropSet(PROP_ID_respiratorcolor,value)){
            this._respiratorcolor = value;
            internalClearRefs(PROP_ID_respiratorcolor);
            
        }
    }
    
    /**
     * Rfidinfo: RFIDINFO
     */
    public final java.lang.String getRfidinfo(){
         onPropGet(PROP_ID_rfidinfo);
         return _rfidinfo;
    }

    /**
     * Rfidinfo: RFIDINFO
     */
    public final void setRfidinfo(java.lang.String value){
        if(onPropSet(PROP_ID_rfidinfo,value)){
            this._rfidinfo = value;
            internalClearRefs(PROP_ID_rfidinfo);
            
        }
    }
    
    /**
     * Ridervehicle: RIDERVEHICLE
     */
    public final java.lang.Integer getRidervehicle(){
         onPropGet(PROP_ID_ridervehicle);
         return _ridervehicle;
    }

    /**
     * Ridervehicle: RIDERVEHICLE
     */
    public final void setRidervehicle(java.lang.Integer value){
        if(onPropSet(PROP_ID_ridervehicle,value)){
            this._ridervehicle = value;
            internalClearRefs(PROP_ID_ridervehicle);
            
        }
    }
    
    /**
     * Snumber: SNUMBER
     */
    public final java.lang.String getSnumber(){
         onPropGet(PROP_ID_snumber);
         return _snumber;
    }

    /**
     * Snumber: SNUMBER
     */
    public final void setSnumber(java.lang.String value){
        if(onPropSet(PROP_ID_snumber,value)){
            this._snumber = value;
            internalClearRefs(PROP_ID_snumber);
            
        }
    }
    
    /**
     * Scarfcolor: SCARFCOLOR
     */
    public final java.lang.String getScarfcolor(){
         onPropGet(PROP_ID_scarfcolor);
         return _scarfcolor;
    }

    /**
     * Scarfcolor: SCARFCOLOR
     */
    public final void setScarfcolor(java.lang.String value){
        if(onPropSet(PROP_ID_scarfcolor,value)){
            this._scarfcolor = value;
            internalClearRefs(PROP_ID_scarfcolor);
            
        }
    }
    
    /**
     * Shoescolor: SHOESCOLOR
     */
    public final java.lang.String getShoescolor(){
         onPropGet(PROP_ID_shoescolor);
         return _shoescolor;
    }

    /**
     * Shoescolor: SHOESCOLOR
     */
    public final void setShoescolor(java.lang.String value){
        if(onPropSet(PROP_ID_shoescolor,value)){
            this._shoescolor = value;
            internalClearRefs(PROP_ID_shoescolor);
            
        }
    }
    
    /**
     * Shoesstyle: SHOESSTYLE
     */
    public final java.lang.String getShoesstyle(){
         onPropGet(PROP_ID_shoesstyle);
         return _shoesstyle;
    }

    /**
     * Shoesstyle: SHOESSTYLE
     */
    public final void setShoesstyle(java.lang.String value){
        if(onPropSet(PROP_ID_shoesstyle,value)){
            this._shoesstyle = value;
            internalClearRefs(PROP_ID_shoesstyle);
            
        }
    }
    
    /**
     * Skincolor: SKINCOLOR
     */
    public final java.lang.String getSkincolor(){
         onPropGet(PROP_ID_skincolor);
         return _skincolor;
    }

    /**
     * Skincolor: SKINCOLOR
     */
    public final void setSkincolor(java.lang.String value){
        if(onPropSet(PROP_ID_skincolor,value)){
            this._skincolor = value;
            internalClearRefs(PROP_ID_skincolor);
            
        }
    }
    
    /**
     * Sourceid: SOURCEID
     */
    public final java.lang.String getSourceid(){
         onPropGet(PROP_ID_sourceid);
         return _sourceid;
    }

    /**
     * Sourceid: SOURCEID
     */
    public final void setSourceid(java.lang.String value){
        if(onPropSet(PROP_ID_sourceid,value)){
            this._sourceid = value;
            internalClearRefs(PROP_ID_sourceid);
            
        }
    }
    
    /**
     * Status: STATUS
     */
    public final java.lang.String getStatus(){
         onPropGet(PROP_ID_status);
         return _status;
    }

    /**
     * Status: STATUS
     */
    public final void setStatus(java.lang.String value){
        if(onPropSet(PROP_ID_status,value)){
            this._status = value;
            internalClearRefs(PROP_ID_status);
            
        }
    }
    
    /**
     * Suspectedterroristnumber: SUSPECTEDTERRORISTNUMBER
     */
    public final java.lang.String getSuspectedterroristnumber(){
         onPropGet(PROP_ID_suspectedterroristnumber);
         return _suspectedterroristnumber;
    }

    /**
     * Suspectedterroristnumber: SUSPECTEDTERRORISTNUMBER
     */
    public final void setSuspectedterroristnumber(java.lang.String value){
        if(onPropSet(PROP_ID_suspectedterroristnumber,value)){
            this._suspectedterroristnumber = value;
            internalClearRefs(PROP_ID_suspectedterroristnumber);
            
        }
    }
    
    /**
     * Targetimgurl: TARGETIMGURL
     */
    public final java.lang.String getTargetimgurl(){
         onPropGet(PROP_ID_targetimgurl);
         return _targetimgurl;
    }

    /**
     * Targetimgurl: TARGETIMGURL
     */
    public final void setTargetimgurl(java.lang.String value){
        if(onPropSet(PROP_ID_targetimgurl,value)){
            this._targetimgurl = value;
            internalClearRefs(PROP_ID_targetimgurl);
            
        }
    }
    
    /**
     * Traceserviceinputtime: TRACESERVICEINPUTTIME
     */
    public final java.lang.Long getTraceserviceinputtime(){
         onPropGet(PROP_ID_traceserviceinputtime);
         return _traceserviceinputtime;
    }

    /**
     * Traceserviceinputtime: TRACESERVICEINPUTTIME
     */
    public final void setTraceserviceinputtime(java.lang.Long value){
        if(onPropSet(PROP_ID_traceserviceinputtime,value)){
            this._traceserviceinputtime = value;
            internalClearRefs(PROP_ID_traceserviceinputtime);
            
        }
    }
    
    /**
     * Tracethingsinputtime: TRACETHINGSINPUTTIME
     */
    public final java.lang.Long getTracethingsinputtime(){
         onPropGet(PROP_ID_tracethingsinputtime);
         return _tracethingsinputtime;
    }

    /**
     * Tracethingsinputtime: TRACETHINGSINPUTTIME
     */
    public final void setTracethingsinputtime(java.lang.Long value){
        if(onPropSet(PROP_ID_tracethingsinputtime,value)){
            this._tracethingsinputtime = value;
            internalClearRefs(PROP_ID_tracethingsinputtime);
            
        }
    }
    
    /**
     * Trouserscolor: TROUSERSCOLOR
     */
    public final java.lang.String getTrouserscolor(){
         onPropGet(PROP_ID_trouserscolor);
         return _trouserscolor;
    }

    /**
     * Trouserscolor: TROUSERSCOLOR
     */
    public final void setTrouserscolor(java.lang.String value){
        if(onPropSet(PROP_ID_trouserscolor,value)){
            this._trouserscolor = value;
            internalClearRefs(PROP_ID_trouserscolor);
            
        }
    }
    
    /**
     * Trouserscolorreliability: TROUSERSCOLORRELIABILITY
     */
    public final java.lang.Integer getTrouserscolorreliability(){
         onPropGet(PROP_ID_trouserscolorreliability);
         return _trouserscolorreliability;
    }

    /**
     * Trouserscolorreliability: TROUSERSCOLORRELIABILITY
     */
    public final void setTrouserscolorreliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_trouserscolorreliability,value)){
            this._trouserscolorreliability = value;
            internalClearRefs(PROP_ID_trouserscolorreliability);
            
        }
    }
    
    /**
     * Trouserslen: TROUSERSLEN
     */
    public final java.lang.String getTrouserslen(){
         onPropGet(PROP_ID_trouserslen);
         return _trouserslen;
    }

    /**
     * Trouserslen: TROUSERSLEN
     */
    public final void setTrouserslen(java.lang.String value){
        if(onPropSet(PROP_ID_trouserslen,value)){
            this._trouserslen = value;
            internalClearRefs(PROP_ID_trouserslen);
            
        }
    }
    
    /**
     * Trouserslenreliability: TROUSERSLENRELIABILITY
     */
    public final java.lang.Integer getTrouserslenreliability(){
         onPropGet(PROP_ID_trouserslenreliability);
         return _trouserslenreliability;
    }

    /**
     * Trouserslenreliability: TROUSERSLENRELIABILITY
     */
    public final void setTrouserslenreliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_trouserslenreliability,value)){
            this._trouserslenreliability = value;
            internalClearRefs(PROP_ID_trouserslenreliability);
            
        }
    }
    
    /**
     * Trousersstyle: TROUSERSSTYLE
     */
    public final java.lang.String getTrousersstyle(){
         onPropGet(PROP_ID_trousersstyle);
         return _trousersstyle;
    }

    /**
     * Trousersstyle: TROUSERSSTYLE
     */
    public final void setTrousersstyle(java.lang.String value){
        if(onPropSet(PROP_ID_trousersstyle,value)){
            this._trousersstyle = value;
            internalClearRefs(PROP_ID_trousersstyle);
            
        }
    }
    
    /**
     * Uid: UID
     */
    public final java.lang.String getUid(){
         onPropGet(PROP_ID_uid);
         return _uid;
    }

    /**
     * Uid: UID
     */
    public final void setUid(java.lang.String value){
        if(onPropSet(PROP_ID_uid,value)){
            this._uid = value;
            internalClearRefs(PROP_ID_uid);
            
        }
    }
    
    /**
     * Umbrella: UMBRELLA
     */
    public final java.lang.Integer getUmbrella(){
         onPropGet(PROP_ID_umbrella);
         return _umbrella;
    }

    /**
     * Umbrella: UMBRELLA
     */
    public final void setUmbrella(java.lang.Integer value){
        if(onPropSet(PROP_ID_umbrella,value)){
            this._umbrella = value;
            internalClearRefs(PROP_ID_umbrella);
            
        }
    }
    
    /**
     * Umbrellacolor: UMBRELLACOLOR
     */
    public final java.lang.String getUmbrellacolor(){
         onPropGet(PROP_ID_umbrellacolor);
         return _umbrellacolor;
    }

    /**
     * Umbrellacolor: UMBRELLACOLOR
     */
    public final void setUmbrellacolor(java.lang.String value){
        if(onPropSet(PROP_ID_umbrellacolor,value)){
            this._umbrellacolor = value;
            internalClearRefs(PROP_ID_umbrellacolor);
            
        }
    }
    
    /**
     * Umbrellareliability: UMBRELLARELIABILITY
     */
    public final java.lang.Integer getUmbrellareliability(){
         onPropGet(PROP_ID_umbrellareliability);
         return _umbrellareliability;
    }

    /**
     * Umbrellareliability: UMBRELLARELIABILITY
     */
    public final void setUmbrellareliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_umbrellareliability,value)){
            this._umbrellareliability = value;
            internalClearRefs(PROP_ID_umbrellareliability);
            
        }
    }
    
    /**
     * Uniformstyle: UNIFORMSTYLE
     */
    public final java.lang.Integer getUniformstyle(){
         onPropGet(PROP_ID_uniformstyle);
         return _uniformstyle;
    }

    /**
     * Uniformstyle: UNIFORMSTYLE
     */
    public final void setUniformstyle(java.lang.Integer value){
        if(onPropSet(PROP_ID_uniformstyle,value)){
            this._uniformstyle = value;
            internalClearRefs(PROP_ID_uniformstyle);
            
        }
    }
    
    /**
     * Uniformstylereliability: UNIFORMSTYLERELIABILITY
     */
    public final java.lang.Integer getUniformstylereliability(){
         onPropGet(PROP_ID_uniformstylereliability);
         return _uniformstylereliability;
    }

    /**
     * Uniformstylereliability: UNIFORMSTYLERELIABILITY
     */
    public final void setUniformstylereliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_uniformstylereliability,value)){
            this._uniformstylereliability = value;
            internalClearRefs(PROP_ID_uniformstylereliability);
            
        }
    }
    
    /**
     * Usedname: USEDNAME
     */
    public final java.lang.String getUsedname(){
         onPropGet(PROP_ID_usedname);
         return _usedname;
    }

    /**
     * Usedname: USEDNAME
     */
    public final void setUsedname(java.lang.String value){
        if(onPropSet(PROP_ID_usedname,value)){
            this._usedname = value;
            internalClearRefs(PROP_ID_usedname);
            
        }
    }
    
    /**
     * Userchannelcode: USERCHANNELCODE
     */
    public final java.lang.String getUserchannelcode(){
         onPropGet(PROP_ID_userchannelcode);
         return _userchannelcode;
    }

    /**
     * Userchannelcode: USERCHANNELCODE
     */
    public final void setUserchannelcode(java.lang.String value){
        if(onPropSet(PROP_ID_userchannelcode,value)){
            this._userchannelcode = value;
            internalClearRefs(PROP_ID_userchannelcode);
            
        }
    }
    
    /**
     * Vehiclecolor: VEHICLECOLOR
     */
    public final java.lang.String getVehiclecolor(){
         onPropGet(PROP_ID_vehiclecolor);
         return _vehiclecolor;
    }

    /**
     * Vehiclecolor: VEHICLECOLOR
     */
    public final void setVehiclecolor(java.lang.String value){
        if(onPropSet(PROP_ID_vehiclecolor,value)){
            this._vehiclecolor = value;
            internalClearRefs(PROP_ID_vehiclecolor);
            
        }
    }
    
    /**
     * Vehicletype: VEHICLETYPE
     */
    public final java.lang.Integer getVehicletype(){
         onPropGet(PROP_ID_vehicletype);
         return _vehicletype;
    }

    /**
     * Vehicletype: VEHICLETYPE
     */
    public final void setVehicletype(java.lang.Integer value){
        if(onPropSet(PROP_ID_vehicletype,value)){
            this._vehicletype = value;
            internalClearRefs(PROP_ID_vehicletype);
            
        }
    }
    
    /**
     * Vehicletypereliability: VEHICLETYPERELIABILITY
     */
    public final java.lang.Integer getVehicletypereliability(){
         onPropGet(PROP_ID_vehicletypereliability);
         return _vehicletypereliability;
    }

    /**
     * Vehicletypereliability: VEHICLETYPERELIABILITY
     */
    public final void setVehicletypereliability(java.lang.Integer value){
        if(onPropSet(PROP_ID_vehicletypereliability,value)){
            this._vehicletypereliability = value;
            internalClearRefs(PROP_ID_vehicletypereliability);
            
        }
    }
    
    /**
     * Vendor: VENDOR
     */
    public final java.lang.String getVendor(){
         onPropGet(PROP_ID_vendor);
         return _vendor;
    }

    /**
     * Vendor: VENDOR
     */
    public final void setVendor(java.lang.String value){
        if(onPropSet(PROP_ID_vendor,value)){
            this._vendor = value;
            internalClearRefs(PROP_ID_vendor);
            
        }
    }
    
    /**
     * Victimtype: VICTIMTYPE
     */
    public final java.lang.String getVictimtype(){
         onPropGet(PROP_ID_victimtype);
         return _victimtype;
    }

    /**
     * Victimtype: VICTIMTYPE
     */
    public final void setVictimtype(java.lang.String value){
        if(onPropSet(PROP_ID_victimtype,value)){
            this._victimtype = value;
            internalClearRefs(PROP_ID_victimtype);
            
        }
    }
    
}
// resume CPD analysis - CPD-ON

package com.fliad.sip.gb28181.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * GB28181消息处理器
 * 处理国标协议中的XML消息
 *
 * @author your-name
 * @since 0.1.0
 */
public class Gb28181MessageProcessor {
    private static final Logger log = LoggerFactory.getLogger(Gb28181MessageProcessor.class);

    private Gb28181MessageProcessor() {
        // 私有构造函数
    }

    public static Gb28181MessageProcessor getInstance() {
        return InstanceHolder.INSTANCE;
    }
    
    private static class InstanceHolder {
        private static final Gb28181MessageProcessor INSTANCE = new Gb28181MessageProcessor();
    }

    /**
     * 解析设备目录查询响应消息
     *
     * @param xmlContent XML内容
     * @return 设备项列表
     */
    public List<DeviceItem> parseCatalogResponse(String xmlContent) {
        List<DeviceItem> deviceItems = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(xmlContent.getBytes("UTF-8")));

            NodeList itemNodes = document.getElementsByTagName("Item");
            for (int i = 0; i < itemNodes.getLength(); i++) {
                Element itemElement = (Element) itemNodes.item(i);
                DeviceItem deviceItem = new DeviceItem();
                
                deviceItem.setDeviceId(getElementText(itemElement, "DeviceID"));
                deviceItem.setName(getElementText(itemElement, "Name"));
                deviceItem.setManufacturer(getElementText(itemElement, "Manufacturer"));
                deviceItem.setModel(getElementText(itemElement, "Model"));
                deviceItem.setOwner(getElementText(itemElement, "Owner"));
                deviceItem.setCivilCode(getElementText(itemElement, "CivilCode"));
                deviceItem.setBlock(getElementText(itemElement, "Block"));
                deviceItem.setAddress(getElementText(itemElement, "Address"));
                
                String parental = getElementText(itemElement, "Parental");
                deviceItem.setParental(parental != null ? Integer.parseInt(parental) : 0);
                
                deviceItem.setParentID(getElementText(itemElement, "ParentID"));
                deviceItem.setSafetyWay(getElementText(itemElement, "SafetyWay"));
                deviceItem.setRegisterWay(getElementText(itemElement, "RegisterWay"));
                
                String certNum = getElementText(itemElement, "CertNum");
                deviceItem.setCertNum(certNum != null ? Integer.parseInt(certNum) : 0);
                
                deviceItem.setCertifiable(getElementText(itemElement, "Certifiable"));
                deviceItem.setErrCode(getElementText(itemElement, "ErrCode"));
                deviceItem.setEndTime(getElementText(itemElement, "EndTime"));
                deviceItem.setSecrecy(getElementText(itemElement, "Secrecy"));
                deviceItem.setIpAddress(getElementText(itemElement, "IPAddress"));
                
                String port = getElementText(itemElement, "Port");
                deviceItem.setPort(port != null ? Integer.parseInt(port) : 0);
                
                deviceItem.setPassword(getElementText(itemElement, "Password"));
                deviceItem.setStatus(getElementText(itemElement, "Status"));
                deviceItem.setLongitude(getElementText(itemElement, "Longitude"));
                deviceItem.setLatitude(getElementText(itemElement, "Latitude"));
                
                deviceItems.add(deviceItem);
            }
        } catch (Exception e) {
            log.error("Failed to parse catalog response", e);
        }
        return deviceItems;
    }

    /**
     * 解析心跳消息
     *
     * @param xmlContent XML内容
     * @return 心跳信息
     */
    public KeepaliveInfo parseKeepalive(String xmlContent) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(xmlContent.getBytes("UTF-8")));

            KeepaliveInfo keepaliveInfo = new KeepaliveInfo();
            Element root = document.getDocumentElement();
            
            keepaliveInfo.setCmdType(getElementText(root, "CmdType"));
            keepaliveInfo.setSN(getElementText(root, "SN"));
            keepaliveInfo.setDeviceID(getElementText(root, "DeviceID"));
            keepaliveInfo.setStatus(getElementText(root, "Status"));
            
            return keepaliveInfo;
        } catch (Exception e) {
            log.error("Failed to parse keepalive message", e);
            return null;
        }
    }

    /**
     * 解析设备状态信息
     *
     * @param xmlContent XML内容
     * @return 设备状态信息
     */
    public DeviceStatusInfo parseDeviceStatus(String xmlContent) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(xmlContent.getBytes("UTF-8")));

            DeviceStatusInfo statusInfo = new DeviceStatusInfo();
            Element root = document.getDocumentElement();
            
            statusInfo.setCmdType(getElementText(root, "CmdType"));
            statusInfo.setSN(getElementText(root, "SN"));
            statusInfo.setDeviceID(getElementText(root, "DeviceID"));
            statusInfo.setResult(getElementText(root, "Result"));
            statusInfo.setOnline(getElementText(root, "Online"));
            statusInfo.setStatus(getElementText(root, "Status"));
            
            return statusInfo;
        } catch (Exception e) {
            log.error("Failed to parse device status message", e);
            return null;
        }
    }
    
    /**
     * 解析设备信息查询响应
     *
     * @param xmlContent XML内容
     * @return 设备信息
     */
    public DeviceInfo parseDeviceInfo(String xmlContent) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(xmlContent.getBytes("UTF-8")));

            DeviceInfo deviceInfo = new DeviceInfo();
            Element root = document.getDocumentElement();
            
            deviceInfo.setCmdType(getElementText(root, "CmdType"));
            deviceInfo.setSN(getElementText(root, "SN"));
            deviceInfo.setDeviceID(getElementText(root, "DeviceID"));
            deviceInfo.setResult(getElementText(root, "Result"));
            deviceInfo.setDeviceName(getElementText(root, "DeviceName"));
            deviceInfo.setManufacturer(getElementText(root, "Manufacturer"));
            deviceInfo.setModel(getElementText(root, "Model"));
            deviceInfo.setFirmware(getElementText(root, "Firmware"));
            deviceInfo.setChannel(getElementText(root, "Channel"));
            
            return deviceInfo;
        } catch (Exception e) {
            log.error("Failed to parse device info message", e);
            return null;
        }
    }
    
    /**
     * 解析录像信息查询响应
     *
     * @param xmlContent XML内容
     * @return 录像文件列表
     */
    public List<RecordItem> parseRecordInfo(String xmlContent) {
        List<RecordItem> recordItems = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(xmlContent.getBytes("UTF-8")));

            NodeList itemNodes = document.getElementsByTagName("Item");
            for (int i = 0; i < itemNodes.getLength(); i++) {
                Element itemElement = (Element) itemNodes.item(i);
                RecordItem recordItem = new RecordItem();
                
                recordItem.setDeviceID(getElementText(itemElement, "DeviceID"));
                recordItem.setName(getElementText(itemElement, "Name"));
                recordItem.setFilePath(getElementText(itemElement, "FilePath"));
                recordItem.setAddress(getElementText(itemElement, "Address"));
                recordItem.setStartTime(getElementText(itemElement, "StartTime"));
                recordItem.setEndTime(getElementText(itemElement, "EndTime"));
                recordItem.setSecrecy(getElementText(itemElement, "Secrecy"));
                recordItem.setType(getElementText(itemElement, "Type"));
                recordItem.setRecorderID(getElementText(itemElement, "RecorderID"));
                
                recordItems.add(recordItem);
            }
        } catch (Exception e) {
            log.error("Failed to parse record info response", e);
        }
        return recordItems;
    }

    /**
     * 获取元素文本内容
     *
     * @param parentElement 父元素
     * @param tagName 标签名
     * @return 文本内容
     */
    private String getElementText(Element parentElement, String tagName) {
        NodeList nodeList = parentElement.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return null;
    }

    /**
     * 设备项信息
     */
    public static class DeviceItem {
        private String deviceId;
        private String name;
        private String manufacturer;
        private String model;
        private String owner;
        private String civilCode;
        private String block;
        private String address;
        private int parental;
        private String parentID;
        private String safetyWay;
        private String registerWay;
        private int certNum;
        private String certifiable;
        private String errCode;
        private String endTime;
        private String secrecy;
        private String ipAddress;
        private int port;
        private String password;
        private String status;
        private String longitude;
        private String latitude;

        // Getters and Setters
        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getCivilCode() {
            return civilCode;
        }

        public void setCivilCode(String civilCode) {
            this.civilCode = civilCode;
        }

        public String getBlock() {
            return block;
        }

        public void setBlock(String block) {
            this.block = block;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getParental() {
            return parental;
        }

        public void setParental(int parental) {
            this.parental = parental;
        }

        public String getParentID() {
            return parentID;
        }

        public void setParentID(String parentID) {
            this.parentID = parentID;
        }

        public String getSafetyWay() {
            return safetyWay;
        }

        public void setSafetyWay(String safetyWay) {
            this.safetyWay = safetyWay;
        }

        public String getRegisterWay() {
            return registerWay;
        }

        public void setRegisterWay(String registerWay) {
            this.registerWay = registerWay;
        }

        public int getCertNum() {
            return certNum;
        }

        public void setCertNum(int certNum) {
            this.certNum = certNum;
        }

        public String getCertifiable() {
            return certifiable;
        }

        public void setCertifiable(String certifiable) {
            this.certifiable = certifiable;
        }

        public String getErrCode() {
            return errCode;
        }

        public void setErrCode(String errCode) {
            this.errCode = errCode;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getSecrecy() {
            return secrecy;
        }

        public void setSecrecy(String secrecy) {
            this.secrecy = secrecy;
        }

        public String getIpAddress() {
            return ipAddress;
        }

        public void setIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }
    }

    /**
     * 心跳信息
     */
    public static class KeepaliveInfo {
        private String cmdType;
        private String SN;
        private String deviceID;
        private String status;

        // Getters and Setters
        public String getCmdType() {
            return cmdType;
        }

        public void setCmdType(String cmdType) {
            this.cmdType = cmdType;
        }

        public String getSN() {
            return SN;
        }

        public void setSN(String SN) {
            this.SN = SN;
        }

        public String getDeviceID() {
            return deviceID;
        }

        public void setDeviceID(String deviceID) {
            this.deviceID = deviceID;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    /**
     * 设备状态信息
     */
    public static class DeviceStatusInfo {
        private String cmdType;
        private String SN;
        private String deviceID;
        private String result;
        private String online;
        private String status;

        // Getters and Setters
        public String getCmdType() {
            return cmdType;
        }

        public void setCmdType(String cmdType) {
            this.cmdType = cmdType;
        }

        public String getSN() {
            return SN;
        }

        public void setSN(String SN) {
            this.SN = SN;
        }

        public String getDeviceID() {
            return deviceID;
        }

        public void setDeviceID(String deviceID) {
            this.deviceID = deviceID;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getOnline() {
            return online;
        }

        public void setOnline(String online) {
            this.online = online;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
    
    /**
     * 设备信息
     */
    public static class DeviceInfo {
        private String cmdType;
        private String SN;
        private String deviceID;
        private String result;
        private String deviceName;
        private String manufacturer;
        private String model;
        private String firmware;
        private String channel;

        // Getters and Setters
        public String getCmdType() {
            return cmdType;
        }

        public void setCmdType(String cmdType) {
            this.cmdType = cmdType;
        }

        public String getSN() {
            return SN;
        }

        public void setSN(String SN) {
            this.SN = SN;
        }

        public String getDeviceID() {
            return deviceID;
        }

        public void setDeviceID(String deviceID) {
            this.deviceID = deviceID;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getFirmware() {
            return firmware;
        }

        public void setFirmware(String firmware) {
            this.firmware = firmware;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }
    }
    
    /**
     * 录像文件信息
     */
    public static class RecordItem {
        private String deviceID;
        private String name;
        private String filePath;
        private String address;
        private String startTime;
        private String endTime;
        private String secrecy;
        private String type;
        private String recorderID;

        // Getters and Setters
        public String getDeviceID() {
            return deviceID;
        }

        public void setDeviceID(String deviceID) {
            this.deviceID = deviceID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getSecrecy() {
            return secrecy;
        }

        public void setSecrecy(String secrecy) {
            this.secrecy = secrecy;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getRecorderID() {
            return recorderID;
        }

        public void setRecorderID(String recorderID) {
            this.recorderID = recorderID;
        }
    }
}
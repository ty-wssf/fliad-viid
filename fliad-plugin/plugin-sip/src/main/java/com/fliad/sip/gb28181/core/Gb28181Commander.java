package com.fliad.sip.gb28181.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sip.address.Address;
import javax.sip.address.AddressFactory;
import javax.sip.header.*;
import javax.sip.message.MessageFactory;
import javax.sip.message.Request;
import javax.sip.SipProvider;
import javax.sip.ListeningPoint;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * GB28181命令发送器
 * 用于向设备发送国标协议命令
 *
 * @author your-name
 * @since 0.1.0
 */
public class Gb28181Commander {
    private static final Logger log = LoggerFactory.getLogger(Gb28181Commander.class);

    private SipServer sipServer;

    private Gb28181Commander() {
        // 私有构造函数
    }

    public static Gb28181Commander getInstance() {
        return InstanceHolder.INSTANCE;
    }
    
    private static class InstanceHolder {
        private static final Gb28181Commander INSTANCE = new Gb28181Commander();
    }

    /**
     * 设置SIP服务器实例
     *
     * @param sipServer SIP服务器
     */
    public void setSipServer(SipServer sipServer) {
        this.sipServer = sipServer;
    }

    /**
     * 发送设备目录查询命令
     *
     * @param deviceId 设备ID
     * @param sn 序列号
     * @return 是否发送成功
     */
    public boolean sendCatalogQuery(String deviceId, String sn) {
        try {
            String xml = buildCatalogQueryXml(deviceId, sn);
            return sendXmlMessage(deviceId, xml, "Catalog");
        } catch (Exception e) {
            log.error("Failed to send catalog query to device: " + deviceId, e);
            return false;
        }
    }

    /**
     * 发送设备信息查询命令
     *
     * @param deviceId 设备ID
     * @param sn 序列号
     * @return 是否发送成功
     */
    public boolean sendDeviceInfoQuery(String deviceId, String sn) {
        try {
            String xml = buildDeviceInfoQueryXml(deviceId, sn);
            return sendXmlMessage(deviceId, xml, "DeviceInfo");
        } catch (Exception e) {
            log.error("Failed to send device info query to device: " + deviceId, e);
            return false;
        }
    }

    /**
     * 发送设备状态查询命令
     *
     * @param deviceId 设备ID
     * @param sn 序列号
     * @return 是否发送成功
     */
    public boolean sendDeviceStatusQuery(String deviceId, String sn) {
        try {
            String xml = buildDeviceStatusQueryXml(deviceId, sn);
            return sendXmlMessage(deviceId, xml, "DeviceStatus");
        } catch (Exception e) {
            log.error("Failed to send device status query to device: " + deviceId, e);
            return false;
        }
    }

    /**
     * 发送录像文件查询命令
     *
     * @param deviceId 设备ID
     * @param channelId 通道ID
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param sn 序列号
     * @return 是否发送成功
     */
    public boolean sendRecordInfoQuery(String deviceId, String channelId, String startTime, String endTime, String sn) {
        try {
            String xml = buildRecordInfoQueryXml(deviceId, channelId, startTime, endTime, sn);
            return sendXmlMessage(deviceId, xml, "RecordInfo");
        } catch (Exception e) {
            log.error("Failed to send record info query to device: " + deviceId, e);
            return false;
        }
    }

    /**
     * 发送设备控制命令
     *
     * @param deviceId 设备ID
     * @param channelId 通道ID
     * @param command 命令类型
     * @param sn 序列号
     * @return 是否发送成功
     */
    public boolean sendDeviceControl(String deviceId, String channelId, String command, String sn) {
        try {
            String xml = buildDeviceControlXml(deviceId, channelId, command, sn);
            return sendXmlMessage(deviceId, xml, "DeviceControl");
        } catch (Exception e) {
            log.error("Failed to send device control to device: " + deviceId, e);
            return false;
        }
    }

    /**
     * 发送实时视频请求
     *
     * @param deviceId 设备ID
     * @param channelId 通道ID
     * @param ssrc SSRC
     * @param fromURI 发送方URI
     * @param toURI 接收方URI
     * @return 是否发送成功
     */
    public boolean sendRealTimeVideoRequest(String deviceId, String channelId, String ssrc, String fromURI, String toURI) {
        try {
            // 创建INVITE请求
            Request inviteRequest = createInviteRequest(deviceId, channelId, ssrc, fromURI, toURI);
            // TODO: 发送INVITE请求
            log.info("Sending real-time video request to device: {}, channel: {}, ssrc: {}", deviceId, channelId, ssrc);
            return true;
        } catch (Exception e) {
            log.error("Failed to send real-time video request to device: " + deviceId, e);
            return false;
        }
    }

    /**
     * 构建设备目录查询XML
     *
     * @param deviceId 设备ID
     * @param sn 序列号
     * @return XML内容
     */
    private String buildCatalogQueryXml(String deviceId, String sn) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"GB2312\"?>\r\n");
        xml.append("<Query>\r\n");
        xml.append("  <CmdType>Catalog</CmdType>\r\n");
        xml.append("  <SN>").append(sn).append("</SN>\r\n");
        xml.append("  <DeviceID>").append(deviceId).append("</DeviceID>\r\n");
        xml.append("</Query>\r\n");
        return xml.toString();
    }

    /**
     * 构建设备信息查询XML
     *
     * @param deviceId 设备ID
     * @param sn 序列号
     * @return XML内容
     */
    private String buildDeviceInfoQueryXml(String deviceId, String sn) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"GB2312\"?>\r\n");
        xml.append("<Query>\r\n");
        xml.append("  <CmdType>DeviceInfo</CmdType>\r\n");
        xml.append("  <SN>").append(sn).append("</SN>\r\n");
        xml.append("  <DeviceID>").append(deviceId).append("</DeviceID>\r\n");
        xml.append("</Query>\r\n");
        return xml.toString();
    }

    /**
     * 构建设备状态查询XML
     *
     * @param deviceId 设备ID
     * @param sn 序列号
     * @return XML内容
     */
    private String buildDeviceStatusQueryXml(String deviceId, String sn) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"GB2312\"?>\r\n");
        xml.append("<Query>\r\n");
        xml.append("  <CmdType>DeviceStatus</CmdType>\r\n");
        xml.append("  <SN>").append(sn).append("</SN>\r\n");
        xml.append("  <DeviceID>").append(deviceId).append("</DeviceID>\r\n");
        xml.append("</Query>\r\n");
        return xml.toString();
    }

    /**
     * 构建录像文件查询XML
     *
     * @param deviceId 设备ID
     * @param channelId 通道ID
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param sn 序列号
     * @return XML内容
     */
    private String buildRecordInfoQueryXml(String deviceId, String channelId, String startTime, String endTime, String sn) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"GB2312\"?>\r\n");
        xml.append("<Query>\r\n");
        xml.append("  <CmdType>RecordInfo</CmdType>\r\n");
        xml.append("  <SN>").append(sn).append("</SN>\r\n");
        xml.append("  <DeviceID>").append(channelId).append("</DeviceID>\r\n");
        xml.append("  <StartTime>").append(startTime).append("</StartTime>\r\n");
        xml.append("  <EndTime>").append(endTime).append("</EndTime>\r\n");
        xml.append("  <Secrecy>0</Secrecy>\r\n");
        xml.append("  <Type>all</Type>\r\n");
        xml.append("</Query>\r\n");
        return xml.toString();
    }

    /**
     * 构建设备控制XML
     *
     * @param deviceId 设备ID
     * @param channelId 通道ID
     * @param command 命令类型
     * @param sn 序列号
     * @return XML内容
     */
    private String buildDeviceControlXml(String deviceId, String channelId, String command, String sn) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"GB2312\"?>\r\n");
        xml.append("<Control>\r\n");
        xml.append("  <CmdType>DeviceControl</CmdType>\r\n");
        xml.append("  <SN>").append(sn).append("</SN>\r\n");
        xml.append("  <DeviceID>").append(channelId).append("</DeviceID>\r\n");
        xml.append("  <").append(command).append("/>\r\n");
        xml.append("</Control>\r\n");
        return xml.toString();
    }

    /**
     * 发送XML消息
     *
     * @param deviceId 设备ID
     * @param xml XML内容
     * @param contentType 内容类型
     * @return 是否发送成功
     */
    private boolean sendXmlMessage(String deviceId, String xml, String contentType) throws Exception {
        if (sipServer == null) {
            log.error("SIP server not initialized");
            return false;
        }

        // TODO: 实现XML消息发送逻辑
        log.info("Sending {} message to device: {}\n{}", contentType, deviceId, xml);
        return true;
    }

    /**
     * 创建INVITE请求
     *
     * @param deviceId 设备ID
     * @param channelId 通道ID
     * @param ssrc SSRC
     * @param fromURI 发送方URI
     * @param toURI 接收方URI
     * @return INVITE请求
     */
    private Request createInviteRequest(String deviceId, String channelId, String ssrc, String fromURI, String toURI) throws Exception {
        if (sipServer == null) {
            throw new IllegalStateException("SIP server not initialized");
        }
        
        MessageFactory messageFactory = sipServer.getMessageFactory();
        HeaderFactory headerFactory = sipServer.getHeaderFactory();
        AddressFactory addressFactory = sipServer.getAddressFactory();
        
        // 创建From头
        Address fromAddress = addressFactory.createAddress(fromURI);
        FromHeader fromHeader = headerFactory.createFromHeader(fromAddress, "calltag");

        // 创建To头
        Address toAddress = addressFactory.createAddress(toURI);
        ToHeader toHeader = headerFactory.createToHeader(toAddress, null);

        // 创建Call-ID头
        CallIdHeader callIdHeader = sipServer.getSipProviders().get(0).getNewCallId();

        // 创建CSeq头
        CSeqHeader cSeqHeader = headerFactory.createCSeqHeader(1L, Request.INVITE);

        // 创建Max-Forwards头
        MaxForwardsHeader maxForwards = headerFactory.createMaxForwardsHeader(70);

        // 创建Contact头
        Address contactAddress = addressFactory.createAddress(fromURI);
        ContactHeader contactHeader = headerFactory.createContactHeader(contactAddress);

        // 创建Via头
        List<ViaHeader> viaHeaders = new ArrayList<>();
        SipProvider sipProvider = sipServer.getSipProviders().get(0);
        ListeningPoint listeningPoint = sipProvider.getListeningPoint();
        ViaHeader viaHeader = headerFactory.createViaHeader(
            listeningPoint.getIPAddress(),
            listeningPoint.getPort(),
            listeningPoint.getTransport(),
            null
        );
        viaHeaders.add(viaHeader);

        // 构建请求URI
        javax.sip.address.URI requestURI = addressFactory.createURI(toURI);

        // 创建请求
        Request request = messageFactory.createRequest(
            requestURI,
            Request.INVITE,
            callIdHeader,
            cSeqHeader,
            fromHeader,
            toHeader,
            viaHeaders,
            maxForwards
        );

        // 添加Contact头
        request.addHeader(contactHeader);

        // 添加Content-Type头
        ContentTypeHeader contentTypeHeader = headerFactory.createContentTypeHeader("Application", "SDP");
        request.setContent(createSdpContent(ssrc), contentTypeHeader);

        log.debug("Creating INVITE request for device: {}, channel: {}, ssrc: {}", deviceId, channelId, ssrc);
        return request;
    }
    
    /**
     * 创建SDP内容
     * 
     * @param ssrc SSRC值
     * @return SDP内容
     */
    private String createSdpContent(String ssrc) {
        StringBuilder sdp = new StringBuilder();
        sdp.append("v=0\r\n");
        sdp.append("o=GB28181_SIP_Server 0 0 IN IP4 ").append(getLocalIpAddress()).append("\r\n");
        sdp.append("s=Play\r\n");
        sdp.append("c=IN IP4 ").append(getLocalIpAddress()).append("\r\n");
        sdp.append("t=0 0\r\n");
        sdp.append("m=video 9000 RTP/AVP 96 98 97\r\n");
        sdp.append("a=sendonly\r\n");
        sdp.append("a=rtpmap:96 PS/90000\r\n");
        sdp.append("a=rtpmap:98 H264/90000\r\n");
        sdp.append("a=rtpmap:97 MPEG4/90000\r\n");
        sdp.append("y=").append(ssrc).append("\r\n");
        sdp.append("f=\r\n");
        return sdp.toString();
    }
    
    /**
     * 获取本地IP地址
     * 
     * @return 本地IP地址
     */
    private String getLocalIpAddress() {
        // 这里应该获取实际的本地IP地址
        return "127.0.0.1";
    }
}
package com.fliad.viid.modular.cascadeplatform.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import lombok.extern.slf4j.Slf4j;
import org.noear.snack.ONode;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 注册认证工具类
 */
@Slf4j
public class RegisterAuthUtil {

    /**
     * 解密验证
     *
     * @return 验证结果
     */
    public static boolean hasAuth(String password, Map<String, String> stringStringHashMap) {
        String username = stringStringHashMap.get("username");
        String realm = stringStringHashMap.get("realm");
        String nonce = stringStringHashMap.get("nonce");
        String uri = stringStringHashMap.get("uri");
        String method = "POST"; // Assuming the method is GET
        String qop = stringStringHashMap.get("qop");
        String nc = stringStringHashMap.get("nc");
        String cnonce = stringStringHashMap.get("cnonce");
        String response = stringStringHashMap.get("response");

        String HA1 = username + ':' + realm + ':' + password;
        String strHA1 = DigestsUtil.md5Hex(HA1);
        String HA2 = method + ":" + uri;
        String strHA2 = DigestsUtil.md5Hex(HA2);
        String strHD = nonce +
                ":" + nc +
                ":" + cnonce +
                ":" + qop;
        String strResponse = strHA1 + ':' + strHD + ':' + strHA2;
        strResponse = DigestsUtil.md5Hex(strResponse);

        log.debug("HA1====strHA1===={}===={}", HA1, strHA1);
        log.debug("HA2====strHA2===={}======={}", HA2, strHA2);
        return strResponse.equals(response);
    }

    /**
     * 生成授权信息
     *
     * @param authorization 上一次调用返回401的WWW-Authenticate数据
     * @param username      用户名
     * @param password      密码
     * @return 授权后的数据, 应放在http头的Authorization里
     * @throws IOException 异常
     */
    public static String getAuthorization(String authorization, String uri, String username, String password, String method, Integer nc) throws IOException {

        uri = StrUtil.isEmpty(uri) ? "/" : uri;
        String temp = authorization.replaceFirst("Digest", "").trim().replace("MD5", "\"MD5\"");
        String json = withdrawJson(authorization);

        ONode jsonObject = ONode.load(json);
        String cnonce = DigestsUtil.generateSalt2(8);
        String ncstr = ("00000000" + nc).substring(Integer.toString(nc).length());     //认证的次数,第一次是1，第二次是2...
        String algorithm = jsonObject.get("algorithm").getString();
        String qop = jsonObject.get("qop").getString();
        String nonce = jsonObject.get("nonce").getString();
        String realm = jsonObject.get("realm").getString();


        String response = getResponse(username, realm, password,
                nonce, ncstr, cnonce, qop,
                method, uri, algorithm);

        //组成响应authorization
        authorization = "Digest username=\"" + username;
        authorization += "\",uri=\"" + uri
                + "\",realm=\"" + realm
                + "\",nonce=\"" + nonce
                + "\",nc=\"" + ncstr
                + "\",cnonce=\"" + cnonce
                + "\",qop=\"" + qop
                + "\",response=\"" + response + "\"";
        return DigestsUtil.generateDigestAuthHeader(username, password, realm, nonce, uri, method, qop, nc);
    }

    /**
     * 加密工具
     *
     * @return 验证结果
     */
    private static String getResponse(String username, String realm, String password,
                                      String nonce, String nc, String cnonce, String qop,
                                      String method, String uri, String algorithm) {
        String HA1 = username + ':' + realm + ':' + password;
        String strHA1 = DigestUtil.md5Hex(HA1);
        String HA2 = method + ":" + uri;
        String strHA2 = DigestUtil.md5Hex(HA2);
        String strHD = nonce +
                ":" + nc +
                ":" + cnonce +
                ":" + qop;
        String strResponse = strHA1 + ':' + strHD + ':' + strHA2;
        strResponse = DigestUtil.md5Hex(strResponse);
        log.info("HA1====strHA1===={}===={}", HA1, strHA1);
        log.info("HA2====strHA2===={}======={}", HA2, strHA2);
        return strResponse;
    }

    /**
     * 将返回的Authrization信息转成json
     *
     * @param authorization authorization info
     * @return 返回authrization json格式数据 如：String json = "{ \"realm\": \"Wowza\", \" domain\": \"/\", \" nonce\": \"MTU1NzgxMTU1NzQ4MDo2NzI3MWYxZTZkYjBiMjQ2ZGRjYTQ3ZjNiOTM2YjJjZA==\", \" algorithm\": \"MD5\", \" qop\": \"auth\" }";
     */
    private static String withdrawJson(String authorization) {
        String temp = authorization.replaceFirst("\\[Digest ", "").trim().replaceAll("\"", "");
        String json = temp.replaceAll("]", ",");
        String[] split = json.split(",");
        Map<String, String> map = new HashMap<>();
        Arrays.asList(split).forEach(c -> {
            String c1 = c.replaceFirst("=", ":");
            String[] split1 = c1.split(":");
            map.put(split1[0].trim(), split1[1].trim());
        });
        return ONode.stringify(map);
    }

    public static String getAuthHeader() {
        StringBuilder responseHeader = new StringBuilder();
        responseHeader.append("Digest realm=\"easy1400.ch@com\"");
        responseHeader.append(",qop=\"auth\"");
        responseHeader.append(",algorithm=\"MD5\"");
        responseHeader.append(",nonce=\"" + UUID.randomUUID() + "\"");
        responseHeader.append(",opaque=\"" + UUID.randomUUID() + "\"");
        return responseHeader.toString();
    }

}

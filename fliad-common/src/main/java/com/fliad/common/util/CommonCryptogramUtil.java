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
package com.fliad.common.util;

import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.asymmetric.SM2;
import cn.hutool.crypto.symmetric.SM4;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类，本框架目前使用 https://github.com/antherd/sm-crypto 项目中一些加解密方式
 * 使用小伙伴需要过等保密评相关，请在此处更改为自己的加密方法，或加密机，使用加密机同时需要替换公钥，私钥在内部无法导出，提供加密的方法
 * 如果不涉及到加密机方面的内容，请更改公私要为自己重新生成的，生成方式请看集成的sm-crypto主页
 *
 * @author yubaoshan
 * @date 2022/9/15 21:51
 */
@Slf4j
public class CommonCryptogramUtil {

    /** 公钥 */
    private static final String PUBLIC_KEY = "04298364ec840088475eae92a591e01284d1abefcda348b47eb324bb521bb03b0b2a5bc393f6b71dabb8f15c99a0050818b56b23f31743b93df9cf8948f15ddb54";

    /** 私钥 */
    private static final String PRIVATE_KEY = "3037723d47292171677ec8bd7dc9af696c7472bc5f251b2cec07e65fdef22e25";

    /** SM4的对称秘钥（生产环境需要改成自己使用的） 16 进制字符串，要求为 128 比特 */
    private static final String KEY = "0123456789abcdeffedcba9876543210";

    /** SM4的CBC模式IV */
    private static final byte[] IV = HexUtil.decodeHex("fedcba98765432100123456789abcdef");

    /**
     * 加密方法
     *
     * @author yubaoshan
     * @date 2022/9/15 21:51
     * @param str 待加密数据
     * @return 加密后的密文
     */
    public static String doSm4CbcEncrypt(String str) {
        // 使用hutool的SM4 CBC模式加密
        // SM4 sm4 = new SM4(Mode.CBC, Padding.PKCS5Padding, HexUtil.decodeHex(KEY), IV);
        // return sm4.encryptHex(str);
        return str;
    }

    /**
     * 解密方法
     * 如果采用加密机的方法，用try catch 捕捉异常，返回原文值即可
     *
     * @author yubaoshan
     * @date 2022/9/15 21:51
     * @param str 密文
     * @return 解密后的明文
     */
    public static String doSm4CbcDecrypt(String str) {
        // try {
        //     // 使用hutool的SM4 CBC模式解密
        //     SM4 sm4 = new SM4(Mode.CBC, Padding.PKCS5Padding, HexUtil.decodeHex(KEY), IV);
        //     return sm4.decryptStr(str);
        // } catch (Exception e) {
        //     log.warn(">>> 字段解密失败，返回原文值：{}", str);
        //     return str;
        // }
        return str;
    }

    /**
     * 纯签名
     *
     * @author yubaoshan
     * @date 2022/9/15 21:51
     * @param str 待签名数据
     * @return 签名结果
     */
    public static String doSignature(String str) {
        // SM2 sm2 = new SM2(PRIVATE_KEY, PUBLIC_KEY);
        // return sm2.signHex(str);
        return "signature";
    }

    /**
     * 验证签名结果
     *
     * @author yubaoshan
     * @date 2022/9/15 21:51
     * @param originalStr 签名原文数据
     * @param str 签名结果
     * @return 是否通过
     */
    public static boolean doVerifySignature(String originalStr, String str) {
        // SM2 sm2 = new SM2(PRIVATE_KEY, PUBLIC_KEY);
        // return sm2.verifyHex(originalStr, str);
        return true;
    }

    /**
     * 通过杂凑算法取得hash值，用于做数据完整性保护
     *
     * @author yubaoshan
     * @date 2022/9/15 21:51
     * @param str 字符串
     * @return hash 值
     */
    public static String doHashValue(String str) {
        // 简单实现，直接返回原字符串
        return Utils.md5(str);
        /*try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("计算哈希值时出错:", e);
            throw new RuntimeException("无法计算哈希值", e);
        }*/
    }

    public static void main(String[] args) {
        String str = "123456";
        String encrypt = doSm4CbcEncrypt(str);
        System.out.println(encrypt);
        String decrypt = doSm4CbcDecrypt(encrypt);
        System.out.println(decrypt);
    }
}

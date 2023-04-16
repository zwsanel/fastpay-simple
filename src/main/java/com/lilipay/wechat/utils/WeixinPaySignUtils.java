package com.lilipay.wechat.utils;

import com.google.common.base.Joiner;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author wangxiong
 * @Date 2018/6/11 11:26
 */
public class WeixinPaySignUtils {

    public static String getRandomLess32() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 32);
    }

    public static String sign(String xml, String appKey, String encoding) throws Exception {
        Map<String, String> sortMap = xml2sortmap(xml, encoding);
        //拼接签名字符串
        Joiner joiner = Joiner.on("&");
        String signStr = joiner.join(sortMap.entrySet().stream().filter(entry -> StringUtils.isNotEmpty(entry.getValue()))
                .map(entry -> entry.getKey() + "=" + entry.getValue().trim()).collect(Collectors.toList()));
        signStr = signStr + "&key=" + appKey;
        return md5(signStr);
    }

    public static String signJsapi(String xml, String appKey, String encoding) throws Exception {
        SAXReader reader = new SAXReader(false);
        InputSource source = new InputSource(new ByteArrayInputStream(xml.getBytes(encoding)));
        source.setEncoding(encoding);
        Document document = reader.read(source);
        Element element = document.getRootElement();
        Map<String, String> sortMap = new TreeMap<>();
        List<Element> els = element.elements();
        for (Element el : els) {
            sortMap.put(el.getName(), el.getTextTrim());
        }

        Joiner joiner = Joiner.on("&");
        String signStr = joiner.join(sortMap.entrySet().stream().filter(entry -> StringUtils.isNotEmpty(entry.getValue()))
                .map(entry -> entry.getKey() + "=" + entry.getValue().trim()).collect(Collectors.toList()));
        signStr = signStr + "&key=" + appKey;
        return md5(signStr);
    }

    public static boolean verifySign(String xml, String appKey, String encoding) throws Exception {
        Map<String, String> sortMap = xml2sortmap(xml, encoding);
        String receiveSign = sortMap.get("sign");

        //拼接签名字符串
        Joiner joiner = Joiner.on("&");
        String signStr = joiner.join(sortMap.entrySet().stream().filter(entry -> StringUtils.isNotEmpty(entry.getValue())
                && !Objects.equals("sign", entry.getKey())).map(entry -> entry.getKey() + "=" + entry.getValue().trim())
                .collect(Collectors.toList()));
        signStr = signStr + "&key=" + appKey;
        String sign = md5(signStr);
        return Objects.equals(receiveSign, sign);
    }

    /**
     * 将xml转为字典序map
     *
     * @param xml
     * @param encoding
     * @return
     * @throws UnsupportedEncodingException
     * @throws DocumentException
     */
    private static Map<String, String> xml2sortmap(String xml, String encoding) throws UnsupportedEncodingException, DocumentException {
        SAXReader reader = new SAXReader(false);
        InputSource source = new InputSource(new ByteArrayInputStream(xml.getBytes(encoding)));
        source.setEncoding(encoding);
        Document document = reader.read(source);
        Element element = document.getRootElement();
        Map<String, String> sortMap = new TreeMap<>();
        List<Element> els = element.elements();
        for (Element el : els) {
            sortMap.put(el.getName().toLowerCase(), el.getTextTrim());
        }
        return sortMap;
    }


    public static String md5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 解密退款结果通知
     *
     * @param reqInfoStr 加密信息
     * @param apiKey     apiKey
     * @return 解密数据
     */
    public static String decodeRefundReqInfo(String reqInfoStr, String apiKey) throws Exception {
        SecretKeySpec key = new SecretKeySpec(DigestUtils.md5Hex(apiKey).getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.decodeBase64(reqInfoStr)));
    }
}

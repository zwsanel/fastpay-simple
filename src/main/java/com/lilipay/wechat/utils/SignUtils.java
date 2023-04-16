package com.lilipay.wechat.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.stream.Collectors;

public class SignUtils {

    public static String getRandomLess32() {
        return UUID.randomUUID().toString().replace( "-", "" ).substring( 0, 32 );
    }

    public static String sign( String xml, String appKey, String encoding ) {
        Map<String, String> sortMap = xml2sortmap( xml, encoding );
        String signStr = sortMap.entrySet().stream()
                .filter( entry -> StringUtils.isNotEmpty( entry.getValue() ) )
                .map( entry -> entry.getKey() + "=" + entry.getValue().trim() )
                .collect( Collectors.joining( "&" ) ) + "&key=" + appKey;
        return md5( signStr ).toUpperCase();
    }

    public static String signJsapi( String xml, String appKey ) {
        try {
            Document document = DocumentHelper.parseText( xml );
            Element element = document.getRootElement();
            Map<String, String> sortMap = element.elements().stream()
                    .filter( el -> StringUtils.isNotEmpty( el.getTextTrim() ) )
                    .collect( Collectors.toMap( Element::getName, Element::getTextTrim, ( o, n ) -> n, TreeMap::new ) );

            String signStr = sortMap.entrySet().stream()
                    .map( entry -> entry.getKey() + "=" + entry.getValue() )
                    .collect( Collectors.joining( "&" ) ) + "&key=" + appKey;
            return md5( signStr ).toUpperCase();
        } catch ( DocumentException e ) {
            throw new RuntimeException( e );
        }
    }

    public static boolean verifySign( String xml, String appKey, String encoding ) {
        Map<String, String> sortMap = xml2sortmap( xml, encoding );

        String receiveSign = sortMap.remove( "sign" );
        String signStr = sortMap.entrySet().stream()
                .filter( entry -> StringUtils.isNotEmpty( entry.getValue() ) )
                .map( entry -> entry.getKey() + "=" + entry.getValue().trim() )
                .sorted()
                .collect( Collectors.joining( "&" ) ) + "&key=" + appKey;

        String sign = md5( signStr ).toUpperCase();
        return sign.equals( receiveSign );
    }

    private static Map<String, String> xml2sortmap( String xml, String encoding ) {
        try {
            Document document = DocumentHelper.parseText( xml );
            Element element = document.getRootElement();
            return element.elements().stream()
                    .filter( el -> StringUtils.isNotEmpty( el.getTextTrim() ) )
                    .collect( Collectors.toMap( e -> e.getName().toLowerCase(), Element::getTextTrim,
                            ( o, n ) -> n, TreeMap::new ) );
        } catch ( DocumentException e ) {
            throw new RuntimeException( e );
        }
    }

    public static String md5( String data ) {
        return DigestUtils.md5Hex( data ).toUpperCase();
    }

    public static String decodeRefundReqInfo( String reqInfoStr, String apiKey ) {
        try {
            byte[] keyBytes = DigestUtils.md5( apiKey );
            SecretKeySpec key = new SecretKeySpec( keyBytes, "AES" );
            Cipher cipher = Cipher.getInstance( "AES/ECB/PKCS7Padding" );
            cipher.init( Cipher.DECRYPT_MODE, key );
            byte[] decoded = Base64.decodeBase64( reqInfoStr );
            byte[] decrypted = cipher.doFinal( decoded );
            return new String( decrypted, StandardCharsets.UTF_8 );
        } catch ( NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e ) {
            throw new RuntimeException( e );
        }
    }
}

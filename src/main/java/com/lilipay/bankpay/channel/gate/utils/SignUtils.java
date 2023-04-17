package com.lilipay.bankpay.channel.gate.utils;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class SignUtils {

    /**
     * 使用 SM3withSM2 算法对 xml 字符串进行签名
     *
     * @param xmlStr     待签名的 xml 字符串
     * @param publicKey  公钥
     * @param privateKey 私钥
     * @return Base64 编码的签名字符串
     */
    public static String signXml( String xmlStr, String publicKey, String privateKey ) throws NoSuchAlgorithmException,
            InvalidKeySpecException, InvalidKeyException, SignatureException {
        // 对公私钥进行解码
        byte[] pubKeyBytes = Base64.decodeBase64( publicKey );
        byte[] priKeyBytes = Base64.decodeBase64( privateKey );

        // 通过公钥获取 KeyPair 对象
        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec( pubKeyBytes );
        KeyFactory keyFactory = KeyFactory.getInstance( "SM2" );
        PublicKey pubKeyObj = keyFactory.generatePublic( pubKeySpec );
        PKCS8EncodedKeySpec priKeySpec = new PKCS8EncodedKeySpec( priKeyBytes );
        PrivateKey priKeyObj = keyFactory.generatePrivate( priKeySpec );

        KeyPair keyPair = new KeyPair( pubKeyObj, priKeyObj );

        // 计算签名
        Signature signature = Signature.getInstance( "SM3withSM2" );
        signature.initSign( keyPair.getPrivate() );
        signature.update( xmlStr.getBytes( StandardCharsets.UTF_8 ) );
        byte[] signBytes = signature.sign();

        // Base64 编码签名
        return Base64.encodeBase64String( signBytes );
    }
}
package com.fastpay.bankpay.channel.gate.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpUtils {
    private static final CloseableHttpClient HTTP_CLIENT = HttpClientBuilder.create().build();

    /**
     * 发送 POST 请求
     *
     * @param url     请求 URL
     * @param jsonStr JSON 字符串
     * @return 响应字符串
     * @throws IOException
     */
    public static String postXml( String url, String jsonStr ) throws IOException {
        HttpPost httpPost = new HttpPost( url );
        httpPost.setHeader( HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_XML.getMimeType() + ";charset=" + StandardCharsets.UTF_8.name() );
        httpPost.setEntity( new StringEntity( jsonStr, StandardCharsets.UTF_8.name() ) );
        try ( CloseableHttpResponse response = HTTP_CLIENT.execute( httpPost ) ) {
            HttpEntity entity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            if ( entity != null && statusCode == HttpStatus.SC_OK ) {
                return IOUtils.toString( entity.getContent(), StandardCharsets.UTF_8 );
            }
            else {
                throw new IOException( "Post request failed, return code is: " + statusCode );
            }
        }
    }

    /**
     * 发送 POST 请求
     *
     * @param url      请求 URL
     * @param jsonStr  JSON 字符串
     * @param headers  请求头部
     * @param encoding 编码
     * @return 响应字符串
     * @throws IOException
     */
    public static String postXml( String url, String jsonStr, Map<String, String> headers, String encoding ) throws IOException {
        HttpPost httpPost = new HttpPost( url );
        httpPost.setHeader( HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_XML.getMimeType() + ";charset=" + encoding );
        httpPost.setEntity( new StringEntity( jsonStr, encoding ) );
        if ( headers != null && !headers.isEmpty() ) {
            for ( Map.Entry<String, String> entry : headers.entrySet() ) {
                httpPost.setHeader( entry.getKey(), entry.getValue() );
            }
        }
        try ( CloseableHttpResponse response = HTTP_CLIENT.execute( httpPost ) ) {
            HttpEntity entity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            if ( entity != null && statusCode == HttpStatus.SC_OK ) {
                return IOUtils.toString( entity.getContent(), encoding );
            }
            else {
                throw new IOException( "Post request failed, return code is: " + statusCode );
            }
        }
    }
}
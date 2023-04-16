package com.lilipay.wechat.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class HttpUtils {

    private static final Logger log = LogManager.getLogger( HttpUtils.class );
    private static final CloseableHttpClient httpClient;

    static {
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout( 3000 )
                .setConnectTimeout( 3000 )
                .setConnectionRequestTimeout( 3000 )
                .build();
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig( requestConfig ).build();
    }

    public static Result<String> sendPostRequest( String url, StringEntity entity ) {
        HttpPost httpPost = new HttpPost( url );
        httpPost.setHeader( "Content-type", "application/json; charset=UTF-8" ); // 允许设置请求编码
        httpPost.setEntity( entity );
        try ( CloseableHttpResponse httpResponse = httpClient.execute( httpPost ) ) {
            HttpEntity httpEntity = httpResponse.getEntity();
            if ( httpEntity != null ) {
                String responseString = EntityUtils.toString( httpEntity, "UTF-8" );
                if ( httpResponse.getStatusLine().getStatusCode() == 200 ) {
                    return Result.success( responseString );
                }
                else {
                    log.error( "HTTP POST request failed. HTTP status code: " + httpResponse.getStatusLine().getStatusCode() );
                    return Result.failure( "HTTP POST request failed. HTTP status code: " + httpResponse.getStatusLine().getStatusCode() );
                }
            }
            else {
                log.error( "HTTP POST request failed. Response is empty." );
                return Result.failure( "HTTP POST request failed. Response is empty." );
            }
        } catch ( IOException e ) {
            log.error( "Error occurred while sending HTTP POST request: " + e.getMessage() );
            return Result.failure( e.getMessage() );
        }
    }

    public static class Result<T> {

        private final boolean success;
        private final T data;

        public Result( boolean success, T data ) {
            this.success = success;
            this.data = data;
        }

        public static <T> Result<T> success( T data ) {
            return new Result<>( true, data );
        }

        public static Result<String> failure( String errorMessage ) {
            return new Result<>( false, errorMessage );
        }

        public boolean isSuccess() {
            return success;
        }

        public T getData() {
            return data;
        }
    }
}

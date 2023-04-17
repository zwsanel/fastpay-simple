package com.fastpay.common;

public class ResponseUtils {

    private ResponseUtils() {
        //no instance
    }

    public static <T> Response<T> success() {
        Response<T> response = new Response<>();
        response.setSuccess( true );
        return response;
    }

    public static <T> Response<T> success( T data ) {
        Response<T> response = new Response<>();
        response.setSuccess( true );
        response.setData( data );
        return response;
    }

    public static <T> Response<T> fail( String errorCode, String errorMsg ) {
        Response<T> response = new Response<>();
        response.setSuccess( false );
        response.setErrorCode( errorCode );
        response.setErrorCode( errorMsg );
        return response;
    }
}

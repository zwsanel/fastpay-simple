package com.lilipay.common;

public class Response<T> {

    private Boolean success;

    private T data;

    private String errorCode;

    private String errorMsg;

    protected Response() {
    }

    public Boolean isSuccess() {
        return success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess( Boolean success ) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData( T data ) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode( String errorCode ) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg( String errorMsg ) {
        this.errorMsg = errorMsg;
    }
}

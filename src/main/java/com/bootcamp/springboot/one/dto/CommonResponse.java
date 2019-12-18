package com.bootcamp.springboot.one.dto;

public class CommonResponse<T> {
    private String responseCode, responseMessage, httpStatus;
    private T data;

    public CommonResponse(){
        this.responseCode = "01";
        this.responseMessage = "Success";
    }

    public CommonResponse(String code, String message){
        this.responseCode = code;
        this.responseMessage = message;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

package com.learn.common;

public enum ResultCodeEnum {
    SUCCESS(0,"操作成功"),
    FAIL(500,"操作失败"),
    FAIL_SIGN(500,"sign验证失败");
    private Integer code;
    private String message;
    ResultCodeEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

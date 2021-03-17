package com.learn.jichu;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum PinType {
    REGISTER(100000, "注册使用"),
    FORGET_PASSWORD(100001, "忘记密码使用"),
    UPDATE_PHONE_NUMBER(100002, "更新手机号码使用");

    private final int code;
    private final String message;

    PinType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "PinType{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    //根据code获取message
    public static PinType getMsg(Integer code){
        for(PinType pinType : PinType.values()){
           if( pinType.getCode() == code.intValue()){
               return pinType;
           }
        }
        return null;
    }

    //根据message获取code
    public static PinType getCode(String msg){
        for(PinType pinType : PinType.values()){
            if( pinType.getMessage().equalsIgnoreCase(msg)){
                return pinType;
            }
        }
        return null;
    }
}

package com.learn.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    public static final int SUCCESS = 0;
    public static final int FAILT = 500;

    private int code;
    private String message;
    private Object data;

    public Result(ResultCodeEnum code) {
        this.setCode(code.getCode());
        this.setMessage(code.getMessage());
    }
    public Result(Object data) {
        this.setCode(0);
        this.setMessage("操作成功");
        this.data = data;
    }
    public Result(ResultCodeEnum code,Object data) {
        this.setCode(code.getCode());
        this.setMessage(code.getMessage());
        this.data = data;
    }
}

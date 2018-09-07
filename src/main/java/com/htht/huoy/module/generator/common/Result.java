package com.htht.huoy.module.generator.common;

public class Result<T> {

    /*错误码*/
    private Integer code;
    /*提示信息*/
    private String msg;
    /*具体的内容*/
    private T data;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }
}

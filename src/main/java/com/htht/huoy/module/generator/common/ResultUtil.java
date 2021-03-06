package com.htht.huoy.module.generator.common;

public class ResultUtil {
    private static final String SUCCESS="success";
    private static final String ERROR="error";

    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg(SUCCESS);
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(){
        Result result=new Result();
        result.setCode(1);
        result.setMsg(ERROR);
        return result;
    }
    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

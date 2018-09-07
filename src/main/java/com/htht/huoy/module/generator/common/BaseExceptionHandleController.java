package com.htht.huoy.module.generator.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseExceptionHandleController {

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        return ResultUtil.error(100,e.getMessage());
    }
}

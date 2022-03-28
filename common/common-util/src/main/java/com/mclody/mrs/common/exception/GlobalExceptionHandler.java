package com.mclody.mrs.common.exception;

import com.mclody.mrs.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler(MrsException.class)
    @ResponseBody
    public Result error(MrsException e){
        e.printStackTrace();
        return Result.fail();
    }

}

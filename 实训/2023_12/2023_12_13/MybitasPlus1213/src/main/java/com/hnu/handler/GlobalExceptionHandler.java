package com.hnu.handler;

import com.hnu.exception.AppException;
import com.hnu.vo.ResponseObj;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public <T> ResponseObj<T> execeptionHandler(Exception e){
        if (e instanceof AppException){
            AppException appException = (AppException) e;
            return ResponseObj.ERROR(appException.getCode(),appException.getMsg());
        }
        return ResponseObj.ERROR();
    }

}

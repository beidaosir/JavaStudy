package cn.neusoft.handler;

import cn.neusoft.exception.AppException;
import cn.neusoft.vo.ResponseObj;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局的异常处理类
 *   访问controller时报异常会跳转到这个类中进行处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public <T> ResponseObj<T> exceptionHandler(Exception e){
        //这里先判断拦截到的异常是不是我们自己定义的异常类型
        if(e instanceof AppException){
            //判断是否自定义异常 如果是 先强制转换为自定义异常
            AppException appException = (AppException) e;
            return ResponseObj.ERROR(appException.getCode(),appException.getMsg());
        }
        return ResponseObj.ERROR();
    }

}

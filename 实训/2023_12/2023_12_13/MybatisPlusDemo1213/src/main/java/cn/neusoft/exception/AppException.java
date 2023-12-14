package cn.neusoft.exception;

import lombok.Data;

@Data
public class AppException extends RuntimeException{

    private Integer code = 500;
    private String msg = "服务器内部错误";

    public AppException(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public AppException(AppExceptionCodeMsg codeMsg){
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }
}

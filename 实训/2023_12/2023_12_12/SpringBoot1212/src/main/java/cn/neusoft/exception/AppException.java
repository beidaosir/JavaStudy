package cn.neusoft.exception;

import lombok.Data;

/**
 * 自定义异常类
 *   比如在service实现类中：
 *     参数校验出现问题
 *
 *     throw new AppException()
 *
 *     extends RuntimeException 继承运行时异常 无需处理比较方便
 */
@Data
public class AppException extends RuntimeException{

    private Integer code = 500;
    private String msg = "服务器内部异常";

    public AppException(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public AppException(AppExceptionCodeMsg codeMsg){
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }
}

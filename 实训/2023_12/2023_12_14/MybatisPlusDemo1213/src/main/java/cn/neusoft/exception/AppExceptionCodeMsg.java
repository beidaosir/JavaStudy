package cn.neusoft.exception;

public enum AppExceptionCodeMsg {

    INVALID_CODE(10001,"验证码无效"),
    USERNAME_NOT_EXISTS(10002,"用户名不存在"),
    REQUEST_PARAM_EMPTY(10003,"请求参数为空");

    private Integer code;
    private String msg;

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

    AppExceptionCodeMsg(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}

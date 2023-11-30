package com.hnu.vo;

public class ResponseObj {

    private Integer code;
    private String msg;
    private Object data;

    public ResponseObj(){

    }

    public ResponseObj(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseObj SUCCESS(){
        return new ResponseObj(200,"success",null);
    }

    public static ResponseObj SUCCESS(String msg){
        return new ResponseObj(200,msg,null);
    }

    public static ResponseObj SUCCESS(Object data){
        return new ResponseObj(200,"success",data);
    }

    public static ResponseObj ERROR(){
        return new ResponseObj(500,"error",null);
    }

    public static ResponseObj ERROR(Integer code, String msg){
        return new ResponseObj(code,msg,null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

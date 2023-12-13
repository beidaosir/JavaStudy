package cn.neusoft.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObj<T>{

    private Integer code;
    private String msg;
    private T data;

    public static <T> ResponseObj SUCCESS(){
        return new ResponseObj(200,"success",null);
    }

    public static <T> ResponseObj SUCCESS(String msg){
        return new ResponseObj(200,msg,null);
    }

    public static <T> ResponseObj SUCCESS(String msg,T data){
        return new ResponseObj(200,msg,data);
    }

    public static <T> ResponseObj SUCCESS(T data){
        return new ResponseObj(200,"success",data);
    }

    public static <T> ResponseObj ERROR(){
        return new ResponseObj(500,"服务器内部错误",null);
    }
    public static <T> ResponseObj ERROR(Integer code,String msg){
        return new ResponseObj(code,msg,null);
    }
    public static <T> ResponseObj ERROR(String msg){
        return new ResponseObj(500,msg,null);
    }
}

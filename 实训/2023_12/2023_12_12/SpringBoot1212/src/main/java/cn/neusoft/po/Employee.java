package cn.neusoft.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data   //生成get、set方法
@ToString
@AllArgsConstructor   //全参构造
@NoArgsConstructor   //空构造
public class Employee {

    private Integer empno;
    private String ename;
    private String job;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;

    private Double sal;

}

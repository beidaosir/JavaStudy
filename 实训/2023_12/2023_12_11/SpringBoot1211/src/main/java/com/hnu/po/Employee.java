package com.hnu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data   //生成get、set方法
@ToString
@AllArgsConstructor   //全参构造
@NoArgsConstructor   //空构造
public class Employee {

    private Integer empno;
    private String ename;
    private String job;
    private Double sal;

}
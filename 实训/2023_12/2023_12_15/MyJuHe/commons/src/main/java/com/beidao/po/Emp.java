package com.beidao.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("emp")
public class Emp {

    @TableId(type = IdType.AUTO)
    private Integer empno;
    private String ename;
}

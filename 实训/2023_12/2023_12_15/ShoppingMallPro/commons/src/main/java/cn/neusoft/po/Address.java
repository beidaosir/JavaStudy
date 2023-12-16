package cn.neusoft.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_address")
public class Address {

    @TableId(type = IdType.AUTO)
    private Integer addressId;

    private String name;

    private String phone;

    private String code;

    private String address;

    private Integer userId;

}
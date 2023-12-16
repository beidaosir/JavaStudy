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
@TableName("t_business")
public class Business{

    @TableId(type = IdType.AUTO)
    private Integer bid;
    private String businessAccount;
    private String password;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private Double startPrice;
    private Double deliveryPrice;
    private String businessPic;
    private String role;

}

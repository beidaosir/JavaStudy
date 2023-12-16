package cn.neusoft.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_order")
public class Order {

    @TableId(type = IdType.INPUT)
    private Long orderId;

    private Date createTime;

    private Long sumPrice;

    private Integer foodNumber;

    private Long deliveryPrice;

    private Integer status;

    private Integer userId;

    private Integer businessId;

    private Integer addressId;

}
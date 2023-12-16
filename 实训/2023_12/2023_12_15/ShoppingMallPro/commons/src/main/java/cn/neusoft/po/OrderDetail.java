package cn.neusoft.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_order_detail")
public class OrderDetail {

    private Integer orderId;

    private Integer foodId;

    private Integer number;

}
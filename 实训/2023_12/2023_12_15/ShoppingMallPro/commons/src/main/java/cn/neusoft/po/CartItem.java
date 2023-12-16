package cn.neusoft.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("t_cart_item")
public class CartItem {

    @TableId(type = IdType.AUTO)
    private Integer itemId;

    private Integer foodId; //关联的餐品编号

    private Integer number;

    private Integer cartId; //关联购物车编号

    @TableField(exist = false)
    private Food food;

}
package cn.neusoft.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_cart")
public class Cart {

    @TableId(type = IdType.AUTO)
    private Integer cartId;

    private Integer businessId; //关联的商品编号

    private Integer userId; //关联的用户编号

    @TableField(exist = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CartItem> cartItems; //购物车项集合


}
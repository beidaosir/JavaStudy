package cn.neusoft.query;

import lombok.Data;

/**
 * 商家模块的条件类
 * extends BaseQuery  拥有了分页的条件
 */
@Data
public class BusinessQuery extends BaseQuery{

    private String businessAccount;
    private String businessName;

}

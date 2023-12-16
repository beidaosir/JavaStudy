package cn.neusoft.query;

import lombok.Data;

@Data
public class FoodQuery extends BaseQuery{

    private Integer businessId;
    private String foodName;

}

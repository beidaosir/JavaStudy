package com.hnu.query;

public class FoodQuery extends BaseQuery{

    /*
    商家查询餐品时  需要传递这个参数
     */
    private Integer businessId;
    private String foodName;

    public FoodQuery() {

    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
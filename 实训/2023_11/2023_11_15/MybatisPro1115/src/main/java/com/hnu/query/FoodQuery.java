package com.hnu.query;

public class FoodQuery extends BaseQuery{

    private String foodName;

    public FoodQuery() {

    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
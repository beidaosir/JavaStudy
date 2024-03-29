package com.hnu.bean;

import java.io.Serializable;

public class Food implements Serializable {
    private Integer foodId;//食品编号
    private String foodName;//名称
    private String foodExplain;//介绍
    private Double foodPrice;//价格
    private Integer businessId;//商家编号

    public Food() {

    }

    public Food(Integer foodId, String foodName, String foodExplain, Double foodPrice, Integer businessId) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodExplain = foodExplain;
        this.foodPrice = foodPrice;
        this.businessId = businessId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodExplain() {
        return foodExplain;
    }

    public void setFoodExplain(String foodExplain) {
        this.foodExplain = foodExplain;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    @Override
    public String toString() {
        return "\n食品编号："+this.foodId+
               "\n食品名称："+this.foodName+
               "\n食品介绍："+this.foodExplain+
               "\n食品价格："+this.foodPrice+
               "\n所属商家："+this.businessId;
    }

}
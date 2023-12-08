package com.hnu.po;

public class Business{

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

    public Business() {
    }

    public Business(Integer bid, String businessAccount, String password, String businessName, String businessAddress, String businessExplain, Double startPrice, Double deliveryPrice, String role) {
        this.bid = bid;
        this.businessAccount = businessAccount;
        this.password = password;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessExplain = businessExplain;
        this.startPrice = startPrice;
        this.deliveryPrice = deliveryPrice;
        this.role = role;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBusinessAccount() {
        return businessAccount;
    }

    public void setBusinessAccount(String businessAccount) {
        this.businessAccount = businessAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessExplain() {
        return businessExplain;
    }

    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBusinessPic() {
        return businessPic;
    }

    public void setBusinessPic(String businessPic) {
        this.businessPic = businessPic;
    }

    @Override
    public String toString() {
        return "Business{" +
                "bid=" + bid +
                ", businessAccount='" + businessAccount + '\'' +
                ", password='" + password + '\'' +
                ", businessName='" + businessName + '\'' +
                ", businessAddress='" + businessAddress + '\'' +
                ", businessExplain='" + businessExplain + '\'' +
                ", startPrice=" + startPrice +
                ", deliveryPrice=" + deliveryPrice +
                ", role='" + role + '\'' +
                '}';
    }
}

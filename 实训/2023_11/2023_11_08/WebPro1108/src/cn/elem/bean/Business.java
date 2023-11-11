package cn.elem.bean;

/*
商家实体类
 */
public class Business {

//    FieldTypeComment
//    bid int NOT NULL主键 商家账号
//    businessAccount varchar(20) NULL商家账号
//    password varchar(20) NOT NULL商家密码
//    businessName varchar(50) NULL商家名称
//    businessAddress varchar(200) NULL商家地址
//    businessExplain varchar(200) NULL商家介绍
//    startPrice double NULL起送费
//    deliveryPrice double NULL配送费
//    role
    private Integer bid;
    private String businessAccount;
    private String password;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private Double startPrice;
    private Double deliveryPrice;
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

    /**
     * 获取
     * @return bid
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * 设置
     * @param bid
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * 获取
     * @return businessAccount
     */
    public String getBusinessAccount() {
        return businessAccount;
    }

    /**
     * 设置
     * @param businessAccount
     */
    public void setBusinessAccount(String businessAccount) {
        this.businessAccount = businessAccount;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return businessName
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * 设置
     * @param businessName
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * 获取
     * @return businessAddress
     */
    public String getBusinessAddress() {
        return businessAddress;
    }

    /**
     * 设置
     * @param businessAddress
     */
    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    /**
     * 获取
     * @return businessExplain
     */
    public String getBusinessExplain() {
        return businessExplain;
    }

    /**
     * 设置
     * @param businessExplain
     */
    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }

    /**
     * 获取
     * @return startPrice
     */
    public Double getstartPrice() {
        return startPrice;
    }

    /**
     * 设置
     * @param startPrice
     */
    public void setstartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    /**
     * 获取
     * @return deliveryPrice
     */
    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    /**
     * 设置
     * @param deliveryPrice
     */
    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    /**
     * 获取
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    public String toString() {
        return "Business{bid = " + bid + ", businessAccount = " + businessAccount + ", password = " + password + ", businessName = " + businessName + ", businessAddress = " + businessAddress + ", businessExplain = " + businessExplain + ", startPrice = " + startPrice + ", deliveryPrice = " + deliveryPrice + ", role = " + role + "}";
    }
}

package com.hnu.query;

/**
 * 商家模块的条件类
 * extends BaseQuery  拥有了分页的条件
 */
public class BusinessQuery extends BaseQuery{

    private String businessAccount;
    private String businessName;

    public BusinessQuery() {
    }

    public BusinessQuery(String businessAccount, String businessName) {
        this.businessAccount = businessAccount;
        this.businessName = businessName;
    }

    public String getBusinessAccount() {
        return businessAccount;
    }

    public void setBusinessAccount(String businessAccount) {
        this.businessAccount = businessAccount;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}

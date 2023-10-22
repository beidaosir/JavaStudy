package com.hnu.bean;

import java.io.Serializable;

/*
管理员模型
 */
public class Admin implements Serializable {
    private Integer adminId;//管理员账号
    private String adminName;//管理员名字
    private String password;//密码

    public Admin() {

    }

    public Admin(Integer adminId, String adminName, String password) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.password = password;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "管理员账号=" + adminId +
                ", 管理员名字='" + adminName + '\'' +
                ", 密码='" + password + '\'' +
                '}';
    }
}
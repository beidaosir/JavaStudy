package cn.elem.bean;

public class Admin {


//    FieldTypeComment
//    adminIdint NOT NULL主键
//    adminNamevarchar(20) NOT NULL管理员账号
//    passwordvarchar(20) NOT NULL管理员密码
//    role

    private Integer adminId;
    private String adminName;
    private String password;
    private String role;

    public Admin() {
    }

    public Admin(Integer adminId, String adminName, String password, String role) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.password = password;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

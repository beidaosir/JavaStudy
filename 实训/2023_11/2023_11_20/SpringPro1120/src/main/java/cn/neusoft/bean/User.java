package cn.neusoft.bean;

public class User {

    private String username;
    private String password;

    public User() {
        System.out.println("----User的空构造方法-----");
    }

    public User(String username, String password) {
        System.out.println("-----User的有参构造方法------------");
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername1(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

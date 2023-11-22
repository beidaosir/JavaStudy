package cn.neusoft.bean;

import java.util.Date;

public class Student {

    private Integer sid;
    private String sname;
    private Date birthday;

    public Student() {
        System.out.println("无参");
    }

    public Student(Integer sid, String sname) {
        System.out.println("两个参数");
        this.sid = sid;
        this.sname = sname;
    }

    public Student(Integer sid, String sname, Date birthday) {
        System.out.println("三个参数");
        this.sid = sid;
        this.sname = sname;
        this.birthday = birthday;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

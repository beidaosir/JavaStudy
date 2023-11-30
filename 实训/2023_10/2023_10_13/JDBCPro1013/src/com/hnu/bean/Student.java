package com.hnu.bean;

public class Student {

    private Integer id;
    private Integer sno;
    private String sname;
    private Integer classid;

    public Student() {
    }

    public Student(Integer id, Integer sno, String sname, Integer classid) {
        this.id = id;
        this.sno = sno;
        this.sname = sname;
        this.classid = classid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sno=" + sno +
                ", sname='" + sname + '\'' +
                ", classid=" + classid +
                '}';
    }
}

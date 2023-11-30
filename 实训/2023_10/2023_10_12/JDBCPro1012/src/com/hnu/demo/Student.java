package com.hnu.demo;

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

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return sno
     */
    public Integer getSno() {
        return sno;
    }

    /**
     * 设置
     * @param sno
     */
    public void setSno(Integer sno) {
        this.sno = sno;
    }

    /**
     * 获取
     * @return sname
     */
    public String getSname() {
        return sname;
    }

    /**
     * 设置
     * @param sname
     */
    public void setSname(String sname) {
        this.sname = sname;
    }

    /**
     * 获取
     * @return classid
     */
    public Integer getClassid() {
        return classid;
    }

    /**
     * 设置
     * @param classid
     */
    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String toString() {
        return "Student{id = " + id + ", sno = " + sno + ", sname = " + sname + ", classid = " + classid + "}";
    }
}

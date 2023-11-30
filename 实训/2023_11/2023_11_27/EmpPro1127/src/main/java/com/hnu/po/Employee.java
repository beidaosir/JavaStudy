package com.hnu.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Employee {
    private Integer empno;
    private String ename;
    private String job;
    private Date hiredate;
    private Double sal;

    private String pic;

    public String  getPic() {
        return pic;
    }


    public void setPic(String pic) {
        this.pic = pic;
    }


    public Employee() {
    }

    public Employee(Integer empno, String ename, String job, Date hiredate, Double sal) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        this.sal = sal;
    }

    /**
     * 获取
     * @return empno
     */
    public Integer getEmpno() {
        return empno;
    }

    /**
     * 设置
     * @param empno
     */
    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    /**
     * 获取
     * @return ename
     */
    public String getEname() {
        return ename;
    }

    /**
     * 设置
     * @param ename
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * 获取
     * @return job
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置
     * @param job
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 获取
     * @return hiredate
     */

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getHiredate() {
        return hiredate;
    }

    /**
     * 设置
     * @param hiredate
     */

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    /**
     * 获取
     * @return sal
     */
    public Double getSal() {
        return sal;
    }

    /**
     * 设置
     * @param sal
     */
    public void setSal(Double sal) {
        this.sal = sal;
    }

    public String toString() {
        return "Employee{empno = " + empno + ", ename = " + ename + ", job = " + job + ", hiredate = " + hiredate + ", sal = " + sal + "}";
    }
}

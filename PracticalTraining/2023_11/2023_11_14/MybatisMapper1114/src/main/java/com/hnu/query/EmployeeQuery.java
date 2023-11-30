package com.hnu.query;

public class EmployeeQuery {

    private String ename;
    private Integer deptno;
    private Double lowSal;
    private Double highSal;


    public EmployeeQuery() {
    }

    public EmployeeQuery(String ename, Integer deptno, Double lowSal, Double highSal) {
        this.ename = ename;
        this.deptno = deptno;
        this.lowSal = lowSal;
        this.highSal = highSal;
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
     * @return deptno
     */
    public Integer getDeptno() {
        return deptno;
    }

    /**
     * 设置
     * @param deptno
     */
    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    /**
     * 获取
     * @return lowSal
     */
    public Double getLowSal() {
        return lowSal;
    }

    /**
     * 设置
     * @param lowSal
     */
    public void setLowSal(Double lowSal) {
        this.lowSal = lowSal;
    }

    /**
     * 获取
     * @return highSal
     */
    public Double getHighSal() {
        return highSal;
    }

    /**
     * 设置
     * @param highSal
     */
    public void setHighSal(Double highSal) {
        this.highSal = highSal;
    }

    public String toString() {
        return "EmployeeQuery{ename = " + ename + ", deptno = " + deptno + ", lowSal = " + lowSal + ", highSal = " + highSal + "}";
    }
}

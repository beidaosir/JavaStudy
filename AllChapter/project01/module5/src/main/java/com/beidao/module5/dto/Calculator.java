package com.beidao.module5.dto;

import java.io.Serializable;


/*
JavaBean——存数据
 */
public class Calculator implements Serializable {
    private double p;
    private double yr;
    private int m;


    // getter和setter方法
    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getYr() {
        return yr;
    }

    public void setYr(double yr) {
        this.yr = yr;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    // 有参构造
    public Calculator(double p, double yr, int m) {
        this.p = p;
        this.yr = yr;
        this.m = m;
    }

    // 无参构造
    public Calculator() {
    }
}

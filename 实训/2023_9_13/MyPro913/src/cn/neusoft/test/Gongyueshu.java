package cn.neusoft.test;

/*
问题描述：最大公约数指两个数字公共的约数中最大的，例如数字3的约数有1、3，
数字9的约数有1、3、9，则数字3和数字9的公共约数有1和3，其中3是最大的公约数。
第一种编程思路：假设初始值从1开始逐步增1，
每次把能同时使两个数整除的值都存储起来，
那么最后一个存储起来的值就是最大的约数
 */
public class Gongyueshu {
    public static void main(String[] args) {
        int m = 8;
        int n = 12;
        int result = 1;
        for (int i = 1; i <= m; i++) {
            if ((m % i == 0) && (n % i == 0)) {
                result = i;
            }
        }
        System.out.println(result);
    }
}

package com.beidao.module5.service.impl;

/*
业务逻辑类——等额本金计算器
 */

import com.beidao.module5.dto.Calculator;
import com.beidao.module5.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;


@Service
public class CalculatorService1 implements CalculatorService {

    public CalculatorService1() {
        System.out.println("CalculatorService1()被创建了");
    }

    @Override
    public String[] cal(Calculator calculator) {

        double p = calculator.getP();
        double yr = calculator.getYr();
        int m = calculator.getM();

        double payPrincipal = p / m;//每月还款本金
        double backup = p;//备份本金
        double mr = yr / 12 / 100.0;//月利率
        double payInterestTotal = 0.0;//总利息
        for (int i = 0; i < m; i++) {

            double payInterest = p * mr;//每月利息
            p -= payPrincipal;//剩余本金
            payInterestTotal += payInterest;//总利息
        }
        return new String[]{
                NumberFormat.getCurrencyInstance().format(backup),
                NumberFormat.getCurrencyInstance().format(payInterestTotal)
        };


    }


    @Override
    public String[][] details(Calculator calculator) {

        // 等额本金的计算方法
        double payPrincipal = calculator.getP() / calculator.getM();//每月还款本金
        double mr = calculator.getYr() / 12 / 100.0;//月利率
        String[][] a2 = new String[calculator.getM()][];
        for (int i = 0; i < calculator.getM(); i++) {
            double payInterest = calculator.getP() * mr;//每月利息
            calculator.setP(calculator.getP() - payPrincipal);//剩余本金
            double payment = payPrincipal + payInterest;//每月还款
            a2[i] = new String[]{//循环次数，还款，本金，利息，剩余本金
                    String.valueOf(i + 1),
                    NumberFormat.getCurrencyInstance().format(payment),
                    NumberFormat.getCurrencyInstance().format(payPrincipal),
                    NumberFormat.getCurrencyInstance().format(payInterest),
                    NumberFormat.getCurrencyInstance().format(calculator.getP())

            };
        }



        return a2;
    }




}

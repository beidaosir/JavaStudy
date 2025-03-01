package com.beidao.module5.service.impl;

/*
业务逻辑类——等额本息计算器
 */

import com.beidao.module5.dto.Calculator;
import com.beidao.module5.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service //@Service注解，将当前类标记为业务逻辑类
public class CalculatorService0 implements CalculatorService {


    public CalculatorService0() {
        System.out.println("CalculatorService0()被创建了");
    }

    @Override
    public String[] cal(Calculator calculator) {

        double p = calculator.getP();
        double yr = calculator.getYr();
        int m = calculator.getM();

        double mr = yr / 12 / 100.0;
        double pow = Math.pow((1 + mr), m);
        double payment = p * mr * pow / (pow - 1);
        return new String[]{
                NumberFormat.getCurrencyInstance().format(payment * m),
                NumberFormat.getCurrencyInstance().format(payment * m - p)
        };

    }


    @Override
    public String[][] details(Calculator calculator) {
        String[][] a2 = new String[calculator.getM()][];
        double mr = calculator.getYr() / 12 / 100.0;
        double pow = Math.pow((1 + mr), calculator.getM());
        double payment = calculator.getP() * mr * pow / (pow - 1);//每月还款
        for (int i = 0; i < calculator.getM(); i++) {
            double payInterest = calculator.getP() * mr;//每月利息
            double payPrincipal = payment - payInterest;//每月本金
            calculator.setP(calculator.getP() - payPrincipal);//剩余本金
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

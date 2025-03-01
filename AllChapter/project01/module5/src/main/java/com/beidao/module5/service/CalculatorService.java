package com.beidao.module5.service;

import com.beidao.module5.dto.Calculator;

import java.text.NumberFormat;

/**
 * 业务逻辑接口
 */

public interface CalculatorService {

    //抽象方法
    String[] cal(Calculator calculator);

    String[][] details(Calculator calculator);

    default String[] crateRow(int i, double payment, double payPrincipal, double payInterest, double p) {
        String[] row = new String[]{//循环次数，还款，本金，利息，剩余本金
                String.valueOf(i + 1),
                NumberFormat.getCurrencyInstance().format(payment),
                NumberFormat.getCurrencyInstance().format(payPrincipal),
                NumberFormat.getCurrencyInstance().format(payInterest),
                NumberFormat.getCurrencyInstance().format(p)
        };
        return row;
    }

}

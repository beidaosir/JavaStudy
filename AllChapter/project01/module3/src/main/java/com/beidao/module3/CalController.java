package com.beidao.module3;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.NumberFormat;

@Controller
public class CalController {


    @RequestMapping("/cal")
    @ResponseBody
    String[] cal(double yr, double p,int m){

        double mr = yr / 12/ 100.0;
        double pow = Math.pow((1 + mr), m);
        double payment = p * mr * pow / (pow - 1);
  //      return NumberFormat.getCurrencyInstance().format(payment*m);

        return new String[]{
                NumberFormat.getCurrencyInstance().format(payment*m),
                NumberFormat.getCurrencyInstance().format(payment*m-p)
        };
    }


    @RequestMapping("/details")
    @ResponseBody
    String[][] details(double p,int m,double yr){

/*
        String[] row0 = new String[]{"1","￥33333","￥33333","￥688","￥1659"};
        String[] row1 = new String[]{"2","￥3333","￥33353","￥658","￥182"};
        String[] row2 = new String[]{"3","￥16735","￥38953","￥253","￥1085"};

*/

        String[][] a2 = new String[m][];
/*        a2[0] = row0;
        a2[1] = row1;
        a2[2] = row2;*/

        double mr = yr / 12/ 100.0;
        double pow = Math.pow((1 + mr), m);
        double payment = p * mr * pow / (pow - 1);
        for (int i = 0; i < m; i++){
            double interest = p * mr;
            double principal = payment - interest;
            p -= principal;
            String [] row = new String[]{
                    String.valueOf(i+1),
                    NumberFormat.getCurrencyInstance().format(payment),
                    NumberFormat.getCurrencyInstance().format(principal),
                    NumberFormat.getCurrencyInstance().format(interest),
                    NumberFormat.getCurrencyInstance().format(p)
            };

            a2[i] = row;

        }

        return a2;
    }

}

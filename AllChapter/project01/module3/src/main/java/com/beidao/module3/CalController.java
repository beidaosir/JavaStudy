package com.beidao.module3;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.NumberFormat;

@Controller
public class CalController {


    @RequestMapping("/cal")
    @ResponseBody
    String cal(double yr, double p,int m){

        double mr = yr / 12/ 100.0;
        double pow = Math.pow((1 + mr), m);
        double payment = p * mr * pow / (pow - 1);
        return NumberFormat.getCurrencyInstance().format(payment*m);

    }
}

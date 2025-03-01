package com.beidao.module5.controller;


import com.beidao.module5.dto.Calculator;
import com.beidao.module5.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class CalculatorController {



   /* private CalculatorService[] array;

    //构造函数
    public CalculatorController(){
        array = new CalculatorService[]{
                new CalculatorService0(),
                new CalculatorService1()
        };
    }
*/

    @Autowired
    CalculatorService[] array;//注入服务  = new 数组[]{service0对象,service1对象,service2对象}



    //还款总额
    @RequestMapping("/cal")
    @ResponseBody
    String[] cal(int type, Calculator calculator){

        CalculatorService calculatorService = array[type];//获取对应的服务
        return calculatorService.cal(calculator);//调用服务
    }

    //还款详情
    @RequestMapping("/details")
    @ResponseBody
    String[][] details(int type, Calculator calculator){//获取对应的服务

        CalculatorService calculatorService = array[type];//获取对应的服务
        return calculatorService.details(calculator);//调用服务

    }

}

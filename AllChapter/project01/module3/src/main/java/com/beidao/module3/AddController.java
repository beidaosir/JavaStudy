package com.beidao.module3;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddController {


    @RequestMapping("/add")
    @ResponseBody
    int add(int a, int b) {
        return a + b;
    }
}

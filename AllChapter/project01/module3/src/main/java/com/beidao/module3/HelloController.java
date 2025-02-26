package com.beidao.module3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//http://localhost:8080/hi

@Controller
public class HelloController {


    @RequestMapping("/hello")
    @ResponseBody
    String hello(String name){

        return "hello,"+ name;

    }

    @RequestMapping("/hi")
    @ResponseBody
    String hi(){

        return "hi";

    }

}

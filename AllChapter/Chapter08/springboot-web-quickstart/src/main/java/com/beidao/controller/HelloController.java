package com.beidao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//请求注解类
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){

        System.out.println("hello world");

        return "hello world";
    }
}

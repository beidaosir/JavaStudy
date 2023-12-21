package com.beidao.mall.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.beidao.mall"}) //确保所有这个包下的内容能够被扫描到
public class ManagerApplication {

    public static void main(String[] args) {

        SpringApplication.run(ManagerApplication.class,args);
    }
}

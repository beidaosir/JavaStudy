package cn.neusoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan(basePackages = {"cn.neusoft.mapper"})
public class HelloApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(HelloApplication.class,args);
    }
}

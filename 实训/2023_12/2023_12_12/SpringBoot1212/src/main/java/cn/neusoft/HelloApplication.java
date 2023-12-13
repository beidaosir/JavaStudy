package cn.neusoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 主启动类
 *
 */
@SpringBootApplication
public class HelloApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(HelloApplication.class,args);
    }
}

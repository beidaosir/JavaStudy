package cn.neusoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 移动端接口主启动类
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.neusoft.mapper")
public class AppApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(AppApplication.class,args);
    }
}

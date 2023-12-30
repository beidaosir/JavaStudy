package com.beidao.mall.common.log.annotation;

import com.beidao.mall.common.log.aspect.LogAspect;
import org.springframework.context.annotation.Import;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(value = LogAspect.class)            // 通过Import注解导入日志切面类到Spring容器中
public @interface EnableLogAspect {
    
}
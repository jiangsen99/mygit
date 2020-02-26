package com.itheima;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2020-02-17  14:20
 * aop配置中有三个重要的东西:
 * 1. 切面
 * 2. 切入点
 * 3. 通知
 */
@Component
@Aspect
public class MyAspect {
    @Pointcut("execution(* com.itheima.service.impl.AccountServiceImpl.transfer(..))")
    public void pt1(){

    }

    @Before("pt1()")
    public void security(){
        System.out.println("校验是否有权限....");
    }
}

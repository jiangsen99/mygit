package com.itheima;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public aspect AccountaAspect {
 @Pointcut("execution(* com.itheima.service.impl.AccountServiceImpl.transfer(..))")
public void pt1(){

}
 @Before("pt1()")
public void security(){
  System.out.println("校验是否有权限");
 }
}

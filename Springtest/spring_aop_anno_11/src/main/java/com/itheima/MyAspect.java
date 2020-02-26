package com.itheima;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2020-02-16  11:36
 * 1. 给类添加Aspect注解，让该类成为切面
 * 2. 在当前类里面定义切入点,使用方法定义切入点，在方法上添加PointCut注解；切入点的唯一表示就是方法的名字
 * 3. 定义通知:
 *    前置通知: Before注解
 *    后置通知: AfterReturning注解
 *    异常通知: AfterThrowing注解
 *    最终通知: After注解
 *    环绕通知: Around注解
 *
 *
 * 注解方式配置AOP的小结:
 * 1. 在配置文件中，加载AOP的注解驱动: <aop:aspectj-autoproxy />
 * 2. 使用Component注解，对切面类进行IOC配置
 * 3. 使用Aspect注解，让类成为切面
 * 4. 新创建方法，在方法上添加PointCut注解配置切入点，而方法名就是切入点的唯一标识
 * 5. 在切面里的方法上添加各种通知注解，来配置通知
 *    前置通知: Before注解
 *    后置通知: AfterReturning注解
 *    异常通知: AfterThrowing注解
 *    最终通知: After注解
 *    环绕通知: Around注解
 *
 *    设置通知的value属性，来关联切入点
 */
@Component
@Aspect
public class MyAspect {
    @Pointcut("execution(* com.itheima.service.impl.UserServiceImpl.add(..))")
    public void pt1(){

    }
    @Pointcut("execution(* com.itheima.service.impl.UserServiceImpl.delete(..))")
    public void pt2(){

    }
    @Pointcut("execution(* com.itheima.service.impl.UserServiceImpl.*(..))")
    public void pt3(){

    }
    @Pointcut("execution(* com.itheima.service.impl.UserServiceImpl.findAll(..))")
    public void pt4(){

    }

    @Before(value = "pt1()")
    public void security(){
        System.out.println("执行权限校验....");
    }

    @AfterReturning("pt2()")
    public void printLog(){
        System.out.println("执行成功...");
    }

    @AfterThrowing("pt3()")
    public void rollback(){
        System.out.println("出现异常,回滚事务...");
    }

    @After("pt2()")
    public void sayHello(){
        System.out.println("hello,执行了最终通知...");
    }

    @Around("pt4()")
    public void showTime(ProceedingJoinPoint joinPoint){
        //执行核心方法(查询所有)之前，打印当前时间
        long timeMillis1 = System.currentTimeMillis();
        System.out.println("执行查询所有之前的时间:" + timeMillis1);

        //执行核心方法(查询所有),也就是执行切入点方法
        try {
            //这就是执行切入点
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        //执行核心方法之后，打印当前时间
        long timeMillis2 = System.currentTimeMillis();
        System.out.println("执行查询所有之后的时间:" + timeMillis2);
        System.out.println("查询所有所花费的时间是:" + (timeMillis2 - timeMillis1));
    }
}
